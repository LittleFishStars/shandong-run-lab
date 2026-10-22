#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""在 libnesec.so 的运行时明文里找 System.exit / Runtime.exit 的引用点。
思路：先定位字符串，再扫描 adrp+add 组合把地址解出来，看哪些指令指向这些字符串。"""
from capstone import Cs, CS_ARCH_ARM64, CS_MODE_LITTLE_ENDIAN

W = "/home/ylxc/Projects/lib/ShanDong/work"
data = open(W + "/nesec_plain.bin", "rb").read()

TARGETS = [b"java/lang/System\x00", b"java/lang/Runtime\x00", b"exit\x00", b"(I)V\x00",
           b"java/lang/Process\x00", b"META-INF\x00"]

str_off = {}
for t in TARGETS:
    offs, start = [], 0
    while True:
        i = data.find(t, start)
        if i < 0:
            break
        offs.append(i)
        start = i + 1
    str_off[t.rstrip(b"\x00").decode()] = offs
    print("%-20s 出现 %d 次: %s" % (t.rstrip(b"\x00").decode(), len(offs),
                                    " ".join("0x%x" % o for o in offs[:12])))

# 只反汇编可执行段（vaddr 0..0xdc000 与 0xf0000..0x101c08）
CODE = [(0x0, 0xdc000), (0xf0000, 0xf0000 + 0x11c08)]
md = Cs(CS_ARCH_ARM64, CS_MODE_LITTLE_ENDIAN)
md.detail = True

import capstone.arm64_const as a64
adrp_map = {}
hits = []

def string_targets(off):
    """该地址附近是否是我们要找的字符串"""
    for name, offs in str_off.items():
        for o in offs:
            if off == o:
                return name
    return None

for seg_start, seg_end in CODE:
    blob = data[seg_start:seg_end]
    for ins in md.disasm(blob, seg_start):
        if ins.mnemonic == "adrp":
            try:
                reg = ins.operands[0].reg
                imm = ins.operands[1].imm
                adrp_map[(ins.address // 4096, reg)] = imm
            except Exception:
                pass
        elif ins.mnemonic in ("add", "ldr", "ldrb") and len(ins.operands) >= 3:
            try:
                page = ins.address // 4096
                dst = ins.operands[0].reg
                if ins.operands[1].reg == dst and ins.operands[2].type == a64.ARM64_OP_IMM:
                    base = adrp_map.get((page, dst))
                    if base is not None:
                        tgt = base + ins.operands[2].imm
                        s = string_targets(tgt)
                        if s:
                            hits.append((ins.address, s, tgt, ins.mnemonic))
            except Exception:
                pass

print("\n=== 指向目标字符串的指令 ===")
for a, s, t, m in hits:
    print("  0x%-8x  %-10s -> 0x%-8x (%s)" % (a, m, t, s))
print("共 %d 处" % len(hits))
