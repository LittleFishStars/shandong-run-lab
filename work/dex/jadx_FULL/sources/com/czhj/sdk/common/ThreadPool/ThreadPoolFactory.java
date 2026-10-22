package com.czhj.sdk.common.ThreadPool;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ThreadPoolFactory {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f29394a;
    private static final TimeUnit b;
    private static final Handler c;
    private static Handler d;
    private static final ExecutorService e;
    private static HandlerThread f;

    public static class BackgroundThreadPool {
        private static volatile BackgroundThreadPool d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final int f29395a = 2;
        final BlockingQueue<Runnable> b = new LinkedBlockingQueue();
        final ExecutorService c = ThreadPoolFactory.e;

        public BackgroundThreadPool() {
            HandlerThread unused = ThreadPoolFactory.f = new HandlerThread("ioThread");
            ThreadPoolFactory.f.start();
            Handler unused2 = ThreadPoolFactory.d = new Handler(ThreadPoolFactory.f.getLooper());
        }

        public static BackgroundThreadPool getInstance() {
            if (d == null) {
                synchronized (BackgroundThreadPool.class) {
                    if (d == null) {
                        d = new BackgroundThreadPool();
                    }
                }
            }
            return d;
        }

        public ExecutorService getExecutorService() {
            return this.c;
        }

        public Handler getIOHandler() {
            return ThreadPoolFactory.d;
        }

        public Looper getIOLooper() {
            return ThreadPoolFactory.f.getLooper();
        }

        public void submit(Runnable runnable) {
            try {
                this.c.submit(runnable);
            } catch (Throwable unused) {
            }
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f29394a = iAvailableProcessors;
        b = TimeUnit.SECONDS;
        c = new Handler(Looper.getMainLooper());
        e = Executors.newFixedThreadPool(iAvailableProcessors + 1, new BackgroundThreadFactory());
    }

    public static void MainThreadRun(Runnable runnable) {
        c.post(runnable);
    }

    public static ExecutorService getFixIOExecutor() {
        return e;
    }
}
