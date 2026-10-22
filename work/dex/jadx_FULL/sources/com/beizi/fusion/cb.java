package com.beizi.fusion;

import java.util.concurrent.RunnableScheduledFuture;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class cb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected final int f27138a = 0;
    private final Runnable b;
    private RunnableScheduledFuture c;

    public cb(Runnable runnable) {
        this.b = runnable;
    }

    public final void a(long j, long j2, TimeUnit timeUnit) {
        ScheduledExecutorService scheduledExecutorServiceB = b();
        if (scheduledExecutorServiceB != null) {
            a(scheduledExecutorServiceB.scheduleWithFixedDelay(this.b, j, j2, timeUnit));
        }
    }

    public abstract ScheduledExecutorService b();

    public final void c() {
        if (this.c != null) {
            ScheduledExecutorService scheduledExecutorServiceB = b();
            if (scheduledExecutorServiceB instanceof ScheduledThreadPoolExecutor) {
                ((ScheduledThreadPoolExecutor) scheduledExecutorServiceB).remove(this.c);
                this.c = null;
            }
        }
    }

    public Runnable a() {
        return this.b;
    }

    private void a(ScheduledFuture scheduledFuture) {
        if (scheduledFuture instanceof RunnableScheduledFuture) {
            try {
                this.c = (RunnableScheduledFuture) scheduledFuture;
            } catch (Throwable th) {
                om.a(th);
                this.c = null;
            }
        }
    }
}
