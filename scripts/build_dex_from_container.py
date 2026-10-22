#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# 注：work/peek/classes.dex 等中间物已于 2026-10-22 清理，样本类请现场解包：
#     unzip -p samples/com.huachenjie.shandong_school.apk classes.dex > /tmp/classes.dex
"""从网易易盾容器中「完整还原」一个内嵌 DEX。

原理（逐步自洽推导，不依赖被销毁的 DEX 头与 map_list）：
    容器内每个 DEX 的布局为： [基址][4,100 字节私有头/加密区][string_ids][type_ids]
    [proto_ids][field_ids][method_ids][class_defs][data]，各节区**首尾精确相接**。
    因此只要锚定任意两个节区，其余全部可解：

      1. string_ids：数组每项 + 基址 必须落在合法 string_data_item 上 -> 得到 S 与偏移
      2. class_defs：32 字节记录（access_flags 允许为 0，class_data_off 只要求字节对齐）
      3. class_data_item 内的 encoded_method/encoded_field 增量 -> **精确**的
         method_ids_size 与 field_ids_size
      4. method_ids 中的 proto_idx 最大值 -> proto_ids_size
      5. 反向相减即得 proto_ids/field_ids/method_ids 的偏移；
         (proto_ids_off - type_ids_off) / 4 即 type_ids_size（必须整除，作为自洽校验）

用法:
    python3 scripts/build_dex_from_container.py /tmp/classes.dex（unzip -p 样本 classes.dex） \\
        --base 62015996 --class-defs-off 1555204 --out work/rebuilt/dex_09.dex
"""

from __future__ import annotations

import argparse
import hashlib
import re
import struct
import sys
import zlib
from pathlib import Path

ENDIAN_TAG = 0x12345678
NO_INDEX = 0xFFFFFFFF
RE_IDENT = re.compile(rb"^[A-Za-z_$][A-Za-z0-9_$]*$")
RE_SHORTY = re.compile(rb"^[VZBSCIJFD]+$")
RE_CLASS = re.compile(rb"^L[^;]*;$")


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


def derive_string_ids(buf: bytes, base: int, off: int):
    vals, p = [], base + off
    while p + 4 <= len(buf):
        (v,) = struct.unpack_from("<I", buf, p)
        r = parse_string_item(buf, base + v)
        if r is None:
            break
        vals.append(r[1])
        p += 4
    return vals


def derive_class_defs(buf: bytes, base: int, off: int, tmax: int, smax: int):
    """从 off 向后枚举 class_defs；access_flags 允许为 0（包级私有类）。"""
    VALID = 0x1 | 0x10 | 0x200 | 0x400 | 0x1000 | 0x2000 | 0x4000
    span = len(buf) - base
    out, p = [], base + off
    while p + 32 <= len(buf):
        ci, acc, sup, ifc, src, ann, cdata, sval = struct.unpack_from("<8I", buf, p)
        if ci >= tmax or (acc & ~VALID):
            break
        if sup != NO_INDEX and sup >= tmax:
            break
        if src != NO_INDEX and src >= smax:
            break
        if any(o != 0 and o >= span for o in (ifc, ann, cdata, sval)):
            break
        out.append((ci, acc, sup, ifc, src, ann, cdata, sval))
        p += 32
    return out


