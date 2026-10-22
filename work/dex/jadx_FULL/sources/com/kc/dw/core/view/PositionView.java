package com.kc.dw.core.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class PositionView extends View {
    private TouchAdContainer.OnWindownEventListener windownEventListener;

    @Keep
    public interface OnWindownEventListener {
        void onAttachedToWindow();

        void onDetachedFromWindow();

        void onWindowFocusChanged(boolean z);
    }

    public PositionView(Context context) {
        super(context);
    }

    public PositionView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public PositionView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.view.View
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        TouchAdContainer.OnWindownEventListener onWindownEventListener = this.windownEventListener;
        if (onWindownEventListener != null) {
            onWindownEventListener.onAttachedToWindow();
        }
    }

    @Override // android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        TouchAdContainer.OnWindownEventListener onWindownEventListener = this.windownEventListener;
        if (onWindownEventListener != null) {
            onWindownEventListener.onDetachedFromWindow();
        }
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        super.onWindowFocusChanged(z);
        TouchAdContainer.OnWindownEventListener onWindownEventListener = this.windownEventListener;
        if (onWindownEventListener != null) {
            onWindownEventListener.onWindowFocusChanged(z);
        }
    }

    public void setOnWindownEventListener(TouchAdContainer.OnWindownEventListener onWindownEventListener) {
        this.windownEventListener = onWindownEventListener;
    }
}
