package com.zj.adlib;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.GridSampler;
import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class ql2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int[] f44236a = {3808, 476, 2107, 1799};

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f19144a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final tv0 f19145a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f19146a;
    public int b;
    public int c;
    public int d;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f44237a;
        public final int b;

        public a(int i, int i2) {
            this.f44237a = i;
            this.b = i2;
        }

        public int a() {
            return this.f44237a;
        }

        public int b() {
            return this.b;
        }

        public xg7 c() {
            return new xg7(this.f44237a, this.b);
        }

        public String toString() {
            return "<" + this.f44237a + ' ' + this.b + dv9.b;
        }
    }

    public ql2(tv0 tv0Var) {
        this.f19145a = tv0Var;
    }

    public static float c(a aVar, a aVar2) {
        return se5.b(aVar.a(), aVar.b(), aVar2.a(), aVar2.b());
    }

    public static float d(xg7 xg7Var, xg7 xg7Var2) {
        return se5.a(xg7Var.c(), xg7Var.d(), xg7Var2.c(), xg7Var2.d());
    }

    public static xg7[] e(xg7[] xg7VarArr, int i, int i2) {
        float f = i2 / (i * 2.0f);
        float fC = xg7VarArr[0].c() - xg7VarArr[2].c();
        float fD = xg7VarArr[0].d() - xg7VarArr[2].d();
        float fC2 = (xg7VarArr[0].c() + xg7VarArr[2].c()) / 2.0f;
        float fD2 = (xg7VarArr[0].d() + xg7VarArr[2].d()) / 2.0f;
        float f2 = fC * f;
        float f3 = fD * f;
        xg7 xg7Var = new xg7(fC2 + f2, fD2 + f3);
        xg7 xg7Var2 = new xg7(fC2 - f2, fD2 - f3);
        float fC3 = xg7VarArr[1].c() - xg7VarArr[3].c();
        float fD3 = xg7VarArr[1].d() - xg7VarArr[3].d();
        float fC4 = (xg7VarArr[1].c() + xg7VarArr[3].c()) / 2.0f;
        float fD4 = (xg7VarArr[1].d() + xg7VarArr[3].d()) / 2.0f;
        float f4 = fC3 * f;
        float f5 = f * fD3;
        return new xg7[]{xg7Var, new xg7(fC4 + f4, fD4 + f5), xg7Var2, new xg7(fC4 - f4, fD4 - f5)};
    }

    public static int i(long j, boolean z) throws NotFoundException {
        int i;
        int i2;
        if (z) {
            i = 7;
            i2 = 2;
        } else {
            i = 10;
            i2 = 4;
        }
        int i3 = i - i2;
        int[] iArr = new int[i];
        for (int i4 = i - 1; i4 >= 0; i4--) {
            iArr[i4] = ((int) j) & 15;
            j >>= 4;
        }
        try {
            new dd7(it3.d).a(iArr, i3);
            int i5 = 0;
            for (int i6 = 0; i6 < i2; i6++) {
                i5 = (i5 << 4) + iArr[i6];
            }
            return i5;
        } catch (ReedSolomonException unused) {
            throw NotFoundException.getNotFoundInstance();
        }
    }

    public static int n(int[] iArr, int i) throws NotFoundException {
        int i2 = 0;
        for (int i3 : iArr) {
            i2 = (i2 << 3) + ((i3 >> (i - 2)) << 1) + (i3 & 1);
        }
        int i4 = ((i2 & 1) << 11) + (i2 >> 1);
        for (int i5 = 0; i5 < 4; i5++) {
            if (Integer.bitCount(f44236a[i5] ^ i4) <= 2) {
                return i5;
            }
        }
        throw NotFoundException.getNotFoundInstance();
    }

    public wi0 a() throws NotFoundException {
        return b(false);
    }

    public wi0 b(boolean z) throws NotFoundException {
        xg7[] xg7VarArrG = g(l());
        if (z) {
            xg7 xg7Var = xg7VarArrG[0];
            xg7VarArrG[0] = xg7VarArrG[2];
            xg7VarArrG[2] = xg7Var;
        }
        f(xg7VarArrG);
        tv0 tv0Var = this.f19145a;
        int i = this.d;
        return new wi0(r(tv0Var, xg7VarArrG[i % 4], xg7VarArrG[(i + 1) % 4], xg7VarArrG[(i + 2) % 4], xg7VarArrG[(i + 3) % 4]), m(xg7VarArrG), this.f19146a, this.b, this.f19144a);
    }

    public final void f(xg7[] xg7VarArr) throws NotFoundException {
        long j;
        long j2;
        if (!p(xg7VarArr[0]) || !p(xg7VarArr[1]) || !p(xg7VarArr[2]) || !p(xg7VarArr[3])) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i = this.c * 2;
        int[] iArr = {s(xg7VarArr[0], xg7VarArr[1], i), s(xg7VarArr[1], xg7VarArr[2], i), s(xg7VarArr[2], xg7VarArr[3], i), s(xg7VarArr[3], xg7VarArr[0], i)};
        this.d = n(iArr, i);
        long j3 = 0;
        for (int i2 = 0; i2 < 4; i2++) {
            int i3 = iArr[(this.d + i2) % 4];
            if (this.f19146a) {
                j = j3 << 7;
                j2 = (i3 >> 1) & 127;
            } else {
                j = j3 << 10;
                j2 = ((i3 >> 2) & 992) + ((i3 >> 1) & 31);
            }
            j3 = j + j2;
        }
        int i4 = i(j3, this.f19146a);
        if (this.f19146a) {
            this.f19144a = (i4 >> 6) + 1;
            this.b = (i4 & 63) + 1;
        } else {
            this.f19144a = (i4 >> 11) + 1;
            this.b = (i4 & 2047) + 1;
        }
    }

    public final xg7[] g(a aVar) throws NotFoundException {
        this.c = 1;
        a aVar2 = aVar;
        a aVar3 = aVar2;
        a aVar4 = aVar3;
        boolean z = true;
        while (this.c < 9) {
            a aVarK = k(aVar, z, 1, -1);
            a aVarK2 = k(aVar2, z, 1, 1);
            a aVarK3 = k(aVar3, z, -1, 1);
            a aVarK4 = k(aVar4, z, -1, -1);
            if (this.c > 2) {
                double dC = (c(aVarK4, aVarK) * this.c) / (c(aVar4, aVar) * (this.c + 2));
                if (dC < 0.75d || dC > 1.25d || !q(aVarK, aVarK2, aVarK3, aVarK4)) {
                    break;
                }
            }
            z = !z;
            this.c++;
            aVar4 = aVarK4;
            aVar = aVarK;
            aVar2 = aVarK2;
            aVar3 = aVarK3;
        }
        int i = this.c;
        if (i != 5 && i != 7) {
            throw NotFoundException.getNotFoundInstance();
        }
        this.f19146a = i == 5;
        xg7[] xg7VarArr = {new xg7(aVar.a() + 0.5f, aVar.b() - 0.5f), new xg7(aVar2.a() + 0.5f, aVar2.b() + 0.5f), new xg7(aVar3.a() - 0.5f, aVar3.b() + 0.5f), new xg7(aVar4.a() - 0.5f, aVar4.b() - 0.5f)};
        int i2 = this.c;
        return e(xg7VarArr, (i2 * 2) - 3, i2 * 2);
    }

    public final int h(a aVar, a aVar2) {
        float fC = c(aVar, aVar2);
        if (fC == 0.0f) {
            return 0;
        }
        float fA = (aVar2.a() - aVar.a()) / fC;
        float fB = (aVar2.b() - aVar.b()) / fC;
        float fA2 = aVar.a();
        float fB2 = aVar.b();
        boolean zK = this.f19145a.k(aVar.a(), aVar.b());
        int iFloor = (int) Math.floor(fC);
        int i = 0;
        for (int i2 = 0; i2 < iFloor; i2++) {
            if (this.f19145a.k(se5.c(fA2), se5.c(fB2)) != zK) {
                i++;
            }
            fA2 += fA;
            fB2 += fB;
        }
        float f = i / fC;
        if (f <= 0.1f || f >= 0.9f) {
            return (f <= 0.1f) == zK ? 1 : -1;
        }
        return 0;
    }

    public final int j() {
        if (this.f19146a) {
            return (this.f19144a * 4) + 11;
        }
        int i = this.f19144a;
        return (i * 4) + ((((i * 2) + 6) / 15) * 2) + 15;
    }

    public final a k(a aVar, boolean z, int i, int i2) {
        int iA = aVar.a() + i;
        int iB = aVar.b();
        while (true) {
            iB += i2;
            if (!o(iA, iB) || this.f19145a.k(iA, iB) != z) {
                break;
            }
            iA += i;
        }
        int i3 = iA - i;
        int i4 = iB - i2;
        while (o(i3, i4) && this.f19145a.k(i3, i4) == z) {
            i3 += i;
        }
        int i5 = i3 - i;
        while (o(i5, i4) && this.f19145a.k(i5, i4) == z) {
            i4 += i2;
        }
        return new a(i5, i4 - i2);
    }

    public final a l() {
        xg7 xg7VarC;
        xg7 xg7Var;
        xg7 xg7Var2;
        xg7 xg7Var3;
        xg7 xg7VarC2;
        xg7 xg7VarC3;
        xg7 xg7VarC4;
        xg7 xg7VarC5;
        try {
            xg7[] xg7VarArrC = new vv9(this.f19145a).c();
            xg7Var2 = xg7VarArrC[0];
            xg7Var3 = xg7VarArrC[1];
            xg7Var = xg7VarArrC[2];
            xg7VarC = xg7VarArrC[3];
        } catch (NotFoundException unused) {
            int iT = this.f19145a.t() / 2;
            int iO = this.f19145a.o() / 2;
            int i = iT + 7;
            int i2 = iO - 7;
            xg7 xg7VarC6 = k(new a(i, i2), false, 1, -1).c();
            int i3 = iO + 7;
            xg7 xg7VarC7 = k(new a(i, i3), false, 1, 1).c();
            int i4 = iT - 7;
            xg7 xg7VarC8 = k(new a(i4, i3), false, -1, 1).c();
            xg7VarC = k(new a(i4, i2), false, -1, -1).c();
            xg7Var = xg7VarC8;
            xg7Var2 = xg7VarC6;
            xg7Var3 = xg7VarC7;
        }
        int iC = se5.c((((xg7Var2.c() + xg7VarC.c()) + xg7Var3.c()) + xg7Var.c()) / 4.0f);
        int iC2 = se5.c((((xg7Var2.d() + xg7VarC.d()) + xg7Var3.d()) + xg7Var.d()) / 4.0f);
        try {
            xg7[] xg7VarArrC2 = new vv9(this.f19145a, 15, iC, iC2).c();
            xg7VarC2 = xg7VarArrC2[0];
            xg7VarC3 = xg7VarArrC2[1];
            xg7VarC4 = xg7VarArrC2[2];
            xg7VarC5 = xg7VarArrC2[3];
        } catch (NotFoundException unused2) {
            int i5 = iC + 7;
            int i6 = iC2 - 7;
            xg7VarC2 = k(new a(i5, i6), false, 1, -1).c();
            int i7 = iC2 + 7;
            xg7VarC3 = k(new a(i5, i7), false, 1, 1).c();
            int i8 = iC - 7;
            xg7VarC4 = k(new a(i8, i7), false, -1, 1).c();
            xg7VarC5 = k(new a(i8, i6), false, -1, -1).c();
        }
        return new a(se5.c((((xg7VarC2.c() + xg7VarC5.c()) + xg7VarC3.c()) + xg7VarC4.c()) / 4.0f), se5.c((((xg7VarC2.d() + xg7VarC5.d()) + xg7VarC3.d()) + xg7VarC4.d()) / 4.0f));
    }

    public final xg7[] m(xg7[] xg7VarArr) {
        return e(xg7VarArr, this.c * 2, j());
    }

    public final boolean o(int i, int i2) {
        return i >= 0 && i < this.f19145a.t() && i2 >= 0 && i2 < this.f19145a.o();
    }

    public final boolean p(xg7 xg7Var) {
        return o(se5.c(xg7Var.c()), se5.c(xg7Var.d()));
    }

    public final boolean q(a aVar, a aVar2, a aVar3, a aVar4) {
        a aVar5 = new a(Math.max(0, aVar.a() - 3), Math.min(this.f19145a.o() - 1, aVar.b() + 3));
        a aVar6 = new a(Math.max(0, aVar2.a() - 3), Math.max(0, aVar2.b() - 3));
        a aVar7 = new a(Math.min(this.f19145a.t() - 1, aVar3.a() + 3), Math.max(0, Math.min(this.f19145a.o() - 1, aVar3.b() - 3)));
        a aVar8 = new a(Math.min(this.f19145a.t() - 1, aVar4.a() + 3), Math.min(this.f19145a.o() - 1, aVar4.b() + 3));
        int iH = h(aVar8, aVar5);
        return iH != 0 && h(aVar5, aVar6) == iH && h(aVar6, aVar7) == iH && h(aVar7, aVar8) == iH;
    }

    public final tv0 r(tv0 tv0Var, xg7 xg7Var, xg7 xg7Var2, xg7 xg7Var3, xg7 xg7Var4) throws NotFoundException {
        GridSampler gridSamplerA = GridSampler.a();
        int iJ = j();
        float f = iJ / 2.0f;
        int i = this.c;
        float f2 = f - i;
        float f3 = f + i;
        return gridSamplerA.b(tv0Var, iJ, iJ, f2, f2, f3, f2, f3, f3, f2, f3, xg7Var.c(), xg7Var.d(), xg7Var2.c(), xg7Var2.d(), xg7Var3.c(), xg7Var3.d(), xg7Var4.c(), xg7Var4.d());
    }

    public final int s(xg7 xg7Var, xg7 xg7Var2, int i) {
        float fD = d(xg7Var, xg7Var2);
        float f = fD / i;
        float fC = xg7Var.c();
        float fD2 = xg7Var.d();
        float fC2 = ((xg7Var2.c() - xg7Var.c()) * f) / fD;
        float fD3 = (f * (xg7Var2.d() - xg7Var.d())) / fD;
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3++) {
            float f2 = i3;
            if (this.f19145a.k(se5.c((f2 * fC2) + fC), se5.c((f2 * fD3) + fD2))) {
                i2 |= 1 << ((i - i3) - 1);
            }
        }
        return i2;
    }
}
