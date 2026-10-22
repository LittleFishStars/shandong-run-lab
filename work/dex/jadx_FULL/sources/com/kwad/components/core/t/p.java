package com.kwad.components.core.t;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.kwad.sdk.utils.ab;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class p {
    private static int SYSTEM_UI_FLAG_LIGHT_STATUS_BAR;
    private static Method alP;
    private static Method alQ;
    private static Field alR;

    static {
        try {
            alP = Activity.class.getMethod("setStatusBarDarkIcon", Integer.TYPE);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        try {
            alQ = Activity.class.getMethod("setStatusBarDarkIcon", Boolean.TYPE);
        } catch (NoSuchMethodException e2) {
            e2.printStackTrace();
        }
        try {
            alR = WindowManager.LayoutParams.class.getField("statusBarColor");
        } catch (NoSuchFieldException e3) {
            e3.printStackTrace();
        }
        try {
            SYSTEM_UI_FLAG_LIGHT_STATUS_BAR = ((Integer) ab.c(View.class, "SYSTEM_UI_FLAG_LIGHT_STATUS_BAR")).intValue();
        } catch (Exception e4) {
            e4.printStackTrace();
        }
    }

    private static boolean a(WindowManager.LayoutParams layoutParams, String str, boolean z) {
        try {
            int iIntValue = ((Integer) ab.getField(layoutParams, str)).intValue();
            int iIntValue2 = ((Integer) ab.getField(layoutParams, "meizuFlags")).intValue();
            int i = z ? iIntValue | iIntValue2 : (~iIntValue) & iIntValue2;
            if (iIntValue2 == i) {
                return false;
            }
            ab.a(layoutParams, "meizuFlags", Integer.valueOf(i));
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public static void b(Activity activity, boolean z) {
        a(activity, true, true);
    }

    private static void g(View view, boolean z) {
        int systemUiVisibility = view.getSystemUiVisibility();
        int i = z ? SYSTEM_UI_FLAG_LIGHT_STATUS_BAR | systemUiVisibility : (~SYSTEM_UI_FLAG_LIGHT_STATUS_BAR) & systemUiVisibility;
        if (i != systemUiVisibility) {
            view.setSystemUiVisibility(i);
        }
    }

    private static void setStatusBarColor(Window window, int i) {
        WindowManager.LayoutParams attributes = window.getAttributes();
        Field field = alR;
        if (field != null) {
            try {
                if (field.getInt(attributes) != 0) {
                    alR.set(attributes, 0);
                    window.setAttributes(attributes);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    private static void a(Window window, boolean z) {
        View decorView = window.getDecorView();
        if (decorView != null) {
            g(decorView, z);
            setStatusBarColor(window, 0);
        }
    }

    private static void a(Activity activity, boolean z, boolean z2) {
        Method method = alQ;
        if (method != null) {
            try {
                method.invoke(activity, Boolean.valueOf(z));
                return;
            } catch (IllegalAccessException e) {
                e.printStackTrace();
                return;
            } catch (InvocationTargetException e2) {
                e2.printStackTrace();
                return;
            }
        }
        a(activity.getWindow(), z);
    }
}
