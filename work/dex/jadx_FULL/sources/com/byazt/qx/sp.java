package com.byazt.qx;

import com.ali.auth.third.login.LoginConstants;
import java.lang.ref.WeakReference;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 91})
public class sp extends com.byazt.pct.uj<JSONObject, JSONObject> {
    public WeakReference<com.byazt.omf.d> c;

    public sp(com.byazt.omf.d dVar) {
        this.c = new WeakReference<>(dVar);
    }

    @Override // com.byazt.pct.uj
    public void uj() {
    }

    public static void c(com.byazt.pct.nu nuVar, final com.byazt.omf.d dVar) {
        nuVar.c("commonConvert", new com.byazt.pct.uj.tt() { // from class: com.byazt.qx.sp.1
            @Override // com.byazt.pct.uj.tt
            public com.byazt.pct.uj c() {
                return new sp(dVar);
            }
        });
    }

    @Override // com.byazt.pct.uj
    public void c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        com.byazt.lo.c cVarOs;
        JSONObject jSONObjectTt;
        com.byazt.omf.x.m().hd();
        JSONObject jSONObject2 = new JSONObject();
        com.byazt.ete.ic icVarC = null;
        try {
            try {
                WeakReference<com.byazt.omf.d> weakReference = this.c;
                if (weakReference == null) {
                    com.byazt.ukr.yp.c().c("commonConvert", "js", 1, jSONObject2);
                    com.byazt.apd.tt.c().uj(null);
                    return;
                }
                com.byazt.omf.d dVar = weakReference.get();
                if (dVar == null) {
                    ve();
                    com.byazt.ukr.yp.c().c("commonConvert", "js", 2, jSONObject2);
                    com.byazt.apd.tt.c().uj(null);
                    return;
                }
                if (jSONObject == null) {
                    com.byazt.ukr.yp.c().c("commonConvert", "js", 3, jSONObject2);
                    com.byazt.apd.tt.c().uj(null);
                    return;
                }
                icVarC = com.byazt.omf.c.c(jSONObject);
                int iOptInt = jSONObject.optInt("j_live_saas_param_interaction_type", -1);
                int iOptInt2 = jSONObject.optInt("j_download_adapter_mode", 0);
                int iOptInt3 = jSONObject.optInt("j_common_convert_source", 0);
                if (icVarC == null) {
                    com.byazt.ukr.yp.c().c("commonConvert", "js", 4, jSONObject2);
                    com.byazt.apd.tt.c().uj(icVarC);
                    return;
                }
                icVarC.c(true);
                jSONObject2.putOpt("live_interaction_type", Integer.valueOf(icVarC.n()));
                jSONObject2.putOpt(LoginConstants.EXT, icVarC.w_());
                if (icVarC.my() == null && (cVarOs = icVarC.os()) != null && (jSONObjectTt = cVarOs.tt()) != null) {
                    icVarC.c(com.byazt.ete.yp.c(jSONObjectTt));
                }
                dVar.c(iOptInt3, icVarC, iOptInt, iOptInt2);
                com.byazt.ukr.yp.c().c("commonConvert", "js", 0, jSONObject2);
                com.byazt.apd.tt.c().uj(icVarC);
                try {
                    JSONObject jSONObject3 = new JSONObject();
                    jSONObject3.put("code", 200);
                    c(jSONObject3);
                } catch (Exception e) {
                    com.byazt.nr.m.c("xeasy", e.getMessage());
                }
            } catch (Throwable th) {
                com.byazt.ukr.yp.c().c("commonConvert", "js", 0, jSONObject2);
                com.byazt.apd.tt.c().uj(null);
                throw th;
            }
        } catch (Exception e2) {
            com.byazt.nr.m.c(e2);
        }
    }
}
