package cj.mobile.wm.common.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class SwipeFrameLayout extends FrameLayout {
    public SwipeCallback swipeCallback;

    public interface SwipeCallback {
        void swipe(MotionEvent motionEvent);
    }

    public SwipeFrameLayout(@NonNull Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        SwipeCallback swipeCallback = this.swipeCallback;
        if (swipeCallback != null) {
            swipeCallback.swipe(motionEvent);
        }
        return super.onInterceptTouchEvent(motionEvent);
    }

    public void setSwipeCallback(SwipeCallback swipeCallback) {
        this.swipeCallback = swipeCallback;
    }

    public SwipeFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SwipeFrameLayout(@NonNull Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
