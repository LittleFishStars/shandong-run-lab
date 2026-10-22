package com.baidu.mapapi.http.wrapper;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ThreadPoolUtils {
    private static final ExecutorService threadPool = Executors.newCachedThreadPool();

    public static ExecutorService getThreadPool() {
        return threadPool;
    }
}
