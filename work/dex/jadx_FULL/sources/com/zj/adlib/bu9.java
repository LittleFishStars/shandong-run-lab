package com.zj.adlib;

import com.google.android.exoplayer2.extractor.SeekMap;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class bu9 implements SeekMap {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f40841a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final zt9 f15635a;
    public final long b;
    public final long c;
    public final int d;

    public bu9(zt9 zt9Var, int i, long j, long j2) {
        this.f15635a = zt9Var;
        this.d = i;
        this.f40841a = j;
        long j3 = (j2 - j) / ((long) zt9Var.e);
        this.b = j3;
        this.c = b(j3);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public SeekMap.a a(long j) {
        long jT = gj9.t((((long) this.f15635a.c) * j) / (((long) this.d) * 1000000), 0L, this.b - 1);
        long j2 = this.f40841a + (((long) this.f15635a.e) * jT);
        long jB = b(jT);
        x38 x38Var = new x38(jB, j2);
        if (jB >= j || jT == this.b - 1) {
            return new SeekMap.a(x38Var);
        }
        long j3 = jT + 1;
        return new SeekMap.a(x38Var, new x38(b(j3), this.f40841a + (((long) this.f15635a.e) * j3)));
    }

    public final long b(long j) {
        return gj9.o1(j * ((long) this.d), 1000000L, this.f15635a.c);
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public long getDurationUs() {
        return this.c;
    }

    @Override // com.google.android.exoplayer2.extractor.SeekMap
    public boolean isSeekable() {
        return true;
    }
}
