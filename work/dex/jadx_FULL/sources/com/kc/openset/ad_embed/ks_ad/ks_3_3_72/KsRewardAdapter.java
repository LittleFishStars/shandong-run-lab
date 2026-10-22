package com.kc.openset.ad_embed.ks_ad.ks_3_3_72;

import android.app.Activity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseRewardBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kwad.sdk.api.KsLoadManager;
import com.kwad.sdk.api.KsRewardVideoAd;
import com.kwad.sdk.api.KsScene;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KsRewardAdapter extends BaseRewardBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_LOADCONTROL_BUFFERINGTIMEOUT);
    private static final String FRONT = OSETSDKProtected.getString2(743);
    private static final String TAG = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_RTC_ENABLE_DTLS);
    private KsRewardVideoAd mKsRewardVideoAd;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_72.KsRewardAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements KsLoadManager.RewardVideoAdListener {
        final KsRewardAdapter this$0;

        static {
            OSETSDKProtected.interface11(4099);
        }

        public AnonymousClass1(KsRewardAdapter ksRewardAdapter) {
            this.this$0 = ksRewardAdapter;
        }

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public native void onError(int i, String str);

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public native void onRewardVideoAdLoad(List<KsRewardVideoAd> list);

        @Override // com.kwad.sdk.api.KsLoadManager.RewardVideoAdListener
        public native void onRewardVideoResult(List<KsRewardVideoAd> list);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ks_ad.ks_3_3_72.KsRewardAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements KsRewardVideoAd.RewardAdInteractionListener {
        final KsRewardAdapter this$0;

        static {
            OSETSDKProtected.interface11(4100);
        }

        public AnonymousClass2(KsRewardAdapter ksRewardAdapter) {
            this.this$0 = ksRewardAdapter;
        }

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public native void onAdClicked();

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public native void onExtraRewardVerify(int i);

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public native void onPageDismiss();

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public native void onRewardStepVerify(int i, int i2);

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public native void onRewardVerify();

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public native void onRewardVerify(Map<String, Object> map);

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public native void onVideoPlayEnd();

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public native void onVideoPlayError(int i, int i2);

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public native void onVideoPlayStart();

        @Override // com.kwad.sdk.api.KsRewardVideoAd.RewardAdInteractionListener
        public native void onVideoSkipToEnd(long j);
    }

    static {
        OSETSDKProtected.interface11(4101);
    }

    public static native /* synthetic */ void access$000(KsRewardAdapter ksRewardAdapter, String str, String str2);

    public static native /* synthetic */ void access$100(KsRewardAdapter ksRewardAdapter, String str, String str2);

    public static native /* synthetic */ void access$1000(KsRewardAdapter ksRewardAdapter);

    public static native /* synthetic */ void access$1100(KsRewardAdapter ksRewardAdapter);

    public static native /* synthetic */ void access$1200(KsRewardAdapter ksRewardAdapter);

    public static native /* synthetic */ void access$1300(KsRewardAdapter ksRewardAdapter);

    public static native /* synthetic */ KsRewardVideoAd access$202(KsRewardAdapter ksRewardAdapter, KsRewardVideoAd ksRewardVideoAd);

    public static native /* synthetic */ boolean access$300(KsRewardAdapter ksRewardAdapter);

    public static native /* synthetic */ void access$400(KsRewardAdapter ksRewardAdapter, String str, String str2);

    public static native /* synthetic */ void access$500(KsRewardAdapter ksRewardAdapter);

    public static native /* synthetic */ void access$600(KsRewardAdapter ksRewardAdapter);

    public static native /* synthetic */ void access$700(KsRewardAdapter ksRewardAdapter);

    public static native /* synthetic */ void access$800(KsRewardAdapter ksRewardAdapter, String str, String str2);

    public static native /* synthetic */ void access$900(KsRewardAdapter ksRewardAdapter);

    private native KsScene createKsScene(String str);

    private native void loadAndSetAdLoadListener(KsScene ksScene);

    private native void setAdPlayEventListener(KsRewardVideoAd ksRewardVideoAd);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.BaseRewardBridge, com.kc.openset.ad.base.bridge.AdBridge
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
