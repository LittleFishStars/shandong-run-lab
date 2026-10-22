package com.kc.dw.core.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SwipeView extends RelativeLayout {
    private static final String TAG = "SwipeView";
    private int clkType;
    private int distance;
    private float downloadX;
    private float downloadY;
    private float endMoveX;
    private float endMoveY;
    private boolean isMoved;
    private OnSwipeListener mListener;
    private Paint mPaint;
    private Path mPath;
    private float maxMoveX;
    private float maxMoveY;

    @Keep
    public interface OnSwipeListener {
        void onSwipe(int i);
    }

    public SwipeView(Context context) {
        this(context, null);
    }

    public SwipeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SwipeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    private int getCurPower(float f) {
        try {
            DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
            int i = displayMetrics.widthPixels;
            float f2 = i;
            float f3 = displayMetrics.density * 360.0f;
            if (f2 > f3) {
                i = (int) f3;
            }
            return (int) ((f * 100.0f) / i);
        } catch (Exception unused) {
            return -1;
        }
    }

    private void init() {
        this.mPaint = new Paint();
        this.mPath = new Path();
        this.mPaint.setColor(-1);
        this.mPaint.setAntiAlias(true);
        this.mPaint.setStyle(Paint.Style.STROKE);
        this.mPaint.setStrokeWidth(5.0f);
    }

    @Override // android.view.View
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnSwipeListener onSwipeListener;
        float fMax;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downloadX = motionEvent.getRawX();
            this.downloadY = motionEvent.getRawY();
            motionEvent.getX();
            motionEvent.getY();
        } else {
            if (action == 1) {
                if ((this.clkType & 2) == 2 && this.maxMoveX < 10.0f && this.maxMoveY < 10.0f && Math.abs(this.endMoveX) < 10.0f && Math.abs(this.endMoveY) < 10.0f) {
                    return false;
                }
                if ((this.clkType & 32) == 32 && this.maxMoveY > this.distance && this.endMoveY < 0.0f && Math.abs(this.endMoveX) / Math.abs(this.endMoveY) < 1.0f) {
                    onSwipeListener = this.mListener;
                    fMax = this.maxMoveY;
                } else if ((this.clkType & 128) == 128) {
                    Math.abs(this.endMoveX);
                    Math.abs(this.endMoveY);
                    if (Math.abs(this.endMoveX) > this.distance || Math.abs(this.endMoveY) > this.distance) {
                        onSwipeListener = this.mListener;
                        fMax = Math.max(Math.abs(this.endMoveX), Math.abs(this.endMoveY));
                    }
                }
                onSwipeListener.onSwipe(getCurPower(fMax));
                this.maxMoveX = 0.0f;
                this.maxMoveY = 0.0f;
                this.isMoved = true;
                return true;
            }
            if (action == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                motionEvent.getX();
                motionEvent.getY();
                float f = rawY - this.downloadY;
                if (f < 0.0f && this.maxMoveY < Math.abs(f)) {
                    this.maxMoveY = Math.abs(rawY - this.downloadY);
                }
                float f2 = this.maxMoveX;
                float f3 = rawX - this.downloadX;
                if (f2 < f3) {
                    this.maxMoveX = f3;
                }
                this.endMoveX = f3;
                this.endMoveY = rawY - this.downloadY;
            }
        }
        return true;
    }

    public void setMoveDistance(int i, int i2) {
        this.clkType = i;
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        int i3 = displayMetrics.widthPixels;
        float f = i3;
        float f2 = displayMetrics.density * 360.0f;
        if (f > f2) {
            i3 = (int) f2;
        }
        this.distance = (i3 * i2) / 100;
    }

    public void setOnSwipeListener(OnSwipeListener onSwipeListener) {
        this.mListener = onSwipeListener;
    }
}
