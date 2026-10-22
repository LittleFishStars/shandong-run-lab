package com.ipd.dsp.internal.l1;

import androidx.annotation.NonNull;
import com.ipd.dsp.api.DspLoadManager;
import com.ipd.dsp.internal.g1.d;
import com.ipd.dsp.internal.g1.e;
import com.ipd.dsp.internal.g1.f;
import com.ipd.dsp.internal.g1.g;
import com.ipd.dsp.internal.g1.h;
import com.ipd.dsp.internal.g1.i;
import com.ipd.dsp.request.DspBannerAdRequest;
import com.ipd.dsp.request.DspDrawAdRequest;
import com.ipd.dsp.request.DspInterstitialAdRequest;
import com.ipd.dsp.request.DspNativeAdRequest;
import com.ipd.dsp.request.DspNativeExpressAdRequest;
import com.ipd.dsp.request.DspRewardVideoAdRequest;
import com.ipd.dsp.request.DspSplashAdRequest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class b implements DspLoadManager {
    @Override // com.ipd.dsp.api.DspLoadManager
    public void loadBannerAd(@NonNull DspBannerAdRequest dspBannerAdRequest, @NonNull DspLoadManager.BannerAdListener bannerAdListener) {
        new com.ipd.dsp.internal.g1.b().a(dspBannerAdRequest, bannerAdListener);
    }

    @Override // com.ipd.dsp.api.DspLoadManager
    public void loadDrawAd(@NonNull DspDrawAdRequest dspDrawAdRequest, @NonNull DspLoadManager.DrawAdListener drawAdListener) {
        new d().a(dspDrawAdRequest, drawAdListener);
    }

    @Override // com.ipd.dsp.api.DspLoadManager
    public void loadInterstitialAd(@NonNull DspInterstitialAdRequest dspInterstitialAdRequest, @NonNull DspLoadManager.InterstitialAdListener interstitialAdListener) {
        new e().a(dspInterstitialAdRequest, interstitialAdListener);
    }

    @Override // com.ipd.dsp.api.DspLoadManager
    public void loadNativeAd(@NonNull DspNativeAdRequest dspNativeAdRequest, @NonNull DspLoadManager.NativeAdListener nativeAdListener) {
        new f().a(dspNativeAdRequest, nativeAdListener);
    }

    @Override // com.ipd.dsp.api.DspLoadManager
    public void loadNativeExpressAd(@NonNull DspNativeExpressAdRequest dspNativeExpressAdRequest, @NonNull DspLoadManager.NativeExpressAdListener nativeExpressAdListener) {
        new g().a(dspNativeExpressAdRequest, nativeExpressAdListener);
    }

    @Override // com.ipd.dsp.api.DspLoadManager
    public void loadRewardVideoAd(@NonNull DspRewardVideoAdRequest dspRewardVideoAdRequest, @NonNull DspLoadManager.RewardVideoAdListener rewardVideoAdListener) {
        new h().a(dspRewardVideoAdRequest, rewardVideoAdListener);
    }

    @Override // com.ipd.dsp.api.DspLoadManager
    public void loadSplashAd(@NonNull DspSplashAdRequest dspSplashAdRequest, @NonNull DspLoadManager.SplashAdListener splashAdListener) {
        new i().a(dspSplashAdRequest, splashAdListener);
    }
}
