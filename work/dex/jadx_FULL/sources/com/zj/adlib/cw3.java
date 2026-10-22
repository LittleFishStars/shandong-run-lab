package com.zj.adlib;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class cw3 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final float[] f41053a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final int[] f15898a;

    public cw3(float[] fArr, int[] iArr) {
        this.f41053a = fArr;
        this.f15898a = iArr;
    }

    public int[] a() {
        return this.f15898a;
    }

    public float[] b() {
        return this.f41053a;
    }

    public int c() {
        return this.f15898a.length;
    }

    public void d(cw3 cw3Var, cw3 cw3Var2, float f) {
        if (cw3Var.f15898a.length == cw3Var2.f15898a.length) {
            for (int i = 0; i < cw3Var.f15898a.length; i++) {
                this.f41053a[i] = up5.k(cw3Var.f41053a[i], cw3Var2.f41053a[i], f);
                this.f15898a[i] = bs3.c(f, cw3Var.f15898a[i], cw3Var2.f15898a[i]);
            }
            return;
        }
        throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cw3Var.f15898a.length + " vs " + cw3Var2.f15898a.length + ")");
    }
}
