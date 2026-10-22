#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""枚举 nesec_plain.bin 中所有内联 svc #0，并回溯其 syscall 号。"""
import struct
from capstone import Cs, CS_ARCH_ARM64, CS_MODE_LITTLE_ENDIAN
md = Cs(CS_ARCH_ARM64, CS_MODE_LITTLE_ENDIAN)
d = open("nesec_plain.bin", "rb").read()

NAMES = {56:"openat",48:"faccessat",57:"close",63:"read",64:"write",78:"readlinkat",
         79:"newfstatat",93:"exit",94:"exit_group",97:"setpriority",113:"setresuid",
         129:"kill",160:"uname",169:"gettimeofday",172:"getpid",174:"create_key",
         198:"socket",206:"connect",207:"reboot",226:"clock_nanosleep",61:"wait4",
         62:"kill",178:"gettid",214:"brk",215:"munmap",222:"mmap",260:"wait4"}

svc = []
for off in range(0, len(d) - 3, 4):
    w = struct.unpack_from("<I", d, off)[0]
    if w == 0xD4000001:
        svc.append(off)

print(f"共 {len(svc)} 处 svc #0\n")
for s in svc:
    # 往前找最近的 movz/mov x8,#imm
    nr, mn = None, None
    for back in range(1, 5):
        o = s - back * 4
        if o < 0: break
        code = d[o:o + 4]
        ins = list(md.disasm(code, o))
        if not ins: continue
        i = ins[0]
        if i.mnemonic in ("mov", "movz") and i.op_str.replace(" ", "").startswith("x8,#"):
            try:
                nr = int(i.op_str.split("#")[1], 0)
                mn = i.mnemonic
            except Exception:
                pass
            break
    # 找调用者（bl 到包含该 svc 的桩起始处 = 往前对齐到 mov 那条）
    label = NAMES.get(nr, "?")
    print(f"  svc @ {s:#08x}   syscall x8=#{nr} ({label})")
