package com.byazt.kd;

import android.graphics.PointF;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 1714, 46})
public class n implements u<PointF, PointF> {
    public final List<com.byazt.vc.c<PointF>> c;

    public n(List<com.byazt.vc.c<PointF>> list) {
        this.c = list;
    }

    @Override // com.byazt.kd.u
    public com.byazt.dg.c<PointF, PointF> c() {
        return this.c.get(0).n() ? new com.byazt.dg.sl(this.c) : new com.byazt.dg.da(this.c);
    }

    @Override // com.byazt.kd.u
    public boolean tt() {
        return this.c.size() == 1 && this.c.get(0).n();
    }

    @Override // com.byazt.kd.u
    public List<com.byazt.vc.c<PointF>> ve() {
        return this.c;
    }
}
