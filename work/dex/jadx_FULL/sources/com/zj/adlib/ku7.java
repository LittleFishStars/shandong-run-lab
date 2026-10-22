package com.zj.adlib;

import java.util.concurrent.Executor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ku7 implements Executor {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Executor f42913a;

    public static class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Runnable f42914a;

        public a(Runnable runnable) {
            this.f42914a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f42914a.run();
            } catch (Exception e) {
                h25.e("Executor", "Background execution failure.", e);
            }
        }
    }

    public ku7(Executor executor) {
        this.f42913a = executor;
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        this.f42913a.execute(new a(runnable));
    }
}
