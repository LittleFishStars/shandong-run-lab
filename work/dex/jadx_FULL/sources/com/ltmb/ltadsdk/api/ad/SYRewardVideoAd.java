package com.ltmb.ltadsdk.api.ad;

import android.app.Activity;
import com.byazt.hv.TTDownloadField;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bf\u0018\u00002\u00020\u0001:\u0001\tJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\b\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0006H&¨\u0006\n"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/SYRewardVideoAd;", "Lcom/ltmb/ltadsdk/api/ad/ClientBiddingAd;", "Landroid/app/Activity;", TTDownloadField.TT_ACTIVITY, "", "show", "Lcom/ltmb/ltadsdk/api/ad/SYRewardVideoAd$AdInteractionListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "setAdInteractionListener", "AdInteractionListener", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface SYRewardVideoAd extends ClientBiddingAd {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\f\u001a\u00020\u0004H&¨\u0006\r"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/SYRewardVideoAd$AdInteractionListener;", "", "Lcom/ltmb/ltadsdk/api/ad/SYRewardVideoAd;", "ad", "", "onRewardAdShow", "onRewardAdClick", "onRewardAdClose", "Lcom/ltmb/ltadsdk/api/ad/AdError;", "error", "onVideoError", "onRewardArrived", "onVideoComplete", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public interface AdInteractionListener {
        void onRewardAdClick(@NotNull SYRewardVideoAd ad);

        void onRewardAdClose(@NotNull SYRewardVideoAd ad);

        void onRewardAdShow(@NotNull SYRewardVideoAd ad);

        void onRewardArrived(@NotNull SYRewardVideoAd ad);

        void onVideoComplete();

        void onVideoError(@NotNull SYRewardVideoAd ad, @NotNull AdError error);
    }

    void setAdInteractionListener(@NotNull AdInteractionListener listener);

    void show(@NotNull Activity activity);
}
