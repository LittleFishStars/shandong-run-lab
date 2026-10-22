#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""从外部 dump 内存中的壳容器（141MB），用于与磁盘版做 diff。

Frida 负责保活把容器地址报出来；宿主用 /proc/<pid>/mem 读取
（先 SIGSTOP，Android 9 内核要求；toybox dd 的 skip 是 32 位块号，
容器地址约 0x7cb... /4096 ≈ 1.3e8，在 int32 范围内可以正常工作）。
"""
import frida, time, pathlib, subprocess, sys
PKG = 'com.huachenjie.shandong_school'
ADB = str(pathlib.Path.home() / 'Android/Sdk/platform-tools/adb')
out = pathlib.Path('work/container_dump'); out.mkdir(parents=True, exist_ok=True)

info = {}
def om(m, d):
    if m.get('type') == 'send':
        p = m['payload']
        if p.get('t') == 'log': print('[js]', p['msg'], flush=True)
        elif p.get('t') == 'addr':
            info['addr'] = p['addr']; info['size'] = p['size']
            print('[!] 容器地址', p['addr'], p['size'], flush=True)
    elif m.get('type') == 'error':
        print('[err]', m.get('description'), flush=True)

dev = frida.get_usb_device(timeout=20)
pid = dev.spawn([PKG]); sess = dev.attach(pid)
sc = sess.create_script(pathlib.Path('work/addr_bundle.js').read_text())
sc.on('message', om); sc.load(); dev.resume(pid)

# 等容器地址 & 等应用 DEX 加载完（实测 6s 后应用类才全部就位）
for _ in range(40):
    time.sleep(0.5)
    if 'addr' in info: break
if 'addr' not in info:
    print('[!] 未拿到容器地址'); sys.exit(1)
time.sleep(9)

addr = int(info['addr'], 16)
blk = addr // 4096
cnt = (info['size'] + 4095) // 4096
print(f'[*] 从 /proc/{pid}/mem dump: 块号={blk} 块数={cnt}', flush=True)
subprocess.run([ADB, 'shell', 'su', '-c', f'kill -STOP {pid}'], capture_output=True)
subprocess.run([ADB, 'shell', 'su', '-c',
                f'dd if=/proc/{pid}/mem of=/data/local/tmp/cont.bin bs=4096 skip={blk} count={cnt} 2>/dev/null'],
               capture_output=True, timeout=900)
subprocess.run([ADB, 'shell', 'su', '-c', f'kill -CONT {pid}'], capture_output=True)
subprocess.run([ADB, 'shell', 'su', '-c', 'chmod 666 /data/local/tmp/cont.bin'], capture_output=True)
subprocess.run([ADB, 'pull', '/data/local/tmp/cont.bin', str(out / 'cont_mem.bin')], timeout=900)
f = out / 'cont_mem.bin'
print('[*] 本地大小:', f.stat().st_size if f.exists() else '失败', flush=True)
try: sess.detach()
except Exception: pass
