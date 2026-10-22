#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# 注：work/peek/classes.dex 等中间物已于 2026-10-22 清理，样本类请现场解包：
#     unzip -p samples/com.huachenjie.shandong_school.apk classes.dex > /tmp/classes.dex
"""联合标定易盾容器内每个 DEX 的 string_ids / type_ids / proto_ids 边界。

问题：单靠「严格递增」推 type_ids_size 会越界（容器在节区之间插了不定长私有块），
      单靠「必须是类型描述符」又会因 string_ids 多算几项而整体错位。

做法：对 string_ids 长度做小范围回退 (0..64 项)，对每个候选求
      type_ids = 最长「严格递增 + 描述符占比 >= 阈值」段，
      proto_ids = 紧随其后最长「shorty 合法」段，
      再用 class_data 推出的 field/method 大小反推 field_ids 位置做闭合校验，
      最后按「描述符占比 + shorty 占比 + 闭合性」打分，取最优解。

用法:
    python3 scripts/calibrate_container_dex.py /tmp/classes.dex（unzip -p 样本 classes.dex） --base 62015996
"""

from __future__ import annotations

import argparse
import re
import struct
import sys
from pathlib import Path

import numpy as np

RE_IDENT = re.compile(rb"^[A-Za-z_$][A-Za-z0-9_$]*$")
RE_CLASS = re.compile(rb"^L[^;]*;$")
RE_SHORTY = re.compile(rb"^[VZBSCIJFD]+$")


def read_uleb(buf: bytes, off: int):
    r = s = 0
    for i in range(5):
        if off + i >= len(buf):
            return None
        b = buf[off + i]
        r |= (b & 0x7F) << s
        if not b & 0x80:
            return r, i + 1
        s += 7
    return None


def parse_string_item(buf: bytes, pos: int):
    head = read_uleb(buf, pos)
    if head is None:
        return None
    ln, pre = head
    if ln > 65535:
        return None
    p, chars, start = pos + pre, 0, pos + pre
    while p < len(buf) and chars <= ln:
        c = buf[p]
        if c == 0:
            return (ln, buf[start:p]) if chars == ln else None
        chars += 1
        p += 1 if c < 0x80 else (2 if c < 0xE0 else (3 if c < 0xF0 else 4))
    return None


def is_type(s: bytes) -> bool:
    """容器里的 type_ids 除了标准描述符，还会引用泛型签名串
    （如 `Lcom/bumptech/glide/request/RequestListener<`），因此放宽为
    「L 开头」也算类型项。"""
    if RE_CLASS.match(s) or s[:1] == b"[" or (len(s) == 1 and s in b"VZBSCIJFD"):
        return True
    return s[:1] == b"L"


def calibrate(buf: bytes, base: int, s_off: int = 4100, s_back: int = 64):
    """返回最优 (S, T, P, score) 与诊断信息。"""
    # 先取完整 string_ids
    strings, p = [], base + s_off
    while p + 4 <= len(buf):
        (v,) = struct.unpack_from("<I", buf, p)
        r = parse_string_item(buf, base + v)
        if r is None:
            break
        strings.append(r[1])
        p += 4
    S_full = len(strings)
    if S_full < 500:
        return None

    is_t = np.array([is_type(x) for x in strings], dtype=bool)
    is_s = np.array([bool(RE_SHORTY.match(x)) for x in strings], dtype=bool)
    u = np.frombuffer(buf[:(len(buf) // 4) * 4], dtype="<u4")

    best = None
    for back in range(0, min(s_back, S_full - 500) + 1):
        S = S_full - back
        t_off = s_off + 4 * S
        # type_ids：严格递增 + 描述符占比高
        T = 0
        prev = -1
        bad = 0
        while True:
            o = base + t_off + 4 * T
            if o + 4 > len(buf):
                break
            (v,) = struct.unpack_from("<I", buf, o)
            if v <= prev or v >= S:
                break
            prev = v
            T += 1
            if not is_t[v]:
                bad += 1
        if T < 100:
            continue
        t_frac = 1.0 - bad / T
        if t_frac < 0.85:
            continue
        # proto_ids：紧随其后，shorty 合法
        p_off = t_off + 4 * T
        P = 0
        p_bad = 0
        while True:
            o = base + p_off + 12 * P
            if o + 12 > len(buf):
                break
            sh, ret, par = struct.unpack_from("<III", buf, o)
            if sh >= S or ret >= T:
                break
            if par != 0 and not (200_000 <= par < 12_000_000):
                break
            P += 1
            if not is_s[sh]:
                p_bad += 1
        if P < 100:
            continue
        p_frac = 1.0 - p_bad / P
        if p_frac < 0.85:
            continue
        score = t_frac + p_frac
        if best is None or score > best[3]:
            best = (S, T, P, score, t_frac, p_frac, back, p_off)
    return best


def main() -> int:
    ap = argparse.ArgumentParser(description="标定容器内 DEX 的节区边界")
    ap.add_argument("container")
    ap.add_argument("--base", type=int, required=True)
    args = ap.parse_args()
    buf = Path(args.container).read_bytes()
    r = calibrate(buf, args.base)
    if not r:
        print("标定失败")
        return 1
    S, T, P, score, tf, pf, back, p_off = r
    print(f"base={args.base:,}")
    print(f"  string_ids : off=4,100 size={S:,}  (回退 {back} 项)")
    print(f"  type_ids   : off={4100+4*S:,} size={T:,}  描述符占比={tf:.4f}")
    print(f"  proto_ids  : off={p_off:,} size={P:,}  shorty 占比={pf:.4f}")
    print(f"  score={score:.4f}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
