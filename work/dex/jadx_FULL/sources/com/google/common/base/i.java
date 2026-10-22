package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class i {
    public static void A(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, obj, obj2, obj3, obj4));
        }
    }

    public static void A0(boolean z, String str, @CheckForNull Object obj, long j) {
        if (!z) {
            throw new IllegalStateException(l.e(str, obj, Long.valueOf(j)));
        }
    }

    public static void B(boolean z, String str, @CheckForNull Object... objArr) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, objArr));
        }
    }

    public static void B0(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z) {
            throw new IllegalStateException(l.e(str, obj, obj2));
        }
    }

    @CanIgnoreReturnValue
    public static int C(int i, int i2) {
        return D(i, i2, "index");
    }

    public static void C0(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z) {
            throw new IllegalStateException(l.e(str, obj, obj2, obj3));
        }
    }

    @CanIgnoreReturnValue
    public static int D(int i, int i2, String str) {
        if (i < 0 || i >= i2) {
            throw new IndexOutOfBoundsException(a(i, i2, str));
        }
        return i;
    }

    public static void D0(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z) {
            throw new IllegalStateException(l.e(str, obj, obj2, obj3, obj4));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T E(@CheckForNull T t) {
        t.getClass();
        return t;
    }

    public static void E0(boolean z, @CheckForNull String str, @CheckForNull Object... objArr) {
        if (!z) {
            throw new IllegalStateException(l.e(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T F(@CheckForNull T t, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(String.valueOf(obj));
    }

    @CanIgnoreReturnValue
    public static <T> T G(@CheckForNull T t, String str, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, Character.valueOf(c)));
    }

    @CanIgnoreReturnValue
    public static <T> T H(@CheckForNull T t, String str, char c, char c2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, Character.valueOf(c), Character.valueOf(c2)));
    }

    @CanIgnoreReturnValue
    public static <T> T I(@CheckForNull T t, String str, char c, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, Character.valueOf(c), Integer.valueOf(i)));
    }

    @CanIgnoreReturnValue
    public static <T> T J(@CheckForNull T t, String str, char c, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, Character.valueOf(c), Long.valueOf(j)));
    }

    @CanIgnoreReturnValue
    public static <T> T K(@CheckForNull T t, String str, char c, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, Character.valueOf(c), obj));
    }

    @CanIgnoreReturnValue
    public static <T> T L(@CheckForNull T t, String str, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, Integer.valueOf(i)));
    }

    @CanIgnoreReturnValue
    public static <T> T M(@CheckForNull T t, String str, int i, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, Integer.valueOf(i), Character.valueOf(c)));
    }

    @CanIgnoreReturnValue
    public static <T> T N(@CheckForNull T t, String str, int i, int i2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, Integer.valueOf(i), Integer.valueOf(i2)));
    }

    @CanIgnoreReturnValue
    public static <T> T O(@CheckForNull T t, String str, int i, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, Integer.valueOf(i), Long.valueOf(j)));
    }

    @CanIgnoreReturnValue
    public static <T> T P(@CheckForNull T t, String str, int i, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, Integer.valueOf(i), obj));
    }

    @CanIgnoreReturnValue
    public static <T> T Q(@CheckForNull T t, String str, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, Long.valueOf(j)));
    }

    @CanIgnoreReturnValue
    public static <T> T R(@CheckForNull T t, String str, long j, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, Long.valueOf(j), Character.valueOf(c)));
    }

    @CanIgnoreReturnValue
    public static <T> T S(@CheckForNull T t, String str, long j, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, Long.valueOf(j), Integer.valueOf(i)));
    }

    @CanIgnoreReturnValue
    public static <T> T T(@CheckForNull T t, String str, long j, long j2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, Long.valueOf(j), Long.valueOf(j2)));
    }

    @CanIgnoreReturnValue
    public static <T> T U(@CheckForNull T t, String str, long j, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, Long.valueOf(j), obj));
    }

    @CanIgnoreReturnValue
    public static <T> T V(@CheckForNull T t, String str, @CheckForNull Object obj) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, obj));
    }

    @CanIgnoreReturnValue
    public static <T> T W(@CheckForNull T t, String str, @CheckForNull Object obj, char c) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, obj, Character.valueOf(c)));
    }

    @CanIgnoreReturnValue
    public static <T> T X(@CheckForNull T t, String str, @CheckForNull Object obj, int i) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, obj, Integer.valueOf(i)));
    }

    @CanIgnoreReturnValue
    public static <T> T Y(@CheckForNull T t, String str, @CheckForNull Object obj, long j) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, obj, Long.valueOf(j)));
    }

    @CanIgnoreReturnValue
    public static <T> T Z(@CheckForNull T t, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, obj, obj2));
    }

    public static String a(int i, int i2, String str) {
        if (i < 0) {
            return l.e("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return l.e("%s (%s) must be less than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    @CanIgnoreReturnValue
    public static <T> T a0(@CheckForNull T t, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, obj, obj2, obj3));
    }

    public static String b(int i, int i2, String str) {
        if (i < 0) {
            return l.e("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return l.e("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        StringBuilder sb = new StringBuilder(26);
        sb.append("negative size: ");
        sb.append(i2);
        throw new IllegalArgumentException(sb.toString());
    }

    @CanIgnoreReturnValue
    public static <T> T b0(@CheckForNull T t, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, obj, obj2, obj3, obj4));
    }

    public static String c(int i, int i2, int i3) {
        if (i < 0 || i > i3) {
            return b(i, i3, "start index");
        }
        return (i2 < 0 || i2 > i3) ? b(i2, i3, "end index") : l.e("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
    }

    @CanIgnoreReturnValue
    public static <T> T c0(@CheckForNull T t, String str, @CheckForNull Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new NullPointerException(l.e(str, objArr));
    }

    public static void d(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    @CanIgnoreReturnValue
    public static int d0(int i, int i2) {
        return e0(i, i2, "index");
    }

    public static void e(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(String.valueOf(obj));
        }
    }

    @CanIgnoreReturnValue
    public static int e0(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(b(i, i2, str));
        }
        return i;
    }

    public static void f(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, Character.valueOf(c)));
        }
    }

    public static void f0(int i, int i2, int i3) {
        if (i < 0 || i2 < i || i2 > i3) {
            throw new IndexOutOfBoundsException(c(i, i2, i3));
        }
    }

    public static void g(boolean z, String str, char c, char c2) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, Character.valueOf(c), Character.valueOf(c2)));
        }
    }

    public static void g0(boolean z) {
        if (!z) {
            throw new IllegalStateException();
        }
    }

    public static void h(boolean z, String str, char c, int i) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, Character.valueOf(c), Integer.valueOf(i)));
        }
    }

    public static void h0(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }

    public static void i(boolean z, String str, char c, long j) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, Character.valueOf(c), Long.valueOf(j)));
        }
    }

    public static void i0(boolean z, String str, char c) {
        if (!z) {
            throw new IllegalStateException(l.e(str, Character.valueOf(c)));
        }
    }

    public static void j(boolean z, String str, char c, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, Character.valueOf(c), obj));
        }
    }

    public static void j0(boolean z, String str, char c, char c2) {
        if (!z) {
            throw new IllegalStateException(l.e(str, Character.valueOf(c), Character.valueOf(c2)));
        }
    }

    public static void k(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, Integer.valueOf(i)));
        }
    }

    public static void k0(boolean z, String str, char c, int i) {
        if (!z) {
            throw new IllegalStateException(l.e(str, Character.valueOf(c), Integer.valueOf(i)));
        }
    }

    public static void l(boolean z, String str, int i, char c) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, Integer.valueOf(i), Character.valueOf(c)));
        }
    }

    public static void l0(boolean z, String str, char c, long j) {
        if (!z) {
            throw new IllegalStateException(l.e(str, Character.valueOf(c), Long.valueOf(j)));
        }
    }

    public static void m(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void m0(boolean z, String str, char c, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(l.e(str, Character.valueOf(c), obj));
        }
    }

    public static void n(boolean z, String str, int i, long j) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, Integer.valueOf(i), Long.valueOf(j)));
        }
    }

    public static void n0(boolean z, String str, int i) {
        if (!z) {
            throw new IllegalStateException(l.e(str, Integer.valueOf(i)));
        }
    }

    public static void o(boolean z, String str, int i, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, Integer.valueOf(i), obj));
        }
    }

    public static void o0(boolean z, String str, int i, char c) {
        if (!z) {
            throw new IllegalStateException(l.e(str, Integer.valueOf(i), Character.valueOf(c)));
        }
    }

    public static void p(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, Long.valueOf(j)));
        }
    }

    public static void p0(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new IllegalStateException(l.e(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void q(boolean z, String str, long j, char c) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, Long.valueOf(j), Character.valueOf(c)));
        }
    }

    public static void q0(boolean z, String str, int i, long j) {
        if (!z) {
            throw new IllegalStateException(l.e(str, Integer.valueOf(i), Long.valueOf(j)));
        }
    }

    public static void r(boolean z, String str, long j, int i) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, Long.valueOf(j), Integer.valueOf(i)));
        }
    }

    public static void r0(boolean z, String str, int i, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(l.e(str, Integer.valueOf(i), obj));
        }
    }

    public static void s(boolean z, String str, long j, long j2) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void s0(boolean z, String str, long j) {
        if (!z) {
            throw new IllegalStateException(l.e(str, Long.valueOf(j)));
        }
    }

    public static void t(boolean z, String str, long j, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, Long.valueOf(j), obj));
        }
    }

    public static void t0(boolean z, String str, long j, char c) {
        if (!z) {
            throw new IllegalStateException(l.e(str, Long.valueOf(j), Character.valueOf(c)));
        }
    }

    public static void u(boolean z, String str, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, obj));
        }
    }

    public static void u0(boolean z, String str, long j, int i) {
        if (!z) {
            throw new IllegalStateException(l.e(str, Long.valueOf(j), Integer.valueOf(i)));
        }
    }

    public static void v(boolean z, String str, @CheckForNull Object obj, char c) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, obj, Character.valueOf(c)));
        }
    }

    public static void v0(boolean z, String str, long j, long j2) {
        if (!z) {
            throw new IllegalStateException(l.e(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void w(boolean z, String str, @CheckForNull Object obj, int i) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, obj, Integer.valueOf(i)));
        }
    }

    public static void w0(boolean z, String str, long j, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(l.e(str, Long.valueOf(j), obj));
        }
    }

    public static void x(boolean z, String str, @CheckForNull Object obj, long j) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, obj, Long.valueOf(j)));
        }
    }

    public static void x0(boolean z, String str, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException(l.e(str, obj));
        }
    }

    public static void y(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, obj, obj2));
        }
    }

    public static void y0(boolean z, String str, @CheckForNull Object obj, char c) {
        if (!z) {
            throw new IllegalStateException(l.e(str, obj, Character.valueOf(c)));
        }
    }

    public static void z(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z) {
            throw new IllegalArgumentException(l.e(str, obj, obj2, obj3));
        }
    }

    public static void z0(boolean z, String str, @CheckForNull Object obj, int i) {
        if (!z) {
            throw new IllegalStateException(l.e(str, obj, Integer.valueOf(i)));
        }
    }
}
