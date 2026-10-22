#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""分析被加固的 classes.dex：壳头部 + 141MB 追加载荷的结构。

背景：
    该 APK 的 classes.dex 头部只描述约 79KB 内容（30 个易盾壳类），
    文件其余 141MB 是追加载荷。本脚本用「结构指纹」而非猜测来判断载荷性质：
      1. 载荷分块的可打印字符密度 / 熵曲线 —— 区分明文与加密区
      2. DEX type_ids 指纹：type_ids 是「按描述符排序的字符串下标数组」，
         表现为一长串非递减且取值有界的 uint32 —— 若找到说明存在明文 DEX 索引结构
      3. 字符串池指纹：连续的可打印 smali 描述符（L...;）聚集区

用法:
    python3 scripts/scan_dex_payload.py <unzip -p 样本 classes.dex> [-o work/meta/dex_payload_scan.md]
"""

from __future__ import annotations

import argparse
import math
import re
import struct
import sys
from pathlib import Path

import numpy as np

DEX_HEADER_SIZE = 112
DEX_MAGIC = b"dex\n"


def dex_header(data: bytes | np.ndarray, off: int = 0) -> dict | None:
    """读取偏移处的 DEX 头（若自洽）。"""
    if off + DEX_HEADER_SIZE > len(data):
        return None
    if bytes(data[off:off + 4]) != DEX_MAGIC[:4]:
        return None
    # 从 0x08 开始连续读取 22 个 u32，索引口径见下表（DEX 头字段偏移）
    #   0:checksum(0x08) 1-5:signature(0x0C) 6:file_size(0x20) 7:header_size(0x24)
    #   8:endian_tag(0x28) 9:link_size 10:link_off 11:map_off(0x34)
    #   12:string_ids_size(0x38) 13:string_ids_off 14:type_ids_size(0x40) 15:type_ids_off
    #   16:proto_ids_size(0x48) 17:proto_ids_off 18:field_ids_size 19:field_ids_off
    #   20:method_ids_size(0x58) 21:method_ids_off
    # 另用 struct 直接取 class_defs_size/off(0x60/0x64)
    fields = struct.unpack_from("<22I", data, off + 8)
    class_defs_size, class_defs_off = struct.unpack_from("<II", data, off + 0x60)
    return {
        "checksum": fields[0],
        "file_size": fields[6],
        "header_size": fields[7],
        "endian_tag": fields[8],
        "string_ids_size": fields[12],
        "type_ids_size": fields[14],
        "proto_ids_size": fields[16],
        "class_defs_size": class_defs_size,
        "class_defs_off": class_defs_off,
        "data_size": struct.unpack_from("<I", data, off + 0x68)[0],
        "data_off": struct.unpack_from("<I", data, off + 0x6C)[0],
    }


def entropy(block: np.ndarray) -> float:
    counts = np.bincount(block, minlength=256).astype(np.float64)
    probs = counts / counts.sum()
    probs = probs[probs > 0]
    return float(-(probs * np.log2(probs)).sum())


def printable_ratio(block: np.ndarray) -> float:
    ok = ((block >= 0x20) & (block < 0x7F))
    return float(ok.mean())


def find_type_id_runs(u32: np.ndarray, min_run: int, max_value: int) -> list[tuple[int, int]]:
    """找出「非递减且取值 < max_value」的最长连续段，返回 (起始下标, 长度)。"""
    n = u32.size
    if n < 2:
        return []
    a = u32[:-1]
    diff = u32[1:].astype(np.int64) - a.astype(np.int64)
    ok = (diff >= 0) & (a < max_value)
    # 找出 ok 中的所有连续 True 段
    idx = np.flatnonzero(ok)
    if idx.size == 0:
        return []
    breaks = np.flatnonzero(np.diff(idx) != 1)
    starts = np.concatenate(([0], breaks + 1))
    ends = np.concatenate((breaks, [idx.size - 1]))
    runs = [(int(idx[s]), int(idx[e] - idx[s] + 1)) for s, e in zip(starts, ends)]
    runs = [r for r in runs if r[1] >= min_run]
    runs.sort(key=lambda r: -r[1])
    return runs


def main() -> int:
    ap = argparse.ArgumentParser(description="分析加固 classes.dex 的追加载荷结构")
    ap.add_argument("dex", help="classes.dex 路径")
    ap.add_argument("-o", "--output", help="报告输出路径 (markdown)")
    args = ap.parse_args()

    path = Path(args.dex)
    raw = path.read_bytes()
    total = len(raw)

    hdr = dex_header(raw, 0)
    if hdr is None:
        print("[-] 偏移 0 不是合法 DEX 头", file=sys.stderr)
        return 1

    # 壳 DEX 声明的内容结束位置
    data_off = struct.unpack_from("<I", raw, 0x6C)[0]
    data_size = struct.unpack_from("<I", raw, 0x68)[0]
    shell_end = data_off + data_size
    payload = raw[shell_end:]
    payload_arr = np.frombuffer(payload, dtype=np.uint8)

    lines: list[str] = []
    out = lines.append

    out("# 加固 classes.dex 载荷结构扫描\n")
    out(f"- 文件大小: {total:,} 字节")
    out(f"- 壳 DEX 头声明: file_size={hdr['file_size']:,} header_size={hdr['header_size']} "
        f"endian_tag=0x{hdr['endian_tag']:08x}")
    out(f"- 壳 DEX 索引规模: string_ids={hdr['string_ids_size']} type_ids={hdr['type_ids_size']} "
        f"proto_ids={hdr['proto_ids_size']} class_defs={hdr['class_defs_size']}")
    out(f"- 壳 DEX 内容结束于偏移 {shell_end:,}；追加载荷 {len(payload):,} 字节 "
        f"({len(payload) / total:.1%})\n")

    # ---- 1. 分块密度/熵曲线 ----
    chunk = 2 * 1024 * 1024
    out("## 1. 载荷分块特征 (每 2MB)\n")
    out("| 载荷内偏移 | 文件偏移 | 熵 | 可打印比 | 形态推断 |")
    out("|---|---|---|---|---|")
    profile: list[tuple[int, float, float]] = []
    for off in range(0, len(payload_arr), chunk):
        block = payload_arr[off:off + chunk]
        if block.size < 1024:
            break
        e = entropy(block)
        pr = printable_ratio(block)
        profile.append((off, e, pr))
        if pr > 0.75:
            shape = "明文文本/字符串池"
        elif pr > 0.4:
            shape = "明文二进制(含较多字符串)"
        elif e > 7.0:
            shape = "疑似加密/压缩"
        else:
            shape = "二进制(代码/数据)"
        out(f"| {off:,} | {shell_end + off:,} | {e:.3f} | {pr:.3f} | {shape} |")
    out("")

    # ---- 2. type_ids 指纹 ----
    u32 = np.frombuffer(payload[: (len(payload) // 4) * 4], dtype="<u4")
    runs = find_type_id_runs(u32, min_run=2000, max_value=4_000_000)
    out("## 2. DEX type_ids 指纹扫描\n")
    out("> 判据：DEX 的 type_ids 是按描述符排序的字符串下标数组，"
        "在文件中表现为一长串非递减且取值有界的 uint32。\n")
    if runs:
        out(f"发现 {len(runs)} 段可疑非递减 uint32 序列 (长度 >= 2000)：\n")
        out("| 载荷内偏移 | 文件偏移 | 连续长度 | 说明 |")
        out("|---|---|---|---|")
        for start, length in runs[:15]:
            out(f"| {start * 4:,} | {shell_end + start * 4:,} | {length:,} | 可能是 type_ids 等索引表 |")
    else:
        out("未发现长度 >= 2000 的非递减 uint32 序列 → 载荷中**不存在**完整的 DEX 索引表，"
            "索引区很可能被加密或已抽取。")
    out("")

    # ---- 3. 字符串池指纹 ----
    out("## 3. 字符串池指纹\n")
    patterns = {
        b"Lcom/huachenjie/": "应用自有类描述符",
        b"Lcom/kwad/": "快手广告 SDK",
        b"Landroid/": "Android 框架类",
        b"Ljava/lang/Object;": "java.lang.Object",
        b"onCreate": "方法名",
        b"com/netease/nis/wrapper": "易盾壳类(应只出现在壳 DEX)",
    }
    out("| 模式 | 出现次数 |")
    out("|---|---|")
    for pat, desc in patterns.items():
        out(f"| `{pat.decode()}` | {raw.count(pat):,} |")
    out("")

    # DEX magic 全局统计
    magics = [m.start() for m in re.finditer(re.escape(DEX_MAGIC), raw)]
    out(f"- 全文件 `dex\\n` magic 出现位置: {magics}（仅壳 DEX 自身）")
    valid = [o for o in magics if (h := dex_header(raw, o)) and h["header_size"] == DEX_HEADER_SIZE]
    out(f"- 自洽 DEX 头数量: {len(valid)}\n")

    report = "\n".join(lines)
    print(report)
    if args.output:
        Path(args.output).write_text(report, encoding="utf-8")
        print(f"\n[+] 已写入 {args.output}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
