package com.byazt.dg;

import android.graphics.Matrix;
import android.graphics.PointF;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 186, 130})
public class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public c<PointF, PointF> f28398a;
    public final Matrix c = new Matrix();
    public c<Integer, Integer> da;
    public c<Float, Float> i;
    public final float[] n;
    public uj sl;
    public c<?, PointF> sp;
    public uj t;
    public final Matrix tt;
    public c<?, Float> u;
    public final Matrix uj;
    public final Matrix ve;
    public c<com.byazt.vc.uj, com.byazt.vc.uj> x;
    public c<?, Float> yp;

    public m(com.byazt.kd.t tVar) {
        this.f28398a = tVar.c() == null ? null : tVar.c().c();
        this.sp = tVar.tt() == null ? null : tVar.tt().c();
        this.x = tVar.ve() == null ? null : tVar.ve().c();
        this.i = tVar.uj() == null ? null : tVar.uj().c();
        uj ujVar = tVar.x() == null ? null : (uj) tVar.x().c();
        this.sl = ujVar;
        if (ujVar != null) {
            this.tt = new Matrix();
            this.ve = new Matrix();
            this.uj = new Matrix();
            this.n = new float[9];
        } else {
            this.tt = null;
            this.ve = null;
            this.uj = null;
            this.n = null;
        }
        this.t = tVar.i() == null ? null : (uj) tVar.i().c();
        if (tVar.n() != null) {
            this.da = tVar.n().c();
        }
        if (tVar.a() != null) {
            this.u = tVar.a().c();
        } else {
            this.u = null;
        }
        if (tVar.sp() != null) {
            this.yp = tVar.sp().c();
        } else {
            this.yp = null;
        }
    }

    private void n() {
        for (int i = 0; i < 9; i++) {
            this.n[i] = 0.0f;
        }
    }

    public void c(com.byazt.zk.ve veVar) {
        veVar.c(this.da);
        veVar.c(this.u);
        veVar.c(this.yp);
        veVar.c(this.f28398a);
        veVar.c(this.sp);
        veVar.c(this.x);
        veVar.c(this.i);
        veVar.c(this.sl);
        veVar.c(this.t);
    }

    public c<?, Float> tt() {
        return this.u;
    }

    public Matrix uj() {
        PointF pointFSp;
        PointF pointFSp2;
        this.c.reset();
        c<?, PointF> cVar = this.sp;
        if (cVar != null && (pointFSp2 = cVar.sp()) != null) {
            float f = pointFSp2.x;
            if (f != 0.0f || pointFSp2.y != 0.0f) {
                this.c.preTranslate(f, pointFSp2.y);
            }
        }
        c<Float, Float> cVar2 = this.i;
        if (cVar2 != null) {
            float fFloatValue = cVar2 instanceof nu ? cVar2.sp().floatValue() : ((uj) cVar2).i();
            if (fFloatValue != 0.0f) {
                this.c.preRotate(fFloatValue);
            }
        }
        uj ujVar = this.sl;
        if (ujVar != null) {
            uj ujVar2 = this.t;
            float fCos = ujVar2 == null ? 0.0f : (float) Math.cos(Math.toRadians((-ujVar2.i()) + 90.0f));
            uj ujVar3 = this.t;
            float fSin = ujVar3 == null ? 1.0f : (float) Math.sin(Math.toRadians((-ujVar3.i()) + 90.0f));
            float fTan = (float) Math.tan(Math.toRadians(ujVar.i()));
            n();
            float[] fArr = this.n;
            fArr[0] = fCos;
            fArr[1] = fSin;
            float f2 = -fSin;
            fArr[3] = f2;
            fArr[4] = fCos;
            fArr[8] = 1.0f;
            this.tt.setValues(fArr);
            n();
            float[] fArr2 = this.n;
            fArr2[0] = 1.0f;
            fArr2[3] = fTan;
            fArr2[4] = 1.0f;
            fArr2[8] = 1.0f;
            this.ve.setValues(fArr2);
            n();
            float[] fArr3 = this.n;
            fArr3[0] = fCos;
            fArr3[1] = f2;
            fArr3[3] = fSin;
            fArr3[4] = fCos;
            fArr3[8] = 1.0f;
            this.uj.setValues(fArr3);
            this.ve.preConcat(this.tt);
            this.uj.preConcat(this.ve);
            this.c.preConcat(this.uj);
        }
        c<com.byazt.vc.uj, com.byazt.vc.uj> cVar3 = this.x;
        if (cVar3 != null) {
            com.byazt.vc.uj ujVarSp = cVar3.sp();
            if (ujVarSp.c() != 1.0f || ujVarSp.tt() != 1.0f) {
                this.c.preScale(ujVarSp.c(), ujVarSp.tt());
            }
        }
        c<PointF, PointF> cVar4 = this.f28398a;
        if (cVar4 != null && (((pointFSp = cVar4.sp()) != null && pointFSp.x != 0.0f) || pointFSp.y != 0.0f)) {
            this.c.preTranslate(-pointFSp.x, -pointFSp.y);
        }
        return this.c;
    }

    public c<?, Float> ve() {
        return this.yp;
    }

    public Matrix tt(float f) {
        c<?, PointF> cVar = this.sp;
        PointF pointFSp = cVar == null ? null : cVar.sp();
        c<com.byazt.vc.uj, com.byazt.vc.uj> cVar2 = this.x;
        com.byazt.vc.uj ujVarSp = cVar2 == null ? null : cVar2.sp();
        this.c.reset();
        if (pointFSp != null) {
            this.c.preTranslate(pointFSp.x * f, pointFSp.y * f);
        }
        if (ujVarSp != null) {
            double d = f;
            this.c.preScale((float) Math.pow(ujVarSp.c(), d), (float) Math.pow(ujVarSp.tt(), d));
        }
        c<Float, Float> cVar3 = this.i;
        if (cVar3 != null) {
            float fFloatValue = cVar3.sp().floatValue();
            c<PointF, PointF> cVar4 = this.f28398a;
            PointF pointFSp2 = cVar4 != null ? cVar4.sp() : null;
            this.c.preRotate(fFloatValue * f, pointFSp2 == null ? 0.0f : pointFSp2.x, pointFSp2 != null ? pointFSp2.y : 0.0f);
        }
        return this.c;
    }

    public void c(c.InterfaceC0385c interfaceC0385c) {
        c<Integer, Integer> cVar = this.da;
        if (cVar != null) {
            cVar.c(interfaceC0385c);
        }
        c<?, Float> cVar2 = this.u;
        if (cVar2 != null) {
            cVar2.c(interfaceC0385c);
        }
        c<?, Float> cVar3 = this.yp;
        if (cVar3 != null) {
            cVar3.c(interfaceC0385c);
        }
        c<PointF, PointF> cVar4 = this.f28398a;
        if (cVar4 != null) {
            cVar4.c(interfaceC0385c);
        }
        c<?, PointF> cVar5 = this.sp;
        if (cVar5 != null) {
            cVar5.c(interfaceC0385c);
        }
        c<com.byazt.vc.uj, com.byazt.vc.uj> cVar6 = this.x;
        if (cVar6 != null) {
            cVar6.c(interfaceC0385c);
        }
        c<Float, Float> cVar7 = this.i;
        if (cVar7 != null) {
            cVar7.c(interfaceC0385c);
        }
        uj ujVar = this.sl;
        if (ujVar != null) {
            ujVar.c(interfaceC0385c);
        }
        uj ujVar2 = this.t;
        if (ujVar2 != null) {
            ujVar2.c(interfaceC0385c);
        }
    }

    public void c(float f) {
        c<Integer, Integer> cVar = this.da;
        if (cVar != null) {
            cVar.c(f);
        }
        c<?, Float> cVar2 = this.u;
        if (cVar2 != null) {
            cVar2.c(f);
        }
        c<?, Float> cVar3 = this.yp;
        if (cVar3 != null) {
            cVar3.c(f);
        }
        c<PointF, PointF> cVar4 = this.f28398a;
        if (cVar4 != null) {
            cVar4.c(f);
        }
        c<?, PointF> cVar5 = this.sp;
        if (cVar5 != null) {
            cVar5.c(f);
        }
        c<com.byazt.vc.uj, com.byazt.vc.uj> cVar6 = this.x;
        if (cVar6 != null) {
            cVar6.c(f);
        }
        c<Float, Float> cVar7 = this.i;
        if (cVar7 != null) {
            cVar7.c(f);
        }
        uj ujVar = this.sl;
        if (ujVar != null) {
            ujVar.c(f);
        }
        uj ujVar2 = this.t;
        if (ujVar2 != null) {
            ujVar2.c(f);
        }
    }

    public c<?, Integer> c() {
        return this.da;
    }
}
