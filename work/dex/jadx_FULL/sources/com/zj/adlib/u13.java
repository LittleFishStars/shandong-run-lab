package com.zj.adlib;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class u13 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f45044a = 33;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int[] f19938a = {4, 6, 6, 8, 8, 8, 8, 8, 8, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 12, 12, 12, 12, 12, 12, 12, 12, 12, 12};
    public static final int b = 0;
    public static final int c = 32;
    public static final int d = 4;

    public static int[] a(qv0 qv0Var, int i, int i2) {
        int[] iArr = new int[i2];
        int iS = qv0Var.s() / i;
        for (int i3 = 0; i3 < iS; i3++) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                i4 |= qv0Var.m((i3 * i) + i5) ? 1 << ((i - i5) - 1) : 0;
            }
            iArr[i3] = i4;
        }
        return iArr;
    }

    public static void b(tv0 tv0Var, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3 += 2) {
            int i4 = i - i3;
            int i5 = i4;
            while (true) {
                int i6 = i + i3;
                if (i5 <= i6) {
                    tv0Var.z(i5, i4);
                    tv0Var.z(i5, i6);
                    tv0Var.z(i4, i5);
                    tv0Var.z(i6, i5);
                    i5++;
                }
            }
        }
        int i7 = i - i2;
        tv0Var.z(i7, i7);
        int i8 = i7 + 1;
        tv0Var.z(i8, i7);
        tv0Var.z(i7, i8);
        int i9 = i + i2;
        tv0Var.z(i9, i7);
        tv0Var.z(i9, i8);
        tv0Var.z(i9, i9 - 1);
    }

    public static void c(tv0 tv0Var, boolean z, int i, qv0 qv0Var) {
        int i2 = i / 2;
        int i3 = 0;
        if (z) {
            while (i3 < 7) {
                int i4 = (i2 - 3) + i3;
                if (qv0Var.m(i3)) {
                    tv0Var.z(i4, i2 - 5);
                }
                if (qv0Var.m(i3 + 7)) {
                    tv0Var.z(i2 + 5, i4);
                }
                if (qv0Var.m(20 - i3)) {
                    tv0Var.z(i4, i2 + 5);
                }
                if (qv0Var.m(27 - i3)) {
                    tv0Var.z(i2 - 5, i4);
                }
                i3++;
            }
            return;
        }
        while (i3 < 10) {
            int i5 = (i2 - 5) + i3 + (i3 / 5);
            if (qv0Var.m(i3)) {
                tv0Var.z(i5, i2 - 7);
            }
            if (qv0Var.m(i3 + 10)) {
                tv0Var.z(i2 + 7, i5);
            }
            if (qv0Var.m(29 - i3)) {
                tv0Var.z(i5, i2 + 7);
            }
            if (qv0Var.m(39 - i3)) {
                tv0Var.z(i2 - 7, i5);
            }
            i3++;
        }
    }

    public static vi0 d(String str) {
        return g(str.getBytes(StandardCharsets.ISO_8859_1));
    }

    public static vi0 e(String str, int i, int i2) {
        return i(str.getBytes(StandardCharsets.ISO_8859_1), i, i2, null);
    }

    public static vi0 f(String str, int i, int i2, Charset charset) {
        return i(str.getBytes(charset != null ? charset : StandardCharsets.ISO_8859_1), i, i2, charset);
    }

    public static vi0 g(byte[] bArr) {
        return i(bArr, 33, 0, null);
    }

    public static vi0 h(byte[] bArr, int i, int i2) {
        return i(bArr, i, i2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static vi0 i(byte[] bArr, int i, int i2, Charset charset) {
        qv0 qv0VarM;
        int i3;
        boolean z;
        int iAbs;
        int iN;
        int i4;
        qv0 qv0VarA = new j04(bArr, charset).a();
        int iS = ((qv0VarA.s() * i) / 100) + 11;
        int iS2 = qv0VarA.s() + iS;
        int i5 = 4;
        int i6 = 0;
        int i7 = 1;
        if (i2 != 0) {
            boolean z2 = i2 < 0;
            iAbs = Math.abs(i2);
            if (iAbs > (z2 ? 4 : 32)) {
                throw new IllegalArgumentException(String.format("Illegal value %s for layers", Integer.valueOf(i2)));
            }
            iN = n(iAbs, z2);
            i3 = f19938a[iAbs];
            int i8 = iN - (iN % i3);
            qv0VarM = m(qv0VarA, i3);
            if (qv0VarM.s() + iS > i8) {
                z = z2;
                throw new IllegalArgumentException("Data to large for user specified layer");
            }
            if (z2) {
                z = z2;
                if (qv0VarM.s() > i3 * 64) {
                    throw new IllegalArgumentException("Data to large for user specified layer");
                }
            }
        } else {
            qv0 qv0VarM2 = null;
            int i9 = 0;
            int i10 = 0;
            while (true) {
                if (i9 > 32) {
                    throw new IllegalArgumentException("Data too large for an Aztec code");
                }
                boolean z3 = i9 <= 3 ? i7 : i6;
                int i11 = z3 != 0 ? i9 + 1 : i9;
                int iN2 = n(i11, z3);
                if (iS2 <= iN2) {
                    if (qv0VarM2 == null || i10 != f19938a[i11]) {
                        int i12 = f19938a[i11];
                        i10 = i12;
                        qv0VarM2 = m(qv0VarA, i12);
                    }
                    int i13 = iN2 - (iN2 % i10);
                    if ((z3 == 0 || qv0VarM2.s() <= i10 * 64) && qv0VarM2.s() + iS <= i13) {
                        qv0VarM = qv0VarM2;
                        i3 = i10;
                        z = z3;
                        iAbs = i11;
                        iN = iN2;
                        break;
                    }
                }
                i9++;
                i7 = i7;
                i5 = 4;
                i6 = 0;
            }
        }
        qv0 qv0VarJ = j(qv0VarM, iN, i3);
        int iS3 = qv0VarM.s() / i3;
        qv0 qv0VarK = k(z, iAbs, iS3);
        int i14 = (z ? 11 : 14) + (iAbs * 4);
        int[] iArr = new int[i14];
        int i15 = 2;
        if (z) {
            for (int i16 = i6; i16 < i14; i16++) {
                iArr[i16] = i16;
            }
            i4 = i14;
        } else {
            int i17 = i14 / 2;
            i4 = i14 + 1 + (((i17 - 1) / 15) * 2);
            int i18 = i4 / 2;
            for (int i19 = i6; i19 < i17; i19++) {
                int i20 = (i19 / 15) + i19;
                iArr[(i17 - i19) - 1] = (i18 - i20) - 1;
                iArr[i17 + i19] = i20 + i18 + i7;
            }
        }
        tv0 tv0Var = new tv0(i4);
        int i21 = i6;
        int i22 = i21;
        while (i21 < iAbs) {
            int i23 = ((iAbs - i21) * i5) + (z ? 9 : 12);
            int i24 = i6;
            while (i24 < i23) {
                int i25 = i24 * 2;
                while (i6 < i15) {
                    if (qv0VarJ.m(i22 + i25 + i6)) {
                        int i26 = i21 * 2;
                        tv0Var.z(iArr[i26 + i6], iArr[i26 + i24]);
                    }
                    if (qv0VarJ.m((i23 * 2) + i22 + i25 + i6)) {
                        int i27 = i21 * 2;
                        tv0Var.z(iArr[i27 + i24], iArr[((i14 - 1) - i27) - i6]);
                    }
                    if (qv0VarJ.m((i23 * 4) + i22 + i25 + i6)) {
                        int i28 = (i14 - 1) - (i21 * 2);
                        tv0Var.z(iArr[i28 - i6], iArr[i28 - i24]);
                    }
                    if (qv0VarJ.m((i23 * 6) + i22 + i25 + i6)) {
                        int i29 = i21 * 2;
                        tv0Var.z(iArr[((i14 - 1) - i29) - i24], iArr[i29 + i6]);
                    }
                    i6++;
                    i15 = 2;
                }
                i24++;
                i6 = 0;
                i15 = 2;
            }
            i22 += i23 * 8;
            i21++;
            i5 = 4;
            i6 = 0;
            i15 = 2;
        }
        c(tv0Var, z, i4, qv0VarK);
        if (z) {
            b(tv0Var, i4 / 2, 5);
        } else {
            int i30 = i4 / 2;
            b(tv0Var, i30, 7);
            int i31 = 0;
            int i32 = 0;
            while (i32 < (i14 / 2) - 1) {
                for (int i33 = i30 & 1; i33 < i4; i33 += 2) {
                    int i34 = i30 - i31;
                    tv0Var.z(i34, i33);
                    int i35 = i30 + i31;
                    tv0Var.z(i35, i33);
                    tv0Var.z(i33, i34);
                    tv0Var.z(i33, i35);
                }
                i32 += 15;
                i31 += 16;
            }
        }
        vi0 vi0Var = new vi0();
        vi0Var.g(z);
        vi0Var.j(i4);
        vi0Var.h(iAbs);
        vi0Var.f(iS3);
        vi0Var.i(tv0Var);
        return vi0Var;
    }

    public static qv0 j(qv0 qv0Var, int i, int i2) {
        int iS = qv0Var.s() / i2;
        ed7 ed7Var = new ed7(l(i2));
        int i3 = i / i2;
        int[] iArrA = a(qv0Var, i2, i3);
        ed7Var.b(iArrA, i3 - iS);
        qv0 qv0Var2 = new qv0();
        qv0Var2.d(0, i % i2);
        for (int i4 : iArrA) {
            qv0Var2.d(i4, i2);
        }
        return qv0Var2;
    }

    public static qv0 k(boolean z, int i, int i2) {
        qv0 qv0Var = new qv0();
        if (z) {
            qv0Var.d(i - 1, 2);
            qv0Var.d(i2 - 1, 6);
            return j(qv0Var, 28, 4);
        }
        qv0Var.d(i - 1, 5);
        qv0Var.d(i2 - 1, 11);
        return j(qv0Var, 40, 4);
    }

    public static it3 l(int i) {
        if (i == 4) {
            return it3.d;
        }
        if (i == 6) {
            return it3.c;
        }
        if (i == 8) {
            return it3.g;
        }
        if (i == 10) {
            return it3.b;
        }
        if (i == 12) {
            return it3.f42437a;
        }
        throw new IllegalArgumentException("Unsupported word size " + i);
    }

    public static qv0 m(qv0 qv0Var, int i) {
        qv0 qv0Var2 = new qv0();
        int iS = qv0Var.s();
        int i2 = (1 << i) - 2;
        int i3 = 0;
        while (i3 < iS) {
            int i4 = 0;
            for (int i5 = 0; i5 < i; i5++) {
                int i6 = i3 + i5;
                if (i6 >= iS || qv0Var.m(i6)) {
                    i4 |= 1 << ((i - 1) - i5);
                }
            }
            int i7 = i4 & i2;
            if (i7 == i2) {
                qv0Var2.d(i7, i);
            } else {
                if (i7 == 0) {
                    qv0Var2.d(i4 | 1, i);
                } else {
                    qv0Var2.d(i4, i);
                }
                i3 += i;
            }
            i3--;
            i3 += i;
        }
        return qv0Var2;
    }

    public static int n(int i, boolean z) {
        return ((z ? 88 : 112) + (i * 16)) * i;
    }
}
