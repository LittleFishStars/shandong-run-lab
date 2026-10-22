package com.byazt.aas;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.text.TextUtils;
import com.alipay.sdk.m.o.b;
import com.huawei.hms.common.PackageConstants;
import com.kc.openset.constant.DeviceIdType;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 17})
public class gu {
    public static volatile String c = "";
    public static volatile String tt = "";
    public static volatile boolean uj = false;
    public static volatile boolean ve = false;

    public static void c(String str) {
        try {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            ve = true;
            c = str;
            com.byazt.zlb.ve.tt(7, c == null ? "" : c);
            uj = false;
            update(false);
        } catch (Throwable unused) {
        }
    }

    public static String tt(com.byazt.qh.uj ujVar) {
        JSONObject jSONObjectC;
        if (ujVar != null) {
            String type = ujVar.getType();
            if (TextUtils.equals(type, "error")) {
                return "error";
            }
            if (TextUtils.equals(type, b.r0)) {
                return b.r0;
            }
            com.byazt.gj.n.c cVarC = ujVar.c();
            if (cVarC != null && !TextUtils.isEmpty(cVarC.c) && (jSONObjectC = c(cVarC)) != null) {
                return jSONObjectC.toString();
            }
        }
        return "error";
    }

    private static void update(boolean z) {
        if (TextUtils.isEmpty(c)) {
            return;
        }
        String strTt = com.byazt.nr.c.tt(c);
        com.byazt.by.uj.c().ve("app_log_oaid", c);
        com.byazt.by.uj.c().ve("new_app_log_oaid", strTt);
        com.byazt.by.uj.c().c("is_use_dev_oaid", z);
    }

    public static String ve(com.byazt.qh.uj ujVar) {
        if (ujVar == null) {
            return null;
        }
        String type = ujVar.getType();
        if (TextUtils.equals(type, "error")) {
            return "error";
        }
        if (TextUtils.equals(type, b.r0)) {
            return b.r0;
        }
        com.byazt.gj.n.c cVarC = ujVar.c();
        return (cVarC == null || TextUtils.isEmpty(cVarC.c)) ? "error" : cVarC.c;
    }

    public static void c(com.byazt.qh.uj ujVar) {
        com.byazt.lkt.c.c(ujVar);
        com.byazt.apd.tt.c().c(ujVar);
    }

    public static com.byazt.gj.n.c ve(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return new com.byazt.gj.n.c(str, false, c(com.byazt.omf.gt.getContext()));
    }

    private static JSONObject c(com.byazt.gj.n.c cVar) {
        if (cVar == null) {
            return null;
        }
        String str = cVar.c;
        long j = cVar.ve;
        boolean z = cVar.tt;
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(DeviceIdType.OAID, str);
            jSONObject.putOpt("isTrackLimited", Boolean.valueOf(z));
            jSONObject.putOpt("hWIdVersionCode", Long.valueOf(j));
            return jSONObject;
        } catch (Exception unused) {
            return null;
        }
    }

    public static String tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return "error";
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt(DeviceIdType.OAID, str);
            jSONObject.putOpt("isTrackLimited", Boolean.FALSE);
            jSONObject.putOpt("hWIdVersionCode", Integer.valueOf(c(com.byazt.omf.gt.getContext())));
            return jSONObject.toString();
        } catch (Exception unused) {
            return "error";
        }
    }

    private static void tt() {
        uj = com.byazt.by.uj.c().tt("is_use_dev_oaid", false);
    }

    private static int c(Context context) {
        String str = "com.huawei.hwid.tv";
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager.getPackageInfo("com.huawei.hwid", 0) != null) {
                str = "com.huawei.hwid";
            } else if (packageManager.getPackageInfo("com.huawei.hwid.tv", 0) == null) {
                str = PackageConstants.SERVICES_PACKAGE_ALL_SCENE;
            }
            PackageInfo packageInfo = packageManager.getPackageInfo(str, 0);
            if (packageInfo != null) {
                return packageInfo.versionCode;
            }
            return 0;
        } catch (Exception e) {
            com.byazt.nr.m.c(e);
            return 0;
        }
    }

    public static String c(boolean z) {
        long j;
        if (!TextUtils.isEmpty(c)) {
            return c;
        }
        if (z && !TextUtils.isEmpty(tt)) {
            return tt;
        }
        try {
            String strTt = com.byazt.by.uj.c().tt("new_app_log_oaid", (String) null);
            if (TextUtils.isEmpty(strTt)) {
                j = 0;
            } else {
                JSONObject jSONObject = new JSONObject(strTt);
                tt = com.byazt.nr.c.ve(jSONObject.getString("value"));
                j = jSONObject.getLong("time");
            }
            if (!TextUtils.isEmpty(tt) && (z || System.currentTimeMillis() - j < 86400000)) {
                tt();
                return tt;
            }
            if (!ve) {
                com.byazt.omf.a.c().tt();
                com.byazt.dj.uj ujVarMy = com.byazt.omf.x.m().my();
                if (ujVarMy != null && !TextUtils.isEmpty(ujVarMy.getDevOaid())) {
                    c = ujVarMy.getDevOaid();
                    boolean z2 = !TextUtils.isEmpty(ujVarMy.getDevOaid());
                    uj = z2;
                    update(z2);
                }
                com.byazt.zlb.ve.tt(7, c == null ? "" : c);
            }
            return c == null ? "" : c;
        } catch (Exception unused) {
        }
    }

    public static int c() {
        return uj ? 1 : 0;
    }
}
