#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""执行易盾脱壳：注入 frida_unpack_yidun.js，绕环境检测并在 DexFile::OpenCommon 处取明文 DEX。

方案依据 xiaosan-re《网易易盾壳的自定义 linker、SMC 与脱壳实战》：
  * 壳检测 root/模拟器/脱壳器痕迹 -> 命中即闪退；先伪装环境；
  * 壳解密 DEX 后调用 art::DexFileLoader::OpenCommon(base, size, ...)，
    base/size 即完整明文 DEX，是「非常舒服的脱壳点」；
  * 不要遍历 /proc/self/maps（壳会检测）。

用法:
    work/toolchain/.venv-frida/bin/python scripts/run_unpack_yidun.py --seconds 40 --outdir work/unpack_yidun
"""

from __future__ import annotations

import argparse
import sys
import threading
import time
from pathlib import Path

import frida

PKG = "com.huachenjie.shandong_school"
# 优先用 esbuild 打包版（内含 frida-java-bridge，解决 Frida 17 的
# "Java is not defined"）；不存在时退回未打包的脚本（仅 native hook）。
_RAW = Path(__file__).resolve().parent / "frida_unpack_yidun.js"
_BUNDLE = Path(__file__).resolve().parent.parent / "work" / "unpack_bundle.js"
JS = _BUNDLE if _BUNDLE.exists() else _RAW


def main() -> int:
    ap = argparse.ArgumentParser(description="易盾脱壳（OpenCommon 截获）")
    ap.add_argument("--outdir", default="work/unpack_yidun")
    ap.add_argument("--seconds", type=float, default=40.0)
    ap.add_argument("--attach", action="store_true",
                    help="用 attach 而非 spawn（默认 spawn，能覆盖更早时机）")
    args = ap.parse_args()

    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)

    logs: list[str] = []
    saved = 0
    lock = threading.Lock()

    def on_message(msg, data):
        nonlocal saved
        if msg.get("type") == "error":
            line = f"[error] {msg.get('description')}"
            print(line, flush=True)
            logs.append(line)
            return
        if msg.get("type") != "send":
            return
        p = msg["payload"]
        if p.get("t") == "log":
            line = f"[js] {p['msg']}"
            print(line, flush=True)
            logs.append(line)
        elif p.get("t") == "dex":
            with lock:
                cls = p.get("classDefs", 0)
                f = outdir / f"classes_{p['idx']:02d}_{cls}cls_{p['size']}.dex"
                if data:
                    f.write_bytes(bytes(data))
                saved += 1
            line = (f"[√] DEX #{p['idx']} size={p['size']:,} fileSize={p['fileSize']:,} "
                    f"strings={p['strSize']:,} classes={cls:,} -> {f.name}")
            print(line, flush=True)
            logs.append(line)

    dev = frida.get_usb_device(timeout=20)
    print(f"[*] 设备 {dev.name}", flush=True)

    if args.attach:
        import subprocess
        adb = str(Path.home() / "Android/Sdk/platform-tools/adb")
        subprocess.run([adb, "shell", "am", "force-stop", PKG], capture_output=True)
        time.sleep(0.4)
        subprocess.run([adb, "shell", "am", "start", "-n", f"{PKG}/.splash.SplashActivity"],
                       capture_output=True)
        pid = None
        for _ in range(400):
            procs = {p.name: p.pid for p in dev.enumerate_processes()}
            if PKG in procs:
                pid = procs[PKG]
                break
        if not pid:
            print("[!] 未抢到 pid", flush=True)
            return 1
        session = dev.attach(pid)
        print(f"[*] attach pid={pid}", flush=True)
    else:
        pid = dev.spawn([PKG])
        print(f"[*] spawn pid={pid}", flush=True)
        session = dev.attach(pid)

    script = session.create_script(JS.read_text())
    script.on("message", on_message)
    script.load()
    if not args.attach:
        dev.resume(pid)
        print("[*] 已 resume", flush=True)

    t0 = time.time()
    while time.time() - t0 < args.seconds:
        time.sleep(2)
        procs = {p.pid for p in dev.enumerate_processes()}
        alive = pid in procs
        print(f"[{time.time()-t0:5.1f}s] 进程 {'存活' if alive else '已退出'} | 已存 DEX {saved}",
              flush=True)
        if not alive:
            break

    print(f"\n=== 结果：{saved} 个 DEX ===", flush=True)
    for f in sorted(outdir.glob("*.dex")):
        print(f"  {f.name}  {f.stat().st_size:,} B", flush=True)

    Path(outdir / "run.log").write_text("\n".join(logs), encoding="utf-8")
    try:
        session.detach()
    except Exception:
        pass
    return 0 if saved else 1


if __name__ == "__main__":
    sys.exit(main())
