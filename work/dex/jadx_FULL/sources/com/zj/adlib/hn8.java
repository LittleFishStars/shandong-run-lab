package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class hn8 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f42164a = 512;

    public final void A(int i, double[] dArr, int i2, double[] dArr2, int i3) {
        int i4 = i >> 1;
        int i5 = i2 / i;
        int i6 = 0;
        for (int i7 = 1; i7 < i4; i7++) {
            int i8 = i - i7;
            i6 += i5;
            double d = dArr2[i3 + i6];
            double d2 = dArr2[(i3 + i2) - i6];
            double d3 = d - d2;
            double d4 = d + d2;
            double d5 = dArr[i7];
            double d6 = dArr[i8];
            dArr[i7] = (d3 * d5) + (d4 * d6);
            dArr[i8] = (d4 * d5) - (d3 * d6);
        }
        dArr[i4] = dArr[i4] * dArr2[i3 + 0];
    }

    public void B(int i, int i2, double[] dArr, int[] iArr, double[] dArr2) {
        int i3;
        int i4;
        int i5 = iArr[0];
        if (i > (i5 << 2)) {
            i5 = i >> 2;
            H(i5, iArr, dArr2);
        }
        int i6 = i5;
        int i7 = iArr[1];
        if (i > i7) {
            G(i, iArr, dArr2, i6);
            i3 = i;
        } else {
            i3 = i7;
        }
        if (i2 < 0) {
            double d = dArr[i - 1];
            for (int i8 = i - 2; i8 >= 2; i8 -= 2) {
                int i9 = i8 - 1;
                dArr[i8 + 1] = dArr[i8] - dArr[i9];
                dArr[i8] = dArr[i8] + dArr[i9];
            }
            double d2 = dArr[0];
            dArr[1] = d2 - d;
            dArr[0] = d2 + d;
            if (i > 4) {
                J(i, dArr, i3, dArr2, i6);
                i4 = 2;
                j(i, dArr, iArr, 2, i6, dArr2);
            } else {
                i4 = 2;
                if (i == 4) {
                    j(i, dArr, iArr, 2, i6, dArr2);
                }
            }
        } else {
            i4 = 2;
        }
        A(i, dArr, i3, dArr2, i6);
        if (i2 >= 0) {
            if (i > 4) {
                s(i, dArr, iArr, 2, i6, dArr2);
                K(i, dArr, i3, dArr2, i6);
            } else if (i == 4) {
                s(i, dArr, iArr, 2, i6, dArr2);
            }
            double d3 = dArr[0];
            double d4 = dArr[1];
            double d5 = d3 - d4;
            dArr[0] = d3 + d4;
            for (int i10 = i4; i10 < i; i10 += 2) {
                int i11 = i10 + 1;
                dArr[i10 - 1] = dArr[i10] - dArr[i11];
                dArr[i10] = dArr[i10] + dArr[i11];
            }
            dArr[i - 1] = d5;
        }
    }

    public void C(int i, int i2, double[] dArr, int[] iArr, double[] dArr2) {
        int i3;
        int i4;
        int i5 = iArr[0];
        if (i > (i5 << 2)) {
            i5 = i >> 2;
            H(i5, iArr, dArr2);
        }
        int i6 = i5;
        int i7 = iArr[1];
        if (i > i7) {
            G(i, iArr, dArr2, i6);
            i3 = i;
        } else {
            i3 = i7;
        }
        if (i2 < 0) {
            double d = dArr[i - 1];
            for (int i8 = i - 2; i8 >= 2; i8 -= 2) {
                int i9 = i8 - 1;
                dArr[i8 + 1] = (-dArr[i8]) - dArr[i9];
                dArr[i8] = dArr[i8] - dArr[i9];
            }
            double d2 = dArr[0];
            dArr[1] = d2 + d;
            dArr[0] = d2 - d;
            if (i > 4) {
                J(i, dArr, i3, dArr2, i6);
                i4 = 2;
                j(i, dArr, iArr, 2, i6, dArr2);
            } else {
                i4 = 2;
                if (i == 4) {
                    j(i, dArr, iArr, 2, i6, dArr2);
                }
            }
        } else {
            i4 = 2;
        }
        F(i, dArr, i3, dArr2, i6);
        if (i2 >= 0) {
            if (i > 4) {
                s(i, dArr, iArr, 2, i6, dArr2);
                K(i, dArr, i3, dArr2, i6);
            } else if (i == 4) {
                s(i, dArr, iArr, 2, i6, dArr2);
            }
            double d3 = dArr[0];
            double d4 = dArr[1];
            double d5 = d3 - d4;
            dArr[0] = d3 + d4;
            for (int i10 = i4; i10 < i; i10 += 2) {
                int i11 = i10 + 1;
                dArr[i10 - 1] = (-dArr[i10]) - dArr[i11];
                dArr[i10] = dArr[i10] - dArr[i11];
            }
            dArr[i - 1] = -d5;
        }
    }

    public void D(int i, double[] dArr, double[] dArr2, int[] iArr, double[] dArr3) {
        int i2;
        int i3;
        int i4 = iArr[0];
        if (i > (i4 << 3)) {
            i4 = i >> 3;
            H(i4, iArr, dArr3);
        }
        int i5 = i4;
        int i6 = iArr[1];
        if (i > (i6 << 1)) {
            i6 = i >> 1;
            G(i6, iArr, dArr3, i5);
        }
        int i7 = i6;
        int i8 = i >> 1;
        double d = dArr[i8];
        double d2 = dArr[0];
        double d3 = dArr[i];
        double d4 = d2 + d3;
        dArr[0] = d2 - d3;
        dArr2[0] = d4 - d;
        dArr2[i8] = d4 + d;
        if (i <= 2) {
            dArr[1] = dArr[0];
            dArr[2] = dArr2[0];
            dArr[0] = dArr2[1];
            return;
        }
        int i9 = i8 >> 1;
        for (int i10 = 1; i10 < i9; i10++) {
            int i11 = i8 - i10;
            double d5 = dArr[i10];
            double d6 = dArr[i - i10];
            double d7 = d5 - d6;
            double d8 = d5 + d6;
            double d9 = dArr[i11];
            double d10 = dArr[i - i11];
            double d11 = d9 - d10;
            double d12 = d9 + d10;
            dArr[i10] = d7;
            dArr[i11] = d11;
            dArr2[i10] = d8 - d12;
            dArr2[i11] = d8 + d12;
        }
        int i12 = i - i9;
        dArr2[i9] = dArr[i9] + dArr[i12];
        dArr[i9] = dArr[i9] - dArr[i12];
        A(i8, dArr, i7, dArr3, i5);
        if (i8 > 4) {
            i2 = 4;
            s(i8, dArr, iArr, 2, i5, dArr3);
            K(i8, dArr, i7, dArr3, i5);
        } else {
            i2 = 4;
            if (i8 == 4) {
                s(i8, dArr, iArr, 2, i5, dArr3);
            }
        }
        dArr[i - 1] = dArr[0] - dArr[1];
        dArr[1] = dArr[0] + dArr[1];
        int i13 = 2;
        for (int i14 = i8 - 2; i14 >= 2; i14 -= 2) {
            int i15 = i14 * 2;
            int i16 = i14 + 1;
            dArr[i15 + 1] = dArr[i14] + dArr[i16];
            dArr[i15 - 1] = dArr[i14] - dArr[i16];
        }
        int i17 = i9;
        int i18 = 2;
        while (i17 >= i13) {
            A(i17, dArr2, i7, dArr3, i5);
            if (i17 > i2) {
                int i19 = i17;
                i3 = i13;
                s(i19, dArr2, iArr, 2, i5, dArr3);
                K(i19, dArr2, i7, dArr3, i5);
            } else {
                i3 = i13;
                if (i17 == i2) {
                    s(i17, dArr2, iArr, 2, i5, dArr3);
                }
            }
            dArr[i - i18] = dArr2[0] - dArr2[1];
            dArr[i18] = dArr2[0] + dArr2[1];
            int i20 = 0;
            for (int i21 = i3; i21 < i17; i21 += 2) {
                i20 += i18 << 2;
                int i22 = i21 + 1;
                dArr[i20 - i18] = dArr2[i21] - dArr2[i22];
                dArr[i20 + i18] = dArr2[i21] + dArr2[i22];
            }
            i18 <<= 1;
            int i23 = i17 >> 1;
            for (int i24 = 0; i24 < i23; i24++) {
                int i25 = i17 - i24;
                int i26 = i17 + i25;
                int i27 = i17 + i24;
                dArr2[i24] = dArr2[i26] - dArr2[i27];
                dArr2[i25] = dArr2[i26] + dArr2[i27];
            }
            dArr2[i23] = dArr2[i17 + i23];
            i17 = i23;
            i13 = i3;
        }
        int i28 = i13;
        dArr[i18] = dArr2[0];
        dArr[i] = dArr2[i28] - dArr2[1];
        dArr[0] = dArr2[i28] + dArr2[1];
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v0 */
    /* JADX WARN: Type inference failed for: r2v1 */
    /* JADX WARN: Type inference failed for: r2v24 */
    public void E(int i, double[] dArr, double[] dArr2, int[] iArr, double[] dArr3) {
        ?? r2;
        int i2;
        int i3;
        int i4;
        boolean z = false;
        int i5 = iArr[0];
        if (i > (i5 << 3)) {
            i5 = i >> 3;
            H(i5, iArr, dArr3);
        }
        int i6 = i5;
        int i7 = iArr[1];
        if (i > (i7 << 1)) {
            i7 = i >> 1;
            G(i7, iArr, dArr3, i6);
        }
        int i8 = i7;
        if (i > 2) {
            int i9 = i >> 1;
            int i10 = i9 >> 1;
            for (int i11 = 1; i11 < i10; i11++) {
                int i12 = i9 - i11;
                double d = dArr[i11];
                double d2 = dArr[i - i11];
                double d3 = d + d2;
                double d4 = d - d2;
                double d5 = dArr[i12];
                double d6 = dArr[i - i12];
                double d7 = d5 + d6;
                double d8 = d5 - d6;
                dArr[i11] = d3;
                dArr[i12] = d7;
                dArr2[i11] = d4 + d8;
                dArr2[i12] = d4 - d8;
            }
            int i13 = i - i10;
            dArr2[0] = dArr[i10] - dArr[i13];
            dArr[i10] = dArr[i10] + dArr[i13];
            dArr[0] = dArr[i9];
            F(i9, dArr, i8, dArr3, i6);
            if (i9 > 4) {
                i2 = 4;
                i3 = i9;
                s(i9, dArr, iArr, 2, i6, dArr3);
                K(i3, dArr, i8, dArr3, i6);
            } else {
                i2 = 4;
                if (i9 == 4) {
                    i3 = i9;
                    s(i9, dArr, iArr, 2, i6, dArr3);
                } else {
                    i3 = i9;
                }
            }
            dArr[i - 1] = dArr[1] - dArr[0];
            dArr[1] = dArr[0] + dArr[1];
            int i14 = i3 - 2;
            for (int i15 = 2; i14 >= i15; i15 = 2) {
                int i16 = i14 * 2;
                int i17 = i14 + 1;
                dArr[i16 + 1] = dArr[i14] - dArr[i17];
                dArr[i16 - 1] = (-dArr[i14]) - dArr[i17];
                i14 -= 2;
            }
            int i18 = i10;
            int i19 = 2;
            int i20 = 2;
            while (i18 >= i19) {
                int i21 = i18;
                F(i18, dArr2, i8, dArr3, i6);
                if (i21 > i2) {
                    i4 = i19;
                    s(i21, dArr2, iArr, 2, i6, dArr3);
                    K(i21, dArr2, i8, dArr3, i6);
                } else {
                    i4 = i19;
                    if (i21 == i2) {
                        s(i21, dArr2, iArr, 2, i6, dArr3);
                    }
                }
                dArr[i - i20] = dArr2[1] - dArr2[0];
                dArr[i20] = dArr2[0] + dArr2[1];
                int i22 = 0;
                for (int i23 = i4; i23 < i21; i23 += 2) {
                    i22 += i20 << 2;
                    int i24 = i23 + 1;
                    dArr[i22 - i20] = (-dArr2[i23]) - dArr2[i24];
                    dArr[i22 + i20] = dArr2[i23] - dArr2[i24];
                }
                i20 <<= 1;
                i18 = i21 >> 1;
                for (int i25 = 1; i25 < i18; i25++) {
                    int i26 = i21 - i25;
                    int i27 = i21 + i26;
                    int i28 = i21 + i25;
                    dArr2[i25] = dArr2[i27] + dArr2[i28];
                    dArr2[i26] = dArr2[i27] - dArr2[i28];
                }
                dArr2[0] = dArr2[i21 + i18];
                z = false;
                i19 = i4;
            }
            boolean z2 = z;
            dArr[i20] = dArr2[z2 ? 1 : 0];
            r2 = z2;
        } else {
            r2 = 0;
        }
        dArr[r2] = 0.0d;
    }

    public final void F(int i, double[] dArr, int i2, double[] dArr2, int i3) {
        int i4 = i >> 1;
        int i5 = i2 / i;
        int i6 = 0;
        for (int i7 = 1; i7 < i4; i7++) {
            int i8 = i - i7;
            i6 += i5;
            double d = dArr2[i3 + i6];
            double d2 = dArr2[(i3 + i2) - i6];
            double d3 = d - d2;
            double d4 = d + d2;
            double d5 = dArr[i8];
            double d6 = dArr[i7];
            dArr[i8] = (d3 * d5) + (d4 * d6);
            dArr[i7] = (d4 * d5) - (d3 * d6);
        }
        dArr[i4] = dArr[i4] * dArr2[i3 + 0];
    }

    public final void G(int i, int[] iArr, double[] dArr, int i2) {
        iArr[1] = i;
        if (i > 1) {
            int i3 = i >> 1;
            double d = i3;
            double d2 = 0.7853981633974483d / d;
            double dCos = Math.cos(d * d2);
            dArr[i2 + 0] = dCos;
            dArr[i2 + i3] = dCos * 0.5d;
            for (int i4 = 1; i4 < i3; i4++) {
                double d3 = ((double) i4) * d2;
                dArr[i2 + i4] = Math.cos(d3) * 0.5d;
                dArr[(i2 + i) - i4] = Math.sin(d3) * 0.5d;
            }
        }
    }

    public final void H(int i, int[] iArr, double[] dArr) {
        int i2 = 0;
        iArr[0] = i;
        iArr[1] = 1;
        if (i > 2) {
            int i3 = i >> 1;
            double d = i3;
            double d2 = 0.7853981633974483d / d;
            double dCos = Math.cos(d * d2);
            dArr[0] = 1.0d;
            dArr[1] = dCos;
            if (i3 >= 4) {
                dArr[2] = 0.5d / Math.cos(2.0d * d2);
                dArr[3] = 0.5d / Math.cos(6.0d * d2);
            }
            for (int i4 = 4; i4 < i3; i4 += 4) {
                double d3 = i4;
                double d4 = d2 * d3;
                dArr[i4] = Math.cos(d4);
                dArr[i4 + 1] = Math.sin(d4);
                double d5 = 3.0d * d2 * d3;
                dArr[i4 + 2] = Math.cos(d5);
                dArr[i4 + 3] = Math.sin(d5);
            }
            while (i3 > 2) {
                int i5 = i2 + i3;
                i3 >>= 1;
                dArr[i5] = 1.0d;
                dArr[i5 + 1] = dCos;
                if (i3 >= 4) {
                    double d6 = dArr[i2 + 4];
                    double d7 = dArr[i2 + 6];
                    dArr[i5 + 2] = 0.5d / d6;
                    dArr[i5 + 3] = 0.5d / d7;
                }
                for (int i6 = 4; i6 < i3; i6 += 4) {
                    int i7 = (i6 * 2) + i2;
                    double d8 = dArr[i7];
                    double d9 = dArr[i7 + 1];
                    double d10 = dArr[i7 + 2];
                    double d11 = dArr[i7 + 3];
                    int i8 = i5 + i6;
                    dArr[i8] = d8;
                    dArr[i8 + 1] = d9;
                    dArr[i8 + 2] = d10;
                    dArr[i8 + 3] = d11;
                }
                i2 = i5;
            }
        }
    }

    public void I(int i, int i2, double[] dArr, int[] iArr, double[] dArr2) {
        int i3 = iArr[0];
        if (i > (i3 << 2)) {
            i3 = i >> 2;
            H(i3, iArr, dArr2);
        }
        int i4 = i3;
        int i5 = iArr[1];
        if (i > (i5 << 2)) {
            i5 = i >> 2;
            G(i5, iArr, dArr2, i4);
        }
        int i6 = i5;
        if (i2 >= 0) {
            if (i > 4) {
                s(i, dArr, iArr, 2, i4, dArr2);
                K(i, dArr, i6, dArr2, i4);
            } else if (i == 4) {
                s(i, dArr, iArr, 2, i4, dArr2);
            }
            double d = dArr[0];
            double d2 = dArr[1];
            dArr[0] = d + d2;
            dArr[1] = d - d2;
            return;
        }
        double d3 = dArr[0];
        double d4 = (d3 - dArr[1]) * 0.5d;
        dArr[1] = d4;
        dArr[0] = d3 - d4;
        if (i > 4) {
            J(i, dArr, i6, dArr2, i4);
            j(i, dArr, iArr, 2, i4, dArr2);
        } else if (i == 4) {
            j(i, dArr, iArr, 2, i4, dArr2);
        }
    }

    public final void J(int i, double[] dArr, int i2, double[] dArr2, int i3) {
        int i4 = i >> 1;
        int i5 = (i2 * 2) / i4;
        int i6 = 0;
        for (int i7 = 2; i7 < i4; i7 += 2) {
            int i8 = i - i7;
            i6 += i5;
            double d = 0.5d - dArr2[(i3 + i2) - i6];
            double d2 = dArr2[i3 + i6];
            double d3 = dArr[i7];
            double d4 = d3 - dArr[i8];
            int i9 = i7 + 1;
            int i10 = i8 + 1;
            double d5 = dArr[i9] + dArr[i10];
            double d6 = (d * d4) + (d2 * d5);
            double d7 = (d * d5) - (d2 * d4);
            dArr[i7] = d3 - d6;
            dArr[i9] = dArr[i9] - d7;
            dArr[i8] = dArr[i8] + d6;
            dArr[i10] = dArr[i10] - d7;
        }
    }

    public final void K(int i, double[] dArr, int i2, double[] dArr2, int i3) {
        int i4 = i >> 1;
        int i5 = (i2 * 2) / i4;
        int i6 = 0;
        for (int i7 = 2; i7 < i4; i7 += 2) {
            int i8 = i - i7;
            i6 += i5;
            double d = 0.5d - dArr2[(i3 + i2) - i6];
            double d2 = dArr2[i3 + i6];
            double d3 = dArr[i7];
            double d4 = d3 - dArr[i8];
            int i9 = i7 + 1;
            int i10 = i8 + 1;
            double d5 = dArr[i9] + dArr[i10];
            double d6 = (d * d4) - (d2 * d5);
            double d7 = (d * d5) + (d2 * d4);
            dArr[i7] = d3 - d6;
            dArr[i9] = dArr[i9] - d7;
            dArr[i8] = dArr[i8] + d6;
            dArr[i10] = dArr[i10] - d7;
        }
    }

    public final void a(int i, int[] iArr, int i2, double[] dArr) {
        int i3;
        iArr[i2 + 0] = 0;
        int i4 = i;
        int i5 = 1;
        while (true) {
            i3 = i5 << 3;
            if (i3 >= i4) {
                break;
            }
            i4 >>= 1;
            for (int i6 = 0; i6 < i5; i6++) {
                iArr[i2 + i5 + i6] = iArr[i2 + i6] + i4;
            }
            i5 <<= 1;
        }
        int i7 = i5 * 2;
        if (i3 != i4) {
            for (int i8 = 1; i8 < i5; i8++) {
                for (int i9 = 0; i9 < i8; i9++) {
                    int i10 = (i9 * 2) + iArr[i2 + i8];
                    int i11 = (i8 * 2) + iArr[i2 + i9];
                    double d = dArr[i10];
                    int i12 = i10 + 1;
                    double d2 = dArr[i12];
                    double d3 = dArr[i11];
                    int i13 = i11 + 1;
                    double d4 = dArr[i13];
                    dArr[i10] = d3;
                    dArr[i12] = d4;
                    dArr[i11] = d;
                    dArr[i13] = d2;
                    int i14 = i10 + i7;
                    int i15 = i11 + i7;
                    double d5 = dArr[i14];
                    int i16 = i14 + 1;
                    double d6 = dArr[i16];
                    double d7 = dArr[i15];
                    int i17 = i15 + 1;
                    double d8 = dArr[i17];
                    dArr[i14] = d7;
                    dArr[i16] = d8;
                    dArr[i15] = d5;
                    dArr[i17] = d6;
                }
            }
            return;
        }
        for (int i18 = 0; i18 < i5; i18++) {
            for (int i19 = 0; i19 < i18; i19++) {
                int i20 = (i19 * 2) + iArr[i2 + i18];
                int i21 = (i18 * 2) + iArr[i2 + i19];
                double d9 = dArr[i20];
                int i22 = i20 + 1;
                double d10 = dArr[i22];
                double d11 = dArr[i21];
                int i23 = i21 + 1;
                double d12 = dArr[i23];
                dArr[i20] = d11;
                dArr[i22] = d12;
                dArr[i21] = d9;
                dArr[i23] = d10;
                int i24 = i20 + i7;
                int i25 = i7 * 2;
                int i26 = i21 + i25;
                double d13 = dArr[i24];
                int i27 = i24 + 1;
                double d14 = dArr[i27];
                double d15 = dArr[i26];
                int i28 = i26 + 1;
                double d16 = dArr[i28];
                dArr[i24] = d15;
                dArr[i27] = d16;
                dArr[i26] = d13;
                dArr[i28] = d14;
                int i29 = i24 + i7;
                int i30 = i26 - i7;
                double d17 = dArr[i29];
                int i31 = i29 + 1;
                double d18 = dArr[i31];
                double d19 = dArr[i30];
                int i32 = i30 + 1;
                double d20 = dArr[i32];
                dArr[i29] = d19;
                dArr[i31] = d20;
                dArr[i30] = d17;
                dArr[i32] = d18;
                int i33 = i29 + i7;
                int i34 = i30 + i25;
                double d21 = dArr[i33];
                int i35 = i33 + 1;
                double d22 = dArr[i35];
                double d23 = dArr[i34];
                int i36 = i34 + 1;
                double d24 = dArr[i36];
                dArr[i33] = d23;
                dArr[i35] = d24;
                dArr[i34] = d21;
                dArr[i36] = d22;
            }
            int i37 = (i18 * 2) + i7 + iArr[i2 + i18];
            int i38 = i37 + i7;
            double d25 = dArr[i37];
            int i39 = i37 + 1;
            double d26 = dArr[i39];
            double d27 = dArr[i38];
            int i40 = i38 + 1;
            double d28 = dArr[i40];
            dArr[i37] = d27;
            dArr[i39] = d28;
            dArr[i38] = d25;
            dArr[i40] = d26;
        }
    }

    public final void b(double[] dArr) {
        double d = dArr[2];
        double d2 = dArr[3];
        double d3 = dArr[6];
        double d4 = dArr[7];
        double d5 = dArr[8];
        double d6 = dArr[9];
        double d7 = dArr[12];
        double d8 = dArr[13];
        dArr[2] = d5;
        dArr[3] = d6;
        dArr[6] = d7;
        dArr[7] = d8;
        dArr[8] = d;
        dArr[9] = d2;
        dArr[12] = d3;
        dArr[13] = d4;
    }

    public final void c(double[] dArr) {
        double d = dArr[2];
        double d2 = dArr[3];
        double d3 = dArr[4];
        double d4 = dArr[5];
        double d5 = dArr[6];
        double d6 = dArr[7];
        double d7 = dArr[8];
        double d8 = dArr[9];
        double d9 = dArr[10];
        double d10 = dArr[11];
        double d11 = dArr[12];
        double d12 = dArr[13];
        double d13 = dArr[14];
        double d14 = dArr[15];
        dArr[2] = d13;
        dArr[3] = d14;
        dArr[4] = d5;
        dArr[5] = d6;
        dArr[6] = d9;
        dArr[7] = d10;
        dArr[8] = d;
        dArr[9] = d2;
        dArr[10] = d11;
        dArr[11] = d12;
        dArr[12] = d3;
        dArr[13] = d4;
        dArr[14] = d7;
        dArr[15] = d8;
    }

    public final void d(double[] dArr) {
        double d = dArr[2];
        double d2 = dArr[3];
        double d3 = dArr[4];
        double d4 = dArr[5];
        double d5 = dArr[6];
        double d6 = dArr[7];
        double d7 = dArr[8];
        double d8 = dArr[9];
        double d9 = dArr[10];
        double d10 = dArr[11];
        double d11 = dArr[14];
        double d12 = dArr[15];
        double d13 = dArr[16];
        double d14 = dArr[17];
        double d15 = dArr[20];
        double d16 = dArr[21];
        double d17 = dArr[22];
        double d18 = dArr[23];
        double d19 = dArr[24];
        double d20 = dArr[25];
        double d21 = dArr[26];
        double d22 = dArr[27];
        double d23 = dArr[28];
        double d24 = dArr[29];
        dArr[2] = d13;
        dArr[3] = d14;
        dArr[4] = d7;
        dArr[5] = d8;
        dArr[6] = d19;
        dArr[7] = d20;
        dArr[8] = d3;
        dArr[9] = d4;
        dArr[10] = d15;
        dArr[11] = d16;
        dArr[14] = d23;
        dArr[15] = d24;
        dArr[16] = d;
        dArr[17] = d2;
        dArr[20] = d9;
        dArr[21] = d10;
        dArr[22] = d21;
        dArr[23] = d22;
        dArr[24] = d5;
        dArr[25] = d6;
        dArr[26] = d17;
        dArr[27] = d18;
        dArr[28] = d11;
        dArr[29] = d12;
    }

    public final void e(double[] dArr) {
        double d = dArr[2];
        double d2 = dArr[3];
        double d3 = dArr[4];
        double d4 = dArr[5];
        double d5 = dArr[6];
        double d6 = dArr[7];
        double d7 = dArr[8];
        double d8 = dArr[9];
        double d9 = dArr[10];
        double d10 = dArr[11];
        double d11 = dArr[12];
        double d12 = dArr[13];
        double d13 = dArr[14];
        double d14 = dArr[15];
        double d15 = dArr[16];
        double d16 = dArr[17];
        double d17 = dArr[18];
        double d18 = dArr[19];
        double d19 = dArr[20];
        double d20 = dArr[21];
        double d21 = dArr[22];
        double d22 = dArr[23];
        double d23 = dArr[24];
        double d24 = dArr[25];
        double d25 = dArr[26];
        double d26 = dArr[27];
        double d27 = dArr[28];
        double d28 = dArr[29];
        double d29 = dArr[30];
        double d30 = dArr[31];
        dArr[2] = d29;
        dArr[3] = d30;
        dArr[4] = d13;
        dArr[5] = d14;
        dArr[6] = d21;
        dArr[7] = d22;
        dArr[8] = d5;
        dArr[9] = d6;
        dArr[10] = d25;
        dArr[11] = d26;
        dArr[12] = d9;
        dArr[13] = d10;
        dArr[14] = d17;
        dArr[15] = d18;
        dArr[16] = d;
        dArr[17] = d2;
        dArr[18] = d27;
        dArr[19] = d28;
        dArr[20] = d11;
        dArr[21] = d12;
        dArr[22] = d19;
        dArr[23] = d20;
        dArr[24] = d3;
        dArr[25] = d4;
        dArr[26] = d23;
        dArr[27] = d24;
        dArr[28] = d7;
        dArr[29] = d8;
        dArr[30] = d15;
        dArr[31] = d16;
    }

    public final void f(int i, int[] iArr, int i2, double[] dArr) {
        int i3;
        int i4 = 0;
        iArr[i2 + 0] = 0;
        int i5 = i;
        int i6 = 1;
        while (true) {
            i3 = i6 << 3;
            if (i3 >= i5) {
                break;
            }
            i5 >>= 1;
            for (int i7 = 0; i7 < i6; i7++) {
                iArr[i2 + i6 + i7] = iArr[i2 + i7] + i5;
            }
            i6 <<= 1;
        }
        int i8 = i6 * 2;
        if (i3 != i5) {
            int i9 = i6;
            dArr[1] = -dArr[1];
            int i10 = i8 + 1;
            dArr[i10] = -dArr[i10];
            for (int i11 = 1; i11 < i9; i11++) {
                for (int i12 = 0; i12 < i11; i12++) {
                    int i13 = (i12 * 2) + iArr[i2 + i11];
                    int i14 = (i11 * 2) + iArr[i2 + i12];
                    double d = dArr[i13];
                    int i15 = i13 + 1;
                    double d2 = -dArr[i15];
                    double d3 = dArr[i14];
                    int i16 = i14 + 1;
                    double d4 = -dArr[i16];
                    dArr[i13] = d3;
                    dArr[i15] = d4;
                    dArr[i14] = d;
                    dArr[i16] = d2;
                    int i17 = i13 + i8;
                    int i18 = i14 + i8;
                    double d5 = dArr[i17];
                    int i19 = i17 + 1;
                    double d6 = -dArr[i19];
                    double d7 = dArr[i18];
                    int i20 = i18 + 1;
                    double d8 = -dArr[i20];
                    dArr[i17] = d7;
                    dArr[i19] = d8;
                    dArr[i18] = d5;
                    dArr[i20] = d6;
                }
                int i21 = (i11 * 2) + iArr[i2 + i11];
                int i22 = i21 + 1;
                dArr[i22] = -dArr[i22];
                int i23 = i21 + i8 + 1;
                dArr[i23] = -dArr[i23];
            }
            return;
        }
        int i24 = 0;
        while (i24 < i6) {
            int i25 = i4;
            while (i25 < i24) {
                int i26 = (i25 * 2) + iArr[i2 + i24];
                int i27 = (i24 * 2) + iArr[i2 + i25];
                double d9 = dArr[i26];
                int i28 = i26 + 1;
                double d10 = -dArr[i28];
                double d11 = dArr[i27];
                int i29 = i27 + 1;
                double d12 = -dArr[i29];
                dArr[i26] = d11;
                dArr[i28] = d12;
                dArr[i27] = d9;
                dArr[i29] = d10;
                int i30 = i26 + i8;
                int i31 = i8 * 2;
                int i32 = i27 + i31;
                double d13 = dArr[i30];
                int i33 = i30 + 1;
                double d14 = -dArr[i33];
                double d15 = dArr[i32];
                int i34 = i32 + 1;
                int i35 = i24;
                int i36 = i6;
                double d16 = -dArr[i34];
                dArr[i30] = d15;
                dArr[i33] = d16;
                dArr[i32] = d13;
                dArr[i34] = d14;
                int i37 = i30 + i8;
                int i38 = i32 - i8;
                double d17 = dArr[i37];
                int i39 = i37 + 1;
                double d18 = -dArr[i39];
                double d19 = dArr[i38];
                int i40 = i38 + 1;
                double d20 = -dArr[i40];
                dArr[i37] = d19;
                dArr[i39] = d20;
                dArr[i38] = d17;
                dArr[i40] = d18;
                int i41 = i37 + i8;
                int i42 = i38 + i31;
                double d21 = dArr[i41];
                int i43 = i41 + 1;
                double d22 = -dArr[i43];
                double d23 = dArr[i42];
                int i44 = i42 + 1;
                double d24 = -dArr[i44];
                dArr[i41] = d23;
                dArr[i43] = d24;
                dArr[i42] = d21;
                dArr[i44] = d22;
                i25++;
                i6 = i36;
                i24 = i35;
            }
            int i45 = i24;
            int i46 = i6;
            int i47 = (i45 * 2) + iArr[i2 + i45];
            int i48 = i47 + 1;
            dArr[i48] = -dArr[i48];
            int i49 = i47 + i8;
            int i50 = i49 + i8;
            double d25 = dArr[i49];
            int i51 = i49 + 1;
            double d26 = -dArr[i51];
            double d27 = dArr[i50];
            int i52 = i50 + 1;
            double d28 = -dArr[i52];
            dArr[i49] = d27;
            dArr[i51] = d28;
            dArr[i50] = d25;
            dArr[i52] = d26;
            int i53 = i50 + i8 + 1;
            dArr[i53] = -dArr[i53];
            i24 = i45 + 1;
            i6 = i46;
            i4 = 0;
        }
    }

    public void g(int i, int i2, double[] dArr, int[] iArr, double[] dArr2) {
        int i3 = iArr[0];
        if (i > (i3 << 2)) {
            i3 = i >> 2;
            H(i3, iArr, dArr2);
        }
        int i4 = i3;
        if (i2 >= 0) {
            s(i, dArr, iArr, 2, i4, dArr2);
        } else {
            j(i, dArr, iArr, 2, i4, dArr2);
        }
    }

    public final void h(double[] dArr) {
        double d = dArr[0];
        double d2 = dArr[4];
        double d3 = d + d2;
        double d4 = dArr[1];
        double d5 = dArr[5];
        double d6 = d4 + d5;
        double d7 = d - d2;
        double d8 = d4 - d5;
        double d9 = dArr[2];
        double d10 = dArr[6];
        double d11 = d9 + d10;
        double d12 = dArr[3];
        double d13 = dArr[7];
        double d14 = d12 + d13;
        double d15 = d9 - d10;
        double d16 = d12 - d13;
        dArr[0] = d3 + d11;
        dArr[1] = d6 + d14;
        dArr[4] = d3 - d11;
        dArr[5] = d6 - d14;
        dArr[2] = d7 + d16;
        dArr[3] = d8 - d15;
        dArr[6] = d7 - d16;
        dArr[7] = d8 + d15;
    }

    public final void i(int i, double[] dArr, double[] dArr2, int i2) {
        int i3 = i >> 3;
        int i4 = i3 * 2;
        int i5 = i4 + i4;
        int i6 = i5 + i4;
        int i7 = 0;
        double d = dArr[0];
        double d2 = dArr[i5];
        double d3 = d + d2;
        double d4 = dArr[1];
        int i8 = i5 + 1;
        double d5 = dArr[i8];
        double d6 = (-d4) - d5;
        double d7 = d - d2;
        double d8 = (-d4) + d5;
        double d9 = dArr[i4];
        double d10 = dArr[i6];
        double d11 = d9 + d10;
        int i9 = i4 + 1;
        double d12 = dArr[i9];
        int i10 = i6 + 1;
        double d13 = dArr[i10];
        double d14 = d12 + d13;
        double d15 = d9 - d10;
        double d16 = d12 - d13;
        dArr[0] = d3 + d11;
        dArr[1] = d6 - d14;
        dArr[i4] = d3 - d11;
        dArr[i9] = d6 + d14;
        dArr[i5] = d7 + d16;
        dArr[i8] = d8 + d15;
        dArr[i6] = d7 - d16;
        dArr[i10] = d8 - d15;
        double d17 = dArr2[i2 + 1];
        double d18 = dArr2[i2 + 2];
        double d19 = dArr2[i2 + 3];
        int i11 = 2;
        double d20 = 1.0d;
        double d21 = 0.0d;
        double d22 = 0.0d;
        double d23 = 1.0d;
        while (true) {
            double d24 = d17;
            int i12 = i3 - 2;
            if (i11 >= i12) {
                int i13 = i3;
                int i14 = i4;
                double d25 = d18;
                double d26 = d19;
                double d27 = d25 * (d20 + d24);
                double d28 = d25 * (d21 + d24);
                double d29 = d26 * (d23 - d24);
                double d30 = d26 * (d22 - d24);
                int i15 = i13 + i14;
                int i16 = i15 + i14;
                int i17 = i16 + i14;
                double d31 = dArr[i12];
                int i18 = i16 - 2;
                double d32 = dArr[i18];
                double d33 = d31 + d32;
                int i19 = i13 - 1;
                double d34 = dArr[i19];
                int i20 = i16 - 1;
                double d35 = dArr[i20];
                double d36 = (-d34) - d35;
                double d37 = d31 - d32;
                double d38 = (-d34) + d35;
                int i21 = i15 - 2;
                double d39 = dArr[i21];
                int i22 = i17 - 2;
                double d40 = dArr[i22];
                double d41 = d39 + d40;
                int i23 = i15 - 1;
                double d42 = dArr[i23];
                int i24 = i17 - 1;
                double d43 = dArr[i24];
                double d44 = d42 + d43;
                double d45 = d39 - d40;
                double d46 = d42 - d43;
                dArr[i12] = d33 + d41;
                dArr[i19] = d36 - d44;
                dArr[i21] = d33 - d41;
                dArr[i23] = d36 + d44;
                double d47 = d37 + d46;
                double d48 = d38 + d45;
                dArr[i18] = (d27 * d47) - (d28 * d48);
                dArr[i20] = (d48 * d27) + (d47 * d28);
                double d49 = d37 - d46;
                double d50 = d38 - d45;
                dArr[i22] = (d29 * d49) + (d30 * d50);
                dArr[i24] = (d29 * d50) - (d30 * d49);
                double d51 = dArr[i13];
                double d52 = dArr[i16];
                double d53 = d51 + d52;
                int i25 = i13 + 1;
                double d54 = dArr[i25];
                int i26 = i16 + 1;
                double d55 = dArr[i26];
                double d56 = (-d54) - d55;
                double d57 = d51 - d52;
                double d58 = (-d54) + d55;
                double d59 = dArr[i15];
                double d60 = dArr[i17];
                double d61 = d59 + d60;
                int i27 = i15 + 1;
                double d62 = dArr[i27];
                int i28 = i17 + 1;
                double d63 = dArr[i28];
                double d64 = d62 + d63;
                double d65 = d59 - d60;
                double d66 = d62 - d63;
                dArr[i13] = d53 + d61;
                dArr[i25] = d56 - d64;
                dArr[i15] = d53 - d61;
                dArr[i27] = d56 + d64;
                double d67 = d57 + d66;
                double d68 = d58 + d65;
                dArr[i16] = (d67 - d68) * d24;
                dArr[i26] = d24 * (d68 + d67);
                double d69 = d57 - d66;
                double d70 = d58 - d65;
                double d71 = -d24;
                dArr[i17] = (d69 + d70) * d71;
                dArr[i28] = d71 * (d70 - d69);
                int i29 = i13 + 2;
                double d72 = dArr[i29];
                int i30 = i16 + 2;
                double d73 = dArr[i30];
                double d74 = d72 + d73;
                int i31 = i13 + 3;
                double d75 = dArr[i31];
                int i32 = i16 + 3;
                double d76 = dArr[i32];
                double d77 = (-d75) - d76;
                double d78 = d72 - d73;
                double d79 = (-d75) + d76;
                int i33 = i15 + 2;
                double d80 = dArr[i33];
                int i34 = i17 + 2;
                double d81 = dArr[i34];
                double d82 = d80 + d81;
                int i35 = i15 + 3;
                double d83 = dArr[i35];
                int i36 = i17 + 3;
                double d84 = dArr[i36];
                double d85 = d83 + d84;
                double d86 = d80 - d81;
                double d87 = d83 - d84;
                dArr[i29] = d74 + d82;
                dArr[i31] = d77 - d85;
                dArr[i33] = d74 - d82;
                dArr[i35] = d77 + d85;
                double d88 = d78 + d87;
                double d89 = d79 + d86;
                dArr[i30] = (d28 * d88) - (d27 * d89);
                dArr[i32] = (d89 * d28) + (d88 * d27);
                double d90 = d78 - d87;
                double d91 = d79 - d86;
                dArr[i34] = (d30 * d90) + (d29 * d91);
                dArr[i36] = (d30 * d91) - (d29 * d90);
                return;
            }
            int i37 = i7 + 4;
            int i38 = i2 + i37;
            double d92 = dArr2[i38];
            double d93 = (d20 + d92) * d18;
            double d94 = dArr2[i38 + 1];
            double d95 = (d21 + d94) * d18;
            double d96 = dArr2[i38 + 2];
            double d97 = (d23 + d96) * d19;
            double d98 = dArr2[i38 + 3];
            double d99 = (d22 - d98) * d19;
            double d100 = -d98;
            int i39 = i11 + i4;
            int i40 = i39 + i4;
            int i41 = i40 + i4;
            double d101 = dArr[i11];
            double d102 = dArr[i40];
            double d103 = d101 + d102;
            int i42 = i11 + 1;
            double d104 = d19;
            double d105 = dArr[i42];
            int i43 = i40 + 1;
            double d106 = dArr[i43];
            double d107 = (-d105) - d106;
            double d108 = d101 - d102;
            double d109 = (-d105) + d106;
            int i44 = i11 + 2;
            double d110 = dArr[i44];
            int i45 = i40 + 2;
            double d111 = dArr[i45];
            double d112 = d110 + d111;
            int i46 = i11 + 3;
            int i47 = i3;
            int i48 = i4;
            double d113 = dArr[i46];
            int i49 = i40 + 3;
            double d114 = dArr[i49];
            double d115 = (-d113) - d114;
            double d116 = d110 - d111;
            double d117 = (-d113) + d114;
            double d118 = dArr[i39];
            double d119 = dArr[i41];
            double d120 = d118 + d119;
            int i50 = i39 + 1;
            double d121 = dArr[i50];
            int i51 = i41 + 1;
            double d122 = dArr[i51];
            double d123 = d121 + d122;
            double d124 = d118 - d119;
            double d125 = d121 - d122;
            int i52 = i39 + 2;
            double d126 = dArr[i52];
            int i53 = i41 + 2;
            double d127 = dArr[i53];
            double d128 = d126 + d127;
            int i54 = i39 + 3;
            double d129 = dArr[i54];
            int i55 = i41 + 3;
            double d130 = dArr[i55];
            double d131 = d129 + d130;
            double d132 = d126 - d127;
            double d133 = d129 - d130;
            dArr[i11] = d103 + d120;
            dArr[i42] = d107 - d123;
            dArr[i44] = d112 + d128;
            dArr[i46] = d115 - d131;
            dArr[i39] = d103 - d120;
            dArr[i50] = d107 + d123;
            dArr[i52] = d112 - d128;
            dArr[i54] = d115 + d131;
            double d134 = d108 + d125;
            double d135 = d109 + d124;
            dArr[i40] = (d93 * d134) - (d95 * d135);
            dArr[i43] = (d135 * d93) + (d134 * d95);
            double d136 = d116 + d133;
            double d137 = d117 + d132;
            dArr[i45] = (d92 * d136) - (d94 * d137);
            dArr[i49] = (d137 * d92) + (d136 * d94);
            double d138 = d108 - d125;
            double d139 = d109 - d124;
            dArr[i41] = (d97 * d138) + (d99 * d139);
            dArr[i51] = (d139 * d97) - (d138 * d99);
            double d140 = d116 - d133;
            double d141 = d117 - d132;
            dArr[i53] = (d96 * d140) + (d100 * d141);
            dArr[i55] = (d141 * d96) - (d100 * d140);
            int i56 = i48 - i11;
            int i57 = i56 + i48;
            int i58 = i57 + i48;
            int i59 = i58 + i48;
            double d142 = dArr[i56];
            double d143 = dArr[i58];
            double d144 = d142 + d143;
            int i60 = i56 + 1;
            double d145 = dArr[i60];
            int i61 = i11;
            int i62 = i58 + 1;
            double d146 = dArr[i62];
            double d147 = (-d145) - d146;
            double d148 = d142 - d143;
            double d149 = (-d145) + d146;
            int i63 = i56 - 2;
            double d150 = dArr[i63];
            int i64 = i58 - 2;
            double d151 = dArr[i64];
            double d152 = d150 + d151;
            int i65 = i56 - 1;
            double d153 = dArr[i65];
            int i66 = i58 - 1;
            double d154 = dArr[i66];
            double d155 = (-d153) - d154;
            double d156 = d150 - d151;
            double d157 = (-d153) + d154;
            double d158 = dArr[i57];
            double d159 = dArr[i59];
            double d160 = d158 + d159;
            int i67 = i57 + 1;
            double d161 = dArr[i67];
            int i68 = i59 + 1;
            double d162 = dArr[i68];
            double d163 = d161 + d162;
            double d164 = d158 - d159;
            double d165 = d161 - d162;
            int i69 = i57 - 2;
            double d166 = dArr[i69];
            int i70 = i59 - 2;
            double d167 = dArr[i70];
            double d168 = d166 + d167;
            int i71 = i57 - 1;
            double d169 = dArr[i71];
            int i72 = i59 - 1;
            double d170 = dArr[i72];
            double d171 = d169 + d170;
            double d172 = d166 - d167;
            double d173 = d169 - d170;
            dArr[i56] = d144 + d160;
            dArr[i60] = d147 - d163;
            dArr[i63] = d152 + d168;
            dArr[i65] = d155 - d171;
            dArr[i57] = d144 - d160;
            dArr[i67] = d147 + d163;
            dArr[i69] = d152 - d168;
            dArr[i71] = d155 + d171;
            double d174 = d148 + d165;
            double d175 = d149 + d164;
            dArr[i58] = (d95 * d174) - (d93 * d175);
            dArr[i62] = (d175 * d95) + (d174 * d93);
            double d176 = d156 + d173;
            double d177 = d157 + d172;
            dArr[i64] = (d94 * d176) - (d92 * d177);
            dArr[i66] = (d177 * d94) + (d176 * d92);
            double d178 = d148 - d165;
            double d179 = d149 - d164;
            dArr[i59] = (d99 * d178) + (d97 * d179);
            dArr[i68] = (d99 * d179) - (d97 * d178);
            double d180 = d156 - d173;
            double d181 = d157 - d172;
            dArr[i70] = (d100 * d180) + (d96 * d181);
            dArr[i72] = (d100 * d181) - (d180 * d96);
            i11 = i61 + 4;
            i7 = i37;
            d17 = d24;
            d20 = d92;
            d21 = d94;
            d23 = d96;
            d19 = d104;
            d18 = d18;
            i3 = i47;
            i4 = i48;
            d22 = d100;
        }
    }

    public final void j(int i, double[] dArr, int[] iArr, int i2, int i3, double[] dArr2) {
        if (i > 32) {
            int i4 = i >> 2;
            i(i, dArr, dArr2, i3 - i4);
            if (i > 512) {
                x(i4, dArr, 0, i3, dArr2);
                y(i4, dArr, i4, i3, dArr2);
                x(i4, dArr, i4 * 2, i3, dArr2);
                x(i4, dArr, i4 * 3, i3, dArr2);
            } else if (i4 > 32) {
                k(i, dArr, 0, i3, dArr2);
            } else {
                t(i, dArr, 0, i3, dArr2);
            }
            f(i, iArr, i2, dArr);
            return;
        }
        if (i > 8) {
            if (i == 32) {
                p(dArr, 0, dArr2, i3 - 8);
                e(dArr);
                return;
            } else {
                n(dArr, 0, dArr2, 0);
                c(dArr);
                return;
            }
        }
        if (i == 8) {
            h(dArr);
        } else if (i == 4) {
            z(dArr);
        }
    }

    public final void k(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        int i4 = i >> 2;
        while (i4 > 128) {
            for (int i5 = i4; i5 < i; i5 <<= 2) {
                for (int i6 = i5 - i4; i6 < i; i6 += i5 * 4) {
                    int i7 = i3 - (i4 >> 1);
                    int i8 = i4;
                    v(i8, dArr, i2 + i6, dArr2, i7);
                    w(i8, dArr, i2 + i5 + i6, dArr2, i3 - i4);
                    v(i8, dArr, i2 + (i5 * 2) + i6, dArr2, i7);
                }
            }
            v(i4, dArr, (i2 + i) - i4, dArr2, i3 - (i4 >> 1));
            i4 >>= 2;
        }
        for (int i9 = i4; i9 < i; i9 <<= 2) {
            for (int i10 = i9 - i4; i10 < i; i10 += i9 * 4) {
                int i11 = i2 + i10;
                int i12 = i3 - (i4 >> 1);
                v(i4, dArr, i11, dArr2, i12);
                t(i4, dArr, i11, i3, dArr2);
                int i13 = i2 + i9 + i10;
                w(i4, dArr, i13, dArr2, i3 - i4);
                u(i4, dArr, i13, i3, dArr2);
                int i14 = i2 + (i9 * 2) + i10;
                v(i4, dArr, i14, dArr2, i12);
                t(i4, dArr, i14, i3, dArr2);
            }
        }
        int i15 = (i2 + i) - i4;
        v(i4, dArr, i15, dArr2, i3 - (i4 >> 1));
        t(i4, dArr, i15, i3, dArr2);
    }

    public final void l(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        int i4 = i >> 1;
        int i5 = i >> 2;
        while (i5 > 128) {
            for (int i6 = i5; i6 < i4; i6 <<= 2) {
                for (int i7 = i6 - i5; i7 < i4; i7 += i6 * 2) {
                    int i8 = i3 - (i5 >> 1);
                    int i9 = i5;
                    v(i9, dArr, i2 + i7, dArr2, i8);
                    v(i9, dArr, i2 + i4 + i7, dArr2, i8);
                }
                for (int i10 = (i6 * 2) - i5; i10 < i4; i10 += i6 * 4) {
                    int i11 = i3 - i5;
                    int i12 = i5;
                    w(i12, dArr, i2 + i10, dArr2, i11);
                    w(i12, dArr, i2 + i4 + i10, dArr2, i11);
                }
            }
            i5 >>= 2;
        }
        for (int i13 = i5; i13 < i4; i13 <<= 2) {
            for (int i14 = i13 - i5; i14 < i4; i14 += i13 * 2) {
                int i15 = i2 + i14;
                int i16 = i3 - (i5 >> 1);
                int i17 = i5;
                v(i17, dArr, i15, dArr2, i16);
                int i18 = i5;
                t(i18, dArr, i15, i3, dArr2);
                int i19 = i2 + i4 + i14;
                v(i17, dArr, i19, dArr2, i16);
                t(i18, dArr, i19, i3, dArr2);
            }
            for (int i20 = (i13 * 2) - i5; i20 < i4; i20 += i13 * 4) {
                int i21 = i2 + i20;
                int i22 = i3 - i5;
                int i23 = i5;
                w(i23, dArr, i21, dArr2, i22);
                int i24 = i5;
                u(i24, dArr, i21, i3, dArr2);
                int i25 = i2 + i4 + i20;
                w(i23, dArr, i25, dArr2, i22);
                u(i24, dArr, i25, i3, dArr2);
            }
        }
    }

    public final void m(double[] dArr) {
        double d = dArr[0];
        double d2 = dArr[4];
        double d3 = d + d2;
        double d4 = dArr[1];
        double d5 = dArr[5];
        double d6 = d4 + d5;
        double d7 = d - d2;
        double d8 = d4 - d5;
        double d9 = dArr[2];
        double d10 = dArr[6];
        double d11 = d9 + d10;
        double d12 = dArr[3];
        double d13 = dArr[7];
        double d14 = d12 + d13;
        double d15 = d9 - d10;
        double d16 = d12 - d13;
        dArr[0] = d3 + d11;
        dArr[1] = d6 + d14;
        dArr[4] = d3 - d11;
        dArr[5] = d6 - d14;
        dArr[2] = d7 - d16;
        dArr[3] = d8 + d15;
        dArr[6] = d7 + d16;
        dArr[7] = d8 - d15;
    }

    public final void n(double[] dArr, int i, double[] dArr2, int i2) {
        double d = dArr2[i2 + 1];
        int i3 = i + 0;
        double d2 = dArr[i3];
        int i4 = i + 8;
        double d3 = dArr[i4];
        double d4 = d2 + d3;
        int i5 = i + 1;
        double d5 = dArr[i5];
        int i6 = i + 9;
        double d6 = dArr[i6];
        double d7 = d5 + d6;
        double d8 = d2 - d3;
        double d9 = d5 - d6;
        int i7 = i + 4;
        double d10 = dArr[i7];
        int i8 = i + 12;
        double d11 = dArr[i8];
        double d12 = d10 + d11;
        int i9 = i + 5;
        double d13 = dArr[i9];
        int i10 = i + 13;
        double d14 = dArr[i10];
        double d15 = d13 + d14;
        double d16 = d10 - d11;
        double d17 = d13 - d14;
        double d18 = d4 + d12;
        double d19 = d7 + d15;
        double d20 = d4 - d12;
        double d21 = d7 - d15;
        double d22 = d8 - d17;
        double d23 = d9 + d16;
        double d24 = d8 + d17;
        double d25 = d9 - d16;
        int i11 = i + 2;
        double d26 = dArr[i11];
        int i12 = i + 10;
        double d27 = dArr[i12];
        double d28 = d26 + d27;
        int i13 = i + 3;
        double d29 = dArr[i13];
        int i14 = i + 11;
        double d30 = dArr[i14];
        double d31 = d29 + d30;
        double d32 = d26 - d27;
        double d33 = d29 - d30;
        int i15 = i + 6;
        double d34 = dArr[i15];
        int i16 = i + 14;
        double d35 = dArr[i16];
        double d36 = d34 + d35;
        int i17 = i + 7;
        double d37 = dArr[i17];
        int i18 = i + 15;
        double d38 = dArr[i18];
        double d39 = d37 + d38;
        double d40 = d34 - d35;
        double d41 = d37 - d38;
        double d42 = d28 + d36;
        double d43 = d31 + d39;
        double d44 = d28 - d36;
        double d45 = d31 - d39;
        double d46 = d32 - d41;
        double d47 = d33 + d40;
        double d48 = d32 + d41;
        double d49 = d33 - d40;
        double d50 = (d46 - d47) * d;
        double d51 = (d46 + d47) * d;
        double d52 = (d48 - d49) * d;
        double d53 = d * (d48 + d49);
        dArr[i4] = d22 + d50;
        dArr[i6] = d23 + d51;
        dArr[i12] = d22 - d50;
        dArr[i14] = d23 - d51;
        dArr[i8] = d24 - d53;
        dArr[i10] = d25 + d52;
        dArr[i16] = d24 + d53;
        dArr[i18] = d25 - d52;
        dArr[i3] = d18 + d42;
        dArr[i5] = d19 + d43;
        dArr[i11] = d18 - d42;
        dArr[i13] = d19 - d43;
        dArr[i7] = d20 - d45;
        dArr[i9] = d21 + d44;
        dArr[i15] = d20 + d45;
        dArr[i17] = d21 - d44;
    }

    public final void o(double[] dArr, int i, double[] dArr2, int i2) {
        double d = dArr2[i2 + 1];
        double d2 = dArr2[i2 + 4];
        double d3 = dArr2[i2 + 5];
        int i3 = i + 0;
        double d4 = dArr[i3];
        int i4 = i + 9;
        double d5 = dArr[i4];
        double d6 = d4 - d5;
        int i5 = i + 1;
        double d7 = dArr[i5];
        int i6 = i + 8;
        double d8 = dArr[i6];
        double d9 = d7 + d8;
        double d10 = d4 + d5;
        double d11 = d7 - d8;
        int i7 = i + 4;
        double d12 = dArr[i7];
        int i8 = i + 13;
        double d13 = dArr[i8];
        double d14 = d12 - d13;
        int i9 = i + 5;
        double d15 = dArr[i9];
        int i10 = i + 12;
        double d16 = dArr[i10];
        double d17 = d15 + d16;
        double d18 = (d14 - d17) * d;
        double d19 = (d17 + d14) * d;
        double d20 = d12 + d13;
        double d21 = d15 - d16;
        double d22 = (d20 - d21) * d;
        double d23 = d * (d21 + d20);
        int i11 = i + 2;
        double d24 = dArr[i11];
        int i12 = i + 11;
        double d25 = dArr[i12];
        double d26 = d24 - d25;
        int i13 = i + 3;
        double d27 = dArr[i13];
        int i14 = i + 10;
        double d28 = dArr[i14];
        double d29 = d27 + d28;
        double d30 = (d2 * d26) - (d3 * d29);
        double d31 = (d29 * d2) + (d26 * d3);
        double d32 = d24 + d25;
        double d33 = d27 - d28;
        double d34 = (d3 * d32) - (d2 * d33);
        double d35 = (d33 * d3) + (d32 * d2);
        int i15 = i + 6;
        double d36 = dArr[i15];
        int i16 = i + 15;
        double d37 = dArr[i16];
        double d38 = d36 - d37;
        int i17 = i + 7;
        double d39 = dArr[i17];
        int i18 = i + 14;
        double d40 = dArr[i18];
        double d41 = d39 + d40;
        double d42 = (d3 * d38) - (d2 * d41);
        double d43 = (d41 * d3) + (d38 * d2);
        double d44 = d36 + d37;
        double d45 = d39 - d40;
        double d46 = (d2 * d44) - (d3 * d45);
        double d47 = (d2 * d45) + (d3 * d44);
        double d48 = d6 + d18;
        double d49 = d9 + d19;
        double d50 = d30 + d42;
        double d51 = d31 + d43;
        dArr[i3] = d48 + d50;
        dArr[i5] = d49 + d51;
        dArr[i11] = d48 - d50;
        dArr[i13] = d49 - d51;
        double d52 = d6 - d18;
        double d53 = d9 - d19;
        double d54 = d30 - d42;
        double d55 = d31 - d43;
        dArr[i7] = d52 - d55;
        dArr[i9] = d53 + d54;
        dArr[i15] = d52 + d55;
        dArr[i17] = d53 - d54;
        double d56 = d10 - d23;
        double d57 = d11 + d22;
        double d58 = d34 - d46;
        double d59 = d35 - d47;
        dArr[i6] = d56 + d58;
        dArr[i4] = d57 + d59;
        dArr[i14] = d56 - d58;
        dArr[i12] = d57 - d59;
        double d60 = d10 + d23;
        double d61 = d11 - d22;
        double d62 = d34 + d46;
        double d63 = d35 + d47;
        dArr[i10] = d60 - d63;
        dArr[i8] = d61 + d62;
        dArr[i18] = d60 + d63;
        dArr[i16] = d61 - d62;
    }

    public final void p(double[] dArr, int i, double[] dArr2, int i2) {
        double d = dArr2[i2 + 1];
        double d2 = dArr2[i2 + 2];
        double d3 = d * d2;
        double d4 = d2 + d3;
        int i3 = i + 0;
        double d5 = dArr[i3];
        int i4 = i + 16;
        double d6 = dArr[i4];
        double d7 = d5 + d6;
        int i5 = i + 1;
        double d8 = dArr[i5];
        int i6 = i + 17;
        double d9 = dArr[i6];
        double d10 = d8 + d9;
        double d11 = d5 - d6;
        double d12 = d8 - d9;
        int i7 = i + 8;
        double d13 = dArr[i7];
        int i8 = i + 24;
        double d14 = dArr[i8];
        double d15 = d13 + d14;
        int i9 = i + 9;
        double d16 = dArr[i9];
        int i10 = i + 25;
        double d17 = dArr[i10];
        double d18 = d16 + d17;
        double d19 = d13 - d14;
        double d20 = d16 - d17;
        double d21 = d7 + d15;
        double d22 = d10 + d18;
        double d23 = d7 - d15;
        double d24 = d10 - d18;
        double d25 = d11 - d20;
        double d26 = d12 + d19;
        double d27 = d11 + d20;
        double d28 = d12 - d19;
        int i11 = i + 2;
        double d29 = dArr[i11];
        int i12 = i + 18;
        double d30 = dArr[i12];
        double d31 = d29 + d30;
        int i13 = i + 3;
        double d32 = dArr[i13];
        int i14 = i + 19;
        double d33 = dArr[i14];
        double d34 = d32 + d33;
        double d35 = d29 - d30;
        double d36 = d32 - d33;
        int i15 = i + 10;
        double d37 = dArr[i15];
        int i16 = i + 26;
        double d38 = dArr[i16];
        double d39 = d37 + d38;
        int i17 = i + 11;
        double d40 = dArr[i17];
        int i18 = i + 27;
        double d41 = dArr[i18];
        double d42 = d40 + d41;
        double d43 = d37 - d38;
        double d44 = d40 - d41;
        double d45 = d31 + d39;
        double d46 = d34 + d42;
        double d47 = d31 - d39;
        double d48 = d34 - d42;
        double d49 = d35 - d44;
        double d50 = d36 + d43;
        double d51 = (d4 * d49) - (d3 * d50);
        double d52 = (d50 * d4) + (d49 * d3);
        double d53 = d35 + d44;
        double d54 = d36 - d43;
        double d55 = (d3 * d53) - (d4 * d54);
        double d56 = (d54 * d3) + (d53 * d4);
        int i19 = i + 4;
        double d57 = dArr[i19];
        int i20 = i + 20;
        double d58 = dArr[i20];
        double d59 = d57 + d58;
        int i21 = i + 5;
        double d60 = dArr[i21];
        int i22 = i + 21;
        double d61 = dArr[i22];
        double d62 = d60 + d61;
        double d63 = d57 - d58;
        double d64 = d60 - d61;
        int i23 = i + 12;
        double d65 = dArr[i23];
        int i24 = i + 28;
        double d66 = dArr[i24];
        double d67 = d65 + d66;
        int i25 = i + 13;
        double d68 = dArr[i25];
        int i26 = i + 29;
        double d69 = dArr[i26];
        double d70 = d68 + d69;
        double d71 = d65 - d66;
        double d72 = d68 - d69;
        double d73 = d59 + d67;
        double d74 = d62 + d70;
        double d75 = d59 - d67;
        double d76 = d62 - d70;
        double d77 = d63 - d72;
        double d78 = d64 + d71;
        double d79 = (d77 - d78) * d;
        double d80 = (d78 + d77) * d;
        double d81 = d63 + d72;
        double d82 = d64 - d71;
        double d83 = (d81 + d82) * d;
        double d84 = (d82 - d81) * d;
        int i27 = i + 6;
        double d85 = dArr[i27];
        int i28 = i + 22;
        double d86 = dArr[i28];
        double d87 = d85 + d86;
        int i29 = i + 7;
        double d88 = dArr[i29];
        int i30 = i + 23;
        double d89 = dArr[i30];
        double d90 = d88 + d89;
        double d91 = d85 - d86;
        double d92 = d88 - d89;
        int i31 = i + 14;
        double d93 = dArr[i31];
        int i32 = i + 30;
        double d94 = dArr[i32];
        double d95 = d93 + d94;
        int i33 = i + 15;
        double d96 = dArr[i33];
        int i34 = i + 31;
        double d97 = dArr[i34];
        double d98 = d96 + d97;
        double d99 = d93 - d94;
        double d100 = d96 - d97;
        double d101 = d87 + d95;
        double d102 = d90 + d98;
        double d103 = d87 - d95;
        double d104 = d90 - d98;
        double d105 = d91 - d100;
        double d106 = d92 + d99;
        double d107 = (d3 * d105) - (d4 * d106);
        double d108 = (d106 * d3) + (d105 * d4);
        double d109 = d91 + d100;
        double d110 = d92 - d99;
        double d111 = (d4 * d109) - (d3 * d110);
        double d112 = (d4 * d110) + (d3 * d109);
        double d113 = d27 - d83;
        double d114 = d28 - d84;
        double d115 = d27 + d83;
        double d116 = d28 + d84;
        double d117 = d55 - d111;
        double d118 = d56 - d112;
        double d119 = d55 + d111;
        double d120 = d56 + d112;
        dArr[i8] = d113 + d117;
        dArr[i10] = d114 + d118;
        dArr[i16] = d113 - d117;
        dArr[i18] = d114 - d118;
        dArr[i24] = d115 - d120;
        dArr[i26] = d116 + d119;
        dArr[i32] = d115 + d120;
        dArr[i34] = d116 - d119;
        double d121 = d25 + d79;
        double d122 = d26 + d80;
        double d123 = d25 - d79;
        double d124 = d26 - d80;
        double d125 = d51 + d107;
        double d126 = d52 + d108;
        double d127 = d51 - d107;
        double d128 = d52 - d108;
        dArr[i4] = d121 + d125;
        dArr[i6] = d122 + d126;
        dArr[i12] = d121 - d125;
        dArr[i14] = d122 - d126;
        dArr[i20] = d123 - d128;
        dArr[i22] = d124 + d127;
        dArr[i28] = d123 + d128;
        dArr[i30] = d124 - d127;
        double d129 = d47 - d104;
        double d130 = d48 + d103;
        double d131 = (d129 - d130) * d;
        double d132 = (d130 + d129) * d;
        double d133 = d47 + d104;
        double d134 = d48 - d103;
        double d135 = (d133 - d134) * d;
        double d136 = d * (d134 + d133);
        double d137 = d23 - d76;
        double d138 = d24 + d75;
        double d139 = d23 + d76;
        double d140 = d24 - d75;
        dArr[i7] = d137 + d131;
        dArr[i9] = d138 + d132;
        dArr[i15] = d137 - d131;
        dArr[i17] = d138 - d132;
        dArr[i23] = d139 - d136;
        dArr[i25] = d140 + d135;
        dArr[i31] = d139 + d136;
        dArr[i33] = d140 - d135;
        double d141 = d21 + d73;
        double d142 = d22 + d74;
        double d143 = d21 - d73;
        double d144 = d22 - d74;
        double d145 = d45 + d101;
        double d146 = d46 + d102;
        double d147 = d45 - d101;
        double d148 = d46 - d102;
        dArr[i3] = d141 + d145;
        dArr[i5] = d142 + d146;
        dArr[i11] = d141 - d145;
        dArr[i13] = d142 - d146;
        dArr[i19] = d143 - d148;
        dArr[i21] = d144 + d147;
        dArr[i27] = d143 + d148;
        dArr[i29] = d144 - d147;
    }

    public final void q(double[] dArr, int i, double[] dArr2, int i2) {
        double d = dArr2[i2 + 1];
        double d2 = dArr2[i2 + 4];
        double d3 = dArr2[i2 + 5];
        double d4 = dArr2[i2 + 6];
        double d5 = dArr2[i2 + 7];
        double d6 = dArr2[i2 + 8];
        double d7 = dArr2[i2 + 9];
        int i3 = i + 0;
        double d8 = dArr[i3];
        int i4 = i + 17;
        double d9 = dArr[i4];
        double d10 = d8 - d9;
        int i5 = i + 1;
        double d11 = dArr[i5];
        int i6 = i + 16;
        double d12 = dArr[i6];
        double d13 = d11 + d12;
        int i7 = i + 8;
        double d14 = dArr[i7];
        int i8 = i + 25;
        double d15 = dArr[i8];
        double d16 = d14 - d15;
        int i9 = i + 9;
        double d17 = dArr[i9];
        int i10 = i + 24;
        double d18 = dArr[i10];
        double d19 = d17 + d18;
        double d20 = (d16 - d19) * d;
        double d21 = (d19 + d16) * d;
        double d22 = d10 + d20;
        double d23 = d13 + d21;
        double d24 = d10 - d20;
        double d25 = d13 - d21;
        double d26 = d8 + d9;
        double d27 = d11 - d12;
        double d28 = d14 + d15;
        double d29 = d17 - d18;
        double d30 = (d28 - d29) * d;
        double d31 = (d29 + d28) * d;
        double d32 = d26 - d31;
        double d33 = d27 + d30;
        double d34 = d26 + d31;
        double d35 = d27 - d30;
        int i11 = i + 2;
        double d36 = dArr[i11];
        int i12 = i + 19;
        double d37 = dArr[i12];
        double d38 = d36 - d37;
        int i13 = i + 3;
        double d39 = dArr[i13];
        int i14 = i + 18;
        double d40 = dArr[i14];
        double d41 = d39 + d40;
        double d42 = (d2 * d38) - (d3 * d41);
        double d43 = (d41 * d2) + (d38 * d3);
        int i15 = i + 10;
        double d44 = dArr[i15];
        int i16 = i + 27;
        double d45 = dArr[i16];
        double d46 = d44 - d45;
        int i17 = i + 11;
        double d47 = dArr[i17];
        int i18 = i + 26;
        double d48 = dArr[i18];
        double d49 = d47 + d48;
        double d50 = (d5 * d46) - (d4 * d49);
        double d51 = (d49 * d5) + (d46 * d4);
        double d52 = d42 + d50;
        double d53 = d43 + d51;
        double d54 = d42 - d50;
        double d55 = d43 - d51;
        double d56 = d36 + d37;
        double d57 = d39 - d40;
        double d58 = (d4 * d56) - (d5 * d57);
        double d59 = (d57 * d4) + (d56 * d5);
        double d60 = d44 + d45;
        double d61 = d47 - d48;
        double d62 = (d2 * d60) + (d3 * d61);
        double d63 = (d61 * d2) - (d60 * d3);
        double d64 = d58 - d62;
        double d65 = d59 - d63;
        double d66 = d58 + d62;
        double d67 = d59 + d63;
        int i19 = i + 4;
        double d68 = dArr[i19];
        int i20 = i + 21;
        double d69 = dArr[i20];
        double d70 = d68 - d69;
        int i21 = i + 5;
        double d71 = dArr[i21];
        int i22 = i + 20;
        double d72 = dArr[i22];
        double d73 = d71 + d72;
        double d74 = (d6 * d70) - (d7 * d73);
        double d75 = (d73 * d6) + (d70 * d7);
        int i23 = i + 12;
        double d76 = dArr[i23];
        int i24 = i + 29;
        double d77 = dArr[i24];
        double d78 = d76 - d77;
        int i25 = i + 13;
        double d79 = dArr[i25];
        int i26 = i + 28;
        double d80 = dArr[i26];
        double d81 = d79 + d80;
        double d82 = (d7 * d78) - (d6 * d81);
        double d83 = (d81 * d7) + (d78 * d6);
        double d84 = d74 + d82;
        double d85 = d75 + d83;
        double d86 = d74 - d82;
        double d87 = d75 - d83;
        double d88 = d68 + d69;
        double d89 = d71 - d72;
        double d90 = (d7 * d88) - (d6 * d89);
        double d91 = (d89 * d7) + (d88 * d6);
        double d92 = d76 + d77;
        double d93 = d79 - d80;
        double d94 = (d6 * d92) - (d7 * d93);
        double d95 = (d6 * d93) + (d7 * d92);
        double d96 = d90 - d94;
        double d97 = d91 - d95;
        double d98 = d90 + d94;
        double d99 = d91 + d95;
        int i27 = i + 6;
        double d100 = dArr[i27];
        int i28 = i + 23;
        double d101 = dArr[i28];
        double d102 = d100 - d101;
        int i29 = i + 7;
        double d103 = dArr[i29];
        int i30 = i + 22;
        double d104 = dArr[i30];
        double d105 = d103 + d104;
        double d106 = (d4 * d102) - (d5 * d105);
        double d107 = (d105 * d4) + (d102 * d5);
        int i31 = i + 14;
        double d108 = dArr[i31];
        int i32 = i + 31;
        double d109 = dArr[i32];
        double d110 = d108 - d109;
        int i33 = i + 15;
        double d111 = dArr[i33];
        int i34 = i + 30;
        double d112 = dArr[i34];
        double d113 = d111 + d112;
        double d114 = (d3 * d110) - (d2 * d113);
        double d115 = (d113 * d3) + (d110 * d2);
        double d116 = d106 + d114;
        double d117 = d107 + d115;
        double d118 = d106 - d114;
        double d119 = d107 - d115;
        double d120 = d100 + d101;
        double d121 = d103 - d104;
        double d122 = (d3 * d120) + (d2 * d121);
        double d123 = (d3 * d121) - (d2 * d120);
        double d124 = d108 + d109;
        double d125 = d111 - d112;
        double d126 = (d5 * d124) - (d4 * d125);
        double d127 = (d5 * d125) + (d4 * d124);
        double d128 = d122 + d126;
        double d129 = d123 + d127;
        double d130 = d122 - d126;
        double d131 = d123 - d127;
        double d132 = d22 + d84;
        double d133 = d23 + d85;
        double d134 = d52 + d116;
        double d135 = d53 + d117;
        dArr[i3] = d132 + d134;
        dArr[i5] = d133 + d135;
        dArr[i11] = d132 - d134;
        dArr[i13] = d133 - d135;
        double d136 = d22 - d84;
        double d137 = d23 - d85;
        double d138 = d52 - d116;
        double d139 = d53 - d117;
        dArr[i19] = d136 - d139;
        dArr[i21] = d137 + d138;
        dArr[i27] = d136 + d139;
        dArr[i29] = d137 - d138;
        double d140 = d24 - d87;
        double d141 = d25 + d86;
        double d142 = d54 - d119;
        double d143 = d55 + d118;
        double d144 = (d142 - d143) * d;
        double d145 = (d143 + d142) * d;
        dArr[i7] = d140 + d144;
        dArr[i9] = d141 + d145;
        dArr[i15] = d140 - d144;
        dArr[i17] = d141 - d145;
        double d146 = d24 + d87;
        double d147 = d25 - d86;
        double d148 = d54 + d119;
        double d149 = d55 - d118;
        double d150 = (d148 - d149) * d;
        double d151 = (d149 + d148) * d;
        dArr[i23] = d146 - d151;
        dArr[i25] = d147 + d150;
        dArr[i31] = d146 + d151;
        dArr[i33] = d147 - d150;
        double d152 = d32 + d96;
        double d153 = d33 + d97;
        double d154 = d64 - d128;
        double d155 = d65 - d129;
        dArr[i6] = d152 + d154;
        dArr[i4] = d153 + d155;
        dArr[i14] = d152 - d154;
        dArr[i12] = d153 - d155;
        double d156 = d32 - d96;
        double d157 = d33 - d97;
        double d158 = d64 + d128;
        double d159 = d65 + d129;
        dArr[i22] = d156 - d159;
        dArr[i20] = d157 + d158;
        dArr[i30] = d156 + d159;
        dArr[i28] = d157 - d158;
        double d160 = d34 - d99;
        double d161 = d35 + d98;
        double d162 = d66 + d131;
        double d163 = d67 - d130;
        double d164 = (d162 - d163) * d;
        double d165 = (d163 + d162) * d;
        dArr[i10] = d160 + d164;
        dArr[i8] = d161 + d165;
        dArr[i18] = d160 - d164;
        dArr[i16] = d161 - d165;
        double d166 = d34 + d99;
        double d167 = d35 - d98;
        double d168 = d66 - d131;
        double d169 = d67 + d130;
        double d170 = (d168 - d169) * d;
        double d171 = d * (d169 + d168);
        dArr[i26] = d166 - d171;
        dArr[i24] = d167 + d170;
        dArr[i34] = d166 + d171;
        dArr[i32] = d167 - d170;
    }

    public final void r(int i, double[] dArr, double[] dArr2, int i2) {
        int i3 = i >> 3;
        int i4 = i3 * 2;
        int i5 = i4 + i4;
        int i6 = i5 + i4;
        int i7 = 0;
        double d = dArr[0];
        double d2 = dArr[i5];
        double d3 = d + d2;
        double d4 = dArr[1];
        int i8 = i5 + 1;
        double d5 = dArr[i8];
        double d6 = d4 + d5;
        double d7 = d - d2;
        double d8 = d4 - d5;
        double d9 = dArr[i4];
        double d10 = dArr[i6];
        double d11 = d9 + d10;
        int i9 = i4 + 1;
        double d12 = dArr[i9];
        int i10 = i6 + 1;
        double d13 = dArr[i10];
        double d14 = d12 + d13;
        double d15 = d9 - d10;
        double d16 = d12 - d13;
        dArr[0] = d3 + d11;
        dArr[1] = d6 + d14;
        dArr[i4] = d3 - d11;
        dArr[i9] = d6 - d14;
        dArr[i5] = d7 - d16;
        dArr[i8] = d8 + d15;
        dArr[i6] = d7 + d16;
        dArr[i10] = d8 - d15;
        double d17 = dArr2[i2 + 1];
        double d18 = dArr2[i2 + 2];
        double d19 = dArr2[i2 + 3];
        int i11 = 2;
        double d20 = 1.0d;
        double d21 = 0.0d;
        double d22 = 0.0d;
        double d23 = 1.0d;
        while (true) {
            double d24 = d17;
            int i12 = i3 - 2;
            if (i11 >= i12) {
                double d25 = (d20 + d24) * d18;
                double d26 = d18 * (d21 + d24);
                double d27 = (d23 - d24) * d19;
                double d28 = d19 * (d22 - d24);
                int i13 = i3 + i4;
                int i14 = i13 + i4;
                int i15 = i4 + i14;
                double d29 = dArr[i12];
                int i16 = i14 - 2;
                double d30 = dArr[i16];
                double d31 = d29 + d30;
                int i17 = i3 - 1;
                double d32 = dArr[i17];
                int i18 = i14 - 1;
                double d33 = dArr[i18];
                double d34 = d32 + d33;
                double d35 = d29 - d30;
                double d36 = d32 - d33;
                int i19 = i13 - 2;
                double d37 = dArr[i19];
                int i20 = i15 - 2;
                double d38 = dArr[i20];
                double d39 = d37 + d38;
                int i21 = i13 - 1;
                double d40 = dArr[i21];
                int i22 = i15 - 1;
                double d41 = dArr[i22];
                double d42 = d40 + d41;
                double d43 = d37 - d38;
                double d44 = d40 - d41;
                dArr[i12] = d31 + d39;
                dArr[i17] = d34 + d42;
                dArr[i19] = d31 - d39;
                dArr[i21] = d34 - d42;
                double d45 = d35 - d44;
                double d46 = d36 + d43;
                dArr[i16] = (d25 * d45) - (d26 * d46);
                dArr[i18] = (d46 * d25) + (d45 * d26);
                double d47 = d35 + d44;
                double d48 = d36 - d43;
                dArr[i20] = (d27 * d47) + (d28 * d48);
                dArr[i22] = (d48 * d27) - (d47 * d28);
                double d49 = dArr[i3];
                double d50 = dArr[i14];
                double d51 = d49 + d50;
                int i23 = i3 + 1;
                double d52 = dArr[i23];
                int i24 = i14 + 1;
                double d53 = dArr[i24];
                double d54 = d52 + d53;
                double d55 = d49 - d50;
                double d56 = d52 - d53;
                double d57 = dArr[i13];
                double d58 = dArr[i15];
                double d59 = d57 + d58;
                int i25 = i13 + 1;
                double d60 = dArr[i25];
                int i26 = i15 + 1;
                double d61 = dArr[i26];
                double d62 = d60 + d61;
                double d63 = d57 - d58;
                double d64 = d60 - d61;
                dArr[i3] = d51 + d59;
                dArr[i23] = d54 + d62;
                dArr[i13] = d51 - d59;
                dArr[i25] = d54 - d62;
                double d65 = d55 - d64;
                double d66 = d56 + d63;
                dArr[i14] = (d65 - d66) * d24;
                dArr[i24] = d24 * (d66 + d65);
                double d67 = d55 + d64;
                double d68 = d56 - d63;
                double d69 = -d24;
                dArr[i15] = (d67 + d68) * d69;
                dArr[i26] = d69 * (d68 - d67);
                int i27 = i3 + 2;
                double d70 = dArr[i27];
                int i28 = i14 + 2;
                double d71 = dArr[i28];
                double d72 = d70 + d71;
                int i29 = i3 + 3;
                double d73 = dArr[i29];
                int i30 = i14 + 3;
                double d74 = dArr[i30];
                double d75 = d73 + d74;
                double d76 = d70 - d71;
                double d77 = d73 - d74;
                int i31 = i13 + 2;
                double d78 = dArr[i31];
                int i32 = i15 + 2;
                double d79 = dArr[i32];
                double d80 = d78 + d79;
                int i33 = i13 + 3;
                double d81 = dArr[i33];
                int i34 = i15 + 3;
                double d82 = dArr[i34];
                double d83 = d81 + d82;
                double d84 = d78 - d79;
                double d85 = d81 - d82;
                dArr[i27] = d72 + d80;
                dArr[i29] = d75 + d83;
                dArr[i31] = d72 - d80;
                dArr[i33] = d75 - d83;
                double d86 = d76 - d85;
                double d87 = d77 + d84;
                dArr[i28] = (d26 * d86) - (d25 * d87);
                dArr[i30] = (d26 * d87) + (d25 * d86);
                double d88 = d76 + d85;
                double d89 = d77 - d84;
                dArr[i32] = (d28 * d88) + (d27 * d89);
                dArr[i34] = (d28 * d89) - (d88 * d27);
                return;
            }
            i7 += 4;
            int i35 = i2 + i7;
            double d90 = dArr2[i35];
            double d91 = (d20 + d90) * d18;
            double d92 = dArr2[i35 + 1];
            double d93 = (d21 + d92) * d18;
            double d94 = dArr2[i35 + 2];
            double d95 = (d23 + d94) * d19;
            double d96 = dArr2[i35 + 3];
            double d97 = (d22 - d96) * d19;
            double d98 = -d96;
            int i36 = i11 + i4;
            int i37 = i36 + i4;
            int i38 = i37 + i4;
            double d99 = dArr[i11];
            double d100 = dArr[i37];
            double d101 = d99 + d100;
            int i39 = i11 + 1;
            double d102 = dArr[i39];
            int i40 = i37 + 1;
            double d103 = dArr[i40];
            double d104 = d102 + d103;
            double d105 = d99 - d100;
            double d106 = d102 - d103;
            int i41 = i11 + 2;
            double d107 = dArr[i41];
            int i42 = i37 + 2;
            double d108 = dArr[i42];
            double d109 = d107 + d108;
            int i43 = i11 + 3;
            double d110 = dArr[i43];
            int i44 = i37 + 3;
            double d111 = dArr[i44];
            double d112 = d110 + d111;
            double d113 = d107 - d108;
            double d114 = d110 - d111;
            double d115 = dArr[i36];
            double d116 = dArr[i38];
            double d117 = d115 + d116;
            int i45 = i36 + 1;
            double d118 = dArr[i45];
            int i46 = i38 + 1;
            double d119 = dArr[i46];
            double d120 = d118 + d119;
            double d121 = d115 - d116;
            double d122 = d118 - d119;
            int i47 = i36 + 2;
            double d123 = dArr[i47];
            int i48 = i38 + 2;
            double d124 = dArr[i48];
            double d125 = d123 + d124;
            int i49 = i36 + 3;
            double d126 = dArr[i49];
            int i50 = i38 + 3;
            double d127 = dArr[i50];
            double d128 = d126 + d127;
            double d129 = d123 - d124;
            double d130 = d126 - d127;
            dArr[i11] = d101 + d117;
            dArr[i39] = d104 + d120;
            dArr[i41] = d109 + d125;
            dArr[i43] = d112 + d128;
            dArr[i36] = d101 - d117;
            dArr[i45] = d104 - d120;
            dArr[i47] = d109 - d125;
            dArr[i49] = d112 - d128;
            double d131 = d105 - d122;
            double d132 = d106 + d121;
            dArr[i37] = (d91 * d131) - (d93 * d132);
            dArr[i40] = (d132 * d91) + (d131 * d93);
            double d133 = d113 - d130;
            double d134 = d114 + d129;
            dArr[i42] = (d90 * d133) - (d92 * d134);
            dArr[i44] = (d134 * d90) + (d133 * d92);
            double d135 = d105 + d122;
            double d136 = d106 - d121;
            dArr[i38] = (d95 * d135) + (d97 * d136);
            dArr[i46] = (d136 * d95) - (d135 * d97);
            double d137 = d113 + d130;
            double d138 = d114 - d129;
            dArr[i48] = (d94 * d137) + (d98 * d138);
            dArr[i50] = (d138 * d94) - (d137 * d98);
            int i51 = i4 - i11;
            int i52 = i51 + i4;
            int i53 = i52 + i4;
            int i54 = i53 + i4;
            double d139 = dArr[i51];
            double d140 = dArr[i53];
            double d141 = d139 + d140;
            int i55 = i51 + 1;
            double d142 = dArr[i55];
            int i56 = i53 + 1;
            double d143 = dArr[i56];
            double d144 = d142 + d143;
            double d145 = d139 - d140;
            double d146 = d142 - d143;
            int i57 = i51 - 2;
            double d147 = dArr[i57];
            int i58 = i53 - 2;
            double d148 = dArr[i58];
            double d149 = d147 + d148;
            int i59 = i51 - 1;
            double d150 = dArr[i59];
            int i60 = i53 - 1;
            double d151 = dArr[i60];
            double d152 = d150 + d151;
            double d153 = d147 - d148;
            double d154 = d150 - d151;
            double d155 = dArr[i52];
            double d156 = dArr[i54];
            double d157 = d155 + d156;
            int i61 = i52 + 1;
            double d158 = dArr[i61];
            int i62 = i54 + 1;
            double d159 = dArr[i62];
            double d160 = d158 + d159;
            double d161 = d155 - d156;
            double d162 = d158 - d159;
            int i63 = i52 - 2;
            double d163 = dArr[i63];
            int i64 = i54 - 2;
            double d164 = dArr[i64];
            double d165 = d163 + d164;
            int i65 = i52 - 1;
            double d166 = dArr[i65];
            int i66 = i54 - 1;
            double d167 = dArr[i66];
            double d168 = d166 + d167;
            double d169 = d163 - d164;
            double d170 = d166 - d167;
            dArr[i51] = d141 + d157;
            dArr[i55] = d144 + d160;
            dArr[i57] = d149 + d165;
            dArr[i59] = d152 + d168;
            dArr[i52] = d141 - d157;
            dArr[i61] = d144 - d160;
            dArr[i63] = d149 - d165;
            dArr[i65] = d152 - d168;
            double d171 = d145 - d162;
            double d172 = d146 + d161;
            dArr[i53] = (d93 * d171) - (d91 * d172);
            dArr[i56] = (d93 * d172) + (d91 * d171);
            double d173 = d153 - d170;
            double d174 = d154 + d169;
            dArr[i58] = (d92 * d173) - (d90 * d174);
            dArr[i60] = (d174 * d92) + (d173 * d90);
            double d175 = d145 + d162;
            double d176 = d146 - d161;
            dArr[i54] = (d97 * d175) + (d95 * d176);
            dArr[i62] = (d97 * d176) - (d95 * d175);
            double d177 = d153 + d170;
            double d178 = d154 - d169;
            dArr[i64] = (d98 * d177) + (d94 * d178);
            dArr[i66] = (d178 * d98) - (d177 * d94);
            i11 += 4;
            d22 = d98;
            d17 = d24;
            d20 = d90;
            d21 = d92;
            d23 = d94;
        }
    }

    public final void s(int i, double[] dArr, int[] iArr, int i2, int i3, double[] dArr2) {
        if (i > 32) {
            int i4 = i >> 2;
            r(i, dArr, dArr2, i3 - i4);
            if (i > 512) {
                x(i4, dArr, 0, i3, dArr2);
                y(i4, dArr, i4, i3, dArr2);
                x(i4, dArr, i4 * 2, i3, dArr2);
                x(i4, dArr, i4 * 3, i3, dArr2);
            } else if (i4 > 32) {
                k(i, dArr, 0, i3, dArr2);
            } else {
                t(i, dArr, 0, i3, dArr2);
            }
            a(i, iArr, i2, dArr);
            return;
        }
        if (i > 8) {
            if (i == 32) {
                p(dArr, 0, dArr2, i3 - 8);
                d(dArr);
                return;
            } else {
                n(dArr, 0, dArr2, 0);
                b(dArr);
                return;
            }
        }
        if (i == 8) {
            m(dArr);
        } else if (i == 4) {
            z(dArr);
        }
    }

    public final void t(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        if (i == 128) {
            int i4 = i3 - 8;
            p(dArr, i2, dArr2, i4);
            q(dArr, i2 + 32, dArr2, i3 - 32);
            p(dArr, i2 + 64, dArr2, i4);
            p(dArr, i2 + 96, dArr2, i4);
            return;
        }
        int i5 = i3 - 16;
        n(dArr, i2, dArr2, i5);
        o(dArr, i2 + 16, dArr2, i5);
        n(dArr, i2 + 32, dArr2, i5);
        n(dArr, i2 + 48, dArr2, i5);
    }

    public final void u(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        if (i != 128) {
            int i4 = i3 - 16;
            n(dArr, i2, dArr2, i4);
            o(dArr, i2 + 16, dArr2, i4);
            n(dArr, i2 + 32, dArr2, i4);
            o(dArr, i2 + 48, dArr2, i4);
            return;
        }
        int i5 = i3 - 8;
        p(dArr, i2, dArr2, i5);
        int i6 = i3 - 32;
        q(dArr, i2 + 32, dArr2, i6);
        p(dArr, i2 + 64, dArr2, i5);
        q(dArr, i2 + 96, dArr2, i6);
    }

    public final void v(int i, double[] dArr, int i2, double[] dArr2, int i3) {
        int i4 = i >> 3;
        int i5 = i4 * 2;
        int i6 = i5 + i5;
        int i7 = i6 + i5;
        int i8 = i2 + 0;
        double d = dArr[i8];
        int i9 = i2 + i6;
        double d2 = dArr[i9];
        double d3 = d + d2;
        int i10 = i2 + 1;
        double d4 = dArr[i10];
        int i11 = i9 + 1;
        double d5 = dArr[i11];
        double d6 = d4 + d5;
        double d7 = d - d2;
        double d8 = d4 - d5;
        int i12 = i2 + i5;
        double d9 = dArr[i12];
        int i13 = i2 + i7;
        double d10 = dArr[i13];
        double d11 = d9 + d10;
        int i14 = i12 + 1;
        double d12 = dArr[i14];
        int i15 = i13 + 1;
        double d13 = dArr[i15];
        double d14 = d12 + d13;
        double d15 = d9 - d10;
        double d16 = d12 - d13;
        dArr[i8] = d3 + d11;
        dArr[i10] = d6 + d14;
        dArr[i12] = d3 - d11;
        dArr[i14] = d6 - d14;
        dArr[i9] = d7 - d16;
        dArr[i11] = d8 + d15;
        dArr[i13] = d7 + d16;
        dArr[i15] = d8 - d15;
        double d17 = dArr2[i3 + 1];
        int i16 = 0;
        for (int i17 = 2; i17 < i4; i17 += 2) {
            i16 += 4;
            int i18 = i3 + i16;
            double d18 = dArr2[i18];
            double d19 = dArr2[i18 + 1];
            double d20 = dArr2[i18 + 2];
            double d21 = -dArr2[i18 + 3];
            int i19 = i17 + i5;
            int i20 = i19 + i5;
            int i21 = i20 + i5;
            int i22 = i2 + i17;
            double d22 = dArr[i22];
            int i23 = i2 + i20;
            double d23 = dArr[i23];
            double d24 = d22 + d23;
            int i24 = i22 + 1;
            double d25 = dArr[i24];
            int i25 = i23 + 1;
            double d26 = dArr[i25];
            double d27 = d25 + d26;
            double d28 = d22 - d23;
            double d29 = d25 - d26;
            int i26 = i2 + i19;
            double d30 = dArr[i26];
            int i27 = i2 + i21;
            double d31 = dArr[i27];
            double d32 = d30 + d31;
            int i28 = i26 + 1;
            double d33 = dArr[i28];
            int i29 = i27 + 1;
            double d34 = dArr[i29];
            double d35 = d33 + d34;
            double d36 = d30 - d31;
            double d37 = d33 - d34;
            dArr[i22] = d24 + d32;
            dArr[i24] = d27 + d35;
            dArr[i26] = d24 - d32;
            dArr[i28] = d27 - d35;
            double d38 = d28 - d37;
            double d39 = d29 + d36;
            dArr[i23] = (d18 * d38) - (d19 * d39);
            dArr[i25] = (d39 * d18) + (d38 * d19);
            double d40 = d28 + d37;
            double d41 = d29 - d36;
            dArr[i27] = (d20 * d40) + (d21 * d41);
            dArr[i29] = (d41 * d20) - (d40 * d21);
            int i30 = i5 - i17;
            int i31 = i30 + i5;
            int i32 = i31 + i5;
            int i33 = i32 + i5;
            int i34 = i2 + i30;
            double d42 = dArr[i34];
            int i35 = i2 + i32;
            double d43 = dArr[i35];
            double d44 = d42 + d43;
            int i36 = i34 + 1;
            double d45 = dArr[i36];
            int i37 = i35 + 1;
            double d46 = dArr[i37];
            double d47 = d45 + d46;
            double d48 = d42 - d43;
            double d49 = d45 - d46;
            int i38 = i2 + i31;
            double d50 = dArr[i38];
            int i39 = i2 + i33;
            double d51 = dArr[i39];
            double d52 = d50 + d51;
            int i40 = i38 + 1;
            double d53 = dArr[i40];
            int i41 = i39 + 1;
            double d54 = dArr[i41];
            double d55 = d53 + d54;
            double d56 = d50 - d51;
            double d57 = d53 - d54;
            dArr[i34] = d44 + d52;
            dArr[i36] = d47 + d55;
            dArr[i38] = d44 - d52;
            dArr[i40] = d47 - d55;
            double d58 = d48 - d57;
            double d59 = d49 + d56;
            dArr[i35] = (d19 * d58) - (d18 * d59);
            dArr[i37] = (d19 * d59) + (d18 * d58);
            double d60 = d48 + d57;
            double d61 = d49 - d56;
            dArr[i39] = (d21 * d60) + (d20 * d61);
            dArr[i41] = (d21 * d61) - (d20 * d60);
        }
        int i42 = i4 + i5;
        int i43 = i42 + i5;
        int i44 = i5 + i43;
        int i45 = i2 + i4;
        double d62 = dArr[i45];
        int i46 = i2 + i43;
        double d63 = dArr[i46];
        double d64 = d62 + d63;
        int i47 = i45 + 1;
        double d65 = dArr[i47];
        int i48 = i46 + 1;
        double d66 = dArr[i48];
        double d67 = d65 + d66;
        double d68 = d62 - d63;
        double d69 = d65 - d66;
        int i49 = i2 + i42;
        double d70 = dArr[i49];
        int i50 = i2 + i44;
        double d71 = dArr[i50];
        double d72 = d70 + d71;
        int i51 = i49 + 1;
        double d73 = dArr[i51];
        int i52 = i50 + 1;
        double d74 = dArr[i52];
        double d75 = d73 + d74;
        double d76 = d70 - d71;
        double d77 = d73 - d74;
        dArr[i45] = d64 + d72;
        dArr[i47] = d67 + d75;
        dArr[i49] = d64 - d72;
        dArr[i51] = d67 - d75;
        double d78 = d68 - d77;
        double d79 = d69 + d76;
        dArr[i46] = (d78 - d79) * d17;
        dArr[i48] = (d79 + d78) * d17;
        double d80 = d68 + d77;
        double d81 = d69 - d76;
        double d82 = -d17;
        dArr[i50] = (d80 + d81) * d82;
        dArr[i52] = d82 * (d81 - d80);
    }

    public final void w(int i, double[] dArr, int i2, double[] dArr2, int i3) {
        int i4 = i >> 3;
        int i5 = i4 * 2;
        double d = dArr2[i3 + 1];
        int i6 = i5 + i5;
        int i7 = i6 + i5;
        int i8 = i2 + 0;
        double d2 = dArr[i8];
        int i9 = i2 + i6;
        int i10 = i9 + 1;
        double d3 = dArr[i10];
        double d4 = d2 - d3;
        int i11 = i2 + 1;
        double d5 = dArr[i11];
        double d6 = dArr[i9];
        double d7 = d5 + d6;
        double d8 = d2 + d3;
        double d9 = d5 - d6;
        int i12 = i2 + i5;
        double d10 = dArr[i12];
        int i13 = i2 + i7;
        int i14 = i13 + 1;
        double d11 = dArr[i14];
        double d12 = d10 - d11;
        int i15 = i12 + 1;
        double d13 = dArr[i15];
        double d14 = dArr[i13];
        double d15 = d13 + d14;
        double d16 = d10 + d11;
        double d17 = d13 - d14;
        double d18 = (d12 - d15) * d;
        double d19 = (d15 + d12) * d;
        dArr[i8] = d4 + d18;
        dArr[i11] = d7 + d19;
        dArr[i12] = d4 - d18;
        dArr[i15] = d7 - d19;
        double d20 = (d16 - d17) * d;
        double d21 = d * (d17 + d16);
        dArr[i9] = d8 - d21;
        dArr[i10] = d9 + d20;
        dArr[i13] = d8 + d21;
        dArr[i14] = d9 - d20;
        int i16 = i5 * 2;
        int i17 = 2;
        int i18 = 0;
        while (i17 < i4) {
            int i19 = i18 + 4;
            int i20 = i3 + i19;
            double d22 = dArr2[i20];
            double d23 = dArr2[i20 + 1];
            double d24 = dArr2[i20 + 2];
            double d25 = -dArr2[i20 + 3];
            i16 -= 4;
            int i21 = i3 + i16;
            double d26 = dArr2[i21];
            double d27 = dArr2[i21 + 1];
            double d28 = dArr2[i21 + 2];
            double d29 = -dArr2[i21 + 3];
            int i22 = i17 + i5;
            int i23 = i22 + i5;
            int i24 = i23 + i5;
            int i25 = i2 + i17;
            double d30 = dArr[i25];
            int i26 = i2 + i23;
            int i27 = i26 + 1;
            double d31 = dArr[i27];
            double d32 = d30 - d31;
            int i28 = i25 + 1;
            double d33 = dArr[i28];
            double d34 = dArr[i26];
            double d35 = d33 + d34;
            double d36 = d30 + d31;
            double d37 = d33 - d34;
            int i29 = i2 + i22;
            double d38 = dArr[i29];
            int i30 = i2 + i24;
            int i31 = i30 + 1;
            double d39 = dArr[i31];
            double d40 = d38 - d39;
            int i32 = i29 + 1;
            double d41 = dArr[i32];
            double d42 = dArr[i30];
            double d43 = d41 + d42;
            double d44 = d38 + d39;
            double d45 = d41 - d42;
            double d46 = (d22 * d32) - (d23 * d35);
            double d47 = (d35 * d22) + (d32 * d23);
            double d48 = (d27 * d40) - (d26 * d43);
            double d49 = (d43 * d27) + (d40 * d26);
            dArr[i25] = d46 + d48;
            dArr[i28] = d47 + d49;
            dArr[i29] = d46 - d48;
            dArr[i32] = d47 - d49;
            double d50 = (d24 * d36) + (d25 * d37);
            double d51 = (d37 * d24) - (d36 * d25);
            double d52 = (d29 * d44) + (d28 * d45);
            double d53 = (d45 * d29) - (d44 * d28);
            dArr[i26] = d50 + d52;
            dArr[i27] = d51 + d53;
            dArr[i30] = d50 - d52;
            dArr[i31] = d51 - d53;
            int i33 = i5 - i17;
            int i34 = i33 + i5;
            int i35 = i34 + i5;
            int i36 = i35 + i5;
            int i37 = i2 + i33;
            double d54 = dArr[i37];
            int i38 = i2 + i35;
            int i39 = i38 + 1;
            double d55 = dArr[i39];
            double d56 = d54 - d55;
            int i40 = i37 + 1;
            double d57 = dArr[i40];
            double d58 = dArr[i38];
            double d59 = d57 + d58;
            double d60 = d54 + d55;
            double d61 = d57 - d58;
            int i41 = i2 + i34;
            double d62 = dArr[i41];
            int i42 = i2 + i36;
            int i43 = i42 + 1;
            double d63 = dArr[i43];
            double d64 = d62 - d63;
            int i44 = i41 + 1;
            double d65 = dArr[i44];
            double d66 = dArr[i42];
            double d67 = d65 + d66;
            double d68 = d62 + d63;
            double d69 = d65 - d66;
            double d70 = (d26 * d56) - (d27 * d59);
            double d71 = (d26 * d59) + (d27 * d56);
            double d72 = (d23 * d64) - (d22 * d67);
            double d73 = (d23 * d67) + (d22 * d64);
            dArr[i37] = d70 + d72;
            dArr[i40] = d71 + d73;
            dArr[i41] = d70 - d72;
            dArr[i44] = d71 - d73;
            double d74 = (d28 * d60) + (d29 * d61);
            double d75 = (d28 * d61) - (d29 * d60);
            double d76 = (d25 * d68) + (d24 * d69);
            double d77 = (d25 * d69) - (d24 * d68);
            dArr[i38] = d74 + d76;
            dArr[i39] = d75 + d77;
            dArr[i42] = d74 - d76;
            dArr[i43] = d75 - d77;
            i17 += 2;
            i18 = i19;
        }
        int i45 = i3 + i5;
        double d78 = dArr2[i45];
        double d79 = dArr2[i45 + 1];
        int i46 = i4 + i5;
        int i47 = i46 + i5;
        int i48 = i5 + i47;
        int i49 = i2 + i4;
        double d80 = dArr[i49];
        int i50 = i2 + i47;
        int i51 = i50 + 1;
        double d81 = dArr[i51];
        double d82 = d80 - d81;
        int i52 = i49 + 1;
        double d83 = dArr[i52];
        double d84 = dArr[i50];
        double d85 = d83 + d84;
        double d86 = d80 + d81;
        double d87 = d83 - d84;
        int i53 = i2 + i46;
        double d88 = dArr[i53];
        int i54 = i2 + i48;
        int i55 = i54 + 1;
        double d89 = dArr[i55];
        double d90 = d88 - d89;
        int i56 = i53 + 1;
        double d91 = dArr[i56];
        double d92 = dArr[i54];
        double d93 = d91 + d92;
        double d94 = d88 + d89;
        double d95 = d91 - d92;
        double d96 = (d78 * d82) - (d79 * d85);
        double d97 = (d85 * d78) + (d82 * d79);
        double d98 = (d79 * d90) - (d78 * d93);
        double d99 = (d93 * d79) + (d90 * d78);
        dArr[i49] = d96 + d98;
        dArr[i52] = d97 + d99;
        dArr[i53] = d96 - d98;
        dArr[i56] = d97 - d99;
        double d100 = (d79 * d86) - (d78 * d87);
        double d101 = (d87 * d79) + (d86 * d78);
        double d102 = (d78 * d94) - (d79 * d95);
        double d103 = (d78 * d95) + (d79 * d94);
        dArr[i50] = d100 - d102;
        dArr[i51] = d101 - d103;
        dArr[i54] = d100 + d102;
        dArr[i55] = d101 + d103;
    }

    public final void x(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        int i4 = i >> 2;
        int i5 = i4 * 2;
        v(i, dArr, i2, dArr2, i3 - i5);
        if (i <= 512) {
            k(i, dArr, i2, i3, dArr2);
            return;
        }
        x(i4, dArr, i2, i3, dArr2);
        y(i4, dArr, i2 + i4, i3, dArr2);
        x(i4, dArr, i2 + i5, i3, dArr2);
        x(i4, dArr, i2 + (i4 * 3), i3, dArr2);
    }

    public final void y(int i, double[] dArr, int i2, int i3, double[] dArr2) {
        int i4 = i >> 2;
        w(i, dArr, i2, dArr2, i3 - i);
        if (i <= 512) {
            l(i, dArr, i2, i3, dArr2);
            return;
        }
        x(i4, dArr, i2, i3, dArr2);
        y(i4, dArr, i2 + i4, i3, dArr2);
        x(i4, dArr, i2 + (i4 * 2), i3, dArr2);
        y(i4, dArr, i2 + (i4 * 3), i3, dArr2);
    }

    public final void z(double[] dArr) {
        double d = dArr[0];
        double d2 = dArr[2];
        double d3 = dArr[1];
        double d4 = dArr[3];
        dArr[0] = d + d2;
        dArr[1] = d3 + d4;
        dArr[2] = d - d2;
        dArr[3] = d3 - d4;
    }
}
