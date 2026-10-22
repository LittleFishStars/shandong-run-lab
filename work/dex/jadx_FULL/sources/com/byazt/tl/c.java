package com.byazt.tl;

import android.app.Dialog;
import com.byazt.ete.ic;
import com.byazt.ete.pu;
import com.byazt.nc.a;
import com.byazt.ukr.yp;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 467, 20})
public class c implements com.byazt.sif.c {
    public final ic c;

    public c(ic icVar) {
        this.c = icVar;
    }

    @Override // com.byazt.sif.c
    public boolean c(String str, Dialog dialog) {
        return false;
    }

    @Override // com.byazt.sif.c
    public boolean c(a aVar, String str, Dialog dialog) {
        if (!"7:1".equals(aVar.getId())) {
            return false;
        }
        yp.c().tt(new com.byazt.ee.c() { // from class: com.byazt.tl.c.1
            @Override // com.byazt.ee.c
            public com.byazt.qal.c c() throws Exception {
                com.byazt.qal.tt ttVarC = com.byazt.qal.tt.tt().c("stats_feedback_cannot_close");
                if (c.this.c != null) {
                    ttVarC.a(c.this.c.qy()).x(c.this.c.w_());
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("render_control", pu.tt(c.this.c));
                    jSONObject.put("ad_info", c.this.c.mk());
                    jSONObject.put("render_sequence", pu.tt(c.this.c));
                    ttVarC.tt(jSONObject.toString());
                }
                return ttVarC;
            }
        }, "stats_feedback_cannot_close");
        return true;
    }

    public static void c(com.byazt.dyf.tt ttVar, ic icVar) {
        if (ttVar == null || icVar == null) {
            return;
        }
        ttVar.addInterceptor(new c(icVar));
    }
}
