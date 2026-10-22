package com.kc.openset.config;

import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.config.controller.OSETCustomController;
import com.kc.openset.hook.LogoInfoBean;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class c {
    private static String A = null;
    private static String B = null;
    private static List<LogoInfoBean> C = null;
    private static List<com.kc.openset.bean.b> D = null;
    private static String E = null;
    private static boolean F = false;
    private static int G = 0;
    private static int H = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static String f39750a = null;
    private static int b = 0;
    private static int c = 0;
    private static String d = "";
    private static String e = "";
    private static String f = "";
    private static String g = "";
    private static boolean h = false;
    private static boolean i = false;
    private static boolean j = false;
    private static int k = 0;
    private static int l = 0;
    private static int m = 1;
    private static boolean n = false;
    private static boolean o = false;
    private static boolean p = false;
    private static boolean q = true;
    private static boolean r = true;
    private static boolean s;
    private static OSETCustomController t;
    private static String u;
    private static boolean v;
    private static ChannelType w;
    private static int x;
    private static Map<String, Integer> y;
    private static boolean z;

    static {
        OSETSDKProtected.interface11(4398);
        t = new com.kc.openset.config.controller.a();
        v = false;
        w = ChannelType.DEFAULT;
        x = 0;
        y = new HashMap();
        z = false;
        E = "";
        F = false;
        G = 3000;
        H = 2;
    }

    public static native String A();

    public static native int B();

    public static native String C();

    public static native String D();

    public static native String E();

    public static native String F();

    public static native boolean G();

    public static native boolean H();

    public static native boolean I();

    public static native boolean J();

    public static native boolean K();

    public static native boolean L();

    public static native boolean M();

    public static native boolean N();

    public static native boolean O();

    public static native void a(int i2);

    public static native void a(ChannelType channelType);

    public static native void a(OSETCustomController oSETCustomController);

    public static native void a(String str);

    public static native void a(List<com.kc.openset.bean.b> list);

    public static native void a(Map<String, Integer> map);

    public static native void a(boolean z2);

    public static native boolean a();

    public static native void b(int i2);

    public static native void b(String str);

    public static native void b(List<LogoInfoBean> list);

    public static native void b(boolean z2);

    public static native boolean b();

    public static native void c(int i2);

    public static native void c(String str);

    public static native void c(boolean z2);

    public static native boolean c();

    public static native void d(int i2);

    public static native void d(String str);

    public static native void d(boolean z2);

    public static native boolean d();

    public static native void e(int i2);

    public static native void e(String str);

    public static native void e(boolean z2);

    public static native boolean e();

    public static native void f(int i2);

    public static native void f(String str);

    public static native void f(boolean z2);

    public static native boolean f();

    public static native void g(int i2);

    public static native void g(String str);

    public static native void g(boolean z2);

    public static native boolean g();

    public static native void h(int i2);

    public static native void h(String str);

    public static native void h(boolean z2);

    public static native boolean h();

    public static native String i();

    public static native void i(String str);

    public static native void i(boolean z2);

    public static native int j();

    public static native void j(boolean z2);

    public static native int k();

    public static native void k(boolean z2);

    public static native String l();

    public static native void l(boolean z2);

    public static native String m();

    public static native Map<String, Integer> n();

    public static native ChannelType o();

    public static native int p();

    public static native String q();

    public static native int r();

    public static native List<com.kc.openset.bean.b> s();

    public static native String t();

    public static native String u();

    public static native List<String> v();

    public static native String w();

    public static native boolean x();

    public static native List<LogoInfoBean> y();

    public static native String z();
}
