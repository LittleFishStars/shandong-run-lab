#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""跑步编排引擎：把「开跑 → 生成数据 → 记录 → 上传 → 结算」串成一条可复现的流水线

设计要点
  · 每一步都往 EventBus 发事件，GUI 可以直接当作进度条与日志用；
  · 生成的数据先全部落到 SQLite（数据记录），上传阶段只读库、再回写状态位，
    因此任何一步崩掉都能 `resume()` 续跑，不需要重跑一次完整流程；
  · 距离/配速/步频三者互相约束：时长由 `距离 ÷ 步幅 ÷ 步频` 反推，
    保证 totalStep / distance 与服务端校验口径一致（不触发步幅异常 58）。
"""
from __future__ import annotations

import threading
import time
from typing import Any, Dict, List, Optional, Sequence

from . import protocol
from .constants import (
    CHECKPOINT_HIT_RADIUS_M,
    CODE_OK,
    DEFAULT_SAMPLE_S,
    SPORT_TYPE_SUN,
    STRIDE_STATISTICS_M,
)
from .protocol import (
    IntervalPace,
    IntervalStep,
    RunLatLng,
    StrideSegment,
    TrackGenerator,
    evaluate_run,
    haversine,
)
from .simulator import FuckRunSim


class EngineError(RuntimeError):
    pass


class RunEngine:
    """阳光跑全流程编排"""

    def __init__(self, client, config: Dict[str, Any], bus=None):
        self.client = client
        self.cfg = config or {}
        self.bus = bus
        self.store = client.store
        self._lock = threading.Lock()
        self.last: Dict[str, Any] = {}          # 最近一次跑步的摘要
        # 真实打卡点：只由开跑响应（run/startSunRun_v2 的 targetPoints）填进来
        self.checkpoints: List[Dict[str, Any]] = []
        self.checkpoints_source: str = ""         # "server" | "preview" | ""
        # 拉取配置阶段按围栏几何预估的预览点：只服务「高级 / 调试」里的路径预览
        self.preview_points: List[Dict[str, Any]] = []

    # ══════════════════ 工具 ══════════════════
    def _emit(self, kind: str, msg: str, **data: Any) -> None:
        if self.bus:
            self.bus.emit(kind, msg, **data)

    def _step(self, pct: int, msg: str) -> None:
        self._emit("progress", msg, percent=max(0, min(100, int(pct))))

    def _run_cfg(self, key: str, default: Any) -> Any:
        return (self.cfg.get("run") or {}).get(key, default)

    def _realtime_cfg(self) -> tuple:
        """实时仿真开关与倍速。默认关：自检/批量跑需要的是快，不是看得见。"""
        sc = self.cfg.get("sim") or {}
        try:
            speed = max(0.1, float(sc.get("speed", 8.0) or 8.0))
        except (TypeError, ValueError):
            speed = 8.0
        return bool(sc.get("realtime", False)), speed

    def _write_points_paced(self, run_code: str, pts: Sequence[Any],
                            seconds: float, speed: float, steps: int = 20) -> None:
        """实时模式：把轨迹分 20 批写入，批间按仿真时间休眠。

        这样界面上能看到轨迹一笔一笔画出来、进度一格一格走（调“逐点行为”时比
        一次性算完有用得多）。总耗时约 仿真时长 ÷ 倍速，跟真实跑步的节奏一致。
        """
        n = len(pts)
        if n <= 1:
            self.store.add_points(run_code, pts)
            return
        chunk = max(1, -(-n // max(1, steps)))          # 向上取整，保证不丢尾巴
        per_sleep = (seconds / float(speed)) / max(1, -(-n // chunk))
        written = 0
        for i in range(0, n, chunk):
            batch = list(pts[i:i + chunk])
            self.store.add_points(run_code, batch)
            written = min(n, i + chunk)
            self._step(36 + int(9 * written / n),
                       f"仿真推进：{written}/{n} 点（{speed:g} 倍速）")
            if written < n:
                time.sleep(max(0.0, min(5.0, per_sleep)))

    # ══════════════════ ① 准备：套餐 / 围栏 / 规则 ══════════════════
    def prepare(self, school_code: str = "", fence_index: int = 0,
                semester_code: str = "") -> Dict[str, Any]:
        c = self.client
        if not c.logged_in:
            raise EngineError("尚未登录")
        self._step(2, "拉取用户信息…")
        user = c.load_user()
        if user.get("code") not in (CODE_OK, None):
            self._emit("log", f"用户信息异常：{user.get('message')}", level="warn")

        self._step(4, "拉取学期列表…")
        c.load_semesters()
        sem_code = semester_code or self._guess_semester_code()

        self._step(6, "拉取地理围栏…")
        fences = c.load_fences(school_code)
        if not c.fences:
            self._emit("log", "围栏列表为空，使用本地合成围栏（调试模式）", level="warn")
            c.fences = [self._synthetic_fence()]
        idx = max(0, min(int(fence_index), len(c.fences) - 1))
        c.fence = dict(c.fences[idx])

        self._step(7, "拉取服务端运行参数…")
        c.load_common_config()

        self._step(8, "拉取学校规则…")
        # 真实服务端：checkSunRunConfig 不返回 schoolRule，规则在 abstract 的
        # schoolDemandRule 里；这里不让 load_rule 自己去拉 abstract，避免同一次 prepare 请求两遍
        c.load_rule(semester_code=sem_code, allow_abstract_fallback=False)
        c.load_sunrun_abstract(semester_code=sem_code)
        c.load_plans(semester_code=sem_code)

        # 打卡点坐标只有开跑接口才下发（原版：围栏只给 requiredPointCounts 这类计数），
        # 所以这里只存一份按围栏预估的预览点，真实打卡点等 start() 落下来。
        self.preview_points = self.build_preview_points()
        self.checkpoints = []
        self.checkpoints_source = ""
        info = {
            "user": c.user,
            "semesters": c.semesters,
            "semester_code": sem_code,
            "fences": c.fences,
            "fence_index": idx,
            "fence": c.fence,
            "fence_polygon": c.fence_polygon(),
            "rule": c.rule.to_dict(),
            "checkpoints": self.checkpoints,          # 开跑前为空：打卡点由开跑下发
            "preview_points": self.preview_points,    # 按围栏预估，仅供调试预览
            "plans": c.run_plans,
            "abstract": c.abstract,
            "fences_response": fences,
        }
        self._emit("prepared", "准备完成", **{k: v for k, v in info.items()
                                             if k not in ("fences_response",)})
        return info

    def _guess_semester_code(self) -> str:
        for s in self.client.semesters or []:
            if isinstance(s, dict):
                if s.get("current") or s.get("isCurrent") or s.get("status") == 1:
                    return str(s.get("semesterCode") or s.get("code") or "")
        if self.client.semesters and isinstance(self.client.semesters[0], dict):
            s0 = self.client.semesters[0]
            return str(s0.get("semesterCode") or s0.get("code") or "")
        return ""

    def _synthetic_fence(self) -> Dict[str, Any]:
        """离线/接口缺围栏时的合成围栏：以配置里的坐标画一个 260 米方框"""
        lat = float(self._run_cfg("fallback_lat", 30.2867))
        lng = float(self._run_cfg("fallback_lng", 120.0861))
        half = float(self._run_cfg("fallback_half_m", 260.0))
        dlat = half / protocol.EARTH_M_PER_DEG_LAT
        dlng = half / (protocol.EARTH_M_PER_DEG_LAT * 0.8660)
        return {
            "fenceCode": "SYNTHETIC",
            "fenceName": "本地合成围栏（调试）",
            "lat": lat, "lng": lng,
            "fenceList": [
                {"lat": lat + dlat, "lng": lng - dlng},
                {"lat": lat + dlat, "lng": lng + dlng},
                {"lat": lat - dlat, "lng": lng + dlng},
                {"lat": lat - dlat, "lng": lng - dlng},
            ],
        }

    def build_preview_points(self) -> List[Dict[str, Any]]:
        """按围栏几何预估 N 个点（N 取自 SchoolRule.requiredPointCounts）

        原版不在开跑前下发打卡点坐标，这里只是给「高级 / 调试」的路径预览用，
        真实打卡点以开跑响应 targetPoints 为准。
        """
        c = self.client
        poly = c.fence_polygon()
        n = max(1, int(c.rule.required_point_counts or 3))
        pts: List[Dict[str, Any]] = []
        if poly:
            clat, clng = protocol.polygon_centroid(poly)
            for i in range(n):
                v = poly[i % len(poly)]
                pts.append({"index": i,
                            "lat": clat + (v[0] - clat) * 0.55,
                            "lng": clng + (v[1] - clng) * 0.55,
                            "radius_m": CHECKPOINT_HIT_RADIUS_M})
        else:
            lat, lng = c.fence_center()
            for i in range(n):
                pts.append({"index": i, "lat": lat, "lng": lng, "radius_m": CHECKPOINT_HIT_RADIUS_M})
        return pts

    # ══════════════════ ② 开跑 ══════════════════
    def start(self, target_m: Optional[float] = None, fence_index: Optional[int] = None,
              run_plan_code: str = "", sport_type: int = SPORT_TYPE_SUN,
              use_credit_sword: bool = False, activity_code: str = "",
              lat: Optional[float] = None, lng: Optional[float] = None) -> str:
        c = self.client
        if fence_index is not None and c.fences:
            idx = max(0, min(int(fence_index), len(c.fences) - 1))
            c.fence = dict(c.fences[idx])
        target = float(target_m or self._run_cfg("target_distance_m", 2000))
        if lat is None or lng is None:      # 没选起点时才回到围栏中心
            lat, lng = c.fence_center()
        self._step(12, f"请求开跑（目标 {target:.0f} 米）…")
        res = c.start_sun_run(lat=lat, lng=lng, min_run_dis=target,
                              run_plan_code=run_plan_code, sport_type=sport_type,
                              use_credit_sword=use_credit_sword,
                              activity_code=activity_code)
        if res.get("code") != CODE_OK or not (res.get("data") or {}).get("runRecordCode"):
            raise EngineError(f"开跑失败：{res.get('code')} {res.get('message')}")
        code = str(res["data"]["runRecordCode"])
        # 打卡点：服务端 targetPoints（client.start_sun_run 已落库）优先，
        # 没下发才退回围栏预估点，保证整条链路还有目标可打。
        cps = c.store.get_checkpoints(code) or []
        if cps:
            self.checkpoints = cps
            self.checkpoints_source = "server"
            self._emit("log", f"服务端下发 {len(cps)} 个打卡点（开跑响应 targetPoints）")
        else:
            self.checkpoints = [dict(p) for p in (self.preview_points or self.build_preview_points())]
            self.checkpoints_source = "preview"
            c.store.add_checkpoints(code, self.checkpoints)
            self._emit("log", f"服务端未下发打卡点，按围栏预估 {len(self.checkpoints)} 个",
                       level="warn")
        self.last = {"run_code": code, "target_m": target, "started_at": int(time.time() * 1000)}
        self._emit("run_started", f"已开跑：{code}", run_code=code, target_m=target)
        return code

    # ══════════════════ ③ 生成 + 记录 ══════════════════
    def simulate(self, run_code: str, target_m: Optional[float] = None,
                 seed: Optional[int] = None, mode: str = "sim") -> Dict[str, Any]:
        """生成一整趟跑步的三类数据并落库（轨迹 / 步频段 / 配速段）"""
        c = self.client
        t0 = time.time()
        run = self.store.get_run(run_code) or {}
        start_ms = int(run.get("start_ms") or time.time() * 1000)
        target = float(target_m or self.last.get("target_m")
                       or self._run_cfg("target_distance_m", 2000))
        stride = float(self._run_cfg("stride_m", 0.85))
        sc = self.cfg.get("sim") or {}
        c_lo = float(sc.get("min_cadence", 172.0))
        c_hi = float(sc.get("max_cadence", 182.0))
        cadence = (c_lo + c_hi) / 2.0

        # 几何与必经点先取出来：目标距离必须先满足“走得到所有打卡点”
        lat0, lng0 = c.fence_center()
        cps = self.store.get_checkpoints(run_code)
        waypoints = [(float(cp["lat"]), float(cp["lng"])) for cp in cps
                     if cp.get("lat") is not None and cp.get("lng") is not None]
        need = TrackGenerator.route_length(lat0, lng0, waypoints) if waypoints else 0.0
        if need > target:
            self._step(15, f"目标 {target:.0f} 米不足以走完全部打卡点，自动提升到 {need:.0f} 米")
            target = need

        # 时长由 距离 ÷ 步幅 ÷ 步频 反推，保证三个量自洽
        total_step_est = target / max(0.5, stride)
        seconds = int(round(total_step_est / (cadence / 60.0)))

        self._step(20, f"生成轨迹：{target:.0f} 米 / 预计 {seconds // 60}分{seconds % 60}秒")

        poly = c.fence_polygon()
        radius = 260.0
        if poly:
            radius = max(60.0, min(600.0, self._polygon_inradius(poly)))
        if waypoints:
            self._step(22, f"途经必经点轨迹：{len(waypoints)} 个打卡点")
        gen = TrackGenerator(
            center_lat=lat0, center_lng=lng0,
            target_distance_m=target, target_seconds=seconds,
            stride_m=stride, cadence_spm=cadence,
            fence_radius_m=radius, polygon=poly or None,
            waypoints=waypoints or None,
            sample_s=float(self._run_cfg("sample_s", DEFAULT_SAMPLE_S)),
            seed=seed,
        )
        pts: List[RunLatLng] = gen.generate_track(start_ms=start_ms)

        self._step(28, "运行 FUCK-RUN 步频仿真…")
        sim = FuckRunSim(min_cadence=c_lo, max_cadence=c_hi,
                         hz=float(sc.get("sensor_hz", 25.0)), seed=seed)
        sim.start(start_ms=start_ms)
        timeline = sim.step_timeline(duration_s=seconds, interval_s=gen.sample_s,
                                     start_ms=start_ms)
        steps: List[IntervalStep] = gen.build_steps(timeline, start_ms=start_ms)
        paces: List[IntervalPace] = gen.generate_paces(start_ms=start_ms)
        stride_interval = int((self.cfg.get("common") or {}).get("strideStatisticsInterval")
                              or STRIDE_STATISTICS_M)
        strides: List[StrideSegment] = gen.build_strides(timeline, interval_m=stride_interval)
        realtime, speed = self._realtime_cfg()
        if realtime:
            self._write_points_paced(run_code, pts, seconds, speed)
        else:
            self._step(36, f"写入本地记录：{len(pts)} 点 / {len(steps)} 步频段 / {len(paces)} 配速段")
            self.store.add_points(run_code, pts)
        self.store.add_steps(run_code, steps)
        self.store.add_paces(run_code, paces)
        self.store.add_strides(run_code, strides)

        hits = self.match_checkpoints(run_code, pts)
        total_step = sum(int(s.step) for s in steps)
        distance = sum(haversine(a.lat, a.lng, b.lat, b.lng)
                       for a, b in zip(pts, pts[1:]))
        pace_real = seconds / (distance / 1000.0) if distance > 0 else 0.0

        validity = evaluate_run(pts, seconds, total_step, c.rule,
                                gps_enabled=True,
                                stride_exception_segments=self._stride_exceptions(steps, stride),
                                checkpoints_total=len(self.store.get_checkpoints(run_code)),
                                checkpoints_done=hits,
                                sport_type=int(run.get("sport_type", SPORT_TYPE_SUN)),
                                cheat_level=int(run.get("cheat_level") or 0),
                                white_flag=bool(run.get("white_flag") or 0),
                                gps_white_flag=bool(getattr(c.rule, "gps_white_flag", False)))
        vd = validity.to_dict()
        self.store.finish_run(run_code,
                              end_ms=start_ms + seconds * 1000,
                              duration_s=seconds,
                              distance_m=round(distance, 2),
                              total_step=total_step,
                              pace_s_per_km=round(pace_real, 2),
                              status=int(validity.status),
                              source=mode,
                              valid=vd,
                              rule=c.rule.to_dict())
        summary = {
            "run_code": run_code,
            "points": len(pts),
            "steps": len(steps),
            "paces": len(paces),
            "distance_m": round(distance, 2),
            "duration_s": seconds,
            "total_step": total_step,
            "pace_s_per_km": round(pace_real, 2),
            "stride_m": round(distance / total_step, 3) if total_step else 0,
            "checkpoints_done": hits,
            "checkpoints_total": len(self.store.get_checkpoints(run_code)),
            "valid": vd,
            "elapsed_s": round(time.time() - t0, 2),
            "sensor": sim.state().to_dict(),
        }
        self.last = {**self.last, **summary}
        self._step(45, f"数据生成完成，用时 {summary['elapsed_s']}s；"
                       f"有效={vd.get('isValid')}")
        self._emit("simulated", "轨迹与步频已生成并入库", **summary)
        return summary
    def _stride_exceptions(self, steps: Sequence[IntervalStep], stride: float) -> int:
        """按段统计步幅异常数（对齐客户端 segmentStrideExceptionNum 口径）

        段的时间字段是秒，所以直接当秒用。
        """
        # 原版 R1()：段步幅（厘米）超过 SchoolRule.segmentStrideAvg 且该段起点
        # 距起点 >= 200 米才计一次；仿真里步幅是常量，所以要么全计要么都不计。
        base = float(getattr(self.client.rule, "segment_stride_avg", 0) or 0)
        base = base * 100.0 if 0 < base < 10 else base
        if base <= 0 or stride * 100.0 <= base:
            return 0
        return sum(1 for s in steps if int(s.step) * stride >= 200)

    def _polygon_inradius(self, poly: Sequence[Sequence[float]]) -> float:
        """多边形内切圆半径的粗略估计：面积 / 半周长"""
        if len(poly) < 3:
            return 200.0
        area = 0.0
        per = 0.0
        n = len(poly)
        for i in range(n):
            a, b = poly[i], poly[(i + 1) % n]
            area += a[0] * b[1] - b[0] * a[1]
            per += haversine(a[0], a[1], b[0], b[1])
        area_m = abs(area) / 2.0 * (protocol.EARTH_M_PER_DEG_LAT ** 2) * 0.87
        return (2 * area_m / per) if per > 0 else 200.0

    def match_checkpoints(self, run_code: str, pts: Sequence[RunLatLng]) -> int:
        """轨迹点与必经点做命中判定（12 米半径，与客户端一致）"""
        cps = self.store.get_checkpoints(run_code)
        if not cps or not pts:
            return 0
        hits = 0
        for cp in cps:
            if int(cp.get("passed") or 0) == 1:
                hits += 1
                continue
            best = min(pts, key=lambda p: haversine(p.lat, p.lng, cp["lat"], cp["lng"]))
            d = haversine(best.lat, best.lng, cp["lat"], cp["lng"])
            if d <= float(cp.get("radius_m") or CHECKPOINT_HIT_RADIUS_M):
                self.store.mark_checkpoint_hit(run_code, int(cp["index"]),
                                               best.lat, best.lng, best.collect_time)
                hits += 1
        return hits

    # ══════════════════ ④ 上传 ══════════════════
    def upload(self, run_code: str, batch: Optional[int] = None,
               do_steps: bool = True, do_paces: bool = True,
               do_strides: bool = True, do_checkpoints: bool = True) -> Dict[str, Any]:
        c = self.client
        out: Dict[str, Any] = {}
        self._step(55, "上传轨迹（分批，带 sign）…")
        out["points"] = c.upload_points(run_code, batch=batch or
                                        int(self._run_cfg("upload_batch", 50)))
        if out["points"].get("code") != CODE_OK:
            self._emit("log", "轨迹上传中断，可稍后 resume() 续传", level="error")
            self.last = {**self.last, "upload": out}
            return out
        # 原版停止序列：轨迹 → 步频 → 配速 → 步幅 → 打卡点 → 结算
        if do_steps:
            self._step(68, "上传步频段…")
            out["steps"] = c.upload_steps(run_code)
        if do_paces:
            self._step(76, "上传配速段…")
            out["paces"] = c.upload_paces(run_code)
        if do_strides:
            self._step(84, "上传步幅段…")
            out["strides"] = c.upload_strides(run_code, interval_m=int(
                (self.cfg.get("common") or {}).get("strideStatisticsInterval")
                or STRIDE_STATISTICS_M))
        if do_checkpoints:
            self._step(88, "上传打卡点…")
            out["checkpoints"] = c.upload_checkpoints(run_code, [])
        # 上传结果既要给界面看状态码，也要给界面看实际条数（1 个 dict 两种字段）
        self.last = {**self.last, "upload": self._upload_summary(run_code, out)}
        return out

    def _upload_summary(self, run_code: str, out: Dict[str, Any]) -> Dict[str, Any]:
        """把各上传步骤的返回值汇成 {步骤: {code, count, message}}，供界面直接展示"""
        def _count(v: Dict[str, Any]) -> int:
            data = v.get("data") or {}
            for key in ("uploaded", "count", "total"):
                if isinstance(data, dict) and data.get(key) is not None:
                    return int(data[key])
            return 0
        brief: Dict[str, Any] = {}
        for k, v in out.items():
            brief[k] = {"code": v.get("code"), "count": _count(v),
                        "message": str(v.get("message", ""))}
        return brief

    def finish(self, run_code: str, sun: bool = True) -> Dict[str, Any]:
        self._step(92, "提交结算…")
        run = self.store.get_run(run_code) or {}
        res = self.client.finish_run(run_code, sport_type=int(run.get("sport_type", 1)),
                                     sun=sun)
        self.last = {**self.last, "finish": res}
        self._step(100, f"结算完成：{res.get('message')}")
        self._emit("run_finished", f"跑步结束：{run_code}", run_code=run_code,
                   result=res, summary=self.last)
        return res

    # ══════════════════ 一键全流程 ══════════════════
    def auto(self, target_m: Optional[float] = None, fence_index: int = 0,
             seed: Optional[int] = None, do_upload: bool = True,
             do_finish: bool = True, run_plan_code: str = "",
             sport_type: int = SPORT_TYPE_SUN, mode: str = "sim",
             lat: Optional[float] = None, lng: Optional[float] = None) -> Dict[str, Any]:
        with self._lock:
            started = time.time()
            try:
                if not self.client.logged_in:
                    raise EngineError("尚未登录，无法开跑")
                self._step(1, "准备参数…")
                self.prepare(fence_index=fence_index)
                code = self.start(target_m=target_m, run_plan_code=run_plan_code,
                                  sport_type=sport_type, lat=lat, lng=lng)
                summary = self.simulate(code, target_m=target_m, seed=seed, mode=mode)
                if do_upload:
                    _up = self.upload(code)
                    summary["upload"] = self.last.get("upload") or {
                        k: {"code": v.get("code"), "count": 0,
                            "message": str(v.get("message", ""))}
                        for k, v in _up.items()}
                if do_finish:
                    _fin = self.finish(code, sun=(sport_type == SPORT_TYPE_SUN))
                    summary["finish"] = _fin
                    # 结算也算一个“上传步骤”，并入同一张概览表（界面/CLI 共用）
                    summary.setdefault("upload", {})["finish"] = {
                        "code": _fin.get("code"), "count": 0,
                        "message": str(_fin.get("message", ""))}
                summary["total_elapsed_s"] = round(time.time() - started, 2)
                self.last = summary
                self._emit("auto_done", "全流程完成", **summary)
                return {"code": CODE_OK, "message": "全流程完成", "data": summary}
            except EngineError as e:
                self._emit("log", f"✗ {e}", level="error")
                return {"code": -1, "message": str(e), "data": None}
            except Exception as e:  # noqa: BLE001
                self._emit("log", f"✗ 异常：{type(e).__name__}: {e}", level="error")
                return {"code": -2, "message": f"{type(e).__name__}: {e}", "data": None}

    def resume(self, run_code: str) -> Dict[str, Any]:
        """断点续传：不重新生成数据，只补齐上传与结算"""
        try:
            out = self.client.resume_run(run_code)
            self.store.finish_run(run_code, source="resume")
            up: Dict[str, Any] = {"points": out.get("points"),
                                  "checkpoints": out.get("checkpoints"),
                                  "finish": out.get("finish")}
            steps_out = out.get("steps")
            if isinstance(steps_out, list):
                if len(steps_out) > 0:
                    up["steps"] = steps_out[0]
                if len(steps_out) > 1:
                    up["paces"] = steps_out[1]
            brief = self._upload_summary(run_code, {k: v for k, v in up.items() if v})
            self.last = {**self.last, "run_code": run_code, "upload": brief,
                         "valid": (self.store.get_run(run_code) or {}).get("valid") or {}}
            self._emit("auto_done", f"续传完成：{run_code}", run_code=run_code,
                       result=out, **{k: v for k, v in self.last.items() if k != "upload"},
                       upload=brief)
            return out
        except Exception as e:  # noqa: BLE001
            self._emit("log", f"✗ 续传失败：{e}", level="error")
            return {"code": -1, "message": str(e), "data": None}

    # ══════════════════ 导出 ══════════════════
    def export_gpx(self, run_code: str) -> str:
        pts = self.store.get_points(run_code, None)
        parts = ['<?xml version="1.0" encoding="UTF-8"?>',
                 '<gpx version="1.1" creator="shandong-school_cracked" '
                 'xmlns="http://www.topografix.com/GPX/1/1">',
                 f'  <trk><name>{run_code}</name><trkseg>']
        for p in pts:
            t = time.strftime("%Y-%m-%dT%H:%M:%SZ", time.gmtime(p.collect_time / 1000.0))
            parts.append(f'    <trkpt lat="{p.lat:.6f}" lon="{p.lng:.6f}"><time>{t}</time>'
                         f'</trkpt>')
        parts += ['  </trkseg></trk>', '</gpx>']
        return "\n".join(parts)

    def export_json(self, run_code: str) -> Dict[str, Any]:
        run = self.store.get_run(run_code) or {}
        return {
            "run": run,
            "points": [p.to_upload_dict() for p in self.store.get_points(run_code, None)],
            "steps": [s.to_upload_dict() for s in self.store.get_steps(run_code, False)],
            "paces": [p.to_upload_dict() for p in self.store.get_paces(run_code, False)],
            "checkpoints": self.store.get_checkpoints(run_code),
            "upload_log": self.store.get_upload_log(run_code, 200),
        }
