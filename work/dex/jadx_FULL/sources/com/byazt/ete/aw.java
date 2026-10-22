package com.byazt.ete;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 9})
public class aw {
    public int c;
    public int tt;
    public String uj;
    public String ve;

    public static aw c(String str) {
        try {
            return c(new JSONObject(str));
        } catch (JSONException e) {
            com.byazt.nr.m.tt("LiveSdkConfig", "parse failed:".concat(String.valueOf(e)));
            return new aw();
        }
    }

    public boolean n() {
        return this.c == 1;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ad_live_status", c());
            jSONObject.put("app_id", tt());
            jSONObject.put(com.alipay.sdk.m.m.b.z0, ve());
            jSONObject.put("secure_key", uj());
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        return jSONObject.toString();
    }

    public int tt() {
        return this.tt;
    }

    public String uj() {
        return this.uj;
    }

    public String ve() {
        return this.ve;
    }

    public void tt(int i) {
        this.tt = i;
    }

    public void ve(String str) {
        this.uj = str;
    }

    public void tt(String str) {
        this.ve = str;
    }

    public static aw c(JSONObject jSONObject) {
        aw awVar = new aw();
        awVar.c(jSONObject.optInt("ad_live_status"));
        awVar.tt(jSONObject.optInt("app_id"));
        awVar.tt(jSONObject.optString(com.alipay.sdk.m.m.b.z0));
        awVar.ve(jSONObject.optString("secure_key"));
        return awVar;
    }

    public int c() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }
}
