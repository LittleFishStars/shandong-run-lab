package com.kwad.components.core.page.recycle;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class b extends g {
    private Rect aeQ;
    private int aeR;
    private int aeS;
    private boolean aeT;
    private int aeU;
    private a aeV;
    private boolean aeW;
    private boolean aeX;

    public interface a {
        boolean uJ();
    }

    public b(Context context) {
        this(context, null);
    }

    private void a(int i, int i2, int i3) {
        while (true) {
            if (this.aeU == Integer.MIN_VALUE) {
                int[] iArr = new int[2];
                getLocationOnScreen(iArr);
                this.aeU = iArr[1];
            }
            int iFindFirstVisibleItemPosition = f.b(this).findFirstVisibleItemPosition();
            int iFindLastVisibleItemPosition = f.b(this).findLastVisibleItemPosition();
            if (iFindFirstVisibleItemPosition == -1 || iFindLastVisibleItemPosition == -1) {
                return;
            }
            if (i >= iFindFirstVisibleItemPosition && i <= iFindLastVisibleItemPosition) {
                int i4 = i - iFindFirstVisibleItemPosition;
                if (getChildCount() > i4) {
                    int[] iArr2 = new int[2];
                    getChildAt(i4).getLocationOnScreen(iArr2);
                    scrollBy(0, (iArr2[1] - this.aeU) - i3);
                    return;
                }
                return;
            }
            if (i > iFindLastVisibleItemPosition) {
                scrollBy(0, i2);
                a(i, i2, i3);
                return;
            }
            scrollBy(0, -i2);
        }
    }

    private void scrollToPositionWithOffset(int i, int i2) {
        a(i, getHeight(), 0);
    }

    private void uH() {
        Rect rect = this.aeQ;
        if (rect == null) {
            this.aeQ = new Rect();
        } else {
            rect.setEmpty();
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt.getVisibility() == 0) {
                this.aeQ.union(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom());
            }
        }
    }

    private void uI() {
        RecyclerView.Adapter adapter = getAdapter();
        if (adapter instanceof d) {
            ((d) adapter).uM();
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        uI();
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onDraw(Canvas canvas) {
        if (this.aeR != 0) {
            uH();
            Rect rect = this.aeQ;
            if (rect != null && !rect.isEmpty()) {
                canvas.save();
                canvas.clipRect(this.aeQ);
                canvas.drawColor(this.aeR);
                canvas.restore();
            }
        }
        super.onDraw(canvas);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.aeW) {
            return false;
        }
        if (motionEvent.getAction() == 0 && this.aeX) {
            stopScroll();
        }
        a aVar = this.aeV;
        if (aVar == null || !aVar.uJ()) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i2);
        int i3 = this.aeS;
        if (i3 > 0 && i3 < size) {
            i2 = View.MeasureSpec.makeMeasureSpec(this.aeS, View.MeasureSpec.getMode(i2));
        }
        super.onMeasure(i, i2);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    @SuppressLint({"ClickableViewAccessibility"})
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.aeW) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // androidx.recyclerview.widget.RecyclerView
    public void scrollToPosition(int i) {
        if (this.aeT) {
            scrollToPositionWithOffset(i, 0);
        } else {
            super.scrollToPosition(i);
        }
    }

    public void setDisableScroll(boolean z) {
        this.aeW = z;
    }

    public void setDownStop(boolean z) {
        this.aeX = z;
    }

    public void setIgnoreTouchSwipeHandler(a aVar) {
        this.aeV = aVar;
    }

    public void setUnderneathColor(int i) {
        this.aeR = i;
        uH();
        invalidate();
    }

    public void setUseCustomScrollToPosition(boolean z) {
        this.aeT = z;
    }

    public b(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public b(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.aeU = Integer.MIN_VALUE;
        this.aeX = false;
    }
}
