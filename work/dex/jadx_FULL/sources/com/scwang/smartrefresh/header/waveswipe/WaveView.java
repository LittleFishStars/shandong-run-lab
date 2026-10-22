package com.scwang.smartrefresh.header.waveswipe;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.BounceInterpolator;
import androidx.annotation.ColorInt;
import com.zj.adlib.gs2;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class WaveView extends View implements ViewTreeObserver.OnPreDrawListener {
    protected static final long DROP_BOUNCE_ANIMATOR_DURATION = 500;
    protected static final long DROP_CIRCLE_ANIMATOR_DURATION = 500;
    protected static final int DROP_REMOVE_ANIMATOR_DURATION = 200;
    protected static final long DROP_VERTEX_ANIMATION_DURATION = 500;
    protected static final float MAX_WAVE_HEIGHT = 0.2f;
    protected static final int SHADOW_COLOR = -1728053248;
    protected static final int WAVE_ANIMATOR_DURATION = 1000;
    protected ValueAnimator.AnimatorUpdateListener mAnimatorUpdateListener;
    protected float mCurrentCircleCenterY;
    protected ValueAnimator mDisappearCircleAnimator;
    protected ValueAnimator mDropBounceHorizontalAnimator;
    protected ValueAnimator mDropBounceVerticalAnimator;
    protected ValueAnimator mDropCircleAnimator;
    protected Path mDropCirclePath;
    protected float mDropCircleRadius;
    protected boolean mDropHeightUpdated;
    protected RectF mDropRect;
    protected Path mDropTangentPath;
    protected ValueAnimator mDropVertexAnimator;
    protected boolean mIsManualRefreshing;
    protected int mMaxDropHeight;
    protected Paint mPaint;
    protected Path mShadowPath;
    protected int mUpdateMaxDropHeight;
    protected Path mWavePath;
    protected ValueAnimator mWaveReverseAnimator;
    protected int mWidth;
    protected static final float[][] BEGIN_PHASE_POINTS = {new float[]{0.1655f, 0.0f}, new float[]{0.4188f, -0.0109f}, new float[]{0.4606f, -0.0049f}, new float[]{0.4893f, 0.0f}, new float[]{0.4893f, 0.0f}, new float[]{0.5f, 0.0f}};
    protected static final float[][] APPEAR_PHASE_POINTS = {new float[]{0.1655f, 0.0f}, new float[]{0.5237f, 0.0553f}, new float[]{0.4557f, 0.0936f}, new float[]{0.3908f, 0.1302f}, new float[]{0.4303f, 0.2173f}, new float[]{0.5f, 0.2173f}};
    protected static final float[][] EXPAND_PHASE_POINTS = {new float[]{0.1655f, 0.0f}, new float[]{0.5909f, 0.0f}, new float[]{0.4557f, 0.1642f}, new float[]{0.3941f, 0.2061f}, new float[]{0.4303f, 0.2889f}, new float[]{0.5f, 0.2889f}};

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public a() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveView.this.postInvalidate();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            WaveView.this.mCurrentCircleCenterY = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            WaveView.this.postInvalidateOnAnimation();
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            WaveView.this.resetAnimator();
            WaveView.this.mIsManualRefreshing = false;
        }
    }

    public class d implements ValueAnimator.AnimatorUpdateListener {
        public d() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            WaveView.this.mWavePath.moveTo(0.0f, 0.0f);
            WaveView waveView = WaveView.this;
            Path path = waveView.mWavePath;
            int i = waveView.mWidth;
            float f = fFloatValue * 0.5f;
            path.quadTo(i * 0.25f, 0.0f, i * 0.333f, f);
            WaveView waveView2 = WaveView.this;
            Path path2 = waveView2.mWavePath;
            int i2 = waveView2.mWidth;
            path2.quadTo(i2 * 0.5f, fFloatValue * 1.4f, i2 * 0.666f, f);
            WaveView waveView3 = WaveView.this;
            Path path3 = waveView3.mWavePath;
            int i3 = waveView3.mWidth;
            path3.quadTo(i3 * 0.75f, 0.0f, i3, 0.0f);
            WaveView.this.postInvalidate();
        }
    }

    public WaveView(Context context) {
        super(context);
        this.mDropCircleRadius = 100.0f;
        this.mIsManualRefreshing = false;
        this.mDropHeightUpdated = false;
        this.mAnimatorUpdateListener = new a();
        float f = getResources().getDisplayMetrics().density;
        Paint paint = new Paint();
        this.mPaint = paint;
        paint.setColor(-14575885);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setShadowLayer((int) ((f * 2.0f) + 0.5f), 0.0f, 0.0f, SHADOW_COLOR);
        this.mWavePath = new Path();
        this.mDropTangentPath = new Path();
        this.mDropCirclePath = new Path();
        this.mShadowPath = new Path();
        resetAnimator();
        this.mDropRect = new RectF();
        setLayerType(1, null);
        getViewTreeObserver().addOnPreDrawListener(this);
    }

    public void animationDropCircle() {
        if (this.mDisappearCircleAnimator.isRunning()) {
            return;
        }
        startDropAnimation();
        startWaveAnimation(0.1f);
    }

    public void appearPhase(float f, float f2) {
        onPreDragWave();
        this.mWavePath.moveTo(0.0f, 0.0f);
        Path path = this.mWavePath;
        int i = this.mWidth;
        float[][] fArr = APPEAR_PHASE_POINTS;
        float[] fArr2 = fArr[0];
        float f3 = i * fArr2[0];
        float f4 = i * fArr2[1];
        float[][] fArr3 = BEGIN_PHASE_POINTS;
        path.cubicTo(f3, f4, i * Math.min(fArr3[1][0] + f2, fArr[1][0]), this.mWidth * Math.max((fArr3[1][1] + f) - f2, fArr[1][1]), this.mWidth * Math.max(fArr3[2][0] - f2, fArr[2][0]), this.mWidth * Math.max((fArr3[2][1] + f) - f2, fArr[2][1]));
        Path path2 = this.mWavePath;
        float fMax = this.mWidth * Math.max(fArr3[3][0] - f2, fArr[3][0]);
        float fMin = this.mWidth * Math.min(fArr3[3][1] + f + f2, fArr[3][1]);
        float fMax2 = this.mWidth * Math.max(fArr3[4][0] - f2, fArr[4][0]);
        float fMin2 = this.mWidth * Math.min(fArr3[4][1] + f + f2, fArr[4][1]);
        int i2 = this.mWidth;
        float[] fArr4 = fArr[5];
        path2.cubicTo(fMax, fMin, fMax2, fMin2, i2 * fArr4[0], i2 * Math.min(fArr3[0][1] + f + f2, fArr4[1]));
        Path path3 = this.mWavePath;
        int i3 = this.mWidth;
        float fMax3 = i3 - (i3 * Math.max(fArr3[4][0] - f2, fArr[4][0]));
        float fMin3 = this.mWidth * Math.min(fArr3[4][1] + f + f2, fArr[4][1]);
        int i4 = this.mWidth;
        float fMax4 = i4 - (i4 * Math.max(fArr3[3][0] - f2, fArr[3][0]));
        float fMin4 = this.mWidth * Math.min(fArr3[3][1] + f + f2, fArr[3][1]);
        int i5 = this.mWidth;
        path3.cubicTo(fMax3, fMin3, fMax4, fMin4, i5 - (i5 * Math.max(fArr3[2][0] - f2, fArr[2][0])), this.mWidth * Math.max((fArr3[2][1] + f) - f2, fArr[2][1]));
        Path path4 = this.mWavePath;
        int i6 = this.mWidth;
        float fMin5 = i6 - (i6 * Math.min(fArr3[1][0] + f2, fArr[1][0]));
        float fMax5 = Math.max((fArr3[1][1] + f) - f2, fArr[1][1]) * this.mWidth;
        int i7 = this.mWidth;
        float[] fArr5 = fArr[0];
        path4.cubicTo(fMin5, fMax5, i7 - (i7 * fArr5[0]), i7 * fArr5[1], i7, 0.0f);
        this.mCurrentCircleCenterY = (this.mWidth * Math.min(fArr3[3][1] + f + f2, fArr[3][1])) + this.mDropCircleRadius;
        postInvalidateOnAnimation();
    }

    public void beginPhase(float f) {
        onPreDragWave();
        this.mWavePath.moveTo(0.0f, 0.0f);
        Path path = this.mWavePath;
        int i = this.mWidth;
        float[][] fArr = BEGIN_PHASE_POINTS;
        float[] fArr2 = fArr[0];
        float f2 = i * fArr2[0];
        float f3 = fArr2[1];
        float[] fArr3 = fArr[1];
        float f4 = fArr3[0] * i;
        float f5 = i * (fArr3[1] + f);
        float[] fArr4 = fArr[2];
        path.cubicTo(f2, f3, f4, f5, fArr4[0] * i, i * (fArr4[1] + f));
        Path path2 = this.mWavePath;
        int i2 = this.mWidth;
        float[] fArr5 = fArr[3];
        float f6 = i2 * fArr5[0];
        float f7 = i2 * (fArr5[1] + f);
        float[] fArr6 = fArr[4];
        float f8 = i2 * fArr6[0];
        float f9 = i2 * (fArr6[1] + f);
        float[] fArr7 = fArr[5];
        path2.cubicTo(f6, f7, f8, f9, i2 * fArr7[0], i2 * (fArr7[1] + f));
        Path path3 = this.mWavePath;
        int i3 = this.mWidth;
        float[] fArr8 = fArr[4];
        float f10 = i3 - (i3 * fArr8[0]);
        float f11 = i3 * (fArr8[1] + f);
        float[] fArr9 = fArr[3];
        float f12 = i3 - (i3 * fArr9[0]);
        float f13 = i3 * (fArr9[1] + f);
        float[] fArr10 = fArr[2];
        path3.cubicTo(f10, f11, f12, f13, i3 - (i3 * fArr10[0]), i3 * (fArr10[1] + f));
        Path path4 = this.mWavePath;
        int i4 = this.mWidth;
        float[] fArr11 = fArr[1];
        float f14 = i4 - (i4 * fArr11[0]);
        float f15 = i4 * (fArr11[1] + f);
        float[] fArr12 = fArr[0];
        path4.cubicTo(f14, f15, i4 - (i4 * fArr12[0]), fArr12[1], i4, 0.0f);
        postInvalidateOnAnimation();
    }

    public void expandPhase(float f, float f2, float f3) {
        onPreDragWave();
        this.mWavePath.moveTo(0.0f, 0.0f);
        Path path = this.mWavePath;
        int i = this.mWidth;
        float[][] fArr = EXPAND_PHASE_POINTS;
        float[] fArr2 = fArr[0];
        float f4 = i * fArr2[0];
        float f5 = i * fArr2[1];
        float[][] fArr3 = BEGIN_PHASE_POINTS;
        float f6 = fArr3[1][0] + f2;
        float[][] fArr4 = APPEAR_PHASE_POINTS;
        path.cubicTo(f4, f5, i * Math.min(Math.min(f6, fArr4[1][0]) + f3, fArr[1][0]), this.mWidth * Math.max(Math.max((fArr3[1][1] + f) - f2, fArr4[1][1]) - f3, fArr[1][1]), this.mWidth * Math.max(fArr3[2][0] - f2, fArr[2][0]), this.mWidth * Math.min(Math.max((fArr3[2][1] + f) - f2, fArr4[2][1]) + f3, fArr[2][1]));
        Path path2 = this.mWavePath;
        float fMin = this.mWidth * Math.min(Math.max(fArr3[3][0] - f2, fArr4[3][0]) + f3, fArr[3][0]);
        float fMin2 = this.mWidth * Math.min(Math.min(fArr3[3][1] + f + f2, fArr4[3][1]) + f3, fArr[3][1]);
        float fMax = this.mWidth * Math.max(fArr3[4][0] - f2, fArr[4][0]);
        float fMin3 = this.mWidth * Math.min(Math.min(fArr3[4][1] + f + f2, fArr4[4][1]) + f3, fArr[4][1]);
        int i2 = this.mWidth;
        path2.cubicTo(fMin, fMin2, fMax, fMin3, i2 * fArr[5][0], i2 * Math.min(Math.min(fArr3[0][1] + f + f2, fArr4[5][1]) + f3, fArr[5][1]));
        Path path3 = this.mWavePath;
        int i3 = this.mWidth;
        float fMax2 = i3 - (i3 * Math.max(fArr3[4][0] - f2, fArr[4][0]));
        float fMin4 = this.mWidth * Math.min(Math.min(fArr3[4][1] + f + f2, fArr4[4][1]) + f3, fArr[4][1]);
        int i4 = this.mWidth;
        float fMin5 = i4 - (i4 * Math.min(Math.max(fArr3[3][0] - f2, fArr4[3][0]) + f3, fArr[3][0]));
        float fMin6 = this.mWidth * Math.min(Math.min(fArr3[3][1] + f + f2, fArr4[3][1]) + f3, fArr[3][1]);
        int i5 = this.mWidth;
        path3.cubicTo(fMax2, fMin4, fMin5, fMin6, i5 - (i5 * Math.max(fArr3[2][0] - f2, fArr[2][0])), this.mWidth * Math.min(Math.max((fArr3[2][1] + f) - f2, fArr4[2][1]) + f3, fArr[2][1]));
        Path path4 = this.mWavePath;
        int i6 = this.mWidth;
        float fMin7 = i6 - (i6 * Math.min(Math.min(fArr3[1][0] + f2, fArr4[1][0]) + f3, fArr[1][0]));
        float fMax3 = this.mWidth * Math.max(Math.max((fArr3[1][1] + f) - f2, fArr4[1][1]) - f3, fArr[1][1]);
        int i7 = this.mWidth;
        float[] fArr5 = fArr[0];
        path4.cubicTo(fMin7, fMax3, i7 - (i7 * fArr5[0]), i7 * fArr5[1], i7, 0.0f);
        this.mCurrentCircleCenterY = (this.mWidth * Math.min(Math.min(fArr3[3][1] + f + f2, fArr4[3][1]) + f3, fArr[3][1])) + this.mDropCircleRadius;
        postInvalidateOnAnimation();
    }

    public float getCurrentCircleCenterY() {
        return this.mCurrentCircleCenterY;
    }

    public void manualRefresh() {
        if (this.mIsManualRefreshing) {
            return;
        }
        this.mIsManualRefreshing = true;
        int i = this.mMaxDropHeight;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(i, i);
        this.mDropCircleAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.start();
        int i2 = this.mMaxDropHeight;
        float f = this.mDropCircleRadius;
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(i2 - f, i2 - f);
        this.mDropVertexAnimator = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.start();
        this.mCurrentCircleCenterY = this.mMaxDropHeight;
        postInvalidate();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        ValueAnimator valueAnimator = this.mDisappearCircleAnimator;
        if (valueAnimator != null) {
            valueAnimator.end();
            this.mDisappearCircleAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator2 = this.mDropCircleAnimator;
        if (valueAnimator2 != null) {
            valueAnimator2.end();
            this.mDropCircleAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator3 = this.mDropVertexAnimator;
        if (valueAnimator3 != null) {
            valueAnimator3.end();
            this.mDropVertexAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator4 = this.mWaveReverseAnimator;
        if (valueAnimator4 != null) {
            valueAnimator4.end();
            this.mWaveReverseAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator5 = this.mDropBounceHorizontalAnimator;
        if (valueAnimator5 != null) {
            valueAnimator5.end();
            this.mDropBounceHorizontalAnimator.removeAllUpdateListeners();
        }
        ValueAnimator valueAnimator6 = this.mDropBounceVerticalAnimator;
        if (valueAnimator6 != null) {
            valueAnimator6.end();
            this.mDropBounceVerticalAnimator.removeAllUpdateListeners();
        }
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(this.mWavePath, this.mPaint);
        if (!isInEditMode()) {
            this.mWavePath.rewind();
            this.mDropTangentPath.rewind();
            this.mDropCirclePath.rewind();
        }
        float fFloatValue = ((Float) this.mDropCircleAnimator.getAnimatedValue()).floatValue();
        float f = this.mWidth / 2.0f;
        float fFloatValue2 = ((Float) this.mDisappearCircleAnimator.getAnimatedValue()).floatValue();
        float fFloatValue3 = ((Float) this.mDropBounceVerticalAnimator.getAnimatedValue()).floatValue();
        float fFloatValue4 = ((Float) this.mDropBounceHorizontalAnimator.getAnimatedValue()).floatValue();
        RectF rectF = this.mDropRect;
        float f2 = this.mDropCircleRadius;
        float f3 = fFloatValue3 + 1.0f;
        float f4 = 1.0f + fFloatValue4;
        rectF.set((f - ((f2 * f3) * fFloatValue2)) + ((f2 * fFloatValue4) / 2.0f), (((f2 * f4) * fFloatValue2) + fFloatValue) - ((f2 * fFloatValue3) / 2.0f), (((f3 * f2) * fFloatValue2) + f) - ((fFloatValue4 * f2) / 2.0f), (fFloatValue - ((f4 * f2) * fFloatValue2)) + ((f2 * fFloatValue3) / 2.0f));
        float fFloatValue5 = ((Float) this.mDropVertexAnimator.getAnimatedValue()).floatValue();
        this.mDropTangentPath.moveTo(f, fFloatValue5);
        double d2 = fFloatValue;
        double dPow = ((Math.pow(this.mDropCircleRadius, 2.0d) + ((double) (fFloatValue * fFloatValue5))) - Math.pow(d2, 2.0d)) / ((double) (fFloatValue5 - fFloatValue));
        double d3 = (((double) this.mWidth) * (-2.0d)) / 2.0d;
        double d4 = -d3;
        double dPow2 = (d3 * d3) - (((Math.pow(dPow - d2, 2.0d) + Math.pow(f, 2.0d)) - Math.pow(this.mDropCircleRadius, 2.0d)) * 4.0d);
        double dSqrt = (Math.sqrt(dPow2) + d4) / 2.0d;
        double dSqrt2 = (d4 - Math.sqrt(dPow2)) / 2.0d;
        float f5 = (float) dPow;
        this.mDropTangentPath.lineTo((float) dSqrt, f5);
        this.mDropTangentPath.lineTo((float) dSqrt2, f5);
        this.mDropTangentPath.close();
        this.mShadowPath.set(this.mDropTangentPath);
        this.mShadowPath.addOval(this.mDropRect, Path.Direction.CCW);
        this.mDropCirclePath.addOval(this.mDropRect, Path.Direction.CCW);
        canvas.drawPath(this.mDropTangentPath, this.mPaint);
        canvas.drawPath(this.mDropCirclePath, this.mPaint);
    }

    public void onPreDragWave() {
        ValueAnimator valueAnimator = this.mWaveReverseAnimator;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            return;
        }
        this.mWaveReverseAnimator.cancel();
    }

    @Override // android.view.ViewTreeObserver.OnPreDrawListener
    public boolean onPreDraw() {
        getViewTreeObserver().removeOnPreDrawListener(this);
        if (!this.mDropHeightUpdated) {
            return false;
        }
        updateMaxDropHeight(this.mUpdateMaxDropHeight);
        return false;
    }

    @Override // android.view.View
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        this.mWidth = i;
        this.mDropCircleRadius = i / 14.4f;
        updateMaxDropHeight((int) Math.min(Math.min(i, i2), getHeight() - this.mDropCircleRadius));
        super.onSizeChanged(i, i2, i3, i4);
    }

    public void resetAnimator() {
        this.mDropVertexAnimator = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.mDropBounceVerticalAnimator = ValueAnimator.ofFloat(0.0f, 0.0f);
        this.mDropBounceHorizontalAnimator = ValueAnimator.ofFloat(0.0f, 0.0f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(-1000.0f, -1000.0f);
        this.mDropCircleAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.start();
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat(1.0f, 1.0f);
        this.mDisappearCircleAnimator = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.setDuration(1L);
        this.mDisappearCircleAnimator.start();
    }

    public void setShadow(int i, int i2) {
        this.mPaint.setShadowLayer(i, 0.0f, 0.0f, i2);
    }

    public void setWaveColor(@ColorInt int i) {
        this.mPaint.setColor(i);
        invalidate();
    }

    public void startDisappearCircleAnimation() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 0.0f);
        this.mDisappearCircleAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.addUpdateListener(this.mAnimatorUpdateListener);
        this.mDisappearCircleAnimator.setDuration(200L);
        this.mDisappearCircleAnimator.addListener(new c());
        this.mDisappearCircleAnimator.start();
    }

    public void startDropAnimation() {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(1.0f, 1.0f);
        this.mDisappearCircleAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1L);
        this.mDisappearCircleAnimator.start();
        ValueAnimator valueAnimatorOfFloat2 = ValueAnimator.ofFloat((this.mWidth / 1440.0f) * 500.0f, this.mMaxDropHeight);
        this.mDropCircleAnimator = valueAnimatorOfFloat2;
        valueAnimatorOfFloat2.setDuration(500L);
        this.mDropCircleAnimator.addUpdateListener(new b());
        this.mDropCircleAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        this.mDropCircleAnimator.start();
        ValueAnimator valueAnimatorOfFloat3 = ValueAnimator.ofFloat(0.0f, this.mMaxDropHeight - this.mDropCircleRadius);
        this.mDropVertexAnimator = valueAnimatorOfFloat3;
        valueAnimatorOfFloat3.setDuration(500L);
        this.mDropVertexAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mDropVertexAnimator.start();
        ValueAnimator valueAnimatorOfFloat4 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mDropBounceVerticalAnimator = valueAnimatorOfFloat4;
        valueAnimatorOfFloat4.setDuration(500L);
        this.mDropBounceVerticalAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mDropBounceVerticalAnimator.setInterpolator(new gs2());
        this.mDropBounceVerticalAnimator.setStartDelay(500L);
        this.mDropBounceVerticalAnimator.start();
        ValueAnimator valueAnimatorOfFloat5 = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.mDropBounceHorizontalAnimator = valueAnimatorOfFloat5;
        valueAnimatorOfFloat5.setDuration(500L);
        this.mDropBounceHorizontalAnimator.addUpdateListener(this.mAnimatorUpdateListener);
        this.mDropBounceHorizontalAnimator.setInterpolator(new gs2());
        this.mDropBounceHorizontalAnimator.setStartDelay(625L);
        this.mDropBounceHorizontalAnimator.start();
    }

    public void startWaveAnimation(float f) {
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(Math.min(f, 0.2f) * this.mWidth, 0.0f);
        this.mWaveReverseAnimator = valueAnimatorOfFloat;
        valueAnimatorOfFloat.setDuration(1000L);
        this.mWaveReverseAnimator.addUpdateListener(new d());
        this.mWaveReverseAnimator.setInterpolator(new BounceInterpolator());
        this.mWaveReverseAnimator.start();
    }

    public void updateMaxDropHeight(int i) {
        float f = i;
        if ((this.mWidth / 1440.0f) * 500.0f > f) {
            return;
        }
        this.mMaxDropHeight = (int) Math.min(f, getHeight() - this.mDropCircleRadius);
        if (this.mIsManualRefreshing) {
            this.mIsManualRefreshing = false;
            manualRefresh();
        }
    }
}
