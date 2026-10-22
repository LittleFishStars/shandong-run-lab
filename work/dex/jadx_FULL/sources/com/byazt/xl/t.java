package com.byazt.xl;

import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1459, 66})
public class t implements da.c {
    public z c;
    public List<da> tt;
    public AtomicBoolean uj = new AtomicBoolean(false);
    public i ve;

    public t(List<da> list, i iVar) {
        this.tt = list;
        this.ve = iVar;
    }

    @Override // com.byazt.xl.da.c
    public void c() {
        this.ve.a();
        Iterator<da> it = this.tt.iterator();
        while (it.hasNext() && !it.next().c(this)) {
        }
    }

    @Override // com.byazt.xl.da.c
    public boolean tt(da daVar) {
        int iIndexOf = this.tt.indexOf(daVar);
        return iIndexOf < this.tt.size() - 1 && iIndexOf >= 0;
    }

    @Override // com.byazt.xl.da.c
    public boolean ve() {
        return this.uj.get();
    }

    @Override // com.byazt.xl.da.c
    public z tt() {
        return this.c;
    }

    @Override // com.byazt.xl.da.c
    public void c(da daVar) {
        int iIndexOf = this.tt.indexOf(daVar);
        if (iIndexOf < 0) {
            return;
        }
        do {
            iIndexOf++;
            if (iIndexOf >= this.tt.size()) {
                return;
            }
        } while (!this.tt.get(iIndexOf).c(this));
    }

    @Override // com.byazt.xl.da.c
    public void c(z zVar) {
        this.c = zVar;
    }

    @Override // com.byazt.xl.da.c
    public void c(boolean z) {
        this.uj.getAndSet(z);
    }
}
