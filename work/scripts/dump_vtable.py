# -*- coding: utf-8 -*-
"""Dump 单例的 vtable（PTR_FUN_0056e7c0）所有槽位。"""
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
mem = prog.getMemory()
di = DecompInterface(); di.openProgram(prog); mon = ConsoleTaskMonitor()
L = []

VT = 0x56e7c0
L.append('════ vtable @0x%x 前 32 槽 ════' % VT)
targets = []
for i in range(32):
    a2 = af.getAddress('0x%x' % (VT + i * 8))
    try:
        p = mem.getLong(a2) & 0xffffffffffffffff
    except Exception as e:
        L.append('  [+0x%02x] 读失败 %s' % (i * 8, e)); continue
    fa = af.getAddress('0x%x' % p)
    f = fm.getFunctionAt(fa) or fm.getFunctionContaining(fa)
    nm = f.getName() if f else '(非函数/数据)'
    sz = f.getBody().getNumAddresses() if f else 0
    L.append('  [+0x%02x] %#x  %s  %d 字节' % (i * 8, p, nm, sz))
    if f:
        targets.append(('slot%d' % i, p, nm, sz))

# 反编译前 8 个有效槽
L.append('')
for tag, p, nm, sz in targets[:8]:
    f = fm.getFunctionAt(af.getAddress('0x%x' % p))
    if not f: continue
    res = di.decompileFunction(f, 200, mon)
    if not res.decompileCompleted(): continue
    code = res.getDecompiledFunction().getC()
    L.append('════ %s = %s @%#x  %d 字节 ════' % (tag, nm, p, sz))
    L.append(code[:2200])
    open(os.path.join(OUT, 'vt_%s_%x.c' % (tag, p)), 'w').write(code)
    L.append('')
open(os.path.join(OUT, 'vtable_dump.txt'), 'w').write('\n'.join(L))
print('\n'.join(L[:200]))
proj.close()
