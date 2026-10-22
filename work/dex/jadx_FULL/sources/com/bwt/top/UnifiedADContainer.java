package com.bwt.top;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.bwt.top.util.ALog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class UnifiedADContainer extends FrameLayout {
    private String TAG;
    private int changeCount;

    public UnifiedADContainer(Context context) {
        this(context, null);
    }

    public UnifiedADContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public UnifiedADContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "UnifiedADContainer";
        this.changeCount = 0;
    }

    public final int getChangeCount() {
        ALog.d(this.TAG, "getChangeCount :" + this.changeCount);
        return this.changeCount;
    }

    public final boolean isRectVisible() {
        boolean globalVisibleRect = getGlobalVisibleRect(new Rect());
        ALog.d(this.TAG, "isRectVisible :" + globalVisibleRect);
        return globalVisibleRect;
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        ALog.d(this.TAG, "onAttachedToWindow");
        super.onAttachedToWindow();
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        ALog.d(this.TAG, "onDetachedFromWindow");
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void onWindowFocusChanged(boolean z) {
        ALog.d(this.TAG, "onWindowFocusChanged ：" + z);
        super.onWindowFocusChanged(z);
        if (z) {
            this.changeCount++;
        }
    }

    @Override // android.view.View
    public void onWindowVisibilityChanged(int i) {
        ALog.d(this.TAG, "onWindowVisibilityChanged visibility:" + i);
        super.onWindowVisibilityChanged(i);
        if (i == 0) {
            this.changeCount++;
        }
    }
}
