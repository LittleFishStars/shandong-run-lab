#!/usr/bin/env bash
# 闪动校园 · 安卓版 —— 安装脚本
# 安装到已连接的设备/模拟器并启动 MainActivity。
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(cd "${SCRIPT_DIR}/.." && pwd)"

APK="$(find "${PROJECT_DIR}/app/build/outputs/apk" -name '*.apk' -type f 2>/dev/null | head -n 1)"
if [ -z "${APK}" ]; then
    echo "[install] 未找到 APK，请先执行 scripts/build_apk.sh" >&2
    exit 1
fi

# 检查是否有设备/模拟器
DEVICES="$(adb devices | awk 'NR>1 && $2=="device" {print $1}' 2>/dev/null || true)"
if [ -z "${DEVICES}" ]; then
    echo "[install] 没有检测到已连接的设备或模拟器。"
    echo "         请连接设备并开启 USB 调试，或启动模拟器后重试。"
    exit 1
fi

echo "[install] 安装 ${APK} 到以下设备:"
echo "${DEVICES}"
adb install -r "${APK}"

echo "[install] 启动应用..."
adb shell am start -n com.ylxc.shandong/.MainActivity
echo "[install] 完成。"