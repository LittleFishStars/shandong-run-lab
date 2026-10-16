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
from typing import Any, Dict, List, Optional, Tuple

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
    HEADER_E,
    HEADER_PV,
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
        self.clock = clock or (lambda: int(time.time() * 1000))
        # 会话态
        self.token = ""
        self.satoken = ""
        self.school_code = ""
        self.user_id = ""
        # 统计
        self.stats = {"requests": 0, "errors": 0, "signed": 0}

    # ══════════════════ 公共报文 ══════════════════
    def base_payload(self, extra: Optional[Dict[str, Any]] = None) -> Dict[str, Any]:
        """9 个公共字段（顺序与官方客户端一致）"""
        dev = self.cfg.get("device", {}) or {}
        o: Dict[str, Any] = {
            "modelName": dev.get("model", DEFAULT_MODEL),
            "appVersion": APP_VERSION,
            "buildVersion": BUILD_VERSION,
            "channel": dev.get("channel", DEFAULT_CHANNEL),
            "appCode": dev.get("app_code", APP_CODE),
            "deviceId": self.device_id,
            "systemVersion": dev.get("system_version", DEFAULT_SYS_VER),
            "platform": dev.get("platform", DEFAULT_PLATFORM),
            "timestamp": str(self.clock()),
        }
        if extra:
            o.update(extra)
        return o

    def user_agent(self) -> str:
        dev = self.cfg.get("device", {}) or {}
        model = str(dev.get("model", DEFAULT_MODEL))
        brand = model.split("|")[0].split("-")[0].lower()
        return f"{USER_AGENT_PREFIX}/{APP_VERSION} ({brand};Android {dev.get('system_version', DEFAULT_SYS_VER)})"

    def headers(self, v: Optional[str] = None, api: Optional[str] = None,
                h5: bool = False) -> Dict[str, str]:
        h = {
            "Content-Type": "application/json; charset=utf-8",
            "User-Agent": self.user_agent(),
            "app": HEADER_APP,
            "e": HEADER_E,
            "pv": HEADER_PV,
            "Accept": "*/*",
        }
        if h5:
            h["Origin"] = H5_ORIGIN
            h["Referer"] = H5_ORIGIN + "/"
        if self.token:
            h["Authorization"] = self.token
        if self.satoken:
            h["satoken"] = self.satoken
        if v:
            h["v"] = v
        if api:
            h["api"] = api
        return h

    # ══════════════════ 核心调用 ══════════════════
    def post(self, name_or_path: str, payload: Optional[Dict[str, Any]] = None,
             ep: Optional[Endpoint] = None, need_sign: Optional[bool] = None,
             raw_url: Optional[str] = None, h5: bool = False,
             env: int = 0) -> Dict[str, Any]:
        """发送业务请求（按 EP.method 自动选 GET / POST）

        name_or_path 可以是 `EP` 里的接口名，也可以是完整路径。
        """
        if ep is None and name_or_path in _EP_NAMES:
            ep = endpoint(name_or_path)
        if ep is None:
            ep = Endpoint(name_or_path, name_or_path.split("/")[-1],
                          name_or_path.split("/")[0] if "/" in name_or_path else "")
        body = payload if payload is not None else self.base_payload()
        if ep.method == "GET":
            return self.get(name_or_path, body, v=ep.v, api=ep.api, path=ep.path)
        sign_it = ep.need_sign if need_sign is None else need_sign
        return self._do_post(ep.path, body, ep.v, ep.api, sign_it,
                             raw_url=raw_url, h5=h5, env=env)

    def post_raw(self, url: str, payload: Dict[str, Any], v: str = "",
                 api: str = "", h5: bool = True) -> Dict[str, Any]:
        return self._do_post(url, payload, v, api, False, raw_url=url, h5=h5)

    def _do_post(self, path: str, body: Dict[str, Any], v: str, api: str,
                 sign_it: bool, raw_url: Optional[str] = None, h5: bool = False,
                 env: int = 0) -> Dict[str, Any]:
        url = raw_url or f"{self.base_url}/{path.lstrip('/')}"
        text = json.dumps(body, separators=(",", ":"), ensure_ascii=False)
        headers = self.headers(v=v, api=api, h5=h5)
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
            v: str = "", api: str = "", path: str = "") -> Dict[str, Any]:
        path = path or name_or_path
        if path in _EP_NAMES:
            ep = endpoint(path)
            path, v, api = ep.path, ep.v, ep.api
        url = f"{self.base_url}/{path.lstrip('/')}"
        if params:
            url += "?" + urllib.parse.urlencode(params)
        headers = self.headers(v=v, api=api)
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
                                   json.dumps(params or {}, ensure_ascii=False),
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
        req = urllib.request.Request(url, headers={"User-Agent": f"{USER_AGENT_PREFIX}/{APP_VERSION}"})
        try:
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
        if _HAS_REQUESTS:
            proxies = {"http": self.proxy, "https": self.proxy} if self.proxy else None
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
