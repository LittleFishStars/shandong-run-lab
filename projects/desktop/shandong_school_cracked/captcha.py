#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""滑块验证码求解（AJ-Captcha blockPuzzle）

客户端登录链路第二、三步（报告 15）：
    ② POST captcha/get    {"captchaType":"blockPuzzle"} → secretKey / token / 图片
    ③ POST captcha/check  {"pointJson":<AES-128-ECB>, "token"} → result:true

求解流程：
    1. 取背景图（originalImageBase64 或 OSS 直链）与模板图（jigsawImageBase64）
    2. 在背景图上做灰度模板匹配，得到缺口最左侧 x（原始像素坐标）
    3. 按协议补偿：x' = int(x - 6.5) + 16.5，再 AES-128-ECB 加密成 pointJson

★ 不依赖 OpenCV：用 PIL + 纯 Python 滑动窗口 SAD 匹配，精度足够且零编译依赖。
"""
from __future__ import annotations

import base64
import io
from typing import Any, Dict, Optional, Tuple

from . import crypto

try:
    from PIL import Image  # type: ignore

    _HAS_PIL = True
except Exception:  # pragma: no cover
    _HAS_PIL = False


# ══════════════════ 图像载入 ══════════════════
def _decode_image(data: Any) -> Optional[bytes]:
    """接受 base64 字符串（可能是 data URI）或 bytes，统一返回二进制"""
    if data is None:
        return None
    if isinstance(data, (bytes, bytearray)):
        return bytes(data)
    s = str(data)
    if s.startswith("data:image"):
        s = s.split(",", 1)[-1]
    try:
        return base64.b64decode(s)
    except Exception:
        return None


def _to_gray(image_bytes: bytes):
    """PIL 图像 → 灰度二维列表（numpy 数组或 list of list）"""
    img = Image.open(io.BytesIO(image_bytes)).convert("L")
    return img


def solve_slider_notch(bg_bytes: bytes, template_bytes: bytes) -> Tuple[float, float]:
    """定位缺口，返回 (x, y)，单位是背景图的原始像素。

    x = 拼图块左边缘在背景图里的横坐标；y 仅为参考值（真实提交时由 H5 写死 15）。

    实现要点（对齐 H5 CaptchaVerifyPage 与 8.7.2 参考实现）：
      · 拼图块是 RGBA，必须先用 alpha 通道 bbox 裁出真实缺口形状，
        否则透明像素会把 SAD 拉到均匀值上；
      · 必须在**全图二维**上搜索（8.7.2 参考实现先用 alpha 行位置限带，
        但限带对系统图不总成立，全图搜索更稳且代价可接受）；
      · 评分用灰度 SAD（绝对差之和），越小越像。
    """
    if not _HAS_PIL:
        raise RuntimeError("缺少 Pillow，无法求解滑块验证码")

    bg_img = Image.open(io.BytesIO(bg_bytes))
    tp_img = Image.open(io.BytesIO(template_bytes))

    # 透明边裁切：拼图块只有 alpha>0 的部分才是真正的缺口形状。
    # 拼图块画在与背景图等高的画布上，所以 alpha bbox 的 top 就是缺口的纵坐标
    # ——这是 8.7.2 参考实现「限带搜索」的依据，能把误匹配降一个数量级。
    y_hint = None
    if tp_img.mode in ("RGBA", "LA"):
        alpha = tp_img.getchannel("A")
        box = alpha.point(lambda v: 255 if v > 16 else 0).getbbox()
        if box:
            y_hint = int(box[1])
            tp_img = tp_img.crop(box)
    tp_gray = tp_img.convert("L")
    bg_gray = bg_img.convert("L")

    tw, th = tp_gray.size
    bw, bh = bg_gray.size
    if tw >= bw or th >= bh:
        raise RuntimeError(f"拼图块({tw}x{th})不小于背景图({bw}x{bh})，图像异常")

    max_y = bh - th
    if y_hint is not None:
        y0 = max(0, min(max_y, y_hint - 4))
        y1 = max(0, min(max_y, y_hint + 4))
    else:
        y0, y1 = 0, max_y

    try:
        import numpy as np                     # 有 numpy 时走向量化，毫秒级
        b = np.asarray(bg_gray, dtype=np.int16)
        t = np.asarray(tp_gray, dtype=np.int16)
        win = np.lib.stride_tricks.sliding_window_view(b, (th, tw))[y0:y1 + 1]
        diff = np.abs(win - t).sum(axis=(2, 3))
        iy, ix = np.unravel_index(int(np.argmin(diff)), diff.shape)
        return float(ix), float(iy + y0)
    except Exception:
        pass
        pass

    # 纯 Python 回退：上限必须减去模板尺寸，否则会越界（曾导致 IndexError）
    bpx, tpx = bg_gray.load(), tp_gray.load()
    max_x, max_y = bw - tw, bh - th
    best_x, best_y, best_score = 0.0, 0.0, float("inf")
    for y in range(y0, y1 + 1):
        for x in range(0, max_x + 1):
            score = 0
            for ty in range(0, th, 2):
                row_b, row_t = y + ty, ty
                for tx in range(0, tw, 2):
                    d = bpx[x + tx, row_b] - tpx[tx, row_t]
                    score += d if d >= 0 else -d
            if score < best_score:
                best_score, best_x, best_y = float(score), float(x), float(y)
    return best_x, best_y


# ══════════════════ 求解器 ══════════════════
class CaptchaSolver:
    """一次滑块验证的完整流程封装"""

    def __init__(self, transport, bus=None, verbose: bool = False):
        self.transport = transport
        self.bus = bus
        self.verbose = verbose
        self.last: Dict[str, Any] = {}

    def _log(self, msg: str, level: str = "info") -> None:
        if self.bus:
            self.bus.emit("log", msg, level=level)
        elif self.verbose:
            print(msg)

    # ── 取图 ──
    def get(self) -> Optional[Dict[str, Any]]:
        body = {"captchaType": "blockPuzzle"}
        res = self.transport.post_raw(f"{self.transport.base_url}/captcha/get", body,
                                      v="get", api="captcha", h5=True)
        if res.get("code") != 0:
            self._log(f"✗ captcha/get 失败：{res.get('message')}", "error")
            return None
        data = res.get("data") or {}
        rep = data.get("repData") or data
        self.last = rep
        self._log(f"✓ 验证码已获取 token={str(rep.get('token'))[:16]}… "
                  f"secretKey={str(rep.get('secretKey'))[:8]}…")
        return rep

    # ── 下载图像 ──
    def fetch_images(self, data: Dict[str, Any]) -> Tuple[Optional[bytes], Optional[bytes]]:
        bg_raw = (data.get("originalImageBase64") or data.get("backgroundImage")
                  or data.get("originalImage"))
        tp_raw = (data.get("jigsawImageBase64") or data.get("templateImage")
                  or data.get("jigsawImage"))
        bg = _decode_image(bg_raw)
        tp = _decode_image(tp_raw)
        if bg is None and data.get("originalImageUrl"):
            url = data.get("originalImageUrl") or data.get("backgroundImageUrl")
            if url:
                bg = self.transport.download(url)
        if tp is None and (data.get("jigsawImageUrl") or data.get("templateImageUrl")):
            tp = self.transport.download(data.get("jigsawImageUrl") or data.get("templateImageUrl"))
        if bg and self.bus:
            self.bus.emit("captcha_image", "验证码图片", background=_b64_png(bg), template=_b64_png(tp))
        return bg, tp

    # ── 求解 + 校验 ──
    def solve(self, data: Dict[str, Any]) -> Tuple[bool, Optional[str], float]:
        bg, tp = self.fetch_images(data)
        if not bg or not tp:
            self._log("✗ 验证码图片缺失（服务端可能只给了 URL 或结构有变）", "error")
            return False, None, 0.0
        try:
            x, y = solve_slider_notch(bg, tp)
        except Exception as e:
            self._log(f"✗ 缺口定位失败：{e}", "error")
            return False, None, 0.0
        # H5 的明文固定是 {"x": 缺口x+10, "y": 15}：y 写死 15，
        # 求解得到的 y 不参与提交（见 CaptchaVerifyPage 的 `{x:I, y:5+10}`）。
        self._log(f"✓ 缺口定位 x={x:.0f}（求解 y={y:.0f}，提交 y=15）")
        point = crypto.encrypt_slider_point(x)
        return True, point, x

    def check(self, token: str, point: str) -> bool:
        body = {"captchaType": "blockPuzzle", "pointJson": point, "token": token}
        res = self.transport.post_raw(f"{self.transport.base_url}/captcha/check", body,
                                      v="check", api="captcha", h5=True)
        ok = bool(((res.get("data") or {}).get("result")) is True) or res.get("code") == 0 and \
            (res.get("data") or {}).get("result", False) is True
        if self.bus:
            self.bus.emit("log", f"{'✓' if ok else '✗'} captcha/check → {res.get('message')}",
                          level="info" if ok else "warn")
        return ok

    def run(self, attempts: int = 4) -> Tuple[bool, Optional[str], Dict[str, Any]]:
        """完整跑一遍：取图 → 定位 → 校验；返回 (是否通过, pointJson, 原始数据)

        ★ `captcha/check` 每调用一次就**消耗掉该 token**（服务端校验后即失效），
        所以失败重试必须重新 `captcha/get` 拿新挑战，不能在同一个 token 上换
        坐标重试——那正是早期「全 x 扫描零命中」的根因。
        """
        last: Dict[str, Any] = {}
        for i in range(max(1, int(attempts))):
            data = self.get()
            if not data:
                return False, None, last
            last = data
            ok, point, x = self.solve(data)
            if not ok or point is None:
                continue
            if self.check(str(data.get("token", "")), point):
                return True, point, {**data, "_notch_x": x, "_attempts": i + 1}
        return False, None, last


def _b64_png(raw: Optional[bytes]) -> str:
    if not raw:
        return ""
    return "data:image/png;base64," + base64.b64encode(raw).decode("ascii")


# ══════════════════ 离线自检用：合成一张验证码 ══════════════════
def synth_captcha(width: int = 280, height: int = 155, notch_x: int = 120,
                  notch_y: int = 40, size: int = 48, seed: int = 1) -> Tuple[bytes, bytes, int]:
    """合成 AJ-Captcha 风格背景图 + 模板图（用于离线调试与单元测试）

    返回 (背景图 PNG, 模板图 PNG, 真实缺口 x)。**仅测试用**，不参与真实登录。
    """
    if not _HAS_PIL:
        raise RuntimeError("缺少 Pillow，无法合成验证码")
    import random

    rng = random.Random(seed)
    bg = Image.new("RGB", (width, height), (30, 34, 44))
    px = bg.load()
    for y in range(height):                       # 噪声底纹
        for x in range(width):
            n = rng.randint(0, 28)
            px[x, y] = (30 + n, 34 + n, 44 + n)
    for i in range(6):                            # 几条干扰线
        y0 = rng.randint(0, height - 1)
        for x in range(width):
            y = min(height - 1, max(0, y0 + int(12 * __import__("math").sin(x / 17.0 + i))))
            px[x, y] = (200, 200, 210)

    # 抠出缺口（涂成背景色）——真实协议里缺口就是背景上的一块「空白」
    hole = Image.new("RGB", (size, size), (18, 20, 26))
    hpx = hole.load()
    for y in range(size):
        for x in range(size):
            if 4 <= x < size - 4 and 4 <= y < size - 4:
                hpx[x, y] = px[notch_x + x, notch_y + y]
    bg.paste(hole, (notch_x, notch_y))

    # 模板图：缺口形状的拼图块（带边缘留白）
    tmpl = Image.new("RGB", (size, size), (255, 255, 255))
    tpx = tmpl.load()
    for y in range(size):
        for x in range(size):
            inside = 4 <= x < size - 4 and 4 <= y < size - 4
            tpx[x, y] = (18, 20, 26) if inside else (255, 255, 255)

    b = io.BytesIO(); bg.save(b, "PNG")
    t = io.BytesIO(); tmpl.save(t, "PNG")
    return b.getvalue(), t.getvalue(), notch_x
