#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""破解 892 KB 安全 SDK 的字符串加密。

观察：
  · 段内有 1216 条「高位字节 + 00 结尾」的 C 字符串
  · 多条以 `de d8` 开头（前缀标记）
  · 单字节 XOR 0x9A 得到的仍是乱码 → 不是简单 XOR

本脚本系统性尝试：
  ① 单字节 XOR 全 256 值（用已知明文反推密钥）
  ② 已知明文攻击：段里有明文字符串（如 "JNI_OnLoad"、"libart.so"），
     用它反推加密方式
  ③ 逐字节差分：密文与明文的差值规律
  ④ 尝试 base-N 编码（Base64/自定义表）
"""
from __future__ import annotations

import base64
import pathlib
import re
import sys

BLOB = pathlib.Path("work/native/hidden_so3/so_0x7cb2d9d000.bin")


def cstr(data: bytes, off: int, maxlen: int = 128) -> bytes:
    e = data.find(b"\x00", off)
    if e < 0 or e - off > maxlen:
        e = off + maxlen
    return data[off:e]


def main() -> int:
    b = BLOB.read_bytes()
    print(f"blob: {len(b):,} 字节\n")

    # ═══ ① 已知明文攻击 ═══
    print("════ ① 已知明文攻击 ════")
    # 段里有明文 "JNI_OnLoad"（0x14574）与大量可读串
    # 找同一字符串的明文/密文对：先看明文字符串附近是否也有密文形态
    known = b"JNI_OnLoad"
    for m in re.finditer(re.escape(known), b):
        off = m.start()
        ctx = b[max(0, off - 32):off + 48]
        print(f"  明文 'JNI_OnLoad' @0x{off:x}")
        print(f"    上下文: {ctx}")

    # ═══ ② 收集所有加密串并尝试各种变换 ═══
    print()
    print("════ ② 加密串的变换尝试 ════")
    enc = re.findall(rb"[\x80-\xff]{4,}\x00", b)
    print(f"  加密串 {len(enc)} 条")

    # 取最长的几条做分析
    enc_sorted = sorted(set(enc), key=len, reverse=True)[:8]
    for e in enc_sorted[:3]:
        s = e[:-1]
        print(f"\n  密文 ({len(s)}B): {s.hex()}")

        # 常见变换
        cands = {
            "~b": bytes((~c) & 0xFF for c in s),
            "b^0x9A": bytes(c ^ 0x9A for c in s),
            "b-0x9A": bytes((c - 0x9A) & 0xFF for c in s),
            "0xFF-b": bytes(0xFF - c for c in s),
            "b^0x80": bytes(c ^ 0x80 for c in s),
            "b&0x7F": bytes(c & 0x7F for c in s),
            "b-0x80": bytes((c - 0x80) & 0xFF for c in s),
        }
        for nm, d in cands.items():
            try:
                t = d.decode("ascii")
                pr = sum(1 for c in d if 32 <= c < 127) / len(d)
                flag = "★" if pr == 1.0 else " "
                print(f"    {flag} {nm:8} → {t!r}")
            except UnicodeDecodeError:
                pass

    # ═══ ③ 全局搜索：找出「解出来是可打印且像标识符」的密钥 ═══
    print()
    print("════ ③ 全局暴力：单字节 XOR + 加/减常量 ════")
    best = []
    for k in range(256):
        ok = 0
        tot = 0
        for e in enc[:400]:
            s = e[:-1]
            # XOR
            d = bytes(c ^ k for c in s)
            tot += 1
            if all(32 <= c < 127 for c in d):
                ok += 1
        if ok:
            best.append((ok, k, "xor"))
    for k in range(256):
        ok = 0
        for e in enc[:400]:
            s = e[:-1]
            d = bytes((c - k) & 0xFF for c in s)
            if all(32 <= c < 127 for c in d):
                ok += 1
        if ok:
            best.append((ok, k, "sub"))
    best.sort(reverse=True)
    for ok, k, how in best[:10]:
        print(f"  {how} 0x{k:02x}: {ok}/400 条可打印")

    if not best:
        print("  ✗ 无单字节方案")

    # ═══ ④ 观察高频字节的分布（可能是多表替换）═══
    print()
    print("════ ④ 密文字节频率（找结构）════")
    from collections import Counter
    c = Counter()
    for e in enc:
        c.update(e[:-1])
    print("  最常见 16 个字节:")
    for byte, n in c.most_common(16):
        print(f"    0x{byte:02x} ({byte:3d}) ×{n}")
    print()
    print("  全部字节是否 >= 0x80? ",
          all(b_ >= 0x80 for b_ in c.keys()))
    lo = sorted(b_ for b_ in c.keys() if b_ < 0x80)
    print(f"  低于 0x80 的字节: {len(lo)} 种 {[hex(x) for x in lo[:16]]}")

    return 0


if __name__ == "__main__":
    sys.exit(main())
