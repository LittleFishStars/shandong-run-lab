package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class pl2 extends ol2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f44006a;

    public pl2(tz0 tz0Var, boolean z) {
        super(tz0Var);
        this.f44006a = z;
    }

    public void g(yl0 yl0Var) {
        fn1[] fn1VarArrD = d();
        m();
        l(fn1VarArrD, yl0Var);
        tz0 tz0VarA = a();
        xg7 xg7VarH = this.f44006a ? tz0VarA.h() : tz0VarA.i();
        xg7 xg7VarB = this.f44006a ? tz0VarA.b() : tz0VarA.c();
        int iE = e((int) xg7VarH.d());
        int iE2 = e((int) xg7VarB.d());
        int iC = -1;
        int i = 0;
        int iMax = 1;
        while (iE < iE2) {
            fn1 fn1Var = fn1VarArrD[iE];
            if (fn1Var != null) {
                int iC2 = fn1Var.c() - iC;
                if (iC2 == 0) {
                    i++;
                } else {
                    if (iC2 == 1) {
                        iMax = Math.max(iMax, i);
                        iC = fn1Var.c();
                    } else if (iC2 < 0 || fn1Var.c() >= yl0Var.c() || iC2 > iE) {
                        fn1VarArrD[iE] = null;
                    } else {
                        if (iMax > 2) {
                            iC2 *= iMax - 2;
                        }
                        boolean z = iC2 >= iE;
                        for (int i2 = 1; i2 <= iC2 && !z; i2++) {
                            z = fn1VarArrD[iE - i2] != null;
                        }
                        if (z) {
                            fn1VarArrD[iE] = null;
                        } else {
                            iC = fn1Var.c();
                        }
                    }
                    i = 1;
                }
            }
            iE++;
        }
    }

    public final void h(yl0 yl0Var) {
        tz0 tz0VarA = a();
        xg7 xg7VarH = this.f44006a ? tz0VarA.h() : tz0VarA.i();
        xg7 xg7VarB = this.f44006a ? tz0VarA.b() : tz0VarA.c();
        int iE = e((int) xg7VarB.d());
        fn1[] fn1VarArrD = d();
        int iC = -1;
        int i = 0;
        int iMax = 1;
        for (int iE2 = e((int) xg7VarH.d()); iE2 < iE; iE2++) {
            fn1 fn1Var = fn1VarArrD[iE2];
            if (fn1Var != null) {
                fn1Var.j();
                int iC2 = fn1Var.c() - iC;
                if (iC2 == 0) {
                    i++;
                } else {
                    if (iC2 == 1) {
                        iMax = Math.max(iMax, i);
                        iC = fn1Var.c();
                    } else if (fn1Var.c() >= yl0Var.c()) {
                        fn1VarArrD[iE2] = null;
                    } else {
                        iC = fn1Var.c();
                    }
                    i = 1;
                }
            }
        }
    }

    public yl0 i() {
        fn1[] fn1VarArrD = d();
        cm0 cm0Var = new cm0();
        cm0 cm0Var2 = new cm0();
        cm0 cm0Var3 = new cm0();
        cm0 cm0Var4 = new cm0();
        for (fn1 fn1Var : fn1VarArrD) {
            if (fn1Var != null) {
                fn1Var.j();
                int iE = fn1Var.e() % 30;
                int iC = fn1Var.c();
                if (!this.f44006a) {
                    iC += 2;
                }
                int i = iC % 3;
                if (i == 0) {
                    cm0Var2.c((iE * 3) + 1);
                } else if (i == 1) {
                    cm0Var4.c(iE / 3);
                    cm0Var3.c(iE % 3);
                } else if (i == 2) {
                    cm0Var.c(iE + 1);
                }
            }
        }
        if (cm0Var.b().length == 0 || cm0Var2.b().length == 0 || cm0Var3.b().length == 0 || cm0Var4.b().length == 0 || cm0Var.b()[0] < 1 || cm0Var2.b()[0] + cm0Var3.b()[0] < 3 || cm0Var2.b()[0] + cm0Var3.b()[0] > 90) {
            return null;
        }
        yl0 yl0Var = new yl0(cm0Var.b()[0], cm0Var2.b()[0], cm0Var3.b()[0], cm0Var4.b()[0]);
        l(fn1VarArrD, yl0Var);
        return yl0Var;
    }

    public int[] j() {
        int iC;
        yl0 yl0VarI = i();
        if (yl0VarI == null) {
            return null;
        }
        h(yl0VarI);
        int iC2 = yl0VarI.c();
        int[] iArr = new int[iC2];
        for (fn1 fn1Var : d()) {
            if (fn1Var != null && (iC = fn1Var.c()) < iC2) {
                iArr[iC] = iArr[iC] + 1;
            }
        }
        return iArr;
    }

    public boolean k() {
        return this.f44006a;
    }

    public final void l(fn1[] fn1VarArr, yl0 yl0Var) {
        for (int i = 0; i < fn1VarArr.length; i++) {
            fn1 fn1Var = fn1VarArr[i];
            if (fn1Var != null) {
                int iE = fn1Var.e() % 30;
                int iC = fn1Var.c();
                if (iC > yl0Var.c()) {
                    fn1VarArr[i] = null;
                } else {
                    if (!this.f44006a) {
                        iC += 2;
                    }
                    int i2 = iC % 3;
                    if (i2 != 0) {
                        if (i2 != 1) {
                            if (i2 == 2 && iE + 1 != yl0Var.a()) {
                                fn1VarArr[i] = null;
                            }
                        } else if (iE / 3 != yl0Var.b() || iE % 3 != yl0Var.d()) {
                            fn1VarArr[i] = null;
                        }
                    } else if ((iE * 3) + 1 != yl0Var.e()) {
                        fn1VarArr[i] = null;
                    }
                }
            }
        }
    }

    public final void m() {
        for (fn1 fn1Var : d()) {
            if (fn1Var != null) {
                fn1Var.j();
            }
        }
    }

    @Override // com.zj.adlib.ol2
    public String toString() {
        return "IsLeft: " + this.f44006a + '\n' + super.toString();
    }
}
