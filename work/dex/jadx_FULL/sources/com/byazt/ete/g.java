package com.byazt.ete;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 954})
public class g {
    public JSONObject c;
    public boolean n;
    public int tt;
    public String uj;
    public String ve;

    public g(JSONObject jSONObject) {
        if (jSONObject != null) {
            this.c = jSONObject;
            this.tt = jSONObject.optInt("dialog_type");
            this.ve = jSONObject.optString("template_url");
            this.uj = jSONObject.optString("template_md5");
        }
        com.byazt.seg.c cVar = new com.byazt.seg.c();
        cVar.tt(n());
        cVar.ve(uj());
    }

    public boolean a() {
        return this.n;
    }

    public JSONObject c() {
        return this.c;
    }

    public String n() {
        return this.uj;
    }

    public JSONObject tt() {
        return this.c;
    }

    public String uj() {
        return this.ve;
    }

    public int ve() {
        return this.tt;
    }

    public void c(boolean z) {
        this.n = z;
    }
}
