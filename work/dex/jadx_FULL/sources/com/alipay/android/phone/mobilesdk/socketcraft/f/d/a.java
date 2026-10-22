package com.alipay.android.phone.mobilesdk.socketcraft.f.d;

import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadPoolExecutor f25304a;
    private final ScheduledThreadPoolExecutor b;

    public a() {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(7, Integer.MAX_VALUE, 2L, timeUnit, new SynchronousQueue(), new ThreadPoolExecutor.DiscardOldestPolicy());
        this.f25304a = threadPoolExecutor;
        ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1);
        this.b = scheduledThreadPoolExecutor;
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        scheduledThreadPoolExecutor.setKeepAliveTime(6L, timeUnit);
        scheduledThreadPoolExecutor.allowCoreThreadTimeOut(true);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public void a(Runnable runnable) {
        this.f25304a.execute(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public void b(Runnable runnable) {
        this.f25304a.execute(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public void c(Runnable runnable) {
        this.f25304a.execute(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public void d(Runnable runnable) {
        this.f25304a.execute(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public Future<?> e(Runnable runnable) {
        return this.f25304a.submit(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public Future<?> f(Runnable runnable) {
        return this.f25304a.submit(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public void g(Runnable runnable) {
        this.f25304a.execute(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public Future<?> h(Runnable runnable) {
        return this.f25304a.submit(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public <T> Future<T> a(Callable<T> callable) {
        return this.f25304a.submit(callable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public ScheduledFuture<?> b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.b.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public ScheduledFuture<?> a(Runnable runnable, long j, TimeUnit timeUnit) {
        return this.b.schedule(runnable, j, timeUnit);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public <V> ScheduledFuture<V> a(Callable<V> callable, long j, TimeUnit timeUnit) {
        return this.b.schedule(callable, j, timeUnit);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public ScheduledFuture<?> a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return this.b.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }
}
