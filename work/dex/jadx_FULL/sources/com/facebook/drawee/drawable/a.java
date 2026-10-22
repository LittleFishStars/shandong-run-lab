package com.facebook.drawee.drawable;

import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import com.facebook.common.internal.VisibleForTesting;
import com.zj.adlib.ax6;
import com.zj.adlib.cl3;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a extends cl3 {

    @VisibleForTesting
    public int K;

    @VisibleForTesting
    public int L;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @VisibleForTesting
    public PointF f29974a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public ScalingUtils.ScaleType f1619a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    @VisibleForTesting
    public Object f1620a;

    @VisibleForTesting
    public Matrix b;
    public Matrix c;

    public a(Drawable drawable, ScalingUtils.ScaleType scaleType) {
        super((Drawable) ax6.i(drawable));
        this.f29974a = null;
        this.K = 0;
        this.L = 0;
        this.c = new Matrix();
        this.f1619a = scaleType;
    }

    @Override // com.zj.adlib.cl3, android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        s();
        if (this.b == null) {
            super.draw(canvas);
            return;
        }
        int iSave = canvas.save();
        canvas.clipRect(getBounds());
        canvas.concat(this.b);
        super.draw(canvas);
        canvas.restoreToCount(iSave);
    }

    @Override // com.zj.adlib.cl3, com.facebook.drawee.drawable.TransformCallback
    public void o(Matrix matrix) {
        getParentTransform(matrix);
        s();
        Matrix matrix2 = this.b;
        if (matrix2 != null) {
            matrix.preConcat(matrix2);
        }
    }

    @Override // com.zj.adlib.cl3, android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        r();
    }

    @Override // com.zj.adlib.cl3
    public Drawable q(Drawable drawable) {
        Drawable drawableQ = super.q(drawable);
        r();
        return drawableQ;
    }

    @VisibleForTesting
    public void r() {
        Drawable current = getCurrent();
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int iHeight = bounds.height();
        int intrinsicWidth = current.getIntrinsicWidth();
        this.K = intrinsicWidth;
        int intrinsicHeight = current.getIntrinsicHeight();
        this.L = intrinsicHeight;
        if (intrinsicWidth <= 0 || intrinsicHeight <= 0) {
            current.setBounds(bounds);
            this.b = null;
            return;
        }
        if (intrinsicWidth == iWidth && intrinsicHeight == iHeight) {
            current.setBounds(bounds);
            this.b = null;
        } else {
            if (this.f1619a == ScalingUtils.ScaleType.f29972a) {
                current.setBounds(bounds);
                this.b = null;
                return;
            }
            current.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
            ScalingUtils.ScaleType scaleType = this.f1619a;
            Matrix matrix = this.c;
            PointF pointF = this.f29974a;
            scaleType.a(matrix, bounds, intrinsicWidth, intrinsicHeight, pointF != null ? pointF.x : 0.5f, pointF != null ? pointF.y : 0.5f);
            this.b = this.c;
        }
    }

    public final void s() {
        boolean z;
        ScalingUtils.ScaleType scaleType = this.f1619a;
        boolean z2 = true;
        if (scaleType instanceof ScalingUtils.StatefulScaleType) {
            Object state = ((ScalingUtils.StatefulScaleType) scaleType).getState();
            z = state == null || !state.equals(this.f1620a);
            this.f1620a = state;
        } else {
            z = false;
        }
        if (this.K == getCurrent().getIntrinsicWidth() && this.L == getCurrent().getIntrinsicHeight()) {
            z2 = false;
        }
        if (z2 || z) {
            r();
        }
    }

    public PointF t() {
        return this.f29974a;
    }

    public ScalingUtils.ScaleType u() {
        return this.f1619a;
    }

    public void v(PointF pointF) {
        if (this.f29974a == null) {
            this.f29974a = new PointF();
        }
        this.f29974a.set(pointF);
        r();
        invalidateSelf();
    }

    public void w(ScalingUtils.ScaleType scaleType) {
        this.f1619a = scaleType;
        this.f1620a = null;
        r();
        invalidateSelf();
    }
}
