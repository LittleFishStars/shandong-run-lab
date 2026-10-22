package com.byazt.mg;

import android.os.Build;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.blankj.utilcode.util.e;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, 67})
public class u {
    public static final CharSequence c = "sony";
    public static final CharSequence tt = "amigo";
    public static final CharSequence ve = "funtouch";

    public static boolean a() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase(Locale.getDefault()).contains(tt);
    }

    public static String c() {
        if (ve.ve()) {
            return da();
        }
        if (ve.uj()) {
            return t();
        }
        if (u()) {
            return yp();
        }
        String strSl = sl();
        if (!TextUtils.isEmpty(strSl)) {
            return strSl;
        }
        if (n()) {
            return uj();
        }
        if (a()) {
            return sp();
        }
        if (ve()) {
            return tt();
        }
        String strX = x();
        return !TextUtils.isEmpty(strX) ? strX : Build.DISPLAY;
    }

    public static String da() {
        if (!ve.ve()) {
            return "";
        }
        return "miui_" + c(XmSystemUtils.KEY_VERSION_MIUI) + LoginConstants.UNDER_LINE + Build.VERSION.INCREMENTAL;
    }

    public static boolean i() {
        return !TextUtils.isEmpty(c(e.e));
    }

    public static boolean n() {
        String strC = c(e.b);
        return !TextUtils.isEmpty(strC) && strC.toLowerCase(Locale.getDefault()).contains(ve);
    }

    public static String sl() {
        String strC = ve.c();
        if (strC == null || !strC.toLowerCase(Locale.getDefault()).contains("emotionui")) {
            return "";
        }
        return strC + LoginConstants.UNDER_LINE + Build.DISPLAY;
    }

    public static String sp() {
        return Build.DISPLAY + LoginConstants.UNDER_LINE + c("ro.gn.sv.version");
    }

    public static String t() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase(Locale.getDefault()).contains("flyme")) ? "" : str;
    }

    public static String tt() {
        return c(e.f) + LoginConstants.UNDER_LINE + Build.DISPLAY;
    }

    public static boolean u() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase(Locale.getDefault()).contains("oppo");
    }

    public static String uj() {
        return c(e.b) + LoginConstants.UNDER_LINE + c("ro.vivo.product.version");
    }

    public static boolean ve() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase(Locale.getDefault());
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String x() {
        if (!i()) {
            return "";
        }
        return "eui_" + c(e.e) + LoginConstants.UNDER_LINE + Build.DISPLAY;
    }

    public static String yp() {
        if (!u()) {
            return "";
        }
        return "coloros_" + c(e.d) + LoginConstants.UNDER_LINE + Build.DISPLAY;
    }

    private static String c(String str) {
        BufferedReader bufferedReader;
        String line = "";
        try {
            Process processExec = Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str)));
            bufferedReader = new BufferedReader(new InputStreamReader(processExec.getInputStream()), 1024);
            try {
                line = bufferedReader.readLine();
                processExec.destroy();
                a.c(bufferedReader);
                return line;
            } catch (Throwable unused) {
                a.c(bufferedReader);
                return line;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }
}
