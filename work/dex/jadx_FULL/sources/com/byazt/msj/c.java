package com.byazt.msj;

import com.byazt.bwm.i;
import com.byazt.nr.m;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1898, 20})
public abstract class c extends ThreadPoolExecutor {
    public c(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, com.byazt.jtc.c.c);
    }

    private void c(Runnable runnable) {
        try {
            com.byazt.mc.ve veVar = runnable instanceof com.byazt.mc.ve ? (com.byazt.mc.ve) runnable : new com.byazt.mc.ve(runnable);
            veVar.tt();
            i iVar = i.tt;
            if (iVar.yp()) {
                if (!(getCorePoolSize() > getActiveCount() && getQueue().size() <= 0)) {
                    m.tt("BaseThreadPool", "crashing drop task :".concat(String.valueOf(runnable)));
                    veVar.c(3);
                    iVar.t().submit(veVar);
                    return;
                }
            }
            veVar.c(tt());
            super.execute(veVar);
        } catch (InternalError e) {
            m.ve("BaseThreadPool", "InternalError", e);
        } catch (OutOfMemoryError e2) {
            if (i.tt.tt()) {
                i.uj = false;
            }
            c(runnable, e2);
        }
    }

    public boolean c() {
        return false;
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        c(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor
    public void setCorePoolSize(int i) {
        try {
            super.setCorePoolSize(i);
        } catch (Exception e) {
            m.c("BaseThreadPool", e.getMessage());
        } catch (OutOfMemoryError e2) {
            c(null, e2);
        }
    }

    public int tt() {
        return 0;
    }

    public c(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
    }

    public void c(Runnable runnable, OutOfMemoryError outOfMemoryError) {
        com.byazt.mc.ve.tt = true;
    }
}
