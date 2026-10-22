package cn.jy.ad.sdk.jyinter;

import cn.jy.ad.sdk.jyapi.JyBanner;
import cn.jy.ad.sdk.jyapi.JyDraw;
import cn.jy.ad.sdk.jyapi.JyFeed;
import cn.jy.ad.sdk.jyapi.JyFullScreenVideo;
import cn.jy.ad.sdk.jyapi.JyInterstitial;
import cn.jy.ad.sdk.jyapi.JyNativeExpress;
import cn.jy.ad.sdk.jyapi.JyRewardVideo;
import cn.jy.ad.sdk.jyapi.JySplash;
import cn.jy.ad.sdk.jycfg.AdCode;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface JyAdNative {

    public interface AdS2STokenListener extends AdViewErrorListener {
        void onTokenReceived(String str);
    }

    public interface BannerAdLoadListener extends AdViewErrorListener {
        void onBannerAdLoad(JyBanner jyBanner);
    }

    public interface DrawAdLoadListener extends AdViewErrorListener {
        void onDrawAdLoad(List<JyDraw> list);
    }

    public interface FeedAdLoadListener extends AdViewErrorListener {
        void onFeedAdLoad(List<JyFeed> list);
    }

    public interface FullScreenVideoAdLoadListener extends AdViewErrorListener {
        void onFullScreenVideoAdLoad(JyFullScreenVideo jyFullScreenVideo);
    }

    public interface InterstitialAdLoadListener extends AdViewErrorListener {
        void onInterstitialAdLoad(JyInterstitial jyInterstitial);
    }

    public interface NativeExpressAdLoadListener extends AdViewErrorListener {
        void onNativeExpressAdLoad(List<JyNativeExpress> list);
    }

    public interface RewardVideoAdLoadListener extends AdViewErrorListener {
        void onRewardVideoAdLoad(JyRewardVideo jyRewardVideo);
    }

    public interface SplashAdLoadListener extends AdViewErrorListener {
        void onSplashAdLoad(JySplash jySplash);
    }

    void destroy();

    void getS2SBidToken(AdCode adCode, AdS2STokenListener adS2STokenListener);

    void loadBannerAd(AdCode adCode, BannerAdLoadListener bannerAdLoadListener);

    void loadDrawVideoAd(AdCode adCode, DrawAdLoadListener drawAdLoadListener);

    void loadFeedAd(AdCode adCode, FeedAdLoadListener feedAdLoadListener);

    @Deprecated
    void loadFullScreenVideoAd(AdCode adCode, FullScreenVideoAdLoadListener fullScreenVideoAdLoadListener);

    void loadInterstitialAd(AdCode adCode, InterstitialAdLoadListener interstitialAdLoadListener);

    void loadNativeExpressAd(AdCode adCode, NativeExpressAdLoadListener nativeExpressAdLoadListener);

    void loadRewardVideoAd(AdCode adCode, RewardVideoAdLoadListener rewardVideoAdLoadListener);

    void loadSplashAd(AdCode adCode, SplashAdLoadListener splashAdLoadListener);
}
