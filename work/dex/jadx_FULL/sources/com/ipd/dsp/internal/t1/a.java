package com.ipd.dsp.internal.t1;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
public class a extends Drawable {
    public final float e;
    public final float g;
    public final float j;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Paint f38538a = new Paint();
    public final int b = Color.parseColor("#C0D0D0D0");
    public final Path c = new Path();
    public final int d = Color.parseColor("#E5FFFFFF");
    public final Path f = new Path();
    public final int h = Color.parseColor("#33FFFFFF");
    public final Path i = new Path();

    public a(float f, float f2, float f3) {
        this.j = f;
        this.e = f2;
        this.g = f3;
    }

    public final void a(Paint paint, int i) {
        paint.reset();
        paint.setStyle(Paint.Style.FILL);
        paint.setColor(i);
        paint.setAntiAlias(true);
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        a(this.f38538a, this.b);
        canvas.drawPath(this.c, this.f38538a);
        a(this.f38538a, this.d);
        canvas.drawPath(this.f, this.f38538a);
        a(this.f38538a, this.h);
        canvas.drawPath(this.i, this.f38538a);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void onBoundsChange(@NonNull Rect rect) {
        super.onBoundsChange(rect);
        int iWidth = rect.width();
        int iHeight = rect.height();
        float f = iWidth;
        float f2 = f / 2.0f;
        this.c.reset();
        this.c.moveTo(0.0f, this.j + this.e + this.g);
        Path path = this.c;
        float f3 = this.j;
        float f4 = this.e;
        float f5 = this.g;
        path.quadTo(f2, (-f3) + f4 + f5, f, f3 + f4 + f5);
        float f6 = iHeight;
        this.c.lineTo(f, f6);
        this.c.lineTo(0.0f, f6);
        this.c.close();
        this.f.reset();
        this.f.moveTo(0.0f, this.j + this.g);
        Path path2 = this.f;
        float f7 = this.j;
        float f8 = this.g;
        path2.quadTo(f2, (-f7) + f8, f, f7 + f8);
        this.f.lineTo(f, this.j + this.e + this.g);
        Path path3 = this.f;
        float f9 = this.j;
        float f10 = this.e;
        float f11 = this.g;
        path3.quadTo(f2, (-f9) + f10 + f11, 0.0f, f9 + f10 + f11);
        this.f.close();
        this.i.reset();
        this.i.moveTo(0.0f, this.j);
        Path path4 = this.i;
        float f12 = this.j;
        path4.quadTo(f2, -f12, f, f12);
        this.i.lineTo(f, this.j + this.g);
        Path path5 = this.i;
        float f13 = this.j;
        float f14 = this.g;
        path5.quadTo(f2, (-f13) + f14, 0.0f, f13 + f14);
        this.i.close();
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f38538a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f38538a.setColorFilter(colorFilter);
    }
}
