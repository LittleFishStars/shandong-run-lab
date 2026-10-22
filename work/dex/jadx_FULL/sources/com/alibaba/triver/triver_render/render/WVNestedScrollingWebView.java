package com.alibaba.triver.triver_render.render;

import android.content.Context;
import android.view.MotionEvent;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.NestedScrollingChild;
import androidx.core.view.NestedScrollingChildHelper;
import com.alibaba.ariver.app.api.Page;
import com.alibaba.ariver.kernel.common.utils.RVLogger;
import com.uc.webview.export.extension.UCExtension;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
public class WVNestedScrollingWebView extends WMLTRWebView implements NestedScrollingChild {
    public int f;
    public int g;
    private final int[] h;
    private final int[] i;
    private NestedScrollingChildHelper j;

    /* JADX WARN: Multi-variable type inference failed */
    public WVNestedScrollingWebView(Context context, Page page) {
        super(context, page);
        this.h = new int[2];
        this.i = new int[2];
        this.j = new NestedScrollingChildHelper(this);
        setNestedScrollingEnabled(true);
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.alibaba.triver.triver_render.render.WMLTRWebView, android.taobao.windvane.extra.uc.WVUCWebView
    public boolean coreDispatchTouchEvent(MotionEvent motionEvent) {
        UCExtension uCExtension = getUCExtension();
        if (uCExtension != null) {
            if (uCExtension.ignoreTouchEvent()) {
                requestDisallowInterceptTouchEvent(true);
            } else {
                requestDisallowInterceptTouchEvent(false);
            }
        }
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int actionMasked = MotionEventCompat.getActionMasked(motionEventObtain);
        if (actionMasked == 0) {
            this.g = 0;
        }
        int y = (int) motionEventObtain.getY();
        motionEventObtain.offsetLocation(0.0f, this.g);
        RVLogger.d("ypz", "coreDispatchTouchEvent: " + this.g + " " + this.f);
        if (actionMasked == 0) {
            boolean zCoreDispatchTouchEvent = super.coreDispatchTouchEvent(motionEventObtain);
            this.f = y;
            startNestedScroll(2);
            return zCoreDispatchTouchEvent;
        }
        if (actionMasked != 1) {
            if (actionMasked == 2) {
                int i = this.f - y;
                if (dispatchNestedPreScroll(0, i, this.i, this.h)) {
                    i -= this.i[1];
                    int i2 = this.h[1];
                    this.f = y - i2;
                    motionEventObtain.offsetLocation(0.0f, -i2);
                    this.g += this.h[1];
                }
                boolean zCoreDispatchTouchEvent2 = super.coreDispatchTouchEvent(motionEventObtain);
                int[] iArr = this.h;
                if (!dispatchNestedScroll(0, iArr[1], 0, i, iArr)) {
                    return zCoreDispatchTouchEvent2;
                }
                motionEventObtain.offsetLocation(0.0f, this.h[1]);
                this.g += this.h[1];
                return zCoreDispatchTouchEvent2;
            }
            if (actionMasked != 3) {
                return false;
            }
        }
        boolean zCoreDispatchTouchEvent3 = super.coreDispatchTouchEvent(motionEventObtain);
        stopNestedScroll();
        return zCoreDispatchTouchEvent3;
    }

    @Override // androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedFling(float f, float f2, boolean z) {
        return this.j.dispatchNestedFling(f, f2, z);
    }

    @Override // androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreFling(float f, float f2) {
        return this.j.dispatchNestedPreFling(f, f2);
    }

    @Override // androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.j.dispatchNestedPreScroll(i, i2, iArr, iArr2);
    }

    @Override // androidx.core.view.NestedScrollingChild
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.j.dispatchNestedScroll(i, i2, i3, i4, iArr);
    }

    @Override // androidx.core.view.NestedScrollingChild
    public boolean hasNestedScrollingParent() {
        return this.j.hasNestedScrollingParent();
    }

    @Override // androidx.core.view.NestedScrollingChild
    public boolean isNestedScrollingEnabled() {
        return this.j.isNestedScrollingEnabled();
    }

    @Override // androidx.core.view.NestedScrollingChild
    public void setNestedScrollingEnabled(boolean z) {
        this.j.setNestedScrollingEnabled(z);
    }

    @Override // androidx.core.view.NestedScrollingChild
    public boolean startNestedScroll(int i) {
        return this.j.startNestedScroll(i);
    }

    @Override // androidx.core.view.NestedScrollingChild
    public void stopNestedScroll() {
        this.j.stopNestedScroll();
    }
}
