package com.byazt.ete;

import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 8, 518})
public class h {
    public int c;
    public long tt;
    public int ve;

    public static h c(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        h hVar = new h();
        hVar.c = jSONObject.optInt("refresh_control", 0);
        hVar.tt = jSONObject.optLong("refresh_imp_max_time", 0L);
        hVar.ve = jSONObject.optInt("refresh_num", 0);
        return hVar;
    }

    public void tt(JSONObject jSONObject) {
        try {
            jSONObject.put("refresh_control", this.c);
            jSONObject.put("refresh_imp_max_time", this.tt);
            jSONObject.put("refresh_num", this.ve);
        } catch (JSONException unused) {
        }
    }

    public int ve() {
        return this.ve;
    }

    public static boolean ve(ic icVar) {
        return com.byazt.omf.gt.tt().z(String.valueOf(com.byazt.aas.nb.t(icVar))) && c(icVar) && !com.byazt.dl.uj.c(String.valueOf(com.byazt.aas.nb.t(icVar)));
    }

    public long tt() {
        return this.tt;
    }

    public static boolean c(ic icVar) {
        h hVarZo;
        return (icVar == null || (hVarZo = icVar.zo()) == null || hVarZo.c() != 1) ? false : true;
    }

    public static int tt(ic icVar) {
        h hVarZo;
        if (icVar == null || (hVarZo = icVar.zo()) == null) {
            return 0;
        }
        return hVarZo.ve();
    }

    public int c() {
        return this.c;
    }

    public static boolean c(List<ic> list) {
        Iterator<ic> it = list.iterator();
        boolean z = false;
        boolean z2 = false;
        while (it.hasNext()) {
            if (it.next().fr() == 100.0f) {
                z = true;
            } else {
                z2 = true;
            }
        }
        return (z && z2) ? false : true;
    }
}
