package com.zj.adlib;

import java.lang.reflect.Array;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class kh6 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float[][] f42819a = (float[][]) Array.newInstance((Class<?>) Float.TYPE, lh6.f17943b.length, 8);

    static {
        int i;
        int i2 = 0;
        while (true) {
            int[] iArr = lh6.f17943b;
            if (i2 >= iArr.length) {
                return;
            }
            int i3 = iArr[i2];
            int i4 = i3 & 1;
            int i5 = 0;
            while (i5 < 8) {
                float f = 0.0f;
                while (true) {
                    i = i3 & 1;
                    if (i == i4) {
                        f += 1.0f;
                        i3 >>= 1;
                    }
                }
                f42819a[i2][(8 - i5) - 1] = f / 17.0f;
                i5++;
                i4 = i;
            }
            i2++;
        }
    }

    public static int a(int[] iArr) {
        long j = 0;
        for (int i = 0; i < iArr.length; i++) {
            for (int i2 = 0; i2 < iArr[i]; i2++) {
                int i3 = 1;
                long j2 = j << 1;
                if (i % 2 != 0) {
                    i3 = 0;
                }
                j = j2 | ((long) i3);
            }
        }
        return (int) j;
    }

    public static int b(int[] iArr) {
        int iD = se5.d(iArr);
        float[] fArr = new float[8];
        if (iD > 1) {
            for (int i = 0; i < 8; i++) {
                fArr[i] = iArr[i] / iD;
            }
        }
        float f = Float.MAX_VALUE;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            float[][] fArr2 = f42819a;
            if (i3 >= fArr2.length) {
                return i2;
            }
            float[] fArr3 = fArr2[i3];
            float f2 = 0.0f;
            for (int i4 = 0; i4 < 8; i4++) {
                float f3 = fArr3[i4] - fArr[i4];
                f2 += f3 * f3;
                if (f2 >= f) {
                    break;
                }
            }
            if (f2 < f) {
                i2 = lh6.f17943b[i3];
                f = f2;
            }
            i3++;
        }
    }

    public static int c(int[] iArr) {
        int iA = a(iArr);
        if (lh6.b(iA) == -1) {
            return -1;
        }
        return iA;
    }

    public static int d(int[] iArr) {
        int iC = c(e(iArr));
        return iC != -1 ? iC : b(iArr);
    }

    public static int[] e(int[] iArr) {
        float fD = se5.d(iArr);
        int[] iArr2 = new int[8];
        int i = 0;
        int i2 = 0;
        for (int i3 = 0; i3 < 17; i3++) {
            float f = (fD / 34.0f) + ((i3 * fD) / 17.0f);
            int i4 = iArr[i2];
            if (i + i4 <= f) {
                i += i4;
                i2++;
            }
            iArr2[i2] = iArr2[i2] + 1;
        }
        return iArr2;
    }
}
