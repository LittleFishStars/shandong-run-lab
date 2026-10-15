#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""运动协议数据层：三类记录的字段模型 + 报文构造 + 客户端有效性判定

对应客户端内部实现（报告 07 第四、五、六章）：
  · Room v7 三张表 run_lat_lng / run_step / run_pace
  · 上传状态位 INIT=1 / UPLOADING=2 / FAIL=4 / SUCC=8
  · 服务端回 indexList → 本地按段标记状态 → 断点续传
  · 本地有效性判定产出 invalidType（1/2/3/25/58）

★ accuracy / speed / satellites **不上传**，只用于本地质量过滤。
"""
from __future__ import annotations

import math
import random
import time
import uuid
from dataclasses import dataclass, field
from typing import Any, Dict, List, Optional, Sequence, Tuple

from .constants import (
    INVALID_CHECKPOINT,
    INVALID_DISTANCE,
    INVALID_GPS,
    INVALID_PACE,
    INVALID_REASON_NAME,
    INVALID_STRIDE,
    SPORT_TYPE_SUN,
    STATE_FAIL,
    STATE_INIT,
    STATE_SUCC,
    STATE_UPLOADING,
)

EARTH_M_PER_DEG_LAT = 111_320.0


# ══════════════════ 几何工具 ══════════════════
def haversine(lat1: float, lng1: float, lat2: float, lng2: float) -> float:
    """两点球面距离（米）"""
    r = 6_371_008.8
    p1, p2 = math.radians(lat1), math.radians(lat2)
    dp = p2 - p1
    dl = math.radians(lng2 - lng1)
    a = math.sin(dp / 2) ** 2 + math.cos(p1) * math.cos(p2) * math.sin(dl / 2) ** 2
    return 2 * r * math.asin(min(1.0, math.sqrt(a)))


def point_in_polygon(lat: float, lng: float, polygon: Sequence[Sequence[float]]) -> bool:
    """射线法判断点是否在多边形内（polygon 为 [[lat,lng],...]）"""
    if not polygon or len(polygon) < 3:
        return True  # 没有围栏几何时不做限制
    inside = False
    n = len(polygon)
    j = n - 1
    for i in range(n):
        yi, xi = float(polygon[i][0]), float(polygon[i][1])
        yj, xj = float(polygon[j][0]), float(polygon[j][1])
        if ((xi > lng) != (xj > lng)) and \
           (lat < (yj - yi) * (lng - xi) / (xj - xi + 1e-12) + yi):
            inside = not inside
        j = i
    return inside


def polygon_centroid(polygon: Sequence[Sequence[float]]) -> Tuple[float, float]:
    """多边形顶点平均值（近似质心）"""
    if not polygon:
        return 0.0, 0.0
    return (sum(float(p[0]) for p in polygon) / len(polygon),
            sum(float(p[1]) for p in polygon) / len(polygon))


def distance_to_polygon_edge(lat: float, lng: float,
                             polygon: Sequence[Sequence[float]]) -> float:
    """点到围栏边界的最近距离（米）；在围栏内返回 0"""
    if not polygon:
        return 0.0
    if point_in_polygon(lat, lng, polygon):
        return 0.0
    best = float("inf")
    n = len(polygon)
    for i in range(n):
        a = polygon[i]
        b = polygon[(i + 1) % n]
        best = min(best, _point_seg_distance(lat, lng, float(a[0]), float(a[1]),
                                             float(b[0]), float(b[1])))
    return best


def _point_seg_distance(lat: float, lng: float, alat: float, alng: float,
                        blat: float, blng: float) -> float:
    """点到线段距离：先投影到局部平面，再算垂足"""
    m_per_deg_lng = EARTH_M_PER_DEG_LAT * math.cos(math.radians(lat))
    ax, ay = (alng - lng) * m_per_deg_lng, (alat - lat) * EARTH_M_PER_DEG_LAT
    bx, by = (blng - lng) * m_per_deg_lng, (blat - lat) * EARTH_M_PER_DEG_LAT
    dx, dy = bx - ax, by - ay
    seg2 = dx * dx + dy * dy
    if seg2 <= 1e-9:
        return math.hypot(ax, ay)
    t = max(0.0, min(1.0, -(ax * dx + ay * dy) / seg2))
    px, py = ax + t * dx, ay + t * dy
    return math.hypot(px, py)


# ══════════════════ 表 1：run_lat_lng ══════════════════
@dataclass
class RunLatLng:
    """轨迹点 —— 对应 @Entity(tableName="run_lat_lng")"""

    lat: float
    lng: float
    lat_lng_index: int = 0            # @JSONField("index")
    run_time: int = 0                 # @JSONField("runTime")   跑步内相对 ms
    collect_time: int = 0             # @JSONField("collectTime") 采集绝对 ms
    state: int = STATE_INIT           # @JSONField("state")
    off_fence_dis_m: int = 0          # @JSONField("offFenceDisM") 距围栏距离（米）

    # 仅本地（serialize=false）
    accuracy: float = 6.0
    speed: float = 0.0
    satellites: int = 10
    is_valid: bool = True
    is_uploaded: bool = False
    run_code: str = ""

    def to_upload_dict(self, index: Optional[int] = None) -> Dict[str, Any]:
        return {
            "index": index if index is not None else self.lat_lng_index,
            "lat": round(self.lat, 6),
            "lng": round(self.lng, 6),
            "runTime": self.run_time,
            "collectTime": self.collect_time,
            "state": self.state,
            "offFenceDisM": self.off_fence_dis_m,
        }

    @classmethod
    def from_dict(cls, d: Dict[str, Any], run_code: str = "") -> "RunLatLng":
        return cls(
            lat=float(d.get("lat", 0.0)),
            lng=float(d.get("lng", 0.0)),
            lat_lng_index=int(d.get("index", 0)),
            run_time=int(d.get("runTime", 0)),
            collect_time=int(d.get("collectTime", 0)),
            state=int(d.get("state", STATE_INIT)),
            off_fence_dis_m=int(d.get("offFenceDisM", 0)),
            accuracy=float(d.get("accuracy", 6.0)),
            speed=float(d.get("speed", 0.0)),
            satellites=int(d.get("satellites", 10)),
            is_valid=bool(d.get("isValid", True)),
            is_uploaded=bool(d.get("isUploaded", d.get("state", STATE_INIT) == STATE_SUCC)),
            run_code=d.get("runCode", run_code),
        )


# ══════════════════ 表 2：run_step ══════════════════
@dataclass
class IntervalStep:
    """步频段 —— 对应 @Entity(tableName="run_step")"""

    start_step: int = 0
    end_step: int = 0
    start_time: int = 0
    end_time: int = 0
    step: int = 0
    time: int = 0
    step_index: int = 0
    run_code: str = ""
    is_valid: bool = True
    is_uploaded: bool = False

    def to_upload_dict(self, index: Optional[int] = None) -> Dict[str, Any]:
        return {
            "index": index if index is not None else self.step_index,
            "startStep": self.start_step,
            "endStep": self.end_step,
            "startTime": self.start_time,
            "endTime": self.end_time,
            "step": self.step,
            "time": self.time,
        }

    @classmethod
    def from_dict(cls, d: Dict[str, Any], run_code: str = "") -> "IntervalStep":
        return cls(
            start_step=int(d.get("startStep", 0)),
            end_step=int(d.get("endStep", 0)),
            start_time=int(d.get("startTime", 0)),
            end_time=int(d.get("endTime", 0)),
            step=int(d.get("step", 0)),
            time=int(d.get("time", 0)),
            step_index=int(d.get("index", 0)),
            run_code=d.get("runCode", run_code),
            is_valid=bool(d.get("isValid", True)),
            is_uploaded=bool(d.get("isUploaded", False)),
        )


# ══════════════════ 表 3：run_pace ══════════════════
@dataclass
class IntervalPace:
    """配速段 —— 对应 @Entity(tableName="run_pace")"""

    distance: int = 0
    start_distance: int = 0
    end_distance: int = 0
    step_count: int = 0
    start_step_count: int = 0
    end_step_count: int = 0
    time: int = 0
    start_time: int = 0
    end_time: int = 0
    pace_index: int = 0
    run_code: str = ""
    is_valid: bool = True
    is_uploaded: bool = False

    def to_upload_dict(self, index: Optional[int] = None) -> Dict[str, Any]:
        return {
            "index": index if index is not None else self.pace_index,
            "distance": self.distance,
            "startDistance": self.start_distance,
            "endDistance": self.end_distance,
            "stepCount": self.step_count,
            "startStepCount": self.start_step_count,
            "endStepCount": self.end_step_count,
            "time": self.time,
            "startTime": self.start_time,
            "endTime": self.end_time,
        }

    @classmethod
    def from_dict(cls, d: Dict[str, Any], run_code: str = "") -> "IntervalPace":
        return cls(
            distance=int(d.get("distance", 0)),
            start_distance=int(d.get("startDistance", 0)),
            end_distance=int(d.get("endDistance", 0)),
            step_count=int(d.get("stepCount", 0)),
            start_step_count=int(d.get("startStepCount", 0)),
            end_step_count=int(d.get("endStepCount", 0)),
            time=int(d.get("time", 0)),
            start_time=int(d.get("startTime", 0)),
            end_time=int(d.get("endTime", 0)),
            pace_index=int(d.get("index", 0)),
            run_code=d.get("runCode", run_code),
            is_valid=bool(d.get("isValid", True)),
            is_uploaded=bool(d.get("isUploaded", False)),
        )


# ══════════════════ 上传报文构造 ══════════════════
def build_upload_pois(pts: Sequence[RunLatLng]) -> List[Dict[str, Any]]:
    return [p.to_upload_dict(i) for i, p in enumerate(pts)]


def build_pace_list(paces: Sequence[IntervalPace]) -> List[Dict[str, Any]]:
    return [p.to_upload_dict(i) for i, p in enumerate(paces)]


def build_step_list(steps: Sequence[IntervalStep]) -> List[Dict[str, Any]]:
    return [s.to_upload_dict(i) for i, s in enumerate(steps)]


def build_stride_list(steps: Sequence[IntervalStep], stride_m: float = 0.85) -> List[Dict[str, Any]]:
    """由步频段推导步幅段（stride 以厘米整数上传）"""
    return [
        {"index": i, "startStep": s.start_step, "endStep": s.end_step,
         "startTime": s.start_time, "endTime": s.end_time,
         "stride": int(round(stride_m * 100))}
        for i, s in enumerate(steps)
    ]


def build_target_points(pts: Sequence[RunLatLng],
                        checkpoint_indices: Optional[Sequence[int]] = None
                        ) -> List[Dict[str, Any]]:
    """构造打卡点（uploadPassPoint 的 targetPoints）

    未显式给出索引时按 25% / 50% / 75% 三处取点，与客户端默认目标数一致。
    """
    if checkpoint_indices is None:
        n = len(pts)
        checkpoint_indices = [int(n * r) for r in (0.25, 0.5, 0.75)] if n > 4 else []
    out: List[Dict[str, Any]] = []
    for i, idx in enumerate(checkpoint_indices):
        if 0 <= idx < len(pts):
            p = pts[idx]
            out.append({"index": i, "lat": round(p.lat, 6), "lng": round(p.lng, 6),
                        "runTime": p.run_time, "collectTime": p.collect_time})
    return out


def tail_points(pts: Sequence[RunLatLng], k: int = 4) -> List[Dict[str, Any]]:
    """结算报文里的 pois（客户端取最后 4 个点）"""
    tail = list(pts)[-k:]
    base = len(pts) - len(tail)
    return [p.to_upload_dict(base + i) for i, p in enumerate(tail)]


# ══════════════════ 本地有效性判定 ══════════════════
@dataclass
class RunValidity:
    """一次跑步的本地有效性判定结果"""

    is_valid: bool = True
    reasons: List[Dict[str, Any]] = field(default_factory=list)
    distance_m: float = 0.0
    duration_s: int = 0
    total_step: int = 0
    pace_s_per_km: float = 0.0
    checkpoints_done: int = 0
    checkpoints_total: int = 0

    @property
    def status(self) -> int:
        """结算报文的 status：有效 1 / 无效 0"""
        return 1 if self.is_valid else 0

    def to_dict(self) -> Dict[str, Any]:
        return {
            "isValid": self.is_valid,
            "status": self.status,
            "reasons": self.reasons,
            "distanceM": round(self.distance_m, 1),
            "durationS": self.duration_s,
            "totalStep": self.total_step,
            "paceSPerKm": round(self.pace_s_per_km, 1),
            "checkpointsDone": self.checkpoints_done,
            "checkpointsTotal": self.checkpoints_total,
        }


@dataclass
class RuleSet:
    """客户端下发的 SchoolRule 中与判定有关的子集（22 字段里的判定项）"""

    single_min_distance: float = 1000.0     # 单次最小距离（米）
    single_max_distance: float = 10000.0
    min_pace: float = 120.0                 # 秒/公里，越快值越小
    max_pace: float = 600.0
    segment_stride_avg: float = 0.85        # 步幅基准（米）
    segment_stride_exception_num: int = 5   # 允许的步幅异常段数
    swing_amplitude_threshold: int = 100    # 摇晃幅度阈值
    required_point_counts: int = 3          # 必经打卡点数
    optional_point_goal_counts: int = 0
    total_goal_counts: int = 3
    day_max_times: int = 3
    week_min_times: int = 3
    max_frequency: int = 5

    @classmethod
    def from_rule(cls, rule: Optional[Dict[str, Any]]) -> "RuleSet":
        """从服务端返回的 SchoolRule 字典构造（字段名缺失时用默认值）"""
        r = cls()
        if not rule:
            return r
        r.single_min_distance = float(_first(rule, "singleMinDistance", default=r.single_min_distance))
        r.single_max_distance = float(_first(rule, "singleMaxDistance", default=r.single_max_distance))
        r.min_pace = float(_first(rule, "minPace", default=r.min_pace))
        r.max_pace = float(_first(rule, "maxPace", default=r.max_pace))
        r.segment_stride_avg = float(_first(rule, "segmentStrideAvg", default=r.segment_stride_avg))
        r.segment_stride_exception_num = int(_first(
            rule, "segmentStrideExceptionNum", default=r.segment_stride_exception_num))
        r.swing_amplitude_threshold = int(_first(
            rule, "swingAmplitudeThreshold", default=r.swing_amplitude_threshold))
        r.required_point_counts = int(_first(
            rule, "requiredPointCounts", default=r.required_point_counts))
        r.optional_point_goal_counts = int(_first(
            rule, "optionalPointGoalCounts", default=r.optional_point_goal_counts))
        r.total_goal_counts = int(_first(
            rule, "totalGoalCounts", default=r.total_goal_counts))
        r.day_max_times = int(_first(rule, "dayMaxTimes", default=r.day_max_times))
        r.week_min_times = int(_first(rule, "weekMinTimes", default=r.week_min_times))
        r.max_frequency = int(_first(rule, "maxFrequency", default=r.max_frequency))
        return r

    def to_dict(self) -> Dict[str, Any]:
        return {
            "singleMinDistance": self.single_min_distance,
            "singleMaxDistance": self.single_max_distance,
            "minPace": self.min_pace,
            "maxPace": self.max_pace,
            "segmentStrideAvg": self.segment_stride_avg,
            "segmentStrideExceptionNum": self.segment_stride_exception_num,
            "swingAmplitudeThreshold": self.swing_amplitude_threshold,
            "requiredPointCounts": self.required_point_counts,
            "optionalPointGoalCounts": self.optional_point_goal_counts,
            "totalGoalCounts": self.total_goal_counts,
        }


def _first(d: Dict[str, Any], key: str, default: Any) -> Any:
    v = d.get(key, None)
    return default if v is None or v == "" else v


def evaluate_run(pts: Sequence[RunLatLng], duration_s: int, total_step: int,
                 rule: RuleSet, gps_enabled: bool = True,
                 stride_exception_segments: int = 0,
                 checkpoints_total: int = 3,
                 checkpoints_done: int = 0,
                 sport_type: int = SPORT_TYPE_SUN) -> RunValidity:
    """复刻客户端 DataComponent.W0 的本地有效性判定

    判定顺序与客户端一致：GPS → 分段步幅 → 距离 → 打卡点 → 配速。
    """
    res = RunValidity()
    res.duration_s = int(duration_s)
    res.total_step = int(total_step)
    res.checkpoints_total = int(checkpoints_total)
    res.checkpoints_done = int(checkpoints_done)

    dist = 0.0
    for a, b in zip(pts, list(pts)[1:]):
        dist += haversine(a.lat, a.lng, b.lat, b.lng)
    res.distance_m = dist
    if duration_s > 0 and dist > 0:
        res.pace_s_per_km = duration_s / (dist / 1000.0)

    def add(code: int, detail: str) -> None:
        res.reasons.append({"type": code,
                            "name": INVALID_REASON_NAME.get(code, "未知"),
                            "detail": detail})

    # ① 关闭 GPS
    if not gps_enabled:
        add(INVALID_GPS, "定位服务未开启")

    # ② 分段步幅异常
    if stride_exception_segments > rule.segment_stride_exception_num:
        add(INVALID_STRIDE, "分段步频距离异常")

    # ③ 距离不足 / 超限
    if dist < rule.single_min_distance:
        add(INVALID_DISTANCE, f"未完成 {rule.single_min_distance / 1000.0:.1f} 公里")
    elif dist > rule.single_max_distance > 0:
        add(INVALID_DISTANCE, f"超出单次上限 {rule.single_max_distance / 1000.0:.1f} 公里")

    # ④ 打卡点未完成
    if sport_type == SPORT_TYPE_SUN and checkpoints_total > 0:
        if checkpoints_done < min(checkpoints_total, rule.required_point_counts):
            add(INVALID_CHECKPOINT, "必经点未通过")
        elif checkpoints_done < checkpoints_total:
            add(INVALID_CHECKPOINT, "部分打卡点未完成")

    # ⑤ 配速超限
    if res.pace_s_per_km > 0 and rule.min_pace > 0 and rule.max_pace > 0:
        if res.pace_s_per_km < rule.min_pace:
            add(INVALID_PACE, "配速过快")
        elif res.pace_s_per_km > rule.max_pace:
            add(INVALID_PACE, "配速过慢")

    res.is_valid = not res.reasons
    return res


# ══════════════════ 轨迹生成 ══════════════════
class TrackGenerator:
    """生成符合校园跑步特征的轨迹

    设计目标（对齐 SchoolRule 的反作弊判定）：
      · 起点/终点都在围栏内，全程 offFenceDisM = 0
      · 配速落在 [minPace, maxPace] 之间（默认 5'30"–8'00"/km）
      · 步幅稳定在 segmentStrideAvg 附近
      · 步频曲线符合人类特征（热身 → 稳定 → 疲劳），非恒定值

    与客户端一致：3 秒采样一个轨迹点。
    """

    def __init__(self, center_lat: float, center_lng: float,
                 target_distance_m: float = 2000.0,
                 target_seconds: int = 720,
                 stride_m: float = 0.85,
                 cadence_spm: float = 176.0,
                 fence_radius_m: float = 300.0,
                 polygon: Optional[Sequence[Sequence[float]]] = None,
                 waypoints: Optional[Sequence[Sequence[float]]] = None,
                 sample_s: float = 3.0,
                 seed: Optional[int] = None,
                 wobble: float = 0.02):
        self.lat0 = center_lat
        self.lng0 = center_lng
        self.distance = target_distance_m
        self.seconds = max(1, int(target_seconds))
        self.stride = stride_m
        self.cadence = cadence_spm
        self.radius = fence_radius_m
        self.polygon = list(polygon) if polygon else None
        # 必经点（服务端下发的 targetPoints）：给了就必须绕行经过，
        # 这是阳光跑的打卡语义，不能用纯几何椭圆代替。
        self.waypoints: List[Tuple[float, float]] = [
            (float(p[0]), float(p[1])) for p in (waypoints or [])
            if p is not None and len(p) >= 2]
        self.sample_s = sample_s
        self.wobble = wobble
        self.rng = random.Random(seed)

    # ── 经纬度换算 ──
    def _m_per_deg_lat(self) -> float:
        return EARTH_M_PER_DEG_LAT

    def _m_per_deg_lng(self) -> float:
        return EARTH_M_PER_DEG_LAT * math.cos(math.radians(self.lat0))

    def _offset(self, dx_m: float, dy_m: float) -> Tuple[float, float]:
        return (self.lat0 + dy_m / self._m_per_deg_lat(),
                self.lng0 + dx_m / self._m_per_deg_lng())

    def _fits(self, lat: float, lng: float) -> bool:
        return point_in_polygon(lat, lng, self.polygon) if self.polygon else True

    # ── 轨迹点 ──
    def generate_track(self, start_ms: Optional[int] = None) -> List[RunLatLng]:
        """生成闭合环线轨迹，回到起点附近（配速均匀）"""
        n = max(2, int(self.seconds / self.sample_s))
        m_per_s = self.distance / self.seconds
        t0 = int(start_ms if start_ms is not None else time.time() * 1000)
        if self.waypoints:
            # 有必经点：轨迹必须逐个绕行经过，否则打卡永远不可能命中
            return self._waypoint_track(n, m_per_s, t0)
        # 无必经点时退回几何环线：单圈周长按目标距离推导，围栏装不下就绕多圈
        limit = self.radius * 0.9 if self.radius else 1e9
        laps = max(1, int(math.ceil(self.distance / (2 * math.pi * max(1.0, limit)))))
        a = self.distance / (2 * math.pi * laps)
        b = a * 0.92
        total = self._ellipse_perimeter(a, b) * laps

        pts: List[RunLatLng] = []
        for i in range(n + 1):
            # 按弧长比例分配参数角：实测周长回到目标距离（椭圆用 Ramanujan 周长）
            theta = 2 * math.pi * laps * (self.distance / max(1e-6, total)) * i / n
            # 形状抖动必须随角度**平滑**变化：每点独立的缩放会把弦长累加成虚假距离
            jitter = 1.0 + self.wobble * math.sin(3 * theta)
            x = a * math.cos(theta) * jitter + self.rng.uniform(-0.5, 0.5)
            y = b * math.sin(theta) * jitter + self.rng.uniform(-0.5, 0.5)
            lat, lng = self._offset(x, y)
            collect = t0 + int(i * self.sample_s * 1000)
            pts.append(RunLatLng(
                lat=lat, lng=lng, lat_lng_index=i,
                run_time=int(i * self.sample_s * 1000),
                collect_time=collect,
                state=STATE_INIT,
                off_fence_dis_m=int(distance_to_polygon_edge(lat, lng, self.polygon or [])),
                accuracy=self.rng.uniform(3.0, 8.0),
                speed=round(m_per_s, 2),
                satellites=self.rng.randint(8, 14),
            ))
        return pts

    # ── 途经必经点的轨迹（阳光跑打卡语义）──
    @staticmethod
    def route_length(center_lat: float, center_lng: float,
                     waypoints: Sequence[Sequence[float]]) -> float:
        """中心 → 依次绕过全部必经点 → 回中心 的最短闭环长度（最近邻估算）

        用来回答一个工程问题：**跑多远才可能打满所有卡**。目标距离比它短时，
        无论怎么跑都会漏点，引擎会据此自动抬升目标距离。
        """
        rest = [(float(p[0]), float(p[1])) for p in waypoints]
        if not rest:
            return 0.0
        cur = (float(center_lat), float(center_lng))
        total = 0.0
        while rest:
            i = min(range(len(rest)),
                    key=lambda k: haversine(cur[0], cur[1], rest[k][0], rest[k][1]))
            nxt = rest.pop(i)
            total += haversine(cur[0], cur[1], nxt[0], nxt[1])
            cur = nxt
        return total + haversine(cur[0], cur[1], float(center_lat), float(center_lng))

    def _ordered_waypoints(self) -> List[Tuple[float, float]]:
        """把必经点按最近邻排序（从围栏中心出发），减少绕路、缩短单圈长度"""
        rest = list(self.waypoints)
        out: List[Tuple[float, float]] = []
        cur: Tuple[float, float] = (self.lat0, self.lng0)
        while rest:
            i = min(range(len(rest)),
                    key=lambda k: haversine(cur[0], cur[1], rest[k][0], rest[k][1]))
            cur = rest.pop(i)
            out.append((float(cur[0]), float(cur[1])))
        return out

    @staticmethod
    def _ellipse_perimeter(a: float, b: float) -> float:
        """椭圆周长（Ramanujan 近似，误差 < 1e-5），用于把采样量折算回真实米数"""
        return math.pi * (3 * (a + b) - math.sqrt((3 * a + b) * (a + 3 * b)))

    def _to_xy(self, p: Sequence[float]) -> Tuple[float, float]:
        return ((float(p[1]) - self.lng0) * self._m_per_deg_lng(),
                (float(p[0]) - self.lat0) * self._m_per_deg_lat())

    def _waypoint_track(self, n: int, m_per_s: float, t0: int) -> List[RunLatLng]:
        """绕行所有必经点的闭环轨迹（按弧长等距采样）

        路线：围栏中心 → wp0 → wp1 → … → wp_{k-1} → 回中心，构成一个闭合环；
        采样点沿这条环**等弧长推进**，需要绕几圈就绕几圈（不依赖环长的整除性），
        因此实测距离恒等于目标距离。横向抖动用亚米级，
        保证每个必经点在 12 米判定半径内必然有采样点命中。
        """
        wps = self._ordered_waypoints()
        if not wps:
            return []
        center = self._offset(0.0, 0.0)
        loop: List[Tuple[float, float]] = [center] + wps + [center]
        seg = [haversine(x[0], x[1], y[0], y[1]) for x, y in zip(loop, loop[1:])]
        lap = sum(seg)
        if lap < 1e-6:
            return []
        cum = [0.0]
        for d in seg:
            cum.append(cum[-1] + d)
        total = lap

        pts: List[RunLatLng] = []
        for i in range(n + 1):
            # 沿闭合环等弧长取点：总推进量恒为 self.distance（跨圈处 s 回绕，
            # 而环首尾同为围栏中心，所以回绕不会产生跳变）
            s = (self.distance * i / n) % lap
            j = 0
            while j + 1 < len(cum) - 1 and cum[j + 1] < s:
                j += 1
            span = max(1e-6, cum[j + 1] - cum[j])
            f = min(1.0, max(0.0, (s - cum[j]) / span))
            x0, y0 = self._to_xy(loop[j])
            x1, y1 = self._to_xy(loop[j + 1])
            # 亚米级横向抖动：像真实 GPS 漂移，但不影响 12 米打卡判定
            x = x0 + (x1 - x0) * f + self.rng.uniform(-0.8, 0.8)
            y = y0 + (y1 - y0) * f + self.rng.uniform(-0.8, 0.8)
            lat, lng = self._offset(x, y)
            pts.append(RunLatLng(
                lat=lat, lng=lng, lat_lng_index=i,
                run_time=int(i * self.sample_s * 1000),
                collect_time=t0 + int(i * self.sample_s * 1000),
                state=STATE_INIT,
                off_fence_dis_m=int(distance_to_polygon_edge(lat, lng, self.polygon or [])),
                accuracy=self.rng.uniform(3.0, 8.0),
                speed=round(m_per_s, 2),
                satellites=self.rng.randint(8, 14),
            ))
        return pts

    # ── 步频段（由仿真器产生的步数时间线切段）──
    def build_steps(self, step_timeline: Sequence[Tuple[int, int]],
                    start_ms: Optional[int] = None) -> List[IntervalStep]:
        """把 (相对毫秒, 累计步数) 时间线切成固定时长段

        客户端按 stepInterval 切段上传，这里保持同样的语义。
        """
        t0 = int(start_ms if start_ms is not None else time.time() * 1000)
        out: List[IntervalStep] = []
        seg_ms = int(self.sample_s * 1000)
        buf_start_t, buf_start_s = None, 0
        for idx, (rel_ms, cum_step) in enumerate(step_timeline):
            if buf_start_t is None:
                buf_start_t, buf_start_s = rel_ms, cum_step
            if rel_ms - buf_start_t >= seg_ms or idx == len(step_timeline) - 1:
                out.append(IntervalStep(
                    start_step=buf_start_s,
                    end_step=cum_step,
                    start_time=t0 + buf_start_t,
                    end_time=t0 + rel_ms,
                    step=max(0, cum_step - buf_start_s),
                    time=max(1, rel_ms - buf_start_t),
                    step_index=len(out),
                ))
                buf_start_t, buf_start_s = rel_ms, cum_step
        return out

    # ── 配速段 ──
    def generate_paces(self, start_ms: Optional[int] = None) -> List[IntervalPace]:
        """按 1000 米分段生成配速（paceInterval 默认 1000）"""
        t0 = int(start_ms if start_ms is not None else time.time() * 1000)
        per_km_s = self.seconds / (self.distance / 1000.0)
        out: List[IntervalPace] = []
        cum_d, cum_s, cum_t = 0.0, 0, 0
        idx = 0
        while cum_d < self.distance and idx < 200:
            seg_d = min(1000.0, self.distance - cum_d)
            seg_s = per_km_s * (seg_d / 1000.0) * self.rng.uniform(0.98, 1.02)
            seg_step = int(round(seg_d / self.stride))
            out.append(IntervalPace(
                distance=int(round(cum_d + seg_d)),
                start_distance=int(round(cum_d)),
                end_distance=int(round(cum_d + seg_d)),
                step_count=cum_s + seg_step,
                start_step_count=cum_s,
                end_step_count=cum_s + seg_step,
                time=int(round(seg_s * 1000)),
                start_time=t0 + cum_t,
                end_time=t0 + cum_t + int(round(seg_s * 1000)),
                pace_index=idx,
            ))
            cum_d += seg_d
            cum_s += seg_step
            cum_t += int(round(seg_s * 1000))
            idx += 1
        return out


def new_run_code(prefix: str = "SDLAB") -> str:
    """本地生成的 runRecordCode（离线模式下用；真实模式由服务端下发）"""
    return f"{prefix}{uuid.uuid4().hex[:16].upper()}"
