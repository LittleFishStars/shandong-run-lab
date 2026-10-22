package com.zj.adlib;

import com.google.zxing.FormatException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class vv0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final km9 f45460a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final tv0 f20329a;
    public final tv0 b;

    public vv0(tv0 tv0Var) throws FormatException {
        int iO = tv0Var.o();
        if (iO < 8 || iO > 144 || (iO & 1) != 0) {
            throw FormatException.getFormatInstance();
        }
        this.f45460a = j(tv0Var);
        tv0 tv0VarA = a(tv0Var);
        this.f20329a = tv0VarA;
        this.b = new tv0(tv0VarA.t(), tv0VarA.o());
    }

    public static km9 j(tv0 tv0Var) throws FormatException {
        return km9.h(tv0Var.o(), tv0Var.t());
    }

    public final tv0 a(tv0 tv0Var) {
        int iF = this.f45460a.f();
        int iE = this.f45460a.e();
        if (tv0Var.o() != iF) {
            throw new IllegalArgumentException("Dimension of bitMatrix must match the version size");
        }
        int iC = this.f45460a.c();
        int iB = this.f45460a.b();
        int i = iF / iC;
        int i2 = iE / iB;
        tv0 tv0Var2 = new tv0(i2 * iB, i * iC);
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = i3 * iC;
            for (int i5 = 0; i5 < i2; i5++) {
                int i6 = i5 * iB;
                for (int i7 = 0; i7 < iC; i7++) {
                    int i8 = ((iC + 2) * i3) + 1 + i7;
                    int i9 = i4 + i7;
                    for (int i10 = 0; i10 < iB; i10++) {
                        if (tv0Var.k(((iB + 2) * i5) + 1 + i10, i8)) {
                            tv0Var2.z(i6 + i10, i9);
                        }
                    }
                }
            }
        }
        return tv0Var2;
    }

    public km9 b() {
        return this.f45460a;
    }

    public byte[] c() throws FormatException {
        byte[] bArr = new byte[this.f45460a.g()];
        int iO = this.f20329a.o();
        int iT = this.f20329a.t();
        int i = 0;
        boolean z = false;
        int i2 = 0;
        boolean z2 = false;
        boolean z3 = false;
        boolean z4 = false;
        int i3 = 4;
        while (true) {
            if (i3 == iO && i == 0 && !z) {
                bArr[i2] = (byte) d(iO, iT);
                i3 -= 2;
                i += 2;
                i2++;
                z = true;
            } else {
                int i4 = iO - 2;
                if (i3 == i4 && i == 0 && (iT & 3) != 0 && !z2) {
                    bArr[i2] = (byte) e(iO, iT);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z2 = true;
                } else if (i3 == iO + 4 && i == 2 && (iT & 7) == 0 && !z3) {
                    bArr[i2] = (byte) f(iO, iT);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z3 = true;
                } else if (i3 == i4 && i == 0 && (iT & 7) == 4 && !z4) {
                    bArr[i2] = (byte) g(iO, iT);
                    i3 -= 2;
                    i += 2;
                    i2++;
                    z4 = true;
                } else {
                    do {
                        if (i3 < iO && i >= 0 && !this.b.k(i, i3)) {
                            bArr[i2] = (byte) i(i3, i, iO, iT);
                            i2++;
                        }
                        i3 -= 2;
                        i += 2;
                        if (i3 < 0) {
                            break;
                        }
                    } while (i < iT);
                    int i5 = i3 + 1;
                    int i6 = i + 3;
                    do {
                        if (i5 >= 0 && i6 < iT && !this.b.k(i6, i5)) {
                            bArr[i2] = (byte) i(i5, i6, iO, iT);
                            i2++;
                        }
                        i5 += 2;
                        i6 -= 2;
                        if (i5 >= iO) {
                            break;
                        }
                    } while (i6 >= 0);
                    i3 = i5 + 3;
                    i = i6 + 1;
                }
            }
            if (i3 >= iO && i >= iT) {
                break;
            }
        }
        if (i2 == this.f45460a.g()) {
            return bArr;
        }
        throw FormatException.getFormatInstance();
    }

    public final int d(int i, int i2) {
        int i3 = i - 1;
        int i4 = (h(i3, 0, i, i2) ? 1 : 0) << 1;
        if (h(i3, 1, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(i3, 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(0, i2 - 2, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        int i8 = i2 - 1;
        if (h(0, i8, i, i2)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        if (h(1, i8, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        if (h(2, i8, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        return h(3, i8, i, i2) ? i11 | 1 : i11;
    }

    public final int e(int i, int i2) {
        int i3 = (h(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (h(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (h(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(0, i2 - 4, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        if (h(0, i2 - 3, i, i2)) {
            i6 |= 1;
        }
        int i7 = i6 << 1;
        if (h(0, i2 - 2, i, i2)) {
            i7 |= 1;
        }
        int i8 = i7 << 1;
        int i9 = i2 - 1;
        if (h(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        return h(1, i9, i, i2) ? i10 | 1 : i10;
    }

    public final int f(int i, int i2) {
        int i3 = i - 1;
        int i4 = (h(i3, 0, i, i2) ? 1 : 0) << 1;
        int i5 = i2 - 1;
        if (h(i3, i5, i, i2)) {
            i4 |= 1;
        }
        int i6 = i4 << 1;
        int i7 = i2 - 3;
        if (h(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        int i9 = i2 - 2;
        if (h(0, i9, i, i2)) {
            i8 |= 1;
        }
        int i10 = i8 << 1;
        if (h(0, i5, i, i2)) {
            i10 |= 1;
        }
        int i11 = i10 << 1;
        if (h(1, i7, i, i2)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(1, i9, i, i2)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        return h(1, i5, i, i2) ? i13 | 1 : i13;
    }

    public final int g(int i, int i2) {
        int i3 = (h(i + (-3), 0, i, i2) ? 1 : 0) << 1;
        if (h(i - 2, 0, i, i2)) {
            i3 |= 1;
        }
        int i4 = i3 << 1;
        if (h(i - 1, 0, i, i2)) {
            i4 |= 1;
        }
        int i5 = i4 << 1;
        if (h(0, i2 - 2, i, i2)) {
            i5 |= 1;
        }
        int i6 = i5 << 1;
        int i7 = i2 - 1;
        if (h(0, i7, i, i2)) {
            i6 |= 1;
        }
        int i8 = i6 << 1;
        if (h(1, i7, i, i2)) {
            i8 |= 1;
        }
        int i9 = i8 << 1;
        if (h(2, i7, i, i2)) {
            i9 |= 1;
        }
        int i10 = i9 << 1;
        return h(3, i7, i, i2) ? i10 | 1 : i10;
    }

    public final boolean h(int i, int i2, int i3, int i4) {
        if (i < 0) {
            i += i3;
            i2 += 4 - ((i3 + 4) & 7);
        }
        if (i2 < 0) {
            i2 += i4;
            i += 4 - ((i4 + 4) & 7);
        }
        if (i >= i3) {
            i -= i3;
        }
        this.b.z(i2, i);
        return this.f20329a.k(i2, i);
    }

    public final int i(int i, int i2, int i3, int i4) {
        int i5 = i - 2;
        int i6 = i2 - 2;
        int i7 = (h(i5, i6, i3, i4) ? 1 : 0) << 1;
        int i8 = i2 - 1;
        if (h(i5, i8, i3, i4)) {
            i7 |= 1;
        }
        int i9 = i7 << 1;
        int i10 = i - 1;
        if (h(i10, i6, i3, i4)) {
            i9 |= 1;
        }
        int i11 = i9 << 1;
        if (h(i10, i8, i3, i4)) {
            i11 |= 1;
        }
        int i12 = i11 << 1;
        if (h(i10, i2, i3, i4)) {
            i12 |= 1;
        }
        int i13 = i12 << 1;
        if (h(i, i6, i3, i4)) {
            i13 |= 1;
        }
        int i14 = i13 << 1;
        if (h(i, i8, i3, i4)) {
            i14 |= 1;
        }
        int i15 = i14 << 1;
        return h(i, i2, i3, i4) ? i15 | 1 : i15;
    }
}
