package com.kc.openset.config;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.bean.f;
import com.kc.openset.bean.g;
import com.kc.openset.bean.h;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final List<f> f39748a;
    private static final List<g> b;
    private static final List<h> c;

    static {
        OSETSDKProtected.interface11(4396);
        f39748a = new ArrayList();
        b = new ArrayList();
        c = new ArrayList();
    }

    public static native int a(String str, String str2);

    private static native String a();

    public static native void a(f fVar);

    public static native void a(g gVar);

    public static native void a(h hVar);

    private static native void a(String str);

    public static native List<f> b();

    private static native void b(String str);

    public static native List<g> c();

    public static native List<h> d();

    public static native void e();

    private static native void f();
}
