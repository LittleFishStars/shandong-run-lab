#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# 注：work/peek/classes.dex 等中间物已于 2026-10-22 清理，样本类请现场解包：
#     unzip -p samples/com.huachenjie.shandong_school.apk classes.dex > /tmp/classes.dex
"""在加固 classes.dex 的明文载荷中定位并校验原始 DEX 的节区边界。

思路：
    网易易盾把原始 DEX 的头部（112 字节）破坏/加密后，其余节区仍以明文内嵌在
    classes.dex 尾部。本脚本不依赖被破坏的头部，而是用节区自身的结构约束反推：
      * string_ids: u32 数组，每项指向本 DEX 内的 string_data_item；
        校验方式 = 用某个基址 B 去解析 "基址 + 偏移" 处是否为合法的
        (uleb128 UTF-16 长度 + 相应字节数 + 0x00) 结构，再要求字符串按
        UTF-16 码点非递减（DEX 强制 string_ids 按内容排序）。
      * type_ids: u32 数组，值为 string_ids 下标，按描述符排序 → 非递减。
      * proto_ids: 12 字节结构 (shorty_idx, return_type_idx, parameters_off)。
      * field_ids: 8 字节 (class_idx:u16, type_idx:u16, name_idx:u32)。
      * method_ids: 8 字节 (class_idx:u16, proto_idx:u16, name_idx:u32)。
      * class_defs: 32 字节结构。

用法:
    python3 scripts/probe_dex_sections.py /tmp/classes.dex（unzip -p 样本 classes.dex）
"""

from __future__ import annotations

import argparse
import struct
import sys
from pathlib import Path


def read_uleb128(buf: bytes, off: int, limit: int = 5) -> tuple[int, int] | None:
    """读取 ULEB128，返回 (值, 字节数)。"""
    result = 0
    shift = 0
    for i in range(limit):
        if off + i >= len(buf):
            return None
        byte = buf[off + i]
        result |= (byte & 0x7F) << shift
        if not byte & 0x80:
            return result, i + 1
        shift += 7
    return None


def parse_string_data_item(buf: bytes, pos: int) -> tuple[int, bytes] | None:
    """解析 DEX string_data_item，返回 (UTF-16 长度, 原始字节)。"""
    head = read_uleb128(buf, pos)
    if head is None:
        return None
    utf16_len, prefix = head
    if utf16_len > 65535:
        return None
    p = pos + prefix
    chars = 0
    start = p
    while p < len(buf) and chars <= utf16_len:
        c = buf[p]
        if c == 0:
            return (utf16_len, buf[start:p]) if chars == utf16_len else None
        if c < 0x80:
            chars += 1
            p += 1
        elif c < 0xE0:
            chars += 1
            p += 2
        elif c < 0xF0:
            chars += 1
            p += 3
        else:
            chars += 1
            p += 4
    return None


def locate_base(buf: bytes, array_off: int, sample: int = 60, search: int = 1_500_000) -> list[tuple[int, int]]:
    """扫描候选基址，返回 (命中数, 基址) 列表（降序）。"""
    ids = struct.unpack_from(f"<{sample}I", buf, array_off)
    found: list[tuple[int, int]] = []
    for base in range(0, search):
        hit = 0
        for v in ids:
            if parse_string_data_item(buf, base + v):
                hit += 1
        if hit >= sample * 0.8:
            found.append((hit, base))
    found.sort(reverse=True)
    return found


def main() -> int:
    ap = argparse.ArgumentParser(description="定位加固 DEX 载荷中的节区边界")
    ap.add_argument("dex", help="classes.dex 路径")
    args = ap.parse_args()

    buf = Path(args.dex).read_bytes()

    # 已由前序分析确定的 string_ids 数组起点
    array_off = 89_340
    print(f"[*] 待验证的 string_ids 数组起点: {array_off:,}（位于 112 字节头之后）")

    # ---- 1. 基址校验 ----
    base_scores = locate_base(buf, array_off, sample=60, search=200_000)
    print(f"[*] 小范围基址扫描结果 (命中/60): {base_scores[:5]}")

    best = base_scores[0] if base_scores else (0, array_off - 112)
    base = best[1]
    ids_count = (369_920 - array_off) // 4
    print(f"[+] 采用基址 B={base:,}，string_ids 条目数 (由数组长度推算) = {ids_count:,}")

    # ---- 2. 全量校验 string_ids ----
    ids = struct.unpack_from(f"<{ids_count}I", buf, array_off)
    parsed: list[bytes] = []
    bad = 0
    for v in ids:
        r = parse_string_data_item(buf, base + v)
        if r:
            parsed.append(r[1])
        else:
            bad += 1
    print(f"[+] string_ids 全量解析: 成功 {len(parsed):,} / 失败 {bad:,} "
          f"({len(parsed) / ids_count:.2%})")

    # 排序性校验（DEX 要求 string_ids 按 MUTF-8 字节序严格递增）
    non_sorted = sum(1 for a, b in zip(parsed, parsed[1:]) if a > b)
    print(f"[+] string_ids 排序性: 逆序对 {non_sorted:,} 处 "
          f"({'符合 DEX 约束' if non_sorted == 0 else '存在逆序，需复核'})")
    print(f"[+] 字符串样例: {[p[:48] for p in parsed[:3]]}")

    # ---- 3. type_ids 边界 ----
    t_off = 369_920
    vals = struct.unpack_from("<200000I", buf, t_off)
    run = 1
    for i in range(1, len(vals)):
        if vals[i] < vals[i - 1] or vals[i] >= ids_count:
            break
        run += 1
    print(f"\n[+] type_ids 起点 {t_off:,}，非递减且 < string_ids_size 的连续长度 = {run:,}")
    print(f"    前 8 值: {vals[:8]}")
    print(f"    末 4 值: {vals[run - 4:run]}")
    print(f"    推断 type_ids_size = {run:,} → proto_ids_off = {t_off + 4 * run:,}")

    print("\n[!] 下一步：用上述边界逐个反推 proto_ids / field_ids / method_ids / class_defs / data，"
          "重建 112 字节 DEX 头后即可用 jadx 正常反编译。")
    return 0


if __name__ == "__main__":
    sys.exit(main())
