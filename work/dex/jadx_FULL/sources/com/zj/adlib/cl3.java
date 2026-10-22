package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import com.facebook.drawee.drawable.DrawableParent;
import com.facebook.drawee.drawable.TransformAwareDrawable;
import com.facebook.drawee.drawable.TransformCallback;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class cl3 extends Drawable implements Drawable.Callback, TransformCallback, TransformAwareDrawable, DrawableParent {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Matrix f40990a = new Matrix();

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Drawable f15849a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public TransformCallback f15850a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final fr2 f15851a = new fr2();

    public cl3(Drawable drawable) {
        this.f15849a = drawable;
        mr2.d(drawable, this, this);
    }

    @Override // com.facebook.drawee.drawable.TransformAwareDrawable
    public void a(TransformCallback transformCallback) {
        this.f15850a = transformCallback;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        this.f15849a.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable getCurrent() {
        return this.f15849a;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.f15849a.getIntrinsicHeight();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.f15849a.getIntrinsicWidth();
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return this.f15849a.getOpacity();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        return this.f15849a.getPadding(rect);
    }

    public void getParentTransform(Matrix matrix) {
        TransformCallback transformCallback = this.f15850a;
        if (transformCallback != null) {
            transformCallback.o(matrix);
        } else {
            matrix.reset();
        }
    }

    @Override // com.facebook.drawee.drawable.DrawableParent
    public Drawable h(Drawable drawable) {
        return q(drawable);
    }

    @Override // com.facebook.drawee.drawable.DrawableParent
    public Drawable i() {
        return getCurrent();
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void invalidateDrawable(Drawable drawable) {
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public boolean isStateful() {
        return this.f15849a.isStateful();
    }

    @Override // com.facebook.drawee.drawable.TransformCallback
    public void l(RectF rectF) {
        TransformCallback transformCallback = this.f15850a;
        if (transformCallback != null) {
            transformCallback.l(rectF);
        } else {
            rectF.set(getBounds());
        }
    }

    @Override // android.graphics.drawable.Drawable
    public Drawable mutate() {
        this.f15849a.mutate();
        return this;
    }

    public void o(Matrix matrix) {
        getParentTransform(matrix);
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(Rect rect) {
        this.f15849a.setBounds(rect);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        return this.f15849a.setLevel(i);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onStateChange(int[] iArr) {
        return this.f15849a.setState(iArr);
    }

    public void p(RectF rectF) {
        Matrix matrix = f40990a;
        getParentTransform(matrix);
        rectF.set(getBounds());
        matrix.mapRect(rectF);
    }

    public Drawable q(Drawable drawable) {
        Drawable currentWithoutInvalidate = setCurrentWithoutInvalidate(drawable);
        invalidateSelf();
        return currentWithoutInvalidate;
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        scheduleSelf(runnable, j);
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f15851a.b(i);
        this.f15849a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f15851a.c(colorFilter);
        this.f15849a.setColorFilter(colorFilter);
    }

    public Drawable setCurrentWithoutInvalidate(Drawable drawable) {
        Drawable drawable2 = this.f15849a;
        mr2.d(drawable2, null, null);
        mr2.d(drawable, null, null);
        mr2.e(drawable, this.f15851a);
        mr2.a(drawable, this);
        mr2.d(drawable, this, this);
        this.f15849a = drawable;
        return drawable2;
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f15851a.d(z);
        this.f15849a.setDither(z);
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f15851a.e(z);
        this.f15849a.setFilterBitmap(z);
    }

    @Override // android.graphics.drawable.Drawable
    public boolean setVisible(boolean z, boolean z2) {
        super.setVisible(z, z2);
        return this.f15849a.setVisible(z, z2);
    }

    @Override // android.graphics.drawable.Drawable.Callback
    public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        unscheduleSelf(runnable);
    }
}
