package com.kc.openset.ad_embed.fw;

import android.app.Activity;
import android.view.View;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.aw.lib.interf.PtgNativeExpressAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.openset.ad.base.bridge.BaseNativeBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class FWNativeAdapter extends BaseNativeBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(554);
    private static final String FRONT = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_CHANNELS);
    private static final String TAG = OSETSDKProtected.getString2(601);
    private PtgNativeExpressAd mFwNativeAd;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.fw.FWNativeAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements PtgAdNative.NativeExpressAdListener {
        final FWNativeAdapter this$0;

        static {
            OSETSDKProtected.interface11(3914);
        }

        public AnonymousClass1(FWNativeAdapter fWNativeAdapter) {
            this.this$0 = fWNativeAdapter;
        }

        @Override // com.kc.aw.lib.interf.Error
        public native void onError(AdError adError);

        @Override // com.kc.aw.lib.provider.PtgAdNative.NativeExpressAdListener
        public native void onNativeExpressAdLoad(PtgNativeExpressAd ptgNativeExpressAd);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.fw.FWNativeAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements PtgNativeExpressAd.AdInteractionListener {
        final FWNativeAdapter this$0;

        static {
            OSETSDKProtected.interface11(3915);
        }

        public AnonymousClass2(FWNativeAdapter fWNativeAdapter) {
            this.this$0 = fWNativeAdapter;
        }

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public native void onAdClicked();

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public native void onAdDismiss();

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public native void onAdShow();

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public native void onRenderFail(AdError adError);

        @Override // com.kc.aw.lib.interf.PtgNativeExpressAd.ExpressAdInteractionListener
        public native void onRenderSuccess(View view);
    }

    static {
        OSETSDKProtected.interface11(3916);
    }

    public static native /* synthetic */ PtgNativeExpressAd access$000(FWNativeAdapter fWNativeAdapter);

    public static native /* synthetic */ PtgNativeExpressAd access$002(FWNativeAdapter fWNativeAdapter, PtgNativeExpressAd ptgNativeExpressAd);

    public static native /* synthetic */ void access$100(FWNativeAdapter fWNativeAdapter);

    public static native /* synthetic */ void access$1000(FWNativeAdapter fWNativeAdapter, String str);

    public static native /* synthetic */ void access$200(FWNativeAdapter fWNativeAdapter, String str, String str2);

    public static native /* synthetic */ void access$300(FWNativeAdapter fWNativeAdapter, String str, String str2);

    public static native /* synthetic */ void access$400(FWNativeAdapter fWNativeAdapter, String str, String str2);

    public static native /* synthetic */ void access$500(FWNativeAdapter fWNativeAdapter, View view);

    public static native /* synthetic */ void access$600(FWNativeAdapter fWNativeAdapter, View view);

    public static native /* synthetic */ void access$700(FWNativeAdapter fWNativeAdapter, View view);

    public static native /* synthetic */ void access$800(FWNativeAdapter fWNativeAdapter, View view);

    public static native /* synthetic */ void access$900(FWNativeAdapter fWNativeAdapter, String str, String str2);

    private native PtgNativeExpressAd.AdInteractionListener getFwAdInteractionListener();

    private native PtgAdNative.NativeExpressAdListener getFwAdLoadListener();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.BaseNativeBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native Object getAdObj();

    @Override // com.kc.openset.ad.base.bridge.BaseNativeBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdTitle();

    @Override // com.kc.openset.ad.base.bridge.BaseNativeBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdUserName();

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
