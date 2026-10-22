package com.byazt.msj;

import com.byazt.bwm.i;
import com.byazt.nr.m;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1898, 15})
public class uj extends c {
    public uj(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory);
    }

    private boolean n() {
        BlockingQueue<Runnable> queue = getQueue();
        int corePoolSize = getCorePoolSize();
        int i = corePoolSize * 2;
        int iMin = Math.min(corePoolSize + 4, i.c);
        if (corePoolSize >= iMin || queue == null || queue.size() < i) {
            return false;
        }
        try {
            setCorePoolSize(iMin);
            return true;
        } catch (Exception e) {
            m.c("BizCoreThreadPool", e.getMessage());
            return false;
        }
    }

    private void uj() {
        BlockingQueue<Runnable> queue = getQueue();
        int iX = i.tt.x();
        if (getCorePoolSize() == iX || queue == null || queue.size() != 0) {
            return;
        }
        setCorePoolSize(iX);
    }

    public static boolean ve() {
        ThreadPoolExecutor threadPoolExecutorI = i.tt.i();
        if (threadPoolExecutorI.getQueue().size() != 0 || threadPoolExecutorI.isShutdown() || threadPoolExecutorI.isTerminated()) {
            return false;
        }
        int activeCount = threadPoolExecutorI.getActiveCount();
        int corePoolSize = threadPoolExecutorI.getCorePoolSize();
        return activeCount < corePoolSize + (-1) && com.byazt.mc.ve.c.get() < corePoolSize / 2;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void afterExecute(Runnable runnable, Throwable th) {
        super.afterExecute(runnable, th);
        if (i.uj) {
            uj();
        }
    }

    @Override // com.byazt.msj.c
    public void c(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        boolean zOffer;
        super.c(runnable, outOfMemoryError);
        boolean z = false;
        if (runnable != null) {
            try {
                zOffer = getQueue().offer(runnable);
            } catch (Throwable unused) {
                zOffer = z;
            }
        } else {
            zOffer = true;
            try {
                i.uj = false;
            } catch (Throwable unused2) {
                z = zOffer;
                zOffer = z;
            }
        }
        allowCoreThreadTimeOut(false);
        if (!zOffer) {
            throw outOfMemoryError;
        }
    }

    @Override // com.byazt.msj.c, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (i.uj) {
            n();
        }
        super.execute(runnable);
    }

    @Override // com.byazt.msj.c
    public int tt() {
        return 2;
    }

    @Override // com.byazt.msj.c
    public boolean c() {
        BlockingQueue<Runnable> queue = getQueue();
        return queue != null && queue.size() > getCorePoolSize() * 2;
    }
}
