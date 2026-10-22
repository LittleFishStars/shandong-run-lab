package com.baidu.location.b;

import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ExecutorService f26400a;
    private ExecutorService b;

    public static class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static x f26401a = new x();
    }

    private x() {
        this.f26400a = null;
        this.b = null;
    }

    public static x a() {
        return a.f26401a;
    }

    public synchronized ExecutorService b() {
        return this.f26400a;
    }

    public synchronized ExecutorService c() {
        return this.b;
    }

    public void d() {
        ExecutorService executorService = this.f26400a;
        if (executorService != null) {
            executorService.shutdown();
        }
        ExecutorService executorService2 = this.b;
        if (executorService2 != null) {
            executorService2.shutdown();
        }
    }
}
