# -*- coding: utf-8 -*-
"""让 `python -m shandong_school_cracked` 直接可用（等价于 `python -m shandong_school_cracked.cli`）"""
from __future__ import annotations

import sys

from .cli import main

if __name__ == "__main__":
    sys.exit(main())
