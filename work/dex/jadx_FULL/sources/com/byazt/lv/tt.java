package com.byazt.lv;

import com.byazt.pm.a;
import com.byazt.sz.m;
import com.byazt.sz.rh;
import com.byazt.xj.ve;
import org.json.JSONObject;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 2171, 13})
public abstract class tt implements rh {
    public rh c;
    public String tt;
    public JSONObject uj;
    public boolean ve = true;
    public boolean n = false;

    public tt(rh rhVar) {
        this.c = rhVar;
    }

    public void c(JSONObject jSONObject) {
        this.uj = jSONObject;
    }

    public void tt(boolean z) {
        this.n = z;
    }

    public abstract void ve(m mVar, rh.tt ttVar, rh.c cVar);

    public void c(String str) {
        this.tt = str;
    }

    public void tt(m mVar, rh.tt ttVar, rh.c cVar) {
        rh rhVar = this.c;
        if (rhVar == null) {
            return;
        }
        rhVar.c(mVar, ttVar, cVar);
    }

    public void c(boolean z) {
        this.ve = z;
    }

    public boolean c() {
        String str;
        return this.ve && (str = this.tt) != null && "3".compareTo(str) <= 0 && this.uj != null;
    }

    @Override // com.byazt.sz.rh
    public void c(m mVar, rh.tt ttVar, rh.c cVar) {
        if (c()) {
            ve(mVar, ttVar, cVar);
        } else {
            tt(mVar, ttVar, cVar);
        }
    }

    @Override // com.byazt.sz.rh
    public void c(ve veVar, String str, a.c cVar) {
        rh rhVar = this.c;
        if (rhVar == null) {
            return;
        }
        rhVar.c(veVar, str, cVar);
    }
}
