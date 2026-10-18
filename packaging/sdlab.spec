# -*- mode: python ; coding: utf-8 -*-
"""PyInstaller 打包描述（Linux / Windows 共用一份）

由 `scripts/build_bin.py` 调用：

    pyinstaller packaging/sdlab.spec --distpath dist --workpath build/pyi --noconfirm

要点：
  · web/ 与两个自检脚本作为「数据文件」塞进包内（运行期通过 sys._MEIPASS 找）；
  · 装在同一环境里的 pywebview 会自动打进来（有真实桌面窗口），没装就降级成
    本地 HTTP + 浏览器，功能一致；
  · Windows 下读 packaging/version_info.txt（构建脚本按 __version__ 生成）写文件属性；
  · SDLAB_ONEDIR=1 时切成多文件目录模式（排错用，发布件仍是单文件）。
"""
import os
import sys
from pathlib import Path

from PyInstaller.utils.hooks import collect_data_files, collect_submodules

ROOT = Path(SPECPATH).parent          # 仓库根目录
HERE = Path(SPECPATH)                 # packaging/
ONEDIR = os.environ.get("SDLAB_ONEDIR", "") not in ("", "0", "false", "False")

# ── 数据文件 ────────────────────────────────────────────────
datas = [
    (str(ROOT / "web"), "web"),                      # 前端（含 vendor/leaflet）
    (str(ROOT / "scripts" / "selfcheck.py"), "scripts"),
    (str(ROOT / "scripts" / "webcheck.py"), "scripts"),
]

# ── 可选桌面壳 ──────────────────────────────────────────────
# pywebview 的后端是运行期动态 import 的，静默分析看不到；构建环境里有它才收集。
# 只在 Windows 上带：Linux 的 pywebview 后端会拖进整套 GTK（gi/gdk-pixbuf/图标主题
# 上 ~100 MB），而目标机又不一定有 WebKitGTK 匹配版本——Linux 发布件直接走
# 「本地 HTTP + 浏览器」，功能一样（gui.run_desktop 自带降级）。
import sys as _sys  # noqa: E402

IS_WIN = _sys.platform == "win32"
hiddenimports = []
if IS_WIN:
    try:
        import webview  # noqa: F401

        hiddenimports += collect_submodules("webview")
        datas += collect_data_files("webview")       # pywebview 的 js/ 与 lib/ 资源
        hiddenimports += ["clr", "pythonnet"]        # winforms 后端走 .NET
    except Exception:                                # noqa: BLE001
        pass

# ── 瘦身：这些模块 sdlab 用不到，却常被第三方包连带拖进来 ─────
excludes = [
    "tkinter", "unittest", "pydoc_data", "pytest", "test",
    "PyQt5", "PyQt6", "PySide2", "PySide6", "matplotlib", "numpy", "pandas",
    "scipy", "IPython", "jupyter", "notebook", "setuptools", "pip",
    # GTK/GI 全家桶：跟着 pywebview 的 Linux 后端混进来时能胖 100 MB
    "gi", "gtk", "cairo", "pkg_resources", "gevent",
    # 密码学：ciphers.py 优先用 pycryptodome，cryptography 只是第二候选；
    # 留双份后端会让单文件多 14 MB，这里只带前者。
    "cryptography",
]
if not IS_WIN:
    excludes += ["webview", "clr", "httpcore", "h11"]

a = Analysis(
    [str(HERE / "launcher.py")],
    pathex=[str(ROOT)],
    binaries=[],
    datas=datas,
    hiddenimports=hiddenimports,
    hookspath=[],
    hooksconfig={},
    runtime_hooks=[],
    excludes=excludes,
    noarchive=False,
)

pyz = PYZ(a.pure)

version_file = HERE / "version_info.txt"
exe_kwargs = dict(
    name="sdlab",
    debug=False,
    bootloader_ignore_signals=False,
    strip=False,
    upx=False,
    console=True,                 # 同一份 exe 既是 CLI 也是 GUI，保留控制台
    disable_windowed_traceback=False,
    argv_emulation=False,
    target_arch=None,
    codesign_identity=None,
    entitlements_file=None,
)

if sys.platform == "win32":
    if (HERE / "icon.ico").exists():
        exe_kwargs["icon"] = str(HERE / "icon.ico")
    if version_file.exists():
        exe_kwargs["version"] = str(version_file)
elif sys.platform.startswith("linux") and (HERE / "icon.png").exists():
    exe_kwargs["icon"] = str(HERE / "icon.png")

if ONEDIR:
    exe = EXE(pyz, a.scripts, [], exclude_binaries=True, **exe_kwargs)
    coll = COLLECT(exe, a.binaries, a.datas, strip=False, upx=False, name="sdlab")
else:
    exe = EXE(pyz, a.scripts, a.binaries, a.datas, [], **exe_kwargs)
