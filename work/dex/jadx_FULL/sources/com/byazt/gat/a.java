package com.byazt.gat;

import com.byazt.ete.pu;
import com.byazt.im.sp;
import com.byazt.im.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 788, 34})
public class a {
    public com.byazt.rf.c c;
    public com.byazt.im.tt tt;
    public ve<x, sp> ve;

    public a(com.byazt.im.tt ttVar, ve<x, sp> veVar) {
        if (ttVar == null || veVar == null) {
            return;
        }
        this.tt = ttVar;
        this.ve = veVar;
        if (ttVar.da() == 1) {
            this.c = new com.byazt.iox.tt();
        } else {
            this.c = new com.byazt.iox.uj();
        }
    }

    public boolean c() {
        return this.c instanceof com.byazt.iox.uj;
    }

    public void tt() {
        com.byazt.im.tt ttVar = this.tt;
        if (ttVar == null || this.ve == null) {
            return;
        }
        com.byazt.rf.c cVar = this.c;
        if (cVar instanceof com.byazt.iox.tt) {
            cVar.c(ttVar, new ve<x, sp>() { // from class: com.byazt.gat.a.1
                @Override // com.byazt.gat.ve
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void ve(x xVar) {
                    if (xVar != null) {
                        xVar.n(false);
                    }
                    a.this.ve.ve(xVar);
                }

                @Override // com.byazt.gat.ve
                public void tt(x xVar) {
                    if (xVar != null) {
                        xVar.n(true);
                    }
                    a.this.ve.tt(xVar);
                    com.byazt.cc.x.c(a.this.tt.sl());
                }

                @Override // com.byazt.gat.ve
                public void c(sp spVar) {
                    a.this.ve.c(spVar);
                }
            });
        } else {
            cVar.c(ttVar, new ve<x, sp>() { // from class: com.byazt.gat.a.2
                @Override // com.byazt.gat.ve
                /* JADX INFO: renamed from: c, reason: merged with bridge method [inline-methods] */
                public void ve(x xVar) {
                    if (xVar != null) {
                        xVar.n(false);
                    }
                    a.this.ve.ve(xVar);
                }

                @Override // com.byazt.gat.ve
                public void tt(x xVar) {
                    if (xVar != null) {
                        xVar.n(true);
                    }
                    a.this.ve.tt(xVar);
                }

                @Override // com.byazt.gat.ve
                public void c(sp spVar) {
                    if (a.this.tt.t() && a.this.tt.tt() != null) {
                        pu.c(a.this.tt.tt(), 1);
                    }
                    new com.byazt.iox.tt().c(a.this.tt, a.this.ve);
                }
            });
        }
    }
}
