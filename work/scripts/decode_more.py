# -*- coding: utf-8 -*-
"""解码 FUN_0034a644 其余的栈上 XOR 字符串 + 看 FUN_00348470（表生成器）。"""
import os, re
import pyghidra
pyghidra.start()
from ghidra.base.project import GhidraProject
from ghidra.app.decompiler import DecompInterface
from ghidra.util.task import ConsoleTaskMonitor
OUT = os.environ['BLOB_OUT']
proj = GhidraProject.openProject('/home/ylxc/Projects/lib/ShanDong/work/ghidra_htp', 'htpproj', False)
prog = prog_ = proj.openProgram('/', 'libNetHTProtect.so', True)
fm = prog.getFunctionManager(); af = prog.getAddressFactory()
di = DecompInterface(); di.openProgram(prog); mon = ConsoleTaskMonitor()

def dec(fnaddr, outname):
    f = fm.getFunctionAt(af.getAddress(fnaddr))
    if not f: return None
    res = di.decompileFunction(f, 300, mon)
    if not res.decompileCompleted(): return None
    c = res.getDecompiledFunction().getC()
    open(OUT + '/' + outname, 'w').write(c)
    return c

# FUN_00348470 = 表生成器
c = dec('00348470', 'table_gen.c')
print('════ FUN_00348470 (运行时 +0x248470) 表生成器 ════')
if c:
    print(c[:3000])
