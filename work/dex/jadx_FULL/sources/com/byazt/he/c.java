package com.byazt.he;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.p3;
import com.acse.ottn.p4;
import com.ali.auth.third.login.LoginConstants;
import com.blankj.utilcode.util.e;
import com.byazt.nr.m;
import com.byazt.yv.i;
import com.byazt.yv.u;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import com.igexin.assist.util.AssistUtils;
import java.util.Locale;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 994, 20})
public class c {
    public static final CharSequence c = "sony";
    public static final CharSequence tt = "amigo";
    public static final CharSequence ve = "funtouch";
    public static final AbstractC0420c<Boolean> uj = new AbstractC0420c<Boolean>() { // from class: com.byazt.he.c.1
        @Override // com.byazt.he.c.AbstractC0420c
        /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
        public Boolean tt(Object... objArr) {
            try {
                Class<?> cls = Class.forName("com.huawei.system.BuildEx");
                return Boolean.valueOf(p4.f23132a.equals(cls.getMethod("getOsBrand", new Class[0]).invoke(cls, new Object[0])));
            } catch (Throwable unused) {
                return Boolean.FALSE;
            }
        }
    };

    /* JADX INFO: renamed from: com.byazt.he.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, 994, 44})
    public static abstract class AbstractC0420c<T> {
        public volatile T c;

        public abstract T tt(Object... objArr);

        public final T ve(Object... objArr) {
            if (this.c == null) {
                synchronized (this) {
                    if (this.c == null) {
                        this.c = tt(objArr);
                    }
                }
            }
            return this.c;
        }
    }

    public static boolean a() {
        String str = Build.DISPLAY;
        return (!TextUtils.isEmpty(str) && str.contains("Flyme")) || "flyme".equals(Build.USER);
    }

    public static String c() {
        return c("ro.build.version.emui");
    }

    public static String da() {
        if (!sl()) {
            return "";
        }
        return "eui_" + c(e.e) + LoginConstants.UNDER_LINE + Build.DISPLAY;
    }

    public static boolean gr() {
        if ("lenovo".equalsIgnoreCase(Build.BRAND) || "motorola".equalsIgnoreCase(Build.MANUFACTURER)) {
            return true;
        }
        String str = Build.FINGERPRINT;
        if (!TextUtils.isEmpty(str)) {
            return str.contains("VIBEUI_V2");
        }
        String strC = c(e.c);
        return !TextUtils.isEmpty(strC) && strC.contains("VIBEUI_V2");
    }

    public static String gt() {
        if (!rh()) {
            return "";
        }
        return "coloros_" + c(e.d) + LoginConstants.UNDER_LINE + Build.DISPLAY;
    }

    public static boolean gu() {
        return "samsung".equalsIgnoreCase(Build.BRAND) || "samsung".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static String i() {
        return Build.DISPLAY + LoginConstants.UNDER_LINE + c("ro.gn.sv.version");
    }

    public static String m() {
        String strC = c();
        if (strC == null) {
            return "";
        }
        if (!strC.toLowerCase().contains("emotionui") && !strC.toLowerCase().contains("magicui")) {
            return "";
        }
        return strC + LoginConstants.UNDER_LINE + Build.DISPLAY;
    }

    public static boolean my() {
        if (Build.MANUFACTURER.equalsIgnoreCase("XIAOMI")) {
            return true;
        }
        String str = Build.BRAND;
        return str.equalsIgnoreCase("XIAOMI") || str.equalsIgnoreCase("REDMI");
    }

    public static String n() {
        return c(e.b) + LoginConstants.UNDER_LINE + c("ro.vivo.product.version");
    }

    public static String nu() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    private static String p() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean qy() {
        return "OnePlus".equalsIgnoreCase(Build.MANUFACTURER);
    }

    public static boolean rh() {
        String str = Build.MANUFACTURER;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.toLowerCase().contains("oppo") || str.toLowerCase().contains("realme");
    }

    public static boolean rl() {
        String str = Build.BRAND;
        if (str == null) {
            return false;
        }
        return str.toLowerCase(Locale.ENGLISH).contains(AssistUtils.BRAND_MZ);
    }

    public static boolean sl() {
        return !TextUtils.isEmpty(c(e.e));
    }

    public static boolean sp() {
        String strC = c(e.b);
        return !TextUtils.isEmpty(strC) && strC.toLowerCase().contains(ve);
    }

    public static boolean t() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith(AssistUtils.BRAND_HON)) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return (!TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith(AssistUtils.BRAND_HON)) || "HONOR".equalsIgnoreCase(str2);
    }

    public static String tt() {
        if (yp()) {
            return z();
        }
        if (a()) {
            return nu();
        }
        if (rh()) {
            return gt();
        }
        String strM = m();
        if (!TextUtils.isEmpty(strM)) {
            return strM;
        }
        if (sp()) {
            return n();
        }
        if (x()) {
            return i();
        }
        if (uj()) {
            return ve();
        }
        String strDa = da();
        return !TextUtils.isEmpty(strDa) ? strDa : Build.DISPLAY;
    }

    public static boolean u() {
        try {
            Class<?> cls = Class.forName("android.os.SystemProperties");
            return !TextUtils.isEmpty((String) cls.getDeclaredMethod(p3.f, String.class).invoke(cls, "ro.build.version.emui"));
        } catch (Exception e) {
            m.uj("Honor", e.getMessage());
        }
    }

    public static boolean uj() {
        String str = Build.MANUFACTURER + Build.BRAND;
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        return lowerCase.contains("360") || lowerCase.contains("qiku");
    }

    public static String ve() {
        return c(e.f) + LoginConstants.UNDER_LINE + Build.DISPLAY;
    }

    public static boolean x() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(tt);
    }

    public static boolean yp() {
        try {
            return Class.forName("miui.os.Build").getName().length() > 0;
        } catch (Exception unused) {
            return false;
        }
    }

    public static boolean yv() {
        return p().toUpperCase().contains("ASUS");
    }

    public static String z() {
        if (!yp()) {
            return "";
        }
        return "miui_" + c(XmSystemUtils.KEY_VERSION_MIUI) + LoginConstants.UNDER_LINE + Build.VERSION.INCREMENTAL;
    }

    public static boolean zm() {
        return p().toUpperCase().contains("NUBIA");
    }

    private static String c(String str) {
        String strC = i.c(str);
        return !TextUtils.isEmpty(strC) ? strC : u.c(str);
    }

    public static boolean c(Context context) {
        return p().toUpperCase().contains("HUAWEI");
    }
}
