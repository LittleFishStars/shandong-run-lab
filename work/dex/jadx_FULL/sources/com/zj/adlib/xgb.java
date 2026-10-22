package com.zj.adlib;

import com.bwt.top.AdPlatforms;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class xgb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, String> f45820a;
    public static final Map<String, String> b;
    public static final Map<String, String> c;
    public static final Map<String, String> d;
    public static final Map<String, String> e;
    public static final Map<String, String> f;

    static {
        HashMap map = new HashMap();
        f45820a = map;
        AdPlatforms adPlatforms = AdPlatforms.gdt;
        map.put(adPlatforms.name(), "com.bwt.top.gdt.GdtThirdSdkInit");
        AdPlatforms adPlatforms2 = AdPlatforms.bwt;
        map.put(adPlatforms2.name(), "com.bwt.top.bwt.BwtThirdSdkInit");
        AdPlatforms adPlatforms3 = AdPlatforms.channel;
        map.put(adPlatforms3.name(), "com.bwt.top.channel.ChannelThirdSdkInit");
        AdPlatforms adPlatforms4 = AdPlatforms.zhike;
        map.put(adPlatforms4.name(), "com.bwt.top.zhike.ZhiKeThirdSdkInit");
        AdPlatforms adPlatforms5 = AdPlatforms.lingu;
        map.put(adPlatforms5.name(), "com.lingu.adapter.mht.ad.LinguSdkInit");
        HashMap map2 = new HashMap();
        b = map2;
        map2.put(adPlatforms.name(), "com.bwt.top.gdt.GdtBannerAdLoader");
        map2.put(adPlatforms2.name(), "com.bwt.top.bwt.BwtBannerAdLoader");
        map2.put(adPlatforms3.name(), "com.bwt.top.channel.ChannelBannerAdLoader");
        map2.put(adPlatforms4.name(), "com.bwt.top.zhike.ZhiKeBannerAdLoader");
        map2.put(adPlatforms5.name(), "com.lingu.adapter.mht.ad.LinguBannerAdLoader");
        HashMap map3 = new HashMap();
        c = map3;
        map3.put(adPlatforms.name(), "com.bwt.top.gdt.GdtNativeAdLoader");
        map3.put(adPlatforms3.name(), "com.bwt.top.channel.ChannelNativeAdLoader");
        map3.put(adPlatforms4.name(), "com.bwt.top.zhike.ZhiKeNativeAdLoader");
        map3.put(adPlatforms5.name(), "com.lingu.adapter.mht.ad.LinguNativeAdLoader");
        HashMap map4 = new HashMap();
        d = map4;
        map4.put(adPlatforms.name(), "com.bwt.top.gdt.GdtInterstitialAdLoader");
        map4.put(adPlatforms3.name(), "com.bwt.top.channel.ChannelInterstitialAdLoader");
        map4.put(adPlatforms4.name(), "com.bwt.top.zhike.ZhiKeInterstitialAdLoader");
        map4.put(adPlatforms5.name(), "com.lingu.adapter.mht.ad.LinguInterstitialAdLoader");
        HashMap map5 = new HashMap();
        e = map5;
        map5.put(adPlatforms.name(), "com.bwt.top.gdt.GdtUnifiedAdLoader");
        map5.put(adPlatforms3.name(), "com.bwt.top.channel.ChannelUnifiedAdLoader");
        HashMap map6 = new HashMap();
        f = map6;
        map6.put(adPlatforms4.name(), "com.bwt.top.zhike.ZhiKeSplashAdLoader");
        map6.put(adPlatforms3.name(), "com.bwt.top.channel.ChannelSplashAdLoader");
    }
}
