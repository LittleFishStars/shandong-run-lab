#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""命令行入口：不打开图形界面也能走完「登录 → 阳光跑 → 记录 → 上传」

桌面窗口只是这一层的壳，所有能力在这里都能单独调用：

    python -m shandong_school_cracked                       # 与 gui 等价：开桌面窗口
    python -m shandong_school_cracked gui --browser         # 无 GUI 后端时降级到浏览器
    python -m shandong_school_cracked info                  # 看环境、路径、密码学后端
    python -m shandong_school_cracked login -p 13800138000  # 登录（默认打本地 Mock 服务端）
    python -m shandong_school_cracked run -d 2000           # 跑 2 公里：轨迹→上传→结算
    python -m shandong_school_cracked records list          # 本地记录列表
    python -m shandong_school_cracked records show <记录号>  # 单条记录明细
    python -m shandong_school_cracked records export <记录号> --format gpx
    python -m shandong_school_cracked records resume <记录号>  # 断点续传未上传成功的部分
    python -m shandong_school_cracked mock --port 8899      # 只起 Mock 服务端，给别的工具联调
    python -m shandong_school_cracked check                 # 离线自检 + 前端链路自检

默认走 **真实服务端**（api.huachenjie.com）：登录、开跑、上传都是真接口。
想离线调试就加 --mode mock，一切请求改打内置 Mock 服务端（127.0.0.1 随机端口），
两种模式的会话分开存，切换不会互相干扰。
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
    mode = getattr(args, "mode", None)
    # 模式直接进构造函数：先建好再 switch 会白起一个 Mock 服务端再拆掉
    app = App(data_dir=data_dir, config_path=cfg_path, mode=mode)
    if getattr(args, "proxy", None):
        app.patch_config({"transport": "proxy", "proxy": args.proxy})
    sim_patch: Dict[str, Any] = {}
    if getattr(args, "realtime", False):
        sim_patch["realtime"] = True
    if getattr(args, "speed", 0.0):
        sim_patch["speed"] = float(args.speed)
    if sim_patch:
        app.patch_config({"sim": sim_patch})
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
    return run_desktop(app=app, debug=args.debug, autorun=getattr(args, "autorun", 0.0))


