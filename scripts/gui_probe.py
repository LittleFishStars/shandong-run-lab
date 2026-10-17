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
    # 探针一律跑本地 Mock：默认模式是真实服务端，冒烟测试不该打真实接口
    app = App(mode="mock")
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

        # 布局断言：用户要求「轨迹与围栏卡片置于上半页，且显示区域适应卡片大小」。
        # 用真实几何量验证，不靠看截图拍板。
        geo = js(window, "JSON.stringify((()=>{"
                     "const r=(s)=>{const e=document.querySelector(s);"
                     "return e?e.getBoundingClientRect():null;};"
                     "const g=(o)=>o?{top:Math.round(o.top),bottom:Math.round(o.bottom),"
                     "h:Math.round(o.height),w:Math.round(o.width)}:null;"
                     "return {vh:window.innerHeight,vw:window.innerWidth,"
                     "layout:g(r('.layout')),colMid:g(r('.col-mid')),mapCard:g(r('.map-card')),"
                     "mapBody:g(r('.map-body')),map:g(r('#map')),runCard:g(r('.col-mid .card:last-child'))};"
                     "})())")
        try:
            G = json.loads(geo) if isinstance(geo, str) else {}
        except Exception:
            G = {}
        if not G:
            check("能读到中栏实际尺寸", False, str(geo)[:120])
        else:
            vh = G.get("vh") or 0
            mc, mm, cm = G.get("mapCard") or {}, G.get("mapBody") or {}, G.get("colMid") or {}
            rc = G.get("runCard") or {}
            print(f"    · 视口 {G.get('vw')}x{vh}，中栏高 {cm.get('h')}，"
                  f"地图卡 top={mc.get('top')} h={mc.get('h')}（{mm.get('w')}x{mm.get('h')}），"
                  f"本次跑步卡 h={rc.get('h')}")
            check("地图所在卡片位于页面上半部",
                  bool(mc) and (mc.get("top") or 0) + (mc.get("h") or 0) / 2 <= vh * 0.5,
                  f"卡片中线 {int((mc.get('top') or 0) + (mc.get('h') or 0) / 2)} / 视口高 {vh}")
            check("地图卡占中栏高度的一半以上",
                  bool(cm) and (mc.get("h") or 0) >= (cm.get("h") or 0) * 0.45,
                  f"地图卡 {mc.get('h')} / 中栏 {cm.get('h')}")
            check("地图显示区域填满卡片正文（无垂直留白）",
                  bool(mc) and bool(mm) and (mm.get("top") or 0) + (mm.get("h") or 0)
                  >= (mc.get("top") or 0) + (mc.get("h") or 0) - 30,
                  f"地图区底 {int((mm.get('top') or 0) + (mm.get('h') or 0))} vs 卡片底 "
                  f"{int((mc.get('top') or 0) + (mc.get('h') or 0))}")
            check("地图区宽度填满卡片",
                  bool(mc) and bool(mm) and (mm.get("w") or 0) >= (mc.get("w") or 0) - 4,
                  f"地图区宽 {mm.get('w')} vs 卡片宽 {mc.get('w')}")

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
        # 布局与「只规划不动」：先把路径画出来，不升跑。
        # 用户要求：加入摇杆便于自行控制路径 + 加入仅渲染路径点但不一键跑完的功能。
        print("\n[3.5] 只规划路径（不升跑、不落库）与摇杆干跑")
        runs_before = int(js(window, "document.querySelectorAll('#runs .run-item').length") or 0)
        js(window, "document.querySelector('#btn-plan').click()")
        time.sleep(1.5)
        check("规划已画出路线（S.route 非空）",
              int(js(window, "((S.route)||[]).length") or 0) >= 1,
              f"route={js(window, '((S.route)||[]).length')} 个点")
        check("规划未升跑（run_code 仍为空）",
              not str(js(window, "(S.walk && S.walk.run_code) || ''") or ''))
        runs_now = int(js(window, "document.querySelectorAll('#runs .run-item').length") or 0)
        check("规划后本地记录条数不变（只画不写）", runs_now == runs_before,
              f"{runs_before} → {runs_now}")

        # 跑步起点：在图上点一下就定起点，后端记住，围栏外自动吸附
        print("\n[3.6] 跑步起点（图上选点 → 围栏吸附 → 清除）")
        check("起点按钮与提示已渲染",
              js(window, "!!document.querySelector('#btn-pick-start') && "
                         "document.querySelector('#start-info').textContent.indexOf('起点') === 0") is True,
              str(js(window, "document.querySelector('#start-info').textContent")))
        js(window, "document.querySelector('#btn-pick-start').click()")
        time.sleep(0.4)
        check("点「设置起点」进入设点态（按钮变「完成设点」）",
              js(window, "S.pickStart === true && "
                         "document.querySelector('#btn-pick-start').textContent === '完成设点'") is True)
        # 派发一次 Leaflet click：和真人在地图上点一下走同一条通路
        js(window, "MAP.obj.fire('click', {latlng: L.latLng(36.6730, 117.0265)})")
        time.sleep(1.5)
        check("图上设点后拿到吸附后的坐标（S.startPoint 非空）",
              js(window, "!!S.startPoint && !!S.startPoint.lat") is True,
              str(js(window, "JSON.stringify(S.startPoint)")))
        check("提示文字跟着起点走（不再是围栏中心）",
              js(window, "document.querySelector('#start-info').textContent.indexOf('围栏中心') < 0") is True,
              str(js(window, "document.querySelector('#start-info').textContent")))
        # status 不一定是同步回来的（前端每秒轮询一次），等它跟上来，别拿刷新时机当失败
        custom = False
        st_deadline = time.time() + 8.0
        while time.time() < st_deadline:
            custom = js(window, "!!(S.status && S.status.start_point_custom)") is True
            if custom:
                break
            time.sleep(0.5)
        check("后端也记住了起点（status.start_point_custom）", custom)
        n_start = int(js(window, "document.querySelectorAll('.start-label').length") or 0)
        check("地图上出现起点标记", n_start >= 1, f"标记数 {n_start}")
        print("        截图（带上起点）")
        shot(window, outdir, "gui-3-start-point.png", full=args.full)
        js(window, "document.querySelector('#btn-clear-start').click()")
        time.sleep(1.2)
        check("点「清除起点」回到围栏中心",
              js(window, "!S.startPoint && "
                         "document.querySelector('#start-info').textContent === '起点：围栏中心'") is True,
              str(js(window, "document.querySelector('#start-info').textContent")))

        # 摇杆干跑：推杆后地图上必须长出实时轨迹，且不落库
        js(window, "document.querySelector('#btn-walk-dry').click()")
        time.sleep(2.0)
        check("干跑已启动（界面进入 walking 态）",
              js(window, "document.querySelector('.map-card').classList.contains('walking')") is True)
        # 直接调桥推杆（与拖动摇杆走同一条通路），然后看实时点是否在变多
        js(window, "Bridge.call('walk_joystick', 1, 0, 1)")
        time.sleep(4.0)
        n1 = int(js(window, "(S.livePoints||[]).length") or 0)
        js(window, "Bridge.call('walk_joystick', 0, 1, 1)")   # 换个方向，验证真在跟摇杆
        time.sleep(4.0)
        n2 = int(js(window, "(S.livePoints||[]).length") or 0)
        check("摇杆推动后地图上出现实时轨迹点", n1 >= 1, f"推杆 2 秒后 {n1} 个点")
        check("轨迹随摇杆方向继续增长", n2 > n1, f"{n1} → {n2} 个点")
        shot(window, outdir, "gui-4-walk.png", full=args.full)
        js(window, "Bridge.call('walk_joystick', 0, 0, 0)")
        time.sleep(0.5)
        js(window, "document.querySelector('#btn-walk-stop').click()")
        time.sleep(1.5)
        check("干跑已停止（按钮回到禁用）",
              js(window, "document.querySelector('#btn-walk-stop').disabled") is True)
        runs_after = int(js(window, "document.querySelectorAll('#runs .run-item').length") or 0)
        check("干跑不落库（记录条数未变）", runs_after == runs_before,
              f"{runs_before} → {runs_after}")

        # 实跑：摇杆驱动，轨迹/打卡/步频/配速都必须边跑边落库
        print("\n[3.7] 实跑（摇杆驱动）：边跑边落库、实测并检测打卡点")
        # 摇杆速度调高：默认 2.5 m/s 走完“中心→最近打卡点”要一分钟以上，
        # 探针里没必要等那么久（这条链路的正确性与速度无关）
        js(window, "document.querySelector('#in-walk-speed').value = 5.5")
        js(window, "document.querySelector('#btn-walk-real').click()")
        time.sleep(3.0)
        rc_live = str(js(window, "(S.walk && S.walk.run_code) || ''") or "")
        check("实跑已开跑并拿到记录号", bool(rc_live), rc_live)
        js(window, "Bridge.call('walk_joystick', 1, 0, 1)")
        time.sleep(4.0)
        stored = int(js(window, "(S.walk && S.walk.stored) || 0") or 0)
        check("实跑中轨迹已实时写库", stored >= 1, f"已落库 {stored} 点")
        # 步频段每 20 秒才切一刀（原版 CommonConfig.stepInterval），轮询等它出现
        seg_steps = 0
        seg_deadline = time.time() + 30.0
        while time.time() < seg_deadline:
            seg_steps = int(js(window, "((S.walk && S.walk.segments) || {}).steps || 0") or 0)
            if seg_steps >= 1:
                break
            time.sleep(1.0)
        check("实跑中步频段已实时写库", seg_steps >= 1, f"已切 {seg_steps} 个步频段")
        # 沿规划路线自动走，等打卡点被刷到（地图上紫点转绿就是这条链路生效的直观证据）
        # 注意：必须先把杆松回去，否则手动方向会盖掉“沿路线自动巡航”
        js(window, "Bridge.call('walk_joystick', 0, 0, 0)")
        js(window, "Bridge.call('walk_route', JSON.stringify(S.route || []), true, false)")
        deadline = time.time() + 90
        hits = 0
        while time.time() < deadline:
            time.sleep(2.0)
            hits = int(js(window, "((S.walk && S.walk.state) || {}).passed || 0") or 0)
            if hits >= 1:
                break
        check("实跑实时检测打卡点并写库", hits >= 1, f"已打卡 {hits} 个")
        # 界面每 500ms 拉一次 walk_status 并重绘地图，刚命中时可能还没轮到下一帧，
        # 等一拍再查 DOM，否则测的是“刷新时机”而不是“紫点会不会转绿”
        time.sleep(1.5)
        n_cp = int(js(window, "document.querySelectorAll('.cp-label').length") or 0)
        n_green = int(js(window, "document.querySelectorAll('.cp-label.passed').length") or 0)
        n_mapcp = int(js(window, "((S.walk && S.walk.targets) || []).filter(c => Number(c.passed) === 1).length") or 0)
        check("地图上打卡点已变绿（实时快照生效）", n_green >= 1,
              f"DOM 打卡点 {n_cp} 个 / 变绿 {n_green} 个 / 快照命中 {n_mapcp} 个")
        shot(window, outdir, "gui-5-walk-real.png", full=args.full)
        js(window, "Bridge.call('walk_joystick', 0, 0, 0)")
        js(window, "document.querySelector('#btn-walk-stop').click()")
        time.sleep(4.0)
        check("实跑停止后本地轨迹与段仍在（未因停止而回滚）",
              int(js(window, "(S.walk && S.walk.stored) || 0") or 0) >= stored and
              int(js(window, "(S.walk && S.walk.steps) || 0") or 0) >= 1,
              f"已落库 {js(window, '(S.walk && S.walk.stored) || 0')} 点 / "
              f"{js(window, '(S.walk && S.walk.steps) || 0')} 个步频段")
        runs_real = int(js(window, "document.querySelectorAll('#runs .run-item').length") or 0)
        check("实跑确实多了一条本地记录（与干跑相反）", runs_real > runs_before,
              f"{runs_before} → {runs_real}")
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
                # 轨迹写入阶段（36%→45%）反复截图、后面覆盖前面：
                # 拿到的是“写得最满、但还没进入上传阶段”的那张，README 才是“轨迹一笔笔长出来”。
                if v < 50:
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
