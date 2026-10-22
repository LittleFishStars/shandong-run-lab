#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""把 libnesec.so 的内存镜像按 vaddr 对齐到磁盘镜像，导出 keystream = mem ^ disk，
并把内存镜像落盘成可反汇编的 nesec_plain.bin。"""
import os, struct

W = "/home/ylxc/Projects/lib/ShanDong/work"
DISK = "/home/ylxc/Projects/lib/ShanDong/shandong-android-rebuild/app/src/main/arm64-v8a/libnesec.so"

mem = b"".join(open(os.path.join(W, f), "rb").read()
               for f in sorted([x for x in os.listdir(W) if x.startswith("dump_nesec_full_0x")],
                               key=lambda f: int(f.split("_0x")[1].split(".")[0], 16)))
disk = open(DISK, "rb").read()
assert len(mem) == 1167360, len(mem)

phoff = struct.unpack_from("<Q", disk, 0x20)[0]
phentsize = struct.unpack_from("<H", disk, 0x36)[0]
phnum = struct.unpack_from("<H", disk, 0x38)[0]
loads = []
for i in range(phnum):
    p = phoff + i * phentsize
    p_type = struct.unpack_from("<I", disk, p)[0]
    if p_type != 1:
        continue
    p_offset, p_vaddr, _pa, p_filesz, p_memsz, _al = struct.unpack_from("<QQQQQQ", disk, p + 8)
    loads.append((p_vaddr, p_offset, p_filesz, p_memsz))

# 把磁盘内容按 vaddr 摆放
span = max(v + m for v, o, f, m in loads)
disk_v = bytearray(span)
for p_vaddr, p_offset, p_filesz, p_memsz in loads:
    disk_v[p_vaddr:p_vaddr + p_filesz] = disk[p_offset:p_offset + p_filesz]

ks = bytearray(len(mem))
for i in range(len(mem)):
    ks[i] = mem[i] ^ (disk_v[i] if i < len(disk_v) else 0)

open(os.path.join(W, "nesec_plain.bin"), "wb").write(mem)
open(os.path.join(W, "nesec_keystream.bin"), "wb").write(bytes(ks))
print("span=0x%x  mem=%d  keystream 已导出" % (span, len(mem)))
print("keystream 前 32 字节:", bytes(ks[:32]).hex(" "))
print("keystream 0x1000 处:", bytes(ks[0x1000:0x1020]).hex(" "))
print("keystream 0xa5000 处:", bytes(ks[0xa5000:0xa5020]).hex(" "))
