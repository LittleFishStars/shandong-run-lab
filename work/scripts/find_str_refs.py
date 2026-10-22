#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""在 nesec_plain.bin 中搜索关键字符串，并用 adrp+add 配对反查其被引用的代码地址。"""
import struct, sys
from capstone import Cs, CS_ARCH_ARM64, CS_MODE_LITTLE_ENDIAN

md = Cs(CS_ARCH_ARM64, CS_MODE_LITTLE_ENDIAN)
md.detail = False
img = open("nesec_plain.bin", "rb").read()
N = len(img)

# ---------- 1. 预先建立全部 adrp+add 配对表 ----------
refs = {}   # vaddr -> [(insn_off, byte_off_after_add)]
def adrp_target(w, off):
    """返回 adrp 的目标页基址"""
    immlo = (w >> 29) & 3
    immhi = (w >> 5) & 0x7FFFF
    imm = (immhi << 2) | immlo
    if imm & (1 << 20):
        imm -= 1 << 21
    return (off & ~0xFFF) + (imm << 12)

addr2insn = {}
for off in range(0, N - 7, 4):
    w1 = struct.unpack_from("<I", img, off)[0]
    if (w1 & 0x9F000000) != 0x90000000:
        continue
    w2 = struct.unpack_from("<I", img, off + 4)[0]
    # add (64-bit, imm12, shift0): 0x91000000 掩码 0xFF800000
    if (w2 & 0xFF800000) != 0x91000000:
        continue
    r1 = w1 & 0x1F
    rn = (w2 >> 5) & 0x1F
    rd = w2 & 0x1F
    if r1 != rn or r1 != rd:
        continue
    imm12 = (w2 >> 10) & 0xFFF
    va = adrp_target(w1, off) + imm12
    addr2insn.setdefault(va, []).append(off)

def cstr(off, maxlen=120):
    e = img.find(b"\x00", off)
    if e < 0 or e - off > maxlen: e = off + maxlen
    return img[off:e]

KEYS = sys.argv[1:] or ["signature","Signature","getPackageInfo","PackageInfo","sha1","SHA1",
                        "SHA-256","sha256","MessageDigest","toByteArray","signatures",
                        "GET_SIGNATURES","getPackageManager","PackageManager","apkContentsSigners",
                        "signingInfo","digest","Digest","base.apk","zipEntry","ZipEntry","ZipFile",
                        "Landroid/content/pm/"]

for k in KEYS:
    kb = k.encode()
    print(f"\n================ 关键字: {k} ================")
    i = 0; found = 0
    while True:
        i = img.find(kb, i)
        if i < 0: break
        s = cstr(i, 160)
        # 字符串必须完整（前一个字节是 \0 或非可见）
        if i > 0 and (32 <= img[i-1] < 127):
            i += 1; continue
        found += 1
        hits = addr2insn.get(i, [])
        print(f"  str@{i:#08x}  \"{s.decode('latin1')}\"  引用点={[hex(h) for h in hits]}")
        i += 1
        if found > 25: 
            print("  ...（省略）"); break
    if found == 0: print("  （无）")
