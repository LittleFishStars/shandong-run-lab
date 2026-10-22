package com.zj.adlib;

import android.util.Pair;
import com.facebook.cache.common.CacheKey;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.producers.MultiplexProducer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class kw0 extends MultiplexProducer<Pair<CacheKey, ImageRequest.RequestLevel>, rm1<CloseableImage>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CacheKeyFactory f42925a;

    public kw0(CacheKeyFactory cacheKeyFactory, Producer producer) {
        super(producer);
        this.f42925a = cacheKeyFactory;
    }

    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public rm1<CloseableImage> cloneOrNull(rm1<CloseableImage> rm1Var) {
        return rm1.l(rm1Var);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.facebook.imagepipeline.producers.MultiplexProducer
    public Pair<CacheKey, ImageRequest.RequestLevel> getKey(ProducerContext producerContext) {
        return Pair.create(this.f42925a.a(producerContext.b()), producerContext.h());
    }
}
