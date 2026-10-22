#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""闪动校园（网易易盾）脱壳 —— 内核视角读取版。

背景与依据：
  * 依据《当 Hook 失效的那一刻：SVC 指令级系统调用保护》
    (https://overkazaf.github.io/blogs/posts/android-svc-syscall-protection/)：
    加固壳会把安全敏感系统调用改成内联 SVC 指令，绕过 libc，使 Frida 的
    Interceptor 全部失效；同时壳用 SVC 扫描 /proc/self/maps、枚举线程来检测
    Frida 注入。因此「读内存」不能依赖 Frida 的进程内视角，必须从内核视角
    用 /proc/<pid>/mem 读。
  * 壳会在应用 DEX 载入后调用 Java 层 System.exit(0)（ART 走 System.exit ->
    Runtime.exitInternal，不经 libc 的 exit），必须在 Java 层拦，否则进程 2 秒即死。
  * 拿 DEX 的入口：art::ClassLinker::DefineClass（libart.so vaddr=0x11c7d8），
    x2=类描述符，x5=const DexFile&。运行时地址 =
    Module.base + vaddr − 首个LOAD段vaddr(0x27000)。

流程：Frida 保活并报出 DexFile& 地址 → 宿主立刻 SIGSTOP → 从 /proc/pid/mem
读 DexFile 的 begin_/size_ → 校验 "dex\n"/"cdex" → 整块取出并落盘。

用法:
    work/toolchain/.venv-frida/bin/python scripts/unpack_kernelview.py --outdir work/kernelview
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
    """从 /proc/<pid>/mem 读一段内存（先 SIGSTOP，读完 CONT）。

    toybox dd 的 skip 是 32 位块号；本机容器/DexFile 地址约 0x7c..，
    /4096 ≈ 1.3e8，落在 int32 范围内可正常工作。
    """
    inpage = addr % 4096
    blk = addr // 4096
    # 必须把页内偏移算进去：dd 从页首开始读，否则尾部会少 inpage 字节
    cnt = (size + inpage + 4095) // 4096
    name = f"{tag}.bin"
    adb(["shell", "su", "-c", f"kill -STOP {pid}"])
    r = adb(["shell", "su", "-c",
             f"dd if=/proc/{pid}/mem of=/data/local/tmp/{name} bs=4096 skip={blk} "
             f"count={cnt} 2>&1 | tail -2"])
    adb(["shell", "su", "-c", f"kill -CONT {pid}"])
    adb(["shell", "su", "-c", f"chmod 666 /data/local/tmp/{name} 2>/dev/null"])
    adb(["pull", f"/data/local/tmp/{name}", str(outdir / name)])
    f = outdir / name
    data = f.read_bytes() if f.exists() else b""
    inpage = addr % 4096
    print(f"    [read {tag}] 请求 {size:,}B -> 实得 {len(data):,}B  页内偏移={inpage}  "
          f"dd输出: {r.strip()[-80:]}", flush=True)
    # dd 从页首开始读，目标可能在页中间，切掉页内前缀
    if inpage:
        data = data[inpage:]
    return data


def main() -> int:
    ap = argparse.ArgumentParser(description="内核视角脱壳")
    ap.add_argument("--outdir", default="work/kernelview")
    ap.add_argument("--seconds", type=float, default=40.0)
    args = ap.parse_args()

    outdir = pathlib.Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    for old in outdir.glob("*.bin"):
        old.unlink()

    first = {}
    ev = threading.Event()

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
            if not first:
                first.update(p)
                ev.set()     # 立刻唤醒读取线程

    dev = frida.get_usb_device(timeout=20)
    print(f"[*] 设备 {dev.name}", flush=True)
    pid = dev.spawn([PKG])
    print(f"[*] spawn pid={pid}", flush=True)
    session = dev.attach(pid)

    script = session.create_script(BUNDLE.read_text())
    script.on("message", on_message)
    script.load()
    dev.resume(pid)
    print("[*] 已 resume，等待应用类定义 ...", flush=True)

    # 等待第一个 DexFile 地址（最多 25 秒）
    if not ev.wait(timeout=25):
        print("[!] 未等到 DexFile 地址", flush=True)
        try:
            session.detach()
        except Exception:
            pass
        return 1

    addr = int(first["addr"], 16)
    print(f"\n[*] 首个 DexFile& = {first['addr']}  触发类 = {first['desc']}", flush=True)

    # 立刻读取（不等）
    hdr = read_mem(pid, addr, 4096, "dexfile_obj", outdir)
    if len(hdr) < 16:
        print("[!] DexFile 对象读取失败", flush=True)
        try:
            session.detach()
        except Exception:
            pass
        return 1
    # 本机 Android 9 的 art::DexFile 布局与教科书不同：offset 0 不是 begin_，
    # offset 8 才是指向 "dex\n038" 数据的指针（实测逐字段探测得出）。
    # 因此不按固定偏移解析，而是扫描对象前 64 字节里所有像指针的字段，
    # 取第一个指向 dex/cdex magic 的作为 DEX 起点。
    begin = 0
    for off in range(0, 64, 8):
        v = struct.unpack_from("<Q", hdr, off)[0]
        if not (0x10000000 <= v <= 0x8000000000):
            continue
        probe = read_mem(pid, v, 4096, f"probe_{off}", outdir)
        if probe[:4] in (b"dex\n", b"cdex"):
            begin = v
            print(f"[*] 找到 DEX：DexFile 对象 offset {off} -> {v:#x} "
                  f"magic={probe[:8]!r}", flush=True)
            break
    if not begin:
        print("[!] 未在 DexFile 对象中找到 DEX 指针；对象前 64 字节:", flush=True)
        print("   ", hdr[:64].hex(), flush=True)
        try:
            session.detach()
        except Exception:
            pass
        return 1

    head = read_mem(pid, begin, 4096, "dex_head", outdir)
    if head[:4] == b"dex\n":
        size = struct.unpack_from("<I", head, 0x20)[0]
    else:
        size = struct.unpack_from("<I", head, 0x20)[0]
    print(f"[*] DEX 版本={head[4:8]!r} file_size={size:,} "
          f"classes={struct.unpack_from('<I', head, 0x60)[0]:,} "
          f"strings={struct.unpack_from('<I', head, 0x38)[0]:,}", flush=True)
    if not (4096 < size <= 300 * 1024 * 1024):
        print("[!] file_size 不合理", flush=True)
        try:
            session.detach()
        except Exception:
            pass
        return 1

    blob = read_mem(pid, begin, size, "app_dex", outdir)
    out = outdir / f"app_{size}.dex"
    out.write_bytes(blob)
    print(f"\n[√] 已导出 {out}  {len(blob):,}B", flush=True)
    if blob[:4] == b"dex\n":
        print(f"    fileSize={struct.unpack_from('<I', blob, 0x20)[0]:,} "
              f"strings={struct.unpack_from('<I', blob, 0x38)[0]:,} "
              f"classes={struct.unpack_from('<I', blob, 0x60)[0]:,}", flush=True)

    try:
        session.detach()
    except Exception:
        pass
    return 0


if __name__ == "__main__":
    sys.exit(main())
