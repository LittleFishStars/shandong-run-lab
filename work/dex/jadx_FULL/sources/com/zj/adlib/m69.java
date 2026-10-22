package com.zj.adlib;

import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ThumbnailProducer;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class m69 implements Producer<q13> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final ThumbnailProducer<q13>[] f43234a;

    public class a extends DelegatingConsumer<q13, q13> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f43235a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final ProducerContext f18144a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final sf7 f18146a;

        public a(Consumer<q13> consumer, ProducerContext producerContext, int i) {
            super(consumer);
            this.f18144a = producerContext;
            this.f43235a = i;
            this.f18146a = producerContext.b().m();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            if (m69.this.e(this.f43235a + 1, d(), this.f18144a)) {
                return;
            }
            d().onFailure(th);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(q13 q13Var, boolean z) {
            if (q13Var != null && (!z || n69.c(q13Var, this.f18146a))) {
                d().c(q13Var, z);
            } else if (z) {
                q13.j(q13Var);
                if (m69.this.e(this.f43235a + 1, d(), this.f18144a)) {
                    return;
                }
                d().c(null, true);
            }
        }
    }

    public m69(ThumbnailProducer<q13>... thumbnailProducerArr) {
        ThumbnailProducer<q13>[] thumbnailProducerArr2 = (ThumbnailProducer[]) ax6.i(thumbnailProducerArr);
        this.f43234a = thumbnailProducerArr2;
        ax6.g(0, thumbnailProducerArr2.length);
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<q13> consumer, ProducerContext producerContext) {
        if (producerContext.b().m() == null) {
            consumer.c(null, true);
        } else {
            if (e(0, consumer, producerContext)) {
                return;
            }
            consumer.c(null, true);
        }
    }

    public final int d(int i, sf7 sf7Var) {
        while (true) {
            ThumbnailProducer<q13>[] thumbnailProducerArr = this.f43234a;
            if (i >= thumbnailProducerArr.length) {
                return -1;
            }
            if (thumbnailProducerArr[i].b(sf7Var)) {
                return i;
            }
            i++;
        }
    }

    public final boolean e(int i, Consumer<q13> consumer, ProducerContext producerContext) {
        int iD = d(i, producerContext.b().m());
        if (iD == -1) {
            return false;
        }
        this.f43234a[iD].a(new a(consumer, producerContext, iD), producerContext);
        return true;
    }
}
