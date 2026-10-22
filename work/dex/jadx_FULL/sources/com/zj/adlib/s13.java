package com.zj.adlib;

import com.aliyun.svideosdk.preview.camera.AliyunRecorderProperty;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class s13 implements Producer<q13> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final String f44584a = "EncodedMemoryCacheProducer";

    @VisibleForTesting
    public static final String b = "cached_value_found";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheKeyFactory f19495a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MemoryCache<CacheKey, PooledByteBuffer> f19496a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Producer<q13> f19497a;

    public class a extends DelegatingConsumer<q13, q13> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CacheKey f44585a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer consumer, CacheKey cacheKey) {
            super(consumer);
            this.f44585a = cacheKey;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(q13 q13Var, boolean z) {
            if (!z || q13Var == null) {
                d().c(q13Var, z);
                return;
            }
            rm1<PooledByteBuffer> rm1VarL = q13Var.l();
            if (rm1VarL != null) {
                try {
                    rm1 rm1VarE = s13.this.f19496a.e(this.f44585a, rm1VarL);
                    rm1.p(rm1VarL);
                    if (rm1VarE != null) {
                        try {
                            q13 q13Var2 = new q13((rm1<PooledByteBuffer>) rm1VarE);
                            q13Var2.k(q13Var);
                            rm1.p(rm1VarE);
                            try {
                                d().b(1.0f);
                                d().c(q13Var2, true);
                                return;
                            } finally {
                                q13.j(q13Var2);
                            }
                        } catch (Throwable th) {
                            rm1.p(rm1VarE);
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    rm1.p(rm1VarL);
                    throw th2;
                }
            }
            d().c(q13Var, true);
        }
    }

    public s13(MemoryCache<CacheKey, PooledByteBuffer> memoryCache, CacheKeyFactory cacheKeyFactory, Producer<q13> producer) {
        this.f19496a = memoryCache;
        this.f19495a = cacheKeyFactory;
        this.f19497a = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<q13> consumer, ProducerContext producerContext) {
        String id = producerContext.getId();
        ProducerListener producerListenerC = producerContext.c();
        producerListenerC.g(id, f44584a);
        CacheKey cacheKeyB = this.f19495a.b(producerContext.b());
        rm1<PooledByteBuffer> rm1VarB = this.f19496a.b(cacheKeyB);
        try {
            if (rm1VarB != null) {
                q13 q13Var = new q13(rm1VarB);
                try {
                    producerListenerC.c(id, f44584a, producerListenerC.h(id) ? ImmutableMap.of("cached_value_found", "true") : null);
                    consumer.b(1.0f);
                    consumer.c(q13Var, true);
                    q13.j(q13Var);
                    rm1.p(rm1VarB);
                    return;
                } catch (Throwable th) {
                    q13.j(q13Var);
                    throw th;
                }
            }
            if (producerContext.h().getValue() >= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue()) {
                producerListenerC.c(id, f44584a, producerListenerC.h(id) ? ImmutableMap.of("cached_value_found", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE) : null);
                consumer.c(null, true);
                rm1.p(rm1VarB);
            } else {
                a aVar = new a(consumer, cacheKeyB);
                producerListenerC.c(id, f44584a, producerListenerC.h(id) ? ImmutableMap.of("cached_value_found", AliyunRecorderProperty.SURFACE_ROTATION_MODE_FALSE) : null);
                this.f19497a.a(aVar, producerContext);
                rm1.p(rm1VarB);
            }
        } catch (Throwable th2) {
            rm1.p(rm1VarB);
            throw th2;
        }
    }
}
