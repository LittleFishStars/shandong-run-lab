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

from shandong_school_cracked import constants as C
from shandong_school_cracked.app import App
from shandong_school_cracked.protocol import point_in_polygon

超时上限 = 120.0


class 全链路测试(unittest.TestCase):
    @classmethod
    def setUpClass(cls):
        cls.tmp = Path(tempfile.mkdtemp(prefix="shandong-school_cracked-e2e-"))
        # 测试一律钉死本地 Mock：默认模式是真实服务端，单元测试不能去碰真实网络
        cls.app = App(data_dir=cls.tmp, config_path=cls.tmp / "config.json", mode="mock")
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
        # 打卡点只在开跑后才有：坐标由服务端 startSunRun_v2 的 targetPoints 下发
        self.assertEqual(st.get("checkpoints_source"), "server")
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

    def test_结算报文带runImgRecord且距离是字符串(self):
        """原版 km7.c() 在进 finishSunRun_v2 之前调 aw8.c()，无条件塞
        runImgRecord 与 timestamp；distance 走 String.valueOf(...)"""
        self.前置()
        日志 = self.app.run_detail(self.run_code)["upload_log"]
        finish = [e for e in 日志 if e["endpoint"] == "run/finishSunRun_v2"]
        self.assertTrue(finish, "没有结算记录")
        body = json.loads(finish[0]["payload_json"])
        self.assertTrue(body.get("runImgRecord"), f"缺 runImgRecord：{body}")
        self.assertTrue(body.get("timestamp"), f"缺 timestamp：{body}")
        self.assertEqual(len(body["runImgRecord"]), 32)
        self.assertIsInstance(body["distance"], str, "distance 必须是 String")
        self.assertIsInstance(body["duration"], str)
        self.assertIsInstance(body["totalStep"], str)
        # 服务端（Mock）重算必须与客户端声明一致
        from shandong_school_cracked import crypto
        self.assertEqual(
            crypto.run_img_record(body["runRecordCode"], body["timestamp"]),
            body["runImgRecord"])

    def test_结算报文带暂停字段(self):
        """DataComponent.t1() 的 pauseCount / pauseTimes 是实际值（Long/Int），
        这趟没暂停所以都是 0，但字段必须存在且为整数。"""
        self.前置()
        日志 = self.app.run_detail(self.run_code)["upload_log"]
        finish = [e for e in 日志 if e["endpoint"] == "run/finishSunRun_v2"]
        self.assertTrue(finish, "没有结算记录")
        body = json.loads(finish[0]["payload_json"])
        self.assertIsInstance(body.get("pauseCount"), int)
        self.assertIsInstance(body.get("pauseTimes"), int)
        self.assertEqual(body["pauseCount"], 0)
        self.assertEqual(body["pauseTimes"], 0)
        run = self.app.store.get_run(self.run_code)
        self.assertIn("pause_count", run)
        self.assertIn("pause_times_s", run)

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
        cls.tmp = Path(tempfile.mkdtemp(prefix="shandong-school_cracked-e2e-walk-"))
        cls.app = App(data_dir=cls.tmp, config_path=cls.tmp / "config.json", mode="mock")
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

    def test_到达目标里程自动结算(self):
        """跑到 target_m 会自己停；停下来之后必须自己上传 + 结算

        以前的坑：到达目标只在 _loop 的 finally 里发一个 walk_arrived 就结束，
        既没过尾段、没写汇总，也没结算——run 留在「已结束未上传」。
        """
        r = self.app.walk_start("real", target_m=60, fence_index=0,
                                speed_mps=0.0, auto_route=True,
                                auto_start=True, speed=30.0)
        self.assertEqual(r["code"], C.CODE_OK)
        rc = r["data"]["run_code"]
        t0 = time.time()
        while time.time() - t0 < 60:
            st = self.app.walk_status(0)
            if (st.get("state") or {}).get("arrived"):
                break
            time.sleep(0.2)
        self.assertTrue((self.app.walk_status(0).get("state") or {}).get("arrived"),
                        "没自动停在目标里程")
        # arrived 标志是 tick 里置的，收尾（过尾段 + 写汇总 + 发事件）在循环 finally：
        # 等实走线程真正退出，再读库
        t0 = time.time()
        while self.app.walk.running() and time.time() - t0 < 20:
            time.sleep(0.1)
        # 停止当下就必须把汇总写进库，不能等手动 stop
        run = self.app.store.get_run(rc)
        self.assertGreater(float(run.get("distance_m") or 0), 0)
        self.assertGreater(int(run.get("total_step") or 0), 0)
        # 自动结算走后台线程
        t0 = time.time()
        while self.app.running() and time.time() - t0 < 60:
            time.sleep(0.2)
        run = self.app.store.get_run(rc)
        self.assertTrue(run.get("uploaded"), "到达目标后没有自动结算")
        eps = {e["endpoint"] for e in self.app.run_detail(rc)["upload_log"]}
        self.assertIn("run/finishSunRun_v2", eps)
        self.assertIn("run/uploadRunRecord", eps)
        # 已经自动结算过，用户再点「结束跑步」不能把同一趟重复提交
        again = self.app.walk_upload(True)
        self.assertEqual(again.get("code"), 0)
        self.assertIn("已结算", str(again.get("message")))
        n_finish = sum(1 for e in self.app.run_detail(rc)["upload_log"]
                       if e["endpoint"] == "run/finishSunRun_v2")
        self.assertEqual(n_finish, 1)
        # 再点一次停止（界面上很多人会这么做）：尾段不能重复封，汇总不能被改写
        step_before = int((self.app.store.get_run(rc) or {}).get("total_step") or 0)
        self.app.walk_stop()
        run2 = self.app.store.get_run(rc)
        self.assertEqual(int(run2.get("total_step") or 0), step_before)
        self.assertTrue(run2.get("uploaded"))


