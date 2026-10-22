package com.kc.openset.ad_embed.fw;

import android.app.Activity;
import android.os.Bundle;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.aw.lib.interf.PtgRewardVideoAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.openset.ad.base.bridge.BaseRewardBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class FWRewardAdapter extends BaseRewardBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(554);
    private static final String FRONT = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_CHANNELS);
    private static final String TAG = OSETSDKProtected.getString2(607);
    private PtgRewardVideoAd mFwRewardVideoAd;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.fw.FWRewardAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements PtgAdNative.RewardVideoAdListener {
        final FWRewardAdapter this$0;

        static {
            OSETSDKProtected.interface11(3922);
        }

        public AnonymousClass1(FWRewardAdapter fWRewardAdapter) {
            this.this$0 = fWRewardAdapter;
        }

        @Override // com.kc.aw.lib.interf.Error
        public native void onError(AdError adError);

        @Override // com.kc.aw.lib.provider.PtgAdNative.RewardVideoAdListener
        public native void onRewardVideoAdLoad(PtgRewardVideoAd ptgRewardVideoAd);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.fw.FWRewardAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements PtgRewardVideoAd.RewardAdInteractionListener {
        final FWRewardAdapter this$0;

        static {
            OSETSDKProtected.interface11(3923);
        }

        public AnonymousClass2(FWRewardAdapter fWRewardAdapter) {
            this.this$0 = fWRewardAdapter;
        }

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public native void onAdClose();

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public native void onAdShow();

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public native void onAdVideoBarClick();

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public native void onRenderError(AdError adError);

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public native void onRewardVerify(boolean z, Bundle bundle);

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public native void onSkippedVideo();

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public native void onVideoComplete();

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public native void onVideoError(int i, String str);

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public native void onVideoPause();

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public native void onVideoProgressUpdate(long j, long j2);

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public native void onVideoResume();

        @Override // com.kc.aw.lib.interf.PtgRewardVideoAd.RewardAdInteractionListener
        public native void onVideoStart();
    }

    static {
        OSETSDKProtected.interface11(3924);
    }

    public static native /* synthetic */ PtgRewardVideoAd access$002(FWRewardAdapter fWRewardAdapter, PtgRewardVideoAd ptgRewardVideoAd);

    public static native /* synthetic */ void access$100(FWRewardAdapter fWRewardAdapter);

    public static native /* synthetic */ void access$1000(FWRewardAdapter fWRewardAdapter);

    public static native /* synthetic */ void access$1100(FWRewardAdapter fWRewardAdapter, String str, String str2);

    public static native /* synthetic */ void access$1200(FWRewardAdapter fWRewardAdapter);

    public static native /* synthetic */ void access$1300(FWRewardAdapter fWRewardAdapter);

    public static native /* synthetic */ void access$1400(FWRewardAdapter fWRewardAdapter);

    public static native /* synthetic */ void access$200(FWRewardAdapter fWRewardAdapter, String str, String str2);

    public static native /* synthetic */ void access$300(FWRewardAdapter fWRewardAdapter, String str, String str2);

    public static native /* synthetic */ void access$400(FWRewardAdapter fWRewardAdapter, String str, String str2);

    public static native /* synthetic */ void access$500(FWRewardAdapter fWRewardAdapter);

    public static native /* synthetic */ void access$600(FWRewardAdapter fWRewardAdapter);

    public static native /* synthetic */ void access$700(FWRewardAdapter fWRewardAdapter);

    public static native /* synthetic */ void access$800(FWRewardAdapter fWRewardAdapter, String str, String str2);

    public static native /* synthetic */ void access$900(FWRewardAdapter fWRewardAdapter, String str);

    private native PtgRewardVideoAd.RewardAdInteractionListener getFwAdInteractionListener();

    private native PtgAdNative.RewardVideoAdListener getFwAdLoadListener();

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
    public native boolean isLoadByActivity();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
