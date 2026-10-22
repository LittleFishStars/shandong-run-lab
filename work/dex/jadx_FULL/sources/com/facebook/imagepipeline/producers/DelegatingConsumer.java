package com.facebook.imagepipeline.producers;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class DelegatingConsumer<I, O> extends BaseConsumer<I> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Consumer<O> f30011a;

    public DelegatingConsumer(Consumer<O> consumer) {
        this.f30011a = consumer;
    }

    public Consumer<O> d() {
        return this.f30011a;
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void onCancellationImpl() {
        this.f30011a.a();
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void onFailureImpl(Throwable th) {
        this.f30011a.onFailure(th);
    }

    @Override // com.facebook.imagepipeline.producers.BaseConsumer
    public void onProgressUpdateImpl(float f) {
        this.f30011a.b(f);
    }
}
