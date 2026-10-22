package com.byazt.zk;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 909, 91})
public class sp extends ve {
    public final Rect da;
    public final Rect i;
    public com.byazt.dg.c<ColorFilter, ColorFilter> sl;
    public final com.byazt.ga.i sp;
    public com.byazt.dg.c<Bitmap, Bitmap> t;
    public final Paint x;

    public sp(com.byazt.ga.x xVar, x xVar2) {
        super(xVar, xVar2);
        this.x = new com.byazt.xg.c(3);
        this.i = new Rect();
        this.da = new Rect();
        this.sp = xVar.a(xVar2.sp());
    }

    @Override // com.byazt.zk.ve, com.byazt.zy.n
    public void c(RectF rectF, Matrix matrix, boolean z) {
        super.c(rectF, matrix, z);
        if (this.sp != null) {
            float fC = com.byazt.kk.da.c();
            rectF.set(0.0f, 0.0f, this.sp.c() * fC, this.sp.tt() * fC);
            this.c.mapRect(rectF);
        }
    }

    @Override // com.byazt.zk.ve
    public void tt(Canvas canvas, Matrix matrix, int i) {
        super.tt(canvas, matrix, i);
        Bitmap bitmapYp = yp();
        if (bitmapYp == null || bitmapYp.isRecycled() || this.sp == null) {
            return;
        }
        float fC = com.byazt.kk.da.c();
        this.x.setAlpha(i);
        com.byazt.dg.c<ColorFilter, ColorFilter> cVar = this.sl;
        if (cVar != null) {
            this.x.setColorFilter(cVar.sp());
        }
        canvas.save();
        canvas.concat(matrix);
        this.i.set(0, 0, bitmapYp.getWidth(), bitmapYp.getHeight());
        if (this.tt.a()) {
            this.da.set(0, 0, (int) (this.sp.c() * fC), (int) (this.sp.tt() * fC));
        } else {
            this.da.set(0, 0, (int) (bitmapYp.getWidth() * fC), (int) (bitmapYp.getHeight() * fC));
        }
        canvas.drawBitmap(bitmapYp, this.i, this.da, this.x);
        canvas.restore();
    }

    public Bitmap yp() {
        Bitmap bitmapSp;
        com.byazt.dg.c<Bitmap, Bitmap> cVar = this.t;
        if (cVar != null && (bitmapSp = cVar.sp()) != null) {
            return bitmapSp;
        }
        Bitmap bitmapN = this.tt.n(this.ve.sp());
        if (bitmapN != null) {
            return bitmapN;
        }
        com.byazt.ga.i iVar = this.sp;
        if (iVar != null) {
            return iVar.z();
        }
        return null;
    }
}
