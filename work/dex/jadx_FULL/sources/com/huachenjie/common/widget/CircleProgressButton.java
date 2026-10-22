package com.huachenjie.common.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.huachenjie.common.R;
import com.zj.adlib.jj8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class CircleProgressButton extends View {
    private static final int PROGRESS_PLUS = 0;
    private static final int PROGRESS_REDUCE = 1;
    private static final int RADIUS_PLUS = 2;
    private static final int RADIUS_REDUCE = 3;
    private static final long TIME_INTERVAL = 1;
    int bouncedTime;
    private int everyIntervalAngle;
    private boolean ifPressedBackOk;
    private boolean isEnd;
    private boolean isEndOk;
    private boolean isPressedOk;
    private float longTouchInterval;
    private float mAnimatedWidth;
    private Bitmap mBitmap;
    private float mBouncedWidth;
    private int mCircleColor;
    private CircleProcessListener mCircleProcessListener;
    private Context mContext;
    private int mHeight;

    @SuppressLint({"HandlerLeak"})
    private Handler mLongPressedHandler;
    private Paint mPaint;
    private int mProgressColor;
    private float mProgressWidth;
    private int mRadius;
    private int mSize;
    private int mWidth;
    private float sweepAngle;
    private float timeInterval;

    public interface CircleProcessListener {
        void onCancel();

        void onCancelOk();

        void onFinished(float angle);

        void onReStart();
    }

    public CircleProgressButton(Context context) {
        this(context, null);
    }

    private void init() {
        this.mPaint = new Paint(1);
        this.mBouncedWidth = this.mProgressWidth / 2.0f;
    }

    public float getLongTouchInterval() {
        return this.longTouchInterval;
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.translate(this.mWidth / 2, this.mHeight / 2);
        this.mPaint.setColor(this.mProgressColor);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(this.mProgressWidth);
        this.mPaint.setStrokeCap(Paint.Cap.ROUND);
        int i = this.mRadius;
        float f = this.mBouncedWidth;
        canvas.drawArc(new RectF((-i) + f, (-i) + f, i - f, i - f), -90.0f, this.sweepAngle, false, this.mPaint);
        this.mPaint.setStyle(Paint.Style.FILL);
        this.mPaint.setColor(this.mCircleColor);
    }

    @Override // android.view.View
    public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > measuredHeight) {
            measuredWidth = measuredHeight;
        }
        this.mSize = measuredWidth;
        this.mRadius = (measuredWidth / 2) - 15;
        setMeasuredDimension(measuredWidth, measuredWidth);
    }

    @Override // android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        this.mWidth = w;
        this.mHeight = h;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction();
        if (action == 0) {
            if (this.isEnd) {
                this.sweepAngle = 0.0f;
            }
            if (!this.ifPressedBackOk) {
                this.mLongPressedHandler.sendEmptyMessage(3);
            }
            this.mLongPressedHandler.sendEmptyMessage(2);
            if (!this.isEndOk) {
                CircleProcessListener circleProcessListener = this.mCircleProcessListener;
                if (circleProcessListener != null) {
                    circleProcessListener.onReStart();
                }
                this.mLongPressedHandler.removeMessages(1);
            }
            this.mLongPressedHandler.sendEmptyMessage(0);
        } else if (action == 1 || action == 3) {
            if (!this.isPressedOk) {
                this.mLongPressedHandler.sendEmptyMessage(2);
            }
            this.mLongPressedHandler.sendEmptyMessage(3);
            if (!this.isEnd) {
                CircleProcessListener circleProcessListener2 = this.mCircleProcessListener;
                if (circleProcessListener2 != null) {
                    circleProcessListener2.onCancel();
                }
                this.mLongPressedHandler.sendEmptyMessage(1);
            }
            this.mLongPressedHandler.removeMessages(0);
        }
        return true;
    }

    public void setCircleProcessListener(CircleProcessListener circleProcessListener) {
        this.mCircleProcessListener = circleProcessListener;
    }

    public void setImagerResource(int resId) {
        this.mBitmap = BitmapFactory.decodeResource(getResources(), resId);
    }

    public CircleProgressButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CircleProgressButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.everyIntervalAngle = 5;
        this.bouncedTime = 0;
        this.mLongPressedHandler = new Handler() { // from class: com.huachenjie.common.widget.CircleProgressButton.1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                int i = msg.what;
                if (i == 0) {
                    CircleProgressButton circleProgressButton = CircleProgressButton.this;
                    circleProgressButton.isEnd = circleProgressButton.sweepAngle == 360.0f;
                    if (CircleProgressButton.this.isEnd) {
                        if (CircleProgressButton.this.mCircleProcessListener != null) {
                            CircleProgressButton.this.mCircleProcessListener.onFinished(CircleProgressButton.this.sweepAngle);
                        }
                        CircleProgressButton.this.mLongPressedHandler.sendEmptyMessage(1);
                        return;
                    } else {
                        CircleProgressButton.this.sweepAngle += CircleProgressButton.this.everyIntervalAngle;
                        CircleProgressButton.this.invalidate();
                        sendEmptyMessageDelayed(0, 1L);
                        return;
                    }
                }
                if (i == 1) {
                    CircleProgressButton circleProgressButton2 = CircleProgressButton.this;
                    circleProgressButton2.isEndOk = circleProgressButton2.sweepAngle == 0.0f;
                    if (CircleProgressButton.this.isEndOk) {
                        if (CircleProgressButton.this.mCircleProcessListener != null) {
                            CircleProgressButton.this.mCircleProcessListener.onCancelOk();
                        }
                        removeMessages(1);
                        return;
                    } else {
                        CircleProgressButton.this.sweepAngle -= CircleProgressButton.this.everyIntervalAngle;
                        CircleProgressButton.this.invalidate();
                        sendEmptyMessageDelayed(1, 1L);
                        return;
                    }
                }
                if (i == 2) {
                    CircleProgressButton circleProgressButton3 = CircleProgressButton.this;
                    circleProgressButton3.isPressedOk = circleProgressButton3.mBouncedWidth - CircleProgressButton.this.mAnimatedWidth <= 0.0f;
                    if (CircleProgressButton.this.isPressedOk) {
                        removeMessages(2);
                        return;
                    }
                    CircleProgressButton circleProgressButton4 = CircleProgressButton.this;
                    circleProgressButton4.mAnimatedWidth = (float) (((double) circleProgressButton4.mAnimatedWidth) + 0.5d);
                    CircleProgressButton.this.invalidate();
                    sendEmptyMessageDelayed(2, 1L);
                    return;
                }
                if (i != 3) {
                    return;
                }
                CircleProgressButton circleProgressButton5 = CircleProgressButton.this;
                circleProgressButton5.ifPressedBackOk = circleProgressButton5.mAnimatedWidth <= 0.0f;
                if (CircleProgressButton.this.ifPressedBackOk) {
                    removeMessages(3);
                    return;
                }
                CircleProgressButton circleProgressButton6 = CircleProgressButton.this;
                circleProgressButton6.mAnimatedWidth = (float) (((double) circleProgressButton6.mAnimatedWidth) - 0.5d);
                CircleProgressButton.this.invalidate();
                sendEmptyMessageDelayed(3, 1L);
            }
        };
        this.mContext = context;
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attrs, R.styleable.CircleProgressButton);
        this.mCircleColor = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleProgressButton_circleColor, -1);
        this.mProgressColor = typedArrayObtainStyledAttributes.getColor(R.styleable.CircleProgressButton_progressColor, -16776961);
        this.mProgressWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.CircleProgressButton_progressWidth, jj8.b(1.0f, this.mContext));
        typedArrayObtainStyledAttributes.recycle();
        init();
    }
}
