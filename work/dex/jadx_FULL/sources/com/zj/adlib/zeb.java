package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class zeb extends vhb {
    public static int a(uhb uhbVar) {
        return uhbVar.n();
    }

    public static int b(uhb uhbVar, int i, byte b, int i2, int i3) {
        uhbVar.q(4);
        h(uhbVar, i3);
        g(uhbVar, i2);
        e(uhbVar, i);
        d(uhbVar, b);
        return a(uhbVar);
    }

    public static int c(uhb uhbVar, int[] iArr) {
        uhbVar.h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            uhbVar.e(iArr[length]);
        }
        return uhbVar.a();
    }

    public static void d(uhb uhbVar, byte b) {
        uhbVar.f(1, b);
    }

    public static void e(uhb uhbVar, int i) {
        uhbVar.r(0, i);
    }

    public static int f(uhb uhbVar, int[] iArr) {
        uhbVar.h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            uhbVar.e(iArr[length]);
        }
        return uhbVar.a();
    }

    public static void g(uhb uhbVar, int i) {
        uhbVar.r(2, i);
    }

    public static void h(uhb uhbVar, int i) {
        uhbVar.r(3, i);
    }
}
