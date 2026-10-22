package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.text.style.ReplacementSpan;
import com.blankj.utilcode.util.SizeUtils;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class zz8 extends ReplacementSpan {
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;

    public zz8(int bgColor, int textColor, int textSize) {
        this.N = 0;
        this.O = 0;
        this.P = 0;
        this.Q = 0;
        this.K = bgColor;
        this.L = textColor;
        this.M = textSize;
        this.N = SizeUtils.b(16.0f);
        this.O = SizeUtils.b(8.0f);
        this.P = SizeUtils.b(8.0f);
        this.Q = SizeUtils.b(4.0f);
    }

    public float a(Paint paint) {
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        return (-(fontMetrics.ascent + fontMetrics.descent)) / 2.0f;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
        int i;
        int i2;
        int color = paint.getColor();
        float textSize = paint.getTextSize();
        paint.setTextSize(this.M);
        float fMeasureText = paint.measureText(text, start, end);
        paint.setColor(this.K);
        int i3 = this.N;
        int i4 = bottom - top;
        if (i3 >= i4) {
            i = top;
            i2 = bottom;
        } else {
            i = ((i4 - i3) / 2) + top;
            i2 = i3 + i;
        }
        RectF rectF = new RectF(x, i, fMeasureText + x + (this.O * 2), i2);
        int i5 = this.P;
        canvas.drawRoundRect(rectF, i5, i5, paint);
        paint.setColor(this.L);
        paint.setTypeface(Typeface.defaultFromStyle(0));
        canvas.drawText(text, start, end, this.O + x, a(paint) + ((i + i2) / 2), paint);
        paint.setColor(color);
        paint.setTextSize(textSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(Paint paint, CharSequence text, int start, int end, Paint.FontMetricsInt fm) {
        paint.setTextSize(this.M);
        return ((int) paint.measureText(text, start, end)) + (this.O * 2) + this.Q;
    }

    public zz8(int bgColor, int textColor, int textSize, int drawHeight, int padding, int radius, int spacing) {
        this.K = bgColor;
        this.L = textColor;
        this.M = textSize;
        this.N = drawHeight;
        this.O = padding;
        this.P = radius;
        this.Q = spacing;
    }
}
