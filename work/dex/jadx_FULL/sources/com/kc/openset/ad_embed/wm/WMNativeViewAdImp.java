package com.kc.openset.ad_embed.wm;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bean.QDImages;
import com.kc.openset.sdk.adv.OSETQDNativeViewAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class WMNativeViewAdImp implements OSETQDNativeViewAd {
    private final WMNativeViewAdData adData;
    private OSETQDNativeViewAd.OnQDAdInteractionListener qdAdInteractionListener;
    private QDNativeViewInnerListener qdNativeViewInnerListener;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.wm.WMNativeViewAdImp$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements View.OnClickListener {
        final WMNativeViewAdImp this$0;
        final Context val$context;
        final String val$url;
        final int val$urlType;

        static {
            OSETSDKProtected.interface11(4193);
        }

        public AnonymousClass1(WMNativeViewAdImp wMNativeViewAdImp, Context context, String str, int i) {
            this.this$0 = wMNativeViewAdImp;
            this.val$context = context;
            this.val$url = str;
            this.val$urlType = i;
        }

        @Override // android.view.View.OnClickListener
        public native void onClick(View view);
    }

    @Keep
    public interface QDNativeViewInnerListener {
        View getVideoView(Context context);

        boolean isUsable();

        void onRegisterView(ViewGroup viewGroup, List<View> list, View view);
    }

    static {
        OSETSDKProtected.interface11(4195);
    }

    public WMNativeViewAdImp(WMNativeViewAdData wMNativeViewAdData) {
        this.adData = wMNativeViewAdData;
    }

    private native void bindToWebPage(Context context, TextView textView, String str, int i);

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native void bindPrivacyInfoClickListener(Context context, TextView textView, TextView textView2, TextView textView3);

    public native void bindQDNativeViewInnerListener(QDNativeViewInnerListener qDNativeViewInnerListener);

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native boolean enableRotate();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAdActionText();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAdContent();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native int getAdEcpm();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAdIcon();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native List<QDImages> getAdImageUrls();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAdSource();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAdSourceImg();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAdTitle();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAppDeveloper();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAppName();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAppPrivacyInfoUrl();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getAppVersion();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getIntroductionInfoUrl();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getPackageName();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getPermissionInfoUrl();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getRequestId();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native View getRotateView(Context context);

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native String getVideoCoverImageUrl();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native View getVideoView(Context context);

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native boolean isAppInfoVisibility();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native boolean isUsable();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native boolean isVideoMaterial();

    public native void onAdClick();

    public native void onAdClose();

    public native void onAdShow();

    @Override // com.kc.openset.sdk.adv.OSETQDNativeViewAd
    public native void registerViewForInteraction(Activity activity, ViewGroup viewGroup, View view, View view2, List<View> list, OSETQDNativeViewAd.OnQDAdInteractionListener onQDAdInteractionListener);
}
