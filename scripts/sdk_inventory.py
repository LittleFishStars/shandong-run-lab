#!/usr/bin/env python3
# -*- coding: utf-8 -*-
"""
sdk_inventory.py —— Android APK 原生库（.so）资产盘点与第三方 SDK 归属判定

用途
    直接以 zipfile 读取 APK 内的 lib/arm64-v8a/*.so，不落地解包整个 APK；
    对每个 .so 提取可打印字符串，用「关键字 -> SDK」映射表打分，
    依据证据判定该库属于哪个第三方 SDK。

设计要点
    1) 只做静态证据判定，不做猜测：证据分数低于阈值的库一律写「未确定」。
    2) 判定结果必须能被人工复核：输出的 md 表里带上命中的关键字（证据），
       json 里额外保留命中的具体字符串样本，便于后续深挖。
    3) 中文注释/输出。

用法
    python3 scripts/sdk_inventory.py                    # 默认读取工作目录下的 APK
    python3 scripts/sdk_inventory.py --apk xxx.apk
    python3 scripts/sdk_inventory.py --abi arm64-v8a     # 换 ABI
    python3 scripts/sdk_inventory.py --strings-limit 8000  # 每个库取前 N 条字符串

产出
    work/meta/sdk_inventory.md    人类可读表格（库文件名 | 大小 | 判定 SDK | 主要证据关键字）
    work/meta/sdk_inventory.json  机器可读（含每条证据的原始字符串样本）
"""

from __future__ import annotations

import argparse
import json
import os
import re
import sys
import zipfile
from collections import OrderedDict

# ---------------------------------------------------------------------------
# 一、字符串提取
# ---------------------------------------------------------------------------

# 连续可打印 ASCII 片段（长度由调用方控制），用于近似 strings 的效果
_PRINTABLE_RE = re.compile(rb"[\x20-\x7e]{6,}")

# 各 SDK 的编译工具链/标准库样板串，命中它们没有任何区分度，统一在证据里过滤掉，
# 避免「libc.so / Android clang version」这类噪声把分数带偏。
NOISE_PATTERNS = [
    re.compile(r"^Android \("),
    re.compile(r"^clang version"),
    re.compile(r"^Linker: LLD"),
    re.compile(r"^GCC: \(GNU\)"),
    re.compile(r"^\.(comment|gnu|note|dynsym|dynstr|symtab|strtab|shstrtab)"),
    re.compile(r"^_ZN?[0-9]"),
    re.compile(r"^(libc|libdl|liblog|libm|libz|libstdc\+\+|libunwind|libandroid|libjnigraphics)\.so$"),
    re.compile(r"^/?(apex|system|vendor|data)/"),
    re.compile(r"^(__|_edata|_end)"),
    re.compile(r"^[\s\x20]*$"),
]


def is_noise(s: str) -> bool:
    """判断一个字符串是否为无区分度的样板串。"""
    return any(p.search(s) for p in NOISE_PATTERNS)


def extract_strings(blob: bytes, limit: int) -> list[str]:
    """从一个二进制 buffer 里提取可打印字符串（长度 >= 6，取前 limit 条）。"""
    out: list[str] = []
    for m in _PRINTABLE_RE.finditer(blob):
        out.append(m.group().decode("ascii", "replace"))
        if len(out) >= limit:
            break
    return out


