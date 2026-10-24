#!/usr/bin/env bash
# 闪动校园 · 安卓版 —— 安装脚本
# 安装到已连接的设备/模拟器并启动 MainActivity。
#
# 用法：
#   bash scripts/install.sh            # 默认装发布版 release（不存在则回退 debug）
#   bash scripts/install.sh release
#   bash scripts/install.sh debug
set -euo pipefail

SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(cd "${SCRIPT_DIR}/.." && pwd)"

# 选择要装的变体：参数 > 默认 release > 回退 debug
VARIANT="${1:-release}"
APK="${PROJECT_DIR}/app/build/outputs/apk/${VARIANT}/app-${VARIANT}.apk"
if [ ! -f "${APK}" ]; then
    if [ "${VARIANT}" = "release" ] && [ -f "${PROJECT_DIR}/app/build/outputs/apk/debug/app-debug.apk" ]; then
        echo "[install] 没找到 release 包，回退安装 debug 版"
        VARIANT=debug
        APK="${PROJECT_DIR}/app/build/outputs/apk/debug/app-debug.apk"
    else
        echo "[install] 未找到 ${VARIANT} 包，请先执行 scripts/build_apk.sh" >&2
        exit 1
    fi
fi

# 检查是否有设备/模拟器
DEVICES="$(adb devices | awk 'NR>1 && $2=="device" {print $1}' 2>/dev/null || true)"
if [ -z "${DEVICES}" ]; then
    echo "[install] 没有检测到已连接的设备或模拟器。"
    echo "         请连接设备并开启 USB 调试，或启动模拟器后重试。"
    exit 1
fi

# 两个构建变体签名不同，直接覆盖安装会被系统拒绝（INSTALL_FAILED_UPDATE_INCOMPATIBLE），
# 所以先卸载再装，避免「签名不一致」的安装失败。
if adb shell pm list packages 2>/dev/null | grep -q "com.ylxc.shandong"; then
    echo "[install] 已存在旧安装，先卸载（debug/release 签名不通用）"
    adb uninstall com.ylxc.shandong >/dev/null 2>&1 || true
fi

echo "[install] 安装 ${VARIANT} 包到以下设备:"
echo "${DEVICES}"
echo "          ${APK}"
adb install -r "${APK}"

echo "[install] 启动应用..."
adb shell am start -n com.ylxc.shandong/.MainActivity
echo "[install] 完成（${VARIANT}）。"
