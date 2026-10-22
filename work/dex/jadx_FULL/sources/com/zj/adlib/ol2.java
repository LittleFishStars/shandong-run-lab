package com.zj.adlib;

import java.util.Formatter;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ol2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f43772a = 5;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final tz0 f18669a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final fn1[] f18670a;

    public ol2(tz0 tz0Var) {
        this.f18669a = new tz0(tz0Var);
        this.f18670a = new fn1[(tz0Var.e() - tz0Var.g()) + 1];
    }

    public final tz0 a() {
        return this.f18669a;
    }

    public final fn1 b(int i) {
        return this.f18670a[e(i)];
    }

    public final fn1 c(int i) {
        fn1 fn1Var;
        fn1 fn1Var2;
        fn1 fn1VarB = b(i);
        if (fn1VarB != null) {
            return fn1VarB;
        }
        for (int i2 = 1; i2 < 5; i2++) {
            int iE = e(i) - i2;
            if (iE >= 0 && (fn1Var2 = this.f18670a[iE]) != null) {
                return fn1Var2;
            }
            int iE2 = e(i) + i2;
            fn1[] fn1VarArr = this.f18670a;
            if (iE2 < fn1VarArr.length && (fn1Var = fn1VarArr[iE2]) != null) {
                return fn1Var;
            }
        }
        return null;
    }

    public final fn1[] d() {
        return this.f18670a;
    }

    public final int e(int i) {
        return i - this.f18669a.g();
    }

    public final void f(int i, fn1 fn1Var) {
        this.f18670a[e(i)] = fn1Var;
    }

    public String toString() {
        Formatter formatter = new Formatter();
        try {
            int i = 0;
            for (fn1 fn1Var : this.f18670a) {
                if (fn1Var == null) {
                    formatter.format("%3d:    |   %n", Integer.valueOf(i));
                    i++;
                } else {
                    formatter.format("%3d: %3d|%3d%n", Integer.valueOf(i), Integer.valueOf(fn1Var.c()), Integer.valueOf(fn1Var.e()));
                    i++;
                }
            }
            String string = formatter.toString();
            formatter.close();
            return string;
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
}
