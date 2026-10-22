package com.kc.dw.platform.custom;

import com.kc.dw.core.ad.AdType;
import com.kc.dw.core.ad.banner.BannerCommonAdLoader;
import com.kc.dw.core.ad.draw.DrawCommonAdLoader;
import com.kc.dw.core.ad.fullscreenvideo.FullScreenVideoCommonAdLoader;
import com.kc.dw.core.ad.interstitial.InterstitialCommonAdLoader;
import com.kc.dw.core.ad.paster.PasterCommonAdLoader;
import com.kc.dw.core.ad.recycler.RecyclerMixCommonAdLoader;
import com.kc.dw.core.ad.reward.RewardVideoCommonLoader;
import com.kc.dw.core.ad.splash.SplashCommonAdLoader;
import com.kc.dw.core.b;
import com.kc.dw.core.c;
import com.kc.dw.core.domain.SdkAdInfo;
import com.kc.dw.core.domain.SsdAdInfo;
import com.kc.dw.platform.BasePlatformLoader;
import com.kc.dw.platform.custom.banner.MsCustomBannerAdapter;
import com.kc.dw.platform.custom.ca.intertitial.IntertitialChangeAdapter;
import com.kc.dw.platform.custom.ca.splash.SplashChangeAdapter;
import com.kc.dw.platform.custom.draw.MsCustomDrawAdapter;
import com.kc.dw.platform.custom.fullscreen.MsCustomFullScreenAdapter;
import com.kc.dw.platform.custom.interstitial.MsCustomInterstitialAdapter;
import com.kc.dw.platform.custom.paster.MsCustomPasterAdapter;
import com.kc.dw.platform.custom.recycler.MsCustomRecyclerAdapter;
import com.kc.dw.platform.custom.reward.MsCustomRewardAdapter;
import com.kc.dw.platform.custom.splash.MsCustomSplashAdapter;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.reflect.Constructor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class CustomSdkPlatform extends b {
    @Override // com.kc.dw.core.b
    public MsCustomBannerAdapter bannerLoader(BannerCommonAdLoader bannerCommonAdLoader, SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        try {
            Constructor<?> constructor = Class.forName(sdkAdInfo.getCls()).getConstructor(new Class[0]);
            constructor.setAccessible(true);
            return (MsCustomBannerAdapter) constructor.newInstance(new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kc.dw.core.b
    public c createConfig() {
        return new MsCustomAdConfig();
    }

    @Override // com.kc.dw.core.b
    public MsCustomDrawAdapter drawLoader(DrawCommonAdLoader drawCommonAdLoader, SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        try {
            Constructor<?> constructor = Class.forName(sdkAdInfo.getCls()).getConstructor(new Class[0]);
            constructor.setAccessible(true);
            return (MsCustomDrawAdapter) constructor.newInstance(new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kc.dw.core.b
    public MsCustomFullScreenAdapter fullScreenVideoLoader(FullScreenVideoCommonAdLoader fullScreenVideoCommonAdLoader, SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        try {
            Constructor<?> constructor = Class.forName(sdkAdInfo.getCls()).getConstructor(new Class[0]);
            constructor.setAccessible(true);
            return (MsCustomFullScreenAdapter) constructor.newInstance(new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kc.dw.core.b
    public MsCustomInterstitialAdapter interstitialLoader(InterstitialCommonAdLoader interstitialCommonAdLoader, SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        try {
            Constructor<?> constructor = Class.forName(sdkAdInfo.getCls()).getConstructor(new Class[0]);
            constructor.setAccessible(true);
            Object objNewInstance = constructor.newInstance(new Object[0]);
            return objNewInstance instanceof MsCustomInterstitialAdapter ? (MsCustomInterstitialAdapter) objNewInstance : new IntertitialChangeAdapter((BasePlatformLoader) objNewInstance);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kc.dw.core.b
    public com.kc.dw.core.loader.b pasterLoader(PasterCommonAdLoader pasterCommonAdLoader, SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        try {
            Constructor<?> constructor = Class.forName(sdkAdInfo.getCls()).getConstructor(new Class[0]);
            constructor.setAccessible(true);
            return (MsCustomPasterAdapter) constructor.newInstance(new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kc.dw.core.b
    public MsCustomRecyclerAdapter recyclerLoader(RecyclerMixCommonAdLoader recyclerMixCommonAdLoader, SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        try {
            Constructor<?> constructor = Class.forName(sdkAdInfo.getCls()).getConstructor(new Class[0]);
            constructor.setAccessible(true);
            return (MsCustomRecyclerAdapter) constructor.newInstance(new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kc.dw.core.b
    public MsCustomRewardAdapter rewardLoader(RewardVideoCommonLoader rewardVideoCommonLoader, SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        try {
            Constructor<?> constructor = Class.forName(sdkAdInfo.getCls()).getConstructor(new Class[0]);
            constructor.setAccessible(true);
            return (MsCustomRewardAdapter) constructor.newInstance(new Object[0]);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override // com.kc.dw.core.b
    public MsCustomSplashAdapter splashLoader(SplashCommonAdLoader splashCommonAdLoader, SdkAdInfo sdkAdInfo, SsdAdInfo ssdAdInfo) {
        try {
            Constructor<?> constructor = Class.forName(sdkAdInfo.getCls()).getConstructor(new Class[0]);
            constructor.setAccessible(true);
            Object objNewInstance = constructor.newInstance(new Object[0]);
            return objNewInstance instanceof MsCustomSplashAdapter ? (MsCustomSplashAdapter) objNewInstance : new SplashChangeAdapter((BasePlatformLoader) objNewInstance, ssdAdInfo);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public AdType[] support() {
        return new AdType[]{AdType.FEED_MIX, AdType.BANNER, AdType.SPLASH, AdType.INTERSTITIAL, AdType.REWARD, AdType.DRAW, AdType.FULL_SCREEN_VIDEO};
    }
}
