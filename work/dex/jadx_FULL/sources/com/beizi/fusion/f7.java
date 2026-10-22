package com.beizi.fusion;

import android.view.View;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class f7 {
    public static int[] a(int i, int i2) {
        int[] iArr = new int[2];
        boolean z = false;
        while (!z) {
            double dRint = Math.rint(b(0, (int) (((double) (i * 2)) * 0.95d)));
            double dRint2 = Math.rint(b(0, (int) (((double) (i2 * 2)) * 0.95d)));
            double d = i;
            double d2 = i2;
            if (a(d, d2, dRint, dRint2, d * 0.9d, d2 * 0.9d) <= 1.0d) {
                iArr[0] = (int) dRint;
                iArr[1] = (int) dRint2;
                z = true;
            }
        }
        return iArr;
    }

    private static int b(int i, int i2) {
        return (int) ((Math.random() * ((double) (i2 - i))) + ((double) i));
    }

    public static int[] a(View view) {
        return a(view.getWidth() / 2, view.getHeight() / 2);
    }

    private static double a(double d, double d2, double d3, double d4, double d5, double d6) {
        return (Math.pow(d3 - d, 2.0d) / Math.pow(d5, 2.0d)) + (Math.pow(d4 - d2, 2.0d) / Math.pow(d6, 2.0d));
    }
}
