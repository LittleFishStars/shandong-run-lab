package com.byazt.ete;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 606})
public class tx {
    public boolean c;
    public int tt;

    public tx(JSONObject jSONObject) {
        this.c = jSONObject.optBoolean("enable_reward_callback");
        this.tt = jSONObject.optInt("browse_duration_limit", 10);
    }

    public boolean c() {
        return this.c;
    }

    public int tt() {
        return this.tt;
    }

    public void c(JSONObject jSONObject) {
        JSONObject jSONObject2 = new JSONObject();
        try {
            jSONObject2.put("enable_reward_callback", c());
            jSONObject2.put("browse_duration_limit", tt());
            jSONObject.put("self_reward_callback", jSONObject2);
        } catch (JSONException unused) {
        }
    }
}
