package com.byazt.ete;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 46})
public class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28503a;
    public String c;
    public int n;
    public String sp;
    public String tt;
    public int uj;
    public String ve;

    public int a() {
        return this.n;
    }

    public String c() {
        return this.sp;
    }

    public int n() {
        return this.uj;
    }

    public int sp() {
        return this.f28503a;
    }

    public String tt() {
        return this.c;
    }

    public String uj() {
        return this.ve;
    }

    public String ve() {
        return this.tt;
    }

    public JSONObject x() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("app_name", ve());
            jSONObject.put("app_size", sp());
            jSONObject.put("comment_num", a());
            jSONObject.put("download_url", tt());
            jSONObject.put("package_name", uj());
            jSONObject.put("score", n());
        } catch (Exception e) {
            com.byazt.nr.m.ve(e.toString());
        }
        return jSONObject;
    }

    public void c(String str) {
        this.sp = str;
    }

    public void tt(String str) {
        this.c = str;
    }

    public void uj(String str) {
        this.ve = str;
    }

    public void ve(String str) {
        this.tt = str;
    }

    public void c(int i) {
        this.uj = i;
    }

    public void tt(int i) {
        this.n = i;
    }

    public void ve(int i) {
        this.f28503a = i;
    }
}
