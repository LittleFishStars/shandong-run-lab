#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""本地数据记录层：SQLite 持久化 + 断点续传状态机

对齐客户端 Room v7 的三张表语义（run_lat_lng / run_step / run_pace）与
上传状态位 INIT=1 / UPLOADING=2 / FAIL=4 / SUCC=8，
并额外记录跑步会话与上传日志，便于 GUI 展示与离线调试。
"""
from __future__ import annotations

import contextlib
import json
import sqlite3
import threading
import time
from pathlib import Path
from typing import Any, Dict, Iterable, Iterator, List, Optional, Sequence, Tuple

from .constants import (
    CHECKPOINT_HIT_RADIUS_M,
    SPORT_TYPE_SUN,
    STATE_FAIL,
    STATE_INIT,
    STATE_SUCC,
    STATE_UPLOADING,
)
from .protocol import IntervalPace, IntervalStep, RunLatLng, StrideSegment


SCHEMA = """
PRAGMA journal_mode=WAL;

CREATE TABLE IF NOT EXISTS runs (
    run_code     TEXT PRIMARY KEY,
    sport_type   INTEGER NOT NULL DEFAULT 1,
    fence_code   TEXT DEFAULT '',
    fence_name   TEXT DEFAULT '',
    school_code  TEXT DEFAULT '',
    semester_code TEXT DEFAULT '',
    run_plan_code TEXT DEFAULT '',
    start_ms     INTEGER DEFAULT 0,
    end_ms       INTEGER DEFAULT 0,
    duration_s   INTEGER DEFAULT 0,
    distance_m   REAL DEFAULT 0,
    total_step   INTEGER DEFAULT 0,
    pace_s_per_km REAL DEFAULT 0,
    status       INTEGER DEFAULT 0,      -- 1 有效 / 0 无效
    valid_json   TEXT DEFAULT '{}',      -- 有效性判定明细
    rule_json    TEXT DEFAULT '{}',      -- 本次使用的 SchoolRule 子集
    finish_json  TEXT DEFAULT '{}',      -- 结算报文
    uploaded     INTEGER DEFAULT 0,      -- 是否已完成结算上传
    source       TEXT DEFAULT 'sim',     -- sim 仿真 / walk 实走 / real 真实
    clock_mode   INTEGER DEFAULT 0,      -- 开跑返回的 clockMode（2/3=顺序打卡）
    white_flag   INTEGER DEFAULT 0,      -- 开跑返回的 whiteFlag（GPS 白名单）
    cheat_level  INTEGER DEFAULT 0,      -- 开跑返回的 cheatLevel（3/4 影响步频异常）
    pause_count  INTEGER DEFAULT 0,      -- 暂停次数（结算 pauseCount）
    pause_times_s INTEGER DEFAULT 0,     -- 暂停总秒数（结算 pauseTimes）
    created_at   INTEGER DEFAULT 0
);

CREATE TABLE IF NOT EXISTS points (
    id           INTEGER PRIMARY KEY AUTOINCREMENT,
    run_code     TEXT NOT NULL,
    idx          INTEGER NOT NULL,
    lat          REAL NOT NULL,
    lng          REAL NOT NULL,
    run_time     INTEGER DEFAULT 0,
    collect_time INTEGER DEFAULT 0,
    state        INTEGER DEFAULT 1,
    off_fence_dis_m INTEGER DEFAULT 0,
    accuracy     REAL DEFAULT 0,
    speed        REAL DEFAULT 0,
    satellites   INTEGER DEFAULT 0,
    is_valid     INTEGER DEFAULT 1,      -- 过 H0 闸门才为 1；被拒点也落库但为 0
    is_uploaded  INTEGER DEFAULT 0,
    create_time  INTEGER DEFAULT 0,
    UNIQUE(run_code, idx)
);
CREATE INDEX IF NOT EXISTS idx_points_run ON points(run_code, state);
CREATE INDEX IF NOT EXISTS idx_points_valid ON points(run_code, is_valid);

