package com.kc.openset.ad_embed.gdt.gdt_4_671_1541;

import android.app.Activity;
import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseNativeBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.nativ.NativeExpressAD;
import com.qq.e.ads.nativ.NativeExpressADView;
import com.qq.e.comm.util.AdError;
import java.lang.ref.WeakReference;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class f extends BaseNativeBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private WeakReference<NativeExpressADView> f39673a;

    @Keep
    public class a implements NativeExpressAD.NativeExpressADListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final f f39674a;

        static {
            OSETSDKProtected.interface11(3942);
        }

        public a(f fVar) {
            this.f39674a = fVar;
        }

        public native void onADClicked(NativeExpressADView nativeExpressADView);

        public native void onADClosed(NativeExpressADView nativeExpressADView);

        public native void onADExposure(NativeExpressADView nativeExpressADView);

        public native void onADLeftApplication(NativeExpressADView nativeExpressADView);

        public native void onADLoaded(List<NativeExpressADView> list);

        public native void onNoAD(AdError adError);

        public native void onRenderFail(NativeExpressADView nativeExpressADView);

        public native void onRenderSuccess(NativeExpressADView nativeExpressADView);
    }

    static {
        OSETSDKProtected.interface11(3943);
    }

    private native NativeExpressAD a();

    public static native /* synthetic */ WeakReference a(f fVar, WeakReference weakReference);

    public static native /* synthetic */ void a(f fVar);

    public static native /* synthetic */ void a(f fVar, View view);

    public static native /* synthetic */ void a(f fVar, String str, String str2);

    public static native /* synthetic */ void b(f fVar, View view);

    public static native /* synthetic */ void b(f fVar, String str, String str2);

    public static native /* synthetic */ boolean b(f fVar);

    public static native /* synthetic */ void c(f fVar, View view);

    public static native /* synthetic */ void c(f fVar, String str, String str2);

    public static native /* synthetic */ void d(f fVar, View view);

    public static native /* synthetic */ void d(f fVar, String str, String str2);

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

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
