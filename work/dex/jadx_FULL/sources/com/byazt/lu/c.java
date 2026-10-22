package com.byazt.lu;

import com.byazt.yv.da;
import com.byazt.yv.u;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 772, 20})
public class c extends tt {
    public long tt;

    public c(uj ujVar) {
        super(ujVar);
    }

    @Override // com.byazt.lu.tt
    public long c() {
        long jRh = this.c.ve().rh();
        if (jRh < 600000) {
            jRh = 600000;
        }
        return this.tt + jRh;
    }

    @Override // com.byazt.lu.tt
    public long[] tt() {
        return n.ve;
    }

    @Override // com.byazt.lu.tt
    public String uj() {
        return "ab";
    }

    @Override // com.byazt.lu.tt
    public boolean ve() throws JSONException {
        JSONObject jSONObjectC = this.c.uj().c();
        if (this.c.uj().t() == 0 || jSONObjectC == null) {
            return false;
        }
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("header", this.c.uj().c());
        jSONObject.put("magic_tag", "ss_app_log");
        jSONObject.put("_gen_time", jCurrentTimeMillis);
        JSONObject jSONObjectVe = com.byazt.mp.c.ve(com.byazt.mp.c.c(com.byazt.mp.tt.c(this.c.getContext(), this.c.uj().c(), this.c.sp().uj(), true, com.byazt.gj.c.uj()), com.byazt.mp.c.ve), jSONObject);
        if (jSONObjectVe == null) {
            return false;
        }
        com.byazt.gj.c.t().tt(!u.c(com.byazt.gj.c.a(), jSONObjectVe), jSONObjectVe);
        if (da.tt) {
            da.c("getAbConfig ".concat(String.valueOf(jSONObjectVe)), null);
        }
        this.c.uj().c(jSONObjectVe);
        this.tt = jCurrentTimeMillis;
        return true;
    }
}
