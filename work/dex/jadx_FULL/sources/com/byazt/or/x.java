package com.byazt.or;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;
import com.byazt.nr.gu;
import java.lang.reflect.Method;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 579, 71})
public class x {
    public static boolean c;

    public static float c(Context context, float f) {
        if (context == null) {
            context = com.byazt.mf.c.c().ve().getContext();
        }
        return (f * n(context)) + 0.5f;
    }

    public static int c(float f, float f2, float f3, float f4) {
        return (((int) ((f * 255.0f) + 0.5f)) << 24) | (((int) ((f2 * 255.0f) + 0.5f)) << 16) | (((int) ((f3 * 255.0f) + 0.5f)) << 8) | ((int) ((f4 * 255.0f) + 0.5f));
    }

    private static float n(Context context) {
        try {
            if (c) {
                Class<?> clsLoadClass = context.getClassLoader().loadClass("android.util.DisplayMetrics");
                Method declaredMethod = clsLoadClass.getDeclaredMethod("getDeviceDensity", new Class[0]);
                declaredMethod.setAccessible(true);
                return ((Integer) declaredMethod.invoke(clsLoadClass, new Object[0])).intValue() / 160.0f;
            }
        } catch (Exception unused) {
        }
        return context.getResources().getDisplayMetrics().density;
    }

    public static int tt(Context context, float f) {
        if (context == null) {
            context = com.byazt.mf.c.c().ve().getContext();
        }
        float fN = n(context);
        if (fN <= 0.0f) {
            fN = 1.0f;
        }
        return (int) ((f / fN) + 0.5f);
    }

    public static String uj(Context context) {
        String language;
        try {
            Locale locale = gu.c(context).getConfiguration().getLocales().get(0);
            language = locale.getLanguage();
            try {
                if (locale.getCountry().equals("TW")) {
                    language = "zhHant";
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            language = "";
        }
        return c(language);
    }

    public static float ve(Context context, float f) {
        if (context == null) {
            context = com.byazt.mf.c.c().ve().getContext();
        }
        return f * n(context);
    }

    public static int c(Context context) {
        if (context == null) {
            context = com.byazt.mf.c.c().ve().getContext();
        }
        return context.getResources().getDisplayMetrics().widthPixels;
    }

    public static int tt(Context context) {
        if (context == null) {
            context = com.byazt.mf.c.c().ve().getContext();
        }
        return context.getResources().getDisplayMetrics().heightPixels;
    }

    public static int ve(Context context) {
        if (context == null) {
            context = com.byazt.mf.c.c().ve().getContext();
        }
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getRealMetrics(displayMetrics);
        return displayMetrics.heightPixels;
    }

    private static String c(String str) {
        str.hashCode();
        switch (str) {
            case "ar":
                return "aa";
            case "ja":
                return "japan";
            case "ko":
                return "korea";
            case "ms":
                return "my";
            case "zh":
                return "cn";
            default:
                return str;
        }
    }
}
