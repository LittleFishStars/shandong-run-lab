package com.byazt.iox;

import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.byazt.aas.m;
import com.byazt.aas.yp;
import com.byazt.bzd.sl;
import com.byazt.ete.ic;
import com.byazt.im.sp;
import com.byazt.im.x;
import com.byazt.omf.gt;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, TypedValues.TransitionType.TYPE_TRANSITION_FLAGS, 13})
public class tt implements com.byazt.rf.c {
    public sp c = new sp();

    private void tt(final com.byazt.im.tt ttVar, final com.byazt.gat.ve<x, sp> veVar) {
        if (ttVar == null || veVar == null) {
            return;
        }
        this.c.tt(ttVar.u());
        this.c.c(ttVar.tt());
        if (gt.tt().x(ttVar.x()) == 4) {
            x xVar = new x(ttVar.tt(), ttVar.u());
            xVar.c(false);
            xVar.c(ttVar.c());
            xVar.c(ttVar.ve());
            veVar.tt(xVar);
            return;
        }
        com.byazt.sml.tt ttVarUj = ttVar.uj();
        if (ttVarUj == null) {
            this.c.tt(2);
            this.c.c("image request fail");
            this.c.c(false);
            veVar.c(this.c);
            return;
        }
        com.byazt.dz.c.c("Splash_FullLink", "加载图片素材 " + ttVar.tt().qy());
        m.c(ttVarUj, ttVar.n(), ttVar.a(), new m.c() { // from class: com.byazt.iox.tt.1
            @Override // com.byazt.aas.m.c
            public void c(com.byazt.uph.tt ttVar2, com.byazt.yj.m mVar) {
                x xVar2 = new x(ttVar2, ttVar.tt(), ttVar.u());
                xVar2.c(false);
                xVar2.c(ttVar.c());
                xVar2.n(ttVar.ve());
                if (mVar != null) {
                    xVar2.c(mVar.getHeaders());
                    xVar2.tt(mVar.isLocal());
                    xVar2.tt(yp.c(mVar.getHeaders()));
                    if (mVar.getHttpTime() != null) {
                        xVar2.tt(mVar.getHttpTime().getFirstFrameTime());
                        xVar2.ve(mVar.getHttpTime().getStartRequestTime());
                        xVar2.uj(mVar.getHttpTime().getEndRequestTime());
                    }
                }
                veVar.tt(xVar2);
            }

            @Override // com.byazt.aas.m.c
            public void c() {
                tt.this.c.tt(2);
                tt.this.c.c("load image fail");
                tt.this.c.c(false);
                veVar.c(tt.this.c);
            }
        }, sl.n(), 4, new com.byazt.yj.gt() { // from class: com.byazt.iox.tt.2
            @Override // com.byazt.yj.gt
            public void onStep(int i, Object obj) {
                if (i == 3 && tt.this.c(ttVar)) {
                    x xVar2 = new x(ttVar.tt(), ttVar.u());
                    xVar2.c(false);
                    xVar2.c(ttVar.c());
                    xVar2.c(ttVar.ve());
                    xVar2.uj(true);
                    xVar2.tt(false);
                    veVar.ve(xVar2);
                }
            }
        }, true);
    }

    @Override // com.byazt.rf.c
    public void c(com.byazt.im.tt ttVar, com.byazt.gat.ve<x, sp> veVar) {
        tt(ttVar, veVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean c(com.byazt.im.tt ttVar) {
        ic icVarTt;
        if (ttVar == null || (icVarTt = ttVar.tt()) == null) {
            return false;
        }
        int iEj = icVarTt.ej();
        return iEj == 3 || iEj == 4;
    }
}
