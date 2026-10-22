package com.ltmb.ltadsdk.api.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ltmb.ltadsdk.api.SYAdLoadParams;
import com.ltmb.ltadsdk.api.listener.SYBannerAdLoaderListener;
import com.ltmb.ltadsdk.api.listener.SYFeedExpressAdLoaderListener;
import com.ltmb.ltadsdk.api.listener.SYInterstitialAdLoaderListener;
import com.ltmb.ltadsdk.api.listener.SYNativeAdLoaderListener;
import com.ltmb.ltadsdk.api.listener.SYRewardVideoAdLoaderListener;
import com.ltmb.ltadsdk.api.listener.SYSplashAdLoaderListener;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004H&J\u001c\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\bH&J\u001c\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\nH&J\u001c\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\fH&J\u001c\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u000eH&J\u001c\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0010H&¨\u0006\u0012"}, d2 = {"Lcom/ltmb/ltadsdk/api/internal/SYAdManager;", "", "Lcom/ltmb/ltadsdk/api/SYAdLoadParams;", "params", "Lcom/ltmb/ltadsdk/api/listener/SYSplashAdLoaderListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "", "loadSplashAd", "Lcom/ltmb/ltadsdk/api/listener/SYFeedExpressAdLoaderListener;", "loadFeedExpressAd", "Lcom/ltmb/ltadsdk/api/listener/SYInterstitialAdLoaderListener;", "loadInterstitialAd", "Lcom/ltmb/ltadsdk/api/listener/SYRewardVideoAdLoaderListener;", "loadRewardAd", "Lcom/ltmb/ltadsdk/api/listener/SYNativeAdLoaderListener;", "loadNativeAd", "Lcom/ltmb/ltadsdk/api/listener/SYBannerAdLoaderListener;", "loadBannerAd", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface SYAdManager {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static /* synthetic */ void loadBannerAd$default(SYAdManager sYAdManager, SYAdLoadParams sYAdLoadParams, SYBannerAdLoaderListener sYBannerAdLoaderListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadBannerAd");
            }
            if ((i & 2) != 0) {
                sYBannerAdLoaderListener = null;
            }
            sYAdManager.loadBannerAd(sYAdLoadParams, sYBannerAdLoaderListener);
        }

        public static /* synthetic */ void loadFeedExpressAd$default(SYAdManager sYAdManager, SYAdLoadParams sYAdLoadParams, SYFeedExpressAdLoaderListener sYFeedExpressAdLoaderListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadFeedExpressAd");
            }
            if ((i & 2) != 0) {
                sYFeedExpressAdLoaderListener = null;
            }
            sYAdManager.loadFeedExpressAd(sYAdLoadParams, sYFeedExpressAdLoaderListener);
        }

        public static /* synthetic */ void loadInterstitialAd$default(SYAdManager sYAdManager, SYAdLoadParams sYAdLoadParams, SYInterstitialAdLoaderListener sYInterstitialAdLoaderListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadInterstitialAd");
            }
            if ((i & 2) != 0) {
                sYInterstitialAdLoaderListener = null;
            }
            sYAdManager.loadInterstitialAd(sYAdLoadParams, sYInterstitialAdLoaderListener);
        }

        public static /* synthetic */ void loadNativeAd$default(SYAdManager sYAdManager, SYAdLoadParams sYAdLoadParams, SYNativeAdLoaderListener sYNativeAdLoaderListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadNativeAd");
            }
            if ((i & 2) != 0) {
                sYNativeAdLoaderListener = null;
            }
            sYAdManager.loadNativeAd(sYAdLoadParams, sYNativeAdLoaderListener);
        }

        public static /* synthetic */ void loadRewardAd$default(SYAdManager sYAdManager, SYAdLoadParams sYAdLoadParams, SYRewardVideoAdLoaderListener sYRewardVideoAdLoaderListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadRewardAd");
            }
            if ((i & 2) != 0) {
                sYRewardVideoAdLoaderListener = null;
            }
            sYAdManager.loadRewardAd(sYAdLoadParams, sYRewardVideoAdLoaderListener);
        }

        public static /* synthetic */ void loadSplashAd$default(SYAdManager sYAdManager, SYAdLoadParams sYAdLoadParams, SYSplashAdLoaderListener sYSplashAdLoaderListener, int i, Object obj) {
            if (obj != null) {
                throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: loadSplashAd");
            }
            if ((i & 2) != 0) {
                sYSplashAdLoaderListener = null;
            }
            sYAdManager.loadSplashAd(sYAdLoadParams, sYSplashAdLoaderListener);
        }
    }

    void loadBannerAd(@NotNull SYAdLoadParams params, @Nullable SYBannerAdLoaderListener listener);

    void loadFeedExpressAd(@NotNull SYAdLoadParams params, @Nullable SYFeedExpressAdLoaderListener listener);

    void loadInterstitialAd(@NotNull SYAdLoadParams params, @Nullable SYInterstitialAdLoaderListener listener);

    void loadNativeAd(@NotNull SYAdLoadParams params, @Nullable SYNativeAdLoaderListener listener);

    void loadRewardAd(@NotNull SYAdLoadParams params, @Nullable SYRewardVideoAdLoaderListener listener);

    void loadSplashAd(@NotNull SYAdLoadParams params, @Nullable SYSplashAdLoaderListener listener);
}
