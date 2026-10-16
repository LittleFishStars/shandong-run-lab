# -*- coding: utf-8 -*-
"""手动实走（摇杆 / 路点）单元测试

这一层是「自己控路径」的地基，锁定的都是容易被后续改动悄悄破坏的口径：
  1. 位置推进公式与 Android 版 Walker.java 一致（东 = lng+、北 = lat+）；
  2. 采样间隔、打卡半径、路点到达判定这些阈值不能漂；
  3. 干跑绝不落库、实跑必须落库；
  4. status(since) 的增量语义——界面「一笔一笔画线」全靠它。
"""
import math
import tempfile
import unittest
from pathlib import Path

from sdlab.protocol import EARTH_M_PER_DEG_LAT
from sdlab.store import RecordStore
from sdlab.walk import WalkSession, build_walk_targets
from sdlab.walker import (DEFAULT_SPEED_MPS, JOYSTICK_DEADZONE, MAX_LAPS,
                          SAMPLE_INTERVAL_S, WAYPOINT_REACH_M, Walker,
                          route_from_checkpoints)
from sdlab.simulator import FuckRunSim

# 上海人民广场附近的合成起点（坐标系是 GCJ-02，但这里面只做相对几何，不影响断言）
LAT0, LNG0 = 31.2304, 121.4737


def 走(w: Walker, 秒: float, 步长: float = 0.1) -> None:
    """按固定步长把 walker 推进指定秒数（虚拟时间，不 sleep）"""
    n = int(round(秒 / 步长))
    for _ in range(n):
        w.tick(步长)


