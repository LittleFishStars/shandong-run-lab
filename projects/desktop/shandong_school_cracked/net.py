#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""网络传输层：请求头注入 + 签名 + 接口调用 + 全量日志

对齐客户端五层拦截器链的最终形态（报告 07 §3）：

    oq5（基础 header）→ o89（token 校验）→ EncryptInterceptor（字段级 AES）
    → ix5（签名 + 9 指纹注入，持有 hq1）→ lx7（sign→sd 改名，OSS 例外）

本层等价于「基础 header + 签名」两层。字段级加密由调用方在构造 body 时完成
（`crypto.encrypt_field`），因为只有少数业务字段需要加密。

★ 签名适用范围（服务端实测，报告 15）：
    auth/* 与 captcha/* 不校验 sign；**只有 run/uploadRunRecord 校验**。
"""
from __future__ import annotations

import json
import time
import urllib.error
import urllib.parse
import urllib.request
from typing import Any, Dict, Optional, Tuple

from . import crypto
from .constants import (
    APP_CODE,
    APP_VERSION,
    BASE_URL,
    BUILD_VERSION,
    DEFAULT_CHANNEL,
    DEFAULT_MODEL,
    DEFAULT_PLATFORM,
    DEFAULT_SYS_VER,
    H5_ORIGIN,
    HEADER_APP,
    HEADER_E_ENC,
    HEADER_PV,
    DEFAULT_TLS_IMPERSONATE,
    USER_AGENT_PREFIX,
    EP,
    Endpoint,
    endpoint,
)
from .simulator import build_device_fingerprint, random_device_id

try:  # 优先 requests（自动处理 gzip / 连接复用）
    import requests  # type: ignore

    _HAS_REQUESTS = True
except Exception:  # pragma: no cover
    _HAS_REQUESTS = False

try:  # TLS 指纹伪装（curl_cffi；chrome110 预设经 muccc526 项目实测可过服务端）
    from curl_cffi import requests as _cffi_requests  # type: ignore

    _HAS_CURL_CFFI = True
except Exception:  # pragma: no cover
    _cffi_requests = None
    _HAS_CURL_CFFI = False

class TransportError(Exception):
    pass


class Transport:
    """HTTP 传输层

    与客户端的差异：这里把每个请求的完整报文与响应都记录下来（内存 + SQLite），
    供 GUI 的「网络」面板直接展示，这也是本项目相对纯 CLI 工具的主要增益。
    """

    def __init__(self, config: Dict[str, Any], bus=None, store=None,
                 base_url: Optional[str] = None, clock: Any = None):
        self.cfg = config or {}
        self.bus = bus
        self.store = store
        dev = self.cfg.get("device", {}) or {}
        fp = build_device_fingerprint(dev)
        self.device_id = self.cfg.get("device_id") or fp["deviceId"] or random_device_id()
        self.finger = fp["finger"]
        self.base_url = (base_url or self.cfg.get("base_url") or BASE_URL).rstrip("/")
        self.timeout = float(self.cfg.get("timeout", 20))
        self.retry = int(self.cfg.get("retry", 2))
        self.proxy = (self.cfg.get("proxy") or "").strip()
        # TLS 指纹伪装：空串 = 关闭（原生 urllib/requests 指纹）。
        # 默认 chrome110——服务端目前不校验 JA3（2026-10 实测原生指纹可过），
        # 但伪装成本为零，防患于未然；curl_cffi 缺席时自动降级并留告警。
        imp = str(self.cfg.get("tls_impersonate", DEFAULT_TLS_IMPERSONATE) or "").strip()
        self.tls_impersonate = imp if (_HAS_CURL_CFFI or not imp) else ""
        self._cffi_session = (_cffi_requests.Session()
                              if (self.tls_impersonate and _HAS_CURL_CFFI) else None)
        if imp and not self.tls_impersonate and self.bus:
            self.bus.emit("log", "⚠ curl_cffi 未安装，TLS 指纹伪装未生效"
                                 "（pip install curl_cffi）", level="warn")
        # clock：毫秒时钟。原版 SignInterceptor 发 timestamp 时用的是
        # (System.currentTimeMillis() + hq1.f3188a)，而 hq1.f3188a 由
        # r24.java:95 `hq1VarA.c(r90.D(), ...)` 注入 = SyncTimeIntentService
        # 拉 common/syncTime 得到的 data.reduceTimes。这里用 time_offset_ms
        # 存同一个偏移量，clock() 自动加上——公共字段与结算 timestamp 同源。
        self.time_offset_ms = 0
        self.clock = clock or self._now
        # 会话态
        self.token = ""
        self.satoken = ""
        self.school_code = ""
        self.user_id = ""
        # 统计
        self.stats = {"requests": 0, "errors": 0, "signed": 0}

    # ══════════════════ 时间校准 ══════════════════
    def _now(self) -> int:
        """本地毫秒时钟 + 服务端校准偏移（原版 System.currentTimeMillis() + r90.D()）"""
        return int(time.time() * 1000) + int(self.time_offset_ms)

    def sync_time(self) -> Dict[str, Any]:
        """拉 common/syncTime 校准时钟（原版 SyncTimeIntentService）

        原版 `SyncTimeIntentService.b.onCCSuccess()`：
            long reduceTimes = data.getLongValue("reduceTimes");
            if (reduceTimes > 1000) r90.i0(reduceTimes); else r90.i0(0L);
        即「服务端与本地的时间差」，超过 1 秒才采纳，否则归零。
        这个值随后被 r24.java 注入 hq1.f3188a，成为所有请求
        `timestamp` 与结算 `runImgRecord` 时间参的来源。
        """
        res = self.post("sync_time")
        data = res.get("data") or {}
        off = 0
        try:
            red = int(data.get("reduceTimes") or 0)
        except (TypeError, ValueError):
            red = 0
        if red > 1000:
            off = red
        # 服务端只给 reduceTimes 时用它；万一没给则退而用它和 serverTime 的差
        if not off and data.get("serverTime"):
            try:
                off = int(data["serverTime"]) - int(time.time() * 1000)
            except (TypeError, ValueError):
                off = 0
            if abs(off) <= 1000:
                off = 0
        self.time_offset_ms = off
        if self.bus:
            self.bus.emit("log", f"时间校准：服务端与本地相差 {off} ms（原版 r90.D()）")
        return {"code": res.get("code", -1), "message": res.get("message", ""),
                "offset_ms": off, "data": data}
    # ══════════════════ 公共报文 ══════════════════
    def public_fields(self) -> Dict[str, str]:
        """SignInterceptor.m() 注入的 9 个指纹字段，值一律为字符串

        顺序与原版一致：modelName/appVersion/buildVersion/channel/appCode/
        deviceId/systemVersion/platform/timestamp。原版 get/JSON body 两种
        请求都会注入它（GET 进 query，POST 进 body）。
        """
        dev = self.cfg.get("device", {}) or {}
        return {
            "modelName": str(dev.get("model", DEFAULT_MODEL)),
            "appVersion": APP_VERSION,
            "buildVersion": BUILD_VERSION,
            "channel": str(dev.get("channel", DEFAULT_CHANNEL)),
            "appCode": str(dev.get("app_code", APP_CODE)),
            "deviceId": self.device_id,
            "systemVersion": str(dev.get("system_version", DEFAULT_SYS_VER)),
            "platform": str(dev.get("platform", DEFAULT_PLATFORM)),
            "timestamp": str(self.clock()),
        }

    def base_payload(self, extra: Optional[Dict[str, Any]] = None) -> Dict[str, Any]:
        """9 个公共字段（兼容旧调用：值已字符串化，与 Java String.valueOf 一致）"""
        o: Dict[str, Any] = dict(self.public_fields())
        if extra:
            o.update(extra)
        return o

    def user_agent(self) -> str:
        """原版 r24.c()："ShanDong/%s (%s;Android %s)"，%s 依次是 versionName、
        **Build.BRAND**、Build.VERSION.RELEASE"""
        dev = self.cfg.get("device", {}) or {}
        model = str(dev.get("model", DEFAULT_MODEL))
        brand = str(dev.get("brand") or "").strip()
        if not brand:
            brand = model.split("|")[0].split("-")[0].lower()
        return (f"{USER_AGENT_PREFIX}/{APP_VERSION} "
                f"({brand};Android {dev.get('system_version', DEFAULT_SYS_VER)})")

    def headers(self, v: Optional[str] = None, api: Optional[str] = None,
                h5: bool = False, encrypt: bool = False,
                method: str = "POST", form: bool = True) -> Dict[str, str]:
        """复刻拦截器实际注入的头

        · POST：Content-Type=application/json（原版 MediaType.parse 不带 charset）、
          User-Agent 覆盖为 ShanDong/<ver>、有 token/satoken 才加对应头；
        · @FormUrlEncoded 请求另加 app/pv/k 与 api/v/e，e 默认空串、@Headers({"e:1"}) 为 "1"；
        · GET：原版只有 9 个 query 指纹，没有任何自定义头。
        """
        if method.upper() == "GET":
            h: Dict[str, str] = {}
        else:
            h = {"Content-Type": "application/json", "User-Agent": self.user_agent()}
            if form:
                h["app"] = HEADER_APP
                h["pv"] = HEADER_PV
                h["k"] = ""
                # 原版 HeaderInfo.getE() 默认返回空串，仅 @Headers({"e:1"}) 才是 "1"
                h["e"] = HEADER_E_ENC if encrypt else ""
                if api:
                    h["api"] = api
                if v:
                    h["v"] = v
            if self.token:
                h["Authorization"] = self.token
            if self.satoken:
                h["satoken"] = self.satoken
        if h5:
            h["Origin"] = H5_ORIGIN
            h["Referer"] = H5_ORIGIN + "/"
        return h

    # ══════════════════ 核心调用 ══════════════════
    def post(self, name_or_path: str, payload: Optional[Dict[str, Any]] = None,
             ep: Optional[Endpoint] = None, need_sign: Optional[bool] = None,
             raw_url: Optional[str] = None, h5: bool = False,
             env: int = 0) -> Dict[str, Any]:
        """发送业务请求（按 EP.method 自动选 GET / POST）

        name_or_path 可以是 `EP` 里的接口名，也可以是完整路径。
        9 指纹与 sign 都由本层统一注入（与原版 SignInterceptor 一致），
        payload 只需放业务字段。
        """
        if ep is None and name_or_path in _EP_NAMES:
            ep = endpoint(name_or_path)
        if ep is None:
            ep = Endpoint(name_or_path, name_or_path.split("/")[-1],
                          name_or_path.split("/")[0] if "/" in name_or_path else "")
        body = payload if payload is not None else {}
        if ep.method == "GET":
            return self.get(name_or_path, body, v=ep.v, api=ep.api, path=ep.path)
        # 原版 ParamsInterceptor.c()：POST 一律签名（无论 FormBody 还是 JSON body）
        sign_it = True if need_sign is None else bool(need_sign)
        return self._do_post(ep.path, body, ep.v, ep.api, sign_it,
                             raw_url=raw_url, h5=h5, env=env,
                             encrypt=ep.encrypt, form=ep.form)
    def post_raw(self, url: str, payload: Dict[str, Any], v: str = "",
                 api: str = "", h5: bool = True, encrypt: bool = False,
                 form: bool = True, sign_it: bool = False) -> Dict[str, Any]:
        """直连完整 URL（不走 EP 表）

        captcha 走的是 H5 层请求，不在 Retrofit 拦截器链里，因此默认不签名。
        """
        return self._do_post(url, payload, v, api, sign_it, raw_url=url,
                             h5=h5, encrypt=encrypt, form=form)

    def _do_post(self, path: str, body: Dict[str, Any], v: str, api: str,
                 sign_it: bool, raw_url: Optional[str] = None, h5: bool = False,
                 env: int = 0, encrypt: bool = False, form: bool = True) -> Dict[str, Any]:
        # ① 原版 EncryptInterceptor 只处理 @FormUrlEncoded：它先把表单值收集成
        #    Map<String,String>，所以线缆上是"全字符串值"的 JSON 体。
        if form:
            body = {k: _java_str(x) for k, x in body.items()}
        # ② e:1 接口在转 JSON 之后加密 ENCRYPT_FIELDS（原版同位置）
        if encrypt:
            body = crypto.encrypt_body_fields(body)
        # ③ SignInterceptor.m()：补齐 9 指纹（已存在的不覆盖），追加在末尾
        for k, x in self.public_fields().items():
            body.setdefault(k, x)
        url = raw_url or f"{self.base_url}/{path.lstrip('/')}"
        text = json.dumps(body, separators=(",", ":"), ensure_ascii=False)
        headers = self.headers(v=v, api=api, h5=h5, encrypt=encrypt,
                               method="POST", form=form)
        sign_value = ""
        if sign_it:
            sign_value = crypto.get_sign(text, env=env)
            headers["sign"] = sign_value
            self.stats["signed"] += 1

        self.stats["requests"] += 1
        if self.bus:
            self.bus.emit("request", f"→ POST {path}  [{len(text.encode('utf-8'))} B]"
                          + ("  +sign" if sign_it else ""),
                          path=path, v=v, api=api, sign=sign_value, body=body, url=url)

        t0 = time.time()
        last_err = ""
        for attempt in range(max(1, self.retry + 1)):
            try:
                status, resp_text = self._send(url, headers, text.encode("utf-8"))
                elapsed = int((time.time() - t0) * 1000)
                data = _parse_json(resp_text)
                code = int(data.get("code", -1)) if isinstance(data, dict) else -1
                data.setdefault("_http_status", status) if isinstance(data, dict) else None
                data["_elapsed_ms"] = elapsed if isinstance(data, dict) else 0
                if self.bus:
                    self.bus.emit("response", f"← [{status}] {_brief(resp_text)}",
                                  path=path, code=code, status=status,
                                  elapsedMs=elapsed, body=data, raw=resp_text[:4000])
                if self.store:
                    self.store.log_api("POST", path, v, api, sign_it, text,
                                       resp_text, code, elapsed)
                return data
            except Exception as e:  # 网络层异常 → 重试
                last_err = f"{type(e).__name__}: {e}"
                if attempt < self.retry:
                    time.sleep(min(2.0, 0.4 * (attempt + 1)))
                    continue

        self.stats["errors"] += 1
        if self.bus:
            self.bus.emit("log", f"✗ {path} 请求失败：{last_err}", level="error")
        if self.store:
            self.store.log_api("POST", path, v, api, sign_it, text, last_err, -1,
                               int((time.time() - t0) * 1000))
        return {"code": -1, "message": last_err or "网络请求失败", "data": None}

    def get(self, name_or_path: str, params: Optional[Dict[str, Any]] = None,
            v: str = "", api: str = "", path: str = "", h5: bool = False) -> Dict[str, Any]:
        path = path or name_or_path
        if path in _EP_NAMES:
            ep = endpoint(path)
            path, v, api = ep.path, ep.v, ep.api
        url = f"{self.base_url}/{path.lstrip('/')}"
        # 原版 ParamsInterceptor.d()：GET 只把 9 指纹拼进 query，不带任何头也不签名
        q = {k: _java_str(x) for k, x in (params or {}).items()}
        for k, x in self.public_fields().items():
            q.setdefault(k, x)
        url += "?" + urllib.parse.urlencode(q)
        headers = self.headers(method="GET", h5=h5)
        t0 = time.monotonic()
        try:
            status, text = self._send(url, headers, None)
            elapsed = int((time.monotonic() - t0) * 1000)
            data = _parse_json(text)
            if not isinstance(data, dict):
                data = {"code": -1, "message": "响应不是 JSON", "data": None}
            data.setdefault("_http_status", status)
            data["_elapsed_ms"] = elapsed
            if self.bus:
                self.bus.emit("response", f"← [{status}] {_brief(text)}", path=path,
                              code=int(data.get("code", -1)), status=status)
            if self.store:
                self.store.log_api("GET", path, v, api, False,
                                   json.dumps(q, ensure_ascii=False),
                                   text, int(data.get("code", -1)), elapsed)
            return data
        except Exception as e:
            return {"code": -1, "message": f"{type(e).__name__}: {e}", "data": None}

    def download(self, url: str) -> Optional[bytes]:
        """下载二进制（验证码图片）"""
        if url.startswith("//"):
            url = "https:" + url
        elif url.startswith("http://"):
            url = "https://" + url[7:]
        hdrs = {"User-Agent": f"{USER_AGENT_PREFIX}/{APP_VERSION}"}
        try:
            if self._cffi_session is not None:
                r = self._cffi_session.get(url, headers=hdrs, timeout=self.timeout,
                                           impersonate=self.tls_impersonate)
                data = r.content
            else:
                req = urllib.request.Request(url, headers=hdrs)
                with _open(req, self.timeout, self.proxy) as r:
                    data = r.read()
            if self.bus:
                self.bus.emit("log", f"↓ 资源 {len(data)} B  {url[:72]}")
            return data
        except Exception as e:
            if self.bus:
                self.bus.emit("log", f"✗ 资源下载失败 {url[:72]}：{e}", level="error")
            return None

    # ══════════════════ 底层 ══════════════════
    def _send(self, url: str, headers: Dict[str, str], body: Optional[bytes]
              ) -> Tuple[int, str]:
        proxies = {"http": self.proxy, "https": self.proxy} if self.proxy else None
        # TLS 指纹伪装优先（curl_cffi）；验证码图片下载等二进制资源同走
        # _cffi_get/_cffi_post，保证对外 HTTP 指纹全链路一致
        if self._cffi_session is not None:
            if body is not None:
                r = self._cffi_session.post(url, data=body, headers=headers,
                                            timeout=self.timeout, proxies=proxies,
                                            impersonate=self.tls_impersonate)
            else:
                r = self._cffi_session.get(url, headers=headers, timeout=self.timeout,
                                           proxies=proxies,
                                           impersonate=self.tls_impersonate)
            return r.status_code, r.text
        if _HAS_REQUESTS:
            r = requests.post(url, data=body, headers=headers,
                              timeout=self.timeout, proxies=proxies) if body is not None else \
                requests.get(url, headers=headers, timeout=self.timeout, proxies=proxies)
            return r.status_code, r.text
        req = urllib.request.Request(url, data=body, headers=headers,
                                     method="POST" if body is not None else "GET")
        try:
            with _open(req, self.timeout, self.proxy) as r:
                return r.status, r.read().decode("utf-8", errors="replace")
        except urllib.error.HTTPError as e:
            return e.code, e.read().decode("utf-8", errors="replace")

    def reset_session(self) -> None:
        self.token = ""
        self.satoken = ""
        self.school_code = ""
        self.user_id = ""


def _java_str(value: Any) -> str:
    """等价于 Java String.valueOf：布尔小写、整数值浮点去掉 .0、其余 str()

    原版 EncryptInterceptor 把 @FormUrlEncoded 的字段收集成 Map<String,String>，
    所以线缆上 2000、true、14 这类值都是字符串，而不是 JSON 数字/布尔。
    """
    if isinstance(value, bool):
        return "true" if value else "false"
    if isinstance(value, float):
        return str(int(value)) if value.is_integer() else repr(value)
    return str(value)


def _open(req, timeout: float, proxy: str = ""):
    if proxy:
        handler = urllib.request.ProxyHandler({"http": proxy, "https": proxy})
        opener = urllib.request.build_opener(handler)
        return opener.open(req, timeout=timeout)
    return urllib.request.urlopen(req, timeout=timeout)


def _parse_json(text: str) -> Dict[str, Any]:
    if not text:
        return {"code": -1, "message": "空响应", "data": None}
    try:
        data = json.loads(text)
        return data if isinstance(data, dict) else {"code": 0, "data": data}
    except Exception:
        return {"code": -1, "message": "非 JSON 响应", "data": None, "raw": text[:2000]}


def _brief(text: str, limit: int = 400) -> str:
    t = (text or "").replace("\n", " ").strip()
    return t[:limit] + ("…" if len(t) > limit else "")


# 从 EP 直接派生，避免手写名单与实际接口漂移
_EP_NAMES = set(EP)
