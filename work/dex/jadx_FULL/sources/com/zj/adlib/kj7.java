package com.zj.adlib;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.text.style.ReplacementSpan;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class kj7 extends ReplacementSpan {
    public int K;
    public int L;
    public int M;
    public int N;
    public int O;
    public int P;
    public int Q;
    public int R;
    public int S;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Context f42833a;

    public kj7(Context ctx, int bgColor, int textColor, int cornerRoundDp, int leftPadding, int topPadding, int rightPadding, int bottomPadding, @ColorInt int gradientStart, @ColorInt int gradientEnd) {
        this.K = bgColor;
        this.N = textColor;
        this.O = cornerRoundDp;
        this.P = leftPadding;
        this.R = rightPadding;
        this.Q = topPadding;
        this.S = bottomPadding;
        this.L = gradientStart;
        this.M = gradientEnd;
        this.f42833a = ctx;
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, @NonNull Paint paint) {
        int color = paint.getColor();
        float textSize = paint.getTextSize();
        float fMeasureText = x + ((int) paint.measureText(text, start, end)) + cr2.c(this.f42833a, this.P + this.R);
        float fC = bottom + cr2.c(this.f42833a, this.S);
        if (this.L != 0) {
            paint.setShader(new LinearGradient(x, top - cr2.c(this.f42833a, this.Q), fMeasureText, fC, new int[]{this.L, this.M}, new float[]{0.0f, 0.9f}, Shader.TileMode.CLAMP));
        } else {
            paint.setColor(this.K);
        }
        canvas.drawRoundRect(new RectF(x, top - cr2.c(this.f42833a, this.Q), fMeasureText, fC), cr2.c(this.f42833a, this.O), cr2.c(this.f42833a, this.O), paint);
        if (this.L != 0) {
            paint.reset();
        }
        paint.setTextSize(0.8f * textSize);
        paint.setColor(this.N);
        canvas.drawText(text, start, end, x + cr2.c(this.f42833a, this.P), y, paint);
        paint.setColor(color);
        paint.setTextSize(textSize);
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm) {
        return ((int) paint.measureText(text, start, end)) + cr2.c(this.f42833a, this.P + this.R);
    }
}
