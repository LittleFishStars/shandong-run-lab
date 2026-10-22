#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""比较两份 capture_upload.py 采集的上传报文

用法：
    python compare_upload.py baseline.json current.json

忽略每次请求必然不同的字段（时间戳 / 记录号 / 防篡改码 / 各类时钟），
其余字段逐值比较（浮点 1e-9 容差），输出差异路径。
退出码：0 = 业务字段完全一致；1 = 有业务差异。
"""
import json
import math
import sys

IGNORE = {"timestamp", "runRecordCode", "runImgRecord", "collectTime", "createTime",
          "runTime", "clockTime", "uploadTime", "requestId", "nonce", "sign"}

diffs = []


def cmp(path, a, b):
    if isinstance(a, dict) and isinstance(b, dict):
        ka, kb = set(a) - IGNORE, set(b) - IGNORE
        for k in sorted(ka - kb):
            diffs.append(f"{path}.{k}: 仅 baseline 有（{a[k]!r}）")
        for k in sorted(kb - ka):
            diffs.append(f"{path}.{k}: 仅 current 有（{b[k]!r}）")
        for k in sorted(ka & kb):
            cmp(f"{path}.{k}", a[k], b[k])
        return
    if isinstance(a, list) and isinstance(b, list):
        if len(a) != len(b):
            diffs.append(f"{path}: 列表长度 {len(a)} != {len(b)}")
        for i in range(min(len(a), len(b))):
            cmp(f"{path}[{i}]", a[i], b[i])
        return
    if isinstance(a, float) or isinstance(b, float):
        try:
            if math.isclose(float(a), float(b), rel_tol=1e-9, abs_tol=1e-9):
                return
        except (TypeError, ValueError):
            pass
    if a != b:
        diffs.append(f"{path}: {a!r} != {b!r}")


def main(argv):
    if len(argv) != 3:
        print(__doc__)
        return 2
    b = json.load(open(argv[1], encoding="utf-8"))
    c = json.load(open(argv[2], encoding="utf-8"))
    print("记录数:", len(b), len(c))
    if [x["name"] for x in b] != [x["name"] for x in c]:
        print("!! 上传接口序列不同")
        return 1
    for i, (x, y) in enumerate(zip(b, c)):
        cmp(f"[{i}] {x['name']}", x["payload"], y["payload"])
    print("业务字段差异数:", len(diffs))
    for d in diffs[:80]:
        print(" -", d)
    return 0 if not diffs else 1


if __name__ == "__main__":
    raise SystemExit(main(sys.argv))
