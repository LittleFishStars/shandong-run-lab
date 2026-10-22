#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""设备端扫描进程内存提取明文 DEX（适配易盾 3.8s 自毁窗口）。

设计（针对实测约束优化）：
    * 壳解出 DEX 后约 3.8s 执行 System.exit(0)，且 ART 堆 >1.4GB —— 不可能整份回传。
    * 因此把扫描放到设备端：用一个**设备端 Python 脚本**（Android 自带 toybox 无 python，
      故改为 mksh + dd + 十六进制比较，避免依赖 grep 对二进制/换行的支持）。
    * 命中后只回传该 DEX（通常 1~15MB），传输量可控。

设备端做法（纯 mksh + dd）：
    1. 从 /proc/<pid>/maps 取候选区间（匿名 rw/r、dalvik、dex）；
    2. 对每个区间按 1MB 分块 dd 出来，用 `od` 检查首 4 字节是否为 64 65 78 0a（"dex\n"）；
    3. 命中则读 file_size（偏移 0x20 的 u32），把整份 DEX dd 到输出；
    4. 主控端只拉取输出目录。

用法:
    python3 scripts/dump_dex_onside.py --outdir work/memdump2
"""

from __future__ import annotations

import argparse
import base64
import subprocess
import sys
import time
from pathlib import Path

ADB = str(Path.home() / "Android/Sdk/platform-tools/adb")
PKG = "com.huachenjie.shandong_school"
ACT = "com.huachenjie.shandong_school.splash.SplashActivity"

# 设备端 mksh 脚本：按 1MB 步进扫描候选区间，发现 dex magic 就整份导出
SIDE = r'''
#!/system/bin/sh
PID="$1"; OUT="$2"
mkdir -p "$OUT"; rm -f "$OUT"/*

cat /proc/$PID/maps | while read LINE; do
  set -- $LINE
  RANGE="$1"; PERM="$2"
  case "$PERM" in *r*) ;; *) continue;; esac
  START_HEX="${RANGE%-*}"
  END_HEX="${RANGE#*-}"
  START=$((0x$START_HEX)); END=$((0x$END_HEX))
  SIZE=$((END - START))
  [ "$SIZE" -lt 4096 ] && continue
  [ "$SIZE" -gt 268435456 ] && continue
  # 只扫可能位置：匿名、dalvik、dex
  NAME="$6"
  case "$NAME" in
    ""|*anon*|*dalvik*|*dex*|*jar*) ;;
    *) continue;;
  esac
  OFF=0
  while [ "$OFF" -lt "$SIZE" ]; do
    CHUNK=1048576
    [ $((OFF + CHUNK)) -gt "$SIZE" ] && CHUNK=$((SIZE - OFF))
    # 读该块首 8 字节做 magic 判定
    HDR=$(dd if=/proc/$PID/mem bs=8 iflag=skip_bytes,count_bytes skip=$((START+OFF)) count=8 2>/dev/null | od -An -tx1 | tr -d ' \n')
    case "$HDR" in
      6465780a303335*|6465780a303336*|6465780a303337*|6465780a303338*|6465780a303339*)
        # 读 file_size（偏移 0x20，u32 LE）
        FS=$(dd if=/proc/$PID/mem bs=4 iflag=skip_bytes,count_bytes skip=$((START+OFF+32)) count=4 2>/dev/null | od -An -tu4 | tr -d ' ')
        if [ -n "$FS" ] && [ "$FS" -ge 4096 ] && [ "$FS" -le 268435456 ]; then
          dd if=/proc/$PID/mem bs=65536 iflag=skip_bytes,count_bytes skip=$((START+OFF)) count=$FS 2>/dev/null > "$OUT/d_${START}_${OFF}.dex"
          echo "GOT start=$START off=$OFF size=$FS" >> "$OUT/got.txt"
        fi
        ;;
    esac
    OFF=$((OFF + CHUNK))
  done
done
echo "DONE" >> "$OUT/got.txt"
'''


def adb(args, timeout=180, binary=False):
    p = subprocess.run([ADB] + args, capture_output=True, timeout=timeout)
    return p.stdout if binary else p.stdout.decode("utf-8", "replace")


def main() -> int:
    ap = argparse.ArgumentParser(description="设备端扫描内存提取 DEX")
    ap.add_argument("--outdir", default="work/memdump2")
    ap.add_argument("--settle", type=float, default=10.0)
    ap.add_argument("--rounds", type=int, default=3)
    args = ap.parse_args()

    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    dev = "/data/local/tmp/dexscan"

    b64 = base64.b64encode(SIDE.encode()).decode()
    adb(["shell", f"echo {b64} | base64 -d > /data/local/tmp/scan.sh && chmod 755 /data/local/tmp/scan.sh"],
        timeout=60)

    for rnd in range(1, args.rounds + 1):
        print(f"\n===== 第 {rnd} 轮 =====", flush=True)
        adb(["shell", f"rm -rf {dev}"], timeout=30)
        adb(["shell", f"am force-stop {PKG}"], timeout=30)
        time.sleep(0.6)

        launch = (
            f"am start -n {PKG}/{ACT} >/dev/null 2>&1; "
            f"n=0; while [ $n -lt 80 ]; do P=$(pidof {PKG}); "
            f"if [ -n \"$P\" ]; then sh /data/local/tmp/scan.sh $P {dev} >/dev/null 2>&1 & echo \"PID=$P\"; break; fi; "
            f"n=$((n+1)); sleep 0.05; done"
        )
        t0 = time.time()
        out = adb(["shell", launch], timeout=60).strip()
        print(f"  {out}  (抢到耗时 {time.time()-t0:.2f}s)", flush=True)
        time.sleep(args.settle)

        local = outdir / f"round{rnd}"
        local.mkdir(parents=True, exist_ok=True)
        adb(["pull", dev, str(local)], timeout=600)
        d = local / "dexscan"
        if d.is_dir():
            got = d / "got.txt"
            if got.exists():
                for line in got.read_text(errors="replace").splitlines():
                    print("   ", line, flush=True)
            dexs = sorted(d.glob("*.dex"))
            print(f"  回传 {len(dexs)} 个文件, 合计 {sum(f.stat().st_size for f in dexs)/1048576:.1f} MB", flush=True)
            for f in dexs[:12]:
                print(f"    {f.name}  {f.stat().st_size:,} B", flush=True)
            if dexs:
                return 0
        else:
            print("  [!] 设备端未产出目录", flush=True)
    return 1


if __name__ == "__main__":
    sys.exit(main())
