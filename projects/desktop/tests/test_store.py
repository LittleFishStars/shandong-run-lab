# -*- coding: utf-8 -*-
"""本地记录层（SQLite）单元测试

记录层是「断点续传」的物质基础：跑步中的每个轨迹点都有状态位
（1 待传 / 2 上传中 / 4 失败 / 8 成功），崩溃或断网后靠状态位续传。
"""
import json
import tempfile
import unittest
from pathlib import Path

from shandong_school_cracked import constants as C
from shandong_school_cracked.protocol import IntervalPace, IntervalStep, RunLatLng
from shandong_school_cracked.store import RecordStore


def 造点(i, state=C.STATE_INIT):
    return RunLatLng(lat=36.6615 + i * 1e-5, lng=117.0265, lat_lng_index=i,
                     run_time=i * 3, collect_time=1700000000000 + i * 3000,
                     create_time=1700000000000 + i * 3000, state=state)


class 记录层测试(unittest.TestCase):
    def setUp(self):
        self.tmp = tempfile.TemporaryDirectory(prefix="shandong-school_cracked-store-")
        self.db = Path(self.tmp.name) / "records.db"
        self.store = RecordStore(self.db)

    def tearDown(self):
        self.tmp.cleanup()

    # ── 跑步主记录 ──
    def test_建跑步与读取(self):
        self.store.create_run("RUN001", sport_type=C.SPORT_TYPE_SUN,
                              fence_code="F1", school_code="S1", start_ms=1700000000000)
        run = self.store.get_run("RUN001")
        self.assertEqual(run["run_code"], "RUN001")
        self.assertEqual(run["sport_type"], 1)
        self.assertEqual(run["uploaded"], 0)

    def test_结算写入并标记已上传(self):
        self.store.create_run("RUN002")
        self.store.finish_run("RUN002", end_ms=1700000720000, duration_s=720,
                              distance_m=2000.0, total_step=2353, pace_s_per_km=360.0,
                              status=1, valid={"isValid": True}, rule={"minPace": 120},
                              finish={"code": 0})
        self.store.mark_uploaded("RUN002")
        run = self.store.get_run("RUN002")
        self.assertEqual(run["duration_s"], 720)
        self.assertEqual(run["uploaded"], 1)
        self.assertEqual(run["valid"]["isValid"], True)
        self.assertEqual(run["finish"]["code"], 0)

    def test_未完成列表与删除(self):
        self.store.create_run("RUN003")
        self.store.finish_run("RUN003", uploaded=1, distance_m=1000)
        self.assertIn("RUN003", [r["run_code"] for r in self.store.list_runs(10)])
        self.store.delete_run("RUN003")
        self.assertIsNone(self.store.get_run("RUN003"))
        self.assertNotIn("RUN003", [r["run_code"] for r in self.store.list_runs(10)])

    # ── 轨迹点与状态位 ──
    def test_批量写点并带序号(self):
        self.store.create_run("RUN010")
        n = self.store.add_points("RUN010", [造点(i) for i in range(10)])
        self.assertEqual(n, 10)
        self.assertEqual(self.store.count_points("RUN010"), 10)
        self.assertEqual(self.store.next_point_index("RUN010"), 10)
        pts = self.store.get_points("RUN010")
        self.assertEqual([p.lat_lng_index for p in pts], list(range(10)))

    def test_重复写点不会翻倍(self):
        self.store.create_run("RUN011")
        self.store.add_points("RUN011", [造点(i) for i in range(5)])
        self.store.add_points("RUN011", [造点(i) for i in range(5)])
        self.assertEqual(self.store.count_points("RUN011"), 5)

    def test_状态位筛选与计数(self):
        self.store.create_run("RUN012")
        self.store.add_points("RUN012", [造点(i) for i in range(10)])
        self.store.set_point_states("RUN012", [0, 1, 2], C.STATE_SUCC)
        self.store.set_point_states("RUN012", [3], C.STATE_FAIL)
        self.assertEqual(self.store.count_points("RUN012", C.STATE_SUCC), 3)
        self.assertEqual(self.store.count_points("RUN012", C.STATE_FAIL), 1)
        self.assertEqual(self.store.count_points("RUN012", C.STATE_INIT), 6)
        self.assertEqual(len(self.store.get_points("RUN012", [C.STATE_FAIL])), 1)

    def test_上传中状态也算未完成(self):
        """上传中断电会留下 STATE_UPLOADING，续传必须把它捞回来"""
        self.store.create_run("RUN013")
        self.store.add_points("RUN013", [造点(i) for i in range(4)])
        self.store.set_point_states("RUN013", [0], C.STATE_UPLOADING)
        待补 = self.store.get_points("RUN013", [C.STATE_INIT, C.STATE_FAIL, C.STATE_UPLOADING])
        self.assertEqual(len(待补), 4)

    # ── 步频 / 配速 ──
    def test_步频段落库与标记(self):
        self.store.create_run("RUN020")
        steps = [IntervalStep(start_step=i * 9, end_step=(i + 1) * 9,
                              start_time=1700000000000 + i * 3000,
                              end_time=1700000000000 + (i + 1) * 3000,
                              step=9, time=3000, step_index=i) for i in range(4)]
        self.assertEqual(self.store.add_steps("RUN020", steps), 4)
        self.assertEqual(len(self.store.get_steps("RUN020", only_pending=True)), 4)
        self.store.mark_steps_uploaded("RUN020")          # 标记该跑步的全部步频段
        self.assertEqual(len(self.store.get_steps("RUN020", only_pending=True)), 0)
        self.assertEqual(len(self.store.get_steps("RUN020", only_pending=False)), 4)

    def test_配速段落库与标记(self):
        self.store.create_run("RUN021")
        paces = [IntervalPace(distance=100, start_distance=i * 100,
                              end_distance=(i + 1) * 100, step_count=118,
                              start_step_count=i * 118, end_step_count=(i + 1) * 118,
                              time=36, start_time=1700000000000 + i * 36000,
                              end_time=1700000000000 + (i + 1) * 36000,
                              pace_index=i) for i in range(3)]
        self.assertEqual(self.store.add_paces("RUN021", paces), 3)
        self.assertEqual(len(self.store.get_paces("RUN021", only_pending=True)), 3)
        self.store.mark_paces_uploaded("RUN021")
        self.assertEqual(len(self.store.get_paces("RUN021", only_pending=True)), 0)

    # ── 打卡点 ──
    def test_打卡点进度(self):
        self.store.create_run("RUN030")
        self.store.add_checkpoints("RUN030", [
            {"lat": 36.6615, "lng": 117.0265, "radius_m": 12.0},
            {"lat": 36.6635, "lng": 117.0265, "radius_m": 12.0},
            {"lat": 36.6615, "lng": 117.0285, "radius_m": 12.0},
        ])
        cps = self.store.get_checkpoints("RUN030")
        self.assertEqual([c["index"] for c in cps], [0, 1, 2])
        self.assertEqual(self.store.checkpoints_progress("RUN030"), (0, 3))
        self.store.mark_checkpoint_hit("RUN030", 1, 36.66355, 117.02651, 1700000060000)
        self.assertEqual(self.store.checkpoints_progress("RUN030"), (1, 3))
        命中 = [c for c in self.store.get_checkpoints("RUN030") if c["passed"]]
        self.assertEqual(len(命中), 1)

    # ── 日志与 KV ──
    def test_上传日志(self):
        self.store.log_upload("RUN040", "run/uploadRunRecord", True, "成功",
                              {"dis": 2000}, {"code": 0})
        self.store.log_upload("RUN040", "run/finishSunRun_v2", False, "超时", None, None)
        日志 = self.store.get_upload_log("RUN040", 10)
        self.assertEqual(len(日志), 2)
        self.assertFalse(日志[0]["ok"])
        self.assertTrue(日志[1]["ok"])

    def test_接口日志(self):
        self.store.log_api("POST", "run/uploadPaceRecord", "8.7.7", "run-front", True,
                           '{"runRecordCode":"RUN041"}', '{"code":0}', 0, 42)
        日志 = self.store.get_api_log(10)
        self.assertGreaterEqual(len(日志), 1)

    def test_键值存储(self):
        self.assertIsNone(self.store.kv_get("missing"))
        self.store.kv_set("session", {"token": "T", "phone": "13800138000"})
        self.assertEqual(self.store.kv_get("session")["token"], "T")
        self.store.kv_delete("session")
        self.assertIsNone(self.store.kv_get("session"))

    def test_统计信息(self):
        self.store.create_run("RUN050")
        self.store.add_points("RUN050", [造点(i) for i in range(6)])
        self.store.set_point_states("RUN050", [0, 1], C.STATE_SUCC)
        stats = self.store.stats()
        self.assertEqual(stats["runs"], 1)
        self.assertEqual(stats["distance_m"], 0.0)
        self.assertEqual(self.store.count_points("RUN050"), 6)
        self.assertEqual(self.store.count_points("RUN050", C.STATE_SUCC), 2)
        self.assertEqual(self.store.count_points("RUN050", C.STATE_INIT), 4)

    def test_重启后数据还在(self):
        self.store.create_run("RUN060")
        self.store.add_points("RUN060", [造点(i) for i in range(3)])
        新连接 = RecordStore(self.db)
        self.assertEqual(新连接.count_points("RUN060"), 3)
        self.assertEqual((新连接.get_run("RUN060") or {}).get("run_code"), "RUN060")

    def test_坐标精度可往返(self):
        self.store.create_run("RUN070")
        self.store.add_points("RUN070", [造点(0)])
        p = self.store.get_points("RUN070")[0]
        self.assertAlmostEqual(p.lat, 36.6615, places=7)
        self.assertTrue(json.dumps(p.to_upload_dict(), ensure_ascii=False))


if __name__ == "__main__":
    unittest.main(verbosity=2)
