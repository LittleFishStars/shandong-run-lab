package com.kwad.sdk.lib.ad.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.annotation.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class KSViewOffsetBehavior<V extends View> extends KSCoordinatorLayout.Behavior<V> {
    private int mTempLeftRightOffset;
    private int mTempTopBottomOffset;
    private KSViewOffsetHelper mViewOffsetHelper;

    public KSViewOffsetBehavior() {
        this.mTempTopBottomOffset = 0;
        this.mTempLeftRightOffset = 0;
    }

    public int getLeftAndRightOffset() {
        KSViewOffsetHelper kSViewOffsetHelper = this.mViewOffsetHelper;
        if (kSViewOffsetHelper != null) {
            return kSViewOffsetHelper.getLeftAndRightOffset();
        }
        return 0;
    }

    public int getTopAndBottomOffset() {
        KSViewOffsetHelper kSViewOffsetHelper = this.mViewOffsetHelper;
        if (kSViewOffsetHelper != null) {
            return kSViewOffsetHelper.getTopAndBottomOffset();
        }
        return 0;
    }

    public void layoutChild(KSCoordinatorLayout kSCoordinatorLayout, V v, int i) {
        kSCoordinatorLayout.onLayoutChild(v, i);
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public boolean onLayoutChild(KSCoordinatorLayout kSCoordinatorLayout, V v, int i) {
        layoutChild(kSCoordinatorLayout, v, i);
        if (this.mViewOffsetHelper == null) {
            this.mViewOffsetHelper = new KSViewOffsetHelper(v);
        }
        this.mViewOffsetHelper.onViewLayout();
        int i2 = this.mTempTopBottomOffset;
        if (i2 != 0) {
            this.mViewOffsetHelper.setTopAndBottomOffset(i2);
            this.mTempTopBottomOffset = 0;
        }
        int i3 = this.mTempLeftRightOffset;
        if (i3 == 0) {
            return true;
        }
        this.mViewOffsetHelper.setLeftAndRightOffset(i3);
        this.mTempLeftRightOffset = 0;
        return true;
    }

    public boolean setLeftAndRightOffset(int i) {
        KSViewOffsetHelper kSViewOffsetHelper = this.mViewOffsetHelper;
        if (kSViewOffsetHelper != null) {
            return kSViewOffsetHelper.setLeftAndRightOffset(i);
        }
        this.mTempLeftRightOffset = i;
        return false;
    }

    public boolean setTopAndBottomOffset(int i) {
        KSViewOffsetHelper kSViewOffsetHelper = this.mViewOffsetHelper;
        if (kSViewOffsetHelper != null) {
            return kSViewOffsetHelper.setTopAndBottomOffset(i);
        }
        this.mTempTopBottomOffset = i;
        return false;
    }

    public KSViewOffsetBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTempTopBottomOffset = 0;
        this.mTempLeftRightOffset = 0;
    }
}
