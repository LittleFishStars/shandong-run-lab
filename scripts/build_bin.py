#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""把 sdlab 打成单文件可执行程序（Linux / Windows 同一套流程）

    python scripts/build_bin.py                # 当前平台，单文件，产物 dist/sdlab-<版本>-<系统>-<架构>
    python scripts/build_bin.py --zip          # 额外压成 .zip（发布用）
    python scripts/build_bin.py --onedir       # 多文件目录（排错用，不发布）
    python scripts/build_bin.py --skip-smoke   # 跳过构建后的冒烟测试

做完的事：
  1. 检查 PyInstaller（缺了直接给安装命令）；
  2. Windows 下按 `sdlab.__version__` 生成文件属性（版本号/产品名/版权）；
  3. 调 packaging/sdlab.spec 构建（web/ 与自检脚本会被塞进包里）；
  4. 产物改名成带平台/架构的名字，跑 `--version` / `info` 冒烟；
  5. 打印体积与 SHA256，`--zip` 时连同 SHA256SUMS 一起落盘。

Windows 上的构建在 GitHub Actions 里做（见 .github/workflows/build-release.yml），
本机是 Linux 时不要试图交叉编译。
"""
from __future__ import annotations

import argparse
import hashlib
import os
import platform
import shutil
import subprocess
import sys
import zipfile
from pathlib import Path

# Windows 的管道/重定向默认是 cp1252，中文与 ✓ 会直接抛 UnicodeEncodeError，先把输出钉成 UTF-8
for _stream in (sys.stdout, sys.stderr):
    try:
        _stream.reconfigure(encoding="utf-8", errors="replace")
    except Exception:                     # 没有 reconfigure（被重定向成别的对象）就算了
        pass

ROOT = Path(__file__).resolve().parent.parent
DIST = ROOT / "dist"
BUILD = ROOT / "build" / "pyinstaller"
SPEC = ROOT / "packaging" / "sdlab.spec"
VERSION_FILE = ROOT / "packaging" / "version_info.txt"

sys.path.insert(0, str(ROOT))
from sdlab import __version__ as VERSION  # noqa: E402


# ── 平台命名 ──────────────────────────────────────────────────
def platform_tag() -> str:
    if sys.platform == "win32":
        arch = platform.machine().lower()
        return "windows-" + ("x64" if arch in ("amd64", "x86_64") else arch)
    if sys.platform.startswith("linux"):
        arch = platform.machine().lower()
        arch = {"amd64": "x86_64", "aarch64": "arm64"}.get(arch, arch)
        return f"linux-{arch}"
    if sys.platform == "darwin":
        return f"macos-{platform.machine().lower()}"
    return f"{sys.platform}-{platform.machine().lower()}"


def exe_name() -> str:
    return "sdlab.exe" if sys.platform == "win32" else "sdlab"


# ── Windows 文件属性 ──────────────────────────────────────────
def write_version_info() -> None:
    """生成 PyInstaller 的版本资源（只在 Windows 上有意义，但生成无害）"""
    nums = [int(x) for x in (VERSION.split(".") + ["0", "0", "0", "0"])[:4]]
    tuple_str = "(" + ", ".join(str(n) for n in nums) + ")"
    text = f"""# UTF-8
