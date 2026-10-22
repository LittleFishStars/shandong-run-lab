#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""真机脱壳：在易盾壳调用 System.exit 自毁前抢占并冻结进程，导出内存中的明文 DEX。

核心思路（不依赖 Frida）：
    壳在启动后约 2 秒执行 System.exit(0)。但在此之前它已完成 DEX 解密与
    InMemoryDexClassLoader 加载。因此用一个高频轮询的看门狗，在恰当时机
    （默认 pid 出现后 delay 秒）对目标进程发 SIGSTOP，冻结其内存快照，
    再逐映射导出并扫描 DEX。

关键实现细节（真机 Android 9 + Magisk 实测）：
    * /proc/<pid>/mem 必须目标 STOP 后才可读，否则 EIO；
    * toybox dd 的 skip 为 32 位，arm64 高地址会溢出 → 用
      /proc/<pid>/map_files/<range>（内核按映射返回，无 64 位偏移问题）；
    * mksh 的 $((0x..)) 是 32 位 → 用 printf '%d' 解析地址；
    * DEX 可能在映射中间，需用 hexdump 转 hex 后搜 magic（区分大小写与版本）。

用法:
    python3 scripts/realdump_watchdog.py --delay 1.5 --outdir work/realdump_live
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

# 设备端：等 delay 后冻结并导出所有候选映射（含 dex magic 搜索）
SIDE = r'''
#!/system/bin/sh
# $1=PKG $2=OUT $3=delay_sec
PKG="$1"; OUT="$2"; DELAY="$3"
rm -rf "$OUT"; mkdir -p "$OUT"

# 抢 pid（壳仅存活约 2s，必须最快）
PID=""
i=0
while [ $i -lt 20000 ]; do
  PID=$(pidof "$PKG")
  [ -n "$PID" ] && break
  i=$((i+1))
done
[ -z "$PID" ] && { echo "NO_PID" > "$OUT/status"; exit 1; }
echo "PID=$PID" > "$OUT/status"
echo "found_at=$(date +%s.%N 2>/dev/null || date +%s)" >> "$OUT/status"

# 等待 delay，让壳完成解密（但要在它 System.exit 之前）
sleep "$DELAY"
if [ ! -d "/proc/$PID" ]; then
  echo "DIED_BEFORE_STOP" >> "$OUT/status"
  exit 2
fi
# 立即冻结
kill -STOP "$PID" 2>/dev/null
echo "stopped_at=$(date +%s.%N 2>/dev/null || date +%s)" >> "$OUT/status"
echo "maplines=$(wc -l < /proc/$PID/maps 2>/dev/null)" >> "$OUT/status"
echo "threads=$(ls /proc/$PID/task 2>/dev/null | wc -l)" >> "$OUT/status"

# 导出候选映射：可读、匿名/ashmem/dalvik/dex，单映射 <= 64MB
N=0
while read -r LINE; do
  set -- $LINE
  RANGE="$1"; PERM="$2"; NM="$6"
  case "$PERM" in *r*) ;; *) continue;; esac
  SZ=$(( $(printf '%d' "0x${RANGE#*-}") - $(printf '%d' "0x${RANGE%-*}") ))
  [ "$SZ" -lt 4096 ] && continue
  [ "$SZ" -gt 67108864 ] && continue
  case "$NM" in
    ""|*anon*|*dalvik*|*dex*|*base.apk*) ;;
    *) continue;;
  esac
  L="/proc/$PID/map_files/$RANGE"
  [ -e "$L" ] || continue
  N=$((N+1))
  dd if="$L" bs=65536 2>/dev/null > "$OUT/m_${N}.bin"
  echo "$N $RANGE $SZ $NM" >> "$OUT/seg.txt"
done < /proc/$PID/maps

echo "EXPORTED=$N" >> "$OUT/status"

# 边导出边就地扫 DEX（避免后续再传大文件）
: > "$OUT/got.txt"
for F in "$OUT"/m_*.bin; do
  [ -s "$F" ] || continue
  hexdump -v -e '1/1 "%02x"' "$F" 2>/dev/null > "$OUT/h.hex"
  grep -ob '6465780a3033' "$OUT/h.hex" 2>/dev/null | cut -d: -f1 | while read -r HP; do
    BO=$((HP/2))
    M=$(dd if="$F" bs=1 skip=$BO count=8 2>/dev/null | hexdump -v -e '1/1 "%02x"')
    case "$M" in
      6465780a3033*00)
        FH=$(dd if="$F" bs=1 skip=$((BO+32)) count=4 2>/dev/null | hexdump -v -e '1/1 "%02x"')
        [ ${#FH} -ne 8 ] && continue
        FS=$((0x${FH:6:2}${FH:4:2}${FH:2:2}${FH:0:2}))
        [ "$FS" -lt 4096 ] && continue
        [ "$FS" -gt 67108864 ] && continue
        dd if="$F" bs=1 skip=$BO count=$FS 2>/dev/null > "$OUT/DEX_$(basename $F .bin)_$BO.dex"
        echo "GOT $(basename $F) off=$BO size=$FS" >> "$OUT/got.txt"
        ;;
    esac
  done
  rm -f "$OUT/h.hex"
done
echo "SCAN_DONE" >> "$OUT/got.txt"
kill -CONT "$PID" 2>/dev/null
'''


