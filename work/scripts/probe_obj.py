#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""探测 art::DexFile 对象：把前 64 字节里所有像指针的字段逐个试读，
找到真正指向 "dex\\n" 数据的那一个（本机 Android 9 的布局与预期不同）。"""
import pathlib, struct, subprocess, sys, threading, time
import frida
PKG='com.huachenjie.shandong_school'
ADB=str(pathlib.Path.home()/'Android/Sdk/platform-tools/adb')
out=pathlib.Path('work/probe_obj'); out.mkdir(parents=True, exist_ok=True)

def adb(a,t=300): return subprocess.run([ADB]+a,capture_output=True,text=True,timeout=t).stdout
def rd(pid, addr, size, tag):
    blk=addr//4096; cnt=(size+4095)//4096; name=f'{tag}.bin'
    adb(['shell','su','-c',f'kill -STOP {pid}'])
    adb(['shell','su','-c',f'dd if=/proc/{pid}/mem of=/data/local/tmp/{name} bs=4096 skip={blk} count={cnt} 2>/dev/null'])
    adb(['shell','su','-c',f'kill -CONT {pid}'])
    adb(['shell','su','-c',f'chmod 666 /data/local/tmp/{name} 2>/dev/null'])
    adb(['pull',f'/data/local/tmp/{name}',str(out/name)])
    f=out/name
    d=f.read_bytes() if f.exists() else b''
    return d[(addr%4096):]

first={}; ev=threading.Event()
def om(m,d):
    if m.get('type')=='send':
        p=m['payload']
        if p.get('t')=='dexfile':
            if not first: first.update(p); ev.set()
        elif p.get('t')=='log' and 'DexFile&' in p.get('msg',''):
            print('[js]',p['msg'],flush=True)
dev=frida.get_usb_device(timeout=20); pid=dev.spawn([PKG]); sess=dev.attach(pid)
sc=sess.create_script(pathlib.Path('work/tight_bundle.js').read_text())
sc.on('message',om); sc.load(); dev.resume(pid)
if not ev.wait(timeout=25): print('[!] 未拿到地址'); sys.exit(1)
addr=int(first['addr'],16)
print(f'[*] DexFile& = {first["addr"]}  ({first["desc"]})',flush=True)
obj = rd(pid, addr, 256, 'obj')
print(f'[*] 对象前 128 字节:\n    {obj[:128].hex()}',flush=True)
print('[*] 逐字段探测（8 字节对齐）:',flush=True)
for off in range(0, 128, 8):
    v = struct.unpack_from('<Q', obj, off)[0]
    if 0x7000000000 <= v <= 0x8000000000 or 0x12000000 <= v <= 0x80000000:
        head = rd(pid, v, 64, f'f{off}')
        txt = head[:8]
        mark = ''
        if txt[:4] in (b'dex\n', b'cdex'): mark = '  ★★★ 是 DEX/CDEX！'
        print(f'    offset {off:3d}: {v:#018x}  -> {txt.hex()}  {txt[:12]!r}{mark}',flush=True)
try: sess.detach()
except: pass
