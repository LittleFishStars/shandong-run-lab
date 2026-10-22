#!/system/bin/sh
# 极早期内存抓取：抢到 pid 后立刻 SIGSTOP 并导出候选映射。
#
# 背景：该应用被网易易盾加固，壳在真机上仅存活约 1.1 秒即 System.exit(0) 自毁。
#       因此必须在进程刚出现的瞬间冻结它，才可能拿到解壳中间态的明文 DEX。
#
# 经验（真机 Android 9 + Magisk 实测）：
#   * /proc/<pid>/mem 需目标 STOP 后才可读；
#   * toybox dd 的 skip 是 32 位，高地址会溢出 -> 用 /proc/<pid>/map_files/<range>；
#   * mksh 的 $((0x..)) 是 32 位 -> 用 printf '%d' 解析 64 位地址。
PKG="$1"
OUT="$2"
[ -z "$OUT" ] && OUT=/data/local/tmp/quick
rm -rf "$OUT"; mkdir -p "$OUT"

# 最短间隔轮询抢 pid（壳 1.1s 就死，必须尽快）
PID=""
i=0
while [ $i -lt 5000 ]; do
  PID=$(pidof "$PKG")
  [ -n "$PID" ] && break
  i=$((i+1))
done
[ -z "$PID" ] && { echo NO_PID > "$OUT/status"; exit 1; }

# 立刻冻结
kill -STOP "$PID" 2>/dev/null
{
  echo "PID=$PID"
  echo "cmdline=$(cat /proc/$PID/cmdline 2>/dev/null | tr '\0' ' ')"
  echo "maplines=$(wc -l < /proc/$PID/maps 2>/dev/null)"
} > "$OUT/status"

# 导出可能承载 DEX 的映射
N=0
while read -r LINE; do
  set -- $LINE
  RANGE="$1"; PERM="$2"; NM="$6"
  case "$PERM" in *r*) ;; *) continue;; esac
  SZ=$(( $(printf '%d' "0x${RANGE#*-}") - $(printf '%d' "0x${RANGE%-*}") ))
  [ "$SZ" -lt 4096 ] && continue
  [ "$SZ" -gt 200000000 ] && continue
  case "$NM" in
    ""|*anon*|*dalvik*|*dex*) ;;
    *) continue;;
  esac
  L="/proc/$PID/map_files/$RANGE"
  [ -e "$L" ] || continue
  N=$((N+1))
  dd if="$L" bs=65536 2>/dev/null > "$OUT/q_${N}.bin"
  echo "$N $RANGE $SZ $NM" >> "$OUT/seg.txt"
done < /proc/$PID/maps

echo "DONE N=$N" >> "$OUT/status"
# 记录该时刻的线程栈/状态（判断解壳进度）
cat /proc/$PID/task/*/comm 2>/dev/null | sort | uniq -c >> "$OUT/status" 2>/dev/null
kill -CONT "$PID" 2>/dev/null
