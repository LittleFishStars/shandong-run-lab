package com.byazt.aas;

import android.util.Pair;
import com.alibaba.sdk.android.oss.common.OSSConstants;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 613})
public class sv extends com.byazt.va.n {
    public sv(com.byazt.gqp.t tVar) {
        super(tVar);
    }

    public void c(JSONObject jSONObject, String str) {
        Pair<Integer, ?> pairC;
        Object obj;
        try {
            pairC = com.byazt.by.a.c().c(jSONObject.toString(), str);
        } catch (Throwable th) {
            com.byazt.nr.m.ve(th.getMessage());
            pairC = null;
        }
        if (pairC == null || (obj = pairC.first) == null) {
            com.byazt.ukr.yp.c().c(-1, -1L, str, -1);
            ve(com.byazt.nr.c.c(jSONObject).toString());
        } else {
            if (((Integer) obj).intValue() != 4) {
                c((JSONObject) pairC.second);
                return;
            }
            c(OSSConstants.DEFAULT_OBJECT_CONTENT_TYPE, (byte[]) pairC.second);
            c(true);
            tt("x-pglcypher", String.valueOf(pairC.first));
        }
    }

    public void tt(JSONObject jSONObject, String str) {
        if (com.byazt.omf.gt.tt().sd()) {
            c(jSONObject, str);
        } else {
            ve(com.byazt.nr.c.c(jSONObject).toString());
        }
    }

    public void ve(JSONObject jSONObject, String str) {
        if (com.byazt.omf.gt.tt().di()) {
            c(jSONObject, str);
        } else {
            ve(com.byazt.nr.c.c(jSONObject).toString());
        }
    }
}
