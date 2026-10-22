package com.zj.adlib;

import com.google.zxing.ChecksumException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class w43 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final er5 f45522a = er5.f41508a;

    public int a(int[] iArr, int i, int[] iArr2) throws ChecksumException {
        fr5 fr5Var = new fr5(this.f45522a, iArr);
        int[] iArr3 = new int[i];
        boolean z = false;
        for (int i2 = i; i2 > 0; i2--) {
            int iB = fr5Var.b(this.f45522a.c(i2));
            iArr3[i - i2] = iB;
            if (iB != 0) {
                z = true;
            }
        }
        if (!z) {
            return 0;
        }
        fr5 fr5VarD = this.f45522a.d();
        if (iArr2 != null) {
            for (int i3 : iArr2) {
                int iC = this.f45522a.c((iArr.length - 1) - i3);
                er5 er5Var = this.f45522a;
                fr5VarD = fr5VarD.h(new fr5(er5Var, new int[]{er5Var.j(0, iC), 1}));
            }
        }
        fr5[] fr5VarArrD = d(this.f45522a.b(i, 1), new fr5(this.f45522a, iArr3), i);
        fr5 fr5Var2 = fr5VarArrD[0];
        fr5 fr5Var3 = fr5VarArrD[1];
        int[] iArrB = b(fr5Var2);
        int[] iArrC = c(fr5Var3, fr5Var2, iArrB);
        for (int i4 = 0; i4 < iArrB.length; i4++) {
            int length = (iArr.length - 1) - this.f45522a.h(iArrB[i4]);
            if (length < 0) {
                throw ChecksumException.getChecksumInstance();
            }
            iArr[length] = this.f45522a.j(iArr[length], iArrC[i4]);
        }
        return iArrB.length;
    }

    public final int[] b(fr5 fr5Var) throws ChecksumException {
        int iE = fr5Var.e();
        int[] iArr = new int[iE];
        int i = 0;
        for (int i2 = 1; i2 < this.f45522a.e() && i < iE; i2++) {
            if (fr5Var.b(i2) == 0) {
                iArr[i] = this.f45522a.g(i2);
                i++;
            }
        }
        if (i == iE) {
            return iArr;
        }
        throw ChecksumException.getChecksumInstance();
    }

    public final int[] c(fr5 fr5Var, fr5 fr5Var2, int[] iArr) {
        int iE = fr5Var2.e();
        if (iE < 1) {
            return new int[0];
        }
        int[] iArr2 = new int[iE];
        for (int i = 1; i <= iE; i++) {
            iArr2[iE - i] = this.f45522a.i(i, fr5Var2.c(i));
        }
        fr5 fr5Var3 = new fr5(this.f45522a, iArr2);
        int length = iArr.length;
        int[] iArr3 = new int[length];
        for (int i2 = 0; i2 < length; i2++) {
            int iG = this.f45522a.g(iArr[i2]);
            iArr3[i2] = this.f45522a.i(this.f45522a.j(0, fr5Var.b(iG)), this.f45522a.g(fr5Var3.b(iG)));
        }
        return iArr3;
    }

    public final fr5[] d(fr5 fr5Var, fr5 fr5Var2, int i) throws ChecksumException {
        if (fr5Var.e() < fr5Var2.e()) {
            fr5Var2 = fr5Var;
            fr5Var = fr5Var2;
        }
        fr5 fr5VarF = this.f45522a.f();
        fr5 fr5VarD = this.f45522a.d();
        while (true) {
            fr5 fr5Var3 = fr5Var2;
            fr5Var2 = fr5Var;
            fr5Var = fr5Var3;
            fr5 fr5Var4 = fr5VarD;
            fr5 fr5Var5 = fr5VarF;
            fr5VarF = fr5Var4;
            if (fr5Var.e() < i / 2) {
                int iC = fr5VarF.c(0);
                if (iC == 0) {
                    throw ChecksumException.getChecksumInstance();
                }
                int iG = this.f45522a.g(iC);
                return new fr5[]{fr5VarF.g(iG), fr5Var.g(iG)};
            }
            if (fr5Var.f()) {
                throw ChecksumException.getChecksumInstance();
            }
            fr5 fr5VarF2 = this.f45522a.f();
            int iG2 = this.f45522a.g(fr5Var.c(fr5Var.e()));
            while (fr5Var2.e() >= fr5Var.e() && !fr5Var2.f()) {
                int iE = fr5Var2.e() - fr5Var.e();
                int i2 = this.f45522a.i(fr5Var2.c(fr5Var2.e()), iG2);
                fr5VarF2 = fr5VarF2.a(this.f45522a.b(iE, i2));
                fr5Var2 = fr5Var2.k(fr5Var.i(iE, i2));
            }
            fr5VarD = fr5VarF2.h(fr5VarF).k(fr5Var5).j();
        }
    }
}
