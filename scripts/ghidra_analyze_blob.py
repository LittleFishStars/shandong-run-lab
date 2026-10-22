#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""用 Ghidra headless 分析捕获的隐藏 SO blob。

背景：从进程中钓出的隐藏 SO 是**裸内存镜像**——没有可用 ELF 头（壳抹掉了），
因此不能用标准 ELF loader 导入。可行的做法是把裸二进制按 AArch64 处理器导入，
指定基址，让 Ghidra 做反汇编与函数识别。

用法:
    python3 scripts/ghidra_analyze_blob.py --bin work/native/hidden_so3/so_0x7cb2d9d000.bin \
        --base 0x0 --out work/native/ghidra_blob
"""

from __future__ import annotations

import argparse
import os
import pathlib
import subprocess
import sys

GHIDRA = pathlib.Path("/opt/ghidra")
HEADLESS = GHIDRA / "support" / "analyzeHeadless"


def main() -> int:
    ap = argparse.ArgumentParser(description="Ghidra headless 分析裸 blob")
    ap.add_argument("--bin", required=True, help="裸二进制路径")
    ap.add_argument("--base", default="0x0", help="加载基址")
    ap.add_argument("--out", default="work/native/ghidra_blob", help="Ghidra 项目目录")
    ap.add_argument("--project", default="blobproj", help="项目名")
    ap.add_argument("--script", default=None, help="要运行的 Ghidra 脚本（.java 或 .py）")
    ap.add_argument("--timeout", type=int, default=3600)
    args = ap.parse_args()

    blob = pathlib.Path(args.bin).resolve()
    if not blob.exists():
        print(f"[!] 文件不存在: {blob}", flush=True)
        return 1

    outdir = pathlib.Path(args.out).resolve()
    outdir.mkdir(parents=True, exist_ok=True)

    if not HEADLESS.exists():
        print(f"[!] 未找到 {HEADLESS}", flush=True)
        return 1

    # 裸二进制导入：用 -processor 指定架构，-loader BinaryLoader 指定加载器
    cmd = [
        str(HEADLESS),
        str(outdir), args.project,
        "-import", str(blob),
        "-processor", "AARCH64:LE:64:v8A",
        "-loader", "BinaryLoader",
        "-loader-baseAddr", args.base,
        "-overwrite",
        "-analysisTimeoutPerFile", "1800",
    ]
    if args.script:
        cmd += ["-postScript", args.script]
    cmd += ["-deleteProject"]

    print(f"[*] 运行: {' '.join(cmd)}", flush=True)
    env = dict(os.environ)
    # 用工作区 venv 里的 pyghidra（若脚本是 .py）
    r = subprocess.run(cmd, capture_output=True, text=True,
                       timeout=args.timeout, env=env)
    print("── stdout ──", flush=True)
    print(r.stdout[-8000:] if r.stdout else "(空)", flush=True)
    if r.stderr:
        print("── stderr ──", flush=True)
        print(r.stderr[-4000:], flush=True)
    print(f"[*] 退出码: {r.returncode}", flush=True)
    return r.returncode


if __name__ == "__main__":
    sys.exit(main())
