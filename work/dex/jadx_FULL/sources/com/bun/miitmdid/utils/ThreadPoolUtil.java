package com.bun.miitmdid.utils;

import com.netease.nis.sdkwrapper.Utils;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ThreadPoolUtil {
    private static BlockingQueue blockingQueue = new ArrayBlockingQueue(3);
    private static ThreadFactory threadFactory = new ThreadFactory() { // from class: com.bun.miitmdid.utils.ThreadPoolUtil.1
        private final AtomicInteger integer = new AtomicInteger();

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "myThreadPool thread:" + this.integer.getAndIncrement());
        }
    };
    private static int CORE_POOL_SIZE = 2;
    private static int MAX_POOL_SIZE = 5;
    private static int KEEP_ALIVE_TIME = 5000;
    private static ThreadPoolExecutor threadPool = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE, KEEP_ALIVE_TIME, TimeUnit.SECONDS, (BlockingQueue<Runnable>) blockingQueue, threadFactory);

    public static void execute(Runnable runnable) {
        Object[] objArr = new Object[4];
        objArr[1] = runnable;
        objArr[2] = 137;
        objArr[3] = 1606976968609L;
        Utils.rL(objArr);
    }
}
