package com.ipd.dsp.internal.e1;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class m extends d {
    public int F;
    public String G;
    public String H;
    public boolean I;
    public int J;

    public m(JSONObject jSONObject) throws IllegalStateException, JSONException {
        this.j = jSONObject.optString("order_no");
        this.G = jSONObject.getString("pm_appid");
        this.F = a.a(jSONObject.optString("source"));
        if (!com.ipd.dsp.internal.u0.a.a().a(Integer.valueOf(this.F))) {
            throw new IllegalStateException("Plat [" + this.F + "] not support.");
        }
        com.ipd.dsp.internal.m1.c.a(this.F, this.G);
        this.H = jSONObject.getString("pm_posid");
        this.I = jSONObject.optBoolean("is_bidding");
        this.J = jSONObject.optInt("price");
        this.v = jSONObject.optInt("price", -1);
        this.k = "";
        this.l = "";
        this.n = "";
        this.o = "";
        this.q = new j(null);
        this.r = new b(null);
        this.s = new f(null);
        this.w = new c();
        this.D = new g();
    }
}
