package com.kc.openset.ad_embed.ks_ad.ks_3_3_63;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseInterstitialBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsNativeAd;
import com.kwad.sdk.api.KsScene;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KSInterstitialNativeAdapter extends BaseInterstitialBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT);
    private static final String FRONT = OSETSDKProtected.getString2(743);
    private static final String TAG = OSETSDKProtected.getString2(788);
    private KsNativeAd mKsNativeAd;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_63.KSInterstitialNativeAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements KsLoadManager.NativeAdListener {
        final KSInterstitialNativeAdapter this$0;

        static {
            OSETSDKProtected.interface11(3973);
        }

        public AnonymousClass1(KSInterstitialNativeAdapter kSInterstitialNativeAdapter) {
            this.this$0 = kSInterstitialNativeAdapter;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public native void onError(int i, String str);

        @Override // com.kwad.sdk.api.KsLoadManager.NativeAdListener
        public native void onNativeAdLoad(List<KsNativeAd> list);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_63.KSInterstitialNativeAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements DialogInterface.OnDismissListener {
        final KSInterstitialNativeAdapter this$0;

        static {
            OSETSDKProtected.interface11(3974);
        }

        public AnonymousClass2(KSInterstitialNativeAdapter kSInterstitialNativeAdapter) {
            this.this$0 = kSInterstitialNativeAdapter;
        }

        @Override // android.content.DialogInterface.OnDismissListener
        public native void onDismiss(DialogInterface dialogInterface);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_63.KSInterstitialNativeAdapter$3, reason: invalid class name */
    @Keep
    public class AnonymousClass3 implements KSMixAdViewUtil.KSMixNativeAdInteractionListener {
        final KSInterstitialNativeAdapter this$0;

        static {
            OSETSDKProtected.interface11(3975);
        }

        public AnonymousClass3(KSInterstitialNativeAdapter kSInterstitialNativeAdapter) {
            this.this$0 = kSInterstitialNativeAdapter;
        }

        @Override // com.kc.openset.ad_embed.ks_ad.ks_3_3_63.KSMixAdViewUtil.KSMixNativeAdInteractionListener
        public native void onAdClicked();

        @Override // com.kc.openset.ad_embed.ks_ad.ks_3_3_63.KSMixAdViewUtil.KSMixNativeAdInteractionListener
        public native void onAdShow();

        @Override // com.kc.openset.ad_embed.ks_ad.ks_3_3_63.KSMixAdViewUtil.KSMixNativeAdInteractionListener
        public native void onAdShowFail(String str, String str2);
    }

    static {
        OSETSDKProtected.interface11(3976);
    }

    public static native /* synthetic */ void access$000(KSInterstitialNativeAdapter kSInterstitialNativeAdapter, String str, String str2);

    public static native /* synthetic */ void access$100(KSInterstitialNativeAdapter kSInterstitialNativeAdapter, String str, String str2);

    public static native /* synthetic */ void access$1000(KSInterstitialNativeAdapter kSInterstitialNativeAdapter);

    public static native /* synthetic */ void access$1100(KSInterstitialNativeAdapter kSInterstitialNativeAdapter);

    public static native /* synthetic */ void access$1200(KSInterstitialNativeAdapter kSInterstitialNativeAdapter);

    public static native /* synthetic */ void access$1300(KSInterstitialNativeAdapter kSInterstitialNativeAdapter);

    public static native /* synthetic */ void access$1400(KSInterstitialNativeAdapter kSInterstitialNativeAdapter, String str, String str2);

    public static native /* synthetic */ Context access$200(KSInterstitialNativeAdapter kSInterstitialNativeAdapter);

    public static native /* synthetic */ void access$300(KSInterstitialNativeAdapter kSInterstitialNativeAdapter, String str, String str2);

    public static native /* synthetic */ void access$400(KSInterstitialNativeAdapter kSInterstitialNativeAdapter, String str, String str2);

    public static native /* synthetic */ void access$500(KSInterstitialNativeAdapter kSInterstitialNativeAdapter, String str, String str2);

    public static native /* synthetic */ void access$600(KSInterstitialNativeAdapter kSInterstitialNativeAdapter, String str, String str2);

    public static native /* synthetic */ KsNativeAd access$702(KSInterstitialNativeAdapter kSInterstitialNativeAdapter, KsNativeAd ksNativeAd);

    public static native /* synthetic */ boolean access$800(KSInterstitialNativeAdapter kSInterstitialNativeAdapter);

    public static native /* synthetic */ void access$900(KSInterstitialNativeAdapter kSInterstitialNativeAdapter, String str, String str2);

    private native KSMixAdViewUtil.KSMixNativeAdInteractionListener createAndSetAdInteractionListener();

    private native KsScene createKsScene(String str);

    private native void loadMixAd(KsScene ksScene);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.BaseInterstitialBridge, com.kc.openset.ad.base.bridge.AdBridge
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
    public native void toShowAd(Activity activity);
}
