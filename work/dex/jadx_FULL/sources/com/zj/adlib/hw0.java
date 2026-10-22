package com.zj.adlib;

import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CountingMemoryCache;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.cache.MemoryCacheTracker;
import com.facebook.imagepipeline.image.CloseableImage;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class hw0 {

    public static class a implements MemoryCacheTracker {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageCacheStatsTracker f42218a;

        public a(ImageCacheStatsTracker imageCacheStatsTracker) {
            this.f42218a = imageCacheStatsTracker;
        }

        @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
        public void a() {
            this.f42218a.f();
        }

        @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
        public void b() {
            this.f42218a.h();
        }

        @Override // com.facebook.imagepipeline.cache.MemoryCacheTracker
        public void c() {
            this.f42218a.e();
        }
    }

    public static MemoryCache<CacheKey, CloseableImage> a(CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache, ImageCacheStatsTracker imageCacheStatsTracker) {
        imageCacheStatsTracker.i(countingMemoryCache);
        return new nb4(countingMemoryCache, new a(imageCacheStatsTracker));
    }
}
