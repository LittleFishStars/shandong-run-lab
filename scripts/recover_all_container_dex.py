#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""批量还原易盾容器内的全部内嵌 DEX。

流程（对每个基址自动完成，并做闭合校验）：
    1. 由基址推出 string_ids（size S）与 type_ids（升序段，size T）
    2. proto_ids 紧跟 type_ids，用「proto 记录合法性」向前延伸得到 size P
    3. 扫描容器内的 class_defs 候选段（32 字节记录，access_flags 允许为 0）
    4. 解析 class_data_item 得到精确的 field_ids_size / method_ids_size，
       反推 field_ids / method_ids / class_defs 三个偏移
    5. 闭合校验： field_off - (proto_off + 12*P) 只能是 0 或容器固定私有块 19,064
    6. 重建 DEX（清零私有区、补合成 map_list、重算 SHA-1/Adler-32）

用法:
    python3 scripts/recover_all_container_dex.py work/peek/classes.dex -o work/rebuilt
"""

from __future__ import annotations

import argparse
import hashlib
import re
import struct
import sys
import zlib
from pathlib import Path

import numpy as np

ENDIAN_TAG = 0x12345678
NO_INDEX = 0xFFFFFFFF
VALID_ACC = 0x1 | 0x10 | 0x200 | 0x400 | 0x1000 | 0x2000 | 0x4000
GAP = 19_064                      # 容器在节区之间插入的固定私有块大小
RE_SHORTY = re.compile(rb"^[VZBSCIJFD]+$")


def read_uleb(buf: bytes, off: int):
    r = s = 0
    for i in range(5):
        if off + i >= len(buf):
            return None
        b = buf[off + i]
        r |= (b & 0x7F) << s
        if not b & 0x80:
            return r, i + 1
        s += 7
    return None


def parse_string_item(buf: bytes, pos: int):
    head = read_uleb(buf, pos)
    if head is None:
        return None
    ln, pre = head
    if ln > 65535:
        return None
    p, chars, start = pos + pre, 0, pos + pre
    while p < len(buf) and chars <= ln:
        c = buf[p]
        if c == 0:
            return (ln, buf[start:p]) if chars == ln else None
        chars += 1
        p += 1 if c < 0x80 else (2 if c < 0xE0 else (3 if c < 0xF0 else 4))
    return None


def find_bases(buf: bytes) -> list[int]:
    """扫描容器：string_ids 数组的每个元素 + 基址 都必须落在合法字符串项上。"""
    bases = []
    n = len(buf)
    # 以「疑似数组起点」为锚：连续 30 项均可解析
    def ok(base: int, off: int, cnt: int = 30) -> bool:
        p = off
        for _ in range(cnt):
            if p + 4 > n:
                return False
            (v,) = struct.unpack_from("<I", buf, p)
            if parse_string_item(buf, base + v) is None:
                return False
            p += 4
        return True
    # 已知布局：数组在 基址+4,100；因此基址 = 数组起点 - 4,100
    for off in range(200_000, n - 4 * 2000, 4):
        # 先做低成本预筛：连续 3 项都得解析成功才继续
        for base in (off - 4100,):
            if base < 0:
                continue
            if ok(base, off, 30):
                bases.append(base)
    # 归并相邻重复
    out = []
    for b in bases:
        if not out or b - out[-1] > 4096:
            out.append(b)
    return out


def derive_layout(buf: bytes, base: int):
    """推出 S / T / P / F / M 与各节区偏移；失败返回 None。"""
    s_off = 4100
    # string_ids
    S = 0
    p = base + s_off
    while p + 4 <= len(buf):
        (v,) = struct.unpack_from("<I", buf, p)
        if parse_string_item(buf, base + v) is None:
            break
        S += 1
        p += 4
    if S < 500:
        return None
    t_off = s_off + 4 * S
    # type_ids：严格递增且 < S
    T = 0
    prev = -1
    while True:
        (v,) = struct.unpack_from("<I", buf, base + t_off + 4 * T)
        if v <= prev or v >= S:
            break
        prev = v
        T += 1
    if T < 100:
        return None
    # proto_ids：紧跟 type_ids
    p_off = t_off + 4 * T
    P = 0
    while True:
        o = base + p_off + 12 * P
        sh, ret, par = struct.unpack_from("<III", buf, o)
        s = None
        try:
            s = parse_string_item(buf, base + 0)  # 占位，下面单独取
        except Exception:
            pass
        if ret >= T:
            break
        if par != 0:
            if par < 200_000 or par >= 12_000_000:
                break
            (cnt,) = struct.unpack_from("<I", buf, base + par)
            if cnt == 0 or cnt > 512:
                break
        # shorty 必须是短描述符：取 strings[sh]
        if sh >= S:
            break
        P += 1
    if P < 100:
        return None
    f_off = p_off + 12 * P
    if (f_off - p_off) % 4:
        return None
    return {"s_off": s_off, "S": S, "t_off": t_off, "T": T,
            "p_off": p_off, "P": P, "f_off_proto_end": f_off}


_CD_RUNS_CACHE: list[tuple[int, int]] | None = None


def all_class_def_runs(buf: bytes) -> list[tuple[int, int]]:
    """全局扫描一次：找出所有相位的 class_defs 候选段，返回 [(字节偏移, 记录数)]。"""
    global _CD_RUNS_CACHE
    if _CD_RUNS_CACHE is not None:
        return _CD_RUNS_CACHE
    n = (len(buf) // 4) * 4
    u = np.frombuffer(buf[:n], dtype="<u4")
    runs: list[tuple[int, int]] = []
    for k in range(8):                      # 8 种 4 字节相位
        acc = u[(1 + k)::8]
        if acc.size == 0:
            continue
        ok = (acc & ~np.uint32(VALID_ACC)) == 0
        idx = np.flatnonzero(ok)
        if idx.size < 300:
            continue
        brk = np.flatnonzero(np.diff(idx) != 1)
        starts = np.concatenate(([0], brk + 1))
        ends = np.concatenate((brk, [idx.size - 1]))
        for s, e in zip(starts, ends):
            ln = int(e - s + 1)
            if ln < 300:
                continue
            runs.append((int(idx[s]) * 32 + k * 4, ln))
    runs.sort()
    _CD_RUNS_CACHE = runs
    return runs


def find_class_defs(buf: bytes, base: int, tmax: int, limit: int):
    """筛出属于该基址的 class_defs 候选段（相对偏移）。

    关键收紧：class_idx 必须 < 本 DEX 的 type_ids_size，且候选段必须落在
    本 DEX 的范围（base .. limit）内——这两条把候选从几十个降到通常 1 个。
    """
    out = []
    for rec, ln in all_class_def_runs(buf):
        if rec < base or rec >= limit:
            continue
        ci = struct.unpack_from("<I", buf, rec)[0]
        if ci < tmax:
            out.append((rec - base, ln))
    return out


def scan_class_data(buf: bytes, base: int, c_off: int, C: int):
    """解析 class_data_item 得到 (field_ids_size, method_ids_size)。

    work 预算：非法候选段上的 uleb 计数可能很大，逐类展开会累积成百亿次迭代，
    因此统计总读取次数，超预算就返回 -1 放弃该候选段。
    """
    max_f = max_m = -1
    work = 0
    WORK_LIMIT = 30_000_000
    for i in range(C):
        cdata = struct.unpack_from("<I", buf, base + c_off + 32 * i + 24)[0]
        if cdata == 0:
            continue
        o = base + cdata
        if o >= len(buf) - 2:
            continue
        try:
            counts = []
            for _ in range(4):
                r = read_uleb(buf, o)
                if r is None:
                    raise ValueError
                # 护栏：合法的字段/方法计数不会超过几十万；非法候选段上 uleb
                # 会解出天文数字，直接跳过，否则内层循环会卡死。
                if r[0] > 200_000:
                    raise ValueError
                counts.append(r[0])
                o += r[1]
            work += sum(counts) * 2
            if work > WORK_LIMIT:
                return -1, -1
            for cnt in counts[:2]:
                idx = 0
                for _ in range(cnt):
                    r = read_uleb(buf, o); idx += r[0]; o += r[1]
                    r = read_uleb(buf, o); o += r[1]
                max_f = max(max_f, idx)
            for cnt in counts[2:]:
                idx = 0
                for _ in range(cnt):
                    r = read_uleb(buf, o); idx += r[0]; o += r[1]
                    r = read_uleb(buf, o); o += r[1]
                    r = read_uleb(buf, o); o += r[1]
                max_m = max(max_m, idx)
        except Exception:
            continue
    return max_f + 1, max_m + 1


def valid_tables(buf: bytes, base: int, L: dict, f_off: int, F: int,
                 m_off: int, M: int, samples: int = 400) -> bool:
    """抽样校验 field_ids / method_ids 区是否语义有效。"""
    def frac(count, off, kind):
        step = max(1, count // samples)
        tot = ok = 0
        for i in range(0, count, step):
            o = base + off + (8 if kind in ("f", "m") else 12) * i
            if o + 12 > len(buf):
                return 0.0
            if kind == "f":
                cls, typ, name = struct.unpack_from("<HHI", buf, o)
                good = cls < L["T"] and typ < L["T"] and name < L["S"]
            elif kind == "m":
                cls, proto, name = struct.unpack_from("<HHI", buf, o)
                good = cls < L["T"] and proto < L["P"] and name < L["S"]
            else:
                sh, ret, par = struct.unpack_from("<III", buf, o)
                good = sh < L["S"] and ret < L["T"] and (par == 0 or par < 12_000_000)
            tot += 1
            ok += 1 if good else 0
        return ok / max(1, tot)
    return frac(F, f_off, "f") >= 0.90 and frac(M, m_off, "m") >= 0.90


def build_map(sections, map_off: int) -> bytes:
    items = sorted(sections, key=lambda x: x[2])
    items.append((0x1000, 1, map_off))
    out = struct.pack("<I", len(items))
    for t, n, o in items:
        out += struct.pack("<HHII", t, 0, n, o)
    return out


def build_dex(buf: bytes, base: int, L: dict, c_off: int, C: int, F: int, M: int,
              max_data: int, out_path: Path) -> dict:
    m_off = c_off - 8 * M
    f_off = m_off - 8 * F
    p_off, P = L["p_off"], L["P"]
    if f_off < p_off + 12 * P:
        return {}
    data_off = c_off + 32 * C
    data_end = max(max_data + 64 * 1024, data_off)
    data_end = (data_end + 3) & ~3

    body = bytearray(buf[base:base + data_end])
    body[112:L["s_off"]] = b"\x00" * (L["s_off"] - 112)
    for gs, ge in ((L["t_off"] + 4 * L["T"], p_off), (p_off + 12 * P, f_off)):
        if ge > gs:
            body[gs:ge] = b"\x00" * (ge - gs)
    while len(body) % 4:
        body.append(0)
    map_off = len(body)
    body += build_map([(0x0000, 1, 0), (0x0001, L["S"], L["s_off"]),
                       (0x0002, L["T"], L["t_off"]), (0x0003, P, p_off),
                       (0x0004, F, f_off), (0x0005, M, m_off), (0x0006, C, c_off)], map_off)
    file_size = len(body)
    hdr = bytearray(112)
    hdr[0:8] = b"dex\n035\x00"
    for o, v in [(0x20, file_size), (0x24, 112), (0x28, ENDIAN_TAG), (0x2C, 0), (0x30, 0),
                 (0x34, map_off), (0x38, L["S"]), (0x3C, L["s_off"]), (0x40, L["T"]), (0x44, L["t_off"]),
                 (0x48, P), (0x4C, p_off), (0x50, F), (0x54, f_off), (0x58, M), (0x5C, m_off),
                 (0x60, C), (0x64, c_off), (0x68, data_end - data_off), (0x6C, data_off)]:
        struct.pack_into("<I", hdr, o, v)
    body[0:112] = hdr
    body[12:32] = hashlib.sha1(bytes(body[32:])).digest()
    struct.pack_into("<I", body, 8, zlib.adler32(bytes(body[12:])) & 0xFFFFFFFF)
    out_path.parent.mkdir(parents=True, exist_ok=True)
    out_path.write_bytes(bytes(body))
    return {"file_size": file_size, "S": L["S"], "T": L["T"], "P": P, "F": F, "M": M, "C": C}


def main() -> int:
    ap = argparse.ArgumentParser(description="批量还原容器内的全部 DEX")
    ap.add_argument("container")
    ap.add_argument("-o", "--outdir", required=True)
    ap.add_argument("--bases", help="逗号分隔的基址；缺省自动扫描")
    ap.add_argument("--max-dex", type=int, default=40)
    args = ap.parse_args()

    buf = Path(args.container).read_bytes()
    bases = ([int(x) for x in args.bases.split(",")] if args.bases else find_bases(buf))
    print(f"[*] 候选基址 {len(bases)} 个")
    outdir = Path(args.outdir)
    results = []
    for bi, base in enumerate(bases[:args.max_dex]):
        L = derive_layout(buf, base)
        if L is None:
            continue
        limit = next((b for b in bases if b > base), len(buf))
        runs = find_class_defs(buf, base, L["T"], limit)
        print(f"  base={base:,}  S={L['S']:,} T={L['T']:,} P={L['P']:,} "
              f"candidate_class_defs={len(runs)}", flush=True)
        picked = None
        # 真实 DEX 的类数不会超过几万；超长候选段必为误判，直接跳过。
        runs = [(c, n) for c, n in runs if n <= 40_000]
        for c_rel, ln in runs:
            # 预筛：前 8 条记录必须字段合理（避免在错误候选段上做昂贵解析）
            pref_ok = True
            for j in range(min(8, ln)):
                ci = struct.unpack_from("<I", buf, base + c_rel + 32 * j)[0]
                cd = struct.unpack_from("<I", buf, base + c_rel + 32 * j + 24)[0]
                if ci >= L["S"] or (cd and cd >= len(buf) - base):
                    pref_ok = False
                    break
            if not pref_ok:
                continue
            F, M = scan_class_data(buf, base, c_rel, ln)
            if F <= 0 or M <= 0:
                continue
            m_off = c_rel - 8 * M
            f_off = m_off - 8 * F
            if f_off < 0:
                continue
            # 判据：按此布局解出的 field_ids / method_ids 区必须「语义有效」。
            # 间隙大小因 DEX 而异（实测 560 / 2584 / 15048 / 19064 / 21152 …），
            # 不能写死；用抽样有效性来判定。
            if f_off < L["p_off"] + 12 * L["P"]:
                continue
            if not valid_tables(buf, base, L, f_off, F, m_off, M):
                continue
            picked = (c_rel, ln, F, M, f_off - (L["p_off"] + 12 * L["P"]))
            break
        if not picked:
            print(f"  base={base:,}  -> 未找到闭合的 class_defs")
            continue
        c_rel, C, F, M, gap = picked
        # 统计 data 区最大引用
        max_data = 0
        for i in range(C):
            a = struct.unpack_from("<8I", buf, base + c_rel + 32 * i)
            for o in (a[3], a[5], a[6], a[7]):
                if o:
                    max_data = max(max_data, o)
        name = f"dex_{bi:02d}_{base}.dex"
        info = build_dex(buf, base, L, c_rel, C, F, M, max_data, outdir / name)
        if info:
            print(f"  base={base:>12,}  S={L['S']:>7,} T={L['T']:>7,} P={L['P']:>7,} "
                  f"F={F:>7,} M={M:>7,} C={C:>6,} gap={gap:>6,} -> {name}")
            results.append((name, info))
    print(f"\n[+] 共重建 {len(results)} 个 DEX 到 {outdir}")
    return 0


if __name__ == "__main__":
    sys.exit(main())
