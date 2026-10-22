#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""按绝对明文偏移反汇编 nesec_plain.bin（逐 4 字节滑窗，避开数据段断流）
用法: work/toolchain/.venv-frida/bin/python work/nsdis.py 0xb1a90 18"""
import sys, os
from capstone import Cs, CS_ARCH_ARM64, CS_MODE_LITTLE_ENDIAN
md = Cs(CS_ARCH_ARM64, CS_MODE_LITTLE_ENDIAN)
d = open(os.path.join(os.path.dirname(os.path.abspath(__file__)), "nesec_plain.bin"), "rb").read()
start = int(sys.argv[1], 16)
n = int(sys.argv[2]) if len(sys.argv) > 2 else 24
for i in range(n):
    off = start + i * 4
    if off + 4 > len(d):
        break
    code = d[off:off + 4]
    ins = list(md.disasm(code, off))
    if ins:
        x = ins[0]
        print(f"  {x.address:#010x}  {code.hex()}  {x.mnemonic:<10s} {x.op_str}")
    else:
        print(f"  {off:#010x}  {code.hex()}  .word      {int.from_bytes(code, 'little'):#x}")
