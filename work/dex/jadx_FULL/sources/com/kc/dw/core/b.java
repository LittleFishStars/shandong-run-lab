package com.kc.dw.core;

import com.kc.dw.core.ad.banner.BannerCommonAdLoader;
import com.kc.dw.core.ad.draw.DrawCommonAdLoader;
import com.kc.dw.core.ad.fullscreenvideo.FullScreenVideoCommonAdLoader;
import com.kc.dw.core.ad.interstitial.InterstitialCommonAdLoader;
import com.kc.dw.core.ad.paster.PasterCommonAdLoader;
import com.kc.dw.core.ad.recycler.RecyclerMixCommonAdLoader;
import com.kc.dw.core.ad.reward.RewardVideoCommonLoader;
import com.kc.dw.core.ad.splash.SplashCommonAdLoader;
import com.kc.dw.core.domain.SdkAdInfo;
import com.kc.dw.core.domain.SsdAdInfo;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public abstract class b {
    public c config;

    public com.kc.dw.core.loader.b bannerLoader(BannerCommonAdLoader bannerCommonAdLoader, SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        return null;
    }

    public c config() {
        if (this.config == null) {
            this.config = createConfig();
        }
        return this.config;
    }

    public abstract c createConfig();

    public com.kc.dw.core.loader.b drawLoader(DrawCommonAdLoader drawCommonAdLoader, SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        return null;
    }

    public com.kc.dw.core.loader.b fullScreenVideoLoader(FullScreenVideoCommonAdLoader fullScreenVideoCommonAdLoader, SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        return null;
    }

    public com.kc.dw.core.loader.b interstitialLoader(InterstitialCommonAdLoader interstitialCommonAdLoader, SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        return null;
    }

    public com.kc.dw.core.loader.b pasterLoader(PasterCommonAdLoader pasterCommonAdLoader, SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        return null;
    }

    public com.kc.dw.core.loader.b recyclerLoader(RecyclerMixCommonAdLoader recyclerMixCommonAdLoader, SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        return null;
    }

    public com.kc.dw.core.loader.b rewardLoader(RewardVideoCommonLoader rewardVideoCommonLoader, SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        return null;
    }

    public com.kc.dw.core.loader.b splashLoader(SplashCommonAdLoader splashCommonAdLoader, SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        return null;
    }
}
