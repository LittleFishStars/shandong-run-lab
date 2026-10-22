package com.alipay.android.phone.mobilesdk.socketcraft.f.d;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public interface b {
    <T> Future<T> a(Callable<T> callable);

    ScheduledFuture<?> a(Runnable runnable, long j, long j2, TimeUnit timeUnit);

    ScheduledFuture<?> a(Runnable runnable, long j, TimeUnit timeUnit);

    <V> ScheduledFuture<V> a(Callable<V> callable, long j, TimeUnit timeUnit);

    void a(Runnable runnable);

    ScheduledFuture<?> b(Runnable runnable, long j, long j2, TimeUnit timeUnit);

    void b(Runnable runnable);

    void c(Runnable runnable);

    void d(Runnable runnable);

    Future<?> e(Runnable runnable);

    Future<?> f(Runnable runnable);

    void g(Runnable runnable);

    Future<?> h(Runnable runnable);
}
