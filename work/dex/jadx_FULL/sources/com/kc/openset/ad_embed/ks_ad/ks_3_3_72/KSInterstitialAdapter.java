package com.kc.openset.ad_embed.ks_ad.ks_3_3_72;

import android.app.Activity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseInterstitialBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kwad.sdk.api.KsInterstitialAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KSInterstitialAdapter extends BaseInterstitialBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT);
    private static final String FRONT = OSETSDKProtected.getString2(743);
    private static final String TAG = OSETSDKProtected.getString2(781);
    private KsInterstitialAd mKsInterstitialAd;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_72.KSInterstitialAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements KsLoadManager.InterstitialAdListener {
        final KSInterstitialAdapter this$0;

        static {
            OSETSDKProtected.interface11(4068);
        }

        public AnonymousClass1(KSInterstitialAdapter kSInterstitialAdapter) {
            this.this$0 = kSInterstitialAdapter;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public native void onError(int i, String str);

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public native void onInterstitialAdLoad(List<KsInterstitialAd> list);

        @Override // com.kwad.sdk.api.KsLoadManager.InterstitialAdListener
        public native void onRequestResult(int i);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_72.KSInterstitialAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements KsInterstitialAd.AdInteractionListener {
        final KSInterstitialAdapter this$0;

        static {
            OSETSDKProtected.interface11(4069);
        }

        public AnonymousClass2(KSInterstitialAdapter kSInterstitialAdapter) {
            this.this$0 = kSInterstitialAdapter;
        }

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public native void onAdClicked();

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public native void onAdClosed();

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public native void onAdShow();

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public native void onPageDismiss();

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public native void onSkippedAd();

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public native void onVideoPlayEnd();

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public native void onVideoPlayError(int i, int i2);

        @Override // com.kwad.sdk.api.KsInterstitialAd.AdInteractionListener
        public native void onVideoPlayStart();
    }

    static {
        OSETSDKProtected.interface11(4070);
    }

    public static native /* synthetic */ void access$000(KSInterstitialAdapter kSInterstitialAdapter, String str, String str2);

    public static native /* synthetic */ void access$100(KSInterstitialAdapter kSInterstitialAdapter, String str, String str2);

    public static native /* synthetic */ void access$1000(KSInterstitialAdapter kSInterstitialAdapter);

    public static native /* synthetic */ KsInterstitialAd access$202(KSInterstitialAdapter kSInterstitialAdapter, KsInterstitialAd ksInterstitialAd);

    public static native /* synthetic */ boolean access$300(KSInterstitialAdapter kSInterstitialAdapter);

    public static native /* synthetic */ void access$400(KSInterstitialAdapter kSInterstitialAdapter, String str, String str2);

    public static native /* synthetic */ void access$500(KSInterstitialAdapter kSInterstitialAdapter);

    public static native /* synthetic */ void access$600(KSInterstitialAdapter kSInterstitialAdapter);

    public static native /* synthetic */ void access$700(KSInterstitialAdapter kSInterstitialAdapter);

    public static native /* synthetic */ void access$800(KSInterstitialAdapter kSInterstitialAdapter);

    public static native /* synthetic */ void access$900(KSInterstitialAdapter kSInterstitialAdapter, String str, String str2);

    private native KsScene createKsScene(String str);

    private native void loadAndSetAdLoadListener(KsScene ksScene);

    private native void setAdPlayEventListener(KsInterstitialAd ksInterstitialAd);

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
