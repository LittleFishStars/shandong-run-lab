package com.byazt.z;

import android.text.TextUtils;
import com.baidu.mapapi.SDKInitializer;
import com.byazt.nr.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 133, 20})
public class c {
    public String c;
    public String n;
    public int tt = -1;
    public String uj;
    public String ve;

    public String c() {
        return tt().toString();
    }

    public JSONObject tt() {
        JSONObject jSONObject = new JSONObject();
        c(jSONObject);
        return jSONObject;
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        try {
            jSONObject.put("ah_plan_type", this.c);
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, String.valueOf(this.tt));
            jSONObject.put("error_msg", this.ve);
            jSONObject.put("real_device_plan", this.uj);
            jSONObject.put("device_plans", this.n);
        } catch (Throwable unused) {
        }
    }

    public static c c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        c cVar = new c();
        try {
            JSONObject jSONObject = new JSONObject(str);
            cVar.n = jSONObject.optString("device_plans", null);
            cVar.uj = jSONObject.optString("real_device_plan", null);
            cVar.ve = jSONObject.optString("error_msg", null);
            cVar.c = jSONObject.optString("ah_plan_type", null);
            String strOptString = jSONObject.optString(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE);
            if (TextUtils.isEmpty(strOptString)) {
                cVar.tt = -1;
            } else {
                cVar.tt = Integer.parseInt(strOptString);
            }
        } catch (Throwable th) {
            m.c(th);
        }
        return cVar;
    }
}
