#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""从设备读取 maps，定位 0x7caa000a33 所在的段。"""
import subprocess, pathlib, re, sys
ADB = str(pathlib.Path.home()/'Android/Sdk/platform-tools/adb')
PKG = 'com.huachenjie.shandong_school'
def adb(a, t=120): return subprocess.run([ADB]+a, capture_output=True, text=True, timeout=t).stdout
pid = adb(['shell','su','-c',f'pidof {PKG}']).strip().split()
if not pid: print('未运行'); sys.exit(1)
pid = pid[0]
maps = adb(['shell','su','-c',f'cat /proc/{pid}/maps'])
print(f"pid={pid}  maps 行数={len(maps.splitlines())}")
# 目标地址
TARGET = 0x7caa000a33
print(f"\n════ 目标 0x{TARGET:x} 所在段 ════")
for line in maps.splitlines():
    m = re.match(r'^([0-9a-f]+)-([0-9a-f]+)\s+(\S{4})\s+\S+\s+\S+\s+\S+\s*(.*)$', line)
    if not m: continue
    s,e = int(m.group(1),16), int(m.group(2),16)
    if s <= TARGET < e:
        print(f"  {line}")
        print(f"  → 段大小 {e-s:,} 字节 ({(e-s)/1024:.0f} KB)，权限 {m.group(3)}")
        (pathlib.Path('work')/'target_seg.txt').write_text(f"{s:#x} {e-s} {m.group(3)} {m.group(4)}")
        break
else:
    print("  未找到（地址可能已失效）")
# 顺便列出所有大匿名可执行段
print(f"\n════ 所有 >300KB 的可执行段 ════")
for line in maps.splitlines():
    m = re.match(r'^([0-9a-f]+)-([0-9a-f]+)\s+(r-x\S*|rwx\S*)\s+\S+\s+\S+\s+\S+\s*(.*)$', line)
    if not m: continue
    s,e = int(m.group(1),16), int(m.group(2),16)
    if e-s > 300*1024:
        print(f"  {s:#x}-{e:#x}  {(e-s)/1024:7.0f}KB  {m.group(3)}  {m.group(4)[:60]}")
