#!/usr/bin/env bash
# mkpatched.sh —— 把打过补丁的 libnesec.so 塞回**原版 APK**，重签名，产出可安装包
# 作用：最小改动实验。只改 .so，不动 DEX/资源，用来判断
#       ①补丁是否生效  ②改 .so 是否会触发完整性自毁
# 用法：bash work/mkpatched.sh <输出apk>
set -euo pipefail
cd /home/ylxc/Projects/lib/ShanDong

OUT="${1:-work/restest/patched.apk}"
BT="$HOME/.local/share/android/sdk/Sdk/build-tools/36.1.0"
KS="work/restest/debug.keystore"
SRC_APK="com.huachenjie.shandong_school.apk"
SO="shandong-android-rebuild/app/src/main/arm64-v8a/libnesec.so"

echo "[1/4] 重打包 APK（只替换 libnesec.so）"
python3 work/repack_apk.py "$SRC_APK" "work/restest/_raw.apk" lib/arm64-v8a/libnesec.so "$SO" | tail -3

echo "[2/4] zipalign"
"$BT/zipalign" -f -p 4 work/restest/_raw.apk work/restest/_aligned.apk

echo "[3/4] 重签名"
"$BT/apksigner" sign --ks "$KS" --ks-pass pass:android --key-pass pass:android \
  --ks-key-alias k --v1-signing-enabled true --v2-signing-enabled true \
  --out "$OUT" work/restest/_aligned.apk 2>/dev/null

echo "[4/4] 校验"
"$BT/apksigner" verify --print-certs "$OUT" 2>/dev/null | head -2
rm -f work/restest/_raw.apk work/restest/_aligned.apk
ls -l "$OUT"
