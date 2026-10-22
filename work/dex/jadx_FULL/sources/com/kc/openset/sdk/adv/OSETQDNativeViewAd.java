package com.kc.openset.sdk.adv;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.kc.openset.bean.QDImages;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public interface OSETQDNativeViewAd {

    @Keep
    public interface OnQDAdInteractionListener {
        void onAdClicked(OSETQDNativeViewAd oSETQDNativeViewAd);

        void onAdClosed(OSETQDNativeViewAd oSETQDNativeViewAd);

        void onAdDetailViewClosed(OSETQDNativeViewAd oSETQDNativeViewAd);

        void onAdShow(OSETQDNativeViewAd oSETQDNativeViewAd);
    }

    void bindPrivacyInfoClickListener(Context context, TextView textView, TextView textView2, TextView textView3);

    boolean enableRotate();

    String getAdActionText();

    String getAdContent();

    int getAdEcpm();

    String getAdIcon();

    List<QDImages> getAdImageUrls();

    String getAdSource();

    String getAdSourceImg();

    String getAdTitle();

    String getAppDeveloper();

    String getAppName();

    String getAppPrivacyInfoUrl();

    String getAppVersion();

    String getIntroductionInfoUrl();

    String getPackageName();

    String getPermissionInfoUrl();

    String getRequestId();

    View getRotateView(Context context);

    String getVideoCoverImageUrl();

    View getVideoView(Context context);

    boolean isAppInfoVisibility();

    boolean isUsable();

    boolean isVideoMaterial();

    void registerViewForInteraction(Activity activity, ViewGroup viewGroup, View view, View view2, List<View> list, OnQDAdInteractionListener onQDAdInteractionListener);
}
