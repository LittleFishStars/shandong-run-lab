package com.kc.openset.ad_embed.ks_ad.ks_3_3_69;

import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseSplashBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.kwad.sdk.api.KsSplashScreenAd;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KSSplashAdapter extends BaseSplashBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT);
    private static final String FRONT = OSETSDKProtected.getString2(743);
    private static final String TAG = OSETSDKProtected.getString2(805);
    private WeakReference<ViewGroup> mContainerWeakReference = null;
    private KsSplashScreenAd mKsSplashScreenAd;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_69.KSSplashAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements KsLoadManager.SplashScreenAdListener {
        final KSSplashAdapter this$0;

        static {
            OSETSDKProtected.interface11(4045);
        }

        public AnonymousClass1(KSSplashAdapter kSSplashAdapter) {
            this.this$0 = kSSplashAdapter;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public native void onError(int i, String str);

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public native void onRequestResult(int i);

        @Override // com.kwad.sdk.api.KsLoadManager.SplashScreenAdListener
        public native void onSplashScreenAdLoad(KsSplashScreenAd ksSplashScreenAd);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_69.KSSplashAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements KsSplashScreenAd.SplashScreenAdInteractionListener {
        final KSSplashAdapter this$0;

        static {
            OSETSDKProtected.interface11(4046);
        }

        public AnonymousClass2(KSSplashAdapter kSSplashAdapter) {
            this.this$0 = kSSplashAdapter;
        }

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public native void onAdClicked();

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public native void onAdShowEnd();

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public native void onAdShowError(int i, String str);

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public native void onAdShowStart();

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public native void onDownloadTipsDialogCancel();

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public native void onDownloadTipsDialogDismiss();

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public native void onDownloadTipsDialogShow();

        @Override // com.kwad.sdk.api.KsSplashScreenAd.SplashScreenAdInteractionListener
        public native void onSkippedAd();
    }

    static {
        OSETSDKProtected.interface11(4047);
    }

    public static native /* synthetic */ void access$000(KSSplashAdapter kSSplashAdapter, String str, String str2);

    public static native /* synthetic */ void access$1000(KSSplashAdapter kSSplashAdapter);

    public static native /* synthetic */ KsSplashScreenAd access$102(KSSplashAdapter kSSplashAdapter, KsSplashScreenAd ksSplashScreenAd);

    public static native /* synthetic */ boolean access$200(KSSplashAdapter kSSplashAdapter);

    public static native /* synthetic */ void access$300(KSSplashAdapter kSSplashAdapter, String str, String str2);

    public static native /* synthetic */ void access$400(KSSplashAdapter kSSplashAdapter);

    public static native /* synthetic */ void access$500(KSSplashAdapter kSSplashAdapter, String str, String str2);

    public static native /* synthetic */ void access$600(KSSplashAdapter kSSplashAdapter);

    public static native /* synthetic */ void access$700(KSSplashAdapter kSSplashAdapter, String str, String str2);

    public static native /* synthetic */ void access$800(KSSplashAdapter kSSplashAdapter);

    public static native /* synthetic */ void access$900(KSSplashAdapter kSSplashAdapter);

    private native KsScene createKsScene(String str);

    private native View getViewAndSetAdPlayEventListener(KsSplashScreenAd ksSplashScreenAd);

    private native void loadAndSetAdLoadListener(KsScene ksScene);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.BaseSplashBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native Object getAdObj();

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

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadS2SAd(String str);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity, ViewGroup viewGroup);
}
