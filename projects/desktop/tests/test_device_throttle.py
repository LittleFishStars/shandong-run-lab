# -*- coding: utf-8 -*-
"""机型池 / 请求节流 / 现场照规格 / HAR 工具（2026-10-24 吸收项）测试"""
import io
import json
import unittest
from pathlib import Path
from unittest import mock

from shandong_school_cracked import net as netmod
from shandong_school_cracked.client import process_face_photo
from shandong_school_cracked.constants import (FACE_PHOTO_H, FACE_PHOTO_QUALITY,
                                               FACE_PHOTO_W, MODEL_POOL)
from shandong_school_cracked.simulator import resolve_device_profile

HERE = Path(__file__).resolve().parent


class 机型池测试(unittest.TestCase):
    def test_池完整且无重复(self):
        models = [e["model"] for e in MODEL_POOL]
        self.assertEqual(len(models), len(set(models)), "机型重复")
        for e in MODEL_POOL:
            self.assertTrue(e["versions"], f"{e['model']} 无版本区间")
            for f in ("brand", "manufacturer", "device", "product",
                      "board", "hardware"):
                self.assertTrue(e.get(f), f"{e['model']} 缺 {f}")

    def test_同id同机型_不同id散开(self):
        a1 = resolve_device_profile({}, "id-1234")
        a2 = resolve_device_profile({}, "id-1234")
        self.assertEqual(a1["model"], a2["model"])
        self.assertEqual(a1["system_version"], a2["system_version"])
        models = {resolve_device_profile({}, f"dev-{i}")["model"] for i in range(60)}
        self.assertGreater(len(models), 3, "机型池没有散开（聚类风险）")

    def test_版本只在机型区间内(self):
        pool_models = {e["model"]: set(e["versions"]) for e in MODEL_POOL}
        for i in range(200):
            p = resolve_device_profile({}, f"dev-{i}")
            self.assertIn(p["system_version"], pool_models[p["model"]],
                          f"{p['model']} 出现跨机型版本 {p['system_version']}")

    def test_显式配置优先于池(self):
        dev = resolve_device_profile({"model": "SM-A5460", "brand": "samsung"}, "x")
        self.assertEqual(dev["model"], "SM-A5460")

    def test_Transport池模式deviceId独立于指纹(self):
        t = netmod.Transport({"base_url": "https://api.huachenjie.com/run-front"})
        self.assertEqual(len(t.device_id), 16)
        t2 = netmod.Transport({"base_url": "https://api.huachenjie.com/run-front",
                               "device_id": t.device_id})
        self.assertEqual(
            (t.device_profile["model"], t.device_profile["system_version"]),
            (t2.device_profile["model"], t2.device_profile["system_version"]))


class 请求节流测试(unittest.TestCase):
    def test_本地Mock自动关(self):
        t = netmod.Transport({"base_url": "http://127.0.0.1:9999/run-front"})
        self.assertFalse(t.throttle_enabled)

    def test_真实服务端默认开_可关(self):
        t = netmod.Transport({"base_url": "https://api.huachenjie.com/run-front"})
        self.assertTrue(t.throttle_enabled)
        t = netmod.Transport({"base_url": "https://api.huachenjie.com/run-front",
                              "throttle": False})
        self.assertFalse(t.throttle_enabled)

    def test_节流确实补足间隔(self):
        t = netmod.Transport({"base_url": "https://api.huachenjie.com/run-front",
                              "throttle_range": [0.05, 0.06]})
        t._last_request_at = 1.0          # 假装上次请求发生在远古
        sleeps = []
        with mock.patch.object(netmod.time, "monotonic", side_effect=[100.0] * 6), \
             mock.patch.object(netmod.time, "sleep", side_effect=sleeps.append):
            t._throttle()                 # 首次：gap 巨大 → 不睡
            self.assertEqual(sleeps, [])
            t._throttle()                 # 紧接着：gap≈0 → 补足 0.05~0.06
            self.assertEqual(len(sleeps), 1)
            self.assertGreaterEqual(sleeps[0], 0.04)


class 现场照规格测试(unittest.TestCase):
    def test_输出192x256_q82(self):
        from PIL import Image
        buf = io.BytesIO()
        Image.new("RGB", (750, 1000), (120, 140, 160)).save(buf, format="JPEG", quality=95)
        raw = buf.getvalue()
        out = process_face_photo(raw)
        img = Image.open(io.BytesIO(out))
        self.assertEqual(img.size, (FACE_PHOTO_W, FACE_PHOTO_H))     # 192×256
        self.assertNotEqual(out, raw)                                # md5 必变
        self.assertLess(len(out), len(raw))                          # 压成 KB 级小图
        self.assertEqual(FACE_PHOTO_QUALITY, 82)

    def test_横版图居中裁3比4(self):
        from PIL import Image
        buf = io.BytesIO()
        Image.new("RGB", (2000, 1000), (10, 20, 30)).save(buf, format="JPEG", quality=95)
        out = process_face_photo(buf.getvalue())
        img = Image.open(io.BytesIO(out))
        self.assertEqual(img.size, (192, 256))

    def test_非图像输入原样返回(self):
        self.assertEqual(process_face_photo(b"not-an-image"), b"not-an-image")


class HAR工具测试(unittest.TestCase):
    def test_识别与比对(self):
        import importlib.util
        spec = importlib.util.spec_from_file_location(
            "har_diff", HERE.parent / "scripts" / "har_diff.py")
        hd = importlib.util.module_from_spec(spec)
        spec.loader.exec_module(hd)

        har = {"log": {"entries": [
            {"request": {"url": "https://api.huachenjie.com/run-front/run/uploadRunRecord",
                         "postData": {"text": json.dumps({
                             "pois": [], "runRecordCode": "R1",
                             "modelName": "a|b", "appVersion": "8.7.7",
                             "buildVersion": "26101017", "channel": "other",
                             "appCode": "SD001", "deviceId": "d",
                             "systemVersion": "14", "platform": "2",
                             "timestamp": "1"})}}},
            {"request": {"url": "https://api.huachenjie.com/run-front/run/finishSunRun_v2",
                         "postData": {"text": "not-json"}}},
        ]}}
        tmp = HERE / "_har_test.json"
        tmp.write_text(json.dumps(har), encoding="utf-8")
        try:
            entries = hd.load_entries(tmp)
            self.assertIn("uploadRunRecord", entries)
            self.assertNotIn("finishSunRun_v2", entries)   # 非 JSON 体被跳过
            notes = hd.compare("uploadRunRecord", entries["uploadRunRecord"])
            self.assertTrue(any("完全一致" in n for n in notes), notes)
            bad = [dict(entries["uploadRunRecord"][0])]
            bad[0].pop("channel")
            notes = hd.compare("uploadRunRecord", bad)
            self.assertTrue(any("本实现缺" in n for n in notes), notes)
        finally:
            tmp.unlink(missing_ok=True)


if __name__ == "__main__":
    unittest.main()
