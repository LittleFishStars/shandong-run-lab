package com.kwad.sdk.lib.ad.desigin;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;
import androidx.annotation.Keep;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.annotation.VisibleForTesting;
import androidx.core.math.MathUtils;
import androidx.core.util.ObjectsCompat;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.customview.view.AbsSavedState;
import com.kwad.sdk.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
@KSCoordinatorLayout.a(a.class)
public class KSAppBarLayout extends LinearLayout {
    private static final int INVALID_SCROLL_RANGE = -1;
    static final int PENDING_ACTION_ANIMATE_ENABLED = 4;
    static final int PENDING_ACTION_COLLAPSED = 2;
    static final int PENDING_ACTION_EXPANDED = 1;
    static final int PENDING_ACTION_FORCE = 8;
    static final int PENDING_ACTION_NONE = 0;
    private boolean mCollapsed;
    private boolean mCollapsible;
    private int mDownPreScrollRange;
    private int mDownScrollRange;
    private boolean mHaveChildWithInterpolator;
    private WindowInsetsCompat mLastInsets;
    private List<c> mListeners;
    private int mPendingAction;
    private int[] mTmpStatesArray;
    private int mTotalScrollRange;

    public static class a extends KSHeaderBehavior<KSAppBarLayout> {
        private static final int INVALID_POSITION = -1;
        private static final int MAX_OFFSET_ANIMATION_DURATION = 600;
        private WeakReference<View> mLastNestedScrollingChildRef;
        private ValueAnimator mOffsetAnimator;
        private int mOffsetDelta;
        private int mOffsetToChildIndexOnLayout;
        private boolean mOffsetToChildIndexOnLayoutIsMinHeight;
        private float mOffsetToChildIndexOnLayoutPerc;
        private AbstractC1300a mOnDragCallback;

        /* JADX INFO: renamed from: com.kwad.sdk.lib.ad.desigin.KSAppBarLayout$a$a, reason: collision with other inner class name */
        public static abstract class AbstractC1300a {
            public abstract boolean RE();
        }

        public a() {
            this.mOffsetToChildIndexOnLayout = -1;
        }

        private void animateOffsetTo(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, float f) {
            int iAbs = Math.abs(getTopBottomOffsetForScrollingSibling() - i);
            float fAbs = Math.abs(f);
            animateOffsetWithDuration(kSCoordinatorLayout, kSAppBarLayout, i, fAbs > 0.0f ? Math.round((iAbs / fAbs) * 1000.0f) * 3 : (int) (((iAbs / kSAppBarLayout.getHeight()) + 1.0f) * 150.0f));
        }

