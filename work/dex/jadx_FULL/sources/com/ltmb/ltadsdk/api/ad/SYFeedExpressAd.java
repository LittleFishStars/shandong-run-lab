package com.ltmb.ltadsdk.api.ad;

import android.content.Context;
import android.view.View;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001\fJ\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0012\u0010\t\u001a\u0004\u0018\u00010\b2\u0006\u0010\u0007\u001a\u00020\u0006H&J\b\u0010\u000b\u001a\u00020\nH&¨\u0006\r"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/SYFeedExpressAd;", "Lcom/ltmb/ltadsdk/api/ad/ClientBiddingAd;", "Lcom/ltmb/ltadsdk/api/ad/SYFeedExpressAd$AdInteractionListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "", "setAdInteractionListener", "Landroid/content/Context;", "context", "Landroid/view/View;", "render", "", "getTemplate", "AdInteractionListener", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface SYFeedExpressAd extends ClientBiddingAd {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0018\u0010\n\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\t\u001a\u00020\bH&¨\u0006\u000b"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/SYFeedExpressAd$AdInteractionListener;", "", "Lcom/ltmb/ltadsdk/api/ad/SYFeedExpressAd;", "ad", "", "onFeedAdShow", "onFeedAdClick", "onFeedAdClose", "Lcom/ltmb/ltadsdk/api/ad/AdError;", "error", "onFeedAdRenderFail", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public interface AdInteractionListener {
        void onFeedAdClick(@NotNull SYFeedExpressAd ad);

        void onFeedAdClose(@NotNull SYFeedExpressAd ad);

        void onFeedAdRenderFail(@NotNull SYFeedExpressAd ad, @NotNull AdError error);

        void onFeedAdShow(@NotNull SYFeedExpressAd ad);
    }

    int getTemplate();

    @Nullable
    View render(@NotNull Context context);

    void setAdInteractionListener(@NotNull AdInteractionListener listener);
}
