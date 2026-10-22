package com.byazt.aas;

import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 131, 67})
public class u {
    public static boolean c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        JSONObject jSONObjectGx = com.byazt.omf.gt.tt().gx();
        if (jSONObjectGx == null) {
            return false;
        }
        return jCurrentTimeMillis >= jSONObjectGx.optLong("start", 1707480000000L) && jCurrentTimeMillis <= jSONObjectGx.optLong("end", 1707498000000L);
    }

    public static boolean tt() {
        JSONObject jSONObjectGx = com.byazt.omf.gt.tt().gx();
        return jSONObjectGx != null && c() && jSONObjectGx.optInt("force_drop", 0) == 1;
    }
}
