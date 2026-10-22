package com.zj.adlib;

import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class l10 implements Producer<q13> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Producer<q13> f42962a;

    public static class b extends DelegatingConsumer<q13, q13> {
        public b(Consumer<q13> consumer) {
            super(consumer);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(q13 q13Var, boolean z) {
            if (q13Var == null) {
                d().c(null, z);
                return;
            }
            if (!q13.E(q13Var)) {
                q13Var.J();
            }
            d().c(q13Var, z);
        }
    }

    public l10(Producer<q13> producer) {
        this.f42962a = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<q13> consumer, ProducerContext producerContext) {
        this.f42962a.a(new b(consumer), producerContext);
    }
}
