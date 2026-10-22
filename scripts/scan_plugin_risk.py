#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""在反编译出的 Java 源码中扫描高风险行为特征。

用途：
    APK 主体被网易易盾加固（Java 层不可直接反编译），但包内 assets 下的
    动态加载插件（jy.jar / AdxSdk / kcbw / zj / lywm / gdtadv2 等）是**明文 DEX**，
    可直接反编译。本脚本对这些源码做行为特征扫描，输出分类命中统计与具体位置。

用法:
    python3 scripts/scan_plugin_risk.py work/evidence/plugins -o work/meta/plugin_risk.md
"""

from __future__ import annotations

import argparse
import sys
from collections import Counter, defaultdict
from pathlib import Path

# 分类 -> [(规则名, 正则关键字...)]
RULES: dict[str, list[tuple[str, list[str]]]] = {
    "无障碍/自动化": [
        ("无障碍服务", ["AccessibilityService", "accessibilityservice", "performGlobalAction",
                        "dispatchGesture", "getRootInActiveWindow", "AccessibilityNodeInfo"]),
        ("模拟点击", ["VirtualClick", "simulateClick", "autoClick", "performClick"]),
    ],
    "静默安装/APK 分发": [
        ("安装 APK", ["ACTION_INSTALL_PACKAGE", "PackageInstaller", "installPackage",
                      "REQUEST_INSTALL_PACKAGES", "application/vnd.android.package-archive"]),
        ("下载 APK", ["DownloadManager", "apk", "ApkFileProvider", "UpdateApk"]),
    ],
    "设备指纹/隐私采集": [
        ("设备标识", ["getDeviceId", "getImei", "getMeid", "getSubscriberId", "getSimSerialNumber",
                      "ANDROID_ID", "OAID", "getOAID", "VAID", "getVAID", "UDID", "getUDID"]),
        ("应用列表", ["getInstalledPackages", "getInstalledApplications", "QUERY_ALL_PACKAGES",
                      "AppInstalledBean", "InstalledConversionInfo"]),
        ("位置/网络", ["getLastKnownLocation", "requestLocationUpdates", "getMacAddress",
                       "getBSSID", "getSSID"]),
    ],
    "动态加载/反射逃逸": [
        ("类加载器", ["DexClassLoader", "InMemoryDexClassLoader", "PathClassLoader",
                      "BaseDexClassLoader", "loadDex"]),
        ("反射", ["Class.forName", "getDeclaredMethod", "getMethod(", "invoke("]),
        ("动态执行", ["Runtime.getRuntime", "ProcessBuilder", ".exec(", "loadLibrary"]),
    ],
    "WebView 风险": [
        ("JS 桥", ["addJavascriptInterface", "AlipayJSBridge", "postMessage"]),
        ("宽松配置", ["setJavaScriptEnabled", "setAllowFileAccess", "setAllowUniversalAccessFromFileURLs",
                      "setDomStorageEnabled"]),
        ("TLS 放宽", ["onReceivedSslError", "proceed()", "checkServerTrusted",
                      "X509TrustManager", "setHostnameVerifier", "ALLOW_ALL_HOSTNAME_VERIFIER"]),
    ],
    "反检测": [
        ("反调试/反模拟器", ["isDebuggerConnected", "Debug.isDebuggerConnected", "ro.debuggable",
                             "isEmulator", "qemu", "goldfish", "frida", "xposed", "magisk"]),
        ("隐藏/伪装", ["setComponentEnabledSetting", "COMPONENT_ENABLED_STATE_DISABLED",
                       "createChooser", "Base64.decode"]),
    ],
}


def main() -> int:
    ap = argparse.ArgumentParser(description="插件源码风险点扫描")
    ap.add_argument("sources", help="包含各插件反编译结果的目录")
    ap.add_argument("-o", "--output", help="Markdown 报告输出路径")
    ap.add_argument("--per-plugin", action="store_true", help="按插件分组输出")
    args = ap.parse_args()

    root = Path(args.sources)
    if not root.is_dir():
        print(f"[-] 目录不存在: {root}", file=sys.stderr)
        return 1

    counter: Counter = Counter()
    samples: dict[str, list[str]] = defaultdict(list)
    per_plugin: dict[str, Counter] = defaultdict(Counter)

    plugins = sorted(p for p in root.iterdir() if p.is_dir())
    for plugin in plugins:
        for java in plugin.rglob("*.java"):
            try:
                text = java.read_text(encoding="utf-8", errors="replace")
            except OSError:
                continue
            rel = f"{plugin.name}/{java.relative_to(plugin)}"
            for category, rules in RULES.items():
                for rule, keys in rules:
                    for k in keys:
                        if k in text:
                            counter[(category, rule)] += 1
                            per_plugin[plugin.name][(category, rule)] += 1
                            if len(samples[(category, rule)]) < 4:
                                samples[(category, rule)].append(f"{rel}  [{k}]")

    lines = ["# 动态加载插件风险点扫描\n",
             f"- 扫描目录: `{root}`",
             f"- 插件数量: {len(plugins)}（{', '.join(p.name for p in plugins)}）\n",
             "## 1. 总体命中统计\n",
             "| 分类 | 规则 | 命中文件数 |", "|---|---|---|"]
    for (category, rule), n in sorted(counter.items(), key=lambda kv: -kv[1]):
        lines.append(f"| {category} | {rule} | {n} |")

    lines += ["\n## 2. 证据样例\n"]
    for (category, rule), n in sorted(counter.items(), key=lambda kv: -kv[1]):
        lines.append(f"### {category} / {rule}（{n} 处）")
        for s in samples[(category, rule)]:
            lines.append(f"- `{s}`")
        lines.append("")

    if args.per_plugin:
        lines += ["## 3. 按插件分布\n", "| 插件 | 分类/规则 | 命中数 |", "|---|---|---|"]
        for plugin in plugins:
            for (category, rule), n in sorted(per_plugin[plugin].items(), key=lambda kv: -kv[1])[:15]:
                lines.append(f"| {plugin} | {category} / {rule} | {n} |")

    report = "\n".join(lines)
    print(report[:6000])
    if args.output:
        Path(args.output).write_text(report, encoding="utf-8")
        print(f"\n[+] 已写入 {args.output}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
