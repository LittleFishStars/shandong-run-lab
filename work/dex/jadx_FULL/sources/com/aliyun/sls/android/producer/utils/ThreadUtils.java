package com.aliyun.sls.android.producer.utils;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class ThreadUtils {
    private static final ExecutorService CACHED_THREAD_POOL = Executors.newCachedThreadPool();

    private ThreadUtils() {
    }

    public static Executor cachedExecutors() {
        return CACHED_THREAD_POOL;
    }

    public static void exec(Runnable r) {
        CACHED_THREAD_POOL.execute(r);
    }
}
