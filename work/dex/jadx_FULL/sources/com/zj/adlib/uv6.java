package com.zj.adlib;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.Postprocessor;
import com.facebook.imagepipeline.request.RepeatedPostprocessor;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class uv6 implements Producer<rm1<CloseableImage>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final String f45234a = "PostprocessedBitmapMemoryCacheProducer";

    @VisibleForTesting
    public static final String b = "cached_value_found";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheKeyFactory f20138a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MemoryCache<CacheKey, CloseableImage> f20139a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Producer<rm1<CloseableImage>> f20140a;

    public static class a extends DelegatingConsumer<rm1<CloseableImage>, rm1<CloseableImage>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CacheKey f45235a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final MemoryCache<CacheKey, CloseableImage> f20141a;
        public final boolean b;

        public a(Consumer<rm1<CloseableImage>> consumer, CacheKey cacheKey, boolean z, MemoryCache<CacheKey, CloseableImage> memoryCache) {
            super(consumer);
            this.f45235a = cacheKey;
            this.b = z;
            this.f20141a = memoryCache;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(rm1<CloseableImage> rm1Var, boolean z) {
            if (rm1Var == null) {
                if (z) {
                    d().c(null, true);
                }
            } else if (z || this.b) {
                rm1<CloseableImage> rm1VarE = this.f20141a.e(this.f45235a, rm1Var);
                try {
                    d().b(1.0f);
                    Consumer<rm1<CloseableImage>> consumerD = d();
                    if (rm1VarE != null) {
                        rm1Var = rm1VarE;
                    }
                    consumerD.c(rm1Var, z);
                } finally {
                    rm1.p(rm1VarE);
                }
            }
        }
    }

    public uv6(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<rm1<CloseableImage>> producer) {
        this.f20139a = memoryCache;
        this.f20138a = cacheKeyFactory;
        this.f20140a = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<rm1<CloseableImage>> consumer, ProducerContext producerContext) {
        ProducerListener producerListenerC = producerContext.c();
        String id = producerContext.getId();
        ImageRequest imageRequestB = producerContext.b();
        Postprocessor postprocessorH = imageRequestB.h();
        if (postprocessorH == null || postprocessorH.b() == null) {
            this.f20140a.a(consumer, producerContext);
            return;
        }
        producerListenerC.g(id, getProducerName());
        CacheKey cacheKeyC = this.f20138a.c(imageRequestB);
        rm1<CloseableImage> rm1VarB = this.f20139a.b(cacheKeyC);
        if (rm1VarB == null) {
            a aVar = new a(consumer, cacheKeyC, postprocessorH instanceof RepeatedPostprocessor, this.f20139a);
            producerListenerC.c(id, getProducerName(), producerListenerC.h(id) ? ImmutableMap.of("cached_value_found", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE) : null);
            this.f20140a.a(aVar, producerContext);
        } else {
            producerListenerC.c(id, getProducerName(), producerListenerC.h(id) ? ImmutableMap.of("cached_value_found", "true") : null);
            consumer.b(1.0f);
            consumer.c(rm1VarB, true);
            rm1VarB.close();
        }
    }

    public String getProducerName() {
        return f45234a;
    }
}
