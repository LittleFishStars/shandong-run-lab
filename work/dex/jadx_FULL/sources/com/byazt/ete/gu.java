package com.byazt.ete;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 17})
public class gu {
    public static int c;
    public static int tt;

    public static void c(com.byazt.it.n nVar) {
        try {
            JSONObject jSONObject = new JSONObject(nVar.get("dpl_status_counter", ""));
            c = jSONObject.optInt("minute", 0);
            tt = jSONObject.optInt("internal", 0);
            com.byazt.cl.c.tt();
        } catch (JSONException unused) {
        }
    }

    public static void tt(com.byazt.it.n nVar) {
        nVar.put("dpl_status_counter", new JSONObject().toString());
    }

    public static int tt() {
        return tt;
    }

    public static int c() {
        return c;
    }

    public static void c(JSONObject jSONObject) {
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("app_common_config");
        if (jSONObjectOptJSONObject != null) {
            try {
                JSONObject jSONObjectOptJSONObject2 = jSONObjectOptJSONObject.optJSONObject("dpl_status_counter");
                if (jSONObjectOptJSONObject2 != null) {
                    c = jSONObjectOptJSONObject2.optInt("minute", 0);
                    tt = jSONObjectOptJSONObject2.optInt("internal", 0);
                }
            } catch (Exception unused) {
            }
        }
    }
}
