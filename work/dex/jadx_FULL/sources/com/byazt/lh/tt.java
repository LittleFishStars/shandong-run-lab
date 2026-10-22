package com.byazt.lh;

import com.byazt.ip.x;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1050, 13})
public class tt extends com.byazt.ip.uj<com.byazt.hi.tt, com.byazt.ha.tt> {
    public final com.byazt.zyd.tt tt = new com.byazt.zyd.tt() { // from class: com.byazt.lh.tt.1
        @Override // com.byazt.zyd.tt
        public void c(com.byazt.ha.tt ttVar, x xVar) {
        }

        @Override // com.byazt.zyd.tt
        public void tt(com.byazt.ha.tt ttVar, x xVar) {
        }

        @Override // com.byazt.zyd.tt
        public void uj(com.byazt.ha.tt ttVar, x xVar) {
            com.byazt.ip.ve veVar;
            m.c("Tmee_lifecycle", "mAdLoadCenterObserver onLoaded");
            if (ttVar == null || ttVar.c() == null || (veVar = (com.byazt.ip.ve) tt.this.c.remove(ttVar.c())) == null) {
                return;
            }
            veVar.tt(tt.this.tt);
        }

        @Override // com.byazt.zyd.tt
        public void ve(com.byazt.ha.tt ttVar, x xVar) {
        }
    };

    public void c(String str, com.byazt.hi.tt ttVar, x xVar) {
        com.byazt.ip.ve<com.byazt.hi.tt, com.byazt.ha.tt> veVarC = c(str);
        if (veVarC instanceof com.byazt.mtp.tt) {
            ((com.byazt.mtp.tt) veVarC).c(ttVar, xVar);
        }
    }

    public void tt(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.mtp.tt ttVar = new com.byazt.mtp.tt(str, str2);
        ttVar.c(this.tt);
        c(str, ttVar);
    }

    public void c(String str, com.byazt.hi.tt ttVar) {
        c(str, ttVar, null);
    }
}
