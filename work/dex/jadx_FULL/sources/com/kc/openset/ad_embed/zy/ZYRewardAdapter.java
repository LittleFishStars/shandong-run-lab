package com.kc.openset.ad_embed.zy;

import android.app.Activity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.cw.ad.RewardItem;
import com.kc.cw.ad.RewardVideoAd;
import com.kc.cw.ad.RewardVideoAdListener;
import com.kc.openset.ad.base.bridge.BaseRewardBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ZYRewardAdapter extends BaseRewardBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(904);
    private static final String FRONT = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_WILLING_AND_ABLE_TO_WRITE);
    private static final String TAG = OSETSDKProtected.getString2(950);
    private RewardVideoAd mRewardVideoAd;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.zy.ZYRewardAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements RewardVideoAdListener {
        final ZYRewardAdapter this$0;

        static {
            OSETSDKProtected.interface11(4225);
        }

        public AnonymousClass1(ZYRewardAdapter zYRewardAdapter) {
            this.this$0 = zYRewardAdapter;
        }

        @Override // com.kc.cw.ad.RewardVideoAdListener
        public native void onRewardVideoAdClicked();

        @Override // com.kc.cw.ad.RewardVideoAdListener
        public native void onRewardVideoAdClosed();

        @Override // com.kc.cw.ad.RewardVideoAdListener
        public native void onRewardVideoAdComplete();

        @Override // com.kc.cw.ad.RewardVideoAdListener
        public native void onRewardVideoAdFailedToLoad(int i);

        @Override // com.kc.cw.ad.RewardVideoAdListener
        public native void onRewardVideoAdLoaded();

        @Override // com.kc.cw.ad.RewardVideoAdListener
        public native void onRewardVideoAdShown();

        @Override // com.kc.cw.ad.RewardVideoAdListener
        public native void onRewardVideoCached(boolean z);

        @Override // com.kc.cw.ad.RewardVideoAdListener
        public native void onRewarded(RewardItem rewardItem);
    }

    static {
        OSETSDKProtected.interface11(4226);
    }

    public static native /* synthetic */ void access$000(ZYRewardAdapter zYRewardAdapter);

    public static native /* synthetic */ void access$100(ZYRewardAdapter zYRewardAdapter);

    public static native /* synthetic */ void access$200(ZYRewardAdapter zYRewardAdapter);

    public static native /* synthetic */ void access$300(ZYRewardAdapter zYRewardAdapter, String str, String str2);

    public static native /* synthetic */ void access$400(ZYRewardAdapter zYRewardAdapter);

    public static native /* synthetic */ void access$500(ZYRewardAdapter zYRewardAdapter);

    public static native /* synthetic */ void access$600(ZYRewardAdapter zYRewardAdapter);

    private native RewardVideoAdListener createAndSetAdAllListener();

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

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isLoadByActivity();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
