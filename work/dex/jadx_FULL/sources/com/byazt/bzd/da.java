package com.byazt.bzd;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 724, 72})
public class da {
    public static JSONObject c(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                JSONObject jSONObjectOptJSONObject = jSONArray.optJSONObject(i);
                if (jSONObjectOptJSONObject != null) {
                    jSONObject.put(jSONObjectOptJSONObject.optString("name"), jSONObjectOptJSONObject.opt("value"));
                }
            }
        } catch (Exception unused) {
        }
        return jSONObject;
    }
}
