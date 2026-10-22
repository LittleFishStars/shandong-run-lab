package com.byazt.aas;

import android.content.Context;
import android.text.TextUtils;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 115})
public class rh {
    public static final String c = null;
    public static long tt = -1;

    public static JSONArray c(final Context context) {
        if (System.currentTimeMillis() - tt <= 1000) {
            return null;
        }
        tt = System.currentTimeMillis();
        if (!com.byazt.ogz.x.n() || !tt() || !com.byazt.omf.gt.tt().hc() || !com.byazt.omf.x.m().nu().alist()) {
            return null;
        }
        com.byazt.bwm.n.c(new com.byazt.bwm.sp("getIncrementalInstallApps") { // from class: com.byazt.aas.rh.1
            @Override // java.lang.Runnable
            public void run() {
                rh.ve(context);
            }
        }, 1);
        return c();
    }

    private static List<String> uj(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return Arrays.asList(str.split(","));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void ve(Context context) {
        try {
            List<String> listC = com.byazt.ogz.ve.tt().c(context);
            if (listC != null && !listC.isEmpty()) {
                List<String> listUj = uj(com.byazt.omf.tt.c().get("install_app_string", c));
                tt(c(listC));
                if (listUj != null && !listUj.isEmpty()) {
                    listC.removeAll(listUj);
                }
                ve(c(listC));
            }
        } catch (Exception unused) {
        }
    }

    private static void tt(String str) {
        com.byazt.omf.tt.c().put("install_app_string", str);
    }

    private static boolean tt() {
        long j = com.byazt.omf.tt.c().get("apptime", -1L);
        return j == -1 || System.currentTimeMillis() - j > com.heytap.mcssdk.constant.a.g;
    }

    private static JSONArray c() {
        try {
            String str = com.byazt.omf.tt.c().get("install_app_incremental_string", c);
            if (TextUtils.isEmpty(str)) {
                return null;
            }
            return new JSONArray((Collection) uj(str));
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void ve(String str) {
        com.byazt.it.ve veVarC = com.byazt.omf.tt.c();
        veVarC.put("install_app_incremental_string", str);
        veVarC.put("apptime", System.currentTimeMillis());
    }

    private static String c(List<String> list) {
        if (list == null || list.isEmpty()) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < list.size(); i++) {
            sb.append(list.get(i));
            if (i != list.size() - 1) {
                sb.append(",");
            }
        }
        return sb.toString().trim();
    }

    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            c(0, 0, null);
            return false;
        }
        if (nb.yv() && !nb.tt(str)) {
            c(0, 0, null);
        }
        return false;
    }

    private static void c(final int i, final int i2, final String str) {
        com.byazt.ukr.tt.ve().c(new com.byazt.ee.c() { // from class: com.byazt.aas.rh.2
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("call_api_status", i);
                    jSONObject.put("has_actived", i2);
                    if (!TextUtils.isEmpty(str)) {
                        jSONObject.put("error_msg", str);
                    }
                } catch (Throwable unused) {
                }
                return com.byazt.qal.tt.tt().c("call_active_api").tt(jSONObject.toString());
            }
        }, "call_active_api", true);
    }
}
