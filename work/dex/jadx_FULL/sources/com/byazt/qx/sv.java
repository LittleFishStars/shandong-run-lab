package com.byazt.qx;

import android.text.TextUtils;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 613})
public class sv extends com.byazt.pct.n<JSONObject, JSONObject> {
    public final com.byazt.omf.d c;

    public sv(com.byazt.omf.d dVar) {
        this.c = dVar;
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.omf.d dVar) {
        nuVar.c("sendLog", (com.byazt.pct.n<?, ?>) new sv(dVar));
    }

    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        long j;
        JSONObject jSONObjectU;
        com.byazt.at.n nVar;
        JSONObject jSONObject2 = new JSONObject();
        try {
            if (jSONObject != null) {
                JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("extJson");
                if (jSONObjectOptJSONObject != null) {
                    String strOptString = jSONObjectOptJSONObject.optString("category");
                    String strOptString2 = jSONObjectOptJSONObject.optString("tag");
                    String strOptString3 = jSONObjectOptJSONObject.optString("label");
                    if (!this.c.a(strOptString3)) {
                        jSONObject2.put("code", 1);
                        jSONObject2.put("msg", "is not reportclickother");
                        return jSONObject2;
                    }
                    com.byazt.ete.ic icVarX = this.c.x();
                    if (com.byazt.ete.qp.tt(icVarX) && TextUtils.equals(strOptString3, "track")) {
                        jSONObject2.put("code", 1);
                        jSONObject2.put("msg", "track is not send");
                        return jSONObject2;
                    }
                    long j2 = 0;
                    try {
                        j = Long.parseLong(jSONObjectOptJSONObject.optString("value"));
                    } catch (Exception unused) {
                        j = 0;
                    }
                    if (j == 0 && icVarX != null) {
                        try {
                            j = Long.parseLong(icVarX.uj());
                        } catch (Exception unused2) {
                        }
                    }
                    try {
                        j2 = Long.parseLong(jSONObjectOptJSONObject.optString("ext_value"));
                    } catch (Exception unused3) {
                    }
                    long j3 = j2;
                    JSONObject jSONObject3 = new JSONObject();
                    String strOptString4 = jSONObjectOptJSONObject.optString("extra");
                    if (!TextUtils.isEmpty(strOptString4)) {
                        try {
                            jSONObject3 = new JSONObject(strOptString4);
                        } catch (Exception unused4) {
                        }
                    }
                    this.c.c(strOptString3, jSONObject3);
                    if ("click".equals(strOptString3)) {
                        jSONObjectU = this.c.u(jSONObject3);
                        WeakReference<com.byazt.at.n> weakReferenceDa = this.c.da();
                        if (weakReferenceDa != null && (nVar = weakReferenceDa.get()) != null) {
                            nVar.tt();
                        }
                    } else {
                        jSONObjectU = jSONObject3;
                    }
                    String strC = this.c.c(strOptString2, strOptString3);
                    String strOptString5 = jSONObjectU.optString("log_extra");
                    if (icVarX != null && strOptString3.contains("sanfang") && TextUtils.isEmpty(strOptString5)) {
                        jSONObjectU.putOpt("log_extra", icVarX.w_());
                    }
                    com.byazt.ddx.uj.c(strOptString, strC, strOptString3, j, j3, jSONObjectU, this.c.nb());
                    jSONObject2.put("code", 0);
                } else {
                    jSONObject2.put("code", 1);
                    jSONObject2.put("msg", "extJson is null");
                }
            } else {
                jSONObject2.put("code", 1);
                jSONObject2.put("msg", "params is null");
            }
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
            jSONObject2.put("code", 1);
            jSONObject2.put("msg", "exception: " + th.getMessage());
        }
        return jSONObject2;
    }
}
