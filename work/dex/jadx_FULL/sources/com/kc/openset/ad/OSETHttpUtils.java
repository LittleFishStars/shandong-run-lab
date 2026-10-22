package com.kc.openset.ad;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.kc.openset.bridge.common.OSETHttpCallback;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;
import java.util.Queue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OSETHttpUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile OSETHttpUtils f39612a;
    private long b;

    @Keep
    public interface ICallBack {
        void onLoadFail(String str, String str2);

        void onSuccess(b bVar);
    }

    @Keep
    public class a implements OSETHttpCallback {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final ICallBack f39613a;
        final AdType b;
        final int c;
        final String d;
        final OSETHttpUtils e;

        static {
            OSETSDKProtected.interface11(3720);
        }

        public a(OSETHttpUtils oSETHttpUtils, ICallBack iCallBack, AdType adType, int i, String str) {
            this.e = oSETHttpUtils;
            this.f39613a = iCallBack;
            this.b = adType;
            this.c = i;
            this.d = str;
        }

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onFailure(int i, String str);

        @Override // com.kc.openset.bridge.common.OSETHttpCallback
        public native void onSuccess(int i, String str);
    }

    /* JADX INFO: renamed from: $r8$lambda$pj6Iq8Nw-gtKl98l7RVn9k_yh0U, reason: not valid java name */
    public static native /* synthetic */ void m1007$r8$lambda$pj6Iq8NwgtKl98l7RVn9k_yh0U(ICallBack iCallBack, b bVar, boolean z, String str, String str2);

    /* JADX INFO: renamed from: $r8$lambda$qEPzaqgaxy4ONsaYXx-cMeReCG0, reason: not valid java name */
    public static native /* synthetic */ void m1008$r8$lambda$qEPzaqgaxy4ONsaYXxcMeReCG0(OSETHttpUtils oSETHttpUtils, AdType adType, String str, ICallBack iCallBack, String str2);

    static {
        OSETSDKProtected.interface11(3721);
    }

    private OSETHttpUtils() {
    }

    public static native OSETHttpUtils a();

    public static native /* synthetic */ b a(OSETHttpUtils oSETHttpUtils, AdType adType, int i, String str, ICallBack iCallBack, String str2, boolean z);

    public static native /* synthetic */ b a(OSETHttpUtils oSETHttpUtils, String str, String str2, ICallBack iCallBack, AdType adType);

    private native b a(AdType adType, int i, String str, ICallBack iCallBack, String str2, boolean z);

    private native b a(AdType adType, String str, int i, ICallBack iCallBack, String str2, String str3, boolean z);

    private native b a(String str, String str2, ICallBack iCallBack, AdType adType);

    private native String a(AdType adType);

    private static native Queue<e> a(List<e> list, int i, int i2);

    private native Queue<c> a(List<e> list, List<e> list2, int i, String str, int i2, String str2, String str3, AdType adType);

    private native Queue<c> a(List<e> list, List<e> list2, int i, String str, String str2, String str3, AdType adType);

    private static native /* synthetic */ void a(ICallBack iCallBack, b bVar, boolean z, String str, String str2);

    private native /* synthetic */ void a(AdType adType, String str, ICallBack iCallBack, String str2);

    public native b a(AdType adType, String str, int i, ICallBack iCallBack);

    public native void b(AdType adType, String str, int i, ICallBack iCallBack);
}
