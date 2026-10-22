package com.zj.adlib;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.producers.MultiplexProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class o13 extends MultiplexProducer<Pair<CacheKey, ImageRequest.RequestLevel>, q13> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CacheKeyFactory f43646a;

    public o13(CacheKeyFactory cacheKeyFactory, Producer producer) {
        super(producer);
        this.f43646a = cacheKeyFactory;
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public q13 cloneOrNull(q13 q13Var) {
        return q13.h(q13Var);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public Pair<CacheKey, ImageRequest.RequestLevel> getKey(ProducerContext producerContext) {
        return Pair.create(this.f43646a.b(producerContext.b()), producerContext.h());
    }
}
