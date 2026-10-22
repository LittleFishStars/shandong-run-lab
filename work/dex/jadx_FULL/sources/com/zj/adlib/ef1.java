package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.style.ImageSpan;
import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ef1 extends ImageSpan {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f41421a;

    public ef1(Drawable drawable) {
        super(drawable);
        this.f41421a = 0.0f;
    }

    public void a(float degrees) {
        this.f41421a = degrees;
    }

    @Override // android.text.style.DynamicDrawableSpan, android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, @NonNull Paint paint) {
        Drawable drawable = getDrawable();
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int i = ((((fontMetricsInt.descent + y) + y) + fontMetricsInt.ascent) / 2) - (drawable.getBounds().bottom / 2);
        canvas.save();
        canvas.translate(x, i);
        canvas.rotate(this.f41421a, drawable.getBounds().width() / 2.0f, drawable.getBounds().height() / 2.0f);
        drawable.draw(canvas);
        canvas.restore();
    }
}
