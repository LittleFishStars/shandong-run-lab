package com.alibaba.triver.impl;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.NonNull;
import com.alibaba.ariver.kernel.common.service.executor.ExecutorType;
import com.alibaba.ariver.kernel.common.service.executor.RVExecutorService;
import com.alibaba.ariver.kernel.common.service.executor.RVScheduleType;
import com.alibaba.ariver.kernel.common.utils.ExecutorUtils;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class TriverExecutorService implements RVExecutorService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int f24969a;
    private static final int b;
    private static final int c = 2;
    private static final int d;
    private static final int e = 30;
    private static final ThreadFactory n;
    private static final ThreadFactory o;
    private ScheduledThreadPoolExecutor f;
    private Executor i;
    private Executor j;
    private final BlockingQueue<Runnable> g = new PriorityBlockingQueue(256);
    private final BlockingQueue<Runnable> h = new PriorityBlockingQueue(128);
    private Handler k = new Handler(Looper.getMainLooper());
    private Executor l = new Executor() { // from class: com.alibaba.triver.impl.TriverExecutorService.1
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            runnable.run();
        }
    };
    private Executor m = new Executor() { // from class: com.alibaba.triver.impl.TriverExecutorService.2
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            TriverExecutorService.this.k.post(runnable);
        }
    };

    public static class a implements Comparable<a>, Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private ExecutorType f24975a;
        private Runnable b;

        public a(Runnable runnable, ExecutorType executorType) {
            this.f24975a = executorType;
            this.b = runnable;
        }

        public ExecutorType a() {
            return this.f24975a;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.b.run();
        }

        @Override // java.lang.Comparable
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compareTo(a aVar) {
            ExecutorType executorType = this.f24975a;
            if (executorType == null) {
                return -1;
            }
            ExecutorType executorType2 = aVar.f24975a;
            if (executorType2 == null) {
                return 1;
            }
            if (executorType.equals(executorType2)) {
                return 0;
            }
            return this.f24975a.ordinal() - aVar.f24975a.ordinal();
        }
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        f24969a = iAvailableProcessors;
        b = Math.max(2, Math.min(iAvailableProcessors - 1, 4));
        d = (iAvailableProcessors * 2) + 1;
        n = new ThreadFactory() { // from class: com.alibaba.triver.impl.TriverExecutorService.4

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final AtomicInteger f24973a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "Triver #" + this.f24973a.getAndIncrement());
            }
        };
        o = new ThreadFactory() { // from class: com.alibaba.triver.impl.TriverExecutorService.5

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            private final AtomicInteger f24974a = new AtomicInteger(1);

            @Override // java.util.concurrent.ThreadFactory
            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "Triver ##" + this.f24974a.getAndIncrement());
            }
        };
    }

    @Override // com.alibaba.ariver.kernel.common.service.executor.RVExecutorService
    public String getCurrentScheduleType() {
        return ExecutorUtils.isMainThread() ? RVScheduleType.UI : RVScheduleType.UNKNOW;
    }

    @Override // com.alibaba.ariver.kernel.common.service.executor.RVExecutorService
    public Executor getExecutor(final ExecutorType executorType) {
        final Executor executor;
        if (executorType == ExecutorType.UI) {
            return this.m;
        }
        if (executorType == ExecutorType.SYNC) {
            return this.l;
        }
        if (executorType == ExecutorType.NORMAL || executorType == ExecutorType.IDLE) {
            if (this.j == null) {
                synchronized (this) {
                    if (this.j == null) {
                        int i = d / 2;
                        this.j = new ThreadPoolExecutor(2, i < 2 ? 2 : i, 30L, TimeUnit.SECONDS, this.h, o);
                    }
                }
            }
            executor = this.j;
        } else {
            if (this.i == null) {
                synchronized (this) {
                    if (this.i == null) {
                        int i2 = b;
                        int i3 = d;
                        this.i = new ThreadPoolExecutor(i2, i3 < i2 ? i2 : i3, 30L, TimeUnit.SECONDS, this.g, n);
                    }
                }
            }
            executor = this.i;
        }
        return new Executor() { // from class: com.alibaba.triver.impl.TriverExecutorService.3
            @Override // java.util.concurrent.Executor
            public void execute(@NonNull Runnable runnable) {
                executor.execute(new a(runnable, executorType));
            }
        };
    }

    @Override // com.alibaba.ariver.kernel.common.service.executor.RVExecutorService
    public ScheduledThreadPoolExecutor getScheduledExecutor() {
        if (this.f == null) {
            synchronized (this) {
                if (this.f == null) {
                    this.f = new ScheduledThreadPoolExecutor(4);
                }
            }
        }
        return this.f;
    }
}
