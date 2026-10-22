package com.ltmb.gromoreadapter;

import android.os.Handler;
import android.os.Looper;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_01_2010cls.dex */
public class ThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ThreadPoolExecutor f40286a;
    public static final Handler b;

    static {
        int iMax = Math.max(Runtime.getRuntime().availableProcessors(), 16);
        f40286a = new ThreadPoolExecutor(iMax, iMax, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new ThreadPoolExecutor.CallerRunsPolicy());
        b = new Handler(Looper.getMainLooper());
    }

    public static void runOnThreadPool(Runnable runnable) {
        f40286a.execute(runnable);
    }

    public static void runOnUIThread(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            b.post(runnable);
        }
    }

    public static void runOnUIThreadByThreadPool(final Runnable runnable) {
        f40286a.execute(new Runnable() { // from class: com.ltmb.gromoreadapter.ThreadUtils.1
            @Override // java.lang.Runnable
            public void run() {
                ThreadUtils.b.post(runnable);
            }
        });
    }

    public static <T> Future<T> runOnThreadPool(Callable<T> callable) {
        return f40286a.submit(callable);
    }
}
