package com.zj.adlib;

import android.annotation.SuppressLint;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class y50 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45957a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final long f20779a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final y50 f20780a = new y50();
    public static final int b;
    public static final int c;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f20781a;

    public static class b implements Executor {
        public b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f45957a = iAvailableProcessors;
        b = iAvailableProcessors + 1;
        c = (iAvailableProcessors * 2) + 1;
    }

    @SuppressLint({"NewApi"})
    public static void a(ThreadPoolExecutor threadPoolExecutor, boolean z) {
        threadPoolExecutor.allowCoreThreadTimeOut(z);
    }

    public static ExecutorService b() {
    }

    public static ExecutorService c(ThreadFactory threadFactory) {
    }

    public static Executor d() {
        return f20780a.f20781a;
    }
}
