package com.byazt.qx;

import android.content.Context;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 110})
public class qy extends com.byazt.pct.n<JSONObject, JSONObject> {
    public String c;
    public com.byazt.omf.d tt;
    public com.byazt.ete.ic uj;
    public Context ve;

    public qy(String str, com.byazt.omf.d dVar, Context context, com.byazt.ete.ic icVar) {
        this.c = str;
        this.tt = dVar;
        this.ve = context;
        this.uj = icVar;
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.omf.d dVar, Context context, com.byazt.ete.ic icVar) {
        nuVar.c("supportHaptic", (com.byazt.pct.n<?, ?>) new qy("supportHaptic", dVar, context, icVar));
        nuVar.c("playHaptic", (com.byazt.pct.n<?, ?>) new qy("playHaptic", dVar, context, icVar));
        nuVar.c("stopHaptic", (com.byazt.pct.n<?, ?>) new qy("stopHaptic", dVar, context, icVar));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        String str = this.c;
        str.hashCode();
        switch (str) {
            case "stopHaptic":
                Context context = this.ve;
                if (context != null) {
                    com.byazt.fx.ve.tt(context);
                }
                return jSONObject2;
            case "supportHaptic":
                Context context2 = this.ve;
                jSONObject2.put("supportHaptic", context2 != null ? com.byazt.fx.ve.c(context2) : false);
                return jSONObject2;
            case "playHaptic":
                com.byazt.fx.ve.c(jSONObject, this.ve, this.uj);
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }
}