class 摇杆推进测试(unittest.TestCase):
    def test_向东推等于经度增加(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_speed(3.0)
        w.start(LAT0, LNG0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 10.0)
        self.assertGreater(w.lng, LNG0)
        self.assertAlmostEqual(w.lat, LAT0, places=6)

    def test_向北推等于纬度增加(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_speed(3.0)
        w.start(LAT0, LNG0)
        w.set_joystick(0.0, 1.0, 1.0)
        走(w, 10.0)
        self.assertGreater(w.lat, LAT0)
        self.assertAlmostEqual(w.lng, LNG0, places=6)

    def test_距离与时间严格按速度累积(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_speed(2.0)
        w.start(LAT0, LNG0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 10.0)
        self.assertAlmostEqual(w.dist_m, 20.0, places=3)
        self.assertAlmostEqual(w.move_sec, 10.0, places=3)

    def test_推杆幅度线性缩速度(self):
        a = Walker(sim=FuckRunSim(seed=1))
        a.set_target_speed(3.0)
        a.start(LAT0, LNG0)
        a.set_joystick(1.0, 0.0, 1.0)
        走(a, 10.0)

        b = Walker(sim=FuckRunSim(seed=1))
        b.set_target_speed(3.0)
        b.start(LAT0, LNG0)
        b.set_joystick(1.0, 0.0, 0.5)
        走(b, 10.0)

        self.assertAlmostEqual(b.dist_m, a.dist_m / 2, places=3)

    def test_死区内不推进但也不报错(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.start(LAT0, LNG0)
        w.set_joystick(1.0, 0.0, JOYSTICK_DEADZONE / 2)
        走(w, 10.0)
        self.assertEqual(w.dist_m, 0.0)
        self.assertEqual(w.lat, LAT0)
        self.assertEqual(w.state().speed_mps, 0.0)

    def test_松杆后速度为0但位置保留(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_speed(2.0)
        w.start(LAT0, LNG0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 6.0)
        d = w.dist_m
        w.release_joystick()
        走(w, 6.0)
        self.assertAlmostEqual(w.dist_m, d, places=3)   # 站着不动距离不涨
        self.assertEqual(w.state().speed_mps, 0.0)

    def test_位置公式与Android侧一致(self):
        """lat += dy·v·dt/111320，lng += dx·v·dt/(111320·cos lat)"""
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_speed(1.0)
        w.start(LAT0, LNG0)
        w.set_joystick(0.0, 1.0, 1.0)
        走(w, 100.0)
        期望 = LAT0 + 100.0 / EARTH_M_PER_DEG_LAT
        self.assertAlmostEqual(w.lat, 期望, places=9)


class 采样与产出测试(unittest.TestCase):
    def test_每三秒落一个点(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_speed(2.0)
        w.start(LAT0, LNG0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 30.0)
        self.assertEqual(len(w.samples), int(30.0 / SAMPLE_INTERVAL_S))

    def test_采样间隔可配置(self):
        w = Walker(sim=FuckRunSim(seed=1), sample_s=1.0)
        w.set_target_speed(2.0)
        w.start(LAT0, LNG0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 10.0)
        self.assertEqual(len(w.samples), 10)

    def test_轨迹点字段齐全且序号递增(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_speed(2.0)
        w.start(LAT0, LNG0, start_ms=1700000000000)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 10.0)
        pts = w.drain_points()
        self.assertEqual(len(pts), 3)
        for i, p in enumerate(pts):
            d = p.to_upload_dict()
            self.assertIn("lat", d)
            self.assertIn("lng", d)
            self.assertIn("collectTime", d)
            self.assertGreaterEqual(d["lat"], -90)
            self.assertLessEqual(d["lat"], 90)
        序号 = [p.lat_lng_index for p in pts]
        self.assertEqual(序号, sorted(序号))
        self.assertEqual(len(set(序号)), len(序号))

    def test_起始序号在150到300之间(self):
        """与原版一致：随机起点，避免多条记录序号都一样"""
        w = Walker(sim=FuckRunSim(seed=7))
        w.set_target_speed(2.0)
        w.start(LAT0, LNG0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 5.0)
        pts = w.drain_points()
        self.assertTrue(pts)
        self.assertGreaterEqual(pts[0].lat_lng_index, 150)
        self.assertLessEqual(pts[0].lat_lng_index, 300)

    def test_取走后不再重复产出(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_speed(2.0)
        w.start(LAT0, LNG0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 10.0)
        self.assertEqual(len(w.drain_points()), 3)
        self.assertEqual(w.drain_points(), [])

    def test_采样点落在围栏内时偏移为0(self):
        poly = [[LAT0 - 0.01, LNG0 - 0.01], [LAT0 - 0.01, LNG0 + 0.01],
                [LAT0 + 0.01, LNG0 + 0.01], [LAT0 + 0.01, LNG0 - 0.01]]
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_polygon(poly)
        w.set_target_speed(2.0)
        w.start(LAT0, LNG0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 10.0)
        for p in w.drain_points():
            self.assertEqual(p.off_fence_dis_m, 0)


class 打卡判定测试(unittest.TestCase):
    def _带桩(self, 桩距_米: float) -> Walker:
        w = Walker(sim=FuckRunSim(seed=1))
        目标 = {"index": 0, "lat": LAT0, "lng": LNG0 + 桩距_米 / (
            EARTH_M_PER_DEG_LAT * math.cos(math.radians(LAT0))), "radius_m": 12.0}
        w.set_target_points([目标])
        w.start(LAT0, LNG0)          # 起点与桩同一纬度，向东推就会穿过它
        return w

    def test_进入十二米半径即命中(self):
        w = self._带桩(10.0)
        w.set_target_speed(3.0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 10.0)
        self.assertEqual(w.state().passed, 1)

    def test_超过半径不命中(self):
        w = self._带桩(200.0)
        w.set_target_speed(1.0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 10.0)          # 只走了 10 米，离桩还远
        self.assertEqual(w.state().passed, 0)

    def test_打卡半径可按桩覆盖(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_points([{"index": 0, "lat": LAT0, "lng": LNG0 + 0.0005,
                              "radius_m": 200.0}])
        w.set_target_speed(1.0)
        w.start(LAT0, LNG0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 2.0)
        self.assertEqual(w.state().passed, 1)

    def test_命中后记录命中位置(self):
        w = self._带桩(10.0)
        w.set_target_speed(3.0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 10.0)
        cp = w.passed_targets()[0]
        self.assertIn("hit_lat", cp)
        self.assertIn("hit_lng", cp)
        self.assertIn("hit_ms", cp)

    def test_重复经过不重复计数(self):
        w = self._带桩(10.0)
        w.set_target_speed(3.0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 6.0)
        w.set_joystick(-1.0, 0.0, 1.0)
        走(w, 12.0)
        w.set_joystick(1.0, 0.0, 1.0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 6.0)
        self.assertEqual(w.state().passed, 1)   # 回头再经过也只算一次

    def test_重开清空打卡状态(self):
        w = self._带桩(10.0)
        w.set_target_speed(3.0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 10.0)
        self.assertEqual(w.state().passed, 1)
        w.start(LAT0, LNG0)
        self.assertEqual(w.state().passed, 0)


class 路径跟随测试(unittest.TestCase):
    def test_自动沿路点走(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_speed(3.0)
        w.set_route([[LAT0 + 0.002, LNG0], [LAT0 + 0.002, LNG0 + 0.002]])
        w.set_auto_route(True)
        w.start(LAT0, LNG0)
        走(w, 120.0)
        self.assertGreater(w.route_index, 0)
        self.assertLessEqual(w.route_index, len(w.route) * MAX_LAPS + 1)

    def test_路点接近后自动切下一个(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_route([[LAT0 + 0.0001, LNG0], [LAT0, LNG0 + 0.01]])
        w.set_auto_route(True)
        w.start(LAT0, LNG0)
        走(w, 3.0)
        self.assertGreaterEqual(w.route_index, 1)

    def test_路点未到不切换(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_route([[LAT0 + 0.01, LNG0]])
        w.set_auto_route(True)
        w.start(LAT0, LNG0)
        走(w, 1.0)
        self.assertEqual(w.route_index, 0)
        # WAYPOINT_REACH_M 之前不该算到达
        self.assertGreater(_距离(w.lat, w.lng, LAT0 + 0.01, LNG0), WAYPOINT_REACH_M)

    def test_摇杆会关掉路径跟随(self):
        """手动推杆优先于自动路径，否则两者互相覆盖方向"""
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_route([[LAT0, LNG0 + 0.01]])
        w.set_auto_route(True)
        w.start(LAT0, LNG0)
        w.set_joystick(0.0, 1.0, 1.0)
        w.set_auto_route(False)
        走(w, 5.0)
        self.assertGreater(w.lat, LAT0)
        self.assertAlmostEqual(w.lng, LNG0, places=5)

    def test_走到绕满圈数就停(self):
        w = Walker(sim=FuckRunSim(seed=1), checkin_radius_m=1.0)
        w.set_target_speed(20.0)
        w.set_route([[LAT0 + 0.0002, LNG0]])
        w.set_auto_route(True)
        w.start(LAT0, LNG0)
        for _ in range(20000):
            if not w.running:
                break
            w.tick(0.5)
        self.assertFalse(w.running)
        self.assertEqual(w.arrived, "路径已走完")

    def test_空路径不崩(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_auto_route(True)
        w.start(LAT0, LNG0)
        st = w.tick(1.0)
        self.assertFalse(w.running)
        self.assertEqual(st.arrived, "路径已走完")

    def test_重复路点不卡死(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_speed(3.0)
        w.set_route([[LAT0, LNG0], [LAT0, LNG0], [LAT0 + 0.001, LNG0]])
        w.set_auto_route(True)
        w.start(LAT0, LNG0)
        走(w, 10.0)
        self.assertTrue(w.running)


class 距离与状态测试(unittest.TestCase):
    def test_达到目标距离后停(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_speed(2.0)
        w.set_target_distance(50.0)
        w.start(LAT0, LNG0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 60.0)
        self.assertFalse(w.running)
        self.assertIn("目标距离", w.arrived)
        self.assertGreaterEqual(w.dist_m, 50.0)

    def test_目标距离为零表示不限(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_speed(2.0)
        w.set_target_distance(0)
        w.start(LAT0, LNG0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 60.0)
        self.assertTrue(w.running)

    def test_summary口径与一键跑一致(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_speed(2.5)
        w.start(LAT0, LNG0)
        w.set_joystick(1.0, 0.0, 1.0)
        走(w, 100.0)
        s = w.summary()
        self.assertAlmostEqual(s["distance_m"], 250.0, places=1)
        self.assertAlmostEqual(s["pace_s_per_km"], 400.0, places=0)
        self.assertGreater(s["total_step"], 0)
        self.assertGreater(s["stride_m"], 0)

    def test_步数来自仿真层单调不减(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_speed(2.0)
        w.start(LAT0, LNG0)
        w.set_joystick(1.0, 0.0, 1.0)
        上一步 = 0
        for i in range(200):
            w.tick(0.5)
            if i % 10 == 0:
                步 = w.state().steps
                self.assertGreaterEqual(步, 上一步)
                上一步 = 步

    def test_速度上限可改(self):
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_speed(10.0)
        self.assertAlmostEqual(w.target_speed_mps, 10.0)
        w.set_target_speed(0.01)             # 下限保护
        self.assertGreaterEqual(w.target_speed_mps, 0.3)
    def test_默认速度落在校园跑合理区间(self):
        # 2.5 m/s = 9 km/h：正常慢跑。历史上是 2.78（顶满配速上沿），手感偏快
        self.assertGreater(DEFAULT_SPEED_MPS, 2.0)
        self.assertLess(DEFAULT_SPEED_MPS, 2.8)


class 路线规划测试(unittest.TestCase):
    def test_最近邻排序不折返(self):
        cps = [{"lat": LAT0 + 0.001, "lng": LNG0}, {"lat": LAT0, "lng": LNG0 + 0.003},
               {"lat": LAT0 - 0.001, "lng": LNG0}]
        route = route_from_checkpoints(LAT0, LNG0, cps, loop=True)
        self.assertEqual(len(route), 4)
        self.assertEqual(route[-1], [LAT0, LNG0])       # 闭环回到中心
        距离 = sum(_距离(route[i][0], route[i][1], route[i + 1][0], route[i + 1][1])
                   for i in range(len(route) - 1))
        self.assertGreater(距离, 0)

    def test_最近邻比原始顺序短(self):
        cps = [{"lat": LAT0 + 0.002, "lng": LNG0 - 0.002},
               {"lat": LAT0 + 0.002, "lng": LNG0 + 0.002},
               {"lat": LAT0 - 0.002, "lng": LNG0 - 0.002},
               {"lat": LAT0 - 0.002, "lng": LNG0 + 0.002}]
        原始 = [[c["lat"], c["lng"]] for c in cps] + [[LAT0, LNG0]]
        规划 = route_from_checkpoints(LAT0, LNG0, cps, loop=True)

        def 总长(r):
            return sum(_距离(r[i][0], r[i][1], r[i + 1][0], r[i + 1][1])
                       for i in range(len(r) - 1))
        self.assertLessEqual(总长(规划), 总长(原始) + 1e-6)

    def test_空打卡点返回空(self):
        self.assertEqual(route_from_checkpoints(LAT0, LNG0, [], loop=True), [])

    def test_不闭环时不回中心(self):
        cps = [{"lat": LAT0 + 0.001, "lng": LNG0}]
        route = route_from_checkpoints(LAT0, LNG0, cps, loop=False)
        self.assertEqual(len(route), 1)


class 会话落库测试(unittest.TestCase):
    def setUp(self):
        # 用临时文件而不是 :memory:——store 每次操作开一条新连接，
        # 而 :memory: 的库是连接私有的，第二条连接看不到建好的表。
        self.tmp = tempfile.TemporaryDirectory(prefix="sdlab-walk-")
        self.store = RecordStore(Path(self.tmp.name) / "walk.db")
        self.store.create_run("DRY01", source="walk")
        self.store.create_run("REAL01", source="walk")

    def tearDown(self):
        # RecordStore 不持长连接（每次操作开一条），无需 close，只清理临时目录
        self.tmp.cleanup()

    def _会话(self, mode: str, run_code: str) -> WalkSession:
        s = WalkSession(cfg={"walk": {"speed": 50.0}}, store=self.store)
        s.start(mode, lat=LAT0, lng=LNG0, target_m=0.0, speed_mps=3.0,
                targets=build_walk_targets([{"index": 0, "lat": LAT0, "lng": LNG0 + 0.001,
                                             "radius_m": 12.0}]),
                run_code=run_code, speed=50.0)
        return s

    def test_干跑不落库(self):
        s = self._会话("dry", "")
        s.joystick(1.0, 0.0, 1.0)
        for _ in range(200):
            s._drain(s.walker)
            s.walker.tick(0.1)
            s._drain(s.walker)
            if len(s._points) >= 5:
                break
        self.assertGreater(len(s._points), 0)
        self.assertEqual(s._stored, 0)
        self.assertEqual(self.store.count_points("DRY01"), 0)
        s.stop(emit=False)

    def test_实跑实时落库(self):
        s = self._会话("real", "REAL01")
        s.joystick(1.0, 0.0, 1.0)
        for _ in range(400):
            s.walker.tick(0.1)
            s._drain(s.walker)
            if self.store.count_points("REAL01") >= 5:
                break
        self.assertGreaterEqual(self.store.count_points("REAL01"), 5)
        self.assertEqual(s.pending, 0)
        s.stop(emit=False)

    def test_实跑缺run_code直接拒绝(self):
        s = WalkSession(cfg={}, store=self.store)
        r = s.start("real", lat=LAT0, lng=LNG0, run_code="")
        self.assertEqual(r["code"], -1)

    def test_增量拉点不重不漏(self):
        s = self._会话("real", "REAL01")
        s.joystick(1.0, 0.0, 1.0)
        seen = []
        for _ in range(400):
            s.walker.tick(0.1)
            s._drain(s.walker)
            d = s.points_since(len(seen))
            seen.extend(d["points"])
            if len(seen) >= 5:
                break
        self.assertEqual(len(seen), s.status()["points"])
        idx = [p["index"] for p in seen]
        self.assertEqual(len(set(idx)), len(idx))
        s.stop(emit=False)

    def test_status含状态与目标(self):
        s = self._会话("dry", "")
        s.walker.tick(0.5)
        st = s.status()
        for k in ("running", "mode", "state", "points", "stored", "targets", "percent"):
            self.assertIn(k, st)
        self.assertEqual(st["mode"], "dry")
        self.assertEqual(st["state"]["targets"], 1)
        s.stop(emit=False)

    def test_摇杆在未开始时被拒(self):
        s = WalkSession(cfg={}, store=self.store)
        self.assertEqual(s.joystick(1.0, 0.0, 1.0)["code"], -1)

    def test_推杆自动关路径跟随(self):
        s = self._会话("dry", "")
        s.set_route([[LAT0 + 0.01, LNG0]], auto=True)
        self.assertTrue(s.walker.auto_route)
        s.joystick(1.0, 0.0, 1.0)
        self.assertFalse(s.walker.auto_route)
        s.stop(emit=False)

    def test_stop后线程退出(self):
        s = self._会话("dry", "")
        s.joystick(1.0, 0.0, 1.0)
        s.stop(emit=False)
        self.assertFalse(s.running())

    def test_reset清空一切(self):
        s = self._会话("dry", "")
        s.joystick(1.0, 0.0, 1.0)
        s.walker.tick(5.0)
        s._drain(s.walker)
        s.reset()
        self.assertIsNone(s.walker)
        self.assertEqual(s.run_code, "")
        self.assertEqual(s.points_since(0)["points"], [])

    def test_目标距离决定进度百分比(self):
        s = WalkSession(cfg={}, store=self.store)
        s.start("dry", lat=LAT0, lng=LNG0, target_m=100.0, speed_mps=5.0, speed=1.0)
        s.joystick(1.0, 0.0, 1.0)
        s.walker.tick(10.0)                 # 50 米
        self.assertAlmostEqual(s.progress_percent(), 50, delta=2)
        s.stop(emit=False)


def _推进(s: WalkSession, 秒: float, 步长: float = 0.1) -> None:
    """手动推进一个会话（虚拟时间），每次 tick 后即时 drain（等价于后台线程的一轮）"""
    for _ in range(int(round(秒 / 步长))):
        if s.walker is None:
            break
        s.walker.tick(步长)
        s._drain(s.walker)


def _冻结后台线程(s: WalkSession) -> None:
    """停掉后台推进线程，让测试里的 tick 完全决定时间轴（否则线程会抢着推进）"""
    s._stop_flag.set()
    t = s._thread
    if t and t.is_alive():
        t.join(timeout=2.0)
    s._thread = None


class 实时打卡与分段测试(unittest.TestCase):
    """实跑必须边跑边落库：打卡命中、步频段、配速段、收尾统计都不能等到上传才算"""

    def setUp(self):
        self.tmp = tempfile.TemporaryDirectory(prefix="sdlab-walk-rt-")
        self.store = RecordStore(Path(self.tmp.name) / "rt.db")
        self.store.create_run("REAL01", source="walk")
        self.store.create_run("DRY01", source="walk")

    def tearDown(self):
        self.tmp.cleanup()

    def _会话(self, mode: str, run_code: str, *, lng_off: float = 0.0002,
             speed_mps: float = 3.0, 登记打卡: bool = True) -> WalkSession:
        # 打卡桩放在起点东侧约 19 米，推杆向东几秒就能穿过 12 米半径
        cps = [{"index": 0, "lat": LAT0, "lng": LNG0 + lng_off, "radius_m": 12.0}]
        if 登记打卡:
            self.store.add_checkpoints(run_code, [{"lat": LAT0, "lng": LNG0 + lng_off,
                                                   "radius_m": 12.0}])
        s = WalkSession(cfg={}, store=self.store)
        s.start(mode, lat=LAT0, lng=LNG0, target_m=0.0, speed_mps=speed_mps,
                targets=build_walk_targets(cps), run_code=run_code, speed=1.0)
        _冻结后台线程(s)
        s.joystick(1.0, 0.0, 1.0)
        return s

    # ── 打卡 ─────────────────────────────────
    def test_实跑命中打卡点实时写库(self):
        s = self._会话("real", "REAL01")
        _推进(s, 10.0)
        self.assertEqual(s.hits_total, 1)
        cps = self.store.get_checkpoints("REAL01")
        self.assertEqual(len(cps), 1)
        self.assertEqual(int(cps[0]["passed"]), 1)
        self.assertGreater(int(cps[0]["hit_ms"]), 0)
        self.assertNotEqual(float(cps[0]["hit_lat"] or 0), 0.0)
        self.assertEqual(self.store.checkpoints_progress("REAL01"), (1, 1))
        s.stop(emit=False)

    def test_干跑命中打卡点不写库(self):
        s = self._会话("dry", "DRY01")
        _推进(s, 10.0)
        self.assertEqual(s.hits_total, 1)
        self.assertEqual(int(self.store.get_checkpoints("DRY01")[0]["passed"]), 0)
        s.stop(emit=False)

    def test_同一打卡点重复经过只计一次(self):
        s = self._会话("real", "REAL01")
        _推进(s, 6.0)
        n = s.hits_total
        # 反向推回去再推回来，来回穿过两次
        s.joystick(-1.0, 0.0, 1.0)
        _推进(s, 12.0)
        s.joystick(1.0, 0.0, 1.0)
        _推进(s, 12.0)
        self.assertEqual(n, 1)
        self.assertEqual(s.hits_total, 1)
        s.stop(emit=False)

    def test_未命中时进度为零(self):
        s = self._会话("real", "REAL01", lng_off=0.01)   # 桩在 950 米外
        _推进(s, 3.0)
        self.assertEqual(s.hits_total, 0)
        self.assertEqual(self.store.checkpoints_progress("REAL01"), (0, 1))
        s.stop(emit=False)

    def test_干跑不碰打卡表(self):
        s = self._会话("dry", "DRY01", 登记打卡=False)
        _推进(s, 5.0)
        self.assertEqual(self.store.get_checkpoints("DRY01"), [])
        s.stop(emit=False)

    # ── 分段 ─────────────────────────────────
    def test_实跑切出步频段并落库(self):
        s = self._会话("real", "REAL01")
        _推进(s, 10.0)
        self.assertGreaterEqual(s.steps_total, 2)
        rows = self.store.get_steps("REAL01", only_pending=True)
        self.assertEqual(len(rows), s.steps_total)
        for seg in rows:
            self.assertGreater(seg.time, 0)
            self.assertGreaterEqual(seg.end_time, seg.start_time)
        s.stop(emit=False)

    def test_步频段约三秒一段(self):
        s = self._会话("real", "REAL01", speed_mps=3.0)
        _推进(s, 12.0)
        s.stop(emit=False)
        rows = self.store.get_steps("REAL01", only_pending=True)
        self.assertGreaterEqual(len(rows), 3)
        # 每段 3 秒（尾段可能不足，不参与断言）
        for seg in rows[:-1]:
            self.assertAlmostEqual(seg.time, 3000, delta=400)

    def test_干跑分段不落库(self):
        s = self._会话("dry", "DRY01")
        _推进(s, 10.0)
        # 干跑照样切段（内存里能看到），但不能写进 steps/paces 表
        self.assertGreaterEqual(len(s._step_segments), 1)
        self.assertEqual(s.steps_total, 0)
        self.assertEqual(s.paces_total, 0)
        self.assertEqual(self.store.get_steps("DRY01", only_pending=True), [])
        self.assertEqual(self.store.get_paces("DRY01", only_pending=True), [])
        s.stop(emit=False)


    def test_实跑切出配速段(self):
        s = self._会话("real", "REAL01", speed_mps=20.0)
        _推进(s, 55.0)                       # 1100 米 > 1000 米，至少切一段
        self.assertGreaterEqual(s.paces_total, 1)
        rows = self.store.get_paces("REAL01", only_pending=True)
        self.assertGreaterEqual(len(rows), 1)
        self.assertGreater(rows[0].time, 0)
        self.assertGreaterEqual(rows[0].end_distance, 1000)
        s.stop(emit=False)

    def test_配速段距离累计一致(self):
        s = self._会话("real", "REAL01", speed_mps=20.0)
        _推进(s, 110.0)                      # 2200 米，应切出两段以上
        s.stop(emit=False)
        rows = self.store.get_paces("REAL01", only_pending=True)
        self.assertGreaterEqual(len(rows), 2)
        # 段与段首尾相接，且最后一段覆盖到总距离
        for a, b in zip(rows, rows[1:]):
            self.assertEqual(a.end_distance, b.start_distance)
        self.assertAlmostEqual(rows[-1].end_distance, rows[-1].distance, delta=2)

    def test_收尾补切尾段(self):
        s = self._会话("real", "REAL01")
        _推进(s, 4.0)                        # 4 秒：不够 3 秒的整段也该在停止时补上
        s.stop(emit=False)
        rows = self.store.get_steps("REAL01", only_pending=True)
        self.assertGreaterEqual(len(rows), 1)
        self.assertGreater(rows[-1].step, 0)
        self.assertEqual(len(rows), s.steps_total)

    # ── 状态与收尾 ───────────────────────────
    def test_status暴露落库计数(self):
        s = self._会话("real", "REAL01")
        _推进(s, 10.0)
        st = s.status()
        for k in ("hits", "steps", "paces", "segments"):
            self.assertIn(k, st)
        self.assertEqual(st["hits"], s.hits_total)
        self.assertEqual(st["segments"]["steps"], len(s._step_segments))
        self.assertEqual(st["segments"]["paces"], len(s._pace_segments))
        s.stop(emit=False)

    def test_分段在增量拉点通道外不影响轨迹点(self):
        s = self._会话("real", "REAL01")
        _推进(s, 10.0)
        d = s.points_since(0)
        self.assertEqual(len(d["points"]), s.status()["points"])
        # 分段走独立通道：段的首尾必须相接，不能因为切段而丢点或重复计点
        rows = self.store.get_steps("REAL01", only_pending=True)
        self.assertEqual(len(rows), s.status()["steps"])
        for a, b in zip(rows, rows[1:]):
            self.assertEqual(a.end_time, b.start_time)
            self.assertEqual(a.end_step, b.start_step)
        self.assertEqual(rows[0].start_step, 0)
        s.stop(emit=False)

    def test_实跑收尾写回距离与时长(self):
        s = self._会话("real", "REAL01")
        _推进(s, 10.0)
        s.stop(emit=False)
        run = self.store.get_run("REAL01")
        self.assertEqual(run["source"], "walk")
        self.assertGreater(float(run["distance_m"]), 0)
        self.assertGreater(int(run["duration_s"]), 0)
        self.assertGreater(int(run["total_step"]), 0)
        self.assertIn("valid", run)

    def test_干跑收尾不写runs(self):
        s = self._会话("dry", "DRY01")
        _推进(s, 10.0)
        s.stop(emit=False)
        self.assertEqual(self.store.get_run("DRY01")["source"], "walk")
        # create_run 时就是 0；干跑不写回，距离仍为 0
        self.assertFalse(float(self.store.get_run("DRY01")["distance_m"] or 0))

    def test_收尾后可以原地上传打卡记录(self):
        s = self._会话("real", "REAL01")
        _推进(s, 10.0)
        s.stop(emit=False)
        done, total = self.store.checkpoints_progress("REAL01")
        self.assertEqual((done, total), (1, 1))
        pending = [c for c in self.store.get_checkpoints("REAL01") if int(c["passed"]) == 1]
        self.assertEqual(len(pending), 1)
        self.assertGreater(int(pending[0]["hit_ms"]), 0)


class 目标装配测试(unittest.TestCase):
    def test_缺坐标的打卡点被跳过(self):
        out = build_walk_targets([{"index": 0, "lat": None, "lng": None},
                                  {"index": 1, "lat": 1.0, "lng": 2.0}])
        self.assertEqual(len(out), 1)
        self.assertEqual(out[0]["index"], 1)

    def test_默认半径补齐(self):
        out = build_walk_targets([{"index": 0, "lat": 1.0, "lng": 2.0}])
        self.assertEqual(out[0]["radius_m"], 12.0)

    def test_打卡状态被重置(self):
        out = build_walk_targets([{"index": 0, "lat": 1.0, "lng": 2.0, "passed": 1}])
        # 装配层保留库里的打卡状态（历史记录），清空是 Walker.start() 的职责
        self.assertEqual(out[0]["passed"], 1)
        w = Walker(sim=FuckRunSim(seed=1))
        w.set_target_points(out)
        w.start(1.0, 2.0)
        self.assertEqual(w.state().passed, 0)


def _距离(lat1: float, lng1: float, lat2: float, lng2: float) -> float:
    r = 6371008.8
    p1, p2 = math.radians(lat1), math.radians(lat2)
    dl = math.radians(lat2 - lat1)
    dg = math.radians(lng2 - lng1)
    a = math.sin(dl / 2) ** 2 + math.cos(p1) * math.cos(p2) * math.sin(dg / 2) ** 2
    return 2 * r * math.asin(min(1.0, math.sqrt(a)))


if __name__ == "__main__":
    unittest.main()
