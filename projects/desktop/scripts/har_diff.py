# -*- coding: utf-8 -*-
"""HAR 反向校验工具 —— 用真机抓包的请求体校验本实现的上传报文字段契约

吸收 ShandongTool har_diff.py 的方法论（与本项目的 dexdump/jadx 静态核对互补）：

    ① 把 Charles/mitmproxy 导出的 .har 丢进来，自动识别跑步链路接口；
    ② 抽出样本请求体，推导真实字段清单 / 类型 / 数量；
    ③ 与本实现的 protocol/client 构造报文做**逐字段对比**，输出差异报告；
    ④ 差异只有三类结论：字段名错 / 类型错 / 字段集不一致。

不联网、不需要 token。Android 真机抓包时注意：本实现按 Android 口径
（有 channel、platform 字符串），iOS HAR（无 channel、platform 数字、
stepList 纯数组）会出现平台差异，属预期，工具会标注。

用法：
    python scripts/har_diff.py capture.har                 # 只分析抓包
    python scripts/har_diff.py capture.har --compare       # 与本实现对齐比对
    python scripts/har_diff.py capture.har --dump uploadRunRecord   # 看样本原貌
"""
from __future__ import annotations

import argparse
import json
import sys
from pathlib import Path
from typing import Any, Dict, List, Optional

# 接口识别：URL 关键字 → 逻辑名（与 ShandongTool 同款思路）
ROUTE_KEYS = [
    ("checkSunRunConfig", "规则预检"),
    ("startSunRun_v2", "阳光跑开跑"),
    ("uploadRunRecord", "轨迹上传"),
    ("uploadStepsRecord", "步频上传"),
    ("uploadPaceRecord", "配速上传"),
    ("uploadStrideRecord", "步幅上传"),
    ("uploadPassPoint", "打卡点上报"),
    ("finishSunRun_v2", "阳光跑结算"),
    ("getUserFaceImg", "人脸底图"),
    ("oss/getToken", "OSS令牌"),
]


def route_of(url: str) -> Optional[str]:
    for key, _name in ROUTE_KEYS:
        if key in url:
            return key
    return None


def load_entries(har_path: Path) -> Dict[str, List[Dict[str, Any]]]:
    """抽出 {接口: [请求体, ...]}；解析失败/非 JSON 体跳过"""
    har = json.loads(har_path.read_text(encoding="utf-8"))
    out: Dict[str, List[Dict[str, Any]]] = {}
    for ent in har.get("log", {}).get("entries", []):
        url = ent.get("request", {}).get("url", "")
        route = route_of(url)
        if not route:
            continue
        body = ent.get("request", {}).get("postData", {}).get("text", "")
        if not body:
            continue
        try:
            data = json.loads(body)
        except Exception:
            continue
        if isinstance(data, dict):
            out.setdefault(route, []).append(data)
    return out


def field_inventory(samples: List[Dict[str, Any]]) -> Dict[str, str]:
    """从样本推导字段清单与类型（以首个样本为准，跨样本并集标注 *）"""
    inv: Dict[str, str] = {}
    for i, s in enumerate(samples):
        for k, v in s.items():
            t = type(v).__name__
            if k in inv and inv[k] != t:
                inv[k] = f"{inv[k]}|{t}"
            elif k not in inv:
                inv[k] = t
            if i > 0 and k not in samples[0]:
                inv[k] += "*"
    return inv


# ── 本实现的期望字段（与 jadx 审计同源；报告十八/二十三/二十四）──
EXPECTED: Dict[str, Dict[str, Any]] = {
    "uploadRunRecord": {
        "pois", "runRecordCode",
        # 9 个公共指纹由拦截器注入
        "modelName", "appVersion", "buildVersion", "channel", "appCode",
        "deviceId", "systemVersion", "platform", "timestamp",
    },
    "finishSunRun_v2": {
        "runRecordCode", "duration", "distance", "totalStep", "status",
        "stepInterval", "paceInterval", "targetPoints", "alignType",
        "pauseCount", "pauseTimes", "sportType", "runImgRecord", "timestamp",
    },
    "uploadPassPoint": {"targetPoints", "runRecordCode"},
}


def expected_keys(route: str) -> Optional[set]:
    return EXPECTED.get(route)


def compare(route: str, samples: List[Dict[str, Any]]) -> List[str]:
    """真机样本字段集 vs 本实现期望字段集（只对已登记的接口比对）"""
    want = expected_keys(route)
    if want is None:
        return [f"  （{route} 未登记期望字段集，跳过比对——仅展示真机清单）"]
    notes: List[str] = []
    have: set = set()
    for s in samples:
        have |= set(s)
    missing = want - have          # 真机有而我们没有
    extra = have - want            # 真机没有而我们发了
    if not missing and not extra:
        notes.append(f"  ✓ 字段集与期望完全一致（{len(have)} 键）")
    if missing:
        notes.append(f"  ✗ 真机有、本实现缺（{len(missing)}）：{sorted(missing)}")
    if extra:
        notes.append(f"  △ 真机无、本实现多（{len(extra)}）：{sorted(extra)}")
        notes.append("    （若来自 iOS HAR，channel/platform 类型差异属平台口径，见文件头注释）")
    return notes


def main(argv: Optional[List[str]] = None) -> int:
    ap = argparse.ArgumentParser(description="HAR 反向校验：真机抓包 vs 本实现报文契约")
    ap.add_argument("har", help="HAR 文件路径")
    ap.add_argument("--compare", action="store_true", help="与本实现期望字段集比对")
    ap.add_argument("--dump", metavar="ROUTE", help="打印某接口首个样本原貌")
    args = ap.parse_args(argv)

    path = Path(args.har)
    if not path.exists():
        print(f"[错误] 文件不存在：{path}")
        return 1
    entries = load_entries(path)
    if not entries:
        print("[错误] HAR 里没有识别到跑步链路接口（支持："
              + "、".join(k for k, _ in ROUTE_KEYS) + "）")
        return 1

    names = dict(ROUTE_KEYS)
    print(f"[HAR] {path.name}：识别到 {len(entries)} 个跑步链路接口\n")
    for route, samples in entries.items():
        print(f"◆ {names.get(route, route)}（{route}）：{len(samples)} 个样本")
        if args.dump == route:
            print("  样本原貌：")
            print("  " + json.dumps(samples[0], ensure_ascii=False, indent=2)
                  .replace("\n", "\n  ")[:2000])
        inv = field_inventory(samples)
        print(f"  真机字段（{len(inv)} 键）：")
        for k in sorted(inv):
            print(f"    {k:<22} {inv[k]}")
        if args.compare:
            print("  比对：")
            for line in compare(route, samples):
                print(line)
        print()
    return 0


if __name__ == "__main__":
    sys.exit(main())
