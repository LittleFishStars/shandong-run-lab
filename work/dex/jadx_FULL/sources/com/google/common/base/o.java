package com.google.common.base;

import com.google.common.annotations.GwtCompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@GwtCompatible
@ElementTypesAreNonnullByDefault
public final class o {
    public static void a(boolean z) {
        if (!z) {
            throw new VerifyException();
        }
    }

    public static void b(boolean z, String str, char c) {
        if (!z) {
            throw new VerifyException(l.e(str, Character.valueOf(c)));
        }
    }

    public static void c(boolean z, String str, char c, char c2) {
        if (!z) {
            throw new VerifyException(l.e(str, Character.valueOf(c), Character.valueOf(c2)));
        }
    }

    public static void d(boolean z, String str, char c, int i) {
        if (!z) {
            throw new VerifyException(l.e(str, Character.valueOf(c), Integer.valueOf(i)));
        }
    }

    public static void e(boolean z, String str, char c, long j) {
        if (!z) {
            throw new VerifyException(l.e(str, Character.valueOf(c), Long.valueOf(j)));
        }
    }

    public static void f(boolean z, String str, char c, @CheckForNull Object obj) {
        if (!z) {
            throw new VerifyException(l.e(str, Character.valueOf(c), obj));
        }
    }

    public static void g(boolean z, String str, int i) {
        if (!z) {
            throw new VerifyException(l.e(str, Integer.valueOf(i)));
        }
    }

    public static void h(boolean z, String str, int i, char c) {
        if (!z) {
            throw new VerifyException(l.e(str, Integer.valueOf(i), Character.valueOf(c)));
        }
    }

    public static void i(boolean z, String str, int i, int i2) {
        if (!z) {
            throw new VerifyException(l.e(str, Integer.valueOf(i), Integer.valueOf(i2)));
        }
    }

    public static void j(boolean z, String str, int i, long j) {
        if (!z) {
            throw new VerifyException(l.e(str, Integer.valueOf(i), Long.valueOf(j)));
        }
    }

    public static void k(boolean z, String str, int i, @CheckForNull Object obj) {
        if (!z) {
            throw new VerifyException(l.e(str, Integer.valueOf(i), obj));
        }
    }

    public static void l(boolean z, String str, long j) {
        if (!z) {
            throw new VerifyException(l.e(str, Long.valueOf(j)));
        }
    }

    public static void m(boolean z, String str, long j, char c) {
        if (!z) {
            throw new VerifyException(l.e(str, Long.valueOf(j), Character.valueOf(c)));
        }
    }

    public static void n(boolean z, String str, long j, int i) {
        if (!z) {
            throw new VerifyException(l.e(str, Long.valueOf(j), Integer.valueOf(i)));
        }
    }

    public static void o(boolean z, String str, long j, long j2) {
        if (!z) {
            throw new VerifyException(l.e(str, Long.valueOf(j), Long.valueOf(j2)));
        }
    }

    public static void p(boolean z, String str, long j, @CheckForNull Object obj) {
        if (!z) {
            throw new VerifyException(l.e(str, Long.valueOf(j), obj));
        }
    }

    public static void q(boolean z, String str, @CheckForNull Object obj) {
        if (!z) {
            throw new VerifyException(l.e(str, obj));
        }
    }

    public static void r(boolean z, String str, @CheckForNull Object obj, char c) {
        if (!z) {
            throw new VerifyException(l.e(str, obj, Character.valueOf(c)));
        }
    }

    public static void s(boolean z, String str, @CheckForNull Object obj, int i) {
        if (!z) {
            throw new VerifyException(l.e(str, obj, Integer.valueOf(i)));
        }
    }

    public static void t(boolean z, String str, @CheckForNull Object obj, long j) {
        if (!z) {
            throw new VerifyException(l.e(str, obj, Long.valueOf(j)));
        }
    }

    public static void u(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2) {
        if (!z) {
            throw new VerifyException(l.e(str, obj, obj2));
        }
    }

    public static void v(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3) {
        if (!z) {
            throw new VerifyException(l.e(str, obj, obj2, obj3));
        }
    }

    public static void w(boolean z, String str, @CheckForNull Object obj, @CheckForNull Object obj2, @CheckForNull Object obj3, @CheckForNull Object obj4) {
        if (!z) {
            throw new VerifyException(l.e(str, obj, obj2, obj3, obj4));
        }
    }

    public static void x(boolean z, String str, @CheckForNull Object... objArr) {
        if (!z) {
            throw new VerifyException(l.e(str, objArr));
        }
    }

    @CanIgnoreReturnValue
    public static <T> T y(@CheckForNull T t) {
        return (T) z(t, "expected a non-null reference", new Object[0]);
    }

    @CanIgnoreReturnValue
    public static <T> T z(@CheckForNull T t, String str, @CheckForNull Object... objArr) {
        if (t != null) {
            return t;
        }
        throw new VerifyException(l.e(str, objArr));
    }
}
