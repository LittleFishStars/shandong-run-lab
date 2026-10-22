package com.byazt.ji;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.byazt.pm.sl;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 222, 71})
public class x extends tt implements sp {
    public String sl;
    public String t;

    public x(Context context) {
        super(context);
    }

    private void tt(com.byazt.xj.ve veVar) {
        List<com.byazt.xj.ve<View>> listSp;
        List<tt> listTt;
        if (veVar == null) {
            return;
        }
        com.byazt.pm.i iVarKp = veVar.kp();
        if (iVarKp != null && (listTt = iVarKp.tt("timer")) != null && !listTt.isEmpty()) {
            for (tt ttVar : listTt) {
                if (ttVar instanceof a) {
                    a aVar = (a) ttVar;
                    if (TextUtils.isEmpty(this.sl) || TextUtils.equals(this.sl, aVar.tt())) {
                        aVar.c(this);
                    }
                }
            }
        }
        if (!(veVar instanceof com.byazt.xj.c) || (listSp = ((com.byazt.xj.c) veVar).sp()) == null || listSp.isEmpty()) {
            return;
        }
        Iterator<com.byazt.xj.ve<View>> it = listSp.iterator();
        while (it.hasNext()) {
            tt(it.next());
        }
    }

    @Override // com.byazt.ji.tt
    public boolean c(Object... objArr) {
        Map<String, Object> map = this.n;
        if (map != null && !map.isEmpty()) {
            Object obj = this.n.get("name");
            if (obj != null) {
                this.sl = String.valueOf(obj);
            }
            Object obj2 = this.n.get("state");
            if (obj2 != null) {
                this.t = String.valueOf(obj2);
            }
        }
        com.byazt.xj.ve veVar = this.tt;
        com.byazt.xj.ve veVarTt = veVar.tt(veVar);
        if (veVarTt == null) {
            return false;
        }
        tt(veVarTt);
        return false;
    }

    @Override // com.byazt.ji.sp
    public void c(String str) {
        sl slVar;
        if (TextUtils.equals(this.t, "start") || TextUtils.isEmpty(this.t)) {
            if ((TextUtils.isEmpty(this.sl) || TextUtils.equals(this.sl, str)) && (slVar = this.c) != null) {
                slVar.c(this.tt, this.f28697a, this.ve.tt(), this.ve);
            }
        }
    }

    @Override // com.byazt.ji.sp
    public void tt(String str) {
        sl slVar;
        if (TextUtils.equals(this.t, "complete") || TextUtils.isEmpty(this.t)) {
            if ((TextUtils.isEmpty(this.sl) || TextUtils.equals(this.sl, str)) && (slVar = this.c) != null) {
                slVar.c(this.tt, this.f28697a, this.ve.tt(), this.ve);
            }
        }
    }
}
