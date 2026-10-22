package com.kc.openset.bean;

import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f39705a;
    private List<C1109a> b;

    /* JADX INFO: renamed from: com.kc.openset.bean.a$a, reason: collision with other inner class name */
    @Keep
    public static class C1109a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f39706a;
        private String b;
        private double c;
        private String d;
        private List<String> e;
        private String f;

        static {
            OSETSDKProtected.interface11(4302);
        }

        public native String a();

        public native void a(double d);

        public native void a(String str);

        public native void a(List<String> list);

        public native double b();

        public native void b(String str);

        public native String c();

        public native void c(String str);

        public native String d();

        public native List<String> e();
    }

    static {
        OSETSDKProtected.interface11(4303);
    }

    public native List<C1109a> a();

    public native void a(int i);

    public native void a(List<C1109a> list);

    public native int b();
}