def cmd_info(args: argparse.Namespace) -> int:
    from . import ciphers
    from . import constants as C
    from .simulator import FuckRunSim, random_device_id

    app = build_app(args)
    backend, backend_desc = ciphers.backend_info()
    st = app.status()
    sim = FuckRunSim(seed=1)
    sim.start(0, 0)
    from datetime import datetime as _dt
    _u = st.get("user") or {}
    if st.get("logged_in"):
        _at = int(_u.get("loginAt") or 0)
        _when = _dt.fromtimestamp(_at / 1000).strftime("%m-%d %H:%M") if _at else "未知"
        _login = (f"已恢复 {_u.get('userName') or _u.get('userId') or '已登录用户'}"
                  f"（上次登录 {_when}）")
    else:
        _login = "未登录"

    rows = [
        ("工作台版本", f"v{__version__}"),
        ("复刻的 App 版本", f"{APP_VERSION} / build {C.BUILD_VERSION}"),
        ("数据目录", st["data_dir"]),
        ("配置文件", st["config_path"]),
        ("运行模式", "本地 Mock（不联网）" if st["mode"] == "mock" else "真实服务端"),
        ("登录状态", _login),
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


def cmd_accounts(args: argparse.Namespace) -> int:
    from datetime import datetime as _dt
    app = build_app(args)
    try:
        act = (args.action or "list").lower()
        if act == "list":
            lst = app.list_accounts()
            if not lst:
                print(dim("本机还没有登录过的账号（先 shandong-school_cracked login）"))
                return 0
            for a in lst:
                mark = "●" if a.get("current") else " "
                at = int(a.get("loginAt") or 0)
                when = _dt.fromtimestamp(at / 1000).strftime("%m-%d %H:%M") if at else "-"
                print(f" {mark} {a.get('loginName') or '-':<14} {a.get('userName') or '-':<10} "
                      f"{a.get('schoolName') or '-':<12} 上次登录 {when}  id={a.get('userId')}")
            return 0
        uid = str(args.uid or "")
        if not uid:
            print(bad("请给出账号 id（先用 shandong-school_cracked users 看列表）"))
            return 1
        if act in ("use", "switch"):
            r = app.switch_account(uid)
            if r.get("code") != 0:
                print(bad(f"切换失败：{r.get('message')}"))
                return 1
            u = r.get("data") or {}
            print(ok(f"已切换：{u.get('userName') or uid} @ {u.get('schoolName') or ''}"))
            return 0
        if act in ("rm", "remove", "del"):
            r = app.forget_account(uid)
            if r.get("code") != 0:
                print(bad(f"移除失败：{r.get('message')}"))
                return 1
            print(ok("已移除该账号"))
            return 0
        print(bad(f"未知操作：{act}（list / use / rm）"))
        return 1
    finally:
        app.close()


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


def cmd_start_point(args: argparse.Namespace) -> int:
    """查看 / 设置 / 清除跑步起点（GUI 上就是地图工具条的「设置起点」）"""
    app = build_app(args)
    try:
        if args.clear:
            r = app.set_start_point(None, None)
            print(ok(str(r.get("message") or "已清除跑步起点")))
        elif args.lat is not None and args.lng is not None:
            if not app.status()["logged_in"]:
                print(dim("尚未登录，先自动登录并备跑（点在围栏外时要用围栏多边形做吸附）…"))
                if app.login(args.phone, args.password or "", True).get("code") != 0:
                    print(bad("登录失败，拉不到围栏，起点不会被吸附"))
                    return 1
                app.run_prepare()
            elif not app.client.fence_polygon():
                app.run_prepare()
            r = app.set_start_point(args.lat, args.lng)
            if r.get("code") != 0:
                print(bad(str(r.get("message"))))
                return 1
            sp = (r.get("data") or {}).get("start_point") or {}
            print(ok(f"{r.get('message')}：{float(sp.get('lat') or 0):.6f}, "
                     f"{float(sp.get('lng') or 0):.6f}"
                     + ("（已吸附进围栏）" if sp.get("snapped") else "")))
        elif args.lat is not None or args.lng is not None:
            print(bad("--lat 与 --lng 必须成对给出（或加 --clear 清除）"))
            return 1

        st = app.status()
        cur = st.get("start_point") or {}
        rows = [
            ("运行模式", "本地 Mock（不联网）" if st["mode"] == "mock" else "真实服务端"),
            ("当前起点", f"{cur['lat']:.6f}, {cur['lng']:.6f}（图上选的）"
                        if cur else "围栏中心（没自定义过）"),
            ("存的位置", f"{st['data_dir']}/records.db → kv.start_point"),
            ("登录态", "已登录" if st["logged_in"] else "未登录（起点仍可查看/设置）"),
        ]
        if st["logged_in"]:
            try:
                clat, clng = app.client.fence_center()
                rows.append(("围栏中心", f"{clat:.6f}, {clng:.6f}"))
            except Exception:  # noqa: BLE001
                rows.append(("围栏中心", "尚未备跑（先 `login --prepare`）"))
        width = max(len(k) for k, _ in rows)
        for k, v in rows:
            print(f"  {k.ljust(width)}  {v}")
        if args.json:
            print(json.dumps(st.get("start_point"), ensure_ascii=False))
        return 0
    finally:
        app.close()


def _print_summary(last: Dict[str, Any]) -> None:
    if not last:
        return
    up = last.get("upload") or {}
    print(f"  距离     {float(last.get('distance_m') or 0):.1f} 米"
          f"（{int(last.get('points') or 0)} 个轨迹点）")
    print(f"  时长     {int(last.get('duration_s') or 0)} 秒，配速 "
          f"{float(last.get('pace_s_per_km') or 0):.0f} 秒/公里")
    # 步幅：引擎/实跑摘要里有 stride_m 就直接用；从本地库读出来的 run 没有这一列，
    # 用 距离/步数 现算（否则 records show 永远显示 0.000）
    _steps = int(last.get("total_step") or 0)
    _stride = float(last.get("stride_m") or 0)
    if not _stride and _steps > 0:
        _stride = float(last.get("distance_m") or 0) / _steps
    print(f"  步数     {_steps}（步幅 {_stride:.3f} 米）")
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
            print(dim("还没有本地记录。先跑一次：python -m shandong_school_cracked run -d 2000"))
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
        print("  打卡点   " + " ".join(
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
    """自检：源码模式起子进程跑 scripts/ 下的两个脚本；打包版在本进程里跑

    单文件 exe 里 sys.executable 就是自己，起子进程只会重新启动整个程序，
    所以打包时把两个脚本作为数据塞进 bundle，用 runpy 在同一个解释器里执行。
    """
    only = args.only
    rc = 0
    frozen = bool(getattr(sys, "frozen", False))
    base = (Path(getattr(sys, "_MEIPASS", Path(sys.executable).resolve().parent))
            if frozen else Path(__file__).resolve().parent.parent)
    for name, script in (("离线协议自检", "selfcheck.py"), ("前端链路自检", "webcheck.py")):
        if only and only not in script:
            continue
        p = base / "scripts" / script
        if not p.exists():
            print(bad(f"找不到 {p}"))
            rc = 1
            continue
        print(_c(f"\n══ {name}：{script}{'（打包版内置）' if frozen else ''} ══", "1"))
        if frozen:
            rc = rc or _run_script_inproc(p, args.verbose)
            continue
        import subprocess
        r = subprocess.run([sys.executable, str(p)] + (["-v"] if args.verbose else []))
        rc = rc or r.returncode
    return rc


def _run_script_inproc(script: Path, verbose: bool) -> int:
    """在本进程里执行自检脚本（仅打包版）；脚本自己 argparse，所以接管 sys.argv"""
    import runpy

    saved = sys.argv
    sys.argv = [str(script)] + (["-v"] if verbose else [])
    try:
        runpy.run_path(str(script), run_name="__main__")
        return 0
    except SystemExit as e:
        code = e.code
        return int(code) if isinstance(code, int) else (0 if code is None else 1)
    except Exception as e:                       # noqa: BLE001
        print(bad(f"{type(e).__name__}: {e}"))
        if verbose:
            import traceback
            traceback.print_exc()
        return 1
    finally:
        sys.argv = saved

# ══════════════════ 参数解析 ══════════════════
def build_parser() -> argparse.ArgumentParser:
    ap = argparse.ArgumentParser(
        prog="python -m shandong_school_cracked",
        description="闪动校园 · 阳光跑工作台（协议复原 + 本地仿真 + 桌面界面）",
        formatter_class=argparse.RawDescriptionHelpFormatter,
        epilog="默认全部走本地 Mock 服务端；加 --real 才会请求真实 api.huachenjie.com。")
    ap.add_argument("-V", "--version", action="version",
                    version=f"shandong-school_cracked {__version__}（复刻 App {APP_VERSION}）")
    # 兼容 `--mode mock gui`（全局选项写在子命令前面的写法）；子命令后的 --mode 仍然有效
    ap.add_argument("--mode", dest="mode_global", choices=["real", "mock"],
                    default=None, help=argparse.SUPPRESS)

    common = argparse.ArgumentParser(add_help=False)
    common.add_argument("--data-dir", help="数据目录（默认 ~/.local/share/shandong-school_cracked）")
    common.add_argument("--config", help="配置文件路径（默认 ~/.config/shandong-school_cracked/config.json）")
    common.add_argument("--mode", choices=["real", "mock"],
                        help="运行模式：real 真实服务端（默认）/ mock 本地离线仿真")
    common.add_argument("--real", dest="mode", action="store_const", const="real",
                        help="等价于 --mode real")
    common.add_argument("--proxy", help="HTTP 代理，如 http://127.0.0.1:8080")
    common.add_argument("-p", "--phone", default="13800138000", help="手机号")
    common.add_argument("-w", "--password", default="", help="密码（真实登录必填；本地 Mock 任意值）")
    common.add_argument("-q", "--quiet", action="store_true", help="不打印事件流")
    common.add_argument("--realtime", action="store_true",
                        help="实时仿真：按真实时间推进数据写入（默认关，瞬间算完）")
    common.add_argument("--speed", type=float, default=0.0,
                        help="实时仿真倍速，默认 8（配 --realtime 用）")

    sp = ap.add_subparsers(dest="command")

    g = sp.add_parser("gui", parents=[common], help="打开桌面窗口（默认命令）")
    g.add_argument("--browser", action="store_true", help="不开窗口，改用本地 HTTP + 浏览器")
    g.add_argument("--debug", action="store_true", help="打开 webview 调试")
    g.add_argument("--autorun", type=float, default=0.0, metavar="米",
                   help="窗口加载后自动跑一次完整流程（调试/演示）")
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

    stp = sp.add_parser("start-point", parents=[common], help="跑步起点：查看 / 设置 / 清除")
    stp.add_argument("--lat", type=float, default=None, help="起点纬度（与 --lng 成对）")
    stp.add_argument("--lng", type=float, default=None, help="起点经度")
    stp.add_argument("--clear", action="store_true", help="清除起点，回到围栏中心")
    stp.add_argument("--json", action="store_true", help="额外打印原始返回值")
    stp.set_defaults(func=cmd_start_point)

    mk = sp.add_parser("mock", parents=[common], help="只启动 Mock 服务端")
    mk.add_argument("--host", default="127.0.0.1")
    mk.add_argument("--port", type=int, default=8899, help="0 = 随机端口")
    mk.add_argument("--latency", type=int, default=0, help="人为延迟（毫秒），调试加载态")
    mk.add_argument("--fail-rate", type=float, default=0.0, help="随机失败率 0~1，调试重试与断点续传")
    mk.set_defaults(func=cmd_mock)

    us = sp.add_parser("users", parents=[common], help="历史账号：列表/切换/移除（不重新输密码）")
    us.add_argument("action", nargs="?", default="list", help="list（默认）/ use / rm")
    us.add_argument("uid", nargs="?", default="", help="账号 id（use / rm 需要）")
    us.set_defaults(func=cmd_accounts)

    ck = sp.add_parser("check", parents=[common], help="运行自检")
    ck.add_argument("--only", choices=["selfcheck", "webcheck"], help="只跑其中一个")
    ck.add_argument("-v", "--verbose", action="store_true")
    ck.set_defaults(func=cmd_check)
    return ap


_CONSOLE_HIDDEN = False


def _harden_stdio() -> None:
    """Windows 下把输出流的错字符改成替换，而不是抛 UnicodeEncodeError

    真实控制台（Python 3.6+ 走 WriteConsoleW）本来就没事；但输出被重定向到文件/
    管道时用的是 cp1252/cp936，打印 ✓、→ 这类符号会直接崩。只放宽错误策略，
    不改编码，免得 cmd 里中文反而变乱码。
    """
    for stream in (sys.stdout, sys.stderr):
        try:
            if not stream.isatty():
                # 被重定向/管道捕获时统一吐 UTF-8，日志和 CI 都好处理
                stream.reconfigure(encoding="utf-8", errors="replace")
            else:
                stream.reconfigure(errors="replace")
        except Exception:                                # noqa: BLE001
            pass


def _hide_console_if_double_clicked(argv: Optional[List[str]]) -> None:
    """Windows 下双击启动时把控制台黑窗藏掉（打包版专用）

    同一个 exe 既是 GUI 又是 CLI：双击（无参数、且控制台里只有自己）→ 藏窗；
    在 cmd/powershell 里带参数跑 → 不藏，否则 CLI 输出全看不见。
    源码运行、其它平台一律不动。
    """
    global _CONSOLE_HIDDEN
    if sys.platform != "win32" or not getattr(sys, "frozen", False):
        return
    if (argv if argv is not None else sys.argv[1:]):
        return
    try:
        import ctypes

        k32 = ctypes.windll.kernel32
        hwnd = k32.GetConsoleWindow()
        if not hwnd:
            return
        pids = (ctypes.c_uint * 4)()
        if k32.GetConsoleProcessList(pids, 4) > 1:
            return                                  # 是父控制台拉起来的
        ctypes.windll.user32.ShowWindow(hwnd, 0)     # SW_HIDE
        _CONSOLE_HIDDEN = True
    except Exception:                                # noqa: BLE001
        pass


def _report_fatal(e: BaseException) -> None:
    """控制台被藏了的话，只能弹窗告诉用户（否则双击一片死寂）"""
    if not _CONSOLE_HIDDEN:
        return
    try:
        import ctypes

        ctypes.windll.user32.MessageBoxW(
            None, f"启动失败：{type(e).__name__}: {e}", "闪动校园·阳光跑工作台", 0x10)
    except Exception:                                # noqa: BLE001
        pass


def main(argv: Optional[List[str]] = None) -> int:
    _harden_stdio()
    ap = build_parser()
    args = ap.parse_args(argv)
    if getattr(args, "mode_global", None):
        args.mode = args.mode_global      # 全局 --mode 优先于子命令里的模式
    if not getattr(args, "command", None):
        # 没给子命令 = 开桌面窗口
        args = ap.parse_args(["gui"] + (argv or []))
    _hide_console_if_double_clicked(argv)
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
        _report_fatal(e)
        return 1


if __name__ == "__main__":
    raise SystemExit(main())
