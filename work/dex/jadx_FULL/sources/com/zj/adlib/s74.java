package com.zj.adlib;

import android.net.Uri;
import bolts.Continuation;
import com.android.internal.util.Predicate;
import com.facebook.cache.common.CacheKey;
import com.facebook.common.internal.Supplier;
import com.facebook.datasource.DataSource;
import com.facebook.imagepipeline.cache.CacheKeyFactory;
import com.facebook.imagepipeline.cache.MemoryCache;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.image.CloseableImage;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.producers.Producer;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.concurrent.ThreadSafe;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@ThreadSafe
public class s74 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CancellationException f44625a = new CancellationException("Prefetching is not enabled");

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Supplier<Boolean> f19535a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final CacheKeyFactory f19536a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MemoryCache<CacheKey, CloseableImage> f19537a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final RequestListener f19538a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final k59 f19539a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final l11 f19540a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final u07 f19541a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public AtomicLong f19542a = new AtomicLong();
    public final MemoryCache<CacheKey, PooledByteBuffer> b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final l11 f19543b;

    public class a implements Supplier<DataSource<rm1<CloseableImage>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageRequest f44626a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f19545a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f19546a;

        public a(boolean z, ImageRequest imageRequest, Object obj) {
            this.f19546a = z;
            this.f44626a = imageRequest;
            this.f19545a = obj;
        }

        @Override // com.facebook.common.internal.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataSource<rm1<CloseableImage>> get() {
            return this.f19546a ? s74.this.k(this.f44626a, this.f19545a) : s74.this.i(this.f44626a, this.f19545a);
        }

        public String toString() {
            return h76.f(this).f("uri", this.f44626a.o()).toString();
        }
    }

    public class b implements Supplier<DataSource<rm1<PooledByteBuffer>>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ImageRequest f44627a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Object f19548a;

        public b(ImageRequest imageRequest, Object obj) {
            this.f44627a = imageRequest;
            this.f19548a = obj;
        }

        @Override // com.facebook.common.internal.Supplier
        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public DataSource<rm1<PooledByteBuffer>> get() {
            return s74.this.j(this.f44627a, this.f19548a);
        }

        public String toString() {
            return h76.f(this).f("uri", this.f44627a.o()).toString();
        }
    }

    public class c implements Predicate<CacheKey> {
        public c() {
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(CacheKey cacheKey) {
            return true;
        }
    }

    public class d implements Continuation<Boolean, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ng8 f44629a;

        public d(ng8 ng8Var) {
            this.f44629a = ng8Var;
        }

        @Override // bolts.Continuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public Void a(bolts.b<Boolean> bVar) throws Exception {
            this.f44629a.setResult(Boolean.valueOf((bVar.z() || bVar.B() || !bVar.y().booleanValue()) ? false : true));
            return null;
        }
    }

    public class e implements Continuation<Boolean, bolts.b<Boolean>> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CacheKey f44630a;

        public e(CacheKey cacheKey) {
            this.f44630a = cacheKey;
        }

        @Override // bolts.Continuation
        /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
        public bolts.b<Boolean> a(bolts.b<Boolean> bVar) throws Exception {
            return (bVar.z() || bVar.B() || !bVar.y().booleanValue()) ? s74.this.f19543b.i(this.f44630a) : bolts.b.w(Boolean.TRUE);
        }
    }

    public class f implements Predicate<CacheKey> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Uri f44631a;

        public f(Uri uri) {
            this.f44631a = uri;
        }

        /* JADX INFO: renamed from: a, reason: merged with bridge method [inline-methods] */
        public boolean apply(CacheKey cacheKey) {
            return cacheKey.a(this.f44631a);
        }
    }

    public s74(u07 u07Var, Set<RequestListener> set, Supplier<Boolean> supplier, MemoryCache<CacheKey, CloseableImage> memoryCache, MemoryCache<CacheKey, PooledByteBuffer> memoryCache2, l11 l11Var, l11 l11Var2, CacheKeyFactory cacheKeyFactory, k59 k59Var) {
        this.f19541a = u07Var;
        this.f19538a = new el3(set);
        this.f19535a = supplier;
        this.f19537a = memoryCache;
        this.b = memoryCache2;
        this.f19540a = l11Var;
        this.f19543b = l11Var2;
        this.f19536a = cacheKeyFactory;
        this.f19539a = k59Var;
    }

    public final DataSource<Void> A(Producer<Void> producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj, Priority priority) {
        try {
            return v07.r(producer, new z68(imageRequest, l(), this.f19538a, obj, ImageRequest.RequestLevel.getMax(imageRequest.g(), requestLevel), true, false, priority), this.f19538a);
        } catch (Exception e2) {
            return e72.c(e2);
        }
    }

    public void b() {
        d();
        c();
    }

    public void c() {
        this.f19540a.h();
        this.f19543b.h();
    }

    public void d() {
        c cVar = new c();
        this.f19537a.c(cVar);
        this.b.c(cVar);
    }

    public void e(Uri uri) {
        h(uri);
        f(uri);
    }

    public void f(Uri uri) {
        g(ImageRequest.a(uri));
    }

    public void g(ImageRequest imageRequest) {
        CacheKey cacheKeyB = this.f19536a.b(imageRequest);
        this.f19540a.q(cacheKeyB);
        this.f19543b.q(cacheKeyB);
    }

    public void h(Uri uri) {
        Predicate<CacheKey> predicateU = u(uri);
        this.f19537a.c(predicateU);
        this.b.c(predicateU);
    }

    public DataSource<rm1<CloseableImage>> i(ImageRequest imageRequest, Object obj) {
        try {
            return z(this.f19541a.g(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj);
        } catch (Exception e2) {
            return e72.c(e2);
        }
    }

    public DataSource<rm1<PooledByteBuffer>> j(ImageRequest imageRequest, Object obj) {
        ax6.i(imageRequest.o());
        try {
            Producer<rm1<PooledByteBuffer>> producerI = this.f19541a.i(imageRequest);
            if (imageRequest.m() != null) {
                imageRequest = ImageRequestBuilder.c(imageRequest).y(null).a();
            }
            return z(producerI, imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj);
        } catch (Exception e2) {
            return e72.c(e2);
        }
    }

    public DataSource<rm1<CloseableImage>> k(ImageRequest imageRequest, Object obj) {
        try {
            return z(this.f19541a.g(imageRequest), imageRequest, ImageRequest.RequestLevel.BITMAP_MEMORY_CACHE, obj);
        } catch (Exception e2) {
            return e72.c(e2);
        }
    }

    public final String l() {
        return String.valueOf(this.f19542a.getAndIncrement());
    }

    public Supplier<DataSource<rm1<CloseableImage>>> m(ImageRequest imageRequest, Object obj, boolean z) {
        return new a(z, imageRequest, obj);
    }

    public Supplier<DataSource<rm1<PooledByteBuffer>>> n(ImageRequest imageRequest, Object obj) {
        return new b(imageRequest, obj);
    }

    public boolean o(Uri uri) {
        return this.f19537a.f(u(uri));
    }

    public boolean p(ImageRequest imageRequest) {
        rm1<CloseableImage> rm1VarB = this.f19537a.b(this.f19536a.a(imageRequest));
        try {
            return rm1.F(rm1VarB);
        } finally {
            rm1.p(rm1VarB);
        }
    }

    public DataSource<Boolean> q(Uri uri) {
        return r(ImageRequest.a(uri));
    }

    public DataSource<Boolean> r(ImageRequest imageRequest) {
        CacheKey cacheKeyB = this.f19536a.b(imageRequest);
        ng8 ng8VarL = ng8.l();
        this.f19540a.i(cacheKeyB).s(new e(cacheKeyB)).q(new d(ng8VarL));
        return ng8VarL;
    }

    public boolean s() {
        return this.f19539a.c();
    }

    public void t() {
        this.f19539a.e();
    }

    public final Predicate<CacheKey> u(Uri uri) {
        return new f(uri);
    }

    public DataSource<Void> v(ImageRequest imageRequest, Object obj) {
        if (!this.f19535a.get().booleanValue()) {
            return e72.c(f44625a);
        }
        try {
            return A(this.f19541a.e(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, Priority.LOW);
        } catch (Exception e2) {
            return e72.c(e2);
        }
    }

    public DataSource<Void> w(ImageRequest imageRequest, Object obj) {
        return x(imageRequest, obj, Priority.LOW);
    }

    public DataSource<Void> x(ImageRequest imageRequest, Object obj, Priority priority) {
        if (!this.f19535a.get().booleanValue()) {
            return e72.c(f44625a);
        }
        try {
            return A(this.f19541a.h(imageRequest), imageRequest, ImageRequest.RequestLevel.FULL_FETCH, obj, priority);
        } catch (Exception e2) {
            return e72.c(e2);
        }
    }

    public void y() {
        this.f19539a.f();
    }

    public final <T> DataSource<rm1<T>> z(Producer<rm1<T>> producer, ImageRequest imageRequest, ImageRequest.RequestLevel requestLevel, Object obj) {
        try {
            return qm1.r(producer, new z68(imageRequest, l(), this.f19538a, obj, ImageRequest.RequestLevel.getMax(imageRequest.g(), requestLevel), false, imageRequest.l() || !th9.i(imageRequest.o()), imageRequest.k()), this.f19538a);
        } catch (Exception e2) {
            return e72.c(e2);
        }
    }
}
