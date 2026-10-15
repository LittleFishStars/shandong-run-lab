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

from .constants import SPORT_TYPE_SUN
from .protocol import RunLatLng
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

        self._points: List[RunLatLng] = []   # 全部点位（含未落库的，供预览与导出）
        self._stored = 0                     # 已落库的点数
        self._thread: Optional[threading.Thread] = None
        self._stop_flag = threading.Event()
        self._lock = threading.Lock()
        self._last_emit = 0.0
        self._last_emit_m = 0.0

    # ══════════════════ 配置读取 ══════════════════
    def _wcfg(self, key: str, default: Any) -> Any:
        """会话级配置：优先 walk 段，其次 sim 段（倍速/采样间隔沿用同一套习惯）"""
        walk_cfg = self.cfg.get("walk") or {}
        if key in walk_cfg:
            return walk_cfg[key]
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
            self.speed = max(0.1, float(speed if speed is not None
                                        else self._wcfg("speed", 1.0) or 1.0))
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
        self.pending = 0
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

    def _drain(self, w: Walker) -> None:
        """取走新采样点：干跑只留内存，实跑同时落库"""
        new_pts = w.drain_points()
        if not new_pts:
            return
        with self._lock:
            for p in new_pts:
                p.run_code = self.run_code if self.mode == "real" else ""
                self._points.append(p)
            if self.mode == "real" and self.store and self.run_code:
                # 直接切片落库：walker 内部已按全局序号递增 lat_lng_index，
                # 断点续传靠 idx 定位，保持与本地全量序号一致即可
                batch = self._points[self._stored:]
                if self.store.add_points(self.run_code, batch) > 0:
                    self._stored = len(self._points)
                    self.pending = 0
                else:
                    self.pending = len(self._points) - self._stored
            else:
                self.pending = len(self._points)

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
            self.started_at = 0.0
            self.stopped_at = 0.0
            self.finished_result = {}
            self.error = ""
            self.run_code = ""
        return self.status()

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
