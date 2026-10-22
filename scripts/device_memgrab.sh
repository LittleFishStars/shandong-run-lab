#!/system/bin/sh
# 目标进程内存取证（真机 Android 9 + Magisk）。
# 关键经验（全部经实测确认）：
#   * 读 /proc/<pid>/mem 前必须 SIGSTOP 目标，否则 EIO；
#   * toybox dd 的 skip 是「块号」，bs=4096 时约 68MB/s；
#   * 必须用 printf '%d' 解析 64 位地址（mksh 的 $((0x..)) 是 32 位会溢出）；
#   * 读出的 ashmem 区（dalvik-main space）可能被多进程共享，需用「进程独有映射」验证归属。
PKG="$1"
OUT="$2"
[ -z "$OUT" ] && OUT=/data/local/tmp/memgrab
mkdir -p "$OUT"; rm -f "$OUT"/*

# 抢 pid（在同一脚本内完成，避免跨 adb 调用导致进程切换）
PID=""
i=0
while [ $i -lt 400 ]; do
  PID=$(pidof "$PKG")
  [ -n "$PID" ] && break
  i=$((i+1))
  sleep 0.02
done
[ -z "$PID" ] && { echo "NO_PID" > "$OUT/status.txt"; exit 1; }
echo "PID=$PID" > "$OUT/status.txt"
cat /proc/$PID/cmdline 2>/dev/null | tr '\0' ' ' >> "$OUT/status.txt"
echo >> "$OUT/status.txt"

kill -STOP "$PID" 2>/dev/null
trap 'kill -CONT '"$PID"' 2>/dev/null' EXIT INT TERM

# 1) 归属验证：读该进程独有的 base.apk 映射，应看到 ZIP 头 "PK\x03\x04"
APKSEG=$(grep 'base.apk' /proc/$PID/maps | head -1)
if [ -n "$APKSEG" ]; then
  S=$(printf '%d' "0x$(echo "$APKSEG" | cut -d- -f1)")
  echo "apk_seg=$APKSEG" >> "$OUT/status.txt"
  dd if=/proc/$PID/mem bs=4096 skip=$((S/4096)) count=1 2>/dev/null > "$OUT/apkhdr.bin"
  echo "apkhdr_hex=$(hexdump -v -e '1/1 "%02x"' "$OUT/apkhdr.bin" 2>/dev/null | head -c 16)" >> "$OUT/status.txt"
fi

# 2) 抓关键映射（按名称筛选 + 大小上限），整段落盘供离线分析
: > "$OUT/regions.txt"
while read -r LINE; do
  set -- $LINE
  RANGE="$1"; PERM="$2"; NM="$6"
  case "$PERM" in *r*) ;; *) continue;; esac
  START=$(printf '%d' "0x${RANGE%-*}")
  END=$(printf '%d' "0x${RANGE#*-}")
  SZ=$((END - START))
  [ "$SZ" -lt 4096 ] && continue
  [ "$START" -gt 549755813888 ] && continue
  [ "$SZ" -gt 134217728 ] && continue          # 上限 128MB/段
  case "$NM" in *vvar*|*vsyscall*|*vectors*) continue;; esac
  echo "$START $SZ $NM" >> "$OUT/regions.txt"
done < /proc/$PID/maps

N=0
while read -r S L NM; do
  N=$((N+1))
  dd if=/proc/$PID/mem bs=4096 skip=$((S/4096)) count=$(( (L + 4095) / 4096 )) 2>/dev/null > "$OUT/seg_${N}_${S}.bin"
  echo "$N $S $L $NM" >> "$OUT/segments.txt"
done < "$OUT/regions.txt"

echo "GRAB_DONE segments=$N" >> "$OUT/status.txt"
kill -CONT "$PID" 2>/dev/null
