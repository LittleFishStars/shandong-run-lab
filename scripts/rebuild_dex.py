#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""从被加固的 classes.dex 明文中重建原始 DEX 文件。

背景（见 report/01-初步分析.md）：
    网易易盾把原始 DEX 的 112 字节头部销毁，并把多份 DEX 主体首尾相接塞进
    classes.dex 尾部。载荷中的 index 区与 data 区仍是明文，但 `map_list` 已不可用，
    因此本脚本**不依赖 map**，而是用各节区自身的**语义约束**逐段反推边界：

      string_ids : u32 偏移数组，每项必须指向合法的 string_data_item
      type_ids   : u32 数组，值为 string_ids 下标；DEX 要求按描述符排序
                   -> **严格递增**，且对应字符串必须是合法类型描述符
      proto_id   : 12B；shorty_idx 指向的字符串只能是 "VZBSCIJFD" 组成的 shorty
      field_id   : 8B；name_idx 指向的字符串必须是合法字段名
      method_id  : 8B；name_idx 指向合法方法名（含 <init>/<clinit>），proto_idx < proto 数
      class_def  : 32B；class_idx 指向 "L...;" 形式的类描述符

    重建后的头部重新计算 SHA-1 signature 与 Adler-32 checksum，
    并在文件末尾补一个合成的 map_list（原生 map 已丢失）。

用法:
    python3 scripts/rebuild_dex.py work/peek/classes.dex --base 85240 \\
        --string-ids-off 4100 --out work/rebuilt/classes.dex
