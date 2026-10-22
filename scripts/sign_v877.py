#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""闪动校园 v8.7.7 协议密码学完整实现（纯 Python，无需 hook / 设备）

逆向来源：
  · native signRequest 真实现 = liby.so+0x1e320（由 ArtMethod.data_ 指向）
  · 算法：AES-256-CBC( SHA256-hex 首尾8换位 , IV=01234ABCDEF56789 )
  · 生产/测试密钥经 native 预言机端到端验证 5/5 一致
  · 交叉验证参考：github.com/Inverx/com.huachenjie.shandong_school (tag v8.7.7)

用法：
    python3 sign_v877.py            # 自检
    python3 sign_v877.py '{"a":1}'  # 计算签名
"""
from __future__ import annotations

import base64
import hashlib
import json
import sys

from Crypto.Cipher import AES, DES
from Crypto.Util.Padding import pad, unpad

# ══════════════════ 密钥常量 ══════════════════
IV = b"01234ABCDEF56789"

# 签名密钥（AES-256：前 16 字节可见，后补 16 个 0x00）
SIGN_KEY_PROD = b"09L8MJRMJKXW8TPF" + bytes(16)   # env ∉ {9, 11}
SIGN_KEY_TEST = b"Z3MDTC9JATA1SSYB" + bytes(16)   # env ∈ {9, 11}

# 敏感字段加密密钥（手机号 / 密码 / 姓名 / 学号 / 学校）
FIELD_KEY = b"F44B0282BEA83557" + bytes(16)

# 滑块验证码坐标（AES-128-ECB）
SLIDER_KEY = b"Ukp3hmSe7BmMcgbE"

# 跑步防篡改静态盐
RUN_IMG_RECORD_KEY = "2V8BQ8MYXWU10Y9Z"

# 多媒体资源解密 DES 密钥组
DES_KEYS = [
    b"c6bd901f", b"0ddf44be", b"950e5927", b"6460d8df",
    b"11fb887f", b"117e4900", b"bd113950", b"a99f6f97",
]

# 版本信息
APP_VERSION = "8.7.7"
BUILD_VERSION = "26101017"
APP_CODE = "SD001"


# ══════════════════ 基础封装 ══════════════════
def _aes_enc(data: bytes, key: bytes, iv: bytes = IV) -> str:
    """AES-CBC + PKCS#7 → Base64"""
    ct = AES.new(key, AES.MODE_CBC, iv).encrypt(pad(data, AES.block_size))
    return base64.b64encode(ct).decode()


def _aes_dec(b64: str, key: bytes, iv: bytes = IV) -> bytes:
    """Base64 → AES-CBC 解密 + 去 PKCS#7"""
    ct = base64.b64decode(b64)
    return unpad(AES.new(key, AES.MODE_CBC, iv).decrypt(ct), AES.block_size)


# ══════════════════ 核心：请求签名 ══════════════════
def sign(body, env: int = 0) -> str:
    """计算 HTTP 请求头 sign，与 native HcjNative.signRequest(json, env) 等价。

    步骤：
      ① 紧凑序列化 JSON（分隔符无空格，ensure_ascii=False）
      ② SHA-256 → 64 字符小写 hex
      ③ 首尾 8 字符换位：hex[-8:] + hex[8:-8] + hex[:8]
      ④ 用 signKey 与固定 IV 执行 AES-256-CBC（PKCS#7）→ Base64

    body: dict（紧凑序列化）或 str
    env : 与 native 第二参数一致；∈ {9, 11} 使用测试密钥
    """
    key = SIGN_KEY_TEST if env in (9, 11) else SIGN_KEY_PROD

    if isinstance(body, dict):
        text = json.dumps(body, separators=(",", ":"), ensure_ascii=False)
    else:
        text = str(body)

    sha = hashlib.sha256(text.encode("utf-8")).hexdigest().lower()
    swapped = sha[-8:] + sha[8:-8] + sha[:8]
    return _aes_enc(swapped.encode("utf-8"), key)


def unsign(sign_b64: str, env: int = 0) -> str:
    """反解签名（调试用）：返回被签名的 64 字符 hex"""
    key = SIGN_KEY_TEST if env in (9, 11) else SIGN_KEY_PROD
    return _aes_dec(sign_b64, key).decode("utf-8")


# ══════════════════ 敏感字段加密 ══════════════════
def encrypt_field(plain: str) -> str:
    """手机号 / 密码 / 姓名 / 学号 / 学校名"""
    return _aes_enc(plain.encode("utf-8"), FIELD_KEY)


def decrypt_field(b64: str) -> str:
    return _aes_dec(b64, FIELD_KEY).decode("utf-8")


def encrypt_password(password: str) -> str:
    return encrypt_field(password)


def decrypt_password(b64: str) -> str:
    return decrypt_field(b64)


# ══════════════════ 滑块验证码 ══════════════════
def encrypt_slider_point(raw_x: float, y: float = 15.0) -> str:
    """滑块拼图坐标（AES-128-ECB）

    先用基础图片边距 6.5 取整，再加协议位移补偿 16.5。
    """
    fake_e = int(raw_x - 6.5) + 16.5
    raw = json.dumps({"x": fake_e, "y": int(y)}, separators=(",", ":")).encode("utf-8")
    ct = AES.new(SLIDER_KEY, AES.MODE_ECB).encrypt(pad(raw, AES.block_size))
    return base64.b64encode(ct).decode()


def decrypt_slider_point(b64: str) -> dict | None:
    try:
        pt = AES.new(SLIDER_KEY, AES.MODE_ECB).decrypt(base64.b64decode(b64))
        return json.loads(unpad(pt, AES.block_size).decode("utf-8"))
    except Exception:
        return None


