package cn.hzjizhun.admin;

import cn.hzjizhun.admin.ad.bean.AdPlatforms;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public abstract class ddk {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map f22713a;
    public static final Map b;
    public static final Map c;
    public static final Map d;
    public static final Map e;
    public static final Map f;
    public static final Map g;

    static {
        HashMap map = new HashMap();
        f22713a = map;
        AdPlatforms adPlatforms = AdPlatforms.gdt;
        map.put(adPlatforms.name(), "cn.hzjizhun.admin.gdt.GdtThirdSdkInit");
        AdPlatforms adPlatforms2 = AdPlatforms.jz;
        map.put(adPlatforms2.name(), "cn.hzjizhun.admin.jz.JZThirdSdkInit");
        AdPlatforms adPlatforms3 = AdPlatforms.channel;
        map.put(adPlatforms3.name(), "cn.hzjizhun.admin.channel.ChannelThirdSdkInit");
        AdPlatforms adPlatforms4 = AdPlatforms.zhike;
        map.put(adPlatforms4.name(), "cn.hzjizhun.admin.zhike.ZhiKeThirdSdkInit");
        AdPlatforms adPlatforms5 = AdPlatforms.csj;
        map.put(adPlatforms5.name(), "cn.hzjizhun.admin.csj.CsjThirdSdkInit");
        AdPlatforms adPlatforms6 = AdPlatforms.google;
        map.put(adPlatforms6.name(), "cn.hzjizhun.admin.google.GoogleThirdSdkInit");
        AdPlatforms adPlatforms7 = AdPlatforms.lingu;
        map.put(adPlatforms7.name(), "com.lingu.adapter.mht.ad.LinguSdkInit");
        AdPlatforms adPlatforms8 = AdPlatforms.baidu;
        map.put(adPlatforms8.name(), "cn.hzjizhun.admin.baidu.BaiduThirdSdkInit");
        AdPlatforms adPlatforms9 = AdPlatforms.duomeng;
        map.put(adPlatforms9.name(), "cn.hzjizhun.admin.domob.DomobThirdSdkInit");
        HashMap map2 = new HashMap();
        b = map2;
        map2.put(adPlatforms.name(), "cn.hzjizhun.admin.gdt.GdtBannerAdLoader");
        map2.put(adPlatforms2.name(), "cn.hzjizhun.admin.jz.JZBannerAdLoader");
        map2.put(adPlatforms3.name(), "cn.hzjizhun.admin.channel.ChannelBannerAdLoader");
        map2.put(adPlatforms4.name(), "cn.hzjizhun.admin.zhike.ZhiKeBannerAdLoader");
        map2.put(adPlatforms5.name(), "cn.hzjizhun.admin.csj.CsjBannerAdLoader");
        map2.put(adPlatforms6.name(), "cn.hzjizhun.admin.google.GoogleBannerAdLoader");
        map2.put(adPlatforms7.name(), "com.lingu.adapter.mht.ad.LinguBannerAdLoader");
        map2.put(adPlatforms9.name(), "cn.hzjizhun.admin.domob.DomobBannerAdLoader");
        HashMap map3 = new HashMap();
        c = map3;
        map3.put(adPlatforms.name(), "cn.hzjizhun.admin.gdt.GdtNativeAdLoader");
        map3.put(adPlatforms3.name(), "cn.hzjizhun.admin.channel.ChannelNativeAdLoader");
        map3.put(adPlatforms4.name(), "cn.hzjizhun.admin.zhike.ZhiKeNativeAdLoader");
        map3.put(adPlatforms5.name(), "cn.hzjizhun.admin.csj.CsjNativeAdLoader");
        map3.put(adPlatforms6.name(), "cn.hzjizhun.admin.google.GoogleNativeAdLoader");
        map3.put(adPlatforms7.name(), "com.lingu.adapter.mht.ad.LinguNativeAdLoader");
        map3.put(adPlatforms8.name(), "cn.hzjizhun.admin.baidu.BaiduNativeAdLoader");
        map3.put(adPlatforms9.name(), "cn.hzjizhun.admin.domob.DomobNativeAdLoader");
        HashMap map4 = new HashMap();
        d = map4;
        map4.put(adPlatforms.name(), "cn.hzjizhun.admin.gdt.GdtInterstitialAdLoader");
        map4.put(adPlatforms3.name(), "cn.hzjizhun.admin.channel.ChannelInterstitialAdLoader");
        map4.put(adPlatforms4.name(), "cn.hzjizhun.admin.zhike.ZhiKeInterstitialAdLoader");
        map4.put(adPlatforms5.name(), "cn.hzjizhun.admin.csj.CsjInterstitialAdLoader");
        map4.put(adPlatforms6.name(), "cn.hzjizhun.admin.google.GoogleInterstitialAdLoader");
        map4.put(adPlatforms7.name(), "com.lingu.adapter.mht.ad.LinguInterstitialAdLoader");
        map4.put(adPlatforms8.name(), "cn.hzjizhun.admin.baidu.BaiduInterstitialAdLoader");
        map4.put(adPlatforms9.name(), "cn.hzjizhun.admin.domob.DomobInterstitialAdLoader");
        HashMap map5 = new HashMap();
        e = map5;
        map5.put(adPlatforms.name(), "cn.hzjizhun.admin.gdt.GdtUnifiedAdLoader");
        map5.put(adPlatforms3.name(), "cn.hzjizhun.admin.channel.ChannelUnifiedAdLoader");
        map5.put(adPlatforms4.name(), "cn.hzjizhun.admin.zhike.ZhiKeUnifiedAdLoader");
        map5.put(adPlatforms8.name(), "cn.hzjizhun.admin.baidu.BaiduSelfRenderNativeAdLoader");
        map5.put(adPlatforms9.name(), "cn.hzjizhun.admin.domob.DomobSelfRenderNativeAdLoader");
        HashMap map6 = new HashMap();
        f = map6;
        map6.put(adPlatforms4.name(), "cn.hzjizhun.admin.zhike.ZhiKeSplashAdLoader");
        map6.put(adPlatforms3.name(), "cn.hzjizhun.admin.channel.ChannelSplashAdLoader");
        map6.put(adPlatforms.name(), "cn.hzjizhun.admin.gdt.GdtSplashAdLoader");
        map6.put(adPlatforms5.name(), "cn.hzjizhun.admin.csj.CsjSplashAdLoader");
        map6.put(adPlatforms6.name(), "cn.hzjizhun.admin.google.GoogleSplashAdLoader");
        map6.put(adPlatforms8.name(), "cn.hzjizhun.admin.baidu.BaiduSplashAdLoader");
        map6.put(adPlatforms9.name(), "cn.hzjizhun.admin.domob.DomobSplashAdLoader");
        HashMap map7 = new HashMap();
        g = map7;
        map7.put(adPlatforms4.name(), "cn.hzjizhun.admin.zhike.ZhiKeRewardAdLoader");
        map7.put(adPlatforms3.name(), "cn.hzjizhun.admin.channel.ChannelRewardAdLoader");
        map7.put(adPlatforms8.name(), "cn.hzjizhun.admin.baidu.BaiduRewardVideoAdLoader");
        map7.put(adPlatforms9.name(), "cn.hzjizhun.admin.domob.DomobRewardVideoAdLoader");
    }
}
