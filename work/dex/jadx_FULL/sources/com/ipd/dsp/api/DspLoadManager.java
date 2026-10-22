package com.ipd.dsp.api;

import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import com.ipd.dsp.ad.DspBannerAd;
import com.ipd.dsp.ad.DspDrawAd;
import com.ipd.dsp.ad.DspInterstitialAd;
import com.ipd.dsp.ad.DspNativeAd;
import com.ipd.dsp.ad.DspNativeExpressAd;
import com.ipd.dsp.ad.DspRewardVideoAd;
import com.ipd.dsp.ad.DspSplashAd;
import com.ipd.dsp.request.DspBannerAdRequest;
import com.ipd.dsp.request.DspDrawAdRequest;
import com.ipd.dsp.request.DspInterstitialAdRequest;
import com.ipd.dsp.request.DspNativeAdRequest;
import com.ipd.dsp.request.DspNativeExpressAdRequest;
import com.ipd.dsp.request.DspRewardVideoAdRequest;
import com.ipd.dsp.request.DspSplashAdRequest;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface DspLoadManager {

    @Keep
    public interface BannerAdListener extends BaseAdListener {
        @Keep
        void onBannerAdLoad(@NonNull List<DspBannerAd> list);
    }

    public interface BaseAdListener {
        @Keep
        void onLoadError(int i, String str);
    }

    @Keep
    public interface DrawAdListener extends BaseAdListener {
        @Keep
        void onDrawAdLoad(@NonNull List<DspDrawAd> list);
    }

    @Keep
    public interface InterstitialAdListener extends BaseAdListener {
        @Keep
        void onInterstitialAdLoad(@NonNull DspInterstitialAd dspInterstitialAd);
    }

    @Keep
    public interface NativeAdListener extends BaseAdListener {
        @Keep
        void onNativeAdLoad(@NonNull List<DspNativeAd> list);
    }

    @Keep
    public interface NativeExpressAdListener extends BaseAdListener {
        @Keep
        void onNativeExpressAdLoad(@NonNull List<DspNativeExpressAd> list);
    }

    @Keep
    public interface RewardVideoAdListener extends BaseAdListener {
        @Keep
        void onRewardVideoAdLoad(@NonNull DspRewardVideoAd dspRewardVideoAd);
    }

    @Keep
    public interface SplashAdListener extends BaseAdListener {
        @Keep
        void onSplashAdLoad(@NonNull DspSplashAd dspSplashAd);
    }

    @Keep
    void loadBannerAd(@NonNull DspBannerAdRequest dspBannerAdRequest, @NonNull BannerAdListener bannerAdListener);

    @Keep
    void loadDrawAd(@NonNull DspDrawAdRequest dspDrawAdRequest, @NonNull DrawAdListener drawAdListener);

    @Keep
    void loadInterstitialAd(@NonNull DspInterstitialAdRequest dspInterstitialAdRequest, @NonNull InterstitialAdListener interstitialAdListener);

    @Keep
    void loadNativeAd(@NonNull DspNativeAdRequest dspNativeAdRequest, @NonNull NativeAdListener nativeAdListener);

    @Keep
    void loadNativeExpressAd(@NonNull DspNativeExpressAdRequest dspNativeExpressAdRequest, @NonNull NativeExpressAdListener nativeExpressAdListener);

    @Keep
    void loadRewardVideoAd(@NonNull DspRewardVideoAdRequest dspRewardVideoAdRequest, @NonNull RewardVideoAdListener rewardVideoAdListener);

    @Keep
    void loadSplashAd(@NonNull DspSplashAdRequest dspSplashAdRequest, @NonNull SplashAdListener splashAdListener);
}
