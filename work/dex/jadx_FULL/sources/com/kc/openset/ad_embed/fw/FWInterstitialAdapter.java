package com.kc.openset.ad_embed.fw;

import android.app.Activity;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.hzchengdun.securityguard.SecExceptionCode;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.aw.lib.interf.PtgInteractionAd;
import com.kc.aw.lib.model.AdError;
import com.kc.aw.lib.provider.PtgAdNative;
import com.kc.openset.ad.base.bridge.BaseInterstitialBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class FWInterstitialAdapter extends BaseInterstitialBridge {
    private static final String ADVERTISERS = OSETSDKProtected.getString2(554);
    private static final String FRONT = OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_CHANNELS);
    private static final String TAG = OSETSDKProtected.getString2(SecExceptionCode.SEC_ERROR_DYN_STORE_UNKNOWN_ERROR);
    private PtgInteractionAd mFwInterstitialAd;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.fw.FWInterstitialAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements PtgAdNative.InteractionExpressAdListener {
        final FWInterstitialAdapter this$0;

        static {
            OSETSDKProtected.interface11(3911);
        }

        public AnonymousClass1(FWInterstitialAdapter fWInterstitialAdapter) {
            this.this$0 = fWInterstitialAdapter;
        }

        @Override // com.kc.aw.lib.interf.Error
        public native void onError(AdError adError);

        @Override // com.kc.aw.lib.provider.PtgAdNative.InteractionExpressAdListener
        public native void onInteractionAdLoad(PtgInteractionAd ptgInteractionAd);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.fw.FWInterstitialAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements PtgInteractionAd.AdInteractionListener {
        final FWInterstitialAdapter this$0;

        static {
            OSETSDKProtected.interface11(3912);
        }

        public AnonymousClass2(FWInterstitialAdapter fWInterstitialAdapter) {
            this.this$0 = fWInterstitialAdapter;
        }

        @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
        public native void onAdClicked();

        @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
        public native void onAdDismiss();

        @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
        public native void onAdShow();

        @Override // com.kc.aw.lib.interf.PtgInteractionAd.AdInteractionListener
        public native void onRenderError(AdError adError);
    }

    static {
        OSETSDKProtected.interface11(3913);
    }

    public static native /* synthetic */ PtgInteractionAd access$002(FWInterstitialAdapter fWInterstitialAdapter, PtgInteractionAd ptgInteractionAd);

    public static native /* synthetic */ void access$100(FWInterstitialAdapter fWInterstitialAdapter);

    public static native /* synthetic */ void access$200(FWInterstitialAdapter fWInterstitialAdapter, String str, String str2);

    public static native /* synthetic */ void access$300(FWInterstitialAdapter fWInterstitialAdapter, String str, String str2);

    public static native /* synthetic */ void access$400(FWInterstitialAdapter fWInterstitialAdapter, String str, String str2);

    public static native /* synthetic */ void access$500(FWInterstitialAdapter fWInterstitialAdapter);

    public static native /* synthetic */ void access$600(FWInterstitialAdapter fWInterstitialAdapter);

    public static native /* synthetic */ void access$700(FWInterstitialAdapter fWInterstitialAdapter);

    public static native /* synthetic */ void access$800(FWInterstitialAdapter fWInterstitialAdapter, String str, String str2);

    public static native /* synthetic */ void access$900(FWInterstitialAdapter fWInterstitialAdapter, String str);

    private native PtgInteractionAd.AdInteractionListener getFwAdInteractionListener();

    private native PtgAdNative.InteractionExpressAdListener getFwAdLoadListener();

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
    public native boolean isLoadByActivity();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
