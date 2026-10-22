package com.kwad.sdk.utils.a;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_04_1967cls.dex */
public final class d {
    static c.d bsx;
    static volatile Executor bsy;
    static ExecutorService bsz = Executors.newSingleThreadExecutor();

    private d() {
    }

    public static void a(c.d dVar) {
        bsx = dVar;
    }

    public static Executor getExecutor() {
        if (bsy == null) {
            synchronized (d.class) {
                if (bsy == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, 4, 10L, TimeUnit.SECONDS, new LinkedBlockingQueue());
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                    bsy = threadPoolExecutor;
                }
            }
        }
        return bsy;
    }

    public static void setExecutor(Executor executor) {
        if (executor != null) {
            bsy = executor;
        }
    }
}
