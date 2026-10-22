package com.byazt.qx;

import android.text.TextUtils;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 130})
public class m extends com.byazt.pct.n<JSONObject, JSONObject> {
    public static void c(com.byazt.pct.nu nuVar) {
        nuVar.c("getDownloadStatus", (com.byazt.pct.n<?, ?>) new m());
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        return c(jSONObject);
    }

    public static JSONObject c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        if (jSONObject == null) {
            c(jSONObject2, 1, "params is null", 1, 1);
            return jSONObject2;
        }
        try {
            String strOptString = jSONObject.optString("ad_down_load_id");
            if (TextUtils.isEmpty(strOptString)) {
                c(jSONObject2, 1, "ad_down_load_id is null", 1, 1);
                return jSONObject2;
            }
            return com.byazt.nt.tt.c.c(strOptString);
        } catch (Throwable unused) {
            return jSONObject2;
        }
    }

    private static void c(JSONObject jSONObject, int i, String str, int i2, int i3) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("code", i);
            jSONObject.put("codeMsg", str);
            jSONObject.put("downloadStatus", i2);
            jSONObject.put("downloadProcessRate", i3);
        } catch (Exception unused) {
        }
    }
}
