package com.google.android.exoplayer2;

import android.os.SystemClock;
import com.google.common.primitives.Longs;
import com.zj.adlib.gj9;
import com.zj.adlib.sb0;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a implements LivePlaybackSpeedControl {
    public static final float h = 0.97f;
    public static final float i = 1.03f;
    public static final float j = 0.1f;
    public static final float k = 0.999f;
    public static final long m = 1000;
    public static final long n = 500;
    public static final long o = 20;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f30511a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f2210a;
    public final float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f2211b;
    public final float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final long f2212c;
    public final float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public long f2213d;
    public float e;

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public long f2214e;
    public float f;

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public long f2215f;
    public float g;

    /* JADX INFO: renamed from: g, reason: collision with other field name */
    public long f2216g;

    /* JADX INFO: renamed from: h, reason: collision with other field name */
    public long f2217h;

    /* JADX INFO: renamed from: i, reason: collision with other field name */
    public long f2218i;

    /* JADX INFO: renamed from: j, reason: collision with other field name */
    public long f2219j;

    /* JADX INFO: renamed from: k, reason: collision with other field name */
    public long f2220k;
    public long l;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f30512a = 0.97f;
        public float b = 1.03f;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f2221a = 1000;
        public float c = 1.0E-7f;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f2222b = gj9.Z0(20);

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public long f2223c = gj9.Z0(500);
        public float d = 0.999f;

        public a a() {
            return new a(this.f30512a, this.b, this.f2221a, this.c, this.f2222b, this.f2223c, this.d);
        }

        public b b(float f) {
            sb0.a(f >= 1.0f);
            this.b = f;
            return this;
        }

        public b c(float f) {
            sb0.a(0.0f < f && f <= 1.0f);
            this.f30512a = f;
            return this;
        }

        public b d(long j) {
            sb0.a(j > 0);
            this.f2222b = gj9.Z0(j);
            return this;
        }

        public b e(float f) {
            sb0.a(f >= 0.0f && f < 1.0f);
            this.d = f;
            return this;
        }

        public b f(long j) {
            sb0.a(j > 0);
            this.f2221a = j;
            return this;
        }

        public b g(float f) {
            sb0.a(f > 0.0f);
            this.c = f / 1000000.0f;
            return this;
        }

        public b h(long j) {
            sb0.a(j >= 0);
            this.f2223c = gj9.Z0(j);
            return this;
        }
    }

    public static long d(long j2, long j3, float f) {
        return (long) ((j2 * f) + ((1.0f - f) * j3));
    }

    @Override // com.google.android.exoplayer2.LivePlaybackSpeedControl
    public void a(g.C0682g c0682g) {
        this.f2213d = gj9.Z0(c0682g.f3363a);
        this.f2216g = gj9.Z0(c0682g.f3364b);
        this.f2217h = gj9.Z0(c0682g.c);
        float f = c0682g.f3362a;
        if (f == -3.4028235E38f) {
            f = this.f30511a;
        }
        this.f = f;
        float f2 = c0682g.b;
        if (f2 == -3.4028235E38f) {
            f2 = this.b;
        }
        this.e = f2;
        if (f == 1.0f && f2 == 1.0f) {
            this.f2213d = -9223372036854775807L;
        }
        c();
    }

    public final void b(long j2) {
        long j3 = this.f2220k + (this.l * 3);
        if (this.f2218i > j3) {
            float fZ0 = gj9.Z0(this.f2210a);
            this.f2218i = Longs.s(j3, this.f2215f, this.f2218i - (((long) ((this.g - 1.0f) * fZ0)) + ((long) ((this.e - 1.0f) * fZ0))));
            return;
        }
        long jT = gj9.t(j2 - ((long) (Math.max(0.0f, this.g - 1.0f) / this.c)), this.f2218i, j3);
        this.f2218i = jT;
        long j4 = this.f2217h;
        if (j4 == -9223372036854775807L || jT <= j4) {
            return;
        }
        this.f2218i = j4;
    }

    public final void c() {
        long j2 = this.f2213d;
        if (j2 != -9223372036854775807L) {
            long j3 = this.f2214e;
            if (j3 != -9223372036854775807L) {
                j2 = j3;
            }
            long j4 = this.f2216g;
            if (j4 != -9223372036854775807L && j2 < j4) {
                j2 = j4;
            }
            long j5 = this.f2217h;
            if (j5 != -9223372036854775807L && j2 > j5) {
                j2 = j5;
            }
        } else {
            j2 = -9223372036854775807L;
        }
        if (this.f2215f == j2) {
            return;
        }
        this.f2215f = j2;
        this.f2218i = j2;
        this.f2220k = -9223372036854775807L;
        this.l = -9223372036854775807L;
        this.f2219j = -9223372036854775807L;
    }

    public final void e(long j2, long j3) {
        long j4 = j2 - j3;
        long j5 = this.f2220k;
        if (j5 == -9223372036854775807L) {
            this.f2220k = j4;
            this.l = 0L;
        } else {
            long jMax = Math.max(j4, d(j5, j4, this.d));
            this.f2220k = jMax;
            this.l = d(this.l, Math.abs(j4 - jMax), this.d);
        }
    }

    @Override // com.google.android.exoplayer2.LivePlaybackSpeedControl
    public float getAdjustedPlaybackSpeed(long j2, long j3) {
        if (this.f2213d == -9223372036854775807L) {
            return 1.0f;
        }
        e(j2, j3);
        if (this.f2219j != -9223372036854775807L && SystemClock.elapsedRealtime() - this.f2219j < this.f2210a) {
            return this.g;
        }
        this.f2219j = SystemClock.elapsedRealtime();
        b(j2);
        long j4 = j2 - this.f2218i;
        if (Math.abs(j4) < this.f2211b) {
            this.g = 1.0f;
        } else {
            this.g = gj9.r((this.c * j4) + 1.0f, this.f, this.e);
        }
        return this.g;
    }

    @Override // com.google.android.exoplayer2.LivePlaybackSpeedControl
    public long getTargetLiveOffsetUs() {
        return this.f2218i;
    }

    @Override // com.google.android.exoplayer2.LivePlaybackSpeedControl
    public void notifyRebuffer() {
        long j2 = this.f2218i;
        if (j2 == -9223372036854775807L) {
            return;
        }
        long j3 = j2 + this.f2212c;
        this.f2218i = j3;
        long j4 = this.f2217h;
        if (j4 != -9223372036854775807L && j3 > j4) {
            this.f2218i = j4;
        }
        this.f2219j = -9223372036854775807L;
    }

    @Override // com.google.android.exoplayer2.LivePlaybackSpeedControl
    public void setTargetLiveOffsetOverrideUs(long j2) {
        this.f2214e = j2;
        c();
    }

    public a(float f, float f2, long j2, float f3, long j3, long j4, float f4) {
        this.f30511a = f;
        this.b = f2;
        this.f2210a = j2;
        this.c = f3;
        this.f2211b = j3;
        this.f2212c = j4;
        this.d = f4;
        this.f2213d = -9223372036854775807L;
        this.f2214e = -9223372036854775807L;
        this.f2216g = -9223372036854775807L;
        this.f2217h = -9223372036854775807L;
        this.f = f;
        this.e = f2;
        this.g = 1.0f;
        this.f2219j = -9223372036854775807L;
        this.f2215f = -9223372036854775807L;
        this.f2218i = -9223372036854775807L;
        this.f2220k = -9223372036854775807L;
        this.l = -9223372036854775807L;
    }
}
