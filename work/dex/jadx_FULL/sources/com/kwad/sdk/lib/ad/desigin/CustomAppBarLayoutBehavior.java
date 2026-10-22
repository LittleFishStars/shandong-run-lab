package com.kwad.sdk.lib.ad.desigin;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;
import com.kwad.sdk.R;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public class CustomAppBarLayoutBehavior extends KSAppBarLayout.a implements CustomAppBarCustomAttrListener, CustomAppBarFlingConsumer {
    private static final String TAG = CustomAppBarLayoutBehavior.class.toString();
    private CustomAppBarFlingConsumer mCustomAppBarFlingConsumer;
    private int mExtraFixedSize;
    private final int mFlingConsumeViewId;
    private CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> mHeaderExBehavior;
    private int mOffsetDelta;
    private int mScrollableSize;
    private boolean mScrollableSizeChangeable;

    public CustomAppBarLayoutBehavior(CustomAppBarBehaviorParams customAppBarBehaviorParams) {
        this.mScrollableSizeChangeable = true;
        this.mExtraFixedSize = customAppBarBehaviorParams.mExtraFixedSize;
        this.mFlingConsumeViewId = customAppBarBehaviorParams.mFlingConsumeViewId;
        if (customAppBarBehaviorParams.mEnableNestedFling) {
            CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> customHeaderBehaviorEx = new CustomHeaderBehaviorEx<>(this);
            this.mHeaderExBehavior = customHeaderBehaviorEx;
            customHeaderBehaviorEx.setExtraFixedSize(this.mExtraFixedSize);
        }
    }

    private void cancelTargetIfNeeded(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        if (i3 == 1 && iArr[1] == 0 && i2 < 0 && kSAppBarLayout.getTop() == 0) {
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, 0.0f, 0.0f, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
        }
    }

    private static View getAppBarChildOnOffset(KSAppBarLayout kSAppBarLayout, int i) {
        int iAbs = Math.abs(i);
        int childCount = kSAppBarLayout.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = kSAppBarLayout.getChildAt(i2);
            if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private boolean shouldJumpElevationState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
        List<View> dependents = kSCoordinatorLayout.getDependents(kSAppBarLayout);
        int size = dependents.size();
        for (int i = 0; i < size; i++) {
            KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) dependents.get(i).getLayoutParams()).getBehavior();
            if (behavior instanceof KSAppBarLayout.d) {
                return ((KSAppBarLayout.d) behavior).getOverlayTop() != 0;
            }
        }
        return false;
    }

    @Override // com.kwad.sdk.lib.ad.desigin.CustomAppBarFlingConsumer
    public void consumeAppBarFling(int i, int i2) {
        CustomAppBarFlingConsumer customAppBarFlingConsumer = this.mCustomAppBarFlingConsumer;
        if (customAppBarFlingConsumer != null) {
            customAppBarFlingConsumer.consumeAppBarFling(i, i2);
        }
    }

    @Override // com.kwad.sdk.lib.ad.desigin.CustomAppBarCustomAttrListener
    public int getExtraFixedSize() {
        return this.mExtraFixedSize;
    }

    public int getScrollRange(KSAppBarLayout kSAppBarLayout) {
        return kSAppBarLayout.getTotalScrollRange() - this.mExtraFixedSize;
    }

    public int getScrollableSize() {
        return this.mScrollableSize;
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSAppBarLayout.a, com.kwad.sdk.lib.ad.desigin.KSHeaderBehavior
    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset() + this.mOffsetDelta;
    }

    public int interpolateOffset(KSAppBarLayout kSAppBarLayout, int i) {
        int iAbs = Math.abs(i);
        int childCount = kSAppBarLayout.getChildCount();
        int topInset = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = kSAppBarLayout.getChildAt(i2);
            KSAppBarLayout.b bVar = (KSAppBarLayout.b) childAt.getLayoutParams();
            Interpolator interpolatorRG = bVar.RG();
            if (iAbs >= childAt.getTop() && iAbs <= childAt.getBottom()) {
                if (interpolatorRG == null) {
                    break;
                }
                int iRF = bVar.RF();
                if ((iRF & 1) != 0) {
                    topInset = 0 + childAt.getHeight() + ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin;
                    if ((iRF & 2) != 0) {
                        topInset -= ViewCompat.getMinimumHeight(childAt);
                    }
                }
                if (ViewCompat.getFitsSystemWindows(childAt)) {
                    topInset -= kSAppBarLayout.getTopInset();
                }
                if (topInset <= 0) {
                    break;
                }
                float f = topInset;
                return Integer.signum(i) * (childAt.getTop() + Math.round(f * interpolatorRG.getInterpolation((iAbs - childAt.getTop()) / f)));
            }
        }
        return i;
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSAppBarLayout.a
    public boolean isOffsetAnimatorRunning() {
        return false;
    }

    @Override // com.kwad.sdk.lib.ad.desigin.CustomAppBarFlingConsumer
    public void onAppBarTouchDown() {
        CustomAppBarFlingConsumer customAppBarFlingConsumer = this.mCustomAppBarFlingConsumer;
        if (customAppBarFlingConsumer != null) {
            customAppBarFlingConsumer.onAppBarTouchDown();
        }
    }

    public void setExtraFixedSize(int i) {
        this.mExtraFixedSize = i;
        CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> customHeaderBehaviorEx = this.mHeaderExBehavior;
        if (customHeaderBehaviorEx != null) {
            customHeaderBehaviorEx.setExtraFixedSize(i);
        }
    }

    public void setScrollableSize(int i) {
        this.mScrollableSize = i;
    }

    public void setScrollableSizeChangeable(boolean z) {
        this.mScrollableSizeChangeable = z;
    }

    public void stopFling() {
        CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> customHeaderBehaviorEx = this.mHeaderExBehavior;
        if (customHeaderBehaviorEx != null) {
            customHeaderBehaviorEx.stopFling();
        }
    }

    public void updateAppBarLayoutDrawableState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, boolean z) {
        View appBarChildOnOffset = getAppBarChildOnOffset(kSAppBarLayout, i);
        if (appBarChildOnOffset != null) {
            int iRF = ((KSAppBarLayout.b) appBarChildOnOffset.getLayoutParams()).RF();
            if ((iRF & 1) != 0) {
                ViewCompat.getMinimumHeight(appBarChildOnOffset);
                if ((i2 > 0 && (iRF & 12) != 0) || (iRF & 2) != 0) {
                    appBarChildOnOffset.getBottom();
                    kSAppBarLayout.getTopInset();
                }
            }
            if (z || shouldJumpElevationState(kSCoordinatorLayout, kSAppBarLayout)) {
                kSAppBarLayout.jumpDrawablesToCurrentState();
            }
        }
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSHeaderBehavior, com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, MotionEvent motionEvent) {
        CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> customHeaderBehaviorEx = this.mHeaderExBehavior;
        return customHeaderBehaviorEx == null ? super.onInterceptTouchEvent(kSCoordinatorLayout, kSAppBarLayout, motionEvent) : customHeaderBehaviorEx.onInterceptTouchEvent(kSCoordinatorLayout, kSAppBarLayout, motionEvent);
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSAppBarLayout.a, com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, int i3, int i4) {
        boolean zOnMeasureChild = super.onMeasureChild(kSCoordinatorLayout, kSAppBarLayout, i, i2, i3, i4);
        if (this.mCustomAppBarFlingConsumer == null) {
            KeyEvent.Callback callbackFindViewById = kSCoordinatorLayout.findViewById(this.mFlingConsumeViewId);
            if (!(callbackFindViewById instanceof CustomAppBarFlingConsumer)) {
                throw new IllegalArgumentException(String.format("find fling consume view with id %d is not instanceof HeaderFlingConsumer", Integer.valueOf(this.mFlingConsumeViewId)));
            }
            this.mCustomAppBarFlingConsumer = (CustomAppBarFlingConsumer) callbackFindViewById;
        }
        return zOnMeasureChild;
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSAppBarLayout.a, com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public void onNestedPreScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i, int i2, int[] iArr, int i3) {
        int i4;
        int downNestedPreScrollRange;
        cancelTargetIfNeeded(kSCoordinatorLayout, kSAppBarLayout, view, i, i2, iArr, i3);
        if (i2 != 0) {
            if (i2 < 0) {
                i4 = -getScrollRange(kSAppBarLayout);
                downNestedPreScrollRange = kSAppBarLayout.getDownNestedPreScrollRange() + i4;
            } else {
                i4 = -getScrollRange(kSAppBarLayout);
                downNestedPreScrollRange = 0;
            }
            int i5 = i4;
            int i6 = downNestedPreScrollRange;
            if (i5 != i6) {
                iArr[1] = scroll(kSCoordinatorLayout, kSAppBarLayout, i2, i5, i6);
            }
        }
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSAppBarLayout.a, com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public void onNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
        if (i4 < 0) {
            if (i5 == 1) {
                super.setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, getTopBottomOffsetForScrollingSibling() - i4, -kSAppBarLayout.getDownNestedScrollRange(), 0);
            } else {
                setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, getTopBottomOffsetForScrollingSibling() - i4, -kSAppBarLayout.getDownNestedScrollRange(), 0, i5);
            }
        }
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSHeaderBehavior, com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, MotionEvent motionEvent) {
        CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> customHeaderBehaviorEx = this.mHeaderExBehavior;
        return customHeaderBehaviorEx == null ? super.onTouchEvent(kSCoordinatorLayout, kSAppBarLayout, motionEvent) : customHeaderBehaviorEx.onTouchEvent(kSCoordinatorLayout, kSAppBarLayout, motionEvent);
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSHeaderBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSAppBarLayout.a, com.kwad.sdk.lib.ad.desigin.KSHeaderBehavior
    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i, i2, i3, -1);
    }

    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, int i3, int i4) {
        int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
        if (this.mScrollableSizeChangeable) {
            int scrollableSize = getScrollableSize();
            int i5 = i - topBottomOffsetForScrollingSibling;
            if (i5 <= 0) {
                if (scrollableSize <= 0) {
                    return -i5;
                }
                int i6 = scrollableSize + i;
                if (i6 <= 0) {
                    setTopAndBottomOffset(-scrollableSize);
                    return i6;
                }
            }
        }
        int i7 = 0;
        if (i2 != 0 && topBottomOffsetForScrollingSibling >= i2 && topBottomOffsetForScrollingSibling <= i3) {
            int iClamp = MathUtils.clamp(i, i2, i3);
            if (topBottomOffsetForScrollingSibling != iClamp) {
                int iInterpolateOffset = kSAppBarLayout.hasChildWithInterpolator() ? interpolateOffset(kSAppBarLayout, iClamp) : iClamp;
                boolean topAndBottomOffset = setTopAndBottomOffset(iInterpolateOffset);
                i7 = topBottomOffsetForScrollingSibling - iClamp;
                this.mOffsetDelta = iClamp - iInterpolateOffset;
                if (!topAndBottomOffset && kSAppBarLayout.hasChildWithInterpolator()) {
                    kSCoordinatorLayout.dispatchDependentViewsChanged(kSAppBarLayout);
                }
                kSAppBarLayout.dispatchOffsetUpdates(getTopAndBottomOffset());
                updateAppBarLayoutDrawableState(kSCoordinatorLayout, kSAppBarLayout, iClamp, iClamp < topBottomOffsetForScrollingSibling ? -1 : 1, false);
            }
        } else {
            this.mOffsetDelta = 0;
        }
        return i7;
    }

    public CustomAppBarLayoutBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollableSizeChangeable = true;
        int i = R.attr.ksad_headerFlingNested;
        int i2 = R.attr.ksad_extraFixedSize;
        int i3 = R.attr.ksad_flingConsumeViewId;
        int[] iArr = {i, i2, i3};
        Arrays.sort(iArr);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, iArr);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(Arrays.binarySearch(iArr, i), false);
        this.mExtraFixedSize = typedArrayObtainStyledAttributes.getDimensionPixelSize(Arrays.binarySearch(iArr, i2), 0);
        int resourceId = typedArrayObtainStyledAttributes.getResourceId(Arrays.binarySearch(iArr, i3), 0);
        typedArrayObtainStyledAttributes.recycle();
        if (resourceId != 0) {
            this.mFlingConsumeViewId = resourceId;
            if (z) {
                CustomHeaderBehaviorEx<KSAppBarLayout, CustomAppBarLayoutBehavior> customHeaderBehaviorEx = new CustomHeaderBehaviorEx<>(context, attributeSet, this);
                this.mHeaderExBehavior = customHeaderBehaviorEx;
                customHeaderBehaviorEx.setExtraFixedSize(this.mExtraFixedSize);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("should set head fling offset consume view , with 'flingConsumeViewId'");
    }
}
