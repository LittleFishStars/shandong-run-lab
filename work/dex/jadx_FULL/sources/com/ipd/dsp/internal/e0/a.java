package com.ipd.dsp.internal.e0;

import androidx.annotation.NonNull;
import androidx.core.util.Pools;
import com.ipd.dsp.Dsp;
import com.ipd.dsp.internal.c2.k;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f38288a = "FactoryPools";
    public static final int b = 20;
    public static final g<Object> c = new C0877a();

    /* JADX INFO: renamed from: com.ipd.dsp.internal.e0.a$a, reason: collision with other inner class name */
    public class C0877a implements g<Object> {
        @Override // com.ipd.dsp.internal.e0.a.g
        public void a(@NonNull Object obj) {
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class b<T> implements d<List<T>> {
        @Override // com.ipd.dsp.internal.e0.a.d
        @NonNull
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public List<T> a() {
            return new ArrayList();
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    public class c<T> implements g<List<T>> {
        @Override // com.ipd.dsp.internal.e0.a.g
        public void a(@NonNull List<T> list) {
            list.clear();
        }
    }

    public interface d<T> {
        T a();
    }

    public static final class e<T> implements Pools.Pool<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d<T> f38289a;
        public final g<T> b;
        public final Pools.Pool<T> c;

        public e(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
            this.c = pool;
            this.f38289a = dVar;
            this.b = gVar;
        }

        @Override // androidx.core.util.Pools.Pool
        public T acquire() {
            T tAcquire = this.c.acquire();
            if (tAcquire == null) {
                tAcquire = this.f38289a.a();
                if (Dsp.isDebugLogEnable()) {
                    k.e(a.f38288a, "Created new " + tAcquire.getClass());
                }
            }
            if (tAcquire instanceof f) {
                ((f) tAcquire).b().a(false);
            }
            return tAcquire;
        }

        @Override // androidx.core.util.Pools.Pool
        public boolean release(@NonNull T t) {
            if (t instanceof f) {
                ((f) t).b().a(true);
            }
            this.b.a(t);
            return this.c.release(t);
        }
    }

    public interface f {
        @NonNull
        com.ipd.dsp.internal.e0.c b();
    }

    public interface g<T> {
        void a(@NonNull T t);
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> a(int i, @NonNull d<T> dVar) {
        return a(new Pools.SimplePool(i), dVar);
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> b(int i, @NonNull d<T> dVar) {
        return a(new Pools.SynchronizedPool(i), dVar);
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> a(int i, @NonNull d<T> dVar, @NonNull g<T> gVar) {
        return a(new Pools.SynchronizedPool(i), dVar, gVar);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> b() {
        return a(20);
    }

    @NonNull
    public static <T> Pools.Pool<List<T>> a(int i) {
        return a(new Pools.SynchronizedPool(i), new b(), new c());
    }

    @NonNull
    public static <T extends f> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar) {
        return a(pool, dVar, a());
    }

    @NonNull
    public static <T> Pools.Pool<T> a(@NonNull Pools.Pool<T> pool, @NonNull d<T> dVar, @NonNull g<T> gVar) {
        return new e(pool, dVar, gVar);
    }

    @NonNull
    public static <T> g<T> a() {
        return (g<T>) c;
    }
}
