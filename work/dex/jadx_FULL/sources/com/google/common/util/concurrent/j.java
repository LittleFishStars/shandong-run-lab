package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.annotations.VisibleForTesting;
import com.google.common.base.Supplier;
import com.google.common.collect.Lists;
import com.google.common.collect.v;
import com.google.errorprone.annotations.CanIgnoreReturnValue;
import com.google.errorprone.annotations.concurrent.GuardedBy;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public final class j {

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListenableFuture f32426a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ BlockingQueue f6594a;

        public a(BlockingQueue blockingQueue, ListenableFuture listenableFuture) {
            this.f6594a = blockingQueue;
            this.f32426a = listenableFuture;
        }

        @Override // java.lang.Runnable
        public void run() {
            this.f6594a.add(this.f32426a);
        }
    }

    public class b implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Supplier f32427a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Executor f6595a;

        public b(Executor executor, Supplier supplier) {
            this.f6595a = executor;
            this.f32427a = supplier;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            this.f6595a.execute(com.google.common.util.concurrent.b.d(runnable, this.f32427a));
        }
    }

    public class c extends WrappingExecutorService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Supplier f32428a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ExecutorService executorService, Supplier supplier) {
            super(executorService);
            this.f32428a = supplier;
        }

        @Override // com.google.common.util.concurrent.WrappingExecutorService
        public <T> Callable<T> wrapTask(Callable<T> callable) {
            return com.google.common.util.concurrent.b.e(callable, this.f32428a);
        }

        @Override // com.google.common.util.concurrent.WrappingExecutorService
        public Runnable wrapTask(Runnable runnable) {
            return com.google.common.util.concurrent.b.d(runnable, this.f32428a);
        }
    }

    public class d extends WrappingScheduledExecutorService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Supplier f32429a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(ScheduledExecutorService scheduledExecutorService, Supplier supplier) {
            super(scheduledExecutorService);
            this.f32429a = supplier;
        }

        @Override // com.google.common.util.concurrent.WrappingExecutorService
        public <T> Callable<T> wrapTask(Callable<T> callable) {
            return com.google.common.util.concurrent.b.e(callable, this.f32429a);
        }

        @Override // com.google.common.util.concurrent.WrappingExecutorService
        public Runnable wrapTask(Runnable runnable) {
            return com.google.common.util.concurrent.b.d(runnable, this.f32429a);
        }
    }

    public class e implements Executor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AbstractFuture f32430a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Executor f6596a;

        public e(Executor executor, AbstractFuture abstractFuture) {
            this.f6596a = executor;
            this.f32430a = abstractFuture;
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            try {
                this.f6596a.execute(runnable);
            } catch (RejectedExecutionException e) {
                this.f32430a.setException(e);
            }
        }
    }

    @VisibleForTesting
    @GwtIncompatible
    public static class f {

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ long f32431a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ ExecutorService f6597a;

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ TimeUnit f6598a;

            public a(f fVar, ExecutorService executorService, long j, TimeUnit timeUnit) {
                this.f6597a = executorService;
                this.f32431a = j;
                this.f6598a = timeUnit;
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f6597a.shutdown();
                    this.f6597a.awaitTermination(this.f32431a, this.f6598a);
                } catch (InterruptedException unused) {
                }
            }
        }

        public final void a(ExecutorService executorService, long j, TimeUnit timeUnit) {
            com.google.common.base.i.E(executorService);
            com.google.common.base.i.E(timeUnit);
            String strValueOf = String.valueOf(executorService);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 24);
            sb.append("DelayedShutdownHook-for-");
            sb.append(strValueOf);
            b(j.n(sb.toString(), new a(this, executorService, j, timeUnit)));
        }

        @VisibleForTesting
        public void b(Thread thread) {
            Runtime.getRuntime().addShutdownHook(thread);
        }

        public final ExecutorService c(ThreadPoolExecutor threadPoolExecutor) {
            return d(threadPoolExecutor, 120L, TimeUnit.SECONDS);
        }

        public final ExecutorService d(ThreadPoolExecutor threadPoolExecutor, long j, TimeUnit timeUnit) {
            j.v(threadPoolExecutor);
            ExecutorService executorServiceUnconfigurableExecutorService = Executors.unconfigurableExecutorService(threadPoolExecutor);
            a(threadPoolExecutor, j, timeUnit);
            return executorServiceUnconfigurableExecutorService;
        }

        public final ScheduledExecutorService e(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
            return f(scheduledThreadPoolExecutor, 120L, TimeUnit.SECONDS);
        }

        public final ScheduledExecutorService f(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j, TimeUnit timeUnit) {
            j.v(scheduledThreadPoolExecutor);
            ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(scheduledThreadPoolExecutor);
            a(scheduledThreadPoolExecutor, j, timeUnit);
            return scheduledExecutorServiceUnconfigurableScheduledExecutorService;
        }
    }

    @GwtIncompatible
    public static class h extends AbstractListeningExecutorService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ExecutorService f32433a;

        public h(ExecutorService executorService) {
            this.f32433a = (ExecutorService) com.google.common.base.i.E(executorService);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            return this.f32433a.awaitTermination(j, timeUnit);
        }

        @Override // java.util.concurrent.Executor
        public final void execute(Runnable runnable) {
            this.f32433a.execute(runnable);
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isShutdown() {
            return this.f32433a.isShutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final boolean isTerminated() {
            return this.f32433a.isTerminated();
        }

        @Override // java.util.concurrent.ExecutorService
        public final void shutdown() {
            this.f32433a.shutdown();
        }

        @Override // java.util.concurrent.ExecutorService
        public final List<Runnable> shutdownNow() {
            return this.f32433a.shutdownNow();
        }

        public final String toString() {
            String string = super.toString();
            String strValueOf = String.valueOf(this.f32433a);
            StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 2 + strValueOf.length());
            sb.append(string);
            sb.append("[");
            sb.append(strValueOf);
            sb.append("]");
            return sb.toString();
        }
    }

    @GwtIncompatible
    public static final class i extends h implements ListeningScheduledExecutorService {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ScheduledExecutorService f32434a;

        public static final class a<V> extends ForwardingListenableFuture.SimpleForwardingListenableFuture<V> implements ListenableScheduledFuture<V> {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final ScheduledFuture<?> f32435a;

            public a(ListenableFuture<V> listenableFuture, ScheduledFuture<?> scheduledFuture) {
                super(listenableFuture);
                this.f32435a = scheduledFuture;
            }

            @Override // java.lang.Comparable
            /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
            public int compareTo(Delayed delayed) {
                return this.f32435a.compareTo(delayed);
            }

            @Override // com.google.common.util.concurrent.ForwardingFuture, java.util.concurrent.Future
            public boolean cancel(boolean z) {
                boolean zCancel = super.cancel(z);
                if (zCancel) {
                    this.f32435a.cancel(z);
                }
                return zCancel;
            }

            @Override // java.util.concurrent.Delayed
            public long getDelay(TimeUnit timeUnit) {
                return this.f32435a.getDelay(timeUnit);
            }
        }

        @GwtIncompatible
        public static final class b extends AbstractFuture.TrustedFuture<Void> implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final Runnable f32436a;

            public b(Runnable runnable) {
                this.f32436a = (Runnable) com.google.common.base.i.E(runnable);
            }

            @Override // com.google.common.util.concurrent.AbstractFuture
            public String pendingToString() {
                String strValueOf = String.valueOf(this.f32436a);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 7);
                sb.append("task=[");
                sb.append(strValueOf);
                sb.append("]");
                return sb.toString();
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    this.f32436a.run();
                } catch (Throwable th) {
                    setException(th);
                    throw com.google.common.base.m.q(th);
                }
            }
        }

        public i(ScheduledExecutorService scheduledExecutorService) {
            super(scheduledExecutorService);
            this.f32434a = (ScheduledExecutorService) com.google.common.base.i.E(scheduledExecutorService);
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: M */
        public ListenableScheduledFuture<?> scheduleWithFixedDelay(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            b bVar = new b(runnable);
            return new a(bVar, this.f32434a.scheduleWithFixedDelay(bVar, j, j2, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: i0 */
        public ListenableScheduledFuture<?> scheduleAtFixedRate(Runnable runnable, long j, long j2, TimeUnit timeUnit) {
            b bVar = new b(runnable);
            return new a(bVar, this.f32434a.scheduleAtFixedRate(bVar, j, j2, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: m */
        public ListenableScheduledFuture<?> schedule(Runnable runnable, long j, TimeUnit timeUnit) {
            TrustedListenableFutureTask trustedListenableFutureTaskJ = TrustedListenableFutureTask.J(runnable, null);
            return new a(trustedListenableFutureTaskJ, this.f32434a.schedule(trustedListenableFutureTaskJ, j, timeUnit));
        }

        @Override // com.google.common.util.concurrent.ListeningScheduledExecutorService, java.util.concurrent.ScheduledExecutorService
        /* JADX INFO: renamed from: v0 */
        public <V> ListenableScheduledFuture<V> schedule(Callable<V> callable, long j, TimeUnit timeUnit) {
            TrustedListenableFutureTask trustedListenableFutureTaskK = TrustedListenableFutureTask.K(callable);
            return new a(trustedListenableFutureTaskK, this.f32434a.schedule(trustedListenableFutureTaskK, j, timeUnit));
        }
    }

    @Beta
    @GwtIncompatible
    public static void b(ExecutorService executorService, long j, TimeUnit timeUnit) {
        new f().a(executorService, j, timeUnit);
    }

    public static Executor c() {
        return DirectExecutor.INSTANCE;
    }

    @Beta
    @GwtIncompatible
    public static ExecutorService d(ThreadPoolExecutor threadPoolExecutor) {
        return new f().c(threadPoolExecutor);
    }

    @Beta
    @GwtIncompatible
    public static ExecutorService e(ThreadPoolExecutor threadPoolExecutor, long j, TimeUnit timeUnit) {
        return new f().d(threadPoolExecutor, j, timeUnit);
    }

    @Beta
    @GwtIncompatible
    public static ScheduledExecutorService f(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor) {
        return new f().e(scheduledThreadPoolExecutor);
    }

    @Beta
    @GwtIncompatible
    public static ScheduledExecutorService g(ScheduledThreadPoolExecutor scheduledThreadPoolExecutor, long j, TimeUnit timeUnit) {
        return new f().f(scheduledThreadPoolExecutor, j, timeUnit);
    }

    @ParametricNullness
    @GwtIncompatible
    public static <T> T h(ListeningExecutorService listeningExecutorService, Collection<? extends Callable<T>> collection, boolean z, long j, TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        long jNanoTime;
        long jNanoTime2;
        com.google.common.base.i.E(listeningExecutorService);
        com.google.common.base.i.E(timeUnit);
        int size = collection.size();
        com.google.common.base.i.d(size > 0);
        ArrayList arrayListU = Lists.u(size);
        LinkedBlockingQueue linkedBlockingQueueK = v.k();
        long nanos = timeUnit.toNanos(j);
        if (z) {
            try {
                jNanoTime = System.nanoTime();
            } catch (Throwable th) {
                Iterator it = arrayListU.iterator();
                while (it.hasNext()) {
                    ((Future) it.next()).cancel(true);
                }
                throw th;
            }
        } else {
            jNanoTime = 0;
        }
        Iterator<? extends Callable<T>> it2 = collection.iterator();
        arrayListU.add(u(listeningExecutorService, it2.next(), linkedBlockingQueueK));
        int i2 = size - 1;
        int i3 = 1;
        ExecutionException executionException = null;
        while (true) {
            Future future = (Future) linkedBlockingQueueK.poll();
            if (future != null) {
                jNanoTime2 = jNanoTime;
            } else {
                if (i2 > 0) {
                    i2--;
                    arrayListU.add(u(listeningExecutorService, it2.next(), linkedBlockingQueueK));
                    i3++;
                } else {
                    if (i3 == 0) {
                        if (executionException == null) {
                            throw new ExecutionException((Throwable) null);
                        }
                        throw executionException;
                    }
                    if (z) {
                        future = (Future) linkedBlockingQueueK.poll(nanos, TimeUnit.NANOSECONDS);
                        if (future == null) {
                            throw new TimeoutException();
                        }
                        jNanoTime2 = System.nanoTime();
                        nanos -= jNanoTime2 - jNanoTime;
                    } else {
                        future = (Future) linkedBlockingQueueK.take();
                    }
                }
                jNanoTime2 = jNanoTime;
            }
            long j2 = nanos;
            int i4 = i2;
            if (future != null) {
                i3--;
                try {
                    T t = (T) future.get();
                    Iterator it3 = arrayListU.iterator();
                    while (it3.hasNext()) {
                        ((Future) it3.next()).cancel(true);
                    }
                    return t;
                } catch (RuntimeException e2) {
                    executionException = new ExecutionException(e2);
                    i2 = i4;
                    nanos = j2;
                    jNanoTime = jNanoTime2;
                } catch (ExecutionException e3) {
                    executionException = e3;
                    i2 = i4;
                    nanos = j2;
                    jNanoTime = jNanoTime2;
                }
            }
            i2 = i4;
            nanos = j2;
            jNanoTime = jNanoTime2;
        }
    }

    @GwtIncompatible
    public static boolean i() {
        if (System.getProperty("com.google.appengine.runtime.environment") == null) {
            return false;
        }
        try {
            Class.forName("com.google.appengine.api.utils.SystemProperty");
            return Class.forName("com.google.apphosting.api.ApiProxy").getMethod("getCurrentEnvironment", new Class[0]).invoke(null, new Object[0]) != null;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchMethodException | InvocationTargetException unused) {
            return false;
        }
    }

    @GwtIncompatible
    public static ListeningExecutorService j(ExecutorService executorService) {
        if (executorService instanceof ListeningExecutorService) {
            return (ListeningExecutorService) executorService;
        }
        return executorService instanceof ScheduledExecutorService ? new i((ScheduledExecutorService) executorService) : new h(executorService);
    }

    @GwtIncompatible
    public static ListeningScheduledExecutorService k(ScheduledExecutorService scheduledExecutorService) {
        return scheduledExecutorService instanceof ListeningScheduledExecutorService ? (ListeningScheduledExecutorService) scheduledExecutorService : new i(scheduledExecutorService);
    }

    @GwtIncompatible
    public static ListeningExecutorService l() {
        return new g(null);
    }

    @Beta
    @GwtIncompatible
    public static Executor m(Executor executor) {
        return new SequentialExecutor(executor);
    }

    @GwtIncompatible
    public static Thread n(String str, Runnable runnable) {
        com.google.common.base.i.E(str);
        com.google.common.base.i.E(runnable);
        Thread threadNewThread = o().newThread(runnable);
        try {
            threadNewThread.setName(str);
        } catch (SecurityException unused) {
        }
        return threadNewThread;
    }

    @Beta
    @GwtIncompatible
    public static ThreadFactory o() {
        if (!i()) {
            return Executors.defaultThreadFactory();
        }
        try {
            return (ThreadFactory) Class.forName("com.google.appengine.api.ThreadManager").getMethod("currentRequestThreadFactory", new Class[0]).invoke(null, new Object[0]);
        } catch (ClassNotFoundException e2) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e2);
        } catch (IllegalAccessException e3) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e3);
        } catch (NoSuchMethodException e4) {
            throw new RuntimeException("Couldn't invoke ThreadManager.currentRequestThreadFactory", e4);
        } catch (InvocationTargetException e5) {
            throw com.google.common.base.m.q(e5.getCause());
        }
    }

    public static Executor p(Executor executor, AbstractFuture<?> abstractFuture) {
        com.google.common.base.i.E(executor);
        com.google.common.base.i.E(abstractFuture);
        return executor == c() ? executor : new e(executor, abstractFuture);
    }

    @GwtIncompatible
    public static Executor q(Executor executor, Supplier<String> supplier) {
        com.google.common.base.i.E(executor);
        com.google.common.base.i.E(supplier);
        return new b(executor, supplier);
    }

    @GwtIncompatible
    public static ExecutorService r(ExecutorService executorService, Supplier<String> supplier) {
        com.google.common.base.i.E(executorService);
        com.google.common.base.i.E(supplier);
        return new c(executorService, supplier);
    }

    @GwtIncompatible
    public static ScheduledExecutorService s(ScheduledExecutorService scheduledExecutorService, Supplier<String> supplier) {
        com.google.common.base.i.E(scheduledExecutorService);
        com.google.common.base.i.E(supplier);
        return new d(scheduledExecutorService, supplier);
    }

    @CanIgnoreReturnValue
    @Beta
    @GwtIncompatible
    public static boolean t(ExecutorService executorService, long j, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(j) / 2;
        executorService.shutdown();
        try {
            TimeUnit timeUnit2 = TimeUnit.NANOSECONDS;
            if (!executorService.awaitTermination(nanos, timeUnit2)) {
                executorService.shutdownNow();
                executorService.awaitTermination(nanos, timeUnit2);
            }
        } catch (InterruptedException unused) {
            Thread.currentThread().interrupt();
            executorService.shutdownNow();
        }
        return executorService.isTerminated();
    }

    @GwtIncompatible
    public static <T> ListenableFuture<T> u(ListeningExecutorService listeningExecutorService, Callable<T> callable, BlockingQueue<Future<T>> blockingQueue) {
        ListenableFuture<T> listenableFutureSubmit = listeningExecutorService.submit(callable);
        listenableFutureSubmit.addListener(new a(blockingQueue, listenableFutureSubmit), c());
        return listenableFutureSubmit;
    }

    @GwtIncompatible
    public static void v(ThreadPoolExecutor threadPoolExecutor) {
        threadPoolExecutor.setThreadFactory(new q().e(true).h(threadPoolExecutor.getThreadFactory()).b());
    }

    @GwtIncompatible
    public static final class g extends AbstractListeningExecutorService {

        @GuardedBy("lock")
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Object f32432a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @GuardedBy("lock")
        public boolean f6599a;

        public g() {
            this.f32432a = new Object();
            this.K = 0;
            this.f6599a = false;
        }

        public final void a() {
            synchronized (this.f32432a) {
                int i = this.K - 1;
                this.K = i;
                if (i == 0) {
                    this.f32432a.notifyAll();
                }
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean awaitTermination(long j, TimeUnit timeUnit) throws InterruptedException {
            long nanos = timeUnit.toNanos(j);
            synchronized (this.f32432a) {
                while (true) {
                    if (this.f6599a && this.K == 0) {
                        return true;
                    }
                    if (nanos <= 0) {
                        return false;
                    }
                    long jNanoTime = System.nanoTime();
                    TimeUnit.NANOSECONDS.timedWait(this.f32432a, nanos);
                    nanos -= System.nanoTime() - jNanoTime;
                }
            }
        }

        public final void b() {
            synchronized (this.f32432a) {
                if (this.f6599a) {
                    throw new RejectedExecutionException("Executor already shutdown");
                }
                this.K++;
            }
        }

        @Override // java.util.concurrent.Executor
        public void execute(Runnable runnable) {
            b();
            try {
                runnable.run();
            } finally {
                a();
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isShutdown() {
            boolean z;
            synchronized (this.f32432a) {
                z = this.f6599a;
            }
            return z;
        }

        @Override // java.util.concurrent.ExecutorService
        public boolean isTerminated() {
            boolean z;
            synchronized (this.f32432a) {
                z = this.f6599a && this.K == 0;
            }
            return z;
        }

        @Override // java.util.concurrent.ExecutorService
        public void shutdown() {
            synchronized (this.f32432a) {
                this.f6599a = true;
                if (this.K == 0) {
                    this.f32432a.notifyAll();
                }
            }
        }

        @Override // java.util.concurrent.ExecutorService
        public List<Runnable> shutdownNow() {
            shutdown();
            return Collections.emptyList();
        }

        public /* synthetic */ g(a aVar) {
            this();
        }
    }
}
