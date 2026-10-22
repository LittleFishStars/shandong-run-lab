package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class jfb extends vhb {
    public static int a(uhb uhbVar) {
        return uhbVar.n();
    }

    public static int b(uhb uhbVar, int i) {
        uhbVar.q(1);
        d(uhbVar, i);
        return a(uhbVar);
    }

    public static int c(uhb uhbVar, int[] iArr) {
        uhbVar.h(4, iArr.length, 4);
        for (int length = iArr.length - 1; length >= 0; length--) {
            uhbVar.e(iArr[length]);
        }
        return uhbVar.a();
    }

    public static void d(uhb uhbVar, int i) {
        uhbVar.r(0, i);
    }
}
