package com.kc.openset.ad_embed.ks_ad.ks_3_3_72;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseBannerBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kwad.sdk.api.KsApkDownloadListener;
import com.kwad.sdk.api.KsAppDownloadListener;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KSBannerAdapter extends BaseBannerBridge implements View.OnClickListener {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT);
    private static final String FRONT = OSETSDKProtected.getString2(743);
    private static final String TAG = OSETSDKProtected.getString2(735);
    private WeakReference<Button> mBtnActWeakReference;
    private WeakReference<ViewGroup> mContainerWeakReference;
    private KsNativeAd mKsNativeAd;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_72.KSBannerAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements KsLoadManager.NativeAdListener {
        final KSBannerAdapter this$0;

        static {
            OSETSDKProtected.interface11(4054);
        }

        public AnonymousClass1(KSBannerAdapter kSBannerAdapter) {
            this.this$0 = kSBannerAdapter;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public native void onError(int i, String str);

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public native void onNativeAdLoad(List<KsNativeAd> list);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_72.KSBannerAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements KsApkDownloadListener {
        final KSBannerAdapter this$0;

        static {
            OSETSDKProtected.interface11(4055);
        }

        public AnonymousClass2(KSBannerAdapter kSBannerAdapter) {
            this.this$0 = kSBannerAdapter;
        }

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public native void onDownloadFailed();

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public native void onDownloadFinished();

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public native void onDownloadStarted();

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public native void onIdle();

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public native void onInstalled();

        @Override // com.kwad.sdk.api.KsApkDownloadListener
        public native void onPaused(int i);

        @Override // com.kwad.sdk.api.KsAppDownloadListener
        public native void onProgressUpdate(int i);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_72.KSBannerAdapter$3, reason: invalid class name */
    @Keep
    public class AnonymousClass3 implements KsNativeAd.AdInteractionListener {
        final KSBannerAdapter this$0;

        static {
            OSETSDKProtected.interface11(4056);
        }

        public AnonymousClass3(KSBannerAdapter kSBannerAdapter) {
            this.this$0 = kSBannerAdapter;
        }

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public native boolean handleDownloadDialog(DialogInterface.OnClickListener onClickListener);

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public native void onAdClicked(View view, KsNativeAd ksNativeAd);

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public native void onAdShow(KsNativeAd ksNativeAd);

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public native void onDownloadTipsDialogDismiss();

        @Override // com.kwad.sdk.api.KsNativeAd.AdInteractionListener
        public native void onDownloadTipsDialogShow();
    }

    static {
        OSETSDKProtected.interface11(4057);
    }

    public static native /* synthetic */ void access$000(KSBannerAdapter kSBannerAdapter, String str, String str2);

    public static native /* synthetic */ void access$100(KSBannerAdapter kSBannerAdapter, String str, String str2);

    public static native /* synthetic */ void access$1000(KSBannerAdapter kSBannerAdapter);

    public static native /* synthetic */ WeakReference access$1100(KSBannerAdapter kSBannerAdapter);

    public static native /* synthetic */ WeakReference access$1200(KSBannerAdapter kSBannerAdapter);

    public static native /* synthetic */ void access$1300(KSBannerAdapter kSBannerAdapter, View view);

    public static native /* synthetic */ void access$1400(KSBannerAdapter kSBannerAdapter, View view);

    public static native /* synthetic */ Context access$200(KSBannerAdapter kSBannerAdapter);

    public static native /* synthetic */ void access$300(KSBannerAdapter kSBannerAdapter, String str, String str2);

    public static native /* synthetic */ void access$400(KSBannerAdapter kSBannerAdapter, String str, String str2);

    public static native /* synthetic */ void access$500(KSBannerAdapter kSBannerAdapter, String str, String str2);

    public static native /* synthetic */ void access$600(KSBannerAdapter kSBannerAdapter, String str, String str2);

    public static native /* synthetic */ KsNativeAd access$702(KSBannerAdapter kSBannerAdapter, KsNativeAd ksNativeAd);

    public static native /* synthetic */ boolean access$800(KSBannerAdapter kSBannerAdapter);

    public static native /* synthetic */ void access$900(KSBannerAdapter kSBannerAdapter, String str, String str2);

    private native KsScene createKsScene(String str);

    private native void createNativeAd(Activity activity);

    private native KsAppDownloadListener getDownloadListener();

    private native void loadAndSetAdLoadListener(KsScene ksScene);

    private native void registerView(KsNativeAd ksNativeAd, Activity activity, ViewGroup viewGroup, HashMap<View, Integer> map);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.BaseBannerBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native Object getAdObj();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdTitle();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdUserName();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdvertisers();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native int getEcpm();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getLogTag();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getParentAdId();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native String getS2SInfo();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isLoadByActivity();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // android.view.View.OnClickListener
    public native void onClick(View view);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadS2SAd(String str);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
