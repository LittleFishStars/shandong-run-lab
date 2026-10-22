package com.kc.openset.bean;

import android.content.Context;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class i {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f39721a;
    private final String b;
    private final String c;
    private final String d;
    private final String e;
    private final String f;
    private final String g;
    private final int h;
    private final int i;

    @Keep
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f39722a;
        private String b;
        private String c;
        private String d;
        private String e;
        private String f;
        private String g;
        private int h;
        private int i;

        static {
            OSETSDKProtected.interface11(4322);
        }

        public native a a(int i);

        public native a a(Context context);

        public native a a(String str);

        public native i a();

        public native a b(int i);

        public native a b(String str);

        public native a c(String str);

        public native a d(String str);

        public native a e(String str);

        public native a f(String str);
    }

    static {
        OSETSDKProtected.interface11(4323);
    }

    public i(Context context, String str, String str2, String str3, String str4, String str5, String str6, int i, int i2) {
        this.f39721a = context;
        this.b = str;
        this.c = str2;
        this.d = str3;
        this.e = str4;
        this.f = str5;
        this.g = str6;
        this.h = i;
        this.i = i2;
    }

    public static native a a();

    public native String b();

    public native String c();

    public native String d();

    public native String e();

    public native int f();

    public native int g();

    public native String h();

    public native String i();
}
