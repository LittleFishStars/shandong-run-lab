package com.zj.adlib;

import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class w38 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w38 f45518a;
    public static final w38 b;
    public static final w38 c;
    public static final w38 d;
    public static final w38 e;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f20365a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f20366b;

    static {
        w38 w38Var = new w38(0L, 0L);
        f45518a = w38Var;
        b = new w38(Long.MAX_VALUE, Long.MAX_VALUE);
        c = new w38(Long.MAX_VALUE, 0L);
        d = new w38(0L, Long.MAX_VALUE);
        e = w38Var;
    }

    public w38(long j, long j2) {
        sb0.a(j >= 0);
        sb0.a(j2 >= 0);
        this.f20365a = j;
        this.f20366b = j2;
    }

    public long a(long j, long j2, long j3) {
        long j4 = this.f20365a;
        if (j4 == 0 && this.f20366b == 0) {
            return j;
        }
        long jY1 = gj9.y1(j, j4, Long.MIN_VALUE);
        long jB = gj9.b(j, this.f20366b, Long.MAX_VALUE);
        boolean z = jY1 <= j2 && j2 <= jB;
        boolean z2 = jY1 <= j3 && j3 <= jB;
        if (z && z2) {
            return Math.abs(j2 - j) <= Math.abs(j3 - j) ? j2 : j3;
        }
        if (z) {
            return j2;
        }
        return z2 ? j3 : jY1;
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || w38.class != obj.getClass()) {
            return false;
        }
        w38 w38Var = (w38) obj;
        return this.f20365a == w38Var.f20365a && this.f20366b == w38Var.f20366b;
    }

    public int hashCode() {
        return (((int) this.f20365a) * 31) + ((int) this.f20366b);
    }
}
