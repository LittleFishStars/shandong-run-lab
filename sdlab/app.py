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
from .mock import MockServer, MockWorld
from .store import RecordStore


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
        self.bus.subscribe(self._on_event)

    def _on_event(self, ev: Dict[str, Any]) -> None:
        if ev.get("kind") == "progress":
            self._progress = {
                "percent": int(ev.get("percent", 0)),
                "message": str(ev.get("message", "")),
                "running": self._progress.get("running", False),
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
