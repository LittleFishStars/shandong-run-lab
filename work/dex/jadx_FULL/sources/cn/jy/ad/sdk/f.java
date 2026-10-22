package cn.jy.ad.sdk;

import cn.jy.ad.sdk.jycfg.AdCode;
import cn.jy.ad.sdk.jyinter.AdViewErrorListener;
import cn.jy.ad.sdk.jyinter.ILoader;
import cn.jy.ad.sdk.jyinter.JyAdNative;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class f implements JyAdNative {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e<e<ILoader>> f22762a;
    public ILoader b;

    public class a implements e<ILoader> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AdViewErrorListener f22763a;
        public final /* synthetic */ int b;
        public final /* synthetic */ AdCode c;

        public a(AdViewErrorListener adViewErrorListener, int i, AdCode adCode) {
            this.f22763a = adViewErrorListener;
            this.b = i;
            this.c = adCode;
        }

        @Override // cn.jy.ad.sdk.e
        public void a(ILoader iLoader) {
            f.this.b = iLoader;
            if (iLoader == null) {
                AdViewErrorListener adViewErrorListener = this.f22763a;
                if (adViewErrorListener != null) {
                    adViewErrorListener.onError(10003, "加载广告失败，请检查初始化配置");
                    return;
                }
                return;
            }
            try {
                iLoader.loadAd(this.b, cn.jy.ad.sdk.a.a(this.c, this.f22763a));
            } catch (Throwable th) {
                AdViewErrorListener adViewErrorListener2 = this.f22763a;
                if (adViewErrorListener2 != null) {
                    adViewErrorListener2.onError(10004, th.getMessage());
                }
                th.printStackTrace();
            }
        }
    }

    public f(e<e<ILoader>> eVar) {
        this.f22762a = eVar;
    }

    public final void a(int i, AdCode adCode, AdViewErrorListener adViewErrorListener) {
        e<e<ILoader>> eVar = this.f22762a;
        if (eVar != null) {
            eVar.a(new a(adViewErrorListener, i, adCode));
        } else if (adViewErrorListener != null) {
            adViewErrorListener.onError(10005, "广告已经销毁");
        }
    }

    @Override // cn.jy.ad.sdk.jyinter.JyAdNative
    public void destroy() {
        ILoader iLoader = this.b;
        if (iLoader != null) {
            iLoader.destroy();
        }
    }

    @Override // cn.jy.ad.sdk.jyinter.JyAdNative
    public void getS2SBidToken(AdCode adCode, JyAdNative.AdS2STokenListener adS2STokenListener) {
        a(10000, adCode, adS2STokenListener);
    }

    @Override // cn.jy.ad.sdk.jyinter.JyAdNative
    public void loadBannerAd(AdCode adCode, JyAdNative.BannerAdLoadListener bannerAdLoadListener) {
        a(8, adCode, bannerAdLoadListener);
    }

    @Override // cn.jy.ad.sdk.jyinter.JyAdNative
    public void loadDrawVideoAd(AdCode adCode, JyAdNative.DrawAdLoadListener drawAdLoadListener) {
        a(512, adCode, drawAdLoadListener);
    }

    @Override // cn.jy.ad.sdk.jyinter.JyAdNative
    public void loadFeedAd(AdCode adCode, JyAdNative.FeedAdLoadListener feedAdLoadListener) {
        a(32, adCode, feedAdLoadListener);
    }

    @Override // cn.jy.ad.sdk.jyinter.JyAdNative
    public void loadFullScreenVideoAd(AdCode adCode, JyAdNative.FullScreenVideoAdLoadListener fullScreenVideoAdLoadListener) {
        a(256, adCode, fullScreenVideoAdLoadListener);
    }

    @Override // cn.jy.ad.sdk.jyinter.JyAdNative
    public void loadInterstitialAd(AdCode adCode, JyAdNative.InterstitialAdLoadListener interstitialAdLoadListener) {
        a(3, adCode, interstitialAdLoadListener);
    }

    @Override // cn.jy.ad.sdk.jyinter.JyAdNative
    public void loadNativeExpressAd(AdCode adCode, JyAdNative.NativeExpressAdLoadListener nativeExpressAdLoadListener) {
        a(64, adCode, nativeExpressAdLoadListener);
    }

    @Override // cn.jy.ad.sdk.jyinter.JyAdNative
    public void loadRewardVideoAd(AdCode adCode, JyAdNative.RewardVideoAdLoadListener rewardVideoAdLoadListener) {
        a(128, adCode, rewardVideoAdLoadListener);
    }

    @Override // cn.jy.ad.sdk.jyinter.JyAdNative
    public void loadSplashAd(AdCode adCode, JyAdNative.SplashAdLoadListener splashAdLoadListener) {
        a(4, adCode, splashAdLoadListener);
    }
}
