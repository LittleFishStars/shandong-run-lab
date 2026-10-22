package com.byazt.ete;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 117})
public class rl {
    public int c = 1;
    public int tt = 1;

    public void c(int i) {
        this.c = i;
    }

    public void tt(int i) {
        this.tt = i;
    }

    public JSONObject ve() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("ah", this.c);
            jSONObject.put("am", this.tt);
        } catch (Exception e) {
            com.byazt.nr.m.ve(e.toString());
        }
        return jSONObject;
    }

    public boolean c() {
        return this.c == 1;
    }

    public boolean tt() {
        return this.tt == 1;
    }
}
