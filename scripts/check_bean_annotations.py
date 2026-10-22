#!/usr/bin/env python3
"""核对 bean 的 fastjson 注解：dex 的 @JSONType/@JSONField 白名单 vs jadx 源码。

推导「哪些字段会被序列化」依赖三处：
  @JSONType(includes = {...})  类级白名单
  @JSONField(serialize = false) 字段级排除
  @JSONField(name = "...")      重命名
只要 jadx 把任一条读错，上传报文的字段集就会错，因此单独核一遍。
"""
import importlib.util
import re
import sys
from pathlib import Path

ROOT = Path("/home/ylxc/Projects/lib/ShanDong")
spec = importlib.util.spec_from_file_location("capi", ROOT / "tmp/check_all_api.py")
capi = importlib.util.module_from_spec(spec)
sys.argv = [sys.argv[0]]
spec.loader.exec_module(capi)

SRC = ROOT / "work/dex/jadx_FULL/sources"

# 上传链路与结算报文里直接参与序列化的 bean
TARGETS = [
    "com/huachenjie/common/bean/RunLatLng",
    "com/huachenjie/run/bean/IntervalStep",
    "com/huachenjie/run/bean/IntervalPace",
    "com/huachenjie/common/bean/TargetPoints",
    "com/huachenjie/common/bean/UnfinishedRun",
    "com/huachenjie/run/bean/FinishRunResult",
    "com/huachenjie/run/bean/FinishFreeRunResult",
    "com/huachenjie/run/bean/UploadData",
    "com/huachenjie/common/bean/SportStatics",
]


def class_annotations(lines, desc):
    """返回 (class_annot_list, {field_name: [annotations]})"""
    idx = None
    for n, l in enumerate(lines):
        if "Class descriptor" in l and f"'{desc}'" in l:
            idx = n
            break
    if idx is None:
        return None, None
    # 注解段在本类定义之前：向上找最近的 "Class #N annotations:"
    start = None
    for n in range(idx, max(0, idx - 400000), -1):
        if re.match(r"Class #\d+ annotations:", lines[n]):
            start = n
            break
    if start is None:
        return [], {}
    cls_anns, field_anns = [], {}
    cur_field = None
    mode = None
    for l in lines[start + 1: idx]:
        if re.match(r"Class #\d+ annotations:", l) or re.match(r"Class #\d+\s+-", l):
            break
        m = re.match(r"Annotations on field #\d+ '([^']+)'", l)
        if m:
            cur_field, mode = m.group(1), "f"
            field_anns.setdefault(cur_field, [])
            continue
        if l.startswith("Annotations on"):
            cur_field, mode = None, None
            continue
        s = l.strip()
        if not s.startswith("VISIBILITY"):
            continue
        if mode == "f":
            field_anns[cur_field].append(s)
        else:
            cls_anns.append(s)
    return cls_anns, field_anns


def ann_value(ann, key):
    m = re.search(rf'{key}="?([^",]*)', ann)
    return m.group(1) if m else None


def main():
    problems = []
    remain = {rel: "L" + rel + ";" for rel in TARGETS}
    founds = {}
    for dump in sorted(ROOT.glob("tmp/classes_*.dexdump.txt")):
        if not remain:
            break
        lines = dump.read_text(errors="replace").splitlines()
        for rel, desc in list(remain.items()):
            cls_anns, field_anns = class_annotations(lines, desc)
            if cls_anns is not None:
                founds[rel] = (dump.name, cls_anns, field_anns)
                del remain[rel]
    for rel in TARGETS:
        found = founds.get(rel)
        if not found:
            problems.append(f"{rel}: 所有 dex 中都找不到该类的注解段")
            continue
        dump_name, cls_anns, field_anns = found
        # dex 侧：类级 includes、字段级 serialize=false
        dex_includes = None
        for a in cls_anns:
            if "JSONType" in a:
                m = re.search(r"includes=\{(.*?)\}", a)
                if m:
                    dex_includes = set(re.findall(r'"([^"]+)"', m.group(1)))
        dex_noserialize = set()
        dex_rename = {}
        for fname, anns in field_anns.items():
            for a in anns:
                if "JSONField" in a:
                    if "serialize=false" in a.replace(" ", ""):
                        dex_noserialize.add(fname)
                    m = re.search(r'JSONField;\s*name="([^"]+)"', a)
                    if m:
                        dex_rename[fname] = m.group(1)
        # jadx 侧
        jf = SRC / (rel + ".java")
        if not jf.exists():
            problems.append(f"{rel}: jadx 无源文件")
            continue
        text = jf.read_text(errors="replace")
        jadx_includes = None
        m = re.search(r"@JSONType\(includes\s*=\s*\{(.*?)\}\)", text, re.S)
        if m:
            jadx_includes = set(re.findall(r'"([^"]+)"', m.group(1)))
        jadx_noserialize = set()
        for fname in field_anns:
            # 字段声明行本身或紧邻上一行含 @JSONField(serialize = false)
            pat = re.search(rf"((?:@JSONField\([^)]*\)\s*)*)(?:private|public|protected)[^;]*\b{fname}\b[^;]*;", text)
            if pat and "serialize = false" in pat.group(1).replace(" ", "").replace("=", " = "):
                jadx_noserialize.add(fname)
        # 也兜底：源码里以 serialize = false 出现的字段名
        for m in re.finditer(r"@JSONField\(serialize = false\)\s*(?:private|public|protected)[^;]*?\b(\w+)\s*;", text):
            jadx_noserialize.add(m.group(1))
        if dex_includes != jadx_includes:
            problems.append(f"{rel}: @JSONType.includes dex={sorted(dex_includes or [])} jadx={sorted(jadx_includes or [])}")
        if dex_noserialize != jadx_noserialize:
            problems.append(f"{rel}: serialize=false dex={sorted(dex_noserialize)} jadx={sorted(jadx_noserialize)}")
        print(f"{rel}: 字段 {len(field_anns)} 个, dex 排除 {sorted(dex_noserialize)}, includes {sorted(dex_includes) if dex_includes else '无'}  [{dump_name}]")
    print("--- 问题 ---")
    print("\n".join(problems) if problems else "无")


if __name__ == "__main__":
    main()
