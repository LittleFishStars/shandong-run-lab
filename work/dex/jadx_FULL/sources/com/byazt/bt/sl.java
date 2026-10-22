package com.byazt.bt;

import android.content.Context;
import android.content.res.Resources;
import android.util.DisplayMetrics;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 274, 158})
public class sl {
    public static volatile float c = -1.0f;
    public static volatile int n = -1;
    public static volatile int tt = -1;
    public static volatile int uj = -1;
    public static volatile float ve = -1.0f;

    public static void c(Context context) {
        Resources resources;
        if (context == null || (resources = context.getResources()) == null) {
            return;
        }
        if (c()) {
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            c = displayMetrics.density;
            tt = displayMetrics.densityDpi;
            ve = displayMetrics.scaledDensity;
            uj = displayMetrics.widthPixels;
            n = displayMetrics.heightPixels;
        }
        if (resources.getConfiguration() != null) {
            if (resources.getConfiguration().orientation == 1) {
                if (uj > n) {
                    int i = uj;
                    uj = n;
                    n = i;
                    return;
                }
                return;
            }
            if (uj < n) {
                int i2 = uj;
                uj = n;
                n = i2;
            }
        }
    }

    public static int tt(Context context) {
        c(context);
        return tt;
    }

    public static int uj(Context context) {
        c(context);
        return n;
    }

    public static int ve(Context context) {
        c(context);
        return uj;
    }

    private static boolean c() {
        return c < 0.0f || tt < 0 || ve < 0.0f || uj < 0 || n < 0;
    }
}
