package com.zj.adlib;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.image.QualityInfo;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class lw0 implements Producer<rm1<CloseableImage>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final String f43169a = "BitmapMemoryCacheProducer";

    @VisibleForTesting
    public static final String b = "cached_value_found";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheKeyFactory f18094a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MemoryCache<CacheKey, CloseableImage> f18095a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Producer<rm1<CloseableImage>> f18096a;

    public class a extends DelegatingConsumer<rm1<CloseableImage>, rm1<CloseableImage>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CacheKey f43170a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer consumer, CacheKey cacheKey) {
            super(consumer);
            this.f43170a = cacheKey;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(rm1<CloseableImage> rm1Var, boolean z) {
            rm1<CloseableImage> rm1VarB;
            if (rm1Var == null) {
                if (z) {
                    d().c(null, true);
                    return;
                }
                return;
            }
            if (rm1Var.s().j()) {
                d().c(rm1Var, z);
                return;
            }
            if (!z && (rm1VarB = lw0.this.f18095a.b(this.f43170a)) != null) {
                try {
                    QualityInfo qualityInfoG = rm1Var.s().g();
                    QualityInfo qualityInfoG2 = rm1VarB.s().g();
                    if (qualityInfoG2.c() || qualityInfoG2.b() >= qualityInfoG.b()) {
                        d().c(rm1VarB, false);
                        rm1.p(rm1VarB);
                        return;
                    }
                    rm1.p(rm1VarB);
                } catch (Throwable th) {
                    rm1.p(rm1VarB);
                    throw th;
                }
            }
            rm1<CloseableImage> rm1VarE = lw0.this.f18095a.e(this.f43170a, rm1Var);
            if (z) {
                try {
                    d().b(1.0f);
                } finally {
                    rm1.p(rm1VarE);
                }
            }
            Consumer<rm1<CloseableImage>> consumerD = d();
            if (rm1VarE != null) {
                rm1Var = rm1VarE;
            }
            consumerD.c(rm1Var, z);
        }
    }

    public lw0(MemoryCache<CacheKey, CloseableImage> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<rm1<CloseableImage>> producer) {
        this.f18095a = memoryCache;
        this.f18094a = cacheKeyFactory;
        this.f18096a = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<rm1<CloseableImage>> consumer, ProducerContext producerContext) {
        ProducerListener producerListenerC = producerContext.c();
        String id = producerContext.getId();
        producerListenerC.g(id, getProducerName());
        CacheKey cacheKeyA = this.f18094a.a(producerContext.b());
        rm1<CloseableImage> rm1VarB = this.f18095a.b(cacheKeyA);
        if (rm1VarB != null) {
            boolean zC = rm1VarB.s().g().c();
            if (zC) {
                producerListenerC.c(id, getProducerName(), producerListenerC.h(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                consumer.b(1.0f);
            }
            consumer.c(rm1VarB, zC);
            rm1VarB.close();
            if (zC) {
                return;
            }
        }
        if (producerContext.h().getValue() >= ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE.getValue()) {
            producerListenerC.c(id, getProducerName(), producerListenerC.h(id) ? ImmutableMap.of("cached_value_found", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE) : null);
            consumer.c(null, true);
        } else {
            Consumer<rm1<CloseableImage>> consumerWrapConsumer = wrapConsumer(consumer, cacheKeyA);
            producerListenerC.c(id, getProducerName(), producerListenerC.h(id) ? ImmutableMap.of("cached_value_found", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE) : null);
            this.f18096a.a(consumerWrapConsumer, producerContext);
        }
    }

    public String getProducerName() {
        return f43169a;
    }

    public Consumer<rm1<CloseableImage>> wrapConsumer(Consumer<rm1<CloseableImage>> consumer, CacheKey cacheKey) {
        return new a(consumer, cacheKey);
    }
}
