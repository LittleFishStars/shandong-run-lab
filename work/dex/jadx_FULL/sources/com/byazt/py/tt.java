package com.byazt.py;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1879, 13})
public class tt implements Runnable {
    public com.byazt.nbs.tt c;
    public Runnable tt;
    public boolean ve = false;

    public tt(com.byazt.nbs.tt ttVar, Runnable runnable) {
        this.c = ttVar;
        this.tt = runnable;
    }

    public boolean c() {
        return this.ve;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.byazt.nbs.tt ttVar = this.c;
        if (ttVar != null && ttVar.i() == 4) {
            this.c.x().put("serverBidding_timeout", Boolean.TRUE);
        }
        this.ve = true;
        Runnable runnable = this.tt;
        if (runnable != null) {
            runnable.run();
        }
    }
}
