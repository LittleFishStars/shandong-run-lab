
#!/system/bin/sh
if [ -f /data/local/tmp/scan.args ]; then
  . /data/local/tmp/scan.args          # 提供 PID= / OUT=，避免多层引号丢失参数
fi
[ -n "$1" ] && PID="$1"
[ -n "$2" ] && OUT="$2"
[ -z "$PID" ] && exit 1
[ -z "$OUT" ] && OUT=/data/local/tmp/dexout
rm -rf "$OUT"; mkdir -p "$OUT"

# Android 9 内核：读 /proc/<pid>/mem 前必须让目标进程停止（否则 EIO）。
# 用 SIGSTOP 冻结，扫完再 SIGCONT 恢复（壳本来就会自毁，此举主要为了让读取成功）。
kill -STOP "$PID" 2>/dev/null
trap 'kill -CONT '"$PID"' 2>/dev/null' EXIT INT TERM

# 候选：所有可读私有段（含 /dev/ashmem/dalvik-* —— 真机上 ART 堆就是 ashmem）。
# 注意：Android 自带的 toybox awk **没有 strtonum()**（那是 gawk 扩展），
# 因此这里用纯 shell 解析十六进制，避免 awk 直接失败导致 regions.txt 为空。
cut -d' ' -f1 /proc/$PID/maps > "$OUT/nregions.txt"
rm -f "$OUT/regions.txt"; touch "$OUT/regions.txt"
while read -r LINE; do
  set -- $LINE
  RANGE="$1"; PERM="$2"; NM="$6"
  case "$PERM" in *r*) ;; *) continue;; esac
  # arm64 地址是 64 位（如 0x6fb46ab000）；mksh 的 $((0x...)) 只有 32 位有符号，
  # 会溢出成负数导致 dd 全部失败。必须用 printf '%d' 解析。
  START=$(printf '%d' "0x${RANGE%-*}")
  END=$(printf '%d' "0x${RANGE#*-}")
  SZ=$((END - START))
  [ "$SZ" -lt 4096 ] && continue
  [ "$SZ" -gt 268435456 ] && continue
  case "$NM" in *vvar*|*vsyscall*|*vectors*|*cfi*|*libwebview*) continue;; esac
  # 上限 120MB：DEX 极少超过此值，超大段（图形/保留堆）留给后续按需处理
  [ "$SZ" -gt 125829120 ] && continue
  echo "$START $SZ" >> "$OUT/regions.txt"
done < /proc/$PID/maps
# 按段大小升序：小段先扫，命中快且总耗时可控。
# 注意 toybox 的 `sort -k` 不生效、且 `sort -o f f` 会把文件清空，
# 因此必须用「-n -k2 输出到临时文件再 mv」的写法。
sort -n -k2 "$OUT/regions.txt" > "$OUT/.rsort" 2>/dev/null && mv "$OUT/.rsort" "$OUT/regions.txt" || true
wc -l < "$OUT/regions.txt" > "$OUT/nregions.txt"

i=0
while read S L; do
  i=$((i+1))
  # 整段流式读入，用 hexdump 把二进制转成十六进制再搜 magic（避免 grep 对二进制/\n 支持差异）。
  # 为控制开销，分段 4MB 处理，命中后再按绝对地址回读整份 DEX。
  OFFS=0
  while [ "$OFFS" -lt "$L" ]; do
    CH=1048576
    [ $((OFFS + CH)) -gt "$L" ] && CH=$((L - OFFS))
    # toybox dd 的 skip 是块号语义；用 bs=1 才能按字节精确定位
    dd if=/proc/$PID/mem bs=1 skip=$((S+OFFS)) count=$CH 2>/dev/null > "$OUT/blk.bin"
    # hexdump -v -e '1/1 "%02x"' 输出纯 hex 流；再用 grep 找 6465780a3033（"dex\n03"）
    hexdump -v -e '1/1 "%02x"' "$OUT/blk.bin" 2>/dev/null > "$OUT/blk.hex"
    grep -ob '6465780a3033' "$OUT/blk.hex" 2>/dev/null | cut -d: -f1 | while read -r HPOS; do
      BOFF=$((HPOS / 2))                 # 每字节 2 个 hex 字符
      ABS=$((S + OFFS + BOFF))
      dd if=/proc/$PID/mem bs=1 skip=$((ABS+32)) count=4 2>/dev/null > "$OUT/fs.bin"
      # 小端 u32：用 hex 拼接后转十进制
      FSHEX=$(hexdump -v -e '1/1 "%02x"' "$OUT/fs.bin" 2>/dev/null)
      [ ${#FSHEX} -ne 8 ] && continue
      FS=$((0x${FSHEX:6:2}${FSHEX:4:2}${FSHEX:2:2}${FSHEX:0:2}))
      if [ "$FS" -ge 4096 ] && [ "$FS" -le 268435456 ]; then
        dd if=/proc/$PID/mem bs=1 skip=$ABS count=$FS 2>/dev/null > "$OUT/dex_${ABS}.dex"
        echo "GOT abs=$ABS size=$FS" >> "$OUT/got.txt"
      fi
    done
    rm -f "$OUT/blk.bin" "$OUT/blk.hex"
    OFFS=$((OFFS + CH))
  done
done < "$OUT/regions.txt"
echo "SCAN_DONE" >> "$OUT/got.txt"
kill -CONT "$PID" 2>/dev/null