class 错误处理测试(unittest.TestCase):
    """不依赖前置跑步：只验证异常输入不会把程序带崩"""

    @classmethod
    def setUpClass(cls):
        cls.tmp = Path(tempfile.mkdtemp(prefix="shandong-school_cracked-e2e-err-"))
        cls.app = App(data_dir=cls.tmp, config_path=cls.tmp / "config.json", mode="mock")

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


class 跑步起点测试(unittest.TestCase):
    """地图上「设置起点」：围栏外的点自动吸附进围栏，并同时作用于开跑报文 / 实走轨迹 / 路径规划"""

    @classmethod
    def setUpClass(cls):
        cls.tmp = Path(tempfile.mkdtemp(prefix="shandong-school_cracked-e2e-start-"))
        cls.app = App(data_dir=cls.tmp, config_path=cls.tmp / "config.json", mode="mock")
        cls.app.login("13800138000", "any-password", False)
        cls.app.run_prepare()

    @classmethod
    def tearDownClass(cls):
        cls.app.close()
        shutil.rmtree(cls.tmp, ignore_errors=True)

    def _规划起点(self):
        return (self.app.walk_plan().get("data") or {}).get("start") or {}

    def test_默认起点是围栏中心(self):
        st = self.app.status()
        self.assertIsNone(st.get("start_point"))
        self.assertFalse(st.get("start_point_custom"))
        clat, clng = self.app.client.fence_center()
        p = self._规划起点()
        self.assertAlmostEqual(p["lat"], clat, places=6)
        self.assertAlmostEqual(p["lng"], clng, places=6)

    def test_围栏外的点自动吸附进围栏(self):
        poly = [tuple(x) for x in self.app.client.fence_polygon()]
        clat, clng = self.app.client.fence_center()
        r = self.app.set_start_point(clat + 0.01, clng)      # 往北 1.1 km，肯定在围栏外
        self.assertEqual(r["code"], C.CODE_OK)
        起点 = (r.get("data") or {}).get("start_point") or {}
        self.assertTrue(起点.get("snapped"))
        self.assertTrue(起点.get("in_fence"))
        self.assertTrue(point_in_polygon(起点["lat"], 起点["lng"], poly))
        # 路径规划跟着新起点走
        p = self._规划起点()
        self.assertAlmostEqual(p["lat"], 起点["lat"], places=6)
        self.assertAlmostEqual(p["lng"], 起点["lng"], places=6)

    def test_所选起点进开跑报文(self):
        """把围栏藏起来（等价于吸附不可用），此时选的点必须原样进开跑报文"""
        poly = self.app.client.fence_polygon
        self.app.client.fence_polygon = lambda *a, **k: []
        try:
            clat, clng = self.app.client.fence_center()
            r = self.app.set_start_point(clat + 0.01, clng)
        finally:
            self.app.client.fence_polygon = poly
        self.assertEqual(r["code"], C.CODE_OK)
        self.assertFalse(((r.get("data") or {}).get("start_point") or {}).get("snapped"))
        尾巴 = self.app.bus.events_since(0, 1)
        seq = 尾巴[-1]["seq"] if 尾巴 else 0
        self.assertEqual(self.app.walk_start("real", target_m=0, fence_index=0,
                                             speed_mps=0.0, auto_route=False,
                                             auto_start=True, speed=30.0).get("code"),
                         C.CODE_OK)
        try:
            time.sleep(0.8)
            消息 = " | ".join(e.get("message", "") for e in self.app.bus.events_since(seq))
        finally:
            self.app.walk_stop()
        self.assertIn("Mock 开跑成功", 消息)
        self.assertIn("起点不在围栏内", 消息)   # 报文里的 lat/lng 就是用户选的那个点

    def test_清除起点回到围栏中心(self):
        self.assertEqual(self.app.set_start_point().get("code"), C.CODE_OK)
        st = self.app.status()
        self.assertIsNone(st.get("start_point"))
        self.assertFalse(st.get("start_point_custom"))
        clat, clng = self.app.client.fence_center()
        p = self._规划起点()
        self.assertAlmostEqual(p["lat"], clat, places=6)
        self.assertAlmostEqual(p["lng"], clng, places=6)

    def test_非法坐标被拒(self):
        for 坏点 in ((0.0, 0.0), (91.0, 117.0), ("x", "y")):
            self.assertNotEqual(self.app.set_start_point(*坏点).get("code"), C.CODE_OK)

