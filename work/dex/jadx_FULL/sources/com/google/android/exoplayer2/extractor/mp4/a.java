package com.google.android.exoplayer2.extractor.mp4;

import com.zj.adlib.gj9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f30685a = 8192;

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f30686a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long f3015a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[] f3016a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final long[] f3017a;
        public final int[] b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final long[] f3018b;

        public b(long[] jArr, int[] iArr, int i, long[] jArr2, int[] iArr2, long j) {
            this.f3017a = jArr;
            this.f3016a = iArr;
            this.f30686a = i;
            this.f3018b = jArr2;
            this.b = iArr2;
            this.f3015a = j;
        }
    }

    public static b a(int i, long[] jArr, int[] iArr, long j) {
        int i2 = 8192 / i;
        int iM = 0;
        for (int i3 : iArr) {
            iM += gj9.m(i3, i2);
        }
        long[] jArr2 = new long[iM];
        int[] iArr2 = new int[iM];
        long[] jArr3 = new long[iM];
        int[] iArr3 = new int[iM];
        int i4 = 0;
        int i5 = 0;
        int iMax = 0;
        for (int i6 = 0; i6 < iArr.length; i6++) {
            int i7 = iArr[i6];
            long j2 = jArr[i6];
            while (i7 > 0) {
                int iMin = Math.min(i2, i7);
                jArr2[i5] = j2;
                int i8 = i * iMin;
                iArr2[i5] = i8;
                iMax = Math.max(iMax, i8);
                jArr3[i5] = ((long) i4) * j;
                iArr3[i5] = 1;
                j2 += (long) iArr2[i5];
                i4 += iMin;
                i7 -= iMin;
                i5++;
            }
        }
        return new b(jArr2, iArr2, iMax, jArr3, iArr3, j * ((long) i4));
    }
}
