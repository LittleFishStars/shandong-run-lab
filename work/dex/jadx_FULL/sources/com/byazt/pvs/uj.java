package com.byazt.pvs;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 705, 15})
public class uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28960a;
    public String c;
    public JSONObject n;
    public String tt;
    public int uj;
    public boolean ve;

    public uj(String str, String str2, boolean z, int i, JSONObject jSONObject, int i2) {
        this.c = str;
        this.tt = str2;
        this.ve = z;
        this.uj = i;
        this.n = jSONObject;
        this.f28960a = i2;
    }

    public JSONObject c() {
        if (this.n == null) {
            this.n = new JSONObject();
        }
        return this.n;
    }

    public int n() {
        return this.uj;
    }

    public String tt() {
        return this.c;
    }

    public boolean uj() {
        return this.ve;
    }

    public String ve() {
        return this.tt;
    }

    public void c(int i) {
        this.uj = i;
    }
}
