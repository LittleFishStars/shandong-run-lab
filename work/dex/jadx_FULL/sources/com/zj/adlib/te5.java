package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class te5 extends cl3 {
    public int K;
    public int L;
    public Matrix b;
    public Matrix c;

    public te5(Drawable drawable, Matrix matrix) {
        super((Drawable) ax6.i(drawable));
        this.K = 0;
        this.L = 0;
        this.b = matrix;
    }

    @Override // com.zj.adlib.cl3, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        s();
        if (this.c == null) {
            super.draw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.clipRect(getBounds());
        canvas.concat(this.c);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // com.zj.adlib.cl3, com.facebook.drawee.drawable.TransformCallback
    public void o(Matrix matrix) {
        super.o(matrix);
        Matrix matrix2 = this.c;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }

    @Override // com.zj.adlib.cl3, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        super.onBoundsChange(rect);
        r();
    }

    @Override // com.zj.adlib.cl3
    public Drawable q(Drawable drawable) {
        Drawable drawableQ = super.q(drawable);
        r();
        return drawableQ;
    }

    public final void r() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.K = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.L = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.c = null;
        } else {
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            this.c = this.b;
        }
    }

    public final void s() {
        if (this.K == getCurrent().getIntrinsicWidth() && this.L == getCurrent().getIntrinsicHeight()) {
            return;
        }
        r();
    }

    public Matrix t() {
        return this.b;
    }

    public void u(Matrix matrix) {
        this.b = matrix;
        r();
        invalidateSelf();
    }
}
