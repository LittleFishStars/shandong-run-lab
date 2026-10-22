package com.zj.adlib;

import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class se7 implements Producer<rm1<PooledByteBuffer>> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Producer<q13> f44672a;

    public class b extends DelegatingConsumer<q13, rm1<PooledByteBuffer>> {
        public b(Consumer<rm1<PooledByteBuffer>> consumer) {
            super(consumer);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(q13 q13Var, boolean z) {
            rm1<PooledByteBuffer> rm1VarL = null;
            try {
                rm1VarL = q13.H(q13Var) ? q13Var.l() : null;
                d().c(rm1VarL, z);
            } finally {
                rm1.p(rm1VarL);
            }
        }
    }

    public se7(Producer<q13> producer) {
        this.f44672a = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<rm1<PooledByteBuffer>> consumer, ProducerContext producerContext) {
        this.f44672a.a(new b(consumer), producerContext);
    }
}
