package com.kc.openset.advertisers.adv;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseRewardBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kc.openset.sdk.adv.listener.OSETADVRewardListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class f extends BaseRewardBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.kc.openset.sdk.adv.hub.e f39693a;

    @Keep
    public class a implements OSETADVRewardListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final f f39694a;

        static {
            OSETSDKProtected.interface11(4239);
        }

        public a(f fVar) {
            this.f39694a = fVar;
        }

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native String getUserId();

        @Override // com.kc.openset.sdk.adv.listener.OSETADVRewardListener
        public native void onAdClick();

        @Override // com.kc.openset.sdk.adv.listener.OSETADVRewardListener
        public native void onAdClosed();

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native void onAdLoadFailure(String str, String str2);

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native void onAdLoadSuccess();

        @Override // com.kc.openset.sdk.adv.listener.OSETADVRewardListener
        public native void onAdShow();

        @Override // com.kc.openset.sdk.adv.listener.OSETADVRewardListener
        public native void onAdSkip();

        @Override // com.kc.openset.sdk.adv.listener.OSETADVRewardListener
        public native void onReward();

        @Override // com.kc.openset.sdk.adv.listener.OSETADVRewardListener
        public native void onVideoComplete();

        @Override // com.kc.openset.sdk.adv.listener.OSETADVRewardListener
        public native void onVideoError(String str, String str2);
    }

    static {
        OSETSDKProtected.interface11(4240);
    }

    public static native /* synthetic */ com.kc.openset.sdk.adv.hub.e a(f fVar);

    private native void a();

    public static native /* synthetic */ void a(f fVar, String str);

    public static native /* synthetic */ void a(f fVar, String str, String str2);

    private native void b();

    public static native /* synthetic */ void b(f fVar);

    public static native /* synthetic */ void b(f fVar, String str);

    public static native /* synthetic */ void b(f fVar, String str, String str2);

    public static native /* synthetic */ void c(f fVar);

    public static native /* synthetic */ void d(f fVar);

    public static native /* synthetic */ void e(f fVar);

    public static native /* synthetic */ void f(f fVar);

    public static native /* synthetic */ void g(f fVar);

    public static native /* synthetic */ void h(f fVar);

    public static native /* synthetic */ void i(f fVar);

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
