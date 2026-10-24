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
    PACE_INTERVAL_M,
    SPORT_TYPE_SUN,
    STEP_INTERVAL_S,
    STATE_INIT,
    STRIDE_STATISTICS_M,
    STATE_SUCC,
)

EARTH_M_PER_DEG_LAT = 111_320.0
# 起点自动吸附时与围栏边界保持的最小距离（米）：贴边走容易被判成“出围栏”
SNAP_MARGIN_M = 10.0


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


def _polygon_edge_distance(lat: float, lng: float,
                           polygon: Sequence[Sequence[float]]) -> float:
    """点到多边形边界的最近距离（米），不关心点在里还是在外"""
    if not polygon or len(polygon) < 3:
        return 0.0
    best = float("inf")
    n = len(polygon)
    for i in range(n):
        a = polygon[i]
        b = polygon[(i + 1) % n]
        best = min(best, _point_seg_distance(lat, lng, float(a[0]), float(a[1]),
                                             float(b[0]), float(b[1])))
    return 0.0 if best == float("inf") else best


def closest_point_on_polygon(lat: float, lng: float,
                             polygon: Sequence[Sequence[float]]) -> Tuple[float, float, float]:
    """点到多边形边界的最近点：返回 (lat, lng, 距离米)；多边形无效时返回自身"""
    if not polygon or len(polygon) < 3:
        return float(lat), float(lng), 0.0
    m_per_deg_lng = EARTH_M_PER_DEG_LAT * math.cos(math.radians(lat))
    best_d = float("inf")
    best_lat, best_lng = float(lat), float(lng)
    n = len(polygon)
    for i in range(n):
        a = polygon[i]
        b = polygon[(i + 1) % n]
        alat, alng = float(a[0]), float(a[1])
        blat, blng = float(b[0]), float(b[1])
        ax, ay = (alng - lng) * m_per_deg_lng, (alat - lat) * EARTH_M_PER_DEG_LAT
        bx, by = (blng - lng) * m_per_deg_lng, (blat - lat) * EARTH_M_PER_DEG_LAT
        dx, dy = bx - ax, by - ay
        seg2 = dx * dx + dy * dy
        t = 0.0 if seg2 <= 1e-9 else max(0.0, min(1.0, -(ax * dx + ay * dy) / seg2))
        d = math.hypot(ax + t * dx, ay + t * dy)
        if d < best_d:
            best_d = d
            best_lat, best_lng = alat + t * (blat - alat), alng + t * (blng - alng)
    return best_lat, best_lng, best_d


def _inside_with_margin(lat: float, lng: float, polygon: Sequence[Sequence[float]],
                        margin_m: float) -> bool:
    """点在围栏内、且离边界还有 margin_m 米以上（GPS 抖动也还在围栏里）"""
    return point_in_polygon(lat, lng, polygon) and \
        _polygon_edge_distance(lat, lng, polygon) >= margin_m


def snap_into_polygon(lat: float, lng: float, polygon: Sequence[Sequence[float]],
                      margin_m: float = SNAP_MARGIN_M) -> Tuple[float, float, bool]:
    """把点吸附到围栏内，返回 (lat, lng, 是否被移动)

    已经在围栏里、且离边界还有 margin_m 米以上 → 原样返回；
    落在围栏外（或贴着边）→ 先取边界最近点，再沿「边界点 → 质心」方向内推，
    停在第一个“确实在围栏内、且离边界够远”的位置上。
    围栏几何缺失（还没拉到）时不做任何修正——没有依据去改用户选的点。
    """
    if not polygon or len(polygon) < 3:
        return float(lat), float(lng), False
    if _inside_with_margin(lat, lng, polygon, margin_m):
        return float(lat), float(lng), False
    edge_lat, edge_lng, _ = closest_point_on_polygon(lat, lng, polygon)
    c_lat, c_lng = polygon_centroid(polygon)
    lo, hi = 0.0, 1.0
    for i in range(1, 41):
        t = i / 40.0
        if _inside_with_margin(edge_lat + (c_lat - edge_lat) * t,
                              edge_lng + (c_lng - edge_lng) * t, polygon, margin_m):
            hi = t
            break
        lo = t
    else:
        return c_lat, c_lng, True        # 凹陷/细长的围栏：退到质心
    for _ in range(24):                  # 再二分：大围栏上一步就是几十米，插值到贴着边界刚好够 margin
        mid = (lo + hi) / 2.0
        if _inside_with_margin(edge_lat + (c_lat - edge_lat) * mid,
                               edge_lng + (c_lng - edge_lng) * mid, polygon, margin_m):
            hi = mid
        else:
            lo = mid
    return (edge_lat + (c_lat - edge_lat) * hi,
            edge_lng + (c_lng - edge_lng) * hi, True)


