package com.huachenjie.sport.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Nullable;
import com.huachenjie.sport.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class ProgressBarView extends View {
    public int K;
    public int L;
    public int M;
    public int N;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f36749a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public Paint f13794a;
    public Paint b;

    public ProgressBarView(Context context) {
        this(context, null);
    }

    public final void a(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ProgressBarView);
        this.K = typedArrayObtainStyledAttributes.getColor(R.styleable.ProgressBarView_ringColor, -7829368);
        this.L = typedArrayObtainStyledAttributes.getColor(R.styleable.ProgressBarView_ringProgressColor, -16711936);
        this.f36749a = typedArrayObtainStyledAttributes.getDimension(R.styleable.ProgressBarView_ringWidth, 20.0f);
        this.M = typedArrayObtainStyledAttributes.getInteger(R.styleable.ProgressBarView_max, 100);
        this.N = typedArrayObtainStyledAttributes.getInteger(R.styleable.ProgressBarView_progress, 0);
        typedArrayObtainStyledAttributes.recycle();
    }

    public final void b() {
        Paint paint = new Paint();
        this.f13794a = paint;
        paint.setColor(this.K);
        this.f13794a.setStyle(Paint.Style.STROKE);
        this.f13794a.setStrokeWidth(this.f36749a);
        this.f13794a.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.b = paint2;
        paint2.setColor(this.L);
        this.b.setStrokeWidth(this.f36749a);
        this.b.setStrokeCap(Paint.Cap.ROUND);
        this.b.setAntiAlias(true);
        this.b.setStyle(Paint.Style.STROKE);
    }

    public int getBgColor() {
        return this.K;
    }

    public Paint getBgPaint() {
        return this.f13794a;
    }

    public synchronized int getMax() {
        return this.M;
    }

    public synchronized int getProgress() {
        return this.N;
    }

    public int getRingProgressColor() {
        return this.L;
    }

    public Paint getRingProgressPaint() {
        return this.b;
    }

    public float getRingWidth() {
        return this.f36749a;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        int i;
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int height = getHeight() / 2;
        float f = width;
        int i2 = (int) (f - (this.f36749a / 2.0f));
        canvas.drawCircle(f, height, i2, this.f13794a);
        RectF rectF = new RectF(width - i2, height - i2, width + i2, height + i2);
        int i3 = this.M;
        if (i3 <= 0 || (i = this.N) > i3) {
            return;
        }
        canvas.drawArc(rectF, -90.0f, (i * 360.0f) / i3, false, this.b);
    }

    public void setBgColor(int i) {
        this.K = i;
    }

    public void setBgPaint(Paint paint) {
        this.f13794a = paint;
    }

    public synchronized void setMax(int i) {
        try {
            if (i < 0) {
                throw new IllegalArgumentException("max not less than 0");
            }
            this.M = i;
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setProgress(int i) {
        try {
            if (i < 0) {
                throw new IllegalArgumentException("progress not less than 0");
            }
            int i2 = this.M;
            if (i > i2) {
                i = i2;
            }
            if (i <= i2) {
                this.N = i;
                postInvalidate();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void setRingProgressColor(int i) {
        this.L = i;
    }

    public void setRingProgressPaint(Paint paint) {
        this.b = paint;
    }

    public void setRingWidth(float f) {
        this.f36749a = f;
    }

    public ProgressBarView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ProgressBarView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a(context, attributeSet);
        b();
    }
}
