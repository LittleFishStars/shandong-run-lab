package com.kc.openset.ad_embed.zy;

import android.app.Activity;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.cw.ad.SplashAd;
import com.kc.cw.ad.SplashAdListener;
import com.kc.openset.ad.base.bridge.BaseSplashBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class ZYSplashAdapter extends BaseSplashBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(904);
    private static final String FRONT = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_FIX_WILLING_AND_ABLE_TO_WRITE);
    private static final String TAG = OSETSDKProtected.getString2(956);
    private SplashAd mSplashAd;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.zy.ZYSplashAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements SplashAdListener {
        final ZYSplashAdapter this$0;

        static {
            OSETSDKProtected.interface11(4227);
        }

        public AnonymousClass1(ZYSplashAdapter zYSplashAdapter) {
            this.this$0 = zYSplashAdapter;
        }

        @Override // com.kc.cw.ad.SplashAdListener
        public native void onAdCacheLoaded(boolean z);

        @Override // com.kc.cw.ad.SplashAdListener
        public native void onAdClicked();

        @Override // com.kc.cw.ad.SplashAdListener
        public native void onAdClosed();

        @Override // com.kc.cw.ad.SplashAdListener
        public native void onAdFailedToLoad(int i);

        @Override // com.kc.cw.ad.SplashAdListener
        public native void onAdLoaded();

        @Override // com.kc.cw.ad.SplashAdListener
        public native void onAdShown();

        @Override // com.kc.cw.ad.SplashAdListener
        public native void onAdTick(long j);
    }

    static {
        OSETSDKProtected.interface11(4228);
    }

    public static native /* synthetic */ void access$000(ZYSplashAdapter zYSplashAdapter);

    public static native /* synthetic */ void access$100(ZYSplashAdapter zYSplashAdapter);

    public static native /* synthetic */ void access$200(ZYSplashAdapter zYSplashAdapter, String str, String str2);

    public static native /* synthetic */ void access$300(ZYSplashAdapter zYSplashAdapter);

    public static native /* synthetic */ void access$400(ZYSplashAdapter zYSplashAdapter);

    private native SplashAdListener createAndSetAdAllListener();

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
    public native boolean isBindActivityLifeCycle();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isDealWithByAdvertisers();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isLoadByActivity();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity, ViewGroup viewGroup);
}
