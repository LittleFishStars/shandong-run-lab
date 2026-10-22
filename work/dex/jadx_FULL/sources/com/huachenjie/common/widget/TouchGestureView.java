package com.huachenjie.common.widget;

import android.content.Context;
import android.graphics.PointF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.huachenjie.base.widget.picker.OptionsPickerHelper;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class TouchGestureView extends ConstraintLayout {
    private static final int SCALE_DISALLOW = 2;
    private static final int SCALE_MOVE = 1;
    private static final int SCALE_NONE = 0;
    public static final int SCROLL_DISALLOW = 2;
    public static final int SCROLL_MOVE = 1;
    private static final int SCROLL_NONE = 0;
    public static final int SCROLL_TYPE_BOTTOM = 4;
    public static final int SCROLL_TYPE_LEFT = 1;
    private static final int SCROLL_TYPE_NONE = 0;
    public static final int SCROLL_TYPE_RIGHT = 2;
    public static final int SCROLL_TYPE_TOP = 3;
    private static final String TAG = "TouchGesture";
    private OnGestureChangeListener gestureChangeListener;
    private PointF mDownPoint;
    private float mDownScaleSpan;
    private boolean mHandledTouchEvent;
    private int mScaleStatus;
    private int mScrollStatus;
    private int mScrollType;
    protected int mTouchSlop;

    public static class OnGestureChangeListener {
        public void onScale(float scale) {
        }

        public void onScaleEnd() {
        }

        public boolean onScaleStart() {
            return false;
        }

        public void onScroll(int scrollStatus, PointF downPoint, MotionEvent touchEvent) {
        }

        public void onScrollEnd(int scrollStatus) {
        }

        public boolean onScrollStart(int scrollStatus, PointF downPoint) {
            return false;
        }
    }

    public TouchGestureView(@NonNull Context context) {
        super(context);
        this.mDownPoint = new PointF(0.0f, 0.0f);
        this.mScrollStatus = 0;
        this.mScrollType = 0;
        this.mScaleStatus = 0;
        this.mDownScaleSpan = 0.0f;
        this.mHandledTouchEvent = false;
        initView(context);
    }

    private float computeScale(MotionEvent currentEvent) {
        return Math.max(0.1f, Math.min(computeScaleSpan(currentEvent) / this.mDownScaleSpan, 5.0f));
    }

    private float computeScaleSpan(MotionEvent currentEvent) {
        if (currentEvent.getPointerCount() <= 1) {
            return 1.0f;
        }
        int iFindPointerIndex = currentEvent.findPointerIndex(currentEvent.getPointerId(0));
        float x = currentEvent.getX(iFindPointerIndex);
        float y = currentEvent.getY(iFindPointerIndex);
        int iFindPointerIndex2 = currentEvent.findPointerIndex(currentEvent.getPointerId(1));
        return (float) Math.sqrt(Math.pow(x - currentEvent.getX(iFindPointerIndex2), 2.0d) + Math.pow(y - currentEvent.getY(iFindPointerIndex2), 2.0d));
    }

    private int getScrollType(@NonNull PointF downPoint, @NonNull MotionEvent event) {
        float x = event.getX() - downPoint.x;
        float y = event.getY() - downPoint.y;
        if (Math.abs(x) > Math.abs(y)) {
            int i = this.mTouchSlop;
            if (x < (-i)) {
                return 1;
            }
            if (x > i) {
                return 2;
            }
        } else {
            int i2 = this.mTouchSlop;
            if (y < (-i2)) {
                return 3;
            }
            if (y > i2) {
                return 4;
            }
        }
        return 0;
    }

    private String getTouchEventName(MotionEvent event) {
        int action = event.getAction() & 255;
        if (action == 0) {
            return "按下";
        }
        if (action == 1) {
            return "抬起";
        }
        if (action == 2) {
            return "移动";
        }
        if (action == 3) {
            return OptionsPickerHelper.e;
        }
        if (action != 5) {
            return action != 6 ? "未知触摸事件" : "多指抬起";
        }
        return "多指按下";
    }

    private void initView(Context context) {
        this.mTouchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent event) {
        int action = event.getAction() & 255;
        if (action == 0) {
            this.mScaleStatus = 0;
            this.mScrollType = 0;
            this.mScrollStatus = 0;
            this.mDownPoint.set(event.getX(), event.getY());
            boolean zDispatchTouchEvent = super.dispatchTouchEvent(event);
            this.mHandledTouchEvent = zDispatchTouchEvent;
            return zDispatchTouchEvent;
        }
        boolean zDispatchTouchEvent2 = true;
        if (action == 5) {
            int i = this.mScaleStatus;
            if (i != 1) {
                if (i != 0) {
                    return false;
                }
                OnGestureChangeListener onGestureChangeListener = this.gestureChangeListener;
                if (onGestureChangeListener == null || !onGestureChangeListener.onScaleStart()) {
                    this.mScaleStatus = 2;
                    return false;
                }
                this.mScaleStatus = 1;
                this.mDownScaleSpan = computeScaleSpan(event);
            }
        } else if (action == 2) {
            if (this.mScaleStatus == 1) {
                OnGestureChangeListener onGestureChangeListener2 = this.gestureChangeListener;
                if (onGestureChangeListener2 != null) {
                    onGestureChangeListener2.onScale(computeScale(event));
                }
            } else {
                int i2 = this.mScrollStatus;
                if (i2 == 0) {
                    if (this.gestureChangeListener == null) {
                        this.mScrollStatus = 2;
                        return false;
                    }
                    int scrollType = getScrollType(this.mDownPoint, event);
                    this.mScrollType = scrollType;
                    if (scrollType == 0) {
                        return false;
                    }
                    boolean zOnScrollStart = this.gestureChangeListener.onScrollStart(scrollType, this.mDownPoint);
                    if (zOnScrollStart) {
                        this.mScrollStatus = 1;
                        return zOnScrollStart;
                    }
                    this.mScrollStatus = 2;
                    return zOnScrollStart;
                }
                if (i2 != 1) {
                    return super.dispatchTouchEvent(event);
                }
                OnGestureChangeListener onGestureChangeListener3 = this.gestureChangeListener;
                if (onGestureChangeListener3 != null) {
                    onGestureChangeListener3.onScroll(this.mScrollType, this.mDownPoint, event);
                }
            }
        } else {
            if (action != 1) {
                try {
                    return super.dispatchTouchEvent(event);
                } catch (Exception unused) {
                    return false;
                }
            }
            if (this.mScaleStatus == 1) {
                OnGestureChangeListener onGestureChangeListener4 = this.gestureChangeListener;
                if (onGestureChangeListener4 != null) {
                    onGestureChangeListener4.onScaleEnd();
                }
            } else if (this.mScrollStatus == 1) {
                OnGestureChangeListener onGestureChangeListener5 = this.gestureChangeListener;
                if (onGestureChangeListener5 != null) {
                    onGestureChangeListener5.onScrollEnd(this.mScrollType);
                }
            } else {
                zDispatchTouchEvent2 = this.mHandledTouchEvent ? super.dispatchTouchEvent(event) : false;
            }
            this.mScaleStatus = 0;
            this.mScrollType = 0;
            this.mScrollStatus = 0;
            this.mDownPoint.set(0.0f, 0.0f);
        }
        return zDispatchTouchEvent2;
    }

    public void setGestureListener(OnGestureChangeListener gestureChangeListener) {
        this.gestureChangeListener = gestureChangeListener;
    }

    public TouchGestureView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.mDownPoint = new PointF(0.0f, 0.0f);
        this.mScrollStatus = 0;
        this.mScrollType = 0;
        this.mScaleStatus = 0;
        this.mDownScaleSpan = 0.0f;
        this.mHandledTouchEvent = false;
        initView(context);
    }

    public TouchGestureView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.mDownPoint = new PointF(0.0f, 0.0f);
        this.mScrollStatus = 0;
        this.mScrollType = 0;
        this.mScaleStatus = 0;
        this.mDownScaleSpan = 0.0f;
        this.mHandledTouchEvent = false;
        initView(context);
    }
}
