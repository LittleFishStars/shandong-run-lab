package com.alibaba.analytics.a;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class x {
    private static int K = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static x f23749a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ScheduledExecutorService f623a;
    private static final AtomicInteger d = new AtomicInteger();

    public static class a implements ThreadFactory {
        private int priority;

        public a(int i) {
            this.priority = i;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, "AppMonitor:" + x.d.getAndIncrement());
            thread.setPriority(this.priority);
            return thread;
        }
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static synchronized ScheduledExecutorService m97a() {
        if (f623a == null) {
            f623a = Executors.newScheduledThreadPool(3, new a(K));
        }
        return f623a;
    }

    public final ScheduledFuture schedule(ScheduledFuture scheduledFuture, Runnable runnable, long j) {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(true);
        }
        return m97a().schedule(runnable, j, TimeUnit.MILLISECONDS);
    }

    public void submit(Runnable runnable) {
        try {
            m97a().submit(runnable);
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static synchronized x a() {
        if (f23749a == null) {
            f23749a = new x();
        }
        return f23749a;
    }

    public final ScheduledFuture a(ScheduledFuture scheduledFuture, Runnable runnable, long j) {
        if (scheduledFuture != null && !scheduledFuture.isDone()) {
            scheduledFuture.cancel(false);
        }
        return m97a().scheduleAtFixedRate(runnable, 1000L, j, TimeUnit.MILLISECONDS);
    }
}
