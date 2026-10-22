# APK 原生库（.so）清单与第三方 SDK 归属判定

- 目标 APK：`com.huachenjie.shandong_school.apk`
- ABI：`arm64-v8a`
- 库数量：**93** 个，合计 **114.95 MB**
- 判定方法：提取每个 .so 的可打印字符串（长度 ≥ 6，最多 4000 条），用关键字→SDK 映射表打分，取最高分且 ≥ 8 分者为判定结果，否则记为「未确定」。
- 证据列中的 `+N` 是该关键字在映射表中的权重；权重 10 = 厂商独有强指纹。

- 已判定：**84** 个；未确定：**9** 个。

## 1. 判定结果总表

| 库文件名 | 大小 | 判定 SDK | 主要证据关键字 |
|---|---:|---|---|
| `libAMapSDK_MAP_v9_5_0.so` | 12.75 MB | 高德地图 SDK (AMap) v9.5.0 | libamapsdk_map(+10)<br>amap(+6)<br>com/autonavi(+10) |
| `libBaiduMapSDK_base_v7_6_3.so` | 504.27 KB | 百度地图 SDK v7.6.3 | libbaidumapsdk_base(+10)<br>baidumapsdk(+10) |
| `libInno.so` | 110.84 KB | 趣盟/奇妙 advlib 广告 SDK（com.qm.advlib）+ InnoSecure 资源加密 | com/qm/advlib(+10)<br>qm/advlib(+10)<br>innosecure(+10)<br>advlib(+8) |
| `libInnoSecure.so` | 66.08 KB | 趣盟/奇妙 advlib 广告 SDK（com.qm.advlib）+ InnoSecure 资源加密 | com/qm/advlib(+10)<br>qm/advlib(+10)<br>innosecure(+10)<br>com/inno/innosecure(+10) |
| `libInspireFace.so` | 5.08 MB | 虹软 ArcSoft InspireFace 人脸识别 | libinspireface(+10)<br>inspireface(+8) |
| `libNetHTProtect.so` | 4.47 MB | 网易易盾 (NetEase Yidun) 加固/风控 | netease(+6)<br>nished(+8)<br>htprotect(+10)<br>com/netease/htprotect(+10) |
| `libOSETSDKProtected.so` | 1.55 MB | 未确定 | gdt(+6) |
| `libPglbizssdk_ml.so` | 1.07 MB | 字节跳动 火山引擎 MobSec 安全 SDK | com/volcengine/mobsec(+10)<br>volcengine(+8)<br>mobsec(+10) |
| `libRCAD.so` | 644.54 KB | rc 设备指纹（com.rc.base.NativeHelper） | getsysbootmark(+10)<br>getsysupdatemark(+10)<br>librcad(+10) |
| `libalivcffmpeg.so` | 2.31 MB | 阿里云视频 SDK（播放器/FFmpeg/Alivc） | libalivcffmpeg(+10)<br>alivc(+10) |
| `liball_in_one.so` | 8.52 MB | 阿里云视频 SDK（播放器/FFmpeg/Alivc） | libalivcffmpeg(+10)<br>alivc(+10) |
| `libapp.so` | 5.75 MB | TensorFlow Lite (Google) | tflite(+8) |
| `libavmdl_lite.so` | 730.06 KB | 阿里云视频 SDK（播放器/FFmpeg/Alivc） | avmdl(+8) |
| `libbarhopper_v3.so` | 4.16 MB | Google ML Kit 条码识别 (barhopper) | libbarhopper(+10)<br>barhopper(+10)<br>barcode(+6)<br>oqei5.prod.google.com(+10) |
| `libbcmarsxlog.so` | 134.01 KB | 阿里百川 TLog 日志（com.alibaba.baichuan） | com/alibaba/baichuan(+10)<br>baichuan(+8)<br>tlog(+8)<br>libbcmarsxlog(+10) |
| `libbitmaps.so` | 9.55 KB | Facebook Fresco 图片库（com.facebook.imagepipeline） | com/facebook/imagepipeline(+10)<br>nativePinBitmap(+8)<br>nativeReleaseByteBuffer(+8)<br>imagepipeline(+6) |
| `libc++_shared.so` | 962.37 KB | LLVM libc++ 运行库（开源基础库） | libc++_shared.so(+10)<br>libc++abi(+6) |
| `libcn_hzjizhun_admin_base.so` | 618.25 KB | rc 设备指纹（com.rc.base.NativeHelper） | getsysbootmark(+10)<br>getsysupdatemark(+10) |
| `libcommonV2DevInfo.so` | 317.94 KB | 倍孜 Beizi Fusion 广告聚合 SDK | com/beizi/fusion(+10)<br>beizi(+10)<br>devsysmark(+8) |
| `libcrashsdk.so` | 632.74 KB | 阿里 UC / 友盟 crashsdk native 崩溃采集 | com/uc/crashsdk(+10)<br>crashsdk(+8) |
| `libflupdatemark.so` | 18.55 KB | SAAS ADX 广告 SDK（com.fl.saas.adx） | flupdatemark(+10)<br>addoplusflags(+6) |
| `libflutter.so` | 10.11 MB | Flutter (Google) —— 应用 UI 框架本身 | libflutter.so(+10) |
| `libfyplayer.so` | 75.28 KB | ltmb / ltsdk 广告与安全模块 | com/ltmb/ltsdk(+10)<br>ltsdk(+8)<br>com/ltmb(+10) |
| `libglide-webp.so` | 438.32 KB | Android Glide WebP 解码器（bumptech） | com/bumptech/glide(+10)<br>glide(+6)<br>webpdecoder(+6) |
| `libgrowease.so` | 982.73 KB | GrowingIO 增长分析 | growease(+10) |
| `libhigh_available_android.so` | 10.46 MB | 网易云信 NIM (NetEase IM / nos.netease.com) | nos.netease.com(+10)<br>lbs.chatnos.com(+10)<br>yunxin.163.com(+10)<br>httpdns.yunxindns.com(+10) |
| `libhtpcrash.so` | 73.98 KB | 网易易盾 (NetEase Yidun) 加固/风控 | netease(+6)<br>htprotect(+10)<br>com/netease/htprotect(+10)<br>necrash(+8) |
| `libhtpcrash_dumper.so` | 98.65 KB | xCrash 系 native 崩溃转储（爱奇艺开源） | xcrash(+10)<br>xcrash_dumper(+10) |
| `libimage_processing_util_jni.so` | 28.27 KB | Google ML Kit 图像处理 (image_processing_util) | image_processing_util_jni(+10) |
| `libimagepipeline.so` | 401.70 KB | Facebook Fresco 图片库（com.facebook.imagepipeline） | com/facebook/imagepipeline(+10)<br>imagepipeline(+6) |
| `libjiagu_sdk_OSETSDKProtected.so` | 778.34 KB | OSET 加固保护（com.jiagu.sdk.OSETSDKProtected） | libjiagu(+10) |
| `libjsengine-api.so` | 156.41 KB | LLVM libc++ 运行库（开源基础库） | libc++_shared.so(+10) |
| `libjsengine-loadso.so` | 25.97 KB | LLVM libc++ 运行库（开源基础库） | libc++_shared.so(+10) |
| `libjsengine-platform.so` | 95.62 KB | LLVM libc++ 运行库（开源基础库） | libc++_shared.so(+10) |
| `libjxad.so` | 218.05 KB | xCrash 系 native 崩溃转储（爱奇艺开源） | xcrash(+10)<br>libxcrash_dumper(+10)<br>xcrash_dumper(+10)<br>jxad(+6) |
| `libkcbwAliAgainstId.so` | 284.07 KB | 阿里 聚安全 / 反作弊（阿里安全 SDK） | aliagainstid(+10)<br>aliagainstcheating(+10) |
| `liblocSDK8b.so` | 359.93 KB | 百度定位 SDK (Baidu Location) | liblocsdk(+10)<br>fused_sdk(+6) |
| `liblocaljscruntime.so` | 278.19 KB | 阿里 Weex / Windmill JS 运行时 | com/taobao/weex(+10)<br>com/taobao/windmill(+10)<br>weex(+8)<br>wmljs(+8) |
| `liblog.so` | 9.23 KB | 未确定 | — |
| `libltmb.so` | 330.84 KB | ltmb / ltsdk 广告与安全模块 | ltsdk(+8)<br>aesgcm(+4)<br>libltmb(+10) |
| `libltmbaf.so` | 210.05 KB | ltmb / ltsdk 广告与安全模块 | ltsdk(+8)<br>libltmb(+10) |
| `liblywmAliAgainstId.so` | 251.12 KB | 阿里 聚安全 / 反作弊（阿里安全 SDK） | aliagainstid(+10)<br>aliagainstcheating(+10) |
| `libmemchunk.so` | 5.60 KB | Facebook Fresco 图片库（com.facebook.imagepipeline） | com/facebook/imagepipeline(+10)<br>imagepipeline(+6) |
| `libmmkv.so` | 583.01 KB | 腾讯 MMKV 键值存储 | libmmkv(+10)<br>mmkv(+8)<br>com/tencent/mmkv(+10) |
| `libne_audio.so` | 1.21 MB | 网易易盾 音频风控 (ne_audio) | libne_audio(+10)<br>netease(+8) |
| `libnesec-x86.so` | 1.18 MB | 未确定 | — |
| `libnesec.so` | 1.02 MB | 未确定 | — |
| `libnexus-kit.so` | 39.91 KB | 快手 OpenSet / Nexus Deeplink 归因 SDK | nexussdk(+10)<br>openset(+8)<br>activateSession(+3)<br>deeplink(+6) |
| `liboctopus.so` | 331.50 KB | xCrash 系 native 崩溃转储（爱奇艺开源） | xcrash(+10)<br>libxcrash_dumper(+10)<br>xcrash_dumper(+10) |
| `liboset-pine-lib.so` | 233.81 KB | OSET 加固保护（com.jiagu.sdk.OSETSDKProtected） | oset-pine(+10) |
| `libosetutil.so` | 135.45 KB | OSET 加固保护（com.jiagu.sdk.OSETSDKProtected） | osetutil(+10) |
| `libosmss3rd-0.0.4.so` | 2.95 MB | 运营商 SS3RD 三方登录聚合 | osmss3rd(+10)<br>libosmss3rd(+10)<br>ss3rd(+8) |
| `libosmss3rdc-0.0.1.so` | 4.61 MB | 运营商 SS3RD 三方登录聚合 | osmss3rd(+10)<br>libosmss3rd(+10)<br>ss3rd(+8) |
| `libpanglearmor.so` | 258.52 KB | 字节跳动 穿山甲 Pangle 广告 SDK | pangle(+10)<br>libpangle(+10) |
| `libpangleflipped.so` | 7.21 KB | 字节跳动 穿山甲 Pangle 广告 SDK | com/byakv(+10) |
| `libphonemark.so` | 5.69 KB | zm/wfsdk PhoneMark 设备指纹 | phonemark(+10)<br>nativegetbootmark(+10)<br>nativegetupdatemark(+10) |
| `libplt-base.so` | 367.80 KB | 快手（Kwai/Kuaishou）native 安全与性能组件 | kuaishou(+10)<br>kwai(+8)<br>libplt-base(+10)<br>xhook(+8) |
| `libqiyuhigh_available_android.so` | 1.53 MB | 网易云信 NIM (NetEase IM / nos.netease.com) | nos.netease.com(+10)<br>lbs.chatnos.com(+10)<br>yunxin.163.com(+10)<br>httpdns.yunxindns.com(+10) |
| `libqiyune_audio.so` | 1.55 MB | 网易易盾 音频风控 (ne_audio) | libne_audio(+10) |
| `libqiyutraceroute.so` | 98.88 KB | 网络诊断 / traceroute | traceroute(+10)<br>whois.radb.net(+10)<br>icmp(+4) |
| `libqmcheat.so` | 9.77 KB | 海量广告 advlib（com.hailiang.advlib） | com/hailiang/advlib(+10)<br>hailiang(+10)<br>advlib(+6)<br>alicheatparams(+8) |
| `libqysdk_simd.so` | 9.95 KB | 未确定 | — |
| `libsaas.so` | 43.33 KB | 未确定 | addoplusflags(+6) |
| `libsecsdk.so` | 340.86 KB | 未确定 | — |
| `libsgcore.so` | 86.20 KB | 快手（Kwai/Kuaishou）native 安全与性能组件 | kwai(+8)<br>sgcore(+8) |
| `libshenshi.so` | 222.16 KB | xCrash 系 native 崩溃转储（爱奇艺开源） | xcrash(+10)<br>libxcrash_dumper(+10)<br>xcrash_dumper(+10) |
| `libsls_producer.so` | 805.94 KB | 阿里云日志服务 SLS | libsls_producer(+10)<br>com/aliyun/sls(+10)<br>sls_producer(+10)<br>aliyun(+4) |
| `libsoundtouch.so` | 489.77 KB | SoundTouch 音频变速/变调（开源，Olli Parviainen） | soundtouch(+10)<br>soundtouch::(+8) |
| `libssplayer.so` | 242.64 KB | 未确定 | libc++abi(+6) |
| `libtaobaoplayer.so` | 986.78 KB | 阿里 淘宝播放器 / taobao player | libtaobaoplayer(+10)<br>taobaoplayer(+10)<br>libtbffmpeg(+10) |
| `libtbffmpeg.so` | 6.65 MB | HTTPDNS / 网络加速 | httpdns(+10) |
| `libtbplayer.so` | 268.61 KB | 阿里 淘宝播放器 / taobao player | libtbplayer(+10)<br>libtbffmpeg(+10)<br>tbplayer(+10) |
| `libtbsdl.so` | 358.31 KB | 腾讯 X5/TBS 浏览服务 | libtbsdl(+10)<br>tbsdl(+10)<br>tbs(+3) |
| `libtensorflowlite_gpu_jni.so` | 2.89 MB | TensorFlow Lite (Google) | tensorflowlite(+10)<br>tensorflow(+8)<br>tflite(+8) |
| `libtensorflowlite_jni.so` | 3.60 MB | TensorFlow Lite (Google) | tensorflowlite(+10)<br>tensorflow(+8)<br>tflite(+8) |
| `libti-monitor.so` | 113.16 KB | 快手（Kwai/Kuaishou）native 安全与性能组件 | com/kwai/(+10)<br>kwai(+8)<br>libplt-base(+10)<br>xhook(+8) |
| `libtiny_magic.so` | 82.20 KB | 百度 mshield 安全 SDK / 设备指纹 gdid | com/baidu/mshield(+10)<br>mshield(+10)<br>com/baidu/xclient/gdid(+10)<br>gdid(+8) |
| `libtobEmbedEncrypt.so` | 50.37 KB | 字节跳动 穿山甲 Pangle 广告 SDK | ttencryptutils(+10) |
| `libtraceroute.so` | 90.84 KB | 网络诊断 / traceroute | traceroute(+10)<br>whois.radb.net(+10)<br>icmp(+4) |
| `libtt_ugen_layout.so` | 430.34 KB | 字节跳动 穿山甲 Pangle 广告 SDK | com/byakv(+10)<br>tt_ugen(+8)<br>libtt_ugen_layout(+10) |
| `libttmplayer_lite.so` | 1.43 MB | 字节跳动 抖动播放器 (ttmplayer) | libttmplayer(+10)<br>ttmplayer(+10) |
| `libucrash-core.so` | 95.00 KB | 阿里 UC / 友盟 crashsdk native 崩溃采集 | ucrash(+8) |
| `libucrash.so` | 50.44 KB | 友盟+ (Umeng) 统计 / U-APM | umeng(+10)<br>com/umeng/crash(+10)<br>u-apm(+8) |
| `libumeng-spy.so` | 452.98 KB | 友盟+ (Umeng) 统计 / U-APM | libumeng-spy(+10)<br>umeng(+10) |
| `libumonitor.so` | 241.55 KB | 友盟+ (Umeng) 统计 / U-APM | umeng(+10)<br>com/efs/sdk(+10)<br>com/efs/sdk/memleaksdk(+10)<br>umonitor(+8) |
| `libv8worker-native.so` | 98.13 KB | 阿里 mPaaS / Alipay H5 容器 与 JS 引擎 | ariver(+10)<br>v8worker(+10) |
| `libwcdb.so` | 1.80 MB | 腾讯 WCDB 数据库 | libwcdb(+10)<br>wcdb(+8)<br>com/tencent/wcdb(+10) |
| `libweibosdkcore.so` | 25.52 KB | 新浪微博 SDK | libweibosdkcore(+10)<br>weibosdk(+10)<br>com/sina/weibo(+10) |
| `liby.so` | 447.84 KB | 未确定 | — |
| `libzjAliAgainstId.so` | 251.10 KB | 阿里 聚安全 / 反作弊（阿里安全 SDK） | aliagainstid(+10)<br>aliagainstcheating(+10) |
| `libzjadso.so` | 261.09 KB | zj 广告联盟 SDK（com.zj.*） | zjadso(+10) |
| `libzjplayer.so` | 50.62 KB | zj 广告联盟 SDK（com.zj.*） | com/zj/ad(+10)<br>zjplayer(+10) |
| `libzxprotect.so` | 215.92 KB | 运营商一键登录 / UAID 取号 SDK（com.zx.sdk） | com/zx/sdk(+10)<br>zxid-m.mobileservice.cn(+10)<br>msg.cmpassport.com(+10)<br>id6.me(+10) |

