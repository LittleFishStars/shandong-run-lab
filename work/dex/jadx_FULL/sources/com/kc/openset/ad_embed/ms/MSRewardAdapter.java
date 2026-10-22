package com.kc.openset.ad_embed.ms;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.dw.core.ad.reward.RewardAdLoadListener;
import com.kc.dw.core.ad.reward.RewardAdMediaListener;
import com.kc.dw.core.ad.reward.RewardInteractionListener;
import com.kc.dw.core.ad.reward.RewardVideoAd;
import com.kc.dw.core.ad.reward.RewardVideoEventLoader;
import com.kc.dw.core.utils.AdError;
import com.kc.openset.ad.base.bridge.BaseRewardBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class MSRewardAdapter extends BaseRewardBridge {
    private static final String TAG = OSETSDKProtected.getString2(857);
    private RewardVideoAd mRewardVideoAd;
    private RewardVideoEventLoader mRewardVideoEventLoader;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ms.MSRewardAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements RewardAdLoadListener {
        final MSRewardAdapter this$0;

        static {
            OSETSDKProtected.interface11(4170);
        }

        public AnonymousClass1(MSRewardAdapter mSRewardAdapter) {
            this.this$0 = mSRewardAdapter;
        }

        /* JADX INFO: renamed from: onAdFail, reason: avoid collision after fix types in other method */
        public native void onAdFail2(RewardVideoAd rewardVideoAd, AdError adError, int i);

        @Override // com.kc.dw.core.ad.IAdEventListener
        public native /* bridge */ /* synthetic */ void onAdFail(RewardVideoAd rewardVideoAd, AdError adError, int i);

        @Override // com.kc.dw.core.ad.IAdEventListener
        public native void onLoadFail(AdError adError);

        /* JADX INFO: renamed from: onLoadSuccess, reason: avoid collision after fix types in other method */
        public native void onLoadSuccess2(RewardVideoAd rewardVideoAd);

        @Override // com.kc.dw.core.ad.IAdEventListener
        public native /* bridge */ /* synthetic */ void onLoadSuccess(RewardVideoAd rewardVideoAd);

        /* JADX INFO: renamed from: onRenderSuccess, reason: avoid collision after fix types in other method */
        public native void onRenderSuccess2(RewardVideoAd rewardVideoAd);

        @Override // com.kc.dw.core.ad.IAdEventListener
        public native /* bridge */ /* synthetic */ void onRenderSuccess(RewardVideoAd rewardVideoAd);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ms.MSRewardAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements RewardInteractionListener {
        final MSRewardAdapter this$0;

        static {
            OSETSDKProtected.interface11(4171);
        }

        public AnonymousClass2(MSRewardAdapter mSRewardAdapter) {
            this.this$0 = mSRewardAdapter;
        }

        @Override // com.kc.dw.core.loader.InteractionListener
        public native void onAdClicked();

        @Override // com.kc.dw.core.loader.InteractionListener
        public native void onAdClosed();

        @Override // com.kc.dw.core.loader.InteractionListener
        public native void onAdExposure();

        @Override // com.kc.dw.core.ad.reward.RewardInteractionListener
        public native void onReward(Map<String, Object> map);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ms.MSRewardAdapter$3, reason: invalid class name */
    @Keep
    public class AnonymousClass3 implements RewardAdMediaListener {
        final MSRewardAdapter this$0;

        static {
            OSETSDKProtected.interface11(4172);
        }

        public AnonymousClass3(MSRewardAdapter mSRewardAdapter) {
            this.this$0 = mSRewardAdapter;
        }

        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
        public native void onSkippedVideo();

        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
        public native void onVideoCompleted();

        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
        public native void onVideoError();

        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
        public native void onVideoPause();

        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
        public native void onVideoResume();

        @Override // com.kc.dw.core.ad.reward.RewardAdMediaListener
        public native void onVideoStart();
    }

    static {
        OSETSDKProtected.interface11(4173);
    }

    public static native /* synthetic */ void access$000(MSRewardAdapter mSRewardAdapter, int i, String str);

    public static native /* synthetic */ void access$100(MSRewardAdapter mSRewardAdapter, int i, String str);

    public static native /* synthetic */ void access$1000(MSRewardAdapter mSRewardAdapter);

    public static native /* synthetic */ void access$1100(MSRewardAdapter mSRewardAdapter);

    public static native /* synthetic */ void access$1200(MSRewardAdapter mSRewardAdapter, int i, String str);

    public static native /* synthetic */ void access$1300(MSRewardAdapter mSRewardAdapter);

    public static native /* synthetic */ RewardVideoAd access$202(MSRewardAdapter mSRewardAdapter, RewardVideoAd rewardVideoAd);

    public static native /* synthetic */ void access$300(MSRewardAdapter mSRewardAdapter);

    public static native /* synthetic */ void access$400(MSRewardAdapter mSRewardAdapter, int i, String str);

    public static native /* synthetic */ void access$500(MSRewardAdapter mSRewardAdapter, int i, String str);

    public static native /* synthetic */ void access$600(MSRewardAdapter mSRewardAdapter);

    public static native /* synthetic */ void access$700(MSRewardAdapter mSRewardAdapter);

    public static native /* synthetic */ void access$800(MSRewardAdapter mSRewardAdapter);

    public static native /* synthetic */ void access$900(MSRewardAdapter mSRewardAdapter);

    private native RewardAdLoadListener getAdLoadListener();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdvertisers();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native int getEcpm();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getLogTag();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getParentAdId();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
