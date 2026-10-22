package com.zj.adlib;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class hx4 extends Drawable {
    public static final int N = 6;
    public int K;
    public int L;
    public int M;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @Nullable
    public Bitmap f42226a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f17089a;

    public hx4(Resources resources, Bitmap bitmap) {
        this(resources, bitmap, null);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        Bitmap bitmap = this.f42226a;
        if (bitmap == null) {
            return;
        }
        canvas.drawBitmap(bitmap, (Rect) null, getBounds(), this.f17089a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getAlpha() {
        return this.f17089a.getAlpha();
    }

    @Override // android.graphics.drawable.Drawable
    public ColorFilter getColorFilter() {
        return this.f17089a.getColorFilter();
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicHeight() {
        return this.M;
    }

    @Override // android.graphics.drawable.Drawable
    public int getIntrinsicWidth() {
        return this.L;
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        Bitmap bitmap = this.f42226a;
        return (bitmap == null || bitmap.hasAlpha() || this.f17089a.getAlpha() < 255) ? -3 : -1;
    }

    public final void h() {
        Bitmap bitmap = this.f42226a;
        if (bitmap != null) {
            this.L = bitmap.getScaledWidth(this.K);
            this.M = this.f42226a.getScaledHeight(this.K);
        } else {
            this.M = -1;
            this.L = -1;
        }
    }

    @Nullable
    public Bitmap i() {
        return this.f42226a;
    }

    public Paint j() {
        return this.f17089a;
    }

    public boolean l() {
        return this.f17089a.isAntiAlias();
    }

    public void o(boolean z) {
        this.f17089a.setAntiAlias(z);
        invalidateSelf();
    }

    public void p(Bitmap bitmap) {
        if (this.f42226a != bitmap) {
            this.f42226a = bitmap;
            h();
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        if (i != this.f17089a.getAlpha()) {
            this.f17089a.setAlpha(i);
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f17089a.setColorFilter(colorFilter);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setDither(boolean z) {
        this.f17089a.setDither(z);
        invalidateSelf();
    }

    @Override // android.graphics.drawable.Drawable
    public void setFilterBitmap(boolean z) {
        this.f17089a.setFilterBitmap(z);
        invalidateSelf();
    }

    public hx4(Resources resources, Bitmap bitmap, Paint paint) {
        this.f42226a = null;
        this.K = 160;
        Paint paint2 = new Paint(6);
        this.f17089a = paint2;
        if (paint != null) {
            paint2.set(paint);
        }
        this.f42226a = bitmap;
        this.K = resources.getDisplayMetrics().densityDpi;
        h();
    }
}
