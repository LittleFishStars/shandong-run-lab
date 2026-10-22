#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""在 Android 设备上按 /proc/<pid>/maps 分片 dump 目标进程内存，并切出内嵌的 DEX。

为什么用这个方法：
    网易易盾壳会在解壳后主动 System.exit(0)（反调试自毁），磁盘上留不下完整 DEX。
    但明文 DEX 在退出前已存在于进程内存里，因此直接读 /proc/<pid>/mem 即可取得。
    本方法只依赖 adb root（userdebug 镜像）+ /proc，不需要 frida-server（无需下载大文件）。

实现要点：
    - 通过 `adb shell` 起一个设备端 dd 流水线会因多次往返而慢；改为在设备上执行一条
      自包含的 shell 脚本：解析 maps、对每个可读区域 dd 出来、再用本地脚本扫描 DEX。
    - 只在设备上落地原始区域，扫描与提取在本地做（速度快、可复现）。

用法:
    python3 scripts/dump_proc_mem.py --package com.huachenjie.shandong_school \
        --activity com.huachenjie.shandong_school.splash.SplashActivity \
        --outdir work/memdump --watch 12
"""

from __future__ import annotations

import argparse
import os
import re
import subprocess
import sys
import time
from pathlib import Path

ADB = os.environ.get("ADB_BIN", os.path.expanduser("~/Android/Sdk/platform-tools/adb"))


def sh(args: list[str], timeout: int = 60, binary: bool = False):
    """执行 adb 命令。"""
    p = subprocess.run([ADB] + args, capture_output=True, timeout=timeout)
    return p.stdout if binary else p.stdout.decode("utf-8", "replace")


def find_pid(package: str) -> int | None:
    out = sh(["shell", f"pidof {package}"], timeout=30)
    out = out.strip()
    if not out:
        return None
    try:
        return int(out.split()[0])
    except ValueError:
        return None


# 设备端脚本：把 pid 的所有可读区域按 maps 顺序拼接 dump 成一个文件
DEVICE_SCRIPT = r"""
PID="$1"; OUT="$2"
: > "$OUT"
# 只取 r--/rw-/r-x 且路径不是 [vvar]/[vsyscall] 的区域，跳过巨大的匿名空洞
awk '$2 ~ /r/ { split($1, a, "-"); print strtonum("0x" a[1]), strtonum("0x" a[2]), $6 }' /proc/$PID/maps |
while read START END NAME; do
  SIZE=$((END - START))
  # 跳过 >64MB 的单块（多为图形/媒体缓冲，无 DEX）以控制体积
  [ "$SIZE" -gt 67108864 ] && continue
  printf '=== %x %x %s\n' "$START" "$SIZE" "$NAME" >> "$OUT"
  dd if=/proc/$PID/mem bs=4096 iflag=skip_bytes,count_bytes \
     skip=$START count=$SIZE >> "$OUT" 2>/dev/null || true
done
echo "DONE $(wc -c < "$OUT")"
"""


def main() -> int:
    ap = argparse.ArgumentParser(description="dump Android 进程内存并提取 DEX")
    ap.add_argument("--package", required=True)
    ap.add_argument("--activity", required=True)
    ap.add_argument("--outdir", required=True)
    ap.add_argument("--watch", type=float, default=12.0,
                    help="启动后持续监听秒数（壳会自毁，需在窗口内抓取）")
    ap.add_argument("--rounds", type=int, default=3, help="最多尝试轮数")
    args = ap.parse_args()

    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)

    for rnd in range(1, args.rounds + 1):
        print(f"\n=== 第 {rnd} 轮 ===")
        sh(["shell", f"am force-stop {args.package}"], timeout=30)
        time.sleep(1)
        out = sh(["shell", f"am start -n {args.package}/{args.activity}"], timeout=60)
        print("  启动:", out.strip().splitlines()[0] if out.strip() else "(无输出)")

        # 尽快抓到 pid，并在其存活窗口内 dump
        deadline = time.time() + args.watch
        pid = None
        while time.time() < deadline:
            pid = find_pid(args.package)
            if pid:
                break
            time.sleep(0.3)
        if not pid:
            print("  [!] 未抓到 pid")
            continue
        print(f"  pid={pid}，开始 dump（限时 {args.watch}s）")

        dev_out = f"/data/local/tmp/memdump_{pid}.bin"
        script = f"/data/local/tmp/dumper.sh"
        # 用 base64 传脚本，避免引号/换行在多层 shell 中被吞
        import base64
        b64 = base64.b64encode(DEVICE_SCRIPT.encode()).decode()
        sh(["shell", f"echo {b64} | base64 -d > {script} && chmod 755 {script}"], timeout=60)

        t0 = time.time()
        try:
            res = sh(["shell", f"sh {script} {pid} {dev_out}"], timeout=int(args.watch) + 30)
            print("  设备端:", res.strip()[-80:])
        except subprocess.TimeoutExpired:
            print("  [!] 设备端 dump 超时（进程可能已退出），仍尝试取回已有内容")
        local = outdir / f"mem_{pid}.bin"
        sh(["pull", dev_out, str(local)], timeout=300)
        sh(["shell", f"rm -f {dev_out}"], timeout=30)
        if local.exists():
            print(f"  本地: {local}  {local.stat().st_size:,} B  ({time.time()-t0:.1f}s)")
            # 统计内嵌 DEX
            blob = local.read_bytes()
            magics = [m.start() for m in re.finditer(rb"dex\n03[5-9]", blob)]
            print(f"  内嵌 DEX magic: {len(magics)} 个")
            if magics:
                print(f"  -> 前 5 个偏移: {magics[:5]}")
                # 把每个 DEX 的头部信息打印出来，便于挑选
                import struct
                for off in magics[:12]:
                    if off + 112 > len(blob):
                        continue
                    fs = struct.unpack_from("<I", blob, off + 0x20)[0]
                    s_ids, s_off = struct.unpack_from("<II", blob, off + 0x38)
                    cds = struct.unpack_from("<I", blob, off + 0x60)[0]
                    ok = off + fs <= len(blob)
                    print(f"     @{off:,} file_size={fs:,} strings={s_ids:,} "
                          f"class_defs={cds:,} {'完整' if ok else '截断'}")
                return 0
        time.sleep(1)
    print("\n[!] 各轮均未取得 DEX")
    return 1


if __name__ == "__main__":
    sys.exit(main())
