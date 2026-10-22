package com.beizi.fusion.asnp.adn.ad.ad.nativead.render.view.asnp.prefab;

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

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ScopeIndicateArrowView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final int f27044a;
    private final int b;
    private int c;
    private Paint d;
    private Paint e;
    private double f;
    private double g;
    private int h;
    private int i;

    public ScopeIndicateArrowView(Context context) {
        this(context, null);
    }

    private void a() {
        Paint paint = new Paint();
        this.d = paint;
        paint.setAntiAlias(true);
        this.d.setDither(true);
        this.d.setStrokeWidth(this.c);
        this.d.setColor(this.f27044a);
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
            float f = this.c / 2.0f;
            RectF rectF = new RectF(f, f, getWidth() - (this.c / 2.0f), getHeight() - (this.c / 2.0f));
            canvas.drawArc(rectF, 215.0f, 110.0f, false, this.d);
            double d = this.g;
            if (d >= AudioStats.AUDIO_AMPLITUDE_NONE) {
                double d2 = this.f;
                if (d2 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    if (d >= d2) {
                        this.g = d2;
                    }
                    float f2 = (float) (((double) ((float) this.g)) / d2);
                    int i = this.h;
                    if (i == 1) {
                        canvas.drawArc(rectF, 215.0f, f2 * 110.0f, false, this.e);
                    } else if (i == 2) {
                        canvas.drawArc(rectF, 325.0f, (-f2) * 110.0f, false, this.e);
                    } else {
                        canvas.drawArc(rectF, 270.0f, (-f2) * 55.0f, false, this.e);
                        canvas.drawArc(rectF, 270.0f, f2 * 55.0f, false, this.e);
                    }
                }
            }
            int color = Color.parseColor("#CACCCA");
            if (this.g == this.f) {
                color = Color.parseColor("#FFFFFF");
            }
            int i2 = color;
            int width = getWidth();
            int height = getHeight();
            int iMin = (Math.min(width, height) / 2) + (this.c * this.i);
            int i3 = width / 2;
            int i4 = height / 2;
            float fCos = (float) Math.cos(Math.toRadians(45.0d));
            int i5 = this.h;
            if (i5 == 1) {
                b(canvas, i3, i4, fCos, iMin, i2);
            } else {
                if (i5 == 2) {
                    a(canvas, i3, i4, fCos, iMin, i2);
                    return;
                }
                float f3 = iMin;
                a(canvas, i3, i4, fCos, f3, i2);
                b(canvas, i3, i4, fCos, f3, i2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i) + (this.c * 2);
        int size2 = View.MeasureSpec.getSize(i2) + (this.c * 2);
        setMeasuredDimension(Math.min(size, size2), Math.min(size, size2));
    }

    public void setArrowDirection(int i) {
        this.h = i;
    }

    public void setCurrentProgress(double d) {
        this.g = d * 100.0d;
        invalidate();
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setMaxProgress(double d) {
        this.f = d * 100.0d;
    }

    public ScopeIndicateArrowView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ScopeIndicateArrowView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27044a = Color.parseColor("#CACCCA");
        this.b = Color.parseColor("#FFFFFF");
        this.c = 8;
        this.f = -1.0d;
        this.g = -1.0d;
        this.h = 0;
        this.i = 2;
        a();
        b();
    }

    private void a(Canvas canvas, int i, int i2, float f, float f2, int i3) {
        double d = i / 2;
        double d2 = f * f2;
        float f3 = (float) (d - (0.4d * d2));
        int i4 = i2 / 2;
        double d3 = d2 * 0.2d;
        float f4 = i4;
        a(canvas, true, f3, (float) (((double) i4) - d3), (float) (d - d3), f4, f3, f4, i3);
    }

    private void b(Canvas canvas, int i, int i2, float f, float f2, int i3) {
        double d = ((double) i) * 1.5d;
        double d2 = f * f2;
        float f3 = (float) ((0.4d * d2) + d);
        int i4 = i2 / 2;
        double d3 = d2 * 0.2d;
        float f4 = i4;
        a(canvas, true, f3, (float) (((double) i4) - d3), (float) (d + d3), f4, f3, f4, i3);
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
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
