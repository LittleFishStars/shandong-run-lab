package com.ipd.dsp.ad;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Keep;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.ipd.dsp.api.IBid;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public interface DspNativeAd extends IBid {

    @Keep
    public interface AppMiitInfo {
        @Nullable
        @Keep
        String getAppName();

        @Nullable
        @Keep
        String getAuthorName();

        @Nullable
        @Keep
        String getDescriptionUrl();

        @Nullable
        @Keep
        String getIcpInfoUrl();

        @Nullable
        @Keep
        String getIcpNumber();

        @Nullable
        @Keep
        String getPackageName();

        @Keep
        long getPackageSizeBytes();

        @NonNull
        @Keep
        @Deprecated
        List<String> getPermissions();

        @Nullable
        @Keep
        String getPermissionsUrl();

        @Nullable
        @Keep
        String getPrivacyAgreement();

        @Nullable
        @Keep
        String getSuitableAge();

        @Nullable
        @Keep
        String getVersionName();
    }

    @Keep
    public interface InteractionListener {
        @Keep
        void onDownloadConfirmDialogDismiss();

        @Keep
        void onDownloadConfirmDialogShow();

        @Keep
        void onNativeAdClick();

        @Keep
        void onNativeAdError(int i, String str);

        @Keep
        void onNativeAdShow();
    }

    @Keep
    @Retention(RetentionPolicy.SOURCE)
    public @interface MaterialType {

        @Keep
        public static final int IMAGE = 1;

        @Keep
        public static final int VIDEO = 3;
    }

    @Keep
    public interface VideoListener {
        void onVideoPlayComplete();

        void onVideoPlayError(int i, String str);

        void onVideoPlayStart();
    }

    @Keep
    void bindAdView(ViewGroup viewGroup, List<View> list, List<View> list2);

    @Keep
    void bindVideoView(ViewGroup viewGroup, boolean z, VideoListener videoListener);

    @Keep
    void bindVideoView(ViewGroup viewGroup, boolean z, boolean z2, VideoListener videoListener);

    @Nullable
    @Keep
    AppMiitInfo getAppMiitInfo();

    @Keep
    String getCTAText();

    @Keep
    String getDesc();

    @Keep
    String getIcon();

    @Keep
    String getImage();

    @Keep
    int getMaterialType();

    @Keep
    String getRequestId();

    @Keep
    String getSourceLogo();

    @Keep
    String getSourceName();

    @Keep
    String getTitle();

    @Keep
    boolean isAppAd();

    @Keep
    void isDimBehind(boolean z);

    @Keep
    void onDestroy();

    @Keep
    void setInteractionListener(InteractionListener interactionListener);
}
