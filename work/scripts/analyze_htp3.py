# -*- coding: utf-8 -*-
"""追 FUN_00178090 单例 + vtable 槽 0（签名实现）。"""
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
refm = prog.getReferenceManager()
di = DecompInterface(); di.openProgram(prog); mon = ConsoleTaskMonitor()
L = []

def dec(addr, n=1, dumpsize=None):
    """反编译并返回代码"""
    f = fm.getFunctionAt(addr) or fm.getFunctionContaining(addr)
    if not f:
        return None, None
    res = di.decompileFunction(f, 240, mon)
    if not res.decompileCompleted():
        return f, None
    return f, res.getDecompiledFunction().getC()

# ① 看 FUN_00178090
for t in ['00178090', '0036aed4', '00473cdc', '00127e44']:
    f, code = dec(af.getAddress(t))
    L.append('════ %s @%s  %s ════' % (t, f.getEntryPoint() if f else '?',
                                     (str(f.getBody().getNumAddresses()) + ' 字节') if f else '?'))
    if code:
        L.append(code[:1800])
        open(os.path.join(OUT, 'f_%s.c' % t), 'w').write(code)
    L.append('')

open(os.path.join(OUT, 'htp_vt.txt'), 'w').write('\n'.join(L))
print('\n'.join(L[:160]))
proj.close()
