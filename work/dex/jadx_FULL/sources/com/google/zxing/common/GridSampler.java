package com.google.zxing.common;

import com.google.zxing.NotFoundException;
import com.zj.adlib.hg2;
import com.zj.adlib.tv0;
import com.zj.adlib.yp6;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public abstract class GridSampler {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static GridSampler f32504a = new hg2();

    public static GridSampler a() {
        return f32504a;
    }

    /* JADX WARN: Code duplicated, block: B:18:0x0035  */
    /* JADX WARN: Code duplicated, block: B:20:0x0039 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:21:0x003b  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:55:0x0041 A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:63:0x007e A[SYNTHETIC] */
    public static void checkAndNudgePoints(tv0 tv0Var, float[] fArr) throws NotFoundException {
        int iT = tv0Var.t();
        int iO = tv0Var.o();
        int length = fArr.length - 1;
        boolean z = true;
        for (int i = 0; i < length && z; i += 2) {
            int i2 = (int) fArr[i];
            int i3 = i + 1;
            int i4 = (int) fArr[i3];
            if (i2 < -1 || i2 > iT || i4 < -1 || i4 > iO) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i2 == -1) {
                fArr[i] = 0.0f;
            } else {
                if (i2 == iT) {
                    fArr[i] = iT - 1;
                } else {
                    z = false;
                }
                if (i4 == -1) {
                    fArr[i3] = 0.0f;
                } else {
                    if (i4 == iO) {
                        fArr[i3] = iO - 1;
                    }
                }
                z = true;
            }
            z = true;
            if (i4 == -1) {
                fArr[i3] = 0.0f;
            } else {
                if (i4 == iO) {
                    fArr[i3] = iO - 1;
                }
            }
            z = true;
        }
        boolean z2 = true;
        for (int length2 = fArr.length - 2; length2 >= 0 && z2; length2 -= 2) {
            int i5 = (int) fArr[length2];
            int i6 = length2 + 1;
            int i7 = (int) fArr[i6];
            if (i5 < -1 || i5 > iT || i7 < -1 || i7 > iO) {
                throw NotFoundException.getNotFoundInstance();
            }
            if (i5 == -1) {
                fArr[length2] = 0.0f;
            } else {
                if (i5 == iT) {
                    fArr[length2] = iT - 1;
                } else {
                    z2 = false;
                }
                if (i7 == -1) {
                    fArr[i6] = 0.0f;
                } else {
                    if (i7 == iO) {
                        fArr[i6] = iO - 1;
                    }
                }
                z2 = true;
            }
            z2 = true;
            if (i7 == -1) {
                fArr[i6] = 0.0f;
            } else {
                if (i7 == iO) {
                    fArr[i6] = iO - 1;
                }
            }
            z2 = true;
        }
    }

    public static void d(GridSampler gridSampler) {
        f32504a = gridSampler;
    }

    public abstract tv0 b(tv0 tv0Var, int i, int i2, float f, float f2, float f3, float f4, float f5, float f6, float f7, float f8, float f9, float f10, float f11, float f12, float f13, float f14, float f15, float f16) throws NotFoundException;

    public abstract tv0 c(tv0 tv0Var, int i, int i2, yp6 yp6Var) throws NotFoundException;
}
