#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""密码学原语的可插拔后端

设计目标：无论本机装的是 pycryptodome 还是 cryptography，甚至只有标准库，
签名与字段加密的结果都必须**逐字节一致**——因为服务端按字节校验。

后端优先级：pycryptodome → cryptography → 纯标准库降级（仅 ECB/CBC + PKCS#7）。

为什么不用 pycryptodome 作为唯一后端：本项目历史实现依赖它（参考实现
`reference/crypto_v8.7.4_参考实现.py`），但 Arch 上 python-crypto 包名多变；
cryptography 是 python-cryptography 的稳定依赖，覆盖面更广。
"""
from __future__ import annotations

from typing import Optional, Tuple

BACKEND = ""

# ── 后端探测 ─────────────────────────────────────────────────────
try:  # ① pycryptodome
    from Crypto.Cipher import AES as _AES_PC  # type: ignore
    from Crypto.Util.Padding import pad as _pad_pc, unpad as _unpad_pc  # type: ignore

    BACKEND = "pycryptodome"
except Exception:  # pragma: no cover - 取决于本机环境
    _AES_PC = None  # type: ignore
    _pad_pc = _unpad_pc = None  # type: ignore

if not BACKEND:
    try:  # ② cryptography
        from cryptography.hazmat.primitives.ciphers import (  # type: ignore
            Cipher as _CfCipher,
            algorithms as _CfAlgs,
            modes as _CfModes,
        )

        BACKEND = "cryptography"
    except Exception:  # pragma: no cover
        _CfCipher = None  # type: ignore

if not BACKEND:
    BACKEND = "stdlib"

BLOCK = 16


# ══════════════════ PKCS#7 填充 ══════════════════
def pkcs7_pad(data: bytes) -> bytes:
    """标准库 PKCS#7 填充（块大小固定 16）"""
    n = BLOCK - (len(data) % BLOCK)
    return data + bytes([n]) * n


def pkcs7_unpad(data: bytes) -> bytes:
    """标准库 PKCS#7 去填充；不合法时抛 ValueError（调用方决定是否吞掉）"""
    if not data or len(data) % BLOCK != 0:
        raise ValueError("非法密文长度")
    n = data[-1]
    if n < 1 or n > BLOCK or data[-n:] != bytes([n]) * n:
        raise ValueError("PKCS#7 填充不合法")
    return data[:-n]


def _pad(data: bytes) -> bytes:
    if BACKEND == "pycryptodome":
        return _pad_pc(data, BLOCK)  # type: ignore[misc]
    return pkcs7_pad(data)


def _unpad(data: bytes) -> bytes:
    if BACKEND == "pycryptodome":
        return _unpad_pc(data, BLOCK)  # type: ignore[misc]
    return pkcs7_unpad(data)


# ══════════════════ AES ══════════════════
def aes_ecb_encrypt(data: bytes, key: bytes) -> bytes:
    """AES-ECB 加密（调用方负责填充）"""
    if BACKEND == "pycryptodome":
        return _AES_PC.new(key, _AES_PC.MODE_ECB).encrypt(data)  # type: ignore[union-attr]
    if BACKEND == "cryptography":
        c = _CfCipher(_CfAlgs.AES(key), _CfModes.ECB())  # type: ignore[misc]
        e = c.encryptor()
        return e.update(data) + e.finalize()
    return _stdlib_aes(data, key, mode="ecb", encrypt=True)


def aes_ecb_decrypt(data: bytes, key: bytes) -> bytes:
    """AES-ECB 解密（调用方负责去填充）"""
    if BACKEND == "pycryptodome":
        return _AES_PC.new(key, _AES_PC.MODE_ECB).decrypt(data)  # type: ignore[union-attr]
    if BACKEND == "cryptography":
        c = _CfCipher(_CfAlgs.AES(key), _CfModes.ECB())  # type: ignore[misc]
        d = c.decryptor()
        return d.update(data) + d.finalize()
    return _stdlib_aes(data, key, mode="ecb", encrypt=False)


