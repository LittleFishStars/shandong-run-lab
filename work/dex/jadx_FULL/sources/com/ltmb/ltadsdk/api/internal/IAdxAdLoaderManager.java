package com.ltmb.ltadsdk.api.internal;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.ltmb.ltadsdk.api.internal.listener.SYInnerBannerAdLoaderListener;
import com.ltmb.ltadsdk.api.internal.listener.SYInnerFeedExpressAdLoaderListener;
import com.ltmb.ltadsdk.api.internal.listener.SYInnerInterstitialAdLoaderListener;
import com.ltmb.ltadsdk.api.internal.listener.SYInnerNativeAdLoaderListener;
import com.ltmb.ltadsdk.api.internal.listener.SYInnerRewardVideoAdLoaderListener;
import com.ltmb.ltadsdk.api.internal.listener.SYInnerSplashAdLoaderListener;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\u0018\u0010\t\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\bH\u0016J\u0018\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\nH\u0016J\u0018\u0010\r\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\fH\u0016J\u0018\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u000eH\u0016J\u0018\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0010H\u0016¨\u0006\u0012"}, d2 = {"Lcom/ltmb/ltadsdk/api/internal/IAdxAdLoaderManager;", "", "Lcom/ltmb/ltadsdk/api/internal/AdLoadParamsExt;", "params", "Lcom/ltmb/ltadsdk/api/internal/listener/SYInnerSplashAdLoaderListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "", "loadSplashAd", "Lcom/ltmb/ltadsdk/api/internal/listener/SYInnerInterstitialAdLoaderListener;", "loadInterstitialAd", "Lcom/ltmb/ltadsdk/api/internal/listener/SYInnerRewardVideoAdLoaderListener;", "loadRewardVideoAd", "Lcom/ltmb/ltadsdk/api/internal/listener/SYInnerFeedExpressAdLoaderListener;", "loadFeedExpressAd", "Lcom/ltmb/ltadsdk/api/internal/listener/SYInnerBannerAdLoaderListener;", "loadBannerAd", "Lcom/ltmb/ltadsdk/api/internal/listener/SYInnerNativeAdLoaderListener;", "loadNativeAd", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface IAdxAdLoaderManager {

    @Metadata(bv = {1, 0, 3}, d1 = {}, d2 = {}, k = 3, mv = {1, 4, 0})
    public static final class DefaultImpls {
        public static void loadBannerAd(@NotNull IAdxAdLoaderManager iAdxAdLoaderManager, @NotNull AdLoadParamsExt adLoadParamsExt, @NotNull SYInnerBannerAdLoaderListener sYInnerBannerAdLoaderListener) {
            Intrinsics.checkNotNullParameter(adLoadParamsExt, "params");
            Intrinsics.checkNotNullParameter(sYInnerBannerAdLoaderListener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        }

        public static void loadFeedExpressAd(@NotNull IAdxAdLoaderManager iAdxAdLoaderManager, @NotNull AdLoadParamsExt adLoadParamsExt, @NotNull SYInnerFeedExpressAdLoaderListener sYInnerFeedExpressAdLoaderListener) {
            Intrinsics.checkNotNullParameter(adLoadParamsExt, "params");
            Intrinsics.checkNotNullParameter(sYInnerFeedExpressAdLoaderListener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        }

        public static void loadInterstitialAd(@NotNull IAdxAdLoaderManager iAdxAdLoaderManager, @NotNull AdLoadParamsExt adLoadParamsExt, @NotNull SYInnerInterstitialAdLoaderListener sYInnerInterstitialAdLoaderListener) {
            Intrinsics.checkNotNullParameter(adLoadParamsExt, "params");
            Intrinsics.checkNotNullParameter(sYInnerInterstitialAdLoaderListener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        }

        public static void loadNativeAd(@NotNull IAdxAdLoaderManager iAdxAdLoaderManager, @NotNull AdLoadParamsExt adLoadParamsExt, @NotNull SYInnerNativeAdLoaderListener sYInnerNativeAdLoaderListener) {
            Intrinsics.checkNotNullParameter(adLoadParamsExt, "params");
            Intrinsics.checkNotNullParameter(sYInnerNativeAdLoaderListener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        }

        public static void loadRewardVideoAd(@NotNull IAdxAdLoaderManager iAdxAdLoaderManager, @NotNull AdLoadParamsExt adLoadParamsExt, @NotNull SYInnerRewardVideoAdLoaderListener sYInnerRewardVideoAdLoaderListener) {
            Intrinsics.checkNotNullParameter(adLoadParamsExt, "params");
            Intrinsics.checkNotNullParameter(sYInnerRewardVideoAdLoaderListener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        }

        public static void loadSplashAd(@NotNull IAdxAdLoaderManager iAdxAdLoaderManager, @NotNull AdLoadParamsExt adLoadParamsExt, @NotNull SYInnerSplashAdLoaderListener sYInnerSplashAdLoaderListener) {
            Intrinsics.checkNotNullParameter(adLoadParamsExt, "params");
            Intrinsics.checkNotNullParameter(sYInnerSplashAdLoaderListener, ServiceSpecificExtraArgs.CastExtraArgs.f31291a);
        }
    }

    void loadBannerAd(@NotNull AdLoadParamsExt params, @NotNull SYInnerBannerAdLoaderListener listener);

    void loadFeedExpressAd(@NotNull AdLoadParamsExt params, @NotNull SYInnerFeedExpressAdLoaderListener listener);

    void loadInterstitialAd(@NotNull AdLoadParamsExt params, @NotNull SYInnerInterstitialAdLoaderListener listener);

    void loadNativeAd(@NotNull AdLoadParamsExt params, @NotNull SYInnerNativeAdLoaderListener listener);

    void loadRewardVideoAd(@NotNull AdLoadParamsExt params, @NotNull SYInnerRewardVideoAdLoaderListener listener);

    void loadSplashAd(@NotNull AdLoadParamsExt params, @NotNull SYInnerSplashAdLoaderListener listener);
}
