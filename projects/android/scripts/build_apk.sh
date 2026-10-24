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

# ── 目标变体：默认同时构建调试版 + 发布版（每次改动都出两版）──
TARGET="${1:-all}"
# VARIANTS：本次要构建（也即只汇报）的变体，避免把上次残留的旧包当成新产物
case "${TARGET}" in
    debug)   TASKS=(assembleDebug);   VARIANTS=(debug) ;;
    release) TASKS=(assembleRelease); VARIANTS=(release) ;;
    all)     TASKS=(assembleDebug assembleRelease); VARIANTS=(debug release) ;;
    *)       echo "[build] 未知目标 ${TARGET}（可选：debug | release | all）" >&2; exit 2 ;;
esac
shift || true

echo "==> GRADLE_USER_HOME=${GRADLE_USER_HOME}"
echo "==> ANDROID_USER_HOME=${ANDROID_USER_HOME}"
echo "==> JAVA_HOME=${JAVA_HOME}"

echo "==> 构建任务：${TASKS[*]}"

# 调用 gradlew（附加用户参数）
${GW} "${TASKS[@]}" "$@"

# ── 产物汇报（debug / release 各一份）──
SIGNER="$(ls -d "${HOME}/Android/Sdk"/build-tools/*/apksigner 2>/dev/null | tail -1 || true)"
echo ""
echo "=========================================="
FOUND=0
for v in "${VARIANTS[@]}"; do
    APK="app/build/outputs/apk/${v}/app-${v}.apk"
    [ -f "${APK}" ] || continue
    FOUND=1
    echo "  [${v}] ${APK}  $(du -h "${APK}" | cut -f1)"
    if [ "${v}" = "release" ] && [ -n "${SIGNER}" ] && [ -x "${SIGNER}" ]; then
        if "${SIGNER}" verify --print-certs "${APK}" >/dev/null 2>&1; then
            echo "        签名：已签名 ✓"
        else
            echo "        签名：未签名 ✗（检查 local.properties 的 shandong.* 配置）" >&2
        fi
    fi
done
if [ "${FOUND}" -eq 0 ]; then
    echo "[build] 未找到任何 APK 产物，请检查上方构建日志。" >&2
    exit 1
fi
echo "=========================================="