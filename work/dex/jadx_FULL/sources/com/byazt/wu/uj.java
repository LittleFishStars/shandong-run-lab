package com.byazt.wu;

import android.text.TextUtils;
import com.byazt.ete.ic;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1128, 15})
public class uj {
    public static boolean c(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        try {
            JSONArray jSONArray = new JSONArray(str);
            int length = jSONArray.length();
            for (int i = 0; i < length; i++) {
                JSONObject jSONObject = jSONArray.getJSONObject(i);
                if (jSONObject != null) {
                    String strOptString = jSONObject.optString("name", null);
                    if (TextUtils.equals(strOptString, "ec_reward_gold") || TextUtils.equals(strOptString, "reward_gold") || TextUtils.equals(strOptString, "auth_reward_gold")) {
                        return false;
                    }
                }
            }
            return true;
        } catch (Throwable unused) {
            return true;
        }
    }

    public static boolean c(ic icVar) {
        JSONObject jSONObjectN;
        com.byazt.lo.c cVarOs = icVar.os();
        return (cVarOs == null || (jSONObjectN = cVarOs.n()) == null || jSONObjectN.optBoolean("landing_type", false)) ? false : true;
    }
}
