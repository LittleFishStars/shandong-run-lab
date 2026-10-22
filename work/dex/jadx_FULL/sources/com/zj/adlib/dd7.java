package com.zj.adlib;

import com.google.zxing.common.reedsolomon.ReedSolomonException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class dd7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final it3 f41157a;

    public dd7(it3 it3Var) {
        this.f41157a = it3Var;
    }

    public void a(int[] iArr, int i) throws ReedSolomonException {
        jt3 jt3Var = new jt3(this.f41157a, iArr);
        int[] iArr2 = new int[i];
        boolean z = true;
        for (int i2 = 0; i2 < i; i2++) {
            it3 it3Var = this.f41157a;
            int iC = jt3Var.c(it3Var.c(it3Var.d() + i2));
            iArr2[(i - 1) - i2] = iC;
            if (iC != 0) {
                z = false;
            }
        }
        if (z) {
            return;
        }
        jt3[] jt3VarArrD = d(this.f41157a.b(i, 1), new jt3(this.f41157a, iArr2), i);
        jt3 jt3Var2 = jt3VarArrD[0];
        jt3 jt3Var3 = jt3VarArrD[1];
        int[] iArrB = b(jt3Var2);
        int[] iArrC = c(jt3Var3, iArrB);
        for (int i3 = 0; i3 < iArrB.length; i3++) {
            int length = (iArr.length - 1) - this.f41157a.i(iArrB[i3]);
            if (length < 0) {
                throw new ReedSolomonException("Bad error location");
            }
            iArr[length] = it3.a(iArr[length], iArrC[i3]);
        }
    }

    public final int[] b(jt3 jt3Var) throws ReedSolomonException {
        int iF = jt3Var.f();
        int i = 0;
        if (iF == 1) {
            return new int[]{jt3Var.d(1)};
        }
        int[] iArr = new int[iF];
        for (int i2 = 1; i2 < this.f41157a.f() && i < iF; i2++) {
            if (jt3Var.c(i2) == 0) {
                iArr[i] = this.f41157a.h(i2);
                i++;
            }
        }
        if (i == iF) {
            return iArr;
        }
        throw new ReedSolomonException("Error locator degree does not match number of roots");
    }

    public final int[] c(jt3 jt3Var, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        for (int i = 0; i < length; i++) {
            int iH = this.f41157a.h(iArr[i]);
            int iJ = 1;
            for (int i2 = 0; i2 < length; i2++) {
                if (i != i2) {
                    int iJ2 = this.f41157a.j(iArr[i2], iH);
                    iJ = this.f41157a.j(iJ, (iJ2 & 1) == 0 ? iJ2 | 1 : iJ2 & (-2));
                }
            }
            iArr2[i] = this.f41157a.j(jt3Var.c(iH), this.f41157a.h(iJ));
            if (this.f41157a.d() != 0) {
                iArr2[i] = this.f41157a.j(iArr2[i], iH);
            }
        }
        return iArr2;
    }

    public final jt3[] d(jt3 jt3Var, jt3 jt3Var2, int i) throws ReedSolomonException {
        if (jt3Var.f() < jt3Var2.f()) {
            jt3Var2 = jt3Var;
            jt3Var = jt3Var2;
        }
        jt3 jt3VarG = this.f41157a.g();
        jt3 jt3VarE = this.f41157a.e();
        do {
            jt3 jt3Var3 = jt3Var2;
            jt3Var2 = jt3Var;
            jt3Var = jt3Var3;
            jt3 jt3Var4 = jt3VarE;
            jt3 jt3Var5 = jt3VarG;
            jt3VarG = jt3Var4;
            if (jt3Var.f() * 2 < i) {
                int iD = jt3VarG.d(0);
                if (iD == 0) {
                    throw new ReedSolomonException("sigmaTilde(0) was zero");
                }
                int iH = this.f41157a.h(iD);
                return new jt3[]{jt3VarG.h(iH), jt3Var.h(iH)};
            }
            if (jt3Var.g()) {
                throw new ReedSolomonException("r_{i-1} was zero");
            }
            jt3 jt3VarG2 = this.f41157a.g();
            int iH2 = this.f41157a.h(jt3Var.d(jt3Var.f()));
            while (jt3Var2.f() >= jt3Var.f() && !jt3Var2.g()) {
                int iF = jt3Var2.f() - jt3Var.f();
                int iJ = this.f41157a.j(jt3Var2.d(jt3Var2.f()), iH2);
                jt3VarG2 = jt3VarG2.a(this.f41157a.b(iF, iJ));
                jt3Var2 = jt3Var2.a(jt3Var.j(iF, iJ));
            }
            jt3VarE = jt3VarG2.i(jt3VarG).a(jt3Var5);
        } while (jt3Var2.f() < jt3Var.f());
        throw new IllegalStateException("Division algorithm failed to reduce polynomial? r: " + jt3Var2 + ", rLast: " + jt3Var);
    }
}
