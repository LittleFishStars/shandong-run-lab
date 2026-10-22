package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtIncompatible;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@Beta
@ElementTypesAreNonnullByDefault
@GwtIncompatible
public final class h {

    public static class a<V> extends ForwardingFuture<V> implements ListenableFuture<V> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final ThreadFactory f32423a;
        public static final Executor b;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final c f6590a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Executor f6591a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Future<V> f6592a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AtomicBoolean f6593a;

        /* JADX INFO: renamed from: com.google.common.util.concurrent.h$a$a, reason: collision with other inner class name */
        public class RunnableC0761a implements Runnable {
            public RunnableC0761a() {
            }

            @Override // java.lang.Runnable
            public void run() {
                try {
                    s.f(a.this.f6592a);
                } catch (Throwable unused) {
                }
                a.this.f6590a.b();
            }
        }

        static {
            ThreadFactory threadFactoryB = new q().e(true).f("ListenableFutureAdapter-thread-%d").b();
            f32423a = threadFactoryB;
            b = Executors.newCachedThreadPool(threadFactoryB);
        }

        public a(Future<V> future) {
            this(future, b);
        }

        @Override // com.google.common.util.concurrent.ListenableFuture
        public void addListener(Runnable runnable, Executor executor) {
            this.f6590a.a(runnable, executor);
            if (this.f6593a.compareAndSet(false, true)) {
                if (this.f6592a.isDone()) {
                    this.f6590a.b();
                } else {
                    this.f6591a.execute(new RunnableC0761a());
                }
            }
        }

        public a(Future<V> future, Executor executor) {
            this.f6590a = new c();
            this.f6593a = new AtomicBoolean(false);
            this.f6592a = (Future) com.google.common.base.i.E(future);
            this.f6591a = (Executor) com.google.common.base.i.E(executor);
        }

        @Override // com.google.common.util.concurrent.ForwardingFuture, com.google.common.collect.ForwardingObject
        public Future<V> delegate() {
            return this.f6592a;
        }
    }

    public static <V> ListenableFuture<V> a(Future<V> future) {
        return future instanceof ListenableFuture ? (ListenableFuture) future : new a(future);
    }

    public static <V> ListenableFuture<V> b(Future<V> future, Executor executor) {
        com.google.common.base.i.E(executor);
        return future instanceof ListenableFuture ? (ListenableFuture) future : new a(future, executor);
    }
}
