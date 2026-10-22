package com.byazt.qx;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 158})
public class sl extends com.byazt.pct.n<JSONObject, JSONObject> {
    public com.byazt.ete.ic c;
    public com.byazt.omf.d tt;

    public sl(com.byazt.ete.ic icVar, com.byazt.omf.d dVar) {
        this.c = icVar;
        this.tt = dVar;
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.ete.ic icVar, com.byazt.omf.d dVar) {
        nuVar.c("adViewInfo", (com.byazt.pct.n<?, ?>) new sl(icVar, dVar));
    }

    @Override // com.byazt.pct.n
    @Nullable
    public JSONObject c(@NonNull JSONObject jSONObject, @NonNull com.byazt.pct.a aVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("container", this.tt.c());
        jSONObject2.put("creative", this.tt.tt());
        return jSONObject2;
    }
}
