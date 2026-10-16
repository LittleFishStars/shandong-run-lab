#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""手动实走引擎：把「虚拟摇杆方向」或「手动指定的路径」变成可落库的跑步轨迹

对应 Android 侧的 `shandong-mini-apk/app/java/com/ylxc/shandongmini/Walker.java`，
桌面工作台需要同一套能力（自己控制路径、而不是只能一键算完），运动学与判定口径
刻意保持一致：

  · 位置推进：`lat += dy·v·dt / 111320`、`lng += dx·v·dt / (111320·cos(lat))`
    （dx 向东为正、dy 向北为正，与摇杆输出一致）；
  · 采样：每 3 秒落一个轨迹点，与官方 `run_lat_lng` 表的采样间隔一致；
  · 打卡：进入必经点 12 米半径即判定命中（`CHECKPOINT_HIT_RADIUS_M`）；
  · 沿路径自动走：朝下一个路点直线推进，进入 8 米即切下一个，最多绕 4 圈；
  · 步数/步频仍然来自 `FuckRunSim`，因此配速、步幅、步频与一键跑同源，
    不会出现「摇杆走出来的数据判步幅异常」这种自相矛盾。

与 Java 版的差别（桌面侧更省事的地方）：
  · 不挂 Handler 定时器——推进量由调用方给定的 `dt` 决定，GUI 用后台线程按真实
    时间喂小步长、测试里可以直接一次性快进，两边跑的是同一份逻辑；
  · 采样点直接产出协议层的 `RunLatLng`，不再经 JSON 中转。
