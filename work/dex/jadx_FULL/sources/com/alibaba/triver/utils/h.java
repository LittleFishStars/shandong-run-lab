package com.alibaba.triver.utils;

import androidx.annotation.NonNull;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@Deprecated
public class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static h f25276a;
    private AtomicInteger c = new AtomicInteger(0);
    private ThreadPoolExecutor b = new ThreadPoolExecutor(2, 10, 1, TimeUnit.HOURS, new ArrayBlockingQueue(1), new ThreadFactory() { // from class: com.alibaba.triver.utils.h.1
        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            String str = "thread_no_" + h.this.c.addAndGet(1);
            RVLogger.d("RVThreadPool", "create thread " + str);
            return new Thread(runnable, str);
        }
    });

    private h() {
    }

    public ThreadPoolExecutor b() {
        return this.b;
    }

    public void c() {
        ThreadPoolExecutor threadPoolExecutor = this.b;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdownNow();
        }
    }

    public static h a() {
        if (f25276a == null) {
            f25276a = new h();
        }
        return f25276a;
    }
}
