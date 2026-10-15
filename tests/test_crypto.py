# -*- coding: utf-8 -*-
"""密码学层单元测试

覆盖点全部来自逆向报告里已经拿到「服务端回显常量」的算法：
字段加密、请求签名、滑块坐标伪装、跑步结算码、编码工具。
这些用例的作用是：任何一次重构只要动了密码学实现的字节语义，立刻就会红。
"""
import unittest

from sdlab import constants as C
from sdlab import crypto, ciphers


class 字段加密测试(unittest.TestCase):
    """手机号 / 密码这类字段用 AES-128-CBC + 固定 IV 加密"""

    def test_已知向量(self):
        """服务端回显过的密文：改动实现后必须逐字节一致"""
        self.assertEqual(crypto.encrypt_field("13800138000"),
                         "WQZsdeHd/SBQZ8ZhmJzWhg==")

    def test_来回一趟(self):
        for 明文 in ("13800138000", "P@ssw0rd!中文", "a", ""):
            with self.subTest(明文=明文):
                self.assertEqual(crypto.decrypt_field(crypto.encrypt_field(明文)), 明文)

    def test_别名可用(self):
        """encrypt_password 是 encrypt_field 的历史别名"""
        self.assertEqual(crypto.encrypt_password("13800138000"),
                         crypto.encrypt_field("13800138000"))


class 请求签名测试(unittest.TestCase):
    """只有 uploadRunRecord 需要签名，签名是「sha256 → 首尾 8 字节换位 → AES-CBC」"""

    def test_长度固定108(self):
        self.assertEqual(len(crypto.get_sign('{"a":1}')), 108)

    def test_验签通过(self):
        body = {"runRecordCode": "SDLABTEST", "dis": 2000, "中文": "值"}
        sign = crypto.get_sign(body)
        self.assertTrue(crypto.verify_sign(body, sign))

    def test_改一个字节就验不过(self):
        body = {"runRecordCode": "SDLABTEST", "dis": 2000}
        sign = crypto.get_sign(body)
        self.assertFalse(crypto.verify_sign({"runRecordCode": "SDLABTEST", "dis": 2001}, sign))

    def test_字典与等价JSON文本签名一致(self):
        """get_sign 接受 dict，签的是紧凑 JSON（无空格、非 ASCII 不转义）"""
        body = {"a": 1, "b": "中文"}
        # 签名 = AES( 换位( sha256(紧凑 JSON) ) )：反解后应回到换位态，再逆换位回到摘要
        sign = crypto.get_sign(body)
        middle = crypto.sign_middle('{"a":1,"b":"中文"}')
        self.assertEqual(crypto.unsign(sign), middle)
        self.assertEqual(crypto.unswap_ends(middle),
                         crypto.sha256_hex('{"a":1,"b":"中文"}'.encode("utf-8")))

    def test_换位是自逆的(self):
        hex64 = "0123456789abcdef" * 4
        self.assertEqual(crypto.unswap_ends(crypto.swap_ends(hex64)), hex64)

    def test_测试环境密钥可用(self):
        body = {"x": 1}
        sign = crypto.get_sign(body, env=C.SIGN_ENV_TEST[0])
        self.assertTrue(crypto.verify_sign(body, sign, env=C.SIGN_ENV_TEST[0]))
        self.assertFalse(crypto.verify_sign(body, sign, env=0))


class 滑块伪装测试(unittest.TestCase):
    """前端把真实缺口位置做了 fixed 偏移，服务端倒推回来"""

    def test_伪装偏移(self):
        data = crypto.decrypt_slider_point(crypto.encrypt_slider_point(100))
        self.assertIsNotNone(data)
        self.assertAlmostEqual(data["x"], int(100 - C.SLIDER_MARGIN) + C.SLIDER_OFFSET, places=3)
        self.assertAlmostEqual(data["y"], 15.0, places=3)

    def test_再解开一次(self):
        """encrypt_slider_point 接受 (x, y) 两参形态"""
        data = crypto.decrypt_slider_point(crypto.encrypt_slider_point(42.0, 33.0))
        self.assertAlmostEqual(data["y"], 33.0, places=3)

    def test_非法密文返回None(self):
        self.assertIsNone(crypto.decrypt_slider_point("这不是base64密文"))


class 结算码测试(unittest.TestCase):
    """runImgRecord = md5(runRecordCode + buildVersion + appVersion + 固定盐 + timestamp)"""

    def test_已知向量(self):
        self.assertEqual(crypto.run_img_record("CODE", "1700000000000"),
                         "e8f923dc6492f7759b4803663adbf800")

    def test_换码就换结果(self):
        a = crypto.run_img_record("CODE1", "1700000000000")
        b = crypto.run_img_record("CODE2", "1700000000000")
        self.assertNotEqual(a, b)
        self.assertEqual(len(a), 32)
        self.assertTrue(all(ch in "0123456789abcdef" for ch in a))


class 密码学原语测试(unittest.TestCase):
    """AES 原语与可插拔后端"""

    def test_后端已探明(self):
        backend, desc = ciphers.backend_info()
        self.assertIn(backend, ("pycryptodome", "cryptography", "stdlib"))
        self.assertTrue(desc)

    def test_cbc来回(self):
        key, iv, text = b"0123456789abcdef", C.AES_IV, "hello 中文 world" * 3
        blob = crypto.aes_cbc_encrypt(text.encode(), key, iv)
        self.assertEqual(crypto.aes_cbc_decrypt(blob, key, iv), text)

    def test_ecb来回(self):
        key, text = C.SLIDER_KEY, "x" * 40
        blob = crypto.aes_ecb_encrypt(text, key)
        self.assertEqual(crypto.aes_ecb_decrypt(blob, key), text)

    def test_填充可逆(self):
        for 长度 in range(0, 33):
            with self.subTest(长度=长度):
                raw = b"A" * 长度
                self.assertEqual(ciphers.pkcs7_unpad(ciphers.pkcs7_pad(raw)), raw)

    def test_base64工具(self):
        self.assertEqual(crypto.unb64(crypto.b64(b"\x00\x01\xfe")), b"\x00\x01\xfe")

    def test_sha256(self):
        self.assertEqual(crypto.sha256_hex(b"abc"),
                         "ba7816bf8f01cfea414140de5dae2223b00361a396177a9cb410ff61f20015ad")


class 常量一致性测试(unittest.TestCase):
    """报告里校验过的常量不许被顺手改掉"""

    def test_版本与包名(self):
        self.assertEqual(C.APP_VERSION, "8.7.7")
        self.assertEqual(C.PACKAGE_NAME, "com.huachenjie.shandong_school")
        self.assertEqual(C.BASE_URL, "https://api.huachenjie.com/run-front")

    def test_只有上传记录需要签名(self):
        需要签名 = [name for name, ep in C.EP.items() if ep.need_sign]
        self.assertEqual(需要签名, ["upload_record"])

    def test_状态位是位掩码(self):
        self.assertEqual((C.STATE_INIT, C.STATE_UPLOADING, C.STATE_FAIL, C.STATE_SUCC),
                         (1, 2, 4, 8))


if __name__ == "__main__":
    unittest.main(verbosity=2)
