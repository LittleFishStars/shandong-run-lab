package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.source.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class hs5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42193a = 4096;
    public static final int b = 40000;
    public static final int c = 384;
    public static final int d = 1152;
    public static final int e = 1152;
    public static final int f = 576;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String[] f17063a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f17062a = {i.K, 48000, com.google.android.exoplayer2.video.spherical.a.h};

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public static final int[] f17064b = {com.google.android.exoplayer2.video.spherical.a.h, 64000, 96000, com.google.android.exoplayer2.video.spherical.a.i, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public static final int[] f17065c = {com.google.android.exoplayer2.video.spherical.a.h, 48000, 56000, 64000, 80000, 96000, 112000, com.google.android.exoplayer2.video.spherical.a.i, 144000, 160000, 176000, 192000, 224000, 256000};

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public static final int[] f17066d = {com.google.android.exoplayer2.video.spherical.a.h, 48000, 56000, 64000, 80000, 96000, 112000, com.google.android.exoplayer2.video.spherical.a.i, 160000, 192000, 224000, 256000, 320000, 384000};

    /* JADX INFO: renamed from: e, reason: collision with other field name */
    public static final int[] f17067e = {com.google.android.exoplayer2.video.spherical.a.h, 40000, 48000, 56000, 64000, 80000, 96000, 112000, com.google.android.exoplayer2.video.spherical.a.i, 160000, 192000, 224000, 256000, 320000};

    /* JADX INFO: renamed from: f, reason: collision with other field name */
    public static final int[] f17068f = {8000, 16000, 24000, com.google.android.exoplayer2.video.spherical.a.h, 40000, 48000, 56000, 64000, 80000, 96000, 112000, com.google.android.exoplayer2.video.spherical.a.i, 144000, 160000};

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f42194a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        @Nullable
        public String f17069a;
        public int b;
        public int c;
        public int d;
        public int e;
        public int f;

        public boolean a(int i) {
            int i2;
            int i3;
            int i4;
            int i5;
            if (!hs5.l(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
                return false;
            }
            this.f42194a = i2;
            this.f17069a = hs5.f17063a[3 - i3];
            int i6 = hs5.f17062a[i5];
            this.c = i6;
            if (i2 == 2) {
                this.c = i6 / 2;
            } else if (i2 == 0) {
                this.c = i6 / 4;
            }
            int i7 = (i >>> 9) & 1;
            this.f = hs5.k(i2, i3);
            if (i3 == 3) {
                int i8 = i2 == 3 ? hs5.f17064b[i4 - 1] : hs5.f17065c[i4 - 1];
                this.e = i8;
                this.b = (((i8 * 12) / this.c) + i7) * 4;
            } else {
                if (i2 == 3) {
                    int i9 = i3 == 2 ? hs5.f17066d[i4 - 1] : hs5.f17067e[i4 - 1];
                    this.e = i9;
                    this.b = ((i9 * 144) / this.c) + i7;
                } else {
                    int i10 = hs5.f17068f[i4 - 1];
                    this.e = i10;
                    this.b = (((i3 == 1 ? 72 : 144) * i10) / this.c) + i7;
                }
            }
            this.d = ((i >> 6) & 3) == 3 ? 1 : 2;
            return true;
        }
    }

    public static int j(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        if (!l(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i7 = f17062a[i5];
        if (i2 == 2) {
            i7 /= 2;
        } else if (i2 == 0) {
            i7 /= 4;
        }
        int i8 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? f17064b[i4 - 1] : f17065c[i4 - 1]) * 12) / i7) + i8) * 4;
        }
        if (i2 == 3) {
            i6 = i3 == 2 ? f17066d[i4 - 1] : f17067e[i4 - 1];
        } else {
            i6 = f17068f[i4 - 1];
        }
        if (i2 == 3) {
            return ((i6 * 144) / i7) + i8;
        }
        return (((i3 == 1 ? 72 : 144) * i6) / i7) + i8;
    }

    public static int k(int i, int i2) {
        if (i2 == 1) {
            if (i == 3) {
                return 1152;
            }
            return f;
        }
        if (i2 == 2) {
            return 1152;
        }
        if (i2 == 3) {
            return 384;
        }
        throw new IllegalArgumentException();
    }

    public static boolean l(int i) {
        return (i & (-2097152)) == -2097152;
    }

    public static int m(int i) {
        int i2;
        int i3;
        if (!l(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        int i5 = (i >>> 10) & 3;
        if (i4 == 0 || i4 == 15 || i5 == 3) {
            return -1;
        }
        return k(i2, i3);
    }
}
