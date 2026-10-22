package com.beizi.fusion.update;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.beizi.fusion.jh;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ShakeArcView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f27842a;
    private int b;
    private int c;
    private Paint d;
    private Paint e;
    private double f;
    private double g;
    private int h;
    private int i;

    public ShakeArcView(Context context) {
        this(context, null);
    }

    private void a() {
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        this.d.setDither(true);
        this.d.setStrokeWidth(this.c);
        this.d.setColor(this.f27842a);
        this.d.setStyle(Paint.Style.STROKE);
        this.d.setStrokeCap(Paint.Cap.ROUND);
    }

    private void b() {
        Paint paint = new Paint();
        this.e = paint;
        paint.setAntiAlias(true);
        this.e.setDither(true);
        this.e.setStrokeWidth(this.c);
        this.e.setColor(this.b);
        this.e.setStyle(Paint.Style.STROKE);
        this.e.setStrokeCap(Paint.Cap.ROUND);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        try {
            int i = this.c;
            RectF rectF = new RectF(i / 2, i / 2, getWidth() - (this.c / 2), getHeight() - (this.c / 2));
            canvas.drawArc(rectF, 215.0f, 110.0f, false, this.d);
            double d = this.g;
            if (d >= AudioStats.AUDIO_AMPLITUDE_NONE) {
                double d2 = this.f;
                if (d2 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    if (d >= d2) {
                        this.g = d2;
                    }
                    float f = (float) (((double) ((float) this.g)) / d2);
                    jh.b("sweepAngle", "sweepAngle:" + f + ",mMaxProgress:" + this.f + ",mCurrentProgress:" + this.g);
                    int i2 = this.h;
                    if (i2 == 1) {
                        canvas.drawArc(rectF, 215.0f, f * 110.0f, false, this.e);
                    } else if (i2 == 2) {
                        canvas.drawArc(rectF, 325.0f, (-f) * 110.0f, false, this.e);
                    } else {
                        canvas.drawArc(rectF, 270.0f, (-f) * 55.0f, false, this.e);
                        canvas.drawArc(rectF, 270.0f, f * 55.0f, false, this.e);
                    }
                }
            }
            int color = Color.parseColor("#CACCCA");
            if (this.g == this.f) {
                color = Color.parseColor("#FFFFFF");
            }
            int i3 = color;
            int width = getWidth();
            int height = getHeight();
            int iMin = (Math.min(width, height) / 2) + (this.c * this.i);
            int i4 = width / 2;
            int i5 = height / 2;
            float fCos = (float) Math.cos(Math.toRadians(45.0d));
            int i6 = this.h;
            if (i6 == 1) {
                double d3 = ((double) i4) * 1.5d;
                double d4 = fCos * iMin;
                float f2 = (float) ((0.4d * d4) + d3);
                double d5 = d4 * 0.2d;
                float f3 = i5 / 2;
                a(canvas, true, f2, (float) (((double) (i5 / 2)) - d5), (float) (d3 + d5), f3, f2, f3, i3);
                return;
            }
            if (i6 == 2) {
                double d6 = fCos * iMin;
                float f4 = (float) (((double) (i4 / 2)) - (0.4d * d6));
                double d7 = d6 * 0.2d;
                float f5 = i5 / 2;
                a(canvas, true, f4, (float) (((double) (i5 / 2)) - d7), (float) (((double) (i4 / 2)) - d7), f5, f4, f5, i3);
                return;
            }
            double d8 = fCos * iMin;
            double d9 = d8 * 0.4d;
            float f6 = (float) (((double) (i4 / 2)) - d9);
            double d10 = d8 * 0.2d;
            float f7 = i5 / 2;
            a(canvas, true, f6, (float) (((double) (i5 / 2)) - d10), (float) (((double) (i4 / 2)) - d10), f7, f6, f7, i3);
            double d11 = ((double) i4) * 1.5d;
            float f8 = (float) (d11 + d9);
            float f9 = i5 / 2;
            a(canvas, true, f8, (float) (((double) (i5 / 2)) - d10), (float) (d11 + d10), f9, f8, f9, i3);
        } catch (Exception unused) {
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i) + (this.c * 2);
        int size2 = View.MeasureSpec.getSize(i2) + (this.c * 2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    public ShakeArcView setArrowDirection(int i) {
        this.h = i;
        return this;
    }

    public ShakeArcView setCurrentProgress(double d) {
        this.g = d * 100.0d;
        invalidate();
        return this;
    }

    public void setLineRadius(int i) {
        this.i = i;
    }

    public void setLineWidth(int i) {
        try {
            this.c = i;
            Paint paint = this.d;
            if (paint != null) {
                paint.setStrokeWidth(i);
            }
            Paint paint2 = this.e;
            if (paint2 != null) {
                paint2.setStrokeWidth(this.c);
            }
        } catch (Exception unused) {
        }
    }

    public ShakeArcView setMaxProgress(double d) {
        this.f = d * 100.0d;
        return this;
    }

    public ShakeArcView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ShakeArcView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27842a = Color.parseColor("#CACCCA");
        this.b = Color.parseColor("#FFFFFF");
        this.c = 6;
        this.f = -1.0d;
        this.g = -1.0d;
        this.h = 0;
        this.i = 2;
        a();
        b();
    }

    private void a(Canvas canvas, boolean z, float f, float f2, float f3, float f4, float f5, float f6, int i) {
        try {
            Paint paint = new Paint();
            paint.setAntiAlias(true);
            paint.setColor(i);
            if (z) {
                paint.setStyle(Paint.Style.FILL);
            } else {
                paint.setStyle(Paint.Style.STROKE);
            }
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            path.lineTo(f5, f6);
            path.lineTo(f, f2);
            path.close();
            canvas.drawPath(path, paint);
        } catch (Exception unused) {
        }
    }
}
