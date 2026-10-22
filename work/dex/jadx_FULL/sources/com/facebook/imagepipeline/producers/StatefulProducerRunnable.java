package com.facebook.imagepipeline.producers;

import com.facebook.common.executors.StatefulRunnable;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class StatefulProducerRunnable<T> extends StatefulRunnable<T> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Consumer<T> f30025a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ProducerListener f1697a;
    public final String f;
    public final String g;

    public StatefulProducerRunnable(Consumer<T> consumer, ProducerListener producerListener, String str, String str2) {
        this.f30025a = consumer;
        this.f1697a = producerListener;
        this.f = str;
        this.g = str2;
        producerListener.g(str2, str);
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public abstract void disposeResult(T t);

    public Map<String, String> getExtraMapOnCancellation() {
        return null;
    }

    public Map<String, String> getExtraMapOnFailure(Exception exc) {
        return null;
    }

    public Map<String, String> getExtraMapOnSuccess(T t) {
        return null;
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onCancellation() {
        ProducerListener producerListener = this.f1697a;
        String str = this.g;
        producerListener.i(str, this.f, producerListener.h(str) ? getExtraMapOnCancellation() : null);
        this.f30025a.a();
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onFailure(Exception exc) {
        ProducerListener producerListener = this.f1697a;
        String str = this.g;
        producerListener.j(str, this.f, exc, producerListener.h(str) ? getExtraMapOnFailure(exc) : null);
        this.f30025a.onFailure(exc);
    }

    @Override // com.facebook.common.executors.StatefulRunnable
    public void onSuccess(T t) {
        ProducerListener producerListener = this.f1697a;
        String str = this.g;
        producerListener.c(str, this.f, producerListener.h(str) ? getExtraMapOnSuccess(t) : null);
        this.f30025a.c(t, true);
    }
}
