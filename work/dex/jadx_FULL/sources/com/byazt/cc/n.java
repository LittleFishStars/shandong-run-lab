package com.byazt.cc;

import android.os.Looper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 448, 46})
public class n {
    public static boolean c() {
        return (com.byazt.by.n.c().t() & 8) == 8;
    }

    public static void tt(Runnable runnable) {
        if (!c() || Looper.myLooper() == com.byazt.nr.da.ve().getLooper()) {
            runnable.run();
        } else {
            com.byazt.nr.da.ve().post(runnable);
        }
    }

    public static void c(Runnable runnable) {
        if (!c()) {
            com.byazt.bzd.x.c(runnable);
        } else if (Looper.myLooper() == com.byazt.nr.da.ve().getLooper()) {
            runnable.run();
        } else {
            com.byazt.nr.da.ve().post(runnable);
        }
    }
}
