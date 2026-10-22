package com.kc.aw.lib.utils.dev;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Point;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.WindowManager;
import com.gyf.immersionbar.b;
import com.kc.aw.lib.PtgAdSdk;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ScreenUtils {
    public static boolean GUBED;
    private static float hdpi;
    private static int screenRealHeigh;
    private static int screenRealWidth;
    private static float wdpi;

    public static int dp2px(float f) {
        return dp2px(null, f);
    }

    public static int dp2px(Context context, float f) {
        return (int) (((getResources(context).getDisplayMetrics().densityDpi / 160.0f) * f) + 0.5f);
    }

    public static int dpToPx(Context context, float f) {
        return (int) TypedValue.applyDimension(1, f, context.getResources().getDisplayMetrics());
    }

    public static float getDensity() {
        try {
            if (PtgAdSdk.getContext() != null) {
                return PtgAdSdk.getContext().getResources().getDisplayMetrics().density;
            }
            return 0.0f;
        } catch (Exception unused) {
            return 0.0f;
        }
    }

    public static int getDensityDpi() {
        try {
            if (PtgAdSdk.getContext() != null) {
                return PtgAdSdk.getContext().getResources().getDisplayMetrics().densityDpi;
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    public static float getHdpi(Context context) {
        float f = hdpi;
        if (f > 0.0f) {
            return f;
        }
        if (context == null) {
            return 0.0f;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        float f2 = displayMetrics.ydpi;
        hdpi = f2;
        return f2;
    }

    public static Resources getResources(Context context) {
        return context == null ? Resources.getSystem() : context.getResources();
    }

    public static int getScreenHeight(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    public static float getScreenHeightDp(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().heightPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (f2 / f) + 0.5f;
    }

    public static int getScreenRealHeight(Context context) {
        int i = screenRealHeigh;
        if (i > 0) {
            return i;
        }
        if (context == null) {
            return 0;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        int i2 = point.y;
        screenRealHeigh = i2;
        return i2;
    }

    public static int getScreenRealWidth(Context context) {
        int i = screenRealWidth;
        if (i > 0) {
            return i;
        }
        if (context == null) {
            return 0;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        Point point = new Point();
        defaultDisplay.getRealSize(point);
        int i2 = point.x;
        screenRealWidth = i2;
        return i2;
    }

    public static int getScreenWidth(Context context) {
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        DisplayMetrics displayMetrics = new DisplayMetrics();
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.widthPixels;
    }

    public static float getScreenWidthDp(Context context) {
        float f = context.getResources().getDisplayMetrics().density;
        float f2 = context.getResources().getDisplayMetrics().widthPixels;
        if (f <= 0.0f) {
            f = 1.0f;
        }
        return (f2 / f) + 0.5f;
    }

    public static int getStatusBarHeight(Context context) {
        try {
            Class<?> cls = Class.forName("com.android.internal.R$dimen");
            return context.getResources().getDimensionPixelSize(Integer.parseInt(cls.getField(b.f6802a).get(cls.newInstance()).toString()));
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static float getWdpi(Context context) {
        float f = wdpi;
        if (f > 0.0f) {
            return f;
        }
        if (context == null) {
            return 0.0f;
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        float f2 = displayMetrics.xdpi;
        wdpi = f2;
        return f2;
    }

    public static float px2dp(float f) {
        return px2dp(null, f);
    }

    public static float px2dp(Context context, float f) {
        return (f * 160.0f) / getResources(context).getDisplayMetrics().densityDpi;
    }
}
