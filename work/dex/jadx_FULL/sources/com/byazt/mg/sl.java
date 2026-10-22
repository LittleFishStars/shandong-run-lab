package com.byazt.mg;

import android.text.TextUtils;
import com.ali.auth.third.login.LoginConstants;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, com.google.common.math.c.f6376a, 158})
public final class sl {
    public static void c(com.byazt.xz.c cVar, com.byazt.xz.tt ttVar, com.byazt.uy.ve veVar) {
        if (cVar == null || cVar.c() == null || veVar == null) {
            return;
        }
        JSONObject jSONObjectC = cVar.c();
        long jOptLong = jSONObjectC.optLong("crash_time");
        int iTt = tt(c("aid"));
        String strC = com.byazt.uy.x.ve().c();
        if (jOptLong <= 0 || iTt <= 0 || TextUtils.isEmpty(strC) || "0".equals(strC) || TextUtils.isEmpty(veVar.c())) {
            return;
        }
        try {
            String str = "android_" + iTt + LoginConstants.UNDER_LINE + strC + LoginConstants.UNDER_LINE + jOptLong + LoginConstants.UNDER_LINE + veVar;
            if (ttVar == null) {
                jSONObjectC.put("unique_key", str);
                return;
            }
            JSONObject jSONObjectC2 = ttVar.c();
            if (jSONObjectC2 != null) {
                jSONObjectC2.put("unique_key", str);
            }
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
    }

    public static int tt(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            da.tt(e);
            return 0;
        }
    }

    public static String c(String str) {
        Map<String, Object> mapC;
        if (com.byazt.uy.x.c() == null || (mapC = com.byazt.uy.x.c().c()) == null) {
            return null;
        }
        Object obj = mapC.get(str);
        if (obj instanceof String) {
            return (String) obj;
        }
        return null;
    }
}
