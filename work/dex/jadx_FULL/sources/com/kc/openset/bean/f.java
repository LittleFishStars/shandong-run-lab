package com.kc.openset.bean;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.advertisers.bash.BaseConfig;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Class<? extends BaseConfig> f39715a;
    private final String b;
    private final String c;
    private final String d;
    private final boolean e;
    private final List<String> f;
    private final String g;
    private final String h;

    @Keep
    public static /* synthetic */ class a {
    }

    @Keep
    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Class<? extends BaseConfig> f39716a;
        private String b;
        private String c;
        private String d;
        private boolean e;
        private List<String> f;
        private String g;
        private String h;

        static {
            OSETSDKProtected.interface11(4314);
        }

        public static native /* synthetic */ Class a(b bVar);

        public static native /* synthetic */ String b(b bVar);

        public static native /* synthetic */ String c(b bVar);

        public static native /* synthetic */ List d(b bVar);

        public static native /* synthetic */ String e(b bVar);

        public static native /* synthetic */ boolean f(b bVar);

        public static native /* synthetic */ String g(b bVar);

        public static native /* synthetic */ String h(b bVar);

        public native b a(Class<? extends BaseConfig> cls);

        public native b a(String str);

        public native b a(boolean z);

        public native b a(String... strArr);

        public native f a();

        public native b b(String str);

        public native b c(String str);

        public native b d(String str);

        public native b e(String str);
    }

    static {
        OSETSDKProtected.interface11(4315);
    }

    private f(b bVar) {
        this.f39715a = b.a(bVar);
        this.b = b.b(bVar);
        this.c = b.c(bVar);
        this.f = b.d(bVar);
        this.d = b.e(bVar);
        this.e = b.f(bVar);
        this.g = b.g(bVar);
        this.h = b.h(bVar);
    }

    public /* synthetic */ f(b bVar, a aVar) {
        this(bVar);
    }

    public native String a();

    public native String b();

    public native String c();

    public native List<String> d();

    public native String e();

    public native String f();

    public native Class<? extends BaseConfig> g();

    public native boolean h();

    public native String toString();
}
