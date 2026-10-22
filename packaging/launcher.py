#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""PyInstaller 的入口脚本

打包器会把它当成顶层 `__main__` 执行，此时相对导入（`from .cli import main`）
会因为不在包里而失败，所以单独放一个绝对导入的薄壳。
源码运行时一切照旧用 `python -m shandong_school_cracked`。
"""
from __future__ import annotations

import sys

from shandong_school_cracked.cli import main

if __name__ == "__main__":
    sys.exit(main())
