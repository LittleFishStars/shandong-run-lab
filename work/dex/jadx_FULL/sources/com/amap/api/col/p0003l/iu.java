package com.amap.api.col.p0003l;

import com.zj.adlib.a7b;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class iu {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ThreadPoolExecutor f930a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ConcurrentHashMap<it, Future<?>> f929a = new ConcurrentHashMap<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public it.a f25976a = new a();

    public class a implements it.a {
        public a() {
        }

        @Override // com.amap.api.col.3l.it.a
        public final void a(it itVar) {
            iu.this.a(itVar, true);
        }

        @Override // com.amap.api.col.3l.it.a
        public final void b(it itVar) {
            iu.this.a(itVar, false);
        }
    }

    public final synchronized void a(it itVar, boolean z) {
        try {
            Future<?> futureRemove = this.f929a.remove(itVar);
            if (z && futureRemove != null) {
                futureRemove.cancel(true);
            }
        } catch (Throwable th) {
            a7b.m(th, "TPool", "removeQueue");
            th.printStackTrace();
        }
    }

    public final void b(it itVar) {
        ThreadPoolExecutor threadPoolExecutor;
        if (d(itVar) || (threadPoolExecutor = this.f930a) == null || threadPoolExecutor.isShutdown()) {
            return;
        }
        itVar.f = this.f25976a;
        try {
            Future<?> futureSubmit = this.f930a.submit(itVar);
            if (futureSubmit == null) {
                return;
            }
            c(itVar, futureSubmit);
        } catch (RejectedExecutionException e) {
            a7b.m(e, "TPool", "addTask");
        }
    }

    public final synchronized void c(it itVar, Future<?> future) {
        try {
            this.f929a.put(itVar, future);
        } catch (Throwable th) {
            a7b.m(th, "TPool", "addQueue");
            th.printStackTrace();
        }
    }

    public final synchronized boolean d(it itVar) {
        boolean zContainsKey;
        try {
            zContainsKey = this.f929a.containsKey(itVar);
        } catch (Throwable th) {
            a7b.m(th, "TPool", "contain");
            th.printStackTrace();
            zContainsKey = false;
        }
        return zContainsKey;
    }

    public final Executor e() {
        return this.f930a;
    }

    public final void f() {
        try {
            Iterator<Map.Entry<it, Future<?>>> it = this.f929a.entrySet().iterator();
            while (it.hasNext()) {
                Future<?> future = this.f929a.get(it.next().getKey());
                if (future != null) {
                    try {
                        future.cancel(true);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
            this.f929a.clear();
        } catch (Throwable th) {
            a7b.m(th, "TPool", "destroy");
            th.printStackTrace();
        }
        ThreadPoolExecutor threadPoolExecutor = this.f930a;
        if (threadPoolExecutor != null) {
            threadPoolExecutor.shutdown();
        }
    }

    public final void a(long j, TimeUnit timeUnit) {
        try {
            ThreadPoolExecutor threadPoolExecutor = this.f930a;
            if (threadPoolExecutor != null) {
                threadPoolExecutor.awaitTermination(j, timeUnit);
            }
        } catch (InterruptedException unused) {
        }
    }
}
