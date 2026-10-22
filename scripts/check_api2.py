#!/usr/bin/env python3
"""核对 jadx 反编译出来的 Retrofit 接口是否忠实于 dex 原始注解。

权威判据：dexdump -a -d 直接读 dex 的 annotation_item / method descriptor。
被检对象：work/dex/jadx_FULL/sources 下 .java。
检查项：方法集合、@POST 路径、@FormUrlEncoded、参数注解（种类+顺序+@Field 键名）、
        参数个数、签名里的泛型类名集合。
"""
import os
import re
import sys
import subprocess
from pathlib import Path

ROOT = Path("/home/ylxc/Projects/lib/ShanDong")
def _find_dexdump() -> str:
    """优先用系统 Android SDK 的 dexdump（$ANDROID_HOME 或常见安装位置）"""
    import glob as _glob
    for base in (os.environ.get("ANDROID_HOME", ""),
                 str(Path.home() / ".local/share/android/sdk/Sdk"),
                 str(Path.home() / "Android/Sdk")):
        if not base:
            continue
        hits = sorted(_glob.glob(str(Path(base) / "build-tools" / "*" / "dexdump")))
        if hits:
            return hits[-1]
    return "dexdump"


DEXDUMP = _find_dexdump()
DEX = ROOT / "work/dex/APP_ALL4/classes_01_2010cls.dex"
SRC = ROOT / "work/dex/jadx_FULL/sources"
PKG = SRC / "com/huachenjie/run/api"

CASES = [
    ("Lcom/huachenjie/run/api/IFreeApi;", "IFreeApi.java"),
    ("Lcom/huachenjie/run/api/IRunApi;", "IRunApi.java"),
    ("Lcom/huachenjie/run/api/ISunshineApi;", "ISunshineApi.java"),
]

# 注解里以常量形式给出的 @Field 键 → 需从源码解析真实字符串
CONST_FILES = [
    SRC / "com/huachenjie/run/page/free/FreeRunActivity.java",
    SRC / "com/huachenjie/run/page/activities_run/ReadyActivity.java",
    SRC / "com/alibaba/baichuan/trade/common/ut/UserTrackConstant.java",
]


def const_table():
    table = {}
    for f in CONST_FILES:
        if not f.exists():
            continue
        cls = f.stem
        for m in re.finditer(r'(?:String|int|long)\s+(\w+)\s*=\s*"([^"]*)"', f.read_text(errors="replace")):
            table[f"{cls}.{m.group(1)}"] = m.group(2)
    return table


CONSTS = const_table()


# ---------------------------------------------------------------- dex 侧
def dex_dump_lines():
    out = ROOT / "tmp/dexdump_01.txt"
    if not out.exists() or out.stat().st_size < 1000:
        with open(out, "w") as fh:
            subprocess.run([str(DEXDUMP), "-a", "-d", str(DEX)], stdout=fh, stderr=subprocess.DEVNULL)
    return out.read_text(encoding="utf-8", errors="replace").splitlines()


