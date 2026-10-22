package com.byazt.nn;

import com.byazt.nr.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1020, 71})
public class x {
    public static volatile x c;

    private x() {
    }

    public static x c() {
        if (c == null) {
            synchronized (uj.class) {
                if (c == null) {
                    c = new x();
                }
            }
        }
        return c;
    }

    public void c(int i, int i2, com.byazt.dd.tt ttVar) {
        if (ttVar == null) {
            return;
        }
        com.byazt.k.c cVarC = com.byazt.k.c.c(ttVar.my());
        if (cVarC.c("report_api_hijack", 0) == 0) {
            return;
        }
        int i3 = i2 - i;
        if (i <= 0 || i3 <= cVarC.c("check_api_hijack_version_code_diff", 500)) {
            return;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("version_code_diff", i3);
            jSONObject.put("installed_version_code", i2);
            jSONObject.put("hijack_type", 1);
        } catch (JSONException e) {
            m.c(e);
        }
        com.byazt.zn.c.c().tt("api_hijack", jSONObject, ttVar);
    }
}
