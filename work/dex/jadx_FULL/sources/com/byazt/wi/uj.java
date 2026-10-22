package com.byazt.wi;

import android.text.TextUtils;
import com.byazt.bwm.sp;
import com.byazt.ip.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 983, 15})
public class uj implements com.byazt.zyd.ve {
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
        if (veVar == null || TextUtils.isEmpty(veVar.c)) {
            return;
        }
        final String str = veVar.c;
        final long jC = xVar != null ? xVar.c() : System.currentTimeMillis();
        com.byazt.bzd.x.c(new sp("tmax_record_on_ad_end") { // from class: com.byazt.wi.uj.2
            @Override // java.lang.Runnable
            public void run() {
                a.c().uj(str, jC);
            }
        });
    }

    @Override // com.byazt.zyd.ve
    public void tt(com.byazt.ha.ve veVar, x xVar) {
        if (veVar == null || TextUtils.isEmpty(veVar.c)) {
            return;
        }
        final String str = veVar.c;
        final long jC = xVar != null ? xVar.c() : System.currentTimeMillis();
        com.byazt.bzd.x.c(new sp("tmax_record_on_ad_start") { // from class: com.byazt.wi.uj.1
            @Override // java.lang.Runnable
            public void run() {
                a.c().ve(str, jC);
            }
        });
    }

    @Override // com.byazt.zyd.ve
    public void uj(com.byazt.ha.ve veVar, x xVar) {
    }

    @Override // com.byazt.zyd.ve
    public void ve(com.byazt.ha.ve veVar, x xVar) {
    }
}