def aes_cbc_encrypt_raw(data: bytes, key: bytes, iv: bytes) -> bytes:
    """AES-CBC 加密（调用方负责填充）"""
    if BACKEND == "pycryptodome":
        return _AES_PC.new(key, _AES_PC.MODE_CBC, iv).encrypt(data)  # type: ignore[union-attr]
    if BACKEND == "cryptography":
        c = _CfCipher(_CfAlgs.AES(key), _CfModes.CBC(iv))  # type: ignore[misc]
        e = c.encryptor()
        return e.update(data) + e.finalize()
    return _stdlib_aes(data, key, mode="cbc", encrypt=True, iv=iv)


def aes_cbc_decrypt_raw(data: bytes, key: bytes, iv: bytes) -> bytes:
    """AES-CBC 解密（调用方负责去填充）"""
    if BACKEND == "pycryptodome":
        return _AES_PC.new(key, _AES_PC.MODE_CBC, iv).decrypt(data)  # type: ignore[union-attr]
    if BACKEND == "cryptography":
        c = _CfCipher(_CfAlgs.AES(key), _CfModes.CBC(iv))  # type: ignore[misc]
        d = c.decryptor()
        return d.update(data) + d.finalize()
    return _stdlib_aes(data, key, mode="cbc", encrypt=False, iv=iv)


# 带填充的高层封装
def aes_ecb_encrypt_padded(data: bytes, key: bytes) -> bytes:
    return aes_ecb_encrypt(_pad(data), key)


def aes_ecb_decrypt_padded(data: bytes, key: bytes) -> bytes:
    return _unpad(aes_ecb_decrypt(data, key))


def aes_cbc_encrypt_padded(data: bytes, key: bytes, iv: bytes) -> bytes:
    return aes_cbc_encrypt_raw(_pad(data), key, iv)


def aes_cbc_decrypt_padded(data: bytes, key: bytes, iv: bytes) -> bytes:
    return _unpad(aes_cbc_decrypt_raw(data, key, iv))


