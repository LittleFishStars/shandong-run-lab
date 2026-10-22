package com.byazt.oaq;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 995, 996})
public class CycleSkipView extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public int f28863a;
    public int c;
    public int da;
    public boolean gt;
    public float i;
    public AnimatorSet m;
    public ValueAnimator my;
    public float n;
    public ValueAnimator nu;
    public float qy;
    public ValueAnimator rh;
    public final RectF rl;
    public boolean sl;
    public boolean sp;
    public Paint t;
    public int tt;
    public Paint u;
    public float uj;
    public int ve;
    public float x;
    public Paint yp;
    public float z;

    public CycleSkipView(Context context) {
        super(context);
        this.c = Color.parseColor("#f9e8b9");
        this.tt = Color.parseColor("#ffffff");
        this.ve = Color.parseColor("#7b7b7b");
        this.f28863a = 270;
        this.sp = false;
        this.x = 5.0f;
        this.i = 0.0f;
        this.da = 0;
        this.sl = true;
        this.z = 0.0f;
        this.gt = false;
        this.rl = new RectF();
        this.qy = 1.0f;
        this.uj = c(2.0f);
        this.n = c(10.0f);
        this.f28863a %= 360;
        tt();
        setBackgroundColor(-16711681);
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.rh;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.rh = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.z, this.qy);
        this.rh = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.rh.setDuration(1000L);
        this.rh.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.oaq.CycleSkipView.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                CycleSkipView.this.z = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                CycleSkipView.this.postInvalidate();
            }
        });
        return this.rh;
    }

    private int getMinLine() {
        return Math.min(getMeasuredHeight(), getMeasuredWidth());
    }

    private void tt() {
        Paint paint = new Paint(1);
        this.t = paint;
        paint.setColor(this.c);
        this.t.setStrokeWidth(this.uj);
        this.t.setAntiAlias(true);
        this.t.setStrokeCap(Paint.Cap.ROUND);
        this.t.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.u = paint2;
        paint2.setColor(this.tt);
        this.u.setAntiAlias(true);
        this.u.setStrokeWidth(this.uj);
        this.u.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.yp = paint3;
        paint3.setColor(this.ve);
        this.yp.setTextAlign(Paint.Align.CENTER);
    }

    private int ve() {
        return (int) ((((this.uj / 2.0f) + this.n) * 2.0f) + c(4.0f));
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        try {
            AnimatorSet animatorSet = this.m;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.m = null;
            }
            ValueAnimator valueAnimator = this.my;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.my = null;
            }
            ValueAnimator valueAnimator2 = this.nu;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.nu = null;
            }
            ValueAnimator valueAnimator3 = this.rh;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.rh = null;
            }
            this.z = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(getMeasuredWidth() / 2.0f, getMeasuredHeight() / 2.0f);
        tt(canvas);
        c(canvas);
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            size = ve();
        }
        if (mode2 != 1073741824) {
            size2 = ve();
        }
        tt(size, size2);
        setMeasuredDimension(size, size2);
        RectF rectF = this.rl;
        float f = this.n;
        rectF.left = -f;
        rectF.right = f;
        rectF.top = -f;
        rectF.bottom = f;
        this.yp.setTextSize(getMinLine() / 3.0f);
    }

    private void c(Canvas canvas) {
        canvas.save();
        Paint.FontMetrics fontMetrics = this.yp.getFontMetrics();
        canvas.drawText("跳过", 0.0f, (getMinLine() / 3.0f) - ((fontMetrics.bottom - fontMetrics.top) / 2.0f), this.yp);
        canvas.restore();
    }

    private float c(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }

    public void c() {
        AnimatorSet animatorSet = this.m;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.m.cancel();
            this.m = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.m = animatorSet2;
        animatorSet2.playTogether(getArcAnim());
        this.m.setInterpolator(new LinearInterpolator());
        this.m.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.oaq.CycleSkipView.2
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                CycleSkipView.this.gt = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (CycleSkipView.this.gt) {
                    CycleSkipView.this.gt = false;
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        this.m.start();
    }

    private void tt(int i, int i2) {
        this.n = (Math.min(i, i2) / 2.0f) - this.uj;
    }

    private void tt(Canvas canvas) {
        float f;
        float fMax;
        float f2;
        canvas.save();
        float f3 = this.z * 360.0f;
        if (this.sp) {
            if (this.sl) {
                f = this.f28863a;
                f3 = -f3;
            } else {
                f = this.f28863a - f3;
            }
        } else {
            if (this.sl) {
                float f4 = this.f28863a + 360;
                fMax = Math.max(0.0f, 360.0f - f3);
                f2 = f4;
            } else {
                f = this.f28863a;
            }
            canvas.drawCircle(0.0f, 0.0f, this.n, this.u);
            canvas.drawArc(this.rl, f2, fMax, false, this.t);
            canvas.restore();
        }
        fMax = f3;
        f2 = f;
        canvas.drawCircle(0.0f, 0.0f, this.n, this.u);
        canvas.drawArc(this.rl, f2, fMax, false, this.t);
        canvas.restore();
    }

    public void c(int i, int i2) {
        if (i == 0) {
            return;
        }
        float f = i;
        this.x = f;
        float f2 = i2;
        this.i = f2;
        this.da = i - i2;
        this.qy = f2 / f;
        c();
    }
}
