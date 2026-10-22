package com.byazt.i;

import android.os.Build;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import com.acse.ottn.p3;
import com.acse.ottn.p4;
import com.blankj.utilcode.util.e;
import com.byazt.nr.m;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import com.igexin.assist.util.AssistUtils;
import java.io.BufferedReader;
import java.io.InputStreamReader;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 42, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static String f28640a = null;
    public static String c = null;
    public static String n = null;
    public static String sp = null;
    public static String tt = "";
    public static String uj = "";
    public static String ve;
    public static Boolean x;

    public static boolean a() {
        return c("FLYME");
    }

    public static boolean c() {
        return c("EMUI") || c("MAGICUI");
    }

    public static String da() {
        if (ve == null) {
            c("");
        }
        return ve;
    }

    public static String i() {
        if (f28640a == null) {
            c("");
        }
        return f28640a;
    }

    public static boolean m() {
        if (x == null) {
            x = Boolean.valueOf(uj.sp().equals(p4.f23132a));
        }
        return x.booleanValue();
    }

    private static void my() {
        if (sp == null) {
            try {
                sp = uj(XmSystemUtils.KEY_VERSION_MIUI);
            } catch (Exception e) {
                m.c(e);
            }
            String str = sp;
            if (str == null) {
                str = "";
            }
            sp = str;
        }
    }

    public static boolean n() {
        rh();
        return c(c);
    }

    public static boolean nu() {
        String str = Build.BRAND;
        if (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith(AssistUtils.BRAND_HON)) {
            return true;
        }
        String str2 = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str2) && str2.toLowerCase().startsWith(AssistUtils.BRAND_HON);
    }

    private static void rh() {
        if (TextUtils.isEmpty(c)) {
            com.byazt.zz.ve.or();
            c = com.byazt.ev.n.tt;
            uj = "ro.build.version." + com.byazt.ev.n.ve + "rom";
            tt = "com." + com.byazt.ev.n.ve + ".market";
        }
    }

    @NonNull
    public static String sl() {
        String str = Build.MANUFACTURER;
        return str == null ? "" : str.trim();
    }

    public static boolean sp() {
        return c("SAMSUNG");
    }

    @NonNull
    public static String t() {
        String str = Build.DISPLAY;
        return str == null ? "" : str.trim();
    }

    public static boolean tt() {
        return c("MAGICUI");
    }

    public static boolean u() {
        my();
        return "V10".equals(sp);
    }

    public static boolean uj() {
        return c("VIVO");
    }

    public static boolean ve() {
        return c("MIUI");
    }

    public static String x() {
        if (n == null) {
            c("");
        }
        return n;
    }

    public static boolean yp() {
        my();
        return "V11".equals(sp);
    }

    public static boolean z() {
        my();
        return "V12".equals(sp);
    }

    public static boolean c(String str) {
        rh();
        String str2 = n;
        if (str2 != null) {
            return str2.equals(str);
        }
        String strUj = uj(XmSystemUtils.KEY_VERSION_MIUI);
        f28640a = strUj;
        if (TextUtils.isEmpty(strUj)) {
            String strUj2 = uj("ro.build.version.emui");
            f28640a = strUj2;
            if (TextUtils.isEmpty(strUj2)) {
                String strUj3 = uj("ro.build.version.magic");
                f28640a = strUj3;
                if (TextUtils.isEmpty(strUj3)) {
                    String strUj4 = uj(uj);
                    f28640a = strUj4;
                    if (TextUtils.isEmpty(strUj4)) {
                        String strUj5 = uj("ro.vivo.os.version");
                        f28640a = strUj5;
                        if (TextUtils.isEmpty(strUj5)) {
                            String strUj6 = uj("ro.smartisan.version");
                            f28640a = strUj6;
                            if (TextUtils.isEmpty(strUj6)) {
                                String strUj7 = uj("ro.gn.sv.version");
                                f28640a = strUj7;
                                if (TextUtils.isEmpty(strUj7)) {
                                    String strUj8 = uj("ro.lenovo.lvp.version");
                                    f28640a = strUj8;
                                    if (!TextUtils.isEmpty(strUj8)) {
                                        n = "LENOVO";
                                        ve = "com.lenovo.leos.appstore";
                                    } else if (sl().toUpperCase().contains("SAMSUNG")) {
                                        n = "SAMSUNG";
                                        ve = "com.sec.android.app.samsungapps";
                                    } else if (sl().toUpperCase().contains("ZTE")) {
                                        n = "ZTE";
                                        ve = "zte.com.market";
                                    } else if (sl().toUpperCase().contains("NUBIA")) {
                                        n = "NUBIA";
                                        ve = "cn.nubia.neostore";
                                    } else if (t().toUpperCase().contains("FLYME")) {
                                        n = "FLYME";
                                        ve = "com.meizu.mstore";
                                        f28640a = t();
                                    } else if (sl().toUpperCase().contains("ONEPLUS")) {
                                        n = "ONEPLUS";
                                        f28640a = uj(e.h);
                                        if (com.byazt.z.a.c(tt) >= 0) {
                                            ve = tt;
                                        } else {
                                            ve = "com.heytap.market";
                                        }
                                    } else {
                                        n = sl().toUpperCase();
                                        ve = "";
                                        f28640a = "";
                                    }
                                } else {
                                    n = "QIONEE";
                                    ve = "com.gionee.aora.market";
                                }
                            } else {
                                n = "SMARTISAN";
                                ve = "com.smartisanos.appstore";
                            }
                        } else {
                            n = "VIVO";
                            ve = "com.bbk.appstore";
                        }
                    } else {
                        n = c;
                        if (com.byazt.z.a.c(tt) >= 0) {
                            ve = tt;
                        } else {
                            ve = "com.heytap.market";
                        }
                    }
                } else {
                    n = "MAGICUI";
                    ve = "com.hihonor.appmarket";
                }
            } else {
                String str3 = nu() ? "MAGICUI" : "EMUI";
                n = str3;
                if (TextUtils.equals(str3, "MAGICUI")) {
                    ve = "com.hihonor.appmarket";
                } else {
                    ve = "com.huawei.appmarket";
                }
            }
        } else {
            n = "MIUI";
            ve = "com.xiaomi.market";
            sp = f28640a;
        }
        return n.equals(str);
    }

    public static String tt(String str) {
        BufferedReader bufferedReader;
        try {
            bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec("getprop ".concat(String.valueOf(str))).getInputStream()), 1024);
            try {
                String line = bufferedReader.readLine();
                bufferedReader.close();
                com.byazt.w.a.c(bufferedReader);
                return line;
            } catch (Throwable unused) {
                com.byazt.w.a.c(bufferedReader);
                return null;
            }
        } catch (Throwable unused2) {
            bufferedReader = null;
        }
    }

    public static String uj(String str) {
        if (com.byazt.k.c.tt().optBoolean("enable_reflect_system_properties", true)) {
            try {
                return ve(str);
            } catch (Throwable th) {
                m.c(th);
            }
        }
        return tt(str);
    }

    public static String ve(String str) throws Throwable {
        return (String) Class.forName("android.os.SystemProperties").getMethod(p3.f, String.class).invoke(null, str);
    }
}
