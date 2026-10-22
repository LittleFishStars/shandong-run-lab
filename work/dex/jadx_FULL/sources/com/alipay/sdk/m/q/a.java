package com.alipay.sdk.m.q;

import com.alipay.sdk.m.y.g;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f25487a = "TaskHelper";
    public static final int b = 4;
    public static volatile a c = null;
    public static int d = 32;
    public static ThreadPoolExecutor e;

    /* JADX INFO: renamed from: com.alipay.sdk.m.q.a$a, reason: collision with other inner class name */
    public class ThreadFactoryC0202a implements ThreadFactory {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AtomicInteger f25488a = new AtomicInteger(1);

        @Override // java.util.concurrent.ThreadFactory
        public Thread newThread(Runnable runnable) {
            g.d(a.f25487a, "newThread create coreSize=4 kat=2");
            return new Thread(runnable, "MspTaskHelper NEW #" + this.f25488a.getAndIncrement());
        }
    }

    static {
        try {
            ThreadPoolExecutor threadPoolExecutor = e;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.allowCoreThreadTimeOut(true);
            }
        } catch (Throwable th) {
            g.a(th);
        }
    }

    public static ThreadPoolExecutor a() {
        if (e == null) {
            synchronized (a.class) {
                if (e == null) {
                    ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(4, d, 2L, TimeUnit.SECONDS, new LinkedBlockingDeque(), new ThreadFactoryC0202a());
                    e = threadPoolExecutor;
                    threadPoolExecutor.allowCoreThreadTimeOut(true);
                }
            }
        }
        return e;
    }

    public static a b() {
        if (c == null) {
            synchronized (a.class) {
                if (c == null) {
                    c = new a();
                }
            }
        }
        return c;
    }

    public static void a(Runnable runnable) {
        a().execute(runnable);
    }
}
