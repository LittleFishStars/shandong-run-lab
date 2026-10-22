package com.kc.cw.ad.utils;

import android.os.Handler;
import android.os.Looper;
import com.kc.cw.ad.d.b.f;
import com.qihoo.SdkProtected.OSETSDK.Keep;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final ThreadPoolExecutor f39075a;
    private static final ThreadPoolExecutor b;
    public static Handler mMainHandler;

    static {
        TimeUnit timeUnit = TimeUnit.SECONDS;
        f39075a = new ThreadPoolExecutor(5, 20, 2L, timeUnit, new LinkedBlockingQueue(128));
        b = new ThreadPoolExecutor(5, 20, 2L, timeUnit, new LinkedBlockingQueue(128));
        mMainHandler = new Handler(Looper.getMainLooper());
    }

    public static void runOnLogThreadPool(Runnable runnable) {
        try {
            ThreadPoolExecutor threadPoolExecutor = b;
            if (threadPoolExecutor.isShutdown()) {
                return;
            }
            threadPoolExecutor.execute(runnable);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public static <T> Future<T> runOnThreadPool(Callable<T> callable) {
        return f39075a.submit(callable);
    }

    public static void runOnThreadPool(Runnable runnable) {
        try {
            ThreadPoolExecutor threadPoolExecutor = f39075a;
            if (threadPoolExecutor.isShutdown()) {
                return;
            }
            threadPoolExecutor.execute(runnable);
        } catch (Exception e) {
            f.a("OctopusAd", "An Exception Caught", e);
        }
    }

    public static void runOnUIThread(Runnable runnable) {
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            runnable.run();
        } else {
            mMainHandler.post(runnable);
        }
    }

    public static void runOnUIThreadByThreadPool(Runnable runnable) {
        f39075a.execute(new Runnable(runnable) { // from class: com.kc.cw.ad.utils.ThreadUtils.1

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            final Runnable f39076a;

            {
                this.f39076a = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                ThreadUtils.mMainHandler.post(this.f39076a);
            }
        });
    }
}
