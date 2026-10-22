#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""修复从内存 dump 出的 DEX 的 checksum / signature。

为什么需要：运行中的 ART 会「quickening」代码项（把 iget 之类换成带偏移的
quick 变体），这会改变 DEX 字节，但不会更新头部的 Adler-32 校验和与 SHA-1
签名，导致 dexdump/jadx 报 Bad checksum。按 DEX 规范重算即可：
  checksum(offset 8)  = Adler-32(dex[12:])
  signature(offset 12) = SHA-1(dex[32:])
"""
from __future__ import annotations

import argparse
import hashlib
import pathlib
import struct
import sys
import zlib


def fix_one(path: pathlib.Path) -> tuple[bool, str]:
    b = bytearray(path.read_bytes())
    if len(b) < 32 or b[:4] != b"dex\n":
        return False, "不是 DEX"
    fs = struct.unpack_from("<I", b, 0x20)[0]
    if fs > len(b):
        return False, f"文件不完整 ({len(b):,} < {fs:,})"
    b = b[:fs]                      # 截到声明长度
    old_ck = struct.unpack_from("<I", b, 8)[0]
    new_ck = zlib.adler32(bytes(b[12:])) & 0xFFFFFFFF
    struct.pack_into("<I", b, 8, new_ck)
    new_sig = hashlib.sha1(bytes(b[32:])).digest()
    b[12:32] = new_sig
    # 签名改了，checksum 要基于含新签名的内容重算
    new_ck = zlib.adler32(bytes(b[12:])) & 0xFFFFFFFF
    struct.pack_into("<I", b, 8, new_ck)
    path.write_bytes(bytes(b))
    cls = struct.unpack_from("<I", b, 0x60)[0]
    if old_ck == new_ck:
        return True, f"checksum 本就正确 ({new_ck:#010x}) classes={cls:,}"
    return True, f"checksum {old_ck:#010x} -> {new_ck:#010x} classes={cls:,}"


def main() -> int:
    ap = argparse.ArgumentParser(description="修复 DEX checksum/signature")
    ap.add_argument("paths", nargs="+", help="DEX 文件或目录")
    args = ap.parse_args()

    files: list[pathlib.Path] = []
    for p in args.paths:
        pp = pathlib.Path(p)
        files.extend(sorted(pp.glob("*.dex")) if pp.is_dir() else [pp])

    fixed = 0
    for f in files:
        ok, msg = fix_one(f)
        print(f"  {'✓' if ok else '✗'} {f.name:<28} {msg}")
        fixed += 1 if ok else 0
    print(f"\n共处理 {fixed}/{len(files)} 个")
    return 0


if __name__ == "__main__":
    sys.exit(main())
