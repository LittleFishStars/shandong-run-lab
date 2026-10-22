package com.kc.dw.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import com.kc.dw.core.utils.LogUtil;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class TouchAdContainer extends FrameLayout {
    private static final String TAG = "TouchAdContainer";
    private boolean interceptDownEvent;
    private TouchPositionListener touchPositionListener;
    private OnWindownEventListener windownEventListener;

    @Keep
    public interface OnWindownEventListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onWindowFocusChanged(boolean z);
    }

    public TouchAdContainer(Context context) {
        super(context);
        this.interceptDownEvent = false;
    }

    public TouchAdContainer(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.interceptDownEvent = false;
    }

    public TouchAdContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.interceptDownEvent = false;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        OnWindownEventListener onWindownEventListener = this.windownEventListener;
        if (onWindownEventListener != null) {
            onWindownEventListener.onAttachedToWindow();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        OnWindownEventListener onWindownEventListener = this.windownEventListener;
        if (onWindownEventListener != null) {
            onWindownEventListener.onDetachedFromWindow();
        }
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        TouchPositionListener touchPositionListener = this.touchPositionListener;
        if (touchPositionListener != null) {
            touchPositionListener.onTouch(this, motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnTouchEvent = super.onTouchEvent(motionEvent);
        if (zOnTouchEvent || !this.interceptDownEvent || motionEvent.getAction() != 0) {
            return zOnTouchEvent;
        }
        LogUtil.dev(TAG, "ide");
        return true;
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        OnWindownEventListener onWindownEventListener = this.windownEventListener;
        if (onWindownEventListener != null) {
            onWindownEventListener.onWindowFocusChanged(z);
        }
    }

    public void setInterceptDownEvent() {
        this.interceptDownEvent = true;
    }

    public void setOnWindownEventListener(OnWindownEventListener onWindownEventListener) {
        this.windownEventListener = onWindownEventListener;
    }

    public void setTouchPositionListener(TouchPositionListener touchPositionListener) {
        this.touchPositionListener = touchPositionListener;
    }
}
