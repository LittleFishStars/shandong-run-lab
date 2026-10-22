# -*- coding: utf-8 -*-
"""反编译 signRequest 的核心函数 FUN_0034b820。"""
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
di = DecompInterface(); di.openProgram(prog); mon = ConsoleTaskMonitor()
L = []
TARGETS = ['0034b820']
# 顺带查 FUN_0034b820 调用了什么（一层调用图）
for t in TARGETS:
    f = fm.getFunctionAt(af.getAddress(t))
    if not f:
        f = fm.getFunctionContaining(af.getAddress(t))
    if not f:
        L.append('未找到 %s' % t); continue
    L.append('════ %s @%s  %d 字节 ════' % (t, f.getEntryPoint(), f.getBody().getNumAddresses()))
    # 列出直接调用
    called = []
    it = f.getBody().getAddresses(True)
    while it.hasNext():
        a2 = it.next()
        for r in prog.getReferenceManager().getReferencesFrom(a2):
            tf = fm.getFunctionAt(r.getToAddress())
            if tf and tf.getEntryPoint().toString() != f.getEntryPoint().toString():
                called.append((tf.getEntryPoint().toString(), tf.getName(), tf.getBody().getNumAddresses()))
    seen = set(); uniq = []
    for c in called:
        if c[0] in seen: continue
        seen.add(c[0]); uniq.append(c)
    L.append('  直接调用 %d 个函数:' % len(uniq))
    for a3, nm, sz in uniq[:40]:
        L.append('    %s %s  %d 字节' % (a3, nm, sz))
    res = di.decompileFunction(f, 300, mon)
    if res.decompileCompleted():
        code = res.getDecompiledFunction().getC()
        L.append('')
        L.append(code[:6000])
        open(os.path.join(OUT, 'sign_core.c'), 'w').write(code)
open(os.path.join(OUT, 'htp_core.txt'), 'w').write('\n'.join(L))
print('\n'.join(L[:200]))
proj.close()
