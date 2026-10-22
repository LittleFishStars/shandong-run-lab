package com.zj.adlib;

import com.google.zxing.NotFoundException;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class tz0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f45031a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final tv0 f19916a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final xg7 f19917a;
    public final int b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public final xg7 f19918b;
    public final int c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final xg7 f19919c;
    public final int d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public final xg7 f19920d;

    public tz0(tv0 tv0Var, xg7 xg7Var, xg7 xg7Var2, xg7 xg7Var3, xg7 xg7Var4) throws NotFoundException {
        boolean z = xg7Var == null || xg7Var2 == null;
        boolean z2 = xg7Var3 == null || xg7Var4 == null;
        if (z && z2) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (z) {
            xg7Var = new xg7(0.0f, xg7Var3.d());
            xg7Var2 = new xg7(0.0f, xg7Var4.d());
        } else if (z2) {
            xg7Var3 = new xg7(tv0Var.t() - 1, xg7Var.d());
            xg7Var4 = new xg7(tv0Var.t() - 1, xg7Var2.d());
        }
        this.f19916a = tv0Var;
        this.f19917a = xg7Var;
        this.f19918b = xg7Var2;
        this.f19919c = xg7Var3;
        this.f19920d = xg7Var4;
        this.f45031a = (int) Math.min(xg7Var.c(), xg7Var2.c());
        this.b = (int) Math.max(xg7Var3.c(), xg7Var4.c());
        this.c = (int) Math.min(xg7Var.d(), xg7Var3.d());
        this.d = (int) Math.max(xg7Var2.d(), xg7Var4.d());
    }

    public static tz0 j(tz0 tz0Var, tz0 tz0Var2) throws NotFoundException {
        if (tz0Var == null) {
            return tz0Var2;
        }
        return tz0Var2 == null ? tz0Var : new tz0(tz0Var.f19916a, tz0Var.f19917a, tz0Var.f19918b, tz0Var2.f19919c, tz0Var2.f19920d);
    }

    /* JADX WARN: Code duplicated, block: B:17:0x002d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:18:0x002f  */
    /* JADX WARN: Code duplicated, block: B:19:0x0032  */
    /* JADX WARN: Code duplicated, block: B:22:0x0042  */
    /* JADX WARN: Code duplicated, block: B:25:0x0056  */
    /* JADX WARN: Code duplicated, block: B:26:0x0058  */
    /* JADX WARN: Code duplicated, block: B:27:0x005b  */
    public tz0 a(int i, int i2, boolean z) throws NotFoundException {
        xg7 xg7Var;
        xg7 xg7Var2;
        xg7 xg7Var3;
        xg7 xg7Var4;
        xg7 xg7Var5;
        int iD;
        xg7 xg7Var6;
        xg7 xg7Var7 = this.f19917a;
        xg7 xg7Var8 = this.f19918b;
        xg7 xg7Var9 = this.f19919c;
        xg7 xg7Var10 = this.f19920d;
        if (i > 0) {
            xg7 xg7Var11 = z ? xg7Var7 : xg7Var9;
            int iD2 = ((int) xg7Var11.d()) - i;
            if (iD2 < 0) {
                iD2 = 0;
            }
            xg7 xg7Var12 = new xg7(xg7Var11.c(), iD2);
            if (z) {
                xg7Var = xg7Var12;
            } else {
                xg7Var2 = xg7Var12;
                xg7Var = xg7Var7;
            }
            if (i2 > 0) {
                if (z) {
                    xg7Var5 = this.f19918b;
                } else {
                    xg7Var5 = this.f19920d;
                }
                iD = ((int) xg7Var5.d()) + i2;
                if (iD >= this.f19916a.o()) {
                    iD = this.f19916a.o() - 1;
                }
                xg7Var6 = new xg7(xg7Var5.c(), iD);
                if (z) {
                    xg7Var3 = xg7Var6;
                } else {
                    xg7Var4 = xg7Var6;
                    xg7Var3 = xg7Var8;
                }
                return new tz0(this.f19916a, xg7Var, xg7Var3, xg7Var2, xg7Var4);
            }
            xg7Var3 = xg7Var8;
            xg7Var4 = xg7Var10;
            return new tz0(this.f19916a, xg7Var, xg7Var3, xg7Var2, xg7Var4);
        }
        xg7Var = xg7Var7;
        xg7Var2 = xg7Var9;
        if (i2 > 0) {
            if (z) {
                xg7Var5 = this.f19918b;
            } else {
                xg7Var5 = this.f19920d;
            }
            iD = ((int) xg7Var5.d()) + i2;
            if (iD >= this.f19916a.o()) {
                iD = this.f19916a.o() - 1;
            }
            xg7Var6 = new xg7(xg7Var5.c(), iD);
            if (z) {
                xg7Var3 = xg7Var6;
            } else {
                xg7Var4 = xg7Var6;
                xg7Var3 = xg7Var8;
            }
            return new tz0(this.f19916a, xg7Var, xg7Var3, xg7Var2, xg7Var4);
        }
        xg7Var3 = xg7Var8;
        xg7Var4 = xg7Var10;
        return new tz0(this.f19916a, xg7Var, xg7Var3, xg7Var2, xg7Var4);
    }

    public xg7 b() {
        return this.f19918b;
    }

    public xg7 c() {
        return this.f19920d;
    }

    public int d() {
        return this.b;
    }

    public int e() {
        return this.d;
    }

    public int f() {
        return this.f45031a;
    }

    public int g() {
        return this.c;
    }

    public xg7 h() {
        return this.f19917a;
    }

    public xg7 i() {
        return this.f19919c;
    }

    public tz0(tz0 tz0Var) {
        this.f19916a = tz0Var.f19916a;
        this.f19917a = tz0Var.f19917a;
        this.f19918b = tz0Var.f19918b;
        this.f19919c = tz0Var.f19919c;
        this.f19920d = tz0Var.f19920d;
        this.f45031a = tz0Var.f45031a;
        this.b = tz0Var.b;
        this.c = tz0Var.c;
        this.d = tz0Var.d;
    }
}
