package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.style.ReplacementSpan;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class ff1 extends ReplacementSpan {
    public float a(CharSequence text, int start, int end, float x, int top, int y, int bottom, @NonNull Paint paint) {
        float f = y;
        try {
            if (!(paint instanceof TextPaint)) {
                return f;
            }
            Path path = new Path();
            ((TextPaint) paint).getTextPath(text.toString(), start, end, x, f, path);
            RectF rectF = new RectF();
            path.computeBounds(rectF, false);
            if (rectF.isEmpty()) {
                return f;
            }
            rectF.offset(0.0f, (((bottom - top) - rectF.height()) / 2.0f) - rectF.top);
            return (float) (((double) (rectF.bottom - paint.descent())) * 1.08d);
        } catch (Exception unused) {
            return f;
        }
    }

    @Override // android.text.style.ReplacementSpan
    public void draw(@NonNull Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, @NonNull Paint paint) {
        long jNanoTime = System.nanoTime();
        canvas.drawText(text, start, end, x, a(text, start, end, x, top, y, bottom, paint), paint);
        i4a.c("-> " + (System.nanoTime() - jNanoTime) + "ns");
    }

    @Override // android.text.style.ReplacementSpan
    public int getSize(@NonNull Paint paint, CharSequence text, int start, int end, @Nullable Paint.FontMetricsInt fm) {
        return (int) paint.measureText(text, start, end);
    }
}
