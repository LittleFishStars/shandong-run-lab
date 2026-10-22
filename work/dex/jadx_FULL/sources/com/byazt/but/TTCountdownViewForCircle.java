package com.byazt.but;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.byazt.omf.gt;
import com.huachenjie.common.constants.UserConstants;
import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 672, UserConstants.LOGIN_ERROR.d})
public class TTCountdownViewForCircle extends View implements uj {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f28333a;
    public int c;
    public float da;
    public AnimatorSet gr;
    public float gt;
    public c gu;
    public AtomicBoolean h;
    public boolean i;
    public Paint m;
    public boolean md;
    public Paint my;
    public float n;
    public Paint nu;
    public ValueAnimator p;
    public RectF qy;
    public Paint rh;
    public float rl;
    public float sl;
    public float sp;
    public float t;
    public int tt;
    public String u;
    public int uj;
    public int ve;
    public int x;
    public boolean yp;
    public ValueAnimator yv;
    public boolean z;
    public ValueAnimator zm;

    public TTCountdownViewForCircle(Context context) {
        this(context, null);
    }

    private int a() {
        return (int) ((((this.n / 2.0f) + this.sp) * 2.0f) + c(4.0f));
    }

    private ValueAnimator getArcAnim() {
        ValueAnimator valueAnimator = this.yv;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.yv = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.gt, 0.0f);
        this.yv = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.yv.setDuration((long) (c(this.gt, this.da) * 1000.0f));
        this.yv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.but.TTCountdownViewForCircle.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.gt = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.yv;
    }

    private ValueAnimator getNumAnim() {
        ValueAnimator valueAnimator = this.zm;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.zm = null;
        }
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.rl, 0.0f);
        this.zm = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setInterpolator(new LinearInterpolator());
        this.zm.setDuration((long) (c(this.rl, this.sl) * 1000.0f));
        this.zm.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.but.TTCountdownViewForCircle.2
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                TTCountdownViewForCircle.this.rl = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                TTCountdownViewForCircle.this.invalidate();
            }
        });
        return this.zm;
    }

    private void n() {
        float f = this.sp;
        this.qy = new RectF(-f, -f, f, f);
    }

    private void sp() {
        try {
            AnimatorSet animatorSet = this.gr;
            if (animatorSet != null) {
                animatorSet.cancel();
                this.gr = null;
            }
            ValueAnimator valueAnimator = this.p;
            if (valueAnimator != null) {
                valueAnimator.cancel();
                this.p = null;
            }
            ValueAnimator valueAnimator2 = this.zm;
            if (valueAnimator2 != null) {
                valueAnimator2.cancel();
                this.zm = null;
            }
            ValueAnimator valueAnimator3 = this.yv;
            if (valueAnimator3 != null) {
                valueAnimator3.cancel();
                this.yv = null;
            }
            this.gt = 1.0f;
            this.rl = 1.0f;
            invalidate();
        } catch (Exception unused) {
        }
    }

    private void uj() {
        Paint paint = new Paint(1);
        this.m = paint;
        paint.setColor(this.c);
        this.m.setStrokeWidth(this.n);
        this.m.setAntiAlias(true);
        this.m.setStyle(Paint.Style.STROKE);
        Paint paint2 = new Paint(1);
        this.nu = paint2;
        paint2.setColor(this.ve);
        this.nu.setAntiAlias(true);
        this.nu.setStrokeWidth(this.n);
        this.nu.setStyle(Paint.Style.FILL);
        Paint paint3 = new Paint(1);
        this.rh = paint3;
        paint3.setColor(this.tt);
        this.rh.setAntiAlias(true);
        this.rh.setStrokeWidth(this.n / 2.0f);
        this.rh.setStyle(Paint.Style.STROKE);
        Paint paint4 = new Paint(1);
        this.my = paint4;
        paint4.setColor(this.uj);
        this.rh.setAntiAlias(true);
        this.my.setTextSize(this.f28333a);
        this.my.setTextAlign(Paint.Align.CENTER);
    }

    public float c(float f, float f2) {
        return f * f2;
    }

    public float c(float f, int i) {
        return i * f;
    }

    public c getCountdownListener() {
        return this.gu;
    }

    @Override // com.byazt.but.uj
    public View getView() {
        return this;
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        sp();
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
            size = a();
        }
        if (mode2 != 1073741824) {
            size2 = a();
        }
        setMeasuredDimension(size, size2);
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        this.h.set(z);
        if (this.z) {
            return;
        }
        if (this.h.get()) {
            ve();
        } else {
            tt();
        }
    }

    @Override // com.byazt.but.uj
    public void setCountDownTime(int i) {
        float f = i;
        this.sl = f;
        this.da = f;
        sp();
    }

    @Override // com.byazt.but.uj
    public void setCountdownListener(c cVar) {
        this.gu = cVar;
        this.h.get();
    }

    public void ve() {
        AnimatorSet animatorSet;
        try {
            if (this.z || (animatorSet = this.gr) == null) {
                return;
            }
            animatorSet.resume();
        } catch (Throwable unused) {
        }
    }

    public TTCountdownViewForCircle(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TTCountdownViewForCircle(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.c = Color.parseColor("#fce8b6");
        this.tt = Color.parseColor("#f0f0f0");
        this.ve = Color.parseColor("#ffffff");
        this.uj = Color.parseColor("#7c7c7c");
        this.n = 2.0f;
        this.f28333a = 12.0f;
        this.sp = 18.0f;
        this.x = 270;
        this.i = false;
        this.da = 5.0f;
        this.sl = 5.0f;
        this.t = 0.8f;
        this.u = "跳过";
        this.yp = false;
        this.z = false;
        this.gt = 1.0f;
        this.rl = 1.0f;
        this.md = false;
        this.h = new AtomicBoolean(true);
        this.n = c(2.0f);
        this.sp = c(18.0f);
        this.f28333a = tt(12.0f);
        this.x %= 360;
        uj();
        n();
    }

    private void tt(Canvas canvas) {
        float f;
        canvas.save();
        float fC = c(this.gt, 360);
        if (this.i) {
            f = this.x - fC;
        } else {
            f = this.x;
        }
        canvas.drawCircle(0.0f, 0.0f, this.sp, this.nu);
        canvas.drawCircle(0.0f, 0.0f, this.sp, this.rh);
        canvas.drawArc(this.qy, f, fC, false, this.m);
        canvas.restore();
    }

    private void c(Canvas canvas) {
        canvas.save();
        Paint.FontMetrics fontMetrics = this.my.getFontMetrics();
        String strEj = gt.tt().ej();
        this.u = strEj;
        if (TextUtils.isEmpty(strEj)) {
            this.u = "跳过";
        }
        canvas.drawText(this.u, 0.0f, 0.0f - ((fontMetrics.ascent + fontMetrics.descent) / 2.0f), this.my);
        canvas.restore();
    }

    @Override // com.byazt.but.uj
    public void c() {
        if (this.z) {
            return;
        }
        AnimatorSet animatorSet = this.gr;
        if (animatorSet != null && animatorSet.isRunning()) {
            this.gr.cancel();
            this.gr = null;
        }
        AnimatorSet animatorSet2 = new AnimatorSet();
        this.gr = animatorSet2;
        animatorSet2.playTogether(getNumAnim(), getArcAnim());
        this.gr.setInterpolator(new LinearInterpolator());
        this.gr.addListener(new AnimatorListenerAdapter() { // from class: com.byazt.but.TTCountdownViewForCircle.1
            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
                TTCountdownViewForCircle.this.md = true;
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                if (TTCountdownViewForCircle.this.md) {
                    TTCountdownViewForCircle.this.md = false;
                } else if (TTCountdownViewForCircle.this.gu != null) {
                    TTCountdownViewForCircle.this.gu.c();
                }
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }
        });
        try {
            Field declaredField = ValueAnimator.class.getDeclaredField("sDurationScale");
            declaredField.setAccessible(true);
            if (declaredField.getFloat(null) < 1.0f) {
                declaredField.setFloat(null, 1.0f);
            }
        } catch (Throwable unused) {
        }
        this.gr.start();
        if (this.h.get()) {
            return;
        }
        tt();
    }

    private float tt(float f) {
        return TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    public void tt() {
        try {
            AnimatorSet animatorSet = this.gr;
            if (animatorSet != null) {
                animatorSet.pause();
            }
        } catch (Throwable unused) {
        }
    }

    @Override // com.byazt.but.uj
    public void c(boolean z) {
        this.z = z;
        if (z) {
            sp();
        }
    }

    private float c(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }
}
