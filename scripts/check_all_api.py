#!/usr/bin/env python3
"""全量核对：dex 中所有带 Retrofit 注解的类 vs jadx 反编译输出。

用法: python3 tmp/check_all_api.py [dex...]
判据权威：dexdump（直读 dex annotation_item）；jadx 产物是被检方。
"""
import json
import os
import re
import subprocess
import sys
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
SRC = ROOT / "work/dex/jadx_FULL/sources"
_CONSTS_PATH = ROOT / "tmp" / "consts.json"
if not _CONSTS_PATH.exists():                     # 常量表是缓存，缺了先自动生成
    subprocess.run([sys.executable, str(ROOT / "scripts" / "build_consts.py")], check=True)
CONSTS = json.loads(_CONSTS_PATH.read_text(encoding="utf-8"))
FIELD_VALUES = {}
for _k, _vs in CONSTS.items():
    FIELD_VALUES.setdefault(_k.rsplit(".", 1)[-1], set()).update(_vs)


def dump_lines(dex: Path):
    out = ROOT / "tmp" / (dex.stem + ".dexdump.txt")
    if not out.exists() or out.stat().st_size < 1000:
        with open(out, "w") as fh:
            subprocess.run([str(DEXDUMP), "-a", "-d", str(dex)], stdout=fh, stderr=subprocess.DEVNULL)
    return out.read_text(encoding="utf-8", errors="replace").splitlines()


def parse(lines):
    """返回 {class_index: {desc, meth:{name:{path,form}}, params:{name:[(kind,arg)]}, sig:{}}}"""
    classes = {}
    idx = section = cur_meth = cur_mode = None
    for ln in lines:
        m = re.match(r"Class #(\d+) annotations:", ln)
        if m:
            idx, section = int(m.group(1)), "ann"
            classes.setdefault(idx, {"desc": None, "meth": {}, "params": {}, "sig": {}, "proto": {}})
            cur_meth = cur_mode = None
            continue
        m = re.match(r"Class #(\d+)\s+-", ln)
        if m:
            idx, section = int(m.group(1)), "def"
            classes.setdefault(idx, {"desc": None, "meth": {}, "params": {}, "sig": {}, "proto": {}})
            continue
        if idx is None:
            continue
        if section == "def":
            m = re.search(r"Class descriptor\s+:\s+'([^']+)'", ln)
            if m and classes[idx]["desc"] is None:
                classes[idx]["desc"] = m.group(1)
                continue
            m = re.search(r"name\s+:\s+'([^']+)'", ln)
            if m:
                classes[idx].setdefault("_pending", m.group(1))
                continue
            m = re.search(r"type\s+:\s+'(\([^']*)'", ln)
            if m and classes[idx].get("_pending"):
                classes[idx]["proto"][classes[idx].pop("_pending")] = m.group(1)
            continue
        m = re.match(r"Annotations on method #\d+ '([^']+)' parameters", ln)
        if m:
            cur_meth, cur_mode = m.group(1), "p"
            classes[idx]["params"].setdefault(cur_meth, [])
            continue
        m = re.match(r"Annotations on method #\d+ '([^']+)'", ln)
        if m:
            cur_meth, cur_mode = m.group(1), "m"
            classes[idx]["meth"].setdefault(cur_meth, {"path": None, "form": False})
            continue
        if cur_meth is None:
            continue
        s = ln.strip()
        if cur_mode == "m":
            mm = re.search(r'http/(POST|GET);\s*value="([^"]+)"', s)
            if mm:
                classes[idx]["meth"][cur_meth]["path"] = mm.group(1) + " " + mm.group(2)
            if "http/FormUrlEncoded" in s:
                classes[idx]["meth"][cur_meth]["form"] = True
            hm = re.search(r"http/Headers;\s*value=\{(.*)\}", s)
            if hm:
                classes[idx]["meth"][cur_meth].setdefault("headers", []).extend(re.findall(r'"([^"]*)"', hm.group(1)))
            mm = re.search(r"annotation/Signature;\s*value=\{(.*)\}", s)
            if mm:
                classes[idx]["sig"][cur_meth] = "".join(re.findall(r'"([^"]*)"', mm.group(1)))
        else:
            if not s.startswith("VISIBILITY"):
                continue
            f = re.search(r'http/Field;\s*value="([^"]+)"', s)
            if f:
                classes[idx]["params"][cur_meth].append(("Field", f.group(1)))
            elif "http/FieldMap" in s:
                classes[idx]["params"][cur_meth].append(("FieldMap", None))
            elif "http/Body" in s:
                classes[idx]["params"][cur_meth].append(("Body", None))
            elif (h := re.search(r'http/Header;\s*value="([^"]+)"', s)):
                classes[idx]["params"][cur_meth].append(("Header", h.group(1)))
            else:
                q = re.search(r'http/Query;\s*value="([^"]+)"', s)
                if q:
                    classes[idx]["params"][cur_meth].append(("Query", q.group(1)))
    return classes


def inline_constants(text):
    """把 jadx 的 @Field(Cls.FIELD) 按常量表还原成字面量，否则正确反编译会被误判。"""

    def rep(m):
        vals = CONSTS.get(m.group(1)) or []
        return f'@Field("{vals[0]}")' if len(vals) == 1 else m.group(0)

    return re.sub(r"@Field\(([A-Za-z_]\w*\.[A-Za-z_]\w*)\)", rep, text)


REF = re.compile(r"@Field\(([A-Za-z_][\w.]*)\)")


def const_ref_matches(text, literal):
    """jadx 把注解参数还原成常量引用时（如 @Field(yj7.g.WORKS_NO)），
    只要该常量名存在、且其取值就是 dex 里的字面量，就算反编译正确。"""
    for m in REF.finditer(text):
        field = m.group(1).rsplit(".", 1)[-1]
        if literal in FIELD_VALUES.get(field, ()):
            return True
    return False


def main():
    dexes = [Path(a) for a in sys.argv[1:]] or sorted((ROOT / "work/dex/APP_ALL4").glob("classes_*.dex"))
    total = 0
    problems = []
    for dex in dexes:
        classes = parse(dump_lines(dex))
        n_api = 0
        for idx, c in sorted(classes.items()):
            desc = c["desc"]
            if not desc or not any(v["path"] for v in c["meth"].values()):
                continue
            n_api += 1
            total += 1
            f = SRC / (desc.strip("L;").replace(".", "/") + ".java")
            if not f.exists():
                problems.append(f"[{dex.name}] {desc}: jadx 无对应文件")
                continue
            text = inline_constants(f.read_text(errors="replace"))
            for name, info in c["meth"].items():
                if not info["path"]:
                    continue
                method, path = info["path"].split(" ", 1)
                if f'@{method}("{path}")' not in text:
                    problems.append(f"[{dex.name}] {desc}#{name}: jadx 缺 @{method}(\"{path}\")")
                if info["form"] and "@FormUrlEncoded" not in text:
                    problems.append(f"[{dex.name}] {desc}#{name}: jadx 缺 @FormUrlEncoded")
            for name, anns in c["params"].items():
                for kind, arg in anns:
                    needle = f'@{kind}("{arg}")' if arg else f"@{kind}"
                    if needle not in text and not (arg and const_ref_matches(text, arg)):
                        problems.append(f"[{dex.name}] {desc}#{name}: jadx 缺参数注解 {needle}")
        print(f"{dex.name}: 含 Retrofit 注解的类 {n_api} 个", flush=True)
    print(f"\n共核对接口类 {total} 个")
    print("--- 问题 ---")
    print("\n".join(problems) if problems else "无")


if __name__ == "__main__":
    main()
