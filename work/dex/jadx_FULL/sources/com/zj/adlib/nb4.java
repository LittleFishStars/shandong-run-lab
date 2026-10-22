package com.zj.adlib;

import com.android.internal.util.Predicate;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.MemoryCacheTracker;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class nb4<K, V> implements MemoryCache<K, V> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MemoryCache<K, V> f43488a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MemoryCacheTracker f18385a;

    public nb4(MemoryCache<K, V> memoryCache, MemoryCacheTracker memoryCacheTracker) {
        this.f43488a = memoryCache;
        this.f18385a = memoryCacheTracker;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public rm1<V> b(K k) {
        rm1<V> rm1VarB = this.f43488a.b(k);
        if (rm1VarB == null) {
            this.f18385a.a();
        } else {
            this.f18385a.c();
        }
        return rm1VarB;
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public int c(Predicate<K> predicate) {
        return this.f43488a.c(predicate);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public rm1<V> e(K k, rm1<V> rm1Var) {
        this.f18385a.b();
        return this.f43488a.e(k, rm1Var);
    }

    @Override // com.facebook.imagepipeline.cache.MemoryCache
    public boolean f(Predicate<K> predicate) {
        return this.f43488a.f(predicate);
    }
}