CREATE TABLE IF NOT EXISTS steps (
    id           INTEGER PRIMARY KEY AUTOINCREMENT,
    run_code     TEXT NOT NULL,
    idx          INTEGER NOT NULL,
    start_step   INTEGER DEFAULT 0,
    end_step     INTEGER DEFAULT 0,
    start_time   INTEGER DEFAULT 0,
    end_time     INTEGER DEFAULT 0,
    step         INTEGER DEFAULT 0,
    time_ms      INTEGER DEFAULT 0,
    is_uploaded  INTEGER DEFAULT 0,
    UNIQUE(run_code, idx)
);

CREATE TABLE IF NOT EXISTS paces (
    id           INTEGER PRIMARY KEY AUTOINCREMENT,
    run_code     TEXT NOT NULL,
    idx          INTEGER NOT NULL,
    distance     INTEGER DEFAULT 0,
    start_distance INTEGER DEFAULT 0,
    end_distance INTEGER DEFAULT 0,
    step_count   INTEGER DEFAULT 0,
    start_step_count INTEGER DEFAULT 0,
    end_step_count   INTEGER DEFAULT 0,
    time_ms      INTEGER DEFAULT 0,
    start_time   INTEGER DEFAULT 0,
    end_time     INTEGER DEFAULT 0,
    is_uploaded  INTEGER DEFAULT 0,
    UNIQUE(run_code, idx)
);

CREATE TABLE IF NOT EXISTS strides (
    id           INTEGER PRIMARY KEY AUTOINCREMENT,
    run_code     TEXT NOT NULL,
    idx          INTEGER NOT NULL,
    time_s       INTEGER DEFAULT 0,
    stride_cm    REAL DEFAULT 0,
    distance_m   INTEGER DEFAULT 0,
    step_count   INTEGER DEFAULT 0,
    is_uploaded  INTEGER DEFAULT 0,
    UNIQUE(run_code, idx)
);

CREATE TABLE IF NOT EXISTS checkpoints (
    id           INTEGER PRIMARY KEY AUTOINCREMENT,
    run_code     TEXT NOT NULL,
    idx          INTEGER NOT NULL,
    lat          REAL NOT NULL,
    lng          REAL NOT NULL,
    radius_m     REAL DEFAULT 25.0,
    hit_ms       INTEGER DEFAULT 0,
    hit_lat      REAL DEFAULT 0,
    hit_lng      REAL DEFAULT 0,
    passed       INTEGER DEFAULT 0,
    code         INTEGER DEFAULT 0,      -- 服务端下发的点位 code（上传必须原值）
    sort         INTEGER DEFAULT 0,      -- 服务端排序（顺序打卡用）
    nfc          INTEGER DEFAULT 0,      -- nfcEnable
    type         INTEGER DEFAULT 0,      -- 点位 type
    UNIQUE(run_code, idx)
);

CREATE TABLE IF NOT EXISTS upload_log (
    id           INTEGER PRIMARY KEY AUTOINCREMENT,
    run_code     TEXT DEFAULT '',
    endpoint     TEXT DEFAULT '',
    ok           INTEGER DEFAULT 0,
    message      TEXT DEFAULT '',
    payload_json TEXT DEFAULT '',
    response_json TEXT DEFAULT '',
    ts           INTEGER DEFAULT 0
);

CREATE TABLE IF NOT EXISTS api_log (
    id           INTEGER PRIMARY KEY AUTOINCREMENT,
    method       TEXT DEFAULT 'POST',
    path         TEXT DEFAULT '',
    v            TEXT DEFAULT '',
    api          TEXT DEFAULT '',
    signed       INTEGER DEFAULT 0,
    body         TEXT DEFAULT '',
    response     TEXT DEFAULT '',
    code         INTEGER DEFAULT -1,
    elapsed_ms   INTEGER DEFAULT 0,
    ts           INTEGER DEFAULT 0
);

