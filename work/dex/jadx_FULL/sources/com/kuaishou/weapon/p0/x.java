package com.kuaishou.weapon.p0;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class x {
    public JSONArray a(Context context) {
        try {
            JSONArray jSONArray = new JSONArray();
            String strE = bf.e();
            if (!TextUtils.isEmpty(strE) && !strE.startsWith("RISK")) {
                JSONArray jSONArray2 = new JSONArray(strE);
                for (int i = 0; i < jSONArray2.length(); i++) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("1", jSONArray2.getJSONObject(i).getString("appName"));
                    jSONObject.put("2", jSONArray2.getJSONObject(i).getString("pkgName"));
                    jSONObject.put("3", jSONArray2.getJSONObject(i).getString("appVersion"));
                    jSONObject.put("5", jSONArray2.getJSONObject(i).getString("system_app"));
                    jSONObject.put("6", jSONArray2.getJSONObject(i).getString("firstInstallTime"));
                    jSONObject.put("7", jSONArray2.getJSONObject(i).getString("lastUpdateTime"));
                    jSONArray.put(jSONObject);
                }
                return jSONArray;
            }
        } catch (Exception unused) {
        }
        return null;
    }
}
