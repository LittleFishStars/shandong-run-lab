package com.scwang.smartrefresh.header;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import androidx.annotation.ColorInt;
import androidx.annotation.NonNull;
import androidx.core.graphics.ColorUtils;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.internal.InternalAbstract;
import com.zj.adlib.qk8;
import com.zj.adlib.xm8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class BezierCircleHeader extends InternalAbstract implements RefreshHeader {
    protected static final int TARGET_DEGREE = 270;
    protected Paint mBackPaint;
    protected float mBollRadius;
    protected float mBollY;
    protected float mFinishRatio;
    protected Paint mFrontPaint;
    protected float mHeadHeight;
    protected boolean mOuterIsStart;
    protected Paint mOuterPaint;
    protected Path mPath;
    protected int mRefreshStart;
    protected int mRefreshStop;
    protected boolean mShowBoll;
    protected boolean mShowBollTail;
    protected boolean mShowOuter;
    protected float mSpringRatio;
    protected float mWaveHeight;
    protected boolean mWavePulling;

    public class a implements ValueAnimator.AnimatorUpdateListener {
        public float b;
        public final /* synthetic */ float d;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f40360a = 0.0f;
        public float c = 0.0f;
        public int K = 0;

        public a(float f) {
            this.d = f;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            float fFloatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            if (this.K == 0 && fFloatValue <= 0.0f) {
                this.K = 1;
                this.f40360a = Math.abs(fFloatValue - BezierCircleHeader.this.mWaveHeight);
            }
            if (this.K == 1) {
                float f = (-fFloatValue) / this.d;
                this.c = f;
                BezierCircleHeader bezierCircleHeader = BezierCircleHeader.this;
                if (f >= bezierCircleHeader.mSpringRatio) {
                    bezierCircleHeader.mSpringRatio = f;
                    bezierCircleHeader.mBollY = bezierCircleHeader.mHeadHeight + fFloatValue;
                    this.f40360a = Math.abs(fFloatValue - bezierCircleHeader.mWaveHeight);
                } else {
                    this.K = 2;
                    bezierCircleHeader.mSpringRatio = 0.0f;
                    bezierCircleHeader.mShowBoll = true;
                    bezierCircleHeader.mShowBollTail = true;
                    this.b = bezierCircleHeader.mBollY;
                }
            }
            if (this.K == 2) {
                BezierCircleHeader bezierCircleHeader2 = BezierCircleHeader.this;
                float f2 = bezierCircleHeader2.mBollY;
                float f3 = bezierCircleHeader2.mHeadHeight;
                if (f2 > f3 / 2.0f) {
                    bezierCircleHeader2.mBollY = Math.max(f3 / 2.0f, f2 - this.f40360a);
                    float animatedFraction = valueAnimator.getAnimatedFraction();
                    BezierCircleHeader bezierCircleHeader3 = BezierCircleHeader.this;
                    float f4 = bezierCircleHeader3.mHeadHeight / 2.0f;
                    float f5 = this.b;
                    float f6 = (animatedFraction * (f4 - f5)) + f5;
                    if (bezierCircleHeader3.mBollY > f6) {
                        bezierCircleHeader3.mBollY = f6;
                    }
                }
            }
            BezierCircleHeader bezierCircleHeader4 = BezierCircleHeader.this;
            if (bezierCircleHeader4.mShowBollTail && fFloatValue < bezierCircleHeader4.mWaveHeight) {
                bezierCircleHeader4.mShowOuter = true;
                bezierCircleHeader4.mShowBollTail = false;
                bezierCircleHeader4.mOuterIsStart = true;
                bezierCircleHeader4.mRefreshStart = 90;
                bezierCircleHeader4.mRefreshStop = 90;
            }
            if (bezierCircleHeader4.mWavePulling) {
                return;
            }
            bezierCircleHeader4.mWaveHeight = fFloatValue;
            bezierCircleHeader4.invalidate();
        }
    }

    public class b implements ValueAnimator.AnimatorUpdateListener {
        public b() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            BezierCircleHeader bezierCircleHeader = BezierCircleHeader.this;
            bezierCircleHeader.mFinishRatio = ((Float) valueAnimator.getAnimatedValue()).floatValue();
            bezierCircleHeader.invalidate();
        }
    }

    public BezierCircleHeader(Context context) {
        this(context, null);
    }

    @Override // android.view.ViewGroup, android.view.View
    public void dispatchDraw(Canvas canvas) {
        int width = getWidth();
        int height = getHeight();
        if (isInEditMode()) {
            this.mShowBoll = true;
            this.mShowOuter = true;
            float f = height;
            this.mHeadHeight = f;
            this.mRefreshStop = 270;
            this.mBollY = f / 2.0f;
            this.mBollRadius = f / 6.0f;
        }
        n(canvas, width, height);
        m(canvas, width);
        i(canvas, width);
        l(canvas, width);
        k(canvas, width);
        super.dispatchDraw(canvas);
    }

    public final void i(Canvas canvas, int i) {
        if (this.mShowBoll) {
            canvas.drawCircle(i / 2.0f, this.mBollY, this.mBollRadius, this.mFrontPaint);
            float f = this.mHeadHeight;
            j(canvas, i, (this.mWaveHeight + f) / f);
        }
    }

    public final void j(Canvas canvas, int i, float f) {
        if (this.mShowBollTail) {
            float f2 = this.mHeadHeight + this.mWaveHeight;
            float f3 = this.mBollY;
            float f4 = this.mBollRadius;
            float f5 = f3 + ((f4 * f) / 2.0f);
            float f6 = i;
            float f7 = f6 / 2.0f;
            float fSqrt = ((float) Math.sqrt(f4 * f4 * (1.0f - ((f * f) / 4.0f)))) + f7;
            float f8 = this.mBollRadius;
            float f9 = f7 + (((3.0f * f8) / 4.0f) * (1.0f - f));
            float f10 = f8 + f9;
            this.mPath.reset();
            this.mPath.moveTo(fSqrt, f5);
            this.mPath.quadTo(f9, f2, f10, f2);
            this.mPath.lineTo(f6 - f10, f2);
            this.mPath.quadTo(f6 - f9, f2, f6 - fSqrt, f5);
            canvas.drawPath(this.mPath, this.mFrontPaint);
        }
    }

    public final void k(Canvas canvas, int i) {
        if (this.mFinishRatio > 0.0f) {
            int color = this.mOuterPaint.getColor();
            if (this.mFinishRatio < 0.3d) {
                float f = i / 2.0f;
                canvas.drawCircle(f, this.mBollY, this.mBollRadius, this.mFrontPaint);
                float f2 = this.mBollRadius;
                float strokeWidth = this.mOuterPaint.getStrokeWidth() * 2.0f;
                float f3 = this.mFinishRatio;
                this.mOuterPaint.setColor(ColorUtils.setAlphaComponent(color, (int) ((1.0f - (f3 / 0.3f)) * 255.0f)));
                float f4 = (int) (f2 + (strokeWidth * ((f3 / 0.3f) + 1.0f)));
                float f5 = this.mBollY;
                canvas.drawArc(new RectF(f - f4, f5 - f4, f + f4, f5 + f4), 0.0f, 360.0f, false, this.mOuterPaint);
            }
            this.mOuterPaint.setColor(color);
            float f6 = this.mFinishRatio;
            if (f6 >= 0.3d && f6 < 0.7d) {
                float f7 = (f6 - 0.3f) / 0.4f;
                float f8 = this.mHeadHeight;
                float f9 = (int) ((f8 / 2.0f) + ((f8 - (f8 / 2.0f)) * f7));
                this.mBollY = f9;
                canvas.drawCircle(i / 2.0f, f9, this.mBollRadius, this.mFrontPaint);
                if (this.mBollY >= this.mHeadHeight - (this.mBollRadius * 2.0f)) {
                    this.mShowBollTail = true;
                    j(canvas, i, f7);
                }
                this.mShowBollTail = false;
            }
            float f10 = this.mFinishRatio;
            if (f10 < 0.7d || f10 > 1.0f) {
                return;
            }
            float f11 = (f10 - 0.7f) / 0.3f;
            float f12 = i / 2.0f;
            float f13 = this.mBollRadius;
            int i2 = (int) ((f12 - f13) - ((f13 * 2.0f) * f11));
            this.mPath.reset();
            this.mPath.moveTo(i2, this.mHeadHeight);
            Path path = this.mPath;
            float f14 = this.mHeadHeight;
            path.quadTo(f12, f14 - (this.mBollRadius * (1.0f - f11)), i - i2, f14);
            canvas.drawPath(this.mPath, this.mFrontPaint);
        }
    }

    public final void l(Canvas canvas, int i) {
        if (this.mShowOuter) {
            float strokeWidth = this.mBollRadius + (this.mOuterPaint.getStrokeWidth() * 2.0f);
            int i2 = this.mRefreshStart;
            boolean z = this.mOuterIsStart;
            int i3 = i2 + (z ? 3 : 10);
            this.mRefreshStart = i3;
            int i4 = this.mRefreshStop + (z ? 10 : 3);
            this.mRefreshStop = i4;
            int i5 = i3 % 360;
            this.mRefreshStart = i5;
            int i6 = i4 % 360;
            this.mRefreshStop = i6;
            int i7 = i6 - i5;
            if (i7 < 0) {
                i7 += 360;
            }
            float f = i / 2.0f;
            float f2 = this.mBollY;
            canvas.drawArc(new RectF(f - strokeWidth, f2 - strokeWidth, f + strokeWidth, f2 + strokeWidth), this.mRefreshStart, i7, false, this.mOuterPaint);
            if (i7 >= 270) {
                this.mOuterIsStart = false;
            } else if (i7 <= 10) {
                this.mOuterIsStart = true;
            }
            invalidate();
        }
    }

    public final void m(Canvas canvas, int i) {
        float f = this.mSpringRatio;
        if (f > 0.0f) {
            float f2 = i;
            float f3 = f2 / 2.0f;
            float f4 = this.mBollRadius;
            float f5 = (f3 - (4.0f * f4)) + (3.0f * f * f4);
            if (f >= 0.9d) {
                canvas.drawCircle(f3, this.mBollY, f4, this.mFrontPaint);
                return;
            }
            this.mPath.reset();
            this.mPath.moveTo(f5, this.mBollY);
            Path path = this.mPath;
            float f6 = this.mBollY;
            path.quadTo(f3, f6 - ((this.mBollRadius * this.mSpringRatio) * 2.0f), f2 - f5, f6);
            canvas.drawPath(this.mPath, this.mFrontPaint);
        }
    }

    public final void n(Canvas canvas, int i, int i2) {
        float fMin = Math.min(this.mHeadHeight, i2);
        if (this.mWaveHeight == 0.0f) {
            canvas.drawRect(0.0f, 0.0f, i, fMin, this.mBackPaint);
            return;
        }
        this.mPath.reset();
        float f = i;
        this.mPath.lineTo(f, 0.0f);
        this.mPath.lineTo(f, fMin);
        this.mPath.quadTo(f / 2.0f, (this.mWaveHeight * 2.0f) + fMin, 0.0f, fMin);
        this.mPath.close();
        canvas.drawPath(this.mPath, this.mBackPaint);
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public int onFinish(@NonNull RefreshLayout refreshLayout, boolean z) {
        this.mShowBoll = false;
        this.mShowOuter = false;
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(0.0f, 1.0f);
        valueAnimatorOfFloat.addUpdateListener(new b());
        valueAnimatorOfFloat.setInterpolator(new AccelerateInterpolator());
        valueAnimatorOfFloat.setDuration(800L);
        valueAnimatorOfFloat.start();
        return 800;
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onMoving(boolean z, float f, int i, int i2, int i3) {
        if (z || this.mWavePulling) {
            this.mWavePulling = true;
            this.mHeadHeight = i2;
            this.mWaveHeight = Math.max(i - i2, 0) * 0.8f;
        }
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    public void onReleased(@NonNull RefreshLayout refreshLayout, int i, int i2) {
        this.mWavePulling = false;
        float f = i;
        this.mHeadHeight = f;
        this.mBollRadius = f / 6.0f;
        DecelerateInterpolator decelerateInterpolator = new DecelerateInterpolator();
        float fMin = Math.min(this.mWaveHeight * 0.8f, this.mHeadHeight / 2.0f);
        ValueAnimator valueAnimatorOfFloat = ValueAnimator.ofFloat(this.mWaveHeight, 0.0f, -(1.0f * fMin), 0.0f, -(0.4f * fMin), 0.0f);
        valueAnimatorOfFloat.addUpdateListener(new a(fMin));
        valueAnimatorOfFloat.setInterpolator(decelerateInterpolator);
        valueAnimatorOfFloat.setDuration(1000L);
        valueAnimatorOfFloat.start();
    }

    @Override // com.scwang.smartrefresh.layout.internal.InternalAbstract, com.scwang.smartrefresh.layout.api.RefreshInternal
    @Deprecated
    public void setPrimaryColors(@ColorInt int... iArr) {
        if (iArr.length > 0) {
            this.mBackPaint.setColor(iArr[0]);
            if (iArr.length > 1) {
                this.mFrontPaint.setColor(iArr[1]);
                this.mOuterPaint.setColor(iArr[1]);
            }
        }
    }

    public BezierCircleHeader(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public BezierCircleHeader(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mRefreshStop = 90;
        this.mRefreshStart = 90;
        this.mOuterIsStart = true;
        this.mWavePulling = false;
        this.mSpinnerStyle = xm8.b;
        setMinimumHeight(qk8.d(100.0f));
        Paint paint = new Paint();
        this.mBackPaint = paint;
        paint.setColor(-15614977);
        this.mBackPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.mFrontPaint = paint2;
        paint2.setColor(-1);
        this.mFrontPaint.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.mOuterPaint = paint3;
        paint3.setAntiAlias(true);
        this.mOuterPaint.setColor(-1);
        this.mOuterPaint.setStyle(Paint.Style.STROKE);
        this.mOuterPaint.setStrokeWidth(qk8.d(2.0f));
        this.mPath = new Path();
    }
}
