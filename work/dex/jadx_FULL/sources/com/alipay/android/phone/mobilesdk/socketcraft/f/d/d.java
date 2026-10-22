package com.alipay.android.phone.mobilesdk.socketcraft.f.d;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class d {
    public static final void a(Runnable runnable) {
        a().a(runnable);
    }

    public static final void b(Runnable runnable) {
        a().b(runnable);
    }

    public static final void c(Runnable runnable) {
        a().c(runnable);
    }

    public static final void d(Runnable runnable) {
        a().d(runnable);
    }

    public static final Future<?> e(Runnable runnable) {
        return a().e(runnable);
    }

    public static final Future<?> f(Runnable runnable) {
        return a().f(runnable);
    }

    public static final void g(Runnable runnable) {
        a().g(runnable);
    }

    public static final Future<?> h(Runnable runnable) {
        return a().h(runnable);
    }

    public static final <T> Future<T> a(Callable<T> callable) {
        return a().a(callable);
    }

    public static final ScheduledFuture<?> b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return a().b(runnable, j, j2, timeUnit);
    }

    public static final ScheduledFuture<?> a(Runnable runnable, long j, TimeUnit timeUnit) {
        return a().a(runnable, j, timeUnit);
    }

    public static final <V> ScheduledFuture<V> a(Callable<V> callable, long j, TimeUnit timeUnit) {
        return a().a(callable, j, timeUnit);
    }

    public static final ScheduledFuture<?> a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return a().a(runnable, j, j2, timeUnit);
    }

    public static final b a() {
        return c.a();
    }
}
