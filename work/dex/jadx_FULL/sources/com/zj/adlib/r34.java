package com.zj.adlib;

import com.google.zxing.Binarizer;
import com.google.zxing.LuminanceSource;
import com.google.zxing.NotFoundException;
import java.lang.reflect.Array;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class r34 extends nu3 {
    public static final int d = 3;
    public static final int e = 8;
    public static final int f = 7;
    public static final int g = 40;
    public static final int h = 24;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public tv0 f44352a;

    public r34(LuminanceSource luminanceSource) {
        super(luminanceSource);
    }

    /* JADX WARN: Code duplicated, block: B:38:0x009a A[PHI: r5
      0x009a: PHI (r5v4 int) = (r5v3 int), (r5v7 int), (r5v7 int) binds: [B:31:0x007a, B:33:0x007e, B:34:0x0080] A[DONT_GENERATE, DONT_INLINE]] */
    public static int[][] i(byte[] bArr, int i, int i2, int i3, int i4) {
        char c;
        int i5 = 8;
        int i6 = i4 - 8;
        int i7 = i3 - 8;
        char c2 = 2;
        boolean z = true;
        int i8 = 0;
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) Integer.TYPE, i2, i);
        int i9 = 0;
        while (i9 < i2) {
            int i10 = i9 << 3;
            if (i10 > i6) {
                i10 = i6;
            }
            int i11 = i8;
            while (i11 < i) {
                int i12 = i11 << 3;
                if (i12 > i7) {
                    i12 = i7;
                }
                int i13 = (i10 * i3) + i12;
                int i14 = i8;
                int i15 = i14;
                int i16 = i15;
                int i17 = 255;
                while (i14 < i5) {
                    int i18 = i16;
                    int i19 = 0;
                    while (i19 < i5) {
                        int i20 = bArr[i13 + i19] & 255;
                        i15 += i20;
                        if (i20 < i17) {
                            i17 = i20;
                        }
                        if (i20 > i18) {
                            i18 = i20;
                        }
                        i19++;
                        i5 = 8;
                    }
                    if (i18 - i17 > 24) {
                        while (true) {
                            i14++;
                            i13 += i3;
                            if (i14 < 8) {
                                int i21 = 0;
                                for (int i22 = 8; i21 < i22; i22 = 8) {
                                    i15 += bArr[i13 + i21] & 255;
                                    i21++;
                                }
                            }
                        }
                    }
                    i14++;
                    i13 += i3;
                    i16 = i18;
                    z = true;
                    i5 = 8;
                }
                boolean z2 = z;
                int i23 = i15 >> 6;
                if (i16 - i17 <= 24) {
                    i23 = i17 / 2;
                    if (i9 <= 0 || i11 <= 0) {
                        c = 2;
                    } else {
                        int[] iArr2 = iArr[i9 - 1];
                        int i24 = i11 - 1;
                        c = 2;
                        int i25 = ((iArr2[i11] + (iArr[i9][i24] * 2)) + iArr2[i24]) / 4;
                        if (i17 < i25) {
                            i23 = i25;
                        }
                    }
                } else {
                    c = 2;
                }
                iArr[i9][i11] = i23;
                i11++;
                z = z2;
                c2 = c;
                i5 = 8;
                i8 = 0;
            }
            i9++;
            i5 = 8;
            i8 = 0;
        }
        return iArr;
    }

    public static void j(byte[] bArr, int i, int i2, int i3, int i4, int[][] iArr, tv0 tv0Var) {
        int i5 = i4 - 8;
        int i6 = i3 - 8;
        for (int i7 = 0; i7 < i2; i7++) {
            int i8 = i7 << 3;
            int i9 = i8 > i5 ? i5 : i8;
            int iK = k(i7, i2 - 3);
            for (int i10 = 0; i10 < i; i10++) {
                int i11 = i10 << 3;
                int i12 = i11 > i6 ? i6 : i11;
                int iK2 = k(i10, i - 3);
                int i13 = 0;
                for (int i14 = -2; i14 <= 2; i14++) {
                    int[] iArr2 = iArr[iK + i14];
                    i13 += iArr2[iK2 - 2] + iArr2[iK2 - 1] + iArr2[iK2] + iArr2[iK2 + 1] + iArr2[2 + iK2];
                }
                l(bArr, i12, i9, i13 / 25, i3, tv0Var);
            }
        }
    }

    public static int k(int i, int i2) {
        if (i < 2) {
            return 2;
        }
        return Math.min(i, i2);
    }

    public static void l(byte[] bArr, int i, int i2, int i3, int i4, tv0 tv0Var) {
        int i5 = (i2 * i4) + i;
        int i6 = 0;
        while (i6 < 8) {
            for (int i7 = 0; i7 < 8; i7++) {
                if ((bArr[i5 + i7] & 255) <= i3) {
                    tv0Var.z(i + i7, i2 + i6);
                }
            }
            i6++;
            i5 += i4;
        }
    }

    @Override // com.zj.adlib.nu3, com.google.zxing.Binarizer
    public Binarizer a(LuminanceSource luminanceSource) {
        return new r34(luminanceSource);
    }

    @Override // com.zj.adlib.nu3, com.google.zxing.Binarizer
    public tv0 b() throws NotFoundException {
        tv0 tv0Var = this.f44352a;
        if (tv0Var != null) {
            return tv0Var;
        }
        LuminanceSource luminanceSourceE = e();
        int iE = luminanceSourceE.e();
        int iB = luminanceSourceE.b();
        if (iE < 40 || iB < 40) {
            this.f44352a = super.b();
        } else {
            byte[] bArrC = luminanceSourceE.c();
            int i = iE >> 3;
            if ((iE & 7) != 0) {
                i++;
            }
            int i2 = i;
            int i3 = iB >> 3;
            if ((iB & 7) != 0) {
                i3++;
            }
            int i4 = i3;
            int[][] iArrI = i(bArrC, i2, i4, iE, iB);
            tv0 tv0Var2 = new tv0(iE, iB);
            j(bArrC, i2, i4, iE, iB, iArrI, tv0Var2);
            this.f44352a = tv0Var2;
        }
        return this.f44352a;
    }
}
