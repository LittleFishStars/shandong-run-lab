package com.alibaba.appmonitor.a;

import com.alibaba.analytics.a.j;
import com.alibaba.analytics.a.x;
import java.util.concurrent.ScheduledFuture;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class c implements Runnable {
    private static boolean Y = false;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static c f23799a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ScheduledFuture f670a;

    private c() {
    }

    public static void destroy() {
        ScheduledFuture scheduledFuture = f670a;
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            f670a.cancel(true);
        }
        Y = false;
        f23799a = null;
    }

    public static void init() {
        if (Y) {
            return;
        }
        j.d("CleanTask", "init TimeoutEventManager");
        f23799a = new c();
        f670a = x.a().a(f670a, f23799a, 300000L);
        Y = true;
    }

    @Override // java.lang.Runnable
    public void run() {
        j.d("CleanTask", "clean TimeoutEvent");
        com.alibaba.appmonitor.event.e.a().U();
    }
}
