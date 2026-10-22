package com.alibaba.ariver.kernel.common.utils;

import android.content.Context;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class DimensionUtil {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f24275a = "AriverKernel:DimensionUtil";
    private static float b;
    private static float c;
    private static int d;
    private static int e;

    private static void a(Context context) {
        try {
            if (b == 0.0f) {
                b = context.getResources().getDisplayMetrics().density;
            }
        } catch (Throwable th) {
            RVLogger.e(f24275a, th);
        }
    }

    private static void b(Context context) {
        try {
            if (c == 0.0f) {
                c = context.getResources().getDisplayMetrics().scaledDensity;
            }
        } catch (Throwable th) {
            RVLogger.e(f24275a, th);
        }
    }

    public static int dip2px(Context context, float f) {
        a(context);
        return (int) ((f * b) + 0.5f);
    }

    public static float getDensity(Context context) {
        a(context);
        return b;
    }

    public static float getFontSize(float f) {
        if (f == 0.875f) {
            return 14.0f;
        }
        if (f == 1.0f) {
            return 16.0f;
        }
        if (f == 1.125f) {
            return 18.0f;
        }
        if (f == 1.25f) {
            return 20.0f;
        }
        return f == 1.375f ? 22.0f : 16.0f;
    }

    public static int getRelativeLeft(View view) {
        return view.getId() == 16908290 ? view.getLeft() : view.getLeft() + getRelativeLeft((View) view.getParent());
    }

    public static int getRelativeTop(View view) {
        return view.getId() == 16908290 ? view.getTop() : view.getTop() + getRelativeTop((View) view.getParent());
    }

    public static int getScreenHeight(Context context) {
        int i = d;
        if (i != 0) {
            return i;
        }
        int height = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getHeight();
        d = height;
        return height;
    }

    public static int getScreenWidth(Context context) {
        int i = e;
        if (i != 0) {
            return i;
        }
        int width = ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getWidth();
        e = width;
        return width;
    }

    public static boolean isValueEqule(float f, float f2) {
        return ((int) f) == ((int) f2);
    }

    public static int px2dip(Context context, float f) {
        a(context);
        return (int) ((f / b) + 0.5f);
    }

    public static float px2sp(Context context, float f) {
        b(context);
        return f / c;
    }

    public static void resetDimensions() {
        e = 0;
        d = 0;
        c = 0.0f;
        b = 0.0f;
    }

    public static int sp2px(Context context, float f) {
        b(context);
        return (int) ((f * c) + 0.5f);
    }
}
