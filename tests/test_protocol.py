# -*- coding: utf-8 -*-
"""协议与业务规则层单元测试

分成三块：
  1. 几何：haversine / 点在多边形内 / 轨迹生成器（这是打卡能否命中的物理基础）
  2. 报文构造：轨迹点、步频段、配速段、步幅段、打卡点
  3. 有效性判定：复刻客户端 DataComponent.W0 的判定顺序与失效码
"""
import math
import unittest

from sdlab import constants as C
from sdlab.protocol import (SNAP_MARGIN_M, RunLatLng, RuleSet, TrackGenerator,
                            build_pace_list, build_step_list, build_stride_list,
                            build_target_points, build_upload_pois,
                            closest_point_on_polygon, evaluate_run, haversine,
                            point_in_polygon, polygon_centroid, snap_into_polygon)

中心 = (36.6615, 117.0265)


def 造点(lat, lng, i=0, 基准=1700000000000):
    return RunLatLng(lat=lat, lng=lng, lat_lng_index=i,
                     run_time=i * 3, collect_time=基准 + i * 3000)


class 几何测试(unittest.TestCase):
    def test_纬度一米级精度(self):
        """同经度上 0.01 度纬度 ≈ 1111 米"""
        d = haversine(30.0, 117.0, 30.01, 117.0)
        self.assertAlmostEqual(d, 1111.9, delta=5.0)

    def test_同点距离为零(self):
        self.assertAlmostEqual(haversine(*中心, *中心), 0.0, places=6)

    def test_点在多边形内(self):
        方形 = [(36.66, 117.02), (36.66, 117.03), (36.67, 117.03), (36.67, 117.02)]
        self.assertTrue(point_in_polygon(36.665, 117.025, 方形))
        self.assertFalse(point_in_polygon(36.680, 117.025, 方形))

    def test_多边形重心落在形内(self):
        lat, lng = polygon_centroid([(36.66, 117.02), (36.66, 117.03), (36.67, 117.03)])
        self.assertTrue(36.66 < lat < 36.67)
        self.assertTrue(117.02 < lng < 117.03)

    def test_围栏外点吸附到围栏内(self):
        """选到围栏外的起点要能自动落到围栏里，且贴着边界，而不是被吸到围栏中心"""
        方形 = [(36.66, 117.02), (36.66, 117.03), (36.67, 117.03), (36.67, 117.02)]
        lat, lng, moved = snap_into_polygon(36.680, 117.025, 方形)
        self.assertTrue(moved)
        self.assertTrue(point_in_polygon(lat, lng, 方形))
        # 吸附点与边界的距离正好压在 margin 上（不往围栏内部跑）
        self.assertAlmostEqual(haversine(lat, lng, 36.67, 117.025), SNAP_MARGIN_M, delta=1.0)

    def test_围栏内点原样保留(self):
        方形 = [(36.66, 117.02), (36.66, 117.03), (36.67, 117.03), (36.67, 117.02)]
        lat, lng, moved = snap_into_polygon(36.665, 117.025, 方形)
        self.assertFalse(moved)
        self.assertEqual((lat, lng), (36.665, 117.025))
        # 贴着边界（离边界不足 margin）也要往里挪一点：GPS 抖一下就会掉到围栏外
        lat2, lng2, moved2 = snap_into_polygon(36.66995, 117.025, 方形)
        self.assertTrue(moved2)
        self.assertTrue(point_in_polygon(lat2, lng2, 方形))

    def test_没有围栏时不改点(self):
        """还没拉到电子围栏时没有依据去改用户选的点"""
        self.assertEqual(snap_into_polygon(36.680, 117.025, []), (36.680, 117.025, False))

    def test_最近边界点(self):
        方形 = [(36.66, 117.02), (36.66, 117.03), (36.67, 117.03), (36.67, 117.02)]
        lat, lng, d = closest_point_on_polygon(36.680, 117.025, 方形)
        self.assertAlmostEqual(lat, 36.67, places=6)
        self.assertAlmostEqual(lng, 117.025, places=6)
        # 这里用平面投影（EARTH_M_PER_DEG_LAT=111320）算距离，与球面 haversine 差 0.1% 左右
        self.assertAlmostEqual(d, haversine(36.680, 117.025, 36.67, 117.025), delta=2.0)


