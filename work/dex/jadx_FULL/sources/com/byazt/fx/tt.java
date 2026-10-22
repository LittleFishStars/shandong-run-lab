package com.byazt.fx;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 839, 13})
public class tt {
    public int c;
    public float n;
    public int tt;
    public float uj;
    public long ve;

    public tt(JSONObject jSONObject) {
        this.c = 0;
        this.tt = 0;
        this.ve = 0L;
        this.uj = 0.1f;
        this.n = 0.1f;
        if (jSONObject == null) {
            return;
        }
        this.c = jSONObject.optInt("time");
        this.tt = jSONObject.optInt("type");
        this.ve = jSONObject.optLong("duration");
        this.uj = (float) jSONObject.optDouble("intensity");
        this.n = (float) jSONObject.optDouble("density");
        if (this.tt == 1 || this.ve < 100) {
            c(100L);
        }
    }

    public int c() {
        return this.c;
    }

    public int getType() {
        return this.tt;
    }

    public long tt() {
        return this.ve;
    }

    public float uj() {
        return this.n;
    }

    public float ve() {
        return this.uj;
    }

    public void c(long j) {
        this.ve = j;
    }
}
