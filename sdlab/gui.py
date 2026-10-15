#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""桌面外壳：pywebview 承载本地 Web 界面，Python 侧通过 JS Bridge 暴露 App 能力

为什么不用浏览器 + 本地 HTTP 服务：
  · pywebview 用系统 WebView（Linux 上是 WebKitGTK），界面是纯 Web 技术但进程是桌面程序；
  · 没有端口暴露、不需要额外进程，退出即结束；
  · 仍然保留 `--browser` 降级路径：没有 GUI 后端时起本地 HTTP 服务并调用默认浏览器。
"""
from __future__ import annotations

import json
import os
import sys
import threading
import time
import webbrowser
from pathlib import Path
from typing import Any, Dict, Optional

from . import constants as C
from .app import App

WEB_DIR = Path(__file__).resolve().parent.parent / "web"
INDEX = WEB_DIR / "index.html"


# ══════════════════ JS ↔ Python 桥 ══════════════════
class JsApi:
    """暴露给 JS 的接口；返回值必须是 JSON 可序列化的"""

    def __init__(self, app: App, window=None):
        self.app = app
        self.window = window
    # —— 握手 ——
    def ping(self) -> Dict[str, Any]:
        """前端用来确认桌面桥真的接好了。

        pywebview 的 window.pywebview 对象可能早于 api 代理出现，此时任何调用都会静默
        返回 undefined；前端只能靠“真调一下 ping 能不能拿到结果”来判断就绪
        （见 web/app.js 的 Bridge.waitReady）。
        """
        return {
            "ok": True,
            "mode": self.app.mode,
            "ts": int(time.time() * 1000),
            "app_version": C.APP_VERSION,
        }

    # —— 状态 ——
    def status(self) -> Dict[str, Any]:
        return self.app.status()

    def poll(self, seq: int = 0) -> Dict[str, Any]:
        return self.app.poll(seq)

    def events(self, seq: int = 0) -> Dict[str, Any]:
        return self.app.poll(seq)

    # —— 登录 ——
    def login(self, phone: str, password: str = "", do_captcha: bool = True) -> Dict[str, Any]:
        return self.app.login(str(phone), str(password), bool(do_captcha))

    def logout(self) -> Dict[str, Any]:
        return self.app.logout()

    # —— 跑步 ——
    def prepare(self) -> Dict[str, Any]:
        return self.app.run_prepare()

    def run_auto(self, target_m: float = 2000, fence_index: int = 0,
                 do_upload: bool = True, do_finish: bool = True,
                 sport_type: int = 1) -> Dict[str, Any]:
        return self.app.run_auto(target_m=float(target_m), fence_index=int(fence_index),
                                 do_upload=bool(do_upload), do_finish=bool(do_finish),
                                 sport_type=int(sport_type))

    def resume(self, run_code: str = "") -> Dict[str, Any]:
        return self.app.resume(str(run_code))

    # —— 记录 ——
    def list_runs(self, limit: int = 100) -> Any:
        return self.app.list_runs(int(limit))

    def run_detail(self, run_code: str) -> Dict[str, Any]:
        return self.app.run_detail(str(run_code))

    def export(self, run_code: str, fmt: str = "json") -> Dict[str, Any]:
        return self.app.export(str(run_code), str(fmt))

    def delete_run(self, run_code: str) -> Dict[str, Any]:
        return self.app.delete_run(str(run_code))

    # —— 配置与调试 ——
    def get_config(self) -> Dict[str, Any]:
        return self.app.cfg

    def patch_config(self, patch_json: str) -> Dict[str, Any]:
        patch = patch_json if isinstance(patch_json, dict) else json.loads(patch_json or "{}")
        return self.app.patch_config(patch)

    def switch_mode(self, mode: str) -> Dict[str, Any]:
        return self.app.switch_mode(str(mode))

    def reset_device(self) -> Dict[str, Any]:
        return self.app.reset_device()

    def mock_info(self) -> Dict[str, Any]:
        return {
            "running": bool(self.app._mock),
            "url": (self.app._mock.base_url if self.app._mock else ""),
            "world": (self.app.world.snapshot() if self.app.world and
                      hasattr(self.app.world, "snapshot") else {}),
        }

    def open_data_dir(self) -> Dict[str, Any]:
        path = str(self.app.data_dir)
        try:
            if sys.platform.startswith("linux"):
                os.system(f'xdg-open "{path}" >/dev/null 2>&1 &')
            elif sys.platform == "darwin":
                os.system(f'open "{path}"')
            else:
                os.startfile(path)  # type: ignore[attr-defined]
        except Exception:
            pass
        return {"path": path}

    def toast(self, message: str) -> Dict[str, Any]:
        self.app.bus.emit("log", str(message))
        return {"ok": True}

    def quit(self) -> Dict[str, Any]:
        threading.Thread(target=self._shutdown, daemon=True).start()
        return {"ok": True}

    def _shutdown(self) -> None:
        try:
            self.app.close()
        finally:
            if self.window is not None:
                self.window.destroy()


# ══════════════════ 启动器 ══════════════════
def _spawn_autorun(app: App, target_m: float) -> None:
    """窗口加载后自动跑一次完整流程（调试/演示用，等价于点了「一键跑完整链路」）"""

    def _job() -> None:
        import time as _t
        _t.sleep(1.0)                       # 等前端轮询线程就绪
        try:
            app.run_auto(target_m=float(target_m), fence_index=0,
                         do_upload=True, do_finish=True, sport_type=1)
        except Exception as e:  # noqa: BLE001
            app.bus.emit("state", f"✗ 自动跑失败：{e}", level="error")

    threading.Thread(target=_job, name="sdlab-autorun", daemon=True).start()


def run_desktop(config_path: Optional[Path] = None, debug: bool = False,
                width: int = 1360, height: int = 900,
                app: Optional[App] = None, autorun: float = 0.0) -> int:
    """启动桌面窗口

    第一个参数既可以是配置文件路径，也可以直接传一个 App 实例
    （CLI 与 __main__ 就是这么调的，历史 bug：把 App 当成路径传进来会抛
    `TypeError: argument should be a str or an os.PathLike object ... not 'App'`）。
    """
    if app is None and isinstance(config_path, App):
        app, config_path = config_path, None
    if app is None:
        app = App(config_path=config_path)
    try:
        import webview  # type: ignore
    except Exception as e:  # noqa: BLE001
        print(f"[warn] pywebview 不可用（{e}），降级为浏览器模式", file=sys.stderr)
        return run_browser(app)

    api = JsApi(app)
    window = webview.create_window(
        "闪动校园 · 阳光跑工作台",
        url=str(INDEX),
        js_api=api,
        width=width, height=height, min_size=(1100, 720),
        background_color="#0f1420",
        text_select=True,
    )
    api.window = window

    def _on_loaded() -> None:
        app.bus.emit("state", "界面已加载，准备就绪")
        if autorun:
            _spawn_autorun(app, autorun)

    try:
        window.events.loaded += _on_loaded
    except Exception:
        pass

    gui = None
    for cand in ("gtk", "qt", "cef"):
        try:
            import importlib.util
            mod = {"gtk": "gi", "qt": "PyQt6", "cef": "cefpython3"}[cand]
            if importlib.util.find_spec(mod) is not None:
                gui = cand
                break
        except Exception:
            continue
    # 用 pywebview 内置 http 服务供给本地文件（默认开启）：
    # 以 file:// 直接加载时 pywebview 不会注入 window.pywebview，前端就永远拿不到后端。
    webview.start(debug=debug, gui=gui, http_server=True)
    app.close()
    return 0


def build_http_server(app: App, host: str = "127.0.0.1", port: int = 0):
    """把 JsApi 挂到一个极简 HTTP 服务上

    浏览器降级模式与自动化测试共用同一套桥：前端在 HTTP 模式下
    把每个页面动作变成 POST {"method": ..., "args": [...]}。
    返回 (httpd, url)，调用方自己决定何时 serve_forever / shutdown。
    """
    from http.server import SimpleHTTPRequestHandler, ThreadingHTTPServer

    api = JsApi(app)

    class Handler(SimpleHTTPRequestHandler):
        def __init__(self, *a, **kw):
            super().__init__(*a, directory=str(WEB_DIR), **kw)

        def log_message(self, fmt, *args):
            pass

        def do_POST(self):
            length = int(self.headers.get("Content-Length", 0) or 0)
            raw = self.rfile.read(length) if length else b"{}"
            try:
                req = json.loads(raw or b"{}")
            except Exception:
                req = {}
            method = str(req.get("method", ""))
            args = req.get("args") or []
            fn = getattr(api, method, None)
            if not callable(fn) or method.startswith("_"):
                out: Any = {"error": f"未知方法 {method}"}
            else:
                try:
                    out = fn(*args)
                except Exception as e:  # noqa: BLE001
                    out = {"error": f"{type(e).__name__}: {e}"}
            body = json.dumps(out, ensure_ascii=False, default=str).encode("utf-8")
            self.send_response(200)
            self.send_header("Content-Type", "application/json; charset=utf-8")
            self.send_header("Content-Length", str(len(body)))
            self.end_headers()
            self.wfile.write(body)

    httpd = ThreadingHTTPServer((host, port), Handler)
    return httpd, f"http://{host}:{httpd.server_address[1]}/index.html?http=1"


def run_browser(app: Optional[App] = None) -> int:
    """无 GUI 后端时的降级：本地 HTTP 服务 + 默认浏览器"""
    app = app or App()
    httpd, url = build_http_server(app)
    print(f"界面地址：{url}")
    threading.Thread(target=httpd.serve_forever, daemon=True).start()
    webbrowser.open(url)
    try:
        threading.Event().wait()
    except KeyboardInterrupt:
        pass
    finally:
        httpd.shutdown()
        app.close()
    return 0
