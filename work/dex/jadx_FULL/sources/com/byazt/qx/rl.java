package com.byazt.qx;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 117})
public class rl extends com.byazt.pct.n<JSONObject, JSONObject> {
    public static void c(com.byazt.pct.nu nuVar) {
        nuVar.c("getSettingInfo", (com.byazt.pct.n<?, ?>) new rl());
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        String[] strArrSplit;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject != null) {
                JSONArray jSONArrayOptJSONArray = jSONObject.optJSONArray("keys");
                JSONObject jSONObjectZ = com.byazt.omf.gt.tt().z();
                if (jSONObjectZ == null) {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("msg", "settingsJson is null");
                } else if (jSONArrayOptJSONArray != null) {
                    JSONObject jSONObject3 = new JSONObject();
                    for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                        String strOptString = jSONArrayOptJSONArray.optString(i, "");
                        if (!TextUtils.isEmpty(strOptString) && (strArrSplit = strOptString.split("\\.")) != null) {
                            Object objOpt = null;
                            JSONObject jSONObjectOptJSONObject = jSONObjectZ;
                            for (int i2 = 0; i2 < strArrSplit.length; i2++) {
                                String str = strArrSplit[i2];
                                if (str != null && jSONObjectOptJSONObject != null) {
                                    if (i2 != strArrSplit.length - 1) {
                                        jSONObjectOptJSONObject = jSONObjectOptJSONObject.optJSONObject(str);
                                    } else {
                                        objOpt = jSONObjectOptJSONObject.opt(str);
                                    }
                                }
                            }
                            jSONObject3.putOpt(strOptString, objOpt);
                        }
                    }
                    jSONObject2.put("code", 0);
                    jSONObject2.put("data", jSONObject3);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("msg", "keys is not JsonArray or null");
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
