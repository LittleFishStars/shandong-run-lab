#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""比对 libnesec.so 的磁盘镜像与运行时内存镜像，判断代码段是否被壳加密/变形。"""
import os, struct, sys

W = "/home/ylxc/Projects/lib/ShanDong/work"
DISK = "/home/ylxc/Projects/lib/ShanDong/shandong-android-rebuild/app/src/main/arm64-v8a/libnesec.so"

# 1. 拼内存镜像
mem = bytearray()
off = 0
files = sorted(
    [f for f in os.listdir(W) if f.startswith("dump_nesec_full_0x")],
    key=lambda f: int(f.split("_0x")[1].split(".")[0], 16))
for f in files:
    mem += open(os.path.join(W, f), "rb").read()
print("内存镜像 %d 字节，来自 %d 块" % (len(mem), len(files)))

disk = open(DISK, "rb").read()
print("磁盘镜像 %d 字节" % len(disk))

# 2. 用 ELF program header 建立 vaddr→file offset 映射
phoff, phentsize, phnum = struct.unpack_from("<Q", disk, 0x20)[0], struct.unpack_from("<H", disk, 0x36)[0], struct.unpack_from("<H", disk, 0x38)[0]
loads = []
for i in range(phnum):
    p = phoff + i * phentsize
    p_type, p_flags = struct.unpack_from("<II", disk, p)
    p_offset, p_vaddr, p_paddr, p_filesz, p_memsz, p_align = struct.unpack_from("<QQQQQQ", disk, p + 8)
    if p_type == 1:  # PT_LOAD
        loads.append((p_vaddr, p_offset, p_filesz, p_memsz, p_flags))
        print("PT_LOAD vaddr=0x%x off=0x%x filesz=0x%x memsz=0x%x flags=%d" % (p_vaddr, p_offset, p_filesz, p_memsz, p_flags))

# 3. 分页比对
PAGE = 4096
same_pages = diff_pages = 0
for vaddr, p_off, p_filesz, p_memsz, p_flags in loads:
    for rel in range(0, p_memsz, PAGE):
        n = min(PAGE, p_memsz - rel)
        m = mem[vaddr + rel: vaddr + rel + n]
        if rel >= p_filesz:
            d = b"\x00" * n          # bss
        else:
            d = disk[p_off + rel: p_off + rel + n]
        if len(m) < n or len(d) < n:
            continue
        identical = sum(1 for a, b in zip(m, d) if a == b)
        if identical == n:
            same_pages += 1
        else:
            diff_pages += 1
            if diff_pages <= 12:
                # 只看差异，统计 XOR 的重复性
                x = bytes(a ^ b for a, b in zip(m, d))
                uniq = len(set(x))
                print("  差异页 vaddr=0x%-7x 相同=%5d/%-5d  XOR 不同值=%3d  前16=%s"
                      % (vaddr + rel, identical, n, uniq, x[:16].hex(" ")))
print("完全相同页 %d，有差异页 %d" % (same_pages, diff_pages))