def scan_class_data(buf: bytes, base: int, cdefs) -> tuple[int, int, int, int]:
    """解析 class_data_item，返回 (field_ids_size, method_ids_size, max_code_off, max_data_off)。

    max_data_off 包含 class_defs 里的 interfaces/annotations/class_data/static_values
    偏移——它们指向 data 区，决定了重建时该拷多少字节。
    """
    max_f = max_m = max_code = -1
    max_data = 0
    for cd in cdefs:
        for o in (cd[3], cd[5], cd[6], cd[7]):
            if o != 0:
                max_data = max(max_data, o)
        cdata = cd[6]
        if cdata == 0:
            continue
        o = base + cdata
        try:
            counts = []
            for _ in range(4):
                r = read_uleb(buf, o)
                if r is None:
                    raise ValueError
                counts.append(r[0])
                o += r[1]
            for cnt in counts[:2]:                 # static + instance fields
                idx = 0
                for _ in range(cnt):
                    r = read_uleb(buf, o); idx += r[0]; o += r[1]
                    r = read_uleb(buf, o); o += r[1]
                max_f = max(max_f, idx)
            for cnt in counts[2:]:                 # direct + virtual methods
                idx = 0
                for _ in range(cnt):
                    r = read_uleb(buf, o); idx += r[0]; o += r[1]
                    r = read_uleb(buf, o); o += r[1]
                    r = read_uleb(buf, o); o += r[1]
                    if r[0]:
                        max_code = max(max_code, r[0])
                max_m = max(max_m, idx)
        except (ValueError, TypeError, IndexError):
            continue
    return max_f + 1, max_m + 1, max_code, max_data


def build_map(sections, map_off: int) -> bytes:
    items = sorted(sections, key=lambda x: x[2])
    items.append((0x1000, 1, map_off))
    out = struct.pack("<I", len(items))
    for t, n, o in items:
        out += struct.pack("<HHII", t, 0, n, o)
    return out


