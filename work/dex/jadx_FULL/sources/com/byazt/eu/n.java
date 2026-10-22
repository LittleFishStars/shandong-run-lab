package com.byazt.eu;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.byazt.nr.m;
import com.bykv.vk.component.ttvideo.player.MediaPlayer;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, MediaPlayer.MEDIA_PLAYER_OPTION_FORCE_CLOSE_CODEC, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static Handler f28530a = null;
    public static final /* synthetic */ boolean c = true;
    public static final Executor da;
    public static final ThreadPoolExecutor i;
    public static HandlerThread n = null;
    public static final int sp;
    public static final Object tt = new Object();
    public static Handler uj = null;
    public static boolean ve = false;
    public static final int x;

    static {
        c();
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        sp = iAvailableProcessors;
        x = Math.min(iAvailableProcessors, 4);
        i = i();
        da = da();
    }

    public static Executor a() {
        return i;
    }

    public static void c() {
        try {
            HandlerThread handlerThread = new HandlerThread("gm_t_main", -19);
            n = handlerThread;
            handlerThread.start();
            f28530a = new Handler(n.getLooper());
        } catch (Throwable th) {
            m.c(th);
        }
    }

    private static Executor da() {
        return new com.byazt.jtc.uj(2, 2, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(256), c("gm_t_log_upload:"), new ThreadPoolExecutor.DiscardPolicy());
    }

    private static ThreadPoolExecutor i() {
        int i2 = x;
        com.byazt.jtc.uj ujVar = new com.byazt.jtc.uj(i2, i2, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue(1024), c("gm_t_executor:"), new ThreadPoolExecutor.DiscardOldestPolicy() { // from class: com.byazt.eu.n.2
            @Override // java.util.concurrent.ThreadPoolExecutor.DiscardOldestPolicy, java.util.concurrent.RejectedExecutionHandler
            public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                super.rejectedExecution(runnable, threadPoolExecutor);
                com.byazt.ii.c.c().ve();
            }
        });
        try {
            ujVar.allowCoreThreadTimeOut(true);
        } catch (Exception e) {
            m.ve("ThreadHelper", "stackerror:", e);
        } catch (NoSuchMethodError e2) {
            m.c(e2);
        }
        return ujVar;
    }

    public static boolean n() {
        return uj().getLooper() == Looper.myLooper();
    }

    public static Executor sp() {
        return da;
    }

    public static Looper tt() {
        if (x()) {
            return n.getLooper();
        }
        return null;
    }

    public static Handler uj() {
        Handler handler;
        synchronized (tt) {
            if (uj == null) {
                if (ve) {
                    throw new RuntimeException("Did not yet override the UI thread");
                }
                uj = new Handler(Looper.getMainLooper());
            }
            handler = uj;
        }
        return handler;
    }

    public static boolean ve() {
        return x() && n.getLooper() == Looper.myLooper();
    }

    private static boolean x() {
        HandlerThread handlerThread = n;
        return (handlerThread == null || !handlerThread.isAlive() || f28530a == null) ? false : true;
    }

    public static void tt(Runnable runnable) {
        if (n()) {
            runnable.run();
            return;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        c(futureTask);
        try {
            futureTask.get();
        } catch (Exception e) {
            throw new RuntimeException("Exception occured while waiting for runnable", e);
        }
    }

    public static void ve(Runnable runnable) {
        if (n()) {
            runnable.run();
        } else {
            uj().post(runnable);
        }
    }

    public static void c(Runnable runnable) {
        if (x()) {
            if (ve()) {
                runnable.run();
                return;
            } else {
                f28530a.post(runnable);
                return;
            }
        }
        c();
    }

    public static void uj(Runnable runnable) {
        c(i, runnable);
    }

    public static void c(Runnable runnable, long j) {
        if (x()) {
            f28530a.postDelayed(runnable, j);
        } else {
            c();
        }
    }

    public static ThreadFactory c(final String str) {
        return new ThreadFactory() { // from class: com.byazt.eu.n.1
            public final AtomicInteger tt = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new com.byazt.jtc.ve(runnable, str + " # " + this.tt.getAndIncrement());
            }
        };
    }

    public static <T> FutureTask<T> c(FutureTask<T> futureTask) {
        uj().post(futureTask);
        return futureTask;
    }

    public static ExecutorService c(String str, int i2, RejectedExecutionHandler rejectedExecutionHandler) {
        return new com.byazt.jtc.uj(1, 1, 0L, TimeUnit.SECONDS, new LinkedBlockingQueue(i2), c("gm_t_single_".concat(String.valueOf(str))), rejectedExecutionHandler);
    }

    private static boolean c(Executor executor, Runnable runnable) {
        try {
            executor.execute(runnable);
            return true;
        } catch (Throwable th) {
            m.ve("ThreadHelper", "stackerror:", th);
            return false;
        }
    }
}
