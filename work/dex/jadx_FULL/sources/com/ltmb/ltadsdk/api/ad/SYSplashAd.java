package com.ltmb.ltadsdk.api.ad;

import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\nJ\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0012\u0010\u0006\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H&J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0007H&¨\u0006\u000b"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/SYSplashAd;", "Lcom/ltmb/ltadsdk/api/ad/ClientBiddingAd;", "Landroid/view/ViewGroup;", "container", "", "showSplashView", "showFullSplashView", "Lcom/ltmb/ltadsdk/api/ad/SYSplashAd$AdInteractionListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "setAdInteractionListener", "AdInteractionListener", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface SYSplashAd extends ClientBiddingAd {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\n\u001a\u00020\tH&¨\u0006\f"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/SYSplashAd$AdInteractionListener;", "", "Lcom/ltmb/ltadsdk/api/ad/SYSplashAd;", "splashAd", "", "onSplashAdShow", "onSplashAdClick", "onSplashAdClose", "onSplashAdSkip", "Lcom/ltmb/ltadsdk/api/ad/AdError;", "error", "onSplashAdShowFail", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public interface AdInteractionListener {
        void onSplashAdClick(@NotNull SYSplashAd splashAd);

        void onSplashAdClose(@NotNull SYSplashAd splashAd);

        void onSplashAdShow(@NotNull SYSplashAd splashAd);

        void onSplashAdShowFail(@NotNull SYSplashAd splashAd, @NotNull AdError error);

        void onSplashAdSkip(@NotNull SYSplashAd splashAd);
    }

    void setAdInteractionListener(@NotNull AdInteractionListener listener);

    void showFullSplashView(@Nullable ViewGroup container);

    void showSplashView(@Nullable ViewGroup container);
}
