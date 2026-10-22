package com.byazt.atv;

import android.content.Context;
import android.view.View;
import com.byazt.dna.qp;
import com.byazt.nr.m;
import com.byazt.sz.rl;
import com.byazt.xl.da;
import com.byazt.xl.u;
import com.byazt.xl.x;
import com.byazt.xl.yp;
import com.byazt.xl.z;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@com.byazt.zqa.c(c = {0, 1, 134, 34})
public class a implements da {
    public Context c;
    public AtomicBoolean n = new AtomicBoolean(false);
    public n tt;
    public ScheduledFuture<?> uj;
    public u ve;

    @com.byazt.zqa.c(c = {0, 1, 134, 464})
    public class c implements Runnable {
        public da.c c;
        public int ve;

        public c(int i, da.c cVar) {
            this.ve = i;
            this.c = cVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            if (this.ve == 1) {
                a.this.tt.c(true);
                a.this.c(this.c, 137);
            }
        }
    }

    public a(Context context, n nVar, x xVar, u uVar, com.byazt.qdk.tt ttVar) {
        this.c = context;
        this.tt = nVar;
        this.ve = uVar;
        this.tt.c(xVar);
        this.tt.c(ttVar);
    }

    private void tt() {
        try {
            ScheduledFuture<?> scheduledFuture = this.uj;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.uj.cancel(false);
            this.uj = null;
        } catch (Throwable th) {
            m.c(th);
        }
    }

    @Override // com.byazt.xl.da
    public boolean c(final da.c cVar) {
        int iX = this.ve.x();
        if (iX < 0) {
            c(cVar, 137);
        } else {
            this.uj = ((qp) com.byazt.ut.uj.getService("thread_service")).getScheduledThreadPool().schedule(new c(1, cVar), iX, TimeUnit.MILLISECONDS);
            this.tt.c(new com.byazt.xl.sp() { // from class: com.byazt.atv.a.1
                @Override // com.byazt.xl.sp
                public void c(View view, yp ypVar) {
                    if (cVar.ve()) {
                        return;
                    }
                    rl rlVar = new rl();
                    rlVar.c(0);
                    ((tt) a.this.ve).or().c(rlVar);
                    a.this.ve.sp().u();
                    z zVarTt = cVar.tt();
                    if (zVarTt == null) {
                        return;
                    }
                    zVarTt.c(a.this.tt, ypVar);
                    cVar.c(true);
                }

                @Override // com.byazt.xl.sp
                public void c(int i, String str) {
                    z zVarTt;
                    rl rlVar = new rl();
                    rlVar.c(i);
                    rlVar.c(str);
                    ((tt) a.this.ve).or().c(rlVar);
                    if (cVar.tt(a.this)) {
                        cVar.c(a.this);
                    } else {
                        if (cVar.ve() || (zVarTt = cVar.tt()) == null) {
                            return;
                        }
                        zVarTt.a_(i);
                    }
                }
            });
        }
        return true;
    }

    @Override // com.byazt.xl.da
    public void c() {
        n nVar = this.tt;
        if (nVar != null) {
            nVar.t();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(da.c cVar, int i) {
        z zVarTt;
        if (cVar.ve() || this.n.get()) {
            return;
        }
        tt();
        rl rlVar = new rl();
        rlVar.c(i);
        ((tt) this.ve).or().c(rlVar);
        if (cVar.tt(this)) {
            cVar.c(this);
        } else {
            if (cVar.ve() || (zVarTt = cVar.tt()) == null) {
                return;
            }
            cVar.c(true);
            zVarTt.a_(i);
        }
        this.n.getAndSet(true);
    }
}
