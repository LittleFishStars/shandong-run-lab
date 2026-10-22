package com.byazt.dg;

import android.graphics.Path;
import android.graphics.PointF;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 186, 42})
public class i extends com.byazt.vc.c<PointF> {
    public Path da;
    public final com.byazt.vc.c<PointF> sl;

    public i(com.byazt.ga.a aVar, com.byazt.vc.c<PointF> cVar) {
        super(aVar, cVar.c, cVar.tt, cVar.ve, cVar.uj, cVar.n, cVar.f29127a, cVar.sp);
        this.sl = cVar;
        c();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void c() {
        T t;
        T t2;
        T t3 = this.tt;
        boolean z = (t3 == 0 || (t2 = this.c) == 0 || !((PointF) t2).equals(((PointF) t3).x, ((PointF) t3).y)) ? false : true;
        T t4 = this.c;
        if (t4 == 0 || (t = this.tt) == 0 || z) {
            return;
        }
        com.byazt.vc.c<PointF> cVar = this.sl;
        this.da = com.byazt.kk.da.c((PointF) t4, (PointF) t, cVar.x, cVar.i);
    }

    public Path tt() {
        return this.da;
    }
}
