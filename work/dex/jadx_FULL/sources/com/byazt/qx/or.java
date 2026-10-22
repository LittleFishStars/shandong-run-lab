package com.byazt.qx;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 579})
public class or extends com.byazt.pct.n<JSONObject, JSONObject> {
    public com.byazt.xs.tt c;

    public or(com.byazt.xs.tt ttVar) {
        this.c = ttVar;
    }

    public JSONObject ve() {
        return new JSONObject();
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.xs.tt ttVar) {
        nuVar.c("RendUgenDownloadDialogState", (com.byazt.pct.n<?, ?>) new or(ttVar));
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        c(jSONObject);
        return ve();
    }

    private void c(JSONObject jSONObject) {
        if (jSONObject == null || this.c == null) {
            return;
        }
        int iOptInt = jSONObject.optInt("code");
        if (iOptInt == 200) {
            this.c.c();
        } else {
            this.c.c(iOptInt, jSONObject.optString("errorMsg"));
        }
    }
}