# ---------------------------------------------------------------------------
# 二、关键字 -> SDK 映射表
# ---------------------------------------------------------------------------
# 结构：SDK 名称 -> (类别, [(关键字, 权重), ...])
#
# 权重约定：
#   10 = 强指纹（厂商独有的类名/域名/导出符号，几乎不可能误判）
#    6 = 中等指纹（厂商独有但可能被别的库引用）
#    3 = 弱指纹（通用词，只能作为辅助）
# 关键字一律小写，采用「子串包含」匹配（不区分大小写）。
#
# 判定规则：同一 SDK 的所有命中关键字权重求和；对每个 .so 取分数最高的 SDK；
#          最高分 < SCORE_THRESHOLD 则判定为「未确定」。
SDK_RULES: "OrderedDict[str, tuple[str, list[tuple[str, int]]]]" = OrderedDict([
    # ---------------- 应用自身框架 ----------------
    ("Flutter (Google) —— 应用 UI 框架本身", ("应用框架", [
        ("libflutter.so", 10), ("flutter engine", 10), ("dart_", 6),
        ("dartbug.com", 8), ("flutter.io", 6), ("snapshot_", 3),
        ("skia", 3), ("impeller", 6),
    ])),
    ("Dart AOT 应用代码（com.huachenjie.shandong_school）", ("应用自身", [
        ("api.huachenjie.com", 10), ("dev.huachenjie.com", 10),
        ("huachenjie", 8), ("shandong_school", 8),
        ("flutter_assets", 6), ("dart.io", 4),
    ])),
    ("LLVM libc++ 运行库（开源基础库）", ("基础库", [
        ("libc++_shared.so", 10), ("libc++abi", 6), ("__ndk1_shared", 4),
    ])),
    ("Facebook Fresco 图片库（com.facebook.imagepipeline）", ("图片", [
        ("com/facebook/imagepipeline", 10), ("nativePinBitmap", 8),
        ("nativeReleaseByteBuffer", 8), ("imagepipeline", 6),
    ])),
    ("Android Glide WebP 解码器（bumptech）", ("图片", [
        ("com/bumptech/glide", 10), ("glide", 6), ("webpdecoder", 6),
    ])),
    ("SoundTouch 音频变速/变调（开源，Olli Parviainen）", ("音频", [
        ("soundtouch", 10), ("soundtouch::", 8), ("rate transposer", 8),
        ("samplerate", 3),
    ])),

    # ---------------- 地图 / 定位 ----------------
    ("高德地图 SDK (AMap) v9.5.0", ("地图", [
        ("libamapsdk_map", 10), ("amap.com", 8), ("mps.amap.com", 10),
        ("mapcore.com", 6), ("amap", 6), ("com/autonavi", 10),
        ("gnavimap", 8),
    ])),
    ("百度地图 SDK v7.6.3", ("地图", [
        ("libbaidumapsdk_base", 10), ("baidu map", 8), ("baidumapsdk", 10),
        ("com/baidu/mapapi", 8),
    ])),
    ("百度定位 SDK (Baidu Location)", ("地图", [
        ("com/baidu/location", 10), ("com/baidu/serverloc", 10),
        ("liblocsdk", 10), ("baidu location", 8), ("fused_sdk", 6),
    ])),
    ("高德导航/离线地图资源（ae/GNaviConfig.xml 同源）", ("地图", [
        ("gnaviconfig", 8), ("gnavi", 6), ("3dlandscape", 6),
    ])),

    # ---------------- 人脸 / 机器学习 ----------------
    ("虹软 ArcSoft InspireFace 人脸识别", ("AI/人脸", [
        ("libinspireface", 10), ("com/insightface/sdk/inspireface", 10),
        ("inspireface", 8), ("arcsoft", 8), ("megatron", 6), ("pikachu", 6),
    ])),
    ("TensorFlow Lite (Google)", ("AI/推理", [
        ("tensorflowlite", 10), ("tensorflow", 8), ("tflite", 8),
        ("www.tensorflow.org", 8),
    ])),
    ("Google ML Kit 条码识别 (barhopper)", ("AI/条码", [
        ("libbarhopper", 10), ("barhopper", 10), ("barcode", 6),
        ("oqei5.prod.google.com", 10), ("mlkit", 8),
    ])),
    ("Google ML Kit 图像处理 (image_processing_util)", ("AI/图像", [
        ("image_processing_util_jni", 10), ("mlkit", 6), ("imagepipeline", 3),
    ])),

    # ---------------- 网易系 ----------------
    ("网易易盾 (NetEase Yidun) 加固/风控", ("安全/加固", [
        ("netease", 6), ("nished", 8), ("htprotect", 10),
        ("com/netease/htprotect", 10), ("necrash", 8),
        ("yidun", 10), ("libnesec", 8), ("libnethtprotect", 10),
    ])),
    ("网易易盾 音频风控 (ne_audio)", ("安全/加固", [
        ("libne_audio", 10), ("netease", 8), ("nist", 6),
    ])),
    ("网易云信 NIM (NetEase IM / nos.netease.com)", ("IM/推送", [
        ("nos.netease.com", 10), ("lbs.chatnos.com", 10),
        ("yunxin.163.com", 10), ("httpdns.yunxindns.com", 10),
        ("nim_keystore", 10), ("cacert", 4), ("chatnos", 8),
    ])),
    ("网易七鱼客服 (Qiyu)", ("客服", [
        ("qiyu", 10), ("libqiyu", 10), ("statistic.live.126.net", 10),
        ("7moor", 8),
    ])),
    ("网易内部 HTTPDNS / 高可用通道", ("网络", [
        ("high_available_android", 10), ("libhigh_available", 8),
        ("httpdns.yunxindns.com", 8),
    ])),

    # ---------------- 腾讯系 ----------------
    ("腾讯 MMKV 键值存储", ("基础库", [
        ("libmmkv", 10), ("mmkv", 8), ("com/tencent/mmkv", 10),
    ])),
    ("腾讯 WCDB 数据库", ("数据库", [
        ("libwcdb", 10), ("wcdb", 8), ("com/tencent/wcdb", 10),
    ])),
    ("腾讯 X5/TBS 浏览服务", ("WebView/内核", [
        ("libtbsdl", 10), ("tbsdl", 10), ("com/tencent/smtt", 10),
        ("tbs", 3),
    ])),
    ("腾讯优量汇 GDT 广告 SDK", ("广告", [
        ("com/qq/e/comm", 10), ("gdt", 6), ("gdtadv2", 10),
        ("gdt_plugin", 10), ("优量汇", 10),
    ])),
    ("腾讯 Bugly 崩溃上报（仅资源前缀命中）", ("崩溃监控", [
        ("bugly", 8), ("com/tencent/bugly", 10),
    ])),
    ("腾讯微信 OpenSDK", ("登录/分享", [
        ("com/tencent/mm/opensdk", 10), ("wxapifactory", 8), ("wechat", 6),
    ])),

    # ---------------- 字节跳动 / 穿山甲 ----------------
    ("字节跳动 穿山甲 Pangle 广告 SDK", ("广告", [
        ("com/bytedance/sdk/openadsdk", 10), ("pangle", 10),
        ("libpangle", 10), ("com/byakv", 10), ("ttencryptutils", 10),
        ("git.byted.org", 8), ("com/bytedance/sdk/djx", 10),
        ("tt_ugen", 8), ("libtt_ugen_layout", 10),
    ])),
    ("字节跳动 火山引擎 MobSec 安全 SDK", ("安全/加固", [
        ("com/volcengine/mobsec", 10), ("volcengine", 8), ("mobsec", 10),
    ])),
    ("字节跳动 抖动播放器 (ttmplayer)", ("播放器", [
        ("libttmplayer", 10), ("ttmplayer", 10), ("tiktok", 6),
    ])),

    # ---------------- 阿里巴巴 / 阿里云 ----------------
    ("阿里云日志服务 SLS", ("日志", [
        ("libsls_producer", 10), ("com/aliyun/sls", 10), ("sls_producer", 10),
        ("log.aliyuncs.com", 8), ("aliyun", 4),
    ])),
    ("阿里云视频 SDK（播放器/FFmpeg/Alivc）", ("播放器", [
        ("libalivcffmpeg", 10), ("alivc", 10), ("aliyun video", 8),
        ("com/aliyun/player", 10), ("alivideocert", 8), ("avmdl", 8),
    ])),
    ("阿里 淘宝播放器 / taobao player", ("播放器", [
        ("libtaobaoplayer", 10), ("taobaoplayer", 10), ("libtbplayer", 10),
        ("libtbffmpeg", 10), ("tbplayer", 10),
    ])),
    ("阿里百川 TLog 日志（com.alibaba.baichuan）", ("日志", [
        ("com/alibaba/baichuan", 10), ("baichuan", 8), ("tlog", 8),
        ("libbcmarsxlog", 10),
    ])),
    ("阿里 mPaaS / Alipay H5 容器 与 JS 引擎", ("WebView/内核", [
        ("com/alipay/mobile/jsengine", 10), ("alipayjsbridge", 10),
        ("h5_bridge_part", 10), ("ariver", 10), ("v8worker", 10),
        ("mppaas", 8), ("nebula", 6),
    ])),
    ("阿里 Weex / Windmill JS 运行时", ("WebView/内核", [
        ("com/taobao/weex", 10), ("com/taobao/windmill", 10),
        ("weex", 8), ("wmljs", 8),
    ])),
    ("阿里云统一接入（RTC/OSS/日志/AliDNS）", ("云服务", [
        ("aliyuncs.com", 8), ("rtc.aliyuncs.com", 10), ("alidns.com", 10),
        ("oss.aliyuncs.com", 8), ("all_in_one", 8),
    ])),
    ("阿里 聚安全 / 反作弊（阿里安全 SDK）", ("安全/加固", [
        ("aliamap", 3), ("jaliprotect", 8), ("securityguard", 8),
        ("com/alibaba/wireless", 10), ("aliagainstid", 10),
        ("alicheatparams", 10), ("aliagainstcheating", 10),
    ])),
    ("阿里 UC / 友盟 crashsdk native 崩溃采集", ("崩溃监控", [
        ("com/uc/crashsdk", 10), ("crashsdk", 8), ("ucrash", 8),
        ("batte ryinfo", 6),
    ])),

    # ---------------- 友盟 / GrowingIO ----------------
    ("友盟+ (Umeng) 统计 / U-APM", ("统计/APM", [
        ("libumeng-spy", 10), ("umeng", 10), ("com/umeng/crash", 10),
        ("com/efs/sdk", 10), ("efs.sdk", 8), ("u-apm", 8),
        ("com/efs/sdk/memleaksdk", 10), ("umonitor", 8),
    ])),
    ("GrowingIO 增长分析", ("统计/APM", [
        ("growease", 10), ("growingio", 10), ("grow.license", 10),
    ])),

    # ---------------- 快手系 ----------------
    ("快手（Kwai/Kuaishou）native 安全与性能组件", ("性能/安全", [
        ("com/kwai/", 10), ("com/kuaishou", 10), ("kuaishou", 10),
        ("kwai", 8), ("libplt-base", 10), ("xhook", 8),
        ("sgcore", 8), ("com/kwai/sgcore", 10), ("ti-monitor", 10),
        ("com/kwai/performance", 10),
    ])),
    ("快手广告 联盟 SDK（com.kwad）", ("广告", [
        ("com/kwad", 10), ("kwad", 10), ("ksvideoplayconfig", 10),
        ("ksloadmanager", 8),
    ])),
    ("快手 OpenSet / Nexus Deeplink 归因 SDK", ("广告/归因", [
        ("com/kc/openset", 10), ("nexussdk", 10), ("openset", 8),
        ("activateSession", 3), ("deeplink", 6),
    ])),

    # ---------------- 百度系 ----------------
    ("百度移动广告 SDK（百青藤 mobads）", ("广告", [
        ("com/baidu/mobads", 10), ("mobads", 10), ("expressinterstitialad", 8),
    ])),
    ("百度 mshield 安全 SDK / 设备指纹 gdid", ("安全/加固", [
        ("com/baidu/mshield", 10), ("mshield", 10),
        ("com/baidu/xclient/gdid", 10), ("gdid", 8),
        ("libtiny_magic", 10), ("daemonsu", 6),
    ])),

    # ---------------- 京东 ----------------
    ("京东 JADYun 广告 SDK", ("广告", [
        ("com/jd/ad", 10), ("jadyun", 10), ("jadsplash", 10),
    ])),

    # ---------------- 微博 ----------------
    ("新浪微博 SDK", ("登录/分享", [
        ("libweibosdkcore", 10), ("weibosdk", 10), ("com/sina/weibo", 10),
        ("libwbsafeedit", 10), ("safeedit", 8),
    ])),

    # ---------------- 虹软/其他广告聚合 ----------------
    ("倍孜 Beizi Fusion 广告聚合 SDK", ("广告", [
        ("com/beizi/fusion", 10), ("beizi", 10), ("devsysmark", 8),
    ])),
    ("SAAS ADX 广告 SDK（com.fl.saas.adx）", ("广告", [
        ("com/fl/saas", 10), ("fl.saas.adx", 10), ("com/fl/adx", 10),
        ("flupdatemark", 10), ("addoplusflags", 6),
    ])),
    ("趣盟/奇妙 advlib 广告 SDK（com.qm.advlib）+ InnoSecure 资源加密", ("广告", [
        ("com/qm/advlib", 10), ("qm/advlib", 10), ("innosecure", 10),
        ("com/inno/innosecure", 10), ("advlib", 8), ("libinno", 10),
    ])),
    ("海量广告 advlib（com.hailiang.advlib）", ("广告", [
        ("com/hailiang/advlib", 10), ("hailiang", 10), ("advlib", 6),
        ("alicheatparams", 8), ("libqmcheat", 10),
    ])),
    ("kc 广告联盟 SDK（com.kc.*）", ("广告", [
        ("com/kc/bw", 10), ("com/kc/cw", 10), ("com/kc/openset", 8),
        ("com.kc.bw", 10), ("com.kc.cw", 10), ("com.kc.openset", 8),
        ("kcbw", 8), ("kc_openset", 6),
    ])),
    ("zj 广告联盟 SDK（com.zj.*）", ("广告", [
        ("com/zj/zk", 10), ("com/zj/ad", 10), ("com/zj/zjsdkplug", 10),
        ("com.zj.zk", 10), ("com.zj.adsdk", 10), ("com.zj.zjsdkplug", 10),
        ("com.zj.zjdsp", 10), ("com/jx/ad", 8), ("com.jx.ad", 8),
        ("zjadso", 10), ("zjplayer", 10), ("jxad", 8),
        ("zjaliamap", 8), ("zjaliagainstid", 10),
    ])),
    ("lywm 广告联盟 SDK（com.ly.*/lywm）", ("广告", [
        ("lywm", 10), ("com/ly/", 8), ("lywmaliagainstid", 10),
    ])),
    ("octopus 广告聚合模块", ("广告", [
        ("com/octopus/ad", 10), ("octopus", 8), ("octopus_skip_ad", 10),
        ("liboctopus", 10),
    ])),
    ("JY 聚合广告 SDK（cn.jy.ad.sdk）", ("广告", [
        ("cn/jy/ad/sdk", 10), ("jyapi", 8), ("jyad_", 10),
        ("jy_run.jar", 8), ("jy.jar", 8),
    ])),
    ("ADX 广告插件（assets/AdxSdk, pan=com.zm.wfsdk）", ("广告", [
        ("adxsdk", 10), ("adxplayer", 10), ("adxsplashad", 10),
        ("com/zm/wfsdk", 10), ("kingrecordbean", 8),
    ])),
    ("ltmb / ltsdk 广告与安全模块", ("广告/安全", [
        ("com/ltmb/ltsdk", 10), ("ltsdk", 8), ("com/ltmb", 10),
        ("aesgcm", 4), ("libltmb", 10),
    ])),
    ("zm/wfsdk PhoneMark 设备指纹", ("安全/设备指纹", [
        ("com/zm/wfsdk/phonemark", 10), ("phonemark", 10),
        ("nativegetbootmark", 10), ("nativegetupdatemark", 10),
    ])),
    ("rc 设备指纹（com.rc.base.NativeHelper）", ("安全/设备指纹", [
        ("com/rc/base/nativehelper", 10), ("getsysbootmark", 10),
        ("getsysupdatemark", 10), ("librcad", 10),
    ])),

    # ---------------- 运营商一键登录 ----------------
    ("运营商一键登录 / UAID 取号 SDK（com.zx.sdk）", ("登录/认证", [
        ("com/zx/sdk", 10), ("zxid-m.mobileservice.cn", 10),
        ("msg.cmpassport.com", 10), ("id6.me", 10),
        ("nisportal.10010.com", 10), ("saidcallback", 10),
        ("libzxprotect", 10),
    ])),
    ("运营商 SS3RD 三方登录聚合", ("登录/认证", [
        ("osmss3rd", 10), ("libosmss3rd", 10), ("ss3rd", 8),
    ])),

    # ---------------- 加固 / 保护 ----------------
    ("OSET 加固保护（com.jiagu.sdk.OSETSDKProtected）", ("安全/加固", [
        ("osetsdkprotected", 10), ("oset-pine", 10), ("osetutil", 10),
        ("com/jiagu/sdk", 10), ("libjiagu", 10),
    ])),
    ("xCrash 系 native 崩溃转储（爱奇艺开源）", ("崩溃监控", [
        ("xcrash", 10), ("libxcrash_dumper", 10), ("xcrash_dumper", 10),
        ("htpcrash", 8), ("jxad", 6),
    ])),

    # ---------------- 网络诊断 ----------------
    ("网络诊断 / traceroute", ("网络工具", [
        ("traceroute", 10), ("whois.radb.net", 10), ("icmp", 4),
    ])),
    ("HTTPDNS / 网络加速", ("网络", [
        ("httpdns", 10), ("libdns", 6),
    ])),
])


