#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""桌面外壳冒烟测试：真的开一个 pywebview 窗口，按界面上的按钮走一遍完整链路。

为什么需要它：scripts/webcheck.py 验证的是「HTTP 降级桥」，而桌面壳走的是另一条路
（window.pywebview.api）。pywebview 的注入时机是这里最容易翻车的地方——它可能在
DOMContentLoaded 时就已经存在，但 api 代理还没接好，此时任何调用都静默返回
undefined，界面会「不报错但全空」。这个脚本专门抓这种情况。

用法：
    export SDLAB_HOME=$PWD/.run
    .venv/bin/python scripts/gui_probe.py [--distance 1200] [--shots shots]

它会依次：等桥就绪 → 点登录 → 点拉取配置 → 填距离并点一键跑 → 截图 → 读回界面状态。
退出码非 0 表示某一步没通过。
"""
from __future__ import annotations

import argparse
import json
import sys
import threading
import time
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
sys.path.insert(0, str(ROOT))

try:
    import webview
except Exception as exc:  # pragma: no cover - 环境缺 pywebview 时直接说清楚
    print(f"[×] 无法导入 pywebview：{exc}")
    raise SystemExit(2)

from sdlab.app import App                      # noqa: E402
from sdlab.gui import INDEX, JsApi             # noqa: E402

FAILS: list = []


def check(name: str, ok: bool, detail: str = "") -> bool:
    mark = "✓" if ok else "×"
    print(f"  {mark} {name}" + (f"：{detail}" if detail else ""))
    if not ok:
        FAILS.append(name)
    return ok


def js(window, expr: str):
    """取一个同步表达式的值（evaluate_js 不会 await Promise，所以只传同步表达式）"""
    try:
        return window.evaluate_js(expr)
    except Exception as exc:
        return f"<evaluate_js 失败：{exc}>"


def _webkit_shot(window, path: Path) -> bool:
    """用 WebKit 自己的快照接口截图（不依赖合成器）。

    Wayland 下客户端拿不到窗口位置（niri 报 pos=null），grim 按坐标抓会把桌面上
    其它窗口一并抓进来。WebKit2.WebView.get_snapshot() 直接把应用渲染结果写 PNG，
    既不依赖合成器，也不会带上别人的窗口。
    """
    try:
        from gi.repository import GLib, WebKit2
    except Exception:
        return False

    def _find_wv(widget):
        if widget is None:
            return None
        if isinstance(widget, WebKit2.WebView):
            return widget
        child = None
        if hasattr(widget, "get_child"):
            try:
                child = widget.get_child()
            except Exception:
                child = None
        if child is not None:
            got = _find_wv(child)
            if got is not None:
                return got
        if hasattr(widget, "get_children"):
            try:
                for c in widget.get_children() or []:
                    got = _find_wv(c)
                    if got is not None:
                        return got
            except Exception:
                pass
        return None

    native = getattr(window, "native", None)
    if native is None:
        return False
    wv = _find_wv(native)
    if wv is None:
        return False

    done = threading.Event()
    box: Dict[str, Any] = {}

    def _on_main() -> bool:
        def _cb(view, result, *_a) -> None:
            try:
                surface = view.get_snapshot_finish(result)
                surface.write_to_png(str(path))
                box["ok"] = True
            except Exception as exc:       # noqa: BLE001
                box["err"] = str(exc)
            finally:
                done.set()

        try:
            wv.get_snapshot(WebKit2.SnapshotRegion.VISIBLE,
                            WebKit2.SnapshotOptions.NONE, None, _cb)
        except Exception as exc:           # noqa: BLE001
            box["err"] = str(exc)
            done.set()
        return False

    GLib.idle_add(_on_main)
    done.wait(timeout=10)
    return bool(box.get("ok"))


def shot(window, outdir: Path, name: str, full: bool = False) -> None:
    """截图：优先 WebKit 自渲染快照，其次 Wayland 的 grim / X11 的 gnome-screenshot"""
    import shutil
    import subprocess

    outdir.mkdir(parents=True, exist_ok=True)
    path = outdir / name

    # ① 首选：WebKit 自己渲染的快照（Wayland 下唯一能拿到“只有应用窗口”的办法）
    if not full and _webkit_shot(window, path):
        print(f"  · 截图（应用自渲染）→ {path}")
        return

    # ② 退路：按窗口坐标截屏（X11 可用；Wayland 客户端拿不到真实坐标）
    geom = ""
    if not full and shutil.which("grim"):
        try:
            x, y = int(window.x or 0), int(window.y or 0)
            w, h = int(window.width or 0), int(window.height or 0)
            if w > 200 and h > 200:
                geom = f"{x},{y} {w}x{h}"
        except Exception:
            geom = ""

    if shutil.which("grim"):
        cmd = ["grim"] + (["-g", geom] if geom else []) + [str(path)]
    elif shutil.which("import"):
        cmd = ["import", "-window", "root", str(path)]
    else:
        return
    try:
        subprocess.run(cmd, check=True, timeout=20)
        print(f"  · 截图 → {path}")
    except Exception as exc:
        print(f"  · 截图失败：{exc}")


def main() -> int:
    ap = argparse.ArgumentParser(description="桌面外壳冒烟测试")
    ap.add_argument("--distance", type=float, default=1200.0, help="本次跑步目标距离（米）")
    ap.add_argument("--speed", type=float, default=40.0, help="实时仿真倍速（默认 40，跑得快）")
    ap.add_argument("--timeout", type=float, default=60.0, help="等待整场跑完的上限（秒）")
    ap.add_argument("--shots", type=str, default=str(ROOT / "shots"), help="截图输出目录")
    ap.add_argument("--keep", action="store_true", help="跑完不退出（留给人工看）")
    ap.add_argument("--full", action="store_true",
                    help="截图用全屏窗口并截整屏（干净的界面图，不会带上桌面其它窗口）")
    args = ap.parse_args()

    outdir = Path(args.shots)
    app = App()
    api = JsApi(app)
    # 截图模式下让窗口占满屏（这样整屏截图里就只有应用，不会把桌面上的其它窗口拍进去；
    # 而且不用去猜窗口的逻辑坐标——pywebview 在不同缩放下给的位置并不一致）
    window = webview.create_window("闪动校园跑步实验台", url=str(INDEX), js_api=api,
                                   width=1200, height=800, min_size=(980, 640),
                                   fullscreen=bool(args.full))

    def timeline() -> None:
        time.sleep(6)
        print("\n[1] 桥就绪与首屏渲染")
        mode = js(window, "Bridge.mode")
        check("桌面桥已就绪（真实 ping 握手）", js(window, "Bridge.ready === true"), f"mode={mode}")
        check("首屏状态已填充（S.status 非空）", js(window, "!!S.status") is True)
        check("顶栏版本号已显示", "v8" in str(js(window, "document.querySelector('#pill-version').textContent")))
        check("事件流有内容", js(window, "document.querySelector('#log').childElementCount > 0") is True)
        check("事件时间戳不是 NaN",
              js(window, "!/NaN/.test(document.querySelector('#log').textContent)") is True)
        shot(window, outdir, "gui-1-init.png", full=args.full)

        print("\n[2] 登录（点界面按钮）")
        js(window, "document.querySelector('#btn-login').click()")
        time.sleep(4)
        check("登录成功（顶栏已登录）",
              "已登录" in str(js(window, "document.querySelector('#pill-login').textContent")))
        check("用户信息已渲染",
              "未登录" not in str(js(window, "document.querySelector('#user-info').textContent")))

        print("\n[3] 拉取配置（围栏/规则/打卡点）")
        js(window, "document.querySelector('#btn-prepare').click()")
        time.sleep(5)
        check("围栏下拉已有选项", js(window, "document.querySelector('#in-fence').options.length > 0") is True)
        check("规则已显示",
              js(window, "document.querySelector('#rule-info').textContent.indexOf('尚未加载') < 0") is True)

        print(f"\n[4] 一键跑 {args.distance:.0f} 米（点界面按钮，开实时仿真）")
        js(window, f"document.querySelector('#in-distance').value = {args.distance}")
        # 打开实时仿真：mock 模式下不算实时的话整场跑只要一两秒，界面上一瞬就过去了，
        # 既看不到轨迹一笔笔画出来，也测不出“跑步中”的状态。步点了“保存参数”按钮，
        # 顺便把界面的参数落盘链路也走一遍。
        js(window, "document.querySelector('#in-realtime').checked = true")
        js(window, f"document.querySelector('#in-speed').value = {args.speed:g}")
        js(window, "document.querySelector('#btn-save-cfg').click()")
        time.sleep(1.5)
        js(window, "document.querySelector('#btn-run').click()")
        # mock 模式下整场跑只要一两秒（仿真不是实时的），所以要密集采样：
        # 只要采到任何一次 0 < 进度 < 100，就证明界面确实在跑步过程中刷新了。
        seen: list = []
        shot_taken = False
        max_live = 0
        for _ in range(int(max(8, args.timeout * 2))):
            time.sleep(0.45)
            v = js(window, "parseFloat(document.querySelector('#progress-fill').style.width) || 0")
            v = float(v) if isinstance(v, (int, float)) else 0.0
            seen.append(round(v, 1))
            if 0 < v < 100:
                # 途中反复截图、后面覆盖前面：拿到的就是“写得最满”的那张
                shot(window, outdir, "gui-2-running.png", full=args.full)
                shot_taken = True
                live_pts = js(window, "((S.detail && S.detail.points) || []).length")
                if isinstance(live_pts, (int, float)):
                    max_live = max(max_live, int(live_pts))
            if v >= 100:
                break
        check("跑步过程中界面有实时进度",
              any(0 < v < 100 for v in seen), f"采样进度={seen}")
        check("跑步中已能实时拉到轨迹（>60 点）", max_live > 60, f"跑步中最多看到 {max_live} 点")
        if not shot_taken:      # 没赶上跑步中也得留一张图
            shot(window, outdir, "gui-2-running.png", full=args.full)

        # 等真的跑完（轮询事件而不是拍脑袋 sleep，避免白等也避免拍太早）
        deadline = time.time() + 90
        last_obj = None
        while time.time() < deadline:
            time.sleep(1.5)
            last = js(window, "JSON.stringify((S.status && S.status.last) || null)")
            try:
                last_obj = json.loads(last) if isinstance(last, str) else None
            except Exception:
                last_obj = None
            if last_obj:
                break
        if last_obj:
            time.sleep(1.5)     # 让详情/记录列表跟上

        print("\n[5] 收尾与结果渲染")
        time.sleep(5)       # 给界面留时间，把记录列表、进度条、详情渲染完
        last = js(window, "JSON.stringify((S.status && S.status.last) || null)")
        try:
            last_obj = json.loads(last) if isinstance(last, str) else None
        except Exception:
            last_obj = None
        check("status.last 已有结果", bool(last_obj), (last or "")[:120])
        if last_obj:
            check("结果含 run_code", bool(last_obj.get("run_code")), str(last_obj.get("run_code")))
            check("距离达标（> 1000 米）", float(last_obj.get("distance_m") or 0) > 1000,
                  f"distance_m={last_obj.get('distance_m')}")
            check("上传结果已回填",
                  bool((last_obj.get("upload") or {}).get("points")),
                  str((last_obj.get("upload") or {}).get("points"))[:80])
        check("跑步已结束（进度条回零或满格）",
              js(window, "document.querySelector('#progress-text').textContent.length > 0") is True)
        check("本地记录列表非空",
              js(window, "document.querySelector('#runs').childElementCount > 0") is True)
        shot(window, outdir, "gui-3-done.png", full=args.full)

        print("\n[6] 记录详情")
        js(window, "document.querySelector('#runs button, #runs .run-item')?.click()")
        time.sleep(3)
        detail = str(js(window, "document.querySelector('#run-detail').textContent"))[:160]
        check("详情面板有内容", len(detail) > 12, detail)

        print("\n" + "=" * 56)
        if FAILS:
            print(f"桌面冒烟测试：{len(FAILS)} 项未通过 → {FAILS}")
        else:
            print("桌面冒烟测试：全部通过")
        print("=" * 56)
        if not args.keep:
            time.sleep(1)
            window.destroy()

    window.events.loaded += lambda: threading.Thread(target=timeline, daemon=True).start()
    webview.start(gui="gtk", http_server=True, debug=False)
    try:
        app.close()
    except Exception:
        pass
    return 1 if FAILS else 0


if __name__ == "__main__":
    raise SystemExit(main())
