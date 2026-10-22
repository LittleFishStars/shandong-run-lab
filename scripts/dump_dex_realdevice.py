#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""在真机（arm64 + Magisk root）上，于易盾壳自毁前抓取内存中的明文 DEX。

与模拟器的差异（真机更有利）：
    * 真机是 arm64，壳走它设计时预期的 libnesec.so 路径（无 x86 分支、无转译）；
    * 生命周期实测约 10 秒（比模拟器 3.8s 宽裕），且 root 由 Magisk 提供；
    * Magisk su 可直接读 /proc/<pid>/mem，无需 adb root（retail 机器 adb root 不可用）。

策略（避免大流量传输）：
    1. 设备端先用 `su -c` 起一个后台扫描器，按 maps 找候选段；
    2. 用 dd 流式读入，逐 1MB 块用 od 检查块首是否为 dex magic（避免 grep 对二进制支持问题）；
    3. 命中则读 file_size 整份切出到 /data/local/tmp/dexout/；
    4. 主机只 pull 出命中文件。

用法:
    python3 scripts/dump_dex_realdevice.py --outdir work/realdump
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
DEV = "/data/local/tmp/dexout"

# 设备端脚本（以 root 运行）：扫描候选区间，按块检查 dex magic 并整份导出。
# 注意：用 `blocks` 而非逐字节，兼顾速度与覆盖（每块 1MB，块内用 od 只查块首不够，
# 因此再对整块做一次 `grep -abo` 兜底 —— toybox grep 支持 -a 二进制模式）。
SIDE = r'''
#!/system/bin/sh
# 易盾壳自毁前抓内存 DEX。要点（全部经真机实测确认）：
#   1) Android 9 内核：读 /proc/<pid>/mem 前必须 SIGSTOP 目标，否则 EIO；
#   2) toybox dd 的 skip 是「块号」而非字节，配合 bs=4096 可达 ~68MB/s（bs=1 仅 ~2MB/s）；
#   3) toybox awk 无 strtonum；mksh 的 $((0x...)) 是 32 位会溢出 -> 用 printf '%d' 解析 64 位地址；
#   4) toybox sort 不认 -k 且 `sort -o f f` 会清空文件 -> 不做排序，逐段顺序处理。
if [ -f /data/local/tmp/scan.args ]; then . /data/local/tmp/scan.args; fi
[ -n "$1" ] && PID="$1"
[ -n "$2" ] && OUT="$2"
[ -z "$PID" ] && exit 1
[ -z "$OUT" ] && OUT=/data/local/tmp/dexout
rm -rf "$OUT"; mkdir -p "$OUT"
touch "$OUT/got.txt"

kill -STOP "$PID" 2>/dev/null
trap 'kill -CONT '"$PID"' 2>/dev/null' EXIT INT TERM

BS=4096
: > "$OUT/regions.txt"
while read -r LINE; do
  set -- $LINE
  RANGE="$1"; PERM="$2"
  case "$PERM" in *r*) ;; *) continue;; esac
  START=$(printf '%d' "0x${RANGE%-*}")
  END=$(printf '%d' "0x${RANGE#*-}")
  SZ=$((END - START))
  [ "$SZ" -lt 4096 ] && continue
  # 只处理合理的用户空间地址（< 512GB）与不超过 64MB 的段
  [ "$START" -gt 549755813888 ] && continue
  [ "$SZ" -gt 67108864 ] && continue
  echo "$START $SZ" >> "$OUT/regions.txt"

  # 逐 1MB 分块扫描；块内用 hexdump 转 hex 后搜 dex magic
  GOT=0
  NB=$(( (SZ + BS - 1) / BS ))
  while [ "$GOT" -lt "$NB" ]; do
    CN=256
    [ $((GOT + CN)) -gt "$NB" ] && CN=$((NB - GOT))
    dd if=/proc/$PID/mem bs=$BS skip=$(( START / BS + GOT )) count=$CN 2>/dev/null > "$OUT/blk.bin"
    if [ -s "$OUT/blk.bin" ]; then
      hexdump -v -e '1/1 "%02x"' "$OUT/blk.bin" 2>/dev/null > "$OUT/blk.hex"
      grep -ob '6465780a3033' "$OUT/blk.hex" 2>/dev/null | cut -d: -f1 | while read -r HPOS; do
        BOFF=$((HPOS / 2))
        ABS=$(( START + GOT * BS + BOFF ))
        dd if=/proc/$PID/mem bs=$BS skip=$(( ABS / BS )) count=1 2>/dev/null > "$OUT/fs.bin"
        SKIP=$(( ABS % BS + 32 ))
        FSHEX=$(dd if="$OUT/fs.bin" bs=1 skip=$SKIP count=4 2>/dev/null | hexdump -v -e '1/1 "%02x"' 2>/dev/null)
        [ ${#FSHEX} -ne 8 ] && continue
        FS=$((0x${FSHEX:6:2}${FSHEX:4:2}${FSHEX:2:2}${FSHEX:0:2}))
        if [ "$FS" -ge 4096 ] && [ "$FS" -le 67108864 ]; then
          dd if=/proc/$PID/mem bs=$BS skip=$(( ABS / BS )) count=$(( (FS + BS - 1) / BS )) 2>/dev/null > "$OUT/dex_${ABS}.dex"
          echo "GOT abs=$ABS size=$FS" >> "$OUT/got.txt"
        fi
      done
    fi
    rm -f "$OUT/blk.bin" "$OUT/blk.hex"
    GOT=$((GOT + CN))
  done
done < /proc/$PID/maps
echo "SCAN_DONE $(wc -l < "$OUT/regions.txt") segments" >> "$OUT/got.txt"
kill -CONT "$PID" 2>/dev/null
'''



