package com.huachenjie.common.widget.xScrollView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.widget.NestedScrollView;
import androidx.dynamicanimation.animation.DynamicAnimation;
import androidx.dynamicanimation.animation.SpringAnimation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public abstract class XNestedScrollView extends NestedScrollView implements NestedScrollView.OnScrollChangeListener {
    public static final String TAG = "XNestedScrollView";
    private ScrollChangeListener scrollChangeListener;
    private SpringAnimation springAnim;
    private float startDragY;
    private int topMargin;
    protected boolean useSpringAnimation;

    public interface ScrollChangeListener {
        void scrollChange(int scrollY);
    }

    public XNestedScrollView(@NonNull Context context) {
        super(context, null);
        this.useSpringAnimation = true;
    }

    private void init() {
        setFillViewport(true);
        setNestedScrollingEnabled(false);
        setOnScrollChangeListener(this);
        SpringAnimation springAnimation = new SpringAnimation(this, DynamicAnimation.TRANSLATION_Y, 0.0f);
        this.springAnim = springAnimation;
        springAnimation.getSpring().setStiffness(1000.0f);
        this.springAnim.getSpring().setDampingRatio(2.0f);
    }

    private void springBack() {
        if (getTranslationY() != 0.0f && this.useSpringAnimation) {
            this.springAnim.start();
        }
        this.startDragY = 0.0f;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        try {
            return super.onInterceptTouchEvent(ev);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
    public void onScrollChange(NestedScrollView v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
        ScrollChangeListener scrollChangeListener = this.scrollChangeListener;
        if (scrollChangeListener != null) {
            scrollChangeListener.scrollChange(scrollY);
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        sizeChanged();
    }

    /* JADX WARN: Code duplicated, block: B:38:0x00a1 A[Catch: Exception -> 0x00a9, TryCatch #0 {Exception -> 0x00a9, blocks: (B:3:0x0001, B:5:0x000c, B:7:0x0010, B:9:0x0014, B:16:0x0023, B:18:0x002c, B:20:0x0032, B:21:0x0038, B:23:0x0043, B:25:0x004f, B:26:0x005a, B:28:0x0060, B:30:0x0073, B:32:0x0079, B:33:0x007f, B:35:0x008a, B:37:0x0096, B:38:0x00a1, B:39:0x00a4), top: B:44:0x0001 }] */
    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        try {
            if (ev.getY() < this.topMargin) {
                springBack();
                return false;
            }
            if (this.useSpringAnimation) {
                int action = ev.getAction();
                if (action == 1) {
                    springBack();
                } else if (action != 2) {
                    if (action == 3) {
                        springBack();
                    }
                } else if (getScrollY() <= 0) {
                    if (this.startDragY == 0.0f) {
                        this.startDragY = ev.getRawY();
                    }
                    if (ev.getRawY() - this.startDragY >= 0.0f) {
                        setTranslationY((ev.getRawY() - this.startDragY) / 3.0f);
                        return true;
                    }
                    this.startDragY = 0.0f;
                    this.springAnim.cancel();
                    setTranslationY(0.0f);
                } else if (getChildAt(0) != null && getScrollY() + getHeight() >= getChildAt(0).getMeasuredHeight()) {
                    if (this.startDragY == 0.0f) {
                        this.startDragY = ev.getRawY();
                    }
                    if (ev.getRawY() - this.startDragY <= 0.0f) {
                        setTranslationY((ev.getRawY() - this.startDragY) / 3.0f);
                        return true;
                    }
                    this.startDragY = 0.0f;
                    this.springAnim.cancel();
                    setTranslationY(0.0f);
                }
            }
            return super.onTouchEvent(ev);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public void scrollToBottom() {
        fullScroll(33);
    }

    public void setScrollChangeListener(ScrollChangeListener scrollChangeListener) {
        this.scrollChangeListener = scrollChangeListener;
    }

    public void setTopHeight(int height) {
        this.topMargin = height;
    }

    public abstract void sizeChanged();

    public XNestedScrollView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.useSpringAnimation = true;
        init();
    }
}
