package com.google.common.util.concurrent;

import com.google.common.annotations.Beta;
import com.google.common.annotations.GwtCompatible;
import com.google.common.annotations.GwtIncompatible;
import com.google.common.base.Supplier;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible(emulated = true)
public final class b {

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class a<T> implements Callable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Object f32406a;

        public a(Object obj) {
            this.f32406a = obj;
        }

        @Override // java.util.concurrent.Callable
        @ParametricNullness
        public T call() {
            return (T) this.f32406a;
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.google.common.util.concurrent.b$b, reason: collision with other inner class name */
    public class C0759b<T> implements AsyncCallable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ListeningExecutorService f32407a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Callable f6574a;

        public C0759b(ListeningExecutorService listeningExecutorService, Callable callable) {
            this.f32407a = listeningExecutorService;
            this.f6574a = callable;
        }

        @Override // com.google.common.util.concurrent.AsyncCallable
        public ListenableFuture<T> call() throws Exception {
            return this.f32407a.submit(this.f6574a);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class c<T> implements Callable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Supplier f32408a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Callable f6575a;

        public c(Supplier supplier, Callable callable) {
            this.f32408a = supplier;
            this.f6575a = callable;
        }

        @Override // java.util.concurrent.Callable
        @ParametricNullness
        public T call() throws Exception {
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            boolean zF = b.f((String) this.f32408a.get(), threadCurrentThread);
            try {
                return (T) this.f6575a.call();
            } finally {
                if (zF) {
                    b.f(name, threadCurrentThread);
                }
            }
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Supplier f32409a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Runnable f6576a;

        public d(Supplier supplier, Runnable runnable) {
            this.f32409a = supplier;
            this.f6576a = runnable;
        }

        @Override // java.lang.Runnable
        public void run() {
            Thread threadCurrentThread = Thread.currentThread();
            String name = threadCurrentThread.getName();
            boolean zF = b.f((String) this.f32409a.get(), threadCurrentThread);
            try {
                this.f6576a.run();
            } finally {
                if (zF) {
                    b.f(name, threadCurrentThread);
                }
            }
        }
    }

    @Beta
    @GwtIncompatible
    public static <T> AsyncCallable<T> b(Callable<T> callable, ListeningExecutorService listeningExecutorService) {
        com.google.common.base.i.E(callable);
        com.google.common.base.i.E(listeningExecutorService);
        return new C0759b(listeningExecutorService, callable);
    }

    public static <T> Callable<T> c(@ParametricNullness T t) {
        return new a(t);
    }

    @GwtIncompatible
    public static Runnable d(Runnable runnable, Supplier<String> supplier) {
        com.google.common.base.i.E(supplier);
        com.google.common.base.i.E(runnable);
        return new d(supplier, runnable);
    }

    @GwtIncompatible
    public static <T> Callable<T> e(Callable<T> callable, Supplier<String> supplier) {
        com.google.common.base.i.E(supplier);
        com.google.common.base.i.E(callable);
        return new c(supplier, callable);
    }

    @GwtIncompatible
    public static boolean f(String str, Thread thread) {
        try {
            thread.setName(str);
            return true;
        } catch (SecurityException unused) {
            return false;
        }
    }
}
