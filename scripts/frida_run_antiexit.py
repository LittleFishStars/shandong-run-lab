#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""Frida 驱动：注入 anti-exit 脚本后启动应用，观察壳是否还能自毁、能否完成解壳。

流程：
    1. spawn 方式启动目标（在 Application 构造前注入，确保拦到最早的 exit）；
    2. 加载 scripts/frida_anti_exit.js（拦截 System.exit/Runtime/Process/native exit/abort/kill）；
    3. resume 并持续收集日志；
    4. 观察进程存活时长；若存活，说明自毁被成功阻止，此时即可抓内存里的应用 DEX。

用法:
    work/toolchain/.venv-frida/bin/python scripts/frida_run_antiexit.py [--timeout 60] [--out work/records/frida/frida_log.txt]
"""

from __future__ import annotations

import argparse
import sys
import threading
import time
from pathlib import Path

import frida

PKG = "com.huachenjie.shandong_school"
ACT = "com.huachenjie.shandong_school.splash.SplashActivity"
JS = Path(__file__).resolve().parent / "frida_anti_exit.js"


def main() -> int:
    ap = argparse.ArgumentParser(description="Frida anti-exit 注入并观察")
    ap.add_argument("--timeout", type=float, default=60.0, help="观察秒数")
    ap.add_argument("--out", default="work/records/frida/frida_log.txt")
    args = ap.parse_args()

    logs: list[str] = []
    lock = threading.Lock()

    def on_message(msg, data):
        with lock:
            if msg.get("type") == "send":
                line = f"[send] {msg['payload']}"
            elif msg.get("type") == "error":
                line = f"[error] {msg.get('description')}\n{msg.get('stack', '')}"
            else:
                line = f"[{msg.get('type')}] {msg}"
        print(line, flush=True)
        logs.append(line)

    dev = frida.get_usb_device(timeout=20)
    print(f"[*] 设备: {dev.name}", flush=True)

    print(f"[*] spawn {PKG} ...", flush=True)
    pid = dev.spawn([PKG])
    print(f"[*] spawned pid={pid}", flush=True)

    session = dev.attach(pid)
    script = session.create_script(JS.read_text())
    script.on("message", on_message)
    script.load()
    print("[*] anti-exit 脚本已注入", flush=True)

    dev.resume(pid)
    print("[*] 已 resume，开始观察 ...", flush=True)

    t0 = time.time()
    alive_at = []
    while time.time() - t0 < args.timeout:
        time.sleep(2)
        elapsed = time.time() - t0
        # 检查进程是否还在
        procs = {p.pid for p in dev.enumerate_processes()}
        alive = pid in procs
        alive_at.append((elapsed, alive))
        print(f"[{elapsed:5.1f}s] 进程 {'存活' if alive else '已退出'}", flush=True)
        if not alive:
            break

    print("\n=== 观察结果 ===", flush=True)
    survived = sum(1 for _, a in alive_at if a)
    print(f"存活采样点: {survived}/{len(alive_at)}", flush=True)
    last_alive = [e for e, a in alive_at if a]
    print(f"最长存活: {max(last_alive) if last_alive else 0:.1f}s", flush=True)

    Path(args.out).parent.mkdir(parents=True, exist_ok=True)
    Path(args.out).write_text("\n".join(logs), encoding="utf-8")
    print(f"[+] 日志写入 {args.out}（{len(logs)} 条）", flush=True)

    try:
        session.detach()
    except Exception:
        pass
    return 0


if __name__ == "__main__":
    sys.exit(main())