class 轨迹生成测试(unittest.TestCase):
    def test_椭圆环线距离准(self):
        """目标 2000 米，实测累计距离误差要小于 3%"""
        gen = TrackGenerator(中心[0], 中心[1], target_distance_m=2000,
                             target_seconds=720, fence_radius_m=300, seed=7)
        pts = gen.generate_track(start_ms=1700000000000)
        实测 = sum(haversine(pts[i - 1].lat, pts[i - 1].lng, pts[i].lat, pts[i].lng)
                   for i in range(1, len(pts)))
        self.assertLess(abs(实测 - 2000) / 2000, 0.03, f"实测 {实测:.1f} 米")

    def test_采样间隔稳定(self):
        gen = TrackGenerator(中心[0], 中心[1], target_distance_m=2000,
                             target_seconds=720, sample_s=3.0, seed=1)
        pts = gen.generate_track(start_ms=1700000000000)
        # 720 秒 / 3 秒 ≈ 240 段，首尾闭合要多一个点
        self.assertGreaterEqual(len(pts), 240)
        for i, p in enumerate(pts):
            self.assertEqual(p.lat_lng_index, i)
            self.assertEqual(p.run_time, i * 3)

    def test_必经点全部命中(self):
        """三个打卡点都必须落在 12 米打卡半径内，否则服务端判无效"""
        途经 = [(中心[0] + 0.002, 中心[1]), (中心[0], 中心[1] + 0.002),
                (中心[0] - 0.002, 中心[1] - 0.001)]
        gen = TrackGenerator(中心[0], 中心[1], target_distance_m=2000,
                             target_seconds=720, fence_radius_m=300,
                             waypoints=途经, seed=3)
        pts = gen.generate_track(start_ms=1700000000000)
        for k, (wlat, wlng) in enumerate(途经):
            最近 = min(haversine(p.lat, p.lng, wlat, wlng) for p in pts)
            self.assertLess(最近, C.CHECKPOINT_HIT_RADIUS_M,
                            f"第 {k} 个打卡点最近只到 {最近:.2f} 米")

    def test_必经点路线长度可预估(self):
        途经 = [(中心[0] + 0.002, 中心[1]), (中心[0], 中心[1] + 0.002)]
        长度 = TrackGenerator.route_length(中心[0], 中心[1], 途经)
        # 中心 → wp0 → wp1 → 中心，约 220 + 310 + 250 米
        self.assertGreater(长度, 500)
        self.assertLess(长度, 1400)

    def test_无必经点时路线长度为0(self):
        self.assertEqual(TrackGenerator.route_length(中心[0], 中心[1], []), 0.0)

    def test_种子可复现(self):
        a = TrackGenerator(中心[0], 中心[1], seed=11).generate_track(start_ms=0)
        b = TrackGenerator(中心[0], 中心[1], seed=11).generate_track(start_ms=0)
        self.assertEqual([(p.lat, p.lng) for p in a], [(p.lat, p.lng) for p in b])


