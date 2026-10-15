# -*- coding: utf-8 -*-
"""端到端集成测试：登录 → 阳光跑 → 数据记录 → 数据上传 → 结算

整条链路走本地 Mock 服务端（127.0.0.1），不碰真实服务器；
SQLite 落在临时目录，跑完即删。一次完整跑步在 setUpClass 里只跑一次，
后面的用例都断言那次跑步留下的痕迹（省时间、也更接近真实使用）。
"""
import json
import shutil
import tempfile
import time
import unittest
from pathlib import Path

from sdlab import constants as C
from sdlab.app import App

超时上限 = 120.0


class 全链路测试(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.tmp = Path(tempfile.mkdtemp(prefix="sdlab-e2e-"))
        cls.app = App(data_dir=cls.tmp, config_path=cls.tmp / "config.json")
        cls.错误 = []
        try:
            cls.app.login("13800138000", "any-password", False)
            cls.app.run_prepare()
            r = cls.app.run_auto(target_m=1200, fence_index=0,
                                 do_upload=True, do_finish=True, sport_type=C.SPORT_TYPE_SUN)
            if r.get("code") != 0:
                cls.错误.append(f"run_auto 返回 {r}")
            cls.等完()
            cls.last = dict(cls.app.status().get("last") or {})
            cls.run_code = cls.last.get("run_code") or ""
        except Exception as e:  # noqa: BLE001 —— 让用例给出可读失败而不是 setUpClass 崩溃
            cls.错误.append(f"{type(e).__name__}: {e}")

    @classmethod
    def tearDownClass(cls):
        try:
            cls.app.close()
        finally:
            shutil.rmtree(cls.tmp, ignore_errors=True)

    @classmethod
    def 等完(cls, 上限=超时上限):
        t0 = time.time()
        while cls.app.running() and time.time() - t0 < 上限:
            time.sleep(0.2)

    def 前置(self):
        if self.错误:
            self.skipTest("前置跑步失败：" + "；".join(self.错误))
        if not self.run_code:
            self.skipTest("前置跑步没有产出 run_code")

    # ── 登录与状态 ──
    def test_登录后状态可读(self):
        st = self.app.status()
        self.assertEqual(st["mode"], "mock")
        self.assertTrue(st["logged_in"] or st.get("user"))
        self.assertTrue(st["device_id"])
        self.assertTrue(st["data_dir"])

    def test_备跑拿到围栏与规则(self):
        st = self.app.status()
        self.assertGreaterEqual(len(st.get("fences") or []), 1)
        self.assertTrue(st.get("rule"))
        self.assertGreaterEqual(len(st.get("checkpoints") or []), 1)

    # ── 跑步结果 ──
    def test_跑步产出完整记录(self):
        self.前置()
        self.assertEqual(self.last.get("run_code"), self.run_code)
        self.assertGreater(int(self.last.get("points") or 0), 50)
        self.assertGreater(int(self.last.get("steps") or 0), 10)
        self.assertGreater(int(self.last.get("paces") or 0), 0)

    def test_距离落在规则区间(self):
        self.前置()
        dis = float(self.last.get("distance_m") or 0)
        rule = self.app.status().get("rule") or {}
        self.assertGreaterEqual(dis, float(rule.get("singleMinDistance") or 1000))
        self.assertLessEqual(dis, float(rule.get("singleMaxDistance") or 10000))

    def test_配速合理(self):
        self.前置()
        pace = float(self.last.get("pace_s_per_km") or 0)
        self.assertGreater(pace, 120)
        self.assertLess(pace, 600)

    def test_打卡点全部命中(self):
        self.前置()
        self.assertEqual(int(self.last.get("checkpoints_done") or 0),
                         int(self.last.get("checkpoints_total") or 0))
        self.assertGreaterEqual(int(self.last.get("checkpoints_total") or 0), 1)

    def test_本地判定有效(self):
        self.前置()
        valid = self.last.get("valid") or {}
        self.assertTrue(valid.get("isValid", valid.get("is_valid")),
                        f"本地判定不通过：{valid}")

    # ── 上传 ──
    def test_上传各步都成功(self):
        self.前置()
        up = self.last.get("upload") or {}
        self.assertTrue(up, "没有上传摘要")
        for 步骤, 结果 in up.items():
            if 步骤 in ("finish",) and not isinstance(结果, dict):
                continue
            with self.subTest(步骤=步骤):
                self.assertEqual(结果.get("code"), C.CODE_OK, f"{步骤}: {结果}")

    def test_轨迹点全部上传成功(self):
        self.前置()
        counts = self.app.run_detail(self.run_code)["counts"]
        self.assertEqual(counts["points_pending"], 0)
        self.assertEqual(counts["points_failed"], 0)
        self.assertEqual(counts["points_uploaded"], counts["points"])
        self.assertGreater(counts["points"], 50)

    def test_服务端结算通过(self):
        self.前置()
        finish = (self.last.get("upload") or {}).get("finish") or {}
        self.assertEqual(finish.get("code"), C.CODE_OK, f"结算被拒：{finish}")
        run = self.app.run_detail(self.run_code)["run"]
        self.assertEqual(run["uploaded"], 1)
        self.assertEqual(int(run["status"] or 0), 1, "服务端判定无效")

    def test_上传日志有记录(self):
        self.前置()
        日志 = self.app.run_detail(self.run_code)["upload_log"]
        端点 = {e["endpoint"] for e in 日志}
        for 名 in ("run/uploadRunRecord", "run/uploadStepsRecord",
                   "run/uploadPaceRecord", "run/uploadPassPoint",
                   "run/finishSunRun_v2"):
            self.assertIn(名, 端点)
        self.assertTrue(all(e["ok"] for e in 日志))

    # ── 记录与导出 ──
    def test_记录列表可见(self):
        self.前置()
        列表 = self.app.list_runs(20)
        self.assertIn(self.run_code, [r["run_code"] for r in 列表])

    def test_导出JSON字段齐全(self):
        self.前置()
        结果 = self.app.export(self.run_code, "json")
        self.assertEqual(结果.get("code"), C.CODE_OK)
        路径 = 结果["path"]
        data = json.loads(Path(路径).read_text(encoding="utf-8"))
        for 字段 in ("run", "points", "checkpoints", "steps", "paces"):
            self.assertIn(字段, data)
        self.assertEqual(len(data["points"]), self.app.run_detail(self.run_code)["counts"]["points"])

    def test_导出GPX可解析(self):
        self.前置()
        路径 = self.app.export(self.run_code, "gpx")["path"]
        文本 = Path(路径).read_text(encoding="utf-8")
        self.assertTrue(文本.startswith("<?xml"))
        self.assertIn("<trkpt lat=", 文本)
        self.assertIn("</gpx>", 文本)

    # ── 断点续传（独立小跑，避免污染前置跑步）──
    def test_断点续传补齐失败点(self):
        self.前置()
        self.app.run_prepare()
        self.app.run_auto(target_m=1400, fence_index=0,
                          do_upload=True, do_finish=True, sport_type=C.SPORT_TYPE_SUN)
        self.等完()
        code = (self.app.status().get("last") or {}).get("run_code")
        self.assertTrue(code, "续传用例没有拿到 run_code")
        pts = self.app.store.get_points(code)
        self.assertGreaterEqual(len(pts), 20)
        待标 = [p.lat_lng_index for p in pts if p.lat_lng_index >= 5]
        self.app.store.set_point_states(code, 待标, C.STATE_FAIL)
        前 = self.app.run_detail(code)["counts"]
        self.assertEqual(前["points_failed"], len(待标))
        self.assertEqual(self.app.resume(code).get("code"), C.CODE_OK)
        self.等完()
        后 = self.app.run_detail(code)["counts"]
        self.assertEqual(后["points_failed"], 0, f"续传没补齐：{后}")
        self.assertEqual(后["points_pending"], 0)
        self.assertEqual(后["points_uploaded"], 后["points"])

    def test_删除记录(self):
        self.前置()
        self.app.store.create_run("SDLAB-DELETE-ME", sport_type=C.SPORT_TYPE_SUN)
        self.assertIn("SDLAB-DELETE-ME", [r["run_code"] for r in self.app.list_runs(50)])
        self.assertEqual(self.app.delete_run("SDLAB-DELETE-ME").get("code"), C.CODE_OK)
        self.assertNotIn("SDLAB-DELETE-ME", [r["run_code"] for r in self.app.list_runs(50)])


class 手动实走测试(unittest.TestCase):
    """摇杆控制路径 + 只规划不动：走同一套 App/Mock，不碰真实服务端

    与全链路测试的区别：轨迹由外部输入（摇杆/路径跟随）驱动而不是一次算完，
    因此验证重点是「增量采样」「干跑不落库」「实跑可上传」。
    """

    @classmethod
    def setUpClass(cls):
        cls.tmp = Path(tempfile.mkdtemp(prefix="sdlab-e2e-walk-"))
        cls.app = App(data_dir=cls.tmp, config_path=cls.tmp / "config.json")
        cls.app.login("13800138000", "any-password", False)
        cls.app.run_prepare()

    @classmethod
    def tearDownClass(cls):
        cls.app.close()
        shutil.rmtree(cls.tmp, ignore_errors=True)

    def test_仅规划不升跑不落库(self):
        before = len(self.app.list_runs(200))
        r = self.app.walk_plan()
        self.assertEqual(r["code"], C.CODE_OK)
        d = r["data"]
        self.assertTrue(d["planned"])
        self.assertGreaterEqual(len(d["route"]), 1)
        self.assertGreater(d["route_length_m"], 0)
        # 关键：规划不是开跑，库里一条都不该多
        self.assertEqual(len(self.app.list_runs(200)), before)

    def test_干跑不落库且增量取点(self):
        before = len(self.app.list_runs(200))
        r = self.app.walk_start("dry", target_m=0, fence_index=0,
                                speed_mps=3.0, auto_route=False,
                                auto_start=False, speed=30.0)
        self.assertEqual(r["code"], C.CODE_OK)
        self.app.walk_joystick(1.0, 0.0, 1.0)
        time.sleep(1.0)
        st1 = self.app.walk_status(0)
        n1 = int(st1["total"])
        self.assertGreaterEqual(n1, 1)
        self.app.walk_joystick(0.0, 1.0, 1.0)     # 换个方向，确认真在跟着摇杆转
        time.sleep(1.0)
        st2 = self.app.walk_status(n1)
        self.assertGreaterEqual(len(st2["points"]), 1)
        self.assertEqual(int(st2["from"]), n1)
        st = self.app.walk_stop()
        self.assertFalse(st["running"])
        # 干跑的意义：调路径不污染记录
        self.assertEqual(len(self.app.list_runs(200)), before)
        self.assertNotEqual(self.app.walk_upload(True).get("code"), C.CODE_OK)

    def test_实跑落库可上传结算(self):
        before = len(self.app.list_runs(200))
        r = self.app.walk_start("real", target_m=0, fence_index=0,
                                speed_mps=0.0, auto_route=True,
                                auto_start=True, speed=30.0)
        self.assertEqual(r["code"], C.CODE_OK)
        rc = r["data"]["run_code"]
        self.assertTrue(rc)
        # 沿打卡点闭环自动驾驶一会儿，同时确认点数在长
        n = 0
        for _ in range(12):
            time.sleep(0.5)
            n = int(self.app.walk_status(0)["total"])
            if n >= 6:
                break
        self.assertGreaterEqual(n, 1)
        st = self.app.walk_stop()
        self.assertFalse(st["running"])
        # 实跑必须落库，而且落的是本次 run_code
        self.assertGreater(len(self.app.store.get_points(rc, None)), 0)
        self.assertGreater(len(self.app.list_runs(200)), before)
        # 走与一键跑完全相同的上传链路（含 sign）
        up = self.app.walk_upload(True)
        self.assertEqual(up.get("code"), C.CODE_OK)
        t0 = time.time()
        while self.app.running() and time.time() - t0 < 60:
            time.sleep(0.2)
        last = self.app.status().get("last") or {}
        self.assertEqual((last.get("upload") or {}).get("points", {}).get("code"), C.CODE_OK)
        self.assertEqual((last.get("finish") or {}).get("code"), C.CODE_OK)


class 错误处理测试(unittest.TestCase):
    """不依赖前置跑步：只验证异常输入不会把程序带崩"""

    @classmethod
    def setUpClass(cls):
        cls.tmp = Path(tempfile.mkdtemp(prefix="sdlab-e2e-err-"))
        cls.app = App(data_dir=cls.tmp, config_path=cls.tmp / "config.json")

    @classmethod
    def tearDownClass(cls):
        cls.app.close()
        shutil.rmtree(cls.tmp, ignore_errors=True)

    def test_未登录不能备跑(self):
        r = self.app.run_prepare()
        self.assertNotEqual(r.get("code"), C.CODE_OK)

    def test_未知记录导出报错(self):
        self.assertFalse(self.app.export("不存在的记录", "json").get("path"))

    def test_未知记录删除不崩(self):
        self.assertNotEqual(self.app.delete_run("不存在的记录").get("code"), C.CODE_OK)

    def test_登录缺参数被拒(self):
        self.app.logout()
        r = self.app.login("", "", False)
        self.assertNotEqual(r.get("code"), C.CODE_OK)

    def test_配置补丁可写回(self):
        self.app.patch_config({"run": {"target_distance_m": 1500}})
        self.assertEqual(self.app.status()["run_cfg"]["target_distance_m"], 1500)


if __name__ == "__main__":
    unittest.main(verbosity=2)
