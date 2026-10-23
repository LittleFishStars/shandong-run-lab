#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""平台注入点：Android（Chaquopy）与桌面自检共用的唯一宿主适配出口。

职责（严格对齐 docs/android/接口契约.md §5「后端适配 · 设备指纹」）：
  1. 持有 Java 侧注入的 HostBridge（openUrl / quit / toast / deviceInfoJson）；
    桌面自检时没有宿主，`get_host()` 返回 None，各动作回落到桌面语义。
  2. 把 Android 设备指纹注入 App 的 config —— **只走 App 已有的 config 通道**
     （`App.patch_config`，键名见 net.py 的 `public_fields()` 与 `user_agent()`），
     **绝不**直接改写 net.py / simulator.py，也不 import android。
  3. host 为 None（桌面自检）时什么都不注入，保持桌面默认值。

注意：
  · 本文件与 android_api.py 都位于 `app/src/main/python/`（Chaquopy 的 python 源根），
    可直接 `import android_env`，不依赖包内任何模块。
  · 兼容 Python 3.12 / 3.14，不用 3.13+ 新语法。
"""
from __future__ import annotations

import json
from typing import Any, Dict, Optional
__all__ = ["set_host", "get_host", "device_info", "configure_app"]


# ── 模块级单例：Java 侧注入的宿主桥 ──
# 类型约定（对应 Kotlin 的 HostBridge 接口）：
#   openUrl(url: str) -> None
#   quit() -> None
#   toast(msg: str) -> None
#   deviceInfoJson() -> str        （Build.* 序列化成的 JSON 字符串）
_host = None  # type: Optional[Any]


def set_host(host: Any) -> None:
    """注入 Java 侧的 HostBridge。host 为 None 表示清空（回到桌面语义）。"""
    global _host
    _host = host


def get_host() -> Any:
    """返回当前宿主；无宿主（桌面自检）时为 None。"""
    return _host


def device_info() -> Dict[str, Any]:
    """返回宿主上报的设备指纹字典。

    host 为 None 时返回 {}（桌面自检：不注入任何设备指纹，走桌面默认值）。
    宿主 deviceInfoJson 返回字符串 → json.loads 解析；解析失败返回 {} 。
    """
    host = get_host()
    if host is None:
        return {}
    try:
        raw = host.deviceInfoJson()
    except Exception:  # noqa: BLE001  宿主异常不扩散
        return {}
    if not isinstance(raw, (str, bytes, bytearray)):
        raw = "{}"
    try:
        info = json.loads(raw)
    except (TypeError, ValueError):
        info = {}
    return info if isinstance(info, dict) else {}


def _device_patch() -> Dict[str, Any]:
    """从设备指纹构造 config 的 device 补丁（只含本层允许注入的键）。

    键名必须与 net.py 读取的一致（net.py:public_fields / user_agent）：
      · device.model           modelName = Build.MANUFACTURER + "|" + Build.MODEL
      · device.system_version  systemVersion = Build.VERSION.RELEASE
      · device.platform        platform（原版 DEFAULT_PLATFORM；Android 路径注入 "android"，
                               与契约 §5 对齐——net.py 的 device.platform 缺省即空出时
                               才会回落 DEFAULT_PLATFORM，这里显式给值）
      · device.brand           用户代理 (UA) 品牌 = Build.BRAND
    """
    info = device_info() or {}
    patch: Dict[str, Any] = {}
    dev: Dict[str, Any] = {}

    manufacturer = str(info.get("manufacturer") or "").strip()
    model = str(info.get("model") or "").strip()
    # modelName = MANUFACTURER + "|" + MODEL；任一缺失则保留桌面缺省（不注入）
    if manufacturer and model:
        dev["model"] = f"{manufacturer}|{model}"

    release = str(info.get("system_version") or info.get("release") or "").strip()
    if release:
        dev["system_version"] = release

    # 契约显式规定：Android 注入 platform="android"
    dev["platform"] = "android"

    brand = str(info.get("brand") or "").strip()
    if brand:
        dev["brand"] = brand

    if dev:
        patch["device"] = dev
    return patch


def configure_app(app: Any) -> Any:
    """把设备指纹注入 App 的 config（幂等）。

    只走 App 已有的 patch_config 通道；无宿主时不注入（保持桌面默认值）。
    返回 App 实例本身，方便链式调用。
    """
    if app is None or get_host() is None:
        return app
    patch = _device_patch()
    if patch:
        try:
            app.patch_config(patch)
        except Exception:  # noqa: BLE001  注入失败不影响 App 可用性
            pass
    return app