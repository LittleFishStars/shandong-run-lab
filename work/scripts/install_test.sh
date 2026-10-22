#!/usr/bin/env bash
# install_test.sh —— 把重签名改造版 APK 整包安装并启动（决定性验证：壳是否还拒绝非原厂签名）
set -euo pipefail
ADB="$HOME/Android/Sdk/platform-tools/adb"
PKG=com.huachenjie.shandong_school
APK="${1:?用法: install_test.sh <apk>}"

echo "[1/3] 安装 $APK"
$ADB push "$APK" /data/local/tmp/mod.apk >/dev/null 2>&1
$ADB shell "su -c 'pm uninstall $PKG'" >/dev/null 2>&1 || true
$ADB shell "su -c 'pm install -d /data/local/tmp/mod.apk'" | tail -1
$ADB shell "su -c 'magisk --denylist add $PKG'" >/dev/null 2>&1 || true

echo "[2/3] 启动"
$ADB shell "am force-stop $PKG" >/dev/null 2>&1 || true
$ADB logcat -c
$ADB shell "am start -n $PKG/.splash.SplashActivity" >/dev/null 2>&1
sleep 12
echo "[3/3] 结果"
$ADB shell "ps -A | grep huachenjie" || echo "（无进程 ❌）"
$ADB shell dumpsys window 2>/dev/null | grep -E "mCurrentFocus" || true
$ADB logcat -d 2>/dev/null | grep -E "Abort message|FATAL EXCEPTION|UnsatisfiedLink|JNI DETECTED" | head -3 || true