SCORE_THRESHOLD = 8  # 最高分低于该值 => 判定「未确定」


def judge(evidence_text: str) -> tuple[str, int, list[str]]:
    """
    用映射表给一段字符串证据打分。

    返回 (判定 SDK 名, 最高分, 命中关键字列表)。
    如果没有 SDK 超过阈值，返回 ("未确定", 分数, 命中关键字) 以便人工复核。
    """
    low = evidence_text.lower()
    best_sdk, best_score, best_hits = "未确定", 0, []
    for sdk, (_cat, keywords) in SDK_RULES.items():
        score, hits = 0, []
        for kw, weight in keywords:
            if kw.lower() in low:
                score += weight
                hits.append(f"{kw}(+{weight})")
        if score > best_score:
            best_sdk, best_score, best_hits = sdk, score, hits
    if best_score < SCORE_THRESHOLD:
        # 未达阈值：仍然把弱命中的关键字带出来，标为「未确定」
        return "未确定", best_score, best_hits
    return best_sdk, best_score, best_hits


# ---------------------------------------------------------------------------
# 三、主流程
# ---------------------------------------------------------------------------

def human_size(n: float) -> str:
    """把字节数格式化成人类可读的字符串。"""
    for unit in ("B", "KB", "MB", "GB"):
        if n < 1024 or unit == "GB":
            return f"{n:.0f} B" if unit == "B" else f"{n:.2f} {unit}"
        n /= 1024.0
    return f"{n}"