## 2. 按 SDK / 厂商归并

### 未确定（9 个库，4.81 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libOSETSDKProtected.so` | 1.55 MB | 6 | gdt(+6) |
| `liblog.so` | 9.23 KB | 0 | — |
| `libnesec-x86.so` | 1.18 MB | 0 | — |
| `libnesec.so` | 1.02 MB | 0 | — |
| `libqysdk_simd.so` | 9.95 KB | 0 | — |
| `libsaas.so` | 43.33 KB | 6 | addoplusflags(+6) |
| `libsecsdk.so` | 340.86 KB | 0 | — |
| `libssplayer.so` | 242.64 KB | 6 | libc++abi(+6) |
| `liby.so` | 447.84 KB | 0 | — |

### LLVM libc++ 运行库（开源基础库）（4 个库，1.21 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libc++_shared.so` | 962.37 KB | 16 | libc++_shared.so(+10)<br>libc++abi(+6) |
| `libjsengine-api.so` | 156.41 KB | 10 | libc++_shared.so(+10) |
| `libjsengine-loadso.so` | 25.97 KB | 10 | libc++_shared.so(+10) |
| `libjsengine-platform.so` | 95.62 KB | 10 | libc++_shared.so(+10) |

### xCrash 系 native 崩溃转储（爱奇艺开源）（4 个库，870.37 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libhtpcrash_dumper.so` | 98.65 KB | 20 | xcrash(+10)<br>xcrash_dumper(+10) |
| `libjxad.so` | 218.05 KB | 36 | xcrash(+10)<br>libxcrash_dumper(+10)<br>xcrash_dumper(+10)<br>jxad(+6) |
| `liboctopus.so` | 331.50 KB | 30 | xcrash(+10)<br>libxcrash_dumper(+10)<br>xcrash_dumper(+10) |
| `libshenshi.so` | 222.16 KB | 30 | xcrash(+10)<br>libxcrash_dumper(+10)<br>xcrash_dumper(+10) |

