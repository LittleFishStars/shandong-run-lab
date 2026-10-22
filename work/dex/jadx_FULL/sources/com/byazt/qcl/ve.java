package com.byazt.qcl;

import com.byazt.ete.ic;
import com.byazt.omf.gt;
import com.zj.adlib.c49;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 578, 54})
public class ve {
    public static void c(final tt ttVar, final ic icVar, final com.byazt.ip.c cVar) {
        if (gt.tt().ge()) {
            com.byazt.jze.tt.c().post(new Runnable() { // from class: com.byazt.qcl.ve.1
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        JSONObject jSONObjectVe = ve.ve(ttVar, icVar, cVar);
                        if (jSONObjectVe != null) {
                            com.byazt.feb.c.c().c(jSONObjectVe);
                        }
                    } catch (Throwable unused) {
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static JSONObject ve(tt ttVar, ic icVar, com.byazt.ip.c cVar) {
        if (ttVar != null && cVar != null) {
            try {
                JSONObject jSONObject = new JSONObject();
                String strTt = ttVar.tt();
                String strC = ttVar.c();
                jSONObject.putOpt("lifecycle_id", cVar.c());
                jSONObject.putOpt("type", strTt + c49.f40900a + strC);
                jSONObject.putOpt("l_type", strTt);
                jSONObject.putOpt("state", strC);
                jSONObject.putOpt("state_num", uj.c(ttVar));
                if (ttVar.uj() != -1) {
                    jSONObject.putOpt("source", Integer.valueOf(ttVar.uj()));
                }
                jSONObject.putOpt("ts", Long.valueOf(ttVar.ve()));
                if (icVar != null) {
                    JSONObject jSONObject2 = new JSONObject();
                    jSONObject2.putOpt("aid", icVar.uj());
                    jSONObject2.putOpt("cid", icVar.gu());
                    jSONObject2.putOpt("req_id", icVar.qy());
                    int i = cVar.sp;
                    if (i > 0) {
                        jSONObject2.putOpt("ad_type", Integer.valueOf(i));
                    }
                    jSONObject.putOpt("material", jSONObject2);
                }
                return jSONObject;
            } catch (Exception unused) {
            }
        }
        return null;
    }
}