VSVersionInfo(
  ffi=FixedFileInfo(
    filevers={tuple_str},
    prodvers={tuple_str},
    mask=0x3f,
    flags=0x0,
    OS=0x40004,
    fileType=0x1,
    subtype=0x0,
    date=(0, 0)
  ),
  kids=[
    StringFileInfo([
      StringTable('080404B0', [
        StringStruct('CompanyName', 'LittleFishStars'),
        StringStruct('FileDescription', '闪动校园·阳光跑工作台'),
        StringStruct('FileVersion', '{VERSION}'),
        StringStruct('InternalName', 'sdlab'),
        StringStruct('LegalCopyright', '个人学习与研究用途'),
        StringStruct('OriginalFilename', 'sdlab.exe'),
        StringStruct('ProductName', 'shandong-run-lab'),
        StringStruct('ProductVersion', '{VERSION}')
      ])
    ]),
    VarFileInfo([VarStruct('Translation', [2052, 1200])])
  ]
)
"""
    VERSION_FILE.write_text(text, encoding="utf-8")


# ── 构建 ──────────────────────────────────────────────────────
def ensure_pyinstaller() -> None:
    try:
        import PyInstaller  # noqa: F401
    except ImportError:
        print("✗ 没装 PyInstaller。安装：", file=sys.stderr)
        print(f"    {sys.executable} -m pip install pyinstaller", file=sys.stderr)
        raise SystemExit(2)


def run_pyinstaller(clean: bool) -> None:
    from PyInstaller.__main__ import run as pyi_run

    if clean:
        for p in (BUILD, DIST / "sdlab"):
            shutil.rmtree(p, ignore_errors=True)
    args = [
        str(SPEC),
        "--distpath", str(DIST),
        "--workpath", str(BUILD),
        "--noconfirm",
        "--clean",
        "--log-level", "WARN",
    ]
    print("› pyinstaller " + " ".join(args))
    pyi_run(args)


def finalize_name() -> Path:
    """把 dist/sdlab[.exe] 改成 dist/sdlab-<版本>-<平台>[.exe]"""
    src = DIST / exe_name()
    if not src.exists():
        raise SystemExit(f"✗ 构建没产出 {src}")
    suffix = ".exe" if sys.platform == "win32" else ""
    dst = DIST / f"sdlab-{VERSION}-{platform_tag()}{suffix}"
    dst.unlink(missing_ok=True)
    src.replace(dst)
    return dst


# ── 冒烟 ──────────────────────────────────────────────────────
def smoke(binary: Path) -> bool:
    """跑两条不碰网络、不写用户目录的命令，确认包能起得来"""
    ok_all = True
    home = ROOT / "build" / "smoke-home"
    env = dict(os.environ, SDLAB_HOME=str(home))
    common = ["--data-dir", str(home), "--config", str(home / "config.json")]
    for argv, expect in ((["--version"], "sdlab "), (["info", *common], "")):
        try:
            p = subprocess.run([str(binary), *argv], capture_output=True, timeout=180,
                               env=env, encoding="utf-8", errors="replace")
        except Exception as e:                                   # noqa: BLE001
            print(f"  ✗ {argv}: {type(e).__name__}: {e}")
            ok_all = False
            continue
        out = (p.stdout or "") + (p.stderr or "")
        good = p.returncode == 0 and expect in out
        print(f"  {'✓' if good else '✗'} {binary.name} {' '.join(argv)} → rc={p.returncode}"
              + ("" if good else f"\n{out.strip()[:800]}"))
        ok_all = ok_all and good
    return ok_all


def sha256(path: Path) -> str:
    h = hashlib.sha256()
    with path.open("rb") as f:
        for chunk in iter(lambda: f.read(1 << 20), b""):
            h.update(chunk)
    return h.hexdigest()


def make_zip(binary: Path) -> Path:
    zpath = Path(str(binary) + ".zip")
    readme = (
        f"闪动校园·阳光跑工作台 v{VERSION}（{platform_tag()}）\n"
        "\n"
        "运行方式：\n"
        "  双击      = 打开界面（本地 HTTP + 浏览器；装了 pywebview 则是原生窗口）\n"
        "  终端里用  = sdlab(.exe) --help        看全部命令\n"
        "              sdlab(.exe) run -d 2000   直接跑一次 2 公里\n"
        "              sdlab(.exe) --mode mock gui  纯本地仿真，不碰真实服务端\n"
        "\n"
        "数据目录：~/.local/share/shandong-run-lab（Windows: %LOCALAPPDATA%\\shandong-run-lab）\n"
        "配置文件：~/.config/shandong-run-lab（Windows: %APPDATA%\\shandong-run-lab）\n"
        "\n"
        "仅用于个人学习、协议研究与本地仿真调试。\n"
    )
    with zipfile.ZipFile(zpath, "w", zipfile.ZIP_DEFLATED) as z:
        z.writestr("README.txt", readme)
        z.write(binary, binary.name)
        ico = ROOT / "packaging" / "icon.ico"
        if ico.exists():
            z.write(ico, "icon.ico")
    return zpath


def main(argv: list[str] | None = None) -> int:
    ap = argparse.ArgumentParser(description="打包 sdlab 可执行文件")
    ap.add_argument("--onedir", action="store_true", help="多文件目录模式（不发布）")
    ap.add_argument("--zip", action="store_true", help="额外生成发布用 zip")
    ap.add_argument("--no-clean", action="store_true", help="保留上次的构建缓存")
    ap.add_argument("--skip-smoke", action="store_true", help="跳过构建后的冒烟测试")
    args = ap.parse_args(argv)

    ensure_pyinstaller()
    DIST.mkdir(parents=True, exist_ok=True)
    write_version_info()

    print(f"› 目标：sdlab {VERSION} / {platform_tag()} / {'onedir' if args.onedir else 'onefile'}")
    if args.onedir:
        os.environ["SDLAB_ONEDIR"] = "1"
    run_pyinstaller(clean=not args.no_clean)

    if args.onedir:
        out = DIST / "sdlab" / exe_name()
        print(f"✓ 目录产物：{out.parent}（{sum(p.stat().st_size for p in out.parent.rglob('*')) / 1e6:.1f} MB）")
        return 0

    binary = finalize_name()
    size_mb = binary.stat().st_size / 1e6
    print(f"✓ {binary}  {size_mb:.1f} MB")

    if not args.skip_smoke and not smoke(binary):
        print("✗ 冒烟测试没过", file=sys.stderr)
        return 1

    lines = [f"{sha256(binary)}  {binary.name}"]
    if args.zip:
        z = make_zip(binary)
        lines.append(f"{sha256(z)}  {z.name}")
        print(f"✓ {z}  {z.stat().st_size / 1e6:.1f} MB")

    sums = DIST / "SHA256SUMS"
    old = sums.read_text(encoding="utf-8").splitlines() if sums.exists() else []
    kept = [ln for ln in old if not ln.endswith(binary.name) and "sdlab-" not in ln]
    sums.write_text("\n".join(kept + lines) + "\n", encoding="utf-8")
    print("\n".join(lines))
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