def dex_class(lines, descriptor):
    def_start = next(i for i, ln in enumerate(lines)
                     if re.search(r"Class descriptor\s+:\s+'" + re.escape(descriptor) + r"'", ln))
    end = len(lines)
    for i in range(def_start + 1, len(lines)):
        if (re.match(r"Class #\d+ annotations:", lines[i]) or re.match(r"Class #\d+\s+-", lines[i])) and i > def_start + 5:
            end = i
            break

    sig = {}
    cur = None
    for ln in lines[def_start:end]:
        m = re.search(r"name\s+:\s+'([^']+)'", ln)
        if m:
            cur = m.group(1)
            sig[cur] = None
            continue
        m = re.search(r"type\s+:\s+'([^']+)'", ln)
        if m and cur:
            sig[cur] = m.group(1)

    ann_start = None
    for i in range(def_start - 1, max(def_start - 6000, -1), -1):
        if re.match(r"Class #\d+ annotations:", lines[i]):
            ann_start = i
            break
    ann_end = len(lines)
    for i in range(ann_start + 1, len(lines)):
        if re.match(r"Class #\d+\s+-", lines[i]) or re.match(r"Class descriptor", lines[i]):
            ann_end = i
            break

    meth, params, sigtxt = {}, {}, {}
    mode = cur = None
    for ln in lines[ann_start:ann_end]:
        m = re.match(r"Annotations on method #\d+ '([^']+)' parameters", ln)
        if m:
            mode, cur = "params", m.group(1)
            params.setdefault(cur, [])
            continue
        m = re.match(r"Annotations on method #\d+ '([^']+)'", ln)
        if m:
            mode, cur = "method", m.group(1)
            meth.setdefault(cur, {"path": None, "form": False, "headers": []})
            continue
        if cur is None:
            continue
        s = ln.strip()
        if mode == "method":
            mm = re.search(r'http/POST;\s*value="([^"]+)"', s)
            if mm:
                meth[cur]["path"] = mm.group(1)
            if "http/FormUrlEncoded" in s:
                meth[cur]["form"] = True
            mm = re.search(r'http/Headers;\s*value="([^"]+)"', s)
            if mm:
                meth[cur]["headers"].append(mm.group(1))
            mm = re.search(r"annotation/Signature;\s*value=\{(.*)\}", s)
            if mm:
                sigtxt[cur] = "".join(re.findall(r'"([^"]*)"', mm.group(1)))
        else:
            if not s.startswith("VISIBILITY"):
                continue
            f = re.search(r'http/Field;\s*value="([^"]+)"', s)
            if f:
                params[cur].append(["Field", f.group(1)])
            elif "http/FieldMap" in s:
                params[cur].append(["FieldMap", None])
            elif "http/Body" in s:
                params[cur].append(["Body", None])
            elif "http/Header" in s:
                params[cur].append(["Header", None])
    return sig, meth, params, sigtxt


def count_dex_args(sig):
    """'( args )ret' 里 args 的参数个数，跳过泛型 <...>。"""
    if not sig or not sig.startswith("("):
        return None
    depth = gen = 0
    end = None
    for i, ch in enumerate(sig):
        if ch == "(":
            depth += 1
        elif ch == ")":
            depth -= 1
            if depth == 0:
                end = i
                break
    args = sig[1:end]
    # 去掉 <...> 泛型实参，避免把 Map<String,String> 里的 String 当成形参
    prev = None
    while prev != args:
        prev = args
        args = re.sub(r"<[^<>]*>", "", args)
    n = i = 0
    gen = 0
    while i < len(args):
        ch = args[i]
        if ch == "<":
            gen += 1
        elif ch == ">":
            gen -= 1
        elif gen == 0:
            if ch == "[":
                i += 1
                continue
            if ch == "L":
                j = args.find(";", i)
                i = j + 1
                n += 1
                continue
            if ch in "IZJDBFSC":
                n += 1
        i += 1
    return n


# ---------------------------------------------------------------- java 侧
def split_top(s):
    out, depth, cur = [], 0, ""
    for ch in s:
        if ch in "(<":
            depth += 1
        elif ch in ")>":
            depth -= 1
        if ch == "," and depth == 0:
            out.append(cur)
            cur = ""
            continue
        cur += ch
    if cur.strip():
        out.append(cur)
    return out


