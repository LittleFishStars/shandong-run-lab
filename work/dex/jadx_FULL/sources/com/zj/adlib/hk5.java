package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.MediaSource;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class hk5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f42145a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final MediaSource.a f16997a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f16998a;
    public final long b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f16999b;
    public final long c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f17000c;
    public final long d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final boolean f17001d;

    public hk5(MediaSource.a aVar, long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, boolean z4) {
        boolean z5 = false;
        sb0.a(!z4 || z2);
        sb0.a(!z3 || z2);
        if (!z || (!z2 && !z3 && !z4)) {
            z5 = true;
        }
        sb0.a(z5);
        this.f16997a = aVar;
        this.f42145a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
        this.f16998a = z;
        this.f16999b = z2;
        this.f17000c = z3;
        this.f17001d = z4;
    }

    public hk5 a(long j) {
        return j == this.b ? this : new hk5(this.f16997a, this.f42145a, j, this.c, this.d, this.f16998a, this.f16999b, this.f17000c, this.f17001d);
    }

    public hk5 b(long j) {
        return j == this.f42145a ? this : new hk5(this.f16997a, j, this.b, this.c, this.d, this.f16998a, this.f16999b, this.f17000c, this.f17001d);
    }

    public boolean equals(@Nullable Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || hk5.class != obj.getClass()) {
            return false;
        }
        hk5 hk5Var = (hk5) obj;
        return this.f42145a == hk5Var.f42145a && this.b == hk5Var.b && this.c == hk5Var.c && this.d == hk5Var.d && this.f16998a == hk5Var.f16998a && this.f16999b == hk5Var.f16999b && this.f17000c == hk5Var.f17000c && this.f17001d == hk5Var.f17001d && gj9.c(this.f16997a, hk5Var.f16997a);
    }

    public int hashCode() {
        return ((((((((((((((((527 + this.f16997a.hashCode()) * 31) + ((int) this.f42145a)) * 31) + ((int) this.b)) * 31) + ((int) this.c)) * 31) + ((int) this.d)) * 31) + (this.f16998a ? 1 : 0)) * 31) + (this.f16999b ? 1 : 0)) * 31) + (this.f17000c ? 1 : 0)) * 31) + (this.f17001d ? 1 : 0);
    }
}