def main() -> int:
    here = os.path.dirname(os.path.abspath(__file__))
    root = os.path.dirname(here)          # 工作区根目录
    default_apk = os.path.join(root, "samples", "com.huachenjie.shandong_school.apk")

    ap = argparse.ArgumentParser(description="APK 原生库盘点与第三方 SDK 归属判定")
    ap.add_argument("--apk", default=default_apk, help="APK 路径")
    ap.add_argument("--abi", default="arm64-v8a", help="要盘点的 ABI 目录（默认 arm64-v8a）")
    ap.add_argument("--strings-limit", type=int, default=4000,
                    help="每个 .so 最多取多少条字符串作为证据（默认 4000）")
    ap.add_argument("--outdir", default=os.path.join(root, "work", "meta"), help="产出目录")
    args = ap.parse_args()

    if not os.path.isfile(args.apk):
        print(f"[错误] 找不到 APK：{args.apk}", file=sys.stderr)
        return 2
    os.makedirs(args.outdir, exist_ok=True)

    prefix = f"lib/{args.abi}/"
    results = []
    with zipfile.ZipFile(args.apk) as z:
        infos = [i for i in z.infolist() if i.filename.startswith(prefix) and i.filename.endswith(".so")]
        infos.sort(key=lambda i: i.filename)
        print(f"[信息] {prefix}*.so 共 {len(infos)} 个，开始提取字符串 ...", flush=True)

        for idx, info in enumerate(infos, 1):
            name = os.path.basename(info.filename)
            blob = z.read(info.filename)
            strings = extract_strings(blob, args.strings_limit)
            # 去噪后的证据文本（用于打分），但保留原始串以记录证据样本
            clean = [s for s in strings if not is_noise(s)]
            evidence = "\n".join(clean)
            sdk, score, hits = judge(evidence)

            # 给结果附上最有代表性的证据样本：命中关键字所在的那几行
            samples: list[str] = []
            for s in clean:
                low = s.lower()
                if any(h.split("(+")[0].lower() in low for h in hits):
                    if s not in samples:
                        samples.append(s[:200])
                if len(samples) >= 12:
                    break

            results.append({
                "lib": name,
                "path": info.filename,
                "size": info.file_size,
                "size_human": human_size(info.file_size),
                "sha256_prefix": "",           # 占位，见下方可选计算
                "sdk": sdk,
                "category": SDK_RULES.get(sdk, ("未确定",))[0] if sdk != "未确定" else "未确定",
                "score": score,
                "evidence_keywords": hits,
                "evidence_samples": samples,
                "string_count": len(strings),
            })
            print(f"  [{idx:>2}/{len(infos)}] {name:<42} -> {sdk}  (分数 {score})", flush=True)

    # ---------- 写 json ----------
    json_path = os.path.join(args.outdir, "sdk_inventory.json")
    with open(json_path, "w", encoding="utf-8") as f:
        json.dump({
            "apk": os.path.basename(args.apk),
            "abi": args.abi,
            "lib_count": len(results),
            "total_size": sum(r["size"] for r in results),
            "rules_version": "1.0",
            "note": "判定完全基于 .so 内的可打印字符串证据；分数低于阈值的记为「未确定」，不做猜测。",
            "libs": results,
        }, f, ensure_ascii=False, indent=2)

    # ---------- 写 markdown ----------
    md_path = os.path.join(args.outdir, "sdk_inventory.md")
    total = sum(r["size"] for r in results)
    with open(md_path, "w", encoding="utf-8") as f:
        w = f.write
        w("# APK 原生库（.so）清单与第三方 SDK 归属判定\n\n")
        w(f"- 目标 APK：`{os.path.basename(args.apk)}`\n")
        w(f"- ABI：`{args.abi}`\n")
        w(f"- 库数量：**{len(results)}** 个，合计 **{human_size(total)}**\n")
        w(f"- 判定方法：提取每个 .so 的可打印字符串（长度 ≥ 6，最多 {args.strings_limit} 条），"
          f"用关键字→SDK 映射表打分，取最高分且 ≥ {SCORE_THRESHOLD} 分者为判定结果，"
          f"否则记为「未确定」。\n")
        w("- 证据列中的 `+N` 是该关键字在映射表中的权重；权重 10 = 厂商独有强指纹。\n\n")

        determined = [r for r in results if r["sdk"] != "未确定"]
        unknown = [r for r in results if r["sdk"] == "未确定"]
        w(f"- 已判定：**{len(determined)}** 个；未确定：**{len(unknown)}** 个。\n\n")

        w("## 1. 判定结果总表\n\n")
        w("| 库文件名 | 大小 | 判定 SDK | 主要证据关键字 |\n")
        w("|---|---:|---|---|\n")
        for r in results:
            ev = "<br>".join(r["evidence_keywords"][:4]) if r["evidence_keywords"] else "—"
            ev = ev.replace("|", "\\|")
            w(f"| `{r['lib']}` | {r['size_human']} | {r['sdk']} | {ev} |\n")

        w("\n## 2. 按 SDK / 厂商归并\n\n")
        by_sdk: "OrderedDict[str, list[dict]]" = OrderedDict()
        for r in results:
            by_sdk.setdefault(r["sdk"], []).append(r)
        for sdk, items in sorted(by_sdk.items(), key=lambda kv: (-len(kv[1]), kv[0])):
            tot = sum(i["size"] for i in items)
            w(f"### {sdk}（{len(items)} 个库，{human_size(tot)}）\n\n")
            w("| 库文件名 | 大小 | 分数 | 证据关键字 |\n")
            w("|---|---:|---:|---|\n")
            for i in items:
                ev = "<br>".join(i["evidence_keywords"]) if i["evidence_keywords"] else "—"
                w(f"| `{i['lib']}` | {i['size_human']} | {i['score']} | {ev} |\n")
            w("\n")

        w("\n## 3. 未确定库的人工复核线索\n\n")
        w("以下库未达到判定阈值，列出其命中的弱关键字与代表性字符串，供人工继续分析。\n\n")
        for r in unknown:
            w(f"### `{r['lib']}`（{r['size_human']}）\n\n")
            if r["evidence_keywords"]:
                w(f"- 弱命中：{', '.join(r['evidence_keywords'])}\n")
            else:
                w("- 弱命中：无（字符串为高度混淆/随机，疑似加壳或纯内部实现）\n")
            if r["evidence_samples"]:
                w("- 代表性字符串：\n\n```\n")
                for s in r["evidence_samples"][:8]:
                    w(s + "\n")
                w("```\n\n")
            else:
                w("\n")

        w("\n---\n\n")
        w("> 说明：`未确定` 不等于「无风险」，只表示用当前映射表与字符串证据无法可靠归属厂商。\n")

    print(f"\n[完成] 已写出：\n  {md_path}\n  {json_path}")
    print(f"[统计] 已判定 {len(determined)} 个 / 未确定 {len(unknown)} 个")
    return 0


if __name__ == "__main__":
    raise SystemExit(main())
