package com.byazt.mc;

import com.byazt.bwm.i;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1001, 34})
public class a implements com.byazt.bwm.c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile ThreadFactory f28785a;
    public final AtomicInteger c = new AtomicInteger(c(-536870912, 0));
    public final ThreadPoolExecutor da;
    public volatile int i;
    public int n;
    public boolean sl;
    public volatile RejectedExecutionHandler sp;
    public volatile int t;
    public final BlockingQueue<Runnable> tt;
    public ThreadPoolExecutor u;
    public final Condition uj;
    public final ReentrantLock ve;
    public volatile long x;

    public a(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler, ThreadPoolExecutor threadPoolExecutor) {
        ReentrantLock reentrantLock = new ReentrantLock();
        this.ve = reentrantLock;
        this.uj = reentrantLock.newCondition();
        if (i < 0 || i2 <= 0 || i2 < i || j < 0) {
            throw new IllegalArgumentException();
        }
        if (blockingQueue == null || threadFactory == null || rejectedExecutionHandler == null) {
            throw null;
        }
        this.i = i;
        this.t = i2;
        this.tt = blockingQueue;
        this.x = timeUnit.toNanos(j);
        this.f28785a = threadFactory;
        this.sp = rejectedExecutionHandler;
        this.da = threadPoolExecutor;
    }

    private boolean a(int i) {
        if (i == 1) {
            return true;
        }
        if (i == 2) {
            return com.byazt.msj.uj.ve();
        }
        return false;
    }

    private static int c(int i) {
        return i & (-536870912);
    }

    private static int c(int i, int i2) {
        return i | i2;
    }

    private void n(int i) {
        int i2;
        do {
            i2 = this.c.get();
            if (ve(i2, i)) {
                return;
            }
        } while (!this.c.compareAndSet(i2, c(i, tt(i2))));
    }

    private static int tt(int i) {
        return i & 536870911;
    }

    private static boolean tt(int i, int i2) {
        return i < i2;
    }

    private boolean uj(int i) {
        return this.c.compareAndSet(i, i + 1);
    }

    private void ve() {
        while (true) {
            int i = this.c.get();
            if (this.c.compareAndSet(i, i - 1)) {
                return;
            } else {
                Thread.yield();
            }
        }
    }

    private static boolean ve(int i) {
        return i < 0;
    }

    private static boolean ve(int i, int i2) {
        return i >= i2;
    }

    @Override // com.byazt.bwm.c
    public void allowCoreThreadTimeOut(boolean z) {
        this.sl = true;
    }

    @Override // com.byazt.bwm.c
    public boolean allowsCoreThreadTimeOut() {
        return this.sl;
    }

    @Override // com.byazt.bwm.c, java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        long nanos = timeUnit.toNanos(j);
        ReentrantLock reentrantLock = this.ve;
        reentrantLock.lock();
        while (!ve(this.c.get(), 1610612736)) {
            try {
                if (nanos <= 0) {
                    reentrantLock.unlock();
                    return false;
                }
                nanos = this.uj.awaitNanos(nanos);
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
        reentrantLock.unlock();
        return true;
    }

    public ThreadPoolExecutor c() {
        if (this.u == null) {
            this.u = i.tt.da();
        }
        return this.u;
    }

    @Override // com.byazt.bwm.c, java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        ve veVar;
        if (runnable == null) {
            return;
        }
        if (runnable instanceof ve) {
            veVar = (ve) runnable;
            veVar.c(this);
        } else {
            veVar = new ve(runnable, this);
        }
        c(veVar);
    }

    public void finalize() {
        shutdown();
        try {
            super.finalize();
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }

    @Override // com.byazt.bwm.c
    public int getActiveCount() {
        return tt(this.c.get());
    }

    @Override // com.byazt.bwm.c
    public long getCompletedTaskCount() {
        return 0L;
    }

    @Override // com.byazt.bwm.c
    public int getCorePoolSize() {
        return this.i;
    }

    @Override // com.byazt.bwm.c
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return timeUnit.convert(this.x, TimeUnit.NANOSECONDS);
    }

    @Override // com.byazt.bwm.c
    public int getLargestPoolSize() {
        return 0;
    }

    @Override // com.byazt.bwm.c
    public int getMaximumPoolSize() {
        return this.t;
    }

    @Override // com.byazt.bwm.c
    public int getPoolSize() {
        if (ve(this.c.get(), 1073741824)) {
            return 0;
        }
        return tt(this.c.get());
    }

    @Override // com.byazt.bwm.c
    public BlockingQueue<Runnable> getQueue() {
        return this.tt;
    }

    @Override // com.byazt.bwm.c
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.sp;
    }

    @Override // com.byazt.bwm.c
    public long getTaskCount() {
        return 0L;
    }

    @Override // com.byazt.bwm.c
    public ThreadFactory getThreadFactory() {
        return this.f28785a;
    }

    @Override // com.byazt.bwm.c, java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return !ve(this.c.get());
    }

    @Override // com.byazt.bwm.c, java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return ve(this.c.get(), 1610612736);
    }

    @Override // com.byazt.bwm.c
    public boolean isTerminating() {
        int i = this.c.get();
        return !ve(i) && tt(i, 1610612736);
    }

    @Override // com.byazt.bwm.c
    public int prestartAllCoreThreads() {
        return 0;
    }

    @Override // com.byazt.bwm.c
    public boolean prestartCoreThread() {
        return false;
    }

    @Override // com.byazt.bwm.c
    public void purge() {
        BlockingQueue<Runnable> blockingQueue = this.tt;
        try {
            Iterator<Runnable> it = blockingQueue.iterator();
            while (it.hasNext()) {
                Runnable next = it.next();
                if ((next instanceof Future) && ((Future) next).isCancelled()) {
                    it.remove();
                }
            }
        } catch (ConcurrentModificationException unused) {
            for (Object obj : blockingQueue.toArray()) {
                if ((obj instanceof Future) && ((Future) obj).isCancelled()) {
                    blockingQueue.remove(obj);
                }
            }
        }
        tt();
    }

    @Override // com.byazt.bwm.c
    public boolean remove(Runnable runnable) {
        boolean zRemove = this.tt.remove(runnable);
        tt();
        return zRemove;
    }

    @Override // com.byazt.bwm.c
    public void setCorePoolSize(int i) {
    }

    @Override // com.byazt.bwm.c
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        if (j < 0) {
            throw new IllegalArgumentException();
        }
        if (j == 0 && allowsCoreThreadTimeOut()) {
            throw new IllegalArgumentException("Core threads must have nonzero keep alive times");
        }
        this.x = timeUnit.toNanos(j);
    }

    @Override // com.byazt.bwm.c
    public void setMaximumPoolSize(int i) {
        if (i <= 0 || i < this.i) {
            throw new IllegalArgumentException();
        }
        this.t = i;
        this.c.get();
    }

    @Override // com.byazt.bwm.c
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        rejectedExecutionHandler.getClass();
        this.sp = rejectedExecutionHandler;
    }

    @Override // com.byazt.bwm.c
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.f28785a = threadFactory;
    }

    @Override // com.byazt.bwm.c, java.util.concurrent.ExecutorService
    public void shutdown() {
        ReentrantLock reentrantLock = this.ve;
        reentrantLock.lock();
        try {
            n(0);
            reentrantLock.unlock();
            tt();
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.byazt.bwm.c, java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        ReentrantLock reentrantLock = this.ve;
        reentrantLock.lock();
        try {
            n(536870912);
            List<Runnable> listUj = uj();
            reentrantLock.unlock();
            tt();
            return listUj;
        } catch (Throwable th) {
            reentrantLock.unlock();
            throw th;
        }
    }

    @Override // com.byazt.bwm.c, java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, null);
        execute(futureTask);
        return futureTask;
    }

    @Override // com.byazt.bwm.c
    public String toString() {
        String str;
        int i = this.c.get();
        if (tt(i, 0)) {
            str = "Running";
        } else {
            str = ve(i, 1610612736) ? "Terminated" : "Shutting down";
        }
        return getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + "[" + str + ", runnable name = , core size = " + this.i + ", max size = " + this.t + ", worker count = " + tt(i) + ", queued tasks = " + this.tt.size() + "]";
    }

    public final void tt() {
        while (true) {
            int i = this.c.get();
            if (ve(i) || ve(i, 1073741824)) {
                return;
            }
            if ((c(i) == 0 && !this.tt.isEmpty()) || tt(i) != 0) {
                return;
            }
            ReentrantLock reentrantLock = this.ve;
            reentrantLock.lock();
            try {
                if (this.c.compareAndSet(i, c(1073741824, 0))) {
                    this.c.set(c(1610612736, 0));
                    this.uj.signalAll();
                    reentrantLock.unlock();
                    return;
                }
                reentrantLock.unlock();
            } catch (Throwable th) {
                reentrantLock.unlock();
                throw th;
            }
        }
    }

    private List<Runnable> uj() {
        BlockingQueue<Runnable> blockingQueue = this.tt;
        ArrayList arrayList = new ArrayList();
        blockingQueue.drainTo(arrayList);
        if (!blockingQueue.isEmpty()) {
            for (Runnable runnable : (Runnable[]) blockingQueue.toArray(new Runnable[0])) {
                if (blockingQueue.remove(runnable)) {
                    if (runnable instanceof ve) {
                        arrayList.add(((ve) runnable).ve);
                    } else {
                        arrayList.add(runnable);
                    }
                }
            }
        }
        return arrayList;
    }

    @Override // com.byazt.bwm.c, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        if (callable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(callable);
        execute(futureTask);
        return futureTask;
    }

    private void n() {
        ReentrantLock reentrantLock = this.ve;
        reentrantLock.lock();
        try {
            ve();
            tt();
        } finally {
            reentrantLock.unlock();
        }
    }

    public final void c(Runnable runnable) {
        this.sp.rejectedExecution(runnable, this.da);
    }

    private void c(ve veVar) {
        int i = this.c.get();
        if (tt(i) < this.i) {
            if (tt((Runnable) veVar, true)) {
                i.tt.sp();
                return;
            }
            i = this.c.get();
        }
        if (tt(i) == 0) {
            if (tt((Runnable) veVar, false)) {
                i.tt.sp();
                return;
            }
            i = this.c.get();
        }
        if (ve(i) && this.tt.offer(veVar)) {
            if (!ve(this.c.get()) && remove(veVar)) {
                c(veVar.c());
                i.tt.sp();
                return;
            } else {
                i.tt.sp();
                return;
            }
        }
        if (tt(i) < this.t && tt((Runnable) veVar, false)) {
            i.tt.sp();
        } else {
            c(veVar.c());
            i.tt.sp();
        }
    }

    @Override // com.byazt.bwm.c, java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        if (runnable == null) {
            return null;
        }
        FutureTask futureTask = new FutureTask(runnable, t);
        execute(futureTask);
        return futureTask;
    }

    private boolean tt(Runnable runnable, boolean z) {
        while (true) {
            int i = this.c.get();
            int iC = c(i);
            boolean z2 = false;
            if (iC >= 0 && (iC != 0 || runnable != null || this.tt.isEmpty())) {
                break;
            }
            do {
                int iTt = tt(i);
                if (iTt < 536870911) {
                    if (iTt < (z ? this.i : this.t)) {
                        if (!uj(i)) {
                            i = this.c.get();
                        } else {
                            try {
                                ReentrantLock reentrantLock = this.ve;
                                reentrantLock.lock();
                                try {
                                    int iC2 = c(this.c.get());
                                    if (iC2 < 0 || (iC2 == 0 && runnable == null)) {
                                        c().execute(runnable);
                                        int iTt2 = tt(this.c.get());
                                        if (iTt2 > this.n) {
                                            this.n = iTt2;
                                        }
                                        z2 = true;
                                    }
                                    reentrantLock.unlock();
                                    if (!z2) {
                                        n();
                                    }
                                    return z2;
                                } catch (Throwable th) {
                                    reentrantLock.unlock();
                                    throw th;
                                }
                            } catch (Throwable th2) {
                                n();
                                throw th2;
                            }
                        }
                    }
                }
                return false;
            } while (c(i) == iC);
        }
        return false;
    }

    public void c(Runnable runnable, boolean z) {
        int i = this.c.get();
        int iTt = tt(runnable);
        if (tt(i, 536870912)) {
            do {
                Runnable runnablePoll = this.tt.poll();
                if (runnablePoll != null) {
                    if (a(iTt) && (runnablePoll instanceof ve)) {
                        ve veVar = (ve) runnablePoll;
                        veVar.tt();
                        veVar.c(iTt);
                        veVar.c((a) null);
                        runnablePoll.run();
                    } else {
                        c().execute(runnablePoll);
                        return;
                    }
                } else {
                    ve();
                    return;
                }
            } while (tt(i, 536870912));
            tt();
            return;
        }
        tt();
    }

    private int tt(Runnable runnable) {
        if (runnable instanceof ve) {
            return ((ve) runnable).uj();
        }
        return 0;
    }
}
