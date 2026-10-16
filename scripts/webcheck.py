#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""前端链路自检：用真实 HTTP 请求驱动和浏览器完全相同的桥

桌面壳（pywebview）与浏览器降级共用同一个 JsApi：
  · 桌面壳走 window.pywebview.api.<method>(...)
  · 浏览器走 POST /api  {"method": ..., "args": [...]}

本脚本不起浏览器，而是直接对 HTTP 桥发请求，验证：
  1. 静态资源可服务（index.html / app.js / style.css 都是 200 且非空）
  2. 前端会调用的每一个方法都存在且返回 JSON
  3. 走完「登录 → 备跑 → 一键跑 → 轮询进度 → 记录详情 → 导出」全流程
  4. 配置补丁、设备指纹重置、删除记录等辅助动作可用

用法：
    .venv/bin/python scripts/webcheck.py          # 默认 Mock 模式
    .venv/bin/python scripts/webcheck.py -v       # 打印事件流尾部
"""
from __future__ import annotations

import argparse
import json
import sys
import tempfile
import threading
import time
import urllib.request
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
sys.path.insert(0, str(ROOT))

PASS: list[str] = []
FAIL: list[str] = []


def section(title: str) -> None:
    print(f"\n\033[1m══ {title} ══\033[0m")


def check(ok: bool, label: str, detail: str = "") -> bool:
    if ok:
        PASS.append(label)
        print(f"  \033[32m✓\033[0m {label}")
        if detail:
            print(f"       {detail[:150]}")
    else:
        FAIL.append(label)
        print(f"  \033[31m✗\033[0m {label}")
        if detail:
            print(f"       {detail[:200]}")
    return ok


def get_text(url: str, timeout: float = 5.0) -> tuple[int, str]:
    try:
        with urllib.request.urlopen(url, timeout=timeout) as r:
            return r.status, r.read().decode("utf-8", "replace")
    except Exception as e:  # noqa: BLE001
        return 0, f"{type(e).__name__}: {e}"


def post_api(url: str, method: str, *args, timeout: float = 120.0):
    body = json.dumps({"method": method, "args": list(args)}).encode("utf-8")
    req = urllib.request.Request(url, data=body,
                                 headers={"Content-Type": "application/json"})
    with urllib.request.urlopen(req, timeout=timeout) as r:
        return json.loads(r.read().decode("utf-8"))


def main() -> int:
    ap = argparse.ArgumentParser(description="前端链路自检")
    ap.add_argument("-v", "--verbose", action="store_true", help="打印事件流尾部")
    ap.add_argument("--keep", action="store_true", help="保留临时数据目录")
    args = ap.parse_args()

    from sdlab.app import App
    from sdlab.gui import build_http_server

    tmp = Path(tempfile.mkdtemp(prefix="sdlab-webcheck-"))
    app = App(data_dir=tmp, config_path=tmp / "config.json")
    events: list[dict] = []
    app.bus.subscribe(lambda ev: events.append(ev))

    httpd, page_url = build_http_server(app)
    api_url = page_url.split("/index.html")[0] + "/api"
    threading.Thread(target=httpd.serve_forever, daemon=True).start()

    print("\033[1m闪动校园 · 阳光跑工作台 —— 前端（HTTP 桥）链路自检\033[0m")
    print(f"工程 {ROOT}\n数据目录 {tmp}")

    try:
        # ── 1. 静态资源 ──
        section("1. 静态资源与桥")
        for name in ("index.html", "app.js", "style.css"):
            status, text = get_text(page_url.rsplit("/", 1)[0] + "/" + name)
            check(status == 200 and len(text) > 200,
                  f"{name} 可访问（{len(text)} 字节）", f"HTTP {status}")

        st = post_api(api_url, "status")
        check(isinstance(st, dict) and "mode" in st, "桥可用：status() 返回结构正确",
              json.dumps({k: st.get(k) for k in ("mode", "logged_in", "device_id")},
                         ensure_ascii=False))
        check(st.get("mock_url", "") != "" or st.get("mode") == "mock",
              "Mock 服务端地址已下发", str(st.get("mock_url", "")))

        bad = post_api(api_url, "this_method_does_not_exist")
        check(isinstance(bad, dict) and "error" in bad, "未知方法被安全拒绝",
              json.dumps(bad, ensure_ascii=False))

        # ── 2. 登录 ──
        section("2. 登录（与界面同一条链路）")
        r = post_api(api_url, "login", "13800138000", "any", True)
        check(r.get("code") == 0, "login() 成功", str(r.get("message"))[:120])
        st = post_api(api_url, "status")
        check(bool(st.get("logged_in")), "status() 反映已登录")
        cfg = post_api(api_url, "get_config")
        check(isinstance(cfg, dict) and "run" in cfg, "get_config() 返回配置树",
              json.dumps(cfg.get("run", {}), ensure_ascii=False))

        # 设备指纹重置（界面上的「重新生成 deviceId」）
        dev1 = (post_api(api_url, "status") or {}).get("device_id", "")
        post_api(api_url, "reset_device")
        dev2 = (post_api(api_url, "status") or {}).get("device_id", "")
        check(bool(dev2) and dev1 != dev2, f"reset_device() 生效（{dev1} → {dev2}）")

        # ── 3. 一键跑 ──
        section("3. 一键跑（备跑 → 轨迹 → 上传 → 结算）")
        prep = post_api(api_url, "prepare")
        check(prep.get("code") == 0, "prepare() 拉取围栏与规则",
              str(prep.get("message"))[:120])

        # 与前端一字不差：run_auto(目标距离, 围栏序号, 上传, 结算, 运动类型)
        r = post_api(api_url, "run_auto", 1500, 0, True, True, 1)
        check(r.get("code") == 0, "run_auto() 任务已启动", str(r.get("message"))[:120])

        # 与前端完全一致：轮询 poll()，用返回的 running 字段判断后台任务是否结束
        seq, t0, progress, seen_running = 0, time.time(), [], False
        while time.time() - t0 < 300:
            p = post_api(api_url, "poll", seq)
            if p.get("events"):
                # 与前端一致：用事件自带的 seq 推进游标（poll 不返回全局 seq）
                progress.extend(p["events"])
                for ev in p["events"]:
                    seq = max(seq, int(ev.get("seq") or 0))
            if p.get("running"):
                seen_running = True
            elif seen_running:
                break
            time.sleep(0.25)
        check(seen_running, "poll().running 曾为真（任务确实在跑）")
        kinds = {e.get("kind") for e in progress}
        check("progress" in kinds and "auto_done" in kinds,
              f"poll() 收到事件流（{len(progress)} 条，含 auto_done）",
              "kinds=" + ",".join(sorted(k for k in kinds if k))[:120])

        st = post_api(api_url, "status") or {}
        last = st.get("last") or {}
        check(bool(last.get("run_code")), f"本次记录号 {last.get('run_code')}")
        check(float(last.get("distance_m") or 0) > 1000,
              f"轨迹距离 {float(last.get('distance_m') or 0):.0f} 米")
        up = last.get("upload") or {}
        pts = (up.get("points") or {}).get("count") if isinstance(up, dict) else None
        check(bool(up) and (pts or 0) > 0, f"上传结果含条数（points={pts}）",
              json.dumps(up, ensure_ascii=False)[:200])

        # ── 4. 记录列表与详情 ──
        section("4. 记录列表 / 详情 / 导出")
        runs = post_api(api_url, "list_runs", 100)
        check(isinstance(runs, list) and len(runs) >= 1,
              f"list_runs() 返回 {len(runs) if isinstance(runs, list) else '?'} 条")
        code = last.get("run_code") or (runs[0]["run_code"] if runs else "")
        d = post_api(api_url, "run_detail", code)
        check(bool(d.get("run")), "run_detail() 含 run 元数据")
        check(len(d.get("points") or []) > 100,
              f"run_detail() 含轨迹点（{len(d.get('points') or [])} 个）")
        check(bool(d.get("counts")), "run_detail() 含上传计数",
              json.dumps(d.get("counts"), ensure_ascii=False))

        j = post_api(api_url, "export", code, "json")
        check(isinstance(j.get("path"), str) and Path(j["path"]).exists(),
              f"导出 JSON：{Path(str(j.get('path'))).name}（{Path(str(j.get('path'))).stat().st_size if j.get('path') else 0} 字节）")
        g = post_api(api_url, "export", code, "gpx")
        gpx_ok = bool(g.get("path")) and Path(g["path"]).exists() and "<gpx" in Path(g["path"]).read_text(encoding="utf-8")
        check(gpx_ok, f"导出 GPX：{Path(str(g.get('path'))).name}")

        # ── 5. 配置补丁 ──
        section("5. 运行参数热更新（界面「模拟参数」面板）")
        patch = json.dumps({"run": {"target_distance_m": 1234},
                            "sim": {"min_cadence": 170, "max_cadence": 185}})
        pr = post_api(api_url, "patch_config", patch)
        check(isinstance(pr, dict) and "error" not in pr,
              "patch_config() 接受 JSON 串（前端就是这么发的）",
              str(pr.get("message") or "返回完整配置树")[:120])
        cfg2 = post_api(api_url, "get_config")
        check(float(cfg2.get("run", {}).get("target_distance_m", 0)) == 1234.0,
              "补丁已生效（target_distance_m=1234）")

        # ── 6. 摇杆实走与「只规划不动」 ──
        section("6. 摇杆实走（干跑）与仅规划路径")
        plan = post_api(api_url, "walk_plan")
        pd = (plan or {}).get("data") or {}
        check(plan.get("code") == 0 and pd.get("planned") is True,
              "walk_plan() 仅返回规划结果（不开跑、不落库）",
              json.dumps({k: pd.get(k) for k in ("route_length_m", "est_duration_s",
                                                  "min_distance_m")}, ensure_ascii=False))
        check(len(pd.get("route") or []) >= 1, f"规划路线含 {len(pd.get('route') or [])} 个路点")

        # 干跑前先记下记录条数，干跑结束后必须一模一样（干跑绝不落库）
        before = len(post_api(api_url, "list_runs", 100) or [])
        ws = post_api(api_url, "walk_start", "dry", 0, 0, 3.0, False, False, 20.0)
        check(ws.get("code") == 0, "walk_start(dry) 已开始",
              json.dumps(ws.get("data", {}).get("state", {}), ensure_ascii=False)[:140])

        # 摇杆一推就动：两个方向分别推，采样点必须真变多
        post_api(api_url, "walk_joystick", 1.0, 0.0, 1.0)
        time.sleep(1.2)
        st1 = post_api(api_url, "walk_status", 0) or {}
        n1 = int(st1.get("total") or len(st1.get("points") or []))
        check(n1 >= 1, f"摇杆推动后已产生 {n1} 个轨迹点")
        post_api(api_url, "walk_joystick", 0.0, 1.0, 1.0)
        time.sleep(1.2)
        st2 = post_api(api_url, "walk_status", n1) or {}
        add = len(st2.get("points") or [])
        check(add >= 1, f"walk_status(since={n1}) 增量返回 {add} 个新点（界面靠它一笔笔画线）")

        # 只规划不动：给出路点后自动跟随打开，但仍可随时叫停
        rt = post_api(api_url, "walk_route", json.dumps(pd.get("route") or []), True, False)
        check(rt.get("code") == 0, "walk_route() 接受路点数组（仅渲染，不触发上传）",
              json.dumps(rt.get("data", {}), ensure_ascii=False)[:120])
        check(post_api(api_url, "walk_plan").get("code") == 0, "规划接口可重复调用（幂等）")

        post_api(api_url, "walk_joystick", 0, 0, 0)
        stp = post_api(api_url, "walk_stop")
        # walk_stop() 直接返回终态快照（running/state/stored），不是 {code,...} 包装
        check(stp.get("running") is False and isinstance(stp.get("state"), dict),
              "walk_stop() 已叫停并返回终态快照",
              json.dumps({"running": stp.get("running"),
                          "dist_m": (stp.get("state") or {}).get("dist_m"),
                          "steps": (stp.get("state") or {}).get("steps")}, ensure_ascii=False))
        after = len(post_api(api_url, "list_runs", 100) or [])
        check(after == before, f"干跑绝不落库（记录数 {before} → {after}）")
        up = post_api(api_url, "walk_upload", True)
        check(up.get("code") != 0, "干跑没有可上传记录，walk_upload() 被正确拒绝")

        # ── 6.5 实跑：轨迹/打卡/步频/配速必须边跑边落库 ──
        section("6.5 实跑（摇杆驱动）：边跑边落库")
        rs = post_api(api_url, "walk_start", "real", 0, 0, 3.0, True, True, 1.0)
        rc_walk = ((rs.get("data") or {}).get("run_code")) or ""
        check(rs.get("code") == 0 and bool(rc_walk),
              f"walk_start(real) 已开跑并拿到记录号 {rc_walk}",
              json.dumps((rs.get("data") or {}).get("state", {}), ensure_ascii=False)[:120])
        post_api(api_url, "walk_joystick", 1.0, 0.0, 1.0)
        time.sleep(4.0)
        mid = post_api(api_url, "walk_status", -1) or {}
        mid_detail = post_api(api_url, "run_detail", rc_walk) or {}
        n_pts = len(mid_detail.get("points") or [])
        check(n_pts >= 1, f"实跑中轨迹已实时写入本地库（{n_pts} 点）")
        if int(mid.get("steps") or 0) < 1:
            # 步频段每 20 秒切一刀（原版 CommonConfig.stepInterval）
            time.sleep(20.0)
            mid = post_api(api_url, "walk_status", -1) or {}
        check(int(mid.get("steps") or 0) >= 1,
              f"实跑中步频段已实时落库（{mid.get('steps')} 段）",
              json.dumps(mid.get("segments"), ensure_ascii=False))
        # 沿路线自动走，把打卡点蹭至（干跑的规划路线就是绕打卡点一圈）
        post_api(api_url, "walk_route", json.dumps(pd.get("route") or []), True, False)
        t0 = time.time()
        hits = 0
        while time.time() - t0 < 90:
            st_now = post_api(api_url, "walk_status", -1) or {}
            hits = int((st_now.get("state") or {}).get("passed") or 0)
            if hits >= 1 or not st_now.get("running"):
                break
            time.sleep(1.0)
        post_api(api_url, "walk_stop")
        walk_detail = post_api(api_url, "run_detail", rc_walk) or {}
        cps = walk_detail.get("checkpoints") or []
        passed = [c for c in cps if int(c.get("passed") or 0) == 1]
        check(hits >= 1 and len(passed) >= 1,
              f"实跑实时检测打卡点并写库（{len(passed)}/{len(cps)} 已打卡）",
              json.dumps([{"index": c.get("index"), "passed": c.get("passed")} for c in cps],
                         ensure_ascii=False)[:160])
        check(len(walk_detail.get("steps") or []) >= 1,
              f"停止后步频段仍在（{len(walk_detail.get('steps') or [])} 段）")
        wrun = walk_detail.get("run") or {}
        check(wrun.get("source") == "walk" and float(wrun.get("distance_m") or 0) > 0,
              f"实跑收尾已写回距离（{float(wrun.get('distance_m') or 0):.0f} 米）")
        wup = post_api(api_url, "walk_upload", True)
        check(wup.get("code") == 0, "实跑结果可原地上传结算",
              json.dumps(wup.get("data") or wup, ensure_ascii=False)[:160])

        # ── 7. 删除记录 ──
        section("7. 删除记录")
        dr = post_api(api_url, "delete_run", code)
        check(isinstance(dr, dict) and dr.get("code") == 0 and "error" not in dr,
              f"delete_run({code}) 完成", json.dumps(dr, ensure_ascii=False)[:120])
        left = post_api(api_url, "list_runs", 100)
        check(all(x.get("run_code") != code for x in left or []), "记录已从列表移除")

        if args.verbose:
            print("\n  ── 事件流（尾部 12 条）──")
            for ev in events[-12:]:
                print(f"     [{ev.get('kind')}] {str(ev.get('message'))[:110]}")
    finally:
        httpd.shutdown()
        app.close()
        if not args.keep:
            import shutil
            shutil.rmtree(tmp, ignore_errors=True)

    total = len(PASS) + len(FAIL)
    print(f"\n\033[1m结果：{len(PASS)}/{total} 通过\033[0m")
    if FAIL:
        print("失败项：")
        for f in FAIL:
            print(f"  \033[31m✗\033[0m {f}")
        return 1
    print("全部通过 ✅")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
