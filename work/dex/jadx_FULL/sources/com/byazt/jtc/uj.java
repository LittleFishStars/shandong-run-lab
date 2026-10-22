package com.byazt.jtc;

import com.byazt.bwm.i;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 728, 15})
public class uj extends c {
    public uj(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        super(i, i2, j, timeUnit, new com.byazt.mc.c(blockingQueue), new com.byazt.mc.uj(threadFactory, 2));
        c();
    }

    private void c() {
        if (i.tt.n()) {
            if (!allowsCoreThreadTimeOut()) {
                setKeepAliveTime(c(20L), TimeUnit.SECONDS);
                try {
                    super.allowCoreThreadTimeOut(true);
                } catch (Throwable unused) {
                }
            }
            com.byazt.bwm.ve.c.c(this);
        }
    }

    private ExecutorService tt() {
        com.byazt.bwm.ve veVar = com.byazt.bwm.ve.c;
        return veVar.c("PThreadPoolExecutor", veVar.c(getQueue()));
    }

    @Override // com.byazt.jtc.c, java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public void allowCoreThreadTimeOut(boolean z) {
    }

    @Override // com.byazt.jtc.c, java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.byazt.bwm.c
    public void execute(Runnable runnable) {
        if (!i.tt.n()) {
            super.execute(runnable);
            return;
        }
        try {
            super.execute(runnable);
        } catch (OutOfMemoryError e) {
            ExecutorService executorServiceTt = tt();
            if (executorServiceTt == null) {
                throw e;
            }
            executorServiceTt.execute(runnable);
        }
    }

    @Override // com.byazt.jtc.c, java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public void setThreadFactory(ThreadFactory threadFactory) {
        super.setThreadFactory(new com.byazt.mc.uj(threadFactory, 2));
    }

    @Override // com.byazt.jtc.c, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.bwm.c
    public <T> Future<T> submit(Callable<T> callable) {
        if (!i.tt.n()) {
            return super.submit(callable);
        }
        try {
            return super.submit(callable);
        } catch (OutOfMemoryError e) {
            ExecutorService executorServiceTt = tt();
            if (executorServiceTt != null) {
                return executorServiceTt.submit(callable);
            }
            throw e;
        }
    }

    public uj(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, new com.byazt.mc.c(blockingQueue), new com.byazt.mc.uj(threadFactory, 2), rejectedExecutionHandler);
        c();
    }

    private long c(long j) {
        long jMin = Math.min(j, getKeepAliveTime(TimeUnit.SECONDS));
        if (jMin > 1) {
            return jMin;
        }
        return 1L;
    }

    @Override // com.byazt.jtc.c, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.bwm.c
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (i.tt.n()) {
            try {
                return super.submit(runnable, t);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceTt = tt();
                if (executorServiceTt != null) {
                    return executorServiceTt.submit(runnable, t);
                }
                throw e;
            }
        }
        return super.submit(runnable, t);
    }

    @Override // com.byazt.jtc.c, java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.bwm.c
    public Future submit(Runnable runnable) {
        if (i.tt.n()) {
            try {
                return super.submit(runnable);
            } catch (OutOfMemoryError e) {
                ExecutorService executorServiceTt = tt();
                if (executorServiceTt != null) {
                    return executorServiceTt.submit(runnable);
                }
                throw e;
            }
        }
        return super.submit(runnable);
    }
}
