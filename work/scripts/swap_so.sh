#!/usr/bin/env bash
# swap_so.sh —— 「原厂签名 + 只换 libnesec.so」实验台
#
# 原理（已实测证实）：
#   壳的签名校验查的是 PackageManager 记录的**安装时签名**，与磁盘上 APK 内容无关。
#   所以：① 安装原厂 APK → 校验天然通过；
#         ② 该 APK 是 extractNativeLibs=true，.so 会被解压到
#            /data/app/<pkg>-<hash>/lib/arm64/ ，直接替换那一个文件即可。
#   ⇒ 完全不碰 base.apk，不会让 system_server 崩（上次整包覆盖就崩在这）。
#
# 用法：bash work/swap_so.sh [要替换的so]   缺省用 shandong-android-rebuild 里已打补丁的那个
set -euo pipefail
cd /home/ylxc/Projects/lib/ShanDong

ADB="$HOME/Android/Sdk/platform-tools/adb"
PKG=com.huachenjie.shandong_school
ORIG=com.huachenjie.shandong_school.apk
SO_SRC="${1:-shandong-android-rebuild/app/src/main/arm64-v8a/libnesec.so}"

echo "[1/5] 推原版 APK"
$ADB push "$ORIG" /data/local/tmp/orig.apk >/dev/null 2>&1

echo "[2/5] 卸载并安装原版（原厂签名）"
$ADB shell "su -c 'pm uninstall $PKG'" >/dev/null 2>&1 || true
$ADB shell "su -c 'pm install -d /data/local/tmp/orig.apk'" | tail -1

echo "[3/5] 重加 Magisk DenyList（卸载会清掉）"
$ADB shell "su -c 'magisk --denylist add $PKG'" >/dev/null 2>&1 || true

echo "[4/5] 替换解压出来的 libnesec.so"
LIBDIR=$($ADB shell pm path $PKG | sed "s|package:||; s|/base.apk||" | tr -d '\r')
echo "      安装目录: $LIBDIR"
$ADB push "$SO_SRC" /data/local/tmp/libnesec.so >/dev/null 2>&1
$ADB shell "su -c 'cp /data/local/tmp/libnesec.so $LIBDIR/lib/arm64/libnesec.so && chown system:system $LIBDIR/lib/arm64/libnesec.so && chmod 755 $LIBDIR/lib/arm64/libnesec.so && restorecon $LIBDIR/lib/arm64/libnesec.so'"
$ADB shell "su -c 'ls -laZ $LIBDIR/lib/arm64/libnesec.so'"

echo "[5/5] 启动"
$ADB shell "am force-stop $PKG" >/dev/null 2>&1 || true
$ADB logcat -c
$ADB shell "am start -n $PKG/.splash.SplashActivity" >/dev/null 2>&1
echo "已启动，等待 10 秒观察…"
sleep 10
echo "--- 进程 ---"
$ADB shell "ps -A | grep huachenjie" || echo "（无进程）"
echo "--- 焦点 ---"
$ADB shell dumpsys window 2>/dev/null | grep -E "mCurrentFocus" || true
echo "--- 崩溃 ---"
$ADB logcat -d 2>/dev/null | grep -E "Abort message|FATAL EXCEPTION|UnsatisfiedLink" | head -5 || true
