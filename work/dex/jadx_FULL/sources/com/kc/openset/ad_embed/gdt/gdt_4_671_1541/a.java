package com.kc.openset.ad_embed.gdt.gdt_4_671_1541;

import android.app.Activity;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseBannerBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.banner2.UnifiedBannerADListener;
import com.qq.e.ads.banner2.UnifiedBannerView;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class a extends BaseBannerBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<UnifiedBannerView> f39662a;
    private WeakReference<View> b;

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.gdt.gdt_4_671_1541.a$a, reason: collision with other inner class name */
    @Keep
    public class C1104a implements UnifiedBannerADListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final a f39663a;

        static {
            OSETSDKProtected.interface11(3929);
        }

        public C1104a(a aVar) {
            this.f39663a = aVar;
        }

        public native void onADClicked();

        public native void onADClosed();

        public native void onADExposure();

        public native void onADLeftApplication();

        public native void onADReceive();

        public native void onNoAD(AdError adError);
    }

    static {
        OSETSDKProtected.interface11(3930);
    }

    private native UnifiedBannerView a();

    public static native /* synthetic */ void a(a aVar, View view);

    public static native /* synthetic */ void a(a aVar, String str, String str2);

    public static native /* synthetic */ boolean a(a aVar);

    public static native /* synthetic */ void b(a aVar);

    public static native /* synthetic */ void b(a aVar, View view);

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

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native boolean isUsable();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
