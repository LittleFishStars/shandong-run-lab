package com.facebook.imagepipeline.producers;

import com.zj.adlib.ad3;
import javax.annotation.Nullable;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public abstract class BaseConsumer<T> implements Consumer<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f30005a = false;

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void a() {
        if (this.f30005a) {
            return;
        }
        this.f30005a = true;
        try {
            onCancellationImpl();
        } catch (Exception e) {
            onUnhandledException(e);
        }
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void b(float f) {
        if (this.f30005a) {
            return;
        }
        try {
            onProgressUpdateImpl(f);
        } catch (Exception e) {
            onUnhandledException(e);
        }
    }

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void c(@Nullable T t, boolean z) {
        if (this.f30005a) {
            return;
        }
        this.f30005a = z;
        try {
            onNewResultImpl(t, z);
        } catch (Exception e) {
            onUnhandledException(e);
        }
    }

    public abstract void onCancellationImpl();

    @Override // com.facebook.imagepipeline.producers.Consumer
    public synchronized void onFailure(Throwable th) {
        if (this.f30005a) {
            return;
        }
        this.f30005a = true;
        try {
            onFailureImpl(th);
        } catch (Exception e) {
            onUnhandledException(e);
        }
    }

    public abstract void onFailureImpl(Throwable th);

    public abstract void onNewResultImpl(T t, boolean z);

    public void onProgressUpdateImpl(float f) {
    }

    public void onUnhandledException(Exception exc) {
        ad3.t0(getClass(), "unhandled exception", exc);
    }
}
