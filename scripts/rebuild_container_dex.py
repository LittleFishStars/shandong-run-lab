#!/usr/bin/env python3
# -*- coding: utf-8 -*-
# 注：work/peek/classes.dex 等中间物已于 2026-10-22 清理，样本类请现场解包：
#     unzip -p samples/com.huachenjie.shandong_school.apk classes.dex > /tmp/classes.dex
"""针对易盾容器中「独立 DEX」的重建器（放宽版）。

与 rebuild_dex.py 的差别：
    容器里内嵌了**多个独立 DEX**（各自有自己的基址与 string_ids）。
    实测发现它们的 type_ids 前若干项会指向泛型签名串（如
    `Lcom/bumptech/glide/request/RequestListener<`）而非合法类型描述符，
    因此严格谓词会把 type_ids 判成 0 项。本脚本放宽为 DEX 规范的真正约束：
        type_ids 只要求「严格递增且 < string_ids_size」；
    其余节区仍用语义谓词校验，并用**已知的 class_defs 偏移反推校验**。

用法:
    python3 scripts/rebuild_container_dex.py /tmp/classes.dex（unzip -p 样本 classes.dex） \\
        --base 62015996 --class-defs-off 1672804 --out work/rebuilt/dex_09.dex
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
RE_METHOD = re.compile(rb"^([A-Za-z_$][A-Za-z0-9_$]*|<init>|<clinit>)$")
RE_SHORTY = re.compile(rb"^[VZBSCIJFD]+$")
RE_CLASS = re.compile(rb"^L[A-Za-z0-9_$/]+;$")


def read_uleb128(buf: bytes, off: int):
    result = shift = 0
    for i in range(5):
        if off + i >= len(buf):
            return None
        b = buf[off + i]
        result |= (b & 0x7F) << shift
        if not b & 0x80:
            return result, i + 1
        shift += 7
    return None


def parse_string_data_item(buf: bytes, pos: int):
    head = read_uleb128(buf, pos)
    if head is None:
        return None
    ln, prefix = head
    if ln > 65535:
        return None
    p = pos + prefix
    chars = 0
    start = p
    while p < len(buf) and chars <= ln:
        c = buf[p]
        if c == 0:
            return (ln, buf[start:p]) if chars == ln else None
        chars += 1
        p += 1 if c < 0x80 else (2 if c < 0xE0 else (3 if c < 0xF0 else 4))
    return None


class Sec:
    def __init__(self, buf: bytes, base: int):
        self.buf, self.base, self.end = buf, base, len(buf)
        self.strings: list[bytes] = []

    def s(self, i: int):
        return self.strings[i] if 0 <= i < len(self.strings) else None


def derive_strings(sec: Sec, off: int) -> list[bytes]:
    out, p = [], sec.base + off
    while p + 4 <= sec.end:
        (v,) = struct.unpack_from("<I", sec.buf, p)
        r = parse_string_data_item(sec.buf, sec.base + v)
        if r is None:
            break
        out.append(r[1])
        p += 4
    return out


def derive_types(sec: Sec, off: int, smax: int) -> list[int]:
    """放宽：仅要求严格递增且 < string 数（DEX 规范的真实约束）。"""
    out, p, prev = [], sec.base + off, -1
    while p + 4 <= sec.end:
        (v,) = struct.unpack_from("<I", sec.buf, p)
        if v <= prev or v >= smax:
            break
        out.append(v)
        prev = v
        p += 4
    return out


def valid_type_list(sec: Sec, rel: int, tmax: int) -> bool:
    if rel == 0:
        return True
    pos = sec.base + rel
    if pos + 4 > sec.end:
        return False
    (n,) = struct.unpack_from("<I", sec.buf, pos)
    if n == 0 or n > 4096 or pos + 4 + n * 2 > sec.end:
        return False
    for i in range(n):
        (t,) = struct.unpack_from("<H", sec.buf, pos + 4 + i * 2)
        if t >= tmax:
            return False
    return True


def derive_protos(sec: Sec, off: int, smax: int, tmax: int):
    out, p = [], sec.base + off
    while p + 12 <= sec.end:
        shorty, ret, params = struct.unpack_from("<III", sec.buf, p)
        s = sec.s(shorty)
        if s is None or not RE_SHORTY.match(s):
            break
        if ret >= tmax or not valid_type_list(sec, params, tmax):
            break
        out.append((shorty, ret, params))
        p += 12
    return out


def derive_fields(sec: Sec, off: int, tmax: int, smax: int):
    out, p = [], sec.base + off
    while p + 8 <= sec.end:
        cls, typ, name = struct.unpack_from("<HHI", sec.buf, p)
        if cls >= tmax or typ >= tmax:
            break
        n = sec.s(name)
        if n is None or not RE_IDENT.match(n):
            break
        out.append((cls, typ, name))
        p += 8
    return out


def derive_methods(sec: Sec, off: int, tmax: int, pmax: int, smax: int):
    out, p = [], sec.base + off
    while p + 8 <= sec.end:
        cls, proto, name = struct.unpack_from("<HHI", sec.buf, p)
        if cls >= tmax or proto >= pmax:
            break
        n = sec.s(name)
        if n is None or not RE_METHOD.match(n):
            break
        out.append((cls, proto, name))
        p += 8
    return out


def derive_classes(sec: Sec, off: int, tmax: int, smax: int, span: int):
    out, p = [], sec.base + off
    while p + 32 <= sec.end:
        (ci, acc, sup, ifc, src, ann, cdata, sval) = struct.unpack_from("<8I", sec.buf, p)
        if ci >= tmax or acc > 0x1FFFF:
            break
        if sup != NO_INDEX and sup >= tmax:
            break
        if src != NO_INDEX and (src >= smax):
            break
        if any(o != 0 and (o % 4 or o >= span) for o in (ifc, ann, cdata, sval)):
            break
        out.append((ci, acc, sup, ifc, src, ann, cdata, sval))
        p += 32
    return out


def build_map(sections, map_off):
    items = sorted(sections, key=lambda x: x[2])
    items.append((0x1000, 1, map_off))
    out = struct.pack("<I", len(items))
    for t, n, o in items:
        out += struct.pack("<HHII", t, 0, n, o)
    return out


def main() -> int:
    ap = argparse.ArgumentParser(description="重建容器内的独立 DEX（放宽版）")
    ap.add_argument("container")
    ap.add_argument("--base", type=int, required=True)
    ap.add_argument("--class-defs-off", type=int, default=None,
                    help="已知的 class_defs 相对偏移（用于反推校验）")
    ap.add_argument("--string-ids-off", type=int, default=4100)
    ap.add_argument("--data-end", type=int, default=None)
    ap.add_argument("--out", required=True)
    args = ap.parse_args()

    buf = Path(args.container).read_bytes()
    sec = Sec(buf, args.base)
    sec.strings = derive_strings(sec, args.string_ids_off)
    S = len(sec.strings)
    s_off = args.string_ids_off

    t_off = s_off + 4 * S
    types = derive_types(sec, t_off, S)
    T = len(types)
    p_off = t_off + 4 * T
    protos = derive_protos(sec, p_off, S, T)
    P = len(protos)
    f_off = p_off + 12 * P
    fields = derive_fields(sec, f_off, T, S)
    F = len(fields)
    m_off = f_off + 8 * F
    methods = derive_methods(sec, m_off, T, P, S)
    M = len(methods)
    c_off = m_off + 8 * M

    print(f"base={args.base:,}")
    print(f"  string_ids off={s_off:>10,} size={S:>9,}")
    print(f"  type_ids   off={t_off:>10,} size={T:>9,}")
    print(f"  proto_ids  off={p_off:>10,} size={P:>9,}")
    print(f"  field_ids  off={f_off:>10,} size={F:>9,}")
    print(f"  method_ids off={m_off:>10,} size={M:>9,}")
    print(f"  class_defs off={c_off:>10,} size=派生中")
    if args.class_defs_off is not None and c_off != args.class_defs_off:
        print(f"  [!] 与已知 class_defs_off={args.class_defs_off:,} 相差 {args.class_defs_off - c_off:,} 字节")
        c_off = args.class_defs_off
    classes = derive_classes(sec, c_off, T, S, sec.end - sec.base)
    C = len(classes)
    print(f"  class_defs off={c_off:>10,} size={C:>9,}")
    if classes:
        print(f"  首个类: {sec.s(types[classes[0][0]]) if types[classes[0][0]] < S else b'?'}")

    d_off = c_off + 32 * C
    data_end = args.data_end or (sec.end - args.base)

    dex_end = data_end
    body = bytearray(buf[args.base:args.base + dex_end])
    while len(body) % 4:
        body.append(0)
    map_off = len(body)
    sections = [(0x0000, 1, 0), (0x0001, S, s_off), (0x0002, T, t_off), (0x0003, P, p_off),
                (0x0004, F, f_off), (0x0005, M, m_off), (0x0006, C, c_off)]
    body += build_map(sections, map_off)
    file_size = len(body)

    hdr = bytearray(112)
    hdr[0:8] = b"dex\n035\x00"
    for o, v in [(0x20, file_size), (0x24, 112), (0x28, ENDIAN_TAG), (0x2C, 0), (0x30, 0),
                 (0x34, map_off), (0x38, S), (0x3C, s_off), (0x40, T), (0x44, t_off),
                 (0x48, P), (0x4C, p_off), (0x50, F), (0x54, f_off), (0x58, M), (0x5C, m_off),
                 (0x60, C), (0x64, c_off), (0x68, data_end - d_off), (0x6C, d_off)]:
        struct.pack_into("<I", hdr, o, v)
    body[0:112] = hdr
    sig = hashlib.sha1(bytes(body[32:])).digest()
    body[12:32] = sig
    struct.pack_into("<I", body, 8, zlib.adler32(bytes(body[12:])) & 0xFFFFFFFF)

    out = Path(args.out)
    out.parent.mkdir(parents=True, exist_ok=True)
    out.write_bytes(bytes(body))
    print(f"\n[+] 写出 {out}  file_size={file_size:,} map_off={map_off:,}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