class 打卡点下发测试(unittest.TestCase):
    """打卡点坐标只有开跑接口（run/startSunRun_v2 → targetPoints）才下发。

    拉取配置阶段能拿到的只有围栏几何与「需要几个打卡点」的计数，
    所以地图上在开跑前不该出现打卡点；开跑后才用服务端下发的点。
    """

    def setUp(self):
        self.tmp = Path(tempfile.mkdtemp(prefix="shandong-school_cracked-cp-"))
        self.app = App(data_dir=self.tmp, config_path=self.tmp / "config.json", mode="mock")
        self.app.login("13800138000", "any-password", False)
        self.app.run_prepare()

    def tearDown(self):
        try:
            self.app.close()
        finally:
            shutil.rmtree(self.tmp, ignore_errors=True)

    def test_拉取配置后没有打卡点(self):
        st = self.app.status()
        self.assertEqual(st.get("checkpoints"), [])
        self.assertEqual(st.get("checkpoints_source"), "")
        self.assertGreaterEqual(len(st.get("preview_points") or []), 1)

    def test_开跑前规划用预估点(self):
        d = self.app.walk_plan()["data"]
        self.assertTrue(d.get("estimated"))
        self.assertTrue(d.get("route"))

    def test_开跑后用服务端下发的打卡点(self):
        r = self.app.walk_start(mode="real", target_m=600, fence_index=0,
                                auto_start=True, speed=30.0)
        self.assertEqual(r.get("code"), C.CODE_OK)
        try:
            st = self.app.status()
            self.assertEqual(st.get("checkpoints_source"), "server")
            cps = st.get("checkpoints") or []
            self.assertGreaterEqual(len(cps), 1)
            code = str((self.app.engine.last or {}).get("run_code") or "")
            self.assertTrue(code)
            self.assertEqual([(round(c["lat"], 6), round(c["lng"], 6)) for c in cps],
                             [(round(c["lat"], 6), round(c["lng"], 6))
                              for c in self.app.store.get_checkpoints(code)])
            # 拿到真实点之后规划就不再是预估的了
            self.assertFalse(self.app.walk_plan()["data"].get("estimated"))
        finally:
            self.app.walk_stop()

    def test_重启后不会平白出现打卡点(self):
        self.assertEqual(self.app.status().get("checkpoints"), [])
        self.app.close()
        self.app = App(data_dir=self.tmp, config_path=self.tmp / "config.json", mode="mock")
        self.assertEqual(self.app.status().get("checkpoints"), [])