CREATE TABLE IF NOT EXISTS kv (
    k TEXT PRIMARY KEY,
    v TEXT DEFAULT ''
);
"""


class RecordStore:
    """SQLite 记录库（单文件，线程安全：每次操作独立连接）"""

    def __init__(self, path: Path):
        self.path = Path(path)
        self.path.parent.mkdir(parents=True, exist_ok=True)
        self._lock = threading.Lock()
        with self._connect() as con:
            con.executescript(SCHEMA)

    @contextlib.contextmanager
    def _connect(self) -> Iterator[sqlite3.Connection]:
        """开一个短连接：退出时自动提交/回滚并close（避免 ResourceWarning 泄漏）

        调用处写法不变（`with self._connect() as con:`）：with 进入即 transaction 开始，
        正常退出提交、异常退出回滚，最后无论成败都关闭连接。
        """
        con = sqlite3.connect(str(self.path), timeout=15.0)
        con.row_factory = sqlite3.Row
        _ensure_columns(con)
        try:
            with con:                       # 事务边界
                yield con
        finally:
            con.close()

    # ══════════════════ 会话键值 ══════════════════
    def kv_get(self, key: str, default: Any = None) -> Any:
        with self._lock, self._connect() as con:
            row = con.execute("SELECT v FROM kv WHERE k=?", (key,)).fetchone()
        if not row:
            return default
        try:
            return json.loads(row["v"])
        except Exception:
            return row["v"]

    def kv_set(self, key: str, value: Any) -> None:
        with self._lock, self._connect() as con:
            con.execute("INSERT INTO kv(k,v) VALUES(?,?) ON CONFLICT(k) DO UPDATE SET v=excluded.v",
                        (key, json.dumps(value, ensure_ascii=False)))
            con.commit()

    def kv_delete(self, key: str) -> None:
        with self._lock, self._connect() as con:
            con.execute("DELETE FROM kv WHERE k=?", (key,))
            con.commit()

    # ══════════════════ 跑步会话 ══════════════════
    def create_run(self, run_code: str, sport_type: int = SPORT_TYPE_SUN, **kw: Any) -> None:
        with self._lock, self._connect() as con:
            con.execute(
                """INSERT INTO runs(run_code, sport_type, fence_code, fence_name, school_code,
                                    semester_code, run_plan_code, start_ms, created_at, source,
                                    clock_mode, white_flag, cheat_level)
                   VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)
                   ON CONFLICT(run_code) DO UPDATE SET start_ms=excluded.start_ms""",
                (run_code, sport_type, kw.get("fence_code", ""), kw.get("fence_name", ""),
                 kw.get("school_code", ""), kw.get("semester_code", ""),
                 kw.get("run_plan_code", ""), int(kw.get("start_ms", time.time() * 1000)),
                 int(time.time() * 1000), kw.get("source", "sim"),
                 int(kw.get("clock_mode", 0) or 0), int(kw.get("white_flag", 0) or 0),
                 int(kw.get("cheat_level", 0) or 0)))
            con.commit()

    def finish_run(self, run_code: str, **kw: Any) -> None:
        fields, values = [], []
        mapping = {
            "end_ms": "end_ms", "duration_s": "duration_s", "distance_m": "distance_m",
            "total_step": "total_step", "pace_s_per_km": "pace_s_per_km",
            "status": "status", "uploaded": "uploaded", "source": "source",
            "pause_count": "pause_count", "pause_times_s": "pause_times_s",
        }
        for key, col in mapping.items():
            if key in kw:
                fields.append(f"{col}=?")
                values.append(kw[key])
        if "valid" in kw:
            fields.append("valid_json=?")
            values.append(json.dumps(kw["valid"], ensure_ascii=False))
        if "rule" in kw:
            fields.append("rule_json=?")
            values.append(json.dumps(kw["rule"], ensure_ascii=False))
        if "finish" in kw:
            fields.append("finish_json=?")
            values.append(json.dumps(kw["finish"], ensure_ascii=False))
        if not fields:
            return
        with self._lock, self._connect() as con:
            con.execute(f"UPDATE runs SET {', '.join(fields)} WHERE run_code=?", (*values, run_code))
            con.commit()

    def mark_uploaded(self, run_code: str, uploaded: bool = True) -> None:
        with self._lock, self._connect() as con:
            con.execute("UPDATE runs SET uploaded=? WHERE run_code=?",
                        (1 if uploaded else 0, run_code))
            con.commit()

    def get_run(self, run_code: str) -> Optional[Dict[str, Any]]:
        with self._lock, self._connect() as con:
            row = con.execute("SELECT * FROM runs WHERE run_code=?", (run_code,)).fetchone()
        return _row_to_run(row) if row else None

    def list_runs(self, limit: int = 100, sport_type: Optional[int] = None
                  ) -> List[Dict[str, Any]]:
        sql = "SELECT * FROM runs"
        params: List[Any] = []
        if sport_type is not None:
            sql += " WHERE sport_type=?"
            params.append(sport_type)
        sql += " ORDER BY created_at DESC LIMIT ?"
        params.append(limit)
        with self._lock, self._connect() as con:
            rows = con.execute(sql, params).fetchall()
        return [_row_to_run(r) for r in rows]

    def delete_run(self, run_code: str) -> None:
        with self._lock, self._connect() as con:
            for table in ("points", "steps", "paces", "checkpoints", "upload_log"):
                con.execute(f"DELETE FROM {table} WHERE run_code=?", (run_code,))
            con.execute("DELETE FROM runs WHERE run_code=?", (run_code,))
            con.commit()

    def unfinished_runs(self) -> List[Dict[str, Any]]:
        """未完成结算的跑步（断点续传候选）"""
        with self._lock, self._connect() as con:
            rows = con.execute(
                "SELECT * FROM runs WHERE uploaded=0 ORDER BY created_at DESC").fetchall()
        return [_row_to_run(r) for r in rows]

    # ══════════════════ 轨迹点 ══════════════════
    def add_points(self, run_code: str, pts: Sequence[RunLatLng]) -> int:
        if not pts:
            return 0
        now = int(time.time() * 1000)
        rows = [(run_code, p.lat_lng_index, p.lat, p.lng, p.run_time, p.collect_time,
                 p.state, p.off_fence_dis_m, p.accuracy, p.speed, p.satellites,
                 1 if p.is_valid else 0, 1 if p.is_uploaded else 0,
                 p.create_time or now)
                for p in pts]
        with self._lock, self._connect() as con:
            con.executemany(
                """INSERT INTO points(run_code,idx,lat,lng,run_time,collect_time,state,
                                      off_fence_dis_m,accuracy,speed,satellites,
                                      is_valid,is_uploaded,create_time)
                   VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?)
                   ON CONFLICT(run_code,idx) DO UPDATE SET
                     lat=excluded.lat, lng=excluded.lng, run_time=excluded.run_time,
                     collect_time=excluded.collect_time, state=excluded.state,
                     off_fence_dis_m=excluded.off_fence_dis_m, accuracy=excluded.accuracy,
                     speed=excluded.speed, satellites=excluded.satellites,
                     is_valid=excluded.is_valid""", rows)
            con.commit()
        return len(rows)

    def get_points(self, run_code: str,
                   states: Optional[Iterable[int]] = None,
                   valid_only: bool = False) -> List[RunLatLng]:
        sql = "SELECT * FROM points WHERE run_code=?"
        params: List[Any] = [run_code]
        if states is not None:
            state_list = list(states)
            sql += f" AND state IN ({','.join('?' * len(state_list))})"
            params.extend(state_list)
        if valid_only:
            sql += " AND is_valid=1"
        sql += " ORDER BY idx"
        with self._lock, self._connect() as con:
            rows = con.execute(sql, params).fetchall()
        return [_row_to_point(r, run_code) for r in rows]

    def set_point_states(self, run_code: str, indices: Sequence[int], state: int) -> int:
        if not indices:
            return 0
        with self._lock, self._connect() as con:
            q = f"UPDATE points SET state=? WHERE run_code=? AND idx IN ({','.join('?' * len(indices))})"
            cur = con.execute(q, (state, run_code, *indices))
            con.commit()
        return cur.rowcount

    def count_points(self, run_code: str, state: Optional[int] = None) -> int:
        sql = "SELECT COUNT(*) c FROM points WHERE run_code=?"
        params: List[Any] = [run_code]
        if state is not None:
            sql += " AND state=?"
            params.append(state)
        with self._lock, self._connect() as con:
            return int(con.execute(sql, params).fetchone()["c"])

    def next_point_index(self, run_code: str) -> int:
        with self._lock, self._connect() as con:
            row = con.execute("SELECT MAX(idx) m FROM points WHERE run_code=?",
                              (run_code,)).fetchone()
        return int(row["m"]) + 1 if row and row["m"] is not None else 0

    # ══════════════════ 步频段 ══════════════════
    def add_steps(self, run_code: str, steps: Sequence[IntervalStep]) -> int:
        if not steps:
            return 0
        rows = [(run_code, s.step_index, s.start_step, s.end_step, s.start_time, s.end_time,
                 s.step, s.time, 1 if s.is_uploaded else 0) for s in steps]
        with self._lock, self._connect() as con:
            con.executemany(
                """INSERT INTO steps(run_code,idx,start_step,end_step,start_time,end_time,step,time_ms,is_uploaded)
                   VALUES(?,?,?,?,?,?,?,?,?)
                   ON CONFLICT(run_code,idx) DO UPDATE SET
                     start_step=excluded.start_step, end_step=excluded.end_step,
                     step=excluded.step, time_ms=excluded.time_ms""", rows)
            con.commit()
        return len(rows)

    def get_steps(self, run_code: str, only_pending: bool = True) -> List[IntervalStep]:
        sql = "SELECT * FROM steps WHERE run_code=?"
        if only_pending:
            sql += " AND is_uploaded=0"
        sql += " ORDER BY idx"
        with self._lock, self._connect() as con:
            rows = con.execute(sql, (run_code,)).fetchall()
        return [IntervalStep.from_dict({
            "index": r["idx"], "startStep": r["start_step"], "endStep": r["end_step"],
            "startTime": r["start_time"], "endTime": r["end_time"],
            "step": r["step"], "time": r["time_ms"],
            "isUploaded": bool(r["is_uploaded"]),
        }, run_code) for r in rows]

    def mark_steps_uploaded(self, run_code: str) -> None:
        with self._lock, self._connect() as con:
            con.execute("UPDATE steps SET is_uploaded=1 WHERE run_code=?", (run_code,))
            con.commit()

    # ══════════════════ 配速段 ══════════════════
    def add_paces(self, run_code: str, paces: Sequence[IntervalPace]) -> int:
        if not paces:
            return 0
        rows = [(run_code, p.pace_index, p.distance, p.start_distance, p.end_distance,
                 p.step_count, p.start_step_count, p.end_step_count, p.time,
                 p.start_time, p.end_time, 1 if p.is_uploaded else 0) for p in paces]
        with self._lock, self._connect() as con:
            con.executemany(
                """INSERT INTO paces(run_code,idx,distance,start_distance,end_distance,
                        step_count,start_step_count,end_step_count,time_ms,start_time,end_time,is_uploaded)
                   VALUES(?,?,?,?,?,?,?,?,?,?,?,?)
                   ON CONFLICT(run_code,idx) DO UPDATE SET
                     distance=excluded.distance, start_distance=excluded.start_distance,
                     end_distance=excluded.end_distance, step_count=excluded.step_count,
                     time_ms=excluded.time_ms""", rows)
            con.commit()
        return len(rows)

    def get_paces(self, run_code: str, only_pending: bool = True) -> List[IntervalPace]:
        sql = "SELECT * FROM paces WHERE run_code=?"
        if only_pending:
            sql += " AND is_uploaded=0"
        sql += " ORDER BY idx"
        with self._lock, self._connect() as con:
            rows = con.execute(sql, (run_code,)).fetchall()
        return [IntervalPace.from_dict({
            "index": r["idx"], "distance": r["distance"], "startDistance": r["start_distance"],
            "endDistance": r["end_distance"], "stepCount": r["step_count"],
            "startStepCount": r["start_step_count"], "endStepCount": r["end_step_count"],
            "time": r["time_ms"], "startTime": r["start_time"], "endTime": r["end_time"],
            "isUploaded": bool(r["is_uploaded"]),
        }, run_code) for r in rows]

    def mark_paces_uploaded(self, run_code: str) -> None:
        with self._lock, self._connect() as con:
            con.execute("UPDATE paces SET is_uploaded=1 WHERE run_code=?", (run_code,))
            con.commit()

    # ── 步幅段（原版无表，本项目额外落库以便重放/导出）──
    def add_strides(self, run_code: str, strides: Sequence["StrideSegment"]) -> int:
        if not strides:
            return 0
        with self._lock, self._connect() as con:
            for s in strides:
                con.execute(
                    "INSERT INTO strides(run_code, idx, time_s, stride_cm, distance_m,"
                    " step_count, is_uploaded) VALUES(?,?,?,?,?,?,?)"
                    " ON CONFLICT(run_code, idx) DO UPDATE SET time_s=excluded.time_s,"
                    " stride_cm=excluded.stride_cm, distance_m=excluded.distance_m,"
                    " step_count=excluded.step_count",
                    (run_code, int(s.stride_index), int(s.time_s), float(s.stride_cm),
                     int(s.distance_m), int(s.step_count), 1 if s.is_uploaded else 0))
            con.commit()
        return len(strides)

    def get_strides(self, run_code: str,
                    only_pending: bool = True) -> List["StrideSegment"]:
        sql = "SELECT * FROM strides WHERE run_code=?"
        if only_pending:
            sql += " AND is_uploaded=0"
        sql += " ORDER BY idx"
        with self._lock, self._connect() as con:
            rows = con.execute(sql, (run_code,)).fetchall()
        return [StrideSegment.from_dict({
            "index": r["idx"], "time": r["time_s"], "stride": r["stride_cm"],
            "distance": r["distance_m"], "stepCount": r["step_count"],
            "isUploaded": bool(r["is_uploaded"]),
        }, run_code) for r in rows]

    def mark_stride_uploaded(self, run_code: str, idx: int) -> None:
        with self._lock, self._connect() as con:
            con.execute("UPDATE strides SET is_uploaded=1 WHERE run_code=? AND idx=?",
                        (run_code, int(idx)))
            con.commit()

    # ══════════════════ 打卡点 ══════════════════
    def add_checkpoints(self, run_code: str, points: Sequence[Dict[str, Any]]) -> int:
        if not points:
            return 0
        rows = [(run_code, i, float(p["lat"]), float(p["lng"]),
                 float(p.get("radius_m") or CHECKPOINT_HIT_RADIUS_M),
                 int(p.get("code") or 0),
                 int(p.get("sort") if p.get("sort") is not None else i),
                 int(1 if (p.get("nfcEnable") or p.get("nfc")) else 0),
                 int(p.get("type") or 0))
                for i, p in enumerate(points)]
        with self._lock, self._connect() as con:
            con.executemany(
                "INSERT OR IGNORE INTO checkpoints(run_code,idx,lat,lng,radius_m,code,sort,nfc,type) "
                "VALUES(?,?,?,?,?,?,?,?,?)",
                rows)
            con.commit()
        return len(rows)

    def get_checkpoints(self, run_code: str) -> List[Dict[str, Any]]:
        with self._lock, self._connect() as con:
            rows = con.execute("SELECT * FROM checkpoints WHERE run_code=? ORDER BY idx",
                               (run_code,)).fetchall()
        # 统一对外字段名：数据库列是 idx，业务代码统一用 index
        out: List[Dict[str, Any]] = []
        for r in rows:
            d = dict(r)
            d["index"] = int(d.get("idx", 0) or 0)
            out.append(d)
        return out

    def mark_checkpoint_hit(self, run_code: str, idx: int, lat: float, lng: float,
                            hit_ms: int) -> None:
        with self._lock, self._connect() as con:
            con.execute(
                """UPDATE checkpoints SET passed=1, hit_ms=?, hit_lat=?, hit_lng=?
                   WHERE run_code=? AND idx=? AND passed=0""",
                (hit_ms, lat, lng, run_code, idx))
            con.commit()

    def checkpoints_progress(self, run_code: str) -> Tuple[int, int]:
        with self._lock, self._connect() as con:
            row = con.execute(
                "SELECT COUNT(*) total, SUM(passed) done FROM checkpoints WHERE run_code=?",
                (run_code,)).fetchone()
        return int(row["done"] or 0), int(row["total"] or 0)

    def checkpoint_targets(self, run_code: str) -> List[Dict[str, Any]]:
        """构造结算/打卡用的 targetPoints

        原版 `StartRunEntity.getTargetPoints()` 的字段与序列化名：
            code(long) lat(double) lng(double) passStatus(bool)
            clockTime(long) sort(int) nfcEnable(bool)
        其余（pointName/simpleName/type/isClosingStatus/isInFence/
        isSensitiveFenceAdded）都标了 @JSONField(serialize=false)，不上传。
        """
        out: List[Dict[str, Any]] = []
        for i, c in enumerate(self.get_checkpoints(run_code)):
            passed = int(c.get("passed") or 0) == 1
            out.append({
                "code": int(c.get("code") or 0),
                # 坐标必须用服务端下发的桩点：原版 targetPoints 从开跑响应
                # 反序列化后只改 passStatus/clockTime，lat/lng 永不改写。
                # 换成打卡位置会让服务端按 (code, lat, lng) 匹配不到桩点。
                "lat": round(float(c.get("lat") or 0.0), 6),
                "lng": round(float(c.get("lng") or 0.0), 6),
                "passStatus": bool(passed),
                "clockTime": int(c.get("hit_ms") or 0),
                "sort": int(c.get("sort") if c.get("sort") is not None else i),
                "nfcEnable": bool(int(c.get("nfc") or 0)),
            })
        return out

    def invalid_reasons(self, run_code: str) -> List[Dict[str, Any]]:
        """原版 t1() 的 invalidReasons: [{invalidType, invalidDetail}]

        本地校验只给得出类型码（与 constants 的无效码表一致），细节留空。
        """
        run = self.get_run(run_code) or {}
        valid = run.get("valid") or {}
        codes = valid.get("invalidCodes") or valid.get("codes") or []
        if isinstance(codes, int):
            codes = [codes]
        out: List[Dict[str, Any]] = []
        for c in codes or []:
            try:
                out.append({"invalidType": int(c), "invalidDetail": ""})
            except (TypeError, ValueError):
                continue
        return out

    def mark_strides_uploaded(self, run_code: str) -> int:
        with self._lock, self._connect() as con:
            cur = con.execute("UPDATE strides SET is_uploaded=1 WHERE run_code=?",
                              (run_code,))
            con.commit()
            return int(cur.rowcount or 0)

    # ══════════════════ 上传 / 接口日志 ══════════════════
    def log_upload(self, run_code: str, endpoint: str, ok: bool, message: str = "",
                   payload: Any = None, response: Any = None) -> None:
        with self._lock, self._connect() as con:
            con.execute(
                """INSERT INTO upload_log(run_code,endpoint,ok,message,payload_json,response_json,ts)
                   VALUES(?,?,?,?,?,?,?)""",
                (run_code, endpoint, 1 if ok else 0, message[:500],
                 _safe_json(payload)[:20000], _safe_json(response)[:20000],
                 int(time.time() * 1000)))
            con.commit()

    def get_upload_log(self, run_code: str = "", limit: int = 200) -> List[Dict[str, Any]]:
        sql = "SELECT * FROM upload_log"
        params: List[Any] = []
        if run_code:
            sql += " WHERE run_code=?"
            params.append(run_code)
        sql += " ORDER BY id DESC LIMIT ?"
        params.append(limit)
        with self._lock, self._connect() as con:
            rows = con.execute(sql, params).fetchall()
        return [dict(r) for r in rows]

    def log_api(self, method: str, path: str, v: str, api: str, signed: bool,
                body: str, response: str, code: int, elapsed_ms: int) -> None:
        with self._lock, self._connect() as con:
            con.execute(
                """INSERT INTO api_log(method,path,v,api,signed,body,response,code,elapsed_ms,ts)
                   VALUES(?,?,?,?,?,?,?,?,?,?)""",
                (method, path, v, api, 1 if signed else 0, body[:20000], response[:20000],
                 code, elapsed_ms, int(time.time() * 1000)))
            con.commit()

    def get_api_log(self, limit: int = 200) -> List[Dict[str, Any]]:
        with self._lock, self._connect() as con:
            rows = con.execute("SELECT * FROM api_log ORDER BY id DESC LIMIT ?",
                               (limit,)).fetchall()
        return [dict(r) for r in rows]

    def stats(self) -> Dict[str, Any]:
        with self._lock, self._connect() as con:
            r = con.execute(
                """SELECT COUNT(*) runs,
                          COALESCE(SUM(distance_m),0) dist,
                          COALESCE(SUM(duration_s),0) dur,
                          COALESCE(SUM(total_step),0) steps,
                          SUM(CASE WHEN status=1 THEN 1 ELSE 0 END) valid
                   FROM runs""").fetchone()
        return {
            "runs": int(r["runs"] or 0),
            "distance_m": round(float(r["dist"] or 0), 1),
            "duration_s": int(r["dur"] or 0),
            "total_step": int(r["steps"] or 0),
            "valid_runs": int(r["valid"] or 0),
        }


# ══════════════════ 行转换 ══════════════════
def _row_to_run(row: sqlite3.Row) -> Dict[str, Any]:
    d = dict(row)
    for k in ("valid_json", "rule_json", "finish_json"):
        try:
            d[k.replace("_json", "")] = json.loads(d.pop(k) or "{}")
        except Exception:
            d[k.replace("_json", "")] = {}
    return d


def _try_col(row: sqlite3.Row, name: str, default: Any = 0) -> Any:
    """读一行里可能不存在的列（旧库迁移期间兼容）"""
    try:
        return row[name]
    except (IndexError, KeyError):
        return default


def _ensure_columns(con: sqlite3.Connection) -> None:
    """轻量迁移：为旧库补列（points / runs / checkpoints 三张表）"""

    def cols_of(table: str) -> set:
        try:
            return {r[1] for r in con.execute(f"PRAGMA table_info({table})")}
        except sqlite3.Error:
            return set()

    # 首次连接时表还没建（SCHEMA 在 __init__ 里执行），空集直接跳过
    pts, runs, cps = cols_of("points"), cols_of("runs"), cols_of("checkpoints")
    for name, ddl in (("is_valid", "INTEGER DEFAULT 1"),
                      ("is_uploaded", "INTEGER DEFAULT 0"),
                      ("create_time", "INTEGER DEFAULT 0")):
        if pts and name not in pts:
            con.execute(f"ALTER TABLE points ADD COLUMN {name} {ddl}")
    # 开跑响应里的会话级设置（clockMode / whiteFlag / cheatLevel）
    for name, ddl in (("clock_mode", "INTEGER DEFAULT 0"),
                      ("white_flag", "INTEGER DEFAULT 0"),
                      ("cheat_level", "INTEGER DEFAULT 0"),
                      ("pause_count", "INTEGER DEFAULT 0"),
                      ("pause_times_s", "INTEGER DEFAULT 0")):
        if runs and name not in runs:
            con.execute(f"ALTER TABLE runs ADD COLUMN {name} {ddl}")
    # 打卡点的服务端原值（上传必须原样带回，不能拿本地序号顶替）
    for name, ddl in (("code", "INTEGER DEFAULT 0"), ("sort", "INTEGER DEFAULT 0"),
                      ("nfc", "INTEGER DEFAULT 0"), ("type", "INTEGER DEFAULT 0")):
        if cps and name not in cps:
            con.execute(f"ALTER TABLE checkpoints ADD COLUMN {name} {ddl}")
    con.commit()


def _row_to_point(row: sqlite3.Row, run_code: str) -> RunLatLng:
    return RunLatLng(
        lat=float(row["lat"]), lng=float(row["lng"]),
        lat_lng_index=int(row["idx"]),
        run_time=int(row["run_time"]), collect_time=int(row["collect_time"]),
        state=int(row["state"]), off_fence_dis_m=int(row["off_fence_dis_m"]),
        create_time=int(_try_col(row, "create_time", 0) or 0),
        accuracy=float(row["accuracy"] or 0.0), speed=float(row["speed"] or 0.0),
        satellites=int(row["satellites"] or 0),
        is_valid=bool(int(_try_col(row, "is_valid", 1))),
        is_uploaded=int(row["state"]) == STATE_SUCC,
        run_code=run_code,
    )


def _safe_json(obj: Any) -> str:
    if obj is None:
        return ""
    if isinstance(obj, str):
        return obj
    try:
        return json.dumps(obj, ensure_ascii=False)
    except Exception:
        return str(obj)
