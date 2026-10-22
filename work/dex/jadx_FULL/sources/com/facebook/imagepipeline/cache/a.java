package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.image.CloseableImage;
import com.zj.adlib.ul5;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a {

    /* JADX INFO: renamed from: com.facebook.imagepipeline.cache.a$a, reason: collision with other inner class name */
    public static class C0636a implements ValueDescriptor<CloseableImage> {
        @Override // com.facebook.imagepipeline.cache.ValueDescriptor
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(CloseableImage closeableImage) {
            return closeableImage.h();
        }
    }

    public static CountingMemoryCache<CacheKey, CloseableImage> a(Supplier<ul5> supplier, MemoryTrimmableRegistry memoryTrimmableRegistry) {
        CountingMemoryCache<CacheKey, CloseableImage> countingMemoryCache = new CountingMemoryCache<>(new C0636a(), new b(), supplier);
        memoryTrimmableRegistry.b(countingMemoryCache);
        return countingMemoryCache;
    }
}
