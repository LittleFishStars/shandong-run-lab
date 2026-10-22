package com.byazt.tg;

import com.byazt.nr.m;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1956, 72})
public class da implements i {
    private boolean tt(int i) {
        return com.byazt.k.c.c(i).c("pause_optimise_mistake_click_interval_switch", 0) == 1;
    }

    @Override // com.byazt.tg.i
    public boolean c(com.byazt.dd.tt ttVar, int i, x xVar) {
        if (ttVar == null || !tt(ttVar.my())) {
            return false;
        }
        if (System.currentTimeMillis() - ttVar.lo() > c(ttVar.my())) {
            return false;
        }
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.putOpt("pause_optimise_type", "mistake_click");
        } catch (JSONException e) {
            m.c(e);
        }
        com.byazt.zn.c.c().c("pause_optimise", jSONObject, ttVar);
        return true;
    }

    private long c(int i) {
        return com.byazt.k.c.c(i).c("pause_optimise_mistake_click_interval", 300);
    }
}