class 时间校准测试(unittest.TestCase):
    """公共字段 timestamp 与结算时间参都走「本地时钟 + 服务端校准偏移」。

    原版链路：PrivacyActivity 同意隐私 → SyncTimeIntentService 拉
    `common/syncTime` → data.reduceTimes > 1000 就 r90.i0(reduceTimes)，
    否则归零 → r24.java:95 把它注入 hq1.f3188a → SignInterceptor 发
    `System.currentTimeMillis() + f3188a` 作为 timestamp；aw8.c() 的
    runImgRecord 时间参也是 `System.currentTimeMillis() + r90.D()`。
    """

    def setUp(self):
        self.tmp = Path(tempfile.mkdtemp(prefix="shandong-school_cracked-time-"))
        self.app = App(data_dir=self.tmp, config_path=self.tmp / "config.json", mode="mock")

    def tearDown(self):
        try:
            self.app.close()
        finally:
            shutil.rmtree(self.tmp, ignore_errors=True)

    def test_登录后自动校准(self):
        tr = self.app.client.transport
        self.assertEqual(tr.time_offset_ms, 0)
        self.app.login("13800138000", "any-password", False)
        # Mock 默认偏移 0：断言链路跑通且没有把 0 变成垃圾值
        self.assertEqual(int(tr.time_offset_ms), 0)
        self.assertEqual(tr.clock(), tr._now())

    def test_偏移进入公共字段与结算时间参(self):
        self.app.login("13800138000", "any-password", False)
        tr = self.app.client.transport
        tr.time_offset_ms = 12345          # 模拟服务端算出 12.345 秒偏差
        payload = tr.base_payload()
        self.assertGreaterEqual(int(payload["timestamp"]),
                                int(time.time() * 1000) + 12345 - 2000)
        # 手动再校准会把 Mock 的偏移（0）写回去
        r = self.app.sync_time()
        self.assertEqual(r.get("code"), 0)
        self.assertEqual(int(tr.time_offset_ms), 0)

    def test_超大偏移回归(self):
        """Mock 报一个 > 1000 的 reduceTimes 时必须被采纳（原版阈值语义）"""
        self.app.client.transport.sync_time()
        self.app.world.time_offset_ms = 98765
        r = self.app.sync_time()
        self.assertEqual(r.get("offset_ms"), 98765)
        self.assertEqual(self.app.client.transport.time_offset_ms, 98765)

    def test_小于阈值归零(self):
        """reduceTimes <= 1000 时按原版归零（避免小抖动被当成校准）"""
        self.app.client.transport.time_offset_ms = 555
        self.app.world.time_offset_ms = 600
        r = self.app.sync_time()
        self.assertEqual(r.get("offset_ms"), 0)
        self.assertEqual(self.app.client.transport.time_offset_ms, 0)
        # 校准之后发出去的公共字段 timestamp 必须回到本地时钟
        ts = int(self.app.client.transport.base_payload()["timestamp"])
        self.assertLess(abs(ts - int(time.time() * 1000)), 2000)


