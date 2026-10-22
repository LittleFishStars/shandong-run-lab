package com.byazt.ix;

import com.byazt.nr.m;
import com.bytedance.sdk.openadsdk.mediation.MediationConstant;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1677, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28670a;
    public int c;
    public int n;
    public int sp;
    public int tt;
    public String uj;
    public String ve;

    public String c() {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(MediationConstant.KEY_REASON, this.c);
            jSONObject.put("fill_error_code", this.tt);
            jSONObject.put("fill_error_msg", this.ve);
            jSONObject.put("mediation_rit", this.uj);
            jSONObject.put("load_sort", this.n);
            jSONObject.put("show_sort", this.f28670a);
            jSONObject.put("has_shown", this.sp);
            return jSONObject.toString();
        } catch (JSONException e) {
            m.c(e);
            return "{\"name\": \"json err\"}";
        }
    }

    public void n(int i) {
        this.f28670a = i;
    }

    public void tt(int i) {
        this.c = i;
    }

    public void uj(int i) {
        this.n = i;
    }

    public void ve(int i) {
        this.tt = i;
    }

    public void tt(String str) {
        this.uj = str;
    }

    public void c(int i) {
        this.sp = i;
    }

    public void c(String str) {
        this.ve = str;
    }
}
