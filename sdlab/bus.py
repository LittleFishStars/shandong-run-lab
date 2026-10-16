#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""应用运行时支撑：事件总线 + 配置持久化

GUI（Web 前端）通过 pywebview 暴露的 API 调用后端；后端把过程事件
（请求、响应、状态变化、日志）推给前端。这个文件提供那条通路，
以及不依赖数据库的轻量 JSON 配置存储。
"""
from __future__ import annotations

import json
import os
import threading
import time
from pathlib import Path
from typing import Any, Callable, Dict, List, Optional


# ══════════════════ 事件总线 ══════════════════
class EventBus:
    """线程安全的事件总线

    Web 前端通过 `on_events` 轮询消费；后端任意线程都可以 emit。
    事件同时写入内存环形缓冲（便于排查）与可选的日志文件。
    """

    def __init__(self, log_file: Optional[Path] = None, buffer_size: int = 2000):
        self._lock = threading.Lock()
        self._buffer: List[Dict[str, Any]] = []
        self._buffer_size = buffer_size
        self._seq = 0
        self._log_file = Path(log_file) if log_file else None
        self._handlers: List[Callable[[Dict[str, Any]], None]] = []
        if self._log_file:
            self._log_file.parent.mkdir(parents=True, exist_ok=True)

    # ── 订阅 ──
    def subscribe(self, handler: Callable[[Dict[str, Any]], None]) -> None:
        with self._lock:
            self._handlers.append(handler)

    # ── 发送 ──
    def emit(self, kind: str, message: str = "", **data: Any) -> Dict[str, Any]:
        ev = {
            "seq": self._next_seq(),
            "ts": int(time.time() * 1000),
            "time": time.strftime("%H:%M:%S"),
            "kind": kind,           # log / request / response / state / progress / result
            "message": message,
        }
        if data:
            ev["data"] = data
        with self._lock:
            self._buffer.append(ev)
            if len(self._buffer) > self._buffer_size:
                del self._buffer[:len(self._buffer) - self._buffer_size]
            handlers = list(self._handlers)
        for h in handlers:
            try:
                h(ev)
            except Exception:
                pass
        if self._log_file:
            try:
                with self._log_file.open("a", encoding="utf-8") as f:
                    f.write(json.dumps(ev, ensure_ascii=False) + "\n")
            except Exception:
                pass
        return ev

    def log(self, message: str, level: str = "info") -> Dict[str, Any]:
        return self.emit("log", message, level=level)

    def clear(self) -> None:
        with self._lock:
            self._buffer.clear()

    def events_since(self, seq: int = 0, limit: int = 400) -> List[Dict[str, Any]]:
        with self._lock:
            out = [e for e in self._buffer if e["seq"] > seq]
        return out[-limit:]

    def _next_seq(self) -> int:
        with self._lock:
            self._seq += 1
            return self._seq


# ══════════════════ 配置存储 ══════════════════
DEFAULT_CONFIG: Dict[str, Any] = {
    "mode": "mock",                 # mock 离线仿真 / real 真实服务端
    "base_url": "https://api.huachenjie.com/run-front",
    "transport": "direct",          # direct / proxy
    "proxy": "",
    "timeout": 20,
    "retry": 2,
    # 设备指纹（15 个公开 Build 字段 + 9 个公共报文字段）
    "device": {
        "model": "SM-A5460",
        "brand": "samsung",
        "manufacturer": "samsung",
        "device": "a54x",
        "product": "a54xnsxx",
        "board": "a54x",
        "hardware": "mt6985",
        "display": "RP1A.200720.012",
        "id": "TP1A.220624.014",
        "bootloader": "unknown",
        "fingerprint": "samsung/a54xnsxx/a54x:14/TP1A.220624.014:user/release-keys",
        "system_version": "14",
        "platform": "2",
        "channel": "other",
        "app_code": "SD001",
    },
    "device_id": "",                # 空则按 deviceId 三层降级算法生成
    # 跑步默认参数
    "run": {
        "target_distance_m": 2000,
        "target_seconds": 720,
        "stride_m": 0.85,
        "sample_s": 3.0,
        "upload_batch": 50,
    },
    # 仿真（FUCK-RUN- 移植）
    "sim": {
        "enabled": True,
        "min_cadence": 172.0,
        "max_cadence": 182.0,
        "accel_amplitude": 3.5,
        "jitter": 0.15,
        "dropout_rate": 0.0,        # 秒级概率，模拟隧道/丢星
        # 实时仿真：默认关（瞬间算完，适合自检）；打开后按真实时间推进数据写入，
        # 界面上能看到轨迹一笔笔画出来、进度条一格一格走——调试时很有用。
        "realtime": False,
        "speed": 8.0,              # 实时仿真的倍速（8 = 8 倍速，约 1/8 真实耗时）
    },
    # 摇杆实走（手动控制路径）
    "walk": {
        "speed_mps": 2.5,        # 推满杆时的速度：正常慢跑 2.2~2.8，别再快了
        "speed": 1.0,            # 时间倍速固定 1（真实时间）；绝不继承 sim.speed 的 8 倍
        "sample_s": 3.0,        # 定位回调间隔（原版 lj0.m(...,3000L,...)）
        "step_interval_s": 20,  # CommonConfig.stepInterval（秒）：Q0() % 20 == 0 切步频段
        "pace_interval_m": 50,  # CommonConfig.paceInterval（米）：超 50 米封一段配速
        "poi_interval_s": 15,   # CommonConfig.poiInterval（秒）：轨迹点上报节流
    },
}


def _deep_merge(base: Dict[str, Any], extra: Dict[str, Any]) -> Dict[str, Any]:
    out = dict(base)
    for k, v in (extra or {}).items():
        if isinstance(v, dict) and isinstance(out.get(k), dict):
            out[k] = _deep_merge(out[k], v)
        else:
            out[k] = v
    return out


class ConfigStore:
    """JSON 配置文件（默认 ~/.config/shandong-run-lab/config.json）"""

    def __init__(self, path: Optional[Path] = None):
        self.path = Path(path) if path else default_config_path()
        self.save_error: Optional[str] = None    # 配置写不进去时记下来，界面上可以提示
        self._data: Dict[str, Any] = dict(DEFAULT_CONFIG)
        self.load()

    def load(self) -> Dict[str, Any]:
        try:
            if self.path.exists():
                raw = json.loads(self.path.read_text(encoding="utf-8"))
                self._data = _deep_merge(DEFAULT_CONFIG, raw)
        except Exception:
            self._data = dict(DEFAULT_CONFIG)
        return self._data

    def save(self) -> None:
        """写回配置文件。

        写不进去（配置目录只读、沙箱环境等）不应把整个程序搞崩：只记下 save_error，
        配置仍在内存里生效，本轮跑步依然是对的。
        """
        try:
            self.path.parent.mkdir(parents=True, exist_ok=True)
            tmp = self.path.with_suffix(".tmp")
            tmp.write_text(json.dumps(self._data, ensure_ascii=False, indent=2), encoding="utf-8")
            tmp.replace(self.path)
            self.save_error = None
        except Exception as exc:      # OSError / 权限 / 磁盘只读……都不能中断跑步
            self.save_error = str(exc)

    # ── 访问 ──
    def get(self, key: str, default: Any = None) -> Any:
        cur: Any = self._data
        for part in key.split("."):
            if not isinstance(cur, dict) or part not in cur:
                return default
            cur = cur[part]
        return cur

    def set(self, key: str, value: Any) -> None:
        parts = key.split(".")
        cur = self._data
        for p in parts[:-1]:
            cur = cur.setdefault(p, {})
        cur[parts[-1]] = value

    def update(self, patch: Dict[str, Any]) -> Dict[str, Any]:
        self._data = _deep_merge(self._data, patch)
        return self._data

    def as_dict(self) -> Dict[str, Any]:
        return dict(self._data)


def default_config_path() -> Path:
    """配置文件位置。

    优先级：环境变量 SDLAB_HOME（与数据目录同一个开关，整个工作台指哪写哪，
    沙箱/便携场景只设这一个变量）→ $XDG_CONFIG_HOME/shandong-run-lab →
    ~/.config/shandong-run-lab。
    """
    home = os.environ.get("SDLAB_HOME")
    if home:
        return Path(home).expanduser() / "config.json"
    xdg = os.environ.get("XDG_CONFIG_HOME")
    base = Path(xdg) if xdg else Path.home() / ".config"
    return base / "shandong-run-lab" / "config.json"


def default_data_dir() -> Path:
    """数据目录（数据库 / 日志 / 轨迹导出）。同样先看 SDLAB_HOME。"""
    home = os.environ.get("SDLAB_HOME")
    if home:
        return Path(home).expanduser()
    xdg = os.environ.get("XDG_DATA_HOME")
    base = Path(xdg) if xdg else Path.home() / ".local" / "share"
    return base / "shandong-run-lab"
