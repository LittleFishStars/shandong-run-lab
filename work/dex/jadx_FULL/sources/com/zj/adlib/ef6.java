package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class ef6 extends cl3 {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RectF f41424a;

    @VisibleForTesting
    public final Matrix b;
    public final Matrix c;

    public ef6(Drawable drawable, int i) {
        super(drawable);
        this.c = new Matrix();
        this.f41424a = new RectF();
        ax6.d(i % 90 == 0);
        this.b = new Matrix();
        this.K = i;
    }

    @Override // com.zj.adlib.cl3, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.K <= 0) {
            super.draw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.concat(this.b);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // com.zj.adlib.cl3, android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.K % 180 == 0 ? super.getIntrinsicHeight() : super.getIntrinsicWidth();
    }

    @Override // com.zj.adlib.cl3, android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.K % 180 == 0 ? super.getIntrinsicWidth() : super.getIntrinsicHeight();
    }

    @Override // com.zj.adlib.cl3, com.facebook.drawee.drawable.TransformCallback
    public void o(Matrix matrix) {
        getParentTransform(matrix);
        if (this.b.isIdentity()) {
            return;
        }
        matrix.preConcat(this.b);
    }

    @Override // com.zj.adlib.cl3, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        Drawable current = getCurrent();
        int i = this.K;
        if (i <= 0) {
            current.setBounds(rect);
            return;
        }
        this.b.setRotate(i, rect.centerX(), rect.centerY());
        this.c.reset();
        this.b.invert(this.c);
        this.f41424a.set(rect);
        this.c.mapRect(this.f41424a);
        RectF rectF = this.f41424a;
        current.setBounds((int) rectF.left, (int) rectF.top, (int) rectF.right, (int) rectF.bottom);
    }
}
