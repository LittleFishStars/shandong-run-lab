package com.byazt.qx;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 129})
public class bm extends com.byazt.pct.n<JSONObject, JSONObject> {
    public com.byazt.omf.d c;

    public bm(com.byazt.omf.d dVar) {
        this.c = dVar;
    }

    public JSONObject ve() {
        JSONObject jSONObject = new JSONObject();
        com.byazt.omf.d dVar = this.c;
        if (dVar != null) {
            return dVar.t();
        }
        try {
            jSONObject.put("code", -1);
            jSONObject.put("codeMsg", "JsObject is null");
            return jSONObject;
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.omf.d dVar) {
        nuVar.c("ShowUgenDownloadDialog", (com.byazt.pct.n<?, ?>) new bm(dVar));
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        return ve();
    }
}
