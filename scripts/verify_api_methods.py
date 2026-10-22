#!/usr/bin/env python3
"""逐方法核对：dex 里的 Retrofit 接口注解 vs jadx 反编译出的 Java 源码。

与 check_all_api.py 的「按文件存在」不同，这里按「类 + 方法名」逐条比对：
每个方法的 HTTP 方法/路径、@FormUrlEncoded、以及每个参数的注解（Field/FieldMap/Body/Header/Query）
都必须一一对应。jadx 把注解实参还原成常量引用时，用常量表反解回字面量。
"""
import importlib.util
import re
import sys
from pathlib import Path

ROOT = Path("/home/ylxc/Projects/lib/ShanDong")
spec = importlib.util.spec_from_file_location("capi", ROOT / "tmp/check_all_api.py")
capi = importlib.util.module_from_spec(spec)
sys.argv = [sys.argv[0]]  # 避免 import 时触发 main
spec.loader.exec_module(capi)

SRC = ROOT / "work/dex/jadx_FULL/sources"
FIELD_VALUES = capi.FIELD_VALUES
CONSTS = capi.CONSTS

# 参数上的 Retrofit 注解
PARAM_ANN = re.compile(r'@(Field|Header|Query|Path|Part)\("([^"]*)"\)|@(FieldMap|Body|PartMap)\b')
CONST_REF = re.compile(r"@(Field|Header|Query|Path)\(")


def split_params(s: str):
    """按顶层逗号切分参数列表，忽略 <> 与 (...)、("...") 内部。"""
    out, depth, cur, i = [], 0, "", 0
    while i < len(s):
        ch = s[i]
        if ch in "<([":
            depth += 1
        elif ch in ">)]":
            depth -= 1
        elif ch == '"':  # 跳字符串
            j = i + 1
            while j < len(s) and s[j] != '"':
                j += 1
            cur += s[i:j + 1]
            i = j + 1
            continue
        if ch == "," and depth == 0:
            out.append(cur)
            cur = ""
        else:
            cur += ch
        i += 1
    if cur.strip():
        out.append(cur)
    return [p.strip() for p in out if p.strip()]


def resolve_const(expr: str):
    """把 `@Field(yj7.g.WORKS_NO)` 之类的常量引用解析成字面量；解析不出返回 None。"""
    inner = expr[len("@") + len(expr[1:].split("(", 1)[0]) + 1:-1]
    vals = CONSTS.get(inner) or CONSTS.get(inner.split(".", 1)[-1]) or []
    if not vals:
        field = inner.rsplit(".", 1)[-1]
        vals = sorted(FIELD_VALUES.get(field, ()))
    return vals[0] if len(vals) == 1 else None


def inner_name(expr: str):
    """`(yj7.g.WORKS_NO)` -> yj7.g.WORKS_NO"""
    return expr[1:-1]


def param_ok(jp, dp):
    """jp=(kind,arg) 来自 jadx，dp=(kind,arg) 来自 dex；未解析常量按取值集合匹配。"""
    if jp[0] != dp[0]:
        return False
    if not isinstance(jp[1], tuple):
        return jp[1] == dp[1]
    field = jp[1][1].rsplit(".", 1)[-1]
    return dp[1] in FIELD_VALUES.get(field, ())


