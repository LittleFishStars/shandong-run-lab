package com.zj.adlib;

import com.facebook.common.internal.VisibleForTesting;
import com.facebook.imageformat.ImageFormat;
import com.facebook.imagepipeline.request.ImageRequest;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ar2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final float f40592a = 2048.0f;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public static final int f15344a = 1;
    public static final float b = 0.33333334f;

    @VisibleForTesting
    public static float a(ImageRequest imageRequest, q13 q13Var) {
        ax6.d(q13.E(q13Var));
        sf7 sf7VarM = imageRequest.m();
        if (sf7VarM == null || sf7VarM.b <= 0 || sf7VarM.f44682a <= 0 || q13Var.getWidth() == 0 || q13Var.getHeight() == 0) {
            return 1.0f;
        }
        int iC = c(imageRequest, q13Var);
        boolean z = iC == 90 || iC == 270;
        int height = z ? q13Var.getHeight() : q13Var.getWidth();
        int width = z ? q13Var.getWidth() : q13Var.getHeight();
        float f = sf7VarM.f44682a / height;
        float f2 = sf7VarM.b / width;
        float fMax = Math.max(f, f2);
        ad3.i0("DownsampleUtil", "Downsample - Specified size: %dx%d, image size: %dx%d ratio: %.1f x %.1f, ratio: %.3f for %s", Integer.valueOf(sf7VarM.f44682a), Integer.valueOf(sf7VarM.b), Integer.valueOf(height), Integer.valueOf(width), Float.valueOf(f), Float.valueOf(f2), Float.valueOf(fMax), imageRequest.o().toString());
        return fMax;
    }

    public static int b(ImageRequest imageRequest, q13 q13Var) {
        if (!q13.E(q13Var)) {
            return 1;
        }
        float fA = a(imageRequest, q13Var);
        int iE = q13Var.p() == ImageFormat.JPEG ? e(fA) : d(fA);
        int iMax = Math.max(q13Var.getHeight(), q13Var.getWidth());
        while (iMax / iE > 2048.0f) {
            iE = q13Var.p() == ImageFormat.JPEG ? iE * 2 : iE + 1;
        }
        return iE;
    }

    public static int c(ImageRequest imageRequest, q13 q13Var) {
        if (!imageRequest.c()) {
            return 0;
        }
        int iR = q13Var.r();
        ax6.d(iR == 0 || iR == 90 || iR == 180 || iR == 270);
        return iR;
    }

    @VisibleForTesting
    public static int d(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (true) {
            double d = i;
            if ((1.0d / d) + ((1.0d / (Math.pow(d, 2.0d) - d)) * 0.3333333432674408d) <= f) {
                return i - 1;
            }
            i++;
        }
    }

    @VisibleForTesting
    public static int e(float f) {
        if (f > 0.6666667f) {
            return 1;
        }
        int i = 2;
        while (true) {
            int i2 = i * 2;
            double d = 1.0d / ((double) i2);
            if (d + (0.3333333432674408d * d) <= f) {
                return i;
            }
            i = i2;
        }
    }

    @VisibleForTesting
    public static int f(int i) {
        int i2 = 1;
        while (i2 < i) {
            i2 *= 2;
        }
        return i2;
    }
}
