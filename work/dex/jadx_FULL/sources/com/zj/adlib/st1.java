package com.zj.adlib;

import java.util.List;
import java.util.concurrent.AbstractExecutorService;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class st1 extends AbstractExecutorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?> f44771a = st1.class;
    public volatile int K;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f19646a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final BlockingQueue<Runnable> f19647a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f19648a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AtomicInteger f19649a;
    public final AtomicInteger b;
    public final String f;

    public class b implements Runnable {
        public b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                Runnable runnable = (Runnable) st1.this.f19647a.poll();
                if (runnable != null) {
                    runnable.run();
                } else {
                    ad3.V(st1.f44771a, "%s: Worker has nothing to run", st1.this.f);
                }
            } finally {
                int iDecrementAndGet = st1.this.f19649a.decrementAndGet();
                if (st1.this.f19647a.isEmpty()) {
                    ad3.W(st1.f44771a, "%s: worker finished; %d workers left", st1.this.f, Integer.valueOf(iDecrementAndGet));
                } else {
                    st1.this.i();
                }
            }
        }
    }

    public st1(String str, int i, Executor executor, BlockingQueue<Runnable> blockingQueue) {
        if (i <= 0) {
            throw new IllegalArgumentException("max concurrency must be > 0");
        }
        this.f = str;
        this.f19648a = executor;
        this.K = i;
        this.f19647a = blockingQueue;
        this.f19646a = new b();
        this.f19649a = new AtomicInteger(0);
        this.b = new AtomicInteger(0);
    }

    public static st1 g(String str, int i, int i2, Executor executor) {
        return new st1(str, i, executor, new LinkedBlockingQueue(i2));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.Executor
    public void execute(Runnable runnable) {
        if (runnable == null) {
            throw new NullPointerException("runnable parameter is null");
        }
        if (!this.f19647a.offer(runnable)) {
            throw new RejectedExecutionException(this.f + " queue is full, size=" + this.f19647a.size());
        }
        int size = this.f19647a.size();
        int i = this.b.get();
        if (size > i && this.b.compareAndSet(i, size)) {
            ad3.W(f44771a, "%s: max pending work in queue = %d", this.f, Integer.valueOf(size));
        }
        i();
    }

    public boolean f() {
        return this.f19647a.isEmpty() && this.f19649a.get() == 0;
    }

    public final void i() {
        int i = this.f19649a.get();
        while (i < this.K) {
            int i2 = i + 1;
            if (this.f19649a.compareAndSet(i, i2)) {
                ad3.X(f44771a, "%s: starting worker %d of %d", this.f, Integer.valueOf(i2), Integer.valueOf(this.K));
                this.f19648a.execute(this.f19646a);
                return;
            } else {
                ad3.V(f44771a, "%s: race in startWorkerIfNeeded; retrying", this.f);
                i = this.f19649a.get();
            }
        }
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return false;
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.concurrent.ExecutorService
    public List<Runnable> shutdownNow() {
        throw new UnsupportedOperationException();
    }
}
