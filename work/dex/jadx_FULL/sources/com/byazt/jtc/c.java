package com.byazt.jtc;

import com.byazt.bwm.i;
import com.byazt.mc.a;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 728, 20})
public class c extends ThreadPoolExecutor implements com.byazt.bwm.c {
    public static final RejectedExecutionHandler c = new RejectedExecutionHandler() { // from class: com.byazt.jtc.c.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            if (threadPoolExecutor != null && (threadPoolExecutor instanceof ScheduledThreadPoolExecutor) && threadPoolExecutor.getCorePoolSize() == 1) {
                i iVar = i.tt;
                ScheduledExecutorService scheduledExecutorServiceT = iVar.t();
                if (scheduledExecutorServiceT.isShutdown() || scheduledExecutorServiceT.isTerminated()) {
                    iVar.i().execute(runnable);
                } else {
                    scheduledExecutorServiceT.execute(runnable);
                }
            } else {
                i.tt.i().execute(runnable);
            }
            i.tt.sp();
        }
    };
    public com.byazt.bwm.c tt;

    public c(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory) {
        this(i, i2, j, timeUnit, blockingQueue, threadFactory, c);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public void allowCoreThreadTimeOut(boolean z) {
        this.tt.allowCoreThreadTimeOut(z);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public boolean allowsCoreThreadTimeOut() {
        return this.tt.allowsCoreThreadTimeOut();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.byazt.bwm.c
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return this.tt.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor, com.byazt.bwm.c
    public void execute(Runnable runnable) {
        this.tt.execute(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public int getActiveCount() {
        return this.tt.getActiveCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public long getCompletedTaskCount() {
        return this.tt.getCompletedTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public int getCorePoolSize() {
        return this.tt.getCorePoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public long getKeepAliveTime(TimeUnit timeUnit) {
        return this.tt.getKeepAliveTime(timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public int getLargestPoolSize() {
        return this.tt.getLargestPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public int getMaximumPoolSize() {
        return this.tt.getMaximumPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public int getPoolSize() {
        return this.tt.getPoolSize();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public BlockingQueue<Runnable> getQueue() {
        return this.tt.getQueue();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public RejectedExecutionHandler getRejectedExecutionHandler() {
        return this.tt.getRejectedExecutionHandler();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public long getTaskCount() {
        return this.tt.getTaskCount();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public ThreadFactory getThreadFactory() {
        return this.tt.getThreadFactory();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.byazt.bwm.c
    public boolean isShutdown() {
        return this.tt.isShutdown();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.byazt.bwm.c
    public boolean isTerminated() {
        return this.tt.isTerminated();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public boolean isTerminating() {
        return this.tt.isTerminating();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public int prestartAllCoreThreads() {
        return this.tt.prestartAllCoreThreads();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public boolean prestartCoreThread() {
        return this.tt.prestartCoreThread();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public void purge() {
        this.tt.purge();
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public boolean remove(Runnable runnable) {
        return this.tt.remove(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public void setCorePoolSize(int i) {
        this.tt.setCorePoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public void setKeepAliveTime(long j, TimeUnit timeUnit) {
        this.tt.setKeepAliveTime(j, timeUnit);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public void setMaximumPoolSize(int i) {
        this.tt.setMaximumPoolSize(i);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public void setRejectedExecutionHandler(RejectedExecutionHandler rejectedExecutionHandler) {
        this.tt.setRejectedExecutionHandler(rejectedExecutionHandler);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public void setThreadFactory(ThreadFactory threadFactory) {
        threadFactory.getClass();
        this.tt.setThreadFactory(threadFactory);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.byazt.bwm.c
    public void shutdown() {
        com.byazt.bwm.c cVar = this.tt;
        if (cVar != null) {
            cVar.shutdown();
        }
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.ExecutorService, com.byazt.bwm.c
    public List<Runnable> shutdownNow() {
        return this.tt.shutdownNow();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.bwm.c
    public Future<?> submit(Runnable runnable) {
        return this.tt.submit(runnable);
    }

    @Override // java.util.concurrent.ThreadPoolExecutor, com.byazt.bwm.c
    public String toString() {
        com.byazt.bwm.c cVar = this.tt;
        return cVar != null ? cVar.toString() : super.toString();
    }

    public c(int i, int i2, long j, TimeUnit timeUnit, BlockingQueue<Runnable> blockingQueue, ThreadFactory threadFactory, RejectedExecutionHandler rejectedExecutionHandler) {
        super(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler);
        this.tt = new a(i, i2, j, timeUnit, blockingQueue, threadFactory, rejectedExecutionHandler, this);
        i.tt.sp();
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.bwm.c
    public <T> Future<T> submit(Callable<T> callable) {
        return this.tt.submit(callable);
    }

    @Override // java.util.concurrent.AbstractExecutorService, java.util.concurrent.ExecutorService, com.byazt.bwm.c
    public <T> Future<T> submit(Runnable runnable, T t) {
        return this.tt.submit(runnable, t);
    }
}
