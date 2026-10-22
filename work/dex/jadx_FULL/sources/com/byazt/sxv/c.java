package com.byazt.sxv;

import com.byazt.bh.ve;
import com.byazt.kkb.tt;
import com.byazt.nd.uj;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1421, 20})
public class c {
    public static volatile c tt;
    public Map<String, com.byazt.kkb.c> c = new HashMap();

    private c() {
    }

    public static c c() {
        if (tt != null) {
            return tt;
        }
        synchronized (c.class) {
            if (tt != null) {
                return tt;
            }
            c cVar = new c();
            tt = cVar;
            return cVar;
        }
    }

    public void c(String str, com.byazt.kkb.c cVar) {
        this.c.put(str, cVar);
    }

    public void c(String str, com.byazt.cq.c cVar, com.byazt.nd.c cVar2) {
        com.byazt.kkb.c cVar3 = this.c.get(str);
        if (cVar3 == null || cVar == null) {
            return;
        }
        Map<String, Object> mapC = cVar.c();
        uj ujVarN = cVar.n();
        if (ujVarN != null) {
            Map<String, Object> mapC2 = com.byazt.rv.c.c().c(String.valueOf(ujVarN.hashCode()));
            mapC.putAll(mapC2);
            mapC2.clear();
        }
        if (cVar.x() != null && cVar.x().uj() && !ve.c(cVar.x().ve(), cVar.ve(), cVar.c())) {
            cVar.tt(mapC, new com.byazt.qb.c(7599999, "条件不满足"));
            return;
        }
        com.byazt.ow.c cVarC = com.byazt.ow.c.c();
        com.byazt.kkb.c cVarC2 = cVarC.c(cVar3);
        HashMap map = new HashMap();
        if (c(cVar.tt())) {
            map.putAll(cVar.tt());
        }
        if (c(mapC)) {
            map.putAll(mapC);
        }
        cVarC.c(cVarC2, map);
        if (cVarC2 instanceof com.byazt.kkb.ve) {
            ((com.byazt.kkb.ve) cVarC2).c(cVar.tt(), cVar.c(), cVar);
        } else if (cVarC2 instanceof tt) {
            ((tt) cVarC2).c(cVar.tt(), cVar.c(), cVar);
        }
    }

    private boolean c(Map map) {
        return (map == null || map.isEmpty()) ? false : true;
    }
}
