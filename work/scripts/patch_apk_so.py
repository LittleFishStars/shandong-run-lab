#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""原地替换 APK 里 libnesec.so 的数据（保持 ZIP 结构与对齐不变）。

为什么不重打包：
  原 APK 里的 .so 是 ZIP_STORED（未压缩）+ 4K 页对齐，重打包会破坏对齐并让
  壳的完整性校验/对齐检查产生更多噪声。补丁前后文件**长度完全相同**（只改了
  28 字节），所以直接在原文件里覆盖数据区即可，连 local header 的 size/crc
  字段都能顺手修好。

用法：
  python3 work/patch_apk_so.py <in.apk> <out.apk> <zip内路径> <新文件>
"""
import shutil
import struct
import sys
import zlib

LFH = 0x04034B50
CDH = 0x02014B50


def find_local(f, name_b):
    """返回 (header_off, data_off, comp_size, uncomp_size, method, crc_field_off)"""
    f.seek(0)
    head = f.read(4)
    while head == b"PK\x03\x04":
        hoff = f.tell() - 4
        raw = f.read(26)
        if len(raw) < 26:
            return None
        (ver, flags, method, mtime, mdate, crc, cs, us, nlen, elen) = struct.unpack("<HHHHHIIIHH", raw)
        nm = f.read(nlen)
        extra = f.read(elen)
        data_off = f.tell()
        if nm == name_b:
            return {
                "hoff": hoff, "data_off": data_off, "method": method,
                "comp": cs, "uncomp": us, "crc_field": hoff + 14,
                "size_field": hoff + 18, "nlen": nlen, "elen": elen,
            }
        f.seek(data_off + cs)
        head = f.read(4)
    return None


def find_central(f, name_b):
    """扫描中央目录，返回 (entry_off, crc_field_off, size_field_off, method, comp, uncomp)"""
    f.seek(0)
    data = f.read()
    i = data.rfind(b"PK\x05\x06")
    if i < 0:
        return None
    cd_size, cd_off = struct.unpack_from("<II", data, i + 12)
    p = cd_off
    while p < cd_off + cd_size and struct.unpack_from("<I", data, p)[0] == CDH:
        (ver_made, ver_need, flags, method, mtime, mdate, crc, cs, us,
         nlen, elen, clen, dstart, iattr, eattr, lho) = struct.unpack_from("<HHHHHHIIIHHHHHII", data, p + 4)
        nm = data[p + 46:p + 46 + nlen]
        if nm == name_b:
            return {
                "hoff": p, "crc_field": p + 16, "size_field": p + 20,
                "method": method, "comp": cs, "uncomp": us, "lho": lho,
            }
        p += 46 + nlen + elen + clen
    return None


def main():
    if len(sys.argv) != 5:
        print(__doc__)
        return 1
    src, dst, inner, newfile = sys.argv[1:5]
    inner_b = inner.encode()
    payload = open(newfile, "rb").read()

    shutil.copy(src, dst)
    with open(dst, "r+b") as f:
        loc = find_local(f, inner_b)
        cen = find_central(f, inner_b)
        if loc is None or cen is None:
            print(f"❌ 没在 APK 里找到 {inner}")
            return 1
        print(f"local   hoff=0x{loc['hoff']:x} data=0x{loc['data_off']:x} "
              f"method={loc['method']} comp={loc['comp']} uncomp={loc['uncomp']}")
        print(f"central hoff=0x{cen['hoff']:x} method={cen['method']} "
              f"comp={cen['comp']} uncomp={cen['uncomp']} lho=0x{cen['lho']:x}")
        if loc["method"] != 0:
            print(f"❌ .so 是压缩存储（method={loc['method']}），本脚本只支持原地替换")
            return 1
        if len(payload) != loc["uncomp"]:
            print(f"❌ 长度不一致：新 {len(payload)} vs 原 {loc['uncomp']}")
            return 1

        crc = zlib.crc32(payload) & 0xFFFFFFFF
        f.seek(loc["data_off"])
        f.write(payload)
        # 同步修 local header 与 central directory 的 crc / size
        for base in (loc["crc_field"], cen["crc_field"]):
            f.seek(base)
            f.write(struct.pack("<I", crc))
        for base, off in ((loc["size_field"], 4), (cen["size_field"], 8)):
            f.seek(base)
            f.write(struct.pack("<I", len(payload)))          # compressed size
            f.write(struct.pack("<I", len(payload)))          # uncompressed size
        print(f"✓ 已写入 {len(payload)} 字节，crc32=0x{crc:08x}")

    # 自我校验：读回来比一比
    import zipfile
    with zipfile.ZipFile(dst) as z:
        z.testzip()
        got = z.read(inner)
    same = (got == payload)
    print(f"✓ 回读校验：{'一致' if same else '不一致'}  ({len(got)} 字节)")
    return 0 if same else 1


if __name__ == "__main__":
    sys.exit(main())
