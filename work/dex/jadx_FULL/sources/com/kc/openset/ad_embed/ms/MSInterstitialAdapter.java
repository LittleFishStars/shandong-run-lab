package com.kc.openset.ad_embed.ms;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.dw.core.ad.interstitial.InterstitialAd;
import com.kc.dw.core.ad.interstitial.InterstitialAdEventLoader;
import com.kc.dw.core.ad.interstitial.InterstitialAdLoadListener;
import com.kc.dw.core.loader.InteractionListener;
import com.kc.dw.core.utils.AdError;
import com.kc.openset.ad.base.bridge.BaseInterstitialBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class MSInterstitialAdapter extends BaseInterstitialBridge {
    private static final String TAG = OSETSDKProtected.getString2(845);
    private InterstitialAd mInterstitialAd;
    private InterstitialAdEventLoader mInterstitialAdEventLoader;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ms.MSInterstitialAdapter$1, reason: invalid class name */
    @Keep
    public class AnonymousClass1 implements InterstitialAdLoadListener {
        final MSInterstitialAdapter this$0;

        static {
            OSETSDKProtected.interface11(4158);
        }

        public AnonymousClass1(MSInterstitialAdapter mSInterstitialAdapter) {
            this.this$0 = mSInterstitialAdapter;
        }

        /* JADX INFO: renamed from: onAdFail, reason: avoid collision after fix types in other method */
        public native void onAdFail2(InterstitialAd interstitialAd, AdError adError, int i);

        @Override // com.kc.dw.core.ad.IAdEventListener
        public native /* bridge */ /* synthetic */ void onAdFail(InterstitialAd interstitialAd, AdError adError, int i);

        @Override // com.kc.dw.core.ad.IAdEventListener
        public native void onLoadFail(AdError adError);

        /* JADX INFO: renamed from: onLoadSuccess, reason: avoid collision after fix types in other method */
        public native void onLoadSuccess2(InterstitialAd interstitialAd);

        @Override // com.kc.dw.core.ad.IAdEventListener
        public native /* bridge */ /* synthetic */ void onLoadSuccess(InterstitialAd interstitialAd);

        /* JADX INFO: renamed from: onRenderSuccess, reason: avoid collision after fix types in other method */
        public native void onRenderSuccess2(InterstitialAd interstitialAd);

        @Override // com.kc.dw.core.ad.IAdEventListener
        public native /* bridge */ /* synthetic */ void onRenderSuccess(InterstitialAd interstitialAd);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.ms.MSInterstitialAdapter$2, reason: invalid class name */
    @Keep
    public class AnonymousClass2 implements InteractionListener {
        final MSInterstitialAdapter this$0;

        static {
            OSETSDKProtected.interface11(4159);
        }

        public AnonymousClass2(MSInterstitialAdapter mSInterstitialAdapter) {
            this.this$0 = mSInterstitialAdapter;
        }

        @Override // com.kc.dw.core.loader.InteractionListener
        public native void onAdClicked();

        @Override // com.kc.dw.core.loader.InteractionListener
        public native void onAdClosed();

        @Override // com.kc.dw.core.loader.InteractionListener
        public native void onAdExposure();
    }

    static {
        OSETSDKProtected.interface11(4160);
    }

    public static native /* synthetic */ void access$000(MSInterstitialAdapter mSInterstitialAdapter, int i, String str);

    public static native /* synthetic */ void access$100(MSInterstitialAdapter mSInterstitialAdapter, int i, String str);

    public static native /* synthetic */ InterstitialAd access$202(MSInterstitialAdapter mSInterstitialAdapter, InterstitialAd interstitialAd);

    public static native /* synthetic */ void access$300(MSInterstitialAdapter mSInterstitialAdapter);

    public static native /* synthetic */ void access$400(MSInterstitialAdapter mSInterstitialAdapter, int i, String str);

    public static native /* synthetic */ void access$500(MSInterstitialAdapter mSInterstitialAdapter, int i, String str);

    public static native /* synthetic */ void access$600(MSInterstitialAdapter mSInterstitialAdapter);

    public static native /* synthetic */ void access$700(MSInterstitialAdapter mSInterstitialAdapter);

    public static native /* synthetic */ void access$800(MSInterstitialAdapter mSInterstitialAdapter);

    private native InterstitialAdLoadListener getAdLoadListener();

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
