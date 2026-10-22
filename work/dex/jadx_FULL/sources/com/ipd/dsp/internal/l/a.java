package com.ipd.dsp.internal.l;

import android.os.Process;
import android.os.StrictMode;
import android.text.TextUtils;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import androidx.annotation.VisibleForTesting;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.k;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a implements ExecutorService {
    public static final String g = "ipd_source";
    public static final String h = "ipd_disk-cache";
    public static final int i = 1;
    public static final String j = "IPDGlideExecutor";
    public static final String k = "source-unlimited";
    public static final String l = "animation";
    public static final long m = TimeUnit.SECONDS.toMillis(10);
    public static final int n = 4;
    public static volatile int o;
    public final ExecutorService f;

    public static final class b {
        public static final long h = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f38391a;
        public int b;
        public int c;

        @NonNull
        public ThreadFactory d = new c();

        @NonNull
        public e e = e.d;
        public String f;
        public long g;

        public b(boolean z) {
            this.f38391a = z;
        }

        public b a(long j) {
            this.g = j;
            return this;
        }

        public b a(@IntRange(from = 1) int i) {
            this.b = i;
            this.c = i;
            return this;
        }

        @Deprecated
        public b a(@NonNull ThreadFactory threadFactory) {
            this.d = threadFactory;
            return this;
        }

        public b a(@NonNull e eVar) {
            this.e = eVar;
            return this;
        }

        public b a(String str) {
            this.f = str;
            return this;
        }

        public a a() {
            if (!TextUtils.isEmpty(this.f)) {
                ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(this.b, this.c, this.g, TimeUnit.MILLISECONDS, new PriorityBlockingQueue(), new d(this.d, this.f, this.e, this.f38391a));
                if (this.g != 0) {
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
                return new a(threadPoolExecutor);
            }
            throw new IllegalArgumentException("Name must be non-null and non-empty, but given: " + this.f);
        }
    }

    public static final class c implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final int f38392a = 9;

        /* JADX INFO: renamed from: com.ipd.dsp.internal.l.a$c$a, reason: collision with other inner class name */
        public class C0895a extends Thread {
            public C0895a(Runnable runnable) {
                super(runnable);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                Process.setThreadPriority(9);
                super.run();
            }
        }

        public c() {
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            return new C0895a(runnable);
        }
    }

    public static final class d implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ThreadFactory f38393a;
        public final String b;
        public final e c;
        public final boolean d;
        public final AtomicInteger e = new AtomicInteger();

        /* JADX INFO: renamed from: com.ipd.dsp.internal.l.a$d$a, reason: collision with other inner class name */
        public class RunnableC0896a implements Runnable {
            public final /* synthetic */ Runnable f;

            public RunnableC0896a(Runnable runnable) {
                this.f = runnable;
            }

            @Override // java.lang.Runnable
            public void run() {
                if (d.this.d) {
                    StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder().detectNetwork().penaltyDeath().build());
                }
                try {
                    this.f.run();
                } catch (Throwable th) {
                    d.this.c.a(th);
                }
            }
        }

        public d(ThreadFactory threadFactory, String str, e eVar, boolean z) {
            this.f38393a = threadFactory;
            this.b = str;
            this.c = eVar;
            this.d = z;
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            Thread threadNewThread = this.f38393a.newThread(new RunnableC0896a(runnable));
            threadNewThread.setName("glide-" + this.b + "-thread-" + this.e.getAndIncrement());
            return threadNewThread;
        }
    }

    public interface e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f38394a = new C0897a();
        public static final e b;
        public static final e c;
        public static final e d;

        /* JADX INFO: renamed from: com.ipd.dsp.internal.l.a$e$a, reason: collision with other inner class name */
        public class C0897a implements e {
            @Override // com.ipd.dsp.internal.l.a.e
            public void a(Throwable th) {
            }
        }

        public class b implements e {
            @Override // com.ipd.dsp.internal.l.a.e
            public void a(Throwable th) {
                if (th == null || !Dsp.isDebugLogEnable()) {
                    return;
                }
                k.b(a.j, "Request threw uncaught throwable", th);
            }
        }

        public class c implements e {
            @Override // com.ipd.dsp.internal.l.a.e
            public void a(Throwable th) {
                if (th != null) {
                    throw new RuntimeException("Request threw uncaught throwable", th);
                }
            }
        }

        static {
            b bVar = new b();
            b = bVar;
            c = new c();
            d = bVar;
        }

        void a(Throwable th);
    }

    @VisibleForTesting
    public a(ExecutorService executorService) {
        this.f = executorService;
    }

    @Deprecated
    public static a a(e eVar) {
        return e().a(eVar).a();
    }

    @Deprecated
    public static a b(e eVar) {
        return g().a(eVar).a();
    }

    public static b c() {
        return new b(true).a(a()).a(l);
    }

    public static a d() {
        return c().a();
    }

    public static b e() {
        return new b(true).a(1).a(h);
    }

    public static a f() {
        return e().a();
    }

    public static b g() {
        return new b(false).a(b()).a(g);
    }

    public static a h() {
        return g().a();
    }

    public static a i() {
        return new a(new ThreadPoolExecutor(0, Integer.MAX_VALUE, m, TimeUnit.MILLISECONDS, new SynchronousQueue(), new d(new c(), k, e.d, false)));
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean awaitTermination(long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f.awaitTermination(j2, timeUnit);
    }

    public void close() {
        boolean zIsTerminated = isTerminated();
        if (zIsTerminated) {
            return;
        }
        shutdown();
        boolean z = false;
        while (!zIsTerminated) {
            try {
                zIsTerminated = awaitTermination(1L, TimeUnit.DAYS);
            } catch (InterruptedException unused) {
                if (!z) {
                    shutdownNow();
                    z = true;
                }
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    @Override // java.util.concurrent.Executor
    public void execute(@NonNull Runnable runnable) {
        this.f.execute(runnable);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection) throws InterruptedException {
        return this.f.invokeAll(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection) throws ExecutionException, InterruptedException {
        return (T) this.f.invokeAny(collection);
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isShutdown() {
        return this.f.isShutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    public boolean isTerminated() {
        return this.f.isTerminated();
    }

    @Override // java.util.concurrent.ExecutorService
    public void shutdown() {
        this.f.shutdown();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public List<Runnable> shutdownNow() {
        return this.f.shutdownNow();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public Future<?> submit(@NonNull Runnable runnable) {
        return this.f.submit(runnable);
    }

    public String toString() {
        return this.f.toString();
    }

    @Deprecated
    public static a a(int i2, String str, e eVar) {
        return e().a(i2).a(str).a(eVar).a();
    }

    @Deprecated
    public static a b(int i2, String str, e eVar) {
        return g().a(i2).a(str).a(eVar).a();
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> List<Future<T>> invokeAll(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws InterruptedException {
        return this.f.invokeAll(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> T invokeAny(@NonNull Collection<? extends Callable<T>> collection, long j2, @NonNull TimeUnit timeUnit) throws ExecutionException, InterruptedException, TimeoutException {
        return (T) this.f.invokeAny(collection, j2, timeUnit);
    }

    @Override // java.util.concurrent.ExecutorService
    @NonNull
    public <T> Future<T> submit(@NonNull Runnable runnable, T t) {
        return this.f.submit(runnable, t);
    }

    @Override // java.util.concurrent.ExecutorService
    public <T> Future<T> submit(@NonNull Callable<T> callable) {
        return this.f.submit(callable);
    }

    public static int a() {
        return b() >= 4 ? 2 : 1;
    }

    public static int b() {
        if (o == 0) {
            o = Math.min(4, com.ipd.dsp.internal.l.b.a());
        }
        return o;
    }

    @Deprecated
    public static a a(int i2, e eVar) {
        return c().a(i2).a(eVar).a();
    }
}
