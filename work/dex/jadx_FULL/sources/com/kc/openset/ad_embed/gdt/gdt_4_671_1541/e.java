package com.kc.openset.ad_embed.gdt.gdt_4_671_1541;

import android.app.Activity;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseInterstitialBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.interstitial2.UnifiedInterstitialAD;
import com.qq.e.ads.interstitial2.UnifiedInterstitialADListener;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class e extends BaseInterstitialBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private UnifiedInterstitialAD f39671a;

    @Keep
    public class a implements UnifiedInterstitialADListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final e f39672a;

        static {
            OSETSDKProtected.interface11(3940);
        }

        public a(e eVar) {
            this.f39672a = eVar;
        }

        public native void onADClicked();

        public native void onADClosed();

        public native void onADExposure();

        public native void onADLeftApplication();

        public native void onADOpened();

        public native void onADReceive();

        public native void onNoAD(AdError adError);

        public native void onRenderFail();

        public native void onRenderSuccess();

        public native void onVideoCached();
    }

    static {
        OSETSDKProtected.interface11(3941);
    }

    private native UnifiedInterstitialAD a();

    public static native /* synthetic */ void a(e eVar);

    public static native /* synthetic */ void a(e eVar, String str, String str2);

    public static native /* synthetic */ void b(e eVar, String str, String str2);

    public static native /* synthetic */ boolean b(e eVar);

    public static native /* synthetic */ void c(e eVar);

    public static native /* synthetic */ void c(e eVar, String str, String str2);

    public static native /* synthetic */ void d(e eVar);

    public static native /* synthetic */ void e(e eVar);

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
