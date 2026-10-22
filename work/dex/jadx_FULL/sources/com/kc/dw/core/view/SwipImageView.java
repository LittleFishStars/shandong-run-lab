package com.kc.dw.core.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ImageView;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SwipImageView extends ImageView {
    private static final String TAG = "SwipImageView";
    private Bitmap bitmap;
    private int clkType;
    private int distance;
    private float downloadX;
    private float downloadY;
    private float endMoveX;
    private float endMoveY;
    private OnSwipeListener mListener;
    private float maxMoveX;
    private float maxMoveY;

    @Keep
    public interface OnSwipeListener {
        void onSwipe(int i);
    }

    public SwipImageView(Context context) {
        super(context);
    }

    public SwipImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SwipImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* JADX WARN: Code duplicated, block: B:40:0x00aa A[PHI: r0 r6
      0x00aa: PHI (r0v7 int) = (r0v6 int), (r0v5 int) binds: [B:50:0x00d5, B:39:0x00a8] A[DONT_GENERATE, DONT_INLINE]
      0x00aa: PHI (r6v12 com.kc.dw.core.view.SwipImageView$OnSwipeListener) = (r6v11 com.kc.dw.core.view.SwipImageView$OnSwipeListener), (r6v19 com.kc.dw.core.view.SwipImageView$OnSwipeListener) binds: [B:50:0x00d5, B:39:0x00a8] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        OnSwipeListener onSwipeListener;
        int action = motionEvent.getAction();
        if (action == 0) {
            this.downloadX = motionEvent.getRawX();
            this.downloadY = motionEvent.getRawY();
            motionEvent.getX();
            motionEvent.getY();
        } else {
            if (action == 1) {
                if ((this.clkType & 2) == 2 && this.maxMoveY < 10.0f && this.maxMoveX < 10.0f && Math.abs(this.endMoveX) < 10.0f && Math.abs(this.endMoveY) < 10.0f) {
                    OnSwipeListener onSwipeListener2 = this.mListener;
                    if (onSwipeListener2 != null) {
                        onSwipeListener2.onSwipe(2);
                    }
                    return super.onTouchEvent(motionEvent);
                }
                int i = 32;
                if ((this.clkType & 32) != 32 || this.maxMoveY <= this.distance || Math.abs(this.endMoveX) / Math.abs(this.endMoveY) >= 1.0f) {
                    i = 128;
                    if ((this.clkType & 128) == 128 && this.maxMoveX > this.distance && Math.abs(this.endMoveX) / Math.abs(this.endMoveY) > 1.0f) {
                        onSwipeListener = this.mListener;
                        if (onSwipeListener != null) {
                            onSwipeListener.onSwipe(i);
                        }
                    }
                } else {
                    onSwipeListener = this.mListener;
                    if (onSwipeListener != null) {
                        onSwipeListener.onSwipe(i);
                    }
                }
                this.maxMoveX = 0.0f;
                this.maxMoveY = 0.0f;
                return true;
            }
            if (action == 2) {
                float rawX = motionEvent.getRawX();
                float rawY = motionEvent.getRawY();
                motionEvent.getX();
                motionEvent.getY();
                invalidate();
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
        this.distance = (getResources().getDisplayMetrics().widthPixels * i2) / 100;
    }

    public void setOnSwipeListener(OnSwipeListener onSwipeListener) {
        this.mListener = onSwipeListener;
    }
}
