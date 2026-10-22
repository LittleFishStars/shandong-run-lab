package com.google.android.exoplayer2.source;

import android.os.Looper;
import androidx.annotation.CallSuper;
import androidx.annotation.GuardedBy;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.google.android.exoplayer2.decoder.DecoderInputBuffer;
import com.google.android.exoplayer2.drm.DrmInitData;
import com.google.android.exoplayer2.drm.DrmSession;
import com.google.android.exoplayer2.drm.DrmSessionEventListener;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.extractor.TrackOutput;
import com.google.android.exoplayer2.source.SampleQueue;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.android.exoplayer2.upstream.DataReader;
import com.google.android.exoplayer2.util.Consumer;
import com.google.android.exoplayer2.util.Log;
import com.zj.adlib.at6;
import com.zj.adlib.bp5;
import com.zj.adlib.gj9;
import com.zj.adlib.hm8;
import com.zj.adlib.om6;
import com.zj.adlib.sb0;
import com.zj.adlib.yk3;
import java.io.IOException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class SampleQueue implements TrackOutput {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final String f30832a = "SampleQueue";

    @VisibleForTesting
    public static final int j = 1000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.d f3729a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public DrmSession f3730a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final DrmSessionEventListener.a f3731a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final DrmSessionManager f3732a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public UpstreamFormatChangedListener f3733a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final h f3735a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3737a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.d f3741b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public com.google.android.exoplayer2.d f3745c;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f3748d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f3749d;
    public int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public boolean f3750e;
    public int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public boolean f3751f;
    public int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public boolean f3752g;
    public int h;
    public int i;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final b f3734a = new b();
    public int d = 1000;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int[] f3738a = new int[1000];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long[] f3739a = new long[1000];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long[] f3744b = new long[1000];

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int[] f3747c = new int[1000];

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int[] f3743b = new int[1000];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TrackOutput.a[] f3740a = new TrackOutput.a[1000];

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final hm8<c> f3736a = new hm8<>(new Consumer() { // from class: com.zj.adlib.qu7
        @Override // com.google.android.exoplayer2.util.Consumer
        public final void accept(Object obj) {
            SampleQueue.L((SampleQueue.c) obj);
        }
    });

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3728a = Long.MIN_VALUE;
    public long b = Long.MIN_VALUE;
    public long c = Long.MIN_VALUE;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f3746c = true;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f3742b = true;

    public interface UpstreamFormatChangedListener {
        void g(com.google.android.exoplayer2.d dVar);
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f30833a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f3753a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public TrackOutput.a f3754a;
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.google.android.exoplayer2.d f30834a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final DrmSessionManager.DrmSessionReference f3755a;

        public c(com.google.android.exoplayer2.d dVar, DrmSessionManager.DrmSessionReference drmSessionReference) {
            this.f30834a = dVar;
            this.f3755a = drmSessionReference;
        }
    }

    public SampleQueue(Allocator allocator, @Nullable DrmSessionManager drmSessionManager, @Nullable DrmSessionEventListener.a aVar) {
        this.f3732a = drmSessionManager;
        this.f3731a = aVar;
        this.f3735a = new h(allocator);
    }

    public static /* synthetic */ void L(c cVar) {
        cVar.f3755a.release();
    }

    @Deprecated
    public static SampleQueue k(Allocator allocator, Looper looper, DrmSessionManager drmSessionManager, DrmSessionEventListener.a aVar) {
        drmSessionManager.c(looper, at6.f40608a);
        return new SampleQueue(allocator, (DrmSessionManager) sb0.g(drmSessionManager), (DrmSessionEventListener.a) sb0.g(aVar));
    }

    public static SampleQueue l(Allocator allocator, DrmSessionManager drmSessionManager, DrmSessionEventListener.a aVar) {
        return new SampleQueue(allocator, (DrmSessionManager) sb0.g(drmSessionManager), (DrmSessionEventListener.a) sb0.g(aVar));
    }

    public static SampleQueue m(Allocator allocator) {
        return new SampleQueue(allocator, null, null);
    }

    public final synchronized long A() {
        return this.c;
    }

    public final synchronized long B() {
        return Math.max(this.b, C(this.h));
    }

    public final long C(int i) {
        long jMax = Long.MIN_VALUE;
        if (i == 0) {
            return Long.MIN_VALUE;
        }
        int iE = E(i - 1);
        for (int i2 = 0; i2 < i; i2++) {
            jMax = Math.max(jMax, this.f3744b[iE]);
            if ((this.f3747c[iE] & 1) != 0) {
                break;
            }
            iE--;
            if (iE == -1) {
                iE = this.d - 1;
            }
        }
        return jMax;
    }

    public final int D() {
        return this.f + this.h;
    }

    public final int E(int i) {
        int i2 = this.g + i;
        int i3 = this.d;
        return i2 < i3 ? i2 : i2 - i3;
    }

    public final synchronized int F(long j2, boolean z) {
        int iE = E(this.h);
        if (I() && j2 >= this.f3744b[iE]) {
            if (j2 > this.c && z) {
                return this.e - this.h;
            }
            int iX = x(iE, this.e - this.h, j2, true);
            if (iX == -1) {
                return 0;
            }
            return iX;
        }
        return 0;
    }

    @Nullable
    public final synchronized com.google.android.exoplayer2.d G() {
        return this.f3746c ? null : this.f3745c;
    }

    public final int H() {
        return this.f + this.e;
    }

    public final boolean I() {
        return this.h != this.e;
    }

    public final synchronized boolean J() {
        return this.f3737a;
    }

    @CallSuper
    public synchronized boolean K(boolean z) {
        com.google.android.exoplayer2.d dVar;
        boolean z2 = true;
        if (I()) {
            if (this.f3736a.f(D()).f30834a != this.f3729a) {
                return true;
            }
            return M(E(this.h));
        }
        if (!z && !this.f3737a && ((dVar = this.f3745c) == null || dVar == this.f3729a)) {
            z2 = false;
        }
        return z2;
    }

    public final boolean M(int i) {
        DrmSession drmSession = this.f3730a;
        return drmSession == null || drmSession.getState() == 4 || ((this.f3747c[i] & 1073741824) == 0 && this.f3730a.playClearSamplesWithoutKeys());
    }

    @CallSuper
    public void N() throws IOException {
        DrmSession drmSession = this.f3730a;
        if (drmSession != null && drmSession.getState() == 1) {
            throw ((DrmSession.DrmSessionException) sb0.g(this.f3730a.c()));
        }
    }

    public final void O(com.google.android.exoplayer2.d dVar, yk3 yk3Var) {
        com.google.android.exoplayer2.d dVar2 = this.f3729a;
        boolean z = dVar2 == null;
        DrmInitData drmInitData = z ? null : dVar2.f2566a;
        this.f3729a = dVar;
        DrmInitData drmInitData2 = dVar.f2566a;
        DrmSessionManager drmSessionManager = this.f3732a;
        yk3Var.f46052a = drmSessionManager != null ? dVar.d(drmSessionManager.a(dVar)) : dVar;
        yk3Var.f20874a = this.f3730a;
        if (this.f3732a == null) {
            return;
        }
        if (z || !gj9.c(drmInitData, drmInitData2)) {
            DrmSession drmSession = this.f3730a;
            DrmSession drmSessionB = this.f3732a.b(this.f3731a, dVar);
            this.f3730a = drmSessionB;
            yk3Var.f20874a = drmSessionB;
            if (drmSession != null) {
                drmSession.d(this.f3731a);
            }
        }
    }

    public final synchronized int P(yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, boolean z, boolean z2, b bVar) {
        decoderInputBuffer.f2589a = false;
        if (!I()) {
            if (!z2 && !this.f3737a) {
                com.google.android.exoplayer2.d dVar = this.f3745c;
                if (dVar == null || (!z && dVar == this.f3729a)) {
                    return -3;
                }
                O((com.google.android.exoplayer2.d) sb0.g(dVar), yk3Var);
                return -5;
            }
            decoderInputBuffer.i(4);
            return -4;
        }
        com.google.android.exoplayer2.d dVar2 = this.f3736a.f(D()).f30834a;
        if (!z && dVar2 == this.f3729a) {
            int iE = E(this.h);
            if (!M(iE)) {
                decoderInputBuffer.f2589a = true;
                return -3;
            }
            decoderInputBuffer.i(this.f3747c[iE]);
            long j2 = this.f3744b[iE];
            decoderInputBuffer.f30576a = j2;
            if (j2 < this.f3728a) {
                decoderInputBuffer.a(Integer.MIN_VALUE);
            }
            bVar.f30833a = this.f3743b[iE];
            bVar.f3753a = this.f3739a[iE];
            bVar.f3754a = this.f3740a[iE];
            return -4;
        }
        O(dVar2, yk3Var);
        return -5;
    }

    public final synchronized int Q() {
        return I() ? this.f3738a[E(this.h)] : this.i;
    }

    @CallSuper
    public void R() {
        s();
        U();
    }

    @CallSuper
    public int S(yk3 yk3Var, DecoderInputBuffer decoderInputBuffer, int i, boolean z) {
        int iP = P(yk3Var, decoderInputBuffer, (i & 2) != 0, z, this.f3734a);
        if (iP == -4 && !decoderInputBuffer.f()) {
            boolean z2 = (i & 1) != 0;
            if ((i & 4) == 0) {
                if (z2) {
                    this.f3735a.f(decoderInputBuffer, this.f3734a);
                } else {
                    this.f3735a.m(decoderInputBuffer, this.f3734a);
                }
            }
            if (!z2) {
                this.h++;
            }
        }
        return iP;
    }

    @CallSuper
    public void T() {
        W(true);
        U();
    }

    public final void U() {
        DrmSession drmSession = this.f3730a;
        if (drmSession != null) {
            drmSession.d(this.f3731a);
            this.f3730a = null;
            this.f3729a = null;
        }
    }

    public final void V() {
        W(false);
    }

    @CallSuper
    public void W(boolean z) {
        this.f3735a.n();
        this.e = 0;
        this.f = 0;
        this.g = 0;
        this.h = 0;
        this.f3742b = true;
        this.f3728a = Long.MIN_VALUE;
        this.b = Long.MIN_VALUE;
        this.c = Long.MIN_VALUE;
        this.f3737a = false;
        this.f3736a.c();
        if (z) {
            this.f3741b = null;
            this.f3745c = null;
            this.f3746c = true;
        }
    }

    public final synchronized void X() {
        this.h = 0;
        this.f3735a.o();
    }

    public final synchronized boolean Y(int i) {
        X();
        int i2 = this.f;
        if (i >= i2 && i <= this.e + i2) {
            this.f3728a = Long.MIN_VALUE;
            this.h = i - i2;
            return true;
        }
        return false;
    }

    public final synchronized boolean Z(long j2, boolean z) {
        X();
        int iE = E(this.h);
        if (I() && j2 >= this.f3744b[iE] && (j2 <= this.c || z)) {
            int iX = x(iE, this.e - this.h, j2, true);
            if (iX == -1) {
                return false;
            }
            this.f3728a = j2;
            this.h += iX;
            return true;
        }
        return false;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void a(om6 om6Var, int i, int i2) {
        this.f3735a.q(om6Var, i);
    }

    public final void a0(long j2) {
        if (this.f3748d != j2) {
            this.f3748d = j2;
            invalidateUpstreamFormatAdjustment();
        }
    }

    public final void b0(long j2) {
        this.f3728a = j2;
    }

    public final synchronized boolean c0(com.google.android.exoplayer2.d dVar) {
        this.f3746c = false;
        if (gj9.c(dVar, this.f3745c)) {
            return false;
        }
        if (this.f3736a.h() || !this.f3736a.g().f30834a.equals(dVar)) {
            this.f3745c = dVar;
        } else {
            this.f3745c = this.f3736a.g().f30834a;
        }
        com.google.android.exoplayer2.d dVar2 = this.f3745c;
        this.f3750e = bp5.a(dVar2.k, dVar2.i);
        this.f3751f = false;
        return true;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final int d(DataReader dataReader, int i, boolean z, int i2) throws IOException {
        return this.f3735a.p(dataReader, i, z);
    }

    public final void d0(@Nullable UpstreamFormatChangedListener upstreamFormatChangedListener) {
        this.f3733a = upstreamFormatChangedListener;
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0054  */
    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public void e(long j2, int i, int i2, int i3, @Nullable TrackOutput.a aVar) {
        int i4;
        if (this.f3749d) {
            f((com.google.android.exoplayer2.d) sb0.k(this.f3741b));
        }
        int i5 = i & 1;
        boolean z = i5 != 0;
        if (this.f3742b) {
            if (!z) {
                return;
            } else {
                this.f3742b = false;
            }
        }
        long j3 = this.f3748d + j2;
        if (!this.f3750e) {
            i4 = i;
        } else {
            if (j3 < this.f3728a) {
                return;
            }
            if (i5 == 0) {
                if (!this.f3751f) {
                    Log.n(f30832a, "Overriding unexpected non-sync sample for format: " + this.f3745c);
                    this.f3751f = true;
                }
                i4 = i | 1;
            } else {
                i4 = i;
            }
        }
        if (this.f3752g) {
            if (!z || !h(j3)) {
                return;
            } else {
                this.f3752g = false;
            }
        }
        i(j3, i4, (this.f3735a.e() - ((long) i2)) - ((long) i3), i2, aVar);
    }

    /* JADX WARN: Code duplicated, block: B:9:0x000e  */
    public final synchronized void e0(int i) {
        boolean z;
        if (i >= 0) {
            try {
                if (this.h + i <= this.e) {
                    z = true;
                } else {
                    z = false;
                }
            } catch (Throwable th) {
                throw th;
            }
        } else {
            z = false;
        }
        sb0.a(z);
        this.h += i;
    }

    @Override // com.google.android.exoplayer2.extractor.TrackOutput
    public final void f(com.google.android.exoplayer2.d dVar) {
        com.google.android.exoplayer2.d adjustedUpstreamFormat = getAdjustedUpstreamFormat(dVar);
        this.f3749d = false;
        this.f3741b = dVar;
        boolean zC0 = c0(adjustedUpstreamFormat);
        UpstreamFormatChangedListener upstreamFormatChangedListener = this.f3733a;
        if (upstreamFormatChangedListener == null || !zC0) {
            return;
        }
        upstreamFormatChangedListener.g(adjustedUpstreamFormat);
    }

    public final void f0(int i) {
        this.i = i;
    }

    public final void g0() {
        this.f3752g = true;
    }

    @CallSuper
    public com.google.android.exoplayer2.d getAdjustedUpstreamFormat(com.google.android.exoplayer2.d dVar) {
        return (this.f3748d == 0 || dVar.f2565a == Long.MAX_VALUE) ? dVar : dVar.b().i0(dVar.f2565a + this.f3748d).E();
    }

    public final synchronized boolean h(long j2) {
        if (this.e == 0) {
            return j2 > this.b;
        }
        if (B() >= j2) {
            return false;
        }
        v(this.f + j(j2));
        return true;
    }

    public final synchronized void i(long j2, int i, long j3, int i2, @Nullable TrackOutput.a aVar) {
        int i3 = this.e;
        if (i3 > 0) {
            int iE = E(i3 - 1);
            sb0.a(this.f3739a[iE] + ((long) this.f3743b[iE]) <= j3);
        }
        this.f3737a = (536870912 & i) != 0;
        this.c = Math.max(this.c, j2);
        int iE2 = E(this.e);
        this.f3744b[iE2] = j2;
        this.f3739a[iE2] = j3;
        this.f3743b[iE2] = i2;
        this.f3747c[iE2] = i;
        this.f3740a[iE2] = aVar;
        this.f3738a[iE2] = this.i;
        if (this.f3736a.h() || !this.f3736a.g().f30834a.equals(this.f3745c)) {
            DrmSessionManager drmSessionManager = this.f3732a;
            this.f3736a.b(H(), new c((com.google.android.exoplayer2.d) sb0.g(this.f3745c), drmSessionManager != null ? drmSessionManager.d(this.f3731a, this.f3745c) : DrmSessionManager.DrmSessionReference.f30598a));
        }
        int i4 = this.e + 1;
        this.e = i4;
        int i5 = this.d;
        if (i4 == i5) {
            int i6 = i5 + 1000;
            int[] iArr = new int[i6];
            long[] jArr = new long[i6];
            long[] jArr2 = new long[i6];
            int[] iArr2 = new int[i6];
            int[] iArr3 = new int[i6];
            TrackOutput.a[] aVarArr = new TrackOutput.a[i6];
            int i7 = this.g;
            int i8 = i5 - i7;
            System.arraycopy(this.f3739a, i7, jArr, 0, i8);
            System.arraycopy(this.f3744b, this.g, jArr2, 0, i8);
            System.arraycopy(this.f3747c, this.g, iArr2, 0, i8);
            System.arraycopy(this.f3743b, this.g, iArr3, 0, i8);
            System.arraycopy(this.f3740a, this.g, aVarArr, 0, i8);
            System.arraycopy(this.f3738a, this.g, iArr, 0, i8);
            int i9 = this.g;
            System.arraycopy(this.f3739a, 0, jArr, i8, i9);
            System.arraycopy(this.f3744b, 0, jArr2, i8, i9);
            System.arraycopy(this.f3747c, 0, iArr2, i8, i9);
            System.arraycopy(this.f3743b, 0, iArr3, i8, i9);
            System.arraycopy(this.f3740a, 0, aVarArr, i8, i9);
            System.arraycopy(this.f3738a, 0, iArr, i8, i9);
            this.f3739a = jArr;
            this.f3744b = jArr2;
            this.f3747c = iArr2;
            this.f3743b = iArr3;
            this.f3740a = aVarArr;
            this.f3738a = iArr;
            this.g = 0;
            this.d = i6;
        }
    }

    public final void invalidateUpstreamFormatAdjustment() {
        this.f3749d = true;
    }

    public final int j(long j2) {
        int i = this.e;
        int iE = E(i - 1);
        while (i > this.h && this.f3744b[iE] >= j2) {
            i--;
            iE--;
            if (iE == -1) {
                iE = this.d - 1;
            }
        }
        return i;
    }

    public final synchronized long n(long j2, boolean z, boolean z2) {
        int i;
        int i2 = this.e;
        if (i2 != 0) {
            long[] jArr = this.f3744b;
            int i3 = this.g;
            if (j2 >= jArr[i3]) {
                if (z2 && (i = this.h) != i2) {
                    i2 = i + 1;
                }
                int iX = x(i3, i2, j2, z);
                if (iX == -1) {
                    return -1L;
                }
                return q(iX);
            }
        }
        return -1L;
    }

    public final synchronized long o() {
        int i = this.e;
        if (i == 0) {
            return -1L;
        }
        return q(i);
    }

    public synchronized long p() {
        int i = this.h;
        if (i == 0) {
            return -1L;
        }
        return q(i);
    }

    @GuardedBy("this")
    public final long q(int i) {
        this.b = Math.max(this.b, C(i));
        this.e -= i;
        int i2 = this.f + i;
        this.f = i2;
        int i3 = this.g + i;
        this.g = i3;
        int i4 = this.d;
        if (i3 >= i4) {
            this.g = i3 - i4;
        }
        int i5 = this.h - i;
        this.h = i5;
        if (i5 < 0) {
            this.h = 0;
        }
        this.f3736a.e(i2);
        if (this.e != 0) {
            return this.f3739a[this.g];
        }
        int i6 = this.g;
        if (i6 == 0) {
            i6 = this.d;
        }
        int i7 = i6 - 1;
        return this.f3739a[i7] + ((long) this.f3743b[i7]);
    }

    public final void r(long j2, boolean z, boolean z2) {
        this.f3735a.b(n(j2, z, z2));
    }

    public final void s() {
        this.f3735a.b(o());
    }

    public final void t() {
        this.f3735a.b(p());
    }

    public final void u(long j2) {
        if (this.e == 0) {
            return;
        }
        sb0.a(j2 > B());
        w(this.f + j(j2));
    }

    public final long v(int i) {
        int iH = H() - i;
        boolean z = false;
        sb0.a(iH >= 0 && iH <= this.e - this.h);
        int i2 = this.e - iH;
        this.e = i2;
        this.c = Math.max(this.b, C(i2));
        if (iH == 0 && this.f3737a) {
            z = true;
        }
        this.f3737a = z;
        this.f3736a.d(i);
        int i3 = this.e;
        if (i3 == 0) {
            return 0L;
        }
        int iE = E(i3 - 1);
        return this.f3739a[iE] + ((long) this.f3743b[iE]);
    }

    public final void w(int i) {
        this.f3735a.c(v(i));
    }

    public final int x(int i, int i2, long j2, boolean z) {
        int i3 = -1;
        for (int i4 = 0; i4 < i2; i4++) {
            long j3 = this.f3744b[i];
            if (j3 > j2) {
                return i3;
            }
            if (!z || (this.f3747c[i] & 1) != 0) {
                if (j3 == j2) {
                    return i4;
                }
                i3 = i4;
            }
            i++;
            if (i == this.d) {
                i = 0;
            }
        }
        return i3;
    }

    public final int y() {
        return this.f;
    }

    public final synchronized long z() {
        return this.e == 0 ? Long.MIN_VALUE : this.f3744b[this.g];
    }
}