# ══════════════════ 跑步防篡改 ══════════════════
def calc_run_img_record(run_record_code: str, timestamp: str,
                        build_version: str = BUILD_VERSION,
                        app_version: str = APP_VERSION) -> str:
    """跑步防篡改结算值：MD5(runRecordCode + buildVersion + appVersion + KEY + timestamp)"""
    raw = f"{run_record_code}{build_version}{app_version}{RUN_IMG_RECORD_KEY}{timestamp}"
    return hashlib.md5(raw.encode("utf-8")).hexdigest().lower()


# ══════════════════ 多媒体资源解密 ══════════════════
def des_decrypt(b64: str, index: int) -> str | None:
    try:
        ct = DES.new(DES_KEYS[index % len(DES_KEYS)], DES.MODE_ECB).decrypt(
            base64.b64decode(b64))
        return unpad(ct, DES.block_size).decode("utf-8")
    except Exception:
        return None


# ══════════════════ 自检 ══════════════════
# 全部样本来自 native 预言机（ArtMethod.data_ → liby.so+0x1e320）实测输出
_SELFTEST = [
    ({"probe": 1}, 0, "82nIn4Xz+WshQAVduVf2A5xSzQRSdFC2AVzkBigfMLJFYhZhpxPhA6ItBzuS"
                      "701AsXFQJabnL2Lqa3wqq4y3424SPoa7dtK1vueONiW8iVI="),
    ({}, 0, "tL/UJwaTYM8us8R+MEvjgJap2FqlDvj9Uhjq9+Ete9WuhqzgFwQ8R0MChcGYmfgW5jPUXa"
            "/reZdAysyuB+/4837k47ChVL3ji6i3lJmaP4U="),
    ({"a": 2}, 0, "SyhWzEJUJ9kp9W7NVLJEPVngDmExDq19Zpx4eq/mnZ/5FUtqHU7cDz2CWHSN7hodVkC"
                  "FAtwKPdG1hCMeBXEr9dr4n3va0T2Tf9sciU124z8="),
    ({"a": 1}, 0, "ZFj4FfVGvUmm2r8MHmGcz44zy1C51ddcZJFLcq3MILL2HNhYd+CzuSUdyeHRKcrZzJu"
                  "JUSKAtgM7/QK+vfBAkrEIx6mEhRjF9GFcZapJJqc="),
    ({"probe": 2}, 0, "KfFxFcCDJhR9ZE+vi1QUq7EM5PT8FTe8EjHyMqUtKE5GUD/9mERJv0Riry6kONkDRz"
                      "upQOkkR+oGPj6RGjucRqyNcl+ezcApEyzcCeYRYdo="),
]
_TEST_ENV_SAMPLE = ('{"probe":1}', 9,
                    'EGUiM3Qx/Ykt4r2G06QOH6+7qOl1XMGTqlpPPKD9c+I2ei10N6SgVK1HUbnpsKe/')


def selftest() -> bool:
    print("═" * 68)
    print("★ 自检：与 native 预言机实测输出对比（env=0，生产密钥）")
    print("═" * 68)
    ok = 0
    for body, env, expected in _SELFTEST:
        got = sign(body, env)
        m = got == expected
        ok += m
        print(f"  {str(body):<14} {'★★★ 完全一致 ✓' if m else '✗ 不同'}")
        if not m:
            print(f"     算得: {got}")
            print(f"     期望: {expected}")
    print(f"\n  生产密钥: {ok}/{len(_SELFTEST)} 一致")

    print()
    print("═" * 68)
    print("★ 自检：测试密钥（env ∈ {9,11}）")
    print("═" * 68)
    body, env, expected = _TEST_ENV_SAMPLE
    got = sign(body, env)
    m = got.startswith(expected[:40])
    print(f"  env={env}  {'★★★ 匹配 ✓' if m else '✗'}")
    print(f"     算得: {got[:56]}")
    print(f"     期望: {expected}")

    print()
    print("═" * 68)
    print("★ 附加自检：字段加密 / 反解签名")
    print("═" * 68)
    enc = encrypt_field("13800138000")
    dec = decrypt_field(enc)
    print(f"  字段加密 '13800138000' → {enc}")
    print(f"  解密还原             → {dec}  {'✓' if dec == '13800138000' else '✗'}")
    print(f"  反解签名(env=0)      → {unsign(sign({'a': 1}, 0))}")

    print()
    print("═" * 68)
    print("★ 中间量（可对照 native 解密结果）")
    print("═" * 68)
    for body in ('{"probe":1}', '{}'):
        sha = hashlib.sha256(body.encode()).hexdigest().lower()
        sw = sha[-8:] + sha[8:-8] + sha[:8]
        print(f"  {body:<14}")
        print(f"    SHA256         : {sha}")
        print(f"    首尾8换位      : {sw}")
        print(f"    反解签名得到的 : {unsign(sign(body, 0))}")

    allok = (ok == len(_SELFTEST)) and m and dec == "13800138000"
    print()
    print("═" * 68)
    print("★ " + ("全部自检通过 ✓✓✓" if allok else "存在失败项 ✗"))
    print("═" * 68)
    return allok


if __name__ == "__main__":
    if len(sys.argv) > 1:
        arg = sys.argv[1]
        env = int(sys.argv[2]) if len(sys.argv) > 2 else 0
        try:
            obj = json.loads(arg)
        except Exception:
            obj = arg
        print(sign(obj, env))
    else:
        sys.exit(0 if selftest() else 1)
