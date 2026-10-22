package com.byazt.zy;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Path;
import android.graphics.RectF;
import com.hzchengdun.securityguard.SecExceptionCode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.ListIterator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, SecExceptionCode.SEC_ERROR_SAFETOKEN_UNSUPPORTED, 130})
public class m implements da, n, sl, u, com.byazt.dg.c.InterfaceC0385c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f29258a;
    public uj da;
    public final com.byazt.dg.m i;
    public final String n;
    public final com.byazt.dg.c<Float, Float> sp;
    public final com.byazt.zk.ve uj;
    public final com.byazt.ga.x ve;
    public final com.byazt.dg.c<Float, Float> x;
    public final Matrix c = new Matrix();
    public final Path tt = new Path();

    public m(com.byazt.ga.x xVar, com.byazt.zk.ve veVar, com.byazt.jx.t tVar) {
        this.ve = xVar;
        this.uj = veVar;
        this.n = tVar.c();
        this.f29258a = tVar.n();
        com.byazt.dg.c<Float, Float> cVarC = tVar.tt().c();
        this.sp = cVarC;
        veVar.c(cVarC);
        cVarC.c(this);
        com.byazt.dg.c<Float, Float> cVarC2 = tVar.ve().c();
        this.x = cVarC2;
        veVar.c(cVarC2);
        cVarC2.c(this);
        com.byazt.dg.m mVarDa = tVar.uj().da();
        this.i = mVarDa;
        mVarDa.c(veVar);
        mVarDa.c(this);
    }

    @Override // com.byazt.zy.da
    public void c(ListIterator<ve> listIterator) {
        if (this.da != null) {
            return;
        }
        while (listIterator.hasPrevious() && listIterator.previous() != this) {
        }
        ArrayList arrayList = new ArrayList();
        while (listIterator.hasPrevious()) {
            arrayList.add(listIterator.previous());
            listIterator.remove();
        }
        Collections.reverse(arrayList);
        this.da = new uj(this.ve, this.uj, "Repeater", this.f29258a, arrayList, null);
    }

    @Override // com.byazt.zy.u
    public Path uj() {
        Path pathUj = this.da.uj();
        this.tt.reset();
        float fFloatValue = this.sp.sp().floatValue();
        float fFloatValue2 = this.x.sp().floatValue();
        for (int i = ((int) fFloatValue) - 1; i >= 0; i--) {
            this.c.set(this.i.tt(i + fFloatValue2));
            this.tt.addPath(pathUj, this.c);
        }
        return this.tt;
    }

    @Override // com.byazt.zy.ve
    public void c(List<ve> list, List<ve> list2) {
        this.da.c(list, list2);
    }

    @Override // com.byazt.zy.n
    public void c(Canvas canvas, Matrix matrix, int i) {
        float fFloatValue = this.sp.sp().floatValue();
        float fFloatValue2 = this.x.sp().floatValue();
        float fFloatValue3 = this.i.tt().sp().floatValue() / 100.0f;
        float fFloatValue4 = this.i.ve().sp().floatValue() / 100.0f;
        for (int i2 = ((int) fFloatValue) - 1; i2 >= 0; i2--) {
            this.c.set(matrix);
            float f = i2;
            this.c.preConcat(this.i.tt(f + fFloatValue2));
            this.da.c(canvas, this.c, (int) (i * com.byazt.kk.i.c(fFloatValue3, fFloatValue4, f / fFloatValue)));
        }
    }

    @Override // com.byazt.zy.n
    public void c(RectF rectF, Matrix matrix, boolean z) {
        this.da.c(rectF, matrix, z);
    }

    @Override // com.byazt.dg.c.InterfaceC0385c
    public void c() {
        this.ve.invalidateSelf();
    }
}
