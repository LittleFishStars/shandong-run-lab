package com.igexin.b;

import android.text.TextUtils;
import com.igexin.push.core.ServiceManager;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {
    private static String b = "GTSDK-thread-pool | ";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThreadPoolExecutor f37791a;
    private final ConcurrentHashMap<String, ThreadPoolExecutor> c;
    private ScheduledThreadPoolExecutor d;
    private final AtomicInteger e;
    private final AtomicInteger f;
    private int g;

    /* JADX INFO: renamed from: com.igexin.b.a$a, reason: collision with other inner class name */
    public static class C0846a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final a f37800a = new a(0);

        private C0846a() {
        }
    }

    private a() {
        this.c = new ConcurrentHashMap<>();
        this.e = new AtomicInteger(0);
        this.f = new AtomicInteger(0);
        this.g = 30;
        this.f37791a = new ThreadPoolExecutor(0, Runtime.getRuntime().availableProcessors() * 2, this.g, TimeUnit.SECONDS, new SynchronousQueue(), new ThreadFactory() { // from class: com.igexin.b.a.1
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, "gt-thread-multiple " + a.this.e.getAndIncrement());
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.igexin.b.a.1.1
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public final void uncaughtException(Thread thread2, Throwable th) {
                        com.igexin.c.a.c.a.a(a.b + "| caught an exception from " + thread2.getName(), th);
                    }
                });
                return thread;
            }
        }, new RejectedExecutionHandler() { // from class: com.igexin.b.a.2
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
                if (ServiceManager.b != null) {
                    com.igexin.c.a.c.a.a(a.b + "|gtsdk-multiple-thread rejected task tasknum = " + threadPoolExecutor.getActiveCount(), new Object[0]);
                }
            }
        });
    }

    public /* synthetic */ a(byte b2) {
        this();
    }

    public static a a() {
        return C0846a.f37800a;
    }

    private ThreadPoolExecutor d() {
        return this.f37791a;
    }

    public final ThreadPoolExecutor a(String str) {
        final String strConcat = TextUtils.isEmpty(str) ? "gt-thread" : "gt-thread-".concat(String.valueOf(str));
        if (this.c.containsKey(strConcat)) {
            return this.c.get(strConcat);
        }
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(0, 1, this.g, TimeUnit.SECONDS, new LinkedBlockingQueue(), new ThreadFactory() { // from class: com.igexin.b.a.3
            @Override // java.util.concurrent.ThreadFactory
            public final Thread newThread(Runnable runnable) {
                Thread thread = new Thread(runnable, strConcat);
                thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.igexin.b.a.3.1
                    @Override // java.lang.Thread.UncaughtExceptionHandler
                    public final void uncaughtException(Thread thread2, Throwable th) {
                        com.igexin.c.a.c.a.a(a.b + "| caught an exception from " + thread2.getName(), th);
                    }
                });
                return thread;
            }
        }, new RejectedExecutionHandler() { // from class: com.igexin.b.a.4
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                if (ServiceManager.b != null) {
                    com.igexin.c.a.c.a.a(a.b + "singleThread rejected task tasknum = " + threadPoolExecutor2.getActiveCount(), new Object[0]);
                }
            }
        });
        this.c.put(strConcat, threadPoolExecutor);
        return threadPoolExecutor;
    }

    public final ScheduledThreadPoolExecutor b() {
        if (this.d == null) {
            final String str = "gt-thread-delay";
            this.d = new ScheduledThreadPoolExecutor(0, new ThreadFactory() { // from class: com.igexin.b.a.5
                @Override // java.util.concurrent.ThreadFactory
                public final Thread newThread(Runnable runnable) {
                    Thread thread = new Thread(runnable, str);
                    thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() { // from class: com.igexin.b.a.5.1
                        @Override // java.lang.Thread.UncaughtExceptionHandler
                        public final void uncaughtException(Thread thread2, Throwable th) {
                            com.igexin.c.a.c.a.a(a.b + "| caught an exception from " + thread2.getName(), th);
                        }
                    });
                    return thread;
                }
            });
        }
        return this.d;
    }
}
