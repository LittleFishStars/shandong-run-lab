package com.hihonor.push.sdk;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class b1 {
    public static final b1 d = new b1();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile Executor f32638a;
    public volatile ExecutorService b;
    public final Object c = new Object();

    public static class a implements Executor {
        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            new Handler(Looper.getMainLooper()).post(runnable);
        }
    }

    public static Executor a() {
        b1 b1Var = d;
        if (b1Var.f32638a == null) {
            synchronized (b1Var.c) {
                if (b1Var.f32638a == null) {
                    b1Var.f32638a = new a();
                }
            }
        }
        return b1Var.f32638a;
    }

    public static ExecutorService c() {
        return d.b();
    }

    public final ExecutorService b() {
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 10, 1L, TimeUnit.SECONDS, new LinkedBlockingQueue());
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        return threadPoolExecutor;
    }

    public static void a(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            a().execute(runnable);
        }
    }
}
