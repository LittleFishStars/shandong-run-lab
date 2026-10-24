# -*- coding: utf-8 -*-
"""人脸扫脸链路测试（报告二十四的实现配套）

三层：
  ① protocol 纯函数：检查点快照回放 / faceCheckRecordList 线缆形态
  ② client：plan_face_checks 的区间语义
  ③ 端到端（Mock 开 face_enabled）：跑完一趟 → 结算报文里带
     faceCheckRecordList，且每个检查点的快照与轨迹自洽。

参考判据（jadx 8.7.7）：
  · StartRunUtils$checkRunRule$2:95-108 —— randomDistance 由客户端在
    [lowerLimit, upperLimit) 内随机；checkIndex 从 1 起
  · SunshineRunFaceRecord —— 结算线缆字段（18 个）
  · DataComponent.t1() —— runScene==20 && faceAuth 才 put faceCheckRecordList
"""
import json
import shutil
import tempfile
import time
import unittest
from pathlib import Path

from shandong_school_cracked import constants as C
from shandong_school_cracked import protocol
from shandong_school_cracked.app import App
from shandong_school_cracked.client import process_face_photo
from shandong_school_cracked.protocol import RunLatLng

超时上限 = 120.0


def _pts(distances_m, start_ms=1_700_000_000_000):
    """造一条沿经线匀速走的轨迹，累计里程 ≈ distances_m[-1]"""
    pts = []
    lat0 = 30.0
    for i, d in enumerate(distances_m):
        pts.append(RunLatLng(
            lat=lat0 + d / protocol.EARTH_M_PER_DEG_LAT,
            lng=120.0,
            lat_lng_index=i,
            run_time=i * 3,
            collect_time=start_ms + i * 3000,
        ))
    return pts


class 检查点快照测试(unittest.TestCase):
    def test_命中里程取首个越界点(self):
        pts = _pts([0, 100, 200, 300, 400])
        plan = [{"checkIndex": 1, "randomDistance": 150},
                {"checkIndex": 2, "randomDistance": 350}]
        snaps = protocol.face_snapshots_from_track(plan, pts)
        self.assertEqual(len(snaps), 2)
        # 150m：首个累计里程 ≥150 的点是 200m 那个（index 2）
        s1, s2 = snaps
        self.assertEqual(s1["checkIndex"], 1)
        self.assertTrue(s1["hasChecked"])
        self.assertEqual(s1["checkDistance"], 200)
        self.assertEqual(s1["popTime"], pts[2].collect_time)
        self.assertAlmostEqual(s1["checkLat"], pts[2].lat, places=9)
        # 350m → 400m 点
        self.assertEqual(s2["checkDistance"], 400)
        self.assertEqual(s2["popTime"], pts[4].collect_time)

    def test_未跑到的检查点置未完成(self):
        pts = _pts([0, 100, 200])
        plan = [{"checkIndex": 1, "randomDistance": 150},
                {"checkIndex": 2, "randomDistance": 5000}]
        snaps = protocol.face_snapshots_from_track(plan, pts)
        self.assertTrue(snaps[0]["hasChecked"])
        self.assertFalse(snaps[1]["hasChecked"])
        for k in ("popTime", "checkDistance", "checkLng", "checkLat"):
            self.assertIsNone(snaps[1][k])

    def test_快照按checkIndex排序且空输入安全(self):
        self.assertEqual(protocol.face_snapshots_from_track([], _pts([0, 1])), [])
        self.assertEqual(protocol.face_snapshots_from_track(
            [{"checkIndex": 1, "randomDistance": 5}], []), [])


