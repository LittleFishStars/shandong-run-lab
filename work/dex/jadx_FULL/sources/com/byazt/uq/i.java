package com.byazt.uq;

import android.os.Build;
import android.text.TextUtils;
import com.igexin.assist.util.AssistUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1759, 42})
public class i {
    public static boolean a() {
        return false;
    }

    public static boolean c() {
        return true;
    }

    public static boolean da() {
        return true;
    }

    public static boolean gt() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), "samsung");
    }

    public static boolean i() {
        return true;
    }

    public static boolean m() {
        return Build.VERSION.SDK_INT == 29;
    }

    public static boolean my() {
        return TextUtils.equals(Build.BRAND.toLowerCase(), AssistUtils.BRAND_HW);
    }

    public static boolean n() {
        return false;
    }

    public static boolean nu() {
        int i = Build.VERSION.SDK_INT;
        if (i < 30) {
            return i == 29 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean rh() {
        int i = Build.VERSION.SDK_INT;
        if (i < 31) {
            return i == 30 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean sl() {
        return false;
    }

    public static boolean sp() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean t() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean tt() {
        return true;
    }

    public static boolean u() {
        return true;
    }

    public static boolean uj() {
        return false;
    }

    public static boolean ve() {
        return Build.VERSION.SDK_INT <= 28;
    }

    public static boolean x() {
        int i = Build.VERSION.SDK_INT;
        return i >= 29 && i <= 30;
    }

    public static boolean yp() {
        int i = Build.VERSION.SDK_INT;
        if (i < 28) {
            return i == 27 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }

    public static boolean z() {
        int i = Build.VERSION.SDK_INT;
        if (i < 29) {
            return i == 28 && Build.VERSION.PREVIEW_SDK_INT > 0;
        }
        return true;
    }
}
