package com.byazt.pr;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 794, 20})
public class c {
    public static volatile boolean c = false;
    public static ve tt;
    public static uj ve;

    public static void c(ve veVar, uj ujVar) {
        if (c) {
            return;
        }
        c = true;
        tt = veVar;
        ve = ujVar;
    }

    public static uj tt() {
        return ve;
    }

    public static ve c() {
        return tt;
    }
}
