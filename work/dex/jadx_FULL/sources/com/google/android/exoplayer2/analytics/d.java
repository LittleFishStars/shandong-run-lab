package com.google.android.exoplayer2.analytics;

import androidx.annotation.Nullable;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class d {
    public static final int A = 9;
    public static final int B = 10;
    public static final int C = 11;
    public static final int D = 12;
    public static final int E = 13;
    public static final int F = 14;
    public static final int G = 15;
    public static final int H = 16;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f30525a = W(new d[0]);
    public static final int s = 0;
    public static final int t = 1;
    public static final int u = 2;
    public static final int v = 3;
    public static final int w = 4;
    public static final int x = 5;
    public static final int y = 6;
    public static final int z = 7;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f2314a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f2315a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<c> f2316a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long[] f2317a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f2318b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final List<long[]> f2319b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final long f2320c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final List<b> f2321c;
    public final int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final long f2322d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final List<b> f2323d;
    public final int e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final long f2324e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public final List<a> f2325e;
    public final int f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public final long f2326f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public final List<a> f2327f;
    public final int g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public final long f2328g;
    public final int h;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public final long f2329h;
    public final int i;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public final long f2330i;
    public final int j;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public final long f2331j;
    public final int k;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public final long f2332k;
    public final int l;

    /* JADX INFO: renamed from: l, reason: collision with other field name */
    public final long f2333l;
    public final int m;

    /* JADX INFO: renamed from: m, reason: collision with other field name */
    public final long f2334m;
    public final int n;

    /* JADX INFO: renamed from: n, reason: collision with other field name */
    public final long f2335n;
    public final int o;

    /* JADX INFO: renamed from: o, reason: collision with other field name */
    public final long f2336o;
    public final int p;
    public final int q;
    public final int r;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnalyticsListener.a f30526a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final Exception f2337a;

        public a(AnalyticsListener.a aVar, Exception exc) {
            this.f30526a = aVar;
            this.f2337a = exc;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || a.class != obj.getClass()) {
                return false;
            }
            a aVar = (a) obj;
            if (this.f30526a.equals(aVar.f30526a)) {
                return this.f2337a.equals(aVar.f2337a);
            }
            return false;
        }

        public int hashCode() {
            return (this.f30526a.hashCode() * 31) + this.f2337a.hashCode();
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final AnalyticsListener.a f30527a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public final com.google.android.exoplayer2.d f2338a;

        public b(AnalyticsListener.a aVar, @Nullable com.google.android.exoplayer2.d dVar) {
            this.f30527a = aVar;
            this.f2338a = dVar;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || b.class != obj.getClass()) {
                return false;
            }
            b bVar = (b) obj;
            if (!this.f30527a.equals(bVar.f30527a)) {
                return false;
            }
            com.google.android.exoplayer2.d dVar = this.f2338a;
            com.google.android.exoplayer2.d dVar2 = bVar.f2338a;
            if (dVar != null) {
                return dVar.equals(dVar2);
            }
            return dVar2 == null;
        }

        public int hashCode() {
            int iHashCode = this.f30527a.hashCode() * 31;
            com.google.android.exoplayer2.d dVar = this.f2338a;
            return iHashCode + (dVar != null ? dVar.hashCode() : 0);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30528a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final AnalyticsListener.a f2339a;

        public c(AnalyticsListener.a aVar, int i) {
            this.f2339a = aVar;
            this.f30528a = i;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            if (this.f30528a != cVar.f30528a) {
                return false;
            }
            return this.f2339a.equals(cVar.f2339a);
        }

        public int hashCode() {
            return (this.f2339a.hashCode() * 31) + this.f30528a;
        }
    }

    public d(int i, long[] jArr, List<c> list, List<long[]> list2, long j, int i2, int i3, int i4, int i5, long j2, int i6, int i7, int i8, int i9, int i10, long j3, int i11, List<b> list3, List<b> list4, long j4, long j5, long j6, long j7, long j8, long j9, int i12, int i13, int i14, long j10, int i15, long j11, long j12, long j13, long j14, long j15, int i16, int i17, int i18, List<a> list5, List<a> list6) {
        this.f2314a = i;
        this.f2317a = jArr;
        this.f2316a = Collections.unmodifiableList(list);
        this.f2319b = Collections.unmodifiableList(list2);
        this.f2315a = j;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.e = i5;
        this.f2318b = j2;
        this.f = i6;
        this.g = i7;
        this.h = i8;
        this.i = i9;
        this.j = i10;
        this.f2320c = j3;
        this.k = i11;
        this.f2321c = Collections.unmodifiableList(list3);
        this.f2323d = Collections.unmodifiableList(list4);
        this.f2322d = j4;
        this.f2324e = j5;
        this.f2326f = j6;
        this.f2328g = j7;
        this.f2329h = j8;
        this.f2330i = j9;
        this.l = i12;
        this.m = i13;
        this.n = i14;
        this.f2331j = j10;
        this.o = i15;
        this.f2332k = j11;
        this.f2333l = j12;
        this.f2334m = j13;
        this.f2335n = j14;
        this.f2336o = j15;
        this.p = i16;
        this.q = i17;
        this.r = i18;
        this.f2325e = Collections.unmodifiableList(list5);
        this.f2327f = Collections.unmodifiableList(list6);
    }

    public static d W(d... dVarArr) {
        int i;
        int i2 = 16;
        long[] jArr = new long[16];
        int length = dVarArr.length;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        long j6 = 0;
        long j7 = 0;
        long j8 = 0;
        long j9 = 0;
        long j10 = 0;
        int i3 = 0;
        int i4 = 0;
        int i5 = -1;
        long jMax = -9223372036854775807L;
        long jMin = -9223372036854775807L;
        int i6 = 0;
        int i7 = 0;
        int i8 = 0;
        int i9 = 0;
        long j11 = -9223372036854775807L;
        int i10 = 0;
        int i11 = 0;
        int i12 = 0;
        int i13 = 0;
        int i14 = 0;
        int i15 = 0;
        int i16 = 0;
        int i17 = 0;
        long j12 = -1;
        int i18 = 0;
        long j13 = -1;
        int i19 = 0;
        int i20 = 0;
        int i21 = 0;
        while (i3 < length) {
            d dVar = dVarArr[i3];
            i4 += dVar.f2314a;
            for (int i22 = 0; i22 < i2; i22++) {
                jArr[i22] = jArr[i22] + dVar.f2317a[i22];
            }
            if (jMin == -9223372036854775807L) {
                jMin = dVar.f2315a;
                i = length;
            } else {
                i = length;
                long j14 = dVar.f2315a;
                if (j14 != -9223372036854775807L) {
                    jMin = Math.min(jMin, j14);
                }
            }
            i6 += dVar.b;
            i7 += dVar.c;
            i8 += dVar.d;
            i9 += dVar.e;
            if (j11 == -9223372036854775807L) {
                j11 = dVar.f2318b;
            } else {
                long j15 = dVar.f2318b;
                if (j15 != -9223372036854775807L) {
                    j11 += j15;
                }
            }
            i10 += dVar.f;
            i11 += dVar.g;
            i12 += dVar.h;
            i13 += dVar.i;
            i14 += dVar.j;
            if (jMax == -9223372036854775807L) {
                jMax = dVar.f2320c;
            } else {
                long j16 = dVar.f2320c;
                if (j16 != -9223372036854775807L) {
                    jMax = Math.max(jMax, j16);
                }
            }
            i15 += dVar.k;
            j += dVar.f2322d;
            j2 += dVar.f2324e;
            j3 += dVar.f2326f;
            j4 += dVar.f2328g;
            j5 += dVar.f2329h;
            j6 += dVar.f2330i;
            i16 += dVar.l;
            i17 += dVar.m;
            if (i5 == -1) {
                i5 = dVar.n;
            } else {
                int i23 = dVar.n;
                if (i23 != -1) {
                    i5 += i23;
                }
            }
            if (j12 == -1) {
                j12 = dVar.f2331j;
            } else {
                long j17 = dVar.f2331j;
                if (j17 != -1) {
                    j12 += j17;
                }
            }
            i18 += dVar.o;
            if (j13 == -1) {
                j13 = dVar.f2332k;
            } else {
                long j18 = dVar.f2332k;
                if (j18 != -1) {
                    j13 += j18;
                }
            }
            j7 += dVar.f2333l;
            j8 += dVar.f2334m;
            j9 += dVar.f2335n;
            j10 += dVar.f2336o;
            i19 += dVar.p;
            i20 += dVar.q;
            i21 += dVar.r;
            i3++;
            length = i;
            i2 = 16;
        }
        return new d(i4, jArr, Collections.emptyList(), Collections.emptyList(), jMin, i6, i7, i8, i9, j11, i10, i11, i12, i13, i14, jMax, i15, Collections.emptyList(), Collections.emptyList(), j, j2, j3, j4, j5, j6, i16, i17, i5, j12, i18, j13, j7, j8, j9, j10, i19, i20, i21, Collections.emptyList(), Collections.emptyList());
    }

    public float A() {
        return 1.0f / e();
    }

    public float B() {
        return 1.0f / H();
    }

    public float C() {
        return 1.0f / K();
    }

    public int D() {
        long j = this.f2326f;
        if (j == 0) {
            return -1;
        }
        return (int) (this.f2328g / j);
    }

    public int E() {
        long j = this.f2322d;
        if (j == 0) {
            return -1;
        }
        return (int) (this.f2324e / j);
    }

    public long F() {
        if (this.b == 0) {
            return -9223372036854775807L;
        }
        return U() / ((long) this.b);
    }

    public long G(long j) {
        if (this.f2319b.isEmpty()) {
            return -9223372036854775807L;
        }
        int i = 0;
        while (i < this.f2319b.size() && this.f2319b.get(i)[0] <= j) {
            i++;
        }
        if (i == 0) {
            return this.f2319b.get(0)[1];
        }
        if (i == this.f2319b.size()) {
            List<long[]> list = this.f2319b;
            return list.get(list.size() - 1)[1];
        }
        int i2 = i - 1;
        long j2 = this.f2319b.get(i2)[0];
        long j3 = this.f2319b.get(i2)[1];
        long j4 = this.f2319b.get(i)[0];
        long j5 = this.f2319b.get(i)[1];
        long j6 = j4 - j2;
        if (j6 == 0) {
            return j3;
        }
        return j3 + ((long) ((j5 - j3) * ((j - j2) / j6)));
    }

    public float H() {
        long jR = R();
        if (jR == 0) {
            return 0.0f;
        }
        return (this.r * 1000.0f) / jR;
    }

    public int I(long j) {
        int i = 0;
        for (c cVar : this.f2316a) {
            if (cVar.f2339a.f2224a > j) {
                break;
            }
            i = cVar.f30528a;
        }
        return i;
    }

    public long J(int i) {
        return this.f2317a[i];
    }

    public float K() {
        long jR = R();
        if (jR == 0) {
            return 0.0f;
        }
        return (this.j * 1000.0f) / jR;
    }

    public float L() {
        long jQ = Q();
        if (jQ == 0) {
            return 0.0f;
        }
        return S() / jQ;
    }

    public float M() {
        long jQ = Q();
        if (jQ == 0) {
            return 0.0f;
        }
        return T() / jQ;
    }

    public long N() {
        long j = 0;
        for (int i = 0; i < 16; i++) {
            j += this.f2317a[i];
        }
        return j;
    }

    public long O() {
        return J(2);
    }

    public long P() {
        return J(4) + J(7);
    }

    public long Q() {
        return R() + U();
    }

    public long R() {
        return J(3);
    }

    public long S() {
        return J(6);
    }

    public long T() {
        return J(5);
    }

    public long U() {
        return J(2) + J(6) + J(5);
    }

    public float V() {
        long jQ = Q();
        if (jQ == 0) {
            return 0.0f;
        }
        return U() / jQ;
    }

    public float a() {
        int i = this.c;
        int i2 = this.f2314a;
        int i3 = this.b;
        int i4 = i - (i2 - i3);
        if (i3 == 0) {
            return 0.0f;
        }
        return i4 / i3;
    }

    public float b() {
        long jR = R();
        if (jR == 0) {
            return 0.0f;
        }
        return (this.f2336o * 1000.0f) / jR;
    }

    public float c() {
        long jR = R();
        if (jR == 0) {
            return 0.0f;
        }
        return (this.f2335n * 1000.0f) / jR;
    }

    public float d() {
        int i = this.b;
        if (i == 0) {
            return 0.0f;
        }
        return this.d / i;
    }

    public float e() {
        long jR = R();
        if (jR == 0) {
            return 0.0f;
        }
        return (this.q * 1000.0f) / jR;
    }

    public float f() {
        int i = this.b;
        if (i == 0) {
            return 0.0f;
        }
        return this.p / i;
    }

    public float g() {
        long jQ = Q();
        if (jQ == 0) {
            return 0.0f;
        }
        return O() / jQ;
    }

    public int h() {
        long j = this.f2329h;
        if (j == 0) {
            return -1;
        }
        return (int) (this.f2330i / j);
    }

    public int i() {
        long j = this.f2333l;
        if (j == 0) {
            return -1;
        }
        return (int) ((this.f2334m * 8000) / j);
    }

    public long j() {
        if (this.f2314a == 0) {
            return -9223372036854775807L;
        }
        return N() / ((long) this.f2314a);
    }

    public int k() {
        int i = this.o;
        if (i == 0) {
            return -1;
        }
        return (int) (this.f2332k / ((long) i));
    }

    public int l() {
        int i = this.m;
        if (i == 0) {
            return -1;
        }
        return (int) (this.f2331j / ((long) i));
    }

    public int m() {
        int i = this.l;
        if (i == 0) {
            return -1;
        }
        return this.n / i;
    }

    public long n() {
        int i = this.f;
        if (i == 0) {
            return -9223372036854775807L;
        }
        return this.f2318b / ((long) i);
    }

    public float o() {
        int i = this.b;
        if (i == 0) {
            return 0.0f;
        }
        return this.r / i;
    }

    public float p() {
        int i = this.b;
        if (i == 0) {
            return 0.0f;
        }
        return this.h / i;
    }

    public float q() {
        int i = this.b;
        if (i == 0) {
            return 0.0f;
        }
        return this.g / i;
    }

    public long r() {
        if (this.b == 0) {
            return -9223372036854775807L;
        }
        return P() / ((long) this.b);
    }

    public long s() {
        if (this.b == 0) {
            return -9223372036854775807L;
        }
        return Q() / ((long) this.b);
    }

    public long t() {
        if (this.b == 0) {
            return -9223372036854775807L;
        }
        return R() / ((long) this.b);
    }

    public float u() {
        int i = this.b;
        if (i == 0) {
            return 0.0f;
        }
        return this.j / i;
    }

    public long v() {
        if (this.b == 0) {
            return -9223372036854775807L;
        }
        return S() / ((long) this.b);
    }

    public float w() {
        int i = this.b;
        if (i == 0) {
            return 0.0f;
        }
        return this.i / i;
    }

    public long x() {
        if (this.b == 0) {
            return -9223372036854775807L;
        }
        return T() / ((long) this.b);
    }

    public long y() {
        if (this.j == 0) {
            return -9223372036854775807L;
        }
        return (J(6) + J(7)) / ((long) this.j);
    }

    public long z() {
        if (this.i == 0) {
            return -9223372036854775807L;
        }
        return T() / ((long) this.i);
    }
}
