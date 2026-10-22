#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""把 Frida 注入脚本打包成可在 Frida 17（Python API）下加载的 bundle。

为什么要打包：Frida 17 通过 `session.create_script()` 加载脚本时**不会**自动
注入 Java bridge，直接写 `Java.use(...)` 会报 `ReferenceError: 'Java' is not defined`。
解法是把 `frida-java-bridge` 用 esbuild 打成自包含 bundle，并在入口把它挂到全局。

注意（本项目踩过）：
  * 入口文件每次都要**重新生成**，不能追加 —— 追加会导致 `import Java` 重复声明，
    esbuild 直接报 "The symbol Java has already been declared" 并打包失败，
    而失败时旧 bundle 仍在，脚本会悄无声息地跑旧逻辑。
  * 主脚本里也不要再写 `require('frida-java-bridge')`：esbuild 会把它解析成
    CommonJS 模块命名空间对象（没有 perform/use），调用时报 "not a function"。

用法:
    python3 scripts/build_frida_bundle.py scripts/tight.js work/records/frida/tight_bundle.js
"""

from __future__ import annotations

import argparse
import pathlib
import subprocess
import sys

ENTRY_HEADER = """import Java from 'frida-java-bridge';
globalThis.Java = Java;

"""


def main() -> int:
    ap = argparse.ArgumentParser(description="打包 Frida 注入脚本")
    ap.add_argument("source", help="主脚本（如 scripts/tight.js）")
    ap.add_argument("output", help="输出 bundle（如 work/tight_bundle.js）")
    ap.add_argument("--workdir", default=None,
                    help="esbuild 所在目录（默认 work/toolchain，node_modules 在那里）")
    args = ap.parse_args()

    src = pathlib.Path(args.source).resolve()
    out = pathlib.Path(args.output).resolve()
    out.parent.mkdir(parents=True, exist_ok=True)
    root = pathlib.Path(__file__).resolve().parents[1]
    workdir = (pathlib.Path(args.workdir).resolve() if args.workdir
               else root / "work" / "toolchain")

    entry = workdir / "_frida_entry.js"
    # 每次重新生成，绝不追加（追加会造成 import 重复 -> 打包失败）
    entry.write_text(ENTRY_HEADER + src.read_text(), encoding="utf-8")

    esbuild = workdir / "node_modules" / ".bin" / "esbuild"
    if not esbuild.is_file():
        print(f"[!] 未找到 esbuild: {esbuild}", flush=True)
        return 2

    cmd = [str(esbuild), str(entry), "--bundle", f"--outfile={out}",
           "--format=iife", "--platform=neutral", "--target=es2020"]
    r = subprocess.run(cmd, capture_output=True, text=True, cwd=str(workdir))
    print(r.stdout.strip() or r.stderr.strip(), flush=True)
    if r.returncode != 0:
        print("[!] 打包失败", flush=True)
        return r.returncode
    size = out.stat().st_size
    print(f"[√] {out}  {size:,} B", flush=True)
    return 0


if __name__ == "__main__":
    sys.exit(main())
