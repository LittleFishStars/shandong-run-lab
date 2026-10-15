#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""命令行入口：不打开图形界面也能走完「登录 → 阳光跑 → 记录 → 上传」

桌面窗口只是这一层的壳，所有能力在这里都能单独调用：

    python -m sdlab                       # 与 gui 等价：开桌面窗口
    python -m sdlab gui --browser         # 无 GUI 后端时降级到浏览器
    python -m sdlab info                  # 看环境、路径、密码学后端
    python -m sdlab login -p 13800138000  # 登录（默认打本地 Mock 服务端）
    python -m sdlab run -d 2000           # 跑 2 公里：轨迹→上传→结算
    python -m sdlab records list          # 本地记录列表
    python -m sdlab records show <记录号>  # 单条记录明细
    python -m sdlab records export <记录号> --format gpx
    python -m sdlab records resume <记录号>  # 断点续传未上传成功的部分
    python -m sdlab mock --port 8899      # 只起 Mock 服务端，给别的工具联调
    python -m sdlab check                 # 离线自检 + 前端链路自检

默认 **不碰真实服务端**：除非显式给出 --real，否则一切请求都打到内置
Mock 服务端（127.0.0.1 随机端口）。
"""
from __future__ import annotations

import argparse
import json
import sys
import time
from pathlib import Path
from typing import Any, Dict, List, Optional

from . import __version__
from .constants import APP_VERSION

# ── 终端着色（管道里自动退化为无色） ──────────────────────────────
_TTY = sys.stdout.isatty()


def _c(text: str, code: str) -> str:
    return f"\033[{code}m{text}\033[0m" if _TTY else text


def ok(text: str) -> str:
    return _c("✓", "32") + " " + text


def bad(text: str) -> str:
    return _c("✗", "31") + " " + text


def dim(text: str) -> str:
    return _c(text, "90")


# ── 应用装配 ──────────────────────────────────────────────────────
def build_app(args: argparse.Namespace):
    """按命令行参数装配 App（数据目录 / 模式 / 代理都在这里落地）"""
    from .app import App

    data_dir = Path(args.data_dir).expanduser() if getattr(args, "data_dir", None) else None
    cfg_path = Path(args.config).expanduser() if getattr(args, "config", None) else None
    app = App(data_dir=data_dir, config_path=cfg_path)

    mode = getattr(args, "mode", None)
    if mode:
        app.switch_mode(mode)
    if getattr(args, "proxy", None):
        app.patch_config({"transport": "proxy", "proxy": args.proxy})
    return app


def pump(app, quiet: bool = False, timeout: float = 900.0) -> List[Dict[str, Any]]:
    """跟随后台任务打印事件流，直到任务结束（供 run/resume 用）"""
    seq, t0, seen = 0, time.time(), []
    while time.time() - t0 < timeout:
        p = app.poll(seq, limit=200)
        for ev in p.get("events") or []:
            seen.append(ev)
            seq = max(seq, int(ev.get("seq") or 0))
            if not quiet:
                print(f"  {dim(str(ev.get('time', '')))} {_kind(ev)} {ev.get('message', '')}")
        if p.get("running"):
            time.sleep(0.3)
            continue
        # 任务已结束：再收一次尾部事件
        for ev in (app.poll(seq, limit=200).get("events") or []):
            seen.append(ev)
            if not quiet:
                print(f"  {dim(str(ev.get('time', '')))} {_kind(ev)} {ev.get('message', '')}")
        break
    return seen


def _kind(ev: Dict[str, Any]) -> str:
    color = {
        "progress": "36", "run_started": "36", "run_finished": "32",
        "auto_done": "32", "state": "90", "log": "90",
        "request": "34", "response": "34", "mock": "35", "simulated": "35",
        "prepared": "35",
    }.get(str(ev.get("kind")), "0")
    return _c(f"[{ev.get('kind')}]".ljust(14), color)


# ══════════════════ 各子命令 ══════════════════
def cmd_gui(args: argparse.Namespace) -> int:
    from .gui import run_browser, run_desktop

    app = build_app(args)
    if args.browser:
        return run_browser(app)
    return run_desktop(app, debug=args.debug)


def cmd_info(args: argparse.Namespace) -> int:
    from . import ciphers
    from . import constants as C
    from .simulator import FuckRunSim, random_device_id

    app = build_app(args)
    backend, backend_desc = ciphers.backend_info()
    st = app.status()
    sim = FuckRunSim(seed=1)
    sim.start(0, 0)
    rows = [
        ("工作台版本", f"v{__version__}"),
        ("复刻的 App 版本", f"{APP_VERSION} / build {C.BUILD_VERSION}"),
        ("数据目录", st["data_dir"]),
        ("配置文件", st["config_path"]),
        ("运行模式", "本地 Mock（不联网）" if st["mode"] == "mock" else "真实服务端"),
        ("Mock 地址", st.get("mock_url") or "未启动"),
        ("密码学后端", f"{backend} —— {backend_desc}"),
        ("deviceId", st.get("device_id", "")),
        ("随机 deviceId 示例", random_device_id(7)),
        ("仿真步频", f"{sim.cadence_at(0.0):.1f} 步/分（{C.DEFAULT_SAMPLE_S:g}s 一个采样点）"),
        ("默认目标", f"{st['run_cfg'].get('target_distance_m')} 米 / "
                     f"{st['run_cfg'].get('target_seconds')} 秒"),
        ("本地记录", json.dumps(st.get("stats", {}), ensure_ascii=False)),
    ]
    width = max(len(k) for k, _ in rows)
    for k, v in rows:
        print(f"  {k.ljust(width)}  {v}")
    app.close()
    return 0


def cmd_login(args: argparse.Namespace) -> int:
    app = build_app(args)
    print(dim(f"服务端：{app.status().get('mock_url') or '真实 api.huachenjie.com'}"))
    res = app.login(args.phone, args.password or "", not args.no_captcha)
    if res.get("code") != 0:
        print(bad(f"登录失败：{res.get('message')}"))
        app.close()
        return 1
    data = res.get("data") or {}
    print(ok(f"登录成功：{data.get('userName')} @ {data.get('schoolName')}"))
    print(f"  token    {str(data.get('token'))[:32]}…")
    print(f"  satoken  {str(data.get('satoken'))[:32]}…")
    print(f"  手机号（服务端回显，AES 加密）{data.get('phone')}")
    if args.prepare:
        r = app.run_prepare()
        fp = (app.status().get("fence") or {})
        print(ok(f"已拉取围栏与规则：{fp.get('fenceName')}") if r.get("code") == 0
              else bad(f"拉取失败：{r.get('message')}"))
    print(dim(f"会话已写入 {app.status()['data_dir']}/records.db（kv.session）"))
    app.close()
    return 0


def cmd_run(args: argparse.Namespace) -> int:
    app = build_app(args)
    st = app.status()
    if not st["logged_in"]:
        print(dim("尚未登录，先自动登录…"))
        r = app.login(args.phone, args.password or "", True)
        if r.get("code") != 0:
            print(bad(f"登录失败：{r.get('message')}"))
            app.close()
            return 1
    print(dim(f"服务端：{app.status().get('mock_url') or '真实 api.huachenjie.com'}"))
    print(f"  目标 {args.distance:g} 米，围栏序号 {args.fence}，"
          f"上传={'是' if not args.no_upload else '否'}，"
          f"结算={'是' if not args.no_finish else '否'}")

    r = app.run_prepare()
    if r.get("code") != 0:
        print(bad(f"备跑失败：{r.get('message')}"))
        app.close()
        return 1
    fence = app.status().get("fence") or {}
    print(ok(f"备跑完成：{fence.get('fenceName')} "
             f"({len(app.status().get('checkpoints') or [])} 个打卡点)"))

    r = app.run_auto(target_m=args.distance, fence_index=args.fence,
                     do_upload=not args.no_upload, do_finish=not args.no_finish,
                     sport_type=args.sport)
    if r.get("code") != 0:
        print(bad(f"启动失败：{r.get('message')}"))
        app.close()
        return 1
    pump(app, quiet=args.quiet)
    last = (app.status().get("last") or {})
    print(ok(f"完成：{last.get('run_code')}"))
    _print_summary(last)
    if args.json:
        print(json.dumps(last, ensure_ascii=False, indent=2))
    app.close()
    return 0


def _print_summary(last: Dict[str, Any]) -> None:
    if not last:
        return
    up = last.get("upload") or {}
    print(f"  距离     {float(last.get('distance_m') or 0):.1f} 米"
          f"（{int(last.get('points') or 0)} 个轨迹点）")
    print(f"  时长     {int(last.get('duration_s') or 0)} 秒，配速 "
          f"{float(last.get('pace_s_per_km') or 0):.0f} 秒/公里")
    print(f"  步数     {int(last.get('total_step') or 0)}（步幅 "
          f"{float(last.get('stride_m') or 0):.3f} 米）")
    print(f"  打卡     {last.get('checkpoints_done', '?')} / {last.get('checkpoints_total', '?')}")
    valid = last.get("valid")
    if isinstance(valid, dict):
        flag = valid.get("isValid", valid.get("is_valid"))
        reasons = valid.get("reasons") or []
        names = "、".join(str((r or {}).get("name") or r) for r in reasons)
        print(f"  有效性   {'通过' if flag else '不通过'}{'' if flag else ' —— ' + (names or '无')}")
    if up:
        parts = []
        for key, name in (("points", "轨迹"), ("steps", "步频"), ("paces", "配速"),
                          ("strides", "步幅"), ("checkpoints", "打卡"), ("finish", "结算")):
            v = up.get(key)
            if isinstance(v, dict):
                cnt = (v.get("data") or {}).get("count") if isinstance(v.get("data"), dict) else None
                parts.append(f"{name}{'✓' if v.get('code') == 0 else '✗'}"
                             f"{f'({cnt})' if cnt is not None else ''}")
        print("  上传     " + " ".join(parts))


def cmd_records(args: argparse.Namespace) -> int:
    app = build_app(args)
    act = args.action

    if act == "list":
        runs = app.list_runs(args.limit)
        if not runs:
            print(dim("还没有本地记录。先跑一次：python -m sdlab run -d 2000"))
            app.close()
            return 0
        head = f"{'记录号':<20}{'类型':<6}{'距离(m)':>9}{'时长(s)':>8}{'步数':>7}{'上传':>6}  开始时间"
        print(head)
        print(dim("─" * 78))
        for r in runs:
            import datetime as _dt
            ts = _dt.datetime.fromtimestamp((r.get("start_ms") or 0) / 1000).strftime("%Y-%m-%d %H:%M")
            print(f"{r.get('run_code', ''):<20}"
                  f"{'阳光跑' if r.get('sport_type') == 1 else '自由跑':<6}"
                  f"{float(r.get('distance_m') or 0):>9.1f}"
                  f"{int(r.get('duration_s') or 0):>8}"
                  f"{int(r.get('total_step') or 0):>7}"
                  f"{'是' if r.get('uploaded') else '否':>6}  {ts}")
        print(dim(f"\n共 {len(runs)} 条（数据目录 {app.status()['data_dir']}）"))

    elif act == "show":
        d = app.run_detail(args.run_code or app.status().get("last", {}).get("run_code", ""))
        if not d:
            print(bad("没有这条记录"))
            app.close()
            return 1
        run = d["run"]
        print(ok(f"{run.get('run_code')}  {run.get('fence_name') or ''}"))
        _print_summary({**run, "valid": run.get("valid"),
                        "points": d["counts"].get("points"),
                        "checkpoints_done": sum(1 for c in d.get("checkpoints", []) if c.get("passed")),
                        "checkpoints_total": len(d.get("checkpoints") or [])})
        print(f"  上传计数 {json.dumps(d['counts'], ensure_ascii=False)}")
        print(f"  打卡点   " + " ".join(
            f"#{c.get('index')}{'✓' if c.get('passed') else '·'}" for c in d.get("checkpoints", [])))
        if args.points:
            print("\n  轨迹点（前 20）")
            for p in d["points"][:20]:
                print(f"    #{p['index']:<4}{p['lat']:.6f},{p['lng']:.6f} "
                      f"state={p['state']} acc={p.get('accuracy')}")
        if args.log:
            print("\n  上传日志")
            for e in d["upload_log"][:20]:
                print(f"    {e.get('endpoint'):<22}{'✓' if e.get('ok') else '✗'} "
                      f"{e.get('message')}")

    elif act == "export":
        code = args.run_code or app.status().get("last", {}).get("run_code", "")
        r = app.export(code, args.format)
        print(ok(f"已导出 {r.get('path')}"))
        if args.json:
            print(json.dumps(r, ensure_ascii=False))

    elif act == "resume":
        code = args.run_code or app.status().get("last", {}).get("run_code", "")
        r = app.resume(code)
        if r.get("code") != 0:
            print(bad(str(r.get("message"))))
            app.close()
            return 1
        print(dim(str(r.get("message"))))
        pump(app, quiet=args.quiet)
        print(ok("续传结束"))
        _print_summary(app.status().get("last") or {})

    elif act == "delete":
        code = args.run_code or ""
        if not code:
            print(bad("需要记录号"))
            app.close()
            return 1
        app.delete_run(code)
        print(ok(f"已删除本地记录 {code}"))

    elif act == "pending":
        code = args.run_code or app.status().get("last", {}).get("run_code", "")
        d = app.run_detail(code)
        c = d.get("counts") or {}
        print(f"  记录 {code}")
        print(f"  轨迹 {c.get('points_uploaded', 0)}/{c.get('points', 0)} 已上传，"
              f"待传 {c.get('points_pending', 0)}，失败 {c.get('points_failed', 0)}")

    app.close()
    return 0


def cmd_mock(args: argparse.Namespace) -> int:
    """只起 Mock 服务端：给 curl / Postman / 别的客户端联调"""
    from .bus import EventBus
    from .mock import MockServer, MockWorld

    bus = EventBus()
    bus.subscribe(lambda ev: print(f"  {_kind(ev)} {ev.get('message', '')}", flush=True)
                  if ev.get("kind") in ("mock", "log") else None)
    world = MockWorld(bus=bus, latency_ms=args.latency, fail_rate=args.fail_rate)
    srv = MockServer(world, host=args.host, port=args.port)
    url = srv.start()
    print(ok(f"Mock 服务端已启动：{url}"))
    print(f"  基础地址   {srv.base_url}")
    print(f"  账号       {args.phone} / 任意密码")
    print(f"  统计       {srv.api_root}/__stats（内部计数）")
    print(dim("  Ctrl-C 退出"))
    try:
        while True:
            time.sleep(1)
    except KeyboardInterrupt:
        pass
    finally:
        srv.stop()
    return 0


def cmd_check(args: argparse.Namespace) -> int:
    here = Path(__file__).resolve().parent.parent
    import subprocess
    rc = 0
    only = args.only
    for name, script in (("离线协议自检", "selfcheck.py"), ("前端链路自检", "webcheck.py")):
        if only and only not in script:
            continue
        p = here / "scripts" / script
        if not p.exists():
            print(bad(f"找不到 {p}"))
            rc = 1
            continue
        print(_c(f"\n══ {name}：{script} ══", "1"))
        r = subprocess.run([sys.executable, str(p)] + (["-v"] if args.verbose else []))
        rc = rc or r.returncode
    return rc


# ══════════════════ 参数解析 ══════════════════
def build_parser() -> argparse.ArgumentParser:
    ap = argparse.ArgumentParser(
        prog="python -m sdlab",
        description="闪动校园 · 阳光跑工作台（协议复原 + 本地仿真 + 桌面界面）",
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog="默认全部走本地 Mock 服务端；加 --real 才会请求真实 api.huachenjie.com。")
    ap.add_argument("-V", "--version", action="version",
                    version=f"sdlab {__version__}（复刻 App {APP_VERSION}）")

    common = argparse.ArgumentParser(add_help=False)
    common.add_argument("--data-dir", help="数据目录（默认 ~/.local/share/shandong-run-lab）")
    common.add_argument("--config", help="配置文件路径（默认 ~/.config/shandong-run-lab/config.json）")
    common.add_argument("--mode", choices=["mock", "real"],
                        help="运行模式；不给则沿用配置文件（默认 mock）")
    common.add_argument("--real", dest="mode", action="store_const", const="real",
                        help="等价于 --mode real")
    common.add_argument("--proxy", help="HTTP 代理，如 http://127.0.0.1:8080")
    common.add_argument("-p", "--phone", default="13800138000", help="手机号")
    common.add_argument("-w", "--password", default="", help="密码（Mock 模式下任意值）")
    common.add_argument("-q", "--quiet", action="store_true", help="不打印事件流")

    sp = ap.add_subparsers(dest="command")

    g = sp.add_parser("gui", parents=[common], help="打开桌面窗口（默认命令）")
    g.add_argument("--browser", action="store_true", help="不开窗口，改用本地 HTTP + 浏览器")
    g.add_argument("--debug", action="store_true", help="打开 webview 调试")
    g.set_defaults(func=cmd_gui)

    i = sp.add_parser("info", parents=[common], help="打印环境信息")
    i.set_defaults(func=cmd_info)

    lg = sp.add_parser("login", parents=[common], help="登录")
    lg.add_argument("--no-captcha", action="store_true", help="跳过滑块验证码（Mock 下无所谓）")
    lg.add_argument("--prepare", action="store_true", help="登录后顺便拉取围栏与规则")
    lg.set_defaults(func=cmd_login)

    rn = sp.add_parser("run", parents=[common], help="跑一次完整流程")
    rn.add_argument("-d", "--distance", type=float, default=2000.0, help="目标距离（米）")
    rn.add_argument("-f", "--fence", type=int, default=0, help="围栏序号")
    rn.add_argument("-s", "--sport", type=int, default=1, choices=[1, 2],
                    help="1=阳光跑，2=自由跑")
    rn.add_argument("--no-upload", action="store_true", help="只生成不磁上传")
    rn.add_argument("--no-finish", action="store_true", help="不上传结算报文")
    rn.add_argument("--json", action="store_true", help="额外打印完整结果 JSON")
    rn.set_defaults(func=cmd_run)

    rc = sp.add_parser("records", parents=[common], help="本地记录：列表/明细/导出/续传/删除")
    rc.add_argument("action", choices=["list", "show", "export", "resume", "delete", "pending"])
    rc.add_argument("run_code", nargs="?", default="", help="记录号（省略则用最近一条）")
    rc.add_argument("--format", default="json", choices=["json", "gpx"], help="导出格式")
    rc.add_argument("--limit", type=int, default=100, help="列表条数")
    rc.add_argument("--points", action="store_true", help="show 时打印轨迹点")
    rc.add_argument("--log", action="store_true", help="show 时打印上传日志")
    rc.add_argument("--json", action="store_true", help="打印原始返回")
    rc.set_defaults(func=cmd_records)

    mk = sp.add_parser("mock", parents=[common], help="只启动 Mock 服务端")
    mk.add_argument("--host", default="127.0.0.1")
    mk.add_argument("--port", type=int, default=8899, help="0 = 随机端口")
    mk.add_argument("--latency", type=int, default=0, help="人为延迟（毫秒），调试加载态")
    mk.add_argument("--fail-rate", type=float, default=0.0, help="随机失败率 0~1，调试重试与断点续传")
    mk.set_defaults(func=cmd_mock)

    ck = sp.add_parser("check", parents=[common], help="运行自检")
    ck.add_argument("--only", choices=["selfcheck", "webcheck"], help="只跑其中一个")
    ck.add_argument("-v", "--verbose", action="store_true")
    ck.set_defaults(func=cmd_check)
    return ap


def main(argv: Optional[List[str]] = None) -> int:
    ap = build_parser()
    args = ap.parse_args(argv)
    if not getattr(args, "command", None):
        # 没给子命令 = 开桌面窗口
        args = ap.parse_args(["gui"] + (argv or []))
    try:
        return int(args.func(args) or 0)
    except KeyboardInterrupt:
        print("\n已中断")
        return 130
    except Exception as e:  # noqa: BLE001
        print(bad(f"{type(e).__name__}: {e}"))
        if getattr(args, "verbose", False):
            import traceback
            traceback.print_exc()
        return 1


if __name__ == "__main__":
    raise SystemExit(main())
