package com.byazt.lh;

import com.byazt.ha.x;
import com.byazt.nr.m;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1050, 91})
public class sp extends com.byazt.ip.uj<com.byazt.hi.sp, x> {
    public final com.byazt.zyd.sp tt = new com.byazt.zyd.sp() { // from class: com.byazt.lh.sp.1
        @Override // com.byazt.zyd.sp
        public void a(x xVar, com.byazt.ip.x xVar2) {
        }

        @Override // com.byazt.zyd.sp
        public void c(x xVar, com.byazt.ip.x xVar2) {
        }

        @Override // com.byazt.zyd.sp
        public void n(x xVar, com.byazt.ip.x xVar2) {
        }

        @Override // com.byazt.zyd.sp
        public void sp(x xVar, com.byazt.ip.x xVar2) {
        }

        @Override // com.byazt.zyd.sp
        public void tt(x xVar, com.byazt.ip.x xVar2) {
        }

        @Override // com.byazt.zyd.sp
        public void uj(x xVar, com.byazt.ip.x xVar2) {
        }

        @Override // com.byazt.zyd.sp
        public void ve(x xVar, com.byazt.ip.x xVar2) {
        }

        @Override // com.byazt.zyd.sp
        public void x(x xVar, com.byazt.ip.x xVar2) {
            com.byazt.ip.ve veVar;
            m.c("Tmee_lifecycle", "mEasyPlayLifecycleObserver onEnd");
            if (xVar == null || xVar.c() == null || (veVar = (com.byazt.ip.ve) sp.this.c.remove(xVar.c())) == null) {
                return;
            }
            veVar.tt(sp.this.tt);
        }
    };

    public void c(String str, com.byazt.hi.sp spVar, com.byazt.ip.x xVar) {
        com.byazt.ip.ve<com.byazt.hi.sp, x> veVarC = c(str);
        if (veVarC instanceof com.byazt.mtp.sp) {
            ((com.byazt.mtp.sp) veVarC).c(spVar, xVar);
        }
    }

    public void tt(String str, String str2) {
        if (str == null) {
            return;
        }
        com.byazt.mtp.sp spVar = new com.byazt.mtp.sp(str, str2);
        spVar.c(this.tt);
        c(str, spVar);
    }

    public void c(String str, com.byazt.hi.sp spVar) {
        c(str, spVar, null);
    }
}
