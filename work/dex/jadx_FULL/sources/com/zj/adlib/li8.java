package com.zj.adlib;

import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.g;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class li8 extends Timeline {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final long f43074a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final g.C0682g f17956a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final g f17957a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @Nullable
    public final Object f17958a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final boolean f17959a;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long f17960b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final boolean f17961b;
    public final long c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final boolean f17962c;
    public final long d;
    public final long e;
    public final long f;
    public final long g;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final Object f17955b = new Object();
    public static final g b = new g.c().D("SinglePeriodTimeline").L(Uri.EMPTY).a();

    @Deprecated
    public li8(long j, boolean z, boolean z2, boolean z3, @Nullable Object obj, @Nullable Object obj2) {
        this(j, j, 0L, 0L, z, z2, z3, obj, obj2);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int f(Object obj) {
        return f17955b.equals(obj) ? 0 : -1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.b k(int i, Timeline.b bVar, boolean z) {
        sb0.c(i, 0, 1);
        return bVar.x(null, z ? f17955b : null, 0, this.d, -this.f);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int m() {
        return 1;
    }

    @Override // com.google.android.exoplayer2.Timeline
    public Object s(int i) {
        sb0.c(i, 0, 1);
        return f17955b;
    }

    /* JADX WARN: Code duplicated, block: B:14:0x002e A[PHI: r1
      0x002e: PHI (r1v2 long) = (r1v1 long), (r1v1 long), (r1v1 long), (r1v6 long) binds: [B:3:0x000d, B:5:0x0011, B:7:0x0017, B:12:0x002b] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.android.exoplayer2.Timeline
    public Timeline.d u(int i, Timeline.d dVar, long j) {
        long j2;
        sb0.c(i, 0, 1);
        long j3 = this.g;
        boolean z = this.f17961b;
        if (!z || this.f17962c || j == 0) {
            j2 = j3;
        } else {
            long j4 = this.e;
            if (j4 != -9223372036854775807L) {
                j3 += j;
                if (j3 <= j4) {
                    j2 = j3;
                }
            }
            j2 = -9223372036854775807L;
        }
        return dVar.m(Timeline.d.d, this.f17957a, this.f17958a, this.f43074a, this.f17960b, this.c, this.f17959a, z, this.f17956a, j2, this.e, 0, 0, this.f);
    }

    @Override // com.google.android.exoplayer2.Timeline
    public int v() {
        return 1;
    }

    public li8(long j, boolean z, boolean z2, boolean z3, @Nullable Object obj, g gVar) {
        this(j, j, 0L, 0L, z, z2, z3, obj, gVar);
    }

    @Deprecated
    public li8(long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, @Nullable Object obj, @Nullable Object obj2) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2, z3, obj, obj2);
    }

    public li8(long j, long j2, long j3, long j4, boolean z, boolean z2, boolean z3, @Nullable Object obj, g gVar) {
        this(-9223372036854775807L, -9223372036854775807L, -9223372036854775807L, j, j2, j3, j4, z, z2, false, obj, gVar, z3 ? gVar.f3326a : null);
    }

    /* JADX WARN: Illegal instructions before constructor call */
    @Deprecated
    public li8(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, @Nullable Object obj, @Nullable Object obj2) {
        g gVar = b;
        this(j, j2, j3, j4, j5, j6, j7, z, z2, false, obj, gVar.b().K(obj2).a(), z3 ? gVar.f3326a : null);
    }

    @Deprecated
    public li8(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, @Nullable Object obj, g gVar, @Nullable g.C0682g c0682g) {
        this(j, j2, j3, j4, j5, j6, j7, z, z2, false, obj, gVar, c0682g);
    }

    public li8(long j, long j2, long j3, long j4, long j5, long j6, long j7, boolean z, boolean z2, boolean z3, @Nullable Object obj, g gVar, @Nullable g.C0682g c0682g) {
        this.f43074a = j;
        this.f17960b = j2;
        this.c = j3;
        this.d = j4;
        this.e = j5;
        this.f = j6;
        this.g = j7;
        this.f17959a = z;
        this.f17961b = z2;
        this.f17962c = z3;
        this.f17958a = obj;
        this.f17957a = (g) sb0.g(gVar);
        this.f17956a = c0682g;
    }
}
