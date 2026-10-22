package com.byazt.qk;

import android.os.Handler;
import android.os.Looper;
import com.byazt.nr.da;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 952, 13})
public class tt {
    public static final Handler c = new Handler(Looper.getMainLooper());

    public static void c(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            c.post(runnable);
        }
    }

    public static void tt(Runnable runnable) {
        c.post(runnable);
    }

    public static void ve(Runnable runnable) {
        da.ve().post(runnable);
    }
}
