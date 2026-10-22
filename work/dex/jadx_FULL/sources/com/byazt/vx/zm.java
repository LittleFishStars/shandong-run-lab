package com.byazt.vx;

import android.os.Build;
import android.text.TextUtils;
import com.acse.ottn.r3;
import com.ali.auth.third.login.LoginConstants;
import com.blankj.utilcode.util.e;
import com.byazt.dna.or;
import com.igexin.assist.control.xiaomi.XmSystemUtils;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 962, 482})
public class zm {
    public static final CharSequence ve = "sony";
    public static final CharSequence uj = "amigo";
    public static final CharSequence n = "funtouch";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ExecutorService f29152a = com.byazt.eu.n.c("romutils", 2, new RejectedExecutionHandler() { // from class: com.byazt.vx.zm.1
        @Override // java.util.concurrent.RejectedExecutionHandler
        public void rejectedExecution(Runnable runnable, ThreadPoolExecutor threadPoolExecutor) {
        }
    });
    public static boolean c = false;
    public static boolean tt = false;

    @com.byazt.zqa.c(c = {0, 1, 962, 21})
    public static class c implements Callable<String> {
        public final String c;

        public c(String str) {
            this.c = str;
        }

        @Override // java.util.concurrent.Callable
        public String call() throws Exception {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strTt = zm.tt(this.c);
            com.byazt.eu.tt.c(r3.f23176a, "property:" + strTt + ",getSystemProperty use time :" + (System.currentTimeMillis() - jCurrentTimeMillis));
            if (!TextUtils.isEmpty(strTt)) {
                try {
                    com.byazt.eu.tt.ve(r3.f23176a, "SP-getPropertyFromSP:".concat(String.valueOf(strTt)));
                    com.byazt.it.ve veVarRl = zm.rl();
                    if (veVarRl != null) {
                        veVarRl.put("rom_property_info", strTt);
                    }
                } catch (Throwable unused) {
                }
            }
            return strTt;
        }
    }

    public static String a() {
        return ve(e.b) + LoginConstants.UNDER_LINE + ve("ro.vivo.product.version");
    }

    public static String da() {
        if (!sl()) {
            return "";
        }
        return "eui_" + ve(e.e) + LoginConstants.UNDER_LINE + Build.DISPLAY;
    }

    public static String i() {
        return Build.DISPLAY + LoginConstants.UNDER_LINE + ve("ro.gn.sv.version");
    }

    public static String m() {
        if (z()) {
            try {
                return "smartisan_".concat(String.valueOf(ve("ro.smartisan.version")));
            } catch (Throwable unused) {
            }
        }
        return Build.DISPLAY;
    }

    public static String my() {
        if (!rh()) {
            return "";
        }
        return "coloros_" + ve(e.d) + LoginConstants.UNDER_LINE + Build.DISPLAY;
    }

    public static boolean n() {
        if (!tt) {
            try {
                Class.forName("miui.os.Build");
                c = true;
                tt = true;
                return true;
            } catch (Exception unused) {
                tt = true;
            }
        }
        return c;
    }

    public static String nu() {
        String str = Build.DISPLAY;
        return (str == null || !str.toLowerCase().contains("flyme")) ? "" : str;
    }

    private static String qy() {
        try {
            com.byazt.it.ve veVarRl = rl();
            String string = veVarRl != null ? veVarRl.getString("rom_property_info", "") : "";
            com.byazt.eu.tt.tt(r3.f23176a, "get Property From SP...=".concat(String.valueOf(string)));
            return string;
        } catch (Throwable unused) {
            return "";
        }
    }

    public static boolean rh() {
        String str = Build.MANUFACTURER;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains("oppo");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static com.byazt.it.ve rl() {
        try {
            if (com.byazt.bp.c.t() != null) {
                return com.byazt.vif.uj.c(null, "gm_rom_info");
            }
            return null;
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean sl() {
        return !TextUtils.isEmpty(ve(e.e));
    }

    public static boolean sp() {
        String strVe = ve(e.b);
        return !TextUtils.isEmpty(strVe) && strVe.toLowerCase().contains(n);
    }

    public static String t() {
        if (!n()) {
            return "";
        }
        return "miui_" + ve(XmSystemUtils.KEY_VERSION_MIUI) + LoginConstants.UNDER_LINE + Build.VERSION.INCREMENTAL;
    }

    public static boolean tt() {
        return Build.DISPLAY.contains("Flyme") || Build.USER.equals("flyme");
    }

    public static String u() {
        String strYp = yp();
        if (strYp == null || !strYp.toLowerCase().contains("emotionui")) {
            return "";
        }
        return strYp + LoginConstants.UNDER_LINE + Build.DISPLAY;
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
        return ve(e.f) + LoginConstants.UNDER_LINE + Build.DISPLAY;
    }

    public static boolean x() {
        String str = Build.DISPLAY;
        return !TextUtils.isEmpty(str) && str.toLowerCase().contains(uj);
    }

    public static String yp() {
        return ve("ro.build.version.emui");
    }

    public static boolean z() {
        return "smartisan".equalsIgnoreCase(Build.MANUFACTURER) || "smartisan".equalsIgnoreCase(Build.BRAND);
    }

    public static String c() {
        if (z()) {
            return m();
        }
        if (n()) {
            return t();
        }
        if (tt()) {
            return nu();
        }
        if (rh()) {
            return my();
        }
        String strU = u();
        if (!TextUtils.isEmpty(strU)) {
            return strU;
        }
        if (sp()) {
            return a();
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

    /* JADX INFO: Access modifiers changed from: private */
    public static String tt(String str) {
        or orVar = (or) com.byazt.ut.uj.getService("system_info");
        return orVar != null ? orVar.get(str) : "";
    }

    private static String ve(String str) {
        String strQy;
        try {
            strQy = qy();
            try {
                if (TextUtils.isEmpty(strQy)) {
                    FutureTask futureTask = new FutureTask(new c(str));
                    f29152a.execute(futureTask);
                    strQy = (String) futureTask.get(1L, TimeUnit.SECONDS);
                }
            } catch (Throwable unused) {
            }
        } catch (Throwable unused2) {
            strQy = "";
        }
        return strQy == null ? "" : strQy;
    }
}
