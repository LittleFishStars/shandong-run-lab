package com.byazt.qy;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.byazt.bog.a;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 110, 20})
public final class c {
    public static volatile c c;
    public volatile ThreadPoolExecutor tt = null;
    public final Handler ve;

    private c() {
        HandlerThread handlerThread = new HandlerThread("csj_api_main");
        handlerThread.start();
        this.ve = new Handler(handlerThread.getLooper());
    }

    public static c c() {
        if (c == null) {
            synchronized (c.class) {
                c = new c();
            }
        }
        return c;
    }

    public Handler tt() {
        return this.ve;
    }

    public ExecutorService uj() {
        if (this.tt == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, Integer.MAX_VALUE, 1000L, TimeUnit.MILLISECONDS, new SynchronousQueue());
            threadPoolExecutor.allowCoreThreadTimeOut(true);
            this.tt = threadPoolExecutor;
        }
        return this.tt;
    }

    public Handler ve() {
        return new Handler(Looper.getMainLooper());
    }

    public void c(Runnable runnable) {
        if (runnable != null) {
            try {
                this.ve.post(runnable);
            } catch (Throwable th) {
                a.c(th);
            }
        }
    }
}
