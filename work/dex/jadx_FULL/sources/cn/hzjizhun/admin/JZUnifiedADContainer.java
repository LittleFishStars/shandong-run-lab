package cn.hzjizhun.admin;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import cn.hzjizhun.admin.util.ALog;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public final class JZUnifiedADContainer extends FrameLayout {
    private String TAG;
    private int changeCount;

    public JZUnifiedADContainer(Context context) {
        this(context, null);
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

    public JZUnifiedADContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public JZUnifiedADContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.TAG = "UnifiedADContainer";
        this.changeCount = 0;
    }
}
