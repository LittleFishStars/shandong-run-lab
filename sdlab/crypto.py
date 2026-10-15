#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""闪动校园协议密码学层（逆向还原版）

在 `ciphers.py` 提供的多后端原语之上，实现协议层语义：

  · 请求签名      sign = Base64(AES-256-CBC(T(SHA256_hex(json))))
  · 敏感字段加密  手机号 / 密码 / 姓名 / 学号 / 学校名
  · 滑块坐标加密  AES-128-ECB + 边距补偿
  · 结算防篡改码  MD5 拼接串
  · 多媒体资源    DES-ECB 8 密钥轮换

所有算法均经双重验证（报告 13 / 15）：
  ① 与真机 native 预言机（liby.so+0x1e320）逐输入比对 → 5/5 一致
  ② 服务端回显逐字节比对（auth/loginCheck 返回的 AES 手机号）→ 一致
"""
from __future__ import annotations

import base64
import hashlib
import json
from typing import Any, Dict, Optional, Union

from . import ciphers
from .constants import (
    AES_IV,
    APP_VERSION,
    BUILD_VERSION,
    DES_KEYS,
    FIELD_KEY,
    RUN_IMG_RECORD_KEY,
    SIGN_ENV_TEST,
    SIGN_KEY_PROD,
    SIGN_KEY_TEST,
    SLIDER_KEY,
    SLIDER_MARGIN,
    SLIDER_OFFSET,
)

# ══════════════════ 基础编码 ══════════════════
def b64(data: bytes) -> str:
    """标准 Base64（无换行，与 Java util.Base64 一致）"""
    return base64.b64encode(data).decode("ascii")


def unb64(text: str) -> bytes:
    """宽容 Base64 解码（容忍换行/空白）"""
    return base64.b64decode(text, validate=False)


def aes_cbc_encrypt(data: Union[str, bytes], key: bytes, iv: bytes = AES_IV) -> str:
    """AES-CBC + PKCS#7 → Base64"""
    raw = data.encode("utf-8") if isinstance(data, str) else data
    return b64(ciphers.aes_cbc_encrypt_padded(raw, key, iv))


def aes_cbc_decrypt(cipher_b64: str, key: bytes, iv: bytes = AES_IV) -> str:
    """Base64 → AES-CBC 解密 + 去填充 → UTF-8；失败时原样返回（便于排错）"""
    try:
        return ciphers.aes_cbc_decrypt_padded(unb64(cipher_b64), key, iv).decode("utf-8")
    except Exception:
        return cipher_b64


def aes_ecb_encrypt(data: Union[str, bytes], key: bytes) -> str:
    raw = data.encode("utf-8") if isinstance(data, str) else data
    return b64(ciphers.aes_ecb_encrypt_padded(raw, key))


def aes_ecb_decrypt(cipher_b64: str, key: bytes) -> Optional[str]:
    try:
        return ciphers.aes_ecb_decrypt_padded(unb64(cipher_b64), key).decode("utf-8")
    except Exception:
        return None


# ══════════════════ ★ 请求签名 ══════════════════
def sha256_hex(data: bytes) -> str:
    return hashlib.sha256(data).hexdigest().lower()


def swap_ends(hex64: str) -> str:
    """T(s) = s[-8:] + s[8:-8] + s[:8]（64 字符 hex 首尾各 8 字符交换）"""
    return hex64[-8:] + hex64[8:-8] + hex64[:8]


def unswap_ends(hex64: str) -> str:
    """T 的逆运算（用于反解自洽校验）"""
    return hex64[-8:] + hex64[8:-8] + hex64[:8]  # T 自逆


def sign_key(env: int = 0) -> bytes:
    """env ∈ {9, 11} 用测试密钥，其余用生产密钥"""
    return SIGN_KEY_TEST if env in SIGN_ENV_TEST else SIGN_KEY_PROD


def get_sign(body: Union[str, Dict[str, Any]], env: int = 0) -> str:
    """计算官方 HTTP 请求头 sign（等价于 native HcjNative.signRequest）

    调用方必须传入**与服务端逐字节相同**的那份 JSON 字符串；
    传 dict 时按紧凑分隔符序列化（separators=(",",":")）。
    """
    if isinstance(body, dict):
        text = json.dumps(body, separators=(",", ":"), ensure_ascii=False)
    else:
        text = str(body)
    return aes_cbc_encrypt(swap_ends(sha256_hex(text.encode("utf-8"))), sign_key(env))


