package com.ltmb.ltadsdk.api.ad;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bf\u0018\u00002\u00020\u0001:\u0002%&J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\n\u0010\u0006\u001a\u0004\u0018\u00010\u0005H&J\u0010\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007H&J\u0010\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\nH&J\u0014\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH&J\b\u0010\u0013\u001a\u00020\u0012H&J\b\u0010\u0015\u001a\u00020\u0014H&J\n\u0010\u0017\u001a\u0004\u0018\u00010\u0016H&J\b\u0010\u0018\u001a\u00020\u0012H&J(\u0010\u001e\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00100\u001b2\b\u0010\u000b\u001a\u0004\u0018\u00010\u001dH&J\u0010\u0010 \u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\u001fH&J\n\u0010\"\u001a\u0004\u0018\u00010!H&J\b\u0010#\u001a\u00020\u0002H&J\b\u0010$\u001a\u00020\u0002H&¨\u0006'"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/SYNativeAd;", "Lcom/ltmb/ltadsdk/api/ad/ClientBiddingAd;", "", "getTitle", "getDescription", "Lcom/ltmb/ltadsdk/api/ad/SYAdComplianceInfo;", "getComplianceInfo", "", "Lcom/ltmb/ltadsdk/api/ad/SYImage;", "getImageList", "Lcom/ltmb/ltadsdk/api/ad/SYDownloadListener;", ServiceSpecificExtraArgs.CastExtraArgs.f31291a, "", "setDownloadListener", "Landroid/content/Context;", "context", "Landroid/view/View;", "getVideoView", "", "getTemplateType", "", "isDownloadApp", "Lcom/ltmb/ltadsdk/api/ad/SYVideoInfo;", "getCustomVideo", "getDownloadStatus", "Landroid/view/ViewGroup;", "container", "", "clickViews", "Lcom/ltmb/ltadsdk/api/ad/SYNativeAd$AdInteractionListener;", "registerViewForInteraction", "Lcom/ltmb/ltadsdk/api/ad/SYNativeAd$AdVideoListener;", "setVideoListener", "Landroid/graphics/Bitmap;", "getAdLogo", "getAdIcon", "getButtonText", "AdInteractionListener", "AdVideoListener", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
public interface SYNativeAd extends ClientBiddingAd {

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&J\u0010\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/SYNativeAd$AdInteractionListener;", "", "Lcom/ltmb/ltadsdk/api/ad/SYNativeAd;", "ad", "", "onAdClicked", "onAdShow", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public interface AdInteractionListener {
        void onAdClicked(@NotNull SYNativeAd ad);

        void onAdShow(@NotNull SYNativeAd ad);
    }

    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bf\u0018\u00002\u00020\u0001J\b\u0010\u0003\u001a\u00020\u0002H&J\b\u0010\u0004\u001a\u00020\u0002H&J\b\u0010\u0005\u001a\u00020\u0002H&J\b\u0010\u0006\u001a\u00020\u0002H&¨\u0006\u0007"}, d2 = {"Lcom/ltmb/ltadsdk/api/ad/SYNativeAd$AdVideoListener;", "", "", "onVideoStart", "onVideoPause", "onVideoError", "onVideoComplete", "ADAarBuild_ltmbRelease"}, k = 1, mv = {1, 4, 0})
    public interface AdVideoListener {
        void onVideoComplete();

        void onVideoError();

        void onVideoPause();

        void onVideoStart();
    }

    @NotNull
    String getAdIcon();

    @Nullable
    Bitmap getAdLogo();

    @NotNull
    String getButtonText();

    @Nullable
    SYAdComplianceInfo getComplianceInfo();

    @Nullable
    SYVideoInfo getCustomVideo();

    @NotNull
    String getDescription();

    int getDownloadStatus();

    @Nullable
    List<SYImage> getImageList();

    int getTemplateType();

    @NotNull
    String getTitle();

    @Nullable
    View getVideoView(@Nullable Context context);

    boolean isDownloadApp();

    void registerViewForInteraction(@NotNull ViewGroup container, @NotNull List<View> clickViews, @Nullable AdInteractionListener listener);

    void setDownloadListener(@NotNull SYDownloadListener listener);

    void setVideoListener(@NotNull AdVideoListener listener);
}
