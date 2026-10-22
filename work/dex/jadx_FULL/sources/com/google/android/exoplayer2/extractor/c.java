package com.google.android.exoplayer2.extractor;

import com.zj.adlib.x38;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class c implements SeekMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f30638a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f2736a;
    public final long b;
    public final long c;
    public final int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final long f2737d;
    public final int e;

    public c(long j, long j2, int i, int i2) {
        this(j, j2, i, i2, false);
    }

    public static long d(long j, long j2, int i) {
        return ((Math.max(0L, j - j2) * 8) * 1000000) / ((long) i);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.a a(long j) {
        if (this.c == -1 && !this.f2736a) {
            return new SeekMap.a(new x38(0L, this.b));
        }
        long jB = b(j);
        long jC = c(jB);
        x38 x38Var = new x38(jC, jB);
        if (this.c != -1 && jC < j) {
            int i = this.d;
            if (((long) i) + jB < this.f30638a) {
                long j2 = jB + ((long) i);
                return new SeekMap.a(x38Var, new x38(c(j2), j2));
            }
        }
        return new SeekMap.a(x38Var);
    }

    public final long b(long j) {
        long j2 = (j * ((long) this.e)) / 8000000;
        int i = this.d;
        long jMin = (j2 / ((long) i)) * ((long) i);
        long j3 = this.c;
        if (j3 != -1) {
            jMin = Math.min(jMin, j3 - ((long) i));
        }
        return this.b + Math.max(jMin, 0L);
    }

    public long c(long j) {
        return d(j, this.b, this.e);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.f2737d;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return this.c != -1 || this.f2736a;
    }

    public c(long j, long j2, int i, int i2, boolean z) {
        this.f30638a = j;
        this.b = j2;
        this.d = i2 == -1 ? 1 : i2;
        this.e = i;
        this.f2736a = z;
        if (j == -1) {
            this.c = -1L;
            this.f2737d = -9223372036854775807L;
        } else {
            this.c = j - j2;
            this.f2737d = d(j, j2, i);
        }
    }
}
