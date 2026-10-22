package com.byazt.aas;

import android.annotation.SuppressLint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 47})
public final class eo {
    public static volatile boolean c = false;

    @com.byazt.zqa.c(c = {0, 1, 131, 1387})
    public static class c {

        @SuppressLint({"StaticFieldLeak"})
        public static final com.byazt.yy.uj.c c = eo.uj();
    }

    public static com.byazt.iy.n c(String str) {
        return c.c.c(tt(str)).c();
    }

    public static int tt() {
        return 3;
    }

    private static String tt(String str) {
        if (c || com.byazt.nr.gt.c(com.byazt.omf.gt.getContext())) {
            return str;
        }
        return str + com.byazt.nr.gt.tt(com.byazt.omf.gt.getContext());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.yy.uj.c uj() {
        com.byazt.ogz.sl slVarTt = com.byazt.omf.gt.tt();
        slVarTt.by();
        return new com.byazt.yy.uj.c().c(com.byazt.omf.gt.getContext()).c(1).tt(slVarTt.ck()).c(c);
    }

    public static void c() {
        c = true;
    }
}
