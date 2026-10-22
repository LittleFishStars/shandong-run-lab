package com.byazt.cf;

import com.byazt.aas.rl;
import com.byazt.ete.h;
import com.byazt.ete.ic;
import com.byazt.ete.lt;
import com.byazt.ete.or;
import com.byazt.omf.gt;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 18, 20})
public class c extends n<com.byazt.yi.tt> {
    public c(com.byazt.iu.tt ttVar) {
        super(ttVar);
    }

    @Override // com.byazt.cf.n
    public boolean c() {
        return false;
    }

    @Override // com.byazt.cf.n
    public /* synthetic */ void tt(com.byazt.dj.tt ttVar, List list, com.byazt.yi.tt ttVar2) {
        c(ttVar, (List<ic>) list, ttVar2);
    }

    @Override // com.byazt.vvt.tt
    public void c(com.byazt.dj.tt ttVar, List<ic> list, com.byazt.vvt.tt.c<com.byazt.yi.tt> cVar) {
        com.byazt.yi.tt ttVar2 = new com.byazt.yi.tt(gt.getContext(), list.get(0), ttVar);
        if (cVar != null) {
            cVar.c(ttVar2);
        }
    }

    @Override // com.byazt.cf.n
    public boolean c(com.byazt.ete.c cVar) {
        List<ic> listTt;
        if (cVar != null && (listTt = cVar.tt()) != null) {
            ic icVar = listTt.get(0);
            if (h.c(icVar)) {
                return icVar.zo().ve() != 1;
            }
            if (or.tt(c(), icVar, false) && or.uj(icVar) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.cf.n
    public void c(com.byazt.yi.tt ttVar) {
        ttVar.setVideoCacheCallbackResult(1);
    }

    public void c(com.byazt.dj.tt ttVar, List<ic> list, com.byazt.yi.tt ttVar2) {
        ic icVar = list.get(0);
        if (icVar.uv() <= 0) {
            ttVar2.setExpirationTimestamp(System.currentTimeMillis() + 10500000);
        } else {
            ttVar2.setExpirationTimestamp(icVar.uv() * 1000);
        }
        if (com.byazt.ex.c.c(icVar) || rl.ve(icVar) || lt.c(icVar) || !icVar.up()) {
            return;
        }
        ttVar2.setPreload();
    }
}
