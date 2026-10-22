#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""闪动校园（网易易盾）脱壳驱动。

方案要点（全部经本机实测确认）：
  1. 壳在应用 DEX 刚加载完（约 2 秒）时调用 Java 层 System.exit(0) 自毁。
     拦 libc 的 exit/_exit **无效**（ART 走 System.exit -> Runtime.exitInternal
     的 Java 路径），必须在 Java 层拦 System.exit。拦住后进程可长期存活。
  2. DEX 的获取点：遍历 ClassLoader -> pathList.dexElements -> DexFile，
     从 mCookie 拿到 art::DexFile*，读 begin_/size_ 直接落盘。
     注意 enumerateClassLoaders 返回的是 java.lang.ClassLoader，
     必须 Java.cast 成 BaseDexClassLoader 才能访问 pathList 字段。
  3. 时间点很重要：实测 2.5s 时应用自有类为 0，6s 时才有 141 个；
     所以要在 8s 之后才扫描。

用法:
    work/toolchain/.venv-frida/bin/python scripts/run_unpack_final.py --outdir work/dump_ok
"""

from __future__ import annotations

import argparse
import sys
import threading
import time
from pathlib import Path

import frida

PKG = "com.huachenjie.shandong_school"
BUNDLE = Path(__file__).resolve().parent.parent / "work" / "final_dump_bundle.js"


def main() -> int:
    ap = argparse.ArgumentParser(description="闪动校园易盾脱壳（保活 + DexFile 直读）")
    ap.add_argument("--outdir", default="work/dumps/dump_ok")
    ap.add_argument("--seconds", type=float, default=32.0)
    args = ap.parse_args()

    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    if not BUNDLE.is_file():
        print(f"[!] 缺少打包脚本 {BUNDLE}，先运行 esbuild 打包", flush=True)
        return 2

    saved = 0
    lock = threading.Lock()

    def on_message(msg, data):
        nonlocal saved
        if msg.get("type") == "error":
            print(f"[err] {msg.get('description')}", flush=True)
            return
        if msg.get("type") != "send":
            return
        p = msg["payload"]
        if p.get("t") == "log":
            print(f"[js] {p['msg']}", flush=True)
        elif p.get("t") == "blob":
            with lock:
                f = outdir / f"{p['kind']}_{p['idx']:03d}_{p['size']}.bin"
                if data:
                    f.write_bytes(bytes(data))
                    saved += 1
            print(f"[√] {f.name}  {p['size']:,}B", flush=True)

    dev = frida.get_usb_device(timeout=20)
    print(f"[*] 设备 {dev.name}", flush=True)
    pid = dev.spawn([PKG])
    print(f"[*] spawn pid={pid}", flush=True)
    session = dev.attach(pid)
    script = session.create_script(BUNDLE.read_text())
    script.on("message", on_message)
    script.load()
    dev.resume(pid)
    print("[*] 已 resume", flush=True)

    t0 = time.time()
    while time.time() - t0 < args.seconds:
        time.sleep(3)
        alive = pid in {p.pid for p in dev.enumerate_processes()}
        print(f"[{time.time()-t0:5.1f}s] {'存活' if alive else '已退出'} | 已存 {saved}", flush=True)
        if not alive:
            break

    print(f"\n=== 结果：{saved} 个文件 ===", flush=True)
    for f in sorted(outdir.glob("*.bin")):
        print(f"  {f.name}  {f.stat().st_size:,} B", flush=True)
    try:
        session.detach()
    except Exception:
        pass
    return 0 if saved else 1


if __name__ == "__main__":
    sys.exit(main())
