package com.fl.saas.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;
import com.fl.saas.common.util.ViewHelper;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class InterceptClickLayout extends FrameLayout {
    private int filterPattern;
    private boolean isMatchParent;
    private Set<View> mFilterViews;
    private OnIntercept mOutIntercept;

    @Retention(RetentionPolicy.SOURCE)
    public @interface FilterPattern {
        public static final int ALL = 1;
        public static final int FILTER = 2;
        public static final int NORMAL = 0;
    }

    public interface OnIntercept {
        boolean isIntercept(float f, float f2);
    }

    public InterceptClickLayout(Context context) {
        super(context);
        this.filterPattern = 0;
        this.isMatchParent = false;
    }

    public InterceptClickLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet, 0);
        this.filterPattern = 0;
        this.isMatchParent = false;
    }

    public InterceptClickLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.filterPattern = 0;
        this.isMatchParent = false;
    }

    public InterceptClickLayout addFilterViews(View... viewArr) {
        if (this.mFilterViews == null) {
            this.mFilterViews = new HashSet();
        }
        for (View view : viewArr) {
            if (view != null && !this.mFilterViews.contains(view) && ViewHelper.isViewInParent(this, view)) {
                this.mFilterViews.add(view);
            }
        }
        return this;
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int i = this.filterPattern;
        if (i == 1) {
            return true;
        }
        if (i != 2) {
            return super.onInterceptTouchEvent(motionEvent);
        }
        OnIntercept onIntercept = this.mOutIntercept;
        if (onIntercept != null && onIntercept.isIntercept(motionEvent.getRawX(), motionEvent.getRawY())) {
            return false;
        }
        Set<View> set = this.mFilterViews;
        if (set != null && !set.isEmpty()) {
            for (View view : this.mFilterViews) {
                if (view.getVisibility() == 0 && ViewHelper.isPointInsideView(view, motionEvent.getRawX(), motionEvent.getRawY())) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override // android.widget.FrameLayout, android.view.View
    public void onMeasure(int i, int i2) {
        if (!this.isMatchParent) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode != 1073741824) {
            i = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i), 1073741824);
        }
        if (mode2 != 1073741824) {
            i2 = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i2), 1073741824);
        }
        super.onMeasure(i, i2);
    }

    public InterceptClickLayout setFilterPattern(int i) {
        this.filterPattern = i;
        return this;
    }

    public void setMatchParent() {
        this.isMatchParent = true;
    }

    public InterceptClickLayout setOutIntercept(OnIntercept onIntercept) {
        this.mOutIntercept = onIntercept;
        return this;
    }
}
