#!/usr/bin/env python3
# analyze_nesec.py —— 把 nesec_dump.js 抓到的运行时镜像重建成可寻址镜像，并反汇编 load (+0xa5adc)
#
# 背景：
#   libnesec.so 磁盘镜像是全局加密的（熵 7.08），只有运行时才解密。
#   Frida 在 RegisterNatives 回调里把每个 r-x/rw 段按 128 KB 分块落地，
#   文件名形如 dump_nesec_x_0x<段偏移>_0x<块内偏移>.bin.bin。
#   本脚本按段偏移重建一张 vaddr → 字节 的映射表，然后反汇编。
#
# 用法：
#   python3 work/analyze_nesec.py             # 反汇编 load 并统计
#   python3 work/analyze_nesec.py 0xa5000 400 # 指定地址与条数

import re
import sys
from pathlib import Path

WORK = Path(__file__).resolve().parent
DUMP_RE = re.compile(r"dump_nesec_([xr])_0x([0-9a-f]+)_0x([0-9a-f]+)\.bin\.bin$")

try:
    from capstone import Cs, CS_ARCH_ARM64, CS_MODE_LITTLE_ENDIAN, CS_OP_IMM
except ImportError:
    sys.exit("缺少 capstone：work/toolchain/.venv-frida/bin/pip install capstone")


def load_image() -> dict[int, int]:
    """把分块 dump 拼成 vaddr → 字节 的稀疏映射。"""
    mem: dict[int, int] = {}
    files = sorted(WORK.glob("dump_nesec_*.bin.bin"))
    if not files:
        sys.exit("找不到 dump_nesec_*.bin.bin —— 先跑 work/nesec_dump.js")
    segs: dict[int, bytearray] = {}
    for f in files:
        m = DUMP_RE.search(f.name)
        if not m:
            continue
        seg = int(m.group(2), 16)
        blk = int(m.group(3), 16)
        data = f.read_bytes()
        segs.setdefault(seg, bytearray())
        buf = segs[seg]
        need = blk + len(data)
        if len(buf) < need:
            buf.extend(b"\x00" * (need - len(buf)))
        buf[blk:blk + len(data)] = data
    for seg, buf in sorted(segs.items()):
        for i, b in enumerate(buf):
            mem[seg + i] = b
    print(f"[*] 已装载 {len(files)} 个分块 → {len(segs)} 个段，共 {len(mem)} 字节可寻址")
    for seg, buf in sorted(segs.items()):
        print(f"    段 +0x{seg:06x}  {len(buf):>7} B")
    return mem


def disasm(mem: dict[int, int], start: int, count: int) -> list[tuple[int, str, str]]:
    md = Cs(CS_ARCH_ARM64, CS_MODE_LITTLE_ENDIAN)
    buf = bytearray()
    base = start
    for a in range(start, start + count * 4):
        buf.append(mem.get(a, 0))
    out = []
    for ins in md.disasm(bytes(buf), base):
        out.append((ins.address, ins.mnemonic, ins.op_str))
    return out


def main() -> None:
    args = sys.argv[1:]
    mem = load_image()
    start = int(args[0], 0) if args else 0xa5adc
    count = int(args[1]) if len(args) > 1 else 260

    print(f"\n═══ 反汇编 +0x{start:x}（{count} 条）═══")
    ins = disasm(mem, start, count)

    # 建立「全镜像里所有 bl 目标」表，用于把分块边界之外的目标也标出来
    bl_targets: dict[int, list[str]] = {}
    called: set[int] = set()
    for addr, mn, ops in ins:
        if mn in ("bl", "b") and ops.startswith("#0x"):
            try:
                tgt = int(ops[1:], 16)
            except ValueError:
                continue
            called.add(tgt)
            bl_targets.setdefault(tgt, []).append(f"0x{addr:x}")

    for addr, mn, ops in ins:
        mark = ""
        if mn in ("bl", "b") and ops.startswith("#0x"):
            tgt = int(ops[1:], 16)
            if tgt not in mem:
                mark = "   ← 越界（外部/PLT）"
            else:
                head = mem.get(tgt, 0)
                # PAC 序言常见：sub sp / stp x29,x30 / paciasp
                if head == 0xFD or (mem.get(tgt, 0) | (mem.get(tgt + 1, 0) << 8)) == 0xA9BF:
                    mark = "   ← 函数入口"
        print(f"  +0x{addr:x}: {mn:<10} {ops}{mark}")

    print(f"\n[*] 本段内调用了 {len(called)} 个不同目标")
    ext = sorted(t for t in called if t not in mem)
    print(f"[*] 其中 {len(ext)} 个落在镜像之外（PLT / 其他模块）：" +
          " ".join(f"0x{t:x}" for t in ext[:24]))


if __name__ == "__main__":
    main()
