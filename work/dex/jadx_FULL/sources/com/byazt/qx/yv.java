package com.byazt.qx;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 499})
public class yv extends com.byazt.pct.n<JSONObject, JSONObject> {
    public String c;
    public com.byazt.omf.d tt;
    public com.byazt.ete.ic ve;

    public yv(String str, com.byazt.omf.d dVar, com.byazt.ete.ic icVar) {
        this.c = str;
        this.tt = dVar;
        this.ve = icVar;
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.omf.d dVar, com.byazt.ete.ic icVar) {
        nuVar.c("openNewAdPage", (com.byazt.pct.n<?, ?>) new yv("openNewAdPage", dVar, icVar));
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        String str = this.c;
        str.hashCode();
        if (str.equals("openNewAdPage")) {
            if (this.tt != null) {
                int iOptInt = jSONObject.optInt("second_page_type", 0);
                this.tt.n(iOptInt);
                jSONObject2.put("code", 0);
                com.byazt.rob.ve.c(this.ve, true, iOptInt);
            } else {
                jSONObject2.put("code", 1);
                jSONObject2.put("msg", "jsObject is null");
                com.byazt.rob.ve.c(this.ve, false, 0);
            }
        }
        return jSONObject2;
    }
}
