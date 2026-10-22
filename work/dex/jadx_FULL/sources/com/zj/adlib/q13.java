package com.zj.adlib;

import android.util.Pair;
import com.facebook.common.internal.Supplier;
import com.facebook.common.internal.VisibleForTesting;
import com.facebook.common.references.SharedReference;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.memory.PooledByteBuffer;
import java.io.Closeable;
import java.io.FileInputStream;
import java.io.InputStream;
import javax.annotation.Nullable;
import javax.annotation.concurrent.Immutable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
@Immutable
public class q13 implements Closeable {
    public static final int P = -1;
    public static final int Q = -1;
    public static final int R = -1;
    public static final int S = -1;
    public static final int T = 1;
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public final Supplier<FileInputStream> f44101a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public ImageFormat f18977a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final rm1<PooledByteBuffer> f18978a;

    public q13(rm1<PooledByteBuffer> rm1Var) {
        this.f18977a = ImageFormat.UNKNOWN;
        this.K = -1;
        this.L = -1;
        this.M = -1;
        this.N = 1;
        this.O = -1;
        ax6.d(rm1.F(rm1Var));
        this.f18978a = rm1Var.clone();
        this.f44101a = null;
    }

    public static boolean E(q13 q13Var) {
        return q13Var.K >= 0 && q13Var.L >= 0 && q13Var.M >= 0;
    }

    public static boolean H(@Nullable q13 q13Var) {
        return q13Var != null && q13Var.F();
    }

    public static q13 h(q13 q13Var) {
        if (q13Var != null) {
            return q13Var.g();
        }
        return null;
    }

    public static void j(@Nullable q13 q13Var) {
        if (q13Var != null) {
            q13Var.close();
        }
    }

    public synchronized boolean F() {
        return rm1.F(this.f18978a) || this.f44101a != null;
    }

    public void J() {
        Pair<Integer, Integer> pairA;
        ImageFormat imageFormatE = c74.e(q());
        this.f18977a = imageFormatE;
        if (ImageFormat.isWebpFormat(imageFormatE) || (pairA = qw0.a(q())) == null) {
            return;
        }
        this.L = ((Integer) pairA.first).intValue();
        this.M = ((Integer) pairA.second).intValue();
        if (imageFormatE != ImageFormat.JPEG) {
            this.K = 0;
        } else if (this.K == -1) {
            this.K = do4.a(do4.b(q()));
        }
    }

    public void L(int i) {
        this.M = i;
    }

    public void M(ImageFormat imageFormat) {
        this.f18977a = imageFormat;
    }

    public void R(int i) {
        this.K = i;
    }

    public void S(int i) {
        this.N = i;
    }

    public void W(int i) {
        this.O = i;
    }

    public void b0(int i) {
        this.L = i;
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        rm1.p(this.f18978a);
    }

    public q13 g() {
        q13 q13Var;
        Supplier<FileInputStream> supplier = this.f44101a;
        if (supplier != null) {
            q13Var = new q13(supplier, this.O);
        } else {
            rm1 rm1VarL = rm1.l(this.f18978a);
            if (rm1VarL == null) {
                q13Var = null;
            } else {
                try {
                    q13Var = new q13((rm1<PooledByteBuffer>) rm1VarL);
                } catch (Throwable th) {
                    rm1.p(rm1VarL);
                    throw th;
                }
            }
            rm1.p(rm1VarL);
        }
        if (q13Var != null) {
            q13Var.k(this);
        }
        return q13Var;
    }

    public int getHeight() {
        return this.M;
    }

    public int getWidth() {
        return this.L;
    }

    public void k(q13 q13Var) {
        this.f18977a = q13Var.p();
        this.L = q13Var.getWidth();
        this.M = q13Var.getHeight();
        this.K = q13Var.r();
        this.N = q13Var.s();
        this.O = q13Var.v();
    }

    public rm1<PooledByteBuffer> l() {
        return rm1.l(this.f18978a);
    }

    public ImageFormat p() {
        return this.f18977a;
    }

    public InputStream q() {
        Supplier<FileInputStream> supplier = this.f44101a;
        if (supplier != null) {
            return supplier.get();
        }
        rm1 rm1VarL = rm1.l(this.f18978a);
        if (rm1VarL == null) {
            return null;
        }
        try {
            return new pu6((PooledByteBuffer) rm1VarL.s());
        } finally {
            rm1.p(rm1VarL);
        }
    }

    public int r() {
        return this.K;
    }

    public int s() {
        return this.N;
    }

    public int v() {
        rm1<PooledByteBuffer> rm1Var = this.f18978a;
        return (rm1Var == null || rm1Var.s() == null) ? this.O : this.f18978a.s().size();
    }

    @VisibleForTesting
    public synchronized SharedReference<PooledByteBuffer> w() {
        rm1<PooledByteBuffer> rm1Var;
        rm1Var = this.f18978a;
        return rm1Var != null ? rm1Var.v() : null;
    }

    public boolean y(int i) {
        if (this.f18977a != ImageFormat.JPEG || this.f44101a != null) {
            return true;
        }
        ax6.i(this.f18978a);
        PooledByteBuffer pooledByteBufferS = this.f18978a.s();
        return pooledByteBufferS.z(i + (-2)) == -1 && pooledByteBufferS.z(i - 1) == -39;
    }

    public q13(Supplier<FileInputStream> supplier) {
        this.f18977a = ImageFormat.UNKNOWN;
        this.K = -1;
        this.L = -1;
        this.M = -1;
        this.N = 1;
        this.O = -1;
        ax6.i(supplier);
        this.f18978a = null;
        this.f44101a = supplier;
    }

    public q13(Supplier<FileInputStream> supplier, int i) {
        this(supplier);
        this.O = i;
    }
}
