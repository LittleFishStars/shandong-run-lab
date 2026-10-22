package com.huachenjie.common.widget.xScrollView;

import android.R;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
import com.acse.ottn.p3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class XScrollViewUtils {
    static final String IMMERSION_EMUI_NAVIGATION_BAR_HIDE_SHOW = "navigationbar_is_min";
    static final String IMMERSION_MIUI_NAVIGATION_BAR_HIDE_SHOW = "force_fsg_nav_bar";
    static final String IMMERSION_NAVIGATION_BAR_HEIGHT = "navigation_bar_height";
    static final String IMMERSION_NAVIGATION_BAR_HEIGHT_LANDSCAPE = "navigation_bar_height_landscape";
    static final String IMMERSION_STATUS_BAR_HEIGHT = "status_bar_height";
    private static final String KEY_EMUI_VERSION_NAME = "ro.build.version.emui";

    public static int dip2px(Context context, float dpValue) {
        return (int) ((dpValue * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static DisplayMetrics getDpi(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        try {
            Class.forName("android.view.Display").getMethod("getRealMetrics", DisplayMetrics.class).invoke(defaultDisplay, displayMetrics);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return displayMetrics;
    }

    private static String getEMUIVersion() {
        return isEMUI() ? getSystemProperty("ro.build.version.emui", "") : "";
    }

    public static int getNavigationBarHeight(Context context) {
        if (hasNavBar((Activity) context)) {
            return getStatusBarHeight(context, context.getResources().getConfiguration().orientation == 1 ? "navigation_bar_height" : "navigation_bar_height_landscape");
        }
        return 0;
    }

    public static int getNavigationHeight(Context activity) {
        Activity activity2 = (Activity) activity;
        if (isNavigationBarShow(activity2)) {
            return getNavigationBarHeight(activity2);
        }
        return 0;
    }

    public static int getStatusBarHeight(Context context) {
        return getStatusBarHeight(context, "status_bar_height");
    }

    private static String getSystemProperty(String key, String defaultValue) {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return (String) cls.getMethod(p3.f, String.class, String.class).invoke(cls, key, defaultValue);
        } catch (Exception e) {
            e.printStackTrace();
            return defaultValue;
        }
    }

    private static boolean hasNavBar(Activity activity) {
        if (Settings.Global.getInt(activity.getContentResolver(), "force_fsg_nav_bar", 0) != 0) {
            return false;
        }
        if (isEMUI()) {
            if (isEMUI3_x()) {
                if (Settings.System.getInt(activity.getContentResolver(), "navigationbar_is_min", 0) != 0) {
                    return false;
                }
            } else if (Settings.Global.getInt(activity.getContentResolver(), "navigationbar_is_min", 0) != 0) {
                return false;
            }
        }
        Display defaultDisplay = activity.getWindowManager().getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        int i = displayMetrics.heightPixels;
        int i2 = displayMetrics.widthPixels;
        DisplayMetrics displayMetrics2 = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics2);
        return i2 - displayMetrics2.widthPixels > 0 || i - displayMetrics2.heightPixels > 0;
    }

    private static boolean isEMUI() {
        return !TextUtils.isEmpty(getSystemProperty("ro.build.version.emui", ""));
    }

    private static boolean isEMUI3_0() {
        return getEMUIVersion().contains("EmotionUI_3.0");
    }

    private static boolean isEMUI3_1() {
        String eMUIVersion = getEMUIVersion();
        return "EmotionUI 3".equals(eMUIVersion) || eMUIVersion.contains("EmotionUI_3.1");
    }

    private static boolean isEMUI3_x() {
        return isEMUI3_0() || isEMUI3_1();
    }

    public static boolean isNavigationBarShow(Activity activity) {
        int visibility;
        View viewFindViewById = activity.findViewById(R.id.navigationBarBackground);
        return (viewFindViewById == null || (visibility = viewFindViewById.getVisibility()) == 8 || visibility == 4) ? false : true;
    }

    public static int getStatusBarHeight(Context context, String key) {
        try {
            int identifier = Resources.getSystem().getIdentifier(key, "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = context.getResources().getDimensionPixelSize(identifier);
                int dimensionPixelSize2 = Resources.getSystem().getDimensionPixelSize(identifier);
                if (dimensionPixelSize2 >= dimensionPixelSize) {
                    return dimensionPixelSize2;
                }
                float f = (dimensionPixelSize * Resources.getSystem().getDisplayMetrics().density) / context.getResources().getDisplayMetrics().density;
                return (int) (f >= 0.0f ? f + 0.5f : f - 0.5f);
            }
        } catch (Resources.NotFoundException unused) {
        }
        return 0;
    }
}
