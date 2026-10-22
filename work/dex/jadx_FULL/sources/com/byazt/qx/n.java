package com.byazt.qx;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 46})
public class n extends com.byazt.pct.n<JSONObject, JSONObject> {
    public final com.byazt.pct.nu c;

    public n(com.byazt.pct.nu nuVar) {
        this.c = nuVar;
    }

    public static void c(com.byazt.pct.nu nuVar) {
        nuVar.c("canIUse", (com.byazt.pct.n<?, ?>) new n(nuVar));
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject != null) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("names");
                if (jSONArrayOptJSONArray != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i, "");
                        if (!TextUtils.isEmpty(strOptString)) {
                            if (TextUtils.equals(strOptString, "isShow7Factors")) {
                                jSONObject3.put(strOptString, 1);
                            } else {
                                jSONObject3.put(strOptString, this.c.c(strOptString) ? 1 : 0);
                            }
                        }
                    }
                    jSONObject2.put("code", 0);
                    jSONObject2.put("data", jSONObject3);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("msg", "names is not JsonArray or null");
                }
            } else {
                jSONObject2.put("code", 1);
                jSONObject2.put("msg", "params is null");
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
            jSONObject2.put("code", 1);
            jSONObject2.put("msg", "exception: " + th.getMessage());
        }
        return jSONObject2;
    }
}