class 线缆记录构造测试(unittest.TestCase):
    SNAP = [
        {"checkIndex": 1, "randomDistance": 700, "hasChecked": True,
         "popTime": 111, "checkDistance": 705, "checkLng": 120.0, "checkLat": 30.1},
        {"checkIndex": 2, "randomDistance": 5000, "hasChecked": False,
         "popTime": None, "checkDistance": None, "checkLng": None, "checkLat": None},
    ]

    def test_阿里云模式完成记录字段集(self):
        """fastjson 默认跳过 null：未赋值的 label/faceRequestId 等键不出现"""
        recs = protocol.build_face_check_records(self.SNAP, "https://x/y.jpg", 75)
        want = {"checkIndex", "randomDistance", "hasChecked", "finishFaceCheck",
                "runFaceUpload", "popTime", "checkDistance", "checkLng", "checkLat",
                "runFaceImg", "confidence", "rate", "extendParam"}
        self.assertEqual(set(recs[0]), want)

    def test_未触发记录只有五个恒序列化键(self):
        recs = protocol.build_face_check_records(self.SNAP, "https://x/y.jpg", 75)
        self.assertEqual(set(recs[1]),
                         {"checkIndex", "randomDistance", "hasChecked",
                          "finishFaceCheck", "runFaceUpload"})
        self.assertFalse(recs[1]["hasChecked"])
        self.assertFalse(recs[1]["runFaceUpload"])

    def test_置信度过阈值且不到满分(self):
        recs = protocol.build_face_check_records(self.SNAP, "https://x/y.jpg", 75)
        conf = recs[0]["confidence"]
        self.assertGreaterEqual(conf, 75.0)
        self.assertLess(conf, 100.0)

    def test_rate是detectRate不是活体分(self):
        """DetectFaceDelegate.v：rate = isSuccess ? 1.0f : 0.0f，与活体无关"""
        recs = protocol.build_face_check_records(self.SNAP, "u", 75)
        self.assertEqual(recs[0]["rate"], 1.0)
        self.assertNotIn("label", recs[0])     # 不调活体 → detectLabel=null → 不序列化

    def test_阿里云模式extendParam是进度串(self):
        """DetectFaceDelegate.u 的 progressStr：上传→比对（→活体）各步拼接"""
        recs = protocol.build_face_check_records(self.SNAP, "u", 75,
                                                 face_model_type=1, body_enable=False)
        self.assertEqual(recs[0]["extendParam"], "uploading->success->compare->success")
        recs = protocol.build_face_check_records(self.SNAP, "u", 75,
                                                 face_model_type=1, body_enable=True)
        self.assertEqual(recs[0]["extendParam"],
                         "uploading->success->compare->success->living->success")

    def test_本地模式extendParam是状态JSON(self):
        """t() 广播 RunFaceDetectStatus：modelInit 成功是 0（原版 !k()?1:0 照抄），
        livenessCheck 只有 bodyEnable 才置 1"""
        recs = protocol.build_face_check_records(self.SNAP, "u", 75,
                                                 face_model_type=2, body_enable=False)
        ext = json.loads(recs[0]["extendParam"])
        self.assertEqual(set(ext), {"baseImageDownload", "baseImageParse",
                                    "bestImageCapture", "cameraStart",
                                    "livenessCheck", "modelInit",
                                    "similarityCheck", "uploadImage"})
        self.assertEqual(ext["modelInit"], 0)
        self.assertEqual(ext["livenessCheck"], 0)
        for k in ("baseImageDownload", "baseImageParse", "bestImageCapture",
                  "cameraStart", "similarityCheck", "uploadImage"):
            self.assertEqual(ext[k], 1, k)
        # 键序按 fastjson 字母序
        self.assertEqual(recs[0]["extendParam"].index('"baseImageDownload"')
                         < recs[0]["extendParam"].index('"uploadImage"'), True)
        recs = protocol.build_face_check_records(self.SNAP, "u", 75,
                                                 face_model_type=2, body_enable=True)
        self.assertEqual(json.loads(recs[0]["extendParam"])["livenessCheck"], 1)

    def test_未完成记录不上送照片(self):
        recs = protocol.build_face_check_records(self.SNAP, "https://x/y.jpg", 75)
        self.assertEqual(recs[0]["runFaceImg"], "https://x/y.jpg")
        self.assertTrue(recs[0]["runFaceUpload"])
        self.assertNotIn("runFaceImg", recs[1])

class 门控测试(unittest.TestCase):
    """DataComponent.t1()：runScene==20 && faceAuth 才 put faceCheckRecordList"""

    def setUp(self):
        from shandong_school_cracked.client import ShandongClient
        from shandong_school_cracked.store import RecordStore
        self.c = ShandongClient.__new__(ShandongClient)
        self.c.cfg = {}
        self.c.local_mode = True
        self.c.bus = None
        self.c._oss_token = {}
        self.c.store = RecordStore(Path(tempfile.mkdtemp(prefix="face-gate-")) / "r.db")
        self.c.store.kv_set("facecheck:R1", [
            {"checkIndex": 1, "randomDistance": 700, "hasChecked": True,
             "popTime": 1, "checkDistance": 705, "checkLng": 1.0, "checkLat": 2.0}])

    def test_runScene非20不注入(self):
        self.c.face_check = {"faceImg": "x", "faceAuth": True, "runScene": 1,
                             "similarityValue": 75, "faceModelType": 1}
        self.assertIsNone(self.c.build_face_check_list("R1"))

    def test_未认证不注入(self):
        self.c.face_check = {"faceImg": "x", "faceAuth": False, "runScene": 20,
                             "similarityValue": 75, "faceModelType": 1}
        self.assertIsNone(self.c.build_face_check_list("R1"))

    def test_无底图不注入(self):
        self.c.face_check = {"faceImg": "", "faceAuth": True, "runScene": 20,
                             "similarityValue": 75, "faceModelType": 1}
        self.assertIsNone(self.c.build_face_check_list("R1"))

    def test_条件齐备才注入(self):
        self.c.face_check = {"faceImg": "https://mock.local/base.jpg", "faceAuth": True,
                             "runScene": 20, "similarityValue": 75, "faceModelType": 1}
        lst = self.c.build_face_check_list("R1")
        self.assertIsNotNone(lst)
        self.assertEqual(lst[0]["extendParam"], "uploading->success->compare->success")


