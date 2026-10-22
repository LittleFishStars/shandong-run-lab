#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""真机脱壳（最终方案）：Frida 拦 mprotect 保持 DEX 页可读，同时在内存中直接提取 DEX。

依据（AWAKE 对 NetEase YiDun App Packer 的记载）：
    壳在解密 DEX 后用 mprotect(PROT_NONE) 撤销该内存区域的读权限，
    使常规内存扫描读不到明文 DEX。把 prot 改写成 PROT_READ 后，
    即可用 Memory.scan / 直接读内存拿到 DEX 头。

与之前脚本的区别：
    * 之前用 dd/map_files 从外部读内存，被 PROT_NONE 挡住 -> 只能看到壳容器；
    * 本脚本在**进程内部**用 Frida 的 Memory API 读取，权限由我们改写，绕过限制。

流程：
    1. spawn 目标，注入 mprotect 拦截 + DEX 扫描脚本；
    2. resume；
    3. 在进程内周期性 Memory.scan 搜 "dex\\n035"，命中即 dump 出整份 DEX；
    4. 通过 send() 把 DEX 以 base64 传回宿主落盘。

用法:
    work/toolchain/.venv-frida/bin/python scripts/frida_dexdump_live.py --outdir work/dexdump_live
"""

from __future__ import annotations

import argparse
import base64
import sys
import threading
import time
from pathlib import Path

import frida

PKG = "com.huachenjie.shandong_school"

JS = r'''
'use strict';

// ---------- 1) 阻止壳撤销 DEX 页读权限（关键） ----------
function findExport(name) {
    try { if (typeof Module.findGlobalExportByName === 'function') return Module.findGlobalExportByName(name); } catch (e) {}
    try { if (typeof Module.getGlobalExportByName === 'function') return Module.getGlobalExportByName(name); } catch (e) {}
    try { return Module.getExportByName('libc.so', name); } catch (e) {}
    return null;
}

const mp = findExport('mprotect');
let blockedNone = 0;
if (mp) {
    Interceptor.attach(mp, {
        onEnter(args) {
            if (args[2].toInt32() === 0) {
                blockedNone++;
                args[2] = ptr(1);           // PROT_NONE -> PROT_READ
            }
        }
    });
    send({ t: 'ready', msg: 'mprotect 已拦截（PROT_NONE -> PROT_READ）' });
} else {
    send({ t: 'warn', msg: 'mprotect 未找到' });
}

// ---------- 1b) 尝试阻止自毁（attach + this.ret，安全，不 replace） ----------
['exit', '_exit', 'abort', 'quick_exit'].forEach(function (n) {
    const a = findExport(n);
    if (!a) return;
    try {
        Interceptor.attach(a, {
            onEnter() { send({ t: 'warn', msg: '拦截 ' + n + '（跳过原实现）' }); this.ret = true; }
        });
    } catch (e) {}
});

// ---------- 2) 在进程内扫描并导出 DEX ----------
const dumped = new Set();

function scanAndDump(tag) {
    let hits = 0;
    try {
        const ranges = Process.enumerateRanges({ protection: 'rw-', coalesce: true });
        let scanned = 0;
        for (const r of ranges) {
            if (r.size < 4096 || r.size > 64 * 1024 * 1024) continue;
            if (scanned++ > 120) break;          // 限流：每轮最多 120 个区间
            let res = null;
            try {
                res = Memory.scanSync(r.base, r.size, '64 65 78 0a 30 33 35 00');
            } catch (e) { continue; }
            for (const m of res) {
                const addr = m.address;
                const key = addr.toString();
                if (dumped.has(key)) continue;
                // 读 DEX 头拿 file_size
                let hdr = null;
                try { hdr = addr.readByteArray(112); } catch (e) { continue; }
                const u8 = new Uint8Array(hdr);
                const dv = new DataView(u8.buffer);
                const fileSize = dv.getUint32(0x20, true);
                const endian = dv.getUint32(0x28, true);
                const strSize = dv.getUint32(0x38, true);
                const classDefs = dv.getUint32(0x60, true);
                if (endian !== 0x12345678) continue;
                if (fileSize < 4096 || fileSize > 256 * 1024 * 1024) continue;
                let data = null;
                try { data = addr.readByteArray(fileSize); } catch (e) {
                    // 尾部可能跨到不可读页，退一步读一半
                    try { data = addr.readByteArray(Math.floor(fileSize / 2)); } catch (e2) { continue; }
                }
                dumped.add(key);
                hits++;
                send({
                    t: 'dex',
                    addr: key,
                    fileSize: fileSize,
                    strSize: strSize,
                    classDefs: classDefs,
                    b64: base64encode(data),
                }, data);
            }
        }
    } catch (e) {
        send({ t: 'warn', msg: 'scan 异常: ' + e });
    }
    send({ t: 'scan', tag: tag, hits: hits, blockedNone: blockedNone,
           ranges: 'ok' });
}

function base64encode(ab) {
    const bytes = new Uint8Array(ab);
    let bin = '';
    const chunk = 0x8000;
    for (let i = 0; i < bytes.length; i += chunk) {
        bin += String.fromCharCode.apply(null, bytes.subarray(i, i + chunk));
    }
    return btoa(bin);
}

// 多次扫描：壳解密是渐进的，命中时机不定
let round = 0;
// 进程存活仅约 2s，必须立即扫描且高频
scanAndDump('round0');
const iv = setInterval(function () {
    round++;
    scanAndDump('round' + round);
    if (round >= 200) { clearInterval(iv); send({ t: 'done' }); }
}, 50);

send({ t: 'ready', msg: 'DEX 扫描器已启动' });
'''


def main() -> int:
    ap = argparse.ArgumentParser(description="Frida 内存脱壳（拦 mprotect）")
    ap.add_argument("--outdir", default="work/dexdump_live")
    ap.add_argument("--seconds", type=float, default=25.0)
    args = ap.parse_args()

    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)

    dev = frida.get_usb_device(timeout=20)
    print(f"[*] 设备: {dev.name}", flush=True)
    pid = dev.spawn([PKG])
    print(f"[*] spawned pid={pid}", flush=True)
    session = dev.attach(pid)
    script = session.create_script(JS)

    saved = 0
    lock = threading.Lock()

    def on_message(msg, data):
        nonlocal saved
        if msg.get("type") != "send":
            if msg.get("type") == "error":
                print(f"[error] {msg.get('description')}", flush=True)
            return
        p = msg["payload"]
        t = p.get("t")
        if t == "dex":
            with lock:
                f = outdir / f"dex_{p['addr']}_{p['fileSize']}.dex"
                if data:
                    f.write_bytes(bytes(data))
                else:
                    f.write_bytes(base64.b64decode(p["b64"]))
                saved += 1
            print(f"  [√] DEX {p['fileSize']:,}B classes={p['classDefs']:,} "
                  f"strings={p['strSize']:,} -> {f.name}", flush=True)
        elif t == "scan":
            if p.get("hits"):
                print(f"  [{p['tag']}] 命中 {p['hits']} (累计 PROT_NONE 拦截 {p['blockedNone']})", flush=True)
        elif t == "ready":
            print(f"[*] {p['msg']}", flush=True)
        elif t == "warn":
            print(f"[!] {p['msg']}", flush=True)
        elif t == "done":
            print("[*] 扫描结束", flush=True)

    script.on("message", on_message)
    script.load()
    dev.resume(pid)
    print("[*] 已 resume，观察中 ...", flush=True)

    t0 = time.time()
    while time.time() - t0 < args.seconds:
        time.sleep(2)
        procs = {p.pid for p in dev.enumerate_processes()}
        alive = pid in procs
        print(f"[{time.time()-t0:5.1f}s] 进程 {'存活' if alive else '已退出'}"
              f" | 已存 DEX {saved}", flush=True)
        if not alive:
            break

    print(f"\n=== 结果：导出 {saved} 个 DEX ===", flush=True)
    for f in sorted(outdir.glob("*.dex")):
        print(f"  {f.name}  {f.stat().st_size:,} B", flush=True)
    try:
        session.detach()
    except Exception:
        pass
    return 0 if saved else 1


if __name__ == "__main__":
    sys.exit(main())
