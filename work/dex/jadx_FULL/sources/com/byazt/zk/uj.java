package com.byazt.zk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.LongSparseArray;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 909, 15})
public class uj extends ve {
    public final RectF da;
    public final RectF i;
    public final Paint sl;
    public com.byazt.dg.c<Float, Float> sp;
    public boolean t;
    public final List<ve> x;

    /* JADX INFO: renamed from: com.byazt.zk.uj$1, reason: invalid class name */
    @com.byazt.zqa.c(c = {0, 1, 909, 99})
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] c;

        static {
            int[] iArr = new int[x.tt.values().length];
            c = iArr;
            try {
                iArr[x.tt.ADD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                c[x.tt.INVERT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public uj(com.byazt.ga.x xVar, x xVar2, List<x> list, com.byazt.ga.a aVar, Context context) {
        int i;
        ve veVar;
        x.tt ttVarT;
        int i2;
        super(xVar, xVar2);
        this.x = new ArrayList();
        this.i = new RectF();
        this.da = new RectF();
        this.sl = new Paint();
        this.t = true;
        com.byazt.kd.tt ttVarRl = xVar2.rl();
        if (ttVarRl != null) {
            com.byazt.dg.c<Float, Float> cVarC = ttVarRl.c();
            this.sp = cVarC;
            c(cVarC);
            this.sp.c(this);
        } else {
            this.sp = null;
        }
        LongSparseArray longSparseArray = new LongSparseArray(aVar.yp().size());
        int size = list.size() - 1;
        ve veVar2 = null;
        while (true) {
            if (size < 0) {
                break;
            }
            x xVar3 = list.get(size);
            ve veVarC = ve.c(this, xVar3, xVar, aVar, context);
            if (veVarC != null) {
                longSparseArray.put(veVarC.uj().n(), veVarC);
                if (veVar2 != null) {
                    veVar2.c(veVarC);
                    veVar2 = null;
                } else {
                    this.x.add(0, veVarC);
                    if (xVar3 != null && (ttVarT = xVar3.t()) != null && ((i2 = AnonymousClass1.c[ttVarT.ordinal()]) == 1 || i2 == 2)) {
                        veVar2 = veVarC;
                    }
                }
            }
            size--;
        }
        for (i = 0; i < longSparseArray.size(); i++) {
            ve veVar3 = (ve) longSparseArray.get(longSparseArray.keyAt(i));
            if (veVar3 != null && (veVar = (ve) longSparseArray.get(veVar3.uj().u())) != null) {
                veVar3.tt(veVar);
            }
        }
    }

    @Override // com.byazt.zk.ve
    public void c(boolean z) {
        super.c(z);
        Iterator<ve> it = this.x.iterator();
        while (it.hasNext()) {
            it.next().c(z);
        }
    }

    public void tt(boolean z) {
        this.t = z;
    }

    public List<ve> yp() {
        return this.x;
    }

    @Override // com.byazt.zk.ve
    public void tt(Canvas canvas, Matrix matrix, int i) {
        super.tt(canvas, matrix, i);
        com.byazt.ga.n.c("CompositionLayer#draw");
        this.da.set(0.0f, 0.0f, this.ve.x(), this.ve.i());
        matrix.mapRect(this.da);
        boolean z = this.tt.da() && this.x.size() > 1 && i != 255;
        if (z) {
            this.sl.setAlpha(i);
            com.byazt.kk.da.c(canvas, this.da, this.sl);
        } else {
            canvas.save();
        }
        if (z) {
            i = 255;
        }
        for (int size = this.x.size() - 1; size >= 0; size--) {
            if (((!this.t && "__container".equals(this.ve.a())) || this.da.isEmpty()) ? true : canvas.clipRect(this.da)) {
                this.x.get(size).c(canvas, matrix, i);
            }
        }
        canvas.restore();
        com.byazt.ga.n.tt("CompositionLayer#draw");
    }

    @Override // com.byazt.zk.ve, com.byazt.zy.n
    public void c(RectF rectF, Matrix matrix, boolean z) {
        super.c(rectF, matrix, z);
        for (int size = this.x.size() - 1; size >= 0; size--) {
            this.i.set(0.0f, 0.0f, 0.0f, 0.0f);
            this.x.get(size).c(this.i, this.c, true);
            rectF.union(this.i);
        }
    }

    @Override // com.byazt.zk.ve
    public void c(float f) {
        super.c(f);
        if (this.sp != null) {
            f = ((this.sp.sp().floatValue() * this.ve.c().u()) - this.ve.c().a()) / (this.tt.p().rh() + 0.01f);
        }
        if (this.sp == null) {
            f -= this.ve.ve();
        }
        if (this.ve.tt() != 0.0f && !"__container".equals(this.ve.a())) {
            f /= this.ve.tt();
        }
        for (int size = this.x.size() - 1; size >= 0; size--) {
            this.x.get(size).c(f);
        }
    }
}
