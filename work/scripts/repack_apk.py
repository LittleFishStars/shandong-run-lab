#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""重打包 APK：按原顺序复制所有条目，只替换其中一个条目的内容。

原 APK 里的 lib/arm64-v8a/libnesec.so 是 deflate 压缩存储（method=8），
压缩后长度会变，不能原地覆盖，所以整包重建。其余条目**逐字节照搬**
（含 compress_type 与原始数据），只在最后替换目标条目。

用法：
  python3 work/repack_apk.py <in.apk> <out.apk> <zip内路径> <新文件>
"""
import shutil
import sys
import zipfile

ZF = zipfile.ZipFile


def main():
    if len(sys.argv) != 5:
        print(__doc__)
        return 1
    src, dst, inner, newfile = sys.argv[1:5]
    payload = open(newfile, "rb").read()

    zin = ZF(src, "r")
    names = zin.namelist()
    if inner not in names:
        print(f"❌ APK 里没有 {inner}")
        return 1

    old = zin.getinfo(inner)
    print(f"替换 {inner}")
    print(f"  原：method={old.compress_type} comp={old.compress_size} uncomp={old.file_size}")
    print(f"  新：{len(payload)} 字节")

    # 中央目录会保留每个条目名（含目录项），逐条重建
    with ZF(dst, "w", allowZip64=True) as zout:
        zout.comment = zin.comment
        for info in zin.infolist():
            if info.filename == inner:
                zi = zipfile.ZipInfo(info.filename, date_time=info.date_time)
                zi.compress_type = info.compress_type
                zi.external_attr = info.external_attr
                zi.internal_attr = info.internal_attr
                zi.create_system = info.create_system
                zout.writestr(zi, payload)
                continue
            if info.is_dir():
                zi = zipfile.ZipInfo(info.filename, date_time=info.date_time)
                zi.compress_type = zipfile.ZIP_STORED
                zi.external_attr = info.external_attr
                zout.writestr(zi, b"")
                continue
            zi = zipfile.ZipInfo(info.filename, date_time=info.date_time)
            zi.compress_type = info.compress_type
            zi.external_attr = info.external_attr
            zi.internal_attr = info.internal_attr
            zi.create_system = info.create_system
            if info.compress_type == zipfile.ZIP_STORED:
                # STORED 必须给出正确的 crc 与长度
                with zin.open(info) as f:
                    data = f.read()
                zout.writestr(zi, data)
            else:
                zout.writestr(zi, zin.read(info))
    zin.close()

    # 校验
    with ZF(dst) as z:
        bad = z.testzip()
        got = z.read(inner)
    print(f"✓ 条目数 {len(names)} → {len(ZF(dst).namelist())}")
    print(f"✓ 回读校验：{'一致' if got == payload else '不一致'}")
    print(f"✓ testzip: {'通过' if bad is None else bad}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
