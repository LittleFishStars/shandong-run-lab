#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""离线破解 encodeRun 的算法（黑盒样本比对）。

运行时抓到的样本（见 work/oracle2_out.txt）：
    encodeRun('{"x":1}', '26101017', '8.7.7', 'A', 0) = 05017afe6ac20923b6ee765aa503ccb0
    encodeRun('{"x":1}', '26101017', '8.7.7', 'A', 1) = d50261b552022a6a2ac2d7fd8dd05bd3
    encodeRun('',        '26101017', '8.7.7', 'A', 0) = b214b94f429ec0fb54cb08487df5583b
    encodeRun('a',       '26101017', '8.7.7', 'A', 0) = 1427f4ef3b283e88ca2f4c7349566836
    encodeRun('a',       '',         '',      '', 0) = 8233e43470579ae9f0a581da8cdc7706
    encodeRun('a',       '1',        '2',     '3', 0) = 1ad3dd1ef9e043ed81733362911c497e

输出恒为 32 字符 hex（16 字节），符合 MD5/SM3-截断 特征。
本脚本用「已知明文 + 已知算法 + 拼接方式穷举」来验证是哪种。
"""

from __future__ import annotations

import hashlib
import itertools
import sys

# ── 黑盒样本（入参 5 元组 → 期望输出）──
SAMPLES = [
    (('{"x":1}', '26101017', '8.7.7', 'A', '0'), '05017afe6ac20923b6ee765aa503ccb0'),
    (('{"x":1}', '26101017', '8.7.7', 'A', '1'), 'd50261b552022a6a2ac2d7fd8dd05bd3'),
    (('', '26101017', '8.7.7', 'A', '0'), 'b214b94f429ec0fb54cb08487df5583b'),
    (('a', '26101017', '8.7.7', 'A', '0'), '1427f4ef3b283e88ca2f4c7349566836'),
    (('a', '', '', '', '0'), '8233e43470579ae9f0a581da8cdc7706'),
    (('a', '1', '2', '3', '0'), '1ad3dd1ef9e043ed81733362911c497e'),
]

SEPS = ['', '&', '|', ',', '.', '-', '_', ':', ';', '/', '\n', '#', '@', '=', '+']


def digests(data: bytes) -> dict[str, str]:
    out = {
        'md5': hashlib.md5(data).hexdigest(),
        'sha1_16': hashlib.sha1(data).hexdigest()[:32],
        'sha256_16': hashlib.sha256(data).hexdigest()[:32],
        # SM3 不在标准库，若装了 gmssl 则补上
    }
    try:
        from gmssl import sm3, func
        out['sm3'] = sm3.sm3_hash(func.bytes_to_list(data))
        out['sm3_16'] = out['sm3'][:32]
    except ImportError:
        pass
    return out


def main() -> int:
    print("=" * 70)
    print("encodeRun 算法黑盒求解")
    print("=" * 70)
    print(f"样本数: {len(SAMPLES)}，输出长度: 32 hex = 16 字节\n")

    # 候选拼接方式：全排列 5 个字段 × 分隔符
    perms = list(itertools.permutations(range(5)))
    print(f"尝试: {len(perms)} 种字段顺序 × {len(SEPS)} 种分隔符 "
          f"× 多种摘要算法")

    algo_ok: dict[str, list[tuple]] = {}
    tested = 0

    for perm in perms:
        for sep in SEPS:
            blocks = []
            for sample, expect in SAMPLES:
                parts = [sample[i] for i in perm]
                joined = sep.join(parts).encode('utf-8')
                blocks.append((joined, expect))

            # 用第一个样本快速筛掉绝大多数组合
            first_data, first_expect = blocks[0]
            for algo, h in digests(first_data).items():
                if h != first_expect:
                    continue
                tested += 1
                # 命中：用其余样本验证
                allok = True
                for data, expect in blocks[1:]:
                    if digests(data).get(algo) != expect:
                        allok = False
                        break
                if allok:
                    algo_ok.setdefault(algo, []).append((perm, sep))

    print(f"（初筛命中 {tested} 次）\n")
    if not algo_ok:
        print("✗ 未找到「字段顺序 + 分隔符 + 标准摘要」的匹配")
        print("  → 说明其中含有非常量成分（盐/密钥/前缀），或用了非标准算法")
        print("\n下一步建议：")
        print("  · 检查 liby.so 中的 MD5/SM3 常量（IV 表）")
        print("  · 或用 Frida hook liby.so 内部的 md5 更新函数抓原始输入")
        return 1

    for algo, hits in algo_ok.items():
        print(f"★ 算法 = {algo}")
        for perm, sep in hits[:10]:
            print(f"    字段顺序 = {perm}   分隔符 = {sep!r}")
        print()
    return 0


if __name__ == "__main__":
    sys.exit(main())
