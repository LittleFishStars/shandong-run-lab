package com.alibaba.triver.triver_render.view.refresh;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import com.alibaba.triver.triver_render.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class RoundProgressBar extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Paint f25247a;
    private int b;
    private int c;
    private int d;
    private float e;
    private int f;
    private int g;
    private boolean h;

    public RoundProgressBar(Context context) {
        this(context, null);
    }

    public void a() {
        this.g = 95;
        postInvalidate();
        if (this.h) {
            return;
        }
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setDuration(600L);
        rotateAnimation.setRepeatCount(-1);
        rotateAnimation.setFillAfter(true);
        setAnimation(rotateAnimation);
        this.h = true;
    }

    public int getProgress() {
        return this.g;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        float f = width;
        int i = (int) (f - (this.e / 2.0f));
        if (this.d != 0) {
            this.f25247a.setAntiAlias(true);
            this.f25247a.setColor(this.d);
            this.f25247a.setStyle(Paint.Style.FILL);
            canvas.drawCircle(f, f, i, this.f25247a);
        }
        this.f25247a.setColor(this.b);
        this.f25247a.setStyle(Paint.Style.STROKE);
        this.f25247a.setStrokeWidth(this.e);
        this.f25247a.setAntiAlias(true);
        canvas.drawCircle(f, f, i, this.f25247a);
        this.f25247a.setStrokeWidth(this.e);
        this.f25247a.setColor(this.c);
        float f2 = width - i;
        float f3 = width + i;
        RectF rectF = new RectF(f2, f2, f3, f3);
        this.f25247a.setStyle(Paint.Style.STROKE);
        canvas.drawArc(rectF, this.f, (this.g * 360) / 100, false, this.f25247a);
        this.f25247a.setStrokeWidth(0.0f);
        this.f25247a.setTypeface(Typeface.DEFAULT_BOLD);
    }

    public void setProgress(int i) {
        this.f = -90;
        clearAnimation();
        this.h = false;
        if (i < 0) {
            throw new IllegalArgumentException("progress not less than 0");
        }
        if (i > 95) {
            i = 95;
        }
        if (i <= 100) {
            this.g = i;
            postInvalidate();
        }
    }

    public void setRingProgressColor(int i) {
        this.c = i;
        postInvalidate();
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RoundProgressBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f = -90;
        this.f25247a = new Paint();
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RoundProgressBar);
        this.b = typedArrayObtainStyledAttributes.getColor(R.styleable.RoundProgressBar_ringColor, 0);
        this.c = typedArrayObtainStyledAttributes.getColor(R.styleable.RoundProgressBar_ringProgressColor, -1);
        this.e = typedArrayObtainStyledAttributes.getDimension(R.styleable.RoundProgressBar_ringWidth, 4.0f);
        this.g = 30;
        this.d = typedArrayObtainStyledAttributes.getColor(R.styleable.RoundProgressBar_centreColor, 0);
        typedArrayObtainStyledAttributes.recycle();
    }
}
