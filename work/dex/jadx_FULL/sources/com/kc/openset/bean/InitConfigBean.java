package com.kc.openset.bean;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.advertisers.bash.BaseConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class InitConfigBean {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final BaseConfig f39700a;
    private final String b;
    private final String c;
    private final String d;
    private final List<String> e;
    private final boolean f;
    private final boolean g;
    private final String h;
    private InitStatus i;
    private String j;
    private String k;
    private volatile boolean l;
    private final String m;

    @Keep
    public enum InitStatus {
        INIT_STATUS_NORMAL,
        INIT_STATUS_INITIALIZING,
        INIT_STATUS_INIT_SUCCESS,
        INIT_STATUS_INIT_FAIL,
        INIT_STATUS_STARTING,
        INIT_STATUS_START_SUCCESS,
        INIT_STATUS_START_FAIL;

        static {
            OSETSDKProtected.interface11(4292);
        }

        public static native InitStatus valueOf(String str);

        public static native InitStatus[] values();
    }

    @Keep
    public static /* synthetic */ class a {
    }

    @Keep
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private BaseConfig f39701a;
        private String b;
        private String c;
        private String d;
        private boolean e;
        private boolean f;
        private List<String> g;
        private String h;
        private String i;

        static {
            OSETSDKProtected.interface11(4294);
        }

        public static native /* synthetic */ BaseConfig a(b bVar);

        public static native /* synthetic */ String b(b bVar);

        public static native /* synthetic */ String c(b bVar);

        public static native /* synthetic */ String d(b bVar);

        public static native /* synthetic */ boolean e(b bVar);

        public static native /* synthetic */ boolean f(b bVar);

        public static native /* synthetic */ List g(b bVar);

        public static native /* synthetic */ String h(b bVar);

        public static native /* synthetic */ String i(b bVar);

        public native b a(BaseConfig baseConfig);

        public native b a(String str);

        public native b a(List<String> list);

        public native b a(boolean z);

        public native InitConfigBean a();

        public native b b(String str);

        public native b b(boolean z);

        public native b c(String str);

        public native b d(String str);

        public native b e(String str);
    }

    static {
        OSETSDKProtected.interface11(4295);
    }

    private InitConfigBean(b bVar) {
        this.i = InitStatus.INIT_STATUS_NORMAL;
        this.f39700a = b.a(bVar);
        this.b = b.b(bVar);
        this.c = b.c(bVar);
        this.d = b.d(bVar);
        this.f = b.e(bVar);
        this.g = b.f(bVar);
        this.e = b.g(bVar);
        this.h = b.h(bVar);
        this.m = b.i(bVar);
    }

    public /* synthetic */ InitConfigBean(b bVar, a aVar) {
        this(bVar);
    }

    public native String a();

    public native void a(InitStatus initStatus);

    public native void a(String str);

    public native void a(boolean z);

    public native String b();

    public native void b(String str);

    public native String c();

    public native String d();

    public native List<String> e();

    public native InitStatus f();

    public native String g();

    public native BaseConfig h();

    public native String i();

    public native String j();

    public native boolean k();

    public native boolean l();

    public native boolean m();

    public native String toString();
}
