# -*- coding: utf-8 -*-
"""找 DAT_005d26c8 的写入者 —— 即 4 张密钥表的初始化函数。"""
import os
import pyghidra
pyghidra.start()
from ghidra.base.project import GhidraProject
from ghidra.app.decompiler import DecompInterface
from ghidra.util.task import ConsoleTaskMonitor
proj = GhidraProject.openProject('/home/ylxc/Projects/lib/ShanDong/work/ghidra_htp', 'htpproj', False)
prog = proj.openProgram('/', 'libNetHTProtect.so', True)
fm = prog.getFunctionManager(); af = prog.getAddressFactory()
refm = prog.getReferenceManager()
di = DecompInterface(); di.openProgram(prog); mon = ConsoleTaskMonitor()
L = []

TARGETS = {
    'DAT_005d26c8 (初始化守卫)': 0x5d26c8,
    'DAT_005d2738 (FUN_0036aed4 守卫)': 0x5d2738,
    'DAT_0057d9b8 (单例指针)': 0x57d9b8,
    # 表基址
    'T1 基址 0x57c9b8': 0x57c9b8,
}
for name, addr in TARGETS.items():
    a = af.getAddress('0x%x' % addr)
    L.append('════ %s ════' % name)
    n = 0
    for r in refm.getReferencesTo(a):
        frm = r.getFromAddress()
        f = fm.getFunctionContaining(frm)
        rtype = r.getReferenceType()
        L.append('  %s  %s  by %s' % (frm, rtype, (f.getName() + ' @' + str(f.getEntryPoint())) if f else '?'))
        n += 1
    if n == 0:
        L.append('  （无直接引用 —— 可能是基址+偏移访问）')
    L.append('')

# T1 表的实际引用点（代码里用的是 &DAT_0057c9b8 + 偏移）
L.append('════ 引用 0x57c9b8 附近（表访问）的所有函数 ════')
seen = set()
for off in range(0x57c9b0, 0x57da00, 8):
    a = af.getAddress('0x%x' % off)
    for r in refm.getReferencesTo(a):
        f = fm.getFunctionContaining(r.getFromAddress())
        if f and f.getName() not in seen:
            seen.add(f.getName())
            L.append('  %s @%s  (经 0x%x)' % (f.getName(), f.getEntryPoint(), off))
open(os.environ['BLOB_OUT'] + '/init_finder.txt', 'w').write('\n'.join(L))
print('\n'.join(L[:120]))
proj.close()
