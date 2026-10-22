package com.byazt.iuu;

import com.byazt.ete.x;
import com.byazt.iu.n;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1651, 20})
public abstract class c extends tt {
    public final AtomicBoolean c;
    public final AtomicBoolean tt;
    public final AtomicBoolean uj;
    public final AtomicBoolean ve;

    public c(n nVar, x.ve veVar) {
        super(nVar);
        this.c = new AtomicBoolean(false);
        this.tt = new AtomicBoolean(false);
        this.ve = new AtomicBoolean(false);
        this.uj = new AtomicBoolean(false);
        this.n = veVar;
    }

    public abstract void c();

    @Override // com.byazt.iuu.tt
    public void c(int i, String str) {
        this.i = i;
        this.da = str;
        this.uj.set(true);
        tt();
    }

    public void tt() {
        com.byazt.iu.ve veVar;
        if (this.ve.get() && (veVar = this.sp) != null) {
            c(veVar, 2);
            return;
        }
        if (this.uj.get()) {
            com.byazt.iu.ve veVar2 = this.f28669a;
            if (veVar2 != null) {
                c(veVar2, 1);
            } else {
                c((com.byazt.iu.ve) null, 3);
            }
        }
    }

    @Override // com.byazt.iuu.tt
    public void ve() {
        this.uj.set(true);
        tt();
    }

    private void c(com.byazt.iu.ve veVar, int i) {
        if (this.c.compareAndSet(false, true)) {
            if (i != 3) {
                if (veVar != null) {
                    veVar.c();
                }
            } else {
                n nVar = this.x;
                if (nVar != null) {
                    nVar.c(this.i, this.da);
                }
            }
        }
    }

    @Override // com.byazt.iuu.tt
    public void c(boolean z) {
        if (z) {
            this.ve.set(true);
            tt();
        } else {
            this.tt.set(true);
            c();
        }
    }
}
