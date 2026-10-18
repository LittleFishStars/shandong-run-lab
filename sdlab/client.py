#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""业务门面：把协议、传输、记录、仿真串成一条完整链路

对外只暴露「登录 → 阳光跑 → 数据记录 → 数据上传」四类能力，
GUI 与 CLI 都只跟这一层打交道。

对齐客户端行为的关键点：
  · token/satoken 双凭据、deviceId 持久化（report 07 §2）
  · 开跑九参数顺序（schoolCode, fenceCode, activityCode, lat, lng,
    targetDistance, useCreditSword, runPlanCode, sportType）——第 6 个字段名取自
    @Field(FreeRunActivity.y)，是 targetDistance 而不是 minRunDis
  · 9 指纹与 sign 由 net 层统一注入：原版**所有 POST 都带 sign**（GET 不签）
  · 结算报文只有 distance（**无 dis**，那是地图覆盖物配置键），值为 String
  · 服务端回 indexList → 本地按段标记 SUCC / FAIL → 断点续传
"""
from __future__ import annotations

import math
import time
from typing import Any, Dict, List, Optional, Sequence, Tuple

from . import crypto, protocol
from .captcha import CaptchaSolver
from .constants import (
    APP_VERSION,
    BUILD_VERSION,
    CHECKPOINT_HIT_RADIUS_M,
    CODE_OK,
    CODE_NEED_LOGIN,
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
        # 开跑响应里的会话级设置（StartRunEntity）：clockMode 2/3 = 顺序打卡，
        # whiteFlag = GPS 白名单，cheatLevel 3/4 影响步频异常判定
        self.run_clock_mode = 0
        self.run_white_flag = False
        self.run_cheat_level = 0
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

    def _save_session(self, data: Dict[str, Any], touch: bool = False) -> None:
        """写会话（与已有字段合并，刷新用户信息时不会把 token 冲掉）

        touch=True 只在登录成功时传：刷新用户信息不该改「上次登录时间」。
        """
        merged = dict(self.user) if isinstance(self.user, dict) else {}
        merged.update(data or {})
        keep = {
            "token": str(merged.get("token", "") or ""),
            "satoken": str(merged.get("satoken", "") or ""),
            "userId": str(merged.get("userId", "") or ""),
            "schoolCode": str(merged.get("schoolCode", "") or ""),
            "schoolName": str(merged.get("schoolName", "") or ""),
            "userName": str(merged.get("userName", "") or ""),
            "loginName": str(merged.get("loginName", "") or ""),
            "userType": merged.get("userType", 1),
            "deviceId": self.transport.device_id,
            "loginAt": (int(time.time() * 1000) if touch
                        else int(merged.get("loginAt") or time.time() * 1000)),
        }
        self.transport.token = keep["token"]
        self.transport.satoken = keep["satoken"]
        self.transport.school_code = keep["schoolCode"]
        self.transport.user_id = keep["userId"]
        self.logged_in = bool(keep["token"])
        self.user = keep
        self.store.kv_set(self.kv_token_key, keep)

    def _persist_user(self) -> None:
        """用户信息刷新后回写会话（token 与登录时间保持不变）"""
        if not self.transport.token:
            return
        self._save_session(self.user)

    # ══════════════════ 历史账号（多用户切换） ══════════════════
    @property
    def accounts_key(self) -> str:
        return "accounts" + ("_mock" if self.local_mode else "")

    def accounts(self) -> List[Dict[str, Any]]:
        """本机登录过的账号（含 token，界面层负责脱敏展示）"""
        lst = self.store.kv_get(self.accounts_key)
        if isinstance(lst, dict):
            lst = lst.get("list")
        return [a for a in (lst or []) if isinstance(a, dict) and a.get("token")]

    def _remember_account(self) -> None:
        """把当前会话登记进历史账号：按 userId 去重，最多 20 个"""
        uid = str(self.user.get("userId") or "")
        if not uid or not self.transport.token:
            return
        lst = [a for a in self.accounts() if str(a.get("userId")) != uid]
        lst.insert(0, dict(self.user))
        lst.sort(key=lambda a: int(a.get("loginAt") or 0), reverse=True)
        self.store.kv_set(self.accounts_key, lst[:20])

    def _apply_session(self, sess: Dict[str, Any]) -> None:
        """把一条会话装进 transport 与本地库（传空则清当前会话）"""
        self.transport.token = str(sess.get("token") or "")
        self.transport.satoken = str(sess.get("satoken") or "")
        self.transport.school_code = str(sess.get("schoolCode") or "")
        self.transport.user_id = str(sess.get("userId") or "")
        self.logged_in = bool(self.transport.token)
        self.user = dict(sess or {})
        if self.logged_in:
            self.store.kv_set(self.kv_token_key, self.user)
        else:
            self.store.kv_delete(self.kv_token_key)

    def _reset_school_state(self) -> None:
        """换账号时清掉上个账号的学校/围栏/规则缓存，避免拿错学校去开跑"""
        self.fence = {}
        self.fences = []
        self.semesters = []
        self.run_plans = []
        self.abstract = {}
        self.common = {}
        self.rule = RuleSet()

    def switch_account(self, user_id: str) -> Dict[str, Any]:
        """切换到本机登录过的账号：换 token → 刷新用户信息 → 记为当前会话

        不重新输密码：原版会话就存在本地，等价于 SharedPreferences 里换一份 token。
        token 过期（1516）时把该账号从历史里摘掉，并回滚到切换前的身份。
        """
        uid = str(user_id or "")
        target = next((a for a in self.accounts() if str(a.get("userId")) == uid), None)
        if not target:
            return {"code": CODE_NEED_LOGIN, "message": "本机没有这个账号的登录态", "data": None}
        old = dict(self.user) if self.logged_in else {}
        self._apply_session(target)
        self._reset_school_state()
        res = self.load_user()
        code = int(res.get("code", -1))
        if code == CODE_NEED_LOGIN:
            self._forget_account(uid)
            self._apply_session(old)
            return {"code": code, "message": "该账号登录已过期，请重新登录", "data": None}
        if code == CODE_OK:
            self._remember_account()          # 登录时间保留该账号原值
        return res

    def _forget_account(self, user_id: str) -> None:
        lst = [a for a in self.accounts() if str(a.get("userId")) != str(user_id)]
        self.store.kv_set(self.accounts_key, lst)

    def forget_account(self, user_id: str) -> None:
        """移除历史账号；若删的是当前账号，顺带清掉当前会话"""
        self._forget_account(user_id)
        if str(self.user.get("userId") or "") == str(user_id):
            self.logout(remote=False)
        elif self.bus:
            self.bus.emit("state", "已移除该账号")


    def logout(self, remote: bool = True) -> None:
        """退出登录。remote=False 只清本地（token 已失效时用，不再发 logout 请求）"""
        try:
            if remote and self.logged_in:
                self.transport.post("logout")
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
            # 明文交传输层：login_password 标了 encrypt=True，由 net 层按
            # ENCRYPT_FIELDS 加密（与原版 EncryptInterceptor 一致，避免双重加密）
            "password": password,
            "captchaPoint": captcha_point or "",
        })
        res = self.transport.post("login_password", payload)
        if res.get("code") == CODE_OK and res.get("data"):
            res["data"]["loginName"] = phone
            self._save_session(res["data"], touch=True)
            self._remember_account()
            # 登录后立即校准时钟（原版在隐私协议同意时就已跑 SyncTimeIntentService，
            # 登录更晚；这里取等价时机）。失败不影响登录本身。
            try:
                self.transport.sync_time()
            except Exception as _e:      # noqa: BLE001
                if self.bus:
                    self.bus.emit("log", f"时间校准失败（不影响登录）：{_e}", level="warn")
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
            self._persist_user()
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

    def load_rule(self, fence_code: str = "", semester_code: str = "",
                  activity_code: str = "", run_plan_code: str = "",
                  sub_school_code: str = "",
                  sport_type: int = SPORT_TYPE_SUN) -> Dict[str, Any]:
        """拉取 SchoolRule 并转成判定用的 RuleSet

        原版签名（RunRequestModel.d，字段名取自 @Field）：
            schoolCode, subSchoolCode, targetDistance(int), activityCode,
            runPlanCode, fenceCode, sportType
        七个字段一个不能少；**semesterCode 不在这个接口里**（旧实现发错）。
        """
        target = int(self.cfg.get("run", {}).get("target_distance_m", 2000))
        res = self.transport.post("sunrun_config", self.transport.base_payload({
            "schoolCode": str(self.fence.get("schoolCode") or self.transport.school_code),
            "subSchoolCode": str(sub_school_code or self.fence.get("subSchoolCode") or ""),
            "targetDistance": target,
            "activityCode": str(activity_code or self.fence.get("activityCode") or ""),
            "runPlanCode": str(run_plan_code),
            "fenceCode": fence_code or self.fence.get("fenceCode", ""),
            "sportType": sport_type,
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
            "semesterCode": semester_code, "runPlanCode": run_plan_code,
            "sportType": SPORT_TYPE_SUN,
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

    def load_sunrun_abstract(self, semester_code: str = "",
                             run_plan_code: str = "",
                             sport_type: int = SPORT_TYPE_SUN) -> Dict[str, Any]:
        """原版 querySunRunAbstractInfoV2：semesterCode + runPlanCode + sportType"""
        res = self.transport.post("sunrun_abstract", self.transport.base_payload({
            "semesterCode": semester_code,
            "runPlanCode": run_plan_code,
            "sportType": sport_type,
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
            # @Field(FreeRunActivity.y) long → 字段名 targetDistance（不是 minRunDis）
            "targetDistance": int(min_run_dis),
            "useCreditSword": use_credit_sword,
            "runPlanCode": run_plan_code,
            "sportType": sport_type,
        })
        res = self.transport.post("start_sun_run", payload)
        if res.get("code") == CODE_OK and res.get("data"):
            data = res["data"]
            code = str(data.get("runRecordCode", ""))
            if code:
                # StartRunEntity 的会话级设置：clockMode 决定打卡是否必须按序
                # （I1()：2/3 = 顺序模式），whiteFlag 是 GPS 白名单，cheatLevel 影响步频异常
                self.run_clock_mode = int(data.get("clockMode") or 0)
                self.run_white_flag = bool(data.get("whiteFlag"))
                self.run_cheat_level = int(data.get("cheatLevel") or 0)
                self.store.create_run(code, sport_type=sport_type,
                                      fence_code=payload["fenceCode"],
                                      fence_name=self.fence.get("fenceName", ""),
                                      school_code=payload["schoolCode"],
                                      run_plan_code=run_plan_code,
                                      start_ms=int(data.get("startTime") or time.time() * 1000),
                                      clock_mode=self.run_clock_mode,
                                      white_flag=int(self.run_white_flag),
                                      cheat_level=self.run_cheat_level,
                                      source="real" if not self.local_mode else "sim")
                # 打卡点：服务端 targetPoints 的 code/sort/nfcEnable/type 必须原样带回，
                # 不能拿本地序号顶替（结算与 uploadPassPoint 里 code 就是服务端点位标识）
                cps = data.get("targetPoints") or self._fallback_checkpoints()
                norm = []
                for i, p in enumerate(cps):
                    if isinstance(p, dict) and p.get("lat") is not None:
                        norm.append({"lat": float(p["lat"]), "lng": float(p["lng"]),
                                     "radius_m": float(p.get("radius_m", 0) or CHECKPOINT_HIT_RADIUS_M),
                                     "code": int(p.get("code") or 0),
                                     "sort": int(p.get("sort") if p.get("sort") is not None else i),
                                     "nfcEnable": bool(p.get("nfcEnable")),
                                     "type": int(p.get("type") or 0)})
                    else:
                        lat2, lng2 = self._polygon_point(i, max(1, len(cps)))
                        norm.append({"lat": lat2, "lng": lng2,
                                     "radius_m": CHECKPOINT_HIT_RADIUS_M, "code": 0, "sort": i})
                self.store.add_checkpoints(code, norm)
            if self.bus:
                self.bus.emit("state", f"已开跑：runRecordCode={code}")
        return res

    def start_free_run(self, lat: float = 0.0, lng: float = 0.0,
                       aim_distance: int = 0, aim_duration: int = 0,
                       aim_calorie: int = 0) -> Dict[str, Any]:
        """自由跑开跑：原版 km7.g() → IRunApi.startFreeRun(@FieldMap Map<String,String>)

        lat/lng 是 BigDecimal.toString()，全是字符串；三个 aim* 为 0 时**整个键都不发**
        （原版 `if (aimDistance != 0)`），接口里也没有 sportType。
        """
        if not lat or not lng:
            lat, lng = self.fence_center()
        body: Dict[str, Any] = {"lat": repr(float(lat)), "lng": repr(float(lng))}
        for key, val in (("aimDistance", aim_distance),
                         ("aimDuration", aim_duration),
                         ("aimCalorie", aim_calorie)):
            if val:
                body[key] = int(val)
        return self.transport.post("start_free_run", body)

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
        """上传轨迹（唯一带 sign 的接口），按 indexList 标记状态

        照抄 ApiDataComponent.c0() 的三道门（已对反编译逐行核实）：
          · 只取 state ∈ {1 INIT, 4 FAIL} 且 isValid=1 的点（被 H0 拒过的点不上传）
          · 总数 <= 3 时整批不发（原版 listB.size() <= 3 → onCompleted）
          · **整表一次 POST**（原版 onNext(listB) 把全部点一把给订阅者），
            batch=200 只用于**状态回写**的分片（原版 subList(i, i+200)）
        发送前把全部 id 置 UPLOADING，成功置 SUCC、
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
        # 原版先把全部 id 置 UPLOADING（subList 每 200 一段），再整表一次 POST
        all_ids = [p.lat_lng_index for p in pts]
        for i in range(0, len(all_ids), batch):
            self.store.set_point_states(run_code, all_ids[i:i + batch], STATE_UPLOADING)
        res = self.transport.post("upload_record", self.transport.base_payload({
            "pois": protocol.build_upload_pois(pts),
            "runRecordCode": run_code,
        }))
        batches = math.ceil(len(pts) / max(1, batch))
        if res.get("code") == CODE_OK:
            data = res.get("data") or {}
            idx_list = data.get("indexList")
            if isinstance(idx_list, list) and idx_list:
                # 服务端回显的是点的 index（RunLatLng.index / 本地 idx），不是本次请求内下标：
                # 原版 ApiDataComponent 直接拿 indexList 调 DAO 更新（index = 主键）
                wanted = {p.lat_lng_index for p in pts}
                accepted = [int(i) for i in idx_list if int(i) in wanted]
            else:
                accepted = list(all_ids)
            for i in range(0, len(accepted), batch):
                self.store.set_point_states(run_code, sorted(set(accepted[i:i + batch])),
                                            STATE_SUCC)
            self.store.log_upload(run_code, "run/uploadRunRecord", True,
                                  f"单请求 {len(pts)} 点", {"count": len(pts)}, res)
        else:
            for i in range(0, len(all_ids), batch):
                self.store.set_point_states(run_code, all_ids[i:i + batch], STATE_FAIL)
            self.store.log_upload(run_code, "run/uploadRunRecord", False,
                                  str(res.get("message")), {"count": len(pts)}, res)
            if self.bus:
                self.bus.emit("log", f"✗ 轨迹上传失败：{res.get('message')}", level="error")
            return {"code": res.get("code", -1), "message": res.get("message"),
                    "data": {"uploaded": 0, "batches": 0}}
        total_ok = len(pts)
        done = self.store.count_points(run_code, STATE_SUCC)
        if self.bus:
            self.bus.emit("state", f"轨迹上传完成：{done}/{self.store.count_points(run_code)} 点")
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

    def upload_strides(self, run_code: str,
                       interval_m: int = STRIDE_STATISTICS_M) -> Dict[str, Any]:
        """上传步幅段：照搬原版 DataComponent.E0() → uploadStrideRecord

        原版**不是**从步频段反推步幅，而是每浨 strideStatisticsInterval 米
        （服务端实测 200）就用 `S0() - lastSegmentStrideDistance` 与同步数
        现算一段，然后 `strideList` 只装**一个**元素的数组、立即上传。
        所以这里逐段发，每段成功就标 is_uploaded。
        """
        strides = self.store.get_strides(run_code, only_pending=True)
        if not strides:
            return {"code": CODE_OK, "message": "无待上传步幅", "data": None}
        ok = 0
        last: Dict[str, Any] = {"code": CODE_OK, "message": "成功"}
        for s in strides:
            res = self.transport.post("upload_stride", self.transport.base_payload({
                "strideList": build_stride_list(s),
                "strideInterval": interval_m,
                "runRecordCode": run_code,
            }))
            last = res
            good = res.get("code") == CODE_OK
            self.store.log_upload(run_code, "run/uploadStrideRecord", good,
                                  str(res.get("message")), build_stride_list(s), res)
            if good:
                self.store.mark_stride_uploaded(run_code, int(s.stride_index))
                ok += 1
            else:
                break
        return self._with_count(last, ok, len(strides))
    def upload_checkpoints(self, run_code: str, pts: Sequence[RunLatLng]) -> Dict[str, Any]:
        """上传打卡点：原版 p0(targetPoints, runRecordCode) → run/uploadPassPoint

        字段与结算里的 targetPoints 完全一致（code/lat/lng/passStatus/
        clockTime/sort/nfcEnable），统一走 store.checkpoint_targets 构造。

        原版 `p0(getTargetPoints(), E())` 发的是**全量** targetPoints（含
        passStatus=false 的），由服务端根据 passStatus 自行判定——这里同样发全量，
        只发已通过的会让服务端看到一份“缺了点”的列表。
        """
        targets = self.store.checkpoint_targets(run_code)
        if not targets:
            return {"code": CODE_OK, "message": "没有打卡点", "data": None}
        res = self.transport.post("upload_passpoint", self.transport.base_payload({
            "targetPoints": targets,
            "runRecordCode": run_code,
        }))
        self.store.log_upload(run_code, "run/uploadPassPoint", res.get("code") == CODE_OK,
                              str(res.get("message")), targets, res)
        return self._with_count(res, len(targets) if res.get("code") == CODE_OK else 0, len(targets))

    def finish_run(self, run_code: str, sport_type: int = SPORT_TYPE_SUN,
                   sun: bool = True, abnormal_code: int = 0) -> Dict[str, Any]:
        """结算：完整照搬原版 DataComponent.t1()/StopRunUtils.q() 的报文

        轨迹走 run/uploadRunRecord、步频走 uploadStepsRecord、配速走
        uploadPaceRecord，结算只交聚合摘要。

        **runImgRecord / timestamp 只属于阳光跑**：原版两条结算路径不同——
          · 阳光跑：`km7.c(params)` → `aw8.c(params)` → `IRunApi.j()`
            （= run/finishSunRun_v2），aw8.c() 塞 `runImgRecord = encodeRun(...)`
            与 `timestamp`；
          · 自由跑：`km7.b(params)` → `IRunApi.a()`（= run/finishFreeRun），
            **直接发，不调 aw8.c()**，所以没有这两个键。
        encodeRun 已还原为 MD5 拼接（crypto.run_img_record）。
        """
        run = self.store.get_run(run_code) or {}
        pending_steps = self.store.get_steps(run_code, only_pending=True)
        pending_paces = self.store.get_paces(run_code, only_pending=True)
        done_cp, total_cp = self.store.checkpoints_progress(run_code)

        valid = run.get("valid") or {}
        distance = float(run.get("distance_m") or valid.get("distanceM") or 0)
        # 原版结算的 pauseCount/pauseTimes 是实际值（DataComponent.t1()），不是恒 0
        pause_count = int(run.get("pause_count") or 0)
        pause_times = int(run.get("pause_times_s") or 0)
        duration = int(run.get("duration_s") or valid.get("durationS") or 0)
        total_step = int(run.get("total_step") or valid.get("totalStep") or 0)
        common_cfg = self.cfg.get("common", {}) or {}
        align_type = int(common_cfg.get("amapGPSLevel") or 3)
        is_valid = bool(run.get("status", 1 if valid.get("isValid", True) else 0))

        # 原版 aw8.c() 的 timestamp = String.valueOf(now + r90.D())
        # r90.D() 是服务端时间校准偏移（f44400a，默认 0），Transport.clock 已含此偏移
        ts_str = str(self.transport.clock())
        payload = self.transport.base_payload({
            "runRecordCode": run_code,
            # 原版 t1()/StopRunUtils.q() 里是 String.valueOf(...)，类型必须是 String
            # （SchoolActivitySuccessActivity.x = "distance"）
            "distance": str(int(round(distance))),
            "duration": str(duration),
            "totalStep": str(max(0, total_step)),
            "status": int(is_valid),
            "stepInterval": int(common_cfg.get("stepInterval") or STEP_INTERVAL_S),
            "paceInterval": int(common_cfg.get("paceInterval") or PACE_INTERVAL_M),
            "targetPoints": self.store.checkpoint_targets(run_code),
            "alignType": align_type,
            "pauseCount": pause_count,
            "pauseTimes": pause_times,
            "sportType": sport_type,
        })
        if sun:
            # 原版 aw8.c() 只在阳光跑路径上调。它在拦截器之后执行，所以 timestamp
            # 会覆盖公共字段里的那个；env 取原版 l43.b()（默认 4 → 落“其余”分支
            # → 生产密钥），它不进报文，所以 Mock 端必须用同一个默认值重算。
            payload["runImgRecord"] = crypto.run_img_record(
                run_code, ts_str, BUILD_VERSION, APP_VERSION,
                env=int((self.cfg.get("common", {}) or {}).get("envCode") or 0))
            payload["timestamp"] = ts_str

        reasons = self.store.invalid_reasons(run_code)
        if reasons:
            payload["invalidReasons"] = reasons
        if pending_steps:
            payload["stepList"] = build_step_list(pending_steps)
        if pending_paces:
            payload["paceList"] = build_pace_list(pending_paces)
        # 异常结束（原版 StartRunUtils.o0 → StopRunUtils.o → aw8.a()/aw8.b()）：
        # 未完成的跑步走 abnormalFinishSunRun / abnormalFinishActivityRun，
        # 报文与正常结算同构，额外带 abnormalCodes = [checkData]。
        # sportType == 1（阳光跑）走 aw8.b()，其余走 aw8.a()。
        endpoint = ("abnormal_finish" if sport_type == SPORT_TYPE_SUN
                    else "abnormal_finish_activity") if abnormal_code else (
            "finish_sun_run" if sun else "finish_free_run")
        if abnormal_code:
            payload["abnormalCodes"] = [int(abnormal_code)]
        res = self.transport.post(endpoint, payload)
        ok = res.get("code") == CODE_OK
        if ok:
            self.store.mark_uploaded(run_code, True)
            if pending_steps:
                self.store.mark_steps_uploaded(run_code)
            if pending_paces:
                self.store.mark_paces_uploaded(run_code)
            self.store.mark_strides_uploaded(run_code)
            # 原版结算成功后所有点置 SUCC（轨迹已由 uploadRunRecord 托底）
            all_pts = self.store.get_points(run_code, None, valid_only=False)
            self.store.set_point_states(
                run_code, [p.lat_lng_index for p in all_pts], STATE_SUCC)
        # payload 里存真实报文（便于事后核对 runImgRecord 等防篡改字段），
        # 打卡进度另放 message 里
        self.store.log_upload(run_code, EP[endpoint].path if endpoint in EP else endpoint, ok,
                              f"{res.get('message')}｜打卡 {done_cp}/{total_cp}",
                              payload, res)
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

    def query_unfinish_run(self, sport_type: int = SPORT_TYPE_SUN) -> Dict[str, Any]:
        """服务端未完成跑步：原版 km7.a() → queryUnFinishRun(@FieldMap {sportType})

        值是 **String**（String.valueOf(sportType)），而且只有这一个字段。
        """
        return self.transport.post("unfinish_run", {"sportType": str(sport_type)})

    def resume_server_run(self, run_code: str,
                          sport_type: int = SPORT_TYPE_SUN) -> Dict[str, Any]:
        """申请续跑：原版 run/resume = {sportType, runRecordCode}（@FormUrlEncoded）"""
        return self.transport.post("resume_run", {
            "sportType": str(sport_type), "runRecordCode": run_code,
        })

    # ══════════════════ 查询 ══════════════════
    def list_sun_runs(self, page: int = 1, size: int = 10,
                      semester_code: str = "", run_plan_code: str = "") -> Dict[str, Any]:
        """原版 pageSunRunRecord：pageSize + pageNum + semesterCode + runPlanCode"""
        return self.transport.post("sunrun_list", self.transport.base_payload({
            "pageNum": page, "pageSize": size,
            "semesterCode": semester_code, "runPlanCode": run_plan_code,
        }))

    def run_summary(self, sport_type: int = SPORT_TYPE_SUN,
                    time_type: int = 3) -> Dict[str, Any]:
        """近 N 天统计：原版 querySchoolRunSummary 只收一个 time（毫秒时间戳）

        RunRequestModel$nearbyRunStd$2 传的是 System.currentTimeMillis()，
        没有 sportType/timeType——两个参数仅为兼容旧调用而保留。
        """
        return self.transport.post("run_summary", self.transport.base_payload({
            "time": int(self.transport.clock()),
        }))

    def rank_distance(self, cycle: int = 30, sex: int = 2, scope: int = 1,
                      rank_type: int = 1, run_plan_code: str = "") -> Dict[str, Any]:
        """原版 rank/distance 五字段：sex, scope, rankCycle, type, runPlanCode

        scope/type 的取值在反编译中无调用点可循（调用方不在已反编译的 dex），
        默认 1 为占位，调用方可显式覆盖。
        """
        return self.transport.post("rank_distance", self.transport.base_payload({
            "sex": sex, "scope": scope, "rankCycle": cycle,
            "type": rank_type, "runPlanCode": run_plan_code,
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