class 检查点计划测试(unittest.TestCase):
    def test_区间语义照原版(self):
        from shandong_school_cracked.client import ShandongClient
        c = ShandongClient.__new__(ShandongClient)      # 只测纯逻辑，不联网
        c.face_check = {"faceCheckConfigList": [
            {"lowerLimit": 600, "upperLimit": 900},
            {"lowerLimit": 1000, "upperLimit": 1000},   # upper==lower → 直接用 lower
            {"lowerLimit": 0, "upperLimit": 0},
        ]}
        plan = c.plan_face_checks()
        self.assertEqual([p["checkIndex"] for p in plan], [1, 2, 3])
        self.assertTrue(600 <= plan[0]["randomDistance"] < 900)
        self.assertEqual(plan[1]["randomDistance"], 1000)
        self.assertEqual(plan[2]["randomDistance"], 0)


class 端到端人脸结算测试(unittest.TestCase):
    """Mock 开 face_enabled：整趟跑步后结算报文必须带 faceCheckRecordList"""

    @classmethod
    def setUpClass(cls):
        cls.tmp = Path(tempfile.mkdtemp(prefix="shandong-school_cracked-face-"))
        cls.app = App(data_dir=cls.tmp, config_path=cls.tmp / "config.json", mode="mock")
        cls.错误 = []
        cls.run_code = ""
        try:
            cls.app.login("13800138000", "any-password", False)
            # 打开人脸核验（MockWorld 开关，等价于学校侧配置）
            cls.app.world.face_enabled = True
            cls.app.run_prepare()
            cls.app.run_auto(target_m=3000, fence_index=0,
                             do_upload=True, do_finish=True,
                             sport_type=C.SPORT_TYPE_SUN)
            cls.等完()
            cls.last = dict(cls.app.status().get("last") or {})
            cls.run_code = cls.last.get("run_code") or ""
        except Exception as e:  # noqa: BLE001 —— 让用例给出可读失败而不是 setUpClass 崩溃
            cls.错误 = [f"{type(e).__name__}: {e}"]

    @classmethod
    def 等完(cls, 上限=超时上限):
        t0 = time.time()
        while cls.app.running() and time.time() - t0 < 上限:
            time.sleep(0.2)

    @classmethod
    def tearDownClass(cls):
        cls.app.stop_mock()
        shutil.rmtree(cls.tmp, ignore_errors=True)

    def 报文(self, endpoint: str) -> dict:
        run_code = self.run_code or self.app.engine.last.get("run_code")
        self.assertTrue(run_code, "没有跑起来：setUpClass 失败")
        for e in self.app.run_detail(run_code)["upload_log"]:
            if e["endpoint"] == endpoint:
                return json.loads(e["payload_json"])
        self.fail(f"上传日志里没有 {endpoint}")

    def test_结算带faceCheckRecordList(self):
        body = self.报文("run/finishSunRun_v2")
        self.assertIn("faceCheckRecordList", body)
        recs = body["faceCheckRecordList"]
        self.assertEqual(len(recs), 2)      # Mock 下发两个检查点

    def test_记录字段与服务端区间自洽(self):
        body = self.报文("run/finishSunRun_v2")
        recs = body["faceCheckRecordList"]
        for i, r in enumerate(recs, start=1):
            self.assertEqual(r["checkIndex"], i)
            # Mock 区间：[600,900) / [1500,1800)
            self.assertTrue(r["randomDistance"] >= (600 if i == 1 else 1500))
            self.assertTrue(r["randomDistance"] < (900 if i == 1 else 1800))
            # 3km 跑：两个检查点都应完成
            self.assertTrue(r["hasChecked"])
            self.assertTrue(r["finishFaceCheck"])
            self.assertIsNotNone(r["popTime"])
            self.assertIsNotNone(r["checkDistance"])
            # 快照里程应在 randomDistance 附近（不超过 +20m，采样间隔内）
            self.assertLessEqual(r["checkDistance"] - r["randomDistance"], 20)

    def test_现场照URL与底图同源(self):
        """本地仿真 real→reuse 降级：runFaceImg = Mock 下发的底图 URL"""
        body = self.报文("run/finishSunRun_v2")
        for r in body["faceCheckRecordList"]:
            self.assertEqual(r["runFaceImg"], self.app.world.face_img)
            self.assertTrue(r["runFaceUpload"])

    def test_关闭后不带人脸键(self):
        """face_check.mode=off：不注入（原版 runScene!=20 或未认证的语义）"""
        self.app.patch_config({"run": {"face_check": {"mode": "off"}}})
        try:
            self.app.run_prepare()
            self.app.run_auto(target_m=2500, fence_index=0,
                              do_upload=True, do_finish=True,
                              sport_type=C.SPORT_TYPE_SUN)
            self.等完()
            run_code = (self.app.status().get("last") or {}).get("run_code")
            self.assertTrue(run_code, "off 模式那趟没跑起来")
            for e in self.app.run_detail(run_code)["upload_log"]:
                if e["endpoint"] == "run/finishSunRun_v2":
                    body = json.loads(e["payload_json"])
                    self.assertNotIn("faceCheckRecordList", body)
                    return
            self.fail("没有结算记录")
        finally:
            self.app.patch_config({"run": {"face_check": {"mode": "real"}}})