def adb(args, timeout=180, binary=False):
    p = subprocess.run([ADB] + args, capture_output=True, timeout=timeout)
    return p.stdout if binary else p.stdout.decode("utf-8", "replace")


def main() -> int:
    ap = argparse.ArgumentParser(description="真机抓取内存明文 DEX")
    ap.add_argument("--outdir", default="work/realdump")
    ap.add_argument("--settle", type=float, default=14.0)
    ap.add_argument("--rounds", type=int, default=3)
    args = ap.parse_args()

    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)

    b64 = base64.b64encode(SIDE.encode()).decode()
    adb(["shell", f"su -c 'echo {b64} | base64 -d > /data/local/tmp/scan.sh; chmod 755 /data/local/tmp/scan.sh'"])
    print("[*] 扫描脚本已部署", flush=True)

    for rnd in range(1, args.rounds + 1):
        print(f"\n===== 第 {rnd} 轮 =====", flush=True)
        adb(["shell", f"su -c 'rm -rf {DEV}'"])
        adb(["shell", f"am force-stop {PKG}"], timeout=30)
        time.sleep(0.8)

        # 启动应用 -> 抢 pid -> 立刻以 root 后台起扫描
        launch = (
            f"am start -n {PKG}/{ACT} >/dev/null 2>&1; "
            f"n=0; while [ $n -lt 200 ]; do P=$(pidof {PKG}); "
            f"if [ -n \"$P\" ]; then "
            f"echo \"PID=$P\" > /data/local/tmp/scan.args; echo \"OUT={DEV}\" >> /data/local/tmp/scan.args; "
            f"su -c 'sh /data/local/tmp/scan.sh' >/dev/null 2>&1; "
            f"echo \"PID=$P\"; break; fi; "
            f"n=$((n+1)); sleep 0.05; done"
        )
        t0 = time.time()
        out = adb(["shell", launch], timeout=900).strip()
        print(f"  {out}  (抢到耗时 {time.time()-t0:.2f}s)", flush=True)

        time.sleep(args.settle)
        local = outdir / f"round{rnd}"
        local.mkdir(parents=True, exist_ok=True)
        adb(["shell", f"su -c 'chmod -R 777 {DEV}'"], timeout=60)
        adb(["pull", DEV, str(local)], timeout=600)
        d = local / "dexout"
        if d.is_dir():
            got = d / "got.txt"
            if got.exists():
                for line in got.read_text(errors="replace").splitlines():
                    print("   ", line, flush=True)
            dexs = sorted(d.glob("*.dex"))
            tot = sum(f.stat().st_size for f in dexs)
            print(f"  回传 {len(dexs)} 个文件, 合计 {tot/1048576:.1f} MB", flush=True)
            for f in dexs[:12]:
                print(f"    {f.name}  {f.stat().st_size:,} B", flush=True)
            if dexs:
                return 0
        else:
            print("  [!] 未产出目录", flush=True)
    return 1


if __name__ == "__main__":
    sys.exit(main())