class 报文构造测试(unittest.TestCase):
    def setUp(self):
        gen = TrackGenerator(中心[0], 中心[1], target_distance_m=1000,
                             target_seconds=360, seed=5)
        self.t0 = 1700000000000
        self.pts = gen.generate_track(start_ms=self.t0)
        self.gen = gen

    def test_轨迹点上报字段(self):
        pois = build_upload_pois(self.pts)
        self.assertEqual(len(pois), len(self.pts))
        第一 = pois[0]
        for 字段 in ("index", "lat", "lng", "runTime", "collectTime", "state"):
            self.assertIn(字段, 第一)
        # 原版 RunLatLng 的 fastjson 序列化：accuracy/satellites/createTime 都是默认序列化的
        for 字段 in ("accuracy", "satellites", "createTime", "offFenceDisM"):
            self.assertIn(字段, 第一)
        # 带 @JSONField(serialize=false) 的才不上传
        for 字段 in ("speed", "isValid", "isUploaded", "runCode"):
            self.assertNotIn(字段, 第一)

    def test_步频段字段与序号(self):
        # 原版按 stepInterval（默认 20 秒）切段：时间轴用相对毫秒，段的时间字段是跑步内秒
        timeline = [(0, 0), (10000, 30), (20000, 60), (40000, 120)]
        steps = build_step_list(self.gen.build_steps(timeline, start_ms=self.t0))
        # 20 秒一刀：t=20s 封第 1 段、t=40s 封第 2 段
        self.assertEqual(len(steps), 2)
        for i, s in enumerate(steps):
            self.assertEqual(s["index"], i)
        self.assertEqual(steps[0]["startTime"], 0)
        self.assertEqual(steps[0]["endTime"], 20)
        self.assertEqual(steps[0]["time"], 20)
        self.assertEqual(steps[1]["startTime"], 20)
        self.assertEqual(steps[1]["startStep"], steps[0]["endStep"])
        self.assertLessEqual(steps[0]["startStep"], steps[0]["endStep"])

    def test_步幅段按米数切且每次只发一段(self):
        from sdlab.protocol import build_stride_entry
        timeline = [(0, 0), (20000, 60), (40000, 120)]
        strides = self.gen.build_strides(timeline, interval_m=100)
        self.assertGreater(len(strides), 0, "至少切出一段步幅")
        # 每段都是整数米间距
        for s in strides:
            self.assertEqual(s.distance_m, 100)
            self.assertGreater(s.step_count, 0)
        # strideList 恒为单元素数组（原版 ArrayList(1)）
        self.assertEqual(len(build_stride_list(strides[0])), 1)
        entry = build_stride_entry(strides[0])
        for 字段 in ("time", "stride", "distance", "stepCount", "index"):
            self.assertIn(字段, entry)

    def test_配速段覆盖全程(self):
        paces = self.gen.generate_paces(start_ms=self.t0)
        self.assertGreater(len(paces), 0)
        总距 = sum(p.distance for p in paces)
        self.assertAlmostEqual(总距, 1000, delta=60)
        for i, p in enumerate(paces):
            self.assertEqual(p.pace_index, i)

    def test_配速段清单转换(self):
        paces = build_pace_list(self.gen.generate_paces(start_ms=self.t0))
        self.assertEqual(len(paces), len(self.gen.generate_paces(start_ms=self.t0)))
        self.assertIn("distance", paces[0])

    def test_默认打卡点按四分位取(self):
        目标 = build_target_points(self.pts)
        self.assertEqual(len(目标), 3)
        # 原版类头是 @JSONType(includes = {"lat","lng","clockTime","code","passStatus"})
        # → fastjson 只序列化这 5 个字段，sort/nfcEnable 都不发
        允许 = {"code", "lat", "lng", "passStatus", "clockTime"}
        for p in 目标:
            self.assertEqual(set(p), 允许, f"targetPoints 字段不符：{sorted(p)}")
            self.assertNotIn("index", p, "原版字段名是 code，不是 index")
        时间 = [int(p["clockTime"]) for p in 目标]
        self.assertEqual(时间, sorted(时间))
        self.assertTrue(all(p["passStatus"] in (True, False) for p in 目标))