# ══════════════════ 纯标准库 AES 降级实现 ══════════════════
# 只有在既没有 pycryptodome 也没有 cryptography 时才会走到。
# 速度慢但结果与上面两个后端完全一致（已在 tests/test_crypto.py 交叉验证）。
_SBOX = [
    0x63, 0x7c, 0x77, 0x7b, 0xf2, 0x6b, 0x6f, 0xc5, 0x30, 0x01, 0x67, 0x2b, 0xfe, 0xd7, 0xab, 0x76,
    0xca, 0x82, 0xc9, 0x7d, 0xfa, 0x59, 0x47, 0xf0, 0xad, 0xd4, 0xa2, 0xaf, 0x9c, 0xa4, 0x72, 0xc0,
    0xb7, 0xfd, 0x93, 0x26, 0x36, 0x3f, 0xf7, 0xcc, 0x34, 0xa5, 0xe5, 0xf1, 0x71, 0xd8, 0x31, 0x15,
    0x04, 0xc7, 0x23, 0xc3, 0x18, 0x96, 0x05, 0x9a, 0x07, 0x12, 0x80, 0xe2, 0xeb, 0x27, 0xb2, 0x75,
    0x09, 0x83, 0x2c, 0x1a, 0x1b, 0x6e, 0x5a, 0xa0, 0x52, 0x3b, 0xd6, 0xb3, 0x29, 0xe3, 0x2f, 0x84,
    0x53, 0xd1, 0x00, 0xed, 0x20, 0xfc, 0xb1, 0x5b, 0x6a, 0xcb, 0xbe, 0x39, 0x4a, 0x4c, 0x58, 0xcf,
    0xd0, 0xef, 0xaa, 0xfb, 0x43, 0x4d, 0x33, 0x85, 0x45, 0xf9, 0x02, 0x7f, 0x50, 0x3c, 0x9f, 0xa8,
    0x51, 0xa3, 0x40, 0x8f, 0x92, 0x9d, 0x38, 0xf5, 0xbc, 0xb6, 0xda, 0x21, 0x10, 0xff, 0xf3, 0xd2,
    0xcd, 0x0c, 0x13, 0xec, 0x5f, 0x97, 0x44, 0x17, 0xc4, 0xa7, 0x7e, 0x3d, 0x64, 0x5d, 0x19, 0x73,
    0x60, 0x81, 0x4f, 0xdc, 0x22, 0x2a, 0x90, 0x88, 0x46, 0xee, 0xb8, 0x14, 0xde, 0x5e, 0x0b, 0xdb,
    0xe0, 0x32, 0x3a, 0x0a, 0x49, 0x06, 0x24, 0x5c, 0xc2, 0xd3, 0xac, 0x62, 0x91, 0x95, 0xe4, 0x79,
    0xe7, 0xc8, 0x37, 0x6d, 0x8d, 0xd5, 0x4e, 0xa9, 0x6c, 0x56, 0xf4, 0xea, 0x65, 0x7a, 0xae, 0x08,
    0xba, 0x78, 0x25, 0x2e, 0x1c, 0xa6, 0xb4, 0xc6, 0xe8, 0xdd, 0x74, 0x1f, 0x4b, 0xbd, 0x8b, 0x8a,
    0x70, 0x3e, 0xb5, 0x66, 0x48, 0x03, 0xf6, 0x0e, 0x61, 0x35, 0x57, 0xb9, 0x86, 0xc1, 0x1d, 0x9e,
    0xe1, 0xf8, 0x98, 0x11, 0x69, 0xd9, 0x8e, 0x94, 0x9b, 0x1e, 0x87, 0xe9, 0xce, 0x55, 0x28, 0xdf,
    0x8c, 0xa1, 0x89, 0x0d, 0xbf, 0xe6, 0x42, 0x68, 0x41, 0x99, 0x2d, 0x0f, 0xb0, 0x54, 0xbb, 0x16,
]
_INV_SBOX = [0] * 256
for _i, _v in enumerate(_SBOX):
    _INV_SBOX[_v] = _i

_RCON = [0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80, 0x1B, 0x36, 0x6C, 0xD8, 0xAB, 0x4D]


def _xtime(a: int) -> int:
    a <<= 1
    if a & 0x100:
        a = (a ^ 0x1B) & 0xFF
    return a


def _mul(a: int, b: int) -> int:
    """GF(2^8) 乘法"""
    r = 0
    while b:
        if b & 1:
            r ^= a
        a = _xtime(a)
        b >>= 1
    return r


