package com.google.common.cache;

import com.google.common.annotations.GwtCompatible;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Callable;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutionException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
@ElementTypesAreNonnullByDefault
@GwtCompatible
public abstract class AbstractCache<K, V> implements Cache<K, V> {

    public interface StatsCounter {
        com.google.common.cache.a a();

        void b();

        void c(long j);

        void d(long j);

        void e(int i);

        void f(int i);
    }

    public static final class a implements StatsCounter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final LongAddable f31608a = LongAddables.a();
        public final LongAddable b = LongAddables.a();
        public final LongAddable c = LongAddables.a();
        public final LongAddable d = LongAddables.a();
        public final LongAddable e = LongAddables.a();
        public final LongAddable f = LongAddables.a();

        public static long h(long j) {
            if (j >= 0) {
                return j;
            }
            return Long.MAX_VALUE;
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public com.google.common.cache.a a() {
            return new com.google.common.cache.a(h(this.f31608a.sum()), h(this.b.sum()), h(this.c.sum()), h(this.d.sum()), h(this.e.sum()), h(this.f.sum()));
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void b() {
            this.f.increment();
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void c(long j) {
            this.d.increment();
            this.e.add(j);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void d(long j) {
            this.c.increment();
            this.e.add(j);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void e(int i) {
            this.b.add(i);
        }

        @Override // com.google.common.cache.AbstractCache.StatsCounter
        public void f(int i) {
            this.f31608a.add(i);
        }

        public void g(StatsCounter statsCounter) {
            com.google.common.cache.a aVarA = statsCounter.a();
            this.f31608a.add(aVarA.c());
            this.b.add(aVarA.j());
            this.c.add(aVarA.h());
            this.d.add(aVarA.f());
            this.e.add(aVarA.n());
            this.f.add(aVarA.b());
        }
    }

    @Override // com.google.common.cache.Cache
    public ConcurrentMap<K, V> asMap() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void cleanUp() {
    }

    @Override // com.google.common.cache.Cache
    public V get(K k, Callable<? extends V> callable) throws ExecutionException {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public ImmutableMap<K, V> getAllPresent(Iterable<? extends Object> iterable) {
        V ifPresent;
        LinkedHashMap linkedHashMapC0 = Maps.c0();
        for (Object obj : iterable) {
            if (!linkedHashMapC0.containsKey(obj) && (ifPresent = getIfPresent(obj)) != null) {
                linkedHashMapC0.put(obj, ifPresent);
            }
        }
        return ImmutableMap.copyOf((Map) linkedHashMapC0);
    }

    @Override // com.google.common.cache.Cache
    public void invalidate(Object obj) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll(Iterable<? extends Object> iterable) {
        Iterator<? extends Object> it = iterable.iterator();
        while (it.hasNext()) {
            invalidate(it.next());
        }
    }

    @Override // com.google.common.cache.Cache
    public void put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void putAll(Map<? extends K, ? extends V> map) {
        for (Map.Entry<? extends K, ? extends V> entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override // com.google.common.cache.Cache
    public long size() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public com.google.common.cache.a stats() {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.common.cache.Cache
    public void invalidateAll() {
        throw new UnsupportedOperationException();
    }
}
