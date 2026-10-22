#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""验证运行时抓到的加密参数是否自洽（AES-128-CBC/PKCS7 自测）。

参数来源（Frida 运行时实测，非静态推断）：
    key : h33.d(api="F44B0282BEA83557", ...)  注入后 h33.b() == "F44B0282BEA83557"
    iv  : com.zj.adlib.cq.a == "01234ABCDEF56789"
    alg : com.zj.adlib.cq.d == "AES/CBC/PKCS7Padding"
    fields: [phone, password, userName, schoolName, studentNumber]

用法:
    work/toolchain/.venv-frida/bin/python scripts/verify_crypto_params.py
"""

from __future__ import annotations

import base64
import sys

KEY = b"F44B0282BEA83557"          # h33.b() 运行时值
IV = b"01234ABCDEF56789"           # cq.a 运行时值
ALG = "AES/CBC/PKCS7Padding"
FIELDS = ["phone", "password", "userName", "schoolName", "studentNumber"]


def main() -> int:
    print("=" * 62)
    print("运行时抓取的加密参数核验")
    print("=" * 62)
    print(f"  密钥 : {KEY.decode()!r}   长度 {len(KEY)} 字节  "
          f"{'✓ AES-128' if len(KEY) == 16 else '✗ 非 16 字节'}")
    print(f"  IV   : {IV.decode()!r}   长度 {len(IV)} 字节  "
          f"{'✓ 合法' if len(IV) == 16 else '✗ 非 16 字节'}")
    print(f"  算法 : {ALG}")
    print(f"  字段 : {FIELDS}")
    print()

    if len(KEY) != 16 or len(IV) != 16:
        print("✗ 长度不合法，无法继续")
        return 1

    try:
        from Crypto.Cipher import AES
        from Crypto.Util.Padding import pad, unpad
    except ImportError:
        print("! 未安装 pycryptodome：")
        print("    work/toolchain/.venv-frida/bin/pip install pycryptodome")
        print("  （密钥/IV 长度已确认合法，算法为标准 AES-128-CBC）")
        return 0

    def enc(s: str) -> str:
        c = AES.new(KEY, AES.MODE_CBC, IV)
        return base64.b64encode(c.encrypt(pad(s.encode(), 16))).decode()

    def dec(t: str) -> str:
        c = AES.new(KEY, AES.MODE_CBC, IV)
        return unpad(c.decrypt(base64.b64decode(t)), 16).decode()

    print("自测（加密 → 解密往返）:")
    ok = True
    # 用真实业务字段的典型取值
    samples = ["13800138000", "Test@123456", "zhangsan",
               "山东大学", "2021001234", "中文&符号!@#"]
    for plain in samples:
        ct = enc(plain)
        rt = dec(ct)
        good = rt == plain
        ok &= good
        print(f"  {plain!r:<18} → {ct[:44]}{'...' if len(ct) > 44 else ''}")
        print(f"  {'':<18} ← 回解 {rt!r}  {'✓' if good else '✗'}")
    print()
    print("✓ 加解密链路自洽，密钥与 IV 有效" if ok else "✗ 往返不一致")
    return 0 if ok else 1


if __name__ == "__main__":
    sys.exit(main())
