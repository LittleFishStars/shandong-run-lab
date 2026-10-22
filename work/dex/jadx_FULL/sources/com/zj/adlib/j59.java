package com.zj.adlib;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.producers.StatefulProducerRunnable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class j59<T> implements Producer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final String f42512a = "BackgroundThreadHandoffProducer";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Producer<T> f17328a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final k59 f17329a;

    public class a extends StatefulProducerRunnable<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ProducerContext f42513a;
        public final /* synthetic */ Consumer b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final /* synthetic */ ProducerListener f17331b;
        public final /* synthetic */ String h;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Consumer consumer, ProducerListener producerListener, String str, String str2, ProducerListener producerListener2, String str3, Consumer consumer2, ProducerContext producerContext) {
            super(consumer, producerListener, str, str2);
            this.f17331b = producerListener2;
            this.h = str3;
            this.b = consumer2;
            this.f42513a = producerContext;
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
        public void disposeResult(T t) {
        }

        @Override // com.facebook.common.executors.StatefulRunnable
        public T getResult() throws Exception {
            return null;
        }

        @Override // com.facebook.imagepipeline.producers.StatefulProducerRunnable, com.facebook.common.executors.StatefulRunnable
        public void onSuccess(T t) {
            this.f17331b.c(this.h, j59.f42512a, null);
            j59.this.f17328a.a(this.b, this.f42513a);
        }
    }

    public class b extends qq0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ StatefulProducerRunnable f42514a;

        public b(StatefulProducerRunnable statefulProducerRunnable) {
            this.f42514a = statefulProducerRunnable;
        }

        @Override // com.zj.adlib.qq0, com.facebook.imagepipeline.producers.ProducerContextCallbacks
        public void b() {
            this.f42514a.b();
            j59.this.f17329a.d(this.f42514a);
        }
    }

    public j59(Producer<T> producer, k59 k59Var) {
        this.f17328a = (Producer) ax6.i(producer);
        this.f17329a = k59Var;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<T> consumer, ProducerContext producerContext) {
        ProducerListener producerListenerC = producerContext.c();
        String id = producerContext.getId();
        a aVar = new a(consumer, producerListenerC, f42512a, id, producerListenerC, id, consumer, producerContext);
        producerContext.g(new b(aVar));
        this.f17329a.a(aVar);
    }
}
