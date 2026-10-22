package com.byazt.xl;

import android.content.Context;
import android.view.View;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1459, 130})
public class m implements da {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AtomicBoolean f29184a = new AtomicBoolean(false);
    public Context c;
    public ScheduledFuture<?> n;
    public com.byazt.ol.c tt;
    public u uj;
    public x ve;

    @com.byazt.zqa.c(c = {0, 1, 1459, 600})
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
                m.this.tt.c(true);
                m.this.c(this.c, 107, null);
            }
        }
    }

    public m(Context context, u uVar, com.byazt.ol.c cVar, x xVar) {
        this.c = context;
        this.uj = uVar;
        this.ve = xVar;
        this.tt = cVar;
        cVar.c(this.ve);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ve() {
        try {
            ScheduledFuture<?> scheduledFuture = this.n;
            if (scheduledFuture == null || scheduledFuture.isCancelled()) {
                return;
            }
            this.n.cancel(false);
            this.n = null;
        } catch (Throwable th) {
            com.byazt.nr.m.c(th);
        }
    }

    public com.byazt.ol.c tt() {
        return this.tt;
    }

    @Override // com.byazt.xl.da
    public boolean c(final da.c cVar) {
        int iX = this.uj.x();
        if (iX < 0) {
            c(cVar, 107, "time is ".concat(String.valueOf(iX)));
        } else {
            this.n = com.byazt.or.n.c(new c(1, cVar), iX, TimeUnit.MILLISECONDS);
            this.tt.c(new sp() { // from class: com.byazt.xl.m.1
                @Override // com.byazt.xl.sp
                public void c(View view, yp ypVar) {
                    z zVarTt;
                    m.this.ve();
                    if (cVar.ve() || (zVarTt = cVar.tt()) == null) {
                        return;
                    }
                    zVarTt.c(m.this.tt, ypVar);
                    cVar.c(true);
                }

                @Override // com.byazt.xl.sp
                public void c(int i, String str) {
                    m.this.c(cVar, i, str);
                }
            });
        }
        return true;
    }

    @Override // com.byazt.xl.da
    public void c() {
        this.tt.uj();
        ve();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(da.c cVar, int i, String str) {
        z zVarTt;
        if (cVar.ve() || this.f29184a.get()) {
            return;
        }
        ve();
        this.uj.sp().c(i, str);
        if (cVar.tt(this)) {
            cVar.c(this);
        } else {
            if (cVar.ve() || (zVarTt = cVar.tt()) == null) {
                return;
            }
            cVar.c(true);
            zVarTt.a_(i);
        }
        this.f29184a.getAndSet(true);
    }
}
