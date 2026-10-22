#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""反汇编 libnesec.so 的运行时明文镜像（nesec_plain.bin）。"""
import sys
from capstone import Cs, CS_ARCH_ARM64, CS_MODE_LITTLE_ENDIAN

W = "/home/ylxc/Projects/lib/ShanDong/work"
data = open(W + "/nesec_plain.bin", "rb").read()
md = Cs(CS_ARCH_ARM64, CS_MODE_LITTLE_ENDIAN)

def dis(off, n=40, base=None):
    b = base if base is not None else off
    print("── 反汇编 0x%x 起 %d 条 ──" % (off, n))
    cnt = 0
    for ins in md.disasm(data[off:off + n * 4], off):
        line = "  0x%-8x %-10s %s %s" % (ins.address, ins.bytes.hex(), ins.mnemonic, ins.op_str)
        if ins.mnemonic in ("bl", "b", "ret"):
            try:
                tgt = int(ins.op_str.lstrip("#"), 16)
                line += "   → 0x%x" % tgt
            except Exception:
                pass
        print(line)
        cnt += 1

for a in sys.argv[1:] or ["0xa5adc"]:
    dis(int(a, 16))
    print()
