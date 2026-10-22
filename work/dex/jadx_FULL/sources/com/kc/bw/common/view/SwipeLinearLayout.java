package com.kc.bw.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SwipeLinearLayout extends LinearLayout {
    public final int click;
    public float downX;
    public float downY;
    public int interacType;
    public boolean isTouched;
    public OnSwipeListener listener;
    public final int mixClick;
    public final int swipe;

    @Keep
    public interface OnSwipeListener {
        void onClick(SwipeLinearLayout swipeLinearLayout);

        void onSwipe(SwipeLinearLayout swipeLinearLayout);
    }

    public SwipeLinearLayout(Context context) {
        super(context);
        this.swipe = 1;
        this.click = 2;
        this.mixClick = 3;
        this.interacType = 3;
        this.isTouched = false;
    }

    public SwipeLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.swipe = 1;
        this.click = 2;
        this.mixClick = 3;
        this.interacType = 3;
        this.isTouched = false;
    }

    public SwipeLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.swipe = 1;
        this.click = 2;
        this.mixClick = 3;
        this.interacType = 3;
        this.isTouched = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void dexa(View view) {
        OnSwipeListener onSwipeListener = this.listener;
        if (onSwipeListener != null) {
            onSwipeListener.onClick(this);
        }
    }

    public float getDownX() {
        return this.downX;
    }

    public float getDownY() {
        return this.downY;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.downX = motionEvent.getX();
            this.downY = motionEvent.getY();
            int i = this.interacType;
            if ((i == 1 || i == 3) && !this.isTouched) {
                this.isTouched = true;
                OnSwipeListener onSwipeListener = this.listener;
                if (onSwipeListener != null) {
                    onSwipeListener.onSwipe(this);
                }
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }

    public void setDownX(float f) {
        this.downX = f;
    }

    public void setDownY(float f) {
        this.downY = f;
    }

    public void setInteracType(int i) {
        this.interacType = i;
        if (i == 2) {
            setOnClickListener(new View.OnClickListener(this) { // from class: com.kc.bw.common.view.SwipeLinearLayout$$ExternalSyntheticLambda0
                public final SwipeLinearLayout f$0;

                {
                    this.f$0 = this;
                }

                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    this.f$0.dexa(view);
                }
            });
        }
    }

    public void setOnSwipeListener(OnSwipeListener onSwipeListener) {
        this.listener = onSwipeListener;
    }
}