### 字节跳动 穿山甲 Pangle 广告 SDK（4 个库，746.44 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libpanglearmor.so` | 258.52 KB | 20 | pangle(+10)<br>libpangle(+10) |
| `libpangleflipped.so` | 7.21 KB | 10 | com/byakv(+10) |
| `libtobEmbedEncrypt.so` | 50.37 KB | 10 | ttencryptutils(+10) |
| `libtt_ugen_layout.so` | 430.34 KB | 28 | com/byakv(+10)<br>tt_ugen(+8)<br>libtt_ugen_layout(+10) |

### Facebook Fresco 图片库（com.facebook.imagepipeline）（3 个库，416.86 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libbitmaps.so` | 9.55 KB | 32 | com/facebook/imagepipeline(+10)<br>nativePinBitmap(+8)<br>nativeReleaseByteBuffer(+8)<br>imagepipeline(+6) |
| `libimagepipeline.so` | 401.70 KB | 16 | com/facebook/imagepipeline(+10)<br>imagepipeline(+6) |
| `libmemchunk.so` | 5.60 KB | 16 | com/facebook/imagepipeline(+10)<br>imagepipeline(+6) |

### OSET 加固保护（com.jiagu.sdk.OSETSDKProtected）（3 个库，1.12 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libjiagu_sdk_OSETSDKProtected.so` | 778.34 KB | 10 | libjiagu(+10) |
| `liboset-pine-lib.so` | 233.81 KB | 10 | oset-pine(+10) |
| `libosetutil.so` | 135.45 KB | 10 | osetutil(+10) |

