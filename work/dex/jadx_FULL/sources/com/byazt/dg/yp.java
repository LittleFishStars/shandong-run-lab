package com.byazt.dg;

import android.graphics.PointF;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 186, 215})
public class yp extends c<PointF, PointF> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f28401a;
    public final c<Float, Float> i;
    public com.byazt.vc.ve<Float> n;
    public final PointF sp;
    public com.byazt.vc.ve<Float> uj;
    public final c<Float, Float> x;

    public yp(c<Float, Float> cVar, c<Float, Float> cVar2) {
        super(Collections.emptyList());
        this.f28401a = new PointF();
        this.sp = new PointF();
        this.x = cVar;
        this.i = cVar2;
        c(x());
    }

    @Override // com.byazt.dg.c
    /* JADX INFO: renamed from: i, reason: merged with bridge method [inline-methods] */
    public PointF sp() {
        return c(null, 0.0f);
    }

    @Override // com.byazt.dg.c
    /* JADX INFO: renamed from: tt, reason: merged with bridge method [inline-methods] */
    public PointF c(com.byazt.vc.c<PointF> cVar, float f) {
        Float fC;
        com.byazt.vc.c<Float> cVarVe;
        com.byazt.vc.c<Float> cVarVe2;
        Float fC2 = null;
        if (this.uj == null || (cVarVe2 = this.x.ve()) == null) {
            fC = null;
        } else {
            float fN = this.x.n();
            Float f2 = cVarVe2.sp;
            com.byazt.vc.ve<Float> veVar = this.uj;
            float f3 = cVarVe2.f29127a;
            fC = veVar.c(f3, f2 == null ? f3 : f2.floatValue(), cVarVe2.c, cVarVe2.tt, f, f, fN);
        }
        if (this.n != null && (cVarVe = this.i.ve()) != null) {
            float fN2 = this.i.n();
            Float f4 = cVarVe.sp;
            com.byazt.vc.ve<Float> veVar2 = this.n;
            float f5 = cVarVe.f29127a;
            fC2 = veVar2.c(f5, f4 == null ? f5 : f4.floatValue(), cVarVe.c, cVarVe.tt, f, f, fN2);
        }
        if (fC == null) {
            this.sp.set(this.f28401a.x, 0.0f);
        } else {
            this.sp.set(fC.floatValue(), 0.0f);
        }
        if (fC2 == null) {
            PointF pointF = this.sp;
            pointF.set(pointF.x, this.f28401a.y);
        } else {
            PointF pointF2 = this.sp;
            pointF2.set(pointF2.x, fC2.floatValue());
        }
        return this.sp;
    }

    @Override // com.byazt.dg.c
    public void c(float f) {
        this.x.c(f);
        this.i.c(f);
        this.f28401a.set(this.x.sp().floatValue(), this.i.sp().floatValue());
        for (int i = 0; i < this.c.size(); i++) {
            this.c.get(i).c();
        }
    }
}
