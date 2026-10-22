package com.byazt.lh;

import com.byazt.ip.x;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1050, 20})
public class c extends com.byazt.ip.uj<com.byazt.hi.c, com.byazt.ha.c> {
    public final com.byazt.zyd.c tt = new com.byazt.zyd.c() { // from class: com.byazt.lh.c.1
        @Override // com.byazt.zyd.c
        public void a(com.byazt.ha.c cVar, x xVar) {
        }

        @Override // com.byazt.zyd.c
        public void c(com.byazt.ha.c cVar, x xVar) {
        }

        @Override // com.byazt.zyd.c
        public void da(com.byazt.ha.c cVar, x xVar) {
            com.byazt.ip.ve veVar;
            m.c("Tmee_lifecycle", "mAdDownloadLifecycleObserver onEnd");
            if (cVar == null || cVar.c() == null || (veVar = (com.byazt.ip.ve) c.this.c.remove(cVar.c())) == null) {
                return;
            }
            veVar.tt(c.this.tt);
        }

        @Override // com.byazt.zyd.c
        public void i(com.byazt.ha.c cVar, x xVar) {
        }

        @Override // com.byazt.zyd.c
        public void n(com.byazt.ha.c cVar, x xVar) {
        }

        @Override // com.byazt.zyd.c
        public void sp(com.byazt.ha.c cVar, x xVar) {
        }

        @Override // com.byazt.zyd.c
        public void tt(com.byazt.ha.c cVar, x xVar) {
        }

        @Override // com.byazt.zyd.c
        public void uj(com.byazt.ha.c cVar, x xVar) {
        }

        @Override // com.byazt.zyd.c
        public void ve(com.byazt.ha.c cVar, x xVar) {
        }

        @Override // com.byazt.zyd.c
        public void x(com.byazt.ha.c cVar, x xVar) {
        }
    };

    public void c(String str, com.byazt.hi.c cVar, x xVar) {
        com.byazt.ip.ve<com.byazt.hi.c, com.byazt.ha.c> veVarC = c(str);
        if (veVarC instanceof com.byazt.mtp.c) {
            ((com.byazt.mtp.c) veVarC).c(cVar, xVar);
        }
    }

    public void tt(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.mtp.c cVar = new com.byazt.mtp.c(str, str2);
        cVar.c(this.tt);
        c(str, cVar);
    }

    public void c(String str, com.byazt.hi.c cVar) {
        c(str, cVar, null);
    }
}