def _expand_key(key: bytes) -> list:
    """AES 密钥扩展 → 轮密钥列表（每轮 16 字节）"""
    nk = len(key) // 4
    nr = nk + 6
    w = [list(key[4 * i:4 * i + 4]) for i in range(nk)]
    for i in range(nk, 4 * (nr + 1)):
        t = list(w[i - 1])
        if i % nk == 0:
            t = t[1:] + t[:1]
            t = [_SBOX[b] for b in t]
            t[0] ^= _RCON[i // nk - 1]
        elif nk > 6 and i % nk == 4:
            t = [_SBOX[b] for b in t]
        w.append([w[i - nk][j] ^ t[j] for j in range(4)])
    out = []
    for r in range(nr + 1):
        words = [b for c in range(4) for b in w[4 * r + c]]
        out.append(bytes(words))
    return out


def _encrypt_block(block: bytes, rk: list) -> bytes:
    st = list(block)
    _add_round_key(st, rk[0])
    for r in range(1, len(rk) - 1):
        st = [_SBOX[b] for b in st]
        _shift_rows(st)
        _mix_columns(st)
        _add_round_key(st, rk[r])
    st = [_SBOX[b] for b in st]
    _shift_rows(st)
    _add_round_key(st, rk[-1])
    return bytes(st)


def _decrypt_block(block: bytes, rk: list) -> bytes:
    st = list(block)
    _add_round_key(st, rk[-1])
    for r in range(len(rk) - 2, 0, -1):
        _inv_shift_rows(st)
        st = [_INV_SBOX[b] for b in st]
        _add_round_key(st, rk[r])
        _inv_mix_columns(st)
    _inv_shift_rows(st)
    st = [_INV_SBOX[b] for b in st]
    _add_round_key(st, rk[0])
    return bytes(st)


def _add_round_key(st: list, rk: bytes) -> None:
    for i in range(16):
        st[i] ^= rk[i]


def _shift_rows(st: list) -> None:
    # 状态按列存储：st[c*4 + r]
    for r in range(1, 4):
        row = [st[c * 4 + r] for c in range(4)]
        row = row[r:] + row[:r]
        for c in range(4):
            st[c * 4 + r] = row[c]


def _inv_shift_rows(st: list) -> None:
    for r in range(1, 4):
        row = [st[c * 4 + r] for c in range(4)]
        row = row[-r:] + row[:-r]
        for c in range(4):
            st[c * 4 + r] = row[c]


def _mix_columns(st: list) -> None:
    for c in range(4):
        a = st[c * 4:c * 4 + 4]
        st[c * 4 + 0] = _mul(a[0], 2) ^ _mul(a[1], 3) ^ a[2] ^ a[3]
        st[c * 4 + 1] = a[0] ^ _mul(a[1], 2) ^ _mul(a[2], 3) ^ a[3]
        st[c * 4 + 2] = a[0] ^ a[1] ^ _mul(a[2], 2) ^ _mul(a[3], 3)
        st[c * 4 + 3] = _mul(a[0], 3) ^ a[1] ^ a[2] ^ _mul(a[3], 2)


def _inv_mix_columns(st: list) -> None:
    for c in range(4):
        a = st[c * 4:c * 4 + 4]
        st[c * 4 + 0] = _mul(a[0], 14) ^ _mul(a[1], 11) ^ _mul(a[2], 13) ^ _mul(a[3], 9)
        st[c * 4 + 1] = _mul(a[0], 9) ^ _mul(a[1], 14) ^ _mul(a[2], 11) ^ _mul(a[3], 13)
        st[c * 4 + 2] = _mul(a[0], 13) ^ _mul(a[1], 9) ^ _mul(a[2], 14) ^ _mul(a[3], 11)
        st[c * 4 + 3] = _mul(a[0], 11) ^ _mul(a[1], 13) ^ _mul(a[2], 9) ^ _mul(a[3], 14)


def _stdlib_aes(data: bytes, key: bytes, mode: str, encrypt: bool,
                iv: Optional[bytes] = None) -> bytes:
    """纯标准库 AES-ECB / AES-CBC（无填充，调用方处理）"""
    if len(data) % BLOCK or len(key) not in (16, 24, 32):
        raise ValueError("AES 参数不合法")
    rk = _expand_key(key)
    out = bytearray()
    prev: Optional[bytes] = bytes(iv) if mode == "cbc" and iv else (bytes(BLOCK) if mode == "cbc" else None)
    for off in range(0, len(data), BLOCK):
        blk = data[off:off + BLOCK]
        if encrypt:
            if mode == "cbc":
                blk = bytes(a ^ b for a, b in zip(blk, prev))  # type: ignore[arg-type]
            enc = _encrypt_block(blk, rk)
            out += enc
            prev = enc
        else:
            dec = _decrypt_block(blk, rk)
            if mode == "cbc":
                dec = bytes(a ^ b for a, b in zip(dec, prev))  # type: ignore[arg-type]
                prev = blk
            out += dec
    return bytes(out)


def backend_info() -> Tuple[str, str]:
    """(后端名, 说明) —— 用于 selftest 与 doctor 打印"""
    desc = {
        "pycryptodome": "pycryptodome（与历史参考实现同源）",
        "cryptography": "cryptography（OpenSSL 实现，推荐）",
        "stdlib": "纯标准库降级实现（慢但等价，建议安装 cryptography）",
    }[BACKEND]
    return BACKEND, desc
