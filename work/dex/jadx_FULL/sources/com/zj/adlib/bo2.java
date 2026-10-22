package com.zj.adlib;

import bolts.Continuation;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.ImmutableMap;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.Map;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class bo2 implements Producer<q13> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final String f40791a = "DiskCacheProducer";

    @VisibleForTesting
    public static final String b = "cached_value_found";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f15588a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheKeyFactory f15589a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Producer<q13> f15590a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final l11 f15591a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f15592a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final l11 f15593b;

    public class a implements Continuation<q13, bolts.b<q13>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CacheKey f40792a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ l11 f15595a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AtomicBoolean f15596a;

        public a(l11 l11Var, CacheKey cacheKey, AtomicBoolean atomicBoolean) {
            this.f15595a = l11Var;
            this.f40792a = cacheKey;
            this.f15596a = atomicBoolean;
        }

        @Override // bolts.Continuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public bolts.b<q13> a(bolts.b<q13> bVar) throws Exception {
            if (bo2.j(bVar)) {
                return bVar;
            }
            return (bVar.B() || bVar.y() == null) ? this.f15595a.m(this.f40792a, this.f15596a) : bVar;
        }
    }

    public class b implements Continuation<q13, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CacheKey f40793a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Consumer f15597a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ProducerContext f15598a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ProducerListener f15599a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ l11 f15601a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ String f15602a;

        public b(ProducerListener producerListener, String str, Consumer consumer, l11 l11Var, CacheKey cacheKey, ProducerContext producerContext) {
            this.f15599a = producerListener;
            this.f15602a = str;
            this.f15597a = consumer;
            this.f15601a = l11Var;
            this.f40793a = cacheKey;
            this.f15598a = producerContext;
        }

        @Override // bolts.Continuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(bolts.b<q13> bVar) throws Exception {
            if (bo2.j(bVar)) {
                this.f15599a.i(this.f15602a, bo2.f40791a, null);
                this.f15597a.a();
            } else if (bVar.B()) {
                this.f15599a.j(this.f15602a, bo2.f40791a, bVar.x(), null);
                bo2 bo2Var = bo2.this;
                Consumer consumer = this.f15597a;
                bo2Var.k(consumer, new d(bo2Var, consumer, this.f15601a, this.f40793a, null), this.f15598a);
            } else {
                q13 q13VarY = bVar.y();
                if (q13VarY != null) {
                    ProducerListener producerListener = this.f15599a;
                    String str = this.f15602a;
                    producerListener.c(str, bo2.f40791a, bo2.i(producerListener, str, true));
                    this.f15597a.b(1.0f);
                    this.f15597a.c(q13VarY, true);
                    q13VarY.close();
                } else {
                    ProducerListener producerListener2 = this.f15599a;
                    String str2 = this.f15602a;
                    producerListener2.c(str2, bo2.f40791a, bo2.i(producerListener2, str2, false));
                    bo2 bo2Var2 = bo2.this;
                    Consumer consumer2 = this.f15597a;
                    bo2Var2.k(consumer2, new d(bo2Var2, consumer2, this.f15601a, this.f40793a, null), this.f15598a);
                }
            }
            return null;
        }
    }

    public class c extends qq0 {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AtomicBoolean f15603a;

        public c(AtomicBoolean atomicBoolean) {
            this.f15603a = atomicBoolean;
        }

        @Override // com.zj.adlib.qq0, com.facebook.imagepipeline.producers.ProducerContextCallbacks
        public void b() {
            this.f15603a.set(true);
        }
    }

    public class d extends DelegatingConsumer<q13, q13> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final CacheKey f40795a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final l11 f15605a;

        public /* synthetic */ d(bo2 bo2Var, Consumer consumer, l11 l11Var, CacheKey cacheKey, a aVar) {
            this(consumer, l11Var, cacheKey);
        }

        public d(Consumer<q13> consumer, l11 l11Var, CacheKey cacheKey) {
            super(consumer);
            this.f15605a = l11Var;
            this.f40795a = cacheKey;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(q13 q13Var, boolean z) {
            if (q13Var != null && z) {
                if (bo2.this.f15592a) {
                    int iV = q13Var.v();
                    if (iV <= 0 || iV >= bo2.this.f15588a) {
                        bo2.this.f15591a.o(this.f40795a, q13Var);
                    } else {
                        bo2.this.f15593b.o(this.f40795a, q13Var);
                    }
                } else {
                    this.f15605a.o(this.f40795a, q13Var);
                }
            }
            d().c(q13Var, z);
        }
    }

    public bo2(l11 l11Var, l11 l11Var2, CacheKeyFactory cacheKeyFactory, Producer<q13> producer, int i) {
        this.f15591a = l11Var;
        this.f15593b = l11Var2;
        this.f15589a = cacheKeyFactory;
        this.f15590a = producer;
        this.f15588a = i;
        this.f15592a = i > 0;
    }

    @VisibleForTesting
    public static Map<String, String> i(ProducerListener producerListener, String str, boolean z) {
        if (producerListener.h(str)) {
            return ImmutableMap.of("cached_value_found", String.valueOf(z));
        }
        return null;
    }

    public static boolean j(bolts.b<?> bVar) {
        return bVar.z() || (bVar.B() && (bVar.x() instanceof CancellationException));
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<q13> consumer, ProducerContext producerContext) {
        bolts.b<q13> bVarM;
        l11 l11Var;
        l11 l11Var2;
        ImageRequest imageRequestB = producerContext.b();
        if (!imageRequestB.p()) {
            k(consumer, consumer, producerContext);
            return;
        }
        producerContext.c().g(producerContext.getId(), f40791a);
        CacheKey cacheKeyB = this.f15589a.b(imageRequestB);
        l11 l11Var3 = imageRequestB.e() == ImageRequest.ImageType.SMALL ? this.f15593b : this.f15591a;
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (this.f15592a) {
            boolean zK = this.f15593b.k(cacheKeyB);
            boolean zK2 = this.f15591a.k(cacheKeyB);
            if (zK || !zK2) {
                l11Var = this.f15593b;
                l11Var2 = this.f15591a;
            } else {
                l11Var = this.f15591a;
                l11Var2 = this.f15593b;
            }
            bVarM = l11Var.m(cacheKeyB, atomicBoolean).s(new a(l11Var2, cacheKeyB, atomicBoolean));
        } else {
            bVarM = l11Var3.m(cacheKeyB, atomicBoolean);
        }
        bVarM.q(l(consumer, l11Var3, cacheKeyB, producerContext));
        m(atomicBoolean, producerContext);
    }

    public final void k(Consumer<q13> consumer, Consumer<q13> consumer2, ProducerContext producerContext) {
        if (producerContext.h().getValue() >= ImageRequest.RequestLevel.DISK_CACHE.getValue()) {
            consumer.c(null, true);
        } else {
            this.f15590a.a(consumer2, producerContext);
        }
    }

    public final Continuation<q13, Void> l(Consumer<q13> consumer, l11 l11Var, CacheKey cacheKey, ProducerContext producerContext) {
        return new b(producerContext.c(), producerContext.getId(), consumer, l11Var, cacheKey, producerContext);
    }

    public final void m(AtomicBoolean atomicBoolean, ProducerContext producerContext) {
        producerContext.g(new c(atomicBoolean));
    }
}
