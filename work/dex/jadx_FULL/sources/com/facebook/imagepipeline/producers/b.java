package com.facebook.imagepipeline.producers;

import android.os.SystemClock;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imagepipeline.memory.ByteArrayPool;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import com.facebook.imagepipeline.memory.PooledByteBufferFactory;
import com.facebook.imagepipeline.memory.PooledByteBufferOutputStream;
import com.zj.adlib.q13;
import com.zj.adlib.rm1;
import com.zj.adlib.ze3;
import java.io.InputStream;
import java.util.Map;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class b implements Producer<q13> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30029a = 16384;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public static final long f1703a = 100;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public static final String f1704a = "NetworkFetchProducer";
    public static final String b = "intermediate_result";

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ByteArrayPool f1705a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final PooledByteBufferFactory f1706a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final NetworkFetcher f1707a;

    public class a implements NetworkFetcher.Callback {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ ze3 f1708a;

        public a(ze3 ze3Var) {
            this.f1708a = ze3Var;
        }

        @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
        public void a() {
            b.this.k(this.f1708a);
        }

        @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
        public void b(InputStream inputStream, int i) throws Throwable {
            b.this.m(this.f1708a, inputStream, i);
        }

        @Override // com.facebook.imagepipeline.producers.NetworkFetcher.Callback
        public void onFailure(Throwable th) {
            b.this.l(this.f1708a, th);
        }
    }

    public b(PooledByteBufferFactory pooledByteBufferFactory, ByteArrayPool byteArrayPool, NetworkFetcher networkFetcher) {
        this.f1706a = pooledByteBufferFactory;
        this.f1705a = byteArrayPool;
        this.f1707a = networkFetcher;
    }

    public static float f(int i, int i2) {
        return i2 > 0 ? i / i2 : 1.0f - ((float) Math.exp(((double) (-i)) / 50000.0d));
    }

    @Override // com.facebook.imagepipeline.producers.Producer
    public void a(Consumer<q13> consumer, ProducerContext producerContext) {
        producerContext.c().g(producerContext.getId(), f1704a);
        ze3 ze3VarA = this.f1707a.a(consumer, producerContext);
        this.f1707a.b(ze3VarA, new a(ze3VarA));
    }

    @Nullable
    public final Map<String, String> g(ze3 ze3Var, int i) {
        if (ze3Var.d().h(ze3Var.b())) {
            return this.f1707a.e(ze3Var, i);
        }
        return null;
    }

    public final void h(PooledByteBufferOutputStream pooledByteBufferOutputStream, ze3 ze3Var) throws Throwable {
        ze3Var.d().c(ze3Var.b(), f1704a, g(ze3Var, pooledByteBufferOutputStream.size()));
        j(pooledByteBufferOutputStream, true, ze3Var.a());
    }

    public final void i(PooledByteBufferOutputStream pooledByteBufferOutputStream, ze3 ze3Var) throws Throwable {
        long jUptimeMillis = SystemClock.uptimeMillis();
        if (!n(ze3Var) || jUptimeMillis - ze3Var.c() < 100) {
            return;
        }
        ze3Var.f(jUptimeMillis);
        ze3Var.d().d(ze3Var.b(), f1704a, b);
        j(pooledByteBufferOutputStream, false, ze3Var.a());
    }

    public final void j(PooledByteBufferOutputStream pooledByteBufferOutputStream, boolean z, Consumer<q13> consumer) throws Throwable {
        rm1 rm1VarH = rm1.H(pooledByteBufferOutputStream.g());
        q13 q13Var = null;
        try {
            q13 q13Var2 = new q13((rm1<PooledByteBuffer>) rm1VarH);
            try {
                q13Var2.J();
                consumer.c(q13Var2, z);
                q13.j(q13Var2);
                rm1.p(rm1VarH);
            } catch (Throwable th) {
                th = th;
                q13Var = q13Var2;
                q13.j(q13Var);
                rm1.p(rm1VarH);
                throw th;
            }
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public final void k(ze3 ze3Var) {
        ze3Var.d().i(ze3Var.b(), f1704a, null);
        ze3Var.a().a();
    }

    public final void l(ze3 ze3Var, Throwable th) {
        ze3Var.d().j(ze3Var.b(), f1704a, th, null);
        ze3Var.a().onFailure(th);
    }

    public final void m(ze3 ze3Var, InputStream inputStream, int i) throws Throwable {
        PooledByteBufferOutputStream pooledByteBufferOutputStreamF = i > 0 ? this.f1706a.f(i) : this.f1706a.d();
        byte[] bArr = this.f1705a.get(16384);
        while (true) {
            try {
                int i2 = inputStream.read(bArr);
                if (i2 < 0) {
                    this.f1707a.d(ze3Var, pooledByteBufferOutputStreamF.size());
                    h(pooledByteBufferOutputStreamF, ze3Var);
                    this.f1705a.a(bArr);
                    pooledByteBufferOutputStreamF.close();
                    return;
                }
                if (i2 > 0) {
                    pooledByteBufferOutputStreamF.write(bArr, 0, i2);
                    i(pooledByteBufferOutputStreamF, ze3Var);
                    ze3Var.a().b(f(pooledByteBufferOutputStreamF.size(), i));
                }
            } catch (Throwable th) {
                this.f1705a.a(bArr);
                pooledByteBufferOutputStreamF.close();
                throw th;
            }
        }
    }

    public final boolean n(ze3 ze3Var) {
        if (ze3Var.getContext().b().l()) {
            return this.f1707a.c(ze3Var);
        }
        return false;
    }
}
