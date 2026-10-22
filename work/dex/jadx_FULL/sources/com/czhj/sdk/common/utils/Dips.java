package com.czhj.sdk.common.utils;

import android.content.Context;
import android.util.TypedValue;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class Dips {
    private static float a(float f, Context context) {
        return f / getDensity(context);
    }

    public static int asIntPixels(float f, Context context) {
        if (f == 0.0f || context == null) {
            return 0;
        }
        return (int) (c(f, context) + 0.5f);
    }

    private static float b(float f, Context context) {
        return f * getDensity(context);
    }

    private static float c(float f, Context context) {
        return TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static int dipsToIntPixels(float f, Context context) {
        if (f == 0.0f || context == null) {
            return 0;
        }
        return (int) (b(f, context) + 0.5f);
    }

    public static float getDensity(Context context) {
        return context.getResources().getDisplayMetrics().density;
    }

    public static int pixelsToIntDips(float f, Context context) {
        if (f == 0.0f || context == null) {
            return 0;
        }
        return (int) (a(f, context) + 0.5f);
    }

    public static int screenHeightAsIntDips(Context context) {
        if (context == null) {
            return 0;
        }
        return pixelsToIntDips(context.getResources().getDisplayMetrics().heightPixels, context);
    }

    public static int screenWidthAsIntDips(Context context) {
        if (context == null) {
            return 0;
        }
        return pixelsToIntDips(context.getResources().getDisplayMetrics().widthPixels, context);
    }
}
