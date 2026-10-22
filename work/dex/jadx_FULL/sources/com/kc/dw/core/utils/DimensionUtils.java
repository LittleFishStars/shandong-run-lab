package com.kc.dw.core.utils;

import android.content.Context;
import android.util.DisplayMetrics;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class DimensionUtils {
    public static float dip2px(Context context, float f) {
        return f * context.getResources().getDisplayMetrics().density;
    }

    public static int getSplashDesignHeight(Context context) {
        try {
            DisplayMetrics displayMetricsN = w0.n(context);
            return (int) Math.min(((double) displayMetricsN.widthPixels) / 0.46d, displayMetricsN.heightPixels);
        } catch (Throwable th) {
            th.printStackTrace();
            return 0;
        }
    }

    public static float px2dip(Context context, float f) {
        return f / context.getResources().getDisplayMetrics().density;
    }

    public static float px2sp(Context context, float f) {
        return (f / context.getResources().getDisplayMetrics().scaledDensity) + 0.5f;
    }

    public static float sp2px(Context context, float f) {
        return (f * context.getResources().getDisplayMetrics().scaledDensity) + 0.5f;
    }
}
