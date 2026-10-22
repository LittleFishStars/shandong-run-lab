package com.byazt.bzd;

import android.os.Looper;
import com.byazt.dna.qp;
import com.byazt.omf.gt;
import com.byazt.omf.rh;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 724, 71})
public class x {
    public static boolean c() {
        return Looper.getMainLooper() == Looper.myLooper();
    }

    public static void n(Runnable runnable) {
        c(runnable, (ScheduledExecutorService) null);
    }

    public static void tt(Runnable runnable) {
        ((qp) com.byazt.ut.uj.getService("thread_service")).executeNormalTask(runnable);
    }

    public static void uj(Runnable runnable) {
        if (gt.tt().ra()) {
            ((qp) com.byazt.ut.uj.getService("thread_service")).getCsjMainHandler().post(runnable);
        } else {
            runnable.run();
        }
    }

    public static void ve(Runnable runnable) {
        if (gt.tt().tu() || Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            rh.a().post(runnable);
        }
    }

    public static void c(Runnable runnable) {
        if (Looper.getMainLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            rh.a().post(runnable);
        }
    }

    public static Looper tt() {
        return gt.tt().ra() ? ((qp) com.byazt.ut.uj.getService("thread_service")).getCsjMainHandler().getLooper() : Looper.getMainLooper();
    }

    public static void c(Runnable runnable, long j) {
        rh.a().postDelayed(runnable, j);
    }

    public static void c(com.byazt.bwm.sp spVar) {
        ((qp) com.byazt.ut.uj.getService("thread_service")).executeFastTask(spVar);
    }

    public static void c(final Runnable runnable, ScheduledExecutorService scheduledExecutorService) {
        if (!c()) {
            if (runnable != null) {
                runnable.run();
            }
        } else if (scheduledExecutorService != null) {
            scheduledExecutorService.execute(runnable);
        } else {
            ((qp) com.byazt.ut.uj.getService("thread_service")).executeFastTask(new Runnable() { // from class: com.byazt.bzd.x.1
                @Override // java.lang.Runnable
                public void run() {
                    Runnable runnable2 = runnable;
                    if (runnable2 != null) {
                        runnable2.run();
                    }
                }
            });
        }
    }
}
