package com.zj.adlib;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.GridSampler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class rl2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final tv0 f44478a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final vv9 f19347a;

    public rl2(tv0 tv0Var) throws NotFoundException {
        this.f44478a = tv0Var;
        this.f19347a = new vv9(tv0Var);
    }

    public static xg7 f(xg7 xg7Var, float f, float f2) {
        float fC = xg7Var.c();
        float fD = xg7Var.d();
        return new xg7(fC < f ? fC - 1.0f : fC + 1.0f, fD < f2 ? fD - 1.0f : fD + 1.0f);
    }

    public static tv0 g(tv0 tv0Var, xg7 xg7Var, xg7 xg7Var2, xg7 xg7Var3, xg7 xg7Var4, int i, int i2) throws NotFoundException {
        float f = i - 0.5f;
        float f2 = i2 - 0.5f;
        return GridSampler.a().b(tv0Var, i, i2, 0.5f, 0.5f, f, 0.5f, f, f2, 0.5f, f2, xg7Var.c(), xg7Var.d(), xg7Var4.c(), xg7Var4.d(), xg7Var3.c(), xg7Var3.d(), xg7Var2.c(), xg7Var2.d());
    }

    public static xg7 h(xg7 xg7Var, xg7 xg7Var2, int i) {
        float f = i + 1;
        return new xg7(xg7Var.c() + ((xg7Var2.c() - xg7Var.c()) / f), xg7Var.d() + ((xg7Var2.d() - xg7Var.d()) / f));
    }

    public final xg7 a(xg7[] xg7VarArr) {
        xg7 xg7Var = xg7VarArr[0];
        xg7 xg7Var2 = xg7VarArr[1];
        xg7 xg7Var3 = xg7VarArr[2];
        xg7 xg7Var4 = xg7VarArr[3];
        int iJ = j(xg7Var, xg7Var4);
        xg7 xg7VarH = h(xg7Var, xg7Var2, (j(xg7Var2, xg7Var4) + 1) * 4);
        xg7 xg7VarH2 = h(xg7Var3, xg7Var2, (iJ + 1) * 4);
        int iJ2 = j(xg7VarH, xg7Var4);
        int iJ3 = j(xg7VarH2, xg7Var4);
        float f = iJ2 + 1;
        xg7 xg7Var5 = new xg7(xg7Var4.c() + ((xg7Var3.c() - xg7Var2.c()) / f), xg7Var4.d() + ((xg7Var3.d() - xg7Var2.d()) / f));
        float f2 = iJ3 + 1;
        xg7 xg7Var6 = new xg7(xg7Var4.c() + ((xg7Var.c() - xg7Var2.c()) / f2), xg7Var4.d() + ((xg7Var.d() - xg7Var2.d()) / f2));
        if (e(xg7Var5)) {
            return (e(xg7Var6) && j(xg7VarH, xg7Var5) + j(xg7VarH2, xg7Var5) <= j(xg7VarH, xg7Var6) + j(xg7VarH2, xg7Var6)) ? xg7Var6 : xg7Var5;
        }
        if (e(xg7Var6)) {
            return xg7Var6;
        }
        return null;
    }

    public ul2 b() throws NotFoundException {
        int iMax;
        int i;
        xg7[] xg7VarArrD = d(c(this.f19347a.c()));
        xg7 xg7VarA = a(xg7VarArrD);
        xg7VarArrD[3] = xg7VarA;
        if (xg7VarA == null) {
            throw NotFoundException.getNotFoundInstance();
        }
        xg7[] xg7VarArrI = i(xg7VarArrD);
        xg7 xg7Var = xg7VarArrI[0];
        xg7 xg7Var2 = xg7VarArrI[1];
        xg7 xg7Var3 = xg7VarArrI[2];
        xg7 xg7Var4 = xg7VarArrI[3];
        int iJ = j(xg7Var, xg7Var4) + 1;
        int iJ2 = j(xg7Var3, xg7Var4) + 1;
        if ((iJ & 1) == 1) {
            iJ++;
        }
        if ((iJ2 & 1) == 1) {
            iJ2++;
        }
        if (iJ * 4 >= iJ2 * 6 || iJ2 * 4 >= iJ * 6) {
            iMax = iJ;
            i = iJ2;
        } else {
            iMax = Math.max(iJ, iJ2);
            i = iMax;
        }
        return new ul2(g(this.f44478a, xg7Var, xg7Var2, xg7Var3, xg7Var4, iMax, i), new xg7[]{xg7Var, xg7Var2, xg7Var3, xg7Var4});
    }

    public final xg7[] c(xg7[] xg7VarArr) {
        xg7 xg7Var = xg7VarArr[0];
        xg7 xg7Var2 = xg7VarArr[1];
        xg7 xg7Var3 = xg7VarArr[3];
        xg7 xg7Var4 = xg7VarArr[2];
        int iJ = j(xg7Var, xg7Var2);
        int iJ2 = j(xg7Var2, xg7Var3);
        int iJ3 = j(xg7Var3, xg7Var4);
        int iJ4 = j(xg7Var4, xg7Var);
        xg7[] xg7VarArr2 = {xg7Var4, xg7Var, xg7Var2, xg7Var3};
        if (iJ > iJ2) {
            xg7VarArr2[0] = xg7Var;
            xg7VarArr2[1] = xg7Var2;
            xg7VarArr2[2] = xg7Var3;
            xg7VarArr2[3] = xg7Var4;
            iJ = iJ2;
        }
        if (iJ > iJ3) {
            xg7VarArr2[0] = xg7Var2;
            xg7VarArr2[1] = xg7Var3;
            xg7VarArr2[2] = xg7Var4;
            xg7VarArr2[3] = xg7Var;
        } else {
            iJ3 = iJ;
        }
        if (iJ3 > iJ4) {
            xg7VarArr2[0] = xg7Var3;
            xg7VarArr2[1] = xg7Var4;
            xg7VarArr2[2] = xg7Var;
            xg7VarArr2[3] = xg7Var2;
        }
        return xg7VarArr2;
    }

    public final xg7[] d(xg7[] xg7VarArr) {
        xg7 xg7Var = xg7VarArr[0];
        xg7 xg7Var2 = xg7VarArr[1];
        xg7 xg7Var3 = xg7VarArr[2];
        xg7 xg7Var4 = xg7VarArr[3];
        int iJ = (j(xg7Var, xg7Var4) + 1) * 4;
        if (j(h(xg7Var2, xg7Var3, iJ), xg7Var) < j(h(xg7Var3, xg7Var2, iJ), xg7Var4)) {
            xg7VarArr[0] = xg7Var;
            xg7VarArr[1] = xg7Var2;
            xg7VarArr[2] = xg7Var3;
            xg7VarArr[3] = xg7Var4;
        } else {
            xg7VarArr[0] = xg7Var2;
            xg7VarArr[1] = xg7Var3;
            xg7VarArr[2] = xg7Var4;
            xg7VarArr[3] = xg7Var;
        }
        return xg7VarArr;
    }

    public final boolean e(xg7 xg7Var) {
        return xg7Var.c() >= 0.0f && xg7Var.c() <= ((float) (this.f44478a.t() - 1)) && xg7Var.d() > 0.0f && xg7Var.d() <= ((float) (this.f44478a.o() - 1));
    }

    public final xg7[] i(xg7[] xg7VarArr) {
        xg7 xg7Var = xg7VarArr[0];
        xg7 xg7Var2 = xg7VarArr[1];
        xg7 xg7Var3 = xg7VarArr[2];
        xg7 xg7Var4 = xg7VarArr[3];
        int iJ = j(xg7Var, xg7Var4) + 1;
        xg7 xg7VarH = h(xg7Var, xg7Var2, (j(xg7Var3, xg7Var4) + 1) * 4);
        xg7 xg7VarH2 = h(xg7Var3, xg7Var2, iJ * 4);
        int iJ2 = j(xg7VarH, xg7Var4) + 1;
        int iJ3 = j(xg7VarH2, xg7Var4) + 1;
        if ((iJ2 & 1) == 1) {
            iJ2++;
        }
        if ((iJ3 & 1) == 1) {
            iJ3++;
        }
        float fC = (((xg7Var.c() + xg7Var2.c()) + xg7Var3.c()) + xg7Var4.c()) / 4.0f;
        float fD = (((xg7Var.d() + xg7Var2.d()) + xg7Var3.d()) + xg7Var4.d()) / 4.0f;
        xg7 xg7VarF = f(xg7Var, fC, fD);
        xg7 xg7VarF2 = f(xg7Var2, fC, fD);
        xg7 xg7VarF3 = f(xg7Var3, fC, fD);
        xg7 xg7VarF4 = f(xg7Var4, fC, fD);
        int i = iJ3 * 4;
        int i2 = iJ2 * 4;
        return new xg7[]{h(h(xg7VarF, xg7VarF2, i), xg7VarF4, i2), h(h(xg7VarF2, xg7VarF, i), xg7VarF3, i2), h(h(xg7VarF3, xg7VarF4, i), xg7VarF2, i2), h(h(xg7VarF4, xg7VarF3, i), xg7VarF, i2)};
    }

    public final int j(xg7 xg7Var, xg7 xg7Var2) {
        int iC = (int) xg7Var.c();
        int iD = (int) xg7Var.d();
        int iC2 = (int) xg7Var2.c();
        int iMin = Math.min(this.f44478a.o() - 1, (int) xg7Var2.d());
        int i = 0;
        boolean z = Math.abs(iMin - iD) > Math.abs(iC2 - iC);
        if (z) {
            iD = iC;
            iC = iD;
            iMin = iC2;
            iC2 = iMin;
        }
        int iAbs = Math.abs(iC2 - iC);
        int iAbs2 = Math.abs(iMin - iD);
        int i2 = (-iAbs) / 2;
        int i3 = iD < iMin ? 1 : -1;
        int i4 = iC >= iC2 ? -1 : 1;
        boolean zK = this.f44478a.k(z ? iD : iC, z ? iC : iD);
        while (iC != iC2) {
            boolean zK2 = this.f44478a.k(z ? iD : iC, z ? iC : iD);
            if (zK2 != zK) {
                i++;
                zK = zK2;
            }
            i2 += iAbs2;
            if (i2 > 0) {
                if (iD == iMin) {
                    break;
                }
                iD += i3;
                i2 -= iAbs;
            }
            iC += i4;
        }
        return i;
    }
}
