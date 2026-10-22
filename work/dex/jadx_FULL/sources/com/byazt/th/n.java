package com.byazt.th;

import com.byazt.uk.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 78, 46})
public class n {
    public static a c;

    public static void c(a aVar) {
        c = aVar;
    }

    public static void tt(Runnable runnable) {
        c.tt(runnable);
    }

    public static void ve(Runnable runnable) {
        c.ve(runnable);
    }

    public static void c(Runnable runnable, boolean z) {
        if (z) {
            c(runnable);
        } else {
            tt(runnable);
        }
    }

    public static void c(Runnable runnable) {
        c.c(runnable);
    }
}
