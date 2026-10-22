package com.byazt.jx;

import android.graphics.PointF;
import com.zj.adlib.go6;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, go6.g, 215})
public class yp {
    public final List<com.byazt.nb.c> c;
    public PointF tt;
    public boolean ve;

    public yp(PointF pointF, boolean z, List<com.byazt.nb.c> list) {
        this.tt = pointF;
        this.ve = z;
        this.c = new ArrayList(list);
    }

    public void c(float f, float f2) {
        if (this.tt == null) {
            this.tt = new PointF();
        }
        this.tt.set(f, f2);
    }

    public String toString() {
        return "ShapeData{numCurves=" + this.c.size() + "closed=" + this.ve + '}';
    }

    public boolean tt() {
        return this.ve;
    }

    public List<com.byazt.nb.c> ve() {
        return this.c;
    }

    public PointF c() {
        return this.tt;
    }

    public yp() {
        this.c = new ArrayList();
    }

    public void c(boolean z) {
        this.ve = z;
    }

    public void c(yp ypVar, yp ypVar2, float f) {
        if (this.tt == null) {
            this.tt = new PointF();
        }
        this.ve = ypVar.tt() || ypVar2.tt();
        if (ypVar.ve().size() != ypVar2.ve().size()) {
            com.byazt.kk.a.tt("Curves must have the same number of control points. Shape 1: " + ypVar.ve().size() + "\tShape 2: " + ypVar2.ve().size());
        }
        int iMin = Math.min(ypVar.ve().size(), ypVar2.ve().size());
        if (this.c.size() < iMin) {
            for (int size = this.c.size(); size < iMin; size++) {
                this.c.add(new com.byazt.nb.c());
            }
        } else if (this.c.size() > iMin) {
            for (int size2 = this.c.size() - 1; size2 >= iMin; size2--) {
                List<com.byazt.nb.c> list = this.c;
                list.remove(list.size() - 1);
            }
        }
        PointF pointFC = ypVar.c();
        PointF pointFC2 = ypVar2.c();
        c(com.byazt.kk.i.c(pointFC.x, pointFC2.x, f), com.byazt.kk.i.c(pointFC.y, pointFC2.y, f));
        for (int size3 = this.c.size() - 1; size3 >= 0; size3--) {
            com.byazt.nb.c cVar = ypVar.ve().get(size3);
            com.byazt.nb.c cVar2 = ypVar2.ve().get(size3);
            PointF pointFC3 = cVar.c();
            PointF pointFTt = cVar.tt();
            PointF pointFVe = cVar.ve();
            PointF pointFC4 = cVar2.c();
            PointF pointFTt2 = cVar2.tt();
            PointF pointFVe2 = cVar2.ve();
            this.c.get(size3).c(com.byazt.kk.i.c(pointFC3.x, pointFC4.x, f), com.byazt.kk.i.c(pointFC3.y, pointFC4.y, f));
            this.c.get(size3).tt(com.byazt.kk.i.c(pointFTt.x, pointFTt2.x, f), com.byazt.kk.i.c(pointFTt.y, pointFTt2.y, f));
            this.c.get(size3).ve(com.byazt.kk.i.c(pointFVe.x, pointFVe2.x, f), com.byazt.kk.i.c(pointFVe.y, pointFVe2.y, f));
        }
    }
}
