package com.zj.adlib;

import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class yz0 implements Producer<q13> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Producer<q13> f46144a;
    public final Producer<q13> b;

    public class b extends DelegatingConsumer<q13, q13> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public ProducerContext f46145a;

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            yz0.this.b.a(d(), this.f46145a);
        }

        public b(Consumer<q13> consumer, ProducerContext producerContext) {
            super(consumer);
            this.f46145a = producerContext;
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(q13 q13Var, boolean z) {
            ImageRequest imageRequestB = this.f46145a.b();
            boolean zC = n69.c(q13Var, imageRequestB.m());
            if (q13Var != null && (zC || imageRequestB.f())) {
                d().c(q13Var, z && zC);
            }
            if (!z || zC) {
                return;
            }
            q13.j(q13Var);
            yz0.this.b.a(d(), this.f46145a);
        }
    }

    public yz0(Producer<q13> producer, Producer<q13> producer2) {
        this.f46144a = producer;
        this.b = producer2;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<q13> consumer, ProducerContext producerContext) {
        this.f46144a.a(new b(consumer, producerContext), producerContext);
    }
}
