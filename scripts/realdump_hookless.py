#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""真机脱壳（绕 tripwire 版）：Frida 拦 mprotect + 外部读 maps + 外部 dump。

核心教训（本机实测）：
    * 任何在目标进程内读取 /proc/self/maps 的 Frida API
      （Process.enumerateRanges / findRangeByAddress / Module.enumerateRanges）
      都会触发易盾 tripwire，进程立即退出。因此**内存布局必须在进程外获取**。
    * 壳用 mprotect(PROT_NONE) 撤销解密后 DEX 页的读权限，需在 Frida 里
      把 prot 改成 PROT_READ（窗口期内），再从外部读内存。
    * 外部读 /proc/<pid>/mem 需要目标 SIGSTOP（Android 9 内核要求），
      且高地址要用 /proc/<pid>/map_files/<range>（toybox dd 的 skip 是 32 位）。

流程：
    1. Frida spawn + 注入「拦 mprotect / 拦 exit」脚本，resume；
    2. 等若干秒（壳解密窗口），期间 Frida 持续保持 DEX 页可读；
    3. SIGSTOP 目标；外部拉取 /proc/<pid>/maps 与各 rw- 区间；
    4. 在宿主本地扫描 DEX magic 并校验头部，导出可反编译的 DEX；
    5. SIGCONT（让壳继续其正常流程）。

用法:
    work/toolchain/.venv-frida/bin/python scripts/realdump_hookless.py --wait 1.2 --outdir work/dumps/dump_final
