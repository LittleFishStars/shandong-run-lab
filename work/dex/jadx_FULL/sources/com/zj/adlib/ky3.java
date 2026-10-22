package com.zj.adlib;

import android.os.Handler;
import com.facebook.common.executors.HandlerExecutorService;
import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.Callable;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ky3 extends AbstractExecutorService implements HandlerExecutorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f42942a;

    public ky3(Handler handler) {
        this.f42942a = handler;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
    public ScheduledFuture<?> submit(Runnable runnable) {
        return submit(runnable, null);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public <T> ScheduledFuture<T> submit(Runnable runnable, @Nullable T t) {
        runnable.getClass();
        ov7<T> ov7VarNewTaskFor = newTaskFor(runnable, (Object) t);
        execute(ov7VarNewTaskFor);
        return ov7VarNewTaskFor;
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService
    /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
    public <T> ScheduledFuture<T> submit(Callable<T> callable) {
        callable.getClass();
        ov7<T> ov7VarNewTaskFor = newTaskFor((Callable) callable);
        execute(ov7VarNewTaskFor);
        return ov7VarNewTaskFor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f42942a.post(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // com.facebook.common.executors.HandlerExecutorService
    public void q0() {
        this.f42942a.getLooper().quit();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
        ov7 ov7VarNewTaskFor = newTaskFor(runnable, (Object) null);
        this.f42942a.postDelayed(ov7VarNewTaskFor, timeUnit.toMillis(j));
        return ov7VarNewTaskFor;
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public ScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }

    @Override // com.facebook.common.executors.HandlerExecutorService
    public boolean w() {
        return Thread.currentThread() == this.f42942a.getLooper().getThread();
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> ov7<T> newTaskFor(Runnable runnable, T t) {
        return new ov7<>(this.f42942a, runnable, t);
    }

    @Override // java.util.concurrent.ScheduledExecutorService
    public <V> ScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
        ov7 ov7VarNewTaskFor = newTaskFor((Callable) callable);
        this.f42942a.postDelayed(ov7VarNewTaskFor, timeUnit.toMillis(j));
        return ov7VarNewTaskFor;
    }

    @Override // java.util.concurrent.AbstractExecutorService
    public <T> ov7<T> newTaskFor(Callable<T> callable) {
        return new ov7<>(this.f42942a, callable);
    }
}
