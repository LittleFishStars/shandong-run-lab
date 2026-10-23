"""启动检查更新：对比 GitHub Releases 的最新 tag 与本地版本（只提示，不强制）

- 默认查 api.github.com 的 latest release；可用环境变量 SDLAB_UPDATE_API 覆盖（自测/镜像用）。
- 网络不可用、限流、JSON 异常都静默返回 ok=False，绝不打断启动。
"""
from __future__ import annotations

import json
import os
import re
import urllib.request
from typing import Any, Dict, Tuple

REPO = "LittleFishStars/shandong-school_cracked"
DEFAULT_API = f"https://api.github.com/repos/{REPO}/releases/latest"


def current_version() -> str:
    from . import __version__
    return str(__version__)


def version_tuple(v: str) -> Tuple[int, int, int]:
    nums = re.findall(r"\d+", str(v or ""))
    if not nums:
        return (0, 0, 0)
    parts = [int(x) for x in nums[:3]]
    while len(parts) < 3:
        parts.append(0)
    return tuple(parts)  # type: ignore[return-value]


def check_update(timeout: float = 6.0) -> Dict[str, Any]:
    """检查最新发布版；有新版本时 has_update=True（不下载、不替换任何文件）"""
    cur = current_version()
    api = os.environ.get("SDLAB_UPDATE_API") or DEFAULT_API
    out: Dict[str, Any] = {
        "ok": False, "current": cur, "latest": "", "has_update": False,
        "url": "", "notes": "", "error": "",
    }
    try:
        req = urllib.request.Request(api, headers={
            "User-Agent": f"shandong-school_cracked/{cur}",
            "Accept": "application/vnd.github+json",
        })
        with urllib.request.urlopen(req, timeout=float(timeout)) as resp:
            data = json.loads(resp.read().decode("utf-8"))
    except Exception as exc:  # noqa: BLE001  启动时不打扰
        out["error"] = str(exc)[:200]
        return out
    if not isinstance(data, dict):
        out["error"] = "发布信息格式异常"
        return out
    tag = str(data.get("tag_name") or "").strip()
    latest = tag.lstrip("vV")
    out.update(ok=True, latest=latest,
               url=str(data.get("html_url") or ""),
               notes=str(data.get("body") or "")[:800])
    out["has_update"] = version_tuple(latest) > version_tuple(cur)
    return out
