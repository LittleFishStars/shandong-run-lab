package com.kc.openset.advertisers.adv;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseInterstitialBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kc.openset.sdk.adv.listener.OSETADVInterstitialListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class c extends BaseInterstitialBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.kc.openset.sdk.adv.hub.b f39687a;

    @Keep
    public class a implements OSETADVInterstitialListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final c f39688a;

        static {
            OSETSDKProtected.interface11(4233);
        }

        public a(c cVar) {
            this.f39688a = cVar;
        }

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native String getUserId();

        @Override // com.kc.openset.sdk.adv.listener.OSETADVInterstitialListener
        public native void onAdClick();

        @Override // com.kc.openset.sdk.adv.listener.OSETADVInterstitialListener
        public native void onAdClosed();

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native void onAdLoadFailure(String str, String str2);

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native void onAdLoadSuccess();

        @Override // com.kc.openset.sdk.adv.listener.OSETADVInterstitialListener
        public native void onAdShow();

        @Override // com.kc.openset.sdk.adv.listener.OSETADVInterstitialListener
        public native void onVideoError(String str, String str2);
    }

    static {
        OSETSDKProtected.interface11(4234);
    }

    public static native /* synthetic */ com.kc.openset.sdk.adv.hub.b a(c cVar);

    private native void a();

    public static native /* synthetic */ void a(c cVar, String str);

    public static native /* synthetic */ void a(c cVar, String str, String str2);

    private native void b();

    public static native /* synthetic */ void b(c cVar);

    public static native /* synthetic */ void b(c cVar, String str);

    public static native /* synthetic */ void b(c cVar, String str, String str2);

    public static native /* synthetic */ void c(c cVar);

    public static native /* synthetic */ void d(c cVar);

    public static native /* synthetic */ void e(c cVar);

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

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadS2SAd(String str);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
