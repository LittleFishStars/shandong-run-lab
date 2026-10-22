package com.byazt.qx;

import com.byazt.ete.kp;
import java.lang.ref.WeakReference;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 163, 17})
public class gu extends com.byazt.pct.n<JSONObject, JSONObject> {
    public final WeakReference<com.byazt.omf.d> c;
    public final String tt;

    public gu(com.byazt.omf.d dVar, String str) {
        this.c = new WeakReference<>(dVar);
        this.tt = str;
    }

    public static void c(com.byazt.pct.nu nuVar, com.byazt.omf.d dVar) {
        nuVar.c("interactiveStart", (com.byazt.pct.n<?, ?>) new gu(dVar, "interactiveStart"));
        nuVar.c("interactiveFinish", (com.byazt.pct.n<?, ?>) new gu(dVar, "interactiveFinish"));
        nuVar.c("interactiveEnd", (com.byazt.pct.n<?, ?>) new gu(dVar, "interactiveEnd"));
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    @Override // com.byazt.pct.n
    public JSONObject c(JSONObject jSONObject, com.byazt.pct.a aVar) throws Exception {
        JSONObject jSONObject2 = new JSONObject();
        if (this.c.get() == null) {
            return jSONObject2;
        }
        com.byazt.omf.d dVar = this.c.get();
        com.byazt.ete.ic icVarX = dVar.x();
        String str = this.tt;
        str.hashCode();
        int i = 0;
        boolean z = true;
        switch (str) {
            case "interactiveStart":
                dVar.rh();
                return jSONObject2;
            case "interactiveEnd":
                dVar.my();
                return jSONObject2;
            case "interactiveFinish":
                try {
                    if (jSONObject.optInt("finish", 1) != 1) {
                        z = false;
                    }
                    int iC = c(icVarX, jSONObject.optInt("reduce_duration", -1));
                    if (z) {
                        dVar.uj(iC);
                    } else {
                        i = -1;
                    }
                    jSONObject2.put("code", i);
                    jSONObject2.put("reduce_duration", iC);
                    break;
                } catch (JSONException e) {
                    com.byazt.nr.m.c(e);
                }
                return jSONObject2;
            default:
                return jSONObject2;
        }
    }

    public static int c(com.byazt.ete.ic icVar, int i) {
        int iMc = icVar != null ? icVar.mc() : 0;
        if (i >= 0 && iMc >= 0) {
            i = Math.min(i, iMc);
        } else if (i < 0) {
            i = iMc >= 0 ? iMc : 0;
        }
        if (kp.n(icVar)) {
            return 0;
        }
        return i;
    }
}
