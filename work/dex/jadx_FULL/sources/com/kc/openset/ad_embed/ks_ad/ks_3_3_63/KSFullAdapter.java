package com.kc.openset.ad_embed.ks_ad.ks_3_3_63;

import android.app.Activity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseFullBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kwad.sdk.api.KsFullScreenVideoAd;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsScene;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KSFullAdapter extends BaseFullBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT);
    private static final String FRONT = OSETSDKProtected.getString2(743);
    private static final String TAG = OSETSDKProtected.getString2(762);
    private KsFullScreenVideoAd mKsFullScreenVideoAd;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_63.KSFullAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements KsLoadManager.FullScreenVideoAdListener {
        final KSFullAdapter this$0;

        static {
            OSETSDKProtected.interface11(3964);
        }

        public AnonymousClass1(KSFullAdapter kSFullAdapter) {
            this.this$0 = kSFullAdapter;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public native void onError(int i, String str);

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public native void onFullScreenVideoAdLoad(List<KsFullScreenVideoAd> list);

        @Override // com.kwad.sdk.api.KsLoadManager.FullScreenVideoAdListener
        public native void onFullScreenVideoResult(List<KsFullScreenVideoAd> list);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_63.KSFullAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements KsFullScreenVideoAd.FullScreenVideoAdInteractionListener {
        final KSFullAdapter this$0;

        static {
            OSETSDKProtected.interface11(3965);
        }

        public AnonymousClass2(KSFullAdapter kSFullAdapter) {
            this.this$0 = kSFullAdapter;
        }

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public native void onAdClicked();

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public native void onPageDismiss();

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public native void onSkippedVideo();

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public native void onVideoPlayEnd();

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public native void onVideoPlayError(int i, int i2);

        @Override // com.kwad.sdk.api.KsFullScreenVideoAd.FullScreenVideoAdInteractionListener
        public native void onVideoPlayStart();
    }

    static {
        OSETSDKProtected.interface11(3966);
    }

    public static native /* synthetic */ void access$000(KSFullAdapter kSFullAdapter, String str, String str2);

    public static native /* synthetic */ void access$100(KSFullAdapter kSFullAdapter, String str, String str2);

    public static native /* synthetic */ void access$1000(KSFullAdapter kSFullAdapter);

    public static native /* synthetic */ void access$1100(KSFullAdapter kSFullAdapter);

    public static native /* synthetic */ void access$1200(KSFullAdapter kSFullAdapter);

    public static native /* synthetic */ KsFullScreenVideoAd access$202(KSFullAdapter kSFullAdapter, KsFullScreenVideoAd ksFullScreenVideoAd);

    public static native /* synthetic */ boolean access$300(KSFullAdapter kSFullAdapter);

    public static native /* synthetic */ void access$400(KSFullAdapter kSFullAdapter, String str, String str2);

    public static native /* synthetic */ void access$500(KSFullAdapter kSFullAdapter);

    public static native /* synthetic */ void access$600(KSFullAdapter kSFullAdapter);

    public static native /* synthetic */ void access$700(KSFullAdapter kSFullAdapter);

    public static native /* synthetic */ void access$800(KSFullAdapter kSFullAdapter, String str, String str2);

    public static native /* synthetic */ void access$900(KSFullAdapter kSFullAdapter);

    private native void loadAndSetAdLoadListener(KsScene ksScene);

    private native void setAdPlayEventListener(KsFullScreenVideoAd ksFullScreenVideoAd);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.BaseFullBridge, com.kc.openset.ad.base.bridge.AdBridge
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
    public native boolean isLoadByActivity();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
