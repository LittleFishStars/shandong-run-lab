package com.google.android.exoplayer2.source.dash.manifest;

import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.zj.adlib.gj9;
import com.zj.adlib.ka7;
import com.zj.adlib.zh9;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public abstract class SegmentBase {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30895a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final ka7 f3991a;
    public final long b;

    public static abstract class MultiSegmentBase extends SegmentBase {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final List<c> f30896a;
        public final long c;
        public final long d;
        public final long e;
        public final long f;

        @VisibleForTesting
        public final long g;

        public MultiSegmentBase(@Nullable ka7 ka7Var, long j, long j2, long j3, long j4, @Nullable List<c> list, long j5, long j6, long j7) {
            super(ka7Var, j, j2);
            this.c = j3;
            this.d = j4;
            this.f30896a = list;
            this.g = j5;
            this.e = j6;
            this.f = j7;
        }

        public long c(long j, long j2) {
            long jG = g(j);
            return jG != -1 ? jG : (int) (i((j2 - this.f) + this.g, j) - d(j, j2));
        }

        public long d(long j, long j2) {
            if (g(j) == -1) {
                long j3 = this.e;
                if (j3 != -9223372036854775807L) {
                    return Math.max(e(), i((j2 - this.f) - j3, j));
                }
            }
            return e();
        }

        public long e() {
            return this.c;
        }

        public long f(long j, long j2) {
            if (this.f30896a != null) {
                return -9223372036854775807L;
            }
            long jD = d(j, j2) + c(j, j2);
            return (j(jD) + h(jD, j)) - this.g;
        }

        public abstract long g(long j);

        public final long h(long j, long j2) {
            List<c> list = this.f30896a;
            if (list != null) {
                return (list.get((int) (j - this.c)).b * 1000000) / ((SegmentBase) this).f30895a;
            }
            long jG = g(j2);
            return (jG == -1 || j != (e() + jG) - 1) ? (this.d * 1000000) / ((SegmentBase) this).f30895a : j2 - j(j);
        }

        public long i(long j, long j2) {
            long jE = e();
            long jG = g(j2);
            if (jG == 0) {
                return jE;
            }
            if (this.f30896a == null) {
                long j3 = this.c + (j / ((this.d * 1000000) / ((SegmentBase) this).f30895a));
                if (j3 < jE) {
                    return jE;
                }
                return jG == -1 ? j3 : Math.min(j3, (jE + jG) - 1);
            }
            long j4 = (jG + jE) - 1;
            long j5 = jE;
            while (j5 <= j4) {
                long j6 = ((j4 - j5) / 2) + j5;
                long j7 = j(j6);
                if (j7 < j) {
                    j5 = j6 + 1;
                } else {
                    if (j7 <= j) {
                        return j6;
                    }
                    j4 = j6 - 1;
                }
            }
            return j5 == jE ? j5 : j4;
        }

        public final long j(long j) {
            List<c> list = this.f30896a;
            return gj9.o1(list != null ? list.get((int) (j - this.c)).f30898a - this.b : (j - this.c) * this.d, 1000000L, ((SegmentBase) this).f30895a);
        }

        public abstract ka7 k(Representation representation, long j);

        public boolean l() {
            return this.f30896a != null;
        }
    }

    public static final class a extends MultiSegmentBase {

        @Nullable
        public final List<ka7> b;

        public a(ka7 ka7Var, long j, long j2, long j3, long j4, @Nullable List<c> list, long j5, @Nullable List<ka7> list2, long j6, long j7) {
            super(ka7Var, j, j2, j3, j4, list, j5, j6, j7);
            this.b = list2;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public long g(long j) {
            return this.b.size();
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public ka7 k(Representation representation, long j) {
            return this.b.get((int) (j - this.c));
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public boolean l() {
            return true;
        }
    }

    public static final class b extends MultiSegmentBase {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        @Nullable
        public final zh9 f30897a;

        @Nullable
        public final zh9 b;
        public final long h;

        public b(ka7 ka7Var, long j, long j2, long j3, long j4, long j5, @Nullable List<c> list, long j6, @Nullable zh9 zh9Var, @Nullable zh9 zh9Var2, long j7, long j8) {
            super(ka7Var, j, j2, j3, j5, list, j6, j7, j8);
            this.f30897a = zh9Var;
            this.b = zh9Var2;
            this.h = j4;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase
        @Nullable
        public ka7 a(Representation representation) {
            zh9 zh9Var = this.f30897a;
            if (zh9Var == null) {
                return super.a(representation);
            }
            com.google.android.exoplayer2.d dVar = representation.f3983a;
            return new ka7(zh9Var.a(dVar.f, 0L, dVar.O, 0L), 0L, -1L);
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public long g(long j) {
            List<c> list = ((MultiSegmentBase) this).f30896a;
            if (list != null) {
                return list.size();
            }
            long j2 = this.h;
            if (j2 != -1) {
                return (j2 - this.c) + 1;
            }
            if (j != -9223372036854775807L) {
                return com.google.common.math.b.c(BigInteger.valueOf(j).multiply(BigInteger.valueOf(((SegmentBase) this).f30895a)), BigInteger.valueOf(this.d).multiply(BigInteger.valueOf(1000000L)), RoundingMode.CEILING).longValue();
            }
            return -1L;
        }

        @Override // com.google.android.exoplayer2.source.dash.manifest.SegmentBase.MultiSegmentBase
        public ka7 k(Representation representation, long j) {
            List<c> list = ((MultiSegmentBase) this).f30896a;
            long j2 = list != null ? list.get((int) (j - this.c)).f30898a : (j - this.c) * this.d;
            zh9 zh9Var = this.b;
            com.google.android.exoplayer2.d dVar = representation.f3983a;
            return new ka7(zh9Var.a(dVar.f, j, dVar.O, j2), 0L, -1L);
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f30898a;
        public final long b;

        public c(long j, long j2) {
            this.f30898a = j;
            this.b = j2;
        }

        public boolean equals(@Nullable Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || c.class != obj.getClass()) {
                return false;
            }
            c cVar = (c) obj;
            return this.f30898a == cVar.f30898a && this.b == cVar.b;
        }

        public int hashCode() {
            return (((int) this.f30898a) * 31) + ((int) this.b);
        }
    }

    public SegmentBase(@Nullable ka7 ka7Var, long j, long j2) {
        this.f3991a = ka7Var;
        this.f30895a = j;
        this.b = j2;
    }

    @Nullable
    public ka7 a(Representation representation) {
        return this.f3991a;
    }

    public long b() {
        return gj9.o1(this.b, 1000000L, this.f30895a);
    }

    public static class d extends SegmentBase {
        public final long c;
        public final long d;

        public d(@Nullable ka7 ka7Var, long j, long j2, long j3, long j4) {
            super(ka7Var, j, j2);
            this.c = j3;
            this.d = j4;
        }

        @Nullable
        public ka7 c() {
            long j = this.d;
            if (j <= 0) {
                return null;
            }
            return new ka7(null, this.c, j);
        }

        public d() {
            this(null, 1L, 0L, 0L, 0L);
        }
    }
}
