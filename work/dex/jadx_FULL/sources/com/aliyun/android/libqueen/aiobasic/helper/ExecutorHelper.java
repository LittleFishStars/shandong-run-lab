package com.aliyun.android.libqueen.aiobasic.helper;

import androidx.annotation.NonNull;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ExecutorHelper {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExecutorService f25563a;
    private ScheduledExecutorService b;

    public class a implements ThreadFactory {
        public a(ExecutorHelper executorHelper) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread thread = new Thread(runnable);
            if (thread.getPriority() != 2) {
                thread.setPriority(2);
            }
            return thread;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static ExecutorHelper f25564a = new ExecutorHelper(null);
    }

    private ExecutorHelper() {
        a aVar = new a(this);
        this.f25563a = new ThreadPoolExecutor(1, 8, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), aVar);
        this.b = new ScheduledThreadPoolExecutor(1, aVar);
    }

    public /* synthetic */ ExecutorHelper(a aVar) {
        this();
    }

    public static ExecutorHelper getInstance() {
        return b.f25564a;
    }

    public void destroy() {
        this.f25563a.shutdown();
    }

    public void submit(Runnable runnable) {
        this.f25563a.submit(runnable);
    }

    public void submitDelay(Runnable runnable, long j) {
        this.b.schedule(runnable, j, TimeUnit.MILLISECONDS);
    }
}
