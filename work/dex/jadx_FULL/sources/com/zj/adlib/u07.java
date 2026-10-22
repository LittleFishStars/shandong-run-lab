package com.zj.adlib;

import android.net.Uri;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.producers.NetworkFetcher;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.producers.ThumbnailProducer;
import com.facebook.imagepipeline.request.ImageRequest;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class u07 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45039a = 5;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final NetworkFetcher f19926a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public Producer<rm1<CloseableImage>> f19927a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final k59 f19928a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final s07 f19929a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f19931a;

    @VisibleForTesting
    public Producer<q13> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f19933b;

    @VisibleForTesting
    public Producer<rm1<PooledByteBuffer>> c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f19934c;

    @VisibleForTesting
    public Producer<Void> d;
    public Producer<q13> e;

    @VisibleForTesting
    public Producer<rm1<CloseableImage>> f;

    @VisibleForTesting
    public Producer<rm1<CloseableImage>> g;

    @VisibleForTesting
    public Producer<rm1<CloseableImage>> h;

    @VisibleForTesting
    public Producer<rm1<CloseableImage>> i;

    @VisibleForTesting
    public Producer<rm1<CloseableImage>> j;

    @VisibleForTesting
    public Producer<rm1<CloseableImage>> k;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public Map<Producer<rm1<CloseableImage>>, Producer<rm1<CloseableImage>>> f19930a = new HashMap();

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @VisibleForTesting
    public Map<Producer<rm1<CloseableImage>>, Producer<Void>> f19932b = new HashMap();

    public u07(s07 s07Var, NetworkFetcher networkFetcher, boolean z, boolean z2, boolean z3, k59 k59Var) {
        this.f19929a = s07Var;
        this.f19926a = networkFetcher;
        this.f19931a = z;
        this.f19934c = z2;
        this.f19933b = z3;
        this.f19928a = k59Var;
    }

    public static void y(ImageRequest imageRequest) {
        ax6.i(imageRequest);
        ax6.d(th9.i(imageRequest.o()));
        ax6.d(imageRequest.g().getValue() <= ImageRequest.RequestLevel.ENCODED_MEMORY_CACHE.getValue());
    }

    public final synchronized Producer<q13> a() {
        if (this.b == null) {
            this.b = this.f19929a.b(c(), this.f19928a);
        }
        return this.b;
    }

    public final Producer<rm1<CloseableImage>> b(ImageRequest imageRequest) {
        ax6.i(imageRequest);
        Uri uriO = imageRequest.o();
        ax6.j(uriO, "Uri is null.");
        if (th9.i(uriO)) {
            return o();
        }
        if (th9.g(uriO)) {
            return rl5.e(rl5.b(uriO.getPath())) ? n() : l();
        }
        if (th9.f(uriO)) {
            return k();
        }
        if (th9.c(uriO)) {
            return j();
        }
        if (th9.h(uriO)) {
            return m();
        }
        if (th9.b(uriO)) {
            return d();
        }
        String string = uriO.toString();
        if (string.length() > 30) {
            string = string.substring(0, 30) + v39.CHARACTER_ELLIPSIZE;
        }
        throw new RuntimeException("Unsupported uri scheme! Uri is: " + string);
    }

    public final synchronized Producer<q13> c() {
        if (this.e == null) {
            l10 l10VarA = s07.a(v(this.f19929a.s(this.f19926a)));
            this.e = l10VarA;
            if (this.f19931a && !this.f19934c) {
                this.e = this.f19929a.w(l10VarA);
            }
        }
        return this.e;
    }

    public final synchronized Producer<rm1<CloseableImage>> d() {
        if (this.k == null) {
            Producer<q13> producerA = s07.a(this.f19929a.g());
            if (!this.f19934c) {
                producerA = this.f19929a.w(producerA);
            }
            this.k = s(producerA);
        }
        return this.k;
    }

    public Producer<Void> e(ImageRequest imageRequest) {
        return f(b(imageRequest));
    }

    public final synchronized Producer<Void> f(Producer<rm1<CloseableImage>> producer) {
        if (!this.f19932b.containsKey(producer)) {
            this.f19932b.put(producer, s07.x(producer));
        }
        return this.f19932b.get(producer);
    }

    public Producer<rm1<CloseableImage>> g(ImageRequest imageRequest) {
        Producer<rm1<CloseableImage>> producerB = b(imageRequest);
        return imageRequest.h() != null ? q(producerB) : producerB;
    }

    public Producer<Void> h(ImageRequest imageRequest) {
        y(imageRequest);
        return p();
    }

    public Producer<rm1<PooledByteBuffer>> i(ImageRequest imageRequest) {
        y(imageRequest);
        synchronized (this) {
            if (this.c == null) {
                this.c = new se7(a());
            }
        }
        return this.c;
    }

    public final synchronized Producer<rm1<CloseableImage>> j() {
        if (this.j == null) {
            this.j = t(this.f19929a.l());
        }
        return this.j;
    }

    public final synchronized Producer<rm1<CloseableImage>> k() {
        if (this.h == null) {
            this.h = u(this.f19929a.m(), new ThumbnailProducer[]{this.f19929a.n(), this.f19929a.o()});
        }
        return this.h;
    }

    public final synchronized Producer<rm1<CloseableImage>> l() {
        if (this.f == null) {
            this.f = t(this.f19929a.p());
        }
        return this.f;
    }

    public final synchronized Producer<rm1<CloseableImage>> m() {
        if (this.i == null) {
            this.i = t(this.f19929a.q());
        }
        return this.i;
    }

    public final synchronized Producer<rm1<CloseableImage>> n() {
        if (this.g == null) {
            this.g = r(this.f19929a.r());
        }
        return this.g;
    }

    public final synchronized Producer<rm1<CloseableImage>> o() {
        if (this.f19927a == null) {
            this.f19927a = s(c());
        }
        return this.f19927a;
    }

    public final synchronized Producer<Void> p() {
        if (this.d == null) {
            this.d = s07.x(a());
        }
        return this.d;
    }

    public final synchronized Producer<rm1<CloseableImage>> q(Producer<rm1<CloseableImage>> producer) {
        if (!this.f19930a.containsKey(producer)) {
            this.f19930a.put(producer, this.f19929a.u(this.f19929a.v(producer)));
        }
        return this.f19930a.get(producer);
    }

    public final Producer<rm1<CloseableImage>> r(Producer<rm1<CloseableImage>> producer) {
        return this.f19929a.c(this.f19929a.b(this.f19929a.d(this.f19929a.e(producer)), this.f19928a));
    }

    public final Producer<rm1<CloseableImage>> s(Producer<q13> producer) {
        return r(this.f19929a.h(producer));
    }

    public final Producer<rm1<CloseableImage>> t(Producer<q13> producer) {
        return u(producer, new ThumbnailProducer[]{this.f19929a.o()});
    }

    public final Producer<rm1<CloseableImage>> u(Producer<q13> producer, ThumbnailProducer<q13>[] thumbnailProducerArr) {
        return s(x(v(producer), thumbnailProducerArr));
    }

    public final Producer<q13> v(Producer<q13> producer) {
        return this.f19929a.j(this.f19929a.k(this.f19929a.i(producer)));
    }

    public final Producer<q13> w(ThumbnailProducer<q13>[] thumbnailProducerArr) {
        m69 m69VarZ = this.f19929a.z(thumbnailProducerArr);
        return this.f19934c ? m69VarZ : this.f19929a.w(m69VarZ);
    }

    public final Producer<q13> x(Producer<q13> producer, ThumbnailProducer<q13>[] thumbnailProducerArr) {
        Producer<q13> producerA = s07.a(producer);
        if (!this.f19934c) {
            producerA = this.f19929a.w(producerA);
        }
        return s07.f(w(thumbnailProducerArr), this.f19929a.y(5, producerA));
    }
}
