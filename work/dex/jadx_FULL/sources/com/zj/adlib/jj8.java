package com.zj.adlib;

import android.content.Context;
import android.content.res.Resources;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class jj8 {
    public static int a(float dipValue) {
        return (int) ((dipValue * Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static final int b(float dp, Context context) {
        return (int) ((dp * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static final float c(int px, Context context) {
        return px / context.getResources().getDisplayMetrics().density;
    }

    public static float d(int pxValue) {
        return (int) ((pxValue / Resources.getSystem().getDisplayMetrics().density) + 0.5f);
    }

    public static int e(float spValue, Context context) {
        return (int) ((spValue * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f);
    }

    public static int f(float dipValue) {
        return (int) ((dipValue * Resources.getSystem().getDisplayMetrics().scaledDensity) + 0.5f);
    }
}
