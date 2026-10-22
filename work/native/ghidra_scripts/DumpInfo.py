# -*- coding: utf-8 -*-
"""导出 Ghidra 对裸 blob 的分析结果（Python 脚本，Ghidra 内运行）。
# @category Analysis
"""
# Ghidra/FlatProgramAPI 预置：currentProgram, println 等

import os
import java.io

out_dir = os.environ.get("BLOB_OUT", "/tmp")
os.makedirs(out_dir, exist_ok=True)


def w(path, lines):
    with open(os.path.join(out_dir, path), "w", encoding="utf-8") as f:
        f.write("\n".join(lines))


# ── ① 内存块 ──
blocks = []
for b in currentProgram.getMemory().getBlocks():
    blocks.append("%s\t%s\t%s\t%d\t%s" % (
        b.getName(), b.getStart(), b.getEnd(), b.getSize(),
        "X" if b.isExecute() else "-"))
w("blocks.tsv", blocks)
println("内存块: %d" % len(blocks))

# ── ② 函数清单 ──
fm = currentProgram.getFunctionManager()
funcs = []
for f in fm.getFunctions(True):
    funcs.append("%s\t%s\t%d\t%d" % (
        f.getEntryPoint(), f.getName(), f.getBody().getNumAddresses(),
        f.getParameterCount()))
w("functions.tsv", funcs)
println("函数数: %d" % len(funcs))

# ── ③ 字符串 ──
strs = []
for d in currentProgram.getListing().getDefinedData(True):
    try:
        v = d.getValue()
    except Exception:
        continue
    if isinstance(v, str) and len(v) >= 4:
        strs.append("%s\t%s" % (d.getAddress(), v.replace("\n", "\\n").replace("\t", " ")))
w("strings.tsv", strs)
println("字符串数: %d" % len(strs))

# ── ④ 按体积排序的函数（前 300）──
def size_of(row):
    try:
        return int(row.split("\t")[2])
    except Exception:
        return 0

funcs_sorted = sorted(funcs, key=size_of, reverse=True)
w("funcs_by_size.tsv", funcs_sorted[:300])

# ── ⑤ 符号 / 外部引用 ──
syms = []
st = currentProgram.getSymbolTable()
for s in st.getAllSymbols(True):
    try:
        syms.append("%s\t%s\t%s" % (s.getAddress(), s.getName(), s.getSymbolType()))
    except Exception:
        pass
w("symbols.tsv", syms[:20000])
println("符号数: %d" % len(syms))

println("已导出到 %s" % out_dir)
