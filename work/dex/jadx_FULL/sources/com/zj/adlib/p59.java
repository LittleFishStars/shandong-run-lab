package com.zj.adlib;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class p59 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f43908a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ExecutorService f18778a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static ThreadPoolExecutor f18779a = null;
    public static final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static ThreadPoolExecutor f18780b = null;
    public static final int c = 5;

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f43908a = iAvailableProcessors;
        b = (iAvailableProcessors * 2) + 1;
    }

    public static synchronized ExecutorService a() {
        if (f18779a == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(2, b, 5L, TimeUnit.SECONDS, new LinkedBlockingDeque());
            f18779a = threadPoolExecutor;
            threadPoolExecutor.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardOldestPolicy());
            f18779a.allowCoreThreadTimeOut(true);
        }
        return f18779a;
    }

    public static synchronized ExecutorService b() {
        if (f18778a == null) {
            f18778a = Executors.newSingleThreadExecutor();
        }
        return f18778a;
    }

    public static synchronized ExecutorService c() {
        if (f18780b == null) {
            ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, b, 5L, TimeUnit.SECONDS, new LinkedBlockingDeque());
            f18780b = threadPoolExecutor;
            threadPoolExecutor.allowCoreThreadTimeOut(true);
        }
        return f18780b;
    }
}
