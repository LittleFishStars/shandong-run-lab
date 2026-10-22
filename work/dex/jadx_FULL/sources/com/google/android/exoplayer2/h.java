package com.google.android.exoplayer2;

import android.os.Handler;
import android.util.Pair;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.analytics.AnalyticsCollector;
import com.google.android.exoplayer2.source.MediaPeriod;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.upstream.Allocator;
import com.google.common.collect.ImmutableList;
import com.zj.adlib.fk5;
import com.zj.adlib.gk5;
import com.zj.adlib.hk5;
import com.zj.adlib.rs6;
import com.zj.adlib.sb0;
import com.zj.adlib.wa9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class h {
    public static final int c = 100;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final long f3385c = 1000000000000L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f30756a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f3386a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Handler f3387a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.b f3388a = new Timeline.b();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Timeline.d f3389a = new Timeline.d();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final AnalyticsCollector f3390a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public fk5 f3391a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public Object f3392a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f3393a;
    public int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public long f3394b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    @Nullable
    public fk5 f3395b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    @Nullable
    public fk5 f3396c;

    public h(AnalyticsCollector analyticsCollector, Handler handler) {
        this.f3390a = analyticsCollector;
        this.f3387a = handler;
    }

    public static MediaSource.a B(Timeline timeline, Object obj, long j, long j2, Timeline.d dVar, Timeline.b bVar) {
        timeline.l(obj, bVar);
        timeline.t(bVar.K, dVar);
        int iF = timeline.f(obj);
        Object objG = obj;
        while (bVar.f2190a == 0 && bVar.f() > 0 && bVar.v(bVar.t()) && bVar.h(0L) == -1) {
            int i = iF + 1;
            if (iF >= dVar.L) {
                break;
            }
            timeline.k(i, bVar, true);
            objG = sb0.g(bVar.f2194b);
            iF = i;
        }
        timeline.l(objG, bVar);
        int iH = bVar.h(j);
        return iH == -1 ? new MediaSource.a(objG, j2, bVar.g(j)) : new MediaSource.a(objG, iH, bVar.p(iH), j2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void w(ImmutableList.a aVar, MediaSource.a aVar2) {
        this.f3390a.s(aVar.e(), aVar2);
    }

    public MediaSource.a A(Timeline timeline, Object obj, long j) {
        return B(timeline, obj, j, D(timeline, obj), this.f3389a, this.f3388a);
    }

    public MediaSource.a C(Timeline timeline, Object obj, long j) {
        long jD = D(timeline, obj);
        timeline.l(obj, this.f3388a);
        timeline.t(this.f3388a.K, this.f3389a);
        boolean z = false;
        for (int iF = timeline.f(obj); iF >= this.f3389a.K; iF--) {
            timeline.k(iF, this.f3388a, true);
            boolean z2 = this.f3388a.f() > 0;
            z |= z2;
            Timeline.b bVar = this.f3388a;
            if (bVar.h(bVar.f2190a) != -1) {
                obj = sb0.g(this.f3388a.f2194b);
            }
            if (z && (!z2 || this.f3388a.f2190a != 0)) {
                break;
            }
        }
        return B(timeline, obj, j, jD, this.f3389a, this.f3388a);
    }

    public final long D(Timeline timeline, Object obj) {
        int iF;
        int i = timeline.l(obj, this.f3388a).K;
        Object obj2 = this.f3392a;
        if (obj2 != null && (iF = timeline.f(obj2)) != -1 && timeline.j(iF, this.f3388a).K == i) {
            return this.f3394b;
        }
        for (fk5 fk5VarJ = this.f3391a; fk5VarJ != null; fk5VarJ = fk5VarJ.j()) {
            if (fk5VarJ.f16547a.equals(obj)) {
                return ((gk5) fk5VarJ.f16545a.f16997a).f16804a;
            }
        }
        for (fk5 fk5VarJ2 = this.f3391a; fk5VarJ2 != null; fk5VarJ2 = fk5VarJ2.j()) {
            int iF2 = timeline.f(fk5VarJ2.f16547a);
            if (iF2 != -1 && timeline.j(iF2, this.f3388a).K == i) {
                return ((gk5) fk5VarJ2.f16545a.f16997a).f16804a;
            }
        }
        long j = this.f3386a;
        this.f3386a = 1 + j;
        if (this.f3391a == null) {
            this.f3392a = obj;
            this.f3394b = j;
        }
        return j;
    }

    public boolean E() {
        fk5 fk5Var = this.f3396c;
        return fk5Var == null || (!fk5Var.f16545a.f17001d && fk5Var.q() && this.f3396c.f16545a.d != -9223372036854775807L && this.b < 100);
    }

    public final boolean F(Timeline timeline) {
        fk5 fk5VarJ = this.f3391a;
        if (fk5VarJ == null) {
            return true;
        }
        int iF = timeline.f(fk5VarJ.f16547a);
        while (true) {
            iF = timeline.h(iF, this.f3388a, this.f3389a, this.f30756a, this.f3393a);
            while (fk5VarJ.j() != null && !fk5VarJ.f16545a.f16999b) {
                fk5VarJ = fk5VarJ.j();
            }
            fk5 fk5VarJ2 = fk5VarJ.j();
            if (iF == -1 || fk5VarJ2 == null || timeline.f(fk5VarJ2.f16547a) != iF) {
                break;
            }
            fk5VarJ = fk5VarJ2;
        }
        boolean z = z(fk5VarJ);
        fk5VarJ.f16545a = r(timeline, fk5VarJ.f16545a);
        return !z;
    }

    public boolean G(Timeline timeline, long j, long j2) {
        hk5 hk5VarR;
        fk5 fk5VarJ = this.f3391a;
        fk5 fk5Var = null;
        while (fk5VarJ != null) {
            hk5 hk5Var = fk5VarJ.f16545a;
            if (fk5Var != null) {
                hk5 hk5VarI = i(timeline, fk5Var, j);
                if (hk5VarI != null && e(hk5Var, hk5VarI)) {
                    hk5VarR = hk5VarI;
                }
                return !z(fk5Var);
            }
            hk5VarR = r(timeline, hk5Var);
            fk5VarJ.f16545a = hk5VarR.a(hk5Var.b);
            if (!d(hk5Var.d, hk5VarR.d)) {
                fk5VarJ.A();
                long j3 = hk5VarR.d;
                return (z(fk5VarJ) || (fk5VarJ == this.f3395b && !fk5VarJ.f16545a.f16998a && ((j2 > Long.MIN_VALUE ? 1 : (j2 == Long.MIN_VALUE ? 0 : -1)) == 0 || (j2 > ((j3 > (-9223372036854775807L) ? 1 : (j3 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : fk5VarJ.z(j3)) ? 1 : (j2 == ((j3 > (-9223372036854775807L) ? 1 : (j3 == (-9223372036854775807L) ? 0 : -1)) == 0 ? Long.MAX_VALUE : fk5VarJ.z(j3)) ? 0 : -1)) >= 0))) ? false : true;
            }
            fk5Var = fk5VarJ;
            fk5VarJ = fk5VarJ.j();
        }
        return true;
    }

    public boolean H(Timeline timeline, int i) {
        this.f30756a = i;
        return F(timeline);
    }

    public boolean I(Timeline timeline, boolean z) {
        this.f3393a = z;
        return F(timeline);
    }

    @Nullable
    public fk5 b() {
        fk5 fk5Var = this.f3391a;
        if (fk5Var == null) {
            return null;
        }
        if (fk5Var == this.f3395b) {
            this.f3395b = fk5Var.j();
        }
        this.f3391a.t();
        int i = this.b - 1;
        this.b = i;
        if (i == 0) {
            this.f3396c = null;
            fk5 fk5Var2 = this.f3391a;
            this.f3392a = fk5Var2.f16547a;
            this.f3394b = ((gk5) fk5Var2.f16545a.f16997a).f16804a;
        }
        this.f3391a = this.f3391a.j();
        x();
        return this.f3391a;
    }

    public fk5 c() {
        fk5 fk5Var = this.f3395b;
        sb0.i((fk5Var == null || fk5Var.j() == null) ? false : true);
        this.f3395b = this.f3395b.j();
        x();
        return this.f3395b;
    }

    public final boolean d(long j, long j2) {
        return j == -9223372036854775807L || j == j2;
    }

    public final boolean e(hk5 hk5Var, hk5 hk5Var2) {
        return hk5Var.f42145a == hk5Var2.f42145a && hk5Var.f16997a.equals(hk5Var2.f16997a);
    }

    public void f() {
        if (this.b == 0) {
            return;
        }
        fk5 fk5VarJ = (fk5) sb0.k(this.f3391a);
        this.f3392a = fk5VarJ.f16547a;
        this.f3394b = ((gk5) fk5VarJ.f16545a.f16997a).f16804a;
        while (fk5VarJ != null) {
            fk5VarJ.t();
            fk5VarJ = fk5VarJ.j();
        }
        this.f3391a = null;
        this.f3396c = null;
        this.f3395b = null;
        this.b = 0;
        x();
    }

    public fk5 g(RendererCapabilities[] rendererCapabilitiesArr, TrackSelector trackSelector, Allocator allocator, MediaSourceList mediaSourceList, hk5 hk5Var, wa9 wa9Var) {
        fk5 fk5Var = this.f3396c;
        fk5 fk5Var2 = new fk5(rendererCapabilitiesArr, fk5Var == null ? 1000000000000L : (fk5Var.l() + this.f3396c.f16545a.d) - hk5Var.f42145a, trackSelector, allocator, mediaSourceList, hk5Var, wa9Var);
        fk5 fk5Var3 = this.f3396c;
        if (fk5Var3 != null) {
            fk5Var3.w(fk5Var2);
        } else {
            this.f3391a = fk5Var2;
            this.f3395b = fk5Var2;
        }
        this.f3392a = null;
        this.f3396c = fk5Var2;
        this.b++;
        x();
        return fk5Var2;
    }

    @Nullable
    public final hk5 h(rs6 rs6Var) {
        return k(rs6Var.f19408a, rs6Var.f19410a, rs6Var.f19406a, rs6Var.e);
    }

    /* JADX WARN: Code duplicated, block: B:29:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:36:0x00e3  */
    @Nullable
    public final hk5 i(Timeline timeline, fk5 fk5Var, long j) {
        long j2;
        long j3;
        long j4;
        long j5;
        boolean z;
        long j6;
        hk5 hk5Var = fk5Var.f16545a;
        long jL = (fk5Var.l() + hk5Var.d) - j;
        if (!hk5Var.f16999b) {
            MediaSource.a aVar = hk5Var.f16997a;
            timeline.l(((gk5) aVar).f16805a, this.f3388a);
            if (!aVar.c()) {
                int iP = this.f3388a.p(aVar.c);
                boolean z2 = this.f3388a.v(aVar.c) && this.f3388a.k(aVar.c, iP) == 3;
                if (iP == this.f3388a.d(aVar.c) || z2) {
                    return m(timeline, ((gk5) aVar).f16805a, n(timeline, ((gk5) aVar).f16805a, aVar.c), hk5Var.d, ((gk5) aVar).f16804a);
                }
                return l(timeline, ((gk5) aVar).f16805a, aVar.c, iP, hk5Var.d, ((gk5) aVar).f16804a);
            }
            int i = ((gk5) aVar).f41928a;
            int iD = this.f3388a.d(i);
            if (iD == -1) {
                return null;
            }
            int iQ = this.f3388a.q(i, aVar.b);
            if (iQ < iD) {
                return l(timeline, ((gk5) aVar).f16805a, i, iQ, hk5Var.b, ((gk5) aVar).f16804a);
            }
            long jLongValue = hk5Var.b;
            if (jLongValue == -9223372036854775807L) {
                Timeline.d dVar = this.f3389a;
                Timeline.b bVar = this.f3388a;
                Pair<Object, Long> pairQ = timeline.q(dVar, bVar, bVar.K, -9223372036854775807L, Math.max(0L, jL));
                if (pairQ == null) {
                    return null;
                }
                jLongValue = ((Long) pairQ.second).longValue();
            }
            return m(timeline, ((gk5) aVar).f16805a, Math.max(n(timeline, ((gk5) aVar).f16805a, ((gk5) aVar).f41928a), jLongValue), hk5Var.b, ((gk5) aVar).f16804a);
        }
        int iH = timeline.h(timeline.f(((gk5) hk5Var.f16997a).f16805a), this.f3388a, this.f3389a, this.f30756a, this.f3393a);
        if (iH == -1) {
            return null;
        }
        int i2 = timeline.k(iH, this.f3388a, true).K;
        Object objG = sb0.g(this.f3388a.f2194b);
        long j7 = ((gk5) hk5Var.f16997a).f16804a;
        if (timeline.t(i2, this.f3389a).K == iH) {
            Pair<Object, Long> pairQ2 = timeline.q(this.f3389a, this.f3388a, i2, -9223372036854775807L, Math.max(0L, jL));
            if (pairQ2 == null) {
                return null;
            }
            objG = pairQ2.first;
            long jLongValue2 = ((Long) pairQ2.second).longValue();
            fk5 fk5VarJ = fk5Var.j();
            if (fk5VarJ == null || !fk5VarJ.f16547a.equals(objG)) {
                j6 = this.f3386a;
                this.f3386a = 1 + j6;
            } else {
                j6 = ((gk5) fk5VarJ.f16545a.f16997a).f16804a;
            }
            j2 = jLongValue2;
            j3 = -9223372036854775807L;
            j7 = j6;
        } else {
            j2 = 0;
            j3 = 0;
        }
        MediaSource.a aVarB = B(timeline, objG, j2, j7, this.f3389a, this.f3388a);
        if (j3 == -9223372036854775807L || hk5Var.b == -9223372036854775807L) {
            j4 = j2;
            j5 = j3;
        } else {
            if (timeline.l(((gk5) hk5Var.f16997a).f16805a, this.f3388a).f() > 0) {
                Timeline.b bVar2 = this.f3388a;
                z = bVar2.v(bVar2.t());
            }
            if (aVarB.c() && z) {
                j5 = hk5Var.b;
                j4 = j2;
            } else {
                if (z) {
                    j4 = hk5Var.b;
                } else {
                    j4 = j2;
                }
                j5 = j3;
            }
        }
        return k(timeline, aVarB, j5, j4);
    }

    @Nullable
    public fk5 j() {
        return this.f3396c;
    }

    @Nullable
    public final hk5 k(Timeline timeline, MediaSource.a aVar, long j, long j2) {
        timeline.l(((gk5) aVar).f16805a, this.f3388a);
        return aVar.c() ? l(timeline, ((gk5) aVar).f16805a, ((gk5) aVar).f41928a, aVar.b, j, ((gk5) aVar).f16804a) : m(timeline, ((gk5) aVar).f16805a, j2, j, ((gk5) aVar).f16804a);
    }

    public final hk5 l(Timeline timeline, Object obj, int i, int i2, long j, long j2) {
        MediaSource.a aVar = new MediaSource.a(obj, i, i2, j2);
        long jE = timeline.l(((gk5) aVar).f16805a, this.f3388a).e(((gk5) aVar).f41928a, aVar.b);
        long j3 = i2 == this.f3388a.p(i) ? this.f3388a.j() : 0L;
        return new hk5(aVar, (jE == -9223372036854775807L || j3 < jE) ? j3 : Math.max(0L, jE - 1), j, -9223372036854775807L, jE, this.f3388a.v(((gk5) aVar).f41928a), false, false, false);
    }

    /* JADX WARN: Code duplicated, block: B:16:0x004d  */
    /* JADX WARN: Code duplicated, block: B:36:0x0097  */
    public final hk5 m(Timeline timeline, Object obj, long j, long j2, long j3) {
        boolean z;
        long j4;
        long jI;
        long j5;
        long jMax = j;
        timeline.l(obj, this.f3388a);
        int iG = this.f3388a.g(jMax);
        int i = 1;
        if (iG == -1) {
            if (this.f3388a.f() > 0) {
                Timeline.b bVar = this.f3388a;
                if (bVar.v(bVar.t())) {
                    z = true;
                } else {
                    z = false;
                }
            } else {
                z = false;
            }
        } else if (this.f3388a.v(iG)) {
            long jI2 = this.f3388a.i(iG);
            Timeline.b bVar2 = this.f3388a;
            if (jI2 == bVar2.f2190a && bVar2.u(iG)) {
                z = true;
                iG = -1;
            } else {
                z = false;
            }
        } else {
            z = false;
        }
        MediaSource.a aVar = new MediaSource.a(obj, j3, iG);
        boolean zS = s(aVar);
        boolean zU = u(timeline, aVar);
        boolean zT = t(timeline, aVar, zS);
        boolean z2 = iG != -1 && this.f3388a.v(iG);
        if (iG == -1) {
            if (z) {
                jI = this.f3388a.f2190a;
            } else {
                j4 = -9223372036854775807L;
            }
            if (j4 != -9223372036854775807L || j4 == Long.MIN_VALUE) {
                j5 = this.f3388a.f2190a;
            } else {
                j5 = j4;
            }
            if (j5 != -9223372036854775807L && jMax >= j5) {
                if (!zT && z) {
                    i = 0;
                }
                jMax = Math.max(0L, j5 - ((long) i));
            }
            return new hk5(aVar, jMax, j2, j4, j5, z2, zS, zU, zT);
        }
        jI = this.f3388a.i(iG);
        j4 = jI;
        if (j4 != -9223372036854775807L) {
            j5 = this.f3388a.f2190a;
        } else {
            j5 = this.f3388a.f2190a;
        }
        if (j5 != -9223372036854775807L) {
            if (!zT) {
                i = 0;
            }
            jMax = Math.max(0L, j5 - ((long) i));
        }
        return new hk5(aVar, jMax, j2, j4, j5, z2, zS, zU, zT);
    }

    public final long n(Timeline timeline, Object obj, int i) {
        timeline.l(obj, this.f3388a);
        long jI = this.f3388a.i(i);
        return jI == Long.MIN_VALUE ? this.f3388a.f2190a : jI + this.f3388a.m(i);
    }

    @Nullable
    public hk5 o(long j, rs6 rs6Var) {
        fk5 fk5Var = this.f3396c;
        return fk5Var == null ? h(rs6Var) : i(rs6Var.f19408a, fk5Var, j);
    }

    @Nullable
    public fk5 p() {
        return this.f3391a;
    }

    @Nullable
    public fk5 q() {
        return this.f3395b;
    }

    /* JADX WARN: Code duplicated, block: B:22:0x0062  */
    /* JADX WARN: Code duplicated, block: B:24:0x006c  */
    /* JADX WARN: Code duplicated, block: B:29:0x007a  */
    public hk5 r(Timeline timeline, hk5 hk5Var) {
        long jO;
        long j;
        int i;
        boolean zV;
        int i2;
        MediaSource.a aVar = hk5Var.f16997a;
        boolean zS = s(aVar);
        boolean zU = u(timeline, aVar);
        boolean zT = t(timeline, aVar, zS);
        timeline.l(((gk5) hk5Var.f16997a).f16805a, this.f3388a);
        long jI = (aVar.c() || (i2 = aVar.c) == -1) ? -9223372036854775807L : this.f3388a.i(i2);
        if (!aVar.c()) {
            if (jI == -9223372036854775807L || jI == Long.MIN_VALUE) {
                jO = this.f3388a.o();
            } else {
                j = jI;
            }
            if (aVar.c()) {
                zV = this.f3388a.v(((gk5) aVar).f41928a);
            } else {
                i = aVar.c;
                if (i == -1 && this.f3388a.v(i)) {
                    zV = true;
                } else {
                    zV = false;
                }
            }
            return new hk5(aVar, hk5Var.f42145a, hk5Var.b, jI, j, zV, zS, zU, zT);
        }
        jO = this.f3388a.e(((gk5) aVar).f41928a, aVar.b);
        j = jO;
        if (aVar.c()) {
            zV = this.f3388a.v(((gk5) aVar).f41928a);
        } else {
            i = aVar.c;
            if (i == -1) {
                zV = false;
            } else {
                zV = false;
            }
        }
        return new hk5(aVar, hk5Var.f42145a, hk5Var.b, jI, j, zV, zS, zU, zT);
    }

    public final boolean s(MediaSource.a aVar) {
        return !aVar.c() && aVar.c == -1;
    }

    public final boolean t(Timeline timeline, MediaSource.a aVar, boolean z) {
        int iF = timeline.f(((gk5) aVar).f16805a);
        return !timeline.t(timeline.j(iF, this.f3388a).K, this.f3389a).f2204b && timeline.x(iF, this.f3388a, this.f3389a, this.f30756a, this.f3393a) && z;
    }

    public final boolean u(Timeline timeline, MediaSource.a aVar) {
        if (s(aVar)) {
            return timeline.t(timeline.l(((gk5) aVar).f16805a, this.f3388a).K, this.f3389a).L == timeline.f(((gk5) aVar).f16805a);
        }
        return false;
    }

    public boolean v(MediaPeriod mediaPeriod) {
        fk5 fk5Var = this.f3396c;
        return fk5Var != null && fk5Var.f16541a == mediaPeriod;
    }

    public final void x() {
        final ImmutableList.a aVarBuilder = ImmutableList.builder();
        for (fk5 fk5VarJ = this.f3391a; fk5VarJ != null; fk5VarJ = fk5VarJ.j()) {
            aVarBuilder.a(fk5VarJ.f16545a.f16997a);
        }
        fk5 fk5Var = this.f3395b;
        final MediaSource.a aVar = fk5Var == null ? null : fk5Var.f16545a.f16997a;
        this.f3387a.post(new Runnable() { // from class: com.zj.adlib.ik5
            @Override // java.lang.Runnable
            public final void run() {
                this.f42378a.w(aVarBuilder, aVar);
            }
        });
    }

    public void y(long j) {
        fk5 fk5Var = this.f3396c;
        if (fk5Var != null) {
            fk5Var.s(j);
        }
    }

    public boolean z(fk5 fk5Var) {
        boolean z = false;
        sb0.i(fk5Var != null);
        if (fk5Var.equals(this.f3396c)) {
            return false;
        }
        this.f3396c = fk5Var;
        while (fk5Var.j() != null) {
            fk5Var = fk5Var.j();
            if (fk5Var == this.f3395b) {
                this.f3395b = this.f3391a;
                z = true;
            }
            fk5Var.t();
            this.b--;
        }
        this.f3396c.w(null);
        x();
        return z;
    }
}