def adb(args, timeout=300, binary=False):
    p = subprocess.run([ADB] + args, capture_output=True, timeout=timeout)
    return p.stdout if binary else p.stdout.decode("utf-8", "replace")


def main() -> int:
    ap = argparse.ArgumentParser(description="壳自毁前抢冻结并导出 DEX")
    ap.add_argument("--outdir", default="work/realdump_live")
    ap.add_argument("--delay", type=float, default=1.5,
                    help="pid 出现后等待多少秒再冻结（壳约 2s 自毁，1.2~1.7 较优）")
    ap.add_argument("--rounds", type=int, default=3)
    args = ap.parse_args()

    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    dev = "/data/local/tmp/rdl"

    b64 = base64.b64encode(SIDE.encode()).decode()
    adb(["shell", f"su -c 'echo {b64} | base64 -d > /data/local/tmp/rdl.sh; chmod 755 /data/local/tmp/rdl.sh'"])
    print("[*] 已部署看门狗脚本", flush=True)

    for rnd in range(1, args.rounds + 1):
        print(f"\n===== 第 {rnd} 轮 (delay={args.delay}s) =====", flush=True)
        adb(["shell", f"su -c 'rm -rf {dev}'"])
        adb(["shell", f"am force-stop {PKG}"], timeout=60)
        time.sleep(0.5)

        # 后台起看门狗，再启动应用（两者并行）
        cmd = (f"su -c 'sh /data/local/tmp/rdl.sh {PKG} {dev} {args.delay}' & "
               f"am start -n {PKG}/{ACT} >/dev/null 2>&1; wait")
        t0 = time.time()
        try:
            adb(["shell", cmd], timeout=600)
        except subprocess.TimeoutExpired:
            print("  [!] shell 超时", flush=True)
        print(f"  设备端耗时 {time.time()-t0:.1f}s", flush=True)

        local = outdir / f"round{rnd}"
        local.mkdir(parents=True, exist_ok=True)
        adb(["shell", f"su -c 'chmod -R 777 {dev}'"], timeout=60)
        adb(["pull", dev, str(local)], timeout=900)

        d = local / "rdl"
        if d.is_dir():
            st = d / "status"
            if st.exists():
                print("  状态:", flush=True)
                for line in st.read_text(errors="replace").splitlines():
                    print("    ", line, flush=True)
            gt = d / "got.txt"
            if gt.exists():
                hits = [l for l in gt.read_text(errors="replace").splitlines() if l.startswith("GOT")]
                print(f"  命中 DEX: {len(hits)}", flush=True)
                for h in hits[:10]:
                    print("    ", h, flush=True)
            dexs = sorted(d.glob("DEX_*.dex"))
            if dexs:
                print(f"  [√] 导出 {len(dexs)} 个 DEX，合计 "
                      f"{sum(f.stat().st_size for f in dexs)/1048576:.1f} MB", flush=True)
                return 0
    return 1


if __name__ == "__main__":
    sys.exit(main())
