#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""Android（Chaquopy）桥分发：把 JS/Java 侧 `dispatch(method, args_json)` 转发到 App 门面。

唯一语义来源是桌面版 `gui.JsApi`（projects/desktop/.../gui.py），本文件只做
「参数按位置取 → 与 JsApi 完全相同的强转 → 调用 App」这一层搬运，不引入任何业务逻辑。

与桌面版 HTTP 桥一致的守则：
  · 白名单显式方法表；未知方法返回 {"error":"未知方法 <name>"}，返回 JSON 字符串；
  · 任何异常 → {"error":"<Type>: <msg>"}，**永不抛给 Java**；
  · 返回值统一 json.dumps(..., ensure_ascii=False, default=str)。

线程：Java 侧已保证串行，本层不再加锁（App 自身有锁）。

注意：
  * 本文件位于 `app/src/main/python/`（Chaquopy 源根），可 `import android_api`；
    兼容 Python 3.12 / 3.14，不用 3.13+ 新语法。
  * `android_api` 与 `android_env` 是**新增**模块，不修改 vendoring 包里的任何文件。
"""
from __future__ import annotations

import json
import time
from typing import Any, Dict, List, Optional

import android_env
from shandong_school_cracked import constants as C
from shandong_school_cracked.app import App

__all__ = ["set_host", "methods", "dispatch", "ensure_app", "get_app"]


# ══════════════════════════════════════════════════════════════════
# 单例 App（懒建）
# ══════════════════════════════════════════════════════════════════
_dispatch_state: Dict[str, Any] = {"app": None}   # 懒建单例 App（mode=None → 默认 real）


def ensure_app():
    """懒建单例 App（mode=None，默认 real，与桌面 App() 一致），再注入设备指纹。

    返回 App 实例；已建过则直接复用。
    """
    app = _dispatch_state["app"]
    if app is None:
        app = App()
        android_env.configure_app(app)
        _dispatch_state["app"] = app
    return app


def set_host(host) -> None:
    """转发到 android_env.set_host，并（若 App 已建）补一次设备指纹注入。"""
    android_env.set_host(host)
    app = _dispatch_state["app"]
    if app is not None:
        android_env.configure_app(app)


def get_app() -> Optional[Any]:
    """返回已建的单例 App；尚未懒建时返回 None（不触发构建）。"""
    return _dispatch_state["app"]


def _set_app(app) -> None:
    """仅供自检脚本注入 mock App（不改变公开桥行为，属测试钩子）。"""
    _dispatch_state["app"] = app


# ══════════════════════════════════════════════════════════════════
# ═══ 白名单方法表（顺序与桌面版 gui.JsApi / 契约 §2 一致） ═══
# 每条：(方法名, ((强转kind, 参数名), ...))。kind 取值：
#   str/int/float/bool -> 强转；any -> 原样直传（null 直塞，如 set_start_point / ui_report）；
#   json -> dict 直用、str 则 json.loads（patch_config 专属）；route -> walk_route 专属。
_METHOD_TABLE = [
    # —— 握手 / 状态 ——
    ("ping",                 ()),
    ("status",               ()),
    ("poll",                 (("int", "seq"),)),
    ("events",               (("int", "seq"),)),
    # —— 登录 / 账号 ——
    ("login",                (("str", "phone"), ("str", "password"), ("bool", "do_captcha"))),
    ("logout",               ()),
    ("list_accounts",        ()),
    ("switch_account",       (("str", "user_id"),)),
    ("forget_account",       (("str", "user_id"),)),
    ("relogin_account",      (("str", "user_id"),)),
    ("refresh_user",         ()),
    # —— 备跑 / 一键跑 ——
    ("prepare",              (("int", "fence_index"),)),
    ("reload_rule",          ()),
    ("run_auto",             (("float", "target_m"), ("int", "fence_index"),
                               ("bool", "do_upload"), ("bool", "do_finish"),
                               ("int", "sport_type"))),
    ("resume",               (("str", "run_code"),)),
    # —— 摇杆实走 ——
    ("walk_start",           (("str", "mode"), ("float", "target_m"), ("int", "fence_index"),
                               ("float", "speed_mps"), ("bool", "auto_route"),
                               ("bool", "auto_start"), ("float", "speed"))),
    ("walk_joystick",        (("float", "dx"), ("float", "dy"), ("float", "mag"))),
    ("walk_stop",            ()),
    ("walk_status",          (("int", "since"),)),
    ("walk_route",           (("route", "waypoints_json"), ("bool", "auto"), ("bool", "targets"))),
    ("walk_auto",            (("bool", "on"),)),
    ("walk_speed",           (("float", "speed_mps"),)),   # v2.1.0：运行中实时调速（夹规则区间）
    ("walk_pause",           (("bool", "on"),)),
    ("walk_upload",          (("bool", "do_finish"),)),
    ("walk_save",            (("str", "name"),)),
    ("walk_plan",            ()),
    ("set_start_point",      (("any", "lat"), ("any", "lng"))),
    ("ui_report",            (("any", "info"),)),
    # —— 记录 ——
    ("list_runs",            (("int", "limit"),)),
    ("server_records",       (("int", "page"), ("int", "size"),
                               ("str", "semester_code"), ("str", "run_plan_code"))),
    ("server_record_detail", (("str", "run_code"), ("str", "semester_code"))),
    ("run_detail",           (("str", "run_code"),)),
    ("export",               (("str", "run_code"), ("str", "fmt"))),
    ("delete_run",           (("str", "run_code"),)),
    # —— 配置 / 杂项 ——
    ("get_config",           ()),
    ("patch_config",         (("json", "patch_json"),)),
    ("switch_mode",          (("str", "mode"),)),
    ("check_update",         ()),
    ("open_url",             (("str", "url"),)),
    ("reset_device",         ()),
    ("mock_info",            ()),
    ("open_data_dir",        ()),
    ("toast",                (("str", "message"),)),
    ("quit",                 ()),
]


def methods() -> List[str]:
    """返回全部已注册桥方法名（自检用），顺序与支持的表一致。"""
    return [name for name, _ in _METHOD_TABLE]


# ══════════════════════════════════════════════════════════════════
# 参数强转
# ══════════════════════════════════════════════════════════════════
def _coerce(kind: str, value):
    """按 JsApi 的强转语义转换单个参数。"""
    if kind == "any":
        return value
    if kind == "bool":
        return bool(value)
    if kind == "int":
        return int(value)
    if kind == "float":
        return float(value)
    if kind == "json":
        if isinstance(value, dict):
            return value
        try:
            return json.loads(value if isinstance(value, str) else (value or "{}"))
        except Exception as e:  # noqa: BLE001
            # 与桌面 patch_config 的行为一致：非法 JSON 返回 {"error": ...}
            return {"error": f"配置补丁不是合法 JSON：{e}", "data": None}
    return value  # "str" 等


def _convert_args(args: List[Any], specs: tuple) -> List[Any]:
    """按位置把原始参数按 spec（(kind, name)）强转；args 不足补 None。"""
    out = []
    for i, (kind, _name) in enumerate(specs):
        if i < len(args):
            out.append(_coerce(kind, args[i]))
        else:
            out.append(None)
    return out


def _json(o) -> str:
    """统一 JSON 序列化，绝不抛异常。"""
    try:
        return json.dumps(o, ensure_ascii=False, default=str)
    except Exception:  # noqa: BLE001
        return json.dumps({"ok": False, "message": "序列化失败"}, ensure_ascii=False)


# ══════════════════════════════════════════════════════════════════
# dispatch 入口
# ══════════════════════════════════════════════════════════════════
def _dispatch_impl(name: str, args: List[Any]):
    """白名单反射调用 + 特殊方法落地；返回 JSON 可序列化对象。"""
    app = _dispatch_state["app"]

    if name == "ping":
        return {"ok": True,
                "mode": app.mode if app is not None else None,
                "ts": int(time.time() * 1000),
                "app_version": C.APP_VERSION}
    if name == "open_url":
        url = str(args[0] or "").strip() if args else ""
        host = android_env.get_host()
        if host is not None:
            try:
                host.openUrl(url)
                return {"code": 0, "message": "ok", "data": {"url": url}}
            except Exception as e:  # noqa: BLE001
                return {"code": -1, "message": str(e), "data": None}
        if not url.lower().startswith(("http://", "https://")):
            return {"code": -1, "message": "链接无效", "data": None}
        try:
            webbrowser.open(url)
            return {"code": 0, "message": "ok", "data": {"url": url}}
        except Exception as e:  # noqa: BLE001
            return {"code": -1, "message": str(e), "data": None}
    if name == "quit":
        host = android_env.get_host()
        if host is not None:
            if app is not None:
                try:
                    app.close()
                except Exception:  # noqa: BLE001
                    pass
            try:
                host.quit()
            except Exception:  # noqa: BLE001
                pass
        return {"ok": True}
    if name == "toast":
        msg = str(args[0] or "") if args else ""
        host = android_env.get_host()
        if host is not None:
            try:
                host.toast(msg)
            except Exception:  # noqa: BLE001
                pass
        if app is not None:
            app.bus.emit("log", msg)
        return {"ok": True}
    if name == "open_data_dir":
        return {"path": str(app.data_dir) if app is not None else ""}
    if name == "mock_info":
        mock = getattr(app, "_mock", None) if app is not None else None
        w = getattr(app, "world", None) if app is not None else None
        if mock is None:
            return {"running": False, "url": "", "world": {}}
        return {
            "running": bool(mock),
            "url": (mock.base_url if getattr(mock, "base_url", None) else ""),
            "world": (w.snapshot() if w is not None and hasattr(w, "snapshot") else {}),
        }
    if name == "walk_route":
        # 桌面语义：非法 JSON 返回 {code:-1,...}；合法转 list 后交给 App
        raw = args[0] if args else ""
        try:
            wps = json.loads(raw) if isinstance(raw, str) and raw else (
                raw if isinstance(raw, list) else [])
        except Exception as e:  # noqa: BLE001
            return {"code": -1, "message": f"路点不是合法 JSON：{e}", "data": None}
        auto = bool(args[1]) if len(args) > 1 else True
        targets = bool(args[2]) if len(args) > 2 else False
        return ensure_app().walk_route(wps, auto=auto, targets=targets)
    if name == "events":
        # 桌面 JsApi.events 就是 poll 的别名（gui.py: events() -> self.app.poll(seq)）
        seq = int(args[0]) if args and args[0] is not None else 0
        return ensure_app().poll(seq)
    if name == "prepare":
        # 桌面 JsApi.prepare -> app.run_prepare(fence_index)（App 上没有 prepare 这个名字）
        idx = int(args[0]) if args and args[0] is not None else 0
        return ensure_app().run_prepare(idx)
    if name == "get_config":
        # 桌面 JsApi.get_config 直接返回 self.app.cfg
        return ensure_app().cfg

    # 白名单查找
    entry = None
    for mname, margs in _METHOD_TABLE:
        if mname == name:
            entry = (mname, margs)
            break
    if entry is None:
        return {"error": f"未知方法 {name}"}

    # 无参方法
    meth_name, arg_names = entry
    if not arg_names:
        return getattr(ensure_app(), meth_name)()

    # 特殊参数名带默认值的（str 缺省给空串等），直接走同名 App 方法
    converted = _convert_args(args, arg_names)
    return getattr(ensure_app(), meth_name)(*converted)


def dispatch(method, args_json) -> str:
    """Java 唯一入口：method 为方法名，args_json 为 JSON 数组字符串。

    返回 JSON 字符串；任何情况下都不向调用方抛异常。
    """
    name = str(method or "")
    # 解析 args_json（可能为空串 / "[]"）
    try:
        parsed = json.loads(args_json) if isinstance(args_json, str) and args_json else []
        args = parsed if isinstance(parsed, list) else [parsed]
    except Exception:  # noqa: BLE001
        args = []
    try:
        result = _dispatch_impl(name, args)
    except Exception as e:  # noqa: BLE001
        return _json({"error": f"{type(e).__name__}: {e}"})
    return _json(result)


# 兼容别名（供 Java 侧显式调用）
dispatch_json = dispatch