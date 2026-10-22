package com.zj.adlib;

import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class iw0 extends lw0 {

    @VisibleForTesting
    public static final String c = "BitmapMemoryCacheGetProducer";

    public iw0(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<rm1<CloseableImage>> producer) {
        super(memoryCache, cacheKeyFactory, producer);
    }

    @Override // com.zj.adlib.lw0
    public String getProducerName() {
        return c;
    }

    @Override // com.zj.adlib.lw0
    public Consumer<rm1<CloseableImage>> wrapConsumer(Consumer<rm1<CloseableImage>> consumer, CacheKey cacheKey) {
        return consumer;
    }
}
