package cn.hzjizhun.admin.http.net.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class EasyThreadPools {
    private static ExecutorService sDefaultExecutorService = new ThreadPoolExecutor(4, 8, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new a(), new ThreadPoolExecutor.CallerRunsPolicy());

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public AtomicInteger f22736a = new AtomicInteger();

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName("EasyNetwork#" + this.f22736a.getAndIncrement());
            return thread;
        }
    }

    public static void executor(Runnable runnable) {
        sDefaultExecutorService.execute(runnable);
    }

    public static void setDefaultExecutorService(ExecutorService executorService) {
        sDefaultExecutorService = executorService;
    }

    public static <T> Future<T> submit(Callable<T> callable) {
        return sDefaultExecutorService.submit(callable);
    }
}
