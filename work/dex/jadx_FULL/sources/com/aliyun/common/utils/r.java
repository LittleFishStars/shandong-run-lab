package com.aliyun.common.utils;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class r {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Handler f25583a = new Handler(Looper.getMainLooper());
    private static final String b = r.class.getName();
    private static final int c;
    private static final int d;
    private static final int e;
    private static final BlockingQueue<Runnable> f;
    private static final ThreadFactory g;
    private static final ThreadPoolExecutor h;

    public static class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f25584a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ThreadUtils #" + this.f25584a.getAndIncrement());
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        c = iAvailableProcessors;
        int iMax = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        d = iMax;
        int i = (iAvailableProcessors * 2) + 1;
        e = i;
        LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue(128);
        f = linkedBlockingQueue;
        a aVar = new a();
        g = aVar;
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(iMax, i, 30L, TimeUnit.SECONDS, linkedBlockingQueue, aVar);
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        h = threadPoolExecutor;
    }

    public static void a(Runnable runnable) {
        ThreadPoolExecutor threadPoolExecutor = h;
        if (threadPoolExecutor.getQueue().size() == 128 || threadPoolExecutor.isShutdown()) {
            Log.e(b, "线程池爆满警告，请查看是否开启了过多的耗时线程");
        } else {
            threadPoolExecutor.execute(runnable);
        }
    }

    public static void a(Runnable runnable, long j) {
        f25583a.postDelayed(runnable, j);
    }

    public static void b(Runnable runnable) {
        a(runnable, 0L);
    }
}
