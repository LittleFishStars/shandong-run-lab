#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""liby.so 解密后代码区的静态反汇编工具。

dump 事实（见 report/12 §9.1）：
    work/native/liby_runtime/first_load_full.bin  = 运行时 vaddr 0x1000..0x47000 的 284 KB
    偏移与 vaddr 的换算：vaddr = 文件偏移 + 0x1000

用法：
    python3 scripts/liby_disasm.py fn 0x1e320          # 反汇编整个函数
    python3 scripts/liby_disasm.py scan                # 找 JNI 风格函数入口
    python3 scripts/liby_disasm.py callers 0x200a8     # 找回边调用
"""

from __future__ import annotations

import sys
from pathlib import Path

from capstone import Cs, CS_ARCH_ARM64, CS_MODE_LITTLE_ENDIAN, CS_OP_IMM
from capstone.arm64 import ARM64_OP_REG, ARM64_REG_LR, ARM64_REG_SP

DUMP = Path(__file__).resolve().parent.parent / "work/native/liby_runtime/first_load_full.bin"
IMAGE_OFF = 0x1000          # dump 起始 vaddr
CODE_START = 0x1000         # 有效代码起点（.note.gnu.proc 解密后）
CODE_END = 0x46000          # dump 结束

MD = Cs(CS_ARCH_ARM64, CS_MODE_LITTLE_ENDIAN)
MD.detail = True


def load() -> bytes:
    return DUMP.read_bytes()


def off(vaddr: int) -> int:
    """vaddr → 文件偏移"""
    return vaddr - IMAGE_OFF


def disasm(data: bytes, vaddr: int, count: int = 4000) -> list:
    return list(MD.disasm(data[off(vaddr):], vaddr, count=count))


def fmt(insn) -> str:
    return f"0x{insn.address:06x}  {insn.mnemonic:<8s} {insn.op_str}"


def bl_targets(insns) -> dict[int, list[int]]:
    """vaddr → 它 bl 到的目标列表"""
    out: dict[int, list[int]] = {}
    for i in insns:
        if i.mnemonic not in ("bl", "b"):
            continue
        for op in i.operands:
            if op.type == CS_OP_IMM:
                out.setdefault(i.address, []).append(op.imm)
                break
    return out


def cmd_fn(vaddr: int, count: int = 4000) -> None:
    data = load()
    for i in disasm(data, vaddr, count):
        print(fmt(i))


def cmd_callers(target: int) -> None:
    """线性扫描整个代码区里的 bl，找谁调 target"""
    data = load()
    hits = []
    # 逐条线性反汇编代价高，这里用「bl 编码」精确匹配：
    #   BL imm26:  bits[31:26]=100101, 目标 = addr + imm26*4
    for o in range(off(CODE_START), off(CODE_END) - 4, 4):
        w = int.from_bytes(data[o:o + 4], "little")
        if (w >> 26) != 0b100101:
            continue
        imm = w & 0x03FFFFFF
        if imm & 0x02000000:
            imm -= 0x04000000
        src = o + IMAGE_OFF
        if src + imm * 4 == target:
            hits.append(src)
    print(f"调用 0x{target:06x} 的位置：{len(hits)} 处")
    for h in hits:
        print(f"  0x{h:06x}")


def cmd_scan() -> None:
    """找 JNI 风格函数入口：sub sp,sp,#N + stp x29,x30 + mrs x?,tpidr_el0"""
    data = load()
    cands = []
    for o in range(off(CODE_START), off(CODE_END) - 16, 4):
        insns = list(MD.disasm(data[o:o + 16], o + IMAGE_OFF, count=4))
        if len(insns) < 3:
            continue
        i0, i1 = insns[0], insns[1]
        if i0.mnemonic != "sub" or "sp, sp, #" not in i0.op_str:
            continue
        if i1.mnemonic != "stp" or "x29, x30" not in i1.op_str:
            continue
        if not any("tpidr_el0" in x.op_str for x in insns):
            continue
        cands.append(i0.address)
    print(f"JNI 风格入口候选：{len(cands)} 个")
    for c in cands:
        print(f"  0x{c:06x}")


def main(argv: list[str]) -> int:
    if len(argv) < 2:
        print(__doc__)
        return 1
    cmd = argv[1]
    if cmd == "fn":
        cmd_fn(int(argv[2], 16))
    elif cmd == "callers":
        cmd_callers(int(argv[2], 16))
    elif cmd == "scan":
        cmd_scan()
    else:
        print(__doc__)
        return 1
    return 0


if __name__ == "__main__":
    sys.exit(main(sys.argv))
