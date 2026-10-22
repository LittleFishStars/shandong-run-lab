package com.zj.adlib;

import com.facebook.common.logging.LoggingDelegate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ad3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f40511a = 2;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static LoggingDelegate f15256a = bd3.h();
    public static final int b = 3;
    public static final int c = 4;
    public static final int d = 5;
    public static final int e = 6;
    public static final int f = 7;

    public static String A(Class<?> cls) {
        return cls.getSimpleName();
    }

    public static void B(Class<?> cls, String str) {
        if (f15256a.g(4)) {
            f15256a.i(A(cls), str);
        }
    }

    public static void C(Class<?> cls, String str, Object obj) {
        if (f15256a.g(4)) {
            f15256a.i(A(cls), y(str, obj));
        }
    }

    public static void D(Class<?> cls, String str, Object obj, Object obj2) {
        if (f15256a.g(4)) {
            f15256a.i(A(cls), y(str, obj, obj2));
        }
    }

    public static void E(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (f15256a.g(4)) {
            f15256a.i(A(cls), y(str, obj, obj2, obj3));
        }
    }

    public static void F(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (f15256a.g(4)) {
            f15256a.i(A(cls), y(str, obj, obj2, obj3, obj4));
        }
    }

    public static void G(Class<?> cls, String str, Throwable th) {
        if (f15256a.g(4)) {
            f15256a.c(A(cls), str, th);
        }
    }

    public static void H(Class<?> cls, String str, Object... objArr) {
        if (f15256a.g(4)) {
            f15256a.i(A(cls), y(str, objArr));
        }
    }

    public static void I(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (R(4)) {
            f15256a.c(A(cls), y(str, objArr), th);
        }
    }

    public static void J(String str, String str2) {
        if (f15256a.g(4)) {
            f15256a.i(str, str2);
        }
    }

    public static void K(String str, String str2, Object obj) {
        if (f15256a.g(4)) {
            f15256a.i(str, y(str2, obj));
        }
    }

    public static void L(String str, String str2, Object obj, Object obj2) {
        if (f15256a.g(4)) {
            f15256a.i(str, y(str2, obj, obj2));
        }
    }

    public static void M(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (f15256a.g(4)) {
            f15256a.i(str, y(str2, obj, obj2, obj3));
        }
    }

    public static void N(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (f15256a.g(4)) {
            f15256a.i(str, y(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void O(String str, String str2, Throwable th) {
        if (f15256a.g(4)) {
            f15256a.c(str, str2, th);
        }
    }

    public static void P(String str, String str2, Object... objArr) {
        if (f15256a.g(4)) {
            f15256a.i(str, y(str2, objArr));
        }
    }

    public static void Q(String str, Throwable th, String str2, Object... objArr) {
        if (f15256a.g(4)) {
            f15256a.c(str, y(str2, objArr), th);
        }
    }

    public static boolean R(int i) {
        return f15256a.g(i);
    }

    public static void S(LoggingDelegate loggingDelegate) {
        if (loggingDelegate == null) {
            throw new IllegalArgumentException();
        }
        f15256a = loggingDelegate;
    }

    public static void T(int i) {
        f15256a.d(i);
    }

    public static void U(Class<?> cls, String str) {
        if (f15256a.g(2)) {
            f15256a.v(A(cls), str);
        }
    }

    public static void V(Class<?> cls, String str, Object obj) {
        if (f15256a.g(2)) {
            f15256a.v(A(cls), y(str, obj));
        }
    }

    public static void W(Class<?> cls, String str, Object obj, Object obj2) {
        if (f15256a.g(2)) {
            f15256a.v(A(cls), y(str, obj, obj2));
        }
    }

    public static void X(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (R(2)) {
            U(cls, y(str, obj, obj2, obj3));
        }
    }

    public static void Y(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (f15256a.g(2)) {
            f15256a.v(A(cls), y(str, obj, obj2, obj3, obj4));
        }
    }

    public static void Z(Class<?> cls, String str, Throwable th) {
        if (f15256a.g(2)) {
            f15256a.b(A(cls), str, th);
        }
    }

    public static void a(Class<?> cls, String str) {
        if (f15256a.g(3)) {
            f15256a.d(A(cls), str);
        }
    }

    public static void a0(Class<?> cls, String str, Object... objArr) {
        if (f15256a.g(2)) {
            f15256a.v(A(cls), y(str, objArr));
        }
    }

    public static void b(Class<?> cls, String str, Object obj) {
        if (f15256a.g(3)) {
            f15256a.d(A(cls), y(str, obj));
        }
    }

    public static void b0(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (f15256a.g(2)) {
            f15256a.b(A(cls), y(str, objArr), th);
        }
    }

    public static void c(Class<?> cls, String str, Object obj, Object obj2) {
        if (f15256a.g(3)) {
            f15256a.d(A(cls), y(str, obj, obj2));
        }
    }

    public static void c0(String str, String str2) {
        if (f15256a.g(2)) {
            f15256a.v(str, str2);
        }
    }

    public static void d(Class<?> cls, String str, Object obj, Object obj2, Object obj3) {
        if (f15256a.g(3)) {
            f15256a.d(A(cls), y(str, obj, obj2, obj3));
        }
    }

    public static void d0(String str, String str2, Object obj) {
        if (f15256a.g(2)) {
            f15256a.v(str, y(str2, obj));
        }
    }

    public static void e(Class<?> cls, String str, Object obj, Object obj2, Object obj3, Object obj4) {
        if (f15256a.g(3)) {
            f15256a.d(A(cls), y(str, obj, obj2, obj3, obj4));
        }
    }

    public static void e0(String str, String str2, Object obj, Object obj2) {
        if (f15256a.g(2)) {
            f15256a.v(str, y(str2, obj, obj2));
        }
    }

    public static void f(Class<?> cls, String str, Throwable th) {
        if (f15256a.g(3)) {
            f15256a.d(A(cls), str, th);
        }
    }

    public static void f0(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (f15256a.g(2)) {
            f15256a.v(str, y(str2, obj, obj2, obj3));
        }
    }

    public static void g(Class<?> cls, String str, Object... objArr) {
        if (f15256a.g(3)) {
            f15256a.d(A(cls), y(str, objArr));
        }
    }

    public static void g0(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (f15256a.g(2)) {
            f15256a.v(str, y(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void h(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (f15256a.g(3)) {
            f15256a.d(A(cls), y(str, objArr), th);
        }
    }

    public static void h0(String str, String str2, Throwable th) {
        if (f15256a.g(2)) {
            f15256a.b(str, str2, th);
        }
    }

    public static void i(String str, String str2) {
        if (f15256a.g(3)) {
            f15256a.d(str, str2);
        }
    }

    public static void i0(String str, String str2, Object... objArr) {
        if (f15256a.g(2)) {
            f15256a.v(str, y(str2, objArr));
        }
    }

    public static void j(String str, String str2, Object obj) {
        if (f15256a.g(3)) {
            f15256a.d(str, y(str2, obj));
        }
    }

    public static void j0(String str, Throwable th, String str2, Object... objArr) {
        if (f15256a.g(2)) {
            f15256a.b(str, y(str2, objArr), th);
        }
    }

    public static void k(String str, String str2, Object obj, Object obj2) {
        if (f15256a.g(3)) {
            f15256a.d(str, y(str2, obj, obj2));
        }
    }

    public static void k0(Class<?> cls, String str) {
        if (f15256a.g(5)) {
            f15256a.w(A(cls), str);
        }
    }

    public static void l(String str, String str2, Object obj, Object obj2, Object obj3) {
        if (f15256a.g(3)) {
            f15256a.d(str, y(str2, obj, obj2, obj3));
        }
    }

    public static void l0(Class<?> cls, String str, Throwable th) {
        if (f15256a.g(5)) {
            f15256a.w(A(cls), str, th);
        }
    }

    public static void m(String str, String str2, Object obj, Object obj2, Object obj3, Object obj4) {
        if (f15256a.g(3)) {
            f15256a.d(str, y(str2, obj, obj2, obj3, obj4));
        }
    }

    public static void m0(Class<?> cls, String str, Object... objArr) {
        if (f15256a.g(5)) {
            f15256a.w(A(cls), y(str, objArr));
        }
    }

    public static void n(String str, String str2, Throwable th) {
        if (f15256a.g(3)) {
            f15256a.d(str, str2, th);
        }
    }

    public static void n0(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (R(5)) {
            l0(cls, y(str, objArr), th);
        }
    }

    public static void o(String str, String str2, Object... objArr) {
        if (f15256a.g(3)) {
            i(str, y(str2, objArr));
        }
    }

    public static void o0(String str, String str2) {
        if (f15256a.g(5)) {
            f15256a.w(str, str2);
        }
    }

    public static void p(String str, Throwable th, String str2, Object... objArr) {
        if (f15256a.g(3)) {
            n(str, y(str2, objArr), th);
        }
    }

    public static void p0(String str, String str2, Throwable th) {
        if (f15256a.g(5)) {
            f15256a.w(str, str2, th);
        }
    }

    public static void q(Class<?> cls, String str) {
        if (f15256a.g(6)) {
            f15256a.e(A(cls), str);
        }
    }

    public static void q0(String str, String str2, Object... objArr) {
        if (f15256a.g(5)) {
            f15256a.w(str, y(str2, objArr));
        }
    }

    public static void r(Class<?> cls, String str, Throwable th) {
        if (f15256a.g(6)) {
            f15256a.e(A(cls), str, th);
        }
    }

    public static void r0(String str, Throwable th, String str2, Object... objArr) {
        if (f15256a.g(5)) {
            f15256a.w(str, y(str2, objArr), th);
        }
    }

    public static void s(Class<?> cls, String str, Object... objArr) {
        if (f15256a.g(6)) {
            f15256a.e(A(cls), y(str, objArr));
        }
    }

    public static void s0(Class<?> cls, String str) {
        if (f15256a.g(6)) {
            f15256a.wtf(A(cls), str);
        }
    }

    public static void t(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (f15256a.g(6)) {
            f15256a.e(A(cls), y(str, objArr), th);
        }
    }

    public static void t0(Class<?> cls, String str, Throwable th) {
        if (f15256a.g(6)) {
            f15256a.f(A(cls), str, th);
        }
    }

    public static void u(String str, String str2) {
        if (f15256a.g(6)) {
            f15256a.e(str, str2);
        }
    }

    public static void u0(Class<?> cls, String str, Object... objArr) {
        if (f15256a.g(6)) {
            f15256a.wtf(A(cls), y(str, objArr));
        }
    }

    public static void v(String str, String str2, Throwable th) {
        if (f15256a.g(6)) {
            f15256a.e(str, str2, th);
        }
    }

    public static void v0(Class<?> cls, Throwable th, String str, Object... objArr) {
        if (f15256a.g(6)) {
            f15256a.f(A(cls), y(str, objArr), th);
        }
    }

    public static void w(String str, String str2, Object... objArr) {
        if (f15256a.g(6)) {
            f15256a.e(str, y(str2, objArr));
        }
    }

    public static void w0(String str, String str2) {
        if (f15256a.g(6)) {
            f15256a.wtf(str, str2);
        }
    }

    public static void x(String str, Throwable th, String str2, Object... objArr) {
        if (f15256a.g(6)) {
            f15256a.e(str, y(str2, objArr), th);
        }
    }

    public static void x0(String str, String str2, Throwable th) {
        if (f15256a.g(6)) {
            f15256a.f(str, str2, th);
        }
    }

    public static String y(String str, Object... objArr) {
        return String.format(null, str, objArr);
    }

    public static void y0(String str, String str2, Object... objArr) {
        if (f15256a.g(6)) {
            f15256a.wtf(str, y(str2, objArr));
        }
    }

    public static int z() {
        return f15256a.a();
    }

    public static void z0(String str, Throwable th, String str2, Object... objArr) {
        if (f15256a.g(6)) {
            f15256a.f(str, y(str2, objArr), th);
        }
    }
}