def sign_middle(json_text: str) -> str:
    """签名流程中间态（换位后的 64 字符 hex），用于离线核对"""
    return swap_ends(sha256_hex(json_text.encode("utf-8")))


def unsign(sign_b64: str, env: int = 0) -> str:
    """反解签名 → 返回换位后的 64 字符 hex（失败返回原文）"""
    return aes_cbc_decrypt(sign_b64, sign_key(env))


def verify_sign(body: Union[str, Dict[str, Any]], sign_b64: str, env: int = 0) -> bool:
    """校验签名是否与 body 匹配（Mock 服务端用它模拟服务端验签）"""
    try:
        middle = sha256_hex(
            (json.dumps(body, separators=(",", ":"), ensure_ascii=False)
             if isinstance(body, dict) else str(body)).encode("utf-8")
        )
        recovered = unswap_ends(unsign(sign_b64, env))
        return recovered == middle
    except Exception:
        return False


# ══════════════════ 敏感字段加密 ══════════════════
def encrypt_field(plain: str) -> str:
    """加密手机号 / 密码 / 姓名 / 学号 / 学校名

    服务端验证常量：encrypt_field("13800138000") == "WQZsdeHd/SBQZ8ZhmJzWhg=="
    """
    return aes_cbc_encrypt(plain, FIELD_KEY)


def decrypt_field(cipher_b64: str) -> str:
    return aes_cbc_decrypt(cipher_b64, FIELD_KEY)


encrypt_password = encrypt_field
decrypt_password = decrypt_field


# ══════════════════ 滑块验证码 ══════════════════
def encrypt_slider_point(raw_x: float, y: float = 15.0) -> str:
    """滑块拼图坐标加密（AES-128-ECB）

    协议：先减图片基础边距 6.5 并取整，再加协议位移 16.5。
    服务端自验常量：encrypt_slider_point(101, 15) 的结果在 tests 中固定。
    """
    fake_x = int(raw_x - SLIDER_MARGIN) + SLIDER_OFFSET
    raw = json.dumps({"x": fake_x, "y": int(y)}, separators=(",", ":")).encode("utf-8")
    return aes_ecb_encrypt(raw, SLIDER_KEY)


def decrypt_slider_point(cipher_b64: str) -> Optional[Dict[str, Any]]:
    text = aes_ecb_decrypt(cipher_b64, SLIDER_KEY)
    if not text:
        return None
    try:
        return json.loads(text)
    except Exception:
        return None


# ══════════════════ 跑步防篡改 ══════════════════
def run_img_record(run_record_code: str, timestamp_str: str,
                   build_version: str = BUILD_VERSION,
                   app_version: str = APP_VERSION) -> str:
    """结算防篡改码

    MD5(runRecordCode + buildVersion + appVersion + RUN_IMG_RECORD_KEY + timestamp)
    """
    raw = f"{run_record_code}{build_version}{app_version}{RUN_IMG_RECORD_KEY}{timestamp_str}"
    return hashlib.md5(raw.encode("utf-8")).hexdigest().lower()


calculate_run_img_record = run_img_record


# ══════════════════ 多媒体资源 ══════════════════
def des_decrypt(encrypted_b64: str, index: int = 0) -> Optional[str]:
    """多媒体 DES 资源解密（8 个密钥轮换，ECB）"""
    try:
        key = DES_KEYS[index % len(DES_KEYS)]
        ct = unb64(encrypted_b64)
        pt = ciphers.pkcs7_unpad(_des_ecb_decrypt(ct, key))
        return pt.decode("utf-8", errors="replace")
    except Exception:
        return None


def _des_ecb_decrypt(data: bytes, key: bytes) -> bytes:
    """DES-ECB 解密：优先 pycryptodome，其次 cryptography，最后纯标准库降级"""
    if ciphers.BACKEND == "pycryptodome":  # pragma: no cover
        from Crypto.Cipher import DES  # type: ignore

        return DES.new(key, DES.MODE_ECB).decrypt(data)
    try:  # pragma: no cover
        from cryptography.hazmat.primitives.ciphers import (  # type: ignore
            Cipher, algorithms, modes,
        )

        c = Cipher(algorithms.TripleDES(key * 3), modes.ECB())
        return c.decryptor().update(data)
    except Exception:
        return _stdlib_des(data, key)


