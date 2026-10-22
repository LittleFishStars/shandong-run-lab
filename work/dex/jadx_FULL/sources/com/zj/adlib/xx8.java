package com.zj.adlib;

import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class xx8<T> implements Producer<Void> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Producer<T> f45914a;

    public class a extends DelegatingConsumer<T, Void> {
        public a(Consumer consumer) {
            super(consumer);
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(T t, boolean z) {
            if (z) {
                d().c(null, z);
            }
        }
    }

    public xx8(Producer<T> producer) {
        this.f45914a = producer;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<Void> consumer, ProducerContext producerContext) {
        this.f45914a.a(new a(consumer), producerContext);
    }
}