def java_methods(path):
    text = path.read_text(errors="replace")
    body = text.split("public interface", 1)[1]
    body = body.rsplit("}", 1)[0]
    out = {}
    for m in re.finditer(r'@POST\("([^"]+)"\)', body):
        start_after = m.end()
        depth = 0
        # 找形参括号：depth 归零后紧跟 ';' 的那个 '('
        open_idx = None
        i = start_after
        last_open = None
        while i < len(body):
            ch = body[i]
            if ch == "(":
                depth += 1
                if depth == 1:
                    last_open = i
            elif ch == ")":
                depth -= 1
                if depth == 0:
                    k = i + 1
                    while k < len(body) and body[k] in " \t\r\n":
                        k += 1
                    if k < len(body) and body[k] == ";":
                        open_idx = last_open
                        close_idx = i
                        break
            i += 1
        if open_idx is None:
            continue
        head = body[start_after:open_idx]
        name_m = re.search(r"([A-Za-z_]\w*)\s*$", head)
        name = name_m.group(1)
        ret = re.sub(r"@[\w.]+(?:\([^)]*\))?", " ", head[:name_m.start(1)]).strip()
        ret = re.sub(r"\s+", " ", ret)
        raw_params = body[open_idx + 1:close_idx]
        anns, nparams = [], 0
        for seg in split_top(raw_params):
            if not seg.strip():
                continue
            nparams += 1
            fm = re.search(r"@(FieldMap|Field|Body|Header)\b(?:\(([^)]*)\))?", seg)
            if not fm:
                continue
            kind, arg = fm.group(1), fm.group(2)
            if kind == "Field" and arg is not None:
                arg = arg.strip()
                if arg.startswith('"'):
                    arg = arg.strip('"')
                else:
                    arg = CONSTS.get(arg, f"<未解析:{arg}>")
            else:
                arg = None
            anns.append([kind, arg])
        form = body[:m.start()].rstrip().endswith("@FormUrlEncoded")
        out[name] = {"path": m.group(1), "form": form, "anns": anns,
                     "nparams": nparams, "ret": ret,
                     "text": body[m.start():close_idx + 1]}
    return out


def classes_in(s):
    return {t.replace("/", ".") for t in re.findall(r"L([\w/$]+);", s or "")}


def main():
    lines = dex_dump_lines()
    problems = []
    for desc, jfile in CASES:
        sig, meth, params, sigtxt = dex_class(lines, desc)
        jd = java_methods(PKG / jfile)
        short = desc.split("/")[-1].rstrip(";")
        print(f"\n=== {short}: dex {len(sig)} 个方法 / jadx {len(jd)} 个")
        if set(sig) - set(jd):
            problems.append(f"{short}: jadx 缺方法 {sorted(set(sig) - set(jd))}")
        if set(jd) - set(sig):
            problems.append(f"{short}: jadx 多出方法 {sorted(set(jd) - set(sig))}")
        for name in sorted(set(sig) & set(jd), key=lambda x: (len(x), x)):
            d = meth.get(name, {})
            j = jd[name]
            if d.get("path") != j["path"]:
                problems.append(f"{short}.{name}: 路径 dex={d.get('path')} jadx={j['path']}")
            if bool(d.get("form")) != j["form"]:
                problems.append(f"{short}.{name}: @FormUrlEncoded dex={bool(d.get('form'))} jadx={j['form']}")
            if params.get(name, []) != j["anns"]:
                problems.append(f"{short}.{name}: 参数注解 dex={params.get(name, [])} jadx={j['anns']}")
            dn = count_dex_args(sigtxt.get(name) or sig[name])
            if dn is not None and dn != j["nparams"]:
                problems.append(f"{short}.{name}: 参数个数 dex={dn} jadx={j['nparams']} ({sig[name]})")
            # 泛型：dex Signature 里出现的业务类都应能在 jadx 该方法原文里找到
            dex_cls = classes_in(sigtxt.get(name) or sig[name])
            for want in sorted(c for c in dex_cls if c.startswith(("com.", "huachenjie."))):
                if want.split(".")[-1] not in j["text"]:
                    problems.append(f"{short}.{name}: 签名泛型 {want} 未出现在 jadx 方法体中")
    print("\n--- 差异 ---")
    print("\n".join(problems) if problems else "无：方法集合 / 路径 / FormUrlEncoded / 参数注解与顺序 / 参数个数 / 泛型 bean 全部一致")


if __name__ == "__main__":
    main()