# ══════════════════ 表 1：run_lat_lng ══════════════════
@dataclass
class RunLatLng:
    """轨迹点 —— 对应 @Entity(tableName="run_lat_lng")"""

    lat: float
    lng: float
    lat_lng_index: int = 0            # @JSONField("index")
    run_time: int = 0                 # @JSONField("runTime")   跑步内相对**秒**（原版 (int)Q0()）
    collect_time: int = 0             # @JSONField("collectTime") 采集绝对毫秒（原版 addressInfo.getTime()）
    create_time: int = 0              # 建表时 System.currentTimeMillis()（会上传）
    state: int = STATE_INIT           # @JSONField("state")  1 INIT / 2 UPLOADING / 4 FAIL / 8 SUCC
    off_fence_dis_m: int = 0          # @JSONField("offFenceDisM") 出围栏总距离；常态 -1（见 walker.W1 注释）

    # 会上传的物理量（原版无 serialize=false）
    accuracy: float = 6.0
    satellites: int = 10

    # 仅本地（serialize=false）
    speed: float = 0.0
    is_valid: bool = True
    is_uploaded: bool = False
    run_code: str = ""


    def to_upload_dict(self) -> Dict[str, Any]:
        return {
            "index": self.lat_lng_index,
            "lat": round(self.lat, 6),
            "lng": round(self.lng, 6),
            "runTime": self.run_time,
            "collectTime": self.collect_time,
            "createTime": self.create_time,
            "state": self.state,
            "offFenceDisM": self.off_fence_dis_m,
            "accuracy": round(self.accuracy, 2),
            "satellites": self.satellites,
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
            create_time=int(d.get("createTime", 0)),
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


# ══════════════════ 步幅段（原版是内存态，不是 Room 表）══════════════════
@dataclass
class StrideSegment:
    """对应原版 DataComponent.E0() 里现构的那个 HashMap

    原版不在本地建表：每跑满 strideStatisticsInterval 米就现算一段、立即上传。
    但 stride 段的 is_uploaded 在 Room 里没有对应列，所以原版实际上靠
    `lastSegmentStrideDistance` 基准推进——本项目落库只是为了能重放与导出。
    """

    stride_index: int = 0
    time_s: int = 0                # 段内耗时（秒，基点是上次切分的墙钟）
    stride_cm: float = 0.0         # 步幅（厘米，1 位小数）
    distance_m: int = 0            # 段内距离（米）
    step_count: int = 0            # 段内步数
    run_code: str = ""
    is_uploaded: bool = False

    @classmethod
    def from_dict(cls, d: Dict[str, Any], run_code: str = "") -> "StrideSegment":
        return cls(
            stride_index=int(d.get("index", 0)),
            time_s=int(d.get("time", 0)),
            stride_cm=float(d.get("stride", 0.0)),
            distance_m=int(d.get("distance", 0)),
            step_count=int(d.get("stepCount", 0)),
            run_code=d.get("runCode", run_code),
            is_uploaded=bool(d.get("isUploaded", False)),
        )
# ══════════════════ 上传报文构造 ══════════════════
def build_upload_pois(pts: Sequence[RunLatLng]) -> List[Dict[str, Any]]:
    return [p.to_upload_dict() for p in pts]


def build_pace_list(paces: Sequence[IntervalPace]) -> List[Dict[str, Any]]:
    return [p.to_upload_dict(p.pace_index) for p in paces]


def build_step_list(steps: Sequence[IntervalStep]) -> List[Dict[str, Any]]:
    return [s.to_upload_dict(s.step_index) for s in steps]


def build_stride_entry(stride) -> Dict[str, Any]:
    """原版 DataComponent.E0() 的 stride map（键名与类型照抄）

    stride 以**厘米**计、保留 1 位小数：
      stride = floor((段距离 * 100.0 / 段步数) * 10) / 10
    """
    return {
        "time": int(stride.time_s),
        "stride": round(float(stride.stride_cm), 1),
        "distance": int(stride.distance_m),
        "stepCount": int(stride.step_count),
        "index": int(stride.stride_index),
    }


def build_stride_list(stride) -> List[Dict[str, Any]]:
    """★ strideList 是**只含一个元素**的数组

    原版 km7.l() 里 `ArrayList arrayList = new ArrayList(1); arrayList.add(strideMap);`
    每次只上传刚封口的那一段，不是批量。
    """
    return [build_stride_entry(stride)]


def build_target_points(pts: Sequence[RunLatLng],
                        checkpoint_indices: Optional[Sequence[int]] = None
                        ) -> List[Dict[str, Any]]:
    """构造打卡点（uploadPassPoint / 结算的 targetPoints）的**参考实现**

    ★ 真正的报文字段以 store.checkpoint_targets 为准（它用服务端下发的
    桩点坐标，只有 passStatus/clockTime 会变）。这里只保留一个纯函数版本
    给单测与导出用，字段集必须与它逐字一致。

    ★ 原版类头是
      `@JSONType(includes = {"lat", "lng", "clockTime", "code", "passStatus"})`，
    所以 fastjson **只序列化这 5 个字段**——sort / nfcEnable / type /
    isClosingStatus / isInFence / isSensitiveFenceAdded / pointName /
    simpleName 全都被 includes 白名单排掉，一个都不许发。
    """
    if checkpoint_indices is None:
        n = len(pts)
        checkpoint_indices = [int(n * r) for r in (0.25, 0.5, 0.75)] if n > 4 else []
    out: List[Dict[str, Any]] = []
    for i, idx in enumerate(checkpoint_indices):
        if 0 <= idx < len(pts):
            p = pts[idx]
            out.append({"code": i, "lat": round(p.lat, 6), "lng": round(p.lng, 6),
                        "passStatus": bool(p.is_valid), "clockTime": p.collect_time})
    return out


def tail_points(pts: Sequence[RunLatLng], k: int = 4) -> List[Dict[str, Any]]:
    """最后 4 个点

    ★ 原版 pois 出现在两处：
      1. run/uploadRunRecord（km7.j，整张表一次发）；
      2. 结算报文——ApiDataComponent.J() 会把 state∈{1 INIT,4 FAIL} 且 valid
         的残留点作为 pois 塞进结算（`listB3` 非空才 put）。
    这里取尾部 k 个，只给导出/展示用。
    """
    return [p.to_upload_dict() for p in list(pts)[-k:]]


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
    # SchoolRule.totalDistance（米）：学校要求的总里程（学期目标）
    total_distance: float = 0.0
    # SchoolRule.dayMaxDistance（米）：每日最多计入成绩的里程；原版规则页（dw7.a）按 km 显示
    day_max_distance: float = 0.0
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
    gps_white_flag: bool = False            # SchoolRule.gpsWhiteFlag（DataComponent.D1()：H0 只看 gpsFilterAccuracy）

    @classmethod
    def from_rule(cls, rule: Optional[Dict[str, Any]]) -> "RuleSet":
        """从服务端返回的 SchoolRule 字典构造（字段名缺失时用默认值）"""
        r = cls()
        if not rule:
            return r
        r.single_min_distance = float(_first(rule, "singleMinDistance", default=r.single_min_distance))
        r.single_max_distance = float(_first(rule, "singleMaxDistance", default=r.single_max_distance))
        r.total_distance = float(_first(rule, "totalDistance", default=r.total_distance))
        r.day_max_distance = float(_first(rule, "dayMaxDistance", default=r.day_max_distance))
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
        r.gps_white_flag = bool(_first(rule, "gpsWhiteFlag", default=r.gps_white_flag))
        return r

    def to_dict(self) -> Dict[str, Any]:
        return {
            "singleMinDistance": self.single_min_distance,
            "singleMaxDistance": self.single_max_distance,
            "minPace": self.min_pace,
            "maxPace": self.max_pace,
            "segmentStrideAvg": self.segment_stride_avg,
            "totalDistance": self.total_distance,
            "dayMaxDistance": self.day_max_distance,
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
                 sport_type: int = SPORT_TYPE_SUN,
                 cheat_level: int = 0, white_flag: bool = False,
                 gps_white_flag: bool = False) -> RunValidity:
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

    # ② 分段步幅异常：原版 W0() 里这一项由 L1() 门控 —— 只有服务端下发的
    # cheatLevel 是 3/4（严查）且异常段数超限、又不是白名单（whiteFlag 或
    # SchoolRule.gpsWhiteFlag）时才加，普通学校即使步幅异常也不进本地列表。
    if (int(cheat_level) in (3, 4) and not white_flag and not gps_white_flag
            and stride_exception_segments > rule.segment_stride_exception_num):
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
      · 起点/终点都在围栏内，全程 offFenceDisM = -1（原版裸跑不进出围栏时的常态）
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
                run_time=int(round(i * self.sample_s)),
                collect_time=collect,
                create_time=collect,
                state=STATE_INIT,
                off_fence_dis_m=-1,
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
                run_time=int(round(i * self.sample_s)),
                collect_time=t0 + int(i * self.sample_s * 1000),
                create_time=t0 + int(i * self.sample_s * 1000),
                state=STATE_INIT,
                off_fence_dis_m=-1,
                accuracy=self.rng.uniform(3.0, 8.0),
                speed=round(m_per_s, 2),
                satellites=self.rng.randint(8, 14),
            ))
        return pts

    # ── 步频段（由仿真器产生的步数时间线切段）──
    def build_steps(self, step_timeline: Sequence[Tuple[int, int]],
                    start_ms: Optional[int] = None,
                    interval_s: int = STEP_INTERVAL_S) -> List[IntervalStep]:
        """把 (相对毫秒, 累计步数) 时间线切成固定时长段

        原版按 `Q0() % stepInterval == 0` 切（Q0() 是跑步内整秒），
        所以段长恒为 STEP_INTERVAL_S 秒、起止时间也是「跑步内秒」。
        """
        out: List[IntervalStep] = []
        seg_ms = int(interval_s * 1000)
        buf_start_t, buf_start_s = None, 0
        for idx, (rel_ms, cum_step) in enumerate(step_timeline):
            if buf_start_t is None:
                buf_start_t, buf_start_s = rel_ms, cum_step
            if rel_ms - buf_start_t >= seg_ms or idx == len(step_timeline) - 1:
                t_start = int(buf_start_t // 1000)
                t_end = int(rel_ms // 1000)
                out.append(IntervalStep(
                    start_step=buf_start_s,
                    end_step=cum_step,
                    start_time=t_start,
                    end_time=t_end,
                    step=max(0, cum_step - buf_start_s),
                    time=max(1, t_end - t_start),
                    step_index=len(out),
                ))
                buf_start_t, buf_start_s = rel_ms, cum_step
        return out

    # ── 步幅段 ──
    def build_strides(self, step_timeline: Sequence[Tuple[int, int]],
                      interval_m: int = STRIDE_STATISTICS_M) -> List[StrideSegment]:
        """每跑满 strideStatisticsInterval 米封一段步幅（原版 DataComponent.E0()）

        与服务端实测一致：strideStatisticsInterval 默认 100，实测 200。
        · 段距离 = 本段末累计距离 - 上段末累计距离
        · 段步数 = 本段末累计步数 - 上段末累计步数（由时间线插值）
        · stride = floor((段距离 * 100.0 / 段步数) * 10) / 10（厘米，1 位小数）
        """
        out: List[StrideSegment] = []
        total_m = float(self.distance)
        if total_m <= 0 or not step_timeline:
            return out
        span_ms = max(1, int(step_timeline[-1][0]))
        last_dist, last_step, last_ms = 0.0, 0, 0
        idx = 0
        while total_m - last_dist >= interval_m and idx < 500:
            cur_dist = last_dist + float(interval_m)
            fraction = min(1.0, cur_dist / total_m)
            cur_ms = int(round(span_ms * fraction))
            cur_step = self._steps_at(step_timeline, cur_ms)
            seg_dist = cur_dist - last_dist
            seg_steps = cur_step - last_step
            if seg_steps > 0:
                stride_cm = math.floor((seg_dist * 100.0 / seg_steps) * 10.0) / 10.0
                out.append(StrideSegment(
                    stride_index=idx,
                    time_s=max(0, int(round((cur_ms - last_ms) / 1000.0))),
                    stride_cm=float(stride_cm),
                    distance_m=int(round(seg_dist)),
                    step_count=int(seg_steps),
                ))
            last_dist, last_step, last_ms = cur_dist, cur_step, cur_ms
            idx += 1
        return out

    @staticmethod
    def _steps_at(timeline: Sequence[Tuple[int, int]], t_ms: int) -> int:
        """在 (相对毫秒, 累计步数) 时间线上线性插值"""
        prev_t, prev_s = timeline[0]
        for t, s in timeline:
            if t >= t_ms:
                if t == prev_t:
                    return int(s)
                ratio = (t_ms - prev_t) / float(t - prev_t)
                return int(round(prev_s + (s - prev_s) * ratio))
            prev_t, prev_s = t, s
        return int(timeline[-1][1])

    # ── 配速段 ──
    def generate_paces(self, start_ms: Optional[int] = None) -> List[IntervalPace]:
        """按 PACE_INTERVAL_M（原版 CommonConfig.paceInterval，默认 50 米）分段

        对齐 ApiDataComponent.T()：`distance` 是段内距离（endDistance - startDistance），
        时间字段是「跑步内秒」。
        """
        per_km_s = self.seconds / (self.distance / 1000.0)
        out: List[IntervalPace] = []
        cum_d, cum_s, cum_t = 0.0, 0, 0.0
        idx = 0
        while cum_d < self.distance and idx < 2000:
            seg_d = min(float(PACE_INTERVAL_M), self.distance - cum_d)
            seg_s = per_km_s * (seg_d / 1000.0) * self.rng.uniform(0.98, 1.02)
            seg_step = int(round(seg_d / self.stride))
            t_start = int(round(cum_t))
            t_end = int(round(cum_t + seg_s))
            out.append(IntervalPace(
                distance=int(round(seg_d)),
                start_distance=int(round(cum_d)),
                end_distance=int(round(cum_d + seg_d)),
                step_count=seg_step,
                start_step_count=cum_s,
                end_step_count=cum_s + seg_step,
                time=max(1, t_end - t_start),
                start_time=t_start,
                end_time=t_end,
                pace_index=idx,
            ))
            cum_d += seg_d
            cum_s += seg_step
            cum_t += seg_s
            idx += 1
        return out


def new_run_code(prefix: str = "SDLAB") -> str:
    """本地生成的 runRecordCode（离线模式下用；真实模式由服务端下发）"""
    return f"{prefix}{uuid.uuid4().hex[:16].upper()}"


# ══════════════════ 人脸检查点（报告二十四） ══════════════════
def face_snapshots_from_track(plan: Sequence[Dict[str, Any]],
                              pts: Sequence[RunLatLng]) -> List[Dict[str, Any]]:
    """按检查点里程从已生成轨迹里取「扫脸时刻」快照

    原版 DataComponent（:268-300、:918-928）：跑中每帧比对
    ``S0() >= faceCheckRecordList[i].randomDistance``，命中即记录
    popTime（弹出时刻 ms）/ checkDistance（当时累计里程 m）/
    checkLng / checkLat（当时坐标）。

    这里在轨迹生成后一次性回放：按点序累加 haversine 距离，
    每个检查点取「首个累计里程 >= randomDistance」的点作为快照。
    跑步里程没够到的检查点 → hasChecked=False，字段留空
    （原版未弹出的记录也是 null 字段，同样会随结算上送）。
    """
    snaps: List[Dict[str, Any]] = []
    if not plan or not pts:
        return snaps
    ordered = sorted(pts, key=lambda p: (p.run_time, p.lat_lng_index))
    cum = 0.0
    prev: Optional[RunLatLng] = None
    targets = sorted(plan, key=lambda r: int(r.get("randomDistance") or 0))
    queue = list(targets)
    for p in ordered:
        if prev is not None:
            cum += haversine(prev.lat, prev.lng, p.lat, p.lng)
        prev = p
        while queue and 0 < int(queue[0].get("randomDistance") or 0) <= int(cum):
            rec = queue.pop(0)
            snaps.append({
                "checkIndex": int(rec.get("checkIndex") or 0),
                "randomDistance": int(rec.get("randomDistance") or 0),
                "hasChecked": True,
                "popTime": int(p.collect_time),
                "checkDistance": int(round(cum)),
                "checkLng": float(p.lng),
                "checkLat": float(p.lat),
            })
    # 没够到的检查点：照原版语义上送 null 字段
    for rec in queue:
        snaps.append({
            "checkIndex": int(rec.get("checkIndex") or 0),
            "randomDistance": int(rec.get("randomDistance") or 0),
            "hasChecked": False,
            "popTime": None, "checkDistance": None,
            "checkLng": None, "checkLat": None,
        })
    snaps.sort(key=lambda s: s["checkIndex"])
    return snaps


def build_face_check_records(snapshots: Sequence[Dict[str, Any]],
                             run_face_img: str,
                             similarity_value: int,
                             face_model_type: int = 1,
                             body_enable: bool = False,
                             rng: Optional[random.Random] = None) -> List[Dict[str, Any]]:
    """构造结算报文的 faceCheckRecordList（SunshineRunFaceRecord 的线缆形态）

    逐行对齐原版（2026-10-24 二次核对）：
    · 序列化器是 fastjson，**null 字段默认不序列化**——c2() 只在非空时才 set，
      所以 faceRequestId / bodyRequestId / label / 错误码没值时**键都不出现**，
      不是发空串；未触发检查的记录只有 5 个键（见下）。
    · 布尔/整型原始类型恒序列化：hasChecked / finishFaceCheck / runFaceUpload
      / checkIndex / randomDistance 总在。
    · rate = DetectResultBean.detectRate = isSuccess ? 1.0f : 0.0f（DetectFaceDelegate.v），
      **不是活体置信度**；label 只有真实调过阿里云 DetectLivingFace 才有
      （detectLivingFace$2$a.b）——我们不调活体，省略 label。
    · extendParam 按模式分叉：
      - faceModelType=1（阿里云）：进度串拼接（DetectFaceDelegate.u 的 progressStr），
        成功路径 = "uploading->success->compare->success"（+ bodyEnable 时
        "->living->success"）。
      - faceModelType=2（本地）：RunFaceDetectStatus 的 fastjson 序列化（t()），
        键序按字母序；成功值：cameraStart=1、modelInit=0（FaceDetectAnalyzer.h 的
        `!k()?1:0` 反直觉但照抄）、baseImageDownload/baseImageParse=1、
        bestImageCapture=1、livenessCheck=bodyEnable?1:0、similarityCheck=1、
        uploadImage=1。
    · 唯一合成项：confidence（真值来自阿里云 CompareFace / InspireFace 比对，
      我们没有真摄像头与真调用，取 [阈值+5, min(97, 阈值+15)] 均匀分布——
      刚过阈值但不像同一张图比出来的 100 分）。
    """
    rng = rng or random.Random()
    lo = float(similarity_value) + 5.0
    hi = min(97.0, float(similarity_value) + 15.0)
    if hi <= lo:
        hi = lo + 2.0
    records: List[Dict[str, Any]] = []
    for s in snapshots:
        checked = bool(s.get("hasChecked"))
        # 恒序列化的 5 键（原始类型；见 c2/e2/f2 的赋值链）
        rec: Dict[str, Any] = {
            "checkIndex": int(s.get("checkIndex") or 0),
            "randomDistance": int(s.get("randomDistance") or 0),
            "hasChecked": checked,
            "finishFaceCheck": checked,
            "runFaceUpload": checked and bool(run_face_img),
        }
        if checked:
            # f2()：弹出时刻快照（对象包装类型，有值才序列化）
            rec["popTime"] = s.get("popTime")
            rec["checkDistance"] = s.get("checkDistance")
            rec["checkLng"] = s.get("checkLng")
            rec["checkLat"] = s.get("checkLat")
            if run_face_img:
                rec["runFaceImg"] = run_face_img
            # c2()：比对结果（DetectResultBean）
            rec["confidence"] = round(rng.uniform(lo, hi), 2)
            rec["rate"] = 1.0
            # e2()：过程参数按模式分叉
            if int(face_model_type) == 2:
                rec["extendParam"] = (
                    '{"baseImageDownload":1,"baseImageParse":1,'
                    '"bestImageCapture":1,"cameraStart":1,'
                    f'"livenessCheck":{1 if body_enable else 0},"modelInit":0,'
                    '"similarityCheck":1,"uploadImage":1}')
            else:
                ext = "uploading->success->compare->success"
                if body_enable:
                    ext += "->living->success"
                rec["extendParam"] = ext
        records.append(rec)
    return records
