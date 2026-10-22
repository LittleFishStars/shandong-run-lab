package com.byazt.qx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 577})
public class pf extends com.byazt.pct.n<JSONObject, JSONObject> {
    public final String c;

    public pf(String str) {
        this.c = str;
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.ete.ic icVar) {
        nuVar.c("sendElement", (com.byazt.pct.n<?, ?>) new pf(icVar.zm()));
    }

    @Override // com.byazt.pct.n
    @Nullable
    public JSONObject c(@NonNull JSONObject jSONObject, @NonNull com.byazt.pct.a aVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.rgb.tt.c(this.c, 0, jSONObject);
        jSONObject2.put("code", 0);
        return jSONObject2;
    }
}
