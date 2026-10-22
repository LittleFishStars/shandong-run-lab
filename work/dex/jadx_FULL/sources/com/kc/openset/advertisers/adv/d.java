package com.kc.openset.advertisers.adv;

import android.app.Activity;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseNativeBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kc.openset.sdk.adv.listener.ADVNativeListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class d extends BaseNativeBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.kc.openset.sdk.adv.hub.c f39689a;

    @Keep
    public class a implements ADVNativeListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final d f39690a;

        static {
            OSETSDKProtected.interface11(4235);
        }

        public a(d dVar) {
            this.f39690a = dVar;
        }

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native String getUserId();

        @Override // com.kc.openset.sdk.adv.listener.ADVNativeListener
        public native void onAdClick(View view);

        @Override // com.kc.openset.sdk.adv.listener.ADVNativeListener
        public native void onAdClosed(View view);

        @Override // com.kc.openset.sdk.adv.listener.ADVNativeListener
        public native void onAdDetailViewClosed();

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native void onAdLoadFailure(String str, String str2);

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native void onAdLoadSuccess();

        @Override // com.kc.openset.sdk.adv.listener.ADVNativeListener
        public native void onAdShow(View view);

        @Override // com.kc.openset.sdk.adv.listener.ADVNativeListener
        public native void onAdShowFailure(String str, String str2);
    }

    static {
        OSETSDKProtected.interface11(4236);
    }

    public static native /* synthetic */ com.kc.openset.sdk.adv.hub.c a(d dVar);

    private native void a();

    public static native /* synthetic */ void a(d dVar, View view);

    public static native /* synthetic */ void a(d dVar, String str);

    public static native /* synthetic */ void a(d dVar, String str, String str2);

    private native void b();

    public static native /* synthetic */ void b(d dVar);

    public static native /* synthetic */ void b(d dVar, View view);

    public static native /* synthetic */ void b(d dVar, String str);

    public static native /* synthetic */ void b(d dVar, String str, String str2);

    public static native /* synthetic */ void c(d dVar);

    public static native /* synthetic */ void c(d dVar, View view);

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

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void onShowActivityPaused();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void onShowActivityResumed();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.BaseAdBridge, com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadS2SAd(String str);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
