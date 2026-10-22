package com.google.android.exoplayer2.util;

import androidx.annotation.Nullable;
import com.zj.adlib.ps1;
import java.lang.Exception;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.RunnableFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class RunnableFutureTask<R, E extends Exception> implements RunnableFuture<R> {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Exception f5282a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Thread f5284a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f5285a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public R f5286b;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ps1 f31167a = new ps1();
    public final ps1 b = new ps1();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f5283a = new Object();

    public final void c() {
        this.b.c();
    }

    @Override // java.util.concurrent.Future
    public final boolean cancel(boolean z) {
        synchronized (this.f5283a) {
            if (!this.f5285a && !this.b.e()) {
                this.f5285a = true;
                cancelWork();
                Thread thread = this.f5284a;
                if (thread == null) {
                    this.f31167a.f();
                    this.b.f();
                } else if (z) {
                    thread.interrupt();
                }
                return true;
            }
            return false;
        }
    }

    public void cancelWork() {
    }

    public final void d() {
        this.f31167a.c();
    }

    @UnknownNull
    public abstract R doWork() throws Exception;

    @UnknownNull
    public final R e() throws ExecutionException {
        if (this.f5285a) {
            throw new CancellationException();
        }
        if (this.f5282a == null) {
            return this.f5286b;
        }
        throw new ExecutionException(this.f5282a);
    }

    @Override // java.util.concurrent.Future
    @UnknownNull
    public final R get() throws ExecutionException, InterruptedException {
        this.b.a();
        return e();
    }

    @Override // java.util.concurrent.Future
    public final boolean isCancelled() {
        return this.f5285a;
    }

    @Override // java.util.concurrent.Future
    public final boolean isDone() {
        return this.b.e();
    }

    @Override // java.util.concurrent.RunnableFuture, java.lang.Runnable
    public final void run() {
        synchronized (this.f5283a) {
            if (this.f5285a) {
                return;
            }
            this.f5284a = Thread.currentThread();
            this.f31167a.f();
            try {
                try {
                    this.f5286b = doWork();
                    synchronized (this.f5283a) {
                        this.b.f();
                        this.f5284a = null;
                        Thread.interrupted();
                    }
                } catch (Exception e) {
                    this.f5282a = e;
                    synchronized (this.f5283a) {
                        this.b.f();
                        this.f5284a = null;
                        Thread.interrupted();
                    }
                }
            } catch (Throwable th) {
                synchronized (this.f5283a) {
                    this.b.f();
                    this.f5284a = null;
                    Thread.interrupted();
                    throw th;
                }
            }
        }
    }

    @Override // java.util.concurrent.Future
    @UnknownNull
    public final R get(long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        if (this.b.b(TimeUnit.MILLISECONDS.convert(j, timeUnit))) {
            return e();
        }
        throw new TimeoutException();
    }
}
