package com.alibaba.triver.kit.api.utils;

import android.app.Activity;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.alibaba.ariver.app.api.activity.StartClientBundle;
import com.alibaba.ariver.kernel.RVConstants;
import com.alibaba.ariver.kernel.RVStartParams;
import com.alibaba.ariver.kernel.common.utils.BundleUtils;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.gyf.immersionbar.b;
import com.zj.adlib.xd9;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class StatusBarUtils {
    private static boolean changeMeizuFlag(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        try {
            Field declaredField = layoutParams.getClass().getDeclaredField(str);
            declaredField.setAccessible(true);
            int i = declaredField.getInt(layoutParams);
            Field declaredField2 = layoutParams.getClass().getDeclaredField("meizuFlags");
            declaredField2.setAccessible(true);
            int i2 = declaredField2.getInt(layoutParams);
            int i3 = z ? i | i2 : (~i) & i2;
            if (i2 == i3) {
                return false;
            }
            declaredField2.setInt(layoutParams, i3);
            return true;
        } catch (Throwable th) {
            RVLogger.w(Log.getStackTraceString(th));
            return false;
        }
    }

    public static boolean changeStyle(Activity activity, boolean z) {
        StartClientBundle startClientBundle;
        if (!BundleUtils.getBoolean((activity == null || activity.getIntent() == null || (startClientBundle = (StartClientBundle) BundleUtils.getParcelable(activity.getIntent().getExtras(), RVConstants.EXTRA_ARIVER_START_BUNDLE)) == null) ? null : startClientBundle.startParams, RVStartParams.KEY_SUPPORT_STATUS_BAR, true) || !com.alibaba.ariver.app.api.ui.StatusBarUtils.isConfigSupport()) {
            return false;
        }
        Window window = activity.getWindow();
        if (z) {
            window.clearFlags(201326592);
            window.getDecorView().setSystemUiVisibility(9472);
            window.addFlags(Integer.MIN_VALUE);
        } else {
            window.clearFlags(201334784);
            window.getDecorView().setSystemUiVisibility(1280);
            window.addFlags(Integer.MIN_VALUE);
        }
        window.setStatusBarColor(0);
        if (isMIUIDevice()) {
            miuiSetStatusBarLightMode(activity, z);
        } else if (isMeizuDevice()) {
            setStatusBarDarkIcon(activity, z);
        }
        return true;
    }

    private static boolean isBlackColor(int i, int i2) {
        return toGrey(i) < i2;
    }

    private static boolean isLollipop() {
        return true;
    }

    private static boolean isMIUIDevice() {
        return "Xiaomi".equals(Build.MANUFACTURER);
    }

    private static boolean isMeizuDevice() {
        return "Meizu".endsWith(Build.MANUFACTURER);
    }

    private static boolean miuiSetStatusBarLightMode(Activity activity, boolean z) {
        if (activity == null) {
            return false;
        }
        try {
            Window window = activity.getWindow();
            Class<?> cls = Class.forName("android.view.MiuiWindowManager$LayoutParams");
            int i = cls.getField(b.o).getInt(cls);
            Class<?> cls2 = window.getClass();
            Class<?> cls3 = Integer.TYPE;
            Method method = cls2.getMethod("setExtraFlags", cls3, cls3);
            if (z) {
                method.invoke(window, Integer.valueOf(i), Integer.valueOf(i));
            } else {
                method.invoke(window, 0, Integer.valueOf(i));
            }
            return true;
        } catch (Exception e) {
            RVLogger.w(Log.getStackTraceString(e));
            return false;
        }
    }

    private static void setStatusBarDarkIcon(Activity activity, boolean z) {
        setStatusBarDarkIcon(activity, z, true);
    }

    private static int toGrey(int i) {
        return (((((i & xd9.p) >> 16) * 38) + (((65280 & i) >> 8) * 75)) + ((i & 255) * 15)) >> 7;
    }

    private static void setStatusBarDarkIcon(View view, boolean z) {
        try {
            int i = View.class.getField("SYSTEM_UI_FLAG_LIGHT_STATUS_BAR").getInt(null);
            int systemUiVisibility = view.getSystemUiVisibility();
            int i2 = z ? systemUiVisibility | i : (~i) & systemUiVisibility;
            if (i2 != systemUiVisibility) {
                view.setSystemUiVisibility(i2);
            }
        } catch (IllegalAccessException e) {
            RVLogger.w(Log.getStackTraceString(e));
        } catch (NoSuchFieldException e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        }
    }

    private static void setStatusBarDarkIcon(Window window, boolean z) {
        if (!isLollipop()) {
            changeMeizuFlag(window.getAttributes(), "MEIZU_FLAG_DARK_STATUS_BAR_ICON", z);
            return;
        }
        View decorView = window.getDecorView();
        if (decorView != null) {
            setStatusBarDarkIcon(decorView, z);
        }
    }

    private static void setStatusBarDarkIcon(Activity activity, boolean z, boolean z2) {
        if (activity == null) {
            return;
        }
        try {
            Method method = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
            if (method != null) {
                method.invoke(activity, Boolean.valueOf(z));
            } else if (z2) {
                setStatusBarDarkIcon(activity.getWindow(), z);
            }
        } catch (IllegalAccessException e) {
            RVLogger.w(Log.getStackTraceString(e));
        } catch (NoSuchMethodException e2) {
            RVLogger.w(Log.getStackTraceString(e2));
        } catch (InvocationTargetException e3) {
            RVLogger.w(Log.getStackTraceString(e3));
        }
    }
}
