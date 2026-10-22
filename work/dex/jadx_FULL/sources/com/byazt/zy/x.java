package com.byazt.zy;

import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, 71})
public class x implements n, sl, com.byazt.dg.c.InterfaceC0385c {
    public float c;
    public final List<u> da;
    public com.byazt.dg.c<Float, Float> gt;
    public final RectF i;
    public com.byazt.dg.c<ColorFilter, ColorFilter> m;
    public final int my;
    public com.byazt.dg.nu nu;
    public final com.byazt.ga.x rh;
    public com.byazt.dg.ve rl;
    public final com.byazt.jx.sp sl;
    public final Path sp;
    public final com.byazt.dg.c<com.byazt.jx.uj, com.byazt.jx.uj> t;
    public final String tt;
    public final com.byazt.dg.c<Integer, Integer> u;
    public final com.byazt.zk.ve uj;
    public final boolean ve;
    public final Paint x;
    public final com.byazt.dg.c<PointF, PointF> yp;
    public final com.byazt.dg.c<PointF, PointF> z;
    public final LongSparseArray<LinearGradient> n = new LongSparseArray<>();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LongSparseArray<RadialGradient> f29264a = new LongSparseArray<>();

    public x(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar, com.byazt.jx.n nVar) {
        Path path = new Path();
        this.sp = path;
        this.x = new com.byazt.xg.c(1);
        this.i = new RectF();
        this.da = new ArrayList();
        this.c = 0.0f;
        this.uj = veVar;
        this.tt = nVar.c();
        this.ve = nVar.x();
        this.rh = xVar;
        this.sl = nVar.tt();
        path.setFillType(nVar.ve());
        this.my = (int) (aVar.n() / 32.0f);
        com.byazt.dg.c<com.byazt.jx.uj, com.byazt.jx.uj> cVarC = nVar.uj().c();
        this.t = cVarC;
        cVarC.c(this);
        veVar.c(cVarC);
        com.byazt.dg.c<Integer, Integer> cVarC2 = nVar.n().c();
        this.u = cVarC2;
        cVarC2.c(this);
        veVar.c(cVarC2);
        com.byazt.dg.c<PointF, PointF> cVarC3 = nVar.a().c();
        this.yp = cVarC3;
        cVarC3.c(this);
        veVar.c(cVarC3);
        com.byazt.dg.c<PointF, PointF> cVarC4 = nVar.sp().c();
        this.z = cVarC4;
        cVarC4.c(this);
        veVar.c(cVarC4);
        if (veVar.t() != null) {
            com.byazt.dg.c<Float, Float> cVarC5 = veVar.t().c().c();
            this.gt = cVarC5;
            cVarC5.c(this);
            veVar.c(this.gt);
        }
        if (veVar.u() != null) {
            this.rl = new com.byazt.dg.ve(this, veVar, veVar.u());
        }
    }

    private LinearGradient tt() {
        long jUj = uj();
        LinearGradient linearGradient = this.n.get(jUj);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFSp = this.yp.sp();
        PointF pointFSp2 = this.z.sp();
        com.byazt.jx.uj ujVarSp = this.t.sp();
        LinearGradient linearGradient2 = new LinearGradient(pointFSp.x, pointFSp.y, pointFSp2.x, pointFSp2.y, c(ujVarSp.tt()), ujVarSp.c(), Shader.TileMode.CLAMP);
        this.n.put(jUj, linearGradient2);
        return linearGradient2;
    }

    private int uj() {
        int iRound = Math.round(this.yp.x() * this.my);
        int iRound2 = Math.round(this.z.x() * this.my);
        int iRound3 = Math.round(this.t.x() * this.my);
        int i = iRound != 0 ? iRound * 527 : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private RadialGradient ve() {
        long jUj = uj();
        RadialGradient radialGradient = this.f29264a.get(jUj);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFSp = this.yp.sp();
        PointF pointFSp2 = this.z.sp();
        com.byazt.jx.uj ujVarSp = this.t.sp();
        int[] iArrC = c(ujVarSp.tt());
        float[] fArrC = ujVarSp.c();
        float f = pointFSp.x;
        float f2 = pointFSp.y;
        float fHypot = (float) Math.hypot(pointFSp2.x - f, pointFSp2.y - f2);
        if (fHypot <= 0.0f) {
            fHypot = 0.001f;
        }
        RadialGradient radialGradient2 = new RadialGradient(f, f2, fHypot, iArrC, fArrC, Shader.TileMode.CLAMP);
        this.f29264a.put(jUj, radialGradient2);
        return radialGradient2;
    }

    @Override // com.byazt.dg.c.InterfaceC0385c
    public void c() {
        this.rh.invalidateSelf();
    }

    @Override // com.byazt.zy.ve
    public void c(List<ve> list, List<ve> list2) {
        for (int i = 0; i < list2.size(); i++) {
            ve veVar = list2.get(i);
            if (veVar instanceof u) {
                this.da.add((u) veVar);
            }
        }
    }

    @Override // com.byazt.zy.n
    public void c(Canvas canvas, Matrix matrix, int i) {
        Shader shaderVe;
        if (this.ve) {
            return;
        }
        com.byazt.ga.n.c("GradientFillContent#draw");
        this.sp.reset();
        for (int i2 = 0; i2 < this.da.size(); i2++) {
            this.sp.addPath(this.da.get(i2).uj(), matrix);
        }
        this.sp.computeBounds(this.i, false);
        if (this.sl == com.byazt.jx.sp.LINEAR) {
            shaderVe = tt();
        } else {
            shaderVe = ve();
        }
        shaderVe.setLocalMatrix(matrix);
        this.x.setShader(shaderVe);
        com.byazt.dg.c<ColorFilter, ColorFilter> cVar = this.m;
        if (cVar != null) {
            this.x.setColorFilter(cVar.sp());
        }
        com.byazt.dg.c<Float, Float> cVar2 = this.gt;
        if (cVar2 != null) {
            float fFloatValue = cVar2.sp().floatValue();
            if (fFloatValue == 0.0f) {
                this.x.setMaskFilter(null);
            } else if (fFloatValue != this.c) {
                this.x.setMaskFilter(new BlurMaskFilter(fFloatValue, BlurMaskFilter.Blur.NORMAL));
            }
            this.c = fFloatValue;
        }
        com.byazt.dg.ve veVar = this.rl;
        if (veVar != null) {
            veVar.c(this.x);
        }
        this.x.setAlpha(com.byazt.kk.i.c((int) ((((i / 255.0f) * this.u.sp().intValue()) / 100.0f) * 255.0f), 0, 255));
        canvas.drawPath(this.sp, this.x);
        com.byazt.ga.n.tt("GradientFillContent#draw");
    }

    @Override // com.byazt.zy.n
    public void c(RectF rectF, Matrix matrix, boolean z) {
        this.sp.reset();
        for (int i = 0; i < this.da.size(); i++) {
            this.sp.addPath(this.da.get(i).uj(), matrix);
        }
        this.sp.computeBounds(rectF, false);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
    }

    private int[] c(int[] iArr) {
        com.byazt.dg.nu nuVar = this.nu;
        if (nuVar != null) {
            Integer[] numArr = (Integer[]) nuVar.sp();
            int i = 0;
            if (iArr.length == numArr.length) {
                while (i < iArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            } else {
                iArr = new int[numArr.length];
                while (i < numArr.length) {
                    iArr[i] = numArr[i].intValue();
                    i++;
                }
            }
        }
        return iArr;
    }
}
