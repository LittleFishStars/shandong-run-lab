# -*- coding: utf-8 -*-
"""反编译指定函数并导出伪代码。"""
import os, sys
import pyghidra
pyghidra.start()
from ghidra.base.project import GhidraProject
from ghidra.app.decompiler import DecompInterface, DecompileOptions
from ghidra.util.task import ConsoleTaskMonitor

proj = GhidraProject.openProject('/home/ylxc/Projects/lib/ShanDong/work/native/ghidra_blob', 'blobproj', False)
prog = proj.openProgram('/', 'so_0x7cb2d9d000.bin', True)

targets = sys.argv[1:] if len(sys.argv) > 1 else ['0009be9c','0007c9f8']
out = os.environ.get('BLOB_OUT', '/tmp')

di = DecompInterface()
opts = DecompileOptions()
di.setOptions(opts)
di.openProgram(prog)
mon = ConsoleTaskMonitor()
fm = prog.getFunctionManager()
af = prog.getAddressFactory()

os.makedirs(out, exist_ok=True)
for t in targets:
    a = af.getAddress(t)
    f = fm.getFunctionAt(a) or fm.getFunctionContaining(a)
    if not f:
        print('未找到函数 @', t); continue
    res = di.decompileFunction(f, 120, mon)
    if not res.decompileCompleted():
        print('反编译失败', t, res.getErrorMessage()); continue
    code = res.getDecompiledFunction().getC()
    path = os.path.join(out, 'decomp_%s.c' % t)
    with open(path, 'w', encoding='utf-8') as fh:
        fh.write('// %s  %s\n' % (f.getEntryPoint(), f.getName()))
        fh.write(code)
    print('════════ %s (%s) %d 字节 ════════' % (t, f.getName(), f.getBody().getNumAddresses()))
    print(code[:3500])
    print()
proj.close()
