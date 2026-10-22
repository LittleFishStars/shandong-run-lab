package com.byazt.biq;

import com.byazt.omf.x;
import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 12, 15})
public class uj implements com.byazt.aas.c.tt {
    public long c;
    public long tt;
    public long ve;

    public uj() {
        x.m().c(this);
    }

    public void c() {
        long jCurrentTimeMillis = System.currentTimeMillis();
        long j = this.tt;
        if (j != 0) {
            this.c += jCurrentTimeMillis - j;
        }
        this.tt = jCurrentTimeMillis;
    }

    @Override // com.byazt.aas.c.tt
    public void onAppBackground() {
        tt();
    }

    @Override // com.byazt.aas.c.tt
    public void onAppExit() {
    }

    @Override // com.byazt.aas.c.tt
    public void onAppForeground() {
        c();
    }

    @Override // com.byazt.aas.c.tt
    public void onAppStart() {
    }

    public void tt() {
        if (this.tt == 0) {
            return;
        }
        this.c += System.currentTimeMillis() - this.tt;
        this.tt = 0L;
        this.ve = 0L;
    }

    public void ve() {
        this.tt = 0L;
        this.ve = 0L;
        this.c = 0L;
    }

    public long c(TimeUnit timeUnit) {
        if (timeUnit != null) {
            return timeUnit.convert(this.c, TimeUnit.MILLISECONDS);
        }
        return this.c;
    }
}
