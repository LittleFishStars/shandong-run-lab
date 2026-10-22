package com.beizi.fusion;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class bn implements fb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f27111a;
    private final int b;
    private final ExecutorService c;
    private final ExecutorService d;
    private final ExecutorService e;
    private final ExecutorService f;
    private final ExecutorService g;
    private final ExecutorService h;
    private final ScheduledExecutorService i;
    private final ScheduledExecutorService j;

    public bn() {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        this.f27111a = iAvailableProcessors;
        int iMax = Math.max((iAvailableProcessors / 2) + 1, 4);
        this.b = iMax;
        TimeUnit timeUnit = TimeUnit.SECONDS;
        this.c = new ThreadPoolExecutor(2, 8, 5L, timeUnit, new LinkedBlockingQueue(), new an(5, "T_request"));
        this.d = new ThreadPoolExecutor(2, 8, 5L, timeUnit, new LinkedBlockingQueue(), new an(5, "T_basic"));
        this.h = new ThreadPoolExecutor(2, iMax, 5L, timeUnit, new LinkedBlockingQueue(), new an(5, "T_cache"));
        this.e = Executors.newFixedThreadPool(2, new an(5, "T_init"));
        this.f = new ThreadPoolExecutor(2, iMax, 5L, timeUnit, new LinkedBlockingQueue(), new an(5, "T_local"));
        this.g = new ThreadPoolExecutor(4, iMax, 5L, timeUnit, new LinkedBlockingQueue(), new an(5, "T_analyse"));
        this.i = Executors.newScheduledThreadPool(4, new an(5, "T_basic"));
        this.j = Executors.newScheduledThreadPool(4, new an(5, "T_cache"));
    }

    @Override // com.beizi.fusion.fb
    public void a(Runnable runnable) {
        this.f.execute(runnable);
    }

    @Override // com.beizi.fusion.fb
    public void b(Runnable runnable) {
        this.c.execute(runnable);
    }

    @Override // com.beizi.fusion.fb
    public void c(Runnable runnable) {
        this.h.execute(runnable);
    }

    @Override // com.beizi.fusion.fb
    public void d(Runnable runnable) {
        this.g.execute(runnable);
    }

    @Override // com.beizi.fusion.fb
    public void e(Runnable runnable) {
        this.e.execute(runnable);
    }

    @Override // com.beizi.fusion.fb
    public void f(Runnable runnable) {
        this.d.execute(runnable);
    }

    @Override // com.beizi.fusion.fb
    public void a(Runnable runnable, long j, TimeUnit timeUnit) {
        this.i.schedule(runnable, j, timeUnit);
    }

    public ScheduledExecutorService b() {
        return Executors.newSingleThreadScheduledExecutor(new an(5, "T_basic"));
    }

    public ScheduledExecutorService c() {
        return this.i;
    }

    public ScheduledExecutorService a() {
        return this.j;
    }
}