def main() -> int:
    ap = argparse.ArgumentParser(description="从易盾容器还原内嵌 DEX")
    ap.add_argument("container")
    ap.add_argument("--base", type=int, required=True)
    ap.add_argument("--class-defs-off", type=int, required=True)
    ap.add_argument("--string-ids-off", type=int, default=4100)
    ap.add_argument("--data-end", type=int, default=None,
                    help="data 区结束的相对偏移；缺省按 max(code_off)+256KB 估算")
    ap.add_argument("--out", required=True)
    args = ap.parse_args()

    buf = Path(args.container).read_bytes()
    base = args.base
    strings = derive_string_ids(buf, base, args.string_ids_off)
    S = len(strings)
    t_off = args.string_ids_off + 4 * S
    print(f"string_ids: off={args.string_ids_off:,} size={S:,}  -> type_ids off={t_off:,}")

    # class_defs：先用字符串数作为 type 数上限做宽松枚举，再收紧
    cdefs = derive_class_defs(buf, base, args.class_defs_off, 10 ** 9, S)
    C = len(cdefs)
    tmax = max(cd[0] for cd in cdefs) + 1
    print(f"class_defs: off={args.class_defs_off:,} size={C:,}  (class_idx 最大 {tmax-1:,})")

    f_size, m_size, max_code, max_data = scan_class_data(buf, base, cdefs)
    print(f"由 class_data 推导: field_ids_size={f_size:,}  method_ids_size={m_size:,}")
    print(f"                      max_code_off={max_code:,}  max_data_off={max_data:,}")

    m_off = args.class_defs_off - 8 * m_size
    f_off = m_off - 8 * f_size
    pmax = -1
    for i in range(m_size):
        _, proto, _ = struct.unpack_from("<HHI", buf, base + m_off + 8 * i)
        pmax = max(pmax, proto)
    p_size = pmax + 1

    # type_ids_size：用「严格递增且 < string 数」判定（容器在 type_ids 末尾会插入
    # 一段 19,064 字节的私有块，其首项是 5,554,680 这类大偏移，会触发越界）。
    T = 0
    prev = -1
    while True:
        (v,) = struct.unpack_from("<I", buf, base + t_off + 4 * T)
        if v <= prev or v >= S:
            break
        prev = v
        T += 1

    # proto_ids 紧跟在 type_ids 之后；其后再一次出现 19,064 字节私有块，
    # 然后才是 field_ids。用「proto 记录是否合法」自校验这个偏移。
    p_off = t_off + 4 * T
    if p_off + 12 * p_size > f_off:
        print(f"[-] proto_ids 超出 field_ids 起点: {p_off + 12 * p_size:,} > {f_off:,}")
        return 1
    tail_gap = f_off - (p_off + 12 * p_size)
    print(f"type_ids  : off={t_off:,} size={T:,}")
    print(f"proto_ids : off={p_off:,} size={p_size:,}")
    print(f"method_ids: off={m_off:,} size={m_size:,}  (max proto_idx {pmax:,})")
    print(f"field_ids : off={f_off:,} size={f_size:,}")
    print(f"[√] 链: type {t_off:,}+4*{T:,}={p_off:,} -> proto +12*{p_size:,}"
          f"={p_off+12*p_size:,} (+私有块 {tail_gap:,}) -> field {f_off:,}")
    print(f"[√] 链: field +8*{f_size:,}={f_off+8*f_size:,} -> method {m_off:,}"
          f" -> class_defs {args.class_defs_off:,}")
    print(f"method_ids: off={m_off:,} size={m_size:,}  (max proto_idx {pmax:,})")
    print(f"field_ids : off={f_off:,} size={f_size:,}")
    print(f"proto_ids : off={p_off:,} size={p_size:,}")
    print(f"[√] 节区链闭合: proto_off {p_off:,} == field_off {f_off:,} - 12*{p_size:,}")
    print(f"[√] 节区链闭合: {t_off}+4*{T} = {t_off+4*T:,} == proto off {p_off:,}")

    data_off = args.class_defs_off + 32 * C
    # data 区必须覆盖 max_code_off 与所有 class_defs 引用的 data 偏移
    if args.data_end:
        data_end = args.data_end
    else:
        data_end = max(max_code, max_data) + 64 * 1024
        data_end = (data_end + 3) & ~3
    data_end = max(data_end, data_off)
    print(f"data      : off={data_off:,} size={data_end-data_off:,} (结束 {data_end:,})")

    body = bytearray(buf[base:base + data_end])
    # DEX 规范要求：头部(112B)与首个节区之间，以及相邻节区之间，都是 0 填充。
    # 容器在这些位置放了自己的加密私有区，且没有任何 DEX 结构引用它们，
    # 因此可以安全清零（dexdump 会就非零填充报 "Non-zero padding"）。
    if args.string_ids_off > 112:
        body[112:args.string_ids_off] = b"\x00" * (args.string_ids_off - 112)
    for gs, ge in ((t_off + 4 * T, p_off), (p_off + 12 * p_size, f_off)):
        if ge > gs:                    # 容器在这两个位置各插了一块 19,064 字节私有区
            body[gs:ge] = b"\x00" * (ge - gs)
    while len(body) % 4:
        body.append(0)
    map_off = len(body)
    body += build_map([(0x0000, 1, 0), (0x0001, S, args.string_ids_off), (0x0002, T, t_off),
                       (0x0003, p_size, p_off), (0x0004, f_size, f_off),
                       (0x0005, m_size, m_off), (0x0006, C, args.class_defs_off)], map_off)
    file_size = len(body)

    hdr = bytearray(112)
    hdr[0:8] = b"dex\n035\x00"
    for o, v in [(0x20, file_size), (0x24, 112), (0x28, ENDIAN_TAG), (0x2C, 0), (0x30, 0),
                 (0x34, map_off), (0x38, S), (0x3C, args.string_ids_off), (0x40, T), (0x44, t_off),
                 (0x48, p_size), (0x4C, p_off), (0x50, f_size), (0x54, f_off),
                 (0x58, m_size), (0x5C, m_off), (0x60, C), (0x64, args.class_defs_off),
                 (0x68, data_end - data_off), (0x6C, data_off)]:
        struct.pack_into("<I", hdr, o, v)
    body[0:112] = hdr
    body[12:32] = hashlib.sha1(bytes(body[32:])).digest()
    struct.pack_into("<I", body, 8, zlib.adler32(bytes(body[12:])) & 0xFFFFFFFF)

    out = Path(args.out)
    out.parent.mkdir(parents=True, exist_ok=True)
    out.write_bytes(bytes(body))
    print(f"\n[+] 写出 {out}  file_size={file_size:,}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