# ── 纯标准库 DES 降级实现（仅在两个后端都缺时启用）──
_DES_PC1 = [
    57, 49, 41, 33, 25, 17, 9, 1, 58, 50, 42, 34, 26, 18,
    10, 2, 59, 51, 43, 35, 27, 19, 11, 3, 60, 52, 44, 36,
    63, 55, 47, 39, 31, 23, 15, 7, 62, 54, 46, 38, 30, 22,
    14, 6, 61, 53, 45, 37, 29, 21, 13, 5, 28, 20, 12, 4,
]
_DES_PC2 = [
    14, 17, 11, 24, 1, 5, 3, 28, 15, 6, 21, 10,
    23, 19, 12, 4, 26, 8, 16, 7, 27, 20, 13, 2,
    41, 52, 31, 37, 47, 55, 30, 40, 51, 45, 33, 48,
    44, 49, 39, 56, 34, 53, 46, 42, 50, 36, 29, 32,
]
_DES_SHIFTS = [1, 1, 2, 2, 2, 2, 2, 2, 1, 2, 2, 2, 2, 2, 2, 1]
_DES_IP = [
    58, 50, 42, 34, 26, 18, 10, 2, 60, 52, 44, 36, 28, 20, 12, 4,
    62, 54, 46, 38, 30, 22, 14, 6, 64, 56, 48, 40, 32, 24, 16, 8,
    57, 49, 41, 33, 25, 17, 9, 1, 59, 51, 43, 35, 27, 19, 11, 3,
    61, 53, 45, 37, 29, 21, 13, 5, 63, 55, 47, 39, 31, 23, 15, 7,
]
_DES_FP = [
    40, 8, 48, 16, 56, 24, 64, 32, 39, 7, 47, 15, 55, 23, 63, 31,
    38, 6, 46, 14, 54, 22, 62, 30, 37, 5, 45, 13, 53, 21, 61, 29,
    36, 4, 44, 12, 52, 20, 60, 28, 35, 3, 43, 11, 51, 19, 59, 27,
    34, 2, 42, 10, 50, 18, 58, 26, 33, 1, 41, 9, 49, 17, 57, 25,
]
_DES_E = [
    32, 1, 2, 3, 4, 5, 4, 5, 6, 7, 8, 9,
    8, 9, 10, 11, 12, 13, 12, 13, 14, 15, 16, 17,
    16, 17, 18, 19, 20, 21, 20, 21, 22, 23, 24, 25,
    24, 25, 26, 27, 28, 29, 28, 29, 30, 31, 32, 1,
]
_DES_P = [
    16, 7, 20, 21, 29, 12, 28, 17, 1, 15, 23, 26, 5, 18, 31, 10,
    2, 8, 24, 14, 32, 27, 3, 9, 19, 13, 30, 6, 22, 11, 4, 25,
]
_DES_SBOX = [
    [14, 4, 13, 1, 2, 15, 11, 8, 3, 10, 6, 12, 5, 9, 0, 7,
     0, 15, 7, 4, 14, 2, 13, 1, 10, 6, 12, 11, 9, 5, 3, 8,
     4, 1, 14, 8, 13, 6, 2, 11, 15, 12, 9, 7, 3, 10, 5, 0,
     15, 12, 8, 2, 4, 9, 1, 7, 5, 11, 3, 14, 10, 0, 6, 13],
    [15, 1, 8, 14, 6, 11, 3, 4, 9, 7, 2, 13, 12, 0, 5, 10,
     3, 13, 4, 7, 15, 2, 8, 14, 12, 0, 1, 10, 6, 9, 11, 5,
     0, 14, 7, 11, 10, 4, 13, 1, 5, 8, 12, 6, 9, 3, 2, 15,
     13, 8, 10, 1, 3, 15, 4, 2, 11, 6, 7, 12, 0, 5, 14, 9],
    [10, 0, 9, 14, 6, 3, 15, 5, 1, 13, 12, 7, 11, 4, 2, 8,
     13, 7, 0, 9, 3, 4, 6, 10, 2, 8, 5, 14, 12, 11, 15, 1,
     13, 6, 4, 9, 8, 15, 3, 0, 11, 1, 2, 12, 5, 10, 14, 7,
     1, 10, 13, 0, 6, 9, 8, 7, 4, 15, 14, 3, 11, 5, 2, 12],
    [7, 13, 14, 3, 0, 6, 9, 10, 1, 2, 8, 5, 11, 12, 4, 15,
     13, 8, 11, 5, 6, 15, 0, 3, 4, 7, 2, 12, 1, 10, 14, 9,
     10, 6, 9, 0, 12, 11, 7, 13, 15, 1, 3, 14, 5, 2, 8, 4,
     3, 15, 0, 6, 10, 1, 13, 8, 9, 4, 5, 11, 12, 7, 2, 14],
    [2, 12, 4, 1, 7, 10, 11, 6, 8, 5, 3, 15, 13, 0, 14, 9,
     14, 11, 2, 12, 4, 7, 13, 1, 5, 0, 15, 10, 3, 9, 8, 6,
     4, 2, 1, 11, 10, 13, 7, 8, 15, 9, 12, 5, 6, 3, 0, 14,
     11, 8, 12, 7, 1, 14, 2, 13, 6, 15, 0, 9, 10, 4, 5, 3],
    [12, 1, 10, 15, 9, 2, 6, 8, 0, 13, 3, 4, 14, 7, 5, 11,
     10, 15, 4, 2, 7, 12, 9, 5, 6, 1, 13, 14, 0, 11, 3, 8,
     9, 14, 15, 5, 2, 8, 12, 3, 7, 0, 4, 10, 1, 13, 11, 6,
     4, 3, 2, 12, 9, 5, 15, 10, 11, 14, 1, 7, 6, 0, 8, 13],
    [4, 11, 2, 14, 15, 0, 8, 13, 3, 12, 9, 7, 5, 10, 6, 1,
     13, 0, 11, 7, 4, 9, 1, 10, 14, 3, 5, 12, 2, 15, 8, 6,
     1, 4, 11, 13, 12, 3, 7, 14, 10, 15, 6, 8, 0, 5, 9, 2,
     6, 11, 13, 8, 1, 4, 10, 7, 9, 5, 0, 15, 14, 2, 3, 12],
    [13, 2, 8, 4, 6, 15, 11, 1, 10, 9, 3, 14, 5, 0, 12, 7,
     1, 15, 13, 8, 10, 3, 7, 4, 12, 5, 6, 11, 0, 14, 9, 2,
     7, 11, 4, 1, 9, 12, 14, 2, 0, 6, 10, 13, 15, 3, 5, 8,
     2, 1, 14, 7, 4, 10, 8, 13, 15, 12, 9, 0, 3, 5, 6, 11],
]


