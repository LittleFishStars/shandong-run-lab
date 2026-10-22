package com.kc.openset.sdk.apiad.tools;

import android.view.View;
import com.jiagu.sdk.OSETSDKProtected;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_07_1493cls.dex */
@Keep
public class OSETClicksData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int[] f39915a;
    private int b;
    private int c;
    private boolean d;
    private int[] e;
    private int f;
    private int g;
    private int h;
    private i i;
    private i j;
    private j k;
    private boolean l;
    private Integer m;
    private boolean n;
    private int o;
    private boolean p;
    private String q;
    private String r;
    private String s;
    private boolean t;

    @Keep
    public @interface ClickType {
        public static final String AUTO_CLICK_TRIGGER = "1";
        public static final String AUTO_SHAKE_TRIGGER = "2";
        public static final String USER_TRIGGER = "0";
    }

    static {
        OSETSDKProtected.interface11(4876);
    }

    public static native OSETClicksData a(int i, j jVar);

    public static native OSETClicksData a(i iVar, i iVar2);

    private static native boolean b(i iVar, i iVar2);

    public native int a();

    public native void a(int i);

    public native void a(View view);

    public native void a(i iVar);

    public native void a(j jVar);

    public native void a(Integer num);

    public native void a(String str);

    public native void a(boolean z);

    public native void a(int[] iArr);

    public native void b(int i);

    public native void b(View view);

    public native void b(i iVar);

    public native void b(String str);

    public native void b(boolean z);

    public native void b(int[] iArr);

    public native int[] b();

    public native int c();

    public native void c(int i);

    public native void c(String str);

    public native void c(boolean z);

    public native int d();

    public native void d(int i);

    public native void d(boolean z);

    public native void e(int i);

    public native void e(boolean z);

    public native int[] e();

    public native void f(int i);

    public native boolean f();

    public native int g();

    public native String h();

    public native String i();

    public native i j();

    public native Integer k();

    public native int l();

    public native String m();

    public native int n();

    public native j o();

    public native i p();

    public native boolean q();

    public native boolean r();

    public native boolean s();

    public native boolean t();

    public native boolean u();
}
