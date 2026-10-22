package com.zj.adlib;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_13_8952cls.dex */
public final class cz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final cz0 f41069a = new cz0();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f15906a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ExecutorService f15907a;

    public static class b implements Executor {
        public static final int K = 15;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ThreadLocal<Integer> f41070a;

        public b() {
        }

        public final int a() {
        }

        public final int b() {
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
        }
    }

    public static ExecutorService a() {
        return f41069a.f15907a;
    }

    public static Executor b() {
        return f41069a.f15906a;
    }

    public static boolean c() {
    }
}
