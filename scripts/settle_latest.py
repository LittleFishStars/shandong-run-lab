#!/usr/bin/env python3
"""把「跑完但没结算」的阳光跑补算聚合值并结算（默认取最近一条未结算的）。

背景：实跑正常收尾时 `WalkSession._persist_run_summary()` 才会把距离/时长/步数/
有效性写回 runs 表；若 App 在跑步中途被关掉，点都在库里，但 runs 的
distance/duration/total_step/status 全是 0，直接续传会把「0 米 / 0 秒」结算上去，
服务端必然判无效。

所以这里先按 walk 同一套口径补算：
  duration   = 最后一个点的 run_time（整秒）
  distance   = 相邻点 haversine 累加（evaluate_run 内部同法）
  total_step = 步频段 step 求和
  status/valid = protocol.evaluate_run(...)
再走 client.resume_run()：补传 pending 点/步频/配速/打卡 → finishSunRun_v2。

用法：
  python3 scripts/settle_latest.py                # 只算不发（dry run）
  python3 scripts/settle_latest.py --send         # 真发
  python3 scripts/settle_latest.py --send --sync  # 真发，并把结算后的库写回用户目录
  python3 scripts/settle_latest.py 26102213270278768 --send   # 指定记录

脚本在 tmp/settle-work/ 下用用户库的**副本**工作，不动原库；
--sync 才会把副本覆盖回 ~/.local/share/shandong-school_cracked/records.db。
"""
from __future__ import annotations

import os
import shutil
import sys
import time
from pathlib import Path

ROOT = Path(__file__).resolve().parents[1]
RUNLAB = ROOT / "projects" / "desktop"
WORK = ROOT / "tmp" / "settle-work"
USER_DATA = Path.home() / ".local" / "share" / "shandong-school_cracked" / "records.db"
USER_CFG = Path.home() / ".config" / "shandong-school_cracked" / "config.json"

sys.path.insert(0, str(RUNLAB))

from shandong_school_cracked.app import App                    # noqa: E402
from shandong_school_cracked import protocol                   # noqa: E402
from shandong_school_cracked.constants import SPORT_TYPE_SUN   # noqa: E402


def prepare_workspace() -> None:
    """把用户库与配置复制进工作区（原库只在这里读，脚本只写副本）"""
    WORK.mkdir(parents=True, exist_ok=True)
    if not USER_DATA.exists():
        raise SystemExit(f"找不到本地库：{USER_DATA}")
    shutil.copy2(USER_DATA, WORK / "records.db")
    if USER_CFG.exists():
        shutil.copy2(USER_CFG, WORK / "config.json")


