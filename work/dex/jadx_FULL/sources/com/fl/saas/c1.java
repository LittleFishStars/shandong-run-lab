package com.fl.saas;

import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class c1 {
    private static final int e;
    private static final int f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ThreadPoolExecutor f30145a;
    private final ScheduledExecutorService b;
    private final LinkedBlockingQueue c;
    public Runnable d;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        Runnable f30146a = null;

        public a() {
        }

        /* JADX INFO: Infinite loop detected, blocks: 13, insns: 0 */
        @Override // java.lang.Runnable
        public void run() {
            while (true) {
                try {
                    this.f30146a = null;
                    this.f30146a = (Runnable) c1.this.c.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (this.f30146a != null) {
                    c1.this.f30145a.execute(this.f30146a);
                }
            }
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private static final c1 f30147a = new c1(null);
    }

    static {
        int iAvailableProcessors = Runtime.getRuntime().availableProcessors();
        e = iAvailableProcessors;
        f = (iAvailableProcessors * 2) + 1;
    }

    private c1() {
        this.c = new LinkedBlockingQueue();
        this.d = new a();
        int i = e;
        this.b = Executors.newScheduledThreadPool(i);
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(i, f, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(128), new RejectedExecutionHandler() { // from class: com.zj.adlib.gra
            @Override // java.util.concurrent.RejectedExecutionHandler
            public final void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor2) {
                this.f41975a.a(runnable, threadPoolExecutor2);
            }
        });
        this.f30145a = threadPoolExecutor;
        threadPoolExecutor.execute(this.d);
    }

    public void c(Runnable runnable) {
        if (runnable != null) {
            try {
                this.f30145a.remove(runnable);
                this.c.remove(runnable);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public /* synthetic */ c1(a aVar) {
        this();
    }

    private void a(Runnable runnable) {
        if (runnable != null) {
            try {
                this.c.put(runnable);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public void b(Runnable runnable) {
        if (runnable != null) {
            try {
                this.f30145a.execute(runnable);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public static c1 a() {
        return b.f30147a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void a(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        a(runnable);
    }

    public void a(Runnable runnable, long j, TimeUnit timeUnit) {
        this.b.schedule(runnable, j, timeUnit);
    }
}
