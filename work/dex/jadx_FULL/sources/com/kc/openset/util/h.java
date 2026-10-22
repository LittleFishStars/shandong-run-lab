package com.kc.openset.util;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.ad.config.AdType;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static boolean f39973a;
    private final Map<String, List<com.kc.openset.ad.d>> b;
    private final Map<AdType, List<com.kc.openset.ad.d>> c;
    private final List<com.kc.openset.ad.d> d;
    private int e;

    public static native /* synthetic */ int $r8$lambda$7LGy3rRMHpJu55U09UvJYVtr24U(com.kc.openset.ad.d dVar, com.kc.openset.ad.d dVar2);

    static {
        OSETSDKProtected.interface11(5013);
    }

    public h() {
        this(5);
    }

    public h(int i) {
        this.b = new HashMap();
        this.c = new HashMap();
        this.d = new ArrayList();
        this.e = i <= 0 ? 5 : i;
    }

    private static native /* synthetic */ int a(com.kc.openset.ad.d dVar, com.kc.openset.ad.d dVar2);

    private native void b(List<com.kc.openset.ad.d> list);

    private native void c(com.kc.openset.ad.d dVar);

    private native void d(com.kc.openset.ad.d dVar);

    public native com.kc.openset.ad.d a(String str, AdType adType);

    public native void a();

    public native void a(int i);

    public native void a(com.kc.openset.ad.d dVar);

    public native void a(List<com.kc.openset.ad.d> list);

    public native void b(com.kc.openset.ad.d dVar);

    public native boolean b(String str, AdType adType);

    public native com.kc.openset.ad.d c(String str, AdType adType);

    public native void d(String str, AdType adType);

    public native int e(String str, AdType adType);

    public native String toString();
}
