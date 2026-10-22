package com.byazt.ete;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 956})
public class q {
    public int c;
    public int n;
    public int tt;
    public int uj;
    public long ve;

    public static q c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        q qVar = new q();
        qVar.c = jSONObject.optInt("auth_type");
        qVar.tt = jSONObject.optInt("auth_time");
        qVar.ve = jSONObject.optLong("auth_out_time");
        qVar.uj = jSONObject.optInt("video_open_deeplink");
        qVar.n = jSONObject.optInt("reject_in");
        return qVar;
    }

    public int a() {
        return this.n;
    }

    public long n() {
        return this.ve;
    }

    public int tt() {
        return this.c;
    }

    public int uj() {
        return this.uj;
    }

    public int ve() {
        return this.tt;
    }

    public JSONObject c() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("auth_type", this.c);
            jSONObject.put("auth_time", this.tt);
            jSONObject.put("auth_out_time", this.ve);
            jSONObject.put("video_open_deeplink", this.uj);
            jSONObject.put("reject_in", this.n);
        } catch (JSONException e) {
            com.byazt.nr.m.c(e);
        }
        return jSONObject;
    }
}