"""

from __future__ import annotations

import argparse
import re
import struct
import subprocess
import sys
import threading
import time
from pathlib import Path

import frida

ADB = str(Path.home() / "Android/Sdk/platform-tools/adb")
PKG = "com.huachenjie.shandong_school"

# 只做两件事：保持 DEX 页可读 + 阻止 exit（均不触碰 maps）
JS = r'''
'use strict';
function findExport(n){
  try{ if(typeof Module.findGlobalExportByName==='function') return Module.findGlobalExportByName(n);}catch(e){}
  try{ if(typeof Module.getGlobalExportByName==='function') return Module.getGlobalExportByName(n);}catch(e){}
  try{ return Module.getExportByName('libc.so',n);}catch(e){}
  return null;
}
var mp = findExport('mprotect');
var blocked = 0;
if (mp) {
  Interceptor.attach(mp, { onEnter: function (a) {
    if (a[2].toInt32() === 0) { blocked++; a[2] = ptr(1); }   // PROT_NONE -> PROT_READ
  }});
}
['exit','_exit','abort','quick_exit'].forEach(function (n) {
  var a = findExport(n);
  if (a) Interceptor.attach(a, { onEnter: function () { this.ret = true; } });
});
send({ t: 'ready', blocked: blocked });
'''


def sh(args, timeout=300, binary=False):
    p = subprocess.run([ADB] + args, capture_output=True, timeout=timeout)
    return p.stdout if binary else p.stdout.decode("utf-8", "replace")


def valid_dex(blob: bytes, off: int) -> tuple[bool, int, int, int]:
    """校验 DEX 头，返回 (ok, file_size, strings, class_defs)。"""
    if off + 112 > len(blob):
        return False, 0, 0, 0
    try:
        file_size = struct.unpack_from("<I", blob, off + 0x20)[0]
        header_size = struct.unpack_from("<I", blob, off + 0x24)[0]
        endian = struct.unpack_from("<I", blob, off + 0x28)[0]
        str_size = struct.unpack_from("<I", blob, off + 0x38)[0]
        class_defs = struct.unpack_from("<I", blob, off + 0x60)[0]
    except struct.error:
        return False, 0, 0, 0
    ok = (header_size == 112 and endian == 0x12345678
          and 4096 < file_size <= len(blob) - off
          and 0 < str_size < 5_000_000)
    return ok, file_size, str_size, class_defs


def main() -> int:
    ap = argparse.ArgumentParser(description="绕 tripwire 的真机脱壳")
    ap.add_argument("--outdir", default="work/dumps/dump_final")
    ap.add_argument("--wait", type=float, default=1.2, help="解密窗口等待秒数")
    ap.add_argument("--max-region-mb", type=int, default=64)
    args = ap.parse_args()

    outdir = Path(args.outdir)
    outdir.mkdir(parents=True, exist_ok=True)
    dev_tmp = "/data/local/tmp/fd"

    dev = frida.get_usb_device(timeout=20)
    print(f"[*] 设备 {dev.name}", flush=True)

    pid = dev.spawn([PKG])
    print(f"[*] spawn pid={pid}", flush=True)
    session = dev.attach(pid)
    script = session.create_script(JS)
    script.on("message", lambda m, d: print(f"  [frida] {m.get('payload', m)}", flush=True))
    script.load()
    dev.resume(pid)
    print(f"[*] 已 resume，等待 {args.wait}s ...", flush=True)
    time.sleep(args.wait)
    alive = sh(["shell", "su", "-c", f"ls -d /proc/{pid}"], timeout=20).strip()
    print(f"[*] 进程存活: {'是' if alive else '否'}", flush=True)

    # 冻结目标（外部读 mem 的前提）
    sh(["shell", "su", "-c", f"kill -STOP {pid}"], timeout=60)
    time.sleep(0.3)
    print("[*] 已 SIGSTOP，开始外部读取", flush=True)

    # 取 maps（进程外读取，不触发 tripwire）
    maps = sh(["shell", "su", "-c", f"cat /proc/{pid}/maps"], timeout=120)
    (outdir / f"maps_{pid}.txt").write_text(maps, encoding="utf-8")
    if not maps.strip():
        print(f"[!] maps 为空，检查进程是否存活", flush=True)
        print("    ps:", sh(["shell", "su", "-c", "ps -A | grep huachenjie"]).strip(), flush=True)
    regions = []
    for line in maps.splitlines():
        m = re.match(r"^([0-9a-f]+)-([0-9a-f]+)\s+(\S{4})\s+\S+\s+\S+\s+\S+\s*(.*)$", line)
        if not m:
            continue
        s, e, p, n = int(m.group(1), 16), int(m.group(2), 16), m.group(3), m.group(4).strip()
        if "r" not in p or (e - s) < 4096:
            continue
        if (e - s) > args.max_region_mb * 1024 * 1024:
            continue
        regions.append((s, e, p, n))
    print(f"[*] maps {len(maps.splitlines())} 行 -> 候选区间 {len(regions)}", flush=True)

    # 用 map_files 逐区间导出（绕过 toybox dd 的 32 位 skip 限制）
    sh(["shell", "su", "-c", f"rm -rf {dev_tmp}; mkdir -p {dev_tmp}; chmod 777 {dev_tmp}"], timeout=60)
    idx = 0
    for s, e, p, n in regions:
        idx += 1
        rng = f"{s:x}-{e:x}"
        # 直接 dd map_files，内核按映射返回
        sh(["shell", "su", "-c",
            f"dd if=/proc/{pid}/map_files/{rng} of={dev_tmp}/r_{idx}.bin bs=65536 2>/dev/null"],
           timeout=180)
    sh(["shell", "su", "-c", f"chmod -R 777 {dev_tmp}"], timeout=60)
    sh(["shell", "su", "-c", f"kill -CONT {pid}"], timeout=60)

    local = outdir / "regions"
    local.mkdir(parents=True, exist_ok=True)
    print("[*] 拉回区间数据 ...", flush=True)
    sh(["pull", dev_tmp, str(local)], timeout=900)

    # 本地扫描
    files = sorted((local / "fd").glob("r_*.bin")) if (local / "fd").is_dir() else []
    print(f"[*] 拉回 {len(files)} 个区间，本地扫描 DEX ...", flush=True)
    found = 0
    for f in files:
        try:
            b = f.read_bytes()
        except OSError:
            continue
        for m in re.finditer(rb"dex\n03[5-9]", b):
            off = m.start()
            ok, fsize, ssize, cdefs = valid_dex(b, off)
            if not ok:
                continue
            out = outdir / f"{f.stem}_off{off}_{cdefs}cls.dex"
            out.write_bytes(b[off:off + fsize])
            found += 1
            print(f"  [√] {out.name}  size={fsize:,} strings={ssize:,} classes={cdefs:,}", flush=True)
    print(f"\n[*] 共导出 {found} 个 DEX 到 {outdir}", flush=True)

    try:
        session.detach()
    except Exception:
        pass
    return 0 if found else 1


if __name__ == "__main__":
    sys.exit(main())
