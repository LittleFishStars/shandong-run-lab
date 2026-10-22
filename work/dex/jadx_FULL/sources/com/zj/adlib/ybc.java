package com.zj.adlib;

import javax.annotation.CheckForNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ybc {
    public static int a(int i, int i2, String str) {
        String strB;
        if (i >= 0 && i < i2) {
            return i;
        }
        if (i < 0) {
            strB = zbc.b("%s (%s) must not be negative", "index", Integer.valueOf(i));
        } else {
            if (i2 < 0) {
                throw new IllegalArgumentException("negative size: " + i2);
            }
            strB = zbc.b("%s (%s) must be less than size (%s)", "index", Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IndexOutOfBoundsException(strB);
    }

    public static int b(int i, int i2, String str) {
        if (i < 0 || i > i2) {
            throw new IndexOutOfBoundsException(f(i, i2, "index"));
        }
        return i;
    }

    public static void c(boolean z) {
        if (!z) {
            throw new IllegalArgumentException();
        }
    }

    public static void d(int i, int i2, int i3) {
        String strF;
        if (i < 0 || i2 < i || i2 > i3) {
            if (i < 0 || i > i3) {
                strF = f(i, i3, "start index");
            } else {
                strF = (i2 < 0 || i2 > i3) ? f(i2, i3, "end index") : zbc.b("end index (%s) must not be less than start index (%s)", Integer.valueOf(i2), Integer.valueOf(i));
            }
            throw new IndexOutOfBoundsException(strF);
        }
    }

    public static void e(boolean z, @CheckForNull Object obj) {
        if (!z) {
            throw new IllegalStateException((String) obj);
        }
    }

    public static String f(int i, int i2, String str) {
        if (i < 0) {
            return zbc.b("%s (%s) must not be negative", str, Integer.valueOf(i));
        }
        if (i2 >= 0) {
            return zbc.b("%s (%s) must not be greater than size (%s)", str, Integer.valueOf(i), Integer.valueOf(i2));
        }
        throw new IllegalArgumentException("negative size: " + i2);
    }
}
