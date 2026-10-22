#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""Frida 报告 DexFile 地址，宿主从 /proc/<pid>/mem 外部读取并导出应用 DEX。

为什么外部读：Frida 的进程内读取器对某些受保护区域会返回固定垃圾值，
而 /proc/<pid>/mem 经内核直接读取，不受影响（需先 SIGSTOP）。
"""
import frida, time, pathlib, subprocess, sys
PKG='com.huachenjie.shandong_school'
ADB=str(pathlib.Path.home()/'Android/Sdk/platform-tools/adb')
out=pathlib.Path('work/dexfile_out'); out.mkdir(parents=True, exist_ok=True)

got={}
def om(m,d):
    if m.get('type')=='send':
        p=m['payload']
        if p.get('t')=='log': print('[js]',p['msg'],flush=True)
        elif p.get('t')=='dexfile':
            got.setdefault(p['addr'], p['desc'])
            print('[!] DexFile& =', p['addr'], p['desc'], flush=True)
    elif m.get('type')=='error': print('[err]',m.get('description'),flush=True)

dev=frida.get_usb_device(timeout=20); pid=dev.spawn([PKG]); sess=dev.attach(pid)
sc=sess.create_script(pathlib.Path('work/report_addr_bundle.js').read_text())
sc.on('message',om); sc.load(); dev.resume(pid)
print('[*] spawn pid =', pid, flush=True)

for _ in range(30):
    time.sleep(0.5)
    if got: break
if not got:
    print('[!] 未拿到 DexFile 地址'); sys.exit(1)
time.sleep(3)

def rd(blk, cnt, outname):
    subprocess.run([ADB,'shell','su','-c',f'kill -STOP {pid}'],capture_output=True)
    r=subprocess.run([ADB,'shell','su','-c',
        f'dd if=/proc/{pid}/mem of=/data/local/tmp/{outname} bs=4096 skip={blk} count={cnt} 2>&1 | tail -1; kill -CONT {pid}'],
        capture_output=True,text=True,timeout=300)
    subprocess.run([ADB,'shell','su','-c',f'chmod 666 /data/local/tmp/{outname}'],capture_output=True)
    subprocess.run([ADB,'pull',f'/data/local/tmp/{outname}',str(out/outname)],capture_output=True,timeout=300)
    f=out/outname
    return f.read_bytes() if f.exists() else b''

for addr_hex, desc in list(got.items())[:3]:
    addr=int(addr_hex,16); blk=addr//4096
    print(f'\n[*] 读 DexFile& {addr_hex} （{desc}）', flush=True)
    hdr = rd(blk, 1, 'df.bin')
    if len(hdr) < 16: print('   读取失败'); continue
    import struct
    begin = struct.unpack_from('<Q', hdr, 0)[0]
    size  = struct.unpack_from('<Q', hdr, 8)[0]
    print(f'   begin=0x{begin:x} size={size:,}', flush=True)
    if not (4096 < size <= 300*1024*1024): print('   size 不合理，跳过'); continue
    bblk = begin//4096
    # 先读头部校验 magic
    head = rd(bblk, 1, 'head.bin')
    print('   头部前 16 字节:', head[:16].hex() if head else '(空)', flush=True)
    if head[:4] not in (b'dex\n', b'cdex'):
        print('   不是 dex/cdex，跳过'); continue
    total_blk = (size+4095)//4096
    if total_blk > 24000: print(f'   过大 ({total_blk} 块)，跳过'); continue
    blob = rd(bblk, total_blk, 'dex.bin')
    f = out/f'APP_{desc.split("/")[-1].rstrip(";")}_{size}.dex'
    f.write_bytes(blob)
    print(f'   [√] 写出 {f.name} {len(blob):,}B', flush=True)

try: sess.detach()
except: pass