### TensorFlow Lite (Google)（3 个库，12.25 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libapp.so` | 5.75 MB | 8 | tflite(+8) |
| `libtensorflowlite_gpu_jni.so` | 2.89 MB | 26 | tensorflowlite(+10)<br>tensorflow(+8)<br>tflite(+8) |
| `libtensorflowlite_jni.so` | 3.60 MB | 26 | tensorflowlite(+10)<br>tensorflow(+8)<br>tflite(+8) |

### ltmb / ltsdk 广告与安全模块（3 个库，616.18 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libfyplayer.so` | 75.28 KB | 28 | com/ltmb/ltsdk(+10)<br>ltsdk(+8)<br>com/ltmb(+10) |
| `libltmb.so` | 330.84 KB | 22 | ltsdk(+8)<br>aesgcm(+4)<br>libltmb(+10) |
| `libltmbaf.so` | 210.05 KB | 18 | ltsdk(+8)<br>libltmb(+10) |

### 友盟+ (Umeng) 统计 / U-APM（3 个库，744.97 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libucrash.so` | 50.44 KB | 28 | umeng(+10)<br>com/umeng/crash(+10)<br>u-apm(+8) |
| `libumeng-spy.so` | 452.98 KB | 20 | libumeng-spy(+10)<br>umeng(+10) |
| `libumonitor.so` | 241.55 KB | 38 | umeng(+10)<br>com/efs/sdk(+10)<br>com/efs/sdk/memleaksdk(+10)<br>umonitor(+8) |

### 快手（Kwai/Kuaishou）native 安全与性能组件（3 个库，567.16 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libplt-base.so` | 367.80 KB | 36 | kuaishou(+10)<br>kwai(+8)<br>libplt-base(+10)<br>xhook(+8) |
| `libsgcore.so` | 86.20 KB | 16 | kwai(+8)<br>sgcore(+8) |
| `libti-monitor.so` | 113.16 KB | 56 | com/kwai/(+10)<br>kwai(+8)<br>libplt-base(+10)<br>xhook(+8)<br>ti-monitor(+10)<br>com/kwai/performance(+10) |

