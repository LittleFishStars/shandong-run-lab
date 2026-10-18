#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""离线 Mock 服务端：不联网也能把「登录 → 阳光跑 → 记录 → 上传」完整跑通

存在的理由：
  1. 调试 —— 真实服务端每一步都可能因为账号、风控、网络而失败，Mock 让链路
     本身可被反复验证（含**签名校验**：Mock 会像真服务端一样拒绝错误的 sign，
     这是 `run/uploadRunRecord` 独有的校验，见报告 15 的对照实验）；
  2. 回归 —— 协议实现改动后，可用 Mock 跑端到端自检，不消耗真实账号；
  3. 演示 —— GUI 里可以一键切换 mock / real 两种模式。

Mock 的行为刻意与真服务端**同构**：同样的路径、同样的请求头语义、同样的
返回码（0 成功 / 1516 未登录 / 1002 参数缺失），并额外对结算报文做规则校验，
从而让本地有效性判定（invalidType）也能被对照验证。

⚠️ 这是**本地进程内的假服务端**，只监听 127.0.0.1，不产生任何真实业务数据。
"""
from __future__ import annotations

import json
import random
import threading
import time
import urllib.parse
import uuid
from dataclasses import dataclass, field
from http.server import BaseHTTPRequestHandler, ThreadingHTTPServer
from typing import Any, Dict, List, Optional, Tuple

from . import crypto
from .captcha import synth_captcha
from .constants import (
    CODE_MISSING_PARAM,
    CODE_NEED_LOGIN,
    CODE_OK,
    SLIDER_MARGIN,
    SLIDER_OFFSET,
    SPORT_TYPE_SUN,
)
from .protocol import haversine, point_in_polygon

# ── Mock 世界：一所虚构学校 + 围栏 + 学期 + 计划 ──
MOCK_SCHOOL = {
    "schoolCode": "MOCK001",
    "schoolName": "示例大学（本地仿真）",
    "subSchoolCode": "",
    "subSchoolName": "",
}
MOCK_CENTER = (36.661_500, 117.026_500)     # 围栏中心
MOCK_FENCE_CODE = "FENCE_MOCK_001"


def _rect_polygon(lat: float, lng: float, half_m: float = 260.0) -> List[List[float]]:
    """以中心点为原点生成一个矩形围栏（经纬度顺序：[lat, lng]）"""
    import math

    dlat = half_m / 111_320.0
    dlng = half_m / (111_320.0 * math.cos(math.radians(lat)))
    return [[lat - dlat, lng - dlng], [lat - dlat, lng + dlng],
            [lat + dlat, lng + dlng], [lat + dlat, lng - dlng]]


@dataclass
class MockRun:
    run_code: str
    sport_type: int = SPORT_TYPE_SUN
    fence_code: str = MOCK_FENCE_CODE
    started_ms: int = 0
    points: List[Dict[str, Any]] = field(default_factory=list)
    admitted: int = 0          # 已被 uploadRunRecord 接收的点数
    pass_points: List[Dict[str, Any]] = field(default_factory=list)
    steps: List[Dict[str, Any]] = field(default_factory=list)
    paces: List[Dict[str, Any]] = field(default_factory=list)
    strides: List[Dict[str, Any]] = field(default_factory=list)
    finished: bool = False
    finish_result: Dict[str, Any] = field(default_factory=dict)
    sign_failures: int = 0


class MockWorld:
    """Mock 服务端的世界状态（内存）"""

    def __init__(self, bus=None, latency_ms: int = 0, fail_rate: float = 0.0,
                 verify_sign: bool = True, seed: int = 20261015):
        self.bus = bus
        self.latency_ms = latency_ms
        self.fail_rate = fail_rate          # 随机注入失败，用于测试重试/续传
        self.verify_sign = verify_sign
        self.rng = random.Random(seed)
        self.lock = threading.Lock()

        self.runs: Dict[str, MockRun] = {}
        self.sessions: Dict[str, Dict[str, Any]] = {}
        self.captchas: Dict[str, float] = {}     # token → 真实缺口 x
        self.records: List[Dict[str, Any]] = []  # 已结算的历史记录
        self.calls: List[Dict[str, Any]] = []

        self.fence = {
            "fenceCode": MOCK_FENCE_CODE,
            "fenceName": "示例围栏（本地仿真）",
            "schoolCode": MOCK_SCHOOL["schoolCode"],
            "schoolName": MOCK_SCHOOL["schoolName"],
            "subSchoolCode": "", "subSchoolName": "",
            "lat": MOCK_CENTER[0], "lng": MOCK_CENTER[1],
            "distance": 2000,
            "fenceList": [{"lat": p[0], "lng": p[1]} for p in _rect_polygon(*MOCK_CENTER)],
            "clockMode": 0,
            "openStatus": True,
            "requiredPointCounts": 3,
            "optionalPointCounts": 0,
            "optionalPointGoalCounts": 0,
            "totalGoalCounts": 3,
            "aliTapEnable": False,
            "aliTapPointList": [],
        }
        self.rule = {
            "singleMinDistance": 1000,
            "singleMaxDistance": 10000,
            "dayMaxDistance": 10000,
            "weekMaxDistance": 30000,
            "totalDistance": 200000,
            "dayMaxTimes": 3,
            "weekMaxTimes": 10,
            "weekMinTimes": 3,
            "totalTimes": 60,
            "maxFrequency": 5,
            "minFrequency": 1,
            "minPace": 150,            # 2'30"/km 最快
            "maxPace": 600,            # 10'00"/km 最慢
            "swingAmplitudeThreshold": 100,
            "segmentStrideAvg": 0.85,
            "segmentStrideExceptionNum": 5,
            "startDate": "2026-09-01",
            "endDate": "2027-01-15",
            "morningTimeFragment": ["06:00-08:00"],
            "suspendTime": 600000,
            "forbiddenWiFi": False,
            "gpsWhiteFlag": True,
            "clockModeList": [],
        }

    # ══════════════════ 路由 ══════════════════
    def handle(self, path: str, headers: Dict[str, str], body: Dict[str, Any]
               ) -> Dict[str, Any]:
        # 归一化路径：真实客户端会把 "run-front" 拼在 base_url 上，
        # 而路由表是按 "模块/接口" 登记的；同时剔掉可能存在的查询串。
        path = path.split("?", 1)[0].lstrip("/")
        for _prefix in ("run-front/", "api/", "v1/"):
            if path.startswith(_prefix):
                path = path[len(_prefix):]
                break
        with self.lock:
            self.calls.append({"path": path, "ts": int(time.time() * 1000),
                               "sign": headers.get("sign", "")})
        if self.latency_ms:
            time.sleep(self.latency_ms / 1000.0)
        if self.fail_rate and self.rng.random() < self.fail_rate and path != "captcha/get":
            return {"code": -1, "message": "模拟网络抖动（Mock 注入失败）", "data": None}

        handler = _ROUTES.get(path)
        if handler is None:
            return {"code": CODE_NEED_LOGIN, "message": f"未知路径 {path}", "data": None}
        try:
            return handler(self, path, headers, body)
        except Exception as e:  # Mock 自身异常也要以服务端语义返回
            return {"code": -1, "message": f"Mock 内部错误：{type(e).__name__}: {e}", "data": None}

    # ══════════════════ 工具 ══════════════════
    def emit(self, msg: str, level: str = "info") -> None:
        if self.bus:
            self.bus.emit("mock", msg, level=level)

    def check_sign(self, headers: Dict[str, str], body: Dict[str, Any]) -> bool:
        """像真服务端一样校验 sign（仅 uploadRunRecord 会调用）"""
        if not self.verify_sign:
            return True
        sign_value = headers.get("sign", "")
        if not sign_value or len(sign_value) != 108:
            self.emit("✗ Mock 拒绝：sign 缺失或长度不是 108（" + str(len(sign_value)) + "）", "warn")
            return False
        text = json.dumps(body, separators=(",", ":"), ensure_ascii=False)
        ok = crypto.verify_sign(text, sign_value)
        if not ok:
            self.emit("✗ Mock 拒绝：sign 校验不通过", "warn")
        return ok

    def require_login(self, headers: Dict[str, str]) -> bool:
        return bool(headers.get("Authorization"))


# ══════════════════ 各接口实现 ══════════════════
def _captcha_get(w: MockWorld, path: str, h: Dict[str, str], b: Dict[str, Any]):
    notch_x = w.rng.randint(90, 180)
    bg, tp, true_x = synth_captcha(notch_x=notch_x, seed=w.rng.randint(1, 99999))
    token = uuid.uuid4().hex[:32]
    w.captchas[token] = float(true_x)
    return {
        "code": CODE_OK, "message": "成功",
        "data": {
            "repData": {
                "token": token,
                "secretKey": uuid.uuid4().hex[:16],
                "originalImageBase64": _b64(bg),
                "jigsawImageBase64": _b64(tp),
                "captchaType": "blockPuzzle",
                "_trueNotchX": true_x,     # Mock 特有：便于调试面板直接对照
            },
            "token": token,
        },
    }


def _captcha_check(w: MockWorld, path: str, h: Dict[str, str], b: Dict[str, Any]):
    token = str(b.get("token", ""))
    if token not in w.captchas:
        return {"code": CODE_MISSING_PARAM, "message": "验证码已过期", "data": {"result": False}}
    pt = crypto.decrypt_slider_point(str(b.get("pointJson", "")))
    if not pt:
        return {"code": CODE_MISSING_PARAM, "message": "pointJson 无法解密",
                "data": {"result": False}}
    true_x = w.captchas[token]
    expected = int(true_x - SLIDER_MARGIN) + SLIDER_OFFSET
    got = float(pt.get("x", -999))
    ok = abs(got - expected) <= 3.0
    w.emit(f"{'✓' if ok else '✗'} Mock 校验滑块：提交 x={got} 期望 x={expected}"
           f"（真实缺口 {true_x:.0f}px）", "info" if ok else "warn")
    if ok:
        w.captchas.pop(token, None)
    return {"code": CODE_OK if ok else 1001, "message": "成功" if ok else "验证失败",
            "data": {"result": ok}}


def _login_check(w: MockWorld, path: str, h: Dict[str, str], b: Dict[str, Any]):
    phone = str(b.get("loginName", ""))
    if not phone:
        return {"code": CODE_MISSING_PARAM, "message": "手机号缺失", "data": None}
    return {"code": CODE_OK, "message": "成功",
            "data": {"phone": crypto.encrypt_field(phone), "exist": True}}


def _login_password(w: MockWorld, path: str, h: Dict[str, str], b: Dict[str, Any]):
    phone = str(b.get("loginName", ""))
    pwd = crypto.decrypt_field(str(b.get("password", "")))
    if not phone:
        return {"code": CODE_MISSING_PARAM, "message": "手机号缺失", "data": None}
    token = "mock-token-" + uuid.uuid4().hex[:24]
    satoken = "mock-satoken-" + uuid.uuid4().hex[:16]
    data = {
        "token": token, "satoken": satoken,
        "userId": "U" + uuid.uuid4().hex[:8].upper(),
        "userName": "本地仿真用户",
        "userType": 1,
        "schoolCode": MOCK_SCHOOL["schoolCode"],
        "schoolName": MOCK_SCHOOL["schoolName"],
        "phone": crypto.encrypt_field(phone),
        "pwdLen": len(pwd),                       # 便于核对字段加密是否解回明文
    }
    w.sessions[token] = data
    w.emit(f"✓ Mock 登录成功：userId={data['userId']} 密码解出长度={len(pwd)}")
    return {"code": CODE_OK, "message": "成功", "data": data}


def _user_info(w: MockWorld, path: str, h: Dict[str, str], b: Dict[str, Any]):
    if not w.require_login(h):
        return {"code": CODE_NEED_LOGIN, "message": "未登录", "data": None}
    return {"code": CODE_OK, "message": "成功", "data": {
        "userId": "UMOCK001", "userName": "本地仿真用户",
        "schoolCode": MOCK_SCHOOL["schoolCode"], "schoolName": MOCK_SCHOOL["schoolName"],
        "studentNo": "20260001", "sex": 2, "grade": "2026",
        "totalDistance": 128000, "totalTimes": 42,
    }}


def _semesters(w: MockWorld, path: str, h: Dict[str, str], b: Dict[str, Any]):
    return {"code": CODE_OK, "message": "成功", "data": [
        {"semesterCode": "SEM2026A", "semesterName": "2026-2027 第一学期", "current": True},
        {"semesterCode": "SEM2026B", "semesterName": "2026-2027 第二学期", "current": False},
    ]}


def _fence_list(w: MockWorld, path: str, h, b):
    return {"code": CODE_OK, "message": "成功", "data": [w.fence]}


def _fence_filter(w: MockWorld, path: str, h, b):
    return {"code": CODE_OK, "message": "成功",
            "data": {"usableList": [w.fence], "unusableList": []}}


def _sunrun_rule(w: MockWorld, path: str, h, b):
    return {"code": CODE_OK, "message": "成功", "data": w.rule}


def _run_abstract(w: MockWorld, path: str, h, b):
    return {"code": CODE_OK, "message": "成功", "data": {
        "minPace": w.rule["minPace"], "maxPace": w.rule["maxPace"],
        "segmentStrideAvg": w.rule["segmentStrideAvg"],
        "singleMinDistance": w.rule["singleMinDistance"],
        "singleMaxDistance": w.rule["singleMaxDistance"],
        "weekMinTimes": w.rule["weekMinTimes"],
        "doneTimes": len([r for r in w.records if r.get("status") == 1]),
    }}


def _sunrun_config(w: MockWorld, path: str, h, b):
    return {"code": CODE_OK, "message": "成功", "data": {
        "fenceCode": b.get("fenceCode", MOCK_FENCE_CODE),
        "targetDistance": b.get("targetDistance", "2000"),
        "schoolRule": w.rule,
        "geoFenceDetail": w.fence,
        "faceImg": "",           # 非空表示需要人脸核验
        "faceEnabled": 0,
        "runScene": 1,
    }}


def _plan_list(w, path, h, b):
    return {"code": CODE_OK, "message": "成功", "data": [
        {"runPlanCode": "PLAN_DAILY", "runPlanName": "日常锻炼", "distance": 2000},
    ]}


def _start_sun_run(w: MockWorld, path: str, h, b):
    if not w.require_login(h):
        return {"code": CODE_NEED_LOGIN, "message": "未登录", "data": None}
    code = "MCK" + uuid.uuid4().hex[:14].upper()
    fence_code = str(b.get("fenceCode", MOCK_FENCE_CODE))
    # 校验经纬度是否落在围栏内（与客户端一致：起跑点必须在围栏内）
    lat, lng = float(b.get("lat", 0) or 0), float(b.get("lng", 0) or 0)
    poly = [[p["lat"], p["lng"]] for p in w.fence["fenceList"]]
    in_fence = point_in_polygon(lat, lng, poly) if lat and lng else True
    w.runs[code] = MockRun(run_code=code, sport_type=int(b.get("sportType", SPORT_TYPE_SUN)),
                           fence_code=fence_code, started_ms=int(time.time() * 1000))
    w.emit(f"✓ Mock 开跑成功：runRecordCode={code}"
           f"（起点{'' if in_fence else '不'}在围栏内）", "info" if in_fence else "warn")
    return {"code": CODE_OK, "message": "成功", "data": {
        "runRecordCode": code,
        "startTime": int(time.time() * 1000),
        "targetPoints": _mock_target_points(w),
        "inFence": in_fence,
    }}


def _mock_target_points(w: MockWorld) -> List[Dict[str, Any]]:
    """围栏内均匀取 3 个必经点（客户端由围栏与 clockMode 决定）"""
    poly = _rect_polygon(*MOCK_CENTER, half_m=200.0)
    pts = []
    for i, (la, ln) in enumerate(poly[:3]):
        pts.append({"index": i, "lat": la, "lng": ln, "required": True})
    return pts


def _upload_record(w: MockWorld, path: str, h, b):
    """★ 唯一校验 sign 的接口"""
    if not w.check_sign(h, b):
        return {"code": 1003, "message": "签名校验失败", "data": None}
    code = str(b.get("runRecordCode", ""))
    run = w.runs.get(code)
    if run is None:
        return {"code": CODE_MISSING_PARAM, "message": "runRecordCode 无效", "data": None}
    pois = b.get("pois") or []
    start = len(run.points)
    run.points.extend(pois)
    run.admitted = len(run.points)
    idx_list = list(range(0, len(pois)))     # 服务端返回的「已接收索引」
    w.emit(f"✓ Mock 已接收轨迹 {len(pois)} 点（累计 {run.admitted}），返回 indexList={idx_list[:8]}"
           + ("…" if len(idx_list) > 8 else ""))
    return {"code": CODE_OK, "message": "成功", "data": {
        "indexList": idx_list, "total": run.admitted,
    }}


def _upload_passpoint(w: MockWorld, path: str, h, b):
    code = str(b.get("runRecordCode", ""))
    run = w.runs.get(code)
    if run is None:
        return {"code": CODE_MISSING_PARAM, "message": "runRecordCode 无效", "data": None}
    tps = b.get("targetPoints") or []
    run.pass_points.extend(tps)
    w.emit(f"✓ Mock 已接收打卡点 {len(tps)} 个")
    return {"code": CODE_OK, "message": "成功", "data": {"passedCount": len(run.pass_points)}}


def _upload_pace(w: MockWorld, path: str, h, b):
    code = str(b.get("runRecordCode", ""))
    run = w.runs.get(code)
    if run is None:
        return {"code": CODE_MISSING_PARAM, "message": "runRecordCode 无效", "data": None}
    paces = b.get("paceList") or []
    run.paces.extend(paces)
    return {"code": CODE_OK, "message": "成功", "data": {"indexList": list(range(len(paces)))}}


def _upload_step(w: MockWorld, path: str, h, b):
    code = str(b.get("runRecordCode", ""))
    run = w.runs.get(code)
    if run is None:
        return {"code": CODE_MISSING_PARAM, "message": "runRecordCode 无效", "data": None}
    steps = b.get("stepList") or []
    run.steps.extend(steps)
    return {"code": CODE_OK, "message": "成功", "data": {"indexList": list(range(len(steps)))}}


def _upload_stride(w: MockWorld, path: str, h, b):
    code = str(b.get("runRecordCode", ""))
    run = w.runs.get(code)
    if run is None:
        return {"code": CODE_MISSING_PARAM, "message": "runRecordCode 无效", "data": None}
    run.strides.extend(b.get("strideList") or [])
    return {"code": CODE_OK, "message": "成功", "data": True}


def _finish_sun_run(w: MockWorld, path: str, h, b):
    """结算：Mock 在这里按 SchoolRule 做一次真实服务端式的判定"""
    code = str(b.get("runRecordCode", ""))
    run = w.runs.get(code)
    if run is None:
        return {"code": CODE_MISSING_PARAM, "message": "runRecordCode 无效", "data": None}

    distance = float(b.get("distance") or b.get("dis") or 0)
    duration = int(float(b.get("duration") or 0))
    total_step = int(float(b.get("totalStep") or 0))
    pace = duration / (distance / 1000.0) if distance > 0 else 0.0

    problems: List[Dict[str, Any]] = []
    r = w.rule
    if distance < float(r["singleMinDistance"]):
        problems.append({"type": 2, "name": "距离不足",
                         "detail": f"未完成 {r['singleMinDistance'] / 1000.0:.1f} 公里"})
    if pace and r["minPace"] > 0 and pace < float(r["minPace"]):
        problems.append({"type": 3, "name": "配速越界", "detail": "配速过快"})
    if pace and r["maxPace"] > 0 and pace > float(r["maxPace"]):
        problems.append({"type": 3, "name": "配速越界", "detail": "配速过慢"})
    # 必经点数量写在围栏对象上（不是 SchoolRule），两处都兼容一下
    need = int(w.fence.get("requiredPointCounts") or r.get("requiredPointCounts") or 3)
    if len(run.pass_points) < need:
        problems.append({"type": 1, "name": "打卡点缺失",
                         "detail": f"必经点 {len(run.pass_points)}/{need}"})

    # 轨迹是否越出围栏（用真实几何判定，而不是信任客户端上报的 offFenceDisM）
    poly = [[p["lat"], p["lng"]] for p in w.fence["fenceList"]]
    outside = 0
    for p in run.points:
        if not point_in_polygon(float(p.get("lat", 0)), float(p.get("lng", 0)), poly):
            outside += 1
    if outside > max(3, len(run.points) // 20):
        problems.append({"type": 25, "name": "GPS 异常",
                         "detail": f"有 {outside} 个轨迹点在围栏外"})

    # 客户端声明的 runImgRecord 必须与 Mock 算出来的一致（防篡改码）
    ts = str(b.get("timestamp", ""))
    # env 不进报文（原版是编译期常量 l43.b()），两边都用默认 0 → 生产密钥
    expect_img = crypto.run_img_record(code, ts, str(b.get("buildVersion", "")),
                                       str(b.get("appVersion", "")))
    claimed = str(b.get("runImgRecord", ""))
    img_ok = (not claimed) or claimed == expect_img
    if claimed and not img_ok:
        problems.append({"type": 58, "name": "分段步频距离异常",
                         "detail": "runImgRecord 与本地重算不一致"})

    status = 1 if not problems else 0
    run.finished = True
    run.finish_result = {
        "status": status, "problems": problems,
        "distance": distance, "duration": duration, "pace": round(pace, 1),
        "points": len(run.points), "admitted": run.admitted,
    }
    record = {
        "runRecordCode": code, "sportType": run.sport_type,
        "distance": distance, "duration": duration, "totalStep": total_step,
        "pace": round(pace, 1), "status": status,
        "invalidReasons": problems, "endTime": int(time.time() * 1000),
        "pointCount": len(run.points), "checkpoints": len(run.pass_points),
    }
    w.records.append(record)
    w.emit(f"{'✓' if status == 1 else '⚠'} Mock 结算：{distance:.0f} 米 / {duration}s / "
           f"{pace:.1f} s/km / 轨迹 {len(run.points)} 点 → status={status}"
           + (f" 问题：{[p['name'] for p in problems]}" if problems else ""),
           "info" if status == 1 else "warn")
    return {"code": CODE_OK, "message": "成功", "data": {
        "status": status, "runRecordCode": code,
        "invalidReasons": problems, "record": record,
    }}


def _query_sunrun_list(w: MockWorld, path: str, h, b):
    page = int(b.get("pageNum", 1) or 1)
    size = int(b.get("pageSize", 10) or 10)
    items = sorted(w.records, key=lambda r: r["endTime"], reverse=True)
    return {"code": CODE_OK, "message": "成功", "data": {
        "total": len(items), "pageNum": page, "pageSize": size,
        "list": items[(page - 1) * size: page * size],
    }}


def _query_summary(w: MockWorld, path: str, h, b):
    valid = [r for r in w.records if r["status"] == 1]
    return {"code": CODE_OK, "message": "成功", "data": {
        "totalDistance": round(sum(r["distance"] for r in valid), 1),
        "totalTimes": len(valid),
        "totalDuration": sum(r["duration"] for r in valid),
        "totalStep": sum(r["totalStep"] for r in valid),
        "weekDistance": round(sum(r["distance"] for r in valid), 1),
    }}


def _rank_distance(w: MockWorld, path: str, h, b):
    return {"code": CODE_OK, "message": "成功", "data": {
        "myRank": 12, "myValue": 12800,
        "list": [{"rank": i + 1, "userName": f"同学{i + 1:02d}", "value": 30000 - i * 900}
                 for i in range(10)],
    }}


# ── 新增：真实服务端已有的辅助接口 ──
def _get_config(w: MockWorld, path: str, h, b):
    """GET common/getConfig：返回与真实服务端同结构的运行参数。

    数值取自 2026-10 对 api.huachenjie.com 的实测响应。
    """
    return {"code": 0, "message": "成功", "data": {
        "runFilterAccuracy": 30, "freeRunFilterAccuracy": 75, "startRunAccuracy": 50,
        "poiInterval": 15, "validDistance": 25, "sensitiveDistance": 45,
        "paceInterval": 50, "paceAbnormalTime": 120, "autoStopDuration": 120,
        "singlePointAward": 20, "amapGPSLevel": 3, "strideStatisticsInterval": 200,
        "materialToEnergy": 2, "adIntervalDuration": 5, "gpsAbnormalMaxTimes": 3,
        "gpsFilterAccuracy": 150, "captchaEnable": True, "kyyShieldSwitch": True,
        "slogan": "一起闪动，为自己想要的样子",
    }}


def _sync_time(w: MockWorld, path: str, h, b):
    """GET common/syncTime：真实响应 data.serverTime 为毫秒字符串"""
    return {"code": 0, "message": "成功",
            "data": {"serverTime": str(int(time.time() * 1000))}}


def _mock_nfc_status(w: MockWorld, path: str, h, b):
    return {"code": 0, "message": "成功", "data": {"status": 0}}


def _logout(w: MockWorld, path: str, h, b):
    return {"code": 0, "message": "成功", "data": None}


def _not_found(w, path: str, h, b):
    return {"code": CODE_NEED_LOGIN, "message": f"Mock 未实现该接口：{path}", "data": None}


# 路由表键 = 真实路径（已剔掉 run-front/ 前缀）；同时保留早期报告里的旧路径作别名，
# 兼容历史脚本与旧版客户端。
_ROUTES = {
    "captcha/get": _captcha_get,
    "captcha/check": _captcha_check,
    "auth/loginCheck": _login_check,
    "auth/loginPassword": _login_password,
    "account/sendAuthCode": _login_check,          # 短信下发（Mock 用同一套语义）
    "account/login_v3": _login_password,
    "account/logout": _logout,
    "common/getConfig": _get_config,
    "common/syncTime": _sync_time,
    "account/queryCommonUserInfo": _user_info,
    "attend/semesterSelector": _semesters,
    "school/querySchoolFences": _fence_list,
    "school/filterUsableFence": _fence_filter,
    "run/querySunRunAbstractInfoV2": _run_abstract,
    "run/checkSunRunConfig": _sunrun_config,
    "run/getPreRunCheckIn": _sunrun_config,
    "run/plan/selectList": _plan_list,
    "run/startSunRun_v2": _start_sun_run,
    "run/startFreeRun": _start_sun_run,
    "run/resume": _start_sun_run,
    "run/queryUnFinishRun": _not_found,
    "run/uploadRunRecord": _upload_record,
    "run/uploadPassPoint": _upload_passpoint,
    "run/uploadPaceRecord": _upload_pace,
    "run/uploadStepsRecord": _upload_step,
    "run/uploadStrideRecord": _upload_stride,
    "run/finishSunRun_v2": _finish_sun_run,
    "run/finishFreeRun": _finish_sun_run,
    "run/nfc/verification-status": _mock_nfc_status,
    "run/querySchoolRunSummary": _query_summary,
    "run/queryRunRecordCount": _query_summary,
    "run/runRecordDetail": _query_summary,
    "run/free/detail": _query_summary,
    "run/pageSunRunRecord": _query_sunrun_list,
    "run/pageFreeRunRecordList": _query_sunrun_list,
    "run/listUserReward": _not_found,
    "rank/distance": _rank_distance,
    "rank/runProgress": _rank_distance,
    # ── 旧路径别名（早期报告，已不存在于 v8.7.7）──
    "run/querySunRunRule": _sunrun_rule,
    "run/querySunRunList": _query_sunrun_list,
    "run/queryRunSummary": _query_summary,
}


# ══════════════════ HTTP 外壳 ══════════════════
class _Handler(BaseHTTPRequestHandler):
    world: MockWorld  # 由 MockServer 注入
    server_version = "ShandongMock/1.0"

    def log_message(self, fmt: str, *args: Any) -> None:  # 静默，避免刷屏
        pass

    def do_POST(self) -> None:  # noqa: N802
        path = self.path.lstrip("/")
        length = int(self.headers.get("Content-Length", "0") or 0)
        raw = self.rfile.read(length) if length else b""
        try:
            body = json.loads(raw.decode("utf-8")) if raw else {}
        except Exception:
            body = {}
        headers = {k: v for k, v in self.headers.items()}
        res = self.world.handle(path, headers, body)
        payload = json.dumps(res, ensure_ascii=False).encode("utf-8")
        self.send_response(200)
        self.send_header("Content-Type", "application/json; charset=utf-8")
        self.send_header("Content-Length", str(len(payload)))
        self.end_headers()
        self.wfile.write(payload)

    def do_GET(self) -> None:  # noqa: N802
        """GET 接口（common/getConfig、common/syncTime）走同一套路由。"""
        path, _, query = self.path.lstrip("/").partition("?")
        body = {k: v[0] for k, v in urllib.parse.parse_qs(query).items()} if query else {}
        headers = {k: v for k, v in self.headers.items()}
        res = self.world.handle(path, headers, body)
        payload = json.dumps(res, ensure_ascii=False).encode("utf-8")
        self.send_response(200)
        self.send_header("Content-Type", "application/json; charset=utf-8")
        self.send_header("Content-Length", str(len(payload)))
        self.end_headers()
        self.wfile.write(payload)


class MockServer:
    """本地 Mock 服务端（127.0.0.1，可选端口）

    用法：
        srv = MockServer(world)
        srv.start()          # 启动后台线程
        print(srv.base_url)  # http://127.0.0.1:<port>/run-front
        srv.stop()
    """

    def __init__(self, world: Optional[MockWorld] = None, host: str = "127.0.0.1",
                 port: int = 0):
        self.world = world or MockWorld()
        self.host = host
        self.port = port
        self._httpd: Optional[ThreadingHTTPServer] = None
        self._thread: Optional[threading.Thread] = None

    def start(self) -> str:
        handler = type("_BoundHandler", (_Handler,), {"world": self.world})
        self._httpd = ThreadingHTTPServer((self.host, self.port), handler)
        self._httpd.daemon_threads = True
        self.port = self._httpd.server_address[1]
        self._thread = threading.Thread(target=self._httpd.serve_forever,
                                        name="mock-server", daemon=True)
        self._thread.start()
        self.world.emit(f"✓ Mock 服务端已启动：{self.base_url}")
        return self.base_url

    def stop(self) -> None:
        if self._httpd:
            self._httpd.shutdown()
            self._httpd.server_close()
            self._httpd = None
        if self._thread:
            self._thread.join(timeout=3)
            self._thread = None

    @property
    def base_url(self) -> str:
        return f"http://{self.host}:{self.port}/run-front"

    @property
    def api_root(self) -> str:
        """不带 /run-front 的根地址（captcha 接口用它）"""
        return f"http://{self.host}:{self.port}"


def _b64(raw: bytes) -> str:
    import base64

    return base64.b64encode(raw).decode("ascii")
