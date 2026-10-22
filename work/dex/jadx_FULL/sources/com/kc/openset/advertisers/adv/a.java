package com.kc.openset.advertisers.adv;

import android.app.Activity;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseBannerBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.kc.openset.sdk.adv.listener.ADVBannerListener;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class a extends BaseBannerBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.kc.openset.sdk.adv.hub.a f39685a;
    private WeakReference<View> b;

    /* JADX INFO: renamed from: com.kc.openset.advertisers.adv.a$a, reason: collision with other inner class name */
    @Keep
    public class C1107a implements ADVBannerListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f39686a;

        static {
            OSETSDKProtected.interface11(4230);
        }

        public C1107a(a aVar) {
            this.f39686a = aVar;
        }

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native String getUserId();

        @Override // com.kc.openset.sdk.adv.listener.ADVBannerListener
        public native void onAdClick(View view);

        @Override // com.kc.openset.sdk.adv.listener.ADVBannerListener
        public native void onAdClosed(View view);

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native void onAdLoadFailure(String str, String str2);

        @Override // com.kc.openset.sdk.adv.listener.ADVBaseListener
        public native void onAdLoadSuccess();

        @Override // com.kc.openset.sdk.adv.listener.ADVBannerListener
        public native void onAdShow(View view);

        @Override // com.kc.openset.sdk.adv.listener.ADVBannerListener
        public native void onAdShowFailure(String str, String str2);
    }

    static {
        OSETSDKProtected.interface11(4231);
    }

    public static native /* synthetic */ com.kc.openset.sdk.adv.hub.a a(a aVar);

    private native void a();

    public static native /* synthetic */ void a(a aVar, View view);

    public static native /* synthetic */ void a(a aVar, String str);

    public static native /* synthetic */ void a(a aVar, String str, String str2);

    private native void b();

    public static native /* synthetic */ void b(a aVar);

    public static native /* synthetic */ void b(a aVar, View view);

    public static native /* synthetic */ void b(a aVar, String str);

    public static native /* synthetic */ void b(a aVar, String str, String str2);

    public static native /* synthetic */ WeakReference c(a aVar);

    public static native /* synthetic */ void c(a aVar, View view);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidFail(WinAdData winAdData, boolean z);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void bidSuccess(LossAdData lossAdData);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void destroyAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdFront();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native String getAdTitle();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
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
