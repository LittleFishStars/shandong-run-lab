package com.beizi.fusion;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Rect;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.WindowManager;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class gn {

    public static class a {
        public static int a(Context context, float f) {
            float fA = gn.a(context);
            if (fA > 0.0f) {
                return (int) ((f * fA) + 0.5f);
            }
            return 0;
        }

        public static int b(Context context, float f) {
            float fA = gn.a(context);
            if (fA > 0.0f) {
                return (int) ((f / fA) + 0.5f);
            }
            return 0;
        }

        public static boolean a(View view, int i) {
            if (view == null) {
                return false;
            }
            view.getLocationOnScreen(new int[2]);
            if (view.getVisibility() == 0 && view.getParent() != null && view.hasWindowFocus()) {
                Rect rect = new Rect();
                if (!view.getGlobalVisibleRect(rect)) {
                    return false;
                }
                int iHeight = rect.height() * rect.width();
                int height = view.getHeight() * view.getWidth();
                if (height > 0 && iHeight * 100 >= i * height) {
                    return true;
                }
            }
            return false;
        }
    }

    public static float a(Context context) {
        if (context == null) {
            return 0.0f;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || windowManager.getDefaultDisplay() == null) {
            return 0.0f;
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    public static int b(Context context) {
        if (context == null) {
            return 0;
        }
        DisplayMetrics displayMetrics = new DisplayMetrics();
        WindowManager windowManager = (WindowManager) context.getSystemService("window");
        if (windowManager == null || windowManager.getDefaultDisplay() == null) {
            return 0;
        }
        windowManager.getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.densityDpi;
    }

    public static int c(Context context) {
        Configuration configuration;
        if (context == null || context.getResources() == null || (configuration = context.getResources().getConfiguration()) == null) {
            return 0;
        }
        return configuration.orientation;
    }

    public static int d(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.heightPixels;
    }

    public static int e(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return a.b(context, displayMetrics.heightPixels);
    }

    public static int f(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return displayMetrics.widthPixels;
    }

    public static int g(Context context) {
        DisplayMetrics displayMetrics;
        if (context == null || context.getResources() == null || (displayMetrics = context.getResources().getDisplayMetrics()) == null) {
            return 0;
        }
        return a.b(context, displayMetrics.widthPixels);
    }
}
