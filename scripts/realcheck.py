#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""真实服务端连通性自检：不需要账号也能验证的完整链路。

:: 

    python scripts/realcheck.py                          # 探测公开接口 + 真实滑块验证码
    python scripts/realcheck.py --captcha-trials 8        # 统计验证码通过率
    python scripts/realcheck.py --phone 138... --password '***'   # 追加真实密码登录

覆盖：
  1. 网络层：syncTime（GET）可达并返回业务 JSON
  2. 预检：auth/loginCheck → code 0，且回显 phone 密文与本地实现逐字节一致
  3. 服务端参数：common/getConfig → 真实阈值（runFilterAccuracy / paceInterval …）
  4. 鉴权墙：未登录调用 run/* → code 1516（证明路由存在，只是要先登录）
  5. 真实滑块验证码：captcha/get → 本地求解 → captcha/check 通过
  6. 可选：真实密码登录（提供 --phone / --password 时）

注意：验证码是**一次性**的，`captcha/check` 每调用一次就消耗掉该 token，
所以重试必须重新取挑战——本脚本的通过率统计已按此口径实现。
"""
from __future__ import annotations

import argparse
import json
import sys
import time
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
if str(ROOT) not in sys.path:
    sys.path.insert(0, str(ROOT))

from sdlab import constants as C                          # noqa: E402
from sdlab import crypto                                  # noqa: E402
from sdlab.captcha import CaptchaSolver                   # noqa: E402
from sdlab.client import ShandongClient                   # noqa: E402
from sdlab.net import Transport                           # noqa: E402

OK, FAIL, SKIP = "\033[32m✓\033[0m", "\033[31m✗\033[0m", "\033[33m•\033[0m"
_results: list[tuple[bool, str]] = []


def check(cond: bool, title: str, detail: str = "") -> bool:
    _results.append((bool(cond), title))
    line = f"  {OK if cond else FAIL} {title}"
    if detail:
        line += f"\n       {detail}"
    print(line, flush=True)
    return bool(cond)


def note(title: str, detail: str = "") -> None:
    line = f"  {SKIP} {title}"
    if detail:
        line += f"\n       {detail}"
    print(line, flush=True)


def section(title: str) -> None:
    print(f"\n\033[1m══ {title} ══\033[0m", flush=True)


def main() -> int:
    ap = argparse.ArgumentParser(description="真实服务端连通性自检")
    ap.add_argument("--phone", default="", help="真实手机号（可选，用于登录探测）")
    ap.add_argument("--password", default="", help="真实密码（可选）")
    ap.add_argument("--captcha-trials", type=int, default=5, help="验证码通过率统计次数")
    ap.add_argument("--timeout", type=float, default=25.0, help="单请求超时秒数")
    ap.add_argument("--json", dest="json_out", default="", help="把结果写成 JSON 报告")
    args = ap.parse_args()

    cfg = {"device": {}, "net": {"timeout": args.timeout, "retry": 3}, "mock": {"enabled": False}}
    tr = Transport(cfg, base_url=C.BASE_URL)

    # ────────────────────────────────────────────────────────────
    section("1. 网络层（GET 支持）")
    r = tr.post("sync_time", {})
    check(isinstance(r, dict) and "code" in r,
          "syncTime（GET）可达且返回业务 JSON",
          f"code={r.get('code')} http={r.get('_http_status')} {str(r.get('message'))[:40]}")
    check(str(r.get("code")) != "-1", "无网络错误（-1 表示连接失败）",
          f"elapsed={r.get('_elapsed_ms')}ms")

    section("2. 登录预检 auth/loginCheck")
    phone = args.phone or "13800138000"
    r = tr.post("login_check", tr.base_payload({"loginName": phone}))
    check(r.get("code") == C.CODE_OK, f"loginCheck({phone}) → code 0",
          f"code={r.get('code')} {str(r.get('message'))[:60]}")
    echoed = (r.get("data") or {}).get("phone")
    if echoed:
        check(echoed == crypto.encrypt_field(phone),
              "服务端回显 phone 密文与本地加密逐字节一致", f"server={echoed}")
    else:
            note("服务端未回显 phone（该账号未注册或字段隐藏）")

    section("2.5 e 头 / 字段加密语义（school/firstPageSchoolList 对照）")
    # loginPassword 会把 password 加密后放在 e:1 的请求里；这里用同一套字段加密
    # （schoolName 同在 ENCRYPT_FIELDS）验证服务端确实按 e 头解密：
    #   e=0 + 明文 与 e=1 + 密文 必须解出同一个检索词，返回结果逐条一致。
    url = f"{tr.base_url}/school/firstPageSchoolList"   # base_url 已含 /run-front
    kw = "山东"
    base = {"schoolName": kw, "pageNum": 1, "pageSize": 5}
    r0 = tr.post_raw(url, tr.base_payload(base), v="firstPageSchoolList", api="login",
                     h5=False, encrypt=False)
    # 注意：encrypt=True 时传输层会自己对 ENCRYPT_FIELDS 加密，这里必须传明文
    r1 = tr.post_raw(url, tr.base_payload(base), v="firstPageSchoolList", api="login",
                     h5=False, encrypt=True)
    codes = (r0.get("code"), r1.get("code"))
    check(codes == (C.CODE_OK, C.CODE_OK), "e=0 明文 / e=1 密文 两种发法都返回 code 0",
          f"codes={codes}")
    l0 = (r0.get("data") or {}).get("list") or []
    l1 = (r1.get("data") or {}).get("list") or []
    check(bool(l0) and l0 == l1, "e=0 明文与 e=1 密文的检索结果逐条一致（密文被正确解密）",
          f"{len(l0)} 条 vs {len(l1)} 条，首条 schoolCode="
          f"{(l0[0] if l0 else {}).get('schoolCode', '-')}")
    if l1:
        plain_name = crypto.decrypt_field(str(l1[0].get("schoolName") or ""))
        check(kw in plain_name, "响应 schoolName 可用 FIELD_KEY 解出明文",
              f"{l1[0].get('schoolName')} → {plain_name}")

    section("3. 服务端运行参数 common/getConfig")
    r = tr.post("common_config", tr.base_payload({}))
    cfg_data = r.get("data") or {}
    if r.get("code") == C.CODE_OK and cfg_data:
        keys = ("runFilterAccuracy", "gpsFilterAccuracy", "paceInterval", "stepInterval",
                "validDistance", "poiInterval")
        got = {k: cfg_data.get(k) for k in keys if k in cfg_data}
        check(bool(got), "common/getConfig 返回运行参数", json.dumps(got, ensure_ascii=False))
        check(cfg_data.get("captchaEnable") is True,
              "服务端 captchaEnable=true（登录必须过滑块）",
              f"captchaEnable={cfg_data.get('captchaEnable')}")
    else:
        check(False, "common/getConfig 返回运行参数",
              f"code={r.get('code')} {str(r.get('message'))[:60]}")

    section("4. 鉴权墙（未登录调用 run/*）")
    r = tr.post("sunrun_config", tr.base_payload({"targetDistance": "2000"}))
    check(r.get("code") == 1516, "未登录调用 run/checkSunRunConfig → 1516 请登录后操作",
          f"code={r.get('code')} {str(r.get('message'))[:40]}")

    section("5. 真实滑块验证码（captcha/get → 求解 → captcha/check）")
    solver = CaptchaSolver(tr)
    n = max(1, args.captcha_trials)
    passed, tries = 0, []
    for i in range(n):
        ok, _point, data = solver.run(attempts=4)
        if ok:
            passed += 1
            tries.append(int(data.get("_attempts", 1)))
        print(f"       #{i + 1} {'通过' if ok else '失败'}"
              f" 缺口x={data.get('_notch_x')} 尝试={data.get('_attempts', '-')}", flush=True)
        time.sleep(0.3)
    check(passed > 0, f"真实滑块可被本地求解器通过（{passed}/{n}）",
          f"平均尝试 {sum(tries) / len(tries):.1f} 次" if tries else "")
    check(passed == n, "全部一次挑战内通过（求解精度）" if passed == n else
          f"通过率 {passed}/{n}（偶发误匹配会自动重取挑战）")

    if args.phone and args.password:
        section("6. 真实密码登录")
        cli = ShandongClient({**cfg, "phone": args.phone, "password": args.password})
        res = cli.login(args.phone, args.password)
        check(res.get("code") in (C.CODE_OK, 0), "loginPassword 调用完成",
              f"code={res.get('code')} {str(res.get('message'))[:80]}")
        if cli.logged_in:
            check(True, "登录成功，已保存会话 token")
            r = cli.load_common_config()
            check(bool(cli.common), "登录后能拉取服务端配置")
            r = cli.load_fences()
            check(bool(cli.fences), f"登录后能拉取围栏（{len(cli.fences)} 个）")
        else:
            note("登录未成功（若为密码错误属预期；链路本身已打通）",
                 f"local_mode={cli.local_mode}")
    else:
        section("6. 真实密码登录（未提供凭据，跳过）")
        note("加 --phone 与 --password 可跑完整登录 → 围栏 → 规则链路")

    # ── 汇总 ──
    good = sum(1 for ok, _ in _results if ok)
    total = len(_results)
    print(f"\n\033[1m══ 汇总 ══\033[0m\n  {good}/{total} 项通过", flush=True)
    if args.json_out:
        Path(args.json_out).write_text(json.dumps(
            {"passed": good, "total": total,
             "items": [{"ok": ok, "title": t} for ok, t in _results]},
            ensure_ascii=False, indent=2), encoding="utf-8")
        print(f"  报告已写入 {args.json_out}", flush=True)
    return 0 if good == total else 1


if __name__ == "__main__":
    sys.exit(main())
