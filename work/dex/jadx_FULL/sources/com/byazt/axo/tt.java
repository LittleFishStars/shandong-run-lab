package com.byazt.axo;

import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1724, 13})
public class tt implements c {
    public c c;

    @Override // com.byazt.axo.c
    public void c(JSONObject jSONObject) throws JSONException {
        c cVar = this.c;
        if (cVar != null) {
            cVar.c(jSONObject);
        }
        jSONObject.put("event_ts", System.currentTimeMillis());
    }
}
