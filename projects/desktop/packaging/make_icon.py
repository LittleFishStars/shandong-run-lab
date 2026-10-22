#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""生成应用图标（packaging/icon.png + icon.ico）

图标是确定性绘制的：同一份代码任何机器上跑出来都一样，方便进仓库。
图形语义：渐变底 + 一条白色折线路径 + 起点/途经/终点三个节点 —— 就是「跑步路线」。

    python packaging/make_icon.py          # 重新生成
"""
from __future__ import annotations

from pathlib import Path

from PIL import Image, ImageDraw

HERE = Path(__file__).resolve().parent
SIZE = 1024
C1 = (34, 211, 166)      # 左上：#22D3A6
C2 = (5, 150, 105)       # 右下：#059669


def _gradient(size: int) -> Image.Image:
    """左上 → 右下 的线性渐变（用很小的图算再放大，省时间）"""
    small = Image.new("RGB", (64, 64))
    px = small.load()
    for y in range(64):
        for x in range(64):
            t = (x + y) / 126.0
            px[x, y] = tuple(int(a + (b - a) * t) for a, b in zip(C1, C2))
    return small.resize((size, size), Image.BICUBIC)


def _rounded_mask(size: int, radius: int) -> Image.Image:
    mask = Image.new("L", (size, size), 0)
    ImageDraw.Draw(mask).rounded_rectangle([0, 0, size - 1, size - 1], radius=radius, fill=255)
    return mask


def build() -> Image.Image:
    base = Image.new("RGBA", (SIZE, SIZE), (0, 0, 0, 0))
    grad = _gradient(SIZE).convert("RGBA")
    base.paste(grad, (0, 0), _rounded_mask(SIZE, int(SIZE * 0.215)))

    d = ImageDraw.Draw(base)
    # 路线：左下起 → 上折 → 右上终点（坐标按 1024 画布设计）
    pts = [(250, 700), (250, 470), (400, 330), (620, 330), (770, 470), (770, 700), (600, 790)]
    width = 46
    d.line(pts, fill=(255, 255, 255, 235), width=width, joint="curve")
    for p in (pts[0], pts[-1]):                       # 两端补圆头
        r = width // 2
        d.ellipse([p[0] - r, p[1] - r, p[0] + r, p[1] + r], fill=(255, 255, 255, 235))

    # 节点：起点实心、途经空心、终点实心带内洞
    def node(p, filled: bool, radius: int = 46):
        x, y = p
        if filled:
            d.ellipse([x - radius, y - radius, x + radius, y + radius],
                      fill=(255, 255, 255, 255))
            d.ellipse([x - radius // 2, y - radius // 2, x + radius // 2, y + radius // 2],
                      fill=C2 + (255,))
        else:
            d.ellipse([x - radius, y - radius, x + radius, y + radius],
                      outline=(255, 255, 255, 255), width=22)

    node(pts[0], True)
    node(pts[2], False, 34)
    node(pts[-1], True)
    return base


def main() -> int:
    icon = build()
    png = HERE / "icon.png"
    ico = HERE / "icon.ico"
    icon.resize((512, 512), Image.LANCZOS).save(png, "PNG")
    icon.save(ico, sizes=[(256, 256), (128, 128), (64, 64), (48, 48), (32, 32), (16, 16)])
    print(f"✓ {png}")
    print(f"✓ {ico}")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
