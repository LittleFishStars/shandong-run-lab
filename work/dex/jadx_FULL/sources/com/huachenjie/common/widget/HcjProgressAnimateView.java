package com.huachenjie.common.widget;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.huachenjie.common.R;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class HcjProgressAnimateView extends View {
    private int animationRepeatCount;
    private ValueAnimator mAnimator;
    private ProgressViewCallback mCallback;
    private int mCircleColor;
    private Paint mCirclePaint;
    private int mProgress;
    private int mProgressColor;
    private Paint mProgressPaint;
    private float mProgressWidth;
    private boolean mRevert;
    private int mRingColor;
    private Paint mRingPaint;
    private float mRingWidth;
    private int max;

    public static abstract class ProgressViewCallback {
        public void onCancel() {
        }

        public void onEnd() {
        }

        public void onRepeat() {
        }

        public void onStart() {
        }
    }

    public HcjProgressAnimateView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.max = 360;
        this.mProgress = 0;
        this.animationRepeatCount = 0;
        initAttrs(context, attrs);
        initVariable();
    }

    private void initAttrs(Context context, AttributeSet attrs) {
        TypedArray typedArrayObtainStyledAttributes = context.getTheme().obtainStyledAttributes(attrs, R.styleable.HcjProgressAnimateView, 0, 0);
        this.mCircleColor = typedArrayObtainStyledAttributes.getColor(R.styleable.HcjProgressAnimateView_pav_circleColor, -1);
        this.mRingWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.HcjProgressAnimateView_pav_ringWidth, 4.0f);
        this.mRingColor = typedArrayObtainStyledAttributes.getColor(R.styleable.HcjProgressAnimateView_pav_ringColor, -3355444);
        this.mProgressWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.HcjProgressAnimateView_pav_progressWidth, 5.0f);
        this.mProgressColor = typedArrayObtainStyledAttributes.getColor(R.styleable.HcjProgressAnimateView_pav_progressColor, -16777216);
        this.mRevert = typedArrayObtainStyledAttributes.getBoolean(R.styleable.HcjProgressAnimateView_pav_revert, false);
        typedArrayObtainStyledAttributes.recycle();
    }

    private void initVariable() {
        Paint paint = new Paint();
        this.mCirclePaint = paint;
        paint.setAntiAlias(true);
        this.mCirclePaint.setColor(this.mCircleColor);
        this.mCirclePaint.setStyle(Paint.Style.FILL);
        Paint paint2 = new Paint();
        this.mRingPaint = paint2;
        paint2.setAntiAlias(true);
        this.mRingPaint.setColor(this.mRingColor);
        this.mRingPaint.setStyle(Paint.Style.STROKE);
        this.mRingPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mRingPaint.setStrokeWidth(this.mRingWidth);
        Paint paint3 = new Paint();
        this.mProgressPaint = paint3;
        paint3.setAntiAlias(true);
        this.mProgressPaint.setColor(this.mProgressColor);
        this.mProgressPaint.setStyle(Paint.Style.STROKE);
        this.mProgressPaint.setStrokeCap(Paint.Cap.ROUND);
        this.mProgressPaint.setStrokeWidth(this.mProgressWidth);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$start$0(ValueAnimator valueAnimator) {
        this.mProgress = ((Integer) valueAnimator.getAnimatedValue()).intValue();
        invalidate();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        float width = getWidth();
        float f = width / 2.0f;
        float height = getHeight();
        canvas.drawCircle(f, height / 2.0f, f - this.mRingWidth, this.mCirclePaint);
        float f2 = this.mRingWidth / 2.0f;
        canvas.drawArc(f2, f2, width - f2, height - f2, -90.0f, 360.0f, false, this.mRingPaint);
        int i = this.mProgress;
        if (i > 0) {
            float f3 = this.mProgressWidth / 2.0f;
            canvas.drawArc(f3, f3, width - f3, height - f3, -90.0f, i, false, this.mProgressPaint);
        }
    }

    public void setCallback(ProgressViewCallback callback) {
        this.mCallback = callback;
    }

    public void setCircleColor(int color) {
        this.mCircleColor = color;
        this.mCirclePaint.setColor(color);
        invalidate();
    }

    public void setMax(int max) {
        if (max < 0 || max > 360) {
            return;
        }
        this.max = max;
    }

    public void setProgressColor(int color) {
        this.mProgressColor = color;
        this.mProgressPaint.setColor(color);
        invalidate();
    }

    public void setRingColor(int color) {
        this.mRingColor = color;
        this.mRingPaint.setColor(color);
        invalidate();
    }

    public void start(long duration, final int repeatNum) {
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator == null || !valueAnimator.isRunning()) {
            stop();
            this.animationRepeatCount = 0;
            if (this.mRevert) {
                this.mAnimator = ValueAnimator.ofInt(this.max, this.mProgress);
            } else {
                this.mAnimator = ValueAnimator.ofInt(this.mProgress, this.max);
            }
            this.mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.zj.adlib.jz3
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public final void onAnimationUpdate(ValueAnimator valueAnimator2) {
                    this.f42706a.lambda$start$0(valueAnimator2);
                }
            });
            this.mAnimator.addListener(new AnimatorListenerAdapter() { // from class: com.huachenjie.common.widget.HcjProgressAnimateView.1
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationCancel(Animator animation) {
                    super.onAnimationCancel(animation);
                    HcjProgressAnimateView.this.mProgress = 0;
                    HcjProgressAnimateView.this.invalidate();
                    if (HcjProgressAnimateView.this.mCallback != null) {
                        HcjProgressAnimateView.this.mCallback.onCancel();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animation) {
                    super.onAnimationEnd(animation);
                    HcjProgressAnimateView.this.mProgress = 0;
                    HcjProgressAnimateView.this.invalidate();
                    HcjProgressAnimateView.this.animationRepeatCount++;
                    if (HcjProgressAnimateView.this.animationRepeatCount < repeatNum) {
                        HcjProgressAnimateView.this.mAnimator.start();
                    } else if (HcjProgressAnimateView.this.mCallback != null) {
                        HcjProgressAnimateView.this.mCallback.onEnd();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationRepeat(Animator animation) {
                    super.onAnimationRepeat(animation);
                    if (HcjProgressAnimateView.this.mCallback != null) {
                        HcjProgressAnimateView.this.mCallback.onRepeat();
                    }
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationStart(Animator animation) {
                    super.onAnimationStart(animation);
                    if (HcjProgressAnimateView.this.mCallback != null) {
                        HcjProgressAnimateView.this.mCallback.onStart();
                    }
                }
            });
            this.mAnimator.setInterpolator(new LinearInterpolator());
            this.mAnimator.setDuration(duration);
            this.mAnimator.start();
        }
    }

    public void stop() {
        this.mProgress = 0;
        ValueAnimator valueAnimator = this.mAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllUpdateListeners();
            this.mAnimator.removeAllListeners();
            this.mAnimator.cancel();
            this.mAnimator = null;
        }
    }
}
