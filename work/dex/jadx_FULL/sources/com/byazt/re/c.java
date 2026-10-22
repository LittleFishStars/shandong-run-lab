package com.byazt.re;

import com.byazt.ete.y;
import com.byazt.yj.m;
import com.byazt.yj.x;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1337, 20})
public class c extends com.byazt.uph.c {
    public y c;

    private void c(m mVar) {
        x httpTime = mVar.getHttpTime();
        if (httpTime == null || !uj()) {
            return;
        }
        c(httpTime.getStartRequestTime(), httpTime.getFirstFrameTime());
    }

    private void n() {
        if (uj()) {
            long jCurrentTimeMillis = System.currentTimeMillis();
            y yVar = this.c;
            yVar.x(jCurrentTimeMillis - yVar.my());
            this.c.u(jCurrentTimeMillis);
        }
    }

    private boolean uj() {
        y yVar = this.c;
        return yVar != null && yVar.qy();
    }

    public y ve() {
        return this.c;
    }

    private void c(long j, long j2) {
        this.c.yp(j2);
        y yVar = this.c;
        yVar.i(j2 - yVar.rl());
        this.c.my(j2 - j);
    }

    public void c(y yVar) {
        this.c = yVar;
    }

    @Override // com.byazt.uph.c
    public void c(m mVar, com.byazt.uph.c.tt ttVar) {
        c(mVar);
        super.c(mVar, ttVar);
    }

    @Override // com.byazt.uph.c
    public void c() {
        n();
    }
}