def _permute(data: int, table: list, in_bits: int) -> int:
    out = 0
    for pos in table:
        out = (out << 1) | ((data >> (in_bits - pos)) & 1)
    return out


def _des_subkeys(key: bytes) -> list:
    k = int.from_bytes(key, "big")
    k = _permute(k, _DES_PC1, 64)
    c, d = k >> 28, k & 0xFFFFFFF
    subs = []
    for shift in _DES_SHIFTS:
        c = ((c << shift) | (c >> (28 - shift))) & 0xFFFFFFF
        d = ((d << shift) | (d >> (28 - shift))) & 0xFFFFFFF
        subs.append(_permute((c << 28) | d, _DES_PC2, 56))
    return subs


def _des_feistel(r: int, sub: int) -> int:
    x = _permute(r, _DES_E, 32) ^ sub
    out = 0
    for i in range(8):
        six = (x >> (42 - 6 * i)) & 0x3F
        row = ((six & 0x20) >> 4) | (six & 1)
        col = (six >> 1) & 0xF
        out = (out << 4) | _DES_SBOX[i][row * 16 + col]
    return _permute(out, _DES_P, 32)


def _stdlib_des(data: bytes, key: bytes) -> bytes:
    """纯标准库 DES-ECB 解密（无填充，调用方处理）"""
    subs = _des_subkeys(key)
    out = bytearray()
    for off in range(0, len(data), 8):
        blk = int.from_bytes(data[off:off + 8], "big")
        blk = _permute(blk, _DES_IP, 64)
        left, right = blk >> 32, blk & 0xFFFFFFFF
        for sub in reversed(subs):          # 解密：子密钥逆序
            left, right = right, left ^ _des_feistel(right, sub)
        out += _permute((right << 32) | left, _DES_FP, 64).to_bytes(8, "big")
    return bytes(out)
