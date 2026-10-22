#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""闪动校园（网易易盾）完整脱壳：批量导出应用全部 DEX。

原理（全部经本机实测）：
  1. 壳在应用 DEX 载入后调用 Java 层 System.exit(0) 自毁；必须在 Java 层拦
     System.exit（拦 libc 的 exit/_exit 无效 —— ART 走 System.exit ->
     Runtime.exitInternal，且壳还大量使用内联 SVC 指令绕过 libc）。
  2. 拿 DEX 的入口是 art::ClassLinker::DefineClass
     （libart.so vaddr=0x11c7d8）：
         x2 = 类描述符, x5 = const DexFile&
     运行时地址 = Module.base + vaddr − 首个LOAD段vaddr(0x27000)。
  3. 本机 Android 9 的 art::DexFile 布局与教科书不同：**offset 8** 才是指向
     "dex\\n038" 数据的指针（offset 0 是别的字段）。因此不硬编码偏移，而是
     扫描对象前 64 字节，取第一个指向 dex/cdex magic 的字段。
  4. 读内存一律从内核视角用 /proc/<pid>/mem（先 SIGSTOP）。dd 的 skip 是
     32 位块号；必须把「页内偏移」计入读取页数，否则尾部会被截断。

用法:
    work/toolchain/.venv-frida/bin/python scripts/unpack_all_dex.py --outdir work/APP_ALL
"""

from __future__ import annotations

import argparse
import pathlib
import struct
import subprocess
import sys
import threading
import time

import frida

PKG = "com.huachenjie.shandong_school"
ADB = str(pathlib.Path.home() / "Android/Sdk/platform-tools/adb")
BUNDLE = pathlib.Path(__file__).resolve().parent.parent / "work" / "tight_bundle.js"


def adb(args, timeout=300):
    p = subprocess.run([ADB] + args, capture_output=True, text=True, timeout=timeout)
    return p.stdout


def read_mem(pid: int, addr: int, size: int, tag: str, outdir: pathlib.Path) -> bytes:
    inpage = addr % 4096
    blk = addr // 4096
    cnt = (size + inpage + 4095) // 4096
    name = f"{tag}.bin"
    adb(["shell", "su", "-c", f"kill -STOP {pid}"])
    adb(["shell", "su", "-c",
         f"dd if=/proc/{pid}/mem of=/data/local/tmp/{name} bs=4096 skip={blk} count={cnt} 2>/dev/null"])
    adb(["shell", "su", "-c", f"kill -CONT {pid}"])
    adb(["shell", "su", "-c", f"chmod 666 /data/local/tmp/{name} 2>/dev/null"])
    adb(["pull", f"/data/local/tmp/{name}", str(outdir / name)])
    f = outdir / name
    data = f.read_bytes() if f.exists() else b""
    try:
        (outdir / name).unlink()
    except OSError:
        pass
    return data[inpage:] if data else b""


def main() -> int:
    ap = argparse.ArgumentParser(description="批量导出应用全部 DEX")
    ap.add_argument("--outdir", default="work/APP_ALL")
    ap.add_argument("--collect", type=float, default=15.0,
                    help="收集 DexFile 地址的秒数（应用 DEX 在 2.5~6s 之间陆续载入）")
    args = ap.parse_args()

    outdir = pathlib.Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    for old in outdir.glob("*"):
        if old.is_file():
            old.unlink()

    addrs: dict[str, str] = {}
    lock = threading.Lock()

    def on_message(msg, data):
        if msg.get("type") == "error":
            print(f"[err] {msg.get('description')}", flush=True)
            return
        if msg.get("type") != "send":
            return
        p = msg["payload"]
        if p.get("t") == "log":
            print(f"[js] {p['msg']}", flush=True)
        elif p.get("t") == "dexfile":
            with lock:
                addrs.setdefault(p["addr"], p["desc"])

    dev = frida.get_usb_device(timeout=20)
    print(f"[*] 设备 {dev.name}", flush=True)
    pid = dev.spawn([PKG])
    print(f"[*] spawn pid={pid}", flush=True)
    session = dev.attach(pid)
    script = session.create_script(BUNDLE.read_text())
    script.on("message", on_message)
    script.load()
    dev.resume(pid)
    print(f"[*] 已 resume，收集 DexFile 地址 {args.collect}s ...", flush=True)
    time.sleep(args.collect)

    with lock:
        items = list(addrs.items())
    print(f"\n[*] 共收集到 {len(items)} 个不同的 DexFile 对象", flush=True)

    saved = 0
    seen_dex: set[str] = set()
    for i, (a, desc) in enumerate(items, 1):
        try:
            addr = int(a, 16)
            obj = read_mem(pid, addr, 512, f"obj{i}", outdir)
            if len(obj) < 64:
                continue
            begin = 0
            for off in range(0, 64, 8):
                v = struct.unpack_from("<Q", obj, off)[0]
                if not (0x10000000 <= v <= 0x8000000000):
                    continue
                probe = read_mem(pid, v, 64, f"p{i}_{off}", outdir)
                if probe[:4] in (b"dex\n", b"cdex"):
                    begin = v
                    break
            if not begin:
                continue
            if begin in seen_dex:
                continue
            seen_dex.add(begin)
            head = read_mem(pid, begin, 256, f"h{i}", outdir)
            size = struct.unpack_from("<I", head, 0x20)[0]
            if not (4096 < size <= 100 * 1024 * 1024):
                continue
            blob = read_mem(pid, begin, size, f"dex{i}", outdir)
            if len(blob) < size:
                print(f"  [!] {desc} 读取不完整 ({len(blob):,}/{size:,})", flush=True)
                continue
            fs = struct.unpack_from("<I", blob, 0x20)[0]
            cls = struct.unpack_from("<I", blob, 0x60)[0]
            strs = struct.unpack_from("<I", blob, 0x38)[0]
            out = outdir / f"classes_{saved + 1:02d}_{cls}cls.dex"
            out.write_bytes(blob[:fs])
            saved += 1
            print(f"  [√] {out.name}  {fs:,}B  classes={cls:,} strings={strs:,}  ({desc})",
                  flush=True)
        except Exception as e:
            print(f"  [!] 处理 {a} 失败: {e}", flush=True)

    print(f"\n=== 共导出 {saved} 个 DEX 到 {outdir} ===", flush=True)
    for f in sorted(outdir.glob("*.dex")):
        print(f"  {f.name}  {f.stat().st_size:,} B", flush=True)
    try:
        session.detach()
    except Exception:
        pass
    return 0 if saved else 1


if __name__ == "__main__":
    sys.exit(main())
