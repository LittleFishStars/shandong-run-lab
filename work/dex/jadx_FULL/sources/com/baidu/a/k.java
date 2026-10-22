package com.baidu.a;

import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile k f26253a;
    private final Executor b = new ThreadPoolExecutor(5, 25, 20, TimeUnit.SECONDS, new LinkedBlockingDeque(50));

    private k() {
    }

    public static k a() {
        if (f26253a == null) {
            synchronized (k.class) {
                if (f26253a == null) {
                    f26253a = new k();
                }
            }
        }
        return f26253a;
    }

    public Executor b() {
        return this.b;
    }
}
