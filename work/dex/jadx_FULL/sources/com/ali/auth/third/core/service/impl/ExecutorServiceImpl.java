package com.ali.auth.third.core.service.impl;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import com.ali.auth.third.core.service.MemberExecutorService;
import com.ali.auth.third.core.trace.SDKLogger;
import java.lang.reflect.Field;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class ExecutorServiceImpl implements MemberExecutorService {
    public static ThreadPoolExecutor mExecutor;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Handler f23432a = new Handler(Looper.getMainLooper());
    private final BlockingQueue<Runnable> b = new LinkedBlockingQueue(128);
    private final HandlerThread c;
    private final Handler d;

    public class a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final AtomicInteger f23433a = new AtomicInteger(1);

        public a(ExecutorServiceImpl executorServiceImpl) {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, "ExecutorTask #" + this.f23433a.getAndIncrement());
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Runnable f23434a;

        public b(ExecutorServiceImpl executorServiceImpl, Runnable runnable) {
            this.f23434a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                this.f23434a.run();
            } catch (Throwable th) {
                SDKLogger.e("kernel", th.getMessage(), th);
            }
        }
    }

    public static class c implements RejectedExecutionHandler {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private BlockingQueue<Runnable> f23435a;

        public c(BlockingQueue<Runnable> blockingQueue) {
            this.f23435a = blockingQueue;
        }

        private Object a(Object obj) {
            try {
                Field declaredField = obj.getClass().getDeclaredField("this$0");
                declaredField.setAccessible(true);
                return declaredField.get(obj);
            } catch (Exception e) {
                e.printStackTrace();
                return obj;
            }
        }

        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
            Object[] array = this.f23435a.toArray();
            StringBuilder sb = new StringBuilder();
            sb.append('[');
            for (Object obj : array) {
                sb.append(obj.getClass().isAnonymousClass() ? a(obj) : obj.getClass());
                sb.append(',');
                sb.append(' ');
            }
            sb.append(']');
            throw new RejectedExecutionException("Task " + runnable.toString() + " rejected from " + threadPoolExecutor.toString() + " in " + sb.toString());
        }
    }

    public ExecutorServiceImpl() {
        HandlerThread handlerThread = new HandlerThread("SDK Looper Thread");
        this.c = handlerThread;
        handlerThread.start();
        synchronized (handlerThread) {
            while (this.c.getLooper() == null) {
                try {
                    this.c.wait();
                } catch (InterruptedException unused) {
                }
            }
        }
        this.d = new Handler(this.c.getLooper());
        a aVar = new a(this);
        TimeUnit timeUnit = TimeUnit.SECONDS;
        BlockingQueue<Runnable> blockingQueue = this.b;
        mExecutor = new ThreadPoolExecutor(8, 16, 1, timeUnit, blockingQueue, aVar, new c(blockingQueue));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        return mExecutor.awaitTermination(j, timeUnit);
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        mExecutor.execute(runnable);
    }

    @Override // com.ali.auth.third.core.service.MemberExecutorService
    public Looper getDefaultLooper() {
        return this.c.getLooper();
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection) throws InterruptedException {
        return mExecutor.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> List<Future<T>> invokeAll(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws InterruptedException {
        return mExecutor.invokeAll(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) mExecutor.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(Collection<? extends Callable<T>> collection, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) mExecutor.invokeAny(collection, j, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return mExecutor.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return mExecutor.isTerminated();
    }

    @Override // com.ali.auth.third.core.service.MemberExecutorService
    public void postHandlerTask(Runnable runnable) {
        this.d.post(runnable);
    }

    @Override // com.ali.auth.third.core.service.MemberExecutorService
    public void postTask(Runnable runnable) {
        mExecutor.execute(runnable);
    }

    @Override // com.ali.auth.third.core.service.MemberExecutorService
    public void postUITask(Runnable runnable) {
        this.f23432a.post(new b(this, runnable));
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        mExecutor.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        return mExecutor.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    public Future<?> submit(Runnable runnable) {
        return mExecutor.submit(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Runnable runnable, T t) {
        return mExecutor.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(Callable<T> callable) {
        return mExecutor.submit(callable);
    }
}
