package com.byazt.ky;

import com.byazt.ete.ic;
import com.byazt.omf.rl;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 677, 20})
public class c implements com.byazt.zyd.c {
    public com.byazt.ha.c c;
    public boolean tt = false;
    public boolean ve = false;

    private void c(com.byazt.ha.c cVar) {
        if (this.c == null) {
            this.c = cVar;
        }
    }

    @Override // com.byazt.zyd.c
    public void a(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        c(cVar);
        this.ve = true;
    }

    @Override // com.byazt.zyd.c
    public void c(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
    }

    @Override // com.byazt.zyd.c
    public void da(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        ic icVar;
        if (this.tt || xVar == null || xVar.c("source") == null || !this.ve || (icVar = cVar.i) == null || !icVar.bm() || cVar.i.lr() || !cVar.i.hs() || !xVar.c("source").equals(1)) {
            return;
        }
        this.tt = true;
        com.byazt.ocd.tt ttVar = (com.byazt.ocd.tt) rl.c(cVar.i.rl(), com.byazt.ocd.tt.class);
        if (ttVar != null) {
            cVar.i.n(true);
            com.byazt.ddx.uj.c(cVar.i, 2);
            ttVar.c(5, null);
        }
    }

    @Override // com.byazt.zyd.c
    public void i(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        ic icVar;
        c(cVar);
        this.ve = true;
        if (!this.tt && (icVar = cVar.i) != null && icVar.bm() && !cVar.i.lr() && cVar.i.hs() && cVar.i.ne() == 1) {
            this.tt = true;
            cVar.i.n(true);
            com.byazt.ocd.tt ttVar = (com.byazt.ocd.tt) rl.c(cVar.i.rl(), com.byazt.ocd.tt.class);
            if (ttVar != null) {
                com.byazt.ddx.uj.c(cVar.i, 1);
                ttVar.c(5, null);
            }
        }
    }

    @Override // com.byazt.zyd.c
    public void n(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        c(cVar);
        this.ve = true;
    }

    @Override // com.byazt.zyd.c
    public void sp(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        com.byazt.ocd.tt ttVar;
        c(cVar);
        this.ve = true;
        ic icVar = cVar.i;
        if (icVar == null || icVar.ne() != 1 || (ttVar = (com.byazt.ocd.tt) rl.c(cVar.i.rl(), com.byazt.ocd.tt.class)) == null) {
            return;
        }
        ttVar.c(6, null);
    }

    @Override // com.byazt.zyd.c
    public void tt(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        c(cVar);
        this.ve = true;
    }

    @Override // com.byazt.zyd.c
    public void uj(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        c(cVar);
        this.ve = true;
    }

    @Override // com.byazt.zyd.c
    public void ve(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        c(cVar);
        this.ve = true;
    }

    @Override // com.byazt.zyd.c
    public void x(com.byazt.ha.c cVar, com.byazt.ip.x xVar) {
        c(cVar);
        this.ve = true;
    }
}
