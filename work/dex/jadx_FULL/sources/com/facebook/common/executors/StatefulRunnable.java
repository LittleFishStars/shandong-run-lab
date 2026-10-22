package com.facebook.common.executors;

import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class StatefulRunnable<T> implements Runnable {
    public static final int K = 0;
    public static final int L = 1;
    public static final int M = 2;
    public static final int N = 3;
    public static final int O = 4;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AtomicInteger f29953a = new AtomicInteger(0);

    public void b() {
        if (this.f29953a.compareAndSet(0, 2)) {
            onCancellation();
        }
    }

    public void disposeResult(T t) {
    }

    public abstract T getResult() throws Exception;

    public void onCancellation() {
    }

    public void onFailure(Exception exc) {
    }

    public void onSuccess(T t) {
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (this.f29953a.compareAndSet(0, 1)) {
            try {
                T result = getResult();
                this.f29953a.set(3);
                try {
                    onSuccess(result);
                } finally {
                    disposeResult(result);
                }
            } catch (Exception e) {
                this.f29953a.set(4);
                onFailure(e);
            }
        }
    }
}
