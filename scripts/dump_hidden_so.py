#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""dump 钓到的隐藏 SO 区间（mmap/mprotect 钓鱼法的落地步骤）。

依据（看雪《Frida 企业级加固对抗实战》）：壳绕开系统 linker 私自加载真实 SO，
但它无法绕过 mmap/mprotect —— 隐藏 SO 完成 mmap 后必紧跟一次 mprotect→RX。
本脚本接收 Frida 报出的 RX 区间地址，从 /proc/<pid>/mem 整段 dump。

用法:
    python3 scripts/dump_hidden_so.py --addr 0x7cb2e15000 --size 893000 --outdir work/hidden_so
"""

from __future__ import annotations

import argparse
import pathlib
import re
import struct
import subprocess
import sys
import time

ADB = str(pathlib.Path.home() / "Android/Sdk/platform-tools/adb")
PKG = "com.huachenjie.shandong_school"


def adb(args, timeout=300):
    p = subprocess.run([ADB] + args, capture_output=True, text=True, timeout=timeout)
    return p.stdout


def read_mem(pid: int, addr: int, size: int, tag: str, outdir: pathlib.Path) -> bytes:
    inpage = addr % 4096
    blk = addr // 4096
    cnt = (size + inpage + 4095) // 4096
    name = f"{tag}.bin"
    adb(["shell", "su", "-c", f"kill -STOP {pid}"])
    r = adb(["shell", "su", "-c",
             f"dd if=/proc/{pid}/mem of=/data/local/tmp/{name} bs=4096 skip={blk} count={cnt} 2>&1 | tail -1"])
    adb(["shell", "su", "-c", f"kill -CONT {pid}"])
    adb(["shell", "su", "-c", f"chmod 666 /data/local/tmp/{name} 2>/dev/null"])
    adb(["pull", f"/data/local/tmp/{name}", str(outdir / name)])
    adb(["shell", "su", "-c", f"rm -f /data/local/tmp/{name}"])
    f = outdir / name
    data = f.read_bytes() if f.exists() else b""
    if f.exists():
        f.unlink()
    print(f"    请求 {size:,}B → 实得 {len(data):,}B   {r.strip()[-60:]}", flush=True)
    return data[inpage:] if data else b""


def main() -> int:
    ap = argparse.ArgumentParser(description="dump 隐藏 SO")
    ap.add_argument("--addr", required=True, help="RX 区间起始地址（十六进制）")
    ap.add_argument("--size", type=int, required=True, help="区间大小（字节）")
    ap.add_argument("--outdir", default="work/hidden_so")
    ap.add_argument("--pid", default=None, help="指定 pid（默认取应用首个）")
    args = ap.parse_args()

    outdir = pathlib.Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)

    addr = int(args.addr, 16)

    pid = args.pid
    if not pid:
        for _ in range(40):
            out = adb(["shell", "su", "-c", f"pidof {PKG}"]).strip()
            if out:
                pid = out.split()[0]
                break
            time.sleep(0.5)
    if not pid:
        print("[!] 未拿到 pid", flush=True)
        return 1
    pid = int(pid)
    print(f"[*] pid={pid}  目标 {addr:#x}  {args.size:,} B", flush=True)

    # 先看 maps 里该区间长什么样
    maps = adb(["shell", "su", "-c", f"cat /proc/{pid}/maps"])
    (outdir / "maps.txt").write_text(maps, encoding="utf-8")
    print("[*] 该地址附近的 maps 条目:", flush=True)
    for line in maps.splitlines():
        m = re.match(r"^([0-9a-f]+)-([0-9a-f]+)", line)
        if not m:
            continue
        s, e = int(m.group(1), 16), int(m.group(2), 16)
        if s - 0x20000 <= addr <= e + 0x20000:
            print("   ", line[:120], flush=True)

    blob = read_mem(pid, addr, args.size, "hidden", outdir)
    if not blob:
        print("[!] 读取失败", flush=True)
        return 1

    out = outdir / f"hidden_{addr:x}_{args.size}.bin"
    out.write_bytes(blob)
    print(f"\n[√] 写出 {out}  ({len(blob):,} B)", flush=True)

    # 基础特征
    elf = blob.find(b"\x7fELF")
    print(f"    ELF 头: {hex(elf) if elf >= 0 else '未找到（已抹）'}", flush=True)
    import collections, math
    c = collections.Counter(blob)
    H = -sum((v/len(blob))*math.log2(v/len(blob)) for v in c.values())
    print(f"    熵: {H:.4f}", flush=True)

    # 密码学常量
    SIGS = {
        "MD5-T1": "78a46ad7", "MD5-T2": "56b7c7e8",
        "SHA256-K0": "982f8a42", "SM3-T0": "1945cc79",
        "AES-Te0": "a56363c6", "AES-Sbox": "637c777bf26b6fc5",
        "SM4-FK": "a3b1bac6", "BASE64": "4142434445464748",
    }
    hits = []
    for k, v in SIGS.items():
        pat = bytes.fromhex(v)
        n = blob.count(pat)
        if n:
            hits.append(f"{k}×{n}")
    print(f"    密码学常量: {'; '.join(hits) if hits else '（无）'}", flush=True)

    # 可打印字符串抽样
    strs = re.findall(rb"[\x20-\x7e]{8,}", blob)
    print(f"    可打印串(>=8): {len(strs)}", flush=True)
    for x in strs[:15]:
        print("      ", x.decode("ascii", "replace")[:100], flush=True)

    return 0


if __name__ == "__main__":
    sys.exit(main())
