package com.scwang.smartrefresh.layout.internal;

import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public abstract class PaintDrawable extends Drawable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Paint f40422a;

    public PaintDrawable() {
        Paint paint = new Paint();
        this.f40422a = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f40422a.setAntiAlias(true);
        this.f40422a.setColor(-5592406);
    }

    public void a(int i) {
        this.f40422a.setColor(i);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return -3;
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
        this.f40422a.setAlpha(i);
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
        this.f40422a.setColorFilter(colorFilter);
    }
}
