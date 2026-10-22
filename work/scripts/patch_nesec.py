#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""给 libnesec.so 打补丁：把「检测失败 → 自杀」改写成「检测失败 → 走正常路径」。

★ 结构分析（22 处检测点完全统一）：
     <cond> 正常路径
        ↓ fallthrough = 检测失败
     bl #0xb1bec      ← 自杀调用（永不返回：回桌面 + System.exit(0)）
     b  #SKIP         ← 死代码：跳过正常初始化
     bl #0xb6860      ← ★正常路径（业务初始化）
     ...
   SKIP:

   ⇒ 把 `bl #0xb1bec` 一条指令改写成 `b #(自身+8)`，即直接跳到紧跟其后的
     正常初始化。等价于「该检测永远判定为通过」，其余代码零改动。

★ 为什么不改 0xb1aec / 0xb1bec 本体：
   0xb1aec 是惰性初始化分发器（首次与非首次行为不同），改成恒返回 0 会让
   22 处调用全部跳过后面的业务初始化；
   0xb1bec 改成 ret 会让控制流落到那条 `b SKIP` 上，同样跳过初始化。
   两者实测都会引发 `Invalid address … passed to free`。

★ 为什么不改 svc #0 桩：
   0x2fe88/0x2fea0/… 是一整排**通用 syscall 包装**（0x38/0x30/0x39/0x5e/0xac/…），
   被正常业务大量调用，动它们等于破坏 libc。

用法：
  python3 work/patch_nesec.py            # 打补丁并写回（先自动从 .orig 恢复）
  python3 work/patch_nesec.py --verify   # 只校验
  python3 work/patch_nesec.py --list     # 只列出补丁点
"""
import os
import struct
import shutil
import sys

W = "/home/ylxc/Projects/lib/ShanDong/work"
SO = "/home/ylxc/Projects/lib/ShanDong/shandong-android-rebuild/app/src/main/arm64-v8a/libnesec.so"
PLAIN = f"{W}/nesec_plain.bin"
KSF = f"{W}/nesec_keystream.bin"
BAK = f"{W}/libnesec.so.orig"

SUICIDE = 0xB1BEC          # 自杀出口函数地址
BL_OP = 0x94000000         # bl 指令模板
B_OP = 0x14000000          # b  指令模板


def load():
    disk = bytearray(open(SO, "rb").read())
    blank = bytearray(open(BAK, "rb").read())
    plain = bytearray(open(PLAIN, "rb").read())
    ks = open(KSF, "rb").read()
    phoff = struct.unpack_from("<Q", disk, 0x20)[0]
    phes = struct.unpack_from("<H", disk, 0x36)[0]
    phn = struct.unpack_from("<H", disk, 0x38)[0]
    loads = []
    for i in range(phn):
        p = phoff + i * phes
        if struct.unpack_from("<I", disk, p)[0] != 1:
            continue
        o, v, _pa, f, m, _al = struct.unpack_from("<QQQQQQ", disk, p + 8)
        loads.append((v, o, f, m))
    return disk, blank, plain, ks, loads


def find_call_sites(plain):
    """扫出所有 bl #0xb1bec 的调用点，并确认其后紧跟一条 b 指令。"""
    sites = []
    for off in range(0, len(plain) - 7, 4):
        w = struct.unpack_from("<I", plain, off)[0]
        if (w & 0xFC000000) != BL_OP:
            continue
        imm = w & 0x03FFFFFF
        if imm & 0x02000000:
            imm -= 0x04000000
        if off + imm * 4 != SUICIDE:
            continue
        nxt = struct.unpack_from("<I", plain, off + 4)[0]
        kind = "b" if (nxt & 0xFC000000) == B_OP else "?"
        sites.append((off, kind))
    return sites


def build_patches(plain):
    """每处：bl #0xb1bec → b #(自身+8)，即直接进入正常路径。"""
    out = []
    for off, kind in find_call_sites(plain):
        old = bytes(plain[off:off + 4])
        # b 到 off+8 → imm26 = 2
        new = struct.pack("<I", B_OP | 2)
        out.append((off, old.hex(), new.hex(), f"自杀调用 → 直接走正常初始化（后随 {kind}）"))
    return out


def disk_to_plain(disk, ks, loads):
    out = bytearray(len(ks))
    for v, o, f, m in loads:
        for j in range(v, v + f):
            out[j] = disk[o + (j - v)] ^ ks[j]
    return out


def main():
    verify = "--verify" in sys.argv
    listing = "--list" in sys.argv

    # 打补丁前必须从干净原版出发（plain ^ ks 只在原始磁盘上成立）
    if not verify and not listing:
        if not os.path.exists(BAK):
            print(f"缺少原版备份 {BAK}")
            return
        shutil.copy(BAK, SO)
        print(f"已从 {BAK} 恢复干净原版")

    disk, blank, plain, ks, loads = load()
    patches = build_patches(plain)
    print(f"共找到 {len(patches)} 处自杀调用点\n")

    if listing:
        for a, o, n, d in patches:
            print(f"  0x{a:06x}  {o} → {n}  {d}")
        return

    if verify:
        blank_plain = disk_to_plain(bytearray(blank), ks, loads)
        cur = disk_to_plain(disk, ks, loads)
        ok = 0
        for a, o, n, d in patches:
            got = bytes(cur[a:a + 4]).hex()
            mark = "✅" if got == n else ("· 仍是原值" if got == o else "❓未知")
            if got == n:
                ok += 1
            elif got == o:
                pass
            else:
                print(f"  0x{a:06x}  ⚠️ 当前={got}")
        print(f"\n{ok}/{len(patches)} 处已改写为「走正常路径」")
        # 顺带确认其它关键位置未被误改
        diff = sum(1 for i, (x, y) in enumerate(zip(blank, disk)) if x != y)
        print(f"磁盘相对原版差异：{diff} 字节")
        return

    changed = 0
    for a, o, n, d in patches:
        cur = bytes(plain[a:a + 4]).hex()
        if cur == n:
            continue
        if cur != o:
            print(f"  0x{a:06x}  ⚠️ 原文 {cur} 与预期 {o} 不符")
        plain[a:a + 4] = bytes.fromhex(n)
        changed += 1

    if changed == 0:
        print("没有需要修改的字节")
        return

    # ★ 只写回补丁涉及的字节，绝不整文件重写
    new_disk = bytearray(disk)
    addr2disk = {}
    for v, o, f, m in loads:
        for j in range(v, v + f):
            addr2disk[j] = o + (j - v)
    for a, o, n, d in patches:
        for k in range(4):
            j = a + k
            if j in addr2disk:
                new_disk[addr2disk[j]] = plain[j] ^ ks[j]
    diff = sum(1 for x, y in zip(disk, new_disk) if x != y)
    open(SO, "wb").write(bytes(new_disk))
    print(f"\n共改写 {changed} 处 / 磁盘 {diff} 字节（应为 {len(patches)*4}），已写回 {SO}")


if __name__ == "__main__":
    main()
