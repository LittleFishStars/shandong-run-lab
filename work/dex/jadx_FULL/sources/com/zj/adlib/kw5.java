package com.zj.adlib;

import androidx.annotation.Nullable;
import com.google.android.exoplayer2.util.Log;
import java.nio.ByteBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class kw5 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42927a = 1;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final String f17800a = "NalUnitUtil";
    public static final int b = 2;
    public static final int c = 5;
    public static final int d = 6;
    public static final int e = 7;
    public static final int f = 8;
    public static final int g = 9;
    public static final int h = 255;
    public static final int i = 6;
    public static final int j = 7;
    public static final int k = 39;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final byte[] f17801a = {0, 0, 0, 1};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final float[] f17802a = {1.0f, 1.0f, 1.0909091f, 0.90909094f, 1.4545455f, 1.2121212f, 2.1818182f, 1.8181819f, 2.909091f, 2.4242425f, 1.6363636f, 1.3636364f, 1.939394f, 1.6161616f, 1.3333334f, 1.5f, 2.0f};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final Object f17799a = new Object();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static int[] f17803a = new int[10];

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f42928a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int f17804a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f17805a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int[] f17806a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;

        public a(int i, boolean z, int i2, int i3, int[] iArr, int i4, int i5, int i6, int i7, float f) {
            this.f17804a = i;
            this.f17805a = z;
            this.b = i2;
            this.c = i3;
            this.f17806a = iArr;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.f42928a = f;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f42929a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f17807a;
        public final int b;

        public b(int i, int i2, boolean z) {
            this.f42929a = i;
            this.b = i2;
            this.f17807a = z;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f42930a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final int f17808a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final boolean f17809a;
        public final int b;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public final boolean f17810b;
        public final int c;

        /* JADX INFO: renamed from: c, reason: collision with other field name */
        public final boolean f17811c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final int i;
        public final int j;

        public c(int i, int i2, int i3, int i4, int i5, int i6, int i7, float f, boolean z, boolean z2, int i8, int i9, int i10, boolean z3) {
            this.f17808a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.f42930a = f;
            this.f17809a = z;
            this.f17810b = z2;
            this.h = i8;
            this.i = i9;
            this.j = i10;
            this.f17811c = z3;
        }
    }

    public static void a(boolean[] zArr) {
        zArr[0] = false;
        zArr[1] = false;
        zArr[2] = false;
    }

    public static void b(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int i4 = i2 + 1;
            if (i4 >= iPosition) {
                byteBuffer.clear();
                return;
            }
            int i5 = byteBuffer.get(i2) & 255;
            if (i3 == 3) {
                if (i5 == 1 && (byteBuffer.get(i4) & 31) == 7) {
                    ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
                    byteBufferDuplicate.position(i2 - 3);
                    byteBufferDuplicate.limit(iPosition);
                    byteBuffer.position(0);
                    byteBuffer.put(byteBufferDuplicate);
                    return;
                }
            } else if (i5 == 0) {
                i3++;
            }
            if (i5 != 0) {
                i3 = 0;
            }
            i2 = i4;
        }
    }

    public static int c(byte[] bArr, int i2, int i3, boolean[] zArr) {
        int i4 = i3 - i2;
        sb0.i(i4 >= 0);
        if (i4 == 0) {
            return i3;
        }
        if (zArr[0]) {
            a(zArr);
            return i2 - 3;
        }
        if (i4 > 1 && zArr[1] && bArr[i2] == 1) {
            a(zArr);
            return i2 - 2;
        }
        if (i4 > 2 && zArr[2] && bArr[i2] == 0 && bArr[i2 + 1] == 1) {
            a(zArr);
            return i2 - 1;
        }
        int i5 = i3 - 1;
        int i6 = i2 + 2;
        while (i6 < i5) {
            byte b2 = bArr[i6];
            if ((b2 & 254) == 0) {
                int i7 = i6 - 2;
                if (bArr[i7] == 0 && bArr[i6 - 1] == 0 && b2 == 1) {
                    a(zArr);
                    return i7;
                }
                i6 -= 2;
            }
            i6 += 3;
        }
        zArr[0] = i4 <= 2 ? !(i4 != 2 ? !(zArr[1] && bArr[i5] == 1) : !(zArr[2] && bArr[i3 + (-2)] == 0 && bArr[i5] == 1)) : bArr[i3 + (-3)] == 0 && bArr[i3 + (-2)] == 0 && bArr[i5] == 1;
        zArr[1] = i4 <= 1 ? zArr[2] && bArr[i5] == 0 : bArr[i3 + (-2)] == 0 && bArr[i5] == 0;
        zArr[2] = bArr[i5] == 0;
        return i3;
    }

    public static int d(byte[] bArr, int i2, int i3) {
        while (i2 < i3 - 2) {
            if (bArr[i2] == 0 && bArr[i2 + 1] == 0 && bArr[i2 + 2] == 3) {
                return i2;
            }
            i2++;
        }
        return i3;
    }

    public static int e(byte[] bArr, int i2) {
        return (bArr[i2 + 3] & 126) >> 1;
    }

    public static int f(byte[] bArr, int i2) {
        return bArr[i2 + 3] & 31;
    }

    public static boolean g(@Nullable String str, byte b2) {
        if ("video/avc".equals(str) && (b2 & 31) == 6) {
            return true;
        }
        return "video/hevc".equals(str) && ((b2 & 126) >> 1) == 39;
    }

    public static a h(byte[] bArr, int i2, int i3) {
        return i(bArr, i2 + 2, i3);
    }

    public static a i(byte[] bArr, int i2, int i3) {
        pm6 pm6Var = new pm6(bArr, i2, i3);
        pm6Var.l(4);
        int iE = pm6Var.e(3);
        pm6Var.k();
        int iE2 = pm6Var.e(2);
        boolean zD = pm6Var.d();
        int iE3 = pm6Var.e(5);
        int i4 = 0;
        for (int i5 = 0; i5 < 32; i5++) {
            if (pm6Var.d()) {
                i4 |= 1 << i5;
            }
        }
        int[] iArr = new int[6];
        for (int i6 = 0; i6 < 6; i6++) {
            iArr[i6] = pm6Var.e(8);
        }
        int iE4 = pm6Var.e(8);
        int i7 = 0;
        for (int i8 = 0; i8 < iE; i8++) {
            if (pm6Var.d()) {
                i7 += 89;
            }
            if (pm6Var.d()) {
                i7 += 8;
            }
        }
        pm6Var.l(i7);
        if (iE > 0) {
            pm6Var.l((8 - iE) * 2);
        }
        int iH = pm6Var.h();
        int iH2 = pm6Var.h();
        if (iH2 == 3) {
            pm6Var.k();
        }
        int iH3 = pm6Var.h();
        int iH4 = pm6Var.h();
        if (pm6Var.d()) {
            int iH5 = pm6Var.h();
            int iH6 = pm6Var.h();
            int iH7 = pm6Var.h();
            int iH8 = pm6Var.h();
            iH3 -= ((iH2 == 1 || iH2 == 2) ? 2 : 1) * (iH5 + iH6);
            iH4 -= (iH2 == 1 ? 2 : 1) * (iH7 + iH8);
        }
        pm6Var.h();
        pm6Var.h();
        int iH9 = pm6Var.h();
        for (int i9 = pm6Var.d() ? 0 : iE; i9 <= iE; i9++) {
            pm6Var.h();
            pm6Var.h();
            pm6Var.h();
        }
        pm6Var.h();
        pm6Var.h();
        pm6Var.h();
        pm6Var.h();
        pm6Var.h();
        pm6Var.h();
        if (pm6Var.d() && pm6Var.d()) {
            n(pm6Var);
        }
        pm6Var.l(2);
        if (pm6Var.d()) {
            pm6Var.l(8);
            pm6Var.h();
            pm6Var.h();
            pm6Var.k();
        }
        p(pm6Var);
        if (pm6Var.d()) {
            for (int i10 = 0; i10 < pm6Var.h(); i10++) {
                pm6Var.l(iH9 + 4 + 1);
            }
        }
        pm6Var.l(2);
        float f2 = 1.0f;
        if (pm6Var.d()) {
            if (pm6Var.d()) {
                int iE5 = pm6Var.e(8);
                if (iE5 == 255) {
                    int iE6 = pm6Var.e(16);
                    int iE7 = pm6Var.e(16);
                    if (iE6 != 0 && iE7 != 0) {
                        f2 = iE6 / iE7;
                    }
                } else {
                    float[] fArr = f17802a;
                    if (iE5 < fArr.length) {
                        f2 = fArr[iE5];
                    } else {
                        Log.n(f17800a, "Unexpected aspect_ratio_idc value: " + iE5);
                    }
                }
            }
            if (pm6Var.d()) {
                pm6Var.k();
            }
            if (pm6Var.d()) {
                pm6Var.l(4);
                if (pm6Var.d()) {
                    pm6Var.l(24);
                }
            }
            if (pm6Var.d()) {
                pm6Var.h();
                pm6Var.h();
            }
            pm6Var.k();
            if (pm6Var.d()) {
                iH4 *= 2;
            }
        }
        return new a(iE2, zD, iE3, i4, iArr, iE4, iH, iH3, iH4, f2);
    }

    public static b j(byte[] bArr, int i2, int i3) {
        return k(bArr, i2 + 1, i3);
    }

    public static b k(byte[] bArr, int i2, int i3) {
        pm6 pm6Var = new pm6(bArr, i2, i3);
        int iH = pm6Var.h();
        int iH2 = pm6Var.h();
        pm6Var.k();
        return new b(iH, iH2, pm6Var.d());
    }

    public static c l(byte[] bArr, int i2, int i3) {
        return m(bArr, i2 + 1, i3);
    }

    public static c m(byte[] bArr, int i2, int i3) {
        int iH;
        boolean zD;
        boolean z;
        int iH2;
        float f2;
        int i4;
        pm6 pm6Var = new pm6(bArr, i2, i3);
        int iE = pm6Var.e(8);
        int iE2 = pm6Var.e(8);
        int iE3 = pm6Var.e(8);
        int iH3 = pm6Var.h();
        int i5 = 1;
        if (iE == 100 || iE == 110 || iE == 122 || iE == 244 || iE == 44 || iE == 83 || iE == 86 || iE == 118 || iE == 128 || iE == 138) {
            iH = pm6Var.h();
            zD = iH == 3 ? pm6Var.d() : false;
            pm6Var.h();
            pm6Var.h();
            pm6Var.k();
            if (pm6Var.d()) {
                int i6 = iH != 3 ? 8 : 12;
                int i7 = 0;
                while (i7 < i6) {
                    if (pm6Var.d()) {
                        o(pm6Var, i7 < 6 ? 16 : 64);
                    }
                    i7++;
                }
            }
        } else {
            iH = 1;
            zD = false;
        }
        int iH4 = pm6Var.h() + 4;
        int iH5 = pm6Var.h();
        if (iH5 == 0) {
            iH = iH;
            zD = zD;
            iH2 = pm6Var.h() + 4;
            z = false;
        } else {
            if (iH5 == 1) {
                boolean zD2 = pm6Var.d();
                pm6Var.g();
                pm6Var.g();
                long jH = pm6Var.h();
                for (int i8 = 0; i8 < jH; i8++) {
                    pm6Var.h();
                }
                z = zD2;
            } else {
                z = false;
            }
            iH2 = 0;
        }
        int iH6 = pm6Var.h();
        pm6Var.k();
        int iH7 = pm6Var.h() + 1;
        int iH8 = pm6Var.h() + 1;
        boolean zD3 = pm6Var.d();
        int i9 = (2 - (zD3 ? 1 : 0)) * iH8;
        if (!zD3) {
            pm6Var.k();
        }
        pm6Var.k();
        int i10 = iH7 * 16;
        int i11 = i9 * 16;
        if (pm6Var.d()) {
            int iH9 = pm6Var.h();
            int iH10 = pm6Var.h();
            int iH11 = pm6Var.h();
            int iH12 = pm6Var.h();
            if (iH == 0) {
                i4 = 2 - (zD3 ? 1 : 0);
            } else {
                int i12 = iH;
                i5 = i12 == 3 ? 1 : 2;
                i4 = (2 - (zD3 ? 1 : 0)) * (i12 == 1 ? 2 : 1);
            }
            i10 -= (iH9 + iH10) * i5;
            i11 -= (iH11 + iH12) * i4;
        }
        int i13 = i10;
        int i14 = i11;
        float f3 = 1.0f;
        if (pm6Var.d() && pm6Var.d()) {
            int iE4 = pm6Var.e(8);
            if (iE4 == 255) {
                int iE5 = pm6Var.e(16);
                int iE6 = pm6Var.e(16);
                if (iE5 != 0 && iE6 != 0) {
                    f3 = iE5 / iE6;
                }
            } else {
                float[] fArr = f17802a;
                if (iE4 < fArr.length) {
                    f2 = fArr[iE4];
                } else {
                    Log.n(f17800a, "Unexpected aspect_ratio_idc value: " + iE4);
                }
            }
            f2 = f3;
        } else {
            f2 = f3;
        }
        return new c(iE, iE2, iE3, iH3, iH6, i13, i14, f2, zD, zD3, iH4, iH5, iH2, z);
    }

    public static void n(pm6 pm6Var) {
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = 0;
            while (i3 < 6) {
                int i4 = 1;
                if (pm6Var.d()) {
                    int iMin = Math.min(64, 1 << ((i2 << 1) + 4));
                    if (i2 > 1) {
                        pm6Var.g();
                    }
                    for (int i5 = 0; i5 < iMin; i5++) {
                        pm6Var.g();
                    }
                } else {
                    pm6Var.h();
                }
                if (i2 == 3) {
                    i4 = 3;
                }
                i3 += i4;
            }
        }
    }

    public static void o(pm6 pm6Var, int i2) {
        int iG = 8;
        int i3 = 8;
        for (int i4 = 0; i4 < i2; i4++) {
            if (iG != 0) {
                iG = ((pm6Var.g() + i3) + 256) % 256;
            }
            if (iG != 0) {
                i3 = iG;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void p(pm6 pm6Var) {
        int iH = pm6Var.h();
        int[] iArr = new int[0];
        int[] iArrCopyOf = new int[0];
        int i2 = -1;
        int i3 = 0;
        int i4 = -1;
        while (i3 < iH) {
            if ((i3 != 0 && pm6Var.d()) == true) {
                int i5 = i2 + i4;
                int iH2 = (1 - ((pm6Var.d() ? 1 : 0) * 2)) * (pm6Var.h() + 1);
                int i6 = i5 + 1;
                boolean[] zArr = new boolean[i6];
                for (int i7 = 0; i7 <= i5; i7++) {
                    if (pm6Var.d()) {
                        zArr[i7] = true;
                    } else {
                        zArr[i7] = pm6Var.d();
                    }
                }
                int[] iArr2 = new int[i6];
                int[] iArr3 = new int[i6];
                int i8 = 0;
                for (int i9 = i4 - 1; i9 >= 0; i9--) {
                    int i10 = iArrCopyOf[i9] + iH2;
                    if (i10 < 0 && zArr[i2 + i9]) {
                        iArr2[i8] = i10;
                        i8++;
                    }
                }
                if (iH2 < 0 && zArr[i5]) {
                    iArr2[i8] = iH2;
                    i8++;
                }
                for (int i11 = 0; i11 < i2; i11++) {
                    int i12 = iArr[i11] + iH2;
                    if (i12 < 0 && zArr[i11]) {
                        iArr2[i8] = i12;
                        i8++;
                    }
                }
                int[] iArrCopyOf2 = Arrays.copyOf(iArr2, i8);
                int i13 = 0;
                for (int i14 = i2 - 1; i14 >= 0; i14--) {
                    int i15 = iArr[i14] + iH2;
                    if (i15 > 0 && zArr[i14]) {
                        iArr3[i13] = i15;
                        i13++;
                    }
                }
                if (iH2 > 0 && zArr[i5]) {
                    iArr3[i13] = iH2;
                    i13++;
                }
                for (int i16 = 0; i16 < i4; i16++) {
                    int i17 = iArrCopyOf[i16] + iH2;
                    if (i17 > 0 && zArr[i2 + i16]) {
                        iArr3[i13] = i17;
                        i13++;
                    }
                }
                iArrCopyOf = Arrays.copyOf(iArr3, i13);
                iArr = iArrCopyOf2;
                i2 = i8;
                i4 = i13;
            } else {
                int iH3 = pm6Var.h();
                int iH4 = pm6Var.h();
                int[] iArr4 = new int[iH3];
                for (int i18 = 0; i18 < iH3; i18++) {
                    iArr4[i18] = pm6Var.h() + 1;
                    pm6Var.k();
                }
                int[] iArr5 = new int[iH4];
                for (int i19 = 0; i19 < iH4; i19++) {
                    iArr5[i19] = pm6Var.h() + 1;
                    pm6Var.k();
                }
                i2 = iH3;
                iArr = iArr4;
                i4 = iH4;
                iArrCopyOf = iArr5;
            }
            i3++;
        }
    }

    public static int q(byte[] bArr, int i2) {
        int i3;
        synchronized (f17799a) {
            int iD = 0;
            int i4 = 0;
            while (iD < i2) {
                try {
                    iD = d(bArr, iD, i2);
                    if (iD < i2) {
                        int[] iArr = f17803a;
                        if (iArr.length <= i4) {
                            f17803a = Arrays.copyOf(iArr, iArr.length * 2);
                        }
                        f17803a[i4] = iD;
                        iD += 3;
                        i4++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            i3 = i2 - i4;
            int i5 = 0;
            int i6 = 0;
            for (int i7 = 0; i7 < i4; i7++) {
                int i8 = f17803a[i7] - i6;
                System.arraycopy(bArr, i6, bArr, i5, i8);
                int i9 = i5 + i8;
                int i10 = i9 + 1;
                bArr[i9] = 0;
                i5 = i10 + 1;
                bArr[i10] = 0;
                i6 += i8 + 3;
            }
            System.arraycopy(bArr, i6, bArr, i5, i3 - i5);
        }
        return i3;
    }
}
