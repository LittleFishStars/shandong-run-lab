package com.zj.adlib;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class r8c {
    public static int a(int i, int i2, String str) {
        String strA;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strA = s8c.a("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException("negative size: " + i2);
            }
            strA = s8c.a("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strA);
    }

    public static int b(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(f(i, i2, "index"));
        }
        return i;
    }

    public static Object c(@CheckForNull Object obj, @CheckForNull Object obj2) {
        if (obj != null) {
            return obj;
        }
        throw new NullPointerException((String) obj2);
    }

    public static void d(int i, int i2, int i3) {
        String strF;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strF = f(i, i3, "start index");
            } else {
                strF = (i2 < 0 || i2 > i3) ? f(i2, i3, "end index") : s8c.a("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strF);
        }
    }

    public static void e(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException("A SourcePolicy can only set internal() or external() once.");
        }
    }

    public static String f(int i, int i2, String str) {
        if (i < 0) {
            return s8c.a("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return s8c.a("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }
}
