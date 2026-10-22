package com.kc.openset.ad_embed.zy;

import android.app.Activity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.cw.ad.InterstitialAd;
import com.kc.cw.ad.InterstitialAdListener;
import com.kc.openset.ad.base.bridge.BaseInterstitialBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ZYInterstitialAdapter extends BaseInterstitialBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(904);
    private static final String FRONT = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_WILLING_AND_ABLE_TO_WRITE);
    private static final String TAG = OSETSDKProtected.getString2(932);
    private InterstitialAd mInterstitialAd;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.zy.ZYInterstitialAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements InterstitialAdListener {
        final ZYInterstitialAdapter this$0;

        static {
            OSETSDKProtected.interface11(4214);
        }

        public AnonymousClass1(ZYInterstitialAdapter zYInterstitialAdapter) {
            this.this$0 = zYInterstitialAdapter;
        }

        @Override // com.kc.cw.ad.InterstitialAdListener
        public native void onAdCacheLoaded(boolean z);

        @Override // com.kc.cw.ad.InterstitialAdListener
        public native void onAdClicked();

        @Override // com.kc.cw.ad.InterstitialAdListener
        public native void onAdClosed();

        @Override // com.kc.cw.ad.InterstitialAdListener
        public native void onAdFailedToLoad(int i);

        @Override // com.kc.cw.ad.InterstitialAdListener
        public native void onAdLoaded();

        @Override // com.kc.cw.ad.InterstitialAdListener
        public native void onAdShown();
    }

    static {
        OSETSDKProtected.interface11(4215);
    }

    public static native /* synthetic */ void access$000(ZYInterstitialAdapter zYInterstitialAdapter);

    public static native /* synthetic */ void access$100(ZYInterstitialAdapter zYInterstitialAdapter);

    public static native /* synthetic */ void access$200(ZYInterstitialAdapter zYInterstitialAdapter, String str, String str2);

    public static native /* synthetic */ void access$300(ZYInterstitialAdapter zYInterstitialAdapter);

    public static native /* synthetic */ void access$400(ZYInterstitialAdapter zYInterstitialAdapter);

    private native InterstitialAdListener createAndSetAdAllListener();

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