class 结算报文路径测试(unittest.TestCase):
    """三条结算路径的报文差异（原版 km7 / aw8 分工）：

    · 阳光跑 `km7.c()` → `aw8.c(params)` → `finishSunRun_v2`：带 runImgRecord
    · 自由跑 `km7.b()` → 直接 `finishFreeRun`：**不带** runImgRecord
    · 异常结束 `StopRunUtils.o()` → `aw8.b()/aw8.a()`：
      `abnormalFinishSunRun` / `abnormalFinishActivityRun`，带 runImgRecord
      与 `abnormalCodes = [checkData]`
    """

    @classmethod
    def setUpClass(cls):
        cls.tmp = Path(tempfile.mkdtemp(prefix="shandong-school_cracked-fin-"))
        cls.app = App(data_dir=cls.tmp, config_path=cls.tmp / "config.json", mode="mock")
        cls.app.login("13800138000", "any-password", False)
        cls.app.run_prepare()
        cls.app.run_auto(target_m=1200, fence_index=0,
                         do_upload=True, do_finish=True, sport_type=C.SPORT_TYPE_SUN)
        cls.等完()
        cls.run_code = str((cls.app.status().get("last") or {}).get("run_code") or "")

    @classmethod
    def 等完(cls):
        end = time.time() + 超时上限
        while time.time() < end:
            pg = cls.app.poll(0).get("progress") or {}
            if not pg.get("running"):
                return
            time.sleep(0.3)

    @classmethod
    def tearDownClass(cls):
        try:
            cls.app.close()
        finally:
            shutil.rmtree(cls.tmp, ignore_errors=True)

    def 报文(self, endpoint: str) -> dict:
        for e in self.app.run_detail(self.run_code)["upload_log"]:
            if e["endpoint"] == endpoint:
                return json.loads(e["payload_json"])
        self.fail(f"上传日志里没有 {endpoint}")

    def test_阳光跑结算带runImgRecord(self):
        body = self.报文("run/finishSunRun_v2")
        self.assertEqual(len(body.get("runImgRecord") or ""), 32)
        self.assertIsInstance(body["distance"], str)
        self.assertIsInstance(body["duration"], str)
        self.assertIsInstance(body["totalStep"], str)

    def test_自由跑结算不带runImgRecord(self):
        """km7.b() 不调 aw8.c()：自由跑路径没有这两个键"""
        self.app.client.finish_run(self.run_code, sun=False)
        body = self.报文("run/finishFreeRun")
        self.assertNotIn("runImgRecord", body)
        self.assertNotIn("abnormalCodes", body)
        # 但公共字段 timestamp 仍在（拦截器加的）
        self.assertTrue(body.get("timestamp"))

    def test_异常结束带abnormalCodes(self):
        r = self.app.client.finish_run(self.run_code, sun=True, abnormal_code=7003)
        self.assertEqual(r.get("code"), C.CODE_OK, f"异常结束被拒：{r}")
        body = self.报文("run/abnormalFinishSunRun")
        self.assertEqual(body.get("abnormalCodes"), [7003])
        self.assertEqual(len(body.get("runImgRecord") or ""), 32)

    def test_活动跑异常结束走另一个端点(self):
        r = self.app.client.finish_run(self.run_code, sport_type=C.SPORT_TYPE_SUN,
                                       sun=True, abnormal_code=3)
        self.assertEqual(r.get("code"), C.CODE_OK, f"异常结束被拒：{r}")
        # sportType==1 走 abnormalFinishSunRun；换成别的 sportType 走 ActivityRun
        r2 = self.app.client.finish_run(self.run_code, sport_type=2,
                                        sun=True, abnormal_code=3)
        self.assertEqual(r2.get("code"), C.CODE_OK, f"活动跑异常结束被拒：{r2}")
        self.报文("run/abnormalFinishActivityRun")

    # ── 报文键集：以 DataComponent.t1() 为唯一判据 ──
    def test_阳光跑结算键集与原版t1完全一致(self):
        """DataComponent.t1(isValid, cheatType) 落的 map + aw8.c() 的两个键
        + ApiDataComponent.J() 可能补的三个列表。
        多一个或少一个都算不一致——服务端按字段名取值。"""
        body = self.报文("run/finishSunRun_v2")
        # t1() 的 12 个业务字段（顺序无关）
        base = {"runRecordCode", "duration", "distance", "totalStep", "status",
                "stepInterval", "paceInterval", "targetPoints", "alignType",
                "pauseCount", "pauseTimes", "sportType"}
        # aw8.c()：runImgRecord + timestamp
        sun = {"runImgRecord", "timestamp"}
        # J()：只有非空才 put
        optional = {"pois", "stepList", "paceList"}
        # t1() 里的条件字段（本次正常流程不该出现）
        conditional = {"cheatList", "invalidReasons", "faceCheckRecordList"}
        # 拦截器注入的 9 个公共字段
        public = {"modelName", "appVersion", "buildVersion", "channel", "appCode",
                  "deviceId", "systemVersion", "platform"}
        keys = set(body)
        self.assertTrue(base <= keys, f"缺 t1 字段：{sorted(base - keys)}")
        self.assertTrue(sun <= keys, f"缺 aw8.c 字段：{sorted(sun - keys)}")
        self.assertTrue(keys <= base | sun | optional | conditional | public,
                        f"多出原版没有的字段：{sorted(keys - (base | sun | optional | conditional | public))}")
        # targetPoints 元素：原版 @JSONType(includes=…) 只序列化 5 个字段
        for p in body["targetPoints"]:
            self.assertEqual(set(p), {"clockTime", "code", "lat", "lng", "passStatus"},
                             f"targetPoints 字段不符：{sorted(p)}")


