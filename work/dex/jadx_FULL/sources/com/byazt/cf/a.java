package com.byazt.cf;

import com.byazt.aas.rl;
import com.byazt.ete.ic;
import com.byazt.ete.lt;
import com.byazt.ete.or;
import com.byazt.omf.gt;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 18, 34})
public class a extends n<com.byazt.yi.ve> {
    public a(com.byazt.iu.tt ttVar) {
        super(ttVar);
    }

    @Override // com.byazt.cf.n
    public boolean c() {
        return true;
    }

    @Override // com.byazt.cf.n
    public /* synthetic */ void tt(com.byazt.dj.tt ttVar, List list, com.byazt.yi.ve veVar) {
        c(ttVar, (List<ic>) list, veVar);
    }

    @Override // com.byazt.vvt.tt
    public void c(com.byazt.dj.tt ttVar, List<ic> list, com.byazt.vvt.tt.c<com.byazt.yi.ve> cVar) {
        com.byazt.yi.ve veVar = new com.byazt.yi.ve(gt.getContext(), list.get(0), ttVar);
        if (cVar != null) {
            cVar.c(veVar);
        }
    }

    @Override // com.byazt.cf.n
    public boolean c(com.byazt.ete.c cVar) {
        List<ic> listTt;
        if (cVar != null && (listTt = cVar.tt()) != null) {
            ic icVar = listTt.get(0);
            if (or.tt(c(), icVar, false) && or.uj(icVar) != 0) {
                return true;
            }
        }
        return false;
    }

    @Override // com.byazt.cf.n
    public void c(com.byazt.yi.ve veVar) {
        veVar.setVideoCacheCallbackResult(1);
    }

    public void c(com.byazt.dj.tt ttVar, List<ic> list, com.byazt.yi.ve veVar) {
        ic icVar = list.get(0);
        if (icVar.uv() <= 0) {
            veVar.setExpirationTimestamp(System.currentTimeMillis() + 10500000);
        } else {
            veVar.setExpirationTimestamp(icVar.uv() * 1000);
        }
        if (com.byazt.ex.c.c(icVar) || rl.ve(icVar) || lt.c(icVar) || !icVar.up()) {
            return;
        }
        veVar.setPreload();
    }
}
