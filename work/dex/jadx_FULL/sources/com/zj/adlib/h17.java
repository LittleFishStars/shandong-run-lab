package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class h17 extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f16909a = new Paint(1);

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f42028a = Integer.MIN_VALUE;
    public int b = -2147450625;
    public int c = 10;
    public int d = 20;
    public int e = 0;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f16910a = false;

    public final void a(Canvas canvas, int i, int i2) {
        Rect bounds = getBounds();
        int iWidth = bounds.width();
        int i3 = this.c;
        int i4 = ((iWidth - (i3 * 2)) * i) / 10000;
        int i5 = bounds.left + i3;
        int i6 = (bounds.bottom - i3) - this.d;
        this.f16909a.setColor(i2);
        canvas.drawRect(i5, i6, i5 + i4, i6 + this.d, this.f16909a);
    }

    public int b() {
        return this.f42028a;
    }

    public int c() {
        return this.d;
    }

    public int d() {
        return this.b;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        if (this.f16910a && this.e == 0) {
            return;
        }
        a(canvas, 10000, this.f42028a);
        a(canvas, this.e, this.b);
    }

    public boolean e() {
        return this.f16910a;
    }

    public void f(int i) {
        if (this.f42028a != i) {
            this.f42028a = i;
            invalidateSelf();
        }
    }

    public void g(int i) {
        if (this.d != i) {
            this.d = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return mr2.b(this.f16909a.getColor());
    }

    @Override // android.graphics.drawable.Drawable
    public boolean getPadding(Rect rect) {
        int i = this.c;
        rect.set(i, i, i, i);
        return this.c != 0;
    }

    public void h(int i) {
        if (this.b != i) {
            this.b = i;
            invalidateSelf();
        }
    }

    public void i(boolean z) {
        this.f16910a = z;
    }

    public void j(int i) {
        if (this.c != i) {
            this.c = i;
            invalidateSelf();
        }
    }

    @Override // android.graphics.drawable.Drawable
    public boolean onLevelChange(int i) {
        this.e = i;
        invalidateSelf();
        return true;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f16909a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f16909a.setColorFilter(colorFilter);
    }
}
