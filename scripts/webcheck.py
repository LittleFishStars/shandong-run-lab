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

        # ── 6. 删除记录 ──
        section("6. 删除记录")
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