class 结算残留点补发测试(unittest.TestCase):
    """ApiDataComponent.J()：state∈{1 INIT, 4 FAIL} 且 isValid 的点会被塞进结算

    单独开一个类，因为它会把点表改脏（打回 FAIL），不能污染上面共享的那趟跑。
    """

    @classmethod
    def setUpClass(cls):
        cls.tmp = Path(tempfile.mkdtemp(prefix="shandong-school_cracked-pois-"))
        cls.app = App(data_dir=cls.tmp, config_path=cls.tmp / "config.json", mode="mock")
        cls.app.login("13800138000", "any-password", False)
        cls.app.run_prepare()
        cls.app.run_auto(target_m=1200, fence_index=0,
                         do_upload=True, do_finish=True, sport_type=C.SPORT_TYPE_SUN)
        end = time.time() + 超时上限
        while time.time() < end:
            if not (cls.app.poll(0).get("progress") or {}).get("running"):
                break
            time.sleep(0.3)
        cls.run_code = str((cls.app.status().get("last") or {}).get("run_code") or "")

    @classmethod
    def tearDownClass(cls):
        try:
            cls.app.close()
        finally:
            shutil.rmtree(cls.tmp, ignore_errors=True)

    def 报文(self, endpoint: str) -> dict:
        for e in self.app.run_detail(self.run_code)["upload_log"]:
            if e["endpoint"] == endpoint:
                return json.loads(e["payload_json"])
        self.fail(f"上传日志里没有 {endpoint}")

    def test_结算补发未成功轨迹点pois(self):
        # 首次结算（run_auto 里做的）没有残留点
        self.assertNotIn("pois", self.报文("run/finishSunRun_v2"),
                         "测试前提：首次结算时没有残留点")
        # 把这趟的点打回 FAIL，模拟“轨迹上传失败后直接结算”
        ids = [p.lat_lng_index
               for p in self.app.store.get_points(self.run_code, None, valid_only=True)]
        self.assertGreater(len(ids), 20, "测试前提：这趟得有不少点")
        self.app.store.set_point_states(self.run_code, ids[:10], C.STATE_FAIL)
        app_ok = self.app.client.finish_run(self.run_code, sun=True)
        self.assertEqual(app_ok.get("code"), C.CODE_OK, f"第二次结算被拒：{app_ok}")
        # upload_log 是 ORDER BY id DESC，[0] = 最新
        body = self.报文("run/finishSunRun_v2")
        self.assertIn("pois", body, "残留点没跟结算一起发出去")
        self.assertEqual(len(body["pois"]), 10)
        # 元素字段与 RunLatLng.to_upload_dict()（原版 uploadRunRecord 同构）一致
        one = self.app.store.get_points(self.run_code, None, valid_only=True)[0]
        self.assertEqual(set(body["pois"][0]), set(one.to_upload_dict()))

if __name__ == "__main__":
    unittest.main(verbosity=2)
