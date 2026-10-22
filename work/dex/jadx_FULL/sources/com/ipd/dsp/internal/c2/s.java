package com.ipd.dsp.internal.c2;

import android.content.Context;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.view.WindowManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class s {
    public static float a(float f, float f2) {
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (f2 * f) + 0.5f;
    }

    public static float a(Context context, float f) {
        float fB = b(context);
        if (fB <= 0.0f) {
            fB = 1.0f;
        }
        return (f * fB) + 0.5f;
    }

    public static float b(float f, float f2) {
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (int) ((f2 / f) + 0.5f);
    }

    public static float b(Context context, float f) {
        float fB = b(context);
        if (fB <= 0.0f) {
            fB = 1.0f;
        }
        return (int) ((f / fB) + 0.5f);
    }

    public static Pair<Float, Float> c(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        float f = displayMetrics.density;
        return new Pair<>(Float.valueOf(b(f, displayMetrics.widthPixels)), Float.valueOf(b(f, displayMetrics.heightPixels)));
    }

    public static Pair<Integer, Integer> d(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return new Pair<>(Integer.valueOf(displayMetrics.widthPixels), Integer.valueOf(displayMetrics.heightPixels));
    }

    public static int a(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static float b(Context context) {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        ((WindowManager) context.getSystemService("window")).getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }
}
