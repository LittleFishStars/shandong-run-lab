package com.kc.openset.advertisers.adv;

import android.app.Activity;
import android.view.ViewGroup;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseSplashBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kc.openset.sdk.adv.listener.ADVSPlashListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class g extends BaseSplashBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.kc.openset.sdk.adv.hub.f f39695a;

    @Keep
    public class a implements ADVSPlashListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final com.kc.openset.sdk.adv.hub.f f39696a;
        final g b;

        static {
            OSETSDKProtected.interface11(4241);
        }

        public a(g gVar, com.kc.openset.sdk.adv.hub.f fVar) {
            this.b = gVar;
            this.f39696a = fVar;
        }

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native String getUserId();

        @Override // com.kc.openset.sdk.adv.listener.ADVSPlashListener
        public native void onAdClick();

        @Override // com.kc.openset.sdk.adv.listener.ADVSPlashListener
        public native void onAdClosed();

        @Override // com.kc.openset.sdk.adv.listener.ADVSPlashListener
        public native void onAdDetailViewClosed();

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native void onAdLoadFailure(String str, String str2);

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native void onAdLoadSuccess();

        @Override // com.kc.openset.sdk.adv.listener.ADVSPlashListener
        public native void onAdPreloadFailure(int i, String str);

        @Override // com.kc.openset.sdk.adv.listener.ADVSPlashListener
        public native void onAdPreloadSuccess();

        @Override // com.kc.openset.sdk.adv.listener.ADVSPlashListener
        public native void onAdShow();

        @Override // com.kc.openset.sdk.adv.listener.ADVSPlashListener
        public native void onAdShowFailure(String str, String str2);

        @Override // com.kc.openset.sdk.adv.listener.ADVSPlashListener
        public native void onAdSkip();
    }

    static {
        OSETSDKProtected.interface11(4242);
    }

    private native void a();

    public static native /* synthetic */ void a(g gVar);

    public static native /* synthetic */ void a(g gVar, String str);

    public static native /* synthetic */ void a(g gVar, String str, String str2);

    private native void a(com.kc.openset.sdk.adv.hub.f fVar);

    public static native /* synthetic */ void b(g gVar);

    public static native /* synthetic */ void b(g gVar, String str);

    public static native /* synthetic */ void b(g gVar, String str, String str2);

    public static native /* synthetic */ void c(g gVar);

    public static native /* synthetic */ void d(g gVar);

    public static native /* synthetic */ void e(g gVar);

    public static native /* synthetic */ void f(g gVar);

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

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void onShowActivityPaused();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void onShowActivityResumed();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadS2SAd(String str);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity, ViewGroup viewGroup);
}
