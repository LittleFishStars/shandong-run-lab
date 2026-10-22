#!/usr/bin/env python3
"""比对 dexdump 原始注解 与 jadx 反编译 .java 的 Retrofit 接口定义是否一致。

判据：dexdump 直接读 dex 的 annotation_item（权威），jadx 产物是被检验方。
比较项：HTTP 方法路径、@FormUrlEncoded、每个参数的注解（含顺序）、参数个数、返回泛型类名集合。
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
SRC = ROOT / "work/dex/jadx_FULL/sources/com/huachenjie/run/api"

CASES = [
    ("Lcom/huachenjie/run/api/IFreeApi;", "IFreeApi.java"),
    ("Lcom/huachenjie/run/api/IRunApi;", "IRunApi.java"),
    ("Lcom/huachenjie/run/api/ISunshineApi;", "ISunshineApi.java"),
]


def load_dexdump():
    out = ROOT / "tmp/dexdump_01.txt"
    if not out.exists() or out.stat().st_size < 1000:
        with open(out, "w") as fh:
            subprocess.run([str(DEXDUMP), "-a", "-d", str(DEX)], stdout=fh, stderr=subprocess.DEVNULL)
    return out.read_text(encoding="utf-8", errors="replace").splitlines()


def dex_class_blocks(lines, descriptor):
    """返回该类的 (方法签名表, 方法注解表, 参数注解表)。"""
    # 类定义位置（Class #N annotations 段在其之前 或 之后，两种都兼容：取最近的 descriptor 行）
    def_start = None
    for i, ln in enumerate(lines):
        if re.search(r"Class descriptor\s+:\s+'" + re.escape(descriptor) + r"'", ln):
            def_start = i
            break
    if def_start is None:
        raise SystemExit(f"dex 中找不到 {descriptor}")
    # 找紧随其后的方法列表结束点
    end = len(lines)
    for i in range(def_start + 1, len(lines)):
        if re.match(r"Class #\d+ annotations:", lines[i]) or re.match(r"Class #\d+\s+-", lines[i]):
            if i > def_start + 5:
                end = i
                break
    sigs = {}
    cur = None
    for ln in lines[def_start:end]:
        m = re.search(r"name\s+:\s+'([^']+)'", ln)
        if m:
            cur = m.group(1)
            sigs[cur] = {"type": None}
            continue
        m = re.search(r"type\s+:\s+'([^']+)'", ln)
        if m and cur:
            sigs[cur]["type"] = m.group(1)

    # 注解段：def_start 之前最近的 "Class #N annotations:"（dexdump 把注解段印在类定义之前）
    ann_start = None
    for i in range(def_start - 1, max(def_start - 4000, -1), -1):
        if re.match(r"Class #\d+ annotations:", lines[i]):
            ann_start = i
            break
    if ann_start is None:
        raise SystemExit(f"{descriptor} 找不到注解段")
    ann_end = len(lines)
    for i in range(ann_start + 1, len(lines)):
        if re.match(r"Class #\d+\s+-", lines[i]) or re.match(r"Class descriptor", lines[i]):
            ann_end = i
            break

    meth_ann = {}     # name -> dict
    param_ann = {}    # name -> list[list[str]]
    mode = None
    cur = None
    for ln in lines[ann_start:ann_end]:
        m = re.match(r"Annotations on method #\d+ '([^']+)' parameters", ln)
        if m:
            mode = "params"
            cur = m.group(1)
            param_ann.setdefault(cur, [])
            continue
        m = re.match(r"Annotations on method #\d+ '([^']+)'", ln)
        if m:
            mode = "method"
            cur = m.group(1)
            meth_ann.setdefault(cur, {"path": None, "form": False, "body": False,
                                      "headers": [], "sig": None})
            continue
        if cur is None:
            continue
        s = ln.strip()
        if mode == "method":
            mm = re.search(r'http/POST;\s*value="([^"]+)"', s)
            if mm:
                meth_ann[cur]["path"] = mm.group(1)
            m3 = re.search(r"annotation/Signature;\s*value=\{(.*)\}", s)
            if m3:
                meth_ann[cur]["sig"] = "".join(re.findall(r'"([^"]*)"', m3.group(1)))
            if "http/FormUrlEncoded" in s:
                meth_ann[cur]["form"] = True
            mm = re.search(r'http/Headers;\s*value="([^"]+)"', s)
            if mm:
                meth_ann[cur]["headers"].append(mm.group(1))
        else:
            if s.startswith("#"):
                continue
            if s.startswith("VISIBILITY"):
                field = re.search(r'http/Field;\s*value="([^"]+)"', s)
                if field:
                    param_ann[cur].append(["Field", field.group(1)])
                elif "http/FieldMap" in s:
                    param_ann[cur].append(["FieldMap", None])
                elif "http/Body" in s:
                    param_ann[cur].append(["Body", None])
                elif "http/Header" in s:
                    param_ann[cur].append(["Header", None])
    return sigs, meth_ann, param_ann



def count_dex_params(sig):
    """( args )ret 格式里，统计 args 的参数个数。"""
    if not sig or not sig.startswith("("):
        return None
    depth = 0
    end = None
    for i, ch in enumerate(sig):
        if ch == "(":
            depth += 1
        elif ch == ")":
            depth -= 1
            if depth == 0:
                end = i
                break
    if end is None:
        return None
    args = sig[1:end]
    n = 0
    i = 0
    while i < len(args):
        ch = args[i]
        if ch == "[":
            i += 1
            continue
        if ch == "L":
            j = args.find(";", i)
            if j < 0:
                return None
            i = j + 1
            n += 1
            continue
        if ch in "IZJDBFSC":
            i += 1
            n += 1
            continue
        i += 1
    return n


def count_java_params(params):
    """按顶层逗号切分 java 形参串。"""
    if not params.strip():
        return 0
    depth = 0
    n = 1
    for ch in params:
        if ch in "<(":
            depth += 1
        elif ch in ">)":
            depth -= 1
        elif ch == "," and depth == 0:
            n += 1
    return n


def jadx_methods(path):
    text = path.read_text(encoding="utf-8", errors="replace")
    body = text.split("public interface", 1)[1]
    body = body.rsplit("}", 1)[0]
    pat = re.compile(
        r"(?P<form>@FormUrlEncoded\s*)?@POST\(\"(?P<path>[^\"]+)\"\)"
        r"(?P<ret>.*?)(?P<name>[A-Za-z_]\w*)\((?P<params>.*?)\)\s*;",
        re.S,
    )
    out = {}
    for m in pat.finditer(body):
        params = m.group("params")
        anns = []
        for am in re.finditer(r"@(Field|FieldMap|Body|Header)(?:\(\"([^\"]*)\"\))?", params):
            kind, val = am.group(1), am.group(2)
            anns.append([kind, val if kind == "Field" else None])
        n = count_java_params(params)
        ret = re.sub(r"@\w+\s*", "", m.group("ret")).strip()
        out[m.group("name")] = {
            "path": m.group("path"),
            "form": bool(m.group("form")),
            "anns": anns,
            "nparams": n,
            "ret": ret,
        }
    return out


def norm_ret(s):
    toks = re.findall(r"[A-Za-z_$][\w$]*", s or "")
    skip = {"huachenjie", "sdk", "http", "rx", "Observable", "java", "util", "kotlin", "coroutines",
            "super", "Object", "NotNull", "Nullable"}
    return {t for t in toks if t not in skip}


def main():
    lines = load_dexdump()
    problems = []
    for desc, jfile in CASES:
        sigs, meth, params = dex_class_blocks(lines, desc)
        jd = jadx_methods(SRC / jfile)
        short = desc.split("/")[-1].rstrip(";")
        print(f"\n=== {short} : dex 方法 {len(sigs)} 个 / jadx {len(jd)} 个")
        missing = set(sigs) - set(jd)
        extra = set(jd) - set(sigs)
        if missing:
            problems.append(f"{short}: jadx 缺方法 {sorted(missing)}")
        if extra:
            problems.append(f"{short}: jadx 多出方法 {sorted(extra)}")
        for name in sorted(set(sigs) & set(jd), key=lambda x: (len(x), x)):
            d = meth.get(name, {})
            j = jd[name]
            if d.get("path") != j["path"]:
                problems.append(f"{short}.{name}: 路径 dex={d.get('path')} jadx={j['path']}")
            if bool(d.get("form")) != j["form"]:
                problems.append(f"{short}.{name}: FormUrlEncoded dex={bool(d.get('form'))} jadx={j['form']}")
            pl = params.get(name, [])
            if pl != j["anns"]:
                problems.append(f"{short}.{name}: 参数注解 dex={pl} jadx={j['anns']}")
            if d.get("type") and j["nparams"] != d["type"].count(";") + sum(1 for _ in re.finditer(r"[IZJDBF](?![\w$])", d["type"])):
                pass  # 由下面统一报
        # 方法数/返回类型粗校验
        for name in sorted(set(sigs) & set(jd), key=lambda x: (len(x), x)):
            d = meth.get(name, {})
            j = jd[name]
            dexret = norm_ret((d.get("sig") or ""))
            if dexret and not (dexret & norm_ret(j["ret"])):
                problems.append(f"{short}.{name}: 返回类型疑不符 dex签名/ jadx={j['ret']}")
        # 参数个数
        for name in sorted(set(sigs) & set(jd)):
            t = sigs.get(name, {}).get("type") or ""
            sig = meth.get(name, {}).get("sig")
            cnt = count_dex_params(sig) if sig else None
            if cnt is None:
                cnt = count_dex_params(t)
            if cnt is None:
                continue
            if cnt != j["nparams"]:
                problems.append(f"{short}.{name}: 参数个数 dex={cnt}({sig or t}) jadx={j['nparams']}")
    print("\n--- 差异 ---")
    print("\n".join(problems) if problems else "无（路径/注解/参数顺序/参数个数全部一致）")


if __name__ == "__main__":
    main()
