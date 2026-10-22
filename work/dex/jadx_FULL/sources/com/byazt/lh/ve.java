package com.byazt.lh;

import com.byazt.ip.x;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1050, 54})
public class ve extends com.byazt.ip.uj<com.byazt.hi.ve, com.byazt.ha.ve> {
    public final com.byazt.zyd.ve tt = new com.byazt.zyd.ve() { // from class: com.byazt.lh.ve.1
        @Override // com.byazt.zyd.ve
        public void a(com.byazt.ha.ve veVar, x xVar) {
        }

        @Override // com.byazt.zyd.ve
        public void c(com.byazt.ha.ve veVar, x xVar) {
        }

        @Override // com.byazt.zyd.ve
        public void n(com.byazt.ha.ve veVar, x xVar) {
        }

        @Override // com.byazt.zyd.ve
        public void sp(com.byazt.ha.ve veVar, x xVar) {
            com.byazt.ip.ve veVar2;
            m.c("Tmee_lifecycle", "mAdShowCenterObserver onEnd");
            if (veVar == null || veVar.c() == null || (veVar2 = (com.byazt.ip.ve) ve.this.c.remove(veVar.c())) == null) {
                return;
            }
            veVar2.tt(ve.this.tt);
        }

        @Override // com.byazt.zyd.ve
        public void tt(com.byazt.ha.ve veVar, x xVar) {
        }

        @Override // com.byazt.zyd.ve
        public void uj(com.byazt.ha.ve veVar, x xVar) {
        }

        @Override // com.byazt.zyd.ve
        public void ve(com.byazt.ha.ve veVar, x xVar) {
        }
    };

    public void c(String str, com.byazt.hi.ve veVar, x xVar) {
        com.byazt.ip.ve<com.byazt.hi.ve, com.byazt.ha.ve> veVarC = c(str);
        if (veVarC instanceof com.byazt.mtp.ve) {
            ((com.byazt.mtp.ve) veVarC).c(veVar, xVar);
        }
    }

    public void tt(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.mtp.ve veVar = new com.byazt.mtp.ve(str, str2);
        veVar.c(this.tt);
        c(str, veVar);
    }

    public void c(String str, com.byazt.hi.ve veVar) {
        c(str, veVar, null);
    }
}
