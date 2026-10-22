package com.zj.adlib;

import android.opengl.Matrix;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public final class em3 {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16352a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final float[] f16353a = new float[16];
    public final float[] b = new float[16];

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final x79<float[]> f41468a = new x79<>();

    public static void a(float[] fArr, float[] fArr2) {
        Matrix.setIdentityM(fArr, 0);
        float f = fArr2[10];
        float f2 = fArr2[8];
        float fSqrt = (float) Math.sqrt((f * f) + (f2 * f2));
        float f3 = fArr2[10];
        fArr[0] = f3 / fSqrt;
        float f4 = fArr2[8];
        fArr[2] = f4 / fSqrt;
        fArr[8] = (-f4) / fSqrt;
        fArr[10] = f3 / fSqrt;
    }

    public static void b(float[] fArr, float[] fArr2) {
        float f = fArr2[0];
        float f2 = -fArr2[1];
        float f3 = -fArr2[2];
        float length = Matrix.length(f, f2, f3);
        if (length != 0.0f) {
            Matrix.setRotateM(fArr, 0, (float) Math.toDegrees(length), f / length, f2 / length, f3 / length);
        } else {
            Matrix.setIdentityM(fArr, 0);
        }
    }

    public boolean c(float[] fArr, long j) {
        float[] fArrJ = this.f41468a.j(j);
        if (fArrJ == null) {
            return false;
        }
        b(this.b, fArrJ);
        if (!this.f16352a) {
            a(this.f16353a, this.b);
            this.f16352a = true;
        }
        Matrix.multiplyMM(fArr, 0, this.f16353a, 0, this.b, 0);
        return true;
    }

    public void d() {
        this.f41468a.c();
        this.f16352a = false;
    }

    public void e(long j, float[] fArr) {
        this.f41468a.a(j, fArr);
    }
}
