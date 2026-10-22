package com.huachenjie.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.widget.NestedScrollView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
public class UnTouchNestedScrollView extends NestedScrollView {
    private String TAG;
    private int mScrollY;

    public UnTouchNestedScrollView(Context context) {
        super(context);
        this.TAG = UnTouchNestedScrollView.class.getSimpleName();
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent ev) {
        return super.dispatchTouchEvent(ev);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(View target, int dx, int dy, int[] consumed) {
        super.onNestedPreScroll(target, dx, dy, consumed);
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        this.mScrollY = t;
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent ev) {
        return false;
    }

    public UnTouchNestedScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.TAG = UnTouchNestedScrollView.class.getSimpleName();
    }

    public UnTouchNestedScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.TAG = UnTouchNestedScrollView.class.getSimpleName();
    }
}