### 阿里 聚安全 / 反作弊（阿里安全 SDK）（3 个库，786.29 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libkcbwAliAgainstId.so` | 284.07 KB | 20 | aliagainstid(+10)<br>aliagainstcheating(+10) |
| `liblywmAliAgainstId.so` | 251.12 KB | 20 | aliagainstid(+10)<br>aliagainstcheating(+10) |
| `libzjAliAgainstId.so` | 251.10 KB | 20 | aliagainstid(+10)<br>aliagainstcheating(+10) |

### 阿里云视频 SDK（播放器/FFmpeg/Alivc）（3 个库，11.54 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libalivcffmpeg.so` | 2.31 MB | 20 | libalivcffmpeg(+10)<br>alivc(+10) |
| `liball_in_one.so` | 8.52 MB | 20 | libalivcffmpeg(+10)<br>alivc(+10) |
| `libavmdl_lite.so` | 730.06 KB | 8 | avmdl(+8) |

### rc 设备指纹（com.rc.base.NativeHelper）（2 个库，1.23 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libRCAD.so` | 644.54 KB | 30 | getsysbootmark(+10)<br>getsysupdatemark(+10)<br>librcad(+10) |
| `libcn_hzjizhun_admin_base.so` | 618.25 KB | 20 | getsysbootmark(+10)<br>getsysupdatemark(+10) |

### zj 广告联盟 SDK（com.zj.*）（2 个库，311.72 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libzjadso.so` | 261.09 KB | 10 | zjadso(+10) |
| `libzjplayer.so` | 50.62 KB | 20 | com/zj/ad(+10)<br>zjplayer(+10) |

### 网易云信 NIM (NetEase IM / nos.netease.com)（2 个库，12.00 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libhigh_available_android.so` | 10.46 MB | 48 | nos.netease.com(+10)<br>lbs.chatnos.com(+10)<br>yunxin.163.com(+10)<br>httpdns.yunxindns.com(+10)<br>chatnos(+8) |
| `libqiyuhigh_available_android.so` | 1.53 MB | 48 | nos.netease.com(+10)<br>lbs.chatnos.com(+10)<br>yunxin.163.com(+10)<br>httpdns.yunxindns.com(+10)<br>chatnos(+8) |

### 网易易盾 (NetEase Yidun) 加固/风控（2 个库，4.54 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libNetHTProtect.so` | 4.47 MB | 44 | netease(+6)<br>nished(+8)<br>htprotect(+10)<br>com/netease/htprotect(+10)<br>libnethtprotect(+10) |
| `libhtpcrash.so` | 73.98 KB | 34 | netease(+6)<br>htprotect(+10)<br>com/netease/htprotect(+10)<br>necrash(+8) |

### 网易易盾 音频风控 (ne_audio)（2 个库，2.76 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libne_audio.so` | 1.21 MB | 18 | libne_audio(+10)<br>netease(+8) |
| `libqiyune_audio.so` | 1.55 MB | 10 | libne_audio(+10) |

### 网络诊断 / traceroute（2 个库，189.71 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libqiyutraceroute.so` | 98.88 KB | 24 | traceroute(+10)<br>whois.radb.net(+10)<br>icmp(+4) |
| `libtraceroute.so` | 90.84 KB | 24 | traceroute(+10)<br>whois.radb.net(+10)<br>icmp(+4) |

### 趣盟/奇妙 advlib 广告 SDK（com.qm.advlib）+ InnoSecure 资源加密（2 个库，176.91 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libInno.so` | 110.84 KB | 48 | com/qm/advlib(+10)<br>qm/advlib(+10)<br>innosecure(+10)<br>advlib(+8)<br>libinno(+10) |
| `libInnoSecure.so` | 66.08 KB | 58 | com/qm/advlib(+10)<br>qm/advlib(+10)<br>innosecure(+10)<br>com/inno/innosecure(+10)<br>advlib(+8)<br>libinno(+10) |

### 运营商 SS3RD 三方登录聚合（2 个库，7.56 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libosmss3rd-0.0.4.so` | 2.95 MB | 28 | osmss3rd(+10)<br>libosmss3rd(+10)<br>ss3rd(+8) |
| `libosmss3rdc-0.0.1.so` | 4.61 MB | 28 | osmss3rd(+10)<br>libosmss3rd(+10)<br>ss3rd(+8) |

### 阿里 UC / 友盟 crashsdk native 崩溃采集（2 个库，727.74 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libcrashsdk.so` | 632.74 KB | 18 | com/uc/crashsdk(+10)<br>crashsdk(+8) |
| `libucrash-core.so` | 95.00 KB | 8 | ucrash(+8) |

### 阿里 淘宝播放器 / taobao player（2 个库，1.23 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libtaobaoplayer.so` | 986.78 KB | 30 | libtaobaoplayer(+10)<br>taobaoplayer(+10)<br>libtbffmpeg(+10) |
| `libtbplayer.so` | 268.61 KB | 30 | libtbplayer(+10)<br>libtbffmpeg(+10)<br>tbplayer(+10) |

### Android Glide WebP 解码器（bumptech）（1 个库，438.32 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libglide-webp.so` | 438.32 KB | 22 | com/bumptech/glide(+10)<br>glide(+6)<br>webpdecoder(+6) |

### Flutter (Google) —— 应用 UI 框架本身（1 个库，10.11 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libflutter.so` | 10.11 MB | 10 | libflutter.so(+10) |

### Google ML Kit 图像处理 (image_processing_util)（1 个库，28.27 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libimage_processing_util_jni.so` | 28.27 KB | 10 | image_processing_util_jni(+10) |

### Google ML Kit 条码识别 (barhopper)（1 个库，4.16 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libbarhopper_v3.so` | 4.16 MB | 44 | libbarhopper(+10)<br>barhopper(+10)<br>barcode(+6)<br>oqei5.prod.google.com(+10)<br>mlkit(+8) |

