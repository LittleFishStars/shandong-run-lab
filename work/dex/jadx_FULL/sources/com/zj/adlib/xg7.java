package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class xg7 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float f45819a;
    public final float b;

    public xg7(float f, float f2) {
        this.f45819a = f;
        this.b = f2;
    }

    public static float a(xg7 xg7Var, xg7 xg7Var2, xg7 xg7Var3) {
        float f = xg7Var2.f45819a;
        float f2 = xg7Var2.b;
        return ((xg7Var3.f45819a - f) * (xg7Var.b - f2)) - ((xg7Var3.b - f2) * (xg7Var.f45819a - f));
    }

    public static float b(xg7 xg7Var, xg7 xg7Var2) {
        return se5.a(xg7Var.f45819a, xg7Var.b, xg7Var2.f45819a, xg7Var2.b);
    }

    public static void e(xg7[] xg7VarArr) {
        xg7 xg7Var;
        xg7 xg7Var2;
        xg7 xg7Var3;
        float fB = b(xg7VarArr[0], xg7VarArr[1]);
        float fB2 = b(xg7VarArr[1], xg7VarArr[2]);
        float fB3 = b(xg7VarArr[0], xg7VarArr[2]);
        if (fB2 >= fB && fB2 >= fB3) {
            xg7Var = xg7VarArr[0];
            xg7Var2 = xg7VarArr[1];
            xg7Var3 = xg7VarArr[2];
        } else if (fB3 < fB2 || fB3 < fB) {
            xg7Var = xg7VarArr[2];
            xg7Var2 = xg7VarArr[0];
            xg7Var3 = xg7VarArr[1];
        } else {
            xg7Var = xg7VarArr[1];
            xg7Var2 = xg7VarArr[0];
            xg7Var3 = xg7VarArr[2];
        }
        if (a(xg7Var2, xg7Var, xg7Var3) < 0.0f) {
            xg7 xg7Var4 = xg7Var3;
            xg7Var3 = xg7Var2;
            xg7Var2 = xg7Var4;
        }
        xg7VarArr[0] = xg7Var2;
        xg7VarArr[1] = xg7Var;
        xg7VarArr[2] = xg7Var3;
    }

    public final float c() {
        return this.f45819a;
    }

    public final float d() {
        return this.b;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof xg7)) {
            return false;
        }
        xg7 xg7Var = (xg7) obj;
        return this.f45819a == xg7Var.f45819a && this.b == xg7Var.b;
    }

    public final int hashCode() {
        return (Float.floatToIntBits(this.f45819a) * 31) + Float.floatToIntBits(this.b);
    }

    public final String toString() {
        return "(" + this.f45819a + ',' + this.b + ')';
    }
}
