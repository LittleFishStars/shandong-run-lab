package com.zj.adlib;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.MemoryCacheTracker;
import com.facebook.imagepipeline.memory.PooledByteBuffer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class r13 {

    public static class a implements MemoryCacheTracker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageCacheStatsTracker f44341a;

        public a(ImageCacheStatsTracker imageCacheStatsTracker) {
            this.f44341a = imageCacheStatsTracker;
        }

        @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
        public void a() {
            this.f44341a.j();
        }

        @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
        public void b() {
            this.f44341a.l();
        }

        @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
        public void c() {
            this.f44341a.k();
        }
    }

    public static MemoryCache<CacheKey, PooledByteBuffer> a(CountingMemoryCache<CacheKey, PooledByteBuffer> countingMemoryCache, ImageCacheStatsTracker imageCacheStatsTracker) {
        imageCacheStatsTracker.m(countingMemoryCache);
        return new nb4(countingMemoryCache, new a(imageCacheStatsTracker));
    }
}