### GrowingIO 增长分析（1 个库，982.73 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libgrowease.so` | 982.73 KB | 10 | growease(+10) |

### HTTPDNS / 网络加速（1 个库，6.65 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libtbffmpeg.so` | 6.65 MB | 10 | httpdns(+10) |

### SAAS ADX 广告 SDK（com.fl.saas.adx）（1 个库，18.55 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libflupdatemark.so` | 18.55 KB | 16 | flupdatemark(+10)<br>addoplusflags(+6) |

### SoundTouch 音频变速/变调（开源，Olli Parviainen）（1 个库，489.77 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libsoundtouch.so` | 489.77 KB | 18 | soundtouch(+10)<br>soundtouch::(+8) |

### zm/wfsdk PhoneMark 设备指纹（1 个库，5.69 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libphonemark.so` | 5.69 KB | 30 | phonemark(+10)<br>nativegetbootmark(+10)<br>nativegetupdatemark(+10) |

### 倍孜 Beizi Fusion 广告聚合 SDK（1 个库，317.94 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libcommonV2DevInfo.so` | 317.94 KB | 28 | com/beizi/fusion(+10)<br>beizi(+10)<br>devsysmark(+8) |

### 字节跳动 抖动播放器 (ttmplayer)（1 个库，1.43 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libttmplayer_lite.so` | 1.43 MB | 20 | libttmplayer(+10)<br>ttmplayer(+10) |

### 字节跳动 火山引擎 MobSec 安全 SDK（1 个库，1.07 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libPglbizssdk_ml.so` | 1.07 MB | 28 | com/volcengine/mobsec(+10)<br>volcengine(+8)<br>mobsec(+10) |

### 快手 OpenSet / Nexus Deeplink 归因 SDK（1 个库，39.91 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libnexus-kit.so` | 39.91 KB | 27 | nexussdk(+10)<br>openset(+8)<br>activateSession(+3)<br>deeplink(+6) |

### 新浪微博 SDK（1 个库，25.52 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libweibosdkcore.so` | 25.52 KB | 30 | libweibosdkcore(+10)<br>weibosdk(+10)<br>com/sina/weibo(+10) |

### 海量广告 advlib（com.hailiang.advlib）（1 个库，9.77 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libqmcheat.so` | 9.77 KB | 44 | com/hailiang/advlib(+10)<br>hailiang(+10)<br>advlib(+6)<br>alicheatparams(+8)<br>libqmcheat(+10) |

### 百度 mshield 安全 SDK / 设备指纹 gdid（1 个库，82.20 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libtiny_magic.so` | 82.20 KB | 54 | com/baidu/mshield(+10)<br>mshield(+10)<br>com/baidu/xclient/gdid(+10)<br>gdid(+8)<br>libtiny_magic(+10)<br>daemonsu(+6) |

### 百度地图 SDK v7.6.3（1 个库，504.27 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libBaiduMapSDK_base_v7_6_3.so` | 504.27 KB | 20 | libbaidumapsdk_base(+10)<br>baidumapsdk(+10) |

### 百度定位 SDK (Baidu Location)（1 个库，359.93 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `liblocSDK8b.so` | 359.93 KB | 16 | liblocsdk(+10)<br>fused_sdk(+6) |

### 腾讯 MMKV 键值存储（1 个库，583.01 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libmmkv.so` | 583.01 KB | 28 | libmmkv(+10)<br>mmkv(+8)<br>com/tencent/mmkv(+10) |

### 腾讯 WCDB 数据库（1 个库，1.80 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libwcdb.so` | 1.80 MB | 28 | libwcdb(+10)<br>wcdb(+8)<br>com/tencent/wcdb(+10) |

### 腾讯 X5/TBS 浏览服务（1 个库，358.31 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libtbsdl.so` | 358.31 KB | 23 | libtbsdl(+10)<br>tbsdl(+10)<br>tbs(+3) |

### 虹软 ArcSoft InspireFace 人脸识别（1 个库，5.08 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libInspireFace.so` | 5.08 MB | 18 | libinspireface(+10)<br>inspireface(+8) |

### 运营商一键登录 / UAID 取号 SDK（com.zx.sdk）（1 个库，215.92 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libzxprotect.so` | 215.92 KB | 70 | com/zx/sdk(+10)<br>zxid-m.mobileservice.cn(+10)<br>msg.cmpassport.com(+10)<br>id6.me(+10)<br>nisportal.10010.com(+10)<br>saidcallback(+10)<br>libzxprotect(+10) |

### 阿里 Weex / Windmill JS 运行时（1 个库，278.19 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `liblocaljscruntime.so` | 278.19 KB | 36 | com/taobao/weex(+10)<br>com/taobao/windmill(+10)<br>weex(+8)<br>wmljs(+8) |

### 阿里 mPaaS / Alipay H5 容器 与 JS 引擎（1 个库，98.13 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libv8worker-native.so` | 98.13 KB | 20 | ariver(+10)<br>v8worker(+10) |

### 阿里云日志服务 SLS（1 个库，805.94 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libsls_producer.so` | 805.94 KB | 34 | libsls_producer(+10)<br>com/aliyun/sls(+10)<br>sls_producer(+10)<br>aliyun(+4) |

### 阿里百川 TLog 日志（com.alibaba.baichuan）（1 个库，134.01 KB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libbcmarsxlog.so` | 134.01 KB | 36 | com/alibaba/baichuan(+10)<br>baichuan(+8)<br>tlog(+8)<br>libbcmarsxlog(+10) |

### 高德地图 SDK (AMap) v9.5.0（1 个库，12.75 MB）

| 库文件名 | 大小 | 分数 | 证据关键字 |
|---|---:|---:|---|
| `libAMapSDK_MAP_v9_5_0.so` | 12.75 MB | 26 | libamapsdk_map(+10)<br>amap(+6)<br>com/autonavi(+10) |


## 3. 未确定库的人工复核线索

