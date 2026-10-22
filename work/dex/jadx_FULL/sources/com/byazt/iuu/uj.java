package com.byazt.iuu;

import com.byazt.ete.x;
import com.byazt.iu.n;
import com.byazt.nr.da;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1651, 15})
public class uj extends tt implements Runnable {
    public final AtomicBoolean c;
    public final AtomicBoolean t;
    public final AtomicBoolean tt;
    public final int u;
    public final AtomicBoolean uj;
    public final AtomicBoolean ve;
    public final String yp;

    public uj(n nVar, x.ve veVar, int i, String str) {
        super(nVar);
        this.c = new AtomicBoolean(false);
        this.tt = new AtomicBoolean(false);
        this.ve = new AtomicBoolean(false);
        this.uj = new AtomicBoolean(false);
        this.t = new AtomicBoolean(false);
        this.n = veVar;
        this.u = i;
        this.yp = str;
    }

    private long n() {
        long jC = com.byazt.wi.tt.c().c(this.u, this.yp);
        if (jC > 0) {
            return jC;
        }
        x.ve veVar = this.n;
        if (veVar == null || veVar.a() <= 0) {
            return 10000L;
        }
        return this.n.a();
    }

    @Override // com.byazt.iuu.tt
    public void c(int i, String str) {
        this.i = i;
        this.da = str;
        this.ve.set(true);
        this.t.set(true);
        tt();
    }

    @Override // java.lang.Runnable
    public void run() {
        this.c.set(true);
        tt();
    }

    public void tt() {
        com.byazt.iu.ve veVar;
        if (!this.t.get()) {
            if (this.c.get() && this.uj.get()) {
                if (x.c(this.sl).c("forbid_realtime_use_cache", new x.tt.c().c(-666).c()) || (veVar = this.sp) == null) {
                    return;
                }
                c(veVar, 2);
                return;
            }
            return;
        }
        da.tt().removeCallbacks(this);
        com.byazt.iu.ve veVar2 = this.f28669a;
        if (veVar2 != null) {
            c(veVar2, 1);
            return;
        }
        if (this.uj.get()) {
            if (this.ve.get()) {
                if (this.n.c("forbid_realtime_use_cache", new x.tt.c().c(this.i).c())) {
                    c((com.byazt.iu.ve) null, 3);
                    return;
                }
            }
            com.byazt.iu.ve veVar3 = this.sp;
            if (veVar3 != null) {
                c(veVar3, 2);
            } else {
                c((com.byazt.iu.ve) null, 3);
            }
        }
    }

    @Override // com.byazt.iuu.tt
    public void ve() {
        this.t.set(true);
        tt();
    }

    public void c() {
        da.tt().postDelayed(this, n());
    }

    private void c(com.byazt.iu.ve veVar, int i) {
        com.byazt.iu.ve veVar2;
        com.byazt.iu.ve veVar3;
        if (this.tt.compareAndSet(false, true)) {
            this.sl = i;
            if (i == 3) {
                n nVar = this.x;
                if (nVar != null) {
                    nVar.c(this.i, this.da);
                }
            } else if (veVar != null) {
                veVar.c();
            }
            if (i == 1 && (veVar3 = this.sp) != null) {
                veVar3.ve();
            }
            if (i != 2 || (veVar2 = this.f28669a) == null) {
                return;
            }
            veVar2.ve();
            return;
        }
        if (i == this.sl || veVar == null) {
            return;
        }
        veVar.ve();
    }

    @Override // com.byazt.iuu.tt
    public void c(boolean z) {
        this.uj.set(true);
        tt();
    }
}
