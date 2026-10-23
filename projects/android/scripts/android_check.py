#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""免手机全流程自检：在**桌面 Python** 里直接 import android_api，走 mock 全流程。

这是移动端（Chaquopy）桥的验收脚本，口径与桌面版 `scripts/selfcheck.py` 一致，
但通过**同一个** `android_api.dispatch(method, args_json)` 驱动——即 App 侧真正要跑的
那条唯一入口。

用法：
    python3 projects/android/scripts/android_check.py
    ~/.local/bin/python3.12 projects/android/scripts/android_check.py   # Chaquopy 用 3.12

覆盖：
  1. `android_api.methods()` 与契约 §2（= 桌面版 `gui.JsApi` 方法集）完全一致
     （多一个少一个都判失败，并列出差异）。
  2. 对**每个**方法都经 `dispatch(name, args_json)` 真调一次（参数给合法值），
     断言返回的是合法 JSON、且不含 error 键（个别方法允许业务失败，见白名单）。
  3. mock 全流程（**全新 App 实例**，与冒烟层隔离）：login → prepare → reload_rule
     → set_start_point → walk_start(real) → walk_joystick × N → walk_status
     → walk_stop → walk_upload → server_records → server_record_detail →
     export → list_runs → run_detail，并断言里程/记录增长、导出文件存在。
  4. ✓/✗ 汇总；有任何失败退出码非 0。

