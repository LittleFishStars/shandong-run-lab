package com.byazt.dbo;

import com.byazt.ete.ic;
import com.byazt.nr.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 961, 54})
public final class ve {
    public static void c(ic icVar, JSONObject jSONObject) {
        if (icVar == null || jSONObject == null) {
            return;
        }
        icVar.x(jSONObject.optLong("correct_action_code", -1L));
        icVar.i(jSONObject.optLong("correct_result_code", -1L));
        icVar.da(jSONObject.optLong("cali_timestamp", -1L));
    }

    public static void c(ic icVar, JSONObject jSONObject, boolean z) {
        if (icVar == null || jSONObject == null) {
            return;
        }
        long jXw = icVar.xw();
        long jTu = icVar.tu();
        long jRa = icVar.ra();
        try {
            jSONObject.put("correct_action_code", jXw);
            jSONObject.put("correct_result_code", jTu);
            if (z) {
                jSONObject.put("cali_timestamp", jRa);
            }
        } catch (JSONException e) {
            m.ve("CaliTrackUtils", "putCaliExtra error", e);
        }
    }
}
