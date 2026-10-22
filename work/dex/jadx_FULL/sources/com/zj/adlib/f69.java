package com.zj.adlib;

import android.util.Pair;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.DelegatingConsumer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ProducerContext;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class f69<T> implements Producer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public static final String f41608a = "ThrottlingProducer";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f16478a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Producer<T> f16479a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f16481a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public final ConcurrentLinkedQueue<Pair<Consumer<T>, ProducerContext>> f16480a = new ConcurrentLinkedQueue<>();

    @GuardedBy("this")
    public int b = 0;

    public class b extends DelegatingConsumer<T, T> {

        public class a implements Runnable {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ Pair f41610a;

            public a(Pair pair) {
                this.f41610a = pair;
            }

            @Override // java.lang.Runnable
            public void run() {
                f69 f69Var = f69.this;
                Pair pair = this.f41610a;
                f69Var.f((Consumer) pair.first, (ProducerContext) pair.second);
            }
        }

        public final void e() {
            Pair pair;
            synchronized (f69.this) {
                pair = (Pair) f69.this.f16480a.poll();
                if (pair == null) {
                    f69.d(f69.this);
                }
            }
            if (pair != null) {
                f69.this.f16481a.execute(new a(pair));
            }
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onCancellationImpl() {
            d().a();
            e();
        }

        @Override // com.facebook.imagepipeline.producers.DelegatingConsumer, com.facebook.imagepipeline.producers.BaseConsumer
        public void onFailureImpl(Throwable th) {
            d().onFailure(th);
            e();
        }

        @Override // com.facebook.imagepipeline.producers.BaseConsumer
        public void onNewResultImpl(T t, boolean z) {
            d().c(t, z);
            if (z) {
                e();
            }
        }

        public b(Consumer<T> consumer) {
            super(consumer);
        }
    }

    public f69(int i, Executor executor, Producer<T> producer) {
        this.f16478a = i;
        this.f16481a = (Executor) ax6.i(executor);
        this.f16479a = (Producer) ax6.i(producer);
    }

    public static /* synthetic */ int d(f69 f69Var) {
        int i = f69Var.b;
        f69Var.b = i - 1;
        return i;
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<T> consumer, ProducerContext producerContext) {
        boolean z;
        producerContext.c().g(producerContext.getId(), f41608a);
        synchronized (this) {
            int i = this.b;
            z = true;
            if (i >= this.f16478a) {
                this.f16480a.add(Pair.create(consumer, producerContext));
            } else {
                this.b = i + 1;
                z = false;
            }
        }
        if (z) {
            return;
        }
        f(consumer, producerContext);
    }

    public void f(Consumer<T> consumer, ProducerContext producerContext) {
        producerContext.c().c(producerContext.getId(), f41608a, null);
        this.f16479a.a(new b(consumer), producerContext);
    }
}
