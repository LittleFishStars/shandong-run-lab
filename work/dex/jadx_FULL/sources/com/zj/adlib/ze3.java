package com.zj.adlib;

import android.net.Uri;
import com.facebook.imagepipeline.producers.Consumer;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerListener;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ze3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f46247a = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Consumer<q13> f21041a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ProducerContext f21042a;

    public ze3(Consumer<q13> consumer, ProducerContext producerContext) {
        this.f21041a = consumer;
        this.f21042a = producerContext;
    }

    public Consumer<q13> a() {
        return this.f21041a;
    }

    public String b() {
        return this.f21042a.getId();
    }

    public long c() {
        return this.f46247a;
    }

    public ProducerListener d() {
        return this.f21042a.c();
    }

    public Uri e() {
        return this.f21042a.b().o();
    }

    public void f(long j) {
        this.f46247a = j;
    }

    public ProducerContext getContext() {
        return this.f21042a;
    }
}
