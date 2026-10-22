package com.beizi.fusion;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class m4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f27534a;
    private static final int b;
    private static final LinkedBlockingQueue c;
    private static final LinkedBlockingQueue d;
    private static final LinkedBlockingQueue e;
    private static final ArrayBlockingQueue f;

    public class a implements RejectedExecutionHandler {
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f27534a = iAvailableProcessors;
        b = Math.max((iAvailableProcessors / 2) + 1, 4);
        c = new LinkedBlockingQueue();
        d = new LinkedBlockingQueue();
        e = new LinkedBlockingQueue();
        f = new ArrayBlockingQueue(200);
    }

    public static ThreadPoolExecutor a() {
        return new ThreadPoolExecutor(2, b, 5L, TimeUnit.SECONDS, c, new k4(5, "afAd-"), e());
    }

    public static ThreadPoolExecutor b() {
        return new ThreadPoolExecutor(2, b, 5L, TimeUnit.SECONDS, d, new k4(5, "afHb-"), e());
    }

    public static ThreadPoolExecutor c() {
        return new ThreadPoolExecutor(2, b, 20L, TimeUnit.SECONDS, e, new k4(5, "afIt-"), e());
    }

    public static ThreadPoolExecutor d() {
        return new ThreadPoolExecutor(2, 20, 20L, TimeUnit.SECONDS, f, new k4(5, "afFu-"), e());
    }

    public static RejectedExecutionHandler e() {
        return new a();
    }
}
