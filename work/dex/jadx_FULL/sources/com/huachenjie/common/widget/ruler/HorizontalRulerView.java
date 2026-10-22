package com.huachenjie.common.widget.ruler;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.widget.Scroller;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import com.huachenjie.common.R;
import com.zj.adlib.c82;
import com.zj.adlib.jj8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class HorizontalRulerView extends View implements ScrollChangeListener {
    private static final String DEFAULT_LINE_COLOR = "#B39696BD";
    private static final int DEFAULT_LINE_SPACE = 8;
    private static final int DEFAULT_LINE_STROKE_WIDTH = 2;
    private static final int DEFAULT_LONGLINE_HEIGHT = 50;
    private static final String DEFAULT_SCALE_VALUE_COLOR = "#B39696BD";
    private static final int DEFAULT_SCALE_VALUE_INTERVAL = 14;
    private static final float DEFAULT_SCALE_VALUE_TEXTSIZE = 14.0f;
    private static final int DEFAULT_SCORLL_LOC_DURATION = 250;
    private static final int DEFAULT_SMALLLINE_HEIGHT = 26;
    private boolean isFling;
    private boolean isShowScaleValue;
    private int mCountRange;
    private int mCountWidth;
    private Paint mLinePaint;
    private int mLineSpace;
    private int mLineStrokeWidth;
    private int mLongLineColor;
    private int mLongLineHeight;
    private int mMarginLeft;
    private int mMarginRight;
    private int mMinVelocity;
    private float mPreDistance;
    private boolean mPressUp;
    private Rect mRect;
    private HorizontalRulerHelper mRulerHelper;
    private int mScrollLocDuration;
    private Scroller mScroller;
    private int mSmallLineColor;
    private int mSmallLineHeight;
    private int mTextIndex;
    private Paint mTextPaint;
    private int outPutScale;
    private int scaleValueColor;
    private int scaleValueInterval;
    private int scaleValueTextSize;
    private ScrollFinishListener scrollFinishListener;
    private float startX;
    private VelocityTracker velocityTracker;

    public interface ScrollFinishListener {
        void onScrollFinish(double scaleValue);
    }

    public HorizontalRulerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mTextIndex = 0;
        this.mCountRange = -1;
        this.mPreDistance = -1.0f;
        this.mPressUp = false;
        this.isFling = false;
        this.outPutScale = 1;
        this.mMarginLeft = 0;
        this.mMarginRight = 0;
        this.mScrollLocDuration = 250;
        init(context, attrs);
    }

    private void doScroll(int dx, int dy, int duration) {
        Scroller scroller = this.mScroller;
        scroller.startScroll(scroller.getFinalX(), this.mScroller.getFinalY(), dx, dy, duration);
    }

    private void drawScaleLine(Canvas canvas) {
        this.mTextIndex = 0;
        for (int i = 0; i <= this.mRulerHelper.getIntervalCount(); i++) {
            boolean zIsLongLine = this.mRulerHelper.isLongLine(i);
            int i2 = this.mLineStrokeWidth * i;
            Rect rect = this.mRect;
            rect.left = (this.mLineSpace * i) + i2 + this.mMarginLeft;
            rect.top = getRectTop(zIsLongLine);
            Rect rect2 = this.mRect;
            rect2.right = rect2.left + this.mLineStrokeWidth;
            rect2.bottom = getRectBottom();
            if (!this.mRulerHelper.isAddFull()) {
                this.mRulerHelper.addScale(this.mRect.left);
            }
            if (zIsLongLine) {
                this.mLinePaint.setColor(this.mLongLineColor);
                if (this.isShowScaleValue) {
                    double scaleValueByIndex = this.mRulerHelper.getScaleValueByIndex(this.mTextIndex);
                    this.mTextIndex += this.mRulerHelper.getIntervalCountInBig();
                    canvas.drawText(c82.a(scaleValueByIndex, this.outPutScale), this.mRect.centerX(), getMeasuredHeight() - this.scaleValueInterval, this.mTextPaint);
                }
            } else {
                this.mLinePaint.setColor(this.mSmallLineColor);
            }
            canvas.drawRect(this.mRect, this.mLinePaint);
            this.mRect.setEmpty();
        }
    }

    private int getRectBottom() {
        return getMeasuredHeight();
    }

    private int getRectTop(boolean isLong) {
        int measuredHeight;
        int i;
        if (isLong) {
            measuredHeight = getMeasuredHeight();
            i = this.mLongLineHeight;
        } else {
            measuredHeight = getMeasuredHeight();
            i = this.mSmallLineHeight;
        }
        return measuredHeight - i;
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.HorizontalRuler);
            this.mLineSpace = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.HorizontalRuler_scaleSpace, 8);
            this.mSmallLineHeight = (int) typedArrayObtainStyledAttributes.getDimension(R.styleable.HorizontalRuler_smallScaleHeight, 26.0f);
            this.mLongLineHeight = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.HorizontalRuler_longLineHeight, 50);
            this.mLineStrokeWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.HorizontalRuler_lineStrokeWidth, 2);
            this.mSmallLineColor = typedArrayObtainStyledAttributes.getColor(R.styleable.HorizontalRuler_smallLineColor, Color.parseColor("#B39696BD"));
            this.mLongLineColor = typedArrayObtainStyledAttributes.getColor(R.styleable.HorizontalRuler_longLineColor, Color.parseColor("#B39696BD"));
            this.mScrollLocDuration = typedArrayObtainStyledAttributes.getInteger(R.styleable.HorizontalRuler_scrollLocDuration, 250);
            this.isShowScaleValue = typedArrayObtainStyledAttributes.getBoolean(R.styleable.HorizontalRuler_isShowScaleValue, false);
            this.scaleValueTextSize = jj8.e(typedArrayObtainStyledAttributes.getFloat(R.styleable.HorizontalRuler_scaleValueTextSize, DEFAULT_SCALE_VALUE_TEXTSIZE), getContext());
            this.scaleValueColor = typedArrayObtainStyledAttributes.getColor(R.styleable.HorizontalRuler_scaleValueColor, Color.parseColor("#B39696BD"));
            this.scaleValueInterval = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.HorizontalRuler_scaleValueInterval, 14);
            typedArrayObtainStyledAttributes.recycle();
        }
        this.mRulerHelper = new HorizontalRulerHelper(this);
        Paint paint = new Paint();
        this.mTextPaint = paint;
        paint.setAntiAlias(true);
        this.mTextPaint.setTextSize(this.scaleValueTextSize);
        this.mTextPaint.setColor(this.scaleValueColor);
        this.mTextPaint.setTextAlign(Paint.Align.CENTER);
        Paint paint2 = new Paint();
        this.mLinePaint = paint2;
        paint2.setAntiAlias(true);
        this.mLinePaint.setStrokeWidth(this.mLineStrokeWidth);
        this.mLinePaint.setStyle(Paint.Style.FILL);
        this.mRect = new Rect();
        this.mScroller = new Scroller(context);
        this.velocityTracker = VelocityTracker.obtain();
        this.mMinVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            if (this.mScroller.getCurrX() == this.mScroller.getFinalX() && this.mPressUp && this.isFling) {
                this.mPressUp = false;
                this.isFling = false;
                scrollFinish();
            }
            scrollTo(this.mScroller.getCurrX(), 0);
            invalidate();
        }
        super.computeScroll();
    }

    public void destroy() {
        this.velocityTracker.recycle();
        this.velocityTracker = null;
        this.mRulerHelper.destroy();
        this.scrollFinishListener = null;
    }

    public double getCurrentScaleValue() {
        return this.mRulerHelper.getCurrentScaleValue();
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.mRulerHelper.getIntervalCount() > 0) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            if (this.mMarginLeft == -1 || this.mCountRange == -1) {
                if (marginLayoutParams != null) {
                    this.mMarginLeft = marginLayoutParams.leftMargin;
                    this.mMarginRight = marginLayoutParams.rightMargin;
                }
                this.mCountRange = (this.mCountWidth - getWidth()) + this.mMarginLeft + this.mMarginRight;
                this.mRulerHelper.setCenterPointX((getWidth() / 2) - (this.mLineStrokeWidth / 2));
            }
            drawScaleLine(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int size = View.MeasureSpec.getSize(heightMeasureSpec);
        int size2 = View.MeasureSpec.getSize(widthMeasureSpec);
        if (View.MeasureSpec.getMode(heightMeasureSpec) == Integer.MIN_VALUE) {
            size = this.isShowScaleValue ? Math.max(this.scaleValueInterval + this.scaleValueTextSize, this.mLongLineHeight) : this.mLongLineHeight;
        }
        setMeasuredDimension(size2, size);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0035  */
    /* JADX WARN: Code duplicated, block: B:16:0x004f  */
    /* JADX WARN: Code duplicated, block: B:17:0x0078  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        float xVelocity;
        this.velocityTracker.addMovement(event);
        int action = event.getAction();
        if (action == 0) {
            this.mScroller.forceFinished(true);
            this.mPressUp = false;
            this.isFling = false;
            this.startX = event.getX();
        } else if (action == 1) {
            this.mPressUp = true;
            this.velocityTracker.computeCurrentVelocity(1000);
            xVelocity = this.velocityTracker.getXVelocity();
            if (Math.abs(xVelocity) >= this.mMinVelocity) {
                this.isFling = true;
                int currX = this.mScroller.getCurrX();
                int centerPointX = this.mRulerHelper.getCenterPointX();
                this.mScroller.fling(currX, 0, -((int) (((double) xVelocity) * 0.2d)), 0, -centerPointX, this.mCountRange + centerPointX, 0, 0);
                invalidate();
            } else {
                this.isFling = false;
                scrollFinish();
            }
            this.velocityTracker.clear();
        } else if (action == 2) {
            this.mPressUp = false;
            float x = event.getX() - this.startX;
            if (this.mPreDistance != x) {
                doScroll((int) (-x), 0, 0);
                invalidate();
            }
            this.startX = event.getX();
        } else if (action == 3) {
            this.mPressUp = true;
            this.velocityTracker.computeCurrentVelocity(1000);
            xVelocity = this.velocityTracker.getXVelocity();
            if (Math.abs(xVelocity) >= this.mMinVelocity) {
                this.isFling = true;
                int currX2 = this.mScroller.getCurrX();
                int centerPointX2 = this.mRulerHelper.getCenterPointX();
                this.mScroller.fling(currX2, 0, -((int) (((double) xVelocity) * 0.2d)), 0, -centerPointX2, this.mCountRange + centerPointX2, 0, 0);
                invalidate();
            } else {
                this.isFling = false;
                scrollFinish();
            }
            this.velocityTracker.clear();
        }
        return true;
    }

    public void scrollFinish() {
        doScroll(-this.mRulerHelper.getNearestScaleOffset(this.mRulerHelper.getCenterPointX() + this.mScroller.getFinalX()), 0, this.mScrollLocDuration);
        invalidate();
        if (this.scrollFinishListener != null) {
            this.scrollFinishListener.onScrollFinish(getCurrentScaleValue());
        }
    }

    public void setConfig(double start, double end, double bigInterval, double smallInterval, int scale) {
        if (start >= end || bigInterval == AudioStats.AUDIO_AMPLITUDE_NONE || smallInterval == AudioStats.AUDIO_AMPLITUDE_NONE || !c82.c(bigInterval, smallInterval, 1)) {
            throw new RuntimeException("Invalid interval value!");
        }
        this.outPutScale = scale;
        this.mRulerHelper.setConfig(start, end, bigInterval, smallInterval);
        int intervalCount = this.mRulerHelper.getIntervalCount();
        this.mCountWidth = (this.mLineSpace * intervalCount) + (intervalCount * this.mLineStrokeWidth);
        invalidate();
    }

    public void setCurrentScaleValue(double scale) {
        this.mRulerHelper.setCurrentScaleValue(scale);
    }

    public void setScrollFinishListener(ScrollFinishListener listener) {
        this.scrollFinishListener = listener;
    }

    @Override // com.huachenjie.common.widget.ruler.ScrollChangeListener
    public void startScroll(int distance) {
        doScroll(-distance, 0, this.mScrollLocDuration);
        postInvalidate();
    }

    public HorizontalRulerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mTextIndex = 0;
        this.mCountRange = -1;
        this.mPreDistance = -1.0f;
        this.mPressUp = false;
        this.isFling = false;
        this.outPutScale = 1;
        this.mMarginLeft = 0;
        this.mMarginRight = 0;
        this.mScrollLocDuration = 250;
        init(context, attrs);
    }
}