以下库未达到判定阈值，列出其命中的弱关键字与代表性字符串，供人工继续分析。

### `libOSETSDKProtected.so`（1.55 MB）

- 弱命中：gdt(+6)
- 代表性字符串：

```
GDTI.j
```

### `liblog.so`（9.23 KB）

- 弱命中：无（字符串为高度混淆/随机，疑似加壳或纯内部实现）

### `libnesec-x86.so`（1.18 MB）

- 弱命中：无（字符串为高度混淆/随机，疑似加壳或纯内部实现）

### `libnesec.so`（1.02 MB）

- 弱命中：无（字符串为高度混淆/随机，疑似加壳或纯内部实现）

### `libqysdk_simd.so`（9.95 KB）

- 弱命中：无（字符串为高度混淆/随机，疑似加壳或纯内部实现）

### `libsaas.so`（43.33 KB）

- 弱命中：addoplusflags(+6)
- 代表性字符串：

```
addOplusFlags
```

### `libsecsdk.so`（340.86 KB）

- 弱命中：无（字符串为高度混淆/随机，疑似加壳或纯内部实现）

### `libssplayer.so`（242.64 KB）

- 弱命中：libc++abi(+6)
- 代表性字符串：

```
libc++abi
libc++abi: 
```

### `liby.so`（447.84 KB）

- 弱命中：无（字符串为高度混淆/随机，疑似加壳或纯内部实现）


---

> 说明：`未确定` 不等于「无风险」，只表示用当前映射表与字符串证据无法可靠归属厂商。

---

# 附录 A：脚本判定外的**人工复核结论**（基于补充证据）

脚本只使用 .so 自身字符串打分，以下库字符串长期被高度混淆（可打印串几乎全是随机字符），
已用**补充证据**（JNI 符号表、主 dex 交叉引用、同族库名、同目录资源前缀）人工定性。
证据强度标注为「强 / 中 / 弱」。

