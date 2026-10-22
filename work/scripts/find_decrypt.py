# -*- coding: utf-8 -*-
"""定位 892KB 段的字符串解密函数：找引用加密串地址的代码。"""
import os
import pyghidra
pyghidra.start()
from ghidra.base.project import GhidraProject
from ghidra.app.decompiler import DecompInterface
from ghidra.util.task import ConsoleTaskMonitor
OUT=os.environ.get('BLOB_OUT','/tmp')
proj=GhidraProject.openProject('/home/ylxc/Projects/lib/ShanDong/work/native/ghidra_blob','blobproj',False)
prog=proj.openProgram('/','so_0x7cb2d9d000.bin',True)
fm=prog.getFunctionManager(); af=prog.getAddressFactory(); ref=prog.getReferenceManager()
di=DecompInterface(); di.openProgram(prog); mon=ConsoleTaskMonitor()
L=[]
# 已知被引用的加密串地址（从 FUN_000971f0 里看到的）
TARGETS = ['0001a021','0001a003','0001cda2','00013a90','00013a8e']
L.append('════ 引用加密串的函数 ════')
funcs=set()
for t in TARGETS:
    a=af.getAddress(t)
    n=0
    for r in ref.getReferencesTo(a):
        f=fm.getFunctionContaining(r.getFromAddress())
        if f:
            funcs.add(f); n+=1
            L.append('  0x%s ← %s @%s (%d 字节)  来自 %s'%(t,f.getName(),f.getEntryPoint(),
                     f.getBody().getNumAddresses(), r.getFromAddress()))
    if n==0: L.append('  0x%s 无引用'%t)

# 反编译这些函数，找解密逻辑
L.append('')
for f in list(funcs)[:4]:
    res=di.decompileFunction(f,120,mon)
    if res.decompileCompleted():
        code=res.getDecompiledFunction().getC()
        L.append('════ %s (%d 字节) ════'%(f.getEntryPoint(), f.getBody().getNumAddresses()))
        # 找循环 + xor/add 特征
        import re as _re
        lines=code.split('\n')
        for i,l in enumerate(lines):
            if any(k in l for k in ['0x80','0xff','& 0x7f','^','+ 0x','<< ','>> ']):
                if 'iVar' in l or 'uVar' in l or 'bVar' in l:
                    L.append('  %4d: %s'%(i, l.strip()[:140]))
        L.append('')
open(os.path.join(OUT,'decrypt_locate.txt'),'w').write('\n'.join(L))
print('\n'.join(L[:80]))
proj.close()
