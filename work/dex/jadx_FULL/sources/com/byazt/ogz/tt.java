package com.byazt.ogz;

import com.byazt.nr.m;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1190, 13})
public final class tt {
    public boolean c;
    public String tt;
    public JSONObject uj;
    public long ve = 0;
    public boolean n = uj.tt;

    public static tt c(JSONObject jSONObject) {
        tt ttVar = new tt();
        if (jSONObject != null) {
            ttVar.c(jSONObject.optString("ec_mall_back_url"));
            ttVar.c = jSONObject.optBoolean("sub_process", false);
            ttVar.ve = jSONObject.optLong("init_delay", uj.c);
            ttVar.uj = jSONObject.optJSONObject("live_tob_init_extra");
            ttVar.c(jSONObject.optString("ec_mall_back_url"));
            ttVar.n = jSONObject.optBoolean("init_after_click", uj.tt);
        }
        return ttVar;
    }

    public boolean n() {
        return this.n;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ec_mall_back_url", this.tt);
            jSONObject.put("sub_process", this.c);
            jSONObject.put("init_delay", this.ve);
            jSONObject.put("live_tob_init_extra", this.uj);
            jSONObject.put("init_after_click", this.n);
        } catch (Exception e) {
            m.tt("AppLiveConfig", e);
        }
        return jSONObject.toString();
    }

    public long tt() {
        return this.ve;
    }

    public String uj() {
        return this.tt;
    }

    public JSONObject ve() {
        return this.uj;
    }

    public boolean c() {
        return this.c;
    }

    public void c(String str) {
        this.tt = str;
    }
}
