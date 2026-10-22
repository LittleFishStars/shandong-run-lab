package com.byazt.zy;

import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.RadialGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.LongSparseArray;
import com.hzchengdun.securityguard.SecExceptionCode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, 42})
public class i extends c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LongSparseArray<LinearGradient> f29257a;
    public final int da;
    public final com.byazt.jx.sp i;
    public final boolean n;
    public final com.byazt.dg.c<com.byazt.jx.uj, com.byazt.jx.uj> sl;
    public final LongSparseArray<RadialGradient> sp;
    public final com.byazt.dg.c<PointF, PointF> t;
    public final com.byazt.dg.c<PointF, PointF> u;
    public final String uj;
    public final RectF x;
    public com.byazt.dg.nu yp;

    public i(com.byazt.ga.x xVar, com.byazt.zk.ve veVar, com.byazt.jx.a aVar) {
        super(xVar, veVar, aVar.x().c(), aVar.i().c(), aVar.t(), aVar.uj(), aVar.sp(), aVar.da(), aVar.sl());
        this.f29257a = new LongSparseArray<>();
        this.sp = new LongSparseArray<>();
        this.x = new RectF();
        this.uj = aVar.c();
        this.i = aVar.tt();
        this.n = aVar.u();
        this.da = (int) (xVar.p().n() / 32.0f);
        com.byazt.dg.c<com.byazt.jx.uj, com.byazt.jx.uj> cVarC = aVar.ve().c();
        this.sl = cVarC;
        cVarC.c(this);
        veVar.c(cVarC);
        com.byazt.dg.c<PointF, PointF> cVarC2 = aVar.n().c();
        this.t = cVarC2;
        cVarC2.c(this);
        veVar.c(cVarC2);
        com.byazt.dg.c<PointF, PointF> cVarC3 = aVar.a().c();
        this.u = cVarC3;
        cVarC3.c(this);
        veVar.c(cVarC3);
    }

    private LinearGradient tt() {
        long jUj = uj();
        LinearGradient linearGradient = this.f29257a.get(jUj);
        if (linearGradient != null) {
            return linearGradient;
        }
        PointF pointFSp = this.t.sp();
        PointF pointFSp2 = this.u.sp();
        com.byazt.jx.uj ujVarSp = this.sl.sp();
        LinearGradient linearGradient2 = new LinearGradient(pointFSp.x, pointFSp.y, pointFSp2.x, pointFSp2.y, c(ujVarSp.tt()), ujVarSp.c(), Shader.TileMode.CLAMP);
        this.f29257a.put(jUj, linearGradient2);
        return linearGradient2;
    }

    private int uj() {
        int iRound = Math.round(this.t.x() * this.da);
        int iRound2 = Math.round(this.u.x() * this.da);
        int iRound3 = Math.round(this.sl.x() * this.da);
        int i = iRound != 0 ? iRound * 527 : 17;
        if (iRound2 != 0) {
            i = i * 31 * iRound2;
        }
        return iRound3 != 0 ? i * 31 * iRound3 : i;
    }

    private RadialGradient ve() {
        long jUj = uj();
        RadialGradient radialGradient = this.sp.get(jUj);
        if (radialGradient != null) {
            return radialGradient;
        }
        PointF pointFSp = this.t.sp();
        PointF pointFSp2 = this.u.sp();
        com.byazt.jx.uj ujVarSp = this.sl.sp();
        int[] iArrC = c(ujVarSp.tt());
        float[] fArrC = ujVarSp.c();
        float f = pointFSp.x;
        float f2 = pointFSp.y;
        RadialGradient radialGradient2 = new RadialGradient(f, f2, (float) Math.hypot(pointFSp2.x - f, pointFSp2.y - f2), iArrC, fArrC, Shader.TileMode.CLAMP);
        this.sp.put(jUj, radialGradient2);
        return radialGradient2;
    }

    @Override // com.byazt.zy.c, com.byazt.zy.n
    public void c(Canvas canvas, Matrix matrix, int i) {
        if (this.n) {
            return;
        }
        c(this.x, matrix, false);
        Shader shaderTt = this.i == com.byazt.jx.sp.LINEAR ? tt() : ve();
        shaderTt.setLocalMatrix(matrix);
        this.tt.setShader(shaderTt);
        super.c(canvas, matrix, i);
    }

    private int[] c(int[] iArr) {
        com.byazt.dg.nu nuVar = this.yp;
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
