# -*- coding: utf-8 -*-
"""FUCK-RUN- 仿真层单元测试

这一层是「不改真机也能调」的关键：它按原 Xposed 模块的公式合成
加速度计 / 计步器样本，再折算成步频段与配速。用例锁定三件事：
  1. 数值范围必须落在 SchoolRule 允许区间内（否则服务端判失效）
  2. 步数必须单调不减（回归不可能倒退）
  3. 设备指纹与时间轴必须可复现（同种子同结果）
"""
import re
import unittest

from shandong_school_cracked.bus import DEFAULT_CONFIG
from shandong_school_cracked.simulator import (DEFAULT_HZ, GRAVITY, FuckRunSim, build_device_fingerprint,
                             random_device_id)


class 步频测试(unittest.TestCase):
    def test_步频始终在区间内(self):
        sim = FuckRunSim(min_cadence=172, max_cadence=182, seed=1)
        sim.start(start_ms=0, base_steps=0)
        取值 = [sim.cadence_at(t) for t in range(0, 1800, 7)]
        self.assertGreaterEqual(min(取值), 172.0)
        self.assertLessEqual(max(取值), 182.0)

    def test_热身段偏慢然后收敛(self):
        """前 30 秒热身：起步步频应低于稳态"""
        sim = FuckRunSim(min_cadence=172, max_cadence=182, seed=2)
        sim.start(start_ms=0, base_steps=0)
        起步 = sim.cadence_at(2.0)
        稳态 = sim.cadence_at(600.0)
        self.assertLess(起步, 稳态)

    def test_可改步频区间(self):
        sim = FuckRunSim(seed=3)
        sim.set_cadence_range(120, 130)
        sim.start(start_ms=0, base_steps=0)
        self.assertGreaterEqual(sim.cadence_at(60.0), 120.0)
        self.assertLessEqual(sim.cadence_at(60.0), 130.0)

    def test_固定步频模式(self):
        sim = FuckRunSim(seed=4)
        sim.set_cadence_range(100, 200)   # 区间放宽，避免漂移被夹到边界
        sim.start(start_ms=0, base_steps=0)
        sim.set_cadence(150.0)            # 运行中改步频（等价悬浮窗下发）
        self.assertGreater(sim.cadence_at(600.0), 140.0)
        self.assertLess(sim.cadence_at(600.0), 155.0)


class 传感器样本测试(unittest.TestCase):
    def setUp(self):
        self.sim = FuckRunSim(seed=5)
        self.sim.start(start_ms=1700000000000, base_steps=100)

    def test_加速度围绕重力(self):
        for t in (0.0, 5.0, 33.3, 100.0):
            s = self.sim.sample_at(t)
            self.assertGreater(s.z, GRAVITY - 6.0)
            self.assertLess(s.z, GRAVITY + 6.0)

    def test_步数单调不减(self):
        sim = FuckRunSim(seed=6, step_loss_rate=0.0)
        sim.start(start_ms=0, base_steps=0)
        步数 = [sim.steps_at(t) for t in range(0, 600, 3)]
        self.assertEqual(步数, sorted(步数))
        self.assertGreater(步数[-1], 步数[0])

    def test_基准步数被继承(self):
        """从 1000 步开始跑：第一段步频的 start_step 必须接着 1000"""
        sim = FuckRunSim(seed=7)
        sim.start(start_ms=0, base_steps=1000.0)
        段 = sim.step_timeline(duration_s=60, interval_s=3.0, start_ms=0)
        self.assertGreaterEqual(段[0][1], 1000)

    def test_时间轴长度正确(self):
        段 = self.sim.step_timeline(duration_s=300, interval_s=3.0, start_ms=1700000000000)
        self.assertAlmostEqual(len(段), 100, delta=1)
        # 时间轴用相对毫秒（相对开跑时刻），绝对时间由 build_steps 补回
        self.assertEqual(段[0][0], 0)
        self.assertLess(段[0][0], 段[-1][0])

    def test_样本可序列化(self):
        d = self.sim.sample_at(10.0).to_dict()
        for 字段 in ("t", "x", "y", "z", "stepsCum", "stepDetected"):
            self.assertIn(字段, d)

    def test_暂停期间步数不累计(self):
        sim = FuckRunSim(seed=8)
        sim.start(start_ms=0, base_steps=0)
        正常 = sim.step_timeline(duration_s=30, interval_s=3.0, start_ms=0)
        self.assertGreater(正常[-1][1], 0, "正常跑步应累计步数")
        sim.suspend()
        暂停 = sim.step_timeline(duration_s=30, interval_s=3.0, start_ms=0)
        self.assertTrue(暂停, "暂停期间时间轴仍要产出采样点")
        self.assertEqual(暂停[0][1], 暂停[-1][1], "暂停期间步数不动")
        sim.unsuspend()

    def test_丢包率影响样本(self):
        sim = FuckRunSim(seed=9, dropout_rate=0.5)
        sim.start(start_ms=0, base_steps=0)
        丢包数 = sum(1 for t in range(0, 300) if sim.sample_at(t).dropped)
        self.assertGreater(丢包数, 0)

    def test_频率含抖动但接近配置(self):
        sim = FuckRunSim(seed=10, hz=DEFAULT_HZ)
        sim.start(start_ms=0, base_steps=0)
        实测 = sim.freq_hz(12.0)
        # freq_hz 是「每秒步数」，不是每分钟步频：cadence / 60
        self.assertGreater(实测, 2.5)
        self.assertLess(实测, 3.5)


class 体检测试(unittest.TestCase):
    def test_自检三项通过(self):
        verdict = FuckRunSim(seed=11).self_check()["verdict"]
        self.assertTrue(verdict["cadenceInRange"])
        self.assertTrue(verdict["jitterReasonable"])
        self.assertTrue(verdict["amplitudeReasonable"])

    def test_自检给出量化区间(self):
        info = FuckRunSim(seed=12).self_check()
        self.assertEqual(len(info["cadenceRange"]), 2)
        self.assertLessEqual(info["cadenceRange"][0], info["cadenceRange"][1])


class 设备指纹测试(unittest.TestCase):
    def test_随机设备号格式(self):
        did = random_device_id(seed=1)
        self.assertRegex(did, re.compile(r"^[0-9a-f]{16}$"))
        self.assertEqual(did, random_device_id(seed=1), "同种子必须同结果")
        self.assertNotEqual(did, random_device_id(seed=2))

    def test_默认配置可生成指纹(self):
        指纹 = build_device_fingerprint(DEFAULT_CONFIG["device"])
        self.assertRegex(指纹["deviceId"], re.compile(r"^[0-9a-f]{16}$"))
        self.assertEqual(len(指纹["finger"]), 12, "12 个 Build 字段各取一位")

    def test_同机型同指纹(self):
        cfg = dict(DEFAULT_CONFIG["device"])
        self.assertEqual(build_device_fingerprint(cfg)["deviceId"],
                         build_device_fingerprint(dict(cfg))["deviceId"])

    def test_换机型换指纹(self):
        a = build_device_fingerprint({"model": "SM-A5460"})["deviceId"]
        b = build_device_fingerprint({"model": "Pixel 7 Pro Ultra"})["deviceId"]
        self.assertNotEqual(a, b)

    def test_空配置不报错(self):
        self.assertIn("deviceId", build_device_fingerprint(None))


if __name__ == "__main__":
    unittest.main(verbosity=2)
