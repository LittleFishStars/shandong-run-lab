package com.alipay.android.phone.mobilesdk.socketcraft.d.d;

import com.alipay.android.phone.mobilesdk.socketcraft.f.d.b;
import com.alipay.mobile.common.transport.utils.NetworkAsyncTaskExecutor;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a implements b {
    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public void a(Runnable runnable) {
        NetworkAsyncTaskExecutor.executeIO(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public void b(Runnable runnable) {
        NetworkAsyncTaskExecutor.executeLowPri(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public void c(Runnable runnable) {
        NetworkAsyncTaskExecutor.executeLazy(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public void d(Runnable runnable) {
        NetworkAsyncTaskExecutor.execute(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public Future<?> e(Runnable runnable) {
        return NetworkAsyncTaskExecutor.submit(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public Future<?> f(Runnable runnable) {
        return NetworkAsyncTaskExecutor.submitLazy(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public void g(Runnable runnable) {
        NetworkAsyncTaskExecutor.executeSerial(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public Future<?> h(Runnable runnable) {
        return NetworkAsyncTaskExecutor.submitSerial(runnable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public <T> Future<T> a(Callable<T> callable) {
        return NetworkAsyncTaskExecutor.submit(callable);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public ScheduledFuture<?> b(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return NetworkAsyncTaskExecutor.scheduleWithFixedDelay(runnable, j, j2, timeUnit);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public ScheduledFuture<?> a(Runnable runnable, long j, TimeUnit timeUnit) {
        return NetworkAsyncTaskExecutor.schedule(runnable, j, timeUnit);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public <V> ScheduledFuture<V> a(Callable<V> callable, long j, TimeUnit timeUnit) {
        return NetworkAsyncTaskExecutor.schedule(callable, j, timeUnit);
    }

    @Override // com.alipay.android.phone.mobilesdk.socketcraft.f.d.b
    public ScheduledFuture<?> a(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        return NetworkAsyncTaskExecutor.scheduleAtFixedRate(runnable, j, j2, timeUnit);
    }
}
