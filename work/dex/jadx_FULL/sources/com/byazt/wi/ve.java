package com.byazt.wi;

import com.byazt.bwm.sp;
import com.byazt.ip.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 983, 54})
public class ve implements com.byazt.zyd.tt {
    @Override // com.byazt.zyd.tt
    public void c(com.byazt.ha.tt ttVar, x xVar) {
        if (ttVar == null) {
            return;
        }
        final long jC = xVar != null ? xVar.c() : System.currentTimeMillis();
        final String strC = ttVar.c();
        final int i = ttVar.sp;
        final String str = ttVar.x;
        com.byazt.bzd.x.c(new sp("tmax_record_on_ad_started") { // from class: com.byazt.wi.ve.1
            @Override // java.lang.Runnable
            public void run() {
                a.c().c(strC, i, str, jC);
            }
        });
    }

    @Override // com.byazt.zyd.tt
    public void tt(com.byazt.ha.tt ttVar, x xVar) {
    }

    @Override // com.byazt.zyd.tt
    public void uj(com.byazt.ha.tt ttVar, x xVar) {
        if (ttVar == null) {
            return;
        }
        final String strC = ttVar.c();
        if (ttVar.ve) {
            final long jC = xVar != null ? xVar.c() : System.currentTimeMillis();
            com.byazt.bzd.x.c(new sp("tmax_record_on_ad_loaded") { // from class: com.byazt.wi.ve.2
                @Override // java.lang.Runnable
                public void run() {
                    a.c().c(strC, jC);
                }
            });
        }
    }

    @Override // com.byazt.zyd.tt
    public void ve(com.byazt.ha.tt ttVar, x xVar) {
    }
}
