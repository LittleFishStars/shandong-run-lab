package com.byazt.py;

import android.os.Handler;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1879, 54})
public class ve implements c {
    public Handler c;
    public tt tt;

    @Override // com.byazt.py.c
    public void c(Handler handler, com.byazt.nbs.tt ttVar, tt ttVar2) {
        this.c = handler;
        this.tt = ttVar2;
        if (handler == null || ttVar2 == null || ttVar == null) {
            return;
        }
        ttVar.x().put("serverBidding_timeout", Boolean.FALSE);
        handler.postDelayed(ttVar2, ttVar.da());
    }

    @Override // com.byazt.py.c
    public void c() {
        tt ttVar;
        if (this.c == null || (ttVar = this.tt) == null || ttVar.c()) {
            return;
        }
        this.c.removeCallbacks(this.tt);
        this.tt.run();
    }
}
