#!/usr/bin/env bash
# 闪动校园 · 安卓版 —— 构建 APK 脚本
# 说明：本脚本按沙箱只读环境设计，GRADLE_USER_HOME / ANDROID_USER_HOME 均指向临时目录。
set -euo pipefail

# 定位脚本所在目录（android/scripts/）
SCRIPT_DIR="$(cd "$(dirname "${BASH_SOURCE[0]}")" && pwd)"
PROJECT_DIR="$(cd "${SCRIPT_DIR}/.." && pwd)"
TMP_BASE="${PROJECT_DIR}/../../tmp"   # <workspace>/tmp
mkdir -p "${TMP_BASE}"

# ---- 目录命中（沙箱内 ~/.gradle 与 ~/Android/Sdk 只读）----
# 若环境已将 GRADLE_USER_HOME / ANDROID_USER_HOME 预置为系统只读路径，
# （例如沙箱注入 /home/ylxc/.local/share/gradle），则强制改写到本临时目录，
# 否则保留用户显式设置的值，保证构建可写。
TMP_BASE_REAL="$(cd "${TMP_BASE}" && pwd)"
if [ -z "${GRADLE_USER_HOME:-}" ] || [[ "${GRADLE_USER_HOME}" == "/home/ylxc/.local/share/gradle" || "${GRADLE_USER_HOME}" == "${HOME}/.gradle" ]]; then
    export GRADLE_USER_HOME="${TMP_BASE_REAL}/gh"
fi
if [ -z "${ANDROID_USER_HOME:-}" ] || [[ "${ANDROID_USER_HOME}" == "/home/ylxc/.local/share/android" || "${ANDROID_USER_HOME}" == "${HOME}/.android" ]]; then
    export ANDROID_USER_HOME="${TMP_BASE_REAL}/auh"
fi
# 强制 JDK 21（JDK 27 会让 Groovy 报 "Unsupported class file major version 71"）
export JAVA_HOME="${JAVA_HOME:-/usr/lib/jvm/java-21-openjdk}"
# 通过 GRADLE_OPTS 注入 -Dorg.gradle.java.home（Gradle 守护进程与 Groovy 均使用 JDK21）
GRADLE_OPTS="${GRADLE_OPTS:-}${GRADLE_OPTS:+ }-Dorg.gradle.java.home=${JAVA_HOME}"
export GRADLE_OPTS
mkdir -p "${GRADLE_USER_HOME}" "${ANDROID_USER_HOME}"

# 生成 local.properties（若不存在），写入 SDK 路径
cd "${PROJECT_DIR}"
if [ ! -f local.properties ]; then
    cp -n local.properties.example local.properties 2>/dev/null || true
    echo "sdk.dir=/home/ylxc/Android/Sdk" >> local.properties
    echo "[build] 已写入 local.properties sdk.dir=/home/ylxc/Android/Sdk"
fi

# 选择 gradlew 调用方式
if [ -x ./gradlew ]; then
    GW="./gradlew"
else
    GW="sh ./gradlew"
fi

echo "==> GRADLE_USER_HOME=${GRADLE_USER_HOME}"
echo "==> ANDROID_USER_HOME=${ANDROID_USER_HOME}"
echo "==> JAVA_HOME=${JAVA_HOME}"

# 调用 gradlew（附加用户参数）
${GW} assembleDebug "$@"

# 打印产物与大小
APK="$(find app/build/outputs/apk -name '*.apk' -type f 2>/dev/null | head -n 1)"
if [ -n "${APK}" ]; then
    echo ""
    echo "=========================================="
    echo "  APK: ${APK}"
    echo "  大小: $(du -h "${APK}" | cut -f1)"
    echo "=========================================="
else
    echo "[build] 未找到 APK 产物，请检查上方构建日志。" >&2
    exit 1
fi