# -*- coding: utf-8 -*-
"""反编译 FUN_0034a644（守卫写入者）与 FUN_001780dc（表生成器）。"""
import os
import pyghidra
pyghidra.start()
from ghidra.base.project import GhidraProject
from ghidra.app.decompiler import DecompInterface
from ghidra.util.task import ConsoleTaskMonitor
OUT = os.environ['BLOB_OUT']
proj = GhidraProject.openProject('/home/ylxc/Projects/lib/ShanDong/work/ghidra_htp', 'htpproj', False)
prog = proj.openProgram('/', 'libNetHTProtect.so', True)
fm = prog.getFunctionManager(); af = prog.getAddressFactory()
di = DecompInterface(); di.openProgram(prog); mon = ConsoleTaskMonitor()
L = []

for t in ['0034a644', '001780dc', '00178090', '0036aed4']:
    f = fm.getFunctionAt(af.getAddress(t))
    if not f: L.append('未找到 ' + t); continue
    L.append('════ FUN_%s @%s  %d 字节 ════' % (t, f.getEntryPoint(), f.getBody().getNumAddresses()))
    L.append('  运行时偏移 = 0x%x' % (int(t, 16) - 0x100000))
    res = di.decompileFunction(f, 260, mon)
    if res.decompileCompleted():
        c = res.getDecompiledFunction().getC()
        L.append(c[:3500])
        open(OUT + '/fn_%s.c' % t, 'w').write(c)
    L.append('')
open(OUT + '/deep_init.txt', 'w').write('\n'.join(L))
print('\n'.join(L[:170]))
proj.close()
