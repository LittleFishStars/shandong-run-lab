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

from .constants import SPORT_TYPE_SUN, STATE_INIT
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
        self._pace_buf = self._new_pace_buf(0)
        self._step_buf: List[Dict[str, Any]] = []        # 正在累加的步频段
        self._step_segments: List[IntervalStep] = []     # 已切好的步频段（含未落库的）
        self._pace_segments: List[IntervalPace] = []     # 已切好的配速段（含未落库的）
        self.seg_step_s = 3.0                # 步频段时长（与客户端 stepInterval 3000ms 对齐）
        self.seg_pace_m = 1000.0             # 配速段距离（与 paceInterval 1000m 对齐）

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
        self.seg_step_s = float(self._wcfg("seg_step_s", self.seg_step_s) or self.seg_step_s)
        self.seg_pace_m = float(self._wcfg("seg_pace_m", self.seg_pace_m) or self.seg_pace_m)
        if sim is None:
            from .simulator import FuckRunSim
            sim = FuckRunSim(min_cadence=c_lo, max_cadence=c_hi,
                             dropout_rate=float((self.cfg.get("sim") or {}).get("dropout_rate", 0.0) or 0.0))
        w = Walker(sim=sim, sample_s=sample_s)
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
            # 步频段缓冲用「起点零点」打底：采样点每 3 秒才来一个，
            # 不播种的话第一段永远是空的，0~3 秒的步数会凭空消失
            self._step_buf = [{"abs_sec": 0.0, "abs_dist_m": 0.0, "abs_steps": 0,
                               "start_ms": self.started_ms}]
            self._pace_buf = self._new_pace_buf(self.started_ms)
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
        # 尾段口径与一键跑一致：build_steps() 也会把不足 3 秒的尾巴切成最后一段，
        # 但不能凭空造段——一点都没动过（step_buf 空）就不切
        # 尾部只用「已走过的尾巴」补段：缓冲里只剩播种点时不算走过
        if len(self._step_buf) > 1:
            self._close_step_segment()
        self._flush_pace()
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
        self._record_segments(meta)

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
            self._pace_buf = self._new_pace_buf(0)
            self._step_buf = []
            self._step_segments = []
            self._pace_segments = []
            self.started_at = 0.0
            self.stopped_at = 0.0
            self.finished_result = {}
            self.error = ""
            self.run_code = ""
        return self.status()

    # ══════════════════ 分段切分（步频 3s / 配速 1000m） ══════════════════
    def _new_pace_buf(self, start_ms: int) -> Dict[str, Any]:
        return {"start_dist": 0.0, "start_sec": 0.0, "start_steps": 0, "start_ms": int(start_ms)}

    def _record_segments(self, meta: Sequence[Dict[str, Any]]) -> None:
        """把采样点的分段元数据切成步频段（3 秒）与配速段（1000 米）并落库

        一键跑是一次性算完再切段；手动实走只能边跑边切，所以用每个采样点自带的
        累计距离/运动时长/累计步数做差，切出来的段与客户端 stepInterval /
        paceInterval 的口径一致。
        """
        if not meta:
            return
        items = list(meta)
        for i, m in enumerate(items):
            self._step_buf.append(m)
            sec = float(m.get("abs_sec") or 0.0) - float(self._step_buf[0].get("abs_sec") or 0.0)
            # 只在满 3 秒时切一刀；不足的留在缓冲里等下一次（收尾时 stop() 补切），
            # 否则每个采样点都会被切成一段，等于把步频段打碎成 3 秒级碎片
            if sec >= self.seg_step_s - 1e-9:
                self._close_step_segment()
            dist = float(m.get("abs_dist_m") or 0.0) - float(self._pace_buf.get("start_dist") or 0.0)
            if dist >= self.seg_pace_m:
                self._close_pace_segment(m)

    def _close_step_segment(self) -> None:
        buf = self._step_buf
        if not buf:
            return
        first, last = buf[0], buf[-1]
        s0 = int(first.get("abs_steps") or 0)
        s1 = int(last.get("abs_steps") or 0)
        t0 = float(first.get("abs_sec") or 0.0)
        t1 = float(last.get("abs_sec") or 0.0)
        seg = IntervalStep(
            start_step=s0, end_step=s1,
            start_time=self.started_ms + int(t0 * 1000),
            end_time=self.started_ms + int(t1 * 1000),
            step=max(0, s1 - s0),
            time=max(1, int(round((t1 - t0) * 1000))),
            step_index=len(self._step_segments),
            run_code=self.run_code if self.mode == "real" else "",
        )
        self._step_segments.append(seg)
        if self.mode == "real" and self.store and self.run_code:
            if self.store.add_steps(self.run_code, [seg]) > 0:
                self.steps_total += 1
        # 与 build_steps() 同口径：切点就是下一段的起点（回填而不是清空），
        # 采样点本来就是每 3 秒一个，清空会让段长被撑成 6 秒、段数减半
        self._step_buf = [last]

    def _close_pace_segment(self, m: Dict[str, Any]) -> None:
        buf = self._pace_buf
        end_dist = float(m.get("abs_dist_m") or 0.0)
        end_sec = float(m.get("abs_sec") or 0.0)
        end_steps = int(m.get("abs_steps") or 0)
        seg = IntervalPace(
            distance=int(round(end_dist)),
            start_distance=int(round(float(buf.get("start_dist") or 0.0))),
            end_distance=int(round(end_dist)),
            step_count=end_steps,
            start_step_count=int(buf.get("start_steps") or 0),
            end_step_count=end_steps,
            time=max(1, int(round((end_sec - float(buf.get("start_sec") or 0.0)) * 1000))),
            start_time=self.started_ms + int(float(buf.get("start_sec") or 0.0) * 1000),
            end_time=self.started_ms + int(end_sec * 1000),
            pace_index=len(self._pace_segments),
            run_code=self.run_code if self.mode == "real" else "",
        )
        self._pace_segments.append(seg)
        if self.mode == "real" and self.store and self.run_code:
            if self.store.add_paces(self.run_code, [seg]) > 0:
                self.paces_total += 1
        self._pace_buf = self._new_pace_buf(self.started_ms)
        self._pace_buf.update({"start_dist": end_dist, "start_sec": end_sec,
                               "start_steps": end_steps})
    def _flush_pace(self) -> None:
        """收尾：把不足 1000 米的尾段也补成一段（与一键跑的 generate_paces 一致）"""
        w = self.walker
        if not w:
            return
        start_dist = float(self._pace_buf.get("start_dist") or 0.0)
        if w.dist_m - start_dist <= 0.5:
            return
        self._close_pace_segment({"abs_dist_m": w.dist_m, "abs_sec": w.move_sec,
                                  "abs_steps": int(w.state().steps)})

    def _stride_exceptions(self, steps: Sequence[IntervalStep], stride: float) -> int:
        """按段统计步幅异常数（与 engine 同口径：等效速度越界就算异常）"""
        bad = 0
        for s in steps:
            secs = max(0.001, s.time / 1000.0)
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
            "radius_m": float(cp.get("radius_m") or 12.0),
            "passed": int(cp.get("passed") or 0),
        })
    return out


__all__ = ["WalkSession", "build_walk_targets", "route_from_checkpoints",
           "DEFAULT_SPEED_MPS", "SAMPLE_INTERVAL_S"]
