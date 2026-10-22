package com.kc.openset.config;

import android.app.Application;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.kc.openset.config.controller.OSETCustomController;
import com.kc.openset.listener.OSETInitListener;
import com.kc.openset.util.DeviceIdUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
final class d extends OSETSDK {
    private com.kc.openset.bean.c e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private long f39751a = 0;
    private long b = 0;
    boolean c = false;
    private long d = 0;
    private final DeviceIdUtils.OnDeviceIdResult f = new DeviceIdUtils.OnDeviceIdResult(this) { // from class: com.kc.openset.config.d$$ExternalSyntheticLambda0
        public final d f$0;

        static {
            OSETSDKProtected.interface11(4402);
        }

        {
            this.f$0 = this;
        }

        @Override // com.kc.openset.util.DeviceIdUtils.OnDeviceIdResult
        public final native void onResult();
    };

    @Keep
    public class a implements OSETHttpCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final OSETInitListener f39752a;
        final String b;
        final d c;

        /* JADX INFO: renamed from: $r8$lambda$eTWCDq-X0kOM-42UvB-oEuWa_hw, reason: not valid java name */
        public static native /* synthetic */ void m1034$r8$lambda$eTWCDqX0kOM42UvBoEuWa_hw(a aVar, com.kc.openset.bean.c cVar);

        static {
            OSETSDKProtected.interface11(4405);
        }

        public a(d dVar, OSETInitListener oSETInitListener, String str) {
            this.c = dVar;
            this.f39752a = oSETInitListener;
            this.b = str;
        }

        private native /* synthetic */ void a(com.kc.openset.bean.c cVar);

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onFailure(int i, String str);

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onSuccess(int i, String str);
    }

    /* JADX INFO: renamed from: $r8$lambda$DUihC2kpyToVT-uuWkpxnOE6ELw, reason: not valid java name */
    public static native /* synthetic */ void m1033$r8$lambda$DUihC2kpyToVTuuWkpxnOE6ELw(d dVar, com.kc.openset.bean.c cVar);

    public static native /* synthetic */ void $r8$lambda$JD7XctZfXVvAtbLekh3EZH5vjx4(d dVar);

    static {
        OSETSDKProtected.interface11(4406);
    }

    public static native /* synthetic */ long a(d dVar);

    public static native /* synthetic */ long a(d dVar, long j);

    private native void a(com.kc.openset.bean.c cVar);

    private native void a(com.kc.openset.bean.c cVar, OSETInitListener oSETInitListener, boolean z);

    public static native /* synthetic */ void a(d dVar, com.kc.openset.bean.c cVar);

    public static native /* synthetic */ void a(d dVar, com.kc.openset.bean.c cVar, OSETInitListener oSETInitListener, boolean z);

    public static native /* synthetic */ void a(d dVar, String str, String str2, long j);

    private native void a(String str, String str2, long j);

    private native boolean a();

    private native void b();

    private native void b(com.kc.openset.bean.c cVar);

    private native /* synthetic */ void c();

    private native void c(com.kc.openset.bean.c cVar);

    private native void d();

    private native void d(com.kc.openset.bean.c cVar);

    private native void e(com.kc.openset.bean.c cVar);

    private native void f(com.kc.openset.bean.c cVar);

    private native /* synthetic */ void g(com.kc.openset.bean.c cVar);

    private native void h(com.kc.openset.bean.c cVar);

    @Override // com.kc.openset.config.OSETSDK
    public native int getVersionCode();

    @Override // com.kc.openset.config.OSETSDK
    public native String getVersionName();

    @Override // com.kc.openset.config.OSETSDK
    public native void init(Application application, String str, OSETInitListener oSETInitListener);

    @Override // com.kc.openset.config.OSETSDK
    public native OSETSDK setChannel(ChannelType channelType);

    @Override // com.kc.openset.config.OSETSDK
    public native OSETSDK setCustomController(OSETCustomController oSETCustomController);

    @Override // com.kc.openset.config.OSETSDK
    public native OSETSDK setDebug(boolean z);

    @Override // com.kc.openset.config.OSETSDK
    public native OSETSDK setUserId(String str);
}
