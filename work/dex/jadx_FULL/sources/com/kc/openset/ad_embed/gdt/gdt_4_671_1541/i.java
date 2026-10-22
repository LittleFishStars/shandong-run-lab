package com.kc.openset.ad_embed.gdt.gdt_4_671_1541;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.base.bridge.BaseSplashBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.splash.SplashAD;
import com.qq.e.ads.splash.SplashADListener;
import com.qq.e.comm.util.AdError;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class i extends BaseSplashBridge {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private SplashAD f39680a;
    int b = 0;
    private final Handler c = new b(this, Looper.getMainLooper());

    @Keep
    public class a implements SplashADListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final i f39681a;

        static {
            OSETSDKProtected.interface11(3949);
        }

        public a(i iVar) {
            this.f39681a = iVar;
        }

        public native void onADClicked();

        public native void onADDismissed();

        public native void onADExposure();

        public native void onADLoaded(long j);

        public native void onADPresent();

        public native void onADTick(long j);

        public native void onNoAD(AdError adError);
    }

    @Keep
    public class b extends Handler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final i f39682a;

        static {
            OSETSDKProtected.interface11(3950);
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(i iVar, Looper looper) {
            super(looper);
            this.f39682a = iVar;
        }

        @Override // android.os.Handler
        public native void handleMessage(Message message);
    }

    static {
        OSETSDKProtected.interface11(3951);
    }

    private native SplashAD a();

    public static native /* synthetic */ void a(i iVar);

    public static native /* synthetic */ void a(i iVar, String str, String str2);

    public static native /* synthetic */ void b(i iVar, String str, String str2);

    public static native /* synthetic */ boolean b(i iVar);

    public static native /* synthetic */ void c(i iVar);

    public static native /* synthetic */ void c(i iVar, String str, String str2);

    public static native /* synthetic */ void d(i iVar);

    public static native /* synthetic */ void e(i iVar);

    public static native /* synthetic */ SplashAD f(i iVar);

    public static native /* synthetic */ Handler g(i iVar);

    public native boolean a(View view);

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
    public native void toShowAd(Activity activity, ViewGroup viewGroup);
}