依赖：**不要求安装 Pillow**（mock 登录链路用 do_captcha=False 绕开滑块）。
兼容 Python 3.12（Chaquopy 运行时版本）与 3.14（本机桌面版）。
"""
from __future__ import annotations

import json
import os
import shutil
import sys
import tempfile
import threading
import time
from pathlib import Path

# ── 把 android 的 python 源根加进 sys.path，直接 import android_api ──
SCRIPT_DIR = Path(__file__).resolve().parent.parent
PY_ROOT = SCRIPT_DIR / "app" / "src" / "main" / "python"
sys.path.insert(0, str(PY_ROOT))

import android_api  # noqa: E402

PASS: list[str] = []
FAIL: list[str] = []


def section(title: str) -> None:
    print(f"\n\033[1m══ {title} ══\033[0m")


def check(ok: bool, label: str, detail: str = "") -> bool:
    if ok:
        PASS.append(label)
        print(f"  \033[32m✓\033[0m {label}")
        if detail:
            print(f"       {detail[:160]}")
    else:
        FAIL.append(label)
        print(f"  \033[31m✗\033[0m {label}")
        if detail:
            print(f"       {detail[:220]}")
    return ok


def call(name: str, args_json: str = "[]"):
    """经唯一入口 dispatch 调一次并解析 JSON；返回 (原始串, 解析结果)。"""
    raw = android_api.dispatch(name, args_json)
    try:
        return raw, json.loads(raw)
    except Exception as e:  # noqa: BLE001
        return raw, {"__bad_json__": str(e)}


# ══════════════════════════════════════════════════════════════════
# 契约 §2 的方法集（与桌面 gui.JsApi 逐字一致）
# ══════════════════════════════════════════════════════════════════
CONTRACT_METHODS = [
    "ping", "status", "poll", "events",
    "login", "logout", "list_accounts", "switch_account", "forget_account",
    "relogin_account", "refresh_user",
    "prepare", "reload_rule", "run_auto", "resume",
    "walk_start", "walk_joystick", "walk_stop", "walk_status", "walk_route",
    "walk_auto", "walk_speed", "walk_pause", "walk_upload", "walk_save", "walk_plan",
    "set_start_point", "ui_report",
    "list_runs", "server_records", "server_record_detail", "run_detail",
    "export", "delete_run",
    "get_config", "patch_config", "switch_mode", "check_update", "open_url",
    "reset_device", "mock_info", "open_data_dir", "toast", "quit",
]

# 每个方法的「合法参数」（JSON 数组字符串），供冒烟层真调。
ARG_TABLE = {
    "ping": "[]",
    "status": "[]",
    "poll": "[0]",
    "events": "[0]",
    "login": '["13800138000", "any-password", false]',
    "logout": "[]",
    "list_accounts": "[]",
    "switch_account": '[""]',
    "forget_account": '[""]',
    "relogin_account": '[""]',
    "refresh_user": "[]",
    "prepare": "[0]",
    "reload_rule": "[]",
    "run_auto": '[100, 0, true, true, 1]',
    "resume": '[""]',
    "walk_start": '["dry", 0, 0, 3.0, false, false, 1.0]',
    "walk_joystick": "[0.6, 0.4, 0.9]",
    "walk_stop": "[]",
    "walk_status": "[-1]",
    "walk_route": '[null, true, false]',
    "walk_auto": "[true]",
    "walk_speed": "[2.5]",
    "walk_pause": "[false]",
    "walk_upload": "[false]",
    "walk_save": '["自检草稿"]',
    "walk_plan": "[]",
    "set_start_point": "[36.68, 117.06]",
    "ui_report": '[{"ctl": "joystick", "x": 0, "y": 0, "w": 120, "h": 120}]',
    "list_runs": "[20]",
    "server_records": '[1, 10, "", ""]',
    "server_record_detail": '["", ""]',
    "run_detail": '[""]',
    "export": '["", "json"]',
    "delete_run": '[""]',
    "get_config": "[]",
    "patch_config": '[{"run": {"target_distance_m": 1234}}]',
    "switch_mode": '["mock"]',
    "check_update": "[]",
    "open_url": '["https://example.com"]',
    "open_data_dir": "[]",
    "mock_info": "[]",
    "toast": '["hello"]',
    "reset_device": "[]",
    "quit": "[]",
}

# 允许「业务失败」的方法（必须仍是合法 JSON）：
#   check_update —— 查 GitHub，离线/沙箱里天然失败，且成功路径也可能带空 error；
#   run_detail / server_record_detail / export / delete_run —— 空记录码本就无记录可查；
#   relogin_account / switch_account —— 冒烟层传空串，无历史账号属正常；
#   resume —— 空串无断点可续。
ALLOWED_BUSINESS_ERROR = {
    "check_update", "run_detail", "server_record_detail", "export",
    "delete_run", "relogin_account", "switch_account", "resume",
}


def _is_error(result) -> bool:
    # 只认「真值 error」：walk_status / server_records 等返回里本来就带
    # `"error": ""` 字段（桌面版同款），空值不是错。
    return isinstance(result, dict) and bool(result.get("error"))

def make_app(tmp: Path, mode: str = "mock"):
    """建一个独立的 App 实例并挂到 android_api 单例上（自检专用钩子）。"""
    from shandong_school_cracked.app import App
    app = App(data_dir=tmp, config_path=tmp / "config.json", mode=mode)
    android_api._set_app(app)
    return app


# ══════════════════════════════════════════════════════════════════
# 第 1/2 层：冒烟（一次性 App，跑完即弃）
# ══════════════════════════════════════════════════════════════════
def run_smoke() -> None:
    tmp = Path(tempfile.mkdtemp(prefix="shandong-android-smoke-"))
    os.environ["SDLAB_HOME"] = str(tmp)
    app = make_app(tmp, mode="mock")
    try:
        # ── 1. 方法集一致性 ──
        section("1. 方法集一致性（契约 §2 / 桌面 gui.JsApi）")
        required = android_api.methods()
        extra = [m for m in required if m not in CONTRACT_METHODS]
        missing = [m for m in CONTRACT_METHODS if m not in required]
        dup = sorted({m for m in required if required.count(m) > 1})
        ok = (not extra) and (not missing) and (not dup)
        detail = ""
        if missing:
            detail += f"缺 {len(missing)} 个：{','.join(missing)}；"
        if extra:
            detail += f"多 {len(extra)} 个：{','.join(extra)}；"
        if dup:
            detail += f"重复：{','.join(dup)}"
        check(ok, f"方法集一致（{len(required)} 个）", detail)

        # ── 先登录（让后面每个方法都处在「已登录」状态下真调）──
        raw, res = call("login", ARG_TABLE["login"])
        check(not _is_error(res) and res.get("code") == 0,
              "login() mock 登录成功",
              (res.get("message") or "")[:120] if isinstance(res, dict) else raw[:120])

        # ── 2. 逐一真调 dispatch ──
        section("2. 每个方法经 dispatch 真调一次（已登录态）")
        # 会破坏会话/收尾类的方法放到最后调（logout 清会话、switch_mode 重建 client、
        # quit/forget/delete 是破坏性动作），其余按白名单原序：先只读，再写。
        last_names = {"logout", "quit", "switch_mode", "reset_device",
                      "forget_account", "delete_run"}
        ordered = ([m for m in android_api.methods() if m not in last_names]
                   + [m for m in android_api.methods() if m in last_names])
        n_ok = n_fail = n_allow = 0
        for name in ordered:
            args_json = ARG_TABLE.get(name, "[]")
            try:
                raw, res = call(name, args_json)
            except Exception as e:  # noqa: BLE001
                n_fail += 1
                check(False, f"{name}() 抛异常：{type(e).__name__}: {e}")
                continue
            if "__bad_json__" in res:
                n_fail += 1
                check(False, f"{name}() 返回不是合法 JSON", raw[:160])
                continue
            if _is_error(res):
                if name in ALLOWED_BUSINESS_ERROR:
                    n_allow += 1
                    check(True, f"{name}() 返回 error（白名单内业务失败）",
                          str(res.get("error"))[:120])
                else:
                    n_fail += 1
                    check(False, f"{name}() 返回 error", str(res.get("error"))[:160])
            else:
                n_ok += 1
        check(n_fail == 0,
              f"全部方法可达且返回合法 JSON（{n_ok} 成功 / {n_allow} 白名单 / {n_fail} 失败）")

        # run_auto 是后台线程（auto-run）：等它退出再关 App，避免残留线程与
        # 全流程层的实走争抢 GIL（实测会把推进速度拖慢一半以上）
        deadline = time.time() + 60
        while time.time() < deadline and any(
                t.name == "auto-run" for t in threading.enumerate()):
            time.sleep(0.5)
        check(not any(t.name == "auto-run" for t in threading.enumerate()),
              "run_auto 的后台线程已退出（不干扰后续全流程）")

        # ── 3. ping 结构 ──
        raw, res = call("ping")
        check(all(k in res for k in ("ok", "mode", "ts", "app_version")),
              "ping() 返回结构（ok/mode/ts/app_version）",
              json.dumps(res, ensure_ascii=False)[:120])
    finally:
        try:
            app.close()
        except Exception:  # noqa: BLE001
            pass
        shutil.rmtree(tmp, ignore_errors=True)


# ══════════════════════════════════════════════════════════════════
# 第 3 层：mock 全流程（全新 App 实例，与冒烟层零共享）
# ══════════════════════════════════════════════════════════════════
def run_full_flow() -> None:
    tmp = Path(tempfile.mkdtemp(prefix="shandong-android-flow-"))
    os.environ["SDLAB_HOME"] = str(tmp)
    app = make_app(tmp, mode="mock")
    try:
        section("3. mock 全流程（登录 → 选点 → 开跑 → 摇杆 → 结算 → 记录/导出）")

        raw, login = call("login", ARG_TABLE["login"])
        check(not _is_error(login) and login.get("code") == 0, "登录成功",
              json.dumps(login, ensure_ascii=False)[:120] if isinstance(login, dict) else raw[:120])

        raw, prep = call("prepare", "[0]")
        check(not _is_error(prep) and prep.get("code") == 0, "prepare() 备跑成功",
              json.dumps(prep, ensure_ascii=False)[:120])

        raw, rule = call("reload_rule")
        check(not _is_error(rule) and rule.get("code") == 0, "reload_rule() 拉学校规则")

        raw, st = call("status")
        st = st if isinstance(st, dict) else {}
        check(bool(st.get("logged_in")), "status() 显示已登录",
              f"fences={len(st.get('fences') or [])} rule_source={bool(st.get('rule_source'))}")

        # 起始点：先设一个围栏内点，再清除（回围栏中心），两次都走桥
        raw, sp = call("set_start_point", "[36.68, 117.06]")
        check(not _is_error(sp) and sp.get("code") == 0, "set_start_point(lat,lng) 设点")
        raw, sp2 = call("set_start_point", "[null, null]")
        check(not _is_error(sp2) and sp2.get("code") == 0, "set_start_point(null,null) 清点")

        # 开跑：real 模式 + auto_start（拿 runRecordCode）；速度 2.5 m/s（6'40" 配速，
        # 在规则区间内，mock 复核才判有效）；时间倍速 1（距离按真实时间累积）
        raw, ws = call("walk_start", '["real", 300, 0, 2.5, false, true, 1]')
        ws_ok = (not _is_error(ws)) and ws.get("code") == 0
        check(ws_ok, "walk_start(real) 开跑成功",
              json.dumps(ws, ensure_ascii=False)[:160] if isinstance(ws, dict) else raw[:160])
        if not ws_ok:
            return

        # 摇杆推进：推杆 → 以 since=0 起轮询 walk_status 增量点位，直到 dist_m ≥ 目标
        # （walk_status(since=-1) 只回状态；since>=0 才带增量 points/total —— 与前端一致）
        # 实走距离按真实时间累积（speed 倍速只影响时间戳口径），2.5 m/s 跑 300 m 约 120 s
        target = 300.0
        last_dist = -1.0
        points_seen = 0
        since = 0
        deadline = time.time() + 240
        # 方向轮转（东→北→西→南，每 8 s 换向）：固定向东会撞围栏东边界被夹住
        # （实测两次都恰好停在 239 m —— 围栏中心到东边的距离）
        dirs = [(1.0, 0.0), (0.0, 1.0), (-1.0, 0.0), (0.0, -1.0)]
        turn_every = 32          # 0.25 s × 32 = 8 s 换向
        i = 0
        while time.time() < deadline:
            dx, dy = dirs[(i // turn_every) % 4]
            call("walk_joystick", json.dumps([dx, dy, 1.0]))
            i += 1
            time.sleep(0.25)
            raw, wst = call("walk_status", json.dumps([since]))
            wstate = (wst or {}).get("state") or {}
            last_dist = float(wstate.get("dist_m") or 0.0)
            pts = wst.get("points") or []
            points_seen += len(pts) if isinstance(pts, list) else 0
            since = int(wst.get("total") or since)
            if last_dist >= target:
                break
        check(last_dist >= target,
              f"摇杆推进到目标里程（{last_dist:.0f}/{target:.0f} m，采样 {points_seen} 点）")

        raw, wj0 = call("walk_joystick", "[0, 0, 0]")
        check(not _is_error(wj0) and wj0.get("code") == 0, "松杆回中")

        raw, stop = call("walk_stop")
        # walk_stop 返回的是收尾状态字典（无 code 键）：running=False 即成功收尾
        check(not _is_error(stop) and stop.get("running") is False,
              "walk_stop() 结束本次（running=false）",
              json.dumps(stop, ensure_ascii=False)[:120] if isinstance(stop, dict) else raw[:120])

        # 先等跑中的增量上传（poiInterval 15s 一批）飞完，再发结算；
        # 撞上「已有任务在运行」就重试（最多 5 次 × 2 s）
        time.sleep(3.0)
        raw, up = {"error": ""}, None
        for _ in range(5):
            raw, up = call("walk_upload", "[true]")
            if not _is_error(up):
                break
            time.sleep(2.0)
        up_ok = (not _is_error(up)) and up.get("code") == 0
        check(up_ok, "walk_upload(true) 上传结算",
              json.dumps(up, ensure_ascii=False)[:160] if isinstance(up, dict) else raw[:160])


        # 服务端记录：应出现刚才那条（上传异步，最多等 ~20 s）
        items: list = []
        run_code = ""
        semester = ""
        deadline = time.time() + 20
        while time.time() < deadline:
            raw, recs = call("server_records", '[1, 20, "", ""]')
            items = (recs or {}).get("items") or []
            if items:
                break
            time.sleep(1.0)
        check(bool(items), f"server_records() 拉到 {len(items)} 条服务端记录")
        if items:
            run_code = str((items[0] or {}).get("run_code") or "")
            semester = str((items[0] or {}).get("semester_code") or "")

        # 明细：desktop 同款结构（ok/record/target_points/point_count…）。
        # 注：mock 的 runRecordDetail 恒回空 targetPoints/pois（mock 局限），
        # 所以这里断「明细可达 + 字段在」，计数只作信息展示。
        raw, det = call("server_record_detail", json.dumps([run_code, semester]))
        n_points = int((det or {}).get("target_points") or 0)
        n_pois = int((det or {}).get("point_count") or 0)
        check(bool(run_code) and (det or {}).get("ok") is True
              and "target_points" in (det or {}),
              f"server_record_detail() 明细可达（打卡点 {n_points} / 轨迹点 {n_pois}，mock 恒空）",
              f"run_code={run_code}")

        # 本地记录 + 详情
        # 本地记录（App.list_runs 返回 list）
        raw, runs = call("list_runs", "[20]")
        check(isinstance(runs, list) and len(runs) > 0,
              f"list_runs() 本地记录 {len(runs) if isinstance(runs, list) else 0} 条",
              ("非 list：" + str(type(runs))) if not isinstance(runs, list) else "")
        raw, rd = call("run_detail", json.dumps([run_code]))
        check(not _is_error(rd), "run_detail() 可调（详情结构见桌面口径）",
              json.dumps(rd, ensure_ascii=False)[:120] if isinstance(rd, dict) else raw[:120])

        # 导出 JSON：文件要真实存在（App.export 返回 {code, path}）
        raw, ex = call("export", json.dumps([run_code, "json"]))
        path = str((ex or {}).get("path") or "") if isinstance(ex, dict) else ""
        ok_export = isinstance(ex, dict) and ex.get("code") == 0 and bool(path) and Path(path).exists()
        check(ok_export, "export(json) 导出文件存在", path or raw[:120])

        # 本地库清理动作也要能走通（删的是刚导出的那条之后的状态，不影响别的断言）
        raw, dele = call("delete_run", json.dumps([run_code]))
        check(not _is_error(dele), "delete_run() 可调",
              json.dumps(dele, ensure_ascii=False)[:120] if isinstance(dele, dict) else raw[:120])
    finally:
        try:
            app.close()
        except Exception:  # noqa: BLE001
            pass
        shutil.rmtree(tmp, ignore_errors=True)


def main() -> int:
    print("\033[1m闪动校园 · 安卓桥（android_api.dispatch）免手机自检\033[0m")
    print(f"Python {sys.version.split()[0]} | {PY_ROOT}")
    run_smoke()
    run_full_flow()

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
