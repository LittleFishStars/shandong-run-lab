package com.byazt.zy;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.DashPathEffect;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.RectF;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, 20})
public abstract class c implements n, sl, com.byazt.dg.c.InterfaceC0385c {
    public final com.byazt.zk.ve c;
    public final float[] da;
    public com.byazt.dg.c<Float, Float> m;
    public com.byazt.dg.ve nu;
    public final com.byazt.dg.c<?, Float> sl;
    public final com.byazt.dg.c<?, Integer> t;
    public final Paint tt;
    public final List<com.byazt.dg.c<?, Float>> u;
    public float ve;
    public final com.byazt.ga.x x;
    public final com.byazt.dg.c<?, Float> yp;
    public com.byazt.dg.c<ColorFilter, ColorFilter> z;
    public final PathMeasure uj = new PathMeasure();
    public final Path n = new Path();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Path f29255a = new Path();
    public final RectF sp = new RectF();
    public final List<C0602c> i = new ArrayList();

    /* JADX INFO: renamed from: com.byazt.zy.c$c, reason: collision with other inner class name */
    @com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, 44})
    public static final class C0602c {
        public final List<u> c;
        public final rl tt;

        private C0602c(rl rlVar) {
            this.c = new ArrayList();
            this.tt = rlVar;
        }
    }

    public c(com.byazt.ga.x xVar, com.byazt.zk.ve veVar, Paint.Cap cap, Paint.Join join, float f, com.byazt.kd.uj ujVar, com.byazt.kd.tt ttVar, List<com.byazt.kd.tt> list, com.byazt.kd.tt ttVar2) {
        com.byazt.xg.c cVar = new com.byazt.xg.c(1);
        this.tt = cVar;
        this.ve = 0.0f;
        this.x = xVar;
        this.c = veVar;
        cVar.setStyle(Paint.Style.STROKE);
        cVar.setStrokeCap(cap);
        cVar.setStrokeJoin(join);
        cVar.setStrokeMiter(f);
        this.t = ujVar.c();
        this.sl = ttVar.c();
        if (ttVar2 == null) {
            this.yp = null;
        } else {
            this.yp = ttVar2.c();
        }
        this.u = new ArrayList(list.size());
        this.da = new float[list.size()];
        for (int i = 0; i < list.size(); i++) {
            this.u.add(list.get(i).c());
        }
        veVar.c(this.t);
        veVar.c(this.sl);
        for (int i2 = 0; i2 < this.u.size(); i2++) {
            veVar.c(this.u.get(i2));
        }
        com.byazt.dg.c<?, Float> cVar2 = this.yp;
        if (cVar2 != null) {
            veVar.c(cVar2);
        }
        this.t.c(this);
        this.sl.c(this);
        for (int i3 = 0; i3 < list.size(); i3++) {
            this.u.get(i3).c(this);
        }
        com.byazt.dg.c<?, Float> cVar3 = this.yp;
        if (cVar3 != null) {
            cVar3.c(this);
        }
        if (veVar.t() != null) {
            com.byazt.dg.c<Float, Float> cVarC = veVar.t().c().c();
            this.m = cVarC;
            cVarC.c(this);
            veVar.c(this.m);
        }
        if (veVar.u() != null) {
            this.nu = new com.byazt.dg.ve(this, veVar, veVar.u());
        }
    }

    @Override // com.byazt.dg.c.InterfaceC0385c
    public void c() {
        this.x.invalidateSelf();
    }

    /* JADX WARN: Code duplicated, block: B:21:0x0055  */
    /* JADX WARN: Code duplicated, block: B:23:0x0059 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:24:0x005b  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069 A[SYNTHETIC] */
    @Override // com.byazt.zy.ve
    public void c(List<ve> list, List<ve> list2) {
        rl rlVar = null;
        for (int size = list.size() - 1; size >= 0; size--) {
            ve veVar = list.get(size);
            if (veVar instanceof rl) {
                rl rlVar2 = (rl) veVar;
                if (rlVar2.getType() == com.byazt.jx.my.c.INDIVIDUALLY) {
                    rlVar = rlVar2;
                }
            }
        }
        if (rlVar != null) {
            rlVar.c(this);
        }
        C0602c c0602c = null;
        for (int size2 = list2.size() - 1; size2 >= 0; size2--) {
            ve veVar2 = list2.get(size2);
            if (veVar2 instanceof rl) {
                rl rlVar3 = (rl) veVar2;
                if (rlVar3.getType() == com.byazt.jx.my.c.INDIVIDUALLY) {
                    if (c0602c != null) {
                        this.i.add(c0602c);
                    }
                    c0602c = new C0602c(rlVar3);
                    rlVar3.c(this);
                } else if (!(veVar2 instanceof u)) {
                    if (c0602c == null) {
                        c0602c = new C0602c(rlVar);
                    }
                    c0602c.c.add((u) veVar2);
                }
            } else if (!(veVar2 instanceof u)) {
                if (c0602c == null) {
                    c0602c = new C0602c(rlVar);
                }
                c0602c.c.add((u) veVar2);
            }
        }
        if (c0602c != null) {
            this.i.add(c0602c);
        }
    }

    @Override // com.byazt.zy.n
    public void c(Canvas canvas, Matrix matrix, int i) {
        com.byazt.ga.n.c("StrokeContent#draw");
        if (com.byazt.kk.da.tt(matrix)) {
            com.byazt.ga.n.tt("StrokeContent#draw");
            return;
        }
        this.tt.setAlpha(com.byazt.kk.i.c((int) ((((i / 255.0f) * ((com.byazt.dg.a) this.t).i()) / 100.0f) * 255.0f), 0, 255));
        this.tt.setStrokeWidth(((com.byazt.dg.uj) this.sl).i() * com.byazt.kk.da.c(matrix));
        if (this.tt.getStrokeWidth() <= 0.0f) {
            com.byazt.ga.n.tt("StrokeContent#draw");
            return;
        }
        c(matrix);
        com.byazt.dg.c<ColorFilter, ColorFilter> cVar = this.z;
        if (cVar != null) {
            this.tt.setColorFilter(cVar.sp());
        }
        com.byazt.dg.c<Float, Float> cVar2 = this.m;
        if (cVar2 != null) {
            float fFloatValue = cVar2.sp().floatValue();
            if (fFloatValue == 0.0f) {
                this.tt.setMaskFilter(null);
            } else if (fFloatValue != this.ve) {
                this.tt.setMaskFilter(this.c.tt(fFloatValue));
            }
            this.ve = fFloatValue;
        }
        com.byazt.dg.ve veVar = this.nu;
        if (veVar != null) {
            veVar.c(this.tt);
        }
        for (int i2 = 0; i2 < this.i.size(); i2++) {
            C0602c c0602c = this.i.get(i2);
            if (c0602c.tt != null) {
                c(canvas, c0602c, matrix);
            } else {
                com.byazt.ga.n.c("StrokeContent#buildPath");
                this.n.reset();
                for (int size = c0602c.c.size() - 1; size >= 0; size--) {
                    this.n.addPath(((u) c0602c.c.get(size)).uj(), matrix);
                }
                com.byazt.ga.n.tt("StrokeContent#buildPath");
                com.byazt.ga.n.c("StrokeContent#drawPath");
                canvas.drawPath(this.n, this.tt);
                com.byazt.ga.n.tt("StrokeContent#drawPath");
            }
        }
        com.byazt.ga.n.tt("StrokeContent#draw");
    }

    /* JADX WARN: Code duplicated, block: B:32:0x0110  */
    private void c(Canvas canvas, C0602c c0602c, Matrix matrix) {
        float f;
        float f2;
        float fMin;
        com.byazt.ga.n.c("StrokeContent#applyTrimPath");
        if (c0602c.tt == null) {
            com.byazt.ga.n.tt("StrokeContent#applyTrimPath");
            return;
        }
        this.n.reset();
        for (int size = c0602c.c.size() - 1; size >= 0; size--) {
            this.n.addPath(((u) c0602c.c.get(size)).uj(), matrix);
        }
        float fFloatValue = c0602c.tt.tt().sp().floatValue() / 100.0f;
        float fFloatValue2 = c0602c.tt.ve().sp().floatValue() / 100.0f;
        float fFloatValue3 = c0602c.tt.uj().sp().floatValue() / 360.0f;
        if (fFloatValue < 0.01f && fFloatValue2 > 0.99f) {
            canvas.drawPath(this.n, this.tt);
            com.byazt.ga.n.tt("StrokeContent#applyTrimPath");
            return;
        }
        this.uj.setPath(this.n, false);
        float length = this.uj.getLength();
        while (this.uj.nextContour()) {
            length += this.uj.getLength();
        }
        float f3 = fFloatValue3 * length;
        float f4 = (fFloatValue * length) + f3;
        float fMin2 = Math.min((fFloatValue2 * length) + f3, (f4 + length) - 1.0f);
        float f5 = 0.0f;
        for (int size2 = c0602c.c.size() - 1; size2 >= 0; size2--) {
            this.f29255a.set(((u) c0602c.c.get(size2)).uj());
            this.f29255a.transform(matrix);
            this.uj.setPath(this.f29255a, false);
            float length2 = this.uj.getLength();
            if (fMin2 > length) {
                float f6 = fMin2 - length;
                if (f6 >= f5 + length2 || f5 >= f6) {
                    f = f5 + length2;
                    if (f < f4 && f5 <= fMin2) {
                        if (f > fMin2 || f4 >= f5) {
                            f2 = f4 < f5 ? 0.0f : (f4 - f5) / length2;
                            fMin = fMin2 > f ? 1.0f : (fMin2 - f5) / length2;
                        } else {
                            canvas.drawPath(this.f29255a, this.tt);
                        }
                    }
                } else {
                    f2 = f4 > length ? (f4 - length) / length2 : 0.0f;
                    fMin = Math.min(f6 / length2, 1.0f);
                }
                com.byazt.kk.da.c(this.f29255a, f2, fMin, 0.0f);
                canvas.drawPath(this.f29255a, this.tt);
            } else {
                f = f5 + length2;
                if (f < f4) {
                }
            }
            f5 += length2;
        }
        com.byazt.ga.n.tt("StrokeContent#applyTrimPath");
    }

    @Override // com.byazt.zy.n
    public void c(RectF rectF, Matrix matrix, boolean z) {
        com.byazt.ga.n.c("StrokeContent#getBounds");
        this.n.reset();
        for (int i = 0; i < this.i.size(); i++) {
            C0602c c0602c = this.i.get(i);
            for (int i2 = 0; i2 < c0602c.c.size(); i2++) {
                this.n.addPath(((u) c0602c.c.get(i2)).uj(), matrix);
            }
        }
        this.n.computeBounds(this.sp, false);
        float fI = ((com.byazt.dg.uj) this.sl).i();
        RectF rectF2 = this.sp;
        float f = fI / 2.0f;
        rectF2.set(rectF2.left - f, rectF2.top - f, rectF2.right + f, rectF2.bottom + f);
        rectF.set(this.sp);
        rectF.set(rectF.left - 1.0f, rectF.top - 1.0f, rectF.right + 1.0f, rectF.bottom + 1.0f);
        com.byazt.ga.n.tt("StrokeContent#getBounds");
    }

    private void c(Matrix matrix) {
        com.byazt.ga.n.c("StrokeContent#applyDashPattern");
        if (this.u.isEmpty()) {
            com.byazt.ga.n.tt("StrokeContent#applyDashPattern");
            return;
        }
        float fC = com.byazt.kk.da.c(matrix);
        for (int i = 0; i < this.u.size(); i++) {
            this.da[i] = this.u.get(i).sp().floatValue();
            if (i % 2 == 0) {
                float[] fArr = this.da;
                if (fArr[i] < 1.0f) {
                    fArr[i] = 1.0f;
                }
            } else {
                float[] fArr2 = this.da;
                if (fArr2[i] < 0.1f) {
                    fArr2[i] = 0.1f;
                }
            }
            float[] fArr3 = this.da;
            fArr3[i] = fArr3[i] * fC;
        }
        com.byazt.dg.c<?, Float> cVar = this.yp;
        this.tt.setPathEffect(new DashPathEffect(this.da, cVar == null ? 0.0f : fC * cVar.sp().floatValue()));
        com.byazt.ga.n.tt("StrokeContent#applyDashPattern");
    }
}
