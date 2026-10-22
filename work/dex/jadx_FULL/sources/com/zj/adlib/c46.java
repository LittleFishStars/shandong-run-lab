package com.zj.adlib;

import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class c46<T> implements Producer<T> {
    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<T> consumer, ProducerContext producerContext) {
        consumer.c(null, true);
    }
}
