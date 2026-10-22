package com.bwt.top.util;

import android.app.Activity;
import android.content.Context;
import android.util.DisplayMetrics;
import com.bwt.top.AdSdk;
import com.gyf.immersionbar.b;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class DisplayUtil {
    public static boolean activityIsLandscape(Context context) {
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        int requestedOrientation = ((Activity) context).getRequestedOrientation();
        return (requestedOrientation == 0 || requestedOrientation == 8 || requestedOrientation == 6) || context.getResources().getConfiguration().orientation == 2;
    }

    public static boolean activityIsPortrait(Context context) {
        if (context == null || !(context instanceof Activity)) {
            return false;
        }
        int requestedOrientation = ((Activity) context).getRequestedOrientation();
        return requestedOrientation == 1 || requestedOrientation == 9 || requestedOrientation == 7;
    }

    public static int dp2px(int i) {
        return (int) (AdSdk.getInstance().getDensity() * i);
    }

    public static int getStatusBarHeight(Context context) {
        int dimensionPixelSize;
        try {
            int identifier = context.getResources().getIdentifier(b.f6802a, "dimen", "android");
            dimensionPixelSize = identifier > 0 ? context.getResources().getDimensionPixelSize(identifier) : 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dimensionPixelSize <= 0 ? (int) (context.getResources().getDisplayMetrics().density * 24.0f) : dimensionPixelSize;
    }

    public static int px2dp(int i) {
        return (int) (i / Math.max(1.0f, AdSdk.getInstance().getDensity()));
    }

    public static int screenHeight(Context context) {
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static float screenSize(Context context) {
        DisplayMetrics displayMetrics = context.getResources().getDisplayMetrics();
        return (float) Math.sqrt(Math.pow(displayMetrics.widthPixels / displayMetrics.xdpi, 2.0d) + Math.pow(displayMetrics.heightPixels / displayMetrics.ydpi, 2.0d));
    }

    public static int screenWidth(Context context) {
        return context.getResources().getDisplayMetrics().widthPixels;
    }
}
