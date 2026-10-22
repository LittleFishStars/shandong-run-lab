#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""从外部 dump 应用进程里的匿名可执行段（liby.so 的真实落点）。

背景（本项目实测）：
  * `signRequest` 能正常调用，但 `Process.findModuleByName('liby.so')` 找不到；
  * `/proc/<pid>/maps` 里**只有 libnesec.so，没有 liby.so**；
  * 却存在 1.15 MB 的匿名可执行段 `[anon:.bss]`（r-xp，无路径名）。

结论：易盾壳用自己的「自定义 linker」加载了 liby.so，映射为**匿名段并抹掉
文件名**，因此按名字找不到。要分析它必须：
    ① 定位匿名可执行段
    ② 用 /proc/<pid>/mem 整段 dump（需 SIGSTOP；dd 页数要计入页内偏移）
    ③ 在 dump 出的镜像里找密码学常量（运行时已解密，静态文件里搜不到）

用法:
    python3 scripts/dump_anon_exec.py --outdir work/dumps/liby_dump
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
    """从 /proc/<pid>/mem 读一段（先 SIGSTOP；页数计入页内偏移）。"""
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
    if data and inpage:
        data = data[inpage:]
    if f.exists():
        f.unlink()
    return data


# 密码学常量签名（运行时扫描用）
SIGS = {
    "MD5-IV": "01234567", "MD5-T1": "78a46ad7", "MD5-T2": "56b7c7e8",
    "SHA1-IV": "01234567", "SHA256-IV-A": "67e6096a", "SHA256-IV-B": "85ae67bb",
    "SHA256-K0": "982f8a42", "SM3-IV-0": "6f168073", "SM3-IV-1": "b9b21449",
    "SM3-T0": "1945cc79", "AES-Te0": "a56363c6", "AES-Sbox": "637c777bf26b6fc5",
    "SM4-FK": "a3b1bac6", "SM4-CK0": "00070e15",
    "BASE64-表": "4142434445464748", "RSA-65537": "010001",
    "PEM-BEGIN": "2d2d2d2d2d424547494e",
    "SM2-p-高位": "fffffffeffffffff",
}


def main() -> int:
    ap = argparse.ArgumentParser(description="dump 匿名可执行段（liby.so 落点）")
    ap.add_argument("--outdir", default="work/dumps/liby_dump")
    ap.add_argument("--min-mb", type=float, default=0.1, help="只 dump 大于此大小的段")
    args = ap.parse_args()

    outdir = pathlib.Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    for f in outdir.glob("*"):
        if f.is_file():
            f.unlink()

    # 启动并等进程稳定
    adb(["shell", "am", "force-stop", PKG])
    time.sleep(0.5)
    adb(["shell", "am", "start", "-n", f"{PKG}/.splash.SplashActivity"])
    print("[*] 已启动应用，等待进程 ...", flush=True)

    pid = None
    for _ in range(60):
        out = adb(["shell", "su", "-c", f"pidof {PKG}"]).strip()
        if out:
            pid = int(out.split()[0])
            break
        time.sleep(0.5)
    if not pid:
        print("[!] 未拿到 pid", flush=True)
        return 1
    print(f"[*] pid = {pid}", flush=True)

    maps = adb(["shell", "su", "-c", f"cat /proc/{pid}/maps"])
    (outdir / "maps.txt").write_text(maps, encoding="utf-8")

    # 收集匿名可执行段（r-xp 且无路径名 / 只有 [anon:*]）
    cands = []
    for line in maps.splitlines():
        m = re.match(r"^([0-9a-f]+)-([0-9a-f]+)\s+(\S{4})\s+\S+\s+\S+\s+\S+\s*(.*)$", line)
        if not m:
            continue
        s, e, perm, name = int(m.group(1), 16), int(m.group(2), 16), m.group(3), m.group(4).strip()
        if "x" not in perm:
            continue
        if name and not name.startswith("[anon"):
            continue                      # 有真实路径名 → 不是我们找的
        if name in ("[vdso]", "[vectors]"):
            continue
        size = e - s
        if size < args.min_mb * 1024 * 1024:
            continue
        cands.append((s, size, name or "(无名)"))

    print(f"[*] 匿名可执行段: {len(cands)} 个（>{args.min_mb}MB）", flush=True)
    for s, size, nm in cands:
        print(f"    {s:#x}  {size / 1024 / 1024:8.2f} MB  {nm}", flush=True)

    saved = 0
    for idx, (s, size, nm) in enumerate(cands, 1):
        print(f"\n[*] dump #{idx}  {s:#x}  {size:,} B  {nm}", flush=True)
        blob = read_mem(pid, s, size, f"seg{idx}", outdir)
        if not blob:
            print("    读取失败", flush=True)
            continue
        out = outdir / f"anon_{idx}_{s:x}_{size}.bin"
        out.write_bytes(blob)
        saved += 1

        # 就地扫常量
        hits = []
        for k, v in SIGS.items():
            pat = bytes.fromhex(v)
            n = blob.count(pat)
            if n:
                hits.append(f"{k}×{n}@{blob.find(pat):#x}")
        print(f"    ✓ 写出 {out.name}  ({len(blob):,} B)", flush=True)
        print(f"    常量: {'; '.join(hits) if hits else '（无标准常量）'}", flush=True)

        # 找 ELF 头（可能被抹）
        elf = blob.find(b"\x7fELF")
        print(f"    ELF 头: {elf if elf >= 0 else '未找到（已被抹除）'}", flush=True)

    print(f"\n[*] 共 dump {saved} 段到 {outdir}", flush=True)
    return 0 if saved else 1


if __name__ == "__main__":
    sys.exit(main())
