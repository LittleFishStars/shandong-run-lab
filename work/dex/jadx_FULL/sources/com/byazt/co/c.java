package com.byazt.co;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2247, 20})
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28368a;
    public String c;
    public final JSONObject n = new JSONObject();
    public long tt;
    public String uj;
    public String ve;

    public void c(String str) {
        this.c = str;
    }

    public String toString() {
        return "FingerInfo{name='" + this.c + "', duration=" + this.tt + ", data='" + this.ve + "', error='" + this.uj + "'}";
    }

    public void tt(String str) {
        this.ve = str;
    }

    public void ve(String str) {
        this.uj = str;
    }

    public String c() {
        return this.c;
    }

    public JSONObject tt() {
        return this.n;
    }

    public void ve() {
        try {
            this.n.putOpt("duration", Long.valueOf(this.tt));
            if ("d_i0".equals(this.c) || "d_a0".equals(this.c)) {
                this.n.putOpt("data", new JSONObject(this.ve));
            } else {
                this.n.putOpt("data", this.ve);
            }
            this.n.putOpt("errorMsg", this.uj);
        } catch (JSONException e) {
            com.byazt.tf.c.c("__kite json error " + e.getMessage());
        }
    }

    public void c(long j) {
        this.tt = j;
    }

    public void c(int i) {
        this.f28368a = i;
    }
}
