package com.byazt.lh;

import com.byazt.ip.x;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1050, 46})
public class n extends com.byazt.ip.uj<com.byazt.hi.n, com.byazt.ha.n> {
    public final com.byazt.zyd.n tt = new com.byazt.zyd.n() { // from class: com.byazt.lh.n.1
        @Override // com.byazt.zyd.n
        public void a(com.byazt.ha.n nVar, x xVar) {
        }

        @Override // com.byazt.zyd.n
        public void c(com.byazt.ha.n nVar, x xVar) {
        }

        @Override // com.byazt.zyd.n
        public void n(com.byazt.ha.n nVar, x xVar) {
        }

        @Override // com.byazt.zyd.n
        public void sp(com.byazt.ha.n nVar, x xVar) {
            com.byazt.ip.ve veVar;
            m.c("Tmee_lifecycle", "mAdViewCenterObserver onEnd");
            if (nVar == null || nVar.c() == null || (veVar = (com.byazt.ip.ve) n.this.c.remove(nVar.c())) == null) {
                return;
            }
            veVar.tt(n.this.tt);
        }

        @Override // com.byazt.zyd.n
        public void tt(com.byazt.ha.n nVar, x xVar) {
        }

        @Override // com.byazt.zyd.n
        public void uj(com.byazt.ha.n nVar, x xVar) {
        }

        @Override // com.byazt.zyd.n
        public void ve(com.byazt.ha.n nVar, x xVar) {
        }
    };

    public void c(String str, com.byazt.hi.n nVar, x xVar) {
        com.byazt.ip.ve<com.byazt.hi.n, com.byazt.ha.n> veVarC = c(str);
        if (veVarC instanceof com.byazt.mtp.n) {
            ((com.byazt.mtp.n) veVarC).c(nVar, xVar);
        }
    }

    public void tt(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.mtp.n nVar = new com.byazt.mtp.n(str, str2);
        nVar.c(this.tt);
        c(str, nVar);
    }

    public void c(String str, com.byazt.hi.n nVar) {
        c(str, nVar, null);
    }
}
