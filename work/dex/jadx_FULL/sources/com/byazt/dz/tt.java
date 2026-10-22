package com.byazt.dz;

import android.text.TextUtils;
import com.byazt.nr.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 106, 13})
public class tt {
    public int c;
    public int tt;
    public boolean uj;
    public int ve;

    public int c() {
        return this.c;
    }

    public String toString() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("expire_days", tt());
            jSONObject.put("log_level", c());
            jSONObject.put("max_size", ve());
            jSONObject.put("is_open", uj());
        } catch (JSONException e) {
            m.c(e);
        }
        return jSONObject.toString();
    }

    public int tt() {
        return this.tt;
    }

    public boolean uj() {
        return this.uj;
    }

    public int ve() {
        return this.ve;
    }

    public void c(int i) {
        this.c = i;
    }

    public void tt(int i) {
        this.tt = i;
    }

    public void ve(int i) {
        this.ve = i;
    }

    public static tt c(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return c(new JSONObject(str));
        } catch (JSONException e) {
            m.tt("CLogConfig", "parse failed:".concat(String.valueOf(e)));
            return null;
        }
    }

    public static tt c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        tt ttVar = new tt();
        ttVar.tt(jSONObject.optInt("expire_days"));
        ttVar.c(jSONObject.optInt("log_level"));
        ttVar.ve(jSONObject.optInt("max_size"));
        ttVar.c(jSONObject.optBoolean("is_open"));
        return ttVar;
    }

    public void c(boolean z) {
        this.uj = z;
    }
}
