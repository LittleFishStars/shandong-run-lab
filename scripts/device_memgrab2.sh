#!/system/bin/sh
# 真机（Android 9 + Magisk）内存取证：在易盾壳自毁前导出明文字节。
#
# 为什么用 /proc/<pid>/map_files/<range>：
#   toybox dd 的 skip 是 32 位有符号，真机 arm64 的高地址映射
#   （如 0x6fb3ef3000 ≈ 479GB）算块号会溢出成负数，导致读到 0 字节。
#   map_files/ 让内核按「映射区间」直接返回数据，完全绕过 64 位偏移问题，
#   实测能正确读到 ZIP 头 "PK\x03\x04"，且可精确挑选目标映射。
#
# 关键约束：
#   * 读 /proc/<pid>/mem 或 map_files 前需 SIGSTOP 目标（Android 9 内核要求）；
#   * 只导出「可能承载 DEX / 有分析价值」的映射，控制体积。
PKG="$1"
OUT="$2"
[ -z "$OUT" ] && OUT=/data/local/tmp/memgrab
rm -rf "$OUT"; mkdir -p "$OUT"

# 抢 pid（脚本内完成，避免跨 adb 调用期间进程切换）
PID=""
i=0
while [ $i -lt 500 ]; do
  PID=$(pidof "$PKG")
  [ -n "$PID" ] && break
  i=$((i+1))
  sleep 0.02
done
[ -z "$PID" ] && { echo "NO_PID" > "$OUT/status.txt"; exit 1; }
{
  echo "PID=$PID"
  echo "cmdline=$(cat /proc/$PID/cmdline 2>/dev/null | tr '\0' ' ')"
} > "$OUT/status.txt"

kill -STOP "$PID" 2>/dev/null
trap 'kill -CONT '"$PID"' 2>/dev/null' EXIT INT TERM

# 归属自检：读 base.apk 映射头，应得到 504b0304（"PK\x03\x04"）
APK=$(grep 'base.apk' /proc/$PID/maps | head -1 | awk '{print $1}')
if [ -n "$APK" ] && [ -e "/proc/$PID/map_files/$APK" ]; then
  H=$(dd if="/proc/$PID/map_files/$APK" bs=4096 count=1 2>/dev/null | hexdump -v -e '1/1 "%02x"' | head -c 8)
  echo "apk_probe=$H" >> "$OUT/status.txt"
fi

# 导出候选映射：可读、且属于会承载 DEX 的类别。
# 优先级：匿名/ashmem（解壳后 DEX 多在此）、dalvik 堆、dex/jar 相关、应用数据目录。
N=0
while read -r LINE; do
  set -- $LINE
  RANGE="$1"; PERM="$2"; NM="$6"
  case "$PERM" in *r*) ;; *) continue;; esac
  SZ=$(( $(printf '%d' "0x${RANGE#*-}") - $(printf '%d' "0x${RANGE%-*}") ))
  [ "$SZ" -lt 4096 ] && continue
  [ "$SZ" -gt 268435456 ] && continue           # 单映射上限 256MB
  case "$NM" in
    *vvar*|*vsyscall*|*vectors*|*cfi*) continue;;
  esac
  # 只关注可能含 DEX 的映射，减少体积
  case "$NM" in
    ""|*anon*|*dalvik*|*dex*|*jar*|*base.apk*|*data/app*|*data/data*) ;;
    *) continue;;
  esac
  LINK="/proc/$PID/map_files/$RANGE"
  [ -e "$LINK" ] || continue
  N=$((N+1))
  # 用 map_files 整份读取（内核按映射返回，无需偏移计算）
  dd if="$LINK" bs=65536 2>/dev/null > "$OUT/s_${N}.bin"
  SZR=$(wc -c < "$OUT/s_${N}.bin" 2>/dev/null)
  echo "$N $RANGE $SZ $SZR $NM" >> "$OUT/segments.txt"
done < /proc/$PID/maps

echo "GRAB_DONE exported=$N" >> "$OUT/status.txt"
kill -CONT "$PID" 2>/dev/null
