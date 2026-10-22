package com.kc.openset.ad_embed.fw;

import android.app.Activity;
import android.view.ViewGroup;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.aw.lib.interf.PtgSplashAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.openset.ad.base.bridge.BaseSplashBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class FWSplashAdapter extends BaseSplashBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(554);
    private static final String FRONT = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_CHANNELS);
    private static final String TAG = OSETSDKProtected.getString2(611);
    private PtgSplashAd mFwSplashAd;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.fw.FWSplashAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements PtgAdNative.SplashAdListener {
        final FWSplashAdapter this$0;

        static {
            OSETSDKProtected.interface11(3925);
        }

        public AnonymousClass1(FWSplashAdapter fWSplashAdapter) {
            this.this$0 = fWSplashAdapter;
        }

        @Override // com.kc.aw.lib.interf.Error
        public native void onError(AdError adError);

        @Override // com.kc.aw.lib.provider.PtgAdNative.SplashAdListener
        public native void onSplashAdLoad(PtgSplashAd ptgSplashAd);

        @Override // com.kc.aw.lib.provider.PtgAdNative.SplashAdListener
        public native void onTimeout();
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.fw.FWSplashAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements PtgSplashAd.AdInteractionListener {
        final FWSplashAdapter this$0;

        static {
            OSETSDKProtected.interface11(3926);
        }

        public AnonymousClass2(FWSplashAdapter fWSplashAdapter) {
            this.this$0 = fWSplashAdapter;
        }

        @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
        public native void onAdClicked();

        @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
        public native void onAdShow();

        @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
        public native void onAdSkip();

        @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
        public native void onAdTimeOver();

        @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
        public native void onDismiss(int i);

        @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
        public native void onRenderError(AdError adError);

        @Override // com.kc.aw.lib.interf.PtgSplashAd.AdInteractionListener
        public native void onRenderSuccess();
    }

    static {
        OSETSDKProtected.interface11(3927);
    }

    public static native /* synthetic */ void access$000(FWSplashAdapter fWSplashAdapter, String str, String str2);

    public static native /* synthetic */ void access$100(FWSplashAdapter fWSplashAdapter, String str, String str2);

    public static native /* synthetic */ void access$1000(FWSplashAdapter fWSplashAdapter, String str, String str2);

    public static native /* synthetic */ void access$1100(FWSplashAdapter fWSplashAdapter, String str);

    public static native /* synthetic */ void access$200(FWSplashAdapter fWSplashAdapter, String str, String str2);

    public static native /* synthetic */ PtgSplashAd access$302(FWSplashAdapter fWSplashAdapter, PtgSplashAd ptgSplashAd);

    public static native /* synthetic */ void access$400(FWSplashAdapter fWSplashAdapter);

    public static native /* synthetic */ void access$500(FWSplashAdapter fWSplashAdapter, String str, String str2);

    public static native /* synthetic */ void access$600(FWSplashAdapter fWSplashAdapter);

    public static native /* synthetic */ void access$700(FWSplashAdapter fWSplashAdapter);

    public static native /* synthetic */ void access$800(FWSplashAdapter fWSplashAdapter);

    public static native /* synthetic */ void access$900(FWSplashAdapter fWSplashAdapter);

    private native PtgSplashAd.AdInteractionListener getFwAdInteractionListener();

    private native PtgAdNative.SplashAdListener getFwAdLoadListener();

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
    public native boolean isLoadByActivity();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity, ViewGroup viewGroup);
}
