package com.zj.adlib;

import com.google.zxing.NotFoundException;
import com.google.zxing.common.GridSampler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public final class hg2 extends GridSampler {
    @Override // com.google.zxing.common.GridSampler
    public tv0 b(tv0 tv0Var, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws NotFoundException {
        return c(tv0Var, i, i2, yp6.b(f, f2, f3, f4, f5, f6, f7, f8, f9, f10, f11, f12, f13, f14, f15, f16));
    }

    @Override // com.google.zxing.common.GridSampler
    public tv0 c(tv0 tv0Var, int i, int i2, yp6 yp6Var) throws NotFoundException {
        if (i <= 0 || i2 <= 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        tv0 tv0Var2 = new tv0(i, i2);
        int i3 = i * 2;
        float[] fArr = new float[i3];
        for (int i4 = 0; i4 < i2; i4++) {
            float f = i4 + 0.5f;
            for (int i5 = 0; i5 < i3; i5 += 2) {
                fArr[i5] = (i5 / 2) + 0.5f;
                fArr[i5 + 1] = f;
            }
            yp6Var.f(fArr);
            GridSampler.checkAndNudgePoints(tv0Var, fArr);
            for (int i6 = 0; i6 < i3; i6 += 2) {
                try {
                    if (tv0Var.k((int) fArr[i6], (int) fArr[i6 + 1])) {
                        tv0Var2.z(i6 / 2, i4);
                    }
                } catch (ArrayIndexOutOfBoundsException unused) {
                    throw NotFoundException.getNotFoundInstance();
                }
            }
        }
        return tv0Var2;
    }
}
