package com.byazt.rob;

import com.baidu.mapapi.SDKInitializer;
import com.byazt.aas.nb;
import com.byazt.ete.ic;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1211, 54})
public class ve {
    public static void c(ic icVar, boolean z, int i) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put("second_page_type", i);
        } catch (JSONException unused) {
        }
        com.byazt.ddx.uj.tt(icVar, "second_page_jsb_invoke", jSONObject);
    }

    public static void tt(ic icVar, boolean z, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put("second_page_type", i);
            jSONObject.put("origin_req_id", nb.u(icVar));
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, i2);
        } catch (JSONException unused) {
        }
        com.byazt.ddx.uj.tt(icVar, "second_page_show", jSONObject);
    }

    public static void c(ic icVar, boolean z, int i, int i2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("success", z ? 1 : 0);
            jSONObject.put("second_page_type", i);
            jSONObject.put("origin_req_id", nb.u(icVar));
            jSONObject.put(SDKInitializer.SDK_BROADTCAST_INTENT_EXTRA_INFO_KEY_ERROR_CODE, i2);
        } catch (JSONException unused) {
        }
        com.byazt.ddx.uj.tt(icVar, "second_page_request", jSONObject);
    }
}
