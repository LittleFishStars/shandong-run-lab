package com.blankj.utilcode.util;

import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import androidx.annotation.CallSuper;
import androidx.annotation.IntRange;
import androidx.annotation.NonNull;
import com.acse.ottn.t4;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ThreadUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final byte f28187a = -1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static Executor f1385a = null;
    public static final byte b = -2;
    public static final byte c = -4;
    public static final byte d = -8;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Handler f1382a = new Handler(Looper.getMainLooper());

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Map<Integer, Map<Integer, ExecutorService>> f1383a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Map<Task, ExecutorService> f1386b = new ConcurrentHashMap();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f1381a = Runtime.getRuntime().availableProcessors();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Timer f1384a = new Timer();

    public static final class LinkedBlockingQueue4Util extends LinkedBlockingQueue<Runnable> {
        private int mCapacity;
        private volatile e mPool;

        public LinkedBlockingQueue4Util() {
            this.mCapacity = Integer.MAX_VALUE;
        }

        @Override // java.util.concurrent.LinkedBlockingQueue, java.util.Queue, java.util.concurrent.BlockingQueue
        public boolean offer(@NonNull Runnable runnable) {
            if (this.mCapacity > size() || this.mPool == null || this.mPool.getPoolSize() >= this.mPool.getMaximumPoolSize()) {
                return super.offer(runnable);
            }
            return false;
        }

        public LinkedBlockingQueue4Util(boolean z) {
            this.mCapacity = Integer.MAX_VALUE;
            if (z) {
                this.mCapacity = 0;
            }
        }

        public LinkedBlockingQueue4Util(int i) {
            this.mCapacity = i;
        }
    }

    public static abstract class SimpleTask<T> extends Task<T> {
        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void j() {
            Log.e("ThreadUtils", "onCancel: " + Thread.currentThread());
        }

        @Override // com.blankj.utilcode.util.ThreadUtils.Task
        public void k(Throwable th) {
            Log.e("ThreadUtils", "onFail: ", th);
        }
    }

    public static abstract class Task<T> implements Runnable {
        public static final int K = 0;
        public static final int L = 1;
        public static final int M = 2;
        public static final int N = 3;
        public static final int O = 4;
        public static final int P = 5;
        public static final int Q = 6;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f28188a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public OnTimeoutListener f1387a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public volatile Thread f1388a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Timer f1389a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public Executor f1390a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AtomicInteger f1391a = new AtomicInteger(0);

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public volatile boolean f1392a;

        public interface OnTimeoutListener {
            void onTimeout();
        }

        public class a extends TimerTask {
            public a() {
            }

            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (Task.this.i() || Task.this.f1387a == null) {
                    return;
                }
                Task.this.p();
                Task.this.f1387a.onTimeout();
                Task.this.onDone();
            }
        }

        public class b implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Object f1393a;

            public b(Object obj) {
                this.f1393a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Task.this.l(this.f1393a);
            }
        }

        public class c implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Object f1394a;

            public c(Object obj) {
                this.f1394a = obj;
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.lang.Runnable
            public void run() {
                Task.this.l(this.f1394a);
                Task.this.onDone();
            }
        }

        public class d implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with other field name */
            public final /* synthetic */ Throwable f1395a;

            public d(Throwable th) {
                this.f1395a = th;
            }

            @Override // java.lang.Runnable
            public void run() {
                Task.this.k(this.f1395a);
                Task.this.onDone();
            }
        }

        public class e implements Runnable {
            public e() {
            }

            @Override // java.lang.Runnable
            public void run() {
                Task.this.j();
                Task.this.onDone();
            }
        }

        public void d() {
            e(true);
        }

        public void e(boolean z) {
            synchronized (this.f1391a) {
                if (this.f1391a.get() > 1) {
                    return;
                }
                this.f1391a.set(4);
                if (z && this.f1388a != null) {
                    this.f1388a.interrupt();
                }
                g().execute(new e());
            }
        }

        public abstract T f() throws Throwable;

        public final Executor g() {
            Executor executor = this.f1390a;
            return executor == null ? ThreadUtils.j0() : executor;
        }

        public boolean h() {
            return this.f1391a.get() >= 4;
        }

        public boolean i() {
            return this.f1391a.get() > 1;
        }

        public abstract void j();

        public abstract void k(Throwable th);

        public abstract void l(T t);

        public Task<T> m(Executor executor) {
            this.f1390a = executor;
            return this;
        }

        public final void n(boolean z) {
            this.f1392a = z;
        }

        public Task<T> o(long j, OnTimeoutListener onTimeoutListener) {
            this.f28188a = j;
            this.f1387a = onTimeoutListener;
            return this;
        }

        @CallSuper
        public void onDone() {
            ThreadUtils.f1386b.remove(this);
            Timer timer = this.f1389a;
            if (timer != null) {
                timer.cancel();
                this.f1389a = null;
                this.f1387a = null;
            }
        }

        public final void p() {
            synchronized (this.f1391a) {
                if (this.f1391a.get() > 1) {
                    return;
                }
                this.f1391a.set(6);
                if (this.f1388a != null) {
                    this.f1388a.interrupt();
                }
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.f1392a) {
                if (this.f1388a == null) {
                    if (!this.f1391a.compareAndSet(0, 1)) {
                        return;
                    }
                    this.f1388a = Thread.currentThread();
                    if (this.f1387a != null) {
                        Log.w("ThreadUtils", "Scheduled task doesn't support timeout.");
                    }
                } else if (this.f1391a.get() != 1) {
                    return;
                }
            } else {
                if (!this.f1391a.compareAndSet(0, 1)) {
                    return;
                }
                this.f1388a = Thread.currentThread();
                if (this.f1387a != null) {
                    Timer timer = new Timer();
                    this.f1389a = timer;
                    timer.schedule(new a(), this.f28188a);
                }
            }
            try {
                T tF = f();
                if (this.f1392a) {
                    if (this.f1391a.get() != 1) {
                        return;
                    }
                    g().execute(new b(tF));
                } else if (this.f1391a.compareAndSet(1, 3)) {
                    g().execute(new c(tF));
                }
            } catch (InterruptedException unused) {
                this.f1391a.compareAndSet(4, 5);
            } catch (Throwable th) {
                if (this.f1391a.compareAndSet(1, 2)) {
                    g().execute(new d(th));
                }
            }
        }
    }

    public static final class UtilsThreadFactory extends AtomicLong implements ThreadFactory {
        private static final AtomicInteger POOL_NUMBER = new AtomicInteger(1);
        private static final long serialVersionUID = -9209200509960368598L;
        private final boolean isDaemon;
        private final String namePrefix;
        private final int priority;

        public class a extends Thread {
            public a(Runnable runnable, String str) {
                super(runnable, str);
            }

            @Override // java.lang.Thread, java.lang.Runnable
            public void run() {
                try {
                    super.run();
                } catch (Throwable th) {
                    Log.e("ThreadUtils", "Request threw uncaught throwable", th);
                }
            }
        }

        public class b implements Thread.UncaughtExceptionHandler {
            public b() {
            }

            @Override // java.lang.Thread.UncaughtExceptionHandler
            public void uncaughtException(Thread thread, Throwable th) {
                System.out.println(th);
            }
        }

        public UtilsThreadFactory(String str, int i) {
            this(str, i, false);
        }

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(@NonNull Runnable runnable) {
            a aVar = new a(runnable, this.namePrefix + getAndIncrement());
            aVar.setDaemon(this.isDaemon);
            aVar.setUncaughtExceptionHandler(new b());
            aVar.setPriority(this.priority);
            return aVar;
        }

        public UtilsThreadFactory(String str, int i, boolean z) {
            this.namePrefix = str + "-pool-" + POOL_NUMBER.getAndIncrement() + "-thread-";
            this.priority = i;
            this.isDaemon = z;
        }
    }

    public class a extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Task f28196a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ExecutorService f1396a;

        public a(ExecutorService executorService, Task task) {
            this.f1396a = executorService;
            this.f28196a = task;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f1396a.execute(this.f28196a);
        }
    }

    public class b extends TimerTask {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Task f28197a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ExecutorService f1397a;

        public b(ExecutorService executorService, Task task) {
            this.f1397a = executorService;
            this.f28197a = task;
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            this.f1397a.execute(this.f28197a);
        }
    }

    public class c implements Executor {
        @Override // java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            ThreadUtils.s0(runnable);
        }
    }

    public static class d<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public T f28198a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public CountDownLatch f1398a = new CountDownLatch(1);

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public AtomicBoolean f1399a = new AtomicBoolean();

        public T a() {
            if (!this.f1399a.get()) {
                try {
                    this.f1398a.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            return this.f28198a;
        }

        public T b(long j, TimeUnit timeUnit, T t) {
            if (!this.f1399a.get()) {
                try {
                    this.f1398a.await(j, timeUnit);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    return t;
                }
            }
            return this.f28198a;
        }

        public void c(T t) {
            if (this.f1399a.compareAndSet(false, true)) {
                this.f28198a = t;
                this.f1398a.countDown();
            }
        }
    }

    public static final class e extends ThreadPoolExecutor {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public LinkedBlockingQueue4Util f28199a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AtomicInteger f1400a;

        public e(int i, int i2, long j, TimeUnit timeUnit, LinkedBlockingQueue4Util linkedBlockingQueue4Util, ThreadFactory threadFactory) {
            super(i, i2, j, timeUnit, linkedBlockingQueue4Util, threadFactory);
            this.f1400a = new AtomicInteger();
            linkedBlockingQueue4Util.mPool = this;
            this.f28199a = linkedBlockingQueue4Util;
        }

        public static ExecutorService b(int i, int i2) {
            if (i == -8) {
                return new e(ThreadUtils.f1381a + 1, (ThreadUtils.f1381a * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cpu", i2));
            }
            if (i == -4) {
                return new e((ThreadUtils.f1381a * 2) + 1, (ThreadUtils.f1381a * 2) + 1, 30L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("io", i2));
            }
            if (i == -2) {
                return new e(0, 128, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue4Util(true), new UtilsThreadFactory("cached", i2));
            }
            if (i == -1) {
                return new e(1, 1, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("single", i2));
            }
            return new e(i, i, 0L, TimeUnit.MILLISECONDS, new LinkedBlockingQueue4Util(), new UtilsThreadFactory("fixed(" + i + ")", i2));
        }

        @Override // java.util.concurrent.ThreadPoolExecutor
        public void afterExecute(Runnable runnable, Throwable th) {
            this.f1400a.decrementAndGet();
            super.afterExecute(runnable, th);
        }

        public final int c() {
            return this.f1400a.get();
        }

        @Override // java.util.concurrent.ThreadPoolExecutor, java.util.concurrent.Executor
        public void execute(@NonNull Runnable runnable) {
            if (isShutdown()) {
                return;
            }
            this.f1400a.incrementAndGet();
            try {
                super.execute(runnable);
            } catch (RejectedExecutionException unused) {
                Log.e("ThreadUtils", "This will not happen!");
                this.f28199a.offer(runnable);
            } catch (Throwable unused2) {
                this.f1400a.decrementAndGet();
            }
        }
    }

    public static <T> void A(ExecutorService executorService, Task<T> task) {
        h(executorService, task);
    }

    public static <T> void B(ExecutorService executorService, Task<T> task, long j, long j2, TimeUnit timeUnit) {
        j(executorService, task, j, j2, timeUnit);
    }

    public static <T> void C(ExecutorService executorService, Task<T> task, long j, TimeUnit timeUnit) {
        j(executorService, task, 0L, j, timeUnit);
    }

    public static <T> void D(ExecutorService executorService, Task<T> task, long j, TimeUnit timeUnit) {
        c0(executorService, task, j, timeUnit);
    }

    public static <T> void E(@IntRange(from = 1) int i, Task<T> task) {
        h(n0(i), task);
    }

    public static <T> void F(@IntRange(from = 1) int i, Task<T> task, @IntRange(from = 1, to = t4.u) int i2) {
        h(o0(i, i2), task);
    }

    public static <T> void G(@IntRange(from = 1) int i, Task<T> task, long j, long j2, TimeUnit timeUnit) {
        j(n0(i), task, j, j2, timeUnit);
    }

    public static <T> void H(@IntRange(from = 1) int i, Task<T> task, long j, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = t4.u) int i2) {
        j(o0(i, i2), task, j, j2, timeUnit);
    }

    public static <T> void I(@IntRange(from = 1) int i, Task<T> task, long j, TimeUnit timeUnit) {
        j(n0(i), task, 0L, j, timeUnit);
    }

    public static <T> void J(@IntRange(from = 1) int i, Task<T> task, long j, TimeUnit timeUnit, @IntRange(from = 1, to = t4.u) int i2) {
        j(o0(i, i2), task, 0L, j, timeUnit);
    }

    public static <T> void K(@IntRange(from = 1) int i, Task<T> task, long j, TimeUnit timeUnit) {
        c0(n0(i), task, j, timeUnit);
    }

    public static <T> void L(@IntRange(from = 1) int i, Task<T> task, long j, TimeUnit timeUnit, @IntRange(from = 1, to = t4.u) int i2) {
        c0(o0(i, i2), task, j, timeUnit);
    }

    public static <T> void M(Task<T> task) {
        h(n0(-4), task);
    }

    public static <T> void N(Task<T> task, @IntRange(from = 1, to = t4.u) int i) {
        h(o0(-4, i), task);
    }

    public static <T> void O(Task<T> task, long j, long j2, TimeUnit timeUnit) {
        j(n0(-4), task, j, j2, timeUnit);
    }

    public static <T> void P(Task<T> task, long j, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = t4.u) int i) {
        j(o0(-4, i), task, j, j2, timeUnit);
    }

    public static <T> void Q(Task<T> task, long j, TimeUnit timeUnit) {
        j(n0(-4), task, 0L, j, timeUnit);
    }

    public static <T> void R(Task<T> task, long j, TimeUnit timeUnit, @IntRange(from = 1, to = t4.u) int i) {
        j(o0(-4, i), task, 0L, j, timeUnit);
    }

    public static <T> void S(Task<T> task, long j, TimeUnit timeUnit) {
        c0(n0(-4), task, j, timeUnit);
    }

    public static <T> void T(Task<T> task, long j, TimeUnit timeUnit, @IntRange(from = 1, to = t4.u) int i) {
        c0(o0(-4, i), task, j, timeUnit);
    }

    public static <T> void U(Task<T> task) {
        h(n0(-1), task);
    }

    public static <T> void V(Task<T> task, @IntRange(from = 1, to = t4.u) int i) {
        h(o0(-1, i), task);
    }

    public static <T> void W(Task<T> task, long j, long j2, TimeUnit timeUnit) {
        j(n0(-1), task, j, j2, timeUnit);
    }

    public static <T> void X(Task<T> task, long j, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = t4.u) int i) {
        j(o0(-1, i), task, j, j2, timeUnit);
    }

    public static <T> void Y(Task<T> task, long j, TimeUnit timeUnit) {
        j(n0(-1), task, 0L, j, timeUnit);
    }

    public static <T> void Z(Task<T> task, long j, TimeUnit timeUnit, @IntRange(from = 1, to = t4.u) int i) {
        j(o0(-1, i), task, 0L, j, timeUnit);
    }

    public static <T> void a0(Task<T> task, long j, TimeUnit timeUnit) {
        c0(n0(-1), task, j, timeUnit);
    }

    public static <T> void b0(Task<T> task, long j, TimeUnit timeUnit, @IntRange(from = 1, to = t4.u) int i) {
        c0(o0(-1, i), task, j, timeUnit);
    }

    public static <T> void c0(ExecutorService executorService, Task<T> task, long j, TimeUnit timeUnit) {
        i(executorService, task, j, 0L, timeUnit);
    }

    public static void d(Task task) {
        if (task == null) {
            return;
        }
        task.d();
    }

    public static ExecutorService d0() {
        return n0(-2);
    }

    public static void e(List<Task> list) {
        if (list == null || list.size() == 0) {
            return;
        }
        for (Task task : list) {
            if (task != null) {
                task.d();
            }
        }
    }

    public static ExecutorService e0(@IntRange(from = 1, to = t4.u) int i) {
        return o0(-2, i);
    }

    public static void f(ExecutorService executorService) {
        if (!(executorService instanceof e)) {
            Log.e("ThreadUtils", "The executorService is not ThreadUtils's pool.");
            return;
        }
        for (Map.Entry<Task, ExecutorService> entry : f1386b.entrySet()) {
            if (entry.getValue() == executorService) {
                d(entry.getKey());
            }
        }
    }

    public static ExecutorService f0() {
        return n0(-8);
    }

    public static void g(Task... taskArr) {
        if (taskArr == null || taskArr.length == 0) {
            return;
        }
        for (Task task : taskArr) {
            if (task != null) {
                task.d();
            }
        }
    }

    public static ExecutorService g0(@IntRange(from = 1, to = t4.u) int i) {
        return o0(-8, i);
    }

    public static <T> void h(ExecutorService executorService, Task<T> task) {
        i(executorService, task, 0L, 0L, null);
    }

    public static ExecutorService h0(@IntRange(from = 1) int i) {
        return n0(i);
    }

    public static <T> void i(ExecutorService executorService, Task<T> task, long j, long j2, TimeUnit timeUnit) {
        Map<Task, ExecutorService> map = f1386b;
        synchronized (map) {
            if (map.get(task) != null) {
                Log.e("ThreadUtils", "Task can only be executed once.");
                return;
            }
            map.put(task, executorService);
            if (j2 != 0) {
                task.n(true);
                f1384a.scheduleAtFixedRate(new b(executorService, task), timeUnit.toMillis(j), timeUnit.toMillis(j2));
            } else if (j == 0) {
                executorService.execute(task);
            } else {
                f1384a.schedule(new a(executorService, task), timeUnit.toMillis(j));
            }
        }
    }

    public static ExecutorService i0(@IntRange(from = 1) int i, @IntRange(from = 1, to = t4.u) int i2) {
        return o0(i, i2);
    }

    public static <T> void j(ExecutorService executorService, Task<T> task, long j, long j2, TimeUnit timeUnit) {
        i(executorService, task, j, j2, timeUnit);
    }

    public static Executor j0() {
        if (f1385a == null) {
            f1385a = new c();
        }
        return f1385a;
    }

    public static <T> void k(Task<T> task) {
        h(n0(-2), task);
    }

    public static ExecutorService k0() {
        return n0(-4);
    }

    public static <T> void l(Task<T> task, @IntRange(from = 1, to = t4.u) int i) {
        h(o0(-2, i), task);
    }

    public static ExecutorService l0(@IntRange(from = 1, to = t4.u) int i) {
        return o0(-4, i);
    }

    public static <T> void m(Task<T> task, long j, long j2, TimeUnit timeUnit) {
        j(n0(-2), task, j, j2, timeUnit);
    }

    public static Handler m0() {
        return f1382a;
    }

    public static <T> void n(Task<T> task, long j, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = t4.u) int i) {
        j(o0(-2, i), task, j, j2, timeUnit);
    }

    public static ExecutorService n0(int i) {
        return o0(i, 5);
    }

    public static <T> void o(Task<T> task, long j, TimeUnit timeUnit) {
        j(n0(-2), task, 0L, j, timeUnit);
    }

    public static ExecutorService o0(int i, int i2) {
        ExecutorService executorServiceB;
        Map<Integer, Map<Integer, ExecutorService>> map = f1383a;
        synchronized (map) {
            Map<Integer, ExecutorService> map2 = map.get(Integer.valueOf(i));
            if (map2 == null) {
                ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
                executorServiceB = e.b(i, i2);
                concurrentHashMap.put(Integer.valueOf(i2), executorServiceB);
                map.put(Integer.valueOf(i), concurrentHashMap);
            } else {
                executorServiceB = map2.get(Integer.valueOf(i2));
                if (executorServiceB == null) {
                    executorServiceB = e.b(i, i2);
                    map2.put(Integer.valueOf(i2), executorServiceB);
                }
            }
        }
        return executorServiceB;
    }

    public static <T> void p(Task<T> task, long j, TimeUnit timeUnit, @IntRange(from = 1, to = t4.u) int i) {
        j(o0(-2, i), task, 0L, j, timeUnit);
    }

    public static ExecutorService p0() {
        return n0(-1);
    }

    public static <T> void q(Task<T> task, long j, TimeUnit timeUnit) {
        c0(n0(-2), task, j, timeUnit);
    }

    public static ExecutorService q0(@IntRange(from = 1, to = t4.u) int i) {
        return o0(-1, i);
    }

    public static <T> void r(Task<T> task, long j, TimeUnit timeUnit, @IntRange(from = 1, to = t4.u) int i) {
        c0(o0(-2, i), task, j, timeUnit);
    }

    public static boolean r0() {
        return Looper.myLooper() == Looper.getMainLooper();
    }

    public static <T> void s(Task<T> task) {
        h(n0(-8), task);
    }

    public static void s0(Runnable runnable) {
        if (Looper.myLooper() == Looper.getMainLooper()) {
            runnable.run();
        } else {
            f1382a.post(runnable);
        }
    }

    public static <T> void t(Task<T> task, @IntRange(from = 1, to = t4.u) int i) {
        h(o0(-8, i), task);
    }

    public static void t0(Runnable runnable, long j) {
        f1382a.postDelayed(runnable, j);
    }

    public static <T> void u(Task<T> task, long j, long j2, TimeUnit timeUnit) {
        j(n0(-8), task, j, j2, timeUnit);
    }

    public static void u0(Executor executor) {
        f1385a = executor;
    }

    public static <T> void v(Task<T> task, long j, long j2, TimeUnit timeUnit, @IntRange(from = 1, to = t4.u) int i) {
        j(o0(-8, i), task, j, j2, timeUnit);
    }

    public static <T> void w(Task<T> task, long j, TimeUnit timeUnit) {
        j(n0(-8), task, 0L, j, timeUnit);
    }

    public static <T> void x(Task<T> task, long j, TimeUnit timeUnit, @IntRange(from = 1, to = t4.u) int i) {
        j(o0(-8, i), task, 0L, j, timeUnit);
    }

    public static <T> void y(Task<T> task, long j, TimeUnit timeUnit) {
        c0(n0(-8), task, j, timeUnit);
    }

    public static <T> void z(Task<T> task, long j, TimeUnit timeUnit, @IntRange(from = 1, to = t4.u) int i) {
        c0(o0(-8, i), task, j, timeUnit);
    }
}
