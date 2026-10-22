package com.scwang.smartrefresh.header.waterdrop;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.camera.video.AudioStats;
import com.zj.adlib.gl1;
import com.zj.adlib.qk8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class WaterDropView extends View {
    protected static final int BACK_ANIM_DURATION = 180;
    protected static int STROKE_WIDTH = 2;
    protected gl1 bottomCircle;
    protected int mMaxCircleRadius;
    protected int mMinCircleRadius;
    protected Paint mPaint;
    protected Path mPath;
    protected gl1 topCircle;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaterDropView.this.updateCompleteState(((Float) valueAnimator.getAnimatedValue()).floatValue());
            WaterDropView.this.postInvalidate();
        }
    }

    public WaterDropView(Context context) {
        super(context);
        this.topCircle = new gl1();
        this.bottomCircle = new gl1();
        this.mPath = new Path();
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-7829368);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint2 = this.mPaint;
        int iD = qk8.d(1.0f);
        STROKE_WIDTH = iD;
        paint2.setStrokeWidth(iD);
        Paint paint3 = this.mPaint;
        int i = STROKE_WIDTH;
        paint3.setShadowLayer(i, i / 2.0f, i, -1728053248);
        setLayerType(1, null);
        int i2 = STROKE_WIDTH * 4;
        setPadding(i2, i2, i2, i2);
        this.mPaint.setColor(-7829368);
        int iD2 = qk8.d(20.0f);
        this.mMaxCircleRadius = iD2;
        this.mMinCircleRadius = iD2 / 5;
        gl1 gl1Var = this.topCircle;
        gl1Var.c = iD2;
        gl1 gl1Var2 = this.bottomCircle;
        gl1Var2.c = iD2;
        int i3 = STROKE_WIDTH;
        gl1Var.f41930a = i3 + iD2;
        gl1Var.b = i3 + iD2;
        gl1Var2.f41930a = i3 + iD2;
        gl1Var2.b = i3 + iD2;
    }

    private double getAngle() {
        gl1 gl1Var = this.bottomCircle;
        float f = gl1Var.c;
        gl1 gl1Var2 = this.topCircle;
        float f2 = gl1Var2.c;
        return f > f2 ? AudioStats.AUDIO_AMPLITUDE_NONE : Math.asin((f2 - f) / (gl1Var.b - gl1Var2.b));
    }

    public final void a() {
        this.mPath.reset();
        Path path = this.mPath;
        gl1 gl1Var = this.topCircle;
        path.addCircle(gl1Var.f41930a, gl1Var.b, gl1Var.c, Path.Direction.CCW);
        if (this.bottomCircle.b > this.topCircle.b + qk8.d(1.0f)) {
            Path path2 = this.mPath;
            gl1 gl1Var2 = this.bottomCircle;
            path2.addCircle(gl1Var2.f41930a, gl1Var2.b, gl1Var2.c, Path.Direction.CCW);
            double angle = getAngle();
            gl1 gl1Var3 = this.topCircle;
            float fCos = (float) (((double) gl1Var3.f41930a) - (((double) gl1Var3.c) * Math.cos(angle)));
            gl1 gl1Var4 = this.topCircle;
            float fSin = (float) (((double) gl1Var4.b) + (((double) gl1Var4.c) * Math.sin(angle)));
            gl1 gl1Var5 = this.topCircle;
            float fCos2 = (float) (((double) gl1Var5.f41930a) + (((double) gl1Var5.c) * Math.cos(angle)));
            gl1 gl1Var6 = this.bottomCircle;
            float fCos3 = (float) (((double) gl1Var6.f41930a) - (((double) gl1Var6.c) * Math.cos(angle)));
            gl1 gl1Var7 = this.bottomCircle;
            float fSin2 = (float) (((double) gl1Var7.b) + (((double) gl1Var7.c) * Math.sin(angle)));
            gl1 gl1Var8 = this.bottomCircle;
            float fCos4 = (float) (((double) gl1Var8.f41930a) + (((double) gl1Var8.c) * Math.cos(angle)));
            Path path3 = this.mPath;
            gl1 gl1Var9 = this.topCircle;
            path3.moveTo(gl1Var9.f41930a, gl1Var9.b);
            this.mPath.lineTo(fCos, fSin);
            Path path4 = this.mPath;
            gl1 gl1Var10 = this.bottomCircle;
            path4.quadTo(gl1Var10.f41930a - gl1Var10.c, (gl1Var10.b + this.topCircle.b) / 2.0f, fCos3, fSin2);
            this.mPath.lineTo(fCos4, fSin2);
            Path path5 = this.mPath;
            gl1 gl1Var11 = this.bottomCircle;
            path5.quadTo(gl1Var11.f41930a + gl1Var11.c, (gl1Var11.b + fSin) / 2.0f, fCos2, fSin);
        }
        this.mPath.close();
    }

    public ValueAnimator createAnimator() {
        ValueAnimator duration = ValueAnimator.ofFloat(1.0f, 0.001f).setDuration(180L);
        duration.setInterpolator(new DecelerateInterpolator());
        duration.addUpdateListener(new a());
        return duration;
    }

    public gl1 getBottomCircle() {
        return this.bottomCircle;
    }

    public int getIndicatorColor() {
        return this.mPaint.getColor();
    }

    public int getMaxCircleRadius() {
        return this.mMaxCircleRadius;
    }

    public gl1 getTopCircle() {
        return this.topCircle;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int paddingTop = getPaddingTop();
        int paddingLeft = getPaddingLeft();
        int paddingBottom = getPaddingBottom();
        int height = getHeight();
        canvas.save();
        float f = height;
        float f2 = this.topCircle.c;
        float f3 = paddingTop;
        float f4 = paddingBottom;
        if (f <= (f2 * 2.0f) + f3 + f4) {
            canvas.translate(paddingLeft, (f - (f2 * 2.0f)) - f4);
            gl1 gl1Var = this.topCircle;
            canvas.drawCircle(gl1Var.f41930a, gl1Var.b, gl1Var.c, this.mPaint);
        } else {
            canvas.translate(paddingLeft, f3);
            a();
            canvas.drawPath(this.mPath, this.mPaint);
        }
        canvas.restore();
    }

    @Override // android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        updateCompleteState(getHeight());
    }

    @Override // android.view.View
    public void onMeasure(int i, int i2) {
        int i3 = this.mMaxCircleRadius;
        int i4 = STROKE_WIDTH;
        gl1 gl1Var = this.bottomCircle;
        super.setMeasuredDimension(((i3 + i4) * 2) + getPaddingLeft() + getPaddingRight(), View.resolveSize(((int) Math.ceil(gl1Var.b + gl1Var.c + (i4 * 2))) + getPaddingTop() + getPaddingBottom(), i2));
    }

    public void setIndicatorColor(@ColorInt int i) {
        this.mPaint.setColor(i);
    }

    public void updateCompleteState(float f) {
        int i = this.mMaxCircleRadius;
        float f2 = (float) (((double) i) - ((((double) f) * 0.25d) * ((double) i)));
        float f3 = ((this.mMinCircleRadius - i) * f) + i;
        float f4 = f * 4.0f * i;
        gl1 gl1Var = this.topCircle;
        gl1Var.c = f2;
        gl1 gl1Var2 = this.bottomCircle;
        gl1Var2.c = f3;
        gl1Var2.b = gl1Var.b + f4;
    }

    public void updateCompleteState(int i, int i2) {
    }

    public void updateCompleteState(int i) {
        int paddingTop = getPaddingTop();
        int paddingBottom = getPaddingBottom();
        int i2 = this.mMaxCircleRadius;
        float f = (i2 * 2) + paddingTop + paddingBottom;
        float f2 = i;
        if (f2 < f) {
            gl1 gl1Var = this.topCircle;
            gl1Var.c = i2;
            gl1 gl1Var2 = this.bottomCircle;
            gl1Var2.c = i2;
            gl1Var2.b = gl1Var.b;
            return;
        }
        float fPow = (float) (((double) (i2 - this.mMinCircleRadius)) * (1.0d - Math.pow(100.0d, (-Math.max(0.0f, f2 - f)) / qk8.d(200.0f))));
        gl1 gl1Var3 = this.topCircle;
        int i3 = this.mMaxCircleRadius;
        gl1Var3.c = i3 - (fPow / 4.0f);
        gl1 gl1Var4 = this.bottomCircle;
        float f3 = i3 - fPow;
        gl1Var4.c = f3;
        gl1Var4.b = ((i - paddingTop) - paddingBottom) - f3;
    }
}