class TLS伪装测试(unittest.TestCase):
    def test_默认chrome110且会话可用(self):
        """默认伪装开启；curl_cffi 缺席时自动降级为空（不抛异常）"""
        from shandong_school_cracked import net as netmod
        t = netmod.Transport({})
        if netmod._HAS_CURL_CFFI:
            self.assertEqual(t.tls_impersonate, "chrome110")
            self.assertIsNotNone(t._cffi_session)
        else:
            self.assertEqual(t.tls_impersonate, "")
            self.assertIsNone(t._cffi_session)

    def test_显式关闭(self):
        from shandong_school_cracked import net as netmod
        t = netmod.Transport({"tls_impersonate": ""})
        self.assertEqual(t.tls_impersonate, "")
        self.assertIsNone(t._cffi_session)


if __name__ == "__main__":
    unittest.main()



def _真底图(w=540, h=720):
    import io
    from PIL import Image, ImageDraw
    buf = io.BytesIO()
    img = Image.new("RGB", (w, h), (110, 130, 150))
    d = ImageDraw.Draw(img)
    d.ellipse((w//2-90, h//2-160, w//2+90, h//2+180), fill=(190, 160, 140))
    d.ellipse((w//2-40, h//2-80, w//2-10, h//2-50), fill=(40, 30, 30))
    d.ellipse((w//2+10, h//2-80, w//2+40, h//2-50), fill=(40, 30, 30))
    img.save(buf, format="JPEG", quality=92)
    return buf.getvalue()


class 现场照随机化测试(unittest.TestCase):
    """同一底图两次加工必出不同字节（防哈希/对象名比对），且识别无损"""

    @staticmethod
    def _底图(w=540, h=720):
        import io
        from PIL import Image, ImageDraw
        buf = io.BytesIO()
        img = Image.new("RGB", (w, h), (110, 130, 150))
        d = ImageDraw.Draw(img)
        d.ellipse((w//2-90, h//2-160, w//2+90, h//2+180), fill=(190, 160, 140))
        d.ellipse((w//2-40, h//2-80, w//2-10, h//2-50), fill=(40, 30, 30))
        d.ellipse((w//2+10, h//2-80, w//2+40, h//2-50), fill=(40, 30, 30))
        d.line((w//2-25, h//2+60, w//2+25, h//2+60), fill=(120, 70, 70), width=6)
        img.save(buf, format="JPEG", quality=92)
        return buf.getvalue()

    def test_同底图两次产物字节必不同(self):
        raw = self._底图()
        outs = {process_face_photo(raw) for _ in range(6)}
        self.assertEqual(len(outs), 6, "六次加工出现了重复字节——哈希比对会暴露")
        for out in outs:
            self.assertNotEqual(out, raw)

    def test_规格恒为192x256且可解码(self):
        from PIL import Image
        import io
        raw = self._底图()
        for _ in range(4):
            img = Image.open(io.BytesIO(process_face_photo(raw)))
            self.assertEqual(img.size, (192, 256))

    def test_种子可复现(self):
        import random
        raw = self._底图()
        a = process_face_photo(raw, rng=random.Random(42))
        b = process_face_photo(raw, rng=random.Random(42))
        self.assertEqual(a, b)

    def test_扰动幅度在识别无损区间(self):
        """两次随机化产物的灰度结构相关 > 0.97：人脸 embedding 依赖结构，
        相关 0.97+ 意味着视觉内容基本未变，比对相似度不受影响"""
        import io
        import statistics
        from PIL import Image
        raw = self._底图()

        def gray(b):
            return list(Image.open(io.BytesIO(b)).convert("L").getdata())

        samples = [gray(process_face_photo(raw)) for _ in range(8)]
        cors = []
        for i in range(len(samples)):
            for j in range(i + 1, len(samples)):
                a, b = samples[i], samples[j]
                ma, mb = statistics.mean(a), statistics.mean(b)
                cov = sum((x - ma) * (y - mb) for x, y in zip(a, b))
                va = sum((x - ma) ** 2 for x in a) ** 0.5
                vb = sum((y - mb) ** 2 for y in b) ** 0.5
                cors.append(cov / (va * vb) if va * vb > 0 else 0)
        self.assertGreater(min(cors), 0.97,
                           f"随机化产物结构相关过低：{min(cors):.4f}")


class 按检查点独立上传测试(unittest.TestCase):
    """real 模式：每个检查点独立加工+上传 → URL 必不同（原版逐点拍照语义）"""

    def test_线缆层按checkIndex取URL(self):
        snaps = [
            {"checkIndex": 1, "randomDistance": 700, "hasChecked": True,
             "popTime": 1, "checkDistance": 705, "checkLng": 1.0, "checkLat": 2.0},
            {"checkIndex": 2, "randomDistance": 1600, "hasChecked": True,
             "popTime": 2, "checkDistance": 1605, "checkLng": 1.0, "checkLat": 2.0},
            {"checkIndex": 3, "randomDistance": 5000, "hasChecked": False,
             "popTime": None, "checkDistance": None, "checkLng": None, "checkLat": None},
        ]
        photos = {1: "https://x/run/a.jpg", 2: "https://x/run/b.jpg"}
        recs = protocol.build_face_check_records(snaps, photos, 75, face_model_type=2)
        self.assertEqual(recs[0]["runFaceImg"], "https://x/run/a.jpg")
        self.assertEqual(recs[1]["runFaceImg"], "https://x/run/b.jpg")
        self.assertNotIn("runFaceImg", recs[2])
        self.assertFalse(recs[2]["runFaceUpload"])
        self.assertTrue(recs[0]["runFaceUpload"] and recs[1]["runFaceUpload"])

    def test_缺URL的检查点runFaceUpload为假(self):
        snaps = [{"checkIndex": 1, "randomDistance": 700, "hasChecked": True,
                  "popTime": 1, "checkDistance": 705, "checkLng": 1.0, "checkLat": 2.0}]
        recs = protocol.build_face_check_records(snaps, {}, 75)
        self.assertFalse(recs[0]["runFaceUpload"])
        self.assertNotIn("runFaceImg", recs[0])

    def test_客户端层每点独立上传(self):
        from unittest import mock
        from shandong_school_cracked.client import ShandongClient
        from shandong_school_cracked.store import RecordStore
        import tempfile
        c = ShandongClient.__new__(ShandongClient)
        c.cfg = {}
        c.local_mode = False            # 走 real 分支
        c.bus = None
        c._oss_token = {}
        c.transport = mock.Mock()
        c.transport.download.return_value = self._底图() if hasattr(self, "_底图") else _真底图()
        c.face_check = {"faceImg": "https://x/base.jpg", "faceAuth": True,
                        "runScene": 20, "similarityValue": 75,
                        "faceModelType": 2}
        c.store = RecordStore(Path(tempfile.mkdtemp(prefix="face-per-")) / "r.db")
        c.store.kv_set("facecheck:R1", [
            {"checkIndex": 1, "randomDistance": 700, "hasChecked": True,
             "popTime": 1, "checkDistance": 705, "checkLng": 1.0, "checkLat": 2.0},
            {"checkIndex": 2, "randomDistance": 1600, "hasChecked": True,
             "popTime": 2, "checkDistance": 1605, "checkLng": 1.0, "checkLat": 2.0},
        ])
        with mock.patch.object(c, "upload_face_run_image",
                               side_effect=lambda b: f"https://x/run/{hash(b) & 0xffffffff:x}.jpg") as up:
            lst = c.build_face_check_list("R1")
        self.assertEqual(up.call_count, 2, "两个检查点应各传一张")
        urls = [r["runFaceImg"] for r in lst]
        self.assertEqual(len(set(urls)), 2, f"两个检查点 URL 相同：{urls}")
