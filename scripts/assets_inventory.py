#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
assets_inventory.py —— APK assets 资产盘点 + 域名线索提取

功能
    1) 用 zipfile 读取 APK 内 assets/ 下全部条目，按类型分组（图片/音频/JS/JAR/DB/配置/dat/其它）。
    2) 挑出「需要关注」的文件：jar、dat、db、无扩展名、pem、keystore、js、html、
       证书库(bks/jks)、properties、license，逐个给出大小、file 魔数判定、
       文本类文件的前几行摘要。
    3) 从关注文件与 lib/*.so 的字符串结果中正则提取域名，去重后输出 work/domains.txt。

产出
    work/meta/assets_inventory.md   人类可读盘点报告
    work/meta/domains.txt           去重域名列表（附出现来源）

注意
    · 只读 APK，不改动原有文件。
    · 对 PEM/keystore 只报告类型与指纹，不输出私钥内容。
"""

from __future__ import annotations

import argparse
import os
import re
import subprocess
import zipfile
from collections import OrderedDict

# 「需要关注」的扩展名（小写，无扩展名用 "" 表示）
WATCH_EXT = {
    "", ".jar", ".dat", ".db", ".pem", ".keystore", ".js", ".html",
    ".bks", ".jks", ".properties", ".license", ".lic", ".crt", ".cer",
    ".key", ".p12", ".bin", ".data", ".xml", ".plist", ".pfx", ".aidl",
}

# 按类型分组用的扩展名归属
GROUPS = OrderedDict([
    ("图片", {".png", ".jpg", ".jpeg", ".webp", ".gif", ".svg", ".cur", ".9.png", ".data"}),
    ("音频/视频", {".aac", ".mp3", ".amr", ".wav", ".ogg", ".mp4", ".m4a", ".flv", ".ts"}),
    ("JS/HTML/前端", {".js", ".html", ".css", ".frag", ".queen", ".glsl", ".z"}),
    ("JAR/APK/插件", {".jar", ".apk", ".zip", ".so"}),
    ("DB/数据", {".db", ".sqlite", ".dat", ".data", ".bin", ".czl", ".prof", ".profm"}),
    ("配置/清单", {".json", ".xml", ".properties", ".plist", ".yml", ".yaml", ".txt", ".license", ".cfg"}),
    ("证书/密钥库", {".pem", ".crt", ".cer", ".bks", ".jks", ".keystore", ".p12", ".pfx"}),
    ("字体", {".ttf", ".otf", ".woff", ".woff2", ".pfb"}),
    ("模型", {".tflite", ".flb", ".loc", ".onnx", ".pb"}),
])

# 域名匹配：只取明显是域名的形态，避免把类名当域名
DOMAIN_RE = re.compile(
    r"\b((?:[a-z0-9](?:[a-z0-9-]{0,61}[a-z0-9])?\.)+"
    r"(?:com|cn|net|org|io|me|tv|top|xyz|cc|info|biz|mobi|live|vip|app|dev|ai|co|so|gd|sh)"
    r"(?:\.[a-z]{2})?)\b",
    re.IGNORECASE,
)
URL_RE = re.compile(r"https?://[a-z0-9._~:/?#\[\]@!$&'()*+,;=%-]{6,120}", re.IGNORECASE)

# 过滤掉编译器/开源库样板域名，它们对「第三方 SDK 归属」没有意义
DOMAIN_NOISE = re.compile(
    r"(googlesource\.com|gnu\.org|llvm\.org|zlib\.net|openssl\.org|python\.org|w3\.org|"
    r"apache\.org|json\.org|gcc\.gnu\.org|khronos\.org|example\.com|schemas\.android\.com|"
    r"sqlite\.org|libpng\.org|sourceforge\.net|boost\.org|unicode\.org|tensorflow\.org|"
    r"github\.com|githubusercontent\.com|ffmpeg\.org|videolan\.org|sourceware\.org|"
    r"kernel\.org|busybox\.net|expat|libjpeg|libtiff|curl\.se|openssl|npmjs\.org|"
    r"nodejs\.org|1e100\.net|googleapis\.com|gstatic\.com|digicert\.com|rapidssl\.com)",
    re.IGNORECASE,
)

PW_RE = re.compile(rb"[\x20-\x7e]{6,}")


def guess_magic(blob: bytes) -> str:
    """用魔数做轻量级类型判定（等价于 file 命令的核心判断，避免落盘）。"""
    if blob[:2] == b"PK":
        if blob[:4] == b"PK\x03\x04":
            return "ZIP/JAR/APK (PK\\x03\\x04)"
        return "ZIP 变体 (PK..)"
    if blob[:8] == b"\x89PNG\r\n\x1a\n":
        return "PNG 图片"
    if blob[:3] == b"\xff\xd8\xff":
        return "JPEG 图片"
    if blob[:6] == b"GIF87a" or blob[:6] == b"GIF89a":
        return "GIF 图片"
    if blob[:4] == b"%PDF":
        return "PDF 文档"
    if blob[:4] == b"\x7fELF":
        return f"ELF 可执行/共享库 ({'64' if blob[4] == 2 else '32'}位)"
    if blob[:4] == b"dex\n":
        return "Dalvik DEX (dex\\n)"
    if blob[:16] == b"SQLite format 3\x00":
        return "SQLite 数据库"
    if blob[:11] == b"-----BEGIN ":
        return "PEM 文本 (证书/密钥)"
    if blob[:4] == b"\xfe\xed\xfe\xed":
        return "JKS 密钥库 (FEEDFEED)"
    if blob[:2] == b"\x1f\x8b":
        return "GZIP 压缩"
    if blob[:4] == b"RIFF":
        return "RIFF (WAV/WebP)"
    if blob[:4] == b"\x00\x00\x00\x00":
        return "未知（前 4 字节全 0，疑自定义容器头或加密数据）"
    # 熵估计：高熵且无可识别魔数 => 加密/压缩
    sample = blob[:4096]
    if sample:
        import math
        from collections import Counter
        c = Counter(sample)
        n = len(sample)
        ent = -sum(v / n * math.log2(v / n) for v in c.values())
        if ent > 7.9:
            return f"未知（熵 {ent:.2f}，疑加密/压缩数据）"
        if ent > 7.0:
            return f"未知（熵 {ent:.2f}，疑二进制/混淆数据）"
    return "未知（无已知魔数）"


def is_textish(blob: bytes) -> bool:
    """粗判是否文本：前 512 字节可打印占比 > 90%。"""
    s = blob[:512]
    if not s:
        return False
    printable = sum(1 for b in (s if isinstance(s, bytes) else s.encode()) if 32 <= b < 127 or b in (9, 10, 13))
    return printable / len(s) > 0.90


def text_head(blob: bytes, lines: int = 4, width: int = 160) -> list[str]:
    """取文本前几行做摘要。"""
    txt = blob.decode("utf-8", "replace")
    out = []
    for ln in txt.splitlines()[:lines]:
        out.append(ln[:width])
    return out


def main() -> int:
    here = os.path.dirname(os.path.abspath(__file__))
    root = os.path.dirname(here)
    ap = argparse.ArgumentParser(description="APK assets 资产盘点与域名提取")
    ap.add_argument("--apk", default=os.path.join(root, "samples", "com.huachenjie.shandong_school.apk"))
    ap.add_argument("--outdir", default=os.path.join(root, "work", "meta"))
    ap.add_argument("--skip-domains-from-so", action="store_true",
                    help="跳过从 lib/*.so 提取域名（可显著加速）")
    args = ap.parse_args()
    os.makedirs(args.outdir, exist_ok=True)

    domain_sources: "OrderedDict[str, set[str]]" = OrderedDict()

    def add_domains(text: str, source: str) -> None:
        for m in URL_RE.finditer(text):
            u = m.group().rstrip(".,;)\"'")
            host = re.sub(r"^https?://", "", u).split("/")[0].split(":")[0].lower()
            if host and not DOMAIN_NOISE.search(host):
                domain_sources.setdefault(host, set()).add(source)
        for m in DOMAIN_RE.finditer(text):
            d = m.group(1).lower()
            if not DOMAIN_NOISE.search(d):
                domain_sources.setdefault(d, set()).add(source)

    with zipfile.ZipFile(args.apk) as z:
        assets = [i for i in z.infolist() if i.filename.startswith("assets/") and not i.is_dir()]

        # ---------- 1) 按类型分组 ----------
        grouped: "OrderedDict[str, list]" = OrderedDict((k, []) for k in GROUPS)
        grouped["无扩展名/其它"] = []
        for i in assets:
            ext = os.path.splitext(os.path.basename(i.filename))[1].lower()
            for gname, exts in GROUPS.items():
                if ext in exts:
                    grouped[gname].append(i)
                    break
            else:
                grouped["无扩展名/其它"].append(i)

        # ---------- 2) 关注文件 ----------
        watch = []
        for i in assets:
            base = os.path.basename(i.filename)
            ext = os.path.splitext(base)[1].lower()
            if ext in WATCH_EXT or base in ("keystore_unicorn", "keystore_unicorn2"):
                watch.append(i)
        watch.sort(key=lambda i: -i.file_size)

        reports = []
        for i in watch:
            blob = z.read(i.filename)
            rec = {
                "name": i.filename,
                "size": i.file_size,
                "magic": guess_magic(blob),
                "text": is_textish(blob),
                "head": [],
                "extra": "",
            }
            if rec["text"]:
                rec["head"] = text_head(blob)
                add_domains(blob.decode("utf-8", "replace"), base_name(i.filename))
            else:
                # 非文本：用 strings 思路抓少量可打印串，用于域名与归属线索
                txt = "\n".join(m.group().decode("ascii", "replace") for m in PW_RE.finditer(blob[:4_000_000]))
                add_domains(txt, base_name(i.filename))
                rec["extra"] = "二进制/加密；已从中提取可打印串用于域名线索"
            reports.append(rec)

    # ---------- 3) 从 .so 提取域名 ----------
    if not args.skip_domains_from_so:
        with zipfile.ZipFile(args.apk) as z:
            for info in z.infolist():
                if info.filename.startswith("lib/arm64-v8a/") and info.filename.endswith(".so"):
                    blob = z.read(info.filename)
                    txt = "\n".join(m.group().decode("ascii", "replace")
                                    for m in PW_RE.finditer(blob))
                    add_domains(txt, os.path.basename(info.filename))

    # ---------- 写 domains.txt ----------
    dom_path = os.path.join(args.outdir, "domains.txt")
    with open(dom_path, "w", encoding="utf-8") as f:
        f.write("# APK 内提取的去重域名列表\n")
        f.write("# 格式：域名<TAB>出现来源（逗号分隔）\n")
        f.write("# 来源说明：assets 下文件名 = 来自该资产；lib/*.so 名 = 来自该原生库；classes.dex = 来自主 dex\n")
        for d in sorted(domain_sources):
            srcs = ",".join(sorted(domain_sources[d])[:6])
            f.write(f"{d}\t{srcs}\n")

    # ---------- 写 assets_inventory.md ----------
    md_path = os.path.join(args.outdir, "assets_inventory.md")
    with open(md_path, "w", encoding="utf-8") as f:
        w = f.write
        w("# APK assets 资产盘点\n\n")
        w(f"- 目标 APK：`{os.path.basename(args.apk)}`\n")
        w(f"- assets/ 条目总数：**{len(assets)}**，合计 **{sum(i.file_size for i in assets)/1048576:.1f} MB**\n")
        w(f"- 需关注文件数：**{len(watch)}**\n\n")

        w("## 1. 按类型分组\n\n")
        w("| 类型 | 数量 | 合计大小 |\n|---|---:|---:|\n")
        for gname, items in grouped.items():
            w(f"| {gname} | {len(items)} | {sum(i.file_size for i in items)/1024:.0f} KB |\n")

        w("\n## 2. 需关注文件清单（jar/dat/db/无扩展名/pem/keystore/js/html/bks/properties/license）\n\n")
        w("| 文件 | 大小 | file 魔数判定 | 文本? | 前几行/说明 |\n|---|---:|---|:--:|---|\n")
        for r in reports:
            if r["head"]:
                summary = " ⏎ ".join(h.replace("|", "\\|") for h in r["head"][:3])
            else:
                summary = r["extra"] or "—"
            w(f"| `{r['name']}` | {r['size']} B | {r['magic']} | {'是' if r['text'] else '否'} | {summary[:300]} |\n")

        w("\n## 3. 文本类关注文件的内容摘要\n\n")
        for r in reports:
            if r["text"] and r["head"]:
                w(f"### `{r['name']}`（{r['size']} B）\n\n```\n")
                for h in r["head"]:
                    w(h + "\n")
                w("```\n\n")

        w("\n## 4. 域名线索\n\n")
        w(f"去重后共 **{len(domain_sources)}** 个域名，完整列表见 `work/domains.txt`。\n\n")

        w("\n---\n\n")
        w("> 说明：本表只做静态魔数与字符串判定；`未知（熵≈8）` 表示高熵、疑加密的数据文件，"
          "其真实格式需要配合对应 SDK 的解密逻辑动态确认。\n")

    print(f"[完成] 已写出：\n  {md_path}\n  {dom_path}")
    print(f"[统计] assets {len(assets)} 条；关注文件 {len(watch)} 个；域名 {len(domain_sources)} 个")
    return 0


def base_name(path: str) -> str:
    return os.path.basename(path)


if __name__ == "__main__":
    raise SystemExit(main())
