package com.beizi.fusion;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class n4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f27552a;
    private static final int b;
    private static final LinkedBlockingQueue c;
    private static final LinkedBlockingQueue d;
    private static final ArrayBlockingQueue e;

    public class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f27552a = iAvailableProcessors;
        b = Math.max((iAvailableProcessors / 2) + 1, 4);
        c = new LinkedBlockingQueue();
        d = new LinkedBlockingQueue();
        e = new ArrayBlockingQueue(50);
    }

    public static ThreadPoolExecutor a() {
        return new ThreadPoolExecutor(2, b, 5L, TimeUnit.SECONDS, c, new l4(5, "BeiZi-adsdk-adrequest-thread-"), f());
    }

    public static ThreadPoolExecutor b() {
        return new ThreadPoolExecutor(2, b, 5L, TimeUnit.SECONDS, c, new l4(5, "BeiZi-adsdk-adrequest-thread-"), f());
    }

    public static ThreadPoolExecutor c() {
        return new ThreadPoolExecutor(0, 2, 5L, TimeUnit.SECONDS, d, new l4(5, "BeiZi-adsdk-heartbeat-thread-"), f());
    }

    public static ThreadPoolExecutor d() {
        return new ThreadPoolExecutor(2, 6, 20L, TimeUnit.SECONDS, e, new l4(5, "BeiZi-adsdk-file-log-upload-thread-"), f());
    }

    public static ScheduledThreadPoolExecutor e() {
        return (ScheduledThreadPoolExecutor) Executors.newScheduledThreadPool(4);
    }

    public static RejectedExecutionHandler f() {
        return new a();
    }
}