        private void animateOffsetWithDuration(final KSCoordinatorLayout kSCoordinatorLayout, final KSAppBarLayout kSAppBarLayout, int i, int i2) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            if (topBottomOffsetForScrollingSibling == i) {
                ValueAnimator valueAnimator = this.mOffsetAnimator;
                if (valueAnimator == null || !valueAnimator.isRunning()) {
                    return;
                }
                this.mOffsetAnimator.cancel();
                return;
            }
            ValueAnimator valueAnimator2 = this.mOffsetAnimator;
            if (valueAnimator2 == null) {
                ValueAnimator valueAnimator3 = new ValueAnimator();
                this.mOffsetAnimator = valueAnimator3;
                valueAnimator3.setInterpolator(KSAnimationUtils.DECELERATE_INTERPOLATOR);
                this.mOffsetAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.kwad.sdk.lib.ad.desigin.KSAppBarLayout.a.1
                    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                    public final void onAnimationUpdate(ValueAnimator valueAnimator4) {
                        a.this.setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, ((Integer) valueAnimator4.getAnimatedValue()).intValue());
                    }
                });
            } else {
                valueAnimator2.cancel();
            }
            this.mOffsetAnimator.setDuration(Math.min(i2, 600));
            this.mOffsetAnimator.setIntValues(topBottomOffsetForScrollingSibling, i);
            this.mOffsetAnimator.start();
        }

        private static boolean checkFlag(int i, int i2) {
            return (i & i2) == i2;
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

        private int getChildIndexOnOffset(KSAppBarLayout kSAppBarLayout, int i) {
            int childCount = kSAppBarLayout.getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = kSAppBarLayout.getChildAt(i2);
                int i3 = -i;
                if (childAt.getTop() <= i3 && childAt.getBottom() >= i3) {
                    return i2;
                }
            }
            return -1;
        }

        private int interpolateOffset(KSAppBarLayout kSAppBarLayout, int i) {
            int iAbs = Math.abs(i);
            int childCount = kSAppBarLayout.getChildCount();
            int topInset = 0;
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = kSAppBarLayout.getChildAt(i2);
                b bVar = (b) childAt.getLayoutParams();
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

        private boolean shouldJumpElevationState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
            List<View> dependents = kSCoordinatorLayout.getDependents(kSAppBarLayout);
            int size = dependents.size();
            for (int i = 0; i < size; i++) {
                KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) dependents.get(i).getLayoutParams()).getBehavior();
                if (behavior instanceof d) {
                    return ((d) behavior).getOverlayTop() != 0;
                }
            }
            return false;
        }

        private void snapToChildIfNeeded(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int childIndexOnOffset = getChildIndexOnOffset(kSAppBarLayout, topBottomOffsetForScrollingSibling);
            if (childIndexOnOffset >= 0) {
                View childAt = kSAppBarLayout.getChildAt(childIndexOnOffset);
                int iRF = ((b) childAt.getLayoutParams()).RF();
                if ((iRF & 17) == 17) {
                    int i = -childAt.getTop();
                    int minimumHeight = -childAt.getBottom();
                    if (childIndexOnOffset == kSAppBarLayout.getChildCount() - 1) {
                        minimumHeight += kSAppBarLayout.getTopInset();
                    }
                    if (checkFlag(iRF, 2)) {
                        minimumHeight += ViewCompat.getMinimumHeight(childAt);
                    } else if (checkFlag(iRF, 5)) {
                        int minimumHeight2 = ViewCompat.getMinimumHeight(childAt) + minimumHeight;
                        if (topBottomOffsetForScrollingSibling < minimumHeight2) {
                            i = minimumHeight2;
                        } else {
                            minimumHeight = minimumHeight2;
                        }
                    }
                    if (topBottomOffsetForScrollingSibling < (minimumHeight + i) / 2) {
                        i = minimumHeight;
                    }
                    animateOffsetTo(kSCoordinatorLayout, kSAppBarLayout, MathUtils.clamp(i, -kSAppBarLayout.getTotalScrollRange(), 0), 0.0f);
                }
            }
        }

        private void updateAppBarLayoutDrawableState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, boolean z) {
            View appBarChildOnOffset = getAppBarChildOnOffset(kSAppBarLayout, i);
            if (appBarChildOnOffset != null) {
                int iRF = ((b) appBarChildOnOffset.getLayoutParams()).RF();
                boolean z2 = false;
                if ((iRF & 1) != 0) {
                    int minimumHeight = ViewCompat.getMinimumHeight(appBarChildOnOffset);
                    if (i2 <= 0 || (iRF & 12) == 0 ? !((iRF & 2) == 0 || (-i) < (appBarChildOnOffset.getBottom() - minimumHeight) - kSAppBarLayout.getTopInset()) : (-i) >= (appBarChildOnOffset.getBottom() - minimumHeight) - kSAppBarLayout.getTopInset()) {
                        z2 = true;
                    }
                }
                boolean collapsedState = kSAppBarLayout.setCollapsedState(z2);
                if (z || (collapsedState && shouldJumpElevationState(kSCoordinatorLayout, kSAppBarLayout))) {
                    kSAppBarLayout.jumpDrawablesToCurrentState();
                }
            }
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSHeaderBehavior
        public int getTopBottomOffsetForScrollingSibling() {
            return getTopAndBottomOffset() + this.mOffsetDelta;
        }

        @VisibleForTesting
        public boolean isOffsetAnimatorRunning() {
            ValueAnimator valueAnimator = this.mOffsetAnimator;
            return valueAnimator != null && valueAnimator.isRunning();
        }

        public void setDragCallback(@Nullable AbstractC1300a abstractC1300a) {
            this.mOnDragCallback = abstractC1300a;
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSHeaderBehavior
        public boolean canDragView(KSAppBarLayout kSAppBarLayout) {
            AbstractC1300a abstractC1300a = this.mOnDragCallback;
            if (abstractC1300a != null) {
                return abstractC1300a.RE();
            }
            WeakReference<View> weakReference = this.mLastNestedScrollingChildRef;
            if (weakReference == null) {
                return true;
            }
            View view = weakReference.get();
            return (view == null || !view.isShown() || view.canScrollVertically(-1)) ? false : true;
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSHeaderBehavior
        public int getMaxDragOffset(KSAppBarLayout kSAppBarLayout) {
            return -kSAppBarLayout.getDownNestedScrollRange();
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSHeaderBehavior
        public int getScrollRangeForDragFling(KSAppBarLayout kSAppBarLayout) {
            return kSAppBarLayout.getTotalScrollRange();
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSHeaderBehavior
        public void onFlingFinished(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
            snapToChildIfNeeded(kSCoordinatorLayout, kSAppBarLayout);
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSViewOffsetBehavior, com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
        public boolean onLayoutChild(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i) {
            boolean zOnLayoutChild = super.onLayoutChild(kSCoordinatorLayout, kSAppBarLayout, i);
            int pendingAction = kSAppBarLayout.getPendingAction();
            int i2 = this.mOffsetToChildIndexOnLayout;
            if (i2 >= 0 && (pendingAction & 8) == 0) {
                View childAt = kSAppBarLayout.getChildAt(i2);
                setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, (-childAt.getBottom()) + (this.mOffsetToChildIndexOnLayoutIsMinHeight ? ViewCompat.getMinimumHeight(childAt) + kSAppBarLayout.getTopInset() : Math.round(childAt.getHeight() * this.mOffsetToChildIndexOnLayoutPerc)));
            } else if (pendingAction != 0) {
                boolean z = (pendingAction & 4) != 0;
                if ((pendingAction & 2) != 0) {
                    int i3 = -kSAppBarLayout.getUpNestedPreScrollRange();
                    if (z) {
                        animateOffsetTo(kSCoordinatorLayout, kSAppBarLayout, i3, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, i3);
                    }
                } else if ((pendingAction & 1) != 0) {
                    if (z) {
                        animateOffsetTo(kSCoordinatorLayout, kSAppBarLayout, 0, 0.0f);
                    } else {
                        setHeaderTopBottomOffset(kSCoordinatorLayout, kSAppBarLayout, 0);
                    }
                }
            }
            kSAppBarLayout.resetPendingAction();
            this.mOffsetToChildIndexOnLayout = -1;
            setTopAndBottomOffset(MathUtils.clamp(getTopAndBottomOffset(), -kSAppBarLayout.getTotalScrollRange(), 0));
            updateAppBarLayoutDrawableState(kSCoordinatorLayout, kSAppBarLayout, getTopAndBottomOffset(), 0, true);
            kSAppBarLayout.dispatchOffsetUpdates(getTopAndBottomOffset());
            return zOnLayoutChild;
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
        public boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, int i3, int i4) {
            if (((ViewGroup.MarginLayoutParams) ((KSCoordinatorLayout.LayoutParams) kSAppBarLayout.getLayoutParams())).height != -2) {
                return super.onMeasureChild(kSCoordinatorLayout, kSAppBarLayout, i, i2, i3, i4);
            }
            kSCoordinatorLayout.onMeasureChild(kSAppBarLayout, i, i2, View.MeasureSpec.makeMeasureSpec(0, 0), i4);
            return true;
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
        public void onNestedPreScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i, int i2, int[] iArr, int i3) {
            int i4;
            int downNestedPreScrollRange;
            if (i2 != 0) {
                if (i2 < 0) {
                    i4 = -kSAppBarLayout.getTotalScrollRange();
                    downNestedPreScrollRange = kSAppBarLayout.getDownNestedPreScrollRange() + i4;
                } else {
                    i4 = -kSAppBarLayout.getUpNestedPreScrollRange();
                    downNestedPreScrollRange = 0;
                }
                int i5 = i4;
                int i6 = downNestedPreScrollRange;
                if (i5 != i6) {
                    iArr[1] = scroll(kSCoordinatorLayout, kSAppBarLayout, i2, i5, i6);
                }
            }
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
        public void onNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i, int i2, int i3, int i4, int i5) {
            if (i4 < 0) {
                scroll(kSCoordinatorLayout, kSAppBarLayout, i4, -kSAppBarLayout.getDownNestedScrollRange(), 0);
            }
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
        public void onRestoreInstanceState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, Parcelable parcelable) {
            if (!(parcelable instanceof b)) {
                super.onRestoreInstanceState(kSCoordinatorLayout, kSAppBarLayout, parcelable);
                this.mOffsetToChildIndexOnLayout = -1;
                return;
            }
            b bVar = (b) parcelable;
            super.onRestoreInstanceState(kSCoordinatorLayout, kSAppBarLayout, bVar.getSuperState());
            this.mOffsetToChildIndexOnLayout = bVar.bhL;
            this.mOffsetToChildIndexOnLayoutPerc = bVar.bhM;
            this.mOffsetToChildIndexOnLayoutIsMinHeight = bVar.bhN;
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
        public Parcelable onSaveInstanceState(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout) {
            Parcelable parcelableOnSaveInstanceState = super.onSaveInstanceState(kSCoordinatorLayout, kSAppBarLayout);
            int topAndBottomOffset = getTopAndBottomOffset();
            int childCount = kSAppBarLayout.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = kSAppBarLayout.getChildAt(i);
                int bottom = childAt.getBottom() + topAndBottomOffset;
                if (childAt.getTop() + topAndBottomOffset <= 0 && bottom >= 0) {
                    b bVar = new b(parcelableOnSaveInstanceState);
                    bVar.bhL = i;
                    bVar.bhN = bottom == ViewCompat.getMinimumHeight(childAt) + kSAppBarLayout.getTopInset();
                    bVar.bhM = bottom / childAt.getHeight();
                    return bVar;
                }
            }
            return parcelableOnSaveInstanceState;
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
        public boolean onStartNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, View view2, int i, int i2) {
            ValueAnimator valueAnimator;
            boolean z = (i & 2) != 0 && kSAppBarLayout.hasScrollableChildren() && kSCoordinatorLayout.getHeight() - view.getHeight() <= kSAppBarLayout.getHeight();
            if (z && (valueAnimator = this.mOffsetAnimator) != null) {
                valueAnimator.cancel();
            }
            this.mLastNestedScrollingChildRef = null;
            return z;
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
        public void onStopNestedScroll(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, View view, int i) {
            if (i == 0) {
                snapToChildIfNeeded(kSCoordinatorLayout, kSAppBarLayout);
            }
            this.mLastNestedScrollingChildRef = new WeakReference<>(view);
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSHeaderBehavior
        public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, KSAppBarLayout kSAppBarLayout, int i, int i2, int i3) {
            int topBottomOffsetForScrollingSibling = getTopBottomOffsetForScrollingSibling();
            int i4 = 0;
            if (i2 == 0 || topBottomOffsetForScrollingSibling < i2 || topBottomOffsetForScrollingSibling > i3) {
                this.mOffsetDelta = 0;
            } else {
                int iClamp = MathUtils.clamp(i, i2, i3);
                if (topBottomOffsetForScrollingSibling != iClamp) {
                    int iInterpolateOffset = kSAppBarLayout.hasChildWithInterpolator() ? interpolateOffset(kSAppBarLayout, iClamp) : iClamp;
                    boolean topAndBottomOffset = setTopAndBottomOffset(iInterpolateOffset);
                    i4 = topBottomOffsetForScrollingSibling - iClamp;
                    this.mOffsetDelta = iClamp - iInterpolateOffset;
                    if (!topAndBottomOffset && kSAppBarLayout.hasChildWithInterpolator()) {
                        kSCoordinatorLayout.dispatchDependentViewsChanged(kSAppBarLayout);
                    }
                    kSAppBarLayout.dispatchOffsetUpdates(getTopAndBottomOffset());
                    updateAppBarLayoutDrawableState(kSCoordinatorLayout, kSAppBarLayout, iClamp, iClamp < topBottomOffsetForScrollingSibling ? -1 : 1, false);
                }
            }
            return i4;
        }

        public a(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.mOffsetToChildIndexOnLayout = -1;
        }

        public static class b extends AbsSavedState {
            public static final Parcelable.Creator<b> CREATOR = new Parcelable.ClassLoaderCreator<b>() { // from class: com.kwad.sdk.lib.ad.desigin.KSAppBarLayout.a.b.1
                private static b b(Parcel parcel, ClassLoader classLoader) {
                    return new b(parcel, classLoader);
                }

                private static b f(Parcel parcel) {
                    return new b(parcel, null);
                }

                private static b[] fd(int i) {
                    return new b[i];
                }

                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ Object createFromParcel(Parcel parcel) {
                    return f(parcel);
                }

                @Override // android.os.Parcelable.Creator
                public final /* synthetic */ Object[] newArray(int i) {
                    return fd(i);
                }

                @Override // android.os.Parcelable.ClassLoaderCreator
                public final /* synthetic */ b createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return b(parcel, classLoader);
                }
            };
            int bhL;
            float bhM;
            boolean bhN;

            public b(Parcel parcel, ClassLoader classLoader) {
                super(parcel, classLoader);
                this.bhL = parcel.readInt();
                this.bhM = parcel.readFloat();
                this.bhN = parcel.readByte() != 0;
            }

            @Override // androidx.customview.view.AbsSavedState, android.os.Parcelable
            public final void writeToParcel(Parcel parcel, int i) {
                super.writeToParcel(parcel, i);
                parcel.writeInt(this.bhL);
                parcel.writeFloat(this.bhM);
                parcel.writeByte(this.bhN ? (byte) 1 : (byte) 0);
            }

            public b(Parcelable parcelable) {
                super(parcelable);
            }
        }
    }

    public interface c {
    }

    public static class d extends KSHeaderScrollingViewBehavior {
        public d() {
        }

        private static int getAppBarLayoutOffset(KSAppBarLayout kSAppBarLayout) {
            KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) kSAppBarLayout.getLayoutParams()).getBehavior();
            if (behavior instanceof a) {
                return ((a) behavior).getTopBottomOffsetForScrollingSibling();
            }
            return 0;
        }

        private void offsetChildAsNeeded(KSCoordinatorLayout kSCoordinatorLayout, View view, View view2) {
            KSCoordinatorLayout.Behavior behavior = ((KSCoordinatorLayout.LayoutParams) view2.getLayoutParams()).getBehavior();
            if (behavior instanceof a) {
                ViewCompat.offsetTopAndBottom(view, (((view2.getBottom() - view.getTop()) + ((a) behavior).mOffsetDelta) + getVerticalLayoutGap()) - getOverlapPixelsForOffset(view2));
            }
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSHeaderScrollingViewBehavior
        public /* bridge */ /* synthetic */ View findFirstDependency(List list) {
            return findFirstDependency((List<View>) list);
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSHeaderScrollingViewBehavior
        public float getOverlapRatioForOffset(View view) {
            int i;
            if (view instanceof KSAppBarLayout) {
                KSAppBarLayout kSAppBarLayout = (KSAppBarLayout) view;
                int totalScrollRange = kSAppBarLayout.getTotalScrollRange();
                int downNestedPreScrollRange = kSAppBarLayout.getDownNestedPreScrollRange();
                int appBarLayoutOffset = getAppBarLayoutOffset(kSAppBarLayout);
                if ((downNestedPreScrollRange == 0 || totalScrollRange + appBarLayoutOffset > downNestedPreScrollRange) && (i = totalScrollRange - downNestedPreScrollRange) != 0) {
                    return (appBarLayoutOffset / i) + 1.0f;
                }
            }
            return 0.0f;
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSHeaderScrollingViewBehavior
        public int getScrollRange(View view) {
            return view instanceof KSAppBarLayout ? ((KSAppBarLayout) view).getTotalScrollRange() : super.getScrollRange(view);
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
        public boolean layoutDependsOn(KSCoordinatorLayout kSCoordinatorLayout, View view, View view2) {
            return view2 instanceof KSAppBarLayout;
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
        public boolean onDependentViewChanged(KSCoordinatorLayout kSCoordinatorLayout, View view, View view2) {
            offsetChildAsNeeded(kSCoordinatorLayout, view, view2);
            return false;
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSHeaderScrollingViewBehavior, com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
        public /* bridge */ /* synthetic */ boolean onMeasureChild(KSCoordinatorLayout kSCoordinatorLayout, View view, int i, int i2, int i3, int i4) {
            return super.onMeasureChild(kSCoordinatorLayout, view, i, i2, i3, i4);
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
        public boolean onRequestChildRectangleOnScreen(KSCoordinatorLayout kSCoordinatorLayout, View view, Rect rect, boolean z) {
            KSAppBarLayout kSAppBarLayoutFindFirstDependency = findFirstDependency(kSCoordinatorLayout.getDependencies(view));
            if (kSAppBarLayoutFindFirstDependency != null) {
                rect.offset(view.getLeft(), view.getTop());
                Rect rect2 = this.mTempRect1;
                rect2.set(0, 0, kSCoordinatorLayout.getWidth(), kSCoordinatorLayout.getHeight());
                if (!rect2.contains(rect)) {
                    kSAppBarLayoutFindFirstDependency.setExpanded(false, !z);
                    return true;
                }
            }
            return false;
        }

        public d(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_ScrollingViewBehavior_Layout);
            setOverlayTop(typedArrayObtainStyledAttributes.getDimensionPixelSize(R.styleable.ksad_ScrollingViewBehavior_Layout_ksad_behavior_overlapTop, 0));
            typedArrayObtainStyledAttributes.recycle();
        }

        @Override // com.kwad.sdk.lib.ad.desigin.KSHeaderScrollingViewBehavior
        public KSAppBarLayout findFirstDependency(List<View> list) {
            int size = list.size();
            for (int i = 0; i < size; i++) {
                View view = list.get(i);
                if (view instanceof KSAppBarLayout) {
                    return (KSAppBarLayout) view;
                }
            }
            return null;
        }
    }

    public KSAppBarLayout(Context context) {
        this(context, null);
    }

    private void invalidateScrollRanges() {
        this.mTotalScrollRange = -1;
        this.mDownPreScrollRange = -1;
        this.mDownScrollRange = -1;
    }

    private boolean setCollapsibleState(boolean z) {
        if (this.mCollapsible == z) {
            return false;
        }
        this.mCollapsible = z;
        refreshDrawableState();
        return true;
    }

    private void updateCollapsible() {
        int childCount = getChildCount();
        boolean z = false;
        for (int i = 0; i < childCount; i++) {
            if (((b) getChildAt(i).getLayoutParams()).RH()) {
                z = true;
                break;
            }
        }
        setCollapsibleState(z);
    }

    public void addOnOffsetChangedListener(c cVar) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList();
        }
        if (cVar == null || this.mListeners.contains(cVar)) {
            return;
        }
        this.mListeners.add(cVar);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof b;
    }

    public void dispatchOffsetUpdates(int i) {
        List<c> list = this.mListeners;
        if (list != null) {
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.mListeners.get(i2);
            }
        }
    }

    public int getDownNestedPreScrollRange() {
        int i = this.mDownPreScrollRange;
        if (i != -1) {
            return i;
        }
        int minimumHeight = 0;
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i2 = bVar.bhO;
            if ((i2 & 5) != 5) {
                if (minimumHeight > 0) {
                    break;
                }
            } else {
                int i3 = minimumHeight + ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin;
                minimumHeight = (i2 & 8) != 0 ? i3 + ViewCompat.getMinimumHeight(childAt) : i3 + (measuredHeight - ((i2 & 2) != 0 ? ViewCompat.getMinimumHeight(childAt) : getTopInset()));
            }
        }
        int iMax = Math.max(0, minimumHeight);
        this.mDownPreScrollRange = iMax;
        return iMax;
    }

    public int getDownNestedScrollRange() {
        int i = this.mDownScrollRange;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int minimumHeight = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight() + ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin;
            int i3 = bVar.bhO;
            if ((i3 & 1) == 0) {
                break;
            }
            minimumHeight += measuredHeight;
            if ((i3 & 2) != 0) {
                minimumHeight -= ViewCompat.getMinimumHeight(childAt) + getTopInset();
                break;
            }
        }
        int iMax = Math.max(0, minimumHeight);
        this.mDownScrollRange = iMax;
        return iMax;
    }

    public final int getMinimumHeightForVisibleOverlappingContent() {
        int topInset = getTopInset();
        int minimumHeight = ViewCompat.getMinimumHeight(this);
        if (minimumHeight == 0) {
            int childCount = getChildCount();
            minimumHeight = childCount > 0 ? ViewCompat.getMinimumHeight(getChildAt(childCount - 1)) : 0;
            if (minimumHeight == 0) {
                return getHeight() / 3;
            }
        }
        return (minimumHeight * 2) + topInset;
    }

    public int getPendingAction() {
        return this.mPendingAction;
    }

    @Deprecated
    public float getTargetElevation() {
        return 0.0f;
    }

    @VisibleForTesting
    public final int getTopInset() {
        WindowInsetsCompat windowInsetsCompat = this.mLastInsets;
        if (windowInsetsCompat != null) {
            return windowInsetsCompat.getSystemWindowInsetTop();
        }
        return 0;
    }

    public final int getTotalScrollRange() {
        int i = this.mTotalScrollRange;
        if (i != -1) {
            return i;
        }
        int childCount = getChildCount();
        int minimumHeight = 0;
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            b bVar = (b) childAt.getLayoutParams();
            int measuredHeight = childAt.getMeasuredHeight();
            int i3 = bVar.bhO;
            if ((i3 & 1) == 0) {
                break;
            }
            minimumHeight += measuredHeight + ((LinearLayout.LayoutParams) bVar).topMargin + ((LinearLayout.LayoutParams) bVar).bottomMargin;
            if ((i3 & 2) != 0) {
                minimumHeight -= ViewCompat.getMinimumHeight(childAt);
                break;
            }
        }
        int iMax = Math.max(0, minimumHeight - getTopInset());
        this.mTotalScrollRange = iMax;
        return iMax;
    }

    public int getUpNestedPreScrollRange() {
        return getTotalScrollRange();
    }

    public boolean hasChildWithInterpolator() {
        return this.mHaveChildWithInterpolator;
    }

    public boolean hasScrollableChildren() {
        return getTotalScrollRange() != 0;
    }

    @Override // android.view.ViewGroup, android.view.View
    public int[] onCreateDrawableState(int i) {
        if (this.mTmpStatesArray == null) {
            this.mTmpStatesArray = new int[2];
        }
        int[] iArr = this.mTmpStatesArray;
        int[] iArrOnCreateDrawableState = super.onCreateDrawableState(i + iArr.length);
        boolean z = this.mCollapsible;
        int i2 = R.attr.ksad_state_collapsible;
        if (!z) {
            i2 = -i2;
        }
        iArr[0] = i2;
        iArr[1] = (z && this.mCollapsed) ? R.attr.ksad_state_collapsed : -R.attr.ksad_state_collapsed;
        return View.mergeDrawableStates(iArrOnCreateDrawableState, iArr);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        invalidateScrollRanges();
        this.mHaveChildWithInterpolator = false;
        int childCount = getChildCount();
        for (int i5 = 0; i5 < childCount; i5++) {
            if (((b) getChildAt(i5).getLayoutParams()).RG() != null) {
                this.mHaveChildWithInterpolator = true;
                break;
            }
        }
        updateCollapsible();
    }

    @Override // android.widget.LinearLayout, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        invalidateScrollRanges();
    }

    public WindowInsetsCompat onWindowInsetChanged(WindowInsetsCompat windowInsetsCompat) {
        WindowInsetsCompat windowInsetsCompat2 = ViewCompat.getFitsSystemWindows(this) ? windowInsetsCompat : null;
        if (!ObjectsCompat.equals(this.mLastInsets, windowInsetsCompat2)) {
            this.mLastInsets = windowInsetsCompat2;
            invalidateScrollRanges();
        }
        return windowInsetsCompat;
    }

    public void removeOnOffsetChangedListener(c cVar) {
        List<c> list = this.mListeners;
        if (list == null || cVar == null) {
            return;
        }
        list.remove(cVar);
    }

    public void resetPendingAction() {
        this.mPendingAction = 0;
    }

    public boolean setCollapsedState(boolean z) {
        if (this.mCollapsed == z) {
            return false;
        }
        this.mCollapsed = z;
        refreshDrawableState();
        return true;
    }

    public void setExpanded(boolean z) {
        setExpanded(z, ViewCompat.isLaidOut(this));
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("AppBarLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    @Deprecated
    public void setTargetElevation(float f) {
        KSViewUtilsLollipop.setDefaultAppBarLayoutStateListAnimator(this, f);
    }

    public KSAppBarLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mTotalScrollRange = -1;
        this.mDownPreScrollRange = -1;
        this.mDownScrollRange = -1;
        this.mPendingAction = 0;
        setOrientation(1);
        KSViewUtilsLollipop.setBoundsViewOutlineProvider(this);
        int i = R.style.ksad_Widget_Design_KSAppBarLayout;
        KSViewUtilsLollipop.setStateListAnimatorFromAttrs(this, attributeSet, 0, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_AppBarLayout, 0, i);
        ViewCompat.setBackground(this, typedArrayObtainStyledAttributes.getDrawable(R.styleable.ksad_AppBarLayout_ksad_background));
        int i2 = R.styleable.ksad_AppBarLayout_ksad_expanded;
        if (typedArrayObtainStyledAttributes.hasValue(i2)) {
            setExpanded(typedArrayObtainStyledAttributes.getBoolean(i2, false), false, false);
        }
        int i3 = R.styleable.ksad_AppBarLayout_ksad_keyboardNavigationCluster;
        if (typedArrayObtainStyledAttributes.hasValue(i3)) {
            setKeyboardNavigationCluster(typedArrayObtainStyledAttributes.getBoolean(i3, false));
        }
        int i4 = R.styleable.ksad_AppBarLayout_ksad_touchscreenBlocksFocus;
        if (typedArrayObtainStyledAttributes.hasValue(i4)) {
            setTouchscreenBlocksFocus(typedArrayObtainStyledAttributes.getBoolean(i4, false));
        }
        typedArrayObtainStyledAttributes.recycle();
        ViewCompat.setOnApplyWindowInsetsListener(this, new OnApplyWindowInsetsListener() { // from class: com.kwad.sdk.lib.ad.desigin.KSAppBarLayout.1
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return KSAppBarLayout.this.onWindowInsetChanged(windowInsetsCompat);
            }
        });
    }

    public void setExpanded(boolean z, boolean z2) {
        setExpanded(z, z2, true);
    }

    private void setExpanded(boolean z, boolean z2, boolean z3) {
        this.mPendingAction = (z ? 1 : 2) | (z2 ? 4 : 0) | (z3 ? 8 : 0);
        requestLayout();
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public b generateDefaultLayoutParams() {
        return new b(-1, -2);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public b generateLayoutParams(AttributeSet attributeSet) {
        return new b(getContext(), attributeSet);
    }

    @Override // android.widget.LinearLayout, android.view.ViewGroup
    public b generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams instanceof LinearLayout.LayoutParams) {
            return new b((LinearLayout.LayoutParams) layoutParams);
        }
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            return new b((ViewGroup.MarginLayoutParams) layoutParams);
        }
        return new b(layoutParams);
    }

    public static class b extends LinearLayout.LayoutParams {
        int bhO;
        Interpolator bhP;

        public b(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.bhO = 1;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.ksad_AppBarLayout_Layout);
            this.bhO = typedArrayObtainStyledAttributes.getInt(R.styleable.ksad_AppBarLayout_Layout_ksad_layout_scrollFlags, 0);
            int i = R.styleable.ksad_AppBarLayout_Layout_ksad_layout_scrollInterpolator;
            if (typedArrayObtainStyledAttributes.hasValue(i)) {
                this.bhP = AnimationUtils.loadInterpolator(context, typedArrayObtainStyledAttributes.getResourceId(i, 0));
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public final int RF() {
            return this.bhO;
        }

        public final Interpolator RG() {
            return this.bhP;
        }

        public final boolean RH() {
            int i = this.bhO;
            return (i & 1) == 1 && (i & 10) != 0;
        }

        public b(int i, int i2) {
            super(-1, -2);
            this.bhO = 1;
        }

        public b(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
            this.bhO = 1;
        }

        public b(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
            this.bhO = 1;
        }

        @RequiresApi(19)
        public b(LinearLayout.LayoutParams layoutParams) {
            super(layoutParams);
            this.bhO = 1;
        }
    }
}
