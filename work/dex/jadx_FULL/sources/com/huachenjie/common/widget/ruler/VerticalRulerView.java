package com.huachenjie.common.widget.ruler;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextUtils;
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
import com.zj.adlib.jj8;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class VerticalRulerView extends View implements ScrollChangeListener {
    private static final String DEFAULT_LINE_COLOR = "#B39696BD";
    private static final int DEFAULT_LINE_SPACE = 8;
    private static final int DEFAULT_LINE_STROKE_WIDTH = 2;
    private static final int DEFAULT_LONGLINE_HEIGHT = 50;
    private static final String DEFAULT_SCALE_VALUE_COLOR = "#B39696BD";
    private static final int DEFAULT_SCALE_VALUE_INTERVAL = 144;
    private static final float DEFAULT_SCALE_VALUE_TEXTSIZE = 30.0f;
    private static final int DEFAULT_SCORLL_LOC_DURATION = 250;
    private boolean extraBelowCenter;
    private Typeface extraBelowSelectedTypeface;
    private int extraItemSelectedTitleSize;
    private int extraItemUnselectedTitleColor;
    private int extraItemUnselectedTitleSize;
    private final TextPaint extraLayoutPaint;
    private int extraSelectedTextSize;
    private int extraTextSize;
    private boolean isFling;
    private boolean isShowScaleValue;
    private int mCountHeight;
    private int mCountRange;
    private Paint mExtraPaint;
    private int mLineLength;
    private Paint mLinePaint;
    private int mLineSpace;
    private int mLineStrokeWidth;
    private int mLongLineColor;
    private int mMarginBottom;
    private int mMarginTop;
    private int mMinVelocity;
    private final float mPreDistance;
    private boolean mPressUp;
    private Rect mRect;
    private VerticalRulerHelper mRulerHelper;
    private int mScrollLocDuration;
    private Scroller mScroller;
    private int mTextIndex;
    private Paint mTextPaint;
    private int outPutScale;
    private IScaleTransform scaleTransform;
    private int scaleValueColor;
    private int scaleValueInterval;
    private int scaleValueTextSize;
    private ScrollFinishListener scrollFinishListener;
    private int selectedValueColor;
    private int selectedValueTextSize;
    private float startY;
    private VelocityTracker velocityTracker;

    public interface ScrollFinishListener {
        void onScrollFinish(double scaleValue);
    }

    public VerticalRulerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mPreDistance = -1.0f;
        this.mTextIndex = 0;
        this.mCountRange = -1;
        this.mPressUp = false;
        this.isFling = false;
        this.outPutScale = 1;
        this.mMarginTop = 0;
        this.mMarginBottom = 0;
        this.mScrollLocDuration = 250;
        this.extraLayoutPaint = new TextPaint(1);
        init(context, attrs);
    }

    private void doScroll(int dx, int dy, int duration) {
        Scroller scroller = this.mScroller;
        scroller.startScroll(scroller.getFinalX(), this.mScroller.getFinalY(), dx, dy, duration);
    }

    private void drawScaleLine(Canvas canvas) {
        this.mTextIndex = 0;
        for (int i = 0; i <= this.mRulerHelper.getIntervalCount(); i++) {
            int i2 = this.mLineStrokeWidth;
            Rect rect = this.mRect;
            int i3 = (this.mLineSpace * i) + (i2 * i) + this.mMarginTop;
            rect.top = i3;
            rect.left = 0;
            rect.right = this.mLineLength;
            rect.bottom = i3 + i2;
            if (!this.mRulerHelper.isAddFull()) {
                this.mRulerHelper.addScale(this.mRect.top);
            }
            this.mLinePaint.setColor(this.mLongLineColor);
            if (this.isShowScaleValue) {
                double scaleValueByIndex = this.mRulerHelper.getScaleValueByIndex(this.mTextIndex);
                double currentScaleValue = this.mRulerHelper.getCurrentScaleValue();
                this.mTextIndex++;
                boolean z = scaleValueByIndex == currentScaleValue;
                if (this.extraBelowCenter) {
                    drawScaleValueExtraBelow(canvas, scaleValueByIndex, z, extraAt(i), this.mRect.centerY());
                } else if (z) {
                    this.mTextPaint.setTextSize(this.selectedValueTextSize);
                    this.mTextPaint.setColor(this.selectedValueColor);
                    IScaleTransform iScaleTransform = this.scaleTransform;
                    String strTransform = iScaleTransform != null ? iScaleTransform.transform(Double.valueOf(scaleValueByIndex)) : String.valueOf(scaleValueByIndex);
                    canvas.drawText(strTransform, (getWidth() - this.mTextPaint.measureText(strTransform)) / 2.0f, (this.mRect.centerY() + (this.selectedValueTextSize / 2)) - jj8.a(4.0f), this.mTextPaint);
                    if (this.mRulerHelper.getExtraInfoList() != null && i >= 0 && i < this.mRulerHelper.getExtraInfoList().size() && !TextUtils.isEmpty(this.mRulerHelper.getExtraInfoList().get(i))) {
                        this.mExtraPaint.setTextSize(this.extraSelectedTextSize);
                        this.mExtraPaint.setColor(this.selectedValueColor);
                        String str = this.mRulerHelper.getExtraInfoList().get(i);
                        canvas.drawText(str, (getWidth() - this.mExtraPaint.measureText(str)) - jj8.a(15.0f), (this.mRect.centerY() + (this.extraSelectedTextSize / 2)) - jj8.a(2.0f), this.mExtraPaint);
                    }
                } else {
                    this.mTextPaint.setTextSize(this.scaleValueTextSize);
                    this.mTextPaint.setColor(this.scaleValueColor);
                    IScaleTransform iScaleTransform2 = this.scaleTransform;
                    String strTransform2 = iScaleTransform2 != null ? iScaleTransform2.transform(Double.valueOf(scaleValueByIndex)) : String.valueOf(scaleValueByIndex);
                    canvas.drawText(strTransform2, (getWidth() - this.mTextPaint.measureText(strTransform2)) / 2.0f, (this.mRect.centerY() + (this.scaleValueTextSize / 2)) - jj8.a(4.0f), this.mTextPaint);
                    if (this.mRulerHelper.getExtraInfoList() != null && i >= 0 && i < this.mRulerHelper.getExtraInfoList().size() && !TextUtils.isEmpty(this.mRulerHelper.getExtraInfoList().get(i))) {
                        this.mExtraPaint.setTextSize(this.extraTextSize);
                        this.mExtraPaint.setColor(this.scaleValueColor);
                        String str2 = this.mRulerHelper.getExtraInfoList().get(i);
                        canvas.drawText(str2, (getWidth() - this.mExtraPaint.measureText(str2)) - jj8.a(15.0f), (this.mRect.centerY() + (this.extraTextSize / 2)) - jj8.a(2.0f), this.mExtraPaint);
                    }
                }
            }
            if (this.mLineLength > 0) {
                Rect rect2 = this.mRect;
                float fHeight = rect2.left + (rect2.height() / 2);
                float fCenterY = this.mRect.centerY();
                Rect rect3 = this.mRect;
                canvas.drawLine(fHeight, fCenterY, rect3.right, rect3.centerY(), this.mLinePaint);
            }
            this.mRect.setEmpty();
        }
    }

    private void drawScaleValueExtraBelow(Canvas canvas, double scaleValue, boolean selected, String extraStr, int centerY) {
        int i;
        int i2;
        Typeface typeface;
        boolean z = !TextUtils.isEmpty(extraStr);
        if (z) {
            if (selected) {
                i = this.extraItemSelectedTitleSize;
                if (i == 0) {
                    i = this.selectedValueTextSize;
                }
            } else {
                i = this.extraItemUnselectedTitleSize;
                if (i == 0) {
                    i = this.scaleValueTextSize;
                }
            }
            if (selected) {
                i2 = this.selectedValueColor;
            } else {
                i2 = this.extraItemUnselectedTitleColor;
                if (i2 == 0) {
                    i2 = this.scaleValueColor;
                }
            }
        } else {
            i = selected ? this.selectedValueTextSize : this.scaleValueTextSize;
            i2 = selected ? this.selectedValueColor : this.scaleValueColor;
        }
        float f = i;
        this.mTextPaint.setTextSize(f);
        this.mTextPaint.setColor(i2);
        Paint paint = this.mTextPaint;
        if (!selected || (typeface = this.extraBelowSelectedTypeface) == null) {
            typeface = Typeface.DEFAULT;
        }
        paint.setTypeface(typeface);
        IScaleTransform iScaleTransform = this.scaleTransform;
        String strTransform = iScaleTransform != null ? iScaleTransform.transform(Double.valueOf(scaleValue)) : String.valueOf(scaleValue);
        float fMeasureText = this.mTextPaint.measureText(strTransform);
        if (!z) {
            canvas.drawText(strTransform, (getWidth() - fMeasureText) / 2.0f, (centerY + (f / 2.0f)) - jj8.a(4.0f), this.mTextPaint);
            return;
        }
        this.extraLayoutPaint.set(this.mExtraPaint);
        this.extraLayoutPaint.setAntiAlias(true);
        this.extraLayoutPaint.setTextSize(this.extraTextSize);
        this.extraLayoutPaint.setColor(this.scaleValueColor);
        this.extraLayoutPaint.setTypeface(Typeface.DEFAULT);
        this.extraLayoutPaint.setFakeBoldText(false);
        StaticLayout staticLayout = new StaticLayout(extraStr, this.extraLayoutPaint, Math.max(1, getWidth() - jj8.a(24.0f)), Layout.Alignment.ALIGN_CENTER, 1.0f, 0.0f, false);
        Paint.FontMetrics fontMetrics = this.mTextPaint.getFontMetrics();
        float f2 = fontMetrics.bottom - fontMetrics.top;
        float fA = jj8.a(2.0f);
        float height = (centerY - (((f2 + fA) + staticLayout.getHeight()) / 2.0f)) - fontMetrics.top;
        canvas.drawText(strTransform, (getWidth() - fMeasureText) / 2.0f, height, this.mTextPaint);
        canvas.save();
        canvas.translate(0.0f, height + fontMetrics.bottom + fA);
        staticLayout.draw(canvas);
        canvas.restore();
    }

    private String extraAt(int index) {
        String str;
        List<String> extraInfoList = this.mRulerHelper.getExtraInfoList();
        return (extraInfoList == null || index < 0 || index >= extraInfoList.size() || (str = extraInfoList.get(index)) == null) ? "" : str;
    }

    private int getRectBottom() {
        return getMeasuredHeight();
    }

    private int getRectLeft() {
        return getMeasuredHeight() - this.mLineLength;
    }

    private int getRectTop(boolean isLong) {
        return getMeasuredHeight() - this.mLineLength;
    }

    private void init(Context context, AttributeSet attrs) {
        if (attrs != null) {
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.VerticalRuler);
            this.mLineSpace = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.VerticalRuler_vertical_scaleSpace, 8);
            this.mLineLength = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.VerticalRuler_vertical_lineLength, 50);
            this.mLineStrokeWidth = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.VerticalRuler_vertical_lineStrokeWidth, 2);
            this.mLongLineColor = typedArrayObtainStyledAttributes.getColor(R.styleable.VerticalRuler_vertical_longLineColor, Color.parseColor("#B39696BD"));
            this.mScrollLocDuration = typedArrayObtainStyledAttributes.getInteger(R.styleable.VerticalRuler_vertical_scrollLocDuration, 250);
            this.isShowScaleValue = typedArrayObtainStyledAttributes.getBoolean(R.styleable.VerticalRuler_vertical_isShowScaleValue, false);
            this.scaleValueTextSize = jj8.e(typedArrayObtainStyledAttributes.getFloat(R.styleable.VerticalRuler_vertical_scaleValueTextSize, 30.0f), getContext());
            this.scaleValueColor = typedArrayObtainStyledAttributes.getColor(R.styleable.VerticalRuler_vertical_scaleValueColor, Color.parseColor("#B39696BD"));
            this.selectedValueTextSize = jj8.e(typedArrayObtainStyledAttributes.getFloat(R.styleable.VerticalRuler_vertical_selectedValueTextSize, 30.0f), getContext());
            this.selectedValueColor = typedArrayObtainStyledAttributes.getColor(R.styleable.VerticalRuler_vertical_selectedValueColor, Color.parseColor("#B39696BD"));
            this.scaleValueInterval = typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.VerticalRuler_vertical_scaleValueInterval, 144);
            this.extraTextSize = jj8.e(typedArrayObtainStyledAttributes.getFloat(R.styleable.VerticalRuler_vertical_extraTextSize, 30.0f), getContext());
            this.extraSelectedTextSize = jj8.e(typedArrayObtainStyledAttributes.getFloat(R.styleable.VerticalRuler_vertical_extraSelectedTextSize, 30.0f), getContext());
            typedArrayObtainStyledAttributes.recycle();
        }
        this.mRulerHelper = new VerticalRulerHelper(this);
        Paint paint = new Paint();
        this.mTextPaint = paint;
        paint.setAntiAlias(true);
        this.mTextPaint.setTextSize(this.scaleValueTextSize);
        this.mTextPaint.setColor(this.scaleValueColor);
        Paint paint2 = new Paint();
        this.mExtraPaint = paint2;
        paint2.setAntiAlias(true);
        this.mExtraPaint.setTextSize(this.extraTextSize);
        this.mExtraPaint.setColor(this.scaleValueColor);
        Paint paint3 = new Paint();
        this.mLinePaint = paint3;
        paint3.setAntiAlias(true);
        this.mLinePaint.setStrokeWidth(this.mLineStrokeWidth);
        this.mLinePaint.setStrokeCap(Paint.Cap.ROUND);
        this.mLinePaint.setStyle(Paint.Style.FILL);
        this.mRect = new Rect();
        this.mScroller = new Scroller(context);
        this.velocityTracker = VelocityTracker.obtain();
        this.mMinVelocity = ViewConfiguration.get(context).getScaledMinimumFlingVelocity();
    }

    @Override // android.view.View
    public void computeScroll() {
        if (this.mScroller.computeScrollOffset()) {
            if (this.mScroller.getCurrY() == this.mScroller.getFinalY() && this.mPressUp && this.isFling) {
                this.mPressUp = false;
                this.isFling = false;
                scrollFinish();
            }
            scrollTo(0, this.mScroller.getCurrY());
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
            if (this.mMarginTop == -1 || this.mCountRange == -1) {
                if (marginLayoutParams != null) {
                    this.mMarginTop = marginLayoutParams.leftMargin;
                    this.mMarginBottom = marginLayoutParams.rightMargin;
                }
                this.mCountRange = (this.mCountHeight - getHeight()) + this.mMarginTop + this.mMarginBottom;
                this.mRulerHelper.setCenterPointY((getHeight() / 2) - (this.mLineStrokeWidth / 2));
            }
            drawScaleLine(canvas);
        }
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0035  */
    /* JADX WARN: Code duplicated, block: B:16:0x004f  */
    /* JADX WARN: Code duplicated, block: B:17:0x0078  */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        float yVelocity;
        this.velocityTracker.addMovement(event);
        int action = event.getAction();
        if (action == 0) {
            this.mScroller.forceFinished(true);
            this.mPressUp = false;
            this.isFling = false;
            this.startY = event.getY();
        } else if (action == 1) {
            this.mPressUp = true;
            this.velocityTracker.computeCurrentVelocity(1000);
            yVelocity = this.velocityTracker.getYVelocity();
            if (Math.abs(yVelocity) >= this.mMinVelocity) {
                this.isFling = true;
                int currY = this.mScroller.getCurrY();
                int centerPointY = this.mRulerHelper.getCenterPointY();
                this.mScroller.fling(0, currY, 0, -((int) (((double) yVelocity) * 0.2d)), 0, 0, -centerPointY, this.mCountRange + centerPointY);
                invalidate();
            } else {
                this.isFling = false;
                scrollFinish();
            }
            this.velocityTracker.clear();
        } else if (action == 2) {
            this.mPressUp = false;
            float y = event.getY() - this.startY;
            if (-1.0f != y) {
                doScroll(0, (int) (-y), 0);
                invalidate();
            }
            this.startY = event.getY();
        } else if (action == 3) {
            this.mPressUp = true;
            this.velocityTracker.computeCurrentVelocity(1000);
            yVelocity = this.velocityTracker.getYVelocity();
            if (Math.abs(yVelocity) >= this.mMinVelocity) {
                this.isFling = true;
                int currY2 = this.mScroller.getCurrY();
                int centerPointY2 = this.mRulerHelper.getCenterPointY();
                this.mScroller.fling(0, currY2, 0, -((int) (((double) yVelocity) * 0.2d)), 0, 0, -centerPointY2, this.mCountRange + centerPointY2);
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
        doScroll(0, -this.mRulerHelper.getNearestScaleOffset(this.mRulerHelper.getCenterPointY() + this.mScroller.getFinalY()), this.mScrollLocDuration);
        invalidate();
        if (this.scrollFinishListener != null) {
            this.scrollFinishListener.onScrollFinish(getCurrentScaleValue());
        }
    }

    public void setConfig(double start, double end, double bigInterval, int scale) {
        if (start >= end || bigInterval == AudioStats.AUDIO_AMPLITUDE_NONE) {
            throw new RuntimeException("Invalid interval value!");
        }
        this.outPutScale = scale;
        this.mRulerHelper.setConfig(start, end, bigInterval);
        int intervalCount = this.mRulerHelper.getIntervalCount();
        this.mCountHeight = (this.mLineSpace * intervalCount) + (intervalCount * this.mLineStrokeWidth);
        invalidate();
    }

    public void setCurrentScaleValue(double scale) {
        this.mRulerHelper.setCurrentScaleValue(scale);
    }

    public void setExtraBelowCenter(boolean extraBelowCenter) {
        this.extraBelowCenter = extraBelowCenter;
        if (extraBelowCenter && this.extraBelowSelectedTypeface == null) {
            this.extraBelowSelectedTypeface = Typeface.create("sans-serif-medium", 0);
        }
        invalidate();
    }

    public void setExtraInfo(List<String> extraInfoList) {
        this.mRulerHelper.setExtraInfoList(extraInfoList);
    }

    public void setExtraItemTitlePaint(int selectedSizePx, int unselectedSizePx, int unselectedColor) {
        this.extraItemSelectedTitleSize = selectedSizePx;
        this.extraItemUnselectedTitleSize = unselectedSizePx;
        this.extraItemUnselectedTitleColor = unselectedColor;
        invalidate();
    }

    public void setScaleTransform(IScaleTransform scaleTransform) {
        this.scaleTransform = scaleTransform;
    }

    public void setScrollFinishListener(ScrollFinishListener listener) {
        this.scrollFinishListener = listener;
    }

    @Override // com.huachenjie.common.widget.ruler.ScrollChangeListener
    public void startScroll(int distance) {
        doScroll(0, -distance, this.mScrollLocDuration);
        postInvalidate();
    }

    public void setConfig(double[] valueArray, double bigInterval, int scale) {
        if (valueArray != null && valueArray.length != 0 && bigInterval != AudioStats.AUDIO_AMPLITUDE_NONE) {
            this.outPutScale = scale;
            ArrayList arrayList = new ArrayList();
            for (double d : valueArray) {
                arrayList.add(Double.valueOf(d));
            }
            this.mRulerHelper.setConfig(arrayList, bigInterval);
            int intervalCount = this.mRulerHelper.getIntervalCount();
            this.mCountHeight = (this.mLineSpace * intervalCount) + (intervalCount * this.mLineStrokeWidth);
            invalidate();
            return;
        }
        throw new RuntimeException("Invalid interval value!");
    }

    public VerticalRulerView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mPreDistance = -1.0f;
        this.mTextIndex = 0;
        this.mCountRange = -1;
        this.mPressUp = false;
        this.isFling = false;
        this.outPutScale = 1;
        this.mMarginTop = 0;
        this.mMarginBottom = 0;
        this.mScrollLocDuration = 250;
        this.extraLayoutPaint = new TextPaint(1);
        init(context, attrs);
    }
}