"""

from __future__ import annotations

import argparse
import hashlib
import re
import struct
import sys
import zlib
from pathlib import Path

# DEX map_item 类型码
TYPE_HEADER_ITEM = 0x0000
TYPE_STRING_ID_ITEM = 0x0001
TYPE_TYPE_ID_ITEM = 0x0002
TYPE_PROTO_ID_ITEM = 0x0003
TYPE_FIELD_ID_ITEM = 0x0004
TYPE_METHOD_ID_ITEM = 0x0005
TYPE_CLASS_DEF_ITEM = 0x0006
TYPE_MAP_LIST = 0x1000

ENDIAN_TAG = 0x12345678
NO_INDEX = 0xFFFFFFFF

RE_IDENT = re.compile(rb"^[A-Za-z_$][A-Za-z0-9_$]*$")
RE_METHOD = re.compile(rb"^([A-Za-z_$][A-Za-z0-9_$]*|<init>|<clinit>)$")
RE_SHORTY = re.compile(rb"^[VZBSCIJFD]+$")
RE_CLASS = re.compile(rb"^L[A-Za-z0-9_$/]+;$")


# ---------------------------------------------------------------- 基础解析
def read_uleb128(buf: bytes, off: int) -> tuple[int, int] | None:
    result = 0
    shift = 0
    for i in range(5):
        if off + i >= len(buf):
            return None
        byte = buf[off + i]
        result |= (byte & 0x7F) << shift
        if not byte & 0x80:
            return result, i + 1
        shift += 7
    return None


def parse_string_data_item(buf: bytes, pos: int) -> tuple[int, bytes] | None:
    """解析 DEX string_data_item -> (UTF-16 长度, 原始字节)。"""
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
        chars += 1
        p += 1 if c < 0x80 else (2 if c < 0xE0 else (3 if c < 0xF0 else 4))
    return None


class Section:
    """保存反推结果的容器。"""

    def __init__(self, buf: bytes, base: int):
        self.buf = buf
        self.base = base
        self.end = len(buf)
        self.strings: list[bytes] = []
        self.types: list[bytes] = []      # 类型描述符

    def string_at(self, idx: int) -> bytes | None:
        return self.strings[idx] if 0 <= idx < len(self.strings) else None

    def descriptor_at(self, type_idx: int) -> bytes | None:
        if not (0 <= type_idx < len(self.types)):
            return None
        return self.types[type_idx]


def valid_type_list(sec: Section, rel_off: int, type_count: int) -> bool:
    """校验 type_list: u32 size + size 个 u16 类型下标。"""
    if rel_off == 0:
        return True
    pos = sec.base + rel_off
    if pos + 4 > sec.end:
        return False
    (size,) = struct.unpack_from("<I", sec.buf, pos)
    if size == 0 or size > 4096 or pos + 4 + size * 2 > sec.end:
        return False
    for i in range(size):
        (t,) = struct.unpack_from("<H", sec.buf, pos + 4 + i * 2)
        if t >= type_count:
            return False
    return True


# ---------------------------------------------------------------- 节区反推
def derive_string_ids(sec: Section, off: int) -> list[bytes]:
    """从 off 起逐项校验 string_ids，遇到第一个不合法项即停。"""
    vals: list[bytes] = []
    p = sec.base + off
    while p + 4 <= sec.end:
        (v,) = struct.unpack_from("<I", sec.buf, p)
        s = parse_string_data_item(sec.buf, sec.base + v)
        if s is None:
            break
        vals.append(s[1])
        p += 4
    return vals


def derive_type_ids(sec: Section, off: int) -> list[bytes]:
    """type_ids：严格递增的 string 下标，且描述符合法。"""
    vals: list[bytes] = []
    p = sec.base + off
    prev = -1
    while p + 4 <= sec.end:
        (v,) = struct.unpack_from("<I", sec.buf, p)
        if v <= prev or v >= len(sec.strings):
            break
        desc = sec.strings[v]
        # 合法类型描述符：L...; / [X / 单字符基本类型
        if not (RE_CLASS.match(desc) or desc.startswith(b"[") or
                (len(desc) == 1 and desc in b"VZBSCIJFD")):
            break
        vals.append(desc)
        prev = v
        p += 4
    return vals


def derive_proto_ids(sec: Section, off: int, type_count: int) -> list[tuple]:
    vals = []
    p = sec.base + off
    while p + 12 <= sec.end:
        shorty_idx, ret, params = struct.unpack_from("<III", sec.buf, p)
        shorty = sec.string_at(shorty_idx)
        if shorty is None or not RE_SHORTY.match(shorty):
            break
        if ret >= type_count:
            break
        if not valid_type_list(sec, params, type_count):
            break
        vals.append((shorty_idx, ret, params))
        p += 12
    return vals


def derive_field_ids(sec: Section, off: int, type_count: int):
    vals = []
    p = sec.base + off
    while p + 8 <= sec.end:
        cls, typ, name_idx = struct.unpack_from("<HHI", sec.buf, p)
        if cls >= type_count or typ >= type_count:
            break
        name = sec.string_at(name_idx)
        if name is None or not RE_IDENT.match(name):
            break
        vals.append((cls, typ, name_idx))
        p += 8
    return vals


def derive_method_ids(sec: Section, off: int, type_count: int, proto_count: int):
    vals = []
    p = sec.base + off
    while p + 8 <= sec.end:
        cls, proto, name_idx = struct.unpack_from("<HHI", sec.buf, p)
        if cls >= type_count or proto >= proto_count:
            break
        name = sec.string_at(name_idx)
        if name is None or not RE_METHOD.match(name):
            break
        vals.append((cls, proto, name_idx))
        p += 8
    return vals


def derive_class_defs(sec: Section, off: int, type_count: int):
    vals = []
    p = sec.base + off
    span = sec.end - sec.base
    while p + 32 <= sec.end:
        (class_idx, access, super_idx, interfaces_off, source_idx,
         annotations_off, class_data_off, static_values_off) = struct.unpack_from("<8I", sec.buf, p)
        desc = sec.descriptor_at(class_idx)
        if desc is None or not RE_CLASS.match(desc):
            break
        if access > 0x1FFFF:          # 只有已知的访问标志位
            break
        if super_idx != NO_INDEX and sec.descriptor_at(super_idx) is None:
            break
        if source_idx != NO_INDEX and sec.string_at(source_idx) is None:
            break
        if any(o != 0 and o >= span for o in
               (interfaces_off, annotations_off, class_data_off, static_values_off)):
            break
        vals.append((class_idx, access, super_idx, interfaces_off, source_idx,
                     annotations_off, class_data_off, static_values_off))
        p += 32
    return vals


# ---------------------------------------------------------------- 组装
def build_map_list(sections: list[tuple[int, int, int]], map_off: int) -> bytes:
    items = sorted(sections, key=lambda s: s[2])
    items.append((TYPE_MAP_LIST, 1, map_off))
    out = struct.pack("<I", len(items))
    for t, size, off in items:
        out += struct.pack("<HHII", t, 0, size, off)
    return out


def build_dex(sec: Section, sizes: dict, out_path: Path) -> dict:
    dex_end = sizes["data_off"] + sizes["data_size"]
    body = bytearray(sec.buf[sec.base:dex_end])

    while len(body) % 4:
        body.append(0)
    map_off = len(body)
    sections = [
        (TYPE_HEADER_ITEM, 1, 0),
        (TYPE_STRING_ID_ITEM, sizes["string_ids_size"], sizes["string_ids_off"]),
        (TYPE_TYPE_ID_ITEM, sizes["type_ids_size"], sizes["type_ids_off"]),
        (TYPE_PROTO_ID_ITEM, sizes["proto_ids_size"], sizes["proto_ids_off"]),
        (TYPE_FIELD_ID_ITEM, sizes["field_ids_size"], sizes["field_ids_off"]),
        (TYPE_METHOD_ID_ITEM, sizes["method_ids_size"], sizes["method_ids_off"]),
        (TYPE_CLASS_DEF_ITEM, sizes["class_defs_size"], sizes["class_defs_off"]),
    ]
    body += build_map_list(sections, map_off)
    file_size = len(body)

    header = bytearray(112)
    header[0:8] = b"dex\n035\x00"
    fields = [
        (0x20, file_size), (0x24, 112), (0x28, ENDIAN_TAG),
        (0x2C, 0), (0x30, 0), (0x34, map_off),
        (0x38, sizes["string_ids_size"]), (0x3C, sizes["string_ids_off"]),
        (0x40, sizes["type_ids_size"]), (0x44, sizes["type_ids_off"]),
        (0x48, sizes["proto_ids_size"]), (0x4C, sizes["proto_ids_off"]),
        (0x50, sizes["field_ids_size"]), (0x54, sizes["field_ids_off"]),
        (0x58, sizes["method_ids_size"]), (0x5C, sizes["method_ids_off"]),
        (0x60, sizes["class_defs_size"]), (0x64, sizes["class_defs_off"]),
        (0x68, sizes["data_size"]), (0x6C, sizes["data_off"]),
    ]
    for off, val in fields:
        struct.pack_into("<I", header, off, val)
    body[0:112] = header

    sig = hashlib.sha1(bytes(body[32:])).digest()
    body[12:32] = sig
    chk = zlib.adler32(bytes(body[12:])) & 0xFFFFFFFF
    struct.pack_into("<I", body, 8, chk)

    out_path.parent.mkdir(parents=True, exist_ok=True)
    out_path.write_bytes(bytes(body))
    return {"file_size": file_size, "map_off": map_off, "checksum": chk,
            "sha1": sig.hex()}


def main() -> int:
    ap = argparse.ArgumentParser(description="重建被加固破坏的 DEX 头")
    ap.add_argument("container")
    ap.add_argument("--base", type=int, required=True)
    ap.add_argument("--string-ids-off", type=int, required=True)
    ap.add_argument("--data-end", type=int, default=None,
                    help="data 区结束的相对偏移（缺省=容器末尾）")
    ap.add_argument("--out", required=True)
    args = ap.parse_args()

    buf = Path(args.container).read_bytes()
    sec = Section(buf, args.base)
    sec.strings = derive_string_ids(sec, args.string_ids_off)
    s_size = len(sec.strings)

    t_off = args.string_ids_off + 4 * s_size
    sec.types = derive_type_ids(sec, t_off)
    t_size = len(sec.types)

    p_off = t_off + 4 * t_size
    protos = derive_proto_ids(sec, p_off, t_size)
    p_size = len(protos)

    f_off = p_off + 12 * p_size
    fields = derive_field_ids(sec, f_off, t_size)
    f_size = len(fields)

    m_off = f_off + 8 * f_size
    methods = derive_method_ids(sec, m_off, t_size, p_size)
    m_size = len(methods)

    c_off = m_off + 8 * m_size
    classes = derive_class_defs(sec, c_off, t_size)
    c_size = len(classes)

    d_off = c_off + 32 * c_size
    data_end = args.data_end if args.data_end else len(buf) - args.base

    print(f"[*] base={args.base:,}")
    print(f"[+] string_ids : off={args.string_ids_off:>10,} size={s_size:>10,}")
    print(f"[+] type_ids   : off={t_off:>10,} size={t_size:>10,}")
    print(f"[+] proto_ids  : off={p_off:>10,} size={p_size:>10,}")
    print(f"[+] field_ids  : off={f_off:>10,} size={f_size:>10,}")
    print(f"[+] method_ids : off={m_off:>10,} size={m_size:>10,}")
    print(f"[+] class_defs : off={c_off:>10,} size={c_size:>10,}")
    print(f"[+] data       : off={d_off:>10,} size={data_end - d_off:>10,}")

    # 样例：打印前几个类名，便于人工确认
    print("\n[*] 前 10 个类:")
    for cd in classes[:10]:
        print(f"      {sec.descriptor_at(cd[0]).decode('latin-1') if sec.descriptor_at(cd[0]) else '?'}")

    sizes = {
        "string_ids_off": args.string_ids_off, "string_ids_size": s_size,
        "type_ids_off": t_off, "type_ids_size": t_size,
        "proto_ids_off": p_off, "proto_ids_size": p_size,
        "field_ids_off": f_off, "field_ids_size": f_size,
        "method_ids_off": m_off, "method_ids_size": m_size,
        "class_defs_off": c_off, "class_defs_size": c_size,
        "data_off": d_off, "data_size": data_end - d_off,
    }
    info = build_dex(sec, sizes, Path(args.out))
    print(f"\n[+] 已写出 {args.out}")
    print(f"    file_size={info['file_size']:,} map_off={info['map_off']:,} "
          f"checksum=0x{info['checksum']:08x}")
    print(f"    signature={info['sha1']}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
