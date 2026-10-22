package com.kc.openset.ad_embed.gdt.gdt_4_671_1541;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.NativeViewConfig;
import com.kc.openset.ad.base.ViewHolderManager;
import com.kc.openset.ad.base.bridge.BaseDrawNativeBridge;
import com.kc.openset.ad.base.bridge.LossAdData;
import com.kc.openset.ad.base.bridge.WinAdData;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import com.qq.e.ads.cfg.VideoOption;
import com.qq.e.ads.nativ.MediaView;
import com.qq.e.ads.nativ.NativeADEventListener;
import com.qq.e.ads.nativ.NativeADMediaListener;
import com.qq.e.ads.nativ.NativeADUnifiedListener;
import com.qq.e.ads.nativ.NativeUnifiedAD;
import com.qq.e.ads.nativ.NativeUnifiedADData;
import com.qq.e.comm.util.AdError;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class b extends BaseDrawNativeBridge implements View.OnClickListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private NativeUnifiedADData f39664a;
    private ViewHolderManager.ViewHolder b;
    String c;
    String d;
    String e;
    String f;
    float g;
    float h;

    @Keep
    public class a implements NativeADUnifiedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f39665a;

        static {
            OSETSDKProtected.interface11(3932);
        }

        public a(b bVar) {
            this.f39665a = bVar;
        }

        public native void onADLoaded(List<NativeUnifiedADData> list);

        public native void onNoAD(AdError adError);
    }

    /* JADX INFO: renamed from: com.kc.openset.ad_embed.gdt.gdt_4_671_1541.b$b, reason: collision with other inner class name */
    @Keep
    public class C1105b implements NativeADEventListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final NativeUnifiedADData f39666a;
        final b b;

        static {
            OSETSDKProtected.interface11(3933);
        }

        public C1105b(b bVar, NativeUnifiedADData nativeUnifiedADData) {
            this.b = bVar;
            this.f39666a = nativeUnifiedADData;
        }

        public native void onADClicked();

        public native void onADError(AdError adError);

        public native void onADExposed();

        public native void onADStatusChanged();
    }

    @Keep
    public class c implements NativeADMediaListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final b f39667a;

        static {
            OSETSDKProtected.interface11(3934);
        }

        public c(b bVar) {
            this.f39667a = bVar;
        }

        public native void onVideoClicked();

        public native void onVideoCompleted();

        public native void onVideoError(AdError adError);

        public native void onVideoInit();

        public native void onVideoLoaded(int i);

        public native void onVideoLoading();

        public native void onVideoPause();

        public native void onVideoReady();

        public native void onVideoResume();

        public native void onVideoStart();

        public native void onVideoStop();
    }

    public static native /* synthetic */ boolean $r8$lambda$yUXiJ8BiHKI2nMzY7qTZKNIVl04(b bVar, View view, MotionEvent motionEvent);

    static {
        OSETSDKProtected.interface11(3935);
    }

    private native NativeUnifiedAD a();

    public static native /* synthetic */ NativeUnifiedADData a(b bVar);

    public static native /* synthetic */ NativeUnifiedADData a(b bVar, NativeUnifiedADData nativeUnifiedADData);

    private native void a(Activity activity);

    private native void a(Context context, String str, int i);

    private native void a(Context context, String str, int i, boolean z);

    private native void a(View view);

    public static native /* synthetic */ void a(b bVar, View view);

    public static native /* synthetic */ void a(b bVar, String str, String str2);

    private native void a(NativeUnifiedADData nativeUnifiedADData);

    private native void a(NativeUnifiedADData nativeUnifiedADData, MediaView mediaView, VideoOption videoOption);

    private native /* synthetic */ boolean a(View view, MotionEvent motionEvent);

    private native NativeViewConfig b();

    public static native /* synthetic */ void b(b bVar);

    public static native /* synthetic */ void b(b bVar, View view);

    public static native /* synthetic */ void b(b bVar, String str, String str2);

    public static native /* synthetic */ void c(b bVar, View view);

    public static native /* synthetic */ void c(b bVar, String str, String str2);

    public static native /* synthetic */ boolean c(b bVar);

    public static native /* synthetic */ ViewHolderManager.ViewHolder d(b bVar);

    public static native /* synthetic */ void d(b bVar, View view);

    public static native /* synthetic */ void d(b bVar, String str, String str2);

    public static native /* synthetic */ void e(b bVar, View view);

    public static native /* synthetic */ void e(b bVar, String str, String str2);

    public static native /* synthetic */ void f(b bVar, View view);

    public static native /* synthetic */ void f(b bVar, String str, String str2);

    public native void a(Activity activity, ViewGroup viewGroup);

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

    @Override // android.view.View.OnClickListener
    public native void onClick(View view);

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toLoadAd();

    @Override // com.kc.openset.ad.base.bridge.AdBridge
    public native void toShowAd(Activity activity);
}
