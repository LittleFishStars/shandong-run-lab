package com.byazt.us;

import com.byazt.gq.t;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 251, 46})
public class n implements com.byazt.g.c.InterfaceC0409c {
    public long c;

    @com.byazt.zqa.c(c = {0, 1, 251, 151})
    public static class c {
        public static n c = new n();
    }

    @Override // com.byazt.g.c.InterfaceC0409c
    public void tt() {
        this.c = System.currentTimeMillis();
    }

    @Override // com.byazt.g.c.InterfaceC0409c
    public void ve() {
    }

    private n() {
        this.c = 0L;
        com.byazt.g.c.c().c(this);
    }

    public static n c() {
        return c.c;
    }

    public void tt(uj ujVar) {
        if (ujVar == null) {
            return;
        }
        int iOptInt = t.i().optInt("check_an_result_delay", 1200);
        c(ujVar, iOptInt > 0 ? iOptInt : 1200);
    }

    public void c(final uj ujVar, final long j) {
        if (ujVar == null) {
            return;
        }
        com.byazt.di.n.c().c(new Runnable() { // from class: com.byazt.us.n.1
            @Override // java.lang.Runnable
            public void run() {
                if (!com.byazt.g.c.c().ve() || System.currentTimeMillis() - n.this.c <= j) {
                    ujVar.c(true);
                } else {
                    ujVar.c(false);
                }
            }
        }, j);
    }

    public void c(uj ujVar) {
        c(ujVar, 5000L);
    }
}
