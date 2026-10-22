package com.byazt.bt;

import android.os.Build;
import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import com.byazt.dna.or;
import com.byazt.dna.qp;
import com.igexin.assist.util.AssistUtils;
import com.zj.adlib.c49;
import java.util.Locale;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 274, 34})
public class a {
    public static int c;
    public static int tt;

    @com.byazt.zqa.c(c = {0, 1, 274, 464})
    public static class c implements Callable<String> {
        public String c;
        public com.byazt.dna.c tt;

        public c(String str, com.byazt.dna.c cVar) {
            this.c = str;
            this.tt = cVar;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            System.currentTimeMillis();
            String strC = a.c(this.c);
            System.currentTimeMillis();
            if (!TextUtils.isEmpty(strC)) {
                try {
                    x.c("rom_info", this.tt).put("rom_property_info", strC);
                } catch (Throwable unused) {
                }
            }
            return strC;
        }
    }

    public static String c(com.byazt.dna.c cVar) {
        StringBuilder sb = new StringBuilder();
        try {
            if (c()) {
                sb.append("MIUI-");
            } else if (tt()) {
                sb.append("FLYME-");
            } else {
                String strTt = tt(cVar);
                if (c(strTt, cVar)) {
                    sb.append("EMUI-");
                }
                if (!TextUtils.isEmpty(strTt)) {
                    sb.append(strTt);
                    sb.append(c49.f40900a);
                }
            }
            sb.append(Build.VERSION.INCREMENTAL);
        } catch (Throwable unused) {
        }
        return sb.toString();
    }

    public static boolean n() {
        try {
            String str = Build.BRAND;
            if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith(AssistUtils.BRAND_HW)) {
                String str2 = Build.MANUFACTURER;
                if (TextUtils.isEmpty(str2) || !str2.toLowerCase().startsWith(AssistUtils.BRAND_HW)) {
                    return false;
                }
            }
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean tt() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static boolean uj() {
        if (tt == 0) {
            try {
                Class.forName("com.huawei.system.BuildEx");
                tt = 1;
            } catch (Exception unused) {
            }
        }
        return tt == 1;
    }

    private static String ve(com.byazt.dna.c cVar) {
        try {
            return x.c("rom_info", cVar).get("rom_property_info", "");
        } catch (Throwable unused) {
            return "";
        }
    }

    public static String tt(com.byazt.dna.c cVar) {
        return tt("ro.build.version.emui", cVar);
    }

    public static String ve() {
        String str = Build.DISPLAY + LoginConstants.UNDER_LINE + Build.VERSION.INCREMENTAL;
        String str2 = Build.MANUFACTURER;
        if (c()) {
            return "miui_" + str;
        }
        if (uj()) {
            return "huawei_" + str;
        }
        Locale locale = Locale.ROOT;
        if (str2.toLowerCase(locale).contains("oppo")) {
            return "oppo_" + str;
        }
        if (str2.toLowerCase(locale).contains("vivo")) {
            return "vivo_" + str;
        }
        if (!str2.toLowerCase(locale).contains("oneplus")) {
            return str;
        }
        return "oneplus_" + str;
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static String tt(String str, com.byazt.dna.c cVar) {
        String strVe;
        try {
            strVe = ve(cVar);
            try {
                if (TextUtils.isEmpty(strVe)) {
                    final com.byazt.bwm.a aVar = new com.byazt.bwm.a(new c(str, cVar), 5, 2);
                    ((qp) com.byazt.ut.uj.getService("thread_service")).getIoExecutor().execute(new com.byazt.bwm.sp("getSystemPropertyTask") { // from class: com.byazt.bt.a.1
                        @Override // java.lang.Runnable
                        public void run() {
                            aVar.run();
                        }
                    });
                    strVe = (String) aVar.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strVe = "";
        }
        return strVe == null ? "" : strVe;
    }

    public static boolean c() {
        if (c == 0) {
            try {
                Class.forName("miui.os.Build");
                c = 1;
            } catch (Exception unused) {
            }
        }
        return c == 1;
    }

    public static String c(String str) {
        or orVar = (or) com.byazt.ut.uj.getService("system_info");
        return orVar != null ? orVar.get(str) : "";
    }

    public static boolean c(String str, com.byazt.dna.c cVar) {
        if (TextUtils.isEmpty(str)) {
            str = tt(cVar);
        }
        return (!TextUtils.isEmpty(str) && str.toLowerCase().startsWith("emotionui")) || n();
    }
}
