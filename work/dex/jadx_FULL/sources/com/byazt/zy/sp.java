package com.byazt.zy;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, 91})
public class sp implements n, sl, com.byazt.dg.c.InterfaceC0385c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f29261a;
    public float c;
    public com.byazt.dg.c<ColorFilter, ColorFilter> da;
    public final com.byazt.dg.c<Integer, Integer> i;
    public final String n;
    public final com.byazt.ga.x sl;
    public final List<u> sp;
    public com.byazt.dg.c<Float, Float> t;
    public final Path tt;
    public com.byazt.dg.ve u;
    public final com.byazt.zk.ve uj;
    public final Paint ve;
    public final com.byazt.dg.c<Integer, Integer> x;

    public sp(com.byazt.ga.x xVar, com.byazt.zk.ve veVar, com.byazt.jx.z zVar) {
        Path path = new Path();
        this.tt = path;
        this.ve = new com.byazt.xg.c(1);
        this.sp = new ArrayList();
        this.uj = veVar;
        this.n = zVar.c();
        this.f29261a = zVar.n();
        this.sl = xVar;
        if (veVar.t() != null) {
            com.byazt.dg.c<Float, Float> cVarC = veVar.t().c().c();
            this.t = cVarC;
            cVarC.c(this);
            veVar.c(this.t);
        }
        if (veVar.u() != null) {
            this.u = new com.byazt.dg.ve(this, veVar, veVar.u());
        }
        if (zVar.tt() == null || zVar.ve() == null) {
            this.x = null;
            this.i = null;
            return;
        }
        path.setFillType(zVar.uj());
        com.byazt.dg.c<Integer, Integer> cVarC2 = zVar.tt().c();
        this.x = cVarC2;
        cVarC2.c(this);
        veVar.c(cVarC2);
        com.byazt.dg.c<Integer, Integer> cVarC3 = zVar.ve().c();
        this.i = cVarC3;
        cVarC3.c(this);
        veVar.c(cVarC3);
    }

    @Override // com.byazt.dg.c.InterfaceC0385c
    public void c() {
        this.sl.invalidateSelf();
    }

    @Override // com.byazt.zy.ve
    public void c(List<ve> list, List<ve> list2) {
        for (int i = 0; i < list2.size(); i++) {
            ve veVar = list2.get(i);
            if (veVar instanceof u) {
                this.sp.add((u) veVar);
            }
        }
    }

    @Override // com.byazt.zy.n
    public void c(Canvas canvas, Matrix matrix, int i) {
        if (this.f29261a) {
            return;
        }
        com.byazt.ga.n.c("FillContent#draw");
        this.ve.setColor((com.byazt.kk.i.c((int) ((((i / 255.0f) * this.i.sp().intValue()) / 100.0f) * 255.0f), 0, 255) << 24) | (((com.byazt.dg.tt) this.x).i() & 16777215));
        com.byazt.dg.c<ColorFilter, ColorFilter> cVar = this.da;
        if (cVar != null) {
            this.ve.setColorFilter(cVar.sp());
        }
        com.byazt.dg.c<Float, Float> cVar2 = this.t;
        if (cVar2 != null) {
            float fFloatValue = cVar2.sp().floatValue();
            if (fFloatValue == 0.0f) {
                this.ve.setMaskFilter(null);
            } else if (fFloatValue != this.c) {
                this.ve.setMaskFilter(this.uj.tt(fFloatValue));
            }
            this.c = fFloatValue;
        }
        com.byazt.dg.ve veVar = this.u;
        if (veVar != null) {
            veVar.c(this.ve);
        }
        this.tt.reset();
        for (int i2 = 0; i2 < this.sp.size(); i2++) {
            this.tt.addPath(this.sp.get(i2).uj(), matrix);
        }
        canvas.drawPath(this.tt, this.ve);
        com.byazt.ga.n.tt("FillContent#draw");
    }

    @Override // com.byazt.zy.n
    public void c(RectF rectF, Matrix matrix, boolean z) {
        this.tt.reset();
        for (int i = 0; i < this.sp.size(); i++) {
            this.tt.addPath(this.sp.get(i).uj(), matrix);
        }
        this.tt.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }
}
