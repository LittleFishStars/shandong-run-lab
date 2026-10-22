package com.huachenjie.common.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.RectF;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.res.ResourcesCompat;
import com.blankj.utilcode.util.SizeUtils;
import com.huachenjie.common.R;
import com.huachenjie.run.map.RouteOverlay;
import com.zj.adlib.jj8;
import com.zj.adlib.zn1;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class ShrinkScrollView extends View {
    private static final int DEFAULT_TEXTSIZE = 16;
    private static final int DEFAULT_THUMB_CIRCLE_RADIUS = 35;
    private static final int DEFAULT_TRACK_HEIGHT = 60;
    private static final int DP_RADIUS = 36;
    private ValueAnimator backAnimator;
    private Bitmap bitmap;
    private int changeX;
    private int downX;
    private int downY;
    boolean drawReck;
    private Paint endArcPaint;
    private Paint lockPaint;
    private int mCurrentStep;
    private ShrinkScrollListener mListener;
    private String message;
    private ValueAnimator moveCircleAnimator;
    private int radius;
    private final RectF rectF;
    private int rectHeight;
    private int rectWidth;
    private Paint startArcPaint;
    private final RectF startRectF;
    private Paint startTrackPaint;
    private int startX;
    private int textColor;
    private Paint textPaint;
    private int textSize;
    private int thumbCircleColor;
    private Paint thumbCirclePaint;
    private int thumbCircleRadius;
    private int thumbCircleShadowRadius;
    private int trackColor;
    private Paint trackPaint;

    public interface ShrinkScrollListener {
        void onCancel();

        void onFinish();
    }

    public ShrinkScrollView(Context context) {
        super(context);
        this.message = "";
        this.mCurrentStep = 1;
        this.drawReck = true;
        this.rectF = new RectF();
        this.startRectF = new RectF();
        init(context, null);
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.ScrollShrinkView);
            this.rectHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollShrinkView_trackHeight, jj8.a(60.0f));
            this.trackColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ScrollShrinkView_trackColor, ResourcesCompat.getColor(getResources(), R.color.white, null));
            this.thumbCircleRadius = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ScrollShrinkView_thumbCircleRadius, jj8.a(35.0f));
            this.thumbCircleColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ScrollShrinkView_thumbCircleColor, ResourcesCompat.getColor(getResources(), R.color.color_main_v2, null));
            this.textColor = typedArrayObtainStyledAttributes.getColor(R.styleable.ScrollShrinkView_messageTextColor, ResourcesCompat.getColor(getResources(), R.color.color_8997A4, null));
            this.textSize = typedArrayObtainStyledAttributes.getColor(R.styleable.ScrollShrinkView_messageTextSize, jj8.e(16.0f, context));
            typedArrayObtainStyledAttributes.recycle();
        }
        int iB = SizeUtils.b(5.0f);
        this.thumbCircleShadowRadius = iB;
        int i = this.rectHeight - (iB * 2);
        this.rectHeight = i;
        this.radius = i / 2;
        int i2 = this.thumbCircleRadius;
        this.startX = i2;
        this.changeX = i2;
        initPaint();
    }

    public void initPaint() {
        Paint paint = new Paint();
        this.startArcPaint = paint;
        paint.setStyle(Paint.Style.FILL);
        this.startArcPaint.setAntiAlias(true);
        this.startArcPaint.setColor(Color.parseColor(RouteOverlay.f12338c));
        Paint paint2 = new Paint();
        this.endArcPaint = paint2;
        paint2.setStyle(Paint.Style.FILL);
        this.endArcPaint.setAntiAlias(true);
        this.endArcPaint.setColor(this.trackColor);
        Paint paint3 = new Paint();
        this.thumbCirclePaint = paint3;
        paint3.setColor(this.thumbCircleColor);
        this.thumbCirclePaint.setAntiAlias(true);
        this.thumbCirclePaint.setStyle(Paint.Style.FILL);
        this.thumbCirclePaint.setShadowLayer(SizeUtils.b(5.0f), 0.0f, jj8.a(1.0f), zn1.a(R.color.black));
        Paint paint4 = new Paint();
        this.startTrackPaint = paint4;
        paint4.setColor(Color.parseColor(RouteOverlay.f12338c));
        this.startTrackPaint.setAntiAlias(true);
        this.startTrackPaint.setStyle(Paint.Style.FILL);
        Paint paint5 = new Paint();
        this.trackPaint = paint5;
        paint5.setColor(this.trackColor);
        this.trackPaint.setAntiAlias(true);
        this.trackPaint.setStyle(Paint.Style.FILL);
        Paint paint6 = new Paint();
        this.lockPaint = paint6;
        paint6.setAntiAlias(true);
        this.lockPaint.setColorFilter(new PorterDuffColorFilter(-1, PorterDuff.Mode.SRC_IN));
        Paint paint7 = new Paint();
        this.textPaint = paint7;
        paint7.setColor(this.textColor);
        this.textPaint.setAntiAlias(true);
        this.textPaint.setTextSize(this.textSize);
        Bitmap bitmapDecodeResource = BitmapFactory.decodeResource(getResources(), R.drawable.ic_lock);
        this.bitmap = bitmapDecodeResource;
        this.bitmap = Bitmap.createBitmap(bitmapDecodeResource, 0, 0, bitmapDecodeResource.getWidth(), this.bitmap.getHeight(), (Matrix) null, true);
    }

    public void moveAnim(int start, final int end, final int type) {
        ValueAnimator valueAnimator = this.backAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.backAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(start, end);
        this.backAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(500L);
        this.backAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huachenjie.common.widget.ShrinkScrollView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                ShrinkScrollView.this.changeX = ((Integer) animation.getAnimatedValue()).intValue();
                if (ShrinkScrollView.this.changeX - ShrinkScrollView.this.startX < 10) {
                    ShrinkScrollView.this.drawReck = true;
                }
                ShrinkScrollView.this.invalidate();
            }
        });
        this.backAnimator.start();
    }

    public void moveCircle(int start, final int end) {
        ValueAnimator valueAnimator = this.moveCircleAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.moveCircleAnimator.cancel();
        }
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(start, end);
        this.moveCircleAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(300L);
        this.moveCircleAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huachenjie.common.widget.ShrinkScrollView.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator animation) {
                ShrinkScrollView.this.changeX = ((Integer) animation.getAnimatedValue()).intValue();
                ShrinkScrollView.this.invalidate();
            }
        });
        this.moveCircleAnimator.start();
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        ValueAnimator valueAnimator = this.moveCircleAnimator;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.moveCircleAnimator.cancel();
        }
        ValueAnimator valueAnimator2 = this.backAnimator;
        if (valueAnimator2 == null || !valueAnimator2.isRunning()) {
            return;
        }
        this.backAnimator.cancel();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int i = this.startX - this.radius;
        int height = (this.thumbCircleRadius - (this.rectHeight / 2)) + ((getHeight() / 2) - this.thumbCircleRadius);
        int i2 = this.rectWidth + this.startX + this.radius;
        int i3 = this.rectHeight + height;
        int i4 = i3 - height;
        float f = i;
        float f2 = height;
        float f3 = i2;
        float f4 = i3;
        this.rectF.set(f, f2, f3, f4);
        if (this.drawReck) {
            canvas.drawRect(this.changeX, f2, this.rectWidth + this.startX, f4, this.trackPaint);
        }
        canvas.drawArc(i2 - i4, f2, f3, f4, -90.0f, 180.0f, true, this.endArcPaint);
        canvas.drawArc(f, f2, i + i4, f4, 90.0f, 180.0f, true, this.startArcPaint);
        if (!TextUtils.isEmpty(this.message)) {
            float fMeasureText = this.textPaint.measureText(this.message);
            Paint.FontMetrics fontMetrics = this.textPaint.getFontMetrics();
            canvas.drawText(this.message, (f3 - fMeasureText) - SizeUtils.b(35.0f), this.rectF.centerY() + (((-fontMetrics.ascent) - fontMetrics.descent) / 2.0f), this.textPaint);
        }
        if (this.drawReck) {
            canvas.drawRect(this.startX, f2, this.changeX, f4, this.startTrackPaint);
        }
        canvas.drawCircle(this.changeX, this.rectF.centerY(), this.thumbCircleRadius - this.thumbCircleShadowRadius, this.thumbCirclePaint);
        Bitmap bitmap = this.bitmap;
        canvas.drawBitmap(bitmap, this.changeX - (bitmap.getWidth() / 2.0f), this.rectF.centerY() - (this.bitmap.getHeight() / 2.0f), this.lockPaint);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        this.rectWidth = ((getMeasuredWidth() - this.thumbCircleRadius) - this.thumbCircleShadowRadius) - this.radius;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (!this.drawReck) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            this.downX = (int) event.getX();
            this.downY = (int) event.getY();
        } else if (action == 1) {
            int i = this.changeX;
            int i2 = this.startX;
            int i3 = this.thumbCircleRadius;
            int i4 = (i - i2) + i3;
            int i5 = this.rectWidth;
            if (i4 > (((i3 + i5) + this.radius) * 3) / 5) {
                ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(i, i5 + i2);
                valueAnimatorOfInt.setDuration(300L);
                valueAnimatorOfInt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.huachenjie.common.widget.ShrinkScrollView.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public void onAnimationUpdate(ValueAnimator animation) {
                        ShrinkScrollView.this.changeX = ((Integer) animation.getAnimatedValue()).intValue();
                        ShrinkScrollView.this.invalidate();
                    }
                });
                valueAnimatorOfInt.addListener(new Animator.AnimatorListener() { // from class: com.huachenjie.common.widget.ShrinkScrollView.2
                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationCancel(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationEnd(Animator animator) {
                        if (ShrinkScrollView.this.mListener != null) {
                            ShrinkScrollView.this.mListener.onFinish();
                        }
                        ShrinkScrollView shrinkScrollView = ShrinkScrollView.this;
                        shrinkScrollView.changeX = shrinkScrollView.thumbCircleRadius;
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationRepeat(Animator animator) {
                    }

                    @Override // android.animation.Animator.AnimatorListener
                    public void onAnimationStart(Animator animator) {
                    }
                });
                valueAnimatorOfInt.start();
            } else {
                ShrinkScrollListener shrinkScrollListener = this.mListener;
                if (shrinkScrollListener != null) {
                    shrinkScrollListener.onCancel();
                }
                moveAnim(this.changeX, this.startX, this.mCurrentStep);
            }
        } else if (action == 2 && ((Math.abs(event.getX() - this.downX) >= 30.0f || Math.abs(event.getY() - this.downY) >= 30.0f) && event.getX() < this.rectWidth + this.startX && event.getX() > this.startX)) {
            this.changeX = (int) event.getX();
            invalidate();
        }
        return true;
    }

    public void setMessage(String message) {
        this.message = message;
        postInvalidate();
    }

    public void setScrollShrinkLisner(ShrinkScrollListener listener) {
        this.mListener = listener;
    }

    public ShrinkScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.message = "";
        this.mCurrentStep = 1;
        this.drawReck = true;
        this.rectF = new RectF();
        this.startRectF = new RectF();
        init(context, attrs);
    }
}
