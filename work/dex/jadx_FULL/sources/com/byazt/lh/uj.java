package com.byazt.lh;

import com.byazt.ip.x;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1050, 15})
public class uj extends com.byazt.ip.uj<com.byazt.hi.uj, com.byazt.ha.uj> {
    public final com.byazt.zyd.uj tt = new com.byazt.zyd.uj() { // from class: com.byazt.lh.uj.1
        @Override // com.byazt.zyd.uj
        public void a(com.byazt.ha.uj ujVar, x xVar) {
        }

        @Override // com.byazt.zyd.uj
        public void c(com.byazt.ha.uj ujVar, x xVar) {
        }

        @Override // com.byazt.zyd.uj
        public void da(com.byazt.ha.uj ujVar, x xVar) {
            com.byazt.ip.ve veVar;
            m.c("Tmee_lifecycle", "mAdShowCenterObserver onEnd");
            if (ujVar == null || ujVar.c() == null || (veVar = (com.byazt.ip.ve) uj.this.c.remove(ujVar.c())) == null) {
                return;
            }
            veVar.tt(uj.this.tt);
        }

        @Override // com.byazt.zyd.uj
        public void i(com.byazt.ha.uj ujVar, x xVar) {
        }

        @Override // com.byazt.zyd.uj
        public void n(com.byazt.ha.uj ujVar, x xVar) {
        }

        @Override // com.byazt.zyd.uj
        public void sp(com.byazt.ha.uj ujVar, x xVar) {
        }

        @Override // com.byazt.zyd.uj
        public void tt(com.byazt.ha.uj ujVar, x xVar) {
        }

        @Override // com.byazt.zyd.uj
        public void uj(com.byazt.ha.uj ujVar, x xVar) {
        }

        @Override // com.byazt.zyd.uj
        public void ve(com.byazt.ha.uj ujVar, x xVar) {
        }

        @Override // com.byazt.zyd.uj
        public void x(com.byazt.ha.uj ujVar, x xVar) {
        }
    };

    public void c(String str, com.byazt.hi.uj ujVar, x xVar) {
        com.byazt.ip.ve<com.byazt.hi.uj, com.byazt.ha.uj> veVarC = c(str);
        if (veVarC instanceof com.byazt.mtp.uj) {
            ((com.byazt.mtp.uj) veVarC).c(ujVar, xVar);
        }
    }

    public void tt(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.mtp.uj ujVar = new com.byazt.mtp.uj(str, str2);
        ujVar.c(this.tt);
        c(str, ujVar);
    }

    public void c(String str, com.byazt.hi.uj ujVar) {
        c(str, ujVar, null);
    }
}
