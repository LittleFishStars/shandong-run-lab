package com.byazt.ii;

import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 759, 13})
public class tt {
    public static volatile tt c;

    private tt() {
    }

    public static tt c() {
        if (c == null) {
            synchronized (tt.class) {
                if (c == null) {
                    c = new tt();
                }
            }
        }
        return c;
    }

    public void c(JSONArray jSONArray) {
        if (jSONArray == null) {
            return;
        }
        com.byazt.nys.tt.tt(com.byazt.bp.tt.getContext(), "tt_sdk_test_tool_data_" + com.byazt.bp.c.t().u(), 0).edit().putString("rit_conf", jSONArray.toString()).apply();
    }

    public void c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return;
        }
        com.byazt.nys.tt.tt(com.byazt.bp.tt.getContext(), "tt_sdk_test_tool_data_" + com.byazt.bp.c.t().u(), 0).edit().putString("adn_init_conf", jSONObject.toString()).apply();
    }
}
