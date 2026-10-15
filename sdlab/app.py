#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""应用层：把配置、事件总线、本地记录、Mock 服务端、业务客户端与跑步引擎装到一起

GUI 与 CLI 都只实例化这一个对象：
    app = App()
    app.login("13800138000", "password")
    app.run_auto(target_m=2000)        # 后台线程跑完整流程
    app.bus.events_since(seq)          # 前端轮询事件流
"""
from __future__ import annotations

import json
import os
import threading
import time
from pathlib import Path
from typing import Any, Dict, List, Optional

from .bus import ConfigStore, EventBus, default_data_dir
from .client import ShandongClient
from .engine import RunEngine
from .protocol import haversine
from .mock import MockServer, MockWorld
from .store import RecordStore
from .walk import WalkSession, build_walk_targets
from .walker import route_from_checkpoints


class App:
    """桌面应用的运行时容器（单实例足够）"""

    def __init__(self, config_path: Optional[Path] = None,
                 data_dir: Optional[Path] = None):
        # 数据目录优先级：显式参数 > 环境变量 SDLAB_HOME > 用户数据目录
        # （环境变量是给便携/沙箱环境用的，避免往 HOME 写）
        if data_dir is None:
            env_dir = os.environ.get("SDLAB_HOME", "").strip()
            data_dir = Path(env_dir) if env_dir else None
        self.data_dir = Path(data_dir) if data_dir else default_data_dir()
        self.data_dir.mkdir(parents=True, exist_ok=True)
        self.bus = EventBus(log_file=self.data_dir / "app.log")
        self.cfg_store = ConfigStore(config_path)
        self.cfg: Dict[str, Any] = self.cfg_store.as_dict()
        self.store = RecordStore(self.data_dir / "records.db")
        self.mode: str = str(self.cfg.get("mode", "mock"))

        self._mock: Optional[MockServer] = None
        self.world: Optional[MockWorld] = None
        self.client: ShandongClient = None            # type: ignore[assignment]
        self.engine: RunEngine = None                 # type: ignore[assignment]
        self.walk: WalkSession = None                 # type: ignore[assignment]  # 摇杆实走会话
        # 用户在地图上点出来（或“仅渲染路径点”生成）的待用路线，开走时交给 Walker
        self._pending_route: List[List[float]] = []
        self._pending_auto: bool = True
        self._thread: Optional[threading.Thread] = None
        self._last_result: Dict[str, Any] = {}
        self._progress: Dict[str, Any] = {"percent": 0, "message": "就绪", "running": False}

        self._build()
        self.bus.emit("state", f"运行模式：{'本地 Mock（离线可跑）' if self.is_local else '真实服务端'}")

    # ══════════════════ 组装 ══════════════════
    def _build(self) -> None:
        base_url = None
        if self.mode == "mock":
            base_url = self.start_mock()
        self.client = ShandongClient(self.cfg, bus=self.bus, store=self.store,
                                     base_url=base_url)
        self.client.local_mode = (self.mode == "mock")
        self.engine = RunEngine(self.client, self.cfg, self.bus)
        # 摇杆实走会话与引擎共用同一个 store/bus：实跑模式落的库就是 engine 后续要上传的库
        self.walk = WalkSession(self.cfg, bus=self.bus, store=self.store, engine=self.engine)
        self.bus.subscribe(self._on_event)

    def _on_event(self, ev: Dict[str, Any]) -> None:
        # 任何事件只要带着 run_code，就记下来：界面跑步中要靠它拉轨迹画地图。
        _rc = (ev.get("data") or {}).get("run_code")
        if _rc:
            self._progress = {**self._progress, "run_code": str(_rc)}
        if ev.get("kind") == "progress":
            # 注意：EventBus.emit(kind, msg, **data) 把附加字段放在 ev["data"] 里，
            # percent 不在事件顶层——直接读 ev.get("percent") 永远是 0，进度条就不会动。
            _d = ev.get("data") or {}
            # 用 {**self._progress, ...} 合并而不是新建字典：否则会把上面记下的
            # run_code（还有 running）冲掉，界面跑步中就拉不到轨迹画地图。
            self._progress = {
                **self._progress,
                "percent": int(_d.get("percent", 0)),
                "message": str(ev.get("message", "") or _d.get("message", "")),
                "ts": ev.get("ts"),
            }
        elif ev.get("kind") == "auto_done":
            self._progress = {**self._progress, "percent": 100, "running": False}
            # 把事件 data 里的业务字段平铺到顶层（run_code / distance_m / upload …），
            # 同时保留原始事件，便于前端与脚本直接取用。
            _payload = dict(ev.get("data") or {})
            _payload.setdefault("message", str(ev.get("message", "")))
            _payload["event"] = dict(ev)
            self._last_result = _payload
        elif ev.get("kind") == "log" and ev.get("level") == "error":
            self._progress = {**self._progress, "running": False}

    @property
    def is_local(self) -> bool:
        return self.mode == "mock"

    # ══════════════════ Mock 服务端 ══════════════════
    def start_mock(self) -> str:
        if self._mock:
            return self._mock.base_url
        self.world = MockWorld(bus=self.bus, latency_ms=int(self.cfg.get("mock_latency_ms", 0)),
                               fail_rate=float(self.cfg.get("mock_fail_rate", 0.0)))
        self._mock = MockServer(self.world, port=int(self.cfg.get("mock_port", 0)))
        url = self._mock.start()
        self.bus.emit("state", f"本地 Mock 服务端：{url}")
        return url

    def stop_mock(self) -> None:
        if self._mock:
            self._mock.stop()
            self._mock = None
            self.bus.emit("state", "Mock 服务端已停止")

    def switch_mode(self, mode: str) -> Dict[str, Any]:
        mode = "mock" if str(mode).lower() == "mock" else "real"
        if mode == self.mode:
            return {"mode": self.mode}
        self.client.logout()
        self.client = None  # type: ignore[assignment]
        if mode == "real":
            self.stop_mock()
            self.mode = "real"
            self._build()
        else:
            self.mode = "mock"
            self._build()
        self.cfg_store.set("mode", mode)
        self.cfg_store.save()
        self.bus.emit("state", f"已切换到{'本地 Mock' if mode == 'mock' else '真实服务端'}模式"
                              f"（会话已重置，请重新登录）")
        return {"mode": self.mode}

    # ══════════════════ 配置 ══════════════════
    def patch_config(self, patch: Dict[str, Any]) -> Dict[str, Any]:
        # 前端（web/app.js）直接送的是 JSON 串，桌面壳可能送 dict——两种都收
        if isinstance(patch, str):
            try:
                patch = json.loads(patch or "{}")
            except Exception as e:  # noqa: BLE001
                self.bus.emit("log", f"✗ 配置补丁不是合法 JSON：{e}", level="error")
                return {"error": f"配置补丁不是合法 JSON：{e}"}
        if not isinstance(patch, dict):
            return {"error": "配置补丁必须是 JSON 对象"}
        self.cfg_store.update(patch)
        self.cfg_store.save()
        self.cfg = self.cfg_store.as_dict()
        self.engine.cfg = self.cfg
        self.client.cfg = self.cfg
        self.client.transport.cfg = self.cfg
        if "device" in patch or "device_id" in patch:
            self.client.transport.device_id = str(self.cfg.get("device_id", "")) or \
                self.client.transport.device_id
        self.bus.emit("state", "配置已保存")
        return self.cfg

    def reset_device(self) -> Dict[str, Any]:
        from .simulator import random_device_id
        did = random_device_id()
        self.patch_config({"device_id": did})
        self.client.transport.device_id = did
        self.bus.emit("state", f"已生成新的 deviceId：{did}")
        return {"device_id": did}

    # ══════════════════ 状态快照（GUI 首屏用） ══════════════════
    def status(self) -> Dict[str, Any]:
        c = self.client
        return {
            "mode": self.mode,
            "mock_url": (self._mock.base_url if self._mock else ""),
            "mock_world": (self.world.snapshot() if self.world and hasattr(self.world, "snapshot")
                           else {}),
            "logged_in": bool(c.logged_in),
            "user": c.user,
            "device_id": c.transport.device_id,
            "device": self.cfg.get("device", {}),
            "run_cfg": self.cfg.get("run", {}),
            "sim_cfg": self.cfg.get("sim", {}),
            "fences": c.fences,
            "fence": c.fence,
            "fence_polygon": c.fence_polygon(),
            "rule": c.rule.to_dict(),
            "checkpoints": c.store.get_checkpoints((self._last_code() or "")) or
                           (self.engine.checkpoints if self.engine else []),
            "progress": self._progress,
            "stats": self.store.stats(),
            "last": self._last_result,
            "data_dir": str(self.data_dir),
            "config_path": str(self.cfg_store.path),
            # 配置目录只读时（沙箱、容器）界面上要能看见，不然“保存参数”看着成功其实没落盘
            "config_save_error": self.cfg_store.save_error,
            "config_writable": self.cfg_store.save_error is None,
            "version": _version(),
        }

    def _last_code(self) -> str:
        code = str((self._last_result or {}).get("run_code") or "")
        if code:
            return code
        runs = self.store.list_runs(limit=1)
        return str(runs[0]["run_code"]) if runs else ""

    # ══════════════════ 登录 ══════════════════
    def login(self, phone: str, password: str = "", do_captcha: bool = True) -> Dict[str, Any]:
        try:
            res = self.client.login(phone, password, do_captcha=do_captcha)
            return res
        except Exception as e:  # noqa: BLE001
            self.bus.emit("log", f"✗ 登录异常：{type(e).__name__}: {e}", level="error")
            return {"code": -1, "message": f"{type(e).__name__}: {e}", "data": None}

    def logout(self) -> Dict[str, Any]:
        self.client.logout()
        return {"code": 0, "message": "已退出", "data": None}

    # ══════════════════ 跑一次（后台线程） ══════════════════
    def run_auto(self, target_m: Optional[float] = None, fence_index: int = 0,
                 seed: Optional[int] = None, do_upload: bool = True,
                 do_finish: bool = True, sport_type: int = 1) -> Dict[str, Any]:
        if self._thread and self._thread.is_alive():
            return {"code": -1, "message": "已有任务在运行", "data": None}
        if not self.client.logged_in:
            return {"code": -1, "message": "请先登录", "data": None}
        self._progress = {"percent": 0, "message": "任务已启动", "running": True}

        def _work() -> None:
            try:
                self.engine.auto(target_m=target_m, fence_index=fence_index, seed=seed,
                                 do_upload=do_upload, do_finish=do_finish,
                                 sport_type=sport_type, mode="sim")
            finally:
                self._progress = {**self._progress, "running": False}

        self._thread = threading.Thread(target=_work, name="auto-run", daemon=True)
        self._thread.start()
        return {"code": 0, "message": "任务已启动", "data": None}

    def run_prepare(self) -> Dict[str, Any]:
        try:
            return {"code": 0, "message": "ok", "data": self.engine.prepare()}
        except Exception as e:  # noqa: BLE001
            self.bus.emit("log", f"✗ 准备失败：{e}", level="error")
            return {"code": -1, "message": str(e), "data": None}

    def resume(self, run_code: str = "") -> Dict[str, Any]:
        code = run_code or self._last_code()
        if not code:
            return {"code": -1, "message": "没有可续传的记录", "data": None}
        if self._thread and self._thread.is_alive():
            return {"code": -1, "message": "已有任务在运行", "data": None}
        self._thread = threading.Thread(target=self.engine.resume, args=(code,), daemon=True)
        self._thread.start()
        return {"code": 0, "message": f"续传已启动：{code}", "data": None}

    def running(self) -> bool:
        return bool(self._thread and self._thread.is_alive())

    # ══════════════════ 摇杆实走（手动控制路径） ══════════════════
    def walk_start(self, mode: str = "dry", target_m: float = 0.0,
                   fence_index: int = 0, speed_mps: float = 0.0,
                   auto_route: bool = False, auto_start: bool = False,
                   speed: float = 0.0) -> Dict[str, Any]:
        """开始一次手动实走

        mode='dry' 干跑：不升跑、不落库、不上传，纯调试路径；
        mode='real' 实跑：auto_start 时会先调 engine.start() 拿 runRecordCode，
                         然后轨迹实时写进同一库，叫停后可原地上传结算。
        targets 默认取「当前围栏内的打卡点」，没有就现场推导一份（与一键跑同源）。
        """
        if not self.client.logged_in:
            return {"code": -1, "message": "请先登录", "data": None}
        try:
            self.engine.prepare(fence_index=int(fence_index))
        except Exception as e:  # noqa: BLE001
            self.bus.emit("log", f"✗ 实走前准备失败：{e}", level="error")
            return {"code": -1, "message": str(e), "data": None}

        lat, lng = self.client.fence_center()
        run_code = ""
        mode = "real" if str(mode).lower() == "real" else "dry"
        if mode == "real" and auto_start:
            try:
                run_code = self.engine.start(target_m=target_m, fence_index=int(fence_index))
            except Exception as e:  # noqa: BLE001
                self.bus.emit("log", f"✗ 实跑开跑失败：{e}", level="error")
                return {"code": -1, "message": str(e), "data": None}
            self._progress = {"percent": 0, "message": "实跑已开始", "running": True,
                              "run_code": run_code}

        cps = self.engine.checkpoints or []
        # 优先用用户在地图上点出来/“仅渲染路径点”生成的那条路线，没有才回到默认闭环
        route = list(getattr(self, "_pending_route", None) or [])
        if not route and cps:
            route = route_from_checkpoints(lat, lng, cps, loop=True)
        return self.walk.start(
            mode, lat=lat, lng=lng, target_m=float(target_m or 0),
            speed_mps=(float(speed_mps) if speed_mps else None),
            route=route, auto_route=bool(auto_route or self._pending_auto),
            targets=build_walk_targets(cps),
            polygon=self.client.fence_polygon(),
            run_code=run_code,
            speed=(float(speed) if speed else None))

    def walk_joystick(self, dx: float, dy: float, mag: float) -> Dict[str, Any]:
        return self.walk.joystick(float(dx), float(dy), float(mag))

    def walk_stop(self) -> Dict[str, Any]:
        out = self.walk.stop()
        self._progress = {**self._progress, "running": False, "percent": 0}
        return out

    def walk_status(self, since: int = -1) -> Dict[str, Any]:
        return self.walk.status(None if int(since) < 0 else int(since))

    def walk_route(self, waypoints: Optional[List[Any]] = None,
                   auto: bool = True, targets: bool = False) -> Dict[str, Any]:
        """设置手动路径。

        waypoints 为空且 targets=True 时，自动按「起点→打卡点（最近邻）→回起点」
        生成一条可走的闭环——即“只渲染路径点、不一键跑完”所需的那条线。
        """
        wps: List[List[float]] = []
        for p in (waypoints or []):
            try:
                if isinstance(p, dict):
                    wps.append([float(p["lat"]), float(p["lng"])])
                else:
                    wps.append([float(p[0]), float(p[1])])
            except (TypeError, IndexError, KeyError, ValueError):
                continue
        if not wps and targets:
            try:
                lat, lng = self.client.fence_center()
            except Exception:  # noqa: BLE001
                lat, lng = 0.0, 0.0
            wps = route_from_checkpoints(lat, lng, self.engine.checkpoints or [], loop=True)
        # 还没开走也能先规划：此时只记在 engine.last 里，开走时再交给 Walker
        self._pending_route = wps
        self._pending_auto = bool(auto)
        if self.walk.walker:
            return self.walk.set_route(wps, auto=auto)
        return {"code": 0, "data": {"route": wps, "auto": bool(auto), "staged": True}}

    def walk_upload(self, do_finish: bool = True) -> Dict[str, Any]:
        """叫停后上传：把实跑落的库走与一键跑完全相同的上传链路并结算"""
        rc = self.walk.run_code
        if not rc:
            return {"code": -1, "message": "没有实跑记录可上传（干跑模式不落库）", "data": None}
        if not self.client.logged_in:
            return {"code": -1, "message": "请先登录", "data": None}

        def _work() -> None:
            try:
                out = self.engine.upload(rc)
                if out.get("points", {}).get("code") != 0:
                    self.bus.emit("log", "✗ 轨迹上传中断，可稍后断点续传", level="error")
                if do_finish:
                    self.engine.finish(rc, sun=True)
                    self.store.finish_run(rc, source="walk")
                summary = self.engine.last
                self._last_result = {**(summary or {}), "run_code": rc, "source": "walk"}
                self._progress = {**self._progress, "percent": 100, "running": False}
            except Exception as e:  # noqa: BLE001
                self.bus.emit("log", f"✗ 实跑上传失败：{e}", level="error")
                self._progress = {**self._progress, "running": False}

        if self._thread and self._thread.is_alive():
            return {"code": -1, "message": "已有任务在运行", "data": None}
        self._progress = {**self._progress, "percent": 55, "running": True, "run_code": rc}
        self._thread = threading.Thread(target=_work, name="walk-upload", daemon=True)
        self._thread.start()
        return {"code": 0, "message": f"已开始上传结算：{rc}", "data": {"run_code": rc}}

    def walk_save(self, name: str = "", polygon: Optional[List[Any]] = None) -> Dict[str, Any]:
        """把本次手动路径存成库里的草稿记录（不升跑、不上传，供反复调试）"""
        st = self.walk.status()
        pts = self.walk.all_points()
        if not pts and not (st.get("targets") or []):
            return {"code": -1, "message": "没有可保存的路径点", "data": None}
        code = str(st.get("run_code") or "").strip() or f"WALK-{int(time.time())}"
        if not self.store.get_run(code):
            f = dict(self.client.fence or {})
            self.store.create_run(code, source="walk", sport_type=1,
                                  fence_code=str(f.get("fenceCode") or ""),
                                  fence_name=str(f.get("fenceName") or ""))
        if self.store.get_checkpoints(code) == [] and self.client.fence is not None:
            self.store.add_checkpoints(code, self.engine.checkpoints)
        for i, p in enumerate(pts):
            p.lat_lng_index = int(i)   # 重新编号：草稿必须是 0..n-1 连续，否则续传定位会错
            p.run_code = code
        if pts:
            self.store.add_points(code, pts)
        self.store.finish_run(code, distance_m=float(st["state"].get("dist_m") or 0),
                              duration_s=float(st["state"].get("move_sec") or 0),
                              total_step=int(st["state"].get("steps") or 0),
                              source="walk")
        self.bus.emit("state", f"路径草稿已保存：{code}（{len(pts)} 点）")
        return {"code": 0, "message": f"已保存为 {code}",
                "data": {"run_code": code, "points": len(pts), "name": str(name or "")}}

    def walk_plan(self) -> Dict[str, Any]:
        """“只渲染路径点、不一键跑完”：仅做本地几何规划，不升跑、不落库、不上传。

        返回起点、打卡点序列、围栏多边形、规划路线（含逐段长度与总长）以及
        “跑完全程至少需要多少秒”的预估；后者用来判断目标距离是否够用。
        """
        c = self.client
        try:
            lat, lng = c.fence_center()
        except Exception:  # noqa: BLE001
            lat, lng = 0.0, 0.0
        cps = [dict(x) for x in (self.engine.checkpoints or [])]
        route = route_from_checkpoints(lat, lng, cps, loop=True) if cps else []
        legs: List[Dict[str, Any]] = []
        total = 0.0
        prev = (lat, lng)
        for i, p in enumerate(route):
            d = haversine(prev[0], prev[1], float(p[0]), float(p[1]))
            total += d
            legs.append({"index": i, "lat": float(p[0]), "lng": float(p[1]),
                         "leg_m": round(d, 1)})
            prev = (float(p[0]), float(p[1]))
        stride = float((self.cfg.get("run") or {}).get("stride_m", 0.85) or 0.85)
        cadence = float((self.cfg.get("sim") or {}).get("max_cadence", 182.0) or 182.0)
        est_s = int(round((total / max(0.5, stride)) / (max(60.0, cadence) / 60.0)))
        return {
            "code": 0, "message": "ok",
            "data": {
                "start": {"lat": lat, "lng": lng},
                "checkpoints": cps,
                "fence_polygon": c.fence_polygon(),
                "fence": dict(c.fence or {}),
                "route": route,
                "legs": legs,
                "route_length_m": round(total, 2),
                "est_duration_s": est_s,
                "min_distance_m": round(total, 1),
                "planned": True,
            },
        }

    # ══════════════════ 记录查询 / 导出 ══════════════════
    def list_runs(self, limit: int = 100) -> List[Dict[str, Any]]:
        return self.store.list_runs(limit=limit)

    def run_detail(self, run_code: str) -> Dict[str, Any]:
        run = self.store.get_run(run_code)
        if not run:
            return {}
        pts = self.store.get_points(run_code, None)
        return {
            "run": run,
            "points": [{"lat": p.lat, "lng": p.lng, "index": p.lat_lng_index,
                        "collect_time": p.collect_time, "state": p.state,
                        "accuracy": p.accuracy, "speed": p.speed} for p in pts],
            "checkpoints": self.store.get_checkpoints(run_code),
            "steps": [s.to_upload_dict() for s in self.store.get_steps(run_code, False)],
            "paces": [p.to_upload_dict() for p in self.store.get_paces(run_code, False)],
            "upload_log": self.store.get_upload_log(run_code, 100),
            "counts": {
                "points": self.store.count_points(run_code),
                "points_uploaded": self.store.count_points(run_code, 8),
                "points_pending": self.store.count_points(run_code, 1),
                "points_failed": self.store.count_points(run_code, 4),
            },
        }

    def export(self, run_code: str, fmt: str = "json") -> Dict[str, Any]:
        """导出本地记录：成功返回 {code:0, path:...}；记录不存在时报错且不落空文件"""
        if not str(run_code or "").strip():
            return {"code": -1, "message": "请先选择一条记录", "path": ""}
        if not self.store.get_run(run_code):
            return {"code": -1, "message": f"本地没有这条记录：{run_code}", "path": ""}
        out_dir = self.data_dir / "exports"
        out_dir.mkdir(parents=True, exist_ok=True)
        if fmt == "gpx":
            p = out_dir / f"{run_code}.gpx"
            p.write_text(self.engine.export_gpx(run_code), encoding="utf-8")
        else:
            import json
            p = out_dir / f"{run_code}.json"
            p.write_text(json.dumps(self.engine.export_json(run_code), ensure_ascii=False,
                                    indent=2), encoding="utf-8")
        self.bus.emit("state", f"已导出：{p}")
        return {"code": 0, "path": str(p)}

    def delete_run(self, run_code: str) -> Dict[str, Any]:
        if not self.store.get_run(run_code):
            return {"code": -1, "message": f"本地没有这条记录：{run_code}"}
        self.store.delete_run(run_code)
        self.bus.emit("state", f"已删除本地记录：{run_code}")
        return {"code": 0}

    # ══════════════════ 事件轮询（前端用） ══════════════════
    def poll(self, seq: int = 0, limit: int = 300) -> Dict[str, Any]:
        return {
            "events": self.bus.events_since(int(seq), limit=int(limit)),
            "progress": self._progress,
            "running": self.running(),
            "logged_in": bool(self.client.logged_in),
        }

    def close(self) -> None:
        try:
            self.client.logout()
        except Exception:
            pass
        self.stop_mock()


def _version() -> str:
    from .constants import APP_VERSION
    return APP_VERSION
