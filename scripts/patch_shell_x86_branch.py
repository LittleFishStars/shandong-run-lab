#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""补丁易盾壳 DEX：把 MyJni.a()（"x86" ∈ SUPPORTED_ABIS 探测）改为恒返回 false。

目的：
    壳在 attachBaseContext 里按 `needX86So() && MyJni.a()` 决定加载
    libnesec-x86.so（x86 原生）还是 libnesec.so（arm64）。在带 ARM 转译的
    x86_64 模拟器上，x86 库加载成功但拒绝注册 JNI（导致 MyJni.load 崩溃）。
    强制走 arm64 库（经 ndk_translation 转译）即可复用真机代码路径。

补丁方式（最小侵入）：
    定位 MyJni.a() 的 code_item，把开头两条指令覆盖为
        const/4 v0, #0   ->  12 00
        return  v0       ->  0f 00
    其余指令成为死代码（无害）；然后重算 SHA-1 signature 与 Adler-32 checksum。

用法:
    python3 scripts/patch_shell_x86_branch.py <in.apk> <out.apk>
"""

from __future__ import annotations

import hashlib
import struct
import sys
import zipfile
import zlib
from pathlib import Path


def read_uleb(buf: bytes, off: int):
    r = s = 0
    for i in range(5):
        b = buf[off + i]
        r |= (b & 0x7F) << s
        if not b & 0x80:
            return r, i + 1
        s += 7
    raise ValueError("uleb128 溢出")


def parse_mutf8(raw: bytes) -> str:
    """足够用的 MUTF-8 解码（壳里目标串都是 ASCII）。"""
    return raw.decode("utf-8", "replace")


class Dex:
    def __init__(self, data: bytes):
        self.d = data
        (self.string_ids_size, self.string_ids_off) = struct.unpack_from("<II", data, 0x38)
        (self.type_ids_size, self.type_ids_off) = struct.unpack_from("<II", data, 0x40)
        (self.proto_ids_size, self.proto_ids_off) = struct.unpack_from("<II", data, 0x48)
        (self.method_ids_size, self.method_ids_off) = struct.unpack_from("<II", data, 0x58)
        (self.class_defs_size, self.class_defs_off) = struct.unpack_from("<II", data, 0x60)

    def string_at(self, idx: int) -> str:
        (off,) = struct.unpack_from("<I", self.d, self.string_ids_off + 4 * idx)
        ln, n = read_uleb(self.d, off)
        end = self.d.index(b"\x00", off + n)
        return parse_mutf8(self.d[off + n:end])

    def type_desc(self, idx: int) -> str:
        (si,) = struct.unpack_from("<I", self.d, self.type_ids_off + 4 * idx)
        return self.string_at(si)

    def find_type(self, desc: str) -> int:
        for i in range(self.type_ids_size):
            if self.type_desc(i) == desc:
                return i
        return -1

    def method_id(self, idx: int):
        cls, proto, name = struct.unpack_from("<HHI", self.d, self.method_ids_off + 8 * idx)
        return cls, proto, name

    def find_method(self, cls_desc: str, name: str, shorty: str) -> int:
        """按 类/方法名/shorty 定位 method_ids 下标。"""
        cls_t = self.find_type(cls_desc)
        for i in range(self.method_ids_size):
            c, p, n = self.method_id(i)
            if c != cls_t:
                continue
            if self.string_at(n) != name:
                continue
            (shorty_idx, ret, params) = struct.unpack_from("<III", self.d, self.proto_ids_off + 12 * p)
            if self.string_at(shorty_idx) == shorty and params == 0:
                return i
        return -1

    def find_class_data_off(self, cls_desc: str) -> int:
        cls_t = self.find_type(cls_desc)
        for i in range(self.class_defs_size):
            (ci, access, super_, ifc, src, ann, cdata, sval) = struct.unpack_from(
                "<8I", self.d, self.class_defs_off + 32 * i)
            if ci == cls_t:
                return cdata
        return 0

    def code_off_of_method(self, cls_desc: str, method_idx: int) -> int:
        """在 class_data 的 direct+virtual 方法表里找目标 method 的 code_off。"""
        cdata = self.find_class_data_off(cls_desc)
        if cdata == 0:
            return 0
        o = cdata
        counts = []
        for _ in range(4):          # static_f / instance_f / direct_m / virtual_m
            v, n = read_uleb(self.d, o)
            counts.append(v)
            o += n
        # 先跳过字段区：static + instance，每项 2 个 uleb
        for cnt in counts[:2]:
            for _ in range(cnt):
                _, n1 = read_uleb(self.d, o); o += n1
                _, n2 = read_uleb(self.d, o); o += n2
        # 再遍历方法区：direct methods, virtual methods
        for section in range(2):
            midx = 0          # 每个方法区的索引增量都从 0 重新累加
            for _ in range(counts[2 + section]):
                diff, n1 = read_uleb(self.d, o); o += n1
                _, n2 = read_uleb(self.d, o); o += n2
                code, n3 = read_uleb(self.d, o); o += n3
                midx += diff
                if midx == method_idx and code != 0:
                    return code
        return 0


def fix_dex_checksum(dex: bytearray) -> None:
    """重算签名与校验和。

    DEX 头布局：0x08 是 checksum(u32)，0x0C..0x20 是 signature(SHA-1，20 字节)。
    规则（顺序不能颠倒）：
        signature = SHA-1( dex[32:] )
        checksum  = Adler-32( dex[12:] )
    """
    struct.pack_into("<20s", dex, 12, hashlib.sha1(bytes(dex[32:])).digest())
    struct.pack_into("<I", dex, 8, zlib.adler32(bytes(dex[12:])) & 0xFFFFFFFF)


def main() -> int:
    if len(sys.argv) != 3:
        print(__doc__)
        return 1
    src, dst = Path(sys.argv[1]), Path(sys.argv[2])

    with zipfile.ZipFile(src) as zf:
        dex = bytearray(zf.read("classes.dex"))

    dx = Dex(bytes(dex))
    # 目标：com.netease.nis.wrapper.MyJni 里的 static boolean a()，shorty "()Z"
    mi = dx.find_method("Lcom/netease/nis/wrapper/MyJni;", "a", "Z")
    if mi < 0:
        print("[-] 未找到 MyJni.a()")
        return 1
    code = dx.code_off_of_method("Lcom/netease/nis/wrapper/MyJni;", mi)
    if code == 0:
        print("[-] 未找到 code_item")
        return 1
    (regs, ins, outs, tries) = struct.unpack_from("<4H", dex, code)
    (dbg, insns_size) = struct.unpack_from("<II", dex, code + 8)
    insns_off = code + 16
    print(f"[*] MyJni.a(): method_idx={mi} code_off={code}")
    print(f"    registers={regs} ins={ins} outs={outs} tries={tries} insns_size={insns_size}")
    old = struct.unpack_from("<4H", dex, insns_off)
    print(f"    原指令前 8 字节: {[hex(x) for x in old]}")
    if insns_size < 2:
        print("[-] 指令区过短，无法补丁")
        return 1

    # const/4 v0, #0  (0x12, 00)  +  return v0 (0x0f 00)
    struct.pack_into("<HH", dex, insns_off, 0x0012, 0x000F)
    fix_dex_checksum(dex)
    print(f"    补丁后: {list(struct.unpack_from('<2H', dex, insns_off))}")
    print(f"    新 checksum=0x{struct.unpack_from('<I', dex, 8)[0]:08x}")

    # 原样复制 APK，仅替换 classes.dex
    dst.parent.mkdir(parents=True, exist_ok=True)
    with zipfile.ZipFile(src) as zin, zipfile.ZipFile(dst, "w", zipfile.ZIP_DEFLATED) as zout:
        for item in zin.infolist():
            data = bytes(dex) if item.filename == "classes.dex" else zin.read(item.filename)
            zout.writestr(item, data)
    print(f"[+] 已写出 {dst}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
