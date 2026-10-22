#!/usr/bin/env python3
"""扫描 jadx 源码，收集 `static final String NAME = "value"`，产出 类简名.NAME -> value 映射。

jadx 会把注解里的字符串常量还原成常量引用（如 @Field(AliyunLogCommon.TERMINAL_TYPE)），
核对时必须把它解析回字面量，否则会把正确反编译误判为缺注解。
结果缓存到 tmp/consts.json。
"""
import json
import re
from pathlib import Path

ROOT = Path("/home/ylxc/Projects/lib/ShanDong")
SRC = ROOT / "work/dex/jadx_FULL/sources"
OUT = ROOT / "tmp/consts.json"

FIELD = re.compile(r'static\s+final\s+String\s+(\w+)\s*=\s*"([^"]*)"')


def main():
    table = {}
    for f in SRC.rglob("*.java"):
        try:
            text = f.read_text(errors="replace")
        except OSError:
            continue
        if "static final String" not in text:
            continue
        stem = f.stem
        for name, val in FIELD.findall(text):
            table.setdefault(f"{stem}.{name}", []).append(val)
    OUT.parent.mkdir(parents=True, exist_ok=True)
    OUT.write_text(json.dumps(table, ensure_ascii=False), encoding="utf-8")
    print(f"收集常量 {len(table)} 条 -> {OUT}")


if __name__ == "__main__":
    main()
