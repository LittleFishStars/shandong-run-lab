package com.byazt.lc;

import com.byazt.bwm.n;
import com.byazt.bwm.sp;
import com.byazt.ete.ic;
import com.byazt.ete.pu;
import com.byazt.ku.uj;
import com.byazt.xs.ve;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1311, 20})
public class c {
    public static void c(ic icVar, final ve veVar) {
        final uj ujVarI;
        if (icVar == null || pu.x(icVar) || (ujVarI = pu.i(icVar)) == null) {
            return;
        }
        n.c(new sp("saveTemplate") { // from class: com.byazt.lc.c.1
            @Override // java.lang.Runnable
            public void run() {
                com.byazt.six.sp.c().c(ujVarI, new com.byazt.six.sp.c() { // from class: com.byazt.lc.c.1.1
                    @Override // com.byazt.six.sp.c
                    public void c() {
                        ve veVar2 = veVar;
                        if (veVar2 != null) {
                            veVar2.c(null);
                        }
                    }

                    @Override // com.byazt.six.sp.c
                    public void tt() {
                        ve veVar2 = veVar;
                        if (veVar2 != null) {
                            veVar2.c();
                        }
                    }
                });
            }
        }, 10);
    }
}
