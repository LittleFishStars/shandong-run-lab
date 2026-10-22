#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""在易盾壳自毁(System.exit)前的存活窗口内，dump 目标进程内存并提取明文 DEX。

背景：
    该 APK 被网易易盾加固。壳解出明文 DEX 放进内存后，会因环境检测主动
    System.exit(0)（不是崩溃、无 FATAL），因此磁盘上留不下 DEX。
    进程存活窗口实测约 7 秒，必须在窗口内抓取。

方法：
    1. am start 应用，轮询 pidof 抢到 pid；
    2. 读取 /proc/<pid>/maps，筛出「可能含 DEX」的区域：
       - 匿名 rw-p / r--p / r-xp（解出的 DEX 常被 mmap 成匿名段）
       - 任何名字里带 dex / dalvik / extracted 的段
       - 排除巨大的图形/保留区（>200MB）与纯 ---p 段
    3. 逐区域用 dd 读取（iflag=skip_bytes,count_bytes），失败的段跳过继续；
    4. 本地扫描 dex\\n035 magic，校验头部自洽性并导出可反编译的 DEX。

用法:
    python3 scripts/dump_dex_from_mem.py --outdir work/memdump
"""

from __future__ import annotations

import argparse
import re
import struct
import subprocess
import sys
import time
from pathlib import Path

ADB = str(Path.home() / "Android/Sdk/platform-tools/adb")
PKG = "com.huachenjie.shandong_school"
ACT = "com.huachenjie.shandong_school.splash.SplashActivity"

# DEX 头里的关键字段偏移
OFF_FILE_SIZE = 0x20
OFF_STR_SIZE, OFF_STR_OFF = 0x38, 0x3C
OFF_TYPE_SIZE = 0x40
OFF_CLASS_DEFS = 0x60
OFF_DATA_SIZE, OFF_DATA_OFF = 0x68, 0x6C


def adb(args: list[str], timeout: int = 120, binary: bool = False):
    p = subprocess.run([ADB] + args, capture_output=True, timeout=timeout)
    return p.stdout if binary else p.stdout.decode("utf-8", "replace")


def get_pid() -> int | None:
    out = adb(["shell", f"pidof {PKG}"], timeout=20).strip()
    if not out:
        return None
    try:
        return int(out.split()[0])
    except ValueError:
        return None


def parse_maps(pid: int) -> list[tuple[int, int, str, str]]:
    txt = adb(["shell", f"cat /proc/{pid}/maps"], timeout=60)
    out = []
    for line in txt.splitlines():
        m = re.match(r"^([0-9a-f]+)-([0-9a-f]+)\s+(\S{4})\s+\S+\s+\S+\s+\S+\s*(.*)$", line)
        if not m:
            continue
        start, end = int(m.group(1), 16), int(m.group(2), 16)
        out.append((start, end, m.group(3), m.group(4).strip()))
    return out


def interesting(start: int, end: int, perm: str, name: str) -> bool:
    """挑选可能承载明文 DEX 的区域。"""
    if "p" not in perm:                 # 必须有私有（已修改）语义
        return False
    if perm.startswith("---"):
        return False
    size = end - start
    if size > 256 * 1024 * 1024:        # 超大保留/图形区，跳过
        return False
    if size < 4096:
        return False
    low = name.lower()
    if any(k in low for k in ("dex", "dalvik", "extracted", "base.apk", "jar")):
        return True
    # 匿名段（无路径）是解壳后 DEX 最常见的落点
    if name == "" or name.startswith("[anon"):
        return True
    if "/data/data/" in name or "/data/user/" in name:
        return True
    return False


def dump_region(pid: int, start: int, size: int, dest: Path) -> bool:
    """用 dd 精确读取 [start, start+size)，成功返回 True。"""
    # 设备端 dd：skip_bytes/count_bytes 直接按字节定位（toybox 支持）
    cmd = (f"dd if=/proc/{pid}/mem of={dest} bs=4096 "
           f"iflag=skip_bytes,count_bytes skip={start} count={size} "
           f"conv=noerror 2>/dev/null; wc -c < {dest}")
    try:
        out = adb(["shell", cmd], timeout=180).strip()
        return out.isdigit() and int(out) > 0
    except subprocess.TimeoutExpired:
        return False


def valid_dex_head(blob: bytes, off: int) -> tuple[bool, int, int]:
    """校验偏移处 DEX 头是否自洽，返回 (是否可信, file_size, class_defs)。"""
    if off + 112 > len(blob):
        return False, 0, 0
    try:
        file_size = struct.unpack_from("<I", blob, off + OFF_FILE_SIZE)[0]
        str_size = struct.unpack_from("<I", blob, off + OFF_STR_SIZE)[0]
        str_off = struct.unpack_from("<I", blob, off + OFF_STR_OFF)[0]
        type_size = struct.unpack_from("<I", blob, off + OFF_TYPE_SIZE)[0]
        class_defs = struct.unpack_from("<I", blob, off + OFF_CLASS_DEFS)[0]
        endian = struct.unpack_from("<I", blob, off + 0x28)[0]
    except struct.error:
        return False, 0, 0
    ok = (endian == 0x12345678 and 112 < file_size <= len(blob) - off
          and 0 < str_size < 5_000_000 and str_off < file_size
          and 0 < type_size < 5_000_000)
    return ok, file_size, class_defs


def main() -> int:
    ap = argparse.ArgumentParser(description="dump 进程内存并提取明文 DEX")
    ap.add_argument("--outdir", default="work/memdump")
    ap.add_argument("--watch", type=float, default=14.0, help="抓取窗口秒数")
    ap.add_argument("--rounds", type=int, default=4)
    args = ap.parse_args()

    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    dev_tmp = "/data/local/tmp"

    for rnd in range(1, args.rounds + 1):
        print(f"\n===== 第 {rnd} 轮 =====", flush=True)
        adb(["shell", f"am force-stop {PKG}"], timeout=30)
        time.sleep(0.8)
        adb(["shell", f"am start -n {PKG}/{ACT}"], timeout=60)

        t_start = time.time()
        pid = None
        while time.time() - t_start < args.watch:
            pid = get_pid()
            if pid:
                break
            time.sleep(0.15)
        if not pid:
            print("  [!] 未抓到 pid")
            continue
        print(f"  pid={pid} (启动后 {time.time()-t_start:.2f}s)", flush=True)

        regions = parse_maps(pid)
        picked = [(s, e, p, n) for (s, e, p, n) in regions if interesting(s, e, p, n)]
        total = sum(e - s for s, e, _, _ in picked)
        print(f"  maps {len(regions)} 段 -> 选中 {len(picked)} 段, 合计 {total/1048576:.1f} MB", flush=True)

        # 按大小降序，优先抓大块（DEX 通常不大但先抓最可能目标）
        picked.sort(key=lambda r: -(r[1] - r[0]))
        blob = bytearray()
        index: list[tuple[int, int, int, str]] = []    # (在 blob 的偏移, start, size, name)

        for i, (s, e, p, n) in enumerate(picked):
            if time.time() - t_start > args.watch + 20:
                print(f"  [!] 超时，已抓 {i} 段", flush=True)
                break
            size = e - s
            dev_out = f"{dev_tmp}/r{i}.bin"
            if not dump_region(pid, s, size, dev_out):
                continue
            # 把该段拉回本地
            local = outdir / f"r{i}.bin"
            adb(["pull", dev_out, str(local)], timeout=180)
            adb(["shell", f"rm -f {dev_out}"], timeout=30)
            if local.exists() and local.stat().st_size:
                data = local.read_bytes()
                index.append((len(blob), s, len(data), n))
                blob += data
                local.unlink()          # 立即清理，避免占满磁盘
            if time.time() - t_start > args.watch + 20:
                break

        alive = get_pid()
        print(f"  抓取完成, blob={len(blob):,} B, 进程{'仍存活' if alive else '已退出'}", flush=True)
        (outdir / f"blob_{rnd}.bin").write_bytes(blob)

        # 扫描 DEX
        magics = [m.start() for m in re.finditer(rb"dex\n03[5-9]", blob)]
        print(f"  dex magic: {len(magics)} 个", flush=True)
        found = 0
        for off in magics:
            ok, fsize, cdefs = valid_dex_head(blob, off)
            if not ok:
                continue
            # 找它属于哪一段（用于对齐修正）
            seg = None
            for boff, sstart, slen, sname in index:
                if boff <= off < boff + slen:
                    seg = (boff, sstart, slen, sname)
                    break
            out_dex = outdir / f"dex_{rnd}_{off}.dex"
            out_dex.write_bytes(blob[off:off + fsize])
            found += 1
            print(f"    -> {out_dex.name}  {fsize:,} B  class_defs={cdefs:,}"
                  f"  [{seg[3][:60] if seg else '?'}]", flush=True)
        if found:
            print(f"  [√] 本轮导出 {found} 个 DEX", flush=True)
            return 0
    print("\n[!] 未取到自洽 DEX")
    return 1


if __name__ == "__main__":
    sys.exit(main())
