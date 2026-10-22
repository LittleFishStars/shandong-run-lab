#!/usr/bin/env bash
# test_so.sh —— 快速迭代：只把新的 libnesec.so 塞进已安装目录并重启应用
# 前提：已用 work/swap_so.sh 装好原版 APK（原厂签名）。
set -euo pipefail
ADB="$HOME/Android/Sdk/platform-tools/adb"
PKG=com.huachenjie.shandong_school
SO_SRC="${1:-/home/ylxc/Projects/lib/ShanDong/shandong-android-rebuild/app/src/main/arm64-v8a/libnesec.so}"

LIBDIR=$($ADB shell pm path $PKG | sed "s|package:||; s|/base.apk||" | tr -d '\r')
[ -z "$LIBDIR" ] && { echo "应用未安装，先跑 work/swap_so.sh"; exit 1; }

$ADB push "$SO_SRC" /data/local/tmp/libnesec.so >/dev/null 2>&1
$ADB shell "su -c 'cp /data/local/tmp/libnesec.so $LIBDIR/lib/arm64/libnesec.so && chown system:system $LIBDIR/lib/arm64/libnesec.so && chmod 755 $LIBDIR/lib/arm64/libnesec.so && restorecon $LIBDIR/lib/arm64/libnesec.so'"
LOCAL=$(md5sum "$SO_SRC" | cut -d' ' -f1)
REMOTE=$($ADB shell "su -c 'md5sum $LIBDIR/lib/arm64/libnesec.so'" | cut -d' ' -f1 | tr -d '\r')
echo "so 校验：本地 $LOCAL / 设备 $REMOTE"
[ "$LOCAL" != "$REMOTE" ] && { echo "❌ 替换失败"; exit 1; }

$ADB shell "am force-stop $PKG" >/dev/null 2>&1 || true
$ADB logcat -c
$ADB shell "am start -n $PKG/.splash.SplashActivity" >/dev/null 2>&1
sleep 12
echo "--- 进程 ---"
$ADB shell "ps -A | grep huachenjie" || echo "（无进程 ❌）"
echo "--- 焦点 ---"
$ADB shell dumpsys window 2>/dev/null | grep -E "mCurrentFocus" || true
echo "--- 崩溃 ---"
$ADB logcat -d 2>/dev/null | grep -E "Abort message|FATAL EXCEPTION" | head -3 || true
