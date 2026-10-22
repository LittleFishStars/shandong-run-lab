package com.byazt.zy;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, 15})
public class uj implements n, u, com.byazt.dg.c.InterfaceC0385c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f29263a;
    public final Paint c;
    public List<u> da;
    public final com.byazt.ga.x i;
    public final RectF n;
    public com.byazt.dg.m sl;
    public final boolean sp;
    public final RectF tt;
    public final Path uj;
    public final Matrix ve;
    public final List<ve> x;

    public uj(com.byazt.ga.x xVar, com.byazt.zk.ve veVar, com.byazt.jx.m mVar, com.byazt.ga.a aVar) {
        this(xVar, veVar, mVar.c(), mVar.ve(), c(xVar, aVar, veVar, mVar.tt()), c(mVar.tt()));
    }

    private static List<ve> c(com.byazt.ga.x xVar, com.byazt.ga.a aVar, com.byazt.zk.ve veVar, List<com.byazt.jx.ve> list) {
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < list.size(); i++) {
            ve veVarC = list.get(i).c(xVar, aVar, veVar);
            if (veVarC != null) {
                arrayList.add(veVarC);
            }
        }
        return arrayList;
    }

    private boolean n() {
        int i = 0;
        for (int i2 = 0; i2 < this.x.size(); i2++) {
            if ((this.x.get(i2) instanceof n) && (i = i + 1) >= 2) {
                return true;
            }
        }
        return false;
    }

    public List<u> tt() {
        if (this.da == null) {
            this.da = new ArrayList();
            for (int i = 0; i < this.x.size(); i++) {
                ve veVar = this.x.get(i);
                if (veVar instanceof u) {
                    this.da.add((u) veVar);
                }
            }
        }
        return this.da;
    }

    @Override // com.byazt.zy.u
    public Path uj() {
        this.ve.reset();
        com.byazt.dg.m mVar = this.sl;
        if (mVar != null) {
            this.ve.set(mVar.uj());
        }
        this.uj.reset();
        if (this.sp) {
            return this.uj;
        }
        for (int size = this.x.size() - 1; size >= 0; size--) {
            ve veVar = this.x.get(size);
            if (veVar instanceof u) {
                this.uj.addPath(((u) veVar).uj(), this.ve);
            }
        }
        return this.uj;
    }

    public Matrix ve() {
        com.byazt.dg.m mVar = this.sl;
        if (mVar != null) {
            return mVar.uj();
        }
        this.ve.reset();
        return this.ve;
    }

    public uj(com.byazt.ga.x xVar, com.byazt.zk.ve veVar, String str, boolean z, List<ve> list, com.byazt.kd.t tVar) {
        this.c = new com.byazt.xg.c();
        this.tt = new RectF();
        this.ve = new Matrix();
        this.uj = new Path();
        this.n = new RectF();
        this.f29263a = str;
        this.i = xVar;
        this.sp = z;
        this.x = list;
        if (tVar != null) {
            com.byazt.dg.m mVarDa = tVar.da();
            this.sl = mVarDa;
            mVarDa.c(veVar);
            this.sl.c(this);
        }
        ArrayList arrayList = new ArrayList();
        for (int size = list.size() - 1; size >= 0; size--) {
            ve veVar2 = list.get(size);
            if (veVar2 instanceof da) {
                arrayList.add((da) veVar2);
            }
        }
        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
            ((da) arrayList.get(size2)).c(list.listIterator(list.size()));
        }
    }

    public static com.byazt.kd.t c(List<com.byazt.jx.ve> list) {
        for (int i = 0; i < list.size(); i++) {
            com.byazt.jx.ve veVar = list.get(i);
            if (veVar instanceof com.byazt.kd.t) {
                return (com.byazt.kd.t) veVar;
            }
        }
        return null;
    }

    @Override // com.byazt.dg.c.InterfaceC0385c
    public void c() {
        this.i.invalidateSelf();
    }

    @Override // com.byazt.zy.ve
    public void c(List<ve> list, List<ve> list2) {
        ArrayList arrayList = new ArrayList(list.size() + this.x.size());
        arrayList.addAll(list);
        for (int size = this.x.size() - 1; size >= 0; size--) {
            ve veVar = this.x.get(size);
            veVar.c(arrayList, this.x.subList(0, size));
            arrayList.add(veVar);
        }
    }

    @Override // com.byazt.zy.n
    public void c(Canvas canvas, Matrix matrix, int i) {
        if (this.sp) {
            return;
        }
        this.ve.set(matrix);
        com.byazt.dg.m mVar = this.sl;
        if (mVar != null) {
            this.ve.preConcat(mVar.uj());
            i = (int) (((((this.sl.c() == null ? 100 : this.sl.c().sp().intValue()) / 100.0f) * i) / 255.0f) * 255.0f);
        }
        boolean z = this.i.da() && n() && i != 255;
        if (z) {
            this.tt.set(0.0f, 0.0f, 0.0f, 0.0f);
            c(this.tt, this.ve, true);
            this.c.setAlpha(i);
            com.byazt.kk.da.c(canvas, this.tt, this.c);
        }
        if (z) {
            i = 255;
        }
        for (int size = this.x.size() - 1; size >= 0; size--) {
            ve veVar = this.x.get(size);
            if (veVar instanceof n) {
                ((n) veVar).c(canvas, this.ve, i);
            }
        }
        if (z) {
            canvas.restore();
        }
    }

    @Override // com.byazt.zy.n
    public void c(RectF rectF, Matrix matrix, boolean z) {
        this.ve.set(matrix);
        com.byazt.dg.m mVar = this.sl;
        if (mVar != null) {
            this.ve.preConcat(mVar.uj());
        }
        this.n.set(0.0f, 0.0f, 0.0f, 0.0f);
        for (int size = this.x.size() - 1; size >= 0; size--) {
            ve veVar = this.x.get(size);
            if (veVar instanceof n) {
                ((n) veVar).c(this.n, this.ve, z);
                rectF.union(this.n);
            }
        }
    }
}
