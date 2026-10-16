#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""业务门面：把协议、传输、记录、仿真串成一条完整链路

对外只暴露「登录 → 阳光跑 → 数据记录 → 数据上传」四类能力，
GUI 与 CLI 都只跟这一层打交道。

对齐客户端行为的关键点：
  · token/satoken 双凭据、deviceId 持久化（report 07 §2）
  · 开跑九参数顺序（schoolCode, fenceCode, activityCode, lat, lng,
    minRunDis, useCreditSword, runPlanCode, sportType）
  · **只有 uploadRunRecord 带 sign**，结算报文里 distance 与 dis 双写
  · 服务端回 indexList → 本地按段标记 SUCC / FAIL → 断点续传
"""
from __future__ import annotations

import time
from typing import Any, Dict, List, Optional, Sequence, Tuple

from . import crypto, protocol
from .captcha import CaptchaSolver
from .constants import (
    CHECKPOINT_HIT_RADIUS_M,
    CODE_OK,
    EP,
    DEFAULT_UPLOAD_BATCH,
    PACE_INTERVAL_M,
    POI_UPLOAD_MIN_POINTS,
    SEGMENT_UPLOAD_MIN,
    SPORT_TYPE_SUN,
    STATE_FAIL,
    STATE_INIT,
    STATE_SUCC,
    STATE_UPLOADING,
    STEP_INTERVAL_S,
    STRIDE_STATISTICS_M,
)
from .net import Transport
from .protocol import (
    IntervalPace,
    IntervalStep,
    RunLatLng,
    RuleSet,
    build_pace_list,
    build_step_list,
    build_stride_list,
    build_target_points,
    tail_points,
)
from .store import RecordStore

KV_TOKEN = "session"


class ShandongClient:
    """闪动校园业务客户端（mock / real 双模）"""

    def __init__(self, config: Dict[str, Any], bus=None, store: Optional[RecordStore] = None,
                 base_url: Optional[str] = None, local_mode: bool = False):
        self.cfg = config
        self.bus = bus
        self.store = store or RecordStore(_db_path(config))
        self.transport = Transport(config, bus=bus, store=self.store, base_url=base_url)
        self.captcha = CaptchaSolver(self.transport, bus=bus)
        self.rule = RuleSet()
        self.fence: Dict[str, Any] = {}
        self.fences: List[Dict[str, Any]] = []
        self.semesters: List[Dict[str, Any]] = []
        self.run_plans: List[Dict[str, Any]] = []
        self.abstract: Dict[str, Any] = {}
        self.common: Dict[str, Any] = {}     # 服务端 common/getConfig 原始返回
        self.user: Dict[str, Any] = {}
        self.logged_in = False
        # True = 走本地 Mock 服务端。会话按模式分开存，否则 Mock 的假 token
        # 会被带到真实模式里发给 api.huachenjie.com，一直莫名其妙的 1516。
        self.local_mode = bool(local_mode)
        self.kv_token_key = KV_TOKEN + ("_mock" if self.local_mode else "")
        self._load_session()

    # ══════════════════ 会话 ══════════════════
    def _cfg_set(self, key: str, value: Any) -> None:
        """写配置——兼容 ConfigStore 与普通 dict 两种 cfg 载体"""
        if hasattr(self.cfg, "set"):
            self.cfg.set(key, value)
        else:
            self.cfg[key] = value

    def _load_session(self) -> None:
        s = self.store.kv_get(self.kv_token_key) or {}
        if isinstance(s, dict) and s.get("token"):
            self.transport.token = str(s.get("token", ""))
            self.transport.satoken = str(s.get("satoken", ""))
            self.transport.school_code = str(s.get("schoolCode", ""))
            self.transport.user_id = str(s.get("userId", ""))
            self.logged_in = True
            self.user = s

    def _save_session(self, data: Dict[str, Any]) -> None:
        keep = {
            "token": str(data.get("token", "")),
            "satoken": str(data.get("satoken", "")),
            "userId": str(data.get("userId", "")),
            "schoolCode": str(data.get("schoolCode", "")),
            "schoolName": str(data.get("schoolName", "")),
            "userName": str(data.get("userName", "")),
            "userType": data.get("userType", 1),
            "deviceId": self.transport.device_id,
            "loginAt": int(time.time() * 1000),
        }
        self.transport.token = keep["token"]
        self.transport.satoken = keep["satoken"]
        self.transport.school_code = keep["schoolCode"]
        self.transport.user_id = keep["userId"]
        self.logged_in = bool(keep["token"])
        self.user = keep
        self.store.kv_set(self.kv_token_key, keep)

    def logout(self) -> None:
        try:
            if self.logged_in:
                self.transport.post("logout", self.transport.base_payload(), need_sign=False)
        except Exception:
            pass
        self.transport.reset_session()
        self.store.kv_delete(self.kv_token_key)
        self.logged_in = False
        self.user = {}
        if self.bus:
            self.bus.emit("state", "已退出登录")

    # ══════════════════ 登录链路 ══════════════════
    def login_check(self, phone: str) -> Dict[str, Any]:
        """① 手机号预检：服务端回显 AES 加密手机号（可用来校验字段加密）"""
        return self.transport.post("login_check",
                                   self.transport.base_payload({"loginName": phone}))

    def get_captcha(self) -> Optional[Dict[str, Any]]:
        """② 取滑块验证码"""
        return self.captcha.get()

    def solve_captcha(self, data: Optional[Dict[str, Any]] = None
                      ) -> Tuple[bool, Optional[str]]:
        """③ 求解并校验滑块；返回 (是否通过, pointJson)"""
        if data:
            ok, point, _x = self.captcha.solve(data)
            if ok and point and self.captcha.check(str(data.get("token", "")), point):
                return True, point
        # 单次失败后用 run() 重取挑战重试（check 会消耗 token，不能原地重试坐标）
        ok, point, _d = self.captcha.run(attempts=3)
        return bool(ok and point), point

    def login(self, phone: str, password: str, captcha_point: str = "",
              do_captcha: bool = True) -> Dict[str, Any]:
        """④ 密码登录（含完整前置链路）"""
        if self.bus:
            self.bus.emit("state", f"开始登录：{_mask(phone)}")
        check = self.login_check(phone)
        if check.get("code") != CODE_OK:
            return {"code": check.get("code", -1),
                    "message": f"预检失败：{check.get('message')}", "data": None}
        if do_captcha:
            data = self.get_captcha()
            if data:
                _ok, point = self.solve_captcha(data)
                captcha_point = point or captcha_point
            else:
                if self.bus:
                    self.bus.emit("log", "验证码获取失败，直接尝试登录（部分环境可跳过）",
                                  level="warn")
        payload = self.transport.base_payload({
            "loginName": phone,
            "password": crypto.encrypt_password(password),
            "captchaPoint": captcha_point or "",
        })
        res = self.transport.post("login_password", payload)
        if res.get("code") == CODE_OK and res.get("data"):
            self._save_session(res["data"])
            if self.bus:
                self.bus.emit("state", f"登录成功：{self.user.get('userName', '')}"
                                      f"（{self.user.get('schoolName', '')}）")
        elif self.bus:
            self.bus.emit("state", f"登录失败：{res.get('message')}", level="error") \
                if hasattr(self.bus, "emit") else None
        return res

    # ══════════════════ 用户与学校 ══════════════════
    def load_user(self) -> Dict[str, Any]:
        res = self.transport.post("user_info", self.transport.base_payload())
        if res.get("code") == CODE_OK and res.get("data"):
            self.user = {**self.user, **res["data"]}
            self.transport.school_code = str(res["data"].get("schoolCode",
                                                             self.transport.school_code))
        return res

    def load_semesters(self) -> Dict[str, Any]:
        res = self.transport.post("semesters", self.transport.base_payload())
        self.semesters = (res.get("data") or []) if isinstance(res.get("data"), list) else \
            ((res.get("data") or {}).get("list") or [])
        return res

    # ══════════════════ 围栏与规则 ══════════════════
    def load_fences(self, school_code: str = "") -> Dict[str, Any]:
        payload = self.transport.base_payload(
            {"schoolCode": school_code or self.transport.school_code})
        res = self.transport.post("fence_list", payload)
        data = res.get("data")
        if isinstance(data, list):
            self.fences = data
        elif isinstance(data, dict):
            self.fences = data.get("list") or data.get("fenceList") or []
        else:
            self.fences = []
        if self.fences:
            self.fence = self.fences[0]
        return res

    def load_rule(self, fence_code: str = "", semester_code: str = "") -> Dict[str, Any]:
        """拉取 SchoolRule 并转成判定用的 RuleSet"""
        res = self.transport.post("sunrun_config", self.transport.base_payload({
            "fenceCode": fence_code or self.fence.get("fenceCode", ""),
            "targetDistance": str(int(self.cfg.get("run", {}).get("target_distance_m", 2000))),
            "semesterCode": semester_code,
        }))
        data = res.get("data") or {}
        rule = data.get("schoolRule") if isinstance(data.get("schoolRule"), dict) else data
        self.rule = RuleSet.from_rule(rule)
        if isinstance(data.get("geoFenceDetail"), dict) and data["geoFenceDetail"]:
            self.fence = data["geoFenceDetail"]
        if self.bus:
            self.bus.emit("state", "已加载学校规则："
                          f"单次 {self.rule.single_min_distance:.0f}–"
                          f"{self.rule.single_max_distance:.0f} 米，"
                          f"配速 {self.rule.min_pace:.0f}–{self.rule.max_pace:.0f} 秒/公里，"
                          f"必经点 {self.rule.required_point_counts} 个")
        return res

    def load_sunrun_rule(self, run_plan_code: str = "", semester_code: str = "") -> Dict[str, Any]:
        """阳光跑规则。

        v8.7.7 里**没有** `run/querySunRunRule`；规则参数由 `common/getConfig`
        （见 load_common_config）与 `run/querySunRunAbstractInfoV2` 提供，
        这里改走 abstract 接口，并先刷新全局配置。
        """
        self.load_common_config()
        res = self.transport.post("sunrun_abstract", self.transport.base_payload({
            "runPlanCode": run_plan_code, "semesterCode": semester_code,
        }))
        data = res.get("data")
        if isinstance(data, dict) and data:
            self.rule = RuleSet.from_rule(data)
        return res

    def load_common_config(self) -> Dict[str, Any]:
        """拉取服务端真实运行参数（GET common/getConfig）并写入 cfg。

        服务端实测值（2026-10 拉取）：runFilterAccuracy=30（APK 默认 50）、
        gpsFilterAccuracy=150、gpsAbnormalMaxTimes=3（默认 4）、
        strideStatisticsInterval=200（默认 100）、poiInterval=15、
        validDistance=25、sensitiveDistance=45、paceInterval=50、
        paceAbnormalTime=120、captchaEnable=true、kyyShieldSwitch=true。
        注意：响应里**没有** stepInterval，故步频段周期仍取 APK 默认 20 秒。
        """
        res = self.transport.post("common_config")
        data = res.get("data")
        if isinstance(data, dict) and data:
            self.common = data
            keep = dict(self.cfg.get("common", {}) or {})
            keep.update(data)
            self._cfg_set("common", keep)
            if self.bus:
                self.bus.emit("log", "服务端运行参数：精度过滤 "
                              f"{data.get('runFilterAccuracy')}m、打卡半径 "
                              f"{data.get('validDistance')}m、配速段 "
                              f"{data.get('paceInterval')}m、"
                              f"验证码 {'开' if data.get('captchaEnable') else '关'}")
        return res

    def load_sunrun_abstract(self, semester_code: str = "") -> Dict[str, Any]:
        res = self.transport.post("sunrun_abstract", self.transport.base_payload({
            "semesterCode": semester_code,
        }))
        self.abstract = res.get("data") or {}
        return res

    def load_plans(self, semester_code: str = "") -> Dict[str, Any]:
        res = self.transport.post("plan_list", self.transport.base_payload({
            "semesterCode": semester_code,
        }))
        data = res.get("data")
        self.run_plans = data if isinstance(data, list) else ((data or {}).get("list") or [])
        return res

    def fence_polygon(self) -> List[List[float]]:
        """围栏多边形顶点，转成 [[lat, lng], ...]"""
        raw = self.fence.get("fenceList") or self.fence.get("points") or []
        out: List[List[float]] = []
        for p in raw:
            if isinstance(p, dict):
                out.append([float(p.get("lat", 0)), float(p.get("lng", 0))])
            elif isinstance(p, (list, tuple)) and len(p) >= 2:
                out.append([float(p[0]), float(p[1])])
        return out

    def fence_center(self) -> Tuple[float, float]:
        poly = self.fence_polygon()
        if poly:
            return protocol.polygon_centroid(poly)
        return float(self.fence.get("lat", 0.0)), float(self.fence.get("lng", 0.0))

    # ══════════════════ 开跑 ══════════════════
    def start_sun_run(self, fence_code: str = "", activity_code: str = "",
                      lat: float = 0.0, lng: float = 0.0, min_run_dis: float = 0.0,
                      use_credit_sword: bool = False, run_plan_code: str = "",
                      sport_type: int = SPORT_TYPE_SUN,
                      school_code: str = "") -> Dict[str, Any]:
        """开跑（九参数顺序与客户端一致）"""
        if not lat or not lng:
            lat, lng = self.fence_center()
        if not min_run_dis:
            min_run_dis = float(self.cfg.get("run", {}).get("target_distance_m", 2000))
        payload = self.transport.base_payload({
            "schoolCode": school_code or self.transport.school_code,
            "fenceCode": fence_code or self.fence.get("fenceCode", ""),
            "activityCode": activity_code,
            "lat": lat, "lng": lng,
            "minRunDis": min_run_dis,
            "useCreditSword": use_credit_sword,
            "runPlanCode": run_plan_code,
            "sportType": sport_type,
        })
        res = self.transport.post("start_sun_run", payload)
        if res.get("code") == CODE_OK and res.get("data"):
            data = res["data"]
            code = str(data.get("runRecordCode", ""))
            if code:
                self.store.create_run(code, sport_type=sport_type,
                                      fence_code=payload["fenceCode"],
                                      fence_name=self.fence.get("fenceName", ""),
                                      school_code=payload["schoolCode"],
                                      run_plan_code=run_plan_code,
                                      start_ms=int(data.get("startTime") or time.time() * 1000),
                                      source="real" if not self.local_mode else "sim")
                # 打卡点：优先用服务端下发的 targetPoints，否则按围栏均匀取点
                cps = data.get("targetPoints") or self._fallback_checkpoints()
                norm = []
                for i, p in enumerate(cps):
                    if isinstance(p, dict) and p.get("lat") is not None:
                        norm.append({"lat": float(p["lat"]), "lng": float(p["lng"]),
                                     "radius_m": float(p.get("radius_m", 0) or CHECKPOINT_HIT_RADIUS_M)})
                    else:
                        lat2, lng2 = self._polygon_point(i, max(1, len(cps)))
                        norm.append({"lat": lat2, "lng": lng2, "radius_m": CHECKPOINT_HIT_RADIUS_M})
                self.store.add_checkpoints(code, norm)
            if self.bus:
                self.bus.emit("state", f"已开跑：runRecordCode={code}")
        return res

    def _fallback_checkpoints(self) -> List[Dict[str, Any]]:
        n = max(1, int(self.rule.required_point_counts or 3))
        return [{"index": i, "lat": self._polygon_point(i, n)[0],
                 "lng": self._polygon_point(i, n)[1]} for i in range(n)]

    def _polygon_point(self, i: int, n: int) -> Tuple[float, float]:
        poly = self.fence_polygon()
        if not poly:
            return self.fence_center()
        # 在围栏质心与该顶点之间取 0.6 处，落在围栏内部
        clat, clng = protocol.polygon_centroid(poly)
        v = poly[i % len(poly)]
        return clat + (v[0] - clat) * 0.6, clng + (v[1] - clng) * 0.6

    # ══════════════════ 数据记录（本地） ══════════════════
    def record_points(self, run_code: str, pts: Sequence[RunLatLng]) -> int:
        return self.store.add_points(run_code, pts)

    def record_steps(self, run_code: str, steps: Sequence[IntervalStep]) -> int:
        return self.store.add_steps(run_code, steps)

    def record_paces(self, run_code: str, paces: Sequence[IntervalPace]) -> int:
        return self.store.add_paces(run_code, paces)

    # ══════════════════ 数据上传（断点续传） ══════════════════
    def upload_points(self, run_code: str, batch: int = DEFAULT_UPLOAD_BATCH,
                      only_pending: bool = True) -> Dict[str, Any]:
        """★ 分批上传轨迹（唯一带 sign 的接口），按 indexList 标记状态

        照抄 ApiDataComponent.c0() 的两道门：
          · 只取 state ∈ {1 INIT, 4 FAIL} 且 isValid=1 的点（被 H0 拒过的点不上传）
          · 总数 <= 3 时整批不发（原版 size<=3 直接 onCompleted）
        发送前把全部 id 按 batch（原版 200）一组置 UPLOADING，成功置 SUCC、
        失败置 FAIL —— 与原版 class a 的 Subscriber 回调一致。
        """
        states = [STATE_INIT, STATE_FAIL] if only_pending else None
        pts = self.store.get_points(run_code, states, valid_only=True)
        if not pts:
            return {"code": CODE_OK, "message": "无待上传轨迹", "data": {"uploaded": 0}}
        if only_pending and len(pts) <= POI_UPLOAD_MIN_POINTS - 1:
            return {"code": CODE_OK,
                    "message": f"待上传轨迹 {len(pts)} 点，不足 {POI_UPLOAD_MIN_POINTS} 点暂不发",
                    "data": {"uploaded": 0, "pending": len(pts)}}
        total_ok = 0
        batches = 0
        for i in range(0, len(pts), batch):
            chunk = pts[i:i + batch]
            self.store.set_point_states(run_code, [p.lat_lng_index for p in chunk],
                                        STATE_UPLOADING)
            res = self.transport.post("upload_record", self.transport.base_payload({
                "pois": protocol.build_upload_pois(chunk),
                "runRecordCode": run_code,
            }))
            batches += 1
            if res.get("code") == CODE_OK:
                data = res.get("data") or {}
                idx_list = data.get("indexList")
                if isinstance(idx_list, list) and idx_list:
                    # indexList 是**本批次内**的索引（与客户端一致）
                    accepted = [chunk[j].lat_lng_index for j in idx_list if j < len(chunk)]
                    accepted += [p.lat_lng_index for p in chunk]
                else:
                    accepted = [p.lat_lng_index for p in chunk]
                self.store.set_point_states(run_code, sorted(set(accepted)), STATE_SUCC)
                total_ok += len(chunk)
                self.store.log_upload(run_code, "run/uploadRunRecord", True,
                                      f"批次 {batches}：{len(chunk)} 点", {"count": len(chunk)}, res)
            else:
                self.store.set_point_states(run_code, [p.lat_lng_index for p in chunk],
                                            STATE_FAIL)
                self.store.log_upload(run_code, "run/uploadRunRecord", False,
                                      str(res.get("message")), {"count": len(chunk)}, res)
                if self.bus:
                    self.bus.emit("log", f"✗ 轨迹批次 {batches} 上传失败：{res.get('message')}",
                                  level="error")
                return {"code": res.get("code", -1), "message": res.get("message"),
                        "data": {"uploaded": total_ok, "batches": batches}}
        done = self.store.count_points(run_code, STATE_SUCC)
        if self.bus:
            self.bus.emit("state", f"轨迹上传完成：{done}/{self.store.count_points(run_code)} 点"
                                   f"（{batches} 批）")
        return {"code": CODE_OK, "message": "成功",
                "data": {"uploaded": total_ok, "batches": batches, "confirmed": done}}

    @staticmethod
    def _with_count(res: Dict[str, Any], uploaded: int, total: int) -> Dict[str, Any]:
        """给服务端响应补上本次实际上传条数（界面需要展示，服务端不返回）"""
        data = res.get("data")
        data = dict(data) if isinstance(data, dict) else {}
        data["uploaded"] = int(uploaded)
        data["count"] = int(total)
        return {**res, "data": data}
    def upload_steps(self, run_code: str,
                     interval_s: int = STEP_INTERVAL_S) -> Dict[str, Any]:
        """上传步频段：照抄 ApiDataComponent.d0()

        原版只取 is_uploaded=false 的段（StepDao.b 不带 isValid 条件），
        且不足 3 段直接 onCompleted 不发。stepInterval 是**秒**（CommonConfig 默认 20）。
        """
        steps = self.store.get_steps(run_code, only_pending=True)
        if not steps:
            return {"code": CODE_OK, "message": "无待上传步频", "data": None}
        if len(steps) < SEGMENT_UPLOAD_MIN:
            return {"code": CODE_OK,
                    "message": f"待上传步频 {len(steps)} 段，不足 {SEGMENT_UPLOAD_MIN} 段暂不发",
                    "data": None}
        res = self.transport.post("upload_step", self.transport.base_payload({
            "stepList": build_step_list(steps),
            "stepInterval": interval_s,
            "runRecordCode": run_code,
        }))
        if res.get("code") == CODE_OK:
            self.store.mark_steps_uploaded(run_code)
        self.store.log_upload(run_code, "run/uploadStepsRecord", res.get("code") == CODE_OK,
                              str(res.get("message")), None, res)
        return self._with_count(res, len(steps) if res.get("code") == CODE_OK else 0, len(steps))

    def upload_paces(self, run_code: str,
                     interval_m: int = PACE_INTERVAL_M) -> Dict[str, Any]:
        """上传配速段：照抄 ApiDataComponent.b0()

        原版取 is_uploaded=false **且 isValid=1** 的段（PaceDao.b 多带一道 isValid），
        且不足 3 段直接 onCompleted 不发。paceInterval 是**米**（CommonConfig 默认 50）。
        """
        paces = self.store.get_paces(run_code, only_pending=True)
        if not paces:
            return {"code": CODE_OK, "message": "无待上传配速", "data": None}
        if len(paces) < SEGMENT_UPLOAD_MIN:
            return {"code": CODE_OK,
                    "message": f"待上传配速 {len(paces)} 段，不足 {SEGMENT_UPLOAD_MIN} 段暂不发",
                    "data": None}
        res = self.transport.post("upload_pace", self.transport.base_payload({
            "paceList": build_pace_list(paces),
            "paceInterval": interval_m,
            "runRecordCode": run_code,
        }))
        if res.get("code") == CODE_OK:
            self.store.mark_paces_uploaded(run_code)
        self.store.log_upload(run_code, "run/uploadPaceRecord", res.get("code") == CODE_OK,
                              str(res.get("message")), None, res)
        return self._with_count(res, len(paces) if res.get("code") == CODE_OK else 0, len(paces))

    def upload_strides(self, run_code: str, stride_m: float = 0.85,
                       interval_m: int = STRIDE_STATISTICS_M) -> Dict[str, Any]:
        """上传步幅段：原版 strideInterval 取 CommonConfig.strideStatisticsInterval（100 米）"""
        steps = self.store.get_steps(run_code, only_pending=False)
        if not steps:
            return {"code": CODE_OK, "message": "无步频段可推导步幅", "data": None}
        res = self.transport.post("upload_stride", self.transport.base_payload({
            "strideList": build_stride_list(steps, stride_m),
            "strideInterval": interval_m,
            "runRecordCode": run_code,
        }))
        self.store.log_upload(run_code, "run/uploadStrideRecord", res.get("code") == CODE_OK,
                              str(res.get("message")), None, res)
        return self._with_count(res, len(steps) if res.get("code") == CODE_OK else 0, len(steps))

    def upload_checkpoints(self, run_code: str, pts: Sequence[RunLatLng]) -> Dict[str, Any]:
        """上传打卡点：把已通过的打卡点坐标提交"""
        passed = [c for c in self.store.get_checkpoints(run_code) if int(c.get("passed") or 0) == 1]
        if not passed:
            return {"code": CODE_OK, "message": "无已通过打卡点", "data": None}
        targets = [{"index": i,
                    "lat": round(float(c["hit_lat"] or c["lat"]), 6),
                    "lng": round(float(c["hit_lng"] or c["lng"]), 6),
                    "runTime": 0, "collectTime": int(c.get("hit_ms") or 0)}
                   for i, c in enumerate(passed)]
        res = self.transport.post("upload_passpoint", self.transport.base_payload({
            "targetPoints": targets,
            "runRecordCode": run_code,
        }))
        self.store.log_upload(run_code, "run/uploadPassPoint", res.get("code") == CODE_OK,
                              str(res.get("message")), targets, res)
        return self._with_count(res, len(targets) if res.get("code") == CODE_OK else 0, len(targets))

    def finish_run(self, run_code: str, sport_type: int = SPORT_TYPE_SUN,
                   sun: bool = True) -> Dict[str, Any]:
        """结算：聚合三类未上传数据一次性提交（客户端 finishSunRun_v2 语义）"""
        run = self.store.get_run(run_code) or {}
        pts_all = self.store.get_points(run_code, None, valid_only=True)
        # 原版结算组装 J()：pois 取 state ∈ {1,4} **且 isValid=1** 的点
        pending_pts = self.store.get_points(
            run_code, [STATE_INIT, STATE_FAIL, STATE_UPLOADING], valid_only=True)
        pending_steps = self.store.get_steps(run_code, only_pending=True)
        pending_paces = self.store.get_paces(run_code, only_pending=True)
        done_cp, total_cp = self.store.checkpoints_progress(run_code)

        valid = run.get("valid") or {}
        distance = float(run.get("distance_m") or valid.get("distanceM") or 0)
        duration = int(run.get("duration_s") or valid.get("durationS") or 0)
        total_step = int(run.get("total_step") or valid.get("totalStep") or 0)
        ts = str(self.transport.clock())

        payload = self.transport.base_payload({
            "runRecordCode": run_code,
            "distance": int(round(distance)),
            "dis": int(round(distance)),                  # 双写，兼容不同版本
            "duration": str(duration),
            "totalStep": str(total_step),
            "sportType": sport_type,
            "status": int(run.get("status", 1 if valid.get("isValid", True) else 0)),
            "stepInterval": STEP_INTERVAL_S,
            "paceInterval": PACE_INTERVAL_M,
            "alignType": 3,
            "runImgRecord": crypto.run_img_record(run_code, ts),
            "timestamp": ts,
            "targetPoints": [{"index": i,
                              "lat": round(float(c["lat"]), 6), "lng": round(float(c["lng"]), 6),
                              "passed": int(c.get("passed") or 0)}
                             for i, c in enumerate(self.store.get_checkpoints(run_code))],
            "pois": tail_points(pts_all, 4),
            "pauseCount": 0,
            "pauseTimes": 0,
        })
        if pending_pts:
            payload["pois"] = protocol.build_upload_pois(pending_pts)
        if pending_steps:
            payload["stepList"] = build_step_list(pending_steps)
        if pending_paces:
            payload["paceList"] = build_pace_list(pending_paces)

        endpoint = "finish_sun_run" if sun else "finish_free_run"
        res = self.transport.post(endpoint, payload)
        ok = res.get("code") == CODE_OK
        if ok:
            self.store.mark_uploaded(run_code, True)
            if pending_steps:
                self.store.mark_steps_uploaded(run_code)
            if pending_paces:
                self.store.mark_paces_uploaded(run_code)
            if pending_pts:
                self.store.set_point_states(run_code,
                                            [p.lat_lng_index for p in pending_pts], STATE_SUCC)
        self.store.log_upload(run_code, EP[endpoint].path if endpoint in EP else endpoint, ok,
                              str(res.get("message")),
                              {"checkpoints": f"{done_cp}/{total_cp}"}, res)
        self.store.finish_run(run_code, finish={"endpoint": endpoint, "response": res})
        if self.bus:
            self.bus.emit("state" if ok else "log",
                          f"{'✓' if ok else '✗'} 结算 {'完成' if ok else '失败'}："
                          f"{res.get('message')}", level="info" if ok else "error")
        return res

    def resume_run(self, run_code: str) -> Dict[str, Any]:
        """断点续传：把未完成的跑步补齐并结算"""
        run = self.store.get_run(run_code)
        if not run:
            return {"code": -1, "message": f"本地找不到 {run_code}", "data": None}
        # 已结算的记录也可能残留未成功的点/段（例如部分批次失败后才结算）；
        # 只有“确实一点夹缝都没有”才直接返回，否则继续补传。
        pending_pts = self.store.get_points(run_code, [STATE_INIT, STATE_FAIL, STATE_UPLOADING])
        pending_steps = self.store.get_steps(run_code, only_pending=True)
        pending_paces = self.store.get_paces(run_code, only_pending=True)
        if run.get("uploaded") and not (pending_pts or pending_steps or pending_paces):
            return {"code": CODE_OK, "message": "该记录已全部上传，无需续传", "data": run}
        if self.bus:
            self.bus.emit("state", f"断点续传：{run_code}")
        out: Dict[str, Any] = {"runCode": run_code, "steps": []}
        out["points"] = self.upload_points(run_code)
        out["steps"].append(self.upload_steps(run_code))
        out["steps"].append(self.upload_paces(run_code))
        out["checkpoints"] = self.upload_checkpoints(run_code, [])
        out["finish"] = self.finish_run(run_code, sport_type=int(run.get("sport_type", 1)))
        return {"code": out["finish"].get("code", -1), "message": "续传完成", "data": out}

    # ══════════════════ 查询 ══════════════════
    def list_sun_runs(self, page: int = 1, size: int = 10) -> Dict[str, Any]:
        return self.transport.post("sunrun_list", self.transport.base_payload({
            "pageNum": page, "pageSize": size,
        }))

    def run_summary(self, sport_type: int = SPORT_TYPE_SUN, time_type: int = 3) -> Dict[str, Any]:
        return self.transport.post("run_summary", self.transport.base_payload({
            "sportType": sport_type, "timeType": time_type,
        }))

    def rank_distance(self, cycle: int = 30, sex: int = 2) -> Dict[str, Any]:
        return self.transport.post("rank_distance", self.transport.base_payload({
            "rankCycle": cycle, "sex": sex,
        }))

    def unfinished(self) -> List[Dict[str, Any]]:
        return self.store.unfinished_runs()


def _db_path(config: Dict[str, Any]):
    from pathlib import Path

    from .bus import default_data_dir

    custom = config.get("db_path")
    if custom:
        return Path(custom)
    return default_data_dir() / "records.db"


def _mask(phone: str) -> str:
    s = str(phone)
    return s[:3] + "****" + s[-4:] if len(s) >= 7 else s
