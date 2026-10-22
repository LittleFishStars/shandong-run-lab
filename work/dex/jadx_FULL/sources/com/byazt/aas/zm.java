package com.byazt.aas;

import android.os.Build;
import android.system.Os;
import android.system.OsConstants;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.blankj.utilcode.util.e;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import com.igexin.assist.util.AssistUtils;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 482})
public class zm {
    public static volatile int c = 0;
    public static int sp = Integer.MAX_VALUE;
    public static int tt;
    public static String x;
    public static final CharSequence ve = "sony";
    public static final CharSequence uj = "amigo";
    public static final CharSequence n = "funtouch";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final CharSequence f28279a = "origin";

    public static boolean a() {
        String strC = c(e.b);
        if (TextUtils.isEmpty(strC)) {
            return false;
        }
        return strC.toLowerCase().contains(n) || strC.toLowerCase().contains("origin");
    }

    public static String c() {
        return c(e.f) + LoginConstants.UNDER_LINE + Build.DISPLAY;
    }

    public static String da() {
        return Build.DISPLAY + LoginConstants.UNDER_LINE + c("ro.gn.sv.version");
    }

    public static boolean gt() {
        if (c == 0) {
            try {
                Class.forName("miui.os.Build");
                c = 1;
            } catch (Throwable unused) {
                c = 2;
            }
        }
        return c == 1;
    }

    public static boolean i() {
        try {
            return "FreemeOS".equalsIgnoreCase(c("ro.build.freemeos_label"));
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean m() {
        try {
            String str = Build.MANUFACTURER;
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            return str.toLowerCase().contains("vivo");
        } catch (Exception e) {
            com.byazt.nr.m.uj("romUtils", e.getMessage());
            return false;
        }
    }

    public static int my() {
        try {
            return (int) Os.sysconf(OsConstants._SC_PAGESIZE);
        } catch (Throwable unused) {
            return 4097;
        }
    }

    public static String n() {
        String emuiInfo = ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getEmuiInfo();
        if (emuiInfo == null) {
            return "";
        }
        if (!emuiInfo.toLowerCase().contains("emotionui") && !emuiInfo.toLowerCase().contains("magicui")) {
            return "";
        }
        return emuiInfo + LoginConstants.UNDER_LINE + Build.DISPLAY;
    }

    public static boolean nu() {
        if (sp == Integer.MAX_VALUE) {
            String str = Build.MANUFACTURER;
            String strU = nb.u("kllk");
            if (TextUtils.isEmpty(str) || !str.toLowerCase(Locale.ROOT).contains(strU)) {
                sp = 0;
            } else {
                sp = 1;
            }
        }
        return sp == 1;
    }

    private static String qy() {
        if (gt()) {
            return tt();
        }
        if (rl()) {
            return ve();
        }
        if (nu()) {
            return uj();
        }
        String strN = n();
        if (!TextUtils.isEmpty(strN)) {
            return strN;
        }
        if (a()) {
            return sp();
        }
        if (x()) {
            return da();
        }
        if (sl()) {
            return c();
        }
        String strT = t();
        if (!TextUtils.isEmpty(strT)) {
            return strT;
        }
        if (Build.MANUFACTURER.toLowerCase(Locale.ROOT).contains("oneplus")) {
            return "oneplus_" + Build.DISPLAY + LoginConstants.UNDER_LINE + Build.VERSION.INCREMENTAL;
        }
        if (rh()) {
            return "honor_" + ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getEmuiInfo();
        }
        if (i()) {
            return "freeme_" + ((com.byazt.dna.u) com.byazt.ut.uj.getService("device_info_new")).getEmuiInfo();
        }
        return Build.DISPLAY + LoginConstants.UNDER_LINE + Build.VERSION.INCREMENTAL;
    }

    public static boolean rh() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith(AssistUtils.BRAND_HON)) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return (!TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith(AssistUtils.BRAND_HON)) || "HONOR".equalsIgnoreCase(str2);
    }

    public static boolean rl() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean sl() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String sp() {
        return "vivo_" + c(e.b) + LoginConstants.UNDER_LINE + c("ro.vivo.product.version");
    }

    public static String t() {
        if (!u()) {
            return "";
        }
        return "eui_" + c(e.e) + LoginConstants.UNDER_LINE + Build.DISPLAY;
    }

    public static String tt() {
        if (!gt()) {
            return "";
        }
        return "miui_" + c(XmSystemUtils.KEY_VERSION_MIUI) + LoginConstants.UNDER_LINE + Build.VERSION.INCREMENTAL;
    }

    public static boolean u() {
        return !TextUtils.isEmpty(c(e.e));
    }

    public static String uj() {
        if (!nu()) {
            return "";
        }
        return "coloros_" + c("ro.build.version.kllkrom") + LoginConstants.UNDER_LINE + Build.DISPLAY;
    }

    public static String ve() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    public static boolean x() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(uj);
    }

    public static String yp() {
        if (TextUtils.isEmpty(x)) {
            x = qy();
        }
        return x;
    }

    public static boolean z() {
        try {
            String str = Build.MANUFACTURER;
            if (!TextUtils.isEmpty(str)) {
                return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
            }
        } catch (Exception e) {
            com.byazt.nr.m.uj("romUtil", e.getMessage());
        }
        return false;
    }

    public static String c(String str) {
        com.byazt.dna.or orVar = (com.byazt.dna.or) com.byazt.ut.uj.getService("system_info");
        return orVar != null ? orVar.get(str) : "";
    }
}