def main() -> int:
    send = "--send" in sys.argv
    sync = "--sync" in sys.argv
    code = next((a for a in sys.argv[1:] if not a.startswith("-")), "")

    prepare_workspace()
    app = App(data_dir=str(WORK), config_path=str(WORK / "config.json"), mode="real")
    try:
        for _ in range(50):                       # client 构造时已从 kv 读 token
            if app.client.logged_in:
                break
            time.sleep(0.1)
        if not app.client.logged_in:
            print("✗ 本地没有可用登录态")
            return 1

        if not code:
            pend = app.store.unfinished_runs()
            if not pend:
                print("没有未结算的记录")
                return 0
            code = str(pend[0]["run_code"])
        run = app.store.get_run(code)
        if not run:
            print(f"✗ 库里没有 {code}")
            return 1

        pts = app.store.get_points(code, None)              # 全量点（含已上传）
        steps = app.store.get_steps(code, only_pending=False)
        if not pts:
            print("✗ 没有轨迹点，无法补算")
            return 1
        duration = int(pts[-1].run_time)                    # 整秒截断，与 walk 一致
        total_step = sum(int(s.step) for s in steps)
        cps = app.store.get_checkpoints(code)
        done = sum(1 for c in cps if int(c.get("passed") or 0) == 1)

        # 有未完成跑步时 checkSunRunConfig 会回 2070，改走 abstract 接口拿同一套规则
        app.client.fence = {"fenceCode": run.get("fence_code", ""),
                            "schoolCode": run.get("school_code", ""),
                            "fenceName": run.get("fence_name", "")}
        rule_res = app.client.load_sunrun_rule()
        if int(rule_res.get("code", -1)) != 0:
            rule_res = app.client.load_rule(fence_code=run.get("fence_code", ""),
                                            run_plan_code=run.get("run_plan_code", "") or "")
        r = app.client.rule
        print(f"规则拉取：code={rule_res.get('code')} {rule_res.get('message')}  "
              f"单次 {r.single_min_distance:.0f}-{r.single_max_distance:.0f} m，"
              f"配速 {r.min_pace:.0f}-{r.max_pace:.0f} s/km，必经点 {r.required_point_counts}")

        validity = protocol.evaluate_run(
            pts, duration, total_step, app.client.rule,
            checkpoints_total=len(cps), checkpoints_done=done,
            sport_type=int(run.get("sport_type") or SPORT_TYPE_SUN),
            cheat_level=int(run.get("cheat_level") or 0),
            white_flag=bool(run.get("white_flag") or 0),
            gps_white_flag=bool(getattr(app.client.rule, "gps_white_flag", False)))
        vd = validity.to_dict()
        pace = duration / (validity.distance_m / 1000.0) if validity.distance_m > 0 else 0.0

        started = time.strftime("%F %T", time.localtime(int(run["start_ms"]) / 1000))
        print(f"记录 {code}  围栏={run.get('fence_name')}  开始={started}")
        print(f"  点数 {len(pts)}（待传 {sum(1 for p in pts if p.state in (1, 4))}）"
              f"  步频段 {len(steps)}  打卡 {done}/{len(cps)}")
        print(f"  时长 {duration} s   距离 {validity.distance_m:.2f} m   步数 {total_step}"
              f"   配速 {pace:.1f} s/km"
              f"   步幅 {(validity.distance_m / total_step if total_step else 0):.3f} m")
        print(f"  有效性 {'通过' if validity.is_valid else '不通过'}  status={validity.status}"
              f"  原因={[x['name'] for x in vd.get('reasons', [])]}")

        if not send:
            print("\n（dry run，没写库也没发请求；加 --send 才真正结算）")
            return 0

        # 1) 先把聚合值写回 runs（否则 finish_run 会拿 0 去结算）
        app.store.finish_run(
            code, end_ms=int(run["start_ms"]) + duration * 1000,
            duration_s=duration, distance_m=round(validity.distance_m, 2),
            total_step=total_step, pace_s_per_km=round(pace, 2),
            status=int(validity.status), valid=vd, source="resume")

        # 2) 补传 + 结算
        out = app.client.resume_run(code)
        finish = (app.store.get_run(code) or {}).get("finish") or {}
        resp = (finish.get("response") if isinstance(finish, dict) else None) or {}
        data = resp.get("data") or {}
        print(f"\n结算返回：code={resp.get('code')} {resp.get('message')}")
        for k in ("status", "validDistance", "pace", "energyValue", "creditBookTotal", "recheckStatus"):
            if k in data:
                print(f"  {k} = {data[k]}")
        print(f"  上传：points={(out.get('points') or {}).get('code')} "
              f"checkpoints={(out.get('checkpoints') or {}).get('code')}")

        if sync:
            shutil.copy2(WORK / "records.db", USER_DATA)
            print(f"\n已写回用户库：{USER_DATA}")
        else:
            print(f"\n结算结果只写在工作副本：{WORK / 'records.db'}"
                  f"\n要写回用户库，加 --sync（或手动 cp）")
        return 0 if resp.get("code") == 0 else 1
    finally:
        app.close()


if __name__ == "__main__":
    raise SystemExit(main())
