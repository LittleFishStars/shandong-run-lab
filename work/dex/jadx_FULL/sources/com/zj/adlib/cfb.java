package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class cfb extends vhb {
    public static int a(uhb uhbVar) {
        return uhbVar.n();
    }

    public static int b(uhb uhbVar, byte b, int i) {
        uhbVar.q(2);
        e(uhbVar, i);
        d(uhbVar, b);
        return a(uhbVar);
    }

    public static int c(uhb uhbVar, byte[] bArr) {
        uhbVar.h(1, bArr.length, 1);
        for (int length = bArr.length - 1; length >= 0; length--) {
            uhbVar.d(bArr[length]);
        }
        return uhbVar.a();
    }

    public static void d(uhb uhbVar, byte b) {
        uhbVar.f(0, b);
    }

    public static void e(uhb uhbVar, int i) {
        uhbVar.r(1, i);
    }
}
