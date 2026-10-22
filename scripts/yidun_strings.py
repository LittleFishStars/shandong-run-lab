#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""解密网易易盾壳层（com.netease.nis.wrapper）的字符串常量。

算法（还原自 a/auu/a.java 的 a.c(String)）:
    1. 自定义 Base64 解码（标准字母表 + URL-safe 变体，'=' 为填充）
    2. 与循环密钥 b"Netease" 逐字节异或
    3. 按 UTF-8 解码

用法:
    python3 scripts/yidun_strings.py <jadx_shell_sources_dir> [-o work/meta/yidun_strings.txt]
"""

from __future__ import annotations

import argparse
import base64
import re
import sys
from pathlib import Path

KEY = b"Netease"

# 匹配 a.auu.a.c("...") 形式的调用
RE_CALL = re.compile(r'a\.c\(\s*"([^"]*)"\s*\)')


def decode(text: str) -> str | None:
    """还原一条被混淆的字符串；失败返回 None。"""
    try:
        raw = base64.b64decode(text, validate=False)
    except Exception:
        return None
    out = bytes(b ^ KEY[i % len(KEY)] for i, b in enumerate(raw))
    try:
        return out.decode("utf-8")
    except UnicodeDecodeError:
        return None


def main() -> int:
    ap = argparse.ArgumentParser(description="解密易盾壳层字符串")
    ap.add_argument("sources", help="jadx 反编译输出目录（含 a/auu/a.java 等）")
    ap.add_argument("-o", "--output", help="结果输出文件")
    args = ap.parse_args()

    root = Path(args.sources)
    if not root.is_dir():
        print(f"[-] 目录不存在: {root}", file=sys.stderr)
        return 1

    rows: list[tuple[str, str, str]] = []
    seen: set[str] = set()
    for java in sorted(root.rglob("*.java")):
        rel = java.relative_to(root)
        if str(rel).replace("\\", "/") == "a/auu/a.java":
            continue  # 解密实现本身，没有常量
        for line_no, line in enumerate(java.read_text(encoding="utf-8", errors="replace").splitlines(), 1):
            for m in RE_CALL.finditer(line):
                enc = m.group(1)
                dec = decode(enc)
                rows.append((str(rel), f"{line_no}", f"{enc}  ->  {dec!r}"))
                seen.add(dec or "")

    for rel, line_no, text in rows:
        print(f"{rel}:{line_no}: {text}")

    print(f"\n[+] 共解密 {len(rows)} 条字符串，去重后 {len(seen)} 条")
    if args.output:
        Path(args.output).write_text(
            "\n".join(f"{r}:{l}: {t}" for r, l, t in rows), encoding="utf-8"
        )
        print(f"[+] 已写入 {args.output}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
