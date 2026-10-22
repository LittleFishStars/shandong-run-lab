package com.zj.adlib;

import java.util.Formatter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class nl2 {
    public static final int b = 2;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f43547a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public tz0 f18437a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final yl0 f18438a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ol2[] f18439a;

    public nl2(yl0 yl0Var, tz0 tz0Var) {
        this.f18438a = yl0Var;
        int iA = yl0Var.a();
        this.f43547a = iA;
        this.f18437a = tz0Var;
        this.f18439a = new ol2[iA + 2];
    }

    public static boolean b(fn1 fn1Var, fn1 fn1Var2) {
        if (fn1Var2 == null || !fn1Var2.g() || fn1Var2.a() != fn1Var.a()) {
            return false;
        }
        fn1Var.i(fn1Var2.c());
        return true;
    }

    public static int c(int i, int i2, fn1 fn1Var) {
        if (fn1Var == null || fn1Var.g()) {
            return i2;
        }
        if (!fn1Var.h(i)) {
            return i2 + 1;
        }
        fn1Var.i(i);
        return 0;
    }

    public final void a(ol2 ol2Var) {
        if (ol2Var != null) {
            ((pl2) ol2Var).g(this.f18438a);
        }
    }

    public final int d() {
        int iF = f();
        if (iF == 0) {
            return 0;
        }
        for (int i = 1; i < this.f43547a + 1; i++) {
            fn1[] fn1VarArrD = this.f18439a[i].d();
            for (int i2 = 0; i2 < fn1VarArrD.length; i2++) {
                fn1 fn1Var = fn1VarArrD[i2];
                if (fn1Var != null && !fn1Var.g()) {
                    e(i, i2, fn1VarArrD);
                }
            }
        }
        return iF;
    }

    public final void e(int i, int i2, fn1[] fn1VarArr) {
        fn1 fn1Var = fn1VarArr[i2];
        fn1[] fn1VarArrD = this.f18439a[i - 1].d();
        ol2 ol2Var = this.f18439a[i + 1];
        fn1[] fn1VarArrD2 = ol2Var != null ? ol2Var.d() : fn1VarArrD;
        fn1[] fn1VarArr2 = new fn1[14];
        fn1VarArr2[2] = fn1VarArrD[i2];
        fn1VarArr2[3] = fn1VarArrD2[i2];
        if (i2 > 0) {
            int i3 = i2 - 1;
            fn1VarArr2[0] = fn1VarArr[i3];
            fn1VarArr2[4] = fn1VarArrD[i3];
            fn1VarArr2[5] = fn1VarArrD2[i3];
        }
        if (i2 > 1) {
            int i4 = i2 - 2;
            fn1VarArr2[8] = fn1VarArr[i4];
            fn1VarArr2[10] = fn1VarArrD[i4];
            fn1VarArr2[11] = fn1VarArrD2[i4];
        }
        if (i2 < fn1VarArr.length - 1) {
            int i5 = i2 + 1;
            fn1VarArr2[1] = fn1VarArr[i5];
            fn1VarArr2[6] = fn1VarArrD[i5];
            fn1VarArr2[7] = fn1VarArrD2[i5];
        }
        if (i2 < fn1VarArr.length - 2) {
            int i6 = i2 + 2;
            fn1VarArr2[9] = fn1VarArr[i6];
            fn1VarArr2[12] = fn1VarArrD[i6];
            fn1VarArr2[13] = fn1VarArrD2[i6];
        }
        for (int i7 = 0; i7 < 14 && !b(fn1Var, fn1VarArr2[i7]); i7++) {
        }
    }

    public final int f() {
        g();
        return h() + i();
    }

    public final void g() {
        ol2[] ol2VarArr = this.f18439a;
        ol2 ol2Var = ol2VarArr[0];
        if (ol2Var == null || ol2VarArr[this.f43547a + 1] == null) {
            return;
        }
        fn1[] fn1VarArrD = ol2Var.d();
        fn1[] fn1VarArrD2 = this.f18439a[this.f43547a + 1].d();
        for (int i = 0; i < fn1VarArrD.length; i++) {
            fn1 fn1Var = fn1VarArrD[i];
            if (fn1Var != null && fn1VarArrD2[i] != null && fn1Var.c() == fn1VarArrD2[i].c()) {
                for (int i2 = 1; i2 <= this.f43547a; i2++) {
                    fn1 fn1Var2 = this.f18439a[i2].d()[i];
                    if (fn1Var2 != null) {
                        fn1Var2.i(fn1VarArrD[i].c());
                        if (!fn1Var2.g()) {
                            this.f18439a[i2].d()[i] = null;
                        }
                    }
                }
            }
        }
    }

    public final int h() {
        ol2 ol2Var = this.f18439a[0];
        if (ol2Var == null) {
            return 0;
        }
        fn1[] fn1VarArrD = ol2Var.d();
        int i = 0;
        for (int i2 = 0; i2 < fn1VarArrD.length; i2++) {
            fn1 fn1Var = fn1VarArrD[i2];
            if (fn1Var != null) {
                int iC = fn1Var.c();
                int iC2 = 0;
                for (int i3 = 1; i3 < this.f43547a + 1 && iC2 < 2; i3++) {
                    fn1 fn1Var2 = this.f18439a[i3].d()[i2];
                    if (fn1Var2 != null) {
                        iC2 = c(iC, iC2, fn1Var2);
                        if (!fn1Var2.g()) {
                            i++;
                        }
                    }
                }
            }
        }
        return i;
    }

    public final int i() {
        ol2[] ol2VarArr = this.f18439a;
        int i = this.f43547a;
        if (ol2VarArr[i + 1] == null) {
            return 0;
        }
        fn1[] fn1VarArrD = ol2VarArr[i + 1].d();
        int i2 = 0;
        for (int i3 = 0; i3 < fn1VarArrD.length; i3++) {
            fn1 fn1Var = fn1VarArrD[i3];
            if (fn1Var != null) {
                int iC = fn1Var.c();
                int iC2 = 0;
                for (int i4 = this.f43547a + 1; i4 > 0 && iC2 < 2; i4--) {
                    fn1 fn1Var2 = this.f18439a[i4].d()[i3];
                    if (fn1Var2 != null) {
                        iC2 = c(iC, iC2, fn1Var2);
                        if (!fn1Var2.g()) {
                            i2++;
                        }
                    }
                }
            }
        }
        return i2;
    }

    public int j() {
        return this.f43547a;
    }

    public int k() {
        return this.f18438a.b();
    }

    public int l() {
        return this.f18438a.c();
    }

    public tz0 m() {
        return this.f18437a;
    }

    public ol2 n(int i) {
        return this.f18439a[i];
    }

    public ol2[] o() {
        a(this.f18439a[0]);
        a(this.f18439a[this.f43547a + 1]);
        int i = 928;
        while (true) {
            int iD = d();
            if (iD <= 0 || iD >= i) {
                break;
            }
            i = iD;
        }
        return this.f18439a;
    }

    public void p(tz0 tz0Var) {
        this.f18437a = tz0Var;
    }

    public void q(int i, ol2 ol2Var) {
        this.f18439a[i] = ol2Var;
    }

    public String toString() {
        ol2[] ol2VarArr = this.f18439a;
        ol2 ol2Var = ol2VarArr[0];
        if (ol2Var == null) {
            ol2Var = ol2VarArr[this.f43547a + 1];
        }
        Formatter formatter = new Formatter();
        for (int i = 0; i < ol2Var.d().length; i++) {
            try {
                formatter.format("CW %3d:", Integer.valueOf(i));
                for (int i2 = 0; i2 < this.f43547a + 2; i2++) {
                    ol2 ol2Var2 = this.f18439a[i2];
                    if (ol2Var2 == null) {
                        formatter.format("    |   ", new Object[0]);
                    } else {
                        fn1 fn1Var = ol2Var2.d()[i];
                        if (fn1Var == null) {
                            formatter.format("    |   ", new Object[0]);
                        } else {
                            formatter.format(" %3d|%3d", Integer.valueOf(fn1Var.c()), Integer.valueOf(fn1Var.e()));
                        }
                    }
                }
                formatter.format("%n", new Object[0]);
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    try {
                        formatter.close();
                    } catch (Throwable th3) {
                        th.addSuppressed(th3);
                    }
                    throw th2;
                }
            }
        }
        String string = formatter.toString();
        formatter.close();
        return string;
    }
}
