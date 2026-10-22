# -*- coding: utf-8 -*-
"""深挖 FUN_00179284：完整伪代码 + 调用图 + 常量表。"""
import os
import pyghidra
pyghidra.start()
from ghidra.base.project import GhidraProject
from ghidra.app.decompiler import DecompInterface
from ghidra.util.task import ConsoleTaskMonitor
OUT = os.environ.get('BLOB_OUT', '/tmp')
proj = GhidraProject.openProject('/home/ylxc/Projects/lib/ShanDong/work/ghidra_htp', 'htpproj', False)
prog = prog_ = proj.openProgram('/', 'libNetHTProtect.so', True)
fm = prog.getFunctionManager(); af = prog.getAddressFactory()
refm = prog.getReferenceManager()
di = DecompInterface(); di.openProgram(prog); mon = ConsoleTaskMonitor()
L = []

f = fm.getFunctionAt(af.getAddress('0x179284'))
L.append('════ FUN_00179284 完整伪代码 (%d 字节) ════' % f.getBody().getNumAddresses())
res = di.decompileFunction(f, 300, mon)
code = ''
if res.decompileCompleted():
    code = res.getDecompiledFunction().getC()
    L.append(code)
    open(os.path.join(OUT, 'slot0_full.c'), 'w').write(code)

# 调用图
L.append('')
L.append('════ 直接调用 ════')
seen = set(); calls = []
it = f.getBody().getAddresses(True)
while it.hasNext():
    a2 = it.next()
    for r in refm.getReferencesFrom(a2):
        tf = fm.getFunctionAt(r.getToAddress())
        if tf and tf.getEntryPoint().toString() != f.getEntryPoint().toString():
            k = tf.getEntryPoint().toString()
            if k not in seen:
                seen.add(k); calls.append((k, tf.getName(), tf.getBody().getNumAddresses()))
for c in calls[:40]:
    L.append('  %s %s  %d 字节' % c)

# 反编译被调用的关键函数（体积 100-2000）
L.append('')
for a3, nm, sz in calls:
    if not (80 <= sz <= 2500): continue
    f2 = fm.getFunctionAt(af.getAddress(a3))
    if not f2: continue
    # 只挑「看起来像变换的」（含位运算）
    ins = prog.getListing().getInstructions(f2.getBody(), True)
    n_rot = n_eor = n_tot = 0
    while ins.hasNext():
        i = ins.next(); m = i.getMnemonicString().lower(); n_tot += 1
        if 'ror' in m or 'rev' in m or 'extr' in m: n_rot += 1
        elif m.startswith('eor'): n_eor += 1
    score = (n_rot * 8 + n_eor * 3) / max(1, n_tot)
    if score < 0.05: continue
    res2 = di.decompileFunction(f2, 200, mon)
    if not res2.decompileCompleted(): continue
    code2 = res2.getDecompiledFunction().getC()
    L.append('════ %s %s (score=%.2f rot=%d eor=%d/%d) ════' % (a3, nm, score, n_rot, n_eor, n_tot))
    L.append(code2[:2000])
    open(os.path.join(OUT, 'called_%s.c' % a3), 'w').write(code2)
    L.append('')
open(os.path.join(OUT, 'slot0_deep.txt'), 'w').write('\n'.join(L))
print('\n'.join(L[:200]))
proj.close()
