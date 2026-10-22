#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""在 libnesec 明文里找「指向 System.exit 字符串组」的指令（修正版：不限 dst 寄存器）。"""
from capstone import Cs, CS_ARCH_ARM64, CS_MODE_LITTLE_ENDIAN
import capstone.arm64_const as a64

W = "/home/ylxc/Projects/lib/ShanDong/work"
data = open(W + "/nesec_plain.bin", "rb").read()

TARGET_STR = {0x1434e: "java/lang/System", 0x1435f: "exit", 0x14364: "(I)V",
              0x14354: "java/lang/Runtime(x?)"}
# 已知的字符串群：把 0x14300..0x14400 里所有可打印串都列出来，看看相邻有什么
import re
sec = data[0x14300:0x14400]
for m in re.finditer(rb"[\x20-\x7e]{4,}", sec):
    print("  0x%x  %s" % (0x14300 + m.start(), m.group().decode()))

CODE = [(0x0, 0xdc000), (0xf0000, 0xf0000 + 0x11c08)]
md = Cs(CS_ARCH_ARM64, CS_MODE_LITTLE_ENDIAN)
md.detail = True
adrp = {}
hits = []

for seg_start, seg_end in CODE:
    for ins in md.disasm(data[seg_start:seg_end], seg_start):
        ops = ins.operands
        if ins.mnemonic == "adrp" and len(ops) >= 2:
            try:
                adrp[(ins.address // 4096, ops[0].reg)] = ops[1].imm
            except Exception:
                pass
            continue
        if ins.mnemonic in ("add", "ldr", "ldrb", "str") and len(ops) >= 3:
            try:
                base_reg = ops[1].reg if ops[1].type == a64.ARM64_OP_REG else None
                if base_reg is None:
                    continue
                base = adrp.get((ins.address // 4096, base_reg))
                if base is None:
                    continue
                imm = ops[2].imm if ops[2].type == a64.ARM64_OP_IMM else None
                if imm is None:
                    continue
                tgt = base + imm
                if 0x13300 <= tgt <= 0x14400:
                    hits.append((ins.address, ins.mnemonic, tgt, tgt in TARGET_STR))
            except Exception:
                pass

print("\n=== 指向 0x13300..0x14400 字符串区的指令 ===")
for a, m, t, key in hits:
    tag = " ★" if key else ""
    print("  0x%-8x %-6s -> 0x%-8x%s" % (a, m, t, tag))
print("共 %d 处，其中关键 %d 处" % (len(hits), sum(1 for h in hits if h[3])))
