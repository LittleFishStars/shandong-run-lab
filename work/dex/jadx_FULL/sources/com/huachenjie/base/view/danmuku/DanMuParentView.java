package com.huachenjie.base.view.danmuku;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.RelativeLayout;
import com.huachenjie.base.view.danmuku.view.IDanMuParent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_03_8012cls.dex */
public class DanMuParentView extends RelativeLayout {
    public DanMuParentView(Context context) {
        super(context);
    }

    public void moveChildToBack(View child) {
        int iIndexOfChild = indexOfChild(child);
        if (iIndexOfChild > 0) {
            detachViewFromParent(iIndexOfChild);
            attachViewToParent(child, 0, child.getLayoutParams());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof IDanMuParent) {
                if (((IDanMuParent) childAt).hasCanTouchDanMus()) {
                    childAt.bringToFront();
                    childAt.getParent().requestDisallowInterceptTouchEvent(true);
                } else {
                    moveChildToBack(childAt);
                }
            }
        }
        return super.onInterceptTouchEvent(ev);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        return super.onTouchEvent(event);
    }

    public DanMuParentView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
}
