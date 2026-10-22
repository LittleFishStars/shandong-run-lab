package com.zj.adlib;

import com.google.android.exoplayer2.extractor.mp4.Track;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class ma9 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43259a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long f18158a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Track f18159a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f18160a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final long[] f18161a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final int[] f18162b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final long[] f18163b;

    public ma9(Track track, long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
        sb0.a(iArr.length == jArr2.length);
        sb0.a(jArr.length == jArr2.length);
        sb0.a(iArr2.length == jArr2.length);
        this.f18159a = track;
        this.f18161a = jArr;
        this.f18160a = iArr;
        this.b = i;
        this.f18163b = jArr2;
        this.f18162b = iArr2;
        this.f18158a = j;
        this.f43259a = jArr.length;
        if (iArr2.length > 0) {
            int length = iArr2.length - 1;
            iArr2[length] = iArr2[length] | 536870912;
        }
    }

    public int a(long j) {
        for (int iJ = gj9.j(this.f18163b, j, true, false); iJ >= 0; iJ--) {
            if ((this.f18162b[iJ] & 1) != 0) {
                return iJ;
            }
        }
        return -1;
    }

    public int b(long j) {
        for (int iF = gj9.f(this.f18163b, j, true, false); iF < this.f18163b.length; iF++) {
            if ((this.f18162b[iF] & 1) != 0) {
                return iF;
            }
        }
        return -1;
    }
}
