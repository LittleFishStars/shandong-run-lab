package com.zj.adlib;

import com.facebook.binaryresource.BinaryResource;
import com.facebook.cache.common.CacheKey;
import com.facebook.cache.common.WriterCallback;
import com.facebook.cache.disk.FileCache;
import com.facebook.imagepipeline.cache.ImageCacheStatsTracker;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.concurrent.Callable;
import java.util.concurrent.CancellationException;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class l11 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Class<?> f42963a = l11.class;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final FileCache f17839a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ImageCacheStatsTracker f17840a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PooledByteBufferFactory f17841a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final kp8 f17842a = kp8.d();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final qu6 f17843a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Executor f17844a;
    public final Executor b;

    public class a implements Callable<Boolean> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CacheKey f42964a;

        public a(CacheKey cacheKey) {
            this.f42964a = cacheKey;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public Boolean call() throws Exception {
            q13 q13VarC = l11.this.f17842a.c(this.f42964a);
            if (q13VarC != null) {
                q13VarC.close();
                ad3.V(l11.f42963a, "Found image for %s in staging area", this.f42964a.toString());
                l11.this.f17840a.b();
                return Boolean.TRUE;
            }
            ad3.V(l11.f42963a, "Did not find image for %s in staging area", this.f42964a.toString());
            l11.this.f17840a.c();
            try {
                return Boolean.valueOf(l11.this.f17839a.d(this.f42964a));
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }
    }

    public class b implements Callable<q13> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CacheKey f42965a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ AtomicBoolean f17847a;

        public b(AtomicBoolean atomicBoolean, CacheKey cacheKey) {
            this.f17847a = atomicBoolean;
            this.f42965a = cacheKey;
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // java.util.concurrent.Callable
        public q13 call() throws Exception {
            if (this.f17847a.get()) {
                throw new CancellationException();
            }
            q13 q13VarC = l11.this.f17842a.c(this.f42965a);
            if (q13VarC != null) {
                ad3.V(l11.f42963a, "Found image for %s in staging area", this.f42965a.toString());
                l11.this.f17840a.b();
            } else {
                ad3.V(l11.f42963a, "Did not find image for %s in staging area", this.f42965a.toString());
                l11.this.f17840a.c();
                try {
                    rm1 rm1VarH = rm1.H(l11.this.p(this.f42965a));
                    try {
                        q13 q13Var = new q13((rm1<PooledByteBuffer>) rm1VarH);
                        rm1.p(rm1VarH);
                        q13VarC = q13Var;
                    } catch (Throwable th) {
                        rm1.p(rm1VarH);
                        throw th;
                    }
                } catch (Exception unused) {
                    return null;
                }
            }
            if (!Thread.interrupted()) {
                return q13VarC;
            }
            ad3.U(l11.f42963a, "Host thread was interrupted, decreasing reference count");
            q13VarC.close();
            throw new InterruptedException();
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CacheKey f42966a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ q13 f17849a;

        public c(CacheKey cacheKey, q13 q13Var) {
            this.f42966a = cacheKey;
            this.f17849a = q13Var;
        }

        @Override // java.lang.Runnable
        public void run() {
            try {
                l11.this.r(this.f42966a, this.f17849a);
            } finally {
                l11.this.f17842a.h(this.f42966a, this.f17849a);
                q13.j(this.f17849a);
            }
        }
    }

    public class d implements Callable<Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ CacheKey f42967a;

        public d(CacheKey cacheKey) {
            this.f42967a = cacheKey;
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            l11.this.f17842a.g(this.f42967a);
            l11.this.f17839a.e(this.f42967a);
            return null;
        }
    }

    public class e implements Callable<Void> {
        public e() {
        }

        @Override // java.util.concurrent.Callable
        public Void call() throws Exception {
            l11.this.f17842a.a();
            l11.this.f17839a.clearAll();
            return null;
        }
    }

    public class f implements WriterCallback {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ q13 f17851a;

        public f(q13 q13Var) {
            this.f17851a = q13Var;
        }

        @Override // com.facebook.cache.common.WriterCallback
        public void b(OutputStream outputStream) throws IOException {
            l11.this.f17843a.a(this.f17851a.q(), outputStream);
        }
    }

    public l11(FileCache fileCache, PooledByteBufferFactory pooledByteBufferFactory, qu6 qu6Var, Executor executor, Executor executor2, ImageCacheStatsTracker imageCacheStatsTracker) {
        this.f17839a = fileCache;
        this.f17841a = pooledByteBufferFactory;
        this.f17843a = qu6Var;
        this.f17844a = executor;
        this.b = executor2;
        this.f17840a = imageCacheStatsTracker;
    }

    public bolts.b<Void> h() {
        this.f17842a.a();
        try {
            return bolts.b.call(new e(), this.b);
        } catch (Exception e2) {
            ad3.n0(f42963a, e2, "Failed to schedule disk-cache clear", new Object[0]);
            return bolts.b.v(e2);
        }
    }

    public bolts.b<Boolean> i(CacheKey cacheKey) {
        return k(cacheKey) ? bolts.b.w(Boolean.TRUE) : j(cacheKey);
    }

    public final bolts.b<Boolean> j(CacheKey cacheKey) {
        try {
            return bolts.b.call(new a(cacheKey), this.f17844a);
        } catch (Exception e2) {
            ad3.n0(f42963a, e2, "Failed to schedule disk-cache read for %s", cacheKey.toString());
            return bolts.b.v(e2);
        }
    }

    public boolean k(CacheKey cacheKey) {
        return this.f17842a.b(cacheKey) || this.f17839a.f(cacheKey);
    }

    public final bolts.b<q13> l(CacheKey cacheKey, q13 q13Var) {
        ad3.V(f42963a, "Found image for %s in staging area", cacheKey.toString());
        this.f17840a.b();
        return bolts.b.w(q13Var);
    }

    public bolts.b<q13> m(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        q13 q13VarC = this.f17842a.c(cacheKey);
        return q13VarC != null ? l(cacheKey, q13VarC) : n(cacheKey, atomicBoolean);
    }

    public final bolts.b<q13> n(CacheKey cacheKey, AtomicBoolean atomicBoolean) {
        try {
            return bolts.b.call(new b(atomicBoolean, cacheKey), this.f17844a);
        } catch (Exception e2) {
            ad3.n0(f42963a, e2, "Failed to schedule disk-cache read for %s", cacheKey.toString());
            return bolts.b.v(e2);
        }
    }

    public void o(CacheKey cacheKey, q13 q13Var) {
        ax6.i(cacheKey);
        ax6.d(q13.H(q13Var));
        this.f17842a.f(cacheKey, q13Var);
        q13 q13VarH = q13.h(q13Var);
        try {
            this.b.execute(new c(cacheKey, q13VarH));
        } catch (Exception e2) {
            ad3.n0(f42963a, e2, "Failed to schedule disk-cache write for %s", cacheKey.toString());
            this.f17842a.h(cacheKey, q13Var);
            q13.j(q13VarH);
        }
    }

    public final PooledByteBuffer p(CacheKey cacheKey) throws IOException {
        try {
            Class<?> cls = f42963a;
            ad3.V(cls, "Disk cache read for %s", cacheKey.toString());
            BinaryResource binaryResourceH = this.f17839a.h(cacheKey);
            if (binaryResourceH == null) {
                ad3.V(cls, "Disk cache miss for %s", cacheKey.toString());
                this.f17840a.g();
                return null;
            }
            ad3.V(cls, "Found entry in disk cache for %s", cacheKey.toString());
            this.f17840a.a();
            InputStream inputStreamB = binaryResourceH.b();
            try {
                PooledByteBuffer pooledByteBufferA = this.f17841a.a(inputStreamB, (int) binaryResourceH.size());
                inputStreamB.close();
                ad3.V(cls, "Successful read from disk cache for %s", cacheKey.toString());
                return pooledByteBufferA;
            } catch (Throwable th) {
                inputStreamB.close();
                throw th;
            }
        } catch (IOException e2) {
            ad3.n0(f42963a, e2, "Exception reading from cache for %s", cacheKey.toString());
            this.f17840a.d();
            throw e2;
        }
    }

    public bolts.b<Void> q(CacheKey cacheKey) {
        ax6.i(cacheKey);
        this.f17842a.g(cacheKey);
        try {
            return bolts.b.call(new d(cacheKey), this.b);
        } catch (Exception e2) {
            ad3.n0(f42963a, e2, "Failed to schedule disk-cache remove for %s", cacheKey.toString());
            return bolts.b.v(e2);
        }
    }

    public final void r(CacheKey cacheKey, q13 q13Var) {
        Class<?> cls = f42963a;
        ad3.V(cls, "About to write to disk-cache for key %s", cacheKey.toString());
        try {
            this.f17839a.insert(cacheKey, new f(q13Var));
            ad3.V(cls, "Successful disk-cache write for key %s", cacheKey.toString());
        } catch (IOException e2) {
            ad3.n0(f42963a, e2, "Failed to write to disk-cache for key %s", cacheKey.toString());
        }
    }
}
