#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""解析 `aapt dump xmltree AndroidManifest.xml` 的输出，生成结构化摘要。

用法:
    python3 scripts/parse_manifest.py work/manifest.xmltree [-o work/meta/manifest_summary.json]

设计说明:
    aapt xmltree 采用「缩进即层级」的文本格式:
        E: activity (line=432)              <- 元素，缩进 6 空格
          A: android:name(...)="..."        <- 属性，缩进 8 空格
          E: intent-filter (line=...)       <- 子元素，缩进 8 空格
    因此只要按缩进维护一个栈即可还原树。
"""

from __future__ import annotations

import argparse
import json
import re
import sys
from collections import Counter
from typing import Any

# 匹配 `E: activity (line=432)` / `A: android:name(0x01010003)="X" (Raw: "X")`
RE_ELEMENT = re.compile(r"^(\s*)E:\s+(\S+)\s*(?:\(line=(\d+)\))?\s*$")
RE_ATTRIBUTE = re.compile(r"^(\s*)A:\s+(.*)$")

# 属性值形态: ns:name(0x...)=值
RE_ATTR_VALUE = re.compile(r"^(?:(?P<ns>[A-Za-z0-9_.]+):)?(?P<name>[A-Za-z0-9_.\-]+)"
                           r"(?:\((?:0x[0-9a-fA-F]+|type[^)]*)\))?=(?P<value>.*)$")


def parse_attr_value(raw: str) -> tuple[str, Any]:
    """把一条属性解析成 (名字, Python 值)。"""
    m = RE_ATTR_VALUE.match(raw)
    if not m:
        return raw.strip(), None
    name = m.group("name")
    value = m.group("value").strip()

    # 去掉尾部 `(Raw: "...")`
    raw_suffix = re.search(r'\s*\(Raw: (.*)\)\s*$', value)
    if raw_suffix:
        value = value[: raw_suffix.start()].strip()

    if value.startswith('"') and value.endswith('"') and len(value) >= 2:
        return name, value[1:-1]

    t = re.match(r"^\(type 0x([0-9a-fA-F]+)\)(.*)$", value)
    if t:
        type_code = int(t.group(1), 16)
        body = t.group(2).strip()
        # 0x10=INT_DEC / 0x11=INT_HEX / 0x12=INT_BOOLEAN
        # 注意: aapt 对 INT_DEC 也可能打印 0x 前缀，统一用 int(body, 0) 容错
        if type_code == 0x12:
            return name, body not in ("0x0", "0", "false")
        if type_code in (0x10, 0x11):
            try:
                return name, int(body, 0)
            except ValueError:
                return name, body
        return name, body

    if value.startswith("@"):
        return name, value
    try:
        return name, int(value)
    except ValueError:
        return name, value


def parse_xmltree(text: str) -> dict:
    """把 xmltree 文本还原成 {tag, attrs, children, line} 的树。"""
    root: dict = {"tag": "#root", "attrs": {}, "children": [], "line": 0}
    # 栈元素: (缩进宽度, 节点)
    stack: list[tuple[int, dict]] = [(-1, root)]

    for raw_line in text.splitlines():
        if not raw_line.strip():
            continue

        m = RE_ELEMENT.match(raw_line)
        if m:
            indent = len(m.group(1))
            node = {
                "tag": m.group(2),
                "attrs": {},
                "children": [],
                "line": int(m.group(3)) if m.group(3) else 0,
            }
            while stack and stack[-1][0] >= indent:
                stack.pop()
            stack[-1][1]["children"].append(node)
            stack.append((indent, node))
            continue

        m = RE_ATTRIBUTE.match(raw_line)
        if m:
            indent = len(m.group(1))
            while stack and stack[-1][0] >= indent:
                stack.pop()
            name, value = parse_attr_value(m.group(2))
            stack[-1][1]["attrs"][name] = value

    return root


def find_all(node: dict, tag: str) -> list[dict]:
    """深度优先收集指定 tag 的节点（跳过根）。"""
    out: list[dict] = []
    for child in node.get("children", []):
        if child["tag"] == tag:
            out.append(child)
        out.extend(find_all(child, tag))
    return out


def first(node: dict, tag: str) -> dict | None:
    hits = find_all(node, tag)
    return hits[0] if hits else None


def summarize(root: dict) -> dict:
    manifest = first(root, "manifest")
    if manifest is None:
        raise SystemExit("解析失败: 未找到 manifest 元素")

    app = first(manifest, "application")
    uses_sdk = first(manifest, "uses-sdk")

    def attr(node: dict | None, key: str, default=None):
        return (node or {}).get("attrs", {}).get(key, default)

    # 权限
    permissions = [attr(p, "name") for p in find_all(manifest, "uses-permission")]
    declared_perms = [
        {"name": attr(p, "name"), "protectionLevel": attr(p, "protectionLevel")}
        for p in find_all(manifest, "permission")
    ]

    # 组件（只看 application 直接子节点，避免把 intent-filter 里的嵌套项算进来）
    def components(tag: str) -> list[dict]:
        out = []
        for comp in (app or {}).get("children", []):
            if comp["tag"] != tag:
                continue
            intents = []
            for f in comp["children"]:
                if f["tag"] != "intent-filter":
                    continue
                intents.append({
                    "actions": [attr(a, "name") for a in f["children"] if a["tag"] == "action"],
                    "categories": [attr(c, "name") for c in f["children"] if c["tag"] == "category"],
                    "data": [
                        {k: v for k, v in d["attrs"].items()}
                        for d in f["children"] if d["tag"] == "data"
                    ],
                })
            metas = [
                {"name": attr(m, "name"), "value": attr(m, "value") or attr(m, "resource")}
                for m in comp["children"] if m["tag"] == "meta-data"
            ]
            out.append({
                "name": attr(comp, "name"),
                "exported": attr(comp, "exported"),
                "permission": attr(comp, "permission"),
                "authorities": attr(comp, "authorities"),
                "process": attr(comp, "process"),
                "launchMode": attr(comp, "launchMode"),
                "intentFilters": intents,
                "metaData": metas,
            })
        return out

    activities = components("activity") + components("activity-alias")
    services = components("service")
    receivers = components("receiver")
    providers = components("provider")

    # 启动入口
    launchers = [
        a["name"] for a in activities
        if any(
            "android.intent.action.MAIN" in (f.get("actions") or [])
            and "android.intent.category.LAUNCHER" in (f.get("categories") or [])
            for f in a["intentFilters"]
        )
    ]

    # 按包名/厂商前缀归类组件，用于识别第三方 SDK
    def vendor(name: str | None) -> str:
        if not name:
            return "未知"
        parts = name.split(".")
        if len(parts) >= 3:
            return ".".join(parts[:3])
        return ".".join(parts[:2])

    all_comp_names = [c["name"] for c in activities + services + receivers + providers if c["name"]]
    vendor_stats = Counter(vendor(n) for n in all_comp_names)

    return {
        "package": attr(manifest, "package"),
        "versionCode": attr(manifest, "versionCode"),
        "versionName": attr(manifest, "versionName"),
        "installLocation": attr(manifest, "installLocation"),
        "usesSdk": (uses_sdk or {}).get("attrs", {}),
        "application": {
            "name": attr(app, "name"),
            "appComponentFactory": attr(app, "appComponentFactory"),
            "debuggable": attr(app, "debuggable"),
            "allowBackup": attr(app, "allowBackup"),
            "usesCleartextTraffic": attr(app, "usesCleartextTraffic"),
            "networkSecurityConfig": attr(app, "networkSecurityConfig"),
            "largeHeap": attr(app, "largeHeap"),
            "requestLegacyExternalStorage": attr(app, "requestLegacyExternalStorage"),
            "theme": attr(app, "theme"),
            "label": attr(app, "label"),
            "extractNativeLibs": attr(app, "extractNativeLibs"),
        },
        "applicationMetaData": [
            {"name": attr(m, "name"), "value": attr(m, "value") or attr(m, "resource")}
            for m in (app or {}).get("children", []) if m["tag"] == "meta-data"
        ],
        "usesLibraries": [attr(u, "name") for u in find_all(manifest, "uses-library")],
        "permissions": permissions,
        "declaredPermissions": declared_perms,
        "launcherActivities": launchers,
        "counts": {
            "activities": len(activities),
            "services": len(services),
            "receivers": len(receivers),
            "providers": len(providers),
            "permissions": len(permissions),
        },
        "vendorStats": vendor_stats.most_common(40),
        "activities": activities,
        "services": services,
        "receivers": receivers,
        "providers": providers,
    }


def print_report(s: dict) -> None:
    print("=" * 78)
    print(f"包名        : {s['package']}")
    print(f"版本        : {s['versionName']} (versionCode={s['versionCode']})")
    print(f"uses-sdk    : {s['usesSdk']}")
    app = s["application"]
    print(f"Application : {app['name']}")
    print(f"  AppComponentFactory : {app['appComponentFactory']}")
    print(f"  debuggable={app['debuggable']} allowBackup={app['allowBackup']} "
          f"cleartext={app['usesCleartextTraffic']} largeHeap={app['largeHeap']}")
    print(f"  networkSecurityConfig={app['networkSecurityConfig']} "
          f"extractNativeLibs={app['extractNativeLibs']}")
    print(f"启动 Activity: {s['launcherActivities']}")
    print(f"组件数量    : {s['counts']}")
    print(f"uses-library: {s['usesLibraries']}")

    print("\n--- 第三方 SDK 组件分布 (前 40) ---")
    for name, cnt in s["vendorStats"]:
        print(f"  {cnt:4d}  {name}")

    print(f"\n--- 权限 ({len(s['permissions'])}) ---")
    for i in range(0, len(s["permissions"]), 3):
        row = s["permissions"][i:i + 3]
        print("  " + "".join(f"{p:<52}" for p in row))

    print("\n--- 导出组件 (exported=true) ---")
    for kind in ("activities", "services", "receivers", "providers"):
        exported = [c for c in s[kind] if c["exported"] is True]
        if not exported:
            continue
        print(f"  [{kind}] {len(exported)} 个")
        for c in exported:
            extra = f" authorities={c['authorities']}" if c["authorities"] else ""
            perm = f" permission={c['permission']}" if c["permission"] else ""
            print(f"    {c['name']}{extra}{perm}")

    print("\n--- 自定义权限 ---")
    for p in s["declaredPermissions"]:
        print(f"  {p['name']}  (protectionLevel={p['protectionLevel']})")


def main() -> int:
    ap = argparse.ArgumentParser(description="解析 aapt xmltree 导出的 AndroidManifest")
    ap.add_argument("xmltree", help="aapt dump xmltree 的输出文件")
    ap.add_argument("-o", "--output", help="把摘要写入 JSON")
    args = ap.parse_args()

    with open(args.xmltree, encoding="utf-8", errors="replace") as fh:
        text = fh.read()

    summary = summarize(parse_xmltree(text))
    print_report(summary)

    if args.output:
        with open(args.output, "w", encoding="utf-8") as fh:
            json.dump(summary, fh, ensure_ascii=False, indent=2)
        print(f"\n[+] JSON 摘要已写入 {args.output}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
