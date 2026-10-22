package com.byazt.qx;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 215})
public class yp extends com.byazt.pct.n<JSONObject, JSONObject> {
    public JSONObject c;

    public yp(JSONObject jSONObject) {
        this.c = jSONObject;
    }

    public static void c(com.byazt.pct.nu nuVar, JSONObject jSONObject) {
        nuVar.c("getData", (com.byazt.pct.n<?, ?>) new yp(jSONObject));
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        return com.byazt.jlk.tt.c(this.c, jSONObject);
    }
}
