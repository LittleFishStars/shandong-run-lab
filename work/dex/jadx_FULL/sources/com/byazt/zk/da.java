package com.byazt.zk;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.byazt.jx.m;
import java.util.Collections;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 909, 72})
public class da extends ve {
    public final com.byazt.zy.uj sp;
    public final uj x;

    public da(com.byazt.ga.x xVar, x xVar2, uj ujVar, com.byazt.ga.a aVar) {
        super(xVar, xVar2);
        this.x = ujVar;
        com.byazt.zy.uj ujVar2 = new com.byazt.zy.uj(xVar, this, new m("__container", xVar2.yp(), false), aVar);
        this.sp = ujVar2;
        ujVar2.c(Collections.emptyList(), Collections.emptyList());
    }

    @Override // com.byazt.zk.ve, com.byazt.zy.n
    public void c(RectF rectF, Matrix matrix, boolean z) {
        super.c(rectF, matrix, z);
        this.sp.c(rectF, this.c, z);
    }

    @Override // com.byazt.zk.ve
    public com.byazt.jx.c t() {
        com.byazt.jx.c cVarT = super.t();
        return cVarT != null ? cVarT : this.x.t();
    }

    @Override // com.byazt.zk.ve
    public void tt(Canvas canvas, Matrix matrix, int i) {
        super.tt(canvas, matrix, i);
        this.sp.c(canvas, matrix, i);
    }

    @Override // com.byazt.zk.ve
    public com.byazt.fs.da u() {
        com.byazt.fs.da daVarU = super.u();
        return daVarU != null ? daVarU : this.x.u();
    }
}
