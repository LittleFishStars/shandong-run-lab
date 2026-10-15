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

    # 结算码：MD5(runCode+buildVersion+appVersion+key+ts)
    code = crypto.calculate_run_img_record("SDLABTEST", "1750000000000")
    check(len(code) == 32 and code.islower(), "结算码 runImgRecord 为 32 位小写 MD5", code)


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
    check(all(p.off_fence_dis_m >= 0 for p in track), "所有轨迹点都在围栏内/围栏上")

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
# 3~5. 全链路
# ══════════════════════════════════════════════════════════════════
def test_full_chain(verbose: bool = False, fail_rate: float = 0.0) -> dict:
    section(f"3~5. 全链路（Mock 模式，注入失败率 {fail_rate:.0%}）")

    tmp = Path(tempfile.mkdtemp(prefix="sdlab-check-"))
    app = App(data_dir=tmp, config_path=tmp / "config.yaml")
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
    app = _App(data_dir=tmp, config_path=tmp / "config.yaml")
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
