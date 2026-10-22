package com.kc.openset.bean;

import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import com.jiagu.sdk.OSETSDKProtected;
import com.kc.openset.constant.LogUploadType;
import com.kc.openset.util.OAIDUtils;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class OSETLogUploadBean {
    private int A;
    private boolean A0;
    private String B;
    private String B0;
    private String C;
    private String C0;
    private String D;
    private String D0;
    private String E;
    private double E0;
    private String F;
    private String F0;
    private String G;
    private double G0;
    private List<a> H;
    private int I;
    private int I0;
    private String J;
    private double J0;
    private String K;
    private double K0;
    private String L;
    private double L0;
    private String M;
    private String M0;
    private String N;
    private boolean N0;
    private String O;
    private String O0;
    private String P;
    private String P0;
    private int Q;
    private boolean Q0;
    private String R;
    private String R0;
    private String S;
    private String S0;
    private String T;
    private String T0;
    private String U;
    private String U0;
    private String V;
    private String W;
    private String W0;
    private String X;
    private String Y;
    private String Z;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LogUploadType f39702a;
    private boolean a0;
    private String b;
    private String b0;
    private String c;
    private String c0;
    private String d;
    private String d0;
    private String e;
    private String e0;
    private String f;
    private boolean f0;
    private String g;
    private boolean g0;
    private String h;
    private boolean h0;
    private int i;
    private String i0;
    private String j;
    private String j0;
    private String k;
    private String k0;
    private String l;
    private int l0;
    private String m;
    private String m0;
    private String n;
    private String n0;
    private String o;
    private String o0;
    private String p;
    private String p0;
    private String q;
    private String q0;
    private int r;
    private String r0;
    private int s;
    private String s0;
    private int t;
    private String t0;
    private int u;
    private String u0;
    private int v;
    private String v0;
    private String w;
    private String w0;
    private String x;
    private boolean x0;
    private String y;
    private e y0;
    private String z;
    private String z0;
    private boolean H0 = false;
    private List<OAIDUtils.c> V0 = new ArrayList();

    @Keep
    public enum Category {
        BIDDING(OSETSDKProtected.getString2(276)),
        DATA(OSETSDKProtected.getString2(MediaPlayer.MEDIA_PLAYER_OPTION_AUDIO_HTTP_RES_FINSIH_TIME)),
        FP(OSETSDKProtected.getString2(1222));

        private final String name;

        static {
            OSETSDKProtected.interface11(4296);
        }

        Category(String str) {
            this.name = str;
        }

        public static native Category valueOf(String str);

        public static native Category[] values();
    }

    @Keep
    public enum ResultType {
        NOAD(OSETSDKProtected.getString2(1223)),
        TIMEOUT(OSETSDKProtected.getString2(1225)),
        NORMAL(OSETSDKProtected.getString2(1227)),
        WEEDOUT(OSETSDKProtected.getString2(1228)),
        TIMEOUT_NORMAL(OSETSDKProtected.getString2(1230)),
        TIMEOUT_NOAD(OSETSDKProtected.getString2(1232)),
        TOTAL_TIMEOUT(OSETSDKProtected.getString2(1234));

        private final String name;

        static {
            OSETSDKProtected.interface11(4297);
        }

        ResultType(String str) {
            this.name = str;
        }

        public static native ResultType valueOf(String str);

        public static native ResultType[] values();
    }

    @Keep
    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private String f39703a;
        private String b;
        private String c;
        private String d;

        static {
            OSETSDKProtected.interface11(4298);
        }

        public native String a();

        public native void a(String str);

        public native String b();

        public native void b(String str);

        public native String c();

        public native void c(String str);

        public native String d();

        public native void d(String str);

        public native String toString();
    }

    static {
        OSETSDKProtected.interface11(4299);
    }

    public native int A();

    public native void A(String str);

    public native String A0();

    public native String B();

    public native void B(String str);

    public native String B0();

    public native String C();

    public native void C(String str);

    public native String C0();

    public native String D();

    public native void D(String str);

    public native String D0();

    public native String E();

    public native void E(String str);

    public native String E0();

    public native String F();

    public native void F(String str);

    public native String F0();

    public native String G();

    public native void G(String str);

    public native String G0();

    public native String H();

    public native void H(String str);

    public native String H0();

    public native String I();

    public native void I(String str);

    public native boolean I0();

    public native String J();

    public native void J(String str);

    public native boolean J0();

    public native String K();

    public native void K(String str);

    public native String K0();

    public native String L();

    public native void L(String str);

    public native boolean L0();

    public native String M();

    public native void M(String str);

    public native boolean M0();

    public native String N();

    public native void N(String str);

    public native boolean N0();

    public native String O();

    public native void O(String str);

    public native void P(String str);

    public native boolean P();

    public native String Q();

    public native void Q(String str);

    public native String R();

    public native void R(String str);

    public native String S();

    public native void S(String str);

    public native String T();

    public native void T(String str);

    public native String U();

    public native void U(String str);

    public native String V();

    public native void V(String str);

    public native String W();

    public native void W(String str);

    public native LogUploadType X();

    public native void X(String str);

    public native String Y();

    public native void Y(String str);

    public native String Z();

    public native void Z(String str);

    public native OSETLogUploadBean a(e eVar);

    public native String a();

    public native void a(double d);

    public native void a(int i);

    public native void a(LogUploadType logUploadType);

    public native void a(String str);

    public native void a(List<a> list);

    public native void a(boolean z);

    public native String a0();

    public native void a0(String str);

    public native String b();

    public native void b(double d);

    public native void b(int i);

    public native void b(String str);

    public native void b(List<OAIDUtils.c> list);

    public native void b(boolean z);

    public native String b0();

    public native void b0(String str);

    public native String c();

    public native void c(double d);

    public native void c(int i);

    public native void c(String str);

    public native void c(boolean z);

    public native String c0();

    public native void c0(String str);

    public native e d();

    public native void d(double d);

    public native void d(int i);

    public native void d(String str);

    public native void d(boolean z);

    public native List<OAIDUtils.c> d0();

    public native void d0(String str);

    public native String e();

    public native void e(double d);

    public native void e(int i);

    public native void e(String str);

    public native void e(boolean z);

    public native String e0();

    public native void e0(String str);

    public native int f();

    public native void f(int i);

    public native void f(String str);

    public native void f(boolean z);

    public native String f0();

    public native void f0(String str);

    public native String g();

    public native void g(int i);

    public native void g(String str);

    public native void g(boolean z);

    public native String g0();

    public native void g0(String str);

    public native String h();

    public native void h(int i);

    public native void h(String str);

    public native void h(boolean z);

    public native String h0();

    public native void h0(String str);

    public native String i();

    public native void i(int i);

    public native void i(String str);

    public native void i(boolean z);

    public native String i0();

    public native void i0(String str);

    public native String j();

    public native void j(int i);

    public native void j(String str);

    public native String j0();

    public native void j0(String str);

    public native String k();

    public native void k(int i);

    public native void k(String str);

    public native String k0();

    public native void k0(String str);

    public native String l();

    public native void l(String str);

    public native String l0();

    public native void l0(String str);

    public native String m();

    public native void m(String str);

    public native String m0();

    public native void m0(String str);

    public native String n();

    public native void n(String str);

    public native String n0();

    public native void n0(String str);

    public native String o();

    public native void o(String str);

    public native String o0();

    public native String p();

    public native void p(String str);

    public native String p0();

    public native String q();

    public native void q(String str);

    public native String q0();

    public native String r();

    public native void r(String str);

    public native String r0();

    public native String s();

    public native void s(String str);

    public native String s0();

    public native String t();

    public native void t(String str);

    public native String t0();

    public native String toString();

    public native String u();

    public native void u(String str);

    public native String u0();

    public native String v();

    public native void v(String str);

    public native String v0();

    public native String w();

    public native void w(String str);

    public native String w0();

    public native String x();

    public native void x(String str);

    public native String x0();

    public native String y();

    public native void y(String str);

    public native String y0();

    public native String z();

    public native void z(String str);

    public native int z0();
}
