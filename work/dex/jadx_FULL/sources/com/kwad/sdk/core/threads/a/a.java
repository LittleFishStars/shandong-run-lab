package com.kwad.sdk.core.threads.a;

import android.os.SystemClock;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a extends ScheduledThreadPoolExecutor implements c {
    public static volatile boolean aYQ = false;
    private final ConcurrentHashMap<Runnable, Long> aYR;
    private long aYS;
    private int aYT;

    public a(int i, ThreadFactory threadFactory) {
        super(1, threadFactory);
        this.aYR = new ConcurrentHashMap<>();
        this.aYS = 0L;
        this.aYT = 0;
    }

    @Override // com.kwad.sdk.core.threads.a.c
    public final long Ou() {
        return this.aYS;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public final void beforeExecute(Thread thread, Runnable runnable) {
        super.beforeExecute(thread, runnable);
        if (aYQ && this.aYR.containsKey(runnable) && this.aYR.get(runnable) != null) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() - this.aYR.get(runnable).longValue();
            if (jElapsedRealtime >= 0 && jElapsedRealtime < 1800000) {
                long j = this.aYS;
                int i = this.aYT;
                this.aYS = ((j * ((long) i)) + jElapsedRealtime) / ((long) (i + 1));
                this.aYT = i + 1;
            }
            this.aYR.remove(runnable);
        }
    }

    @Override // java.util.concurrent.ScheduledThreadPoolExecutor, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public final void execute(Runnable runnable) {
        if (aYQ) {
            this.aYR.put(runnable, Long.valueOf(SystemClock.elapsedRealtime()));
        }
        super.execute(runnable);
    }
}
