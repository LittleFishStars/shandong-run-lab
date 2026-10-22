package com.byazt.aas;

import android.text.TextUtils;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 54})
public final class ve {
    public static long c = 0;
    public static JSONObject tt = null;
    public static boolean ve = false;

    public static void c() {
        if (!com.byazt.omf.x.m().sl()) {
            c |= 1;
        }
        if (!com.byazt.omf.x.m().uj()) {
            c |= 2;
        }
        if (com.byazt.omf.x.m().nu().alist()) {
            return;
        }
        c |= 4;
    }

    public static JSONObject tt() {
        JSONObject jSONObject = tt;
        if (jSONObject != null) {
            return jSONObject;
        }
        String str = com.byazt.vif.uj.tt(com.byazt.vxy.c.uj(), com.byazt.ogz.sl.n()).get("pglam", "");
        if (!TextUtils.isEmpty(str)) {
            try {
                JSONObject jSONObject2 = new JSONObject(str);
                tt = jSONObject2;
                return jSONObject2;
            } catch (JSONException e) {
                com.byazt.nr.m.c(e);
            }
        }
        return null;
    }

    public static long ve() {
        if (!ve) {
            c();
            ve = true;
        }
        if (tt == null) {
            JSONObject jSONObjectTt = tt();
            tt = jSONObjectTt;
            if (jSONObjectTt != null) {
                c(jSONObjectTt);
            }
        }
        return c;
    }

    public static void c(JSONObject jSONObject) {
        tt = jSONObject;
        if (jSONObject.optBoolean("pglam_getwvid_enable", true)) {
            return;
        }
        c |= 8;
    }
}
