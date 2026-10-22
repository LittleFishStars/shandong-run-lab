package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class xeb extends vhb {
    public static int a(uhb uhbVar) {
        return uhbVar.n();
    }

    public static int b(uhb uhbVar, int i, int i2, int i3) {
        uhbVar.q(3);
        h(uhbVar, i3);
        g(uhbVar, i2);
        e(uhbVar, i);
        return a(uhbVar);
    }

    public static int c(uhb uhbVar, byte[] bArr) {
        uhbVar.h(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            uhbVar.d(bArr[length]);
        }
        return uhbVar.a();
    }

    public static int d(uhb uhbVar, int[] iArr) {
        uhbVar.h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            uhbVar.e(iArr[length]);
        }
        return uhbVar.a();
    }

    public static void e(uhb uhbVar, int i) {
        uhbVar.r(0, i);
    }

    public static int f(uhb uhbVar, byte[] bArr) {
        uhbVar.h(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            uhbVar.d(bArr[length]);
        }
        return uhbVar.a();
    }

    public static void g(uhb uhbVar, int i) {
        uhbVar.r(1, i);
    }

    public static void h(uhb uhbVar, int i) {
        uhbVar.r(2, i);
    }
}
