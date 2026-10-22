# -*- coding: utf-8 -*-
"""分析 libNetHTProtect.so：定位 signRequest 实现（+0x24926c）并反编译。"""
import os
import pyghidra
pyghidra.start()
from ghidra.base.project import GhidraProject
from ghidra.app.decompiler import DecompInterface
from ghidra.util.task import ConsoleTaskMonitor
OUT = os.environ.get('BLOB_OUT', '/tmp')
proj = GhidraProject.openProject('/home/ylxc/Projects/lib/ShanDong/work/ghidra_htp', 'htpproj', False)
prog = proj.openProgram('/', 'libNetHTProtect.so', True)
fm = prog.getFunctionManager(); af = prog.getAddressFactory()
L = []
ib = prog.getImageBase()
L.append('映像基址: %s' % ib)
L.append('函数数: %d' % fm.getFunctionCount())
L.append('内存块:')
for b in prog.getMemory().getBlocks():
    L.append('   %-22s %s - %s  %9d  %s' % (b.getName(), b.getStart(), b.getEnd(), b.getSize(), 'X' if b.isExecute() else '-'))

# 目标：运行时偏移 0x24926c → Ghidra 地址 = imageBase + 0x24926c
TARGETS = [('signRequest#1', 0x24926c), ('signRequest#2', 0x2493ac)]
di = DecompInterface(); di.openProgram(prog); mon = ConsoleTaskMonitor()
for nm, off in TARGETS:
    addr = ib.add(off)
    f = fm.getFunctionContaining(addr)
    L.append('')
    L.append('════ %s  运行时偏移 0x%x → %s ════' % (nm, off, addr))
    if f:
        L.append('  函数: %s @%s  大小 %d 字节' % (f.getName(), f.getEntryPoint(), f.getBody().getNumAddresses()))
        res = di.decompileFunction(f, 180, mon)
        if res.decompileCompleted():
            code = res.getDecompiledFunction().getC()
            L.append(code[:4000])
            open(os.path.join(OUT, 'signreq_%s.c' % nm.replace('#','_')), 'w').write(code)
    else:
        L.append('  （该地址无函数 —— 可能是内联/数据）')
open(os.path.join(OUT, 'htp_analysis.txt'), 'w').write('\n'.join(L))
print('\n'.join(L[:150]))
proj.close()
