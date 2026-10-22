package com.zj.adlib;

import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPointCallback;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class e40 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f41340a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int f16188a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ResultPointCallback f16189a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final tv0 f16190a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final List<d40> f16191a = new ArrayList(5);

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f16192a = new int[3];
    public final int b;
    public final int c;
    public final int d;

    public e40(tv0 tv0Var, int i, int i2, int i3, int i4, float f, ResultPointCallback resultPointCallback) {
        this.f16190a = tv0Var;
        this.f16188a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        this.f41340a = f;
        this.f16189a = resultPointCallback;
    }

    public static float a(int[] iArr, int i) {
        return (i - iArr[2]) - (iArr[1] / 2.0f);
    }

    public final float b(int i, int i2, int i3, int i4) {
        tv0 tv0Var = this.f16190a;
        int iO = tv0Var.o();
        int[] iArr = this.f16192a;
        iArr[0] = 0;
        iArr[1] = 0;
        iArr[2] = 0;
        int i5 = i;
        while (i5 >= 0 && tv0Var.k(i2, i5)) {
            int i6 = iArr[1];
            if (i6 > i3) {
                break;
            }
            iArr[1] = i6 + 1;
            i5--;
        }
        if (i5 < 0 || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i5 >= 0 && !tv0Var.k(i2, i5)) {
            int i7 = iArr[0];
            if (i7 > i3) {
                break;
            }
            iArr[0] = i7 + 1;
            i5--;
        }
        if (iArr[0] > i3) {
            return Float.NaN;
        }
        int i8 = i + 1;
        while (i8 < iO && tv0Var.k(i2, i8)) {
            int i9 = iArr[1];
            if (i9 > i3) {
                break;
            }
            iArr[1] = i9 + 1;
            i8++;
        }
        if (i8 == iO || iArr[1] > i3) {
            return Float.NaN;
        }
        while (i8 < iO && !tv0Var.k(i2, i8)) {
            int i10 = iArr[2];
            if (i10 > i3) {
                break;
            }
            iArr[2] = i10 + 1;
            i8++;
        }
        int i11 = iArr[2];
        if (i11 <= i3 && Math.abs(((iArr[0] + iArr[1]) + i11) - i4) * 5 < i4 * 2 && d(iArr)) {
            return a(iArr, i8);
        }
        return Float.NaN;
    }

    public d40 c() throws NotFoundException {
        d40 d40VarE;
        d40 d40VarE2;
        int i = this.f16188a;
        int i2 = this.d;
        int i3 = this.c + i;
        int i4 = this.b + (i2 / 2);
        int[] iArr = new int[3];
        for (int i5 = 0; i5 < i2; i5++) {
            int i6 = ((i5 & 1) == 0 ? (i5 + 1) / 2 : -((i5 + 1) / 2)) + i4;
            iArr[0] = 0;
            iArr[1] = 0;
            iArr[2] = 0;
            int i7 = i;
            while (i7 < i3 && !this.f16190a.k(i7, i6)) {
                i7++;
            }
            int i8 = 0;
            while (i7 < i3) {
                if (!this.f16190a.k(i7, i6)) {
                    if (i8 == 1) {
                        i8++;
                    }
                    iArr[i8] = iArr[i8] + 1;
                } else if (i8 == 1) {
                    iArr[1] = iArr[1] + 1;
                } else if (i8 != 2) {
                    i8++;
                    iArr[i8] = iArr[i8] + 1;
                } else {
                    if (d(iArr) && (d40VarE2 = e(iArr, i6, i7)) != null) {
                        return d40VarE2;
                    }
                    iArr[0] = iArr[2];
                    iArr[1] = 1;
                    iArr[2] = 0;
                    i8 = 1;
                }
                i7++;
            }
            if (d(iArr) && (d40VarE = e(iArr, i6, i3)) != null) {
                return d40VarE;
            }
        }
        if (this.f16191a.isEmpty()) {
            throw NotFoundException.getNotFoundInstance();
        }
        return this.f16191a.get(0);
    }

    public final boolean d(int[] iArr) {
        float f = this.f41340a;
        float f2 = f / 2.0f;
        for (int i = 0; i < 3; i++) {
            if (Math.abs(f - iArr[i]) >= f2) {
                return false;
            }
        }
        return true;
    }

    public final d40 e(int[] iArr, int i, int i2) {
        int i3 = iArr[0] + iArr[1] + iArr[2];
        float fA = a(iArr, i2);
        float fB = b(i, (int) fA, iArr[1] * 2, i3);
        if (Float.isNaN(fB)) {
            return null;
        }
        float f = ((iArr[0] + iArr[1]) + iArr[2]) / 3.0f;
        for (d40 d40Var : this.f16191a) {
            if (d40Var.f(f, fB, fA)) {
                return d40Var.g(fB, fA, f);
            }
        }
        d40 d40Var2 = new d40(fA, fB, f);
        this.f16191a.add(d40Var2);
        ResultPointCallback resultPointCallback = this.f16189a;
        if (resultPointCallback == null) {
            return null;
        }
        resultPointCallback.a(d40Var2);
        return null;
    }
}
