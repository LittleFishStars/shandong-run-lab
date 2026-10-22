package com.byazt.mg;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, 72})
public final class da {
    public static void c(String str) {
        if (com.byazt.uy.x.n().a()) {
            com.byazt.nr.m.c("npth", str);
        }
    }

    public static void tt(Throwable th) {
        if (com.byazt.uy.x.n().a()) {
            com.byazt.nr.m.tt("npth", "NPTH Catch Error", th);
        }
    }

    public static void c(Throwable th) {
        if (com.byazt.uy.x.n().a()) {
            com.byazt.nr.m.ve("npth", "NPTH Catch Error", th);
        }
    }

    public static void c(String str, Throwable th) {
        if (com.byazt.uy.x.n().a()) {
            com.byazt.nr.m.ve(str, "NPTH Catch Error", th);
        }
    }
}