class 有效性判定测试(unittest.TestCase):
    """判定顺序：GPS → 步幅 → 距离 → 打卡 → 配速（对齐客户端 W0）"""

    def setUp(self):
        self.rule = RuleSet()
        # 每段 33.4 米 × 59 段 ≈ 1970 米，落在单次有效距离 1000~10000 米内
        self.pts = [造点(中心[0] + i * 3e-4, 中心[1], i) for i in range(60)]

    def 判定(self, **kw):
        参数 = dict(pts=self.pts, duration_s=720, total_step=2353, rule=self.rule,
                    gps_enabled=True, stride_exception_segments=0,
                    checkpoints_total=3, checkpoints_done=3)
        参数.update(kw)
        return evaluate_run(**参数)

    def test_合规跑步判定有效(self):
        res = self.判定()
        self.assertTrue(res.is_valid)
        self.assertEqual(res.status, 1)
        self.assertEqual(res.reasons, [])
        self.assertGreater(res.pace_s_per_km, 300)
        self.assertLess(res.pace_s_per_km, 420)
        self.assertAlmostEqual(res.pace_s_per_km, 720 / (res.distance_m / 1000.0), delta=1)

    def test_关闭GPS判25(self):
        res = self.判定(gps_enabled=False, duration_s=720)
        self.assertFalse(res.is_valid)
        self.assertIn(C.INVALID_GPS, [r["type"] for r in res.reasons])

    def test_距离不足判2(self):
        res = self.判定(pts=[造点(中心[0] + i * 1e-6, 中心[1], i) for i in range(20)])
        self.assertFalse(res.is_valid)
        self.assertIn(C.INVALID_DISTANCE, [r["type"] for r in res.reasons])

    def test_配速过快判3(self):
        res = self.判定(duration_s=200)
        self.assertFalse(res.is_valid)
        self.assertIn(C.INVALID_PACE, [r["type"] for r in res.reasons])

    def test_缺少打卡判1(self):
        res = self.判定(checkpoints_done=1)
        self.assertFalse(res.is_valid)
        self.assertIn(C.INVALID_CHECKPOINT, [r["type"] for r in res.reasons])

    def test_步幅异常判58(self):
        # 原版这一项由 L1() 门控：只有 cheatLevel 3/4（严查学校）才进本地列表
        res = self.判定(stride_exception_segments=99, cheat_level=3)
        self.assertFalse(res.is_valid)
        self.assertIn(C.INVALID_STRIDE, [r["type"] for r in res.reasons])

    def test_普通学校步幅异常不判58(self):
        # cheatLevel 0/1/2：即使异常段数超限，也不在 invalidReasons 里（服务端自己判）
        res = self.判定(stride_exception_segments=99, cheat_level=0)
        self.assertTrue(res.is_valid)
        self.assertNotIn(C.INVALID_STRIDE, [r["type"] for r in res.reasons])

    def test_白名单学校步幅异常不判58(self):
        # whiteFlag / gpsWhiteFlag 任一为真都短路 L1()
        for kw in ({"white_flag": True}, {"gps_white_flag": True}):
            res = self.判定(stride_exception_segments=99, cheat_level=3, **kw)
            self.assertTrue(res.is_valid, kw)

    def test_判定结果可序列化(self):
        d = self.判定().to_dict()
        self.assertIs(d["isValid"], True)
        self.assertEqual(d["status"], 1)
        self.assertIn("distanceM", d)

    def test_规则可从服务端字段解析(self):
        rule = RuleSet.from_rule({"singleMinDistance": "1500", "minPace": 180,
                                  "requiredPointCounts": 2, "未知字段": 1})
        self.assertEqual(rule.single_min_distance, 1500)
        self.assertEqual(rule.min_pace, 180)
        self.assertEqual(rule.required_point_counts, 2)

    def test_规则可回写(self):
        d = RuleSet().to_dict()
        for 字段 in ("singleMinDistance", "minPace", "segmentStrideAvg"):
            self.assertIn(字段, d)


if __name__ == "__main__":
    unittest.main(verbosity=2)
