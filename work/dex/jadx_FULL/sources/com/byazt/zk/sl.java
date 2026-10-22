package com.byazt.zk;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 909, 158})
public class sl extends ve {
    public final Path da;
    public final float[] i;
    public final x sl;
    public final RectF sp;
    public com.byazt.dg.c<ColorFilter, ColorFilter> t;
    public final Paint x;

    public sl(com.byazt.ga.x xVar, x xVar2) {
        super(xVar, xVar2);
        this.sp = new RectF();
        com.byazt.xg.c cVar = new com.byazt.xg.c();
        this.x = cVar;
        this.i = new float[8];
        this.da = new Path();
        this.sl = xVar2;
        cVar.setAlpha(0);
        cVar.setStyle(Paint.Style.FILL);
        cVar.setColor(xVar2.m());
    }

    @Override // com.byazt.zk.ve, com.byazt.zy.n
    public void c(RectF rectF, Matrix matrix, boolean z) {
        super.c(rectF, matrix, z);
        this.sp.set(0.0f, 0.0f, this.sl.rh(), this.sl.nu());
        this.c.mapRect(this.sp);
        rectF.set(this.sp);
    }

    @Override // com.byazt.zk.ve
    public void tt(Canvas canvas, Matrix matrix, int i) {
        super.tt(canvas, matrix, i);
        int iAlpha = Color.alpha(this.sl.m());
        if (iAlpha == 0) {
            return;
        }
        int iIntValue = (int) ((i / 255.0f) * (((iAlpha / 255.0f) * (this.uj.c() == null ? 100 : this.uj.c().sp().intValue())) / 100.0f) * 255.0f);
        this.x.setAlpha(iIntValue);
        com.byazt.dg.c<ColorFilter, ColorFilter> cVar = this.t;
        if (cVar != null) {
            this.x.setColorFilter(cVar.sp());
        }
        if (iIntValue > 0) {
            float[] fArr = this.i;
            fArr[0] = 0.0f;
            fArr[1] = 0.0f;
            fArr[2] = this.sl.rh();
            float[] fArr2 = this.i;
            fArr2[3] = 0.0f;
            fArr2[4] = this.sl.rh();
            this.i[5] = this.sl.nu();
            float[] fArr3 = this.i;
            fArr3[6] = 0.0f;
            fArr3[7] = this.sl.nu();
            matrix.mapPoints(this.i);
            this.da.reset();
            Path path = this.da;
            float[] fArr4 = this.i;
            path.moveTo(fArr4[0], fArr4[1]);
            Path path2 = this.da;
            float[] fArr5 = this.i;
            path2.lineTo(fArr5[2], fArr5[3]);
            Path path3 = this.da;
            float[] fArr6 = this.i;
            path3.lineTo(fArr6[4], fArr6[5]);
            Path path4 = this.da;
            float[] fArr7 = this.i;
            path4.lineTo(fArr7[6], fArr7[7]);
            Path path5 = this.da;
            float[] fArr8 = this.i;
            path5.lineTo(fArr8[0], fArr8[1]);
            this.da.close();
            canvas.drawPath(this.da, this.x);
        }
    }
}
