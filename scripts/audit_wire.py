#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""线缆报文审计：核对 shandong-school_cracked 发出的请求是否与原版拦截器链一致

原版规则（jadx 逐行核实，见 report/18）：

  · POST：ParamsInterceptor 一律签名。@FormUrlEncoded 请求被
    EncryptInterceptor 改写成「全字符串值」的 JSON 体，并补
    app/api/v/e/pv/k 头（e 默认空串，@Headers({"e:1"}) 才是 "1"）；
    @Body 请求原样发 JSON，只补 9 指纹 + sign，不带这些头。
  · GET：只把 9 指纹拼进 query，不带任何自定义头、不签名。
  · Content-Type：application/json（无 charset）。

用法::

    python scripts/audit_wire.py          # 跑一遍 mock 全链路并审计
    python scripts/audit_wire.py -v       # 打印每条请求摘要
"""
from __future__ import annotations

import argparse
import json
import sys
import tempfile
import time
from pathlib import Path
from typing import Any, Dict, List

ROOT = Path(__file__).resolve().parent.parent
if str(ROOT) not in sys.path:
    sys.path.insert(0, str(ROOT))

from shandong_school_cracked import App                       # noqa: E402
from shandong_school_cracked.constants import EP, Endpoint     # noqa: E402
from shandong_school_cracked.net import Transport             # noqa: E402

# 拦截器在 @FormUrlEncoded 请求上补的头
FORM_HEADERS = {"app", "pv", "k", "e", "api", "v"}
PUBLIC_FIELDS = {
    "modelName", "appVersion", "buildVersion", "channel", "appCode",
    "deviceId", "systemVersion", "platform", "timestamp",
}

_records: List[Dict[str, Any]] = []


def _spy_send(self, url, headers, body):
    """"包住 Transport._send：记录线缆上的 URL / 头 / body，再真正发送。"""
    _records.append({
        "url": url,
        "headers": dict(headers),
        "body": body.decode("utf-8") if body else "",
    })
    return _orig_send(self, url, headers, body)


_orig_send = Transport._send
Transport._send = _spy_send


def _ep_of(url: str) -> Endpoint | None:
    path = url.split("?")[0]
    # base_url 之后的部分
    for marker in ("/run-front/",):
        if marker in path:
            path = path.split(marker, 1)[1]
            break
    for ep in EP.values():
        if ep.path == path:
            return ep
    return None


def audit(verbose: bool = False) -> int:
    failures: List[str] = []
    forms = jsons = gets = h5 = 0
    for r in _records:
        url, headers, body = r["url"], r["headers"], r["body"]
        ep = _ep_of(url)
        if ep is None:                       # captcha 等直连请求
            h5 += 1
            continue
        methods = "GET" if "?" in url and not body else "POST"
        if methods == "POST" and ep.method == "GET":
            methods = "GET"

        if methods == "GET":
            gets += 1
            query = dict(p.split("=", 1) for p in url.split("?", 1)[1].split("&") if "=" in p)
            missing = PUBLIC_FIELDS - set(query)
            if missing:
                failures.append(f"GET {ep.path} query 缺 9 指纹：{sorted(missing)}")
            extra = set(headers) - {"Origin", "Referer"}
            if extra:
                failures.append(f"GET {ep.path} 带了不该有的头：{sorted(extra)}")
            if "sign" in headers:
                failures.append(f"GET {ep.path} 不该签名")
            if verbose:
                print(f"  GET  {ep.path:42s} 头={sorted(headers)}")
            continue

        # ── POST ──────────────────────────────────────────────
        if "sign" not in headers:
            failures.append(f"POST {ep.path} 缺 sign 头（原版所有 POST 都签）")
        if headers.get("Content-Type") != "application/json":
            failures.append(f"POST {ep.path} Content-Type={headers.get('Content-Type')!r}，"
                            "原版是 application/json（无 charset）")
        payload = json.loads(body) if body else {}
        if not isinstance(payload, dict):
            failures.append(f"POST {ep.path} body 不是 JSON 对象")
            continue

        if ep.form:
            forms += 1
            for key in ("app", "pv", "k", "e", "api", "v"):
                if key not in headers:
                    failures.append(f"POST(form) {ep.path} 缺头 {key!r}")
            if headers.get("app") != "run-front":
                failures.append(f"POST(form) {ep.path} app={headers.get('app')!r}")
            want_e = "1" if ep.encrypt else ""
            if headers.get("e") != want_e:
                failures.append(f"POST(form) {ep.path} e={headers.get('e')!r}，期望 {want_e!r}")
            non_str = [k for k, v in payload.items() if not isinstance(v, str)]
            if non_str:
                failures.append(f"POST(form) {ep.path} 存在非字符串值：{non_str}")
        else:
            jsons += 1
            bad = FORM_HEADERS & set(headers)
            if bad:
                failures.append(f"POST(json) {ep.path} 带了 FormBody 才有的头：{sorted(bad)}")
        missing = PUBLIC_FIELDS - set(payload)
        if missing:
            failures.append(f"POST {ep.path} body 缺 9 指纹：{sorted(missing)}")
        if verbose:
            print(f"  POST {ep.path:42s} form={int(ep.form)} "
                  f"头={sorted(set(headers))} body={body[:90]}…")

    print(f"\n共捕获 {len(_records)} 条请求：GET {gets} / form-POST {forms} / "
          f"json-POST {jsons} / 直连 {h5}")
    if failures:
        print(f"\n\033[31m✗ {len(failures)} 处不一致\033[0m")
        for f in failures:
            print("  -", f)
        return 1
    print("\033[32m✓ 所有报文与拦截器链规则一致\033[0m")
    return 0


def main() -> int:
    ap = argparse.ArgumentParser()
    ap.add_argument("-v", "--verbose", action="store_true")
    args = ap.parse_args()
    tmp = Path(tempfile.mkdtemp(prefix="shandong-school_cracked-wire-"))
    app = App(data_dir=tmp, config_path=tmp / "config.json", mode="mock")
    try:
        app.login("13800138000", "any-password", False)
        app.run_prepare()
        app.run_auto(target_m=2000, fence_index=0, seed=7)
        deadline = time.time() + 90
        while app.running() and time.time() < deadline:
            time.sleep(0.3)
        time.sleep(1.0)
    finally:
        app.close()
    return audit(args.verbose)


if __name__ == "__main__":
    sys.exit(main())
