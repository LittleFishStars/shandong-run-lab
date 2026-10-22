package com.byazt.zpd;

import com.byazt.omf.gt;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1919, 20})
public abstract class c {
    /* JADX WARN: Code duplicated, block: B:10:0x0025  */
    public int c(int i) {
        int iOptInt;
        JSONObject jSONObjectKz = gt.tt().kz();
        if (jSONObjectKz == null) {
            iOptInt = -1;
        } else if (tt(i)) {
            iOptInt = jSONObjectKz.optInt("explicit_interval", 0);
        } else if (ve(i)) {
            iOptInt = jSONObjectKz.optInt("ambiguous_interval", 0);
        } else {
            iOptInt = -1;
        }
        if (iOptInt > 86400000) {
            return 86400000;
        }
        return iOptInt;
    }

    public boolean tt(int i) {
        return i == 0 || i == 1;
    }

    public boolean ve(int i) {
        return i == 2 || i == 3;
    }

    public void c(int i, long j, long j2) {
        com.byazt.pf.c cVarC = com.byazt.pf.c.c();
        cVarC.c(i);
        cVarC.c(j, j2);
    }

    public int c(JSONObject jSONObject) {
        if (jSONObject != null) {
            return jSONObject.optInt("delay", 200);
        }
        return 200;
    }
}