"""
from __future__ import annotations

import math
import random
import time
from dataclasses import dataclass, field
from typing import Any, Dict, List, Optional, Sequence, Tuple

from .constants import CHECKPOINT_HIT_RADIUS_M, STATE_INIT
from .protocol import EARTH_M_PER_DEG_LAT, RunLatLng, distance_to_polygon_edge
from .simulator import FuckRunSim

# 轨迹采样间隔（秒）：与客户端 run_lat_lng 表一致
SAMPLE_INTERVAL_S = 3.0
# 单帧推进的默认步长（秒，真实时间）：GUI 后台线程按这个节拍喂数据
TICK_DEFAULT_S = 0.1
# 路点到达判定（米）：比打卡半径小，避免在打卡点附近来回蹭
WAYPOINT_REACH_M = 8.0
# 沿路径自动走时最多绕几圈，防止路线闭合后被判成"永远到不了"
MAX_LAPS = 4
# 摇杆推到底时的默认速度（m/s）：2.5 ≈ 9 km/h 的慢跑。原版 2.78（10 km/h）
# 推满就顶到规则配速上沿，手动走的时候手感偏快，所以下调并允许界面自己调
DEFAULT_SPEED_MPS = 2.5
# 摇杆死区：小于这个量级视为没推（避免手指微抖把速度算出来）
JOYSTICK_DEADZONE = 0.02


@dataclass
class WalkState:
    """一帧之后的状态快照（给界面直接显示，字段名与前端约定一致）"""

    lat: float = 0.0
    lng: float = 0.0
    dist_m: float = 0.0
    move_sec: float = 0.0
    steps: int = 0
    speed_mps: float = 0.0
    accel_z: float = 0.0
    cadence: float = 0.0
    passed: int = 0
    targets: int = 0
    points: int = 0
    arrived: str = ""
    route_index: int = 0
    destination: Optional[Tuple[float, float]] = None

    def to_dict(self) -> Dict[str, Any]:
        return {
            "lat": round(self.lat, 6), "lng": round(self.lng, 6),
            "dist_m": round(self.dist_m, 2), "move_sec": round(self.move_sec, 2),
            "steps": int(self.steps), "speed_mps": round(self.speed_mps, 2),
            "accel_z": round(self.accel_z, 3), "cadence": round(self.cadence, 1),
            "passed": int(self.passed), "targets": int(self.targets),
            "points": int(self.points), "arrived": self.arrived,
            "route_index": int(self.route_index),
            "destination": ({"lat": self.destination[0], "lng": self.destination[1]}
                            if self.destination else None),
        }


class Walker:
    """摇杆 / 路径驱动的实走引擎（纯计算，不碰网络与数据库）"""

    def __init__(self, sim: Optional[FuckRunSim] = None,
                 sample_s: float = SAMPLE_INTERVAL_S,
                 checkin_radius_m: float = CHECKPOINT_HIT_RADIUS_M,
                 seed: Optional[int] = None):
        self.sim = sim if sim is not None else FuckRunSim(seed=seed)
        self.sample_s = max(0.5, float(sample_s))
        self.checkin_radius_m = float(checkin_radius_m)
        self.rng = random.Random(seed)

        self.lat = 0.0
        self.lng = 0.0
        self.dist_m = 0.0
        self.move_sec = 0.0
        self.start_ms = 0
        self.running = False
        self.arrived = ""

        # 摇杆输入
        self.dir_x = 0.0
        self.dir_y = 0.0
        self.mag = 0.0
        self.target_speed_mps = DEFAULT_SPEED_MPS

        # 目标距离：<=0 表示不限（走到用户自己停）
        self.target_distance_m = 0.0

        # 手动路径
        self.route: List[Tuple[float, float]] = []
        self.auto_route = False
        self.route_index = 0

        # 打卡桩
        self.targets: List[Dict[str, Any]] = []
        # 围栏多边形（算 offFenceDisM 用）
        self.polygon: List[List[float]] = []

        # 采样与产出
        self.samples: List[Tuple[float, float]] = []      # (距离, 运动秒)
        self._pending: List[RunLatLng] = []              # 待调用方取走的轨迹点
        self._hits: List[Dict[str, Any]] = []            # 本轮新命中的打卡点（调用方落库 + 界面提示）
        self._pending_meta: List[Dict[str, Any]] = []    # 每个采样点的分段元数据（步频/配速）
        self._last_sample_dist = 0.0
        self._last_sample_at_prev_sec = 0.0
        self._last_sample_steps = 0
        self._poi_index = 0
        self._last_sample_at = 0.0
        self._sensor: Dict[str, Any] = {}

    # ══════════════════ 配置 ══════════════════
    def set_joystick(self, dx: float, dy: float, mag: float) -> None:
        """摇杆输入：dx/dy 是单位方向（东/北为正），mag ∈ [0,1] 是推杆幅度"""
        self.dir_x, self.dir_y = float(dx), float(dy)
        self.mag = max(0.0, min(1.0, float(mag)))

    def release_joystick(self) -> None:
        self.mag = 0.0
        self.dir_x = 0.0
        self.dir_y = 0.0

    def set_route(self, route: Sequence[Sequence[float]]) -> None:
        """手动指定路径：[[lat, lng], ...]，配 auto_route=True 时自动沿路点走"""
        self.route = [(float(p[0]), float(p[1])) for p in (route or [])
                      if p is not None and len(p) >= 2]
        self.route_index = 0

    def set_auto_route(self, flag: bool) -> None:
        self.auto_route = bool(flag)

    def set_target_points(self, cps: Sequence[Dict[str, Any]]) -> None:
        """打卡桩：直接吃 `store.get_checkpoints()` 的 dict 形态"""
        self.targets = [dict(c) for c in (cps or [])]

    def set_polygon(self, polygon: Sequence[Sequence[float]]) -> None:
        self.polygon = [list(p) for p in (polygon or [])]

    def set_target_speed(self, mps: float) -> None:
        self.target_speed_mps = max(0.3, float(mps))

    def set_target_distance(self, meters: float) -> None:
        self.target_distance_m = max(0.0, float(meters))

    # ══════════════════ 生命周期 ══════════════════
    def start(self, lat: float, lng: float, reset: bool = True,
              start_ms: Optional[int] = None) -> WalkState:
        """开始或从暂停恢复；reset=True 时清空上一条轨迹"""
        if reset:
            self.lat, self.lng = float(lat), float(lng)
            self.dist_m = 0.0
            self.move_sec = 0.0
            self.samples.clear()
            self._pending.clear()
            self._hits.clear()
            self._pending_meta.clear()
            self._last_sample_dist = 0.0
            self._last_sample_at_prev_sec = 0.0
            self._last_sample_steps = 0
            self.arrived = ""
            self.route_index = 0
            self._last_sample_at = 0.0
            # 起始 POI 序号与原版一致：随机 150–300，避免多条记录序号都一样
            self._poi_index = 150 + self.rng.randint(0, 150)
            for cp in self.targets:
                cp["passed"] = 0
                cp.pop("hit_lat", None)
                cp.pop("hit_lng", None)
                cp.pop("hit_ms", None)
            self.sim.start(start_ms=start_ms, base_steps=0)
        self.start_ms = int(start_ms if start_ms is not None else time.time() * 1000)
        self.running = True
        return self.state()

    def stop(self) -> WalkState:
        self.running = False
        self.sim.stop()
        return self.state()

    # ══════════════════ 单帧推进 ══════════════════
    def tick(self, dt: float) -> WalkState:
        """推进 dt 秒（虚拟时间）；返回推进后的状态

        步行方向优先取路径（auto_route），否则取摇杆；速度为 0 时只走时间不走路，
        这样"站着不动"也能被界面区分出来（距离不变、配速掉下去）。
        """
        if dt <= 0:
            return self.state()
        dx, dy, mag = self.dir_x, self.dir_y, self.mag
        if self.auto_route:
            nxt = self._direction_to_next_waypoint()
            if nxt is None:
                self.arrived = "路径已走完"
                self.running = False
                self.sim.stop()
                return self.state()
            dx, dy, mag = nxt[0], nxt[1], 1.0

        speed = 0.0
        if mag > JOYSTICK_DEADZONE:
            speed = self.target_speed_mps * mag
            move = speed * dt
            self.lat += (dy * move) / EARTH_M_PER_DEG_LAT
            self.lng += (dx * move) / (EARTH_M_PER_DEG_LAT *
                                       max(1e-6, math.cos(math.radians(self.lat))))
            self.dist_m += move
            self.move_sec += dt
            # 采样与打卡都读 _sensor（步数/步频），所以必须先把它推到当前帧，
            # 否则分段步数会整体滞后一帧、与总步数对不上
            self._refresh_sensor()
            self._check_targets()
            self._sample_if_due(speed)

        # 步数用「真实运动时长」而不是时间轴：站着不动就不计步，与暂停语义一致
        self._refresh_sensor()
        if self.target_distance_m > 0 and self.dist_m >= self.target_distance_m:
            self.arrived = f"已达目标距离 {int(self.target_distance_m)} 米"
            self.running = False
            self.sim.stop()
        return self.state()

    def _refresh_sensor(self) -> None:
        """把仿真器推进到当前运动时长，刷新加速度/步频/累计步数"""
        sample = self.sim.sample_at(self.move_sec, elapsed_s=self.move_sec)
        self._sensor = {
            "accel_z": sample.z, "cadence": sample.cadence,
            "steps": int(sample.steps_cum),   # 累计步数：base + 运动时长 × 步频
            "step_detected": bool(sample.step_detected),
        }

    def state(self) -> WalkState:
        s = self._sensor or {}
        passed = sum(1 for c in self.targets if int(c.get("passed") or 0) == 1)
        dest = None
        if self.auto_route and self.route:
            wp = self.route[self.route_index % len(self.route)]
            dest = (float(wp[0]), float(wp[1]))
        return WalkState(
            lat=self.lat, lng=self.lng, dist_m=self.dist_m, move_sec=self.move_sec,
            steps=int(s.get("steps") or 0), speed_mps=self._speed_now(),
            accel_z=float(s.get("accel_z") or 0.0),
            cadence=float(s.get("cadence") or 0.0),
            passed=passed, targets=len(self.targets), points=len(self.samples),
            arrived=self.arrived, route_index=self.route_index, destination=dest,
        )

    def _speed_now(self) -> float:
        """最近一帧的速度：站着不动就是 0（界面靠它显示"正在跑 / 已停下"）"""
        if self.mag <= JOYSTICK_DEADZONE and not self.auto_route:
            return 0.0
        if self.auto_route:
            return self.target_speed_mps
        return self.target_speed_mps * self.mag

    # ══════════════════ 路径导航 ══════════════════
    def _direction_to_next_waypoint(self) -> Optional[Tuple[float, float]]:
        """朝下一个路点的单位方向；走到路点就切下一个，绕满 MAX_LAPS 圈算走完"""
        if not self.route:
            return None
        while True:
            wp = self.route[self.route_index % len(self.route)]
            d = _haversine(self.lat, self.lng, wp[0], wp[1])
            if d < WAYPOINT_REACH_M:
                self.route_index += 1
                if self.route_index >= len(self.route) * MAX_LAPS:
                    return None
                continue
            d_lat = wp[0] - self.lat
            d_lng = (wp[1] - self.lng) * math.cos(math.radians(self.lat))
            length = math.hypot(d_lat, d_lng)
            if length < 1e-9:
                self.route_index += 1
                continue
            return (d_lng / length, d_lat / length)

    # ══════════════════ 打卡与采样 ══════════════════
    def _check_targets(self) -> None:
        now = int(time.time() * 1000)
        for cp in self.targets:
            if int(cp.get("passed") or 0) == 1:
                continue
            try:
                tlat, tlng = float(cp["lat"]), float(cp["lng"])
            except (KeyError, TypeError, ValueError):
                continue
            radius = float(cp.get("radius_m") or self.checkin_radius_m)
            if _haversine(self.lat, self.lng, tlat, tlng) <= radius:
                cp["passed"] = 1
                cp["hit_lat"] = self.lat
                cp["hit_lng"] = self.lng
                cp["hit_ms"] = now
                # 命中的桩必须立刻交给调用方：实跑时要落库（mark_checkpoint_hit），
                # 否则本地库 checkpoints.passed 恒为 0，上传时等于一个都没打
                self._hits.append(dict(cp))

    def _sample_if_due(self, speed: float) -> None:
        """每 sample_s 秒落一个采样点（同时进 samples 与待取走的 _pending）"""
        if self.move_sec - self._last_sample_at < self.sample_s - 1e-9:
            return
        self._last_sample_at = self.move_sec
        self.samples.append((self.dist_m, self.move_sec))
        lat = _round6(self.lat)
        lng = _round6(self.lng)
        off = 0
        if self.polygon:
            off = int(distance_to_polygon_edge(lat, lng, self.polygon))
        self._pending.append(RunLatLng(
            lat=lat, lng=lng, lat_lng_index=self._poi_index,
            run_time=int(self.move_sec * 1000),
            collect_time=self.start_ms + int(self.move_sec * 1000),
            state=STATE_INIT, off_fence_dis_m=off,
            accuracy=round(self.rng.uniform(5.0, 12.0), 1),
            speed=round(speed, 2),
            satellites=self.rng.randint(8, 13),
        ))
        # 采样点是「段」的载体：实跑时要把这段走了多少米/多少步/走了多久带上，
        # 否则落库的步频段与配速段只能事后猜（一键跑是一次性算完，没有这个问题）
        self._pending_meta.append({
            "index": self._poi_index,
            "seg_dist_m": self.dist_m - self._last_sample_dist,
            "seg_sec": self.move_sec - self._last_sample_at_prev_sec,
            "seg_steps": int(self._sensor.get("steps") or 0) - self._last_sample_steps,
            "abs_dist_m": self.dist_m,
            "abs_sec": self.move_sec,
            "abs_steps": int(self._sensor.get("steps") or 0),
            "cadence": float(self._sensor.get("cadence") or 0.0),
            "start_ms": self.start_ms,
        })
        self._last_sample_dist = self.dist_m
        self._last_sample_at_prev_sec = self.move_sec
        self._last_sample_steps = int(self._sensor.get("steps") or 0)
        self._poi_index += 1

    def drain_points(self) -> List[RunLatLng]:
        """取走这一步新产生的轨迹点（调用方负责落库）"""
        out = self._pending
        self._pending = []
        return out

    def drain_hits(self) -> List[Dict[str, Any]]:
        """取走刚命中的打卡点（命中一次只取到一次）"""
        out = self._hits
        self._hits = []
        return out

    def drain_meta(self) -> List[Dict[str, Any]]:
        """取走与刚取走的轨迹点一一对应的分段元数据"""
        out = self._pending_meta
        self._pending_meta = []
        return out

    def points(self) -> List[RunLatLng]:
        """全部轨迹点（收尾时用）"""
        return list(self._pending)

    def passed_targets(self) -> List[Dict[str, Any]]:
        return [dict(c) for c in self.targets if int(c.get("passed") or 0) == 1]

    def summary(self) -> Dict[str, Any]:
        st = self.state()
        speed = st.dist_m / st.move_sec if st.move_sec > 0 else 0.0
        pace = (st.move_sec / (st.dist_m / 1000.0)) if st.dist_m > 0 else 0.0
        return {
            "distance_m": round(st.dist_m, 2),
            "duration_s": round(st.move_sec, 2),
            "total_step": int(st.steps),
            "avg_speed_mps": round(speed, 3),
            "pace_s_per_km": round(pace, 2),
            "stride_m": round(st.dist_m / st.steps, 3) if st.steps else 0.0,
            "samples": len(self.samples),
            "checkpoints_done": st.passed,
            "checkpoints_total": st.targets,
            "arrived": st.arrived,
        }


# ══════════════════ 工具 ══════════════════
def _haversine(lat1: float, lng1: float, lat2: float, lng2: float) -> float:
    """球面距离（米）：与协议层 `protocol.haversine` 同一公式，便于与后端对齐"""
    r = 6371008.8
    p1, p2 = math.radians(lat1), math.radians(lat2)
    d_lat = p2 - p1
    d_lng = math.radians(lng2 - lng1)
    a = math.sin(d_lat / 2) ** 2 + math.cos(p1) * math.cos(p2) * math.sin(d_lng / 2) ** 2
    return 2 * r * math.asin(min(1.0, math.sqrt(a)))


def _round6(v: float) -> float:
    return math.floor(v * 1e6 + 0.5) / 1e6


def route_from_checkpoints(center_lat: float, center_lng: float,
                           cps: Sequence[Dict[str, Any]],
                           loop: bool = True) -> List[List[float]]:
    """把打卡点连成一条可自动走的路线（最近邻排序，可选闭合回中心）

    顺序很重要：按服务端下发顺序直连会来回穿插，绕路会让实际距离远超目标距离；
    最近邻排序缩短单圈长度，也就缩短了"走完全部打卡点至少要跑多远"。
    """
    rest = [(float(c["lat"]), float(c["lng"])) for c in (cps or [])
            if c.get("lat") is not None and c.get("lng") is not None]
    out: List[List[float]] = []
    cur = (float(center_lat), float(center_lng))
    while rest:
        i = min(range(len(rest)), key=lambda k: _haversine(cur[0], cur[1], rest[k][0], rest[k][1]))
        cur = rest.pop(i)
        out.append([cur[0], cur[1]])
    if loop and out:
        out.append([float(center_lat), float(center_lng)])
    return out
