package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class n69 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f43462a = 1.3333334f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f18364a = 90;
    public static final int b = 270;

    public static int a(int i) {
        return (int) (i * 1.3333334f);
    }

    public static boolean b(int i, int i2, sf7 sf7Var) {
        if (sf7Var == null) {
            return ((float) a(i)) >= 2048.0f && a(i2) >= 2048;
        }
        return a(i) >= sf7Var.f44682a && a(i2) >= sf7Var.b;
    }

    public static boolean c(q13 q13Var, sf7 sf7Var) {
        if (q13Var == null) {
            return false;
        }
        int iR = q13Var.r();
        return (iR == 90 || iR == 270) ? b(q13Var.getHeight(), q13Var.getWidth(), sf7Var) : b(q13Var.getWidth(), q13Var.getHeight(), sf7Var);
    }
}
