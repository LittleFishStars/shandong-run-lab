package com.google.common.util.concurrent;

import com.google.common.annotations.GwtIncompatible;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public class i<V> extends FutureTask<V> implements ListenableFuture<V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final c f32425a;

    public i(Callable<V> callable) {
        super(callable);
        this.f32425a = new c();
    }

    public static <V> i<V> a(Runnable runnable, @ParametricNullness V v) {
        return new i<>(runnable, v);
    }

    public static <V> i<V> c(Callable<V> callable) {
        return new i<>(callable);
    }

    @Override // com.google.common.util.concurrent.ListenableFuture
    public void addListener(Runnable runnable, Executor executor) {
        this.f32425a.a(runnable, executor);
    }

    @Override // java.util.concurrent.FutureTask
    public void done() {
        this.f32425a.b();
    }

    @Override // java.util.concurrent.FutureTask, java.util.concurrent.Future
    @CanIgnoreReturnValue
    @ParametricNullness
    public V get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long nanos = timeUnit.toNanos(j);
        return nanos <= l.f32437a ? (V) super.get(j, timeUnit) : (V) super.get(Math.min(nanos, l.f32437a), TimeUnit.NANOSECONDS);
    }

    public i(Runnable runnable, @ParametricNullness V v) {
        super(runnable, v);
        this.f32425a = new c();
    }
}
