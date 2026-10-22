package com.byazt.lh;

import com.byazt.ip.x;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1050, 34})
public class a extends com.byazt.ip.uj<com.byazt.hi.a, com.byazt.ha.a> {
    public final com.byazt.zyd.a tt = new com.byazt.zyd.a() { // from class: com.byazt.lh.a.1
        @Override // com.byazt.zyd.a
        public void c(com.byazt.ha.a aVar, x xVar) {
        }

        @Override // com.byazt.zyd.a
        public void tt(com.byazt.ha.a aVar, x xVar) {
        }

        @Override // com.byazt.zyd.a
        public void uj(com.byazt.ha.a aVar, x xVar) {
            com.byazt.ip.ve veVar;
            m.c("Tmee_lifecycle", "mAppLifecycleObserver onEnd");
            if (aVar == null || aVar.c() == null || (veVar = (com.byazt.ip.ve) a.this.c.remove(aVar.c())) == null) {
                return;
            }
            veVar.tt(a.this.tt);
        }

        @Override // com.byazt.zyd.a
        public void ve(com.byazt.ha.a aVar, x xVar) {
        }
    };

    public void c(String str, com.byazt.hi.a aVar, x xVar) {
        com.byazt.ip.ve<com.byazt.hi.a, com.byazt.ha.a> veVarC = c(str);
        if (veVarC instanceof com.byazt.mtp.a) {
            ((com.byazt.mtp.a) veVarC).c(aVar, xVar);
        }
    }

    public void tt(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.mtp.a aVar = new com.byazt.mtp.a(str, str2);
        aVar.c(this.tt);
        c(str, aVar);
    }

    public void c(String str, com.byazt.hi.a aVar) {
        c(str, aVar, null);
    }
}
