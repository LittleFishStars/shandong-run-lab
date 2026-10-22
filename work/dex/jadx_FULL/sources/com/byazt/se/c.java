package com.byazt.se;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 671, 20})
public abstract class c {
    public Context c;
    public JSONObject uj;
    public String ve = "";
    public final com.byazt.co.c tt = new com.byazt.co.c();

    public c(Context context, JSONObject jSONObject) {
        this.c = context;
        this.uj = jSONObject;
    }

    private String uj() {
        return this.ve;
    }

    public com.byazt.co.c c() {
        try {
            long jCurrentTimeMillis = System.currentTimeMillis();
            String strTt = tt();
            long jCurrentTimeMillis2 = System.currentTimeMillis();
            this.tt.tt(strTt);
            this.tt.c(ve());
            this.tt.c(jCurrentTimeMillis2 - jCurrentTimeMillis);
            this.tt.ve(uj());
            this.tt.ve();
            if (this.uj.has("index")) {
                this.tt.c(this.uj.optInt("index"));
            }
            return this.tt;
        } catch (Exception e) {
            com.byazt.tf.c.tt("__kite" + ve() + " doLoad# error " + e.getMessage());
            return this.tt;
        }
    }

    public abstract String tt();

    public abstract String ve();
}
