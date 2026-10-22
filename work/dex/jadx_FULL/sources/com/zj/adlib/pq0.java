package com.zj.adlib;

import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.producers.ProducerContext;
import com.facebook.imagepipeline.producers.ProducerContextCallbacks;
import com.facebook.imagepipeline.producers.ProducerListener;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class pq0 implements ProducerContext {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @GuardedBy("this")
    public Priority f44042a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ProducerListener f18914a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImageRequest.RequestLevel f18915a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImageRequest f18916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Object f18917a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final String f18918a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public boolean f18920a;

    @GuardedBy("this")
    public boolean b;

    @GuardedBy("this")
    public boolean c = false;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @GuardedBy("this")
    public final List<ProducerContextCallbacks> f18919a = new ArrayList();

    public pq0(ImageRequest imageRequest, String str, ProducerListener producerListener, Object obj, ImageRequest.RequestLevel requestLevel, boolean z, boolean z2, Priority priority) {
        this.f18916a = imageRequest;
        this.f18918a = str;
        this.f18914a = producerListener;
        this.f18917a = obj;
        this.f18915a = requestLevel;
        this.f18920a = z;
        this.f44042a = priority;
        this.b = z2;
    }

    public static void i(@Nullable List<ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        Iterator<ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().b();
        }
    }

    public static void j(@Nullable List<ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        Iterator<ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().a();
        }
    }

    public static void k(@Nullable List<ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        Iterator<ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().c();
        }
    }

    public static void l(@Nullable List<ProducerContextCallbacks> list) {
        if (list == null) {
            return;
        }
        Iterator<ProducerContextCallbacks> it = list.iterator();
        while (it.hasNext()) {
            it.next().d();
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized boolean a() {
        return this.f18920a;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImageRequest b() {
        return this.f18916a;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ProducerListener c() {
        return this.f18914a;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized boolean d() {
        return this.b;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public synchronized Priority e() {
        return this.f44042a;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public Object f() {
        return this.f18917a;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public void g(ProducerContextCallbacks producerContextCallbacks) {
        boolean z;
        synchronized (this) {
            this.f18919a.add(producerContextCallbacks);
            z = this.c;
        }
        if (z) {
            producerContextCallbacks.b();
        }
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public String getId() {
        return this.f18918a;
    }

    @Override // com.facebook.imagepipeline.producers.ProducerContext
    public ImageRequest.RequestLevel h() {
        return this.f18915a;
    }

    public void m() {
        i(n());
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> n() {
        if (this.c) {
            return null;
        }
        this.c = true;
        return new ArrayList(this.f18919a);
    }

    public synchronized boolean o() {
        return this.c;
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> p(boolean z) {
        if (z == this.b) {
            return null;
        }
        this.b = z;
        return new ArrayList(this.f18919a);
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> q(boolean z) {
        if (z == this.f18920a) {
            return null;
        }
        this.f18920a = z;
        return new ArrayList(this.f18919a);
    }

    @Nullable
    public synchronized List<ProducerContextCallbacks> r(Priority priority) {
        if (priority == this.f44042a) {
            return null;
        }
        this.f44042a = priority;
        return new ArrayList(this.f18919a);
    }
}
