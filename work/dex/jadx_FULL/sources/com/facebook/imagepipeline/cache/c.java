package com.facebook.imagepipeline.cache;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.common.memory.MemoryTrimmableRegistry;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.zj.adlib.ul5;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class c {

    public static class a implements ValueDescriptor<PooledByteBuffer> {
        @Override // com.facebook.imagepipeline.cache.ValueDescriptor
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public int a(PooledByteBuffer pooledByteBuffer) {
            return pooledByteBuffer.size();
        }
    }

    public static CountingMemoryCache<CacheKey, PooledByteBuffer> a(Supplier<ul5> supplier, MemoryTrimmableRegistry memoryTrimmableRegistry) {
        CountingMemoryCache<CacheKey, PooledByteBuffer> countingMemoryCache = new CountingMemoryCache<>(new a(), new d(), supplier);
        memoryTrimmableRegistry.b(countingMemoryCache);
        return countingMemoryCache;
    }
}