| 库 | 人工判定 | 关键补充证据 | 强度 |
|---|---|---|---|
| `libnesec.so` | 网易易盾（NetEase Yidun）安全/加固 | 与 `libNetHTProtect.so`（含 `com/netease/htprotect`、`necrash`）、`libne_audio.so`（含 `netease`）同族；命名 `ne*` 前缀；主 dex 中有易盾特征；库内串被强混淆（96%) | 中 |
| `libnesec-x86.so` | 网易易盾 x86 版本 | 同上，且为 x86 变体 | 中 |
| `libOSETSDKProtected.so` / `libjiagu_sdk_OSETSDKProtected.so` / `liboset-pine-lib.so` / `libosetutil.so` | OSET 加固保护层 | 主 dex 中 `Lcom/jiagu/sdk/OSETSDKProtected;` 出现 653 次；与 `com/kc/openset` 同族；`libnexus-kit.so` 导出 `Java_com_kc_openset_plugin_opt_NexusSdk_*` | 强 |
| `libsecsdk.so` | 加固壳 native 运行时（`ConfigManager`/`NativeMethodParser`） | 含 `13ConfigManager`、`18NativeMethodParser`、`dvmAddToReferenceTable` 等 ART/JNI 内部符号，是典型壳框架行为 | 中 |
| `libsaas.so` | SAAS ADX 广告 SDK 的 native 层（`com.fl.saas.adx`） | 同族 `libflupdatemark.so` 导出 `Java_com_fl_saas_adx_util_DeviceUtil_*`；主 dex 中 `com.fl.saas` 出现 12 次 | 中 |
| `libssplayer.so` | 未确定（播放器类，疑广告视频播放内核） | 仅 libunwind/C++ 样板串 + `checkImage`；无厂商标识 | 弱 |
| `liby.so` | 未确定（疑自研/加壳 native，反调试特征明显） | 含 `dl_iterate_phdr`、`dladdr`、`/dev/null`；其余为随机串 | 弱 |
| `liblog.so` | Android 日志封装（非第三方 SDK） | 仅 213 条字符串，无厂商标识 | 中 |
| `libqysdk_simd.so` | 网易七鱼客服 SDK 的 SIMD 加速模块 | 与 `libqiyu*` 同族命名 | 中 |
| `liboctopus.so` | 广告聚合 SDK（octopus 模块） | 含 `com/octopus/ad/utils`、`octopus_skip_ad` | 强 |
| `libshenshi.so` | kc 广告 SDK 的设备指纹/崩溃模块 | 含 `com/kc/cw/ad/utils`；与 `com/kc/bw`（kcbw 插件）同族 | 强 |
| `libltmb.so` / `libltmbaf.so` / `libfyplayer.so` | ltmb `ltsdk` 广告/安全与播放模块 | `Java_com_ltmb_ltsdk_core_kat_*`、`libfyplayer` 含 `com/ltmb/ltsdk/core/fy` | 强 |
| `libtiny_magic.so` | 百度 mshield 安全 SDK / 设备指纹 | `com/baidu/mshield/x0/jni/Native`、`com/baidu/xclient/gdid/jni/Native`、`daemonsu` 反 root | 强 |
| `libRCAD.so` | 设备指纹 SDK（厂商标识仅 `com.rc.base`，厂商未确定） | `Java_com_rc_base_NativeHelper_getSysBootMark/getSysUpdateMark` | 中（归属厂商未确定） |
| `libosmss3rd-0.0.4.so` / `libosmss3rdc-0.0.1.so` | 运营商三方登录聚合（"osm ss3rd"） | 名称自证；含 zlib 1.2.11 | 中（厂商未确定） |
| `libjxad.so` | zj 广告 SDK 的崩溃转储模块（xCrash 内核） | 含 `com.zj.zjdsp.ad`、`com.kaixinkan.ugc.video`，并内嵌 xCrash dump 框架 | 强 |
| `libavmdl_lite.so` | 阿里云播放器 AVMDL lite（视频缓存/下载） | `AnAVMDLWrapper`、`Accept-Ranges`、`application/vnd.apple.mpegurl`、`AkamaiGHost` | 强 |
| `libpangleflipped.so` / `libpanglearmor.so` | 字节跳动穿山甲加固/反调试 | `com/byakv/f/FlippedV2Impl`、`libflipped.so`、`git.byted.org` | 强 |
| `libtobEmbedEncrypt.so` | 字节跳动 TTEncrypt 设备信息加密 | `Java_com_byakv_z_TTEncryptUtils_*`（ttEncrypt/ttDecrypt） | 强 |
| `libPglbizssdk_ml.so` | 字节跳动火山引擎 MobSec 安全 SDK | 含 `com/volcengine/mobsec` | 强 |
| `libInno.so` / `libInnoSecure.so` | **不是加固厂商**，而是 `com.qm.advlib`（趣盟/奇妙 advlib 广告 SDK）的资源加密模块 InnoSecure | `com/inno/innosecure/MyAssets`、`com/qm/advlib/trdparty/secure/InnoSecureMain`、`com/qm/advlib/trdparty/secure/InnoSecureUtils`；对应 `assets/libinno` 标记文件 | 强 |
| `libqmcheat.so` | 海量广告 `com.hailiang.advlib` 的阿里聚安全反作弊（AliCheatParams） | 含 `com/hailiang/advlib/open/AliCheatParams`、`com/hailiang/advlib/__remote__/framework/...`；导出 `getBoot`/`getUpdate` 设备指纹 | 强 |
| `libcrashsdk.so` | **与题面提示不符**：字符串与主 dex 均指向 `com.uc.crashsdk`（阿里 UC / 友盟 U-APM 体系），而非腾讯 Bugly | 主 dex 中 `Lcom/uc/crashsdk/JNIBridge;`；库内含 `$^BATTERYINFO^$`/`$^DEVICESTATUS^$` 等 native 崩溃附加信息标记 | 中 |
| `libucrash.so` / `libucrash-core.so` / `libumonitor.so` | 友盟+ U-APM（`com/umeng/crash`、`com/efs/sdk/memleaksdk`） | 库内类名自证 | 强 |
| `libhtpcrash.so` / `libhtpcrash_dumper.so` | 网易易盾崩溃捕获（`com/netease/htprotect/necrash/nis`） | 库内类名自证 | 强 |
| `libsgcore.so` | **与题面提示不符**：快手 SecurityGuard（`Java_com_kwai_sgcore_SGCore_getClock/getMagic`），非阿里聚安全 | JNI 导出符号自证 | 强 |
| `libltmbaf.so` | ltmb `ltsdk` 的 AliAgainstId 反作弊变体 | `Java_com_ltmb_ltsdk_core_blk_base_x_X_x` | 中 |
| `libbcmarsxlog.so` | 阿里百川（Baichuan）TLog 日志 | `Java_com_alibaba_baichuan_log_TLogNative_*` | 强 |
| `libjsengine-api.so` / `libjsengine-loadso.so` / `libjsengine-platform.so` | 支付宝/阿里 mPaaS JS 引擎（V8） | `Java_com_alipay_mobile_jsengine_JSEngine_*`、`V8_*` | 强 |
| `liblocaljscruntime.so` | 阿里 Weex / Windmill（WML）JS 运行时 | `com/taobao/weex/utils/WMLogUtils`、`com/taobao/windmill/bridge/*` | 强 |
| `libbitmaps.so` / `libmemchunk.so` | Facebook Fresco 图片管线 native | `com/facebook/imagepipeline/*` | 强 |
| `libcommonV2DevInfo.so` | 倍孜 Beizi Fusion 广告聚合 SDK 设备信息 | `com/beizi/fusion/asnp/common/v2/dev/info/DevSysMark` | 强 |
| `libnexus-kit.so` | 快手 `com.kc.openset` Nexus Deeplink 归因 SDK | `Java_com_kc_openset_plugin_opt_NexusSdk_activateSession/buildSessionId/getVersion`、`BSI_ERR_NULL_DEEPLINK` | 强 |
| `libplt-base.so` | 快手性能/稳定性基础库（xhook、JVMTI 监控） | `Java_com_kuaishou_xhook_NativeHandler_*`、`Java_com_kwai_performance_overhead_base_NativeHandler_test` | 强 |
| `libti-monitor.so` | 快手 JVMTI 稳定性监控 | `Java_com_kwai_performance_stability_artti_monitor_JvmtiHelper_*` | 强 |
| `libflupdatemark.so` | SAAS ADX（`com.fl.saas.adx`）设备指纹 | `Java_com_fl_saas_adx_util_DeviceUtil_getUpdate/startAction` | 强 |
| `libzxprotect.so` | 运营商一键登录 / UAID 取号（`com.zx.sdk.api`） | `zxid-m.mobileservice.cn`、`msg.cmpassport.com`、`id6.me`、`nisportal.10010.com:9001`、`SAIDCallback` | 强 |

## 附录 B：本次未完成 / 待续事项

1. `liby.so`、`libssplayer.so`、`libRCAD.so` 的**厂商归属未确定**：字符串被混淆或无厂商标识，
   需要动态运行或反汇编（Ghidra/IDA）才能定性，本次静态盘点未做。
2. `libnesec.so` / `libsecsdk.so` / `libOSETSDKProtected.so` 的**加固方案与保护能力**未展开评估
   （反调试、完整性校验、DEX 抽取方式）。
3. 98 个 `lib/armeabi-v7a/*.so` **未盘点**（本次只按要求做了 arm64-v8a 的 93 个）。
4. 各 SDK 的**版本号**未逐一确认（仅文件名带版本的 AMap v9.5.0 / BaiduMap v7.6.3 可确认）。
5. 未做动态验证（无 adb / 未运行 App），所有结论均为静态证据判定。
