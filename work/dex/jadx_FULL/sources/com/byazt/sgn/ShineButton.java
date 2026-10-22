package com.byazt.sgn;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.view.animation.LinearInterpolator;
import android.widget.Button;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_11_8719cls.dex */
@com.byazt.zqa.c(c = {0, 1, 211, 1371})
public class ShineButton extends Button {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f29007a;
    public Paint c;
    public ValueAnimator n;
    public LinearGradient tt;
    public float uj;
    public Matrix ve;

    public ShineButton(Context context) {
        super(context);
        this.c = new Paint(1);
        this.ve = new Matrix();
        this.uj = 0.0f;
        this.f29007a = 0.3f;
        c(context);
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.n.removeAllListeners();
            this.n.removeAllUpdateListeners();
            this.n = null;
        }
    }

    @Override // android.widget.TextView, android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix = this.ve;
        float f = this.uj;
        matrix.setTranslate(f, f);
        this.tt.setLocalMatrix(this.ve);
        canvas.drawRect(0.0f, 0.0f, getWidth(), getHeight(), this.c);
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        float f = i2 * this.f29007a;
        float f2 = -f;
        LinearGradient linearGradient = new LinearGradient(f2, f2, f, f, new int[]{0, Color.parseColor("#88ffffff"), Color.parseColor("#88ffffff"), 0}, new float[]{0.0f, 0.2f, 0.8f, 1.0f}, Shader.TileMode.CLAMP);
        this.tt = linearGradient;
        this.c.setShader(linearGradient);
        c();
    }

    private void c(Context context) {
        this.c.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        this.c.setColor(-1);
    }

    private void c() {
        ValueAnimator valueAnimator = this.n;
        if (valueAnimator != null) {
            valueAnimator.cancel();
            this.n.removeAllListeners();
            this.n.removeAllUpdateListeners();
            this.n = null;
        }
        float fSqrt = (float) Math.sqrt((getWidth() * getWidth()) + (getHeight() * getHeight()));
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(-fSqrt, fSqrt);
        this.n = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(2000L);
        this.n.setRepeatCount(-1);
        this.n.setInterpolator(new LinearInterpolator());
        this.n.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.byazt.sgn.ShineButton.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator2) {
                ShineButton.this.uj = ((Float) valueAnimator2.getAnimatedValue()).floatValue();
                ShineButton.this.invalidate();
            }
        });
        this.n.start();
    }
}
