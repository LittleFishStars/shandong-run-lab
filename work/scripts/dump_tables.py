# -*- coding: utf-8 -*-
"""Dump libNetHTProtect.so 的加密查找表并识别算法。"""
import os, struct
import pyghidra
pyghidra.start()
from ghidra.base.project import GhidraProject
OUT = os.environ.get('BLOB_OUT', '/tmp')
proj = GhidraProject.openProject('/home/ylxc/Projects/lib/ShanDong/work/ghidra_htp', 'htpproj', False)
prog = proj.openProgram('/', 'libNetHTProtect.so', True)
mem = prog.getMemory()
ib = prog.getImageBase()
L = []

def rd(addr, n):
    out = bytearray()
    a2 = prog.getAddressFactory().getAddress('0x%x' % (ib.getOffset() + addr))
    for i in range(n):
        try: out.append(mem.getByte(a2.add(i)) & 0xff)
        except Exception: out.append(0)
    return bytes(out)

TABLES = [
    ('delta/key DAT_0057c970', 0x47c970, 0x40),
    ('T0 DAT_0057c9b0',        0x47c9b0, 0x10),
    ('T1 DAT_0057c9b8',        0x47c9b8, 0x400),
    ('T2 DAT_0057cdb8',        0x47cdb8, 0x400),
    ('T3 DAT_0057d1b8',        0x47d1b8, 0x400),
    ('T4 DAT_0057d5b8',        0x47d5b8, 0x400),
]
os.makedirs(os.path.join(OUT, 'tables'), exist_ok=True)
for nm, addr, n in TABLES:
    b = rd(addr, n)
    fn = os.path.join(OUT, 'tables', nm.split()[0].replace('/','_') + '.bin')
    open(fn, 'wb').write(b)
    L.append('%s @0x%x (%d 字节) → %s' % (nm, addr, n, os.path.basename(fn)))
    # 前 8 个 uint32
    vals = struct.unpack_from('<%dI' % min(8, n // 4), b, 0)
    L.append('   uint32[0:8]: ' + ' '.join('%08x' % v for v in vals))
    L.append('   hex[0:32]  : ' + b[:32].hex())
    L.append('')

# 检测是否为标准表
b1 = rd(0x47c9b8, 0x400)
b2 = rd(0x47cdb8, 0x400)
# TEA 查表实现的常见形态：T[i] = (i<<4) 或 (i>>5) 相关，或 delta 累加
L.append('════ 表性质分析 ════')
for nm, b in [('T1', b1), ('T2', b2)]:
    v = struct.unpack_from('<256I', b, 0)
    # 检查单调性
    mono = sum(1 for i in range(1, 256) if v[i] > v[i-1])
    L.append('%s: 单调递增对 %d/255, v[0]=%08x v[1]=%08x v[255]=%08x' % (nm, mono, v[0], v[1], v[255]))
    # 检查 v[i] 与 i<<4 的关系
    same_shift4 = sum(1 for i in range(256) if v[i] == ((i << 4) & 0xffffffff))
    same_shift5 = sum(1 for i in range(256) if v[i] == ((i >> 5) & 0xffffffff))
    L.append('    其中 == i<<4 的有 %d 个, == i>>5 的有 %d 个' % (same_shift4, same_shift5))

open(os.path.join(OUT, 'tables_info.txt'), 'w').write('\n'.join(L))
print('\n'.join(L))
proj.close()
