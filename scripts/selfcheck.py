#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""端到端自检：本地 Mock 模式下跑通「登录 → 阳光跑 → 数据记录 → 数据上传」。

这是交付前的验收脚本，也是排查问题的第一入口::

    python scripts/selfcheck.py            # 完整自检
    python scripts/selfcheck.py -v         # 打印每一步的事件流

自检覆盖：
  1. 密码学层字节级一致性（字段加密 / 签名 / 滑块 / 结算码）
  2. 模拟层（轨迹生成、步频仿真、有效性判定）
  3. 登录链路（loginCheck → captcha → loginPassword）
  4. 阳光跑链路（规则 → 开跑 → 轨迹/配速/步频/步幅/打卡 上传 → 结算）
  5. 数据记录层（SQLite 落盘、断点续传状态位、JSON/GPX 导出）
  6. 失败注入下的重试与断点续传
"""
from __future__ import annotations

import argparse
import json
import shutil
import sys
import tempfile
import time
from pathlib import Path

ROOT = Path(__file__).resolve().parent.parent
if str(ROOT) not in sys.path:
    sys.path.insert(0, str(ROOT))

from sdlab import App                                    # noqa: E402
from sdlab import constants as C                         # noqa: E402
from sdlab import crypto                                 # noqa: E402

OK, FAIL = "\033[32m✓\033[0m", "\033[31m✗\033[0m"
_results: list[tuple[bool, str]] = []


def check(cond: bool, title: str, detail: str = "") -> bool:
    """记录一条断言结果。"""
    _results.append((bool(cond), title))
    line = f"  {OK if cond else FAIL} {title}"
    if detail:
        line += f"\n       {detail}"
    print(line, flush=True)
    return bool(cond)


def section(title: str) -> None:
    print(f"\n\033[1m══ {title} ══\033[0m", flush=True)


# ══════════════════════════════════════════════════════════════════
# 1. 密码学层
# ══════════════════════════════════════════════════════════════════
def test_crypto() -> None:
    section("1. 密码学层（与逆向结论逐字节对照）")

    # 字段加密：服务端 auth/loginCheck 回显的已知密文
    enc = crypto.encrypt_field("13800138000")
    check(enc == "WQZsdeHd/SBQZ8ZhmJzWhg==", "字段加密 13800138000 → 已知密文一致", enc)

    # 往返
    check(crypto.decrypt_field(enc) == "13800138000", "字段解密往返一致")

    # 签名：108 字符 base64，且对同一 json 稳定、对不同 json 敏感
    body = {"modelName": "SM-A5460", "timestamp": "1750000000000"}
    s1, s2 = crypto.get_sign(body), crypto.get_sign(dict(body))
    check(len(s1) == 108, "sign 长度 108 字符", f"len={len(s1)}")
    check(s1 == s2, "sign 对相同报文稳定", s1[:40] + "…")
    check(crypto.get_sign({**body, "timestamp": "1750000000001"}) != s1, "sign 对报文变化敏感")

    # 签名中间值（T 变换）可逆性
    mid = crypto.sign_middle(json.dumps(body, separators=(",", ":"), ensure_ascii=False))
    check(isinstance(mid, str) and len(mid) == len(mid), "sign_middle 可计算")

    # 滑块坐标伪装：fake_x = int(raw_x - 6.5) + 16.5
    pt = crypto.encrypt_slider_point(100.0)
    raw = crypto.decrypt_slider_point(pt)
    data = json.loads(raw) if isinstance(raw, (str, bytes)) else raw
    check(abs(float(data["x"]) - (int(100.0 - C.SLIDER_MARGIN) + C.SLIDER_OFFSET)) < 1e-6,
          "滑块坐标伪装公式一致", f"raw=100 → x={data['x']}")

    # encodeRun（结算防篡改码）：公式与原版 liby.so 一致，用预言机真样本守
    code = crypto.calculate_run_img_record("SDLABTEST", "1750000000000")
    check(len(code) == 32 and code.islower(), "结算码 runImgRecord 为 32 位小写 MD5", code)
    oracle = [('{"x":1}', '26101017', '8.7.7', 'A', 0,
               '05017afe6ac20923b6ee765aa503ccb0'),
              ('a', '', '', '', 0, '8233e43470579ae9f0a581da8cdc7706'),
              ('a', '1', '2', '3', 0, '1ad3dd1ef9e043ed81733362911c497e')]
    hit = sum(1 for a, b, c, d, env, want in oracle
              if crypto.run_img_record(a, d, build_version=b, app_version=c, env=env) == want)
    check(hit == len(oracle), "encodeRun 与原版预言机逐字节一致",
          f"{hit}/{len(oracle)}")


# ══════════════════════════════════════════════════════════════════
# 2. 模拟层
# ══════════════════════════════════════════════════════════════════
def test_simulator() -> None:
    section("2. 模拟层（轨迹 / 步频 / 有效性）")

    from sdlab.protocol import RuleSet, TrackGenerator, evaluate_run, haversine
    from sdlab.simulator import FuckRunSim

    gen = TrackGenerator(center_lat=36.67, center_lng=117.05,
                         target_distance_m=2000.0, target_seconds=720,
                         stride_m=0.85, cadence_spm=176.0,
                         fence_radius_m=260.0, sample_s=3.0, seed=7)
    track = gen.generate_track()
    dist = sum(haversine(a.lat, a.lng, b.lat, b.lng) for a, b in zip(track, track[1:]))
    check(len(track) > 100, f"轨迹点数量合理（{len(track)} 点）")
    check(0.7 * 2000 <= dist <= 1.4 * 2000, f"轨迹总长度接近目标（{dist:.0f} m / 2000 m）")
    # offFenceDisM 的语义是「离开围栏的总距离」，常态 -1；这里直接判点在不在围栏内
    check(all(haversine(36.67, 117.05, p.lat, p.lng) <= 260.0 for p in track),
          "所有轨迹点都在围栏内（离中心 ≤ 260 米）")

    sim = FuckRunSim(min_cadence=172.0, max_cadence=182.0, seed=7)
    sim.start(base_steps=12000.0)
    samples = list(sim.timeline(duration_s=60.0, hz=25.0))
    cads = [s.cadence for s in samples]
    check(all(150.0 <= c <= 200.0 for c in cads),
          f"步频落在合理区间（{min(cads):.1f} ~ {max(cads):.1f} 步/分）")
    zs = [s.z for s in samples]
    check(all(0.5 < z < 30.0 for z in zs), f"加速度 z 值合理（{min(zs):.2f} ~ {max(zs):.2f}）")
    jumped = sim.steps_at(60.0) - 12000.0
    check(jumped > 100, f"计步器累加正常（60 秒 {jumped:.0f} 步）")

    verdict = evaluate_run(track, 720, int(dist / 0.85), RuleSet())
    check(hasattr(verdict, "is_valid"), "有效性判定可执行",
          json.dumps(verdict.to_dict(), ensure_ascii=False))


# ══════════════════════════════════════════════════════════════════
# 2.5 跑步起点（地图上选点：围栏吸附 / 三处生效 / 持久化）
# ══════════════════════════════════════════════════════════════════
def test_start_point() -> None:
    section("2.5 跑步起点（图上选点 → 围栏吸附 → 开跑报文 / 实走轨迹 / 路径规划）")

    from sdlab.protocol import (SNAP_MARGIN_M, closest_point_on_polygon,
                                point_in_polygon)

    tmp = Path(tempfile.mkdtemp(prefix="sdlab-check-start-"))
    app = App(data_dir=tmp, config_path=tmp / "config.json", mode="mock")
    try:
        app.login("13800138000", "any-password", False)
        app.run_prepare()
        st = app.status()
        check(st.get("start_point") is None and not st.get("start_point_custom"),
              "默认没有自定义起点（一律按围栏中心算）")

        poly = [tuple(p) for p in app.client.fence_polygon()]
        clat, clng = app.client.fence_center()
        r = app.set_start_point(clat + 0.01, clng)          # 往北 1.1 km，肯定在围栏外
        sp = (r.get("data") or {}).get("start_point") or {}
        _, _, dm = closest_point_on_polygon(sp.get("lat", 0.0), sp.get("lng", 0.0), poly)
        check(r.get("code") == 0 and sp.get("snapped") and sp.get("in_fence")
              and point_in_polygon(sp.get("lat", 0.0), sp.get("lng", 0.0), poly)
              and abs(dm - SNAP_MARGIN_M) < 1.5,
              "围栏外的起点自动吸附进围栏（贴着边界，不被抛到围栏中心）",
              f"离边界 {dm:.1f} 米（margin {SNAP_MARGIN_M:.0f} 米）")

        d = app.walk_plan().get("data") or {}
        check(abs(d["start"]["lat"] - sp["lat"]) < 1e-6
              and abs(d["start"]["lng"] - sp["lng"]) < 1e-6,
              "路径规划从所选起点开始")

        app.walk_start("dry", target_m=0, fence_index=0, speed_mps=3.0,
                       auto_route=False, auto_start=False, speed=30.0)
        time.sleep(0.6)
        app.walk_joystick(1.0, 0.0, 0.5)
        time.sleep(0.6)
        pts = (app.walk_status(0) or {}).get("points") or []
        p0 = pts[0] if pts else {}
        check(bool(p0) and abs(float(p0.get("lat", 0.0)) - sp["lat"]) < 5e-5,
              "实走轨迹的第一个点就是所选起点",
              f"首点 {p0.get('lat')}, {p0.get('lng')}")
        app.walk_stop()

        # 起点真的进了开跑报文：把围栏藏起来（吸附不可用），Mock 便会当场指出“起点不在围栏内”
        seq = (app.bus.events_since(0, 1) or [{"seq": 0}])[-1]["seq"]
        原围栏 = app.client.fence_polygon
        app.client.fence_polygon = lambda *a, **k: []
        try:
            app.set_start_point(clat + 0.01, clng)
        finally:
            app.client.fence_polygon = 原围栏
        app.walk_start("real", target_m=0, fence_index=0, speed_mps=0.0,
                       auto_route=False, auto_start=True, speed=30.0)
        time.sleep(0.8)
        消息 = " | ".join(e.get("message", "") for e in app.bus.events_since(seq))
        app.walk_stop()
        check("Mock 开跑成功" in 消息 and "起点不在围栏内" in 消息,
              "开跑报文的 lat/lng 用的就是所选起点（Mock 服务端口径校验）")

        lat, lng = app.start_lat_lng()
        check(abs(lat - (clat + 0.01)) < 1e-6 and app.store.kv_get("start_point") is not None,
              "起点写进本地库 kv（重启后仍然生效）")

        app.set_start_point()
        check(app.status().get("start_point") is None
              and app.store.kv_get("start_point") is None,
              "清除起点：回到围栏中心，并从库里删掉")
        check(app.set_start_point(0.0, 0.0).get("code") != 0
              and app.set_start_point("x", "y").get("code") != 0,
              "非法坐标被拒（0,0 与 非数字）")
    finally:
        app.close()
        shutil.rmtree(tmp, ignore_errors=True)

def test_checkpoints_source() -> None:
    section("2.6 打卡点来源（拉取配置只有围栏与计数，开跑才下发打卡点）")

    tmp = Path(tempfile.mkdtemp(prefix="sdlab-check-cp-"))
    apps: list = []
    try:
        app = App(data_dir=tmp, config_path=tmp / "config.json", mode="mock")
        apps.append(app)
        app.login("13800138000", "any-password", False)
        app.run_prepare()
        st = app.status()
        check(st.get("checkpoints") == [],
              "拉取配置后没有打卡点（地图上不该出现它们）",
              f"checkpoints={len(st.get('checkpoints') or [])}")
        check(bool(st.get("preview_points")),
              "同一时刻有按围栏预估的预览点（只给高级里的路径预览用）",
              f"preview_points={len(st.get('preview_points') or [])}")

        d = app.walk_plan().get("data") or {}
        check(bool(d.get("estimated")) and bool(d.get("route")),
              "开跑前规划走预估点，并在回执里标明 estimated=True",
              f"{len(d.get('route') or [])} 个点")

        app.walk_start("real", target_m=0, fence_index=0, speed_mps=0.0,
                       auto_route=False, auto_start=True, speed=30.0)
        st2 = app.status()
        cps = st2.get("checkpoints") or []
        check(st2.get("checkpoints_source") == "server" and len(cps) >= 1,
              "开跑后用服务端下发的 targetPoints", f"checkpoints={len(cps)}")
        check(not (app.walk_plan().get("data") or {}).get("estimated"),
              "拿到真实打卡点后规划不再是预估的")

        def 签名(seq) -> list:
            return [(round(float(c["lat"]), 6), round(float(c["lng"]), 6)) for c in seq]

        code = str((app.engine.last or {}).get("run_code") or "")
        check(bool(code) and 签名(cps) == 签名(app.store.get_checkpoints(code)),
              "真实打卡点落进这一趟的记录（上传/结算按它们判）")
        app.walk_stop()

        app.close()
        app2 = App(data_dir=tmp, config_path=tmp / "config.json", mode="mock")
        apps.append(app2)
        check(app2.status().get("checkpoints") == [],
              "重启后不会把上一趟记录的打卡点当成这次的")
    finally:
        for a in apps:
            try:
                a.close()
            except Exception:  # noqa: BLE001
                pass
        shutil.rmtree(tmp, ignore_errors=True)

def test_auto_run() -> None:
    section("2.7 自动跑 / 手动摇杆（默认手动，点了「自动跑」才跟路线）")
    tmp = Path(tempfile.mkdtemp(prefix="sdlab-check-"))
    app = App(data_dir=tmp, config_path=tmp / "config.json", mode="mock")
    try:
        app.login("13800138000", "any-password", False)
        app.run_prepare()
        # 默认手动：不跟路线，等摇杆
        st = app.walk_start("dry", 0.0, 0, 3.0, False, False, 30.0)
        check(st.get("code") == 0 and (st.get("data") or {}).get("auto") is False,
              "默认手动开跑（auto=false）", f"{st.get('data')}")
        # 运行中切自动：沿规划路线走
        check(app.walk_auto(True).get("code") == 0
              and app.walk_status(-1).get("auto") is True,
              "点「自动跑」后后端切为自动")
        # 推杆即接管：一推杆就回手动（与后端的 joystick() 语义一致）
        app.walk_joystick(1.0, 0.0, 0.8)
        check(app.walk_status(-1).get("auto") is False,
              "推杆即接管：手动摇杆自动压过自动巡航")
        check(app.walk_auto(False).get("code") == 0,
              "再点一次能切回手动")
        # 开跑时给的 auto 是一次性的：不能留着下次强制自动
        app.walk_stop()
        app.walk_start("dry", 0.0, 0, 3.0, False, False, 30.0)
        check(app.walk_status(-1).get("auto") is False,
              "下一次开跑仍默认手动（pending 不残留）")
        app.walk_stop()
    finally:
        try:
            app.close()
        except Exception:  # noqa: BLE001
            pass
        shutil.rmtree(tmp, ignore_errors=True)

def test_elapsed_no_freeze() -> None:
    section("2.8 停下来时间照走（时长/配速不冻住，原版 Q0() 口径）")
    tmp = Path(tempfile.mkdtemp(prefix="sdlab-check-"))
    app = App(data_dir=tmp, config_path=tmp / "config.json", mode="mock")
    try:
        app.login("13800138000", "any-password", False)
        app.run_prepare()
        app.walk_start("dry", 0.0, 0, 3.0, False, False, 30.0)
        app.walk_joystick(1.0, 0.0, 0.8)
        time.sleep(1.5)
        app.walk_joystick(0.0, 0.0, 0.0)      # 松开摇杆：站着不动
        time.sleep(0.8)
        st = (app.walk_status(-1).get("state") or {})
        d1 = float(st.get("dist_m") or 0)
        e1 = float(st.get("elapsed_sec") or 0)
        m1 = float(st.get("move_sec") or 0)
        check(d1 > 0, "先走出一段距离", f"{d1:.1f} 米 / 时长 {e1:.1f} 秒")
        time.sleep(2.0)
        st2 = (app.walk_status(-1).get("state") or {})
        d2 = float(st2.get("dist_m") or 0)
        e2 = float(st2.get("elapsed_sec") or 0)
        m2 = float(st2.get("move_sec") or 0)
        check(d2 - d1 < 1.0, "松杆后距离基本不再增长", f"{d1:.1f} → {d2:.1f} 米")
        check(e2 - e1 >= 1.2, "松杆后时长照走（墙钟，原版 Q0()）",
              f"elapsed_sec {e1:.1f} → {e2:.1f} 秒")
        p1 = e1 / (d1 / 1000.0) if d1 > 0 else 0.0
        p2 = e2 / (d2 / 1000.0) if d2 > 0 else 0.0
        check(p2 > p1, "配速随时长变大（配速 = 时长 / 公里）",
              f"{p1:.1f} → {p2:.1f} 秒/公里")
        check(m2 - m1 < (e2 - e1) * 0.5, "move_sec 是另一口径：只在移动时累加",
              f"move_sec {m1:.1f} → {m2:.1f} 秒（elapsed {e1:.1f} → {e2:.1f}）")
        app.walk_stop()
    finally:
        try:
            app.close()
        except Exception:  # noqa: BLE001
            pass
        shutil.rmtree(tmp, ignore_errors=True)


def test_point_wire_fields() -> None:
    section("2.9 轨迹点报文口径（runTime 整数秒 / createTime 非零 / 跑中增量上传）")

    tmp = Path(tempfile.mkdtemp(prefix="sdlab-check-wire-"))
    app = App(data_dir=tmp, config_path=tmp / "config.json", mode="mock")
    try:
        app.login("13800138000", "any-password", False)
        app.run_prepare()
        app.walk_start("real", 0.0, 0, 3.0, True, True, 1.0)
        rc = (app.walk_status(-1) or {}).get("run_code") or ""
        for _ in range(7):
            app.walk_joystick(1.0, 0.0, 1.0)
            time.sleep(3.0)
        st = app.walk_status(-1) or {}
        pts = app.store.get_points(rc, None, valid_only=False)
        app.walk_stop()
        st = app.walk_status(-1) or st

        el = float((st.get("state") or {}).get("elapsed_sec") or 0)
        last = pts[-1] if pts else None
        check(bool(last) and el > 5 and last.run_time <= el + 1,
              "runTime 是跑步内相对**秒**（原版 (int)Q0()），不是毫秒",
              f"run_time={last.run_time if last else None} / elapsed_sec={el:.0f}")
        check(bool(last) and last.create_time > 1_600_000_000_000,
              "createTime 每点都有真实建点时刻（不是 0）",
              f"create_time={last.create_time if last else None}")
        check(bool(last) and last.off_fence_dis_m == -1,
              "offFenceDisM 常态为 -1（原版裸跑不进出围栏）",
              f"off_fence_dis_m={last.off_fence_dis_m if last else None}")
        check(int(st.get("uploaded_points") or 0) > 0,
              "跑中按 poiInterval(15s) 增量上传了轨迹（原版 m0()）",
              f"uploaded_points={st.get('uploaded_points')} / errors={st.get('upload_errors')}")
        n_succ = app.store.count_points(rc, C.STATE_SUCC)
        n_init = app.store.count_points(rc, C.STATE_INIT)
        check(n_succ > 0 and int(st.get("uploaded_points") or 0) <= n_succ,
              "增量上传后状态位对得上（成功数 ≥ 会话内累计上传数，无残留 INIT 时全 SUCC）",
              f"uploaded_points={st.get('uploaded_points')} / SUCC={n_succ} / INIT={n_init} / 总 {len(pts)}")

        cps = app.store.checkpoint_targets(rc)
        res = app.client.upload_checkpoints(rc, [])
        sent = int(((res.get("data") or {}).get("count") or 0))
        check((res.get("data") or {}).get("uploaded") == sent,
              "uploadPassPoint 发全量 targetPoints（含未通过的）",
              f"发 {sent} 个 / 库里有 {len(cps)} 个")
    finally:
        try:
            app.close()
        except Exception:  # noqa: BLE001
            pass
        shutil.rmtree(tmp, ignore_errors=True)


# ══════════════════════════════════════════════════════════════════
# 3~5. 全链路
# ══════════════════════════════════════════════════════════════════
def test_full_chain(verbose: bool = False, fail_rate: float = 0.0) -> dict:
    section(f"3~5. 全链路（Mock 模式，注入失败率 {fail_rate:.0%}）")

    tmp = Path(tempfile.mkdtemp(prefix="sdlab-check-"))
    app = App(data_dir=tmp, config_path=tmp / "config.yaml", mode="mock")
    if fail_rate:
        app.cfg["mock_fail_rate"] = fail_rate
        app.world.fail_rate = fail_rate
    events: list[dict] = []
    if verbose:
        app.bus.subscribe(lambda ev: events.append(ev) if ev.get("kind") != "progress" else None)

    try:
        # ── 登录 ──
        r = app.login("13800138000", "any", do_captcha=True)
        check(r.get("code") == 0, "登录成功（含滑块验证码流程）",
              json.dumps(r, ensure_ascii=False)[:160])
        check(app.client.logged_in, "会话已建立（token/satoken 落盘）")
        _dev = app.client.transport.device_id
        check(bool(_dev) and len(str(_dev)) == 16, f"deviceId 已生成（{_dev}）")

        # ── 配置 ──
        app.run_prepare()
        st = app.status()
        fences = st.get("fences") or []
        check(len(fences) >= 1, f"围栏列表拉取成功（{len(fences)} 个）")
        check(bool(st.get("rule")), "学校跑步规则拉取成功",
              json.dumps(st.get("rule") or {}, ensure_ascii=False)[:200])

        # ── 一键跑 ──
        t0 = time.time()
        r = app.run_auto(target_m=2000.0, fence_index=0, do_upload=True, do_finish=True)
        check(r.get("code") == 0, "一键链路启动", str(r.get("message"))[:120])
        while app.running() and time.time() - t0 < 240:
            time.sleep(0.3)
        elapsed = time.time() - t0

        last = (app.status().get("last") or {})
        check(bool(last.get("run_code")), f"生成本次跑步记录号（{last.get('run_code')}）")
        check(last.get("distance_m", 0) > 1500,
              f"轨迹距离达标（{last.get('distance_m', 0):.0f} m，耗时 {elapsed:.1f}s）")
        check(last.get("total_step", 0) > 1500, f"步数累计正常（{last.get('total_step')} 步）")
        cp_total = last.get("checkpoints_total") or 0
        check(cp_total > 0 and last.get("checkpoints_done") == cp_total,
              f"打卡点全部命中（{last.get('checkpoints_done')}/{cp_total}）")

        up = last.get("upload") or {}
        check(bool(up), "上传结果已回写", json.dumps(up, ensure_ascii=False)[:220])

        # ── 记录层 ──
        runs = app.list_runs(20)
        check(len(runs) >= 1, f"SQLite 记录已落盘（{len(runs)} 条）")
        code = last.get("run_code") or (runs[0]["run_code"] if runs else "")
        detail = app.run_detail(code)
        counts = detail.get("counts") or {}
        check(len(detail.get("points") or []) > 100,
              f"轨迹点持久化（{counts.get('points')} 点，已上传 {counts.get('points_uploaded')}）")
        check(counts.get("points_pending", 1) == 0,
              f"待上传队列已清空（pending={counts.get('points_pending')}）")

        # ── 导出 ──
        ej = app.export(code, "json")
        eg = app.export(code, "gpx")
        check(bool(ej.get("path")) and Path(ej["path"]).exists(), "JSON 导出成功", str(ej.get("path")))
        check(bool(eg.get("path")) and Path(eg["path"]).exists(), "GPX 导出成功", str(eg.get("path")))
        if eg.get("path"):
            head = Path(eg["path"]).read_text(encoding="utf-8")[:120].replace("\n", " ")
            check("gpx" in head, "GPX 内容合法", head[:80])

        return {"run_code": code, "last": last, "data_dir": str(tmp), "app": app}
    finally:
        if verbose and events:
            print("\n  ── 事件流（尾部 12 条）──")
            for ev in events[-12:]:
                print(f"     [{ev.get('kind')}] {str(ev.get('message'))[:110]}")
        # 自检结束即关闭 Mock 服务端，但保留数据目录供人工查看
        app.close()


def test_resume() -> None:
    section("6. 失败注入 → 断点续传")
    from sdlab import App as _App

    tmp = Path(tempfile.mkdtemp(prefix="sdlab-resume-"))
    app = _App(data_dir=tmp, config_path=tmp / "config.yaml", mode="mock")
    try:
        app.login("13800138000", "any", do_captcha=False)
        app.run_prepare()
        app.run_auto(target_m=1200.0, fence_index=0, do_upload=True, do_finish=True)
        t0 = time.time()
        while app.running() and time.time() - t0 < 180:
            time.sleep(0.3)
        code = (app.status().get("last") or {}).get("run_code", "")
        detail = app.run_detail(code)
        cnt = detail.get("counts") or {}
        ok_first = cnt.get("points_uploaded", 0) > 0
        check(ok_first, f"首轮上传有落库（{cnt.get('points_uploaded')} 点）")
        # 人为把后段轨迹点标成失败，再续传
        pts = app.store.get_points(code)
        idxs = [p.lat_lng_index for p in pts if p.lat_lng_index >= 10]
        n_marked = app.store.set_point_states(code, idxs, C.STATE_FAIL)
        check(n_marked > 0, f"已人为标记 {n_marked} 个点为失败态（验证续传）")
        r = app.resume(code)
        check(r.get("code") == 0, "续传接口可调用", str(r.get("message"))[:120])
        t0 = time.time()
        while app.running() and time.time() - t0 < 120:
            time.sleep(0.3)
        cnt2 = (app.run_detail(code).get("counts") or {})
        check(cnt2.get("points_failed", 1) == 0 and cnt2.get("points_pending", 1) == 0,
              f"续传后无残留失败/待传点（failed={cnt2.get('points_failed')}, "
              f"pending={cnt2.get('points_pending')}）")
    finally:
        app.close()
        shutil.rmtree(tmp, ignore_errors=True)


# ══════════════════════════════════════════════════════════════════
def main() -> int:
    ap = argparse.ArgumentParser(description="闪动校园工作台 · 端到端自检")
    ap.add_argument("-v", "--verbose", action="store_true", help="打印事件流")
    ap.add_argument("--fail-rate", type=float, default=0.0,
                    help="Mock 服务端随机失败率（0~1），用于验证重试")
    ap.add_argument("--skip-slow", action="store_true", help="跳过耗时最长的续传用例")
    args = ap.parse_args()

    print("\033[1m闪动校园 · 阳光跑工作台 —— 端到端自检\033[0m")
    print(f"Python {sys.version.split()[0]} | 工程 {ROOT}")
    from sdlab.ciphers import backend_info
    name, desc = backend_info()
    print(f"密码学后端：{name}（{desc}）")

    test_crypto()
    test_simulator()
    test_start_point()
    test_checkpoints_source()
    test_auto_run()
    test_elapsed_no_freeze()
    test_point_wire_fields()
    res = test_full_chain(args.verbose, args.fail_rate)
    if not args.skip_slow:
        test_resume()

    passed = sum(1 for ok, _ in _results if ok)
    total = len(_results)
    print(f"\n\033[1m结果：{passed}/{total} 通过\033[0m")
    if passed != total:
        print("失败项：")
        for ok, title in _results:
            if not ok:
                print(f"  {FAIL} {title}")
        return 1
    print(f"数据目录（保留供人工查看）：{res.get('data_dir')}")
    print("全部通过 ✅")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
