#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""手动实走会话：把 `Walker` 挂到后台线程上，按真实时间推进并落库

与一键跑的区别（也是它存在的理由）：
  · 方向由**外部输入**决定——界面上的虚拟摇杆、键盘方向键、或点击地图画出的路点，
    而不是由几何算法一次算完；
  · 数据是**边跑边落库**的，所以能看到轨迹一节一节长出来，也能在任意时刻叫停；
  · 两种模式：
      dry   干跑：只推位置、只算数据、**不落库、不开跑、不上传**，纯粹用来调路径；
      real  实跑：先 `startSunRun` 拿到 runRecordCode，轨迹实时写进 SQLite，
            叫停后可选择上传与结算（走的是与一键跑完全相同的上传链路）。

线程模型：一个 daemon 线程按 `tick_s` 节拍醒来，把「真实流逝时间 × 倍速」喂给
`Walker.tick()`，再把新产生的采样点交给 `RecordStore`。界面通过 `status(since)`
增量拉取新点与实时状态，不依赖线程安全的事件顺序。
"""
from __future__ import annotations

import threading
import time
from typing import Any, Dict, List, Optional, Sequence

from .constants import (CHECKPOINT_HIT_RADIUS_M, PACE_INTERVAL_M,
                        SPORT_TYPE_SUN, STATE_INIT, STEP_INTERVAL_S)
from .protocol import (IntervalPace, IntervalStep, RunLatLng, evaluate_run)
from .simulator import FuckRunSim
from .store import RecordStore
from .walker import (DEFAULT_SPEED_MPS, SAMPLE_INTERVAL_S, TICK_DEFAULT_S, Walker,
                     WalkState, route_from_checkpoints)


class WalkSession:
    """一次手动实走会话（干跑 / 实跑）"""

    def __init__(self, cfg: Optional[Dict[str, Any]] = None, bus=None,
                 store: Optional[RecordStore] = None, engine=None):
        self.cfg = cfg or {}
        self.bus = bus
        self.store = store
        self.engine = engine

        self.walker: Optional[Walker] = None
        self.state: WalkState = WalkState()
        self.mode = "dry"                    # dry | real
        self.run_code = ""
        self.sport_type = SPORT_TYPE_SUN
        self.started_at = 0.0
        self.stopped_at = 0.0
        self.finished_result: Dict[str, Any] = {}
        self.error = ""
        self.speed = 1.0                     # 时间倍速（1 = 真实速度）
        self.tick_s = TICK_DEFAULT_S
        self.pending = 0                     # 尚未落库的点数
        self.hits_total = 0                  # 已命中打卡点数（内存口径，与库同步）
        self.steps_total = 0                 # 已落库的步频段数
        self.paces_total = 0                 # 已落库的配速段数
        self.started_ms = 0                  # 本次起跑的绝对起始时间（毫秒）
        self._step_segments: List[IntervalStep] = []     # 已从 Walker 取走的步频段
        self._pace_segments: List[IntervalPace] = []     # 已从 Walker 取走的配速段

        self._lock = threading.RLock()
        self._thread: Optional[threading.Thread] = None
        self._stop_flag = threading.Event()
        self._points: List[RunLatLng] = []   # 本次会话产生的全部轨迹点（内存镜像）
        self._stored = 0                     # 已落库的点数（= _points 的前缀长度）
        self._last_emit = 0.0                # 事件限频
        self._last_emit_m = 0.0

    # ══════════════════ 配置读取 ══════════════════
    def _wcfg(self, key: str, default: Any) -> Any:
        """会话级配置：优先 walk 段，其次 sim 段（倍速/采样间隔沿用同一套习惯）"""
        walk_cfg = self.cfg.get("walk") or {}
        if key in walk_cfg:
            return walk_cfg[key]
        # 倍速单独处理：绝不能回退到 sim.speed（那里默认 8 倍），
        # 否则手动实走会以 8 倍速吞掉时间，体感就是“跑得飞快”
        if key == "speed":
            return default
        sim_cfg = self.cfg.get("sim") or {}
        return sim_cfg.get(key, default)

    # ══════════════════ 生命周期 ══════════════════
    def start(self, mode: str = "dry", *, lat: float, lng: float,
              target_m: float = 0.0, speed_mps: Optional[float] = None,
              route: Optional[Sequence[Sequence[float]]] = None,
              auto_route: bool = False,
              targets: Optional[Sequence[Dict[str, Any]]] = None,
              polygon: Optional[Sequence[Sequence[float]]] = None,
              run_code: str = "", start_ms: Optional[int] = None,
              speed: Optional[float] = None, sim=None) -> Dict[str, Any]:
        """开始一次实走；`mode='real'` 时 run_code 必须已经开跑拿到"""
        self.stop(emit=False)
        self.mode = "real" if str(mode).lower() == "real" else "dry"
        if self.mode == "real" and not run_code:
            return {"code": -1, "message": "实跑模式需要先开跑拿到 runRecordCode"}

        c_lo = float(self._wcfg("min_cadence", 172.0) or 172.0)
        c_hi = float(self._wcfg("max_cadence", 182.0) or 182.0)
        sample_s = float(self._wcfg("sample_s", SAMPLE_INTERVAL_S) or SAMPLE_INTERVAL_S)
        # 推满杆的速度默认取 walk.speed_mps（2.5 m/s ≈ 9 km/h，正常慢跑手感）；
        # 以前直接接 Walker 的 2.78，配上误用的 8 倍速，体感就是“跑得飞快”
        if not speed_mps:
            speed_mps = float(self._wcfg("speed_mps", 0.0) or 0.0) or None
        # 分段口径来自原版 CommonConfig：stepInterval（秒）/ paceInterval（米）
        step_interval_s = int(self._wcfg("step_interval_s", STEP_INTERVAL_S) or STEP_INTERVAL_S)
        pace_interval_m = float(self._wcfg("pace_interval_m", PACE_INTERVAL_M) or PACE_INTERVAL_M)
        if sim is None:
            from .simulator import FuckRunSim
            sim = FuckRunSim(min_cadence=c_lo, max_cadence=c_hi,
                             dropout_rate=float((self.cfg.get("sim") or {}).get("dropout_rate", 0.0) or 0.0))
        w = Walker(sim=sim, sample_s=sample_s)
        w.step_interval_s = step_interval_s
        w.pace_interval_m = pace_interval_m
        # 服务端 common/getConfig 的真实阈值优先（实测 runFilterAccuracy=30）
        common_cfg = self.cfg.get("common", {}) or {}
        if common_cfg.get("runFilterAccuracy"):
            w.run_filter_accuracy = float(common_cfg["runFilterAccuracy"])
        if common_cfg.get("gpsFilterAccuracy"):
            w.gps_filter_accuracy = float(common_cfg["gpsFilterAccuracy"])
        if common_cfg.get("paceInterval"):
            w.pace_interval_m = float(common_cfg["paceInterval"])
        w.set_polygon(polygon or [])
        if speed_mps:
            w.set_target_speed(float(speed_mps))
        w.set_target_distance(float(target_m or 0.0))
        if targets:
            w.set_target_points(targets)
        if route:
            w.set_route(route)
        w.set_auto_route(bool(auto_route))
        w.start(lat=lat, lng=lng, reset=True, start_ms=start_ms)

        with self._lock:
            self.walker = w
            self.run_code = str(run_code or "")
            # 段里要带上 runRecordCode（原版 Y()/T() 都用 E() 填 RunCode）
            w.run_code = self.run_code
            self.started_at = time.time()
            self.stopped_at = 0.0
            self.finished_result = {}
            self.error = ""
            self._points = []
            self._stored = 0
            self.pending = 0
            self.hits_total = 0
            self.steps_total = 0
            self.paces_total = 0
            self.started_ms = int(start_ms or time.time() * 1000)
            # 段全部由 Walker 按原版口径切好（Q0() % stepInterval 切步频、
            # 超 paceInterval 封配速），会话层只保留已取走段的镜像用于计数与结算
            self._step_segments = []
            self._pace_segments = []
            # 倍速只认 walk.speed；传 0 表示“按配置”，而配置默认就是 1.0（真实时间）
            self.speed = max(0.1, float(speed if speed else self._wcfg("speed", 1.0) or 1.0))
            self.state = w.state()

        self._stop_flag.clear()
        self._thread = threading.Thread(target=self._loop, name="walk-session", daemon=True)
        self._thread.start()
        self._emit("walk_started",
                   f"手动实走开始（{'实跑 · ' + self.run_code if self.mode == 'real' else '干跑调试'}，"
                   f"{self.speed:g} 倍速）",
                   run_code=self.run_code, mode=self.mode, speed=self.speed,
                   state=self.state.to_dict())
        return {"code": 0, "message": "已开始实走", "data": self.status()}

    def stop(self, emit: bool = True) -> Dict[str, Any]:
        self._stop_flag.set()
        t = self._thread
        if t and t.is_alive() and threading.current_thread() is not t:
            t.join(timeout=1.5)
        self._thread = None
        if self.walker and self.walker.running:
            self.state = self.walker.stop()
            self.state = self.walker.state()
        if self.walker:
            self.state = self.walker.state()
        # 最后一步可能还没被循环 drain 到，补一次，否则停止时少一个采样点/少一段
        self._drain(self.walker)
        self.pending = 0
        # 原版结算时的尾段处理：不满一个 interval 的步频尾段与尚未封口的配速尾段
        # 都要带上（getTailSectionStepData() 与 J() 里的 tailPace）
        self._drain_tail_segments()
        self._persist_run_summary()
        if emit and self.started_at:
            self._emit("walk_stopped", f"手动实走已停止：{self.state.dist_m:.0f} 米 / "
                                       f"{self.state.steps} 步",
                       run_code=self.run_code, state=self.state.to_dict())
        return self.status()

    def _loop(self) -> None:
        """后台推进循环：真实流逝时间 × 倍速 喂给 Walker"""
        last = time.time()
        try:
            while not self._stop_flag.is_set():
                time.sleep(min(0.2, self.tick_s))
                now = time.time()
                dt = (now - last) * self.speed
                last = now
                w = self.walker
                if w is None:
                    break
                if not w.running:
                    self.state = w.state()
                    break
                self.state = w.tick(min(5.0, dt))
                self._drain(w)
                self._maybe_emit(now)
        except Exception as e:  # noqa: BLE001
            self.error = f"{type(e).__name__}: {e}"
            self._emit("log", f"✗ 手动实走异常：{self.error}", level="error")
        finally:
            if self.walker:
                self.state = self.walker.state()
            self.stopped_at = self.stopped_at or time.time()
            if self.state.arrived:
                self._emit("walk_arrived", f"手动实走结束：{self.state.arrived}",
                           run_code=self.run_code, state=self.state.to_dict())

    def _drain(self, w: Optional[Walker]) -> None:
        """取走新采样点：干跑只留内存，实跑同时落库"""
        if w is None:
            return
        new_pts = w.drain_points()
        meta = w.drain_meta()
        hits = w.drain_hits()
        if hits:
            self.hits_total += len(hits)
            if self.mode == "real" and self.store and self.run_code:
                for cp in hits:
                    self.store.mark_checkpoint_hit(
                        self.run_code, int(cp.get("index") or 0),
                        float(cp.get("hit_lat") or w.lat),
                        float(cp.get("hit_lng") or w.lng),
                        int(cp.get("hit_ms") or 0))
            self._emit("checkpoint",
                       f"✓ 已打卡 {self.hits_total}/{w.state().targets}",
                       run_code=self.run_code, hits=self.hits_total,
                       points=[{"index": int(c.get("index") or 0),
                                "lat": round(float(c.get("hit_lat") or 0), 6),
                                "lng": round(float(c.get("hit_lng") or 0), 6)} for c in hits])
        if not new_pts and not meta:
            return
        with self._lock:
            for p in new_pts:
                p.run_code = self.run_code if self.mode == "real" else ""
                self._points.append(p)
            if self.mode == "real" and self.store and self.run_code:
                batch = self._points[self._stored:]
                if batch and self.store.add_points(self.run_code, batch) > 0:
                    self._stored = len(self._points)
                self.pending = len(self._points) - self._stored
            else:
                self.pending = len(self._points)
        self._store_segments(w)

    def _maybe_emit(self, now: float) -> None:
        """限频发事件：每 1 秒或每 50 米一次，避免把事件流刷爆"""
        if now - self._last_emit < 1.0 and (self.state.dist_m - self._last_emit_m) < 50.0:
            return
        self._last_emit = now
        self._last_emit_m = self.state.dist_m
        self._emit("walk", f"实走中：{self.state.dist_m:.0f} 米 / {self.state.steps} 步 / "
                           f"{self.state.passed}/{self.state.targets} 打卡",
                   run_code=self.run_code, state=self.state.to_dict(),
                   percent=self.progress_percent())

    # ══════════════════ 输入 ══════════════════
    def joystick(self, dx: float, dy: float, mag: float) -> Dict[str, Any]:
        if not self.walker:
            return {"code": -1, "message": "尚未开始实走"}
        self.walker.set_joystick(dx, dy, mag)
        # 手动推杆时自动关掉路径跟随，否则两者会互相覆盖方向
        if mag > 0.02:
            self.walker.set_auto_route(False)
        return {"code": 0, "data": {"dx": dx, "dy": dy, "mag": mag}}

    def set_route(self, route: Sequence[Sequence[float]], auto: bool = True
                  ) -> Dict[str, Any]:
        if not self.walker:
            return {"code": -1, "message": "尚未开始实走"}
        self.walker.set_route(route)
        self.walker.set_auto_route(bool(auto))
        self._emit("state", f"已设置 {len(route or [])} 个路点，"
                            f"{'自动沿路径走' if auto else '仍然由摇杆控制'}")
        return {"code": 0, "data": {"route": [list(p) for p in (route or [])], "auto": auto}}

    def set_target_speed(self, mps: float) -> Dict[str, Any]:
        if not self.walker:
            return {"code": -1, "message": "尚未开始实走"}
        self.walker.set_target_speed(float(mps))
        self._emit("state", f"摇杆满速已设为 {float(mps):.2f} m/s")
        return {"code": 0, "data": {"speed_mps": self.walker.target_speed_mps}}

    # ══════════════════ 查询 ══════════════════
    def running(self) -> bool:
        return bool(self._thread and self._thread.is_alive())

    def progress_percent(self) -> int:
        """只有设了目标距离才谈得上百分比；否则按时间大致给一个观感值"""
        w = self.walker
        if not w:
            return 0
        if w.target_distance_m > 0:
            return int(min(100, 100 * w.dist_m / w.target_distance_m))
        return int(min(95, self.state.move_sec / 6.0))

    def points_since(self, since: int = 0, limit: int = 4000) -> Dict[str, Any]:
        """增量拉取轨迹点（界面用它一笔一笔画线）"""
        with self._lock:
            pts = self._points[int(since):]
            total = len(self._points)
        out = [p.to_upload_dict(index=i + int(since))
               for i, p in enumerate(pts[-int(limit):])] if pts else []
        return {"points": out, "total": total, "from": int(since)}

    def status(self, since: Optional[int] = None) -> Dict[str, Any]:
        data: Dict[str, Any] = {
            "running": self.running(),
            "mode": self.mode,
            "run_code": self.run_code,
            "speed": self.speed,
            "state": self.state.to_dict(),
            "percent": self.progress_percent(),
            "points": len(self._points),
            "stored": self._stored,
            "pending": self.pending,
            "hits": self.hits_total,
            "steps": self.steps_total,
            "paces": self.paces_total,
            "segments": {"steps": len(self._step_segments), "paces": len(self._pace_segments)},
            "elapsed": round(time.time() - self.started_at, 2) if self.started_at else 0.0,
            "error": self.error,
            "finished": self.finished_result,
            "targets": [dict(c) for c in (self.walker.targets if self.walker else [])],
        }
        if since is not None:
            data.update(self.points_since(int(since)))
        return data

    def all_points(self) -> List[RunLatLng]:
        with self._lock:
            return list(self._points)

    def summary(self) -> Dict[str, Any]:
        w = self.walker
        if not w:
            return {}
        out = w.summary()
        out["mode"] = self.mode
        out["run_code"] = self.run_code
        out["elapsed_s"] = round((self.stopped_at or time.time()) - self.started_at, 2)
        out["stored"] = self._stored
        out["sim"] = w.sim.state().to_dict()
        out["checkpoints"] = [dict(c) for c in w.targets]
        return out

    def reset(self) -> Dict[str, Any]:
        self.stop(emit=False)
        with self._lock:
            self.walker = None
            self.state = WalkState()
            self._points = []
            self._stored = 0
            self.pending = 0
            self.hits_total = 0
            self.steps_total = 0
            self.paces_total = 0
            self.started_ms = 0
            self._step_segments = []
            self._pace_segments = []
            self.started_at = 0.0
            self.stopped_at = 0.0
            self.finished_result = {}
            self.error = ""
            self.run_code = ""
        return self.status()

    # ══════════════════ 分段落库（照抄 ApiDataComponent Y() / T()） ══════════════════
    def _store_segments(self, w: Optional[Walker]) -> None:
        """取走 Walker 按原版口径切好的段并落库

        步频段来自 Y1()（Q0() % stepInterval == 0 切一刀）；
        配速段来自 W1() 末尾的 y2() → h0()，同一段会被反复“就地延长”，
        所以按 idx 去重后整体 upsert（store.add_paces 本身就是 ON CONFLICT DO UPDATE）。
        """
        if w is None:
            return
        steps = w.drain_step_segments()
        if steps:
            with self._lock:
                seen = {int(x.step_index) for x in self._step_segments}
                for s in steps:
                    if int(s.step_index) in seen:
                        self._step_segments[[int(x.step_index) for x in self._step_segments].index(int(s.step_index))] = s
                    else:
                        self._step_segments.append(s)
                        seen.add(int(s.step_index))
            if self.mode == "real" and self.store and self.run_code:
                self.store.add_steps(self.run_code, steps)
                with self._lock:
                    self.steps_total = len(self._step_segments)
        paces = w.drain_pace_segments()
        if not paces:
            return
        uniq: Dict[int, IntervalPace] = {}
        for p in paces:
            uniq[int(p.pace_index)] = p
        fresh = [uniq[k] for k in sorted(uniq)]
        with self._lock:
            known = {int(p.pace_index): i for i, p in enumerate(self._pace_segments)}
            for p in fresh:
                i = known.get(int(p.pace_index))
                if i is None:
                    self._pace_segments.append(p)
                else:
                    self._pace_segments[i] = p
            if self.mode == "real" and self.store and self.run_code:
                self.paces_total = len(self._pace_segments)
        if self.mode == "real" and self.store and self.run_code:
            self.store.add_paces(self.run_code, fresh)

    def _drain_tail_segments(self) -> None:
        """收尾补段：照抄原版结算组装 J()

        · 步频尾段 = getTailSectionStepData()：不到一个 stepInterval 的那一截
        · 配速尾段 = run_pace 里最后一段尚未封口的（原版若 !isValid 就直接带上）
        """
        w = self.walker
        if w is None:
            return
        self._store_segments(w)
        tail_step = w.tail_step_data()
        if tail_step is not None and int(tail_step.step) > 0:
            with self._lock:
                self._step_segments.append(tail_step)
                self.steps_total = len(self._step_segments)
            if self.mode == "real" and self.store and self.run_code:
                self.store.add_steps(self.run_code, [tail_step])
        tail_pace = w._tail_pace
        if tail_pace is not None and int(tail_pace.distance) > 0:
            tail_pace.is_valid = True
            with self._lock:
                known = {int(p.pace_index): i for i, p in enumerate(self._pace_segments)}
                i = known.get(int(tail_pace.pace_index))
                if i is None:
                    self._pace_segments.append(tail_pace)
                else:
                    self._pace_segments[i] = tail_pace
                self.paces_total = len(self._pace_segments)
            if self.mode == "real" and self.store and self.run_code:
                self.store.add_paces(self.run_code, [tail_pace])

    def _stride_exceptions(self, steps: Sequence[IntervalStep], stride: float) -> int:
        """按段统计步幅异常数（与 engine 同口径：等效速度越界就算异常）

        段的时间字段是秒（与原版 IntervalStep.time 一致），所以直接当秒用。
        """
        bad = 0
        for s in steps:
            secs = max(0.001, float(s.time))
            derived = (s.step * stride) / secs
            if s.step <= 0 or derived < 0.6 or derived > 6.0:
                bad += 1
        return bad

    def _persist_run_summary(self) -> None:
        """实跑收尾：把距离/时长/步数/有效性写回 runs，干跑不碰库"""
        if self.mode != "real" or not self.store or not self.run_code or not self.walker:
            return
        w = self.walker
        s = w.summary()
        duration = int(round(s.get("duration_s") or 0))
        distance = float(s.get("distance_m") or 0)
        total_step = int(s.get("total_step") or 0)
        stride = float((self.cfg.get("run") or {}).get("stride_m", 0.85) or 0.85)
        pace = (duration / (distance / 1000.0)) if distance > 0 else 0.0
        validity: Optional[Dict[str, Any]] = None
        try:
            rule = self.engine.client.rule if self.engine is not None else None
            validity = evaluate_run(
                self.all_points(), duration, total_step, rule,
                stride_exception_segments=self._stride_exceptions(self._step_segments, stride),
                checkpoints_total=len(w.targets), checkpoints_done=self.hits_total,
                sport_type=self.sport_type).to_dict()
        except Exception as e:  # noqa: BLE001
            self.error = self.error or f"有效性判定失败：{type(e).__name__}: {e}"
        self.store.finish_run(
            self.run_code, end_ms=self.started_ms + int(duration * 1000),
            duration_s=duration, distance_m=round(distance, 2), total_step=total_step,
            pace_s_per_km=round(pace, 2), source="walk",
            **(({"status": int(validity["isValid"])}) if validity else {}),
            **(({"valid": validity}) if validity else {}))
        if validity is not None:
            self._emit("state",
                       f"手动实走记录完成：{distance:.0f} 米 / {total_step} 步 / "
                       f"打卡 {self.hits_total}/{len(w.targets)} / "
                       f"有效={validity.get('isValid')}",
                       run_code=self.run_code, valid=validity)

    # ══════════════════ 内部 ══════════════════
    def _emit(self, kind: str, msg: str, **data: Any) -> None:
        if self.bus:
            self.bus.emit(kind, msg, **data)


def build_walk_targets(checkpoints: Sequence[Dict[str, Any]]) -> List[Dict[str, Any]]:
    """把 store 里的打卡点转成 Walker 能吃的桩（保留 radius_m 与序号）"""
    out: List[Dict[str, Any]] = []
    for cp in checkpoints or []:
        if cp.get("lat") is None or cp.get("lng") is None:
            continue
        out.append({
            "index": int(cp.get("index", len(out))),
            "lat": float(cp["lat"]), "lng": float(cp["lng"]),
            "radius_m": float(cp.get("radius_m") or CHECKPOINT_HIT_RADIUS_M),
            "passed": int(cp.get("passed") or 0),
        })
    return out


__all__ = ["WalkSession", "build_walk_targets", "route_from_checkpoints",
           "DEFAULT_SPEED_MPS", "SAMPLE_INTERVAL_S"]