def parse_jadx(path: Path):
    """返回 {方法名: [ {path, form, params:[(kind, arg)]} ... ]}"""
    text = path.read_text(errors="replace")
    lines = text.splitlines()
    methods = {}
    for i, ln in enumerate(lines):
        if not ln.rstrip().endswith((");", ") {")) or "(" not in ln:
            continue
        if ln.lstrip().startswith(("import", "package", "//", "/*", "*")):
            continue
        # 方法级注解：本行之前连续的 @ 行
        anns = []
        j = i - 1
        while j >= 0 and lines[j].strip().startswith("@"):
            anns.append(lines[j].strip())
            j -= 1
        path_ = None
        form = False
        headers = []
        for a in anns:
            m = re.match(r'@(POST|GET|PUT|DELETE)\("([^"]+)"\)', a)
            if m:
                path_ = f"{m.group(1)} {m.group(2)}"
            if a.startswith("@FormUrlEncoded"):
                form = True
            hm = re.match(r'@Headers\(\{(.*?)\}\)', a)
            if hm:
                headers.extend(re.findall(r'"([^"]+)"', hm.group(1)))
        m = re.match(r"^\s*([\w.<>?,\[\] ]+?)\s+(\w+)\((.*)\)(?:;|\s*\{)$", ln.strip())
        if not m:
            continue
        ret, name, params_s = m.group(1), m.group(2), m.group(3)
        ret = re.sub(r"^(?:public|protected|private|static|final|abstract|default|synchronized|native)\s+", "", ret).strip()
        params = []
        for p in split_params(params_s):
            kind = arg = None
            mm = PARAM_ANN.search(p)
            if mm:
                if mm.group(1):
                    kind, arg = mm.group(1), mm.group(2)
                else:
                    kind = mm.group(3)
            else:
                for cm in CONST_REF.finditer(p):
                    seg = p[cm.end() - 1:]
                    depth, k = 0, 0
                    for k, ch in enumerate(seg):
                        if ch == "(":
                            depth += 1
                        elif ch == ")":
                            depth -= 1
                            if depth == 0:
                                break
                    expr = seg[:k + 1]
                    kind = cm.group(1)
                    arg = resolve_const("@" + cm.group(1) + expr)
                    if arg is None:
                        arg = ("?", inner_name(expr))
                    break
                if kind is None:
                    continue  # 该参数不是 Retrofit 字段注解（如 Continuation）
            params.append((kind, arg))
        methods.setdefault(name, []).append({"path": path_, "form": form, "params": params, "ret": ret, "headers": headers})
    return methods


def main():
    problems, checked = [], 0
    dexes = [Path(a) for a in sys.argv[1:]] or sorted((ROOT / "work/dex/APP_ALL4").glob("classes_*.dex"))
    for dex in dexes:
        classes = capi.parse(capi.dump_lines(dex))
        for idx, c in sorted(classes.items()):
            desc = c["desc"]
            if not desc:
                continue
            if not any(v["path"] for v in c["meth"].values()):
                continue
            f = SRC / (desc.strip("L;").replace(".", "/") + ".java")
            if not f.exists():
                continue
            jm = parse_jadx(f)
            for name, info in c["meth"].items():
                if not info["path"]:
                    continue
                checked += 1
                cands = jm.get(name)
                if not cands:
                    problems.append(f"{desc}#{name}: jadx 无同名方法")
                    continue
                want = (info["path"], info["form"],
                        [(k, a) for k, a in c["params"].get(name, []) if k in ("Field", "FieldMap", "Body", "Header", "Query")])

                proto = c.get("proto", {}).get(name, "")
                dex_ret = ""
                if ")" in proto:
                    dex_ret = proto.rsplit(")", 1)[1].strip("L;").rsplit("/", 1)[-1]

                def match(d):
                    if d["path"] != want[0] or d["form"] != want[1]:
                        return False
                    if dex_ret and d.get("ret", "").split("<")[0].rsplit(".", 1)[-1] != dex_ret:
                        return False
                    if sorted(d.get("headers", [])) != sorted(c["meth"][name].get("headers", [])):
                        return False
                    if len(d["params"]) != len(want[2]):
                        return False
                    return all(param_ok(jp, dp) for jp, dp in zip(d["params"], want[2]))

                if not any(match(d) for d in cands):
                    problems.append(f"{desc}#{name}: 期望 {want} / jadx {[(d['path'], d['form'], d['params']) for d in cands]}")
    print(f"逐方法核对 {checked} 个")
    print("--- 方法集合差异 ---")
    extra = []
    for dex in [Path(a) for a in sys.argv[1:]] or sorted((ROOT / "work/dex/APP_ALL4").glob("classes_*.dex")):
        classes = capi.parse(capi.dump_lines(dex))
        for idx, c in sorted(classes.items()):
            desc = c["desc"]
            if not desc or not any(v["path"] for v in c["meth"].values()):
                continue
            f = SRC / (desc.strip("L;").replace(".", "/") + ".java")
            if not f.exists():
                continue
            jm = parse_jadx(f)
            dex_names = {n for n, v in c["meth"].items() if v["path"]}
            jadx_names = {n for n, v in jm.items() if any(d["path"] for d in v)}
            if dex_names != jadx_names:
                extra.append(f"{desc}: dex 独有 {sorted(dex_names - jadx_names)} / jadx 独有 {sorted(jadx_names - dex_names)}")
    print("\n".join(extra) if extra else "无")
    print("--- 不一致 ---")
    print("\n".join(problems) if problems else "无")


if __name__ == "__main__":
    main()
