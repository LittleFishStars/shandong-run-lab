package com.alibaba.triver.monitor;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Executor f25019a = Executors.newFixedThreadPool(3);

    public static void a(Runnable runnable) {
        f25019a.execute(runnable);
    }
}
