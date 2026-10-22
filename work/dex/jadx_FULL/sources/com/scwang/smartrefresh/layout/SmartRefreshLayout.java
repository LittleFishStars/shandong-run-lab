package com.scwang.smartrefresh.layout;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Handler;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.ColorInt;
import androidx.annotation.ColorRes;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.core.view.NestedScrollingChildHelper;
import androidx.core.view.NestedScrollingParent;
import androidx.core.view.NestedScrollingParentHelper;
import com.scwang.smartrefresh.layout.api.DefaultRefreshFooterCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshHeaderCreator;
import com.scwang.smartrefresh.layout.api.DefaultRefreshInitializer;
import com.scwang.smartrefresh.layout.api.RefreshContent;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.scwang.smartrefresh.layout.api.RefreshInternal;
import com.scwang.smartrefresh.layout.api.RefreshKernel;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.api.ScrollBoundaryDecider;
import com.scwang.smartrefresh.layout.constant.RefreshState;
import com.scwang.smartrefresh.layout.footer.BallPulseFooter;
import com.scwang.smartrefresh.layout.header.BezierRadarHeader;
import com.scwang.smartrefresh.layout.impl.RefreshFooterWrapper;
import com.scwang.smartrefresh.layout.impl.RefreshHeaderWrapper;
import com.scwang.smartrefresh.layout.listener.OnLoadMoreListener;
import com.scwang.smartrefresh.layout.listener.OnMultiPurposeListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshLoadMoreListener;
import com.zj.adlib.qk8;
import com.zj.adlib.td7;
import com.zj.adlib.un2;
import com.zj.adlib.xm8;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
@SuppressLint({"RestrictedApi"})
public class SmartRefreshLayout extends ViewGroup implements RefreshLayout, NestedScrollingParent {
    protected static ViewGroup.MarginLayoutParams sDefaultMarginLP = new ViewGroup.MarginLayoutParams(-1, -1);
    protected static DefaultRefreshFooterCreator sFooterCreator;
    protected static DefaultRefreshHeaderCreator sHeaderCreator;
    protected static DefaultRefreshInitializer sRefreshInitializer;
    protected Runnable animationRunnable;
    protected boolean mAttachedToWindow;
    protected int mCurrentVelocity;
    protected boolean mDisableContentWhenLoading;
    protected boolean mDisableContentWhenRefresh;
    protected char mDragDirection;
    protected float mDragRate;
    protected boolean mEnableAutoLoadMore;
    protected boolean mEnableClipFooterWhenFixedBehind;
    protected boolean mEnableClipHeaderWhenFixedBehind;
    protected boolean mEnableDisallowIntercept;
    protected boolean mEnableFooterFollowWhenNoMoreData;
    protected boolean mEnableFooterTranslationContent;
    protected boolean mEnableHeaderTranslationContent;
    protected boolean mEnableLoadMore;
    protected boolean mEnableLoadMoreWhenContentNotFull;
    protected boolean mEnableNestedScrolling;
    protected boolean mEnableOverScrollBounce;
    protected boolean mEnableOverScrollDrag;
    protected boolean mEnablePreviewInEditMode;
    protected boolean mEnablePureScrollMode;
    protected boolean mEnableRefresh;
    protected boolean mEnableScrollContentWhenLoaded;
    protected boolean mEnableScrollContentWhenRefreshed;
    protected MotionEvent mFalsifyEvent;
    protected int mFixedFooterViewId;
    protected int mFixedHeaderViewId;
    protected int mFloorDuration;
    protected int mFooterBackgroundColor;
    protected int mFooterHeight;
    protected un2 mFooterHeightStatus;
    protected int mFooterInsetStart;
    protected boolean mFooterLocked;
    protected float mFooterMaxDragRate;
    protected boolean mFooterNeedTouchEventWhenLoading;
    protected boolean mFooterNoMoreData;
    protected boolean mFooterNoMoreDataEffective;
    protected int mFooterTranslationViewId;
    protected float mFooterTriggerRate;
    protected Handler mHandler;
    protected int mHeaderBackgroundColor;
    protected int mHeaderHeight;
    protected un2 mHeaderHeightStatus;
    protected int mHeaderInsetStart;
    protected float mHeaderMaxDragRate;
    protected boolean mHeaderNeedTouchEventWhenRefreshing;
    protected int mHeaderTranslationViewId;
    protected float mHeaderTriggerRate;
    protected boolean mIsBeingDragged;
    protected RefreshKernel mKernel;
    protected long mLastOpenTime;
    protected int mLastSpinner;
    protected float mLastTouchX;
    protected float mLastTouchY;
    protected OnLoadMoreListener mLoadMoreListener;
    protected boolean mManualFooterTranslationContent;
    protected boolean mManualHeaderTranslationContent;
    protected boolean mManualLoadMore;
    protected int mMaximumVelocity;
    protected int mMinimumVelocity;
    protected NestedScrollingChildHelper mNestedChild;
    protected boolean mNestedInProgress;
    protected NestedScrollingParentHelper mNestedParent;
    protected OnMultiPurposeListener mOnMultiPurposeListener;
    protected Paint mPaint;
    protected int[] mParentOffsetInWindow;
    protected int[] mPrimaryColors;
    protected int mReboundDuration;
    protected Interpolator mReboundInterpolator;
    protected RefreshContent mRefreshContent;
    protected RefreshInternal mRefreshFooter;
    protected RefreshInternal mRefreshHeader;
    protected OnRefreshListener mRefreshListener;
    protected int mScreenHeightPixels;
    protected ScrollBoundaryDecider mScrollBoundaryDecider;
    protected Scroller mScroller;
    protected int mSpinner;
    protected RefreshState mState;
    protected boolean mSuperDispatchTouchEvent;
    protected int mTotalUnconsumed;
    protected int mTouchSlop;
    protected int mTouchSpinner;
    protected float mTouchX;
    protected float mTouchY;
    protected VelocityTracker mVelocityTracker;
    protected boolean mVerticalPermit;
    protected RefreshState mViceState;
    protected ValueAnimator reboundAnimator;

    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f40396a;

        static {
            int[] iArr = new int[RefreshState.values().length];
            f40396a = iArr;
            try {
                iArr[RefreshState.None.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f40396a[RefreshState.PullDownToRefresh.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f40396a[RefreshState.PullUpToLoad.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f40396a[RefreshState.PullDownCanceled.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f40396a[RefreshState.PullUpCanceled.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f40396a[RefreshState.ReleaseToRefresh.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                f40396a[RefreshState.ReleaseToLoad.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                f40396a[RefreshState.ReleaseToTwoLevel.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                f40396a[RefreshState.RefreshReleased.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                f40396a[RefreshState.LoadReleased.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                f40396a[RefreshState.Refreshing.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                f40396a[RefreshState.Loading.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                f40396a[RefreshState.RefreshFinish.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                f40396a[RefreshState.LoadFinish.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                f40396a[RefreshState.TwoLevelReleased.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                f40396a[RefreshState.TwoLevelFinish.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                f40396a[RefreshState.TwoLevel.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f15122a;

        public b(boolean z) {
            this.f15122a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.setStateDirectLoading(this.f15122a);
        }
    }

    public class c extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f15123a;

        public c(boolean z) {
            this.f15123a = z;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            SmartRefreshLayout.this.mLastOpenTime = System.currentTimeMillis();
            SmartRefreshLayout.this.notifyStateChanged(RefreshState.Refreshing);
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            OnRefreshListener onRefreshListener = smartRefreshLayout.mRefreshListener;
            if (onRefreshListener != null) {
                if (this.f15123a) {
                    onRefreshListener.onRefresh(smartRefreshLayout);
                }
            } else if (smartRefreshLayout.mOnMultiPurposeListener == null) {
                smartRefreshLayout.finishRefresh(3000);
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            RefreshInternal refreshInternal = smartRefreshLayout2.mRefreshHeader;
            if (refreshInternal != null) {
                int i = smartRefreshLayout2.mHeaderHeight;
                refreshInternal.onStartAnimator(smartRefreshLayout2, i, (int) (smartRefreshLayout2.mHeaderMaxDragRate * i));
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            OnMultiPurposeListener onMultiPurposeListener = smartRefreshLayout3.mOnMultiPurposeListener;
            if (onMultiPurposeListener == null || !(smartRefreshLayout3.mRefreshHeader instanceof RefreshHeader)) {
                return;
            }
            if (this.f15123a) {
                onMultiPurposeListener.onRefresh(smartRefreshLayout3);
            }
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            OnMultiPurposeListener onMultiPurposeListener2 = smartRefreshLayout4.mOnMultiPurposeListener;
            RefreshHeader refreshHeader = (RefreshHeader) smartRefreshLayout4.mRefreshHeader;
            int i2 = smartRefreshLayout4.mHeaderHeight;
            onMultiPurposeListener2.e(refreshHeader, i2, (int) (smartRefreshLayout4.mHeaderMaxDragRate * i2));
        }
    }

    public class d extends AnimatorListenerAdapter {
        public d() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            RefreshState refreshState;
            RefreshState refreshState2;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            smartRefreshLayout.reboundAnimator = null;
            if (smartRefreshLayout.mSpinner == 0 && (refreshState = smartRefreshLayout.mState) != (refreshState2 = RefreshState.None) && !refreshState.isOpening && !refreshState.isDragging) {
                smartRefreshLayout.notifyStateChanged(refreshState2);
                return;
            }
            RefreshState refreshState3 = smartRefreshLayout.mState;
            if (refreshState3 != smartRefreshLayout.mViceState) {
                smartRefreshLayout.setViceState(refreshState3);
            }
        }
    }

    public class e implements ValueAnimator.AnimatorUpdateListener {
        public e() {
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public void onAnimationUpdate(ValueAnimator valueAnimator) {
            SmartRefreshLayout.this.mKernel.i(((Integer) valueAnimator.getAnimatedValue()).intValue(), false);
        }
    }

    public class f implements Runnable {
        public f() {
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            OnLoadMoreListener onLoadMoreListener = smartRefreshLayout.mLoadMoreListener;
            if (onLoadMoreListener != null) {
                onLoadMoreListener.onLoadMore(smartRefreshLayout);
            } else if (smartRefreshLayout.mOnMultiPurposeListener == null) {
                smartRefreshLayout.finishLoadMore(2000);
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            OnMultiPurposeListener onMultiPurposeListener = smartRefreshLayout2.mOnMultiPurposeListener;
            if (onMultiPurposeListener != null) {
                onMultiPurposeListener.onLoadMore(smartRefreshLayout2);
            }
        }
    }

    public class g implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ Boolean f15124a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f15125a;

        public g(Boolean bool, boolean z) {
            this.f15124a = bool;
            this.f15125a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            RefreshState refreshState = smartRefreshLayout.mState;
            RefreshState refreshState2 = RefreshState.Refreshing;
            if (refreshState != refreshState2 || smartRefreshLayout.mRefreshHeader == null || smartRefreshLayout.mRefreshContent == null) {
                RefreshState refreshState3 = RefreshState.None;
                if (refreshState == refreshState3 && smartRefreshLayout.mViceState == refreshState2) {
                    smartRefreshLayout.mViceState = refreshState3;
                    return;
                }
                ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
                if (valueAnimator == null || !refreshState.isHeader) {
                    return;
                }
                if (refreshState.isDragging || refreshState == RefreshState.RefreshReleased) {
                    smartRefreshLayout.reboundAnimator = null;
                    valueAnimator.cancel();
                    SmartRefreshLayout.this.mKernel.d(refreshState3);
                    return;
                }
                return;
            }
            Boolean bool = this.f15124a;
            if (bool != null) {
                smartRefreshLayout.setNoMoreData(bool == Boolean.TRUE);
            }
            SmartRefreshLayout.this.notifyStateChanged(RefreshState.RefreshFinish);
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            int iOnFinish = smartRefreshLayout2.mRefreshHeader.onFinish(smartRefreshLayout2, this.f15125a);
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            OnMultiPurposeListener onMultiPurposeListener = smartRefreshLayout3.mOnMultiPurposeListener;
            if (onMultiPurposeListener != null) {
                RefreshInternal refreshInternal = smartRefreshLayout3.mRefreshHeader;
                if (refreshInternal instanceof RefreshHeader) {
                    onMultiPurposeListener.a((RefreshHeader) refreshInternal, this.f15125a);
                }
            }
            if (iOnFinish < Integer.MAX_VALUE) {
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                if (smartRefreshLayout4.mIsBeingDragged || smartRefreshLayout4.mNestedInProgress) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (smartRefreshLayout5.mIsBeingDragged) {
                        float f = smartRefreshLayout5.mLastTouchY;
                        smartRefreshLayout5.mTouchY = f;
                        smartRefreshLayout5.mTouchSpinner = 0;
                        smartRefreshLayout5.mIsBeingDragged = false;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, smartRefreshLayout5.mLastTouchX, (f + smartRefreshLayout5.mSpinner) - (smartRefreshLayout5.mTouchSlop * 2), 0));
                        SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 2, smartRefreshLayout6.mLastTouchX, smartRefreshLayout6.mLastTouchY + smartRefreshLayout6.mSpinner, 0));
                    }
                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                    if (smartRefreshLayout7.mNestedInProgress) {
                        smartRefreshLayout7.mTotalUnconsumed = 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 1, smartRefreshLayout7.mLastTouchX, smartRefreshLayout7.mLastTouchY, 0));
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        smartRefreshLayout8.mNestedInProgress = false;
                        smartRefreshLayout8.mTouchSpinner = 0;
                    }
                }
                SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                int i = smartRefreshLayout9.mSpinner;
                if (i <= 0) {
                    if (i < 0) {
                        smartRefreshLayout9.animSpinner(0, iOnFinish, smartRefreshLayout9.mReboundInterpolator, smartRefreshLayout9.mReboundDuration);
                        return;
                    } else {
                        smartRefreshLayout9.mKernel.i(0, false);
                        SmartRefreshLayout.this.mKernel.d(RefreshState.None);
                        return;
                    }
                }
                ValueAnimator valueAnimatorAnimSpinner = smartRefreshLayout9.animSpinner(0, iOnFinish, smartRefreshLayout9.mReboundInterpolator, smartRefreshLayout9.mReboundDuration);
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                ValueAnimator.AnimatorUpdateListener animatorUpdateListenerJ = smartRefreshLayout10.mEnableScrollContentWhenRefreshed ? smartRefreshLayout10.mRefreshContent.j(smartRefreshLayout10.mSpinner) : null;
                if (valueAnimatorAnimSpinner == null || animatorUpdateListenerJ == null) {
                    return;
                }
                valueAnimatorAnimSpinner.addUpdateListener(animatorUpdateListenerJ);
            }
        }
    }

    public class h implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f15126a;
        public final /* synthetic */ boolean b;

        public class a implements Runnable {
            public final /* synthetic */ int K;

            /* JADX INFO: renamed from: com.scwang.smartrefresh.layout.SmartRefreshLayout$h$a$a, reason: collision with other inner class name */
            public class C1326a extends AnimatorListenerAdapter {
                public C1326a() {
                }

                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    h hVar = h.this;
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    smartRefreshLayout.mFooterLocked = false;
                    if (hVar.b) {
                        smartRefreshLayout.setNoMoreData(true);
                    }
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (smartRefreshLayout2.mState == RefreshState.LoadFinish) {
                        smartRefreshLayout2.notifyStateChanged(RefreshState.None);
                    }
                }
            }

            public a(int i) {
                this.K = i;
            }

            @Override // java.lang.Runnable
            public void run() {
                ValueAnimator valueAnimatorB;
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                ValueAnimator.AnimatorUpdateListener animatorUpdateListenerJ = (!smartRefreshLayout.mEnableScrollContentWhenLoaded || this.K >= 0) ? null : smartRefreshLayout.mRefreshContent.j(smartRefreshLayout.mSpinner);
                if (animatorUpdateListenerJ != null) {
                    animatorUpdateListenerJ.onAnimationUpdate(ValueAnimator.ofInt(0, 0));
                }
                C1326a c1326a = new C1326a();
                h hVar = h.this;
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                int i = smartRefreshLayout2.mSpinner;
                if (i > 0) {
                    valueAnimatorB = smartRefreshLayout2.mKernel.b(0);
                } else {
                    if (animatorUpdateListenerJ != null || i == 0) {
                        ValueAnimator valueAnimator = smartRefreshLayout2.reboundAnimator;
                        if (valueAnimator != null) {
                            valueAnimator.cancel();
                            SmartRefreshLayout.this.reboundAnimator = null;
                        }
                        SmartRefreshLayout.this.mKernel.i(0, false);
                        SmartRefreshLayout.this.mKernel.d(RefreshState.None);
                    } else if (hVar.b && smartRefreshLayout2.mEnableFooterFollowWhenNoMoreData) {
                        int i2 = smartRefreshLayout2.mFooterHeight;
                        if (i >= (-i2)) {
                            smartRefreshLayout2.notifyStateChanged(RefreshState.None);
                        } else {
                            valueAnimatorB = smartRefreshLayout2.mKernel.b(-i2);
                        }
                    } else {
                        valueAnimatorB = smartRefreshLayout2.mKernel.b(0);
                    }
                    valueAnimatorB = null;
                }
                if (valueAnimatorB != null) {
                    valueAnimatorB.addListener(c1326a);
                } else {
                    c1326a.onAnimationEnd(null);
                }
            }
        }

        public h(boolean z, boolean z2) {
            this.f15126a = z;
            this.b = z2;
        }

        /* JADX WARN: Code duplicated, block: B:24:0x0052  */
        @Override // java.lang.Runnable
        public void run() {
            boolean z;
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            RefreshState refreshState = smartRefreshLayout.mState;
            RefreshState refreshState2 = RefreshState.Loading;
            if (refreshState != refreshState2 || smartRefreshLayout.mRefreshFooter == null || smartRefreshLayout.mRefreshContent == null) {
                RefreshState refreshState3 = RefreshState.None;
                if (refreshState == refreshState3 && smartRefreshLayout.mViceState == refreshState2) {
                    smartRefreshLayout.mViceState = refreshState3;
                } else {
                    ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
                    if (valueAnimator != null && ((refreshState.isDragging || refreshState == RefreshState.LoadReleased) && refreshState.isFooter)) {
                        smartRefreshLayout.reboundAnimator = null;
                        valueAnimator.cancel();
                        SmartRefreshLayout.this.mKernel.d(refreshState3);
                    }
                }
                if (this.b) {
                    SmartRefreshLayout.this.setNoMoreData(true);
                    return;
                }
                return;
            }
            smartRefreshLayout.notifyStateChanged(RefreshState.LoadFinish);
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            int iOnFinish = smartRefreshLayout2.mRefreshFooter.onFinish(smartRefreshLayout2, this.f15126a);
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            OnMultiPurposeListener onMultiPurposeListener = smartRefreshLayout3.mOnMultiPurposeListener;
            if (onMultiPurposeListener != null) {
                RefreshInternal refreshInternal = smartRefreshLayout3.mRefreshFooter;
                if (refreshInternal instanceof RefreshFooter) {
                    onMultiPurposeListener.d((RefreshFooter) refreshInternal, this.f15126a);
                }
            }
            if (iOnFinish < Integer.MAX_VALUE) {
                if (this.b) {
                    SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                    z = smartRefreshLayout4.mEnableFooterFollowWhenNoMoreData && smartRefreshLayout4.mSpinner < 0 && smartRefreshLayout4.mRefreshContent.a();
                }
                SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                int i = smartRefreshLayout5.mSpinner;
                int iMax = i - (z ? Math.max(i, -smartRefreshLayout5.mFooterHeight) : 0);
                SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                if (smartRefreshLayout6.mIsBeingDragged || smartRefreshLayout6.mNestedInProgress) {
                    long jCurrentTimeMillis = System.currentTimeMillis();
                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                    if (smartRefreshLayout7.mIsBeingDragged) {
                        float f = smartRefreshLayout7.mLastTouchY;
                        smartRefreshLayout7.mTouchY = f;
                        smartRefreshLayout7.mTouchSpinner = smartRefreshLayout7.mSpinner - iMax;
                        smartRefreshLayout7.mIsBeingDragged = false;
                        float f2 = smartRefreshLayout7.mEnableFooterTranslationContent ? iMax : 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 0, smartRefreshLayout7.mLastTouchX, f + f2 + (smartRefreshLayout7.mTouchSlop * 2), 0));
                        SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 2, smartRefreshLayout8.mLastTouchX, smartRefreshLayout8.mLastTouchY + f2, 0));
                    }
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.mNestedInProgress) {
                        smartRefreshLayout9.mTotalUnconsumed = 0;
                        SmartRefreshLayout.super.dispatchTouchEvent(MotionEvent.obtain(jCurrentTimeMillis, jCurrentTimeMillis, 1, smartRefreshLayout9.mLastTouchX, smartRefreshLayout9.mLastTouchY, 0));
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        smartRefreshLayout10.mNestedInProgress = false;
                        smartRefreshLayout10.mTouchSpinner = 0;
                    }
                }
                SmartRefreshLayout.this.mHandler.postDelayed(new a(iMax), SmartRefreshLayout.this.mSpinner < 0 ? iOnFinish : 0L);
            }
        }
    }

    public class i implements Runnable {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f40406a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f15128a;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (smartRefreshLayout.reboundAnimator != null) {
                    smartRefreshLayout.mKernel.i(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                }
            }
        }

        public class b extends AnimatorListenerAdapter {
            public b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (smartRefreshLayout.reboundAnimator != null) {
                    smartRefreshLayout.reboundAnimator = null;
                    RefreshState refreshState = smartRefreshLayout.mState;
                    RefreshState refreshState2 = RefreshState.ReleaseToRefresh;
                    if (refreshState != refreshState2) {
                        smartRefreshLayout.mKernel.d(refreshState2);
                    }
                    i iVar = i.this;
                    SmartRefreshLayout.this.setStateRefreshing(!iVar.f15128a);
                }
            }
        }

        public i(float f, int i, boolean z) {
            this.f40406a = f;
            this.K = i;
            this.f15128a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mViceState != RefreshState.Refreshing) {
                return;
            }
            ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            smartRefreshLayout2.mLastTouchX = smartRefreshLayout2.getMeasuredWidth() / 2.0f;
            SmartRefreshLayout.this.mKernel.d(RefreshState.PullDownToRefresh);
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            smartRefreshLayout3.reboundAnimator = ValueAnimator.ofInt(smartRefreshLayout3.mSpinner, (int) (smartRefreshLayout3.mHeaderHeight * this.f40406a));
            SmartRefreshLayout.this.reboundAnimator.setDuration(this.K);
            SmartRefreshLayout.this.reboundAnimator.setInterpolator(new qk8());
            SmartRefreshLayout.this.reboundAnimator.addUpdateListener(new a());
            SmartRefreshLayout.this.reboundAnimator.addListener(new b());
            SmartRefreshLayout.this.reboundAnimator.start();
        }
    }

    public class j implements Runnable {
        public final /* synthetic */ int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ float f40409a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public final /* synthetic */ boolean f15130a;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (smartRefreshLayout.reboundAnimator != null) {
                    smartRefreshLayout.mKernel.i(((Integer) valueAnimator.getAnimatedValue()).intValue(), true);
                }
            }
        }

        public class b extends AnimatorListenerAdapter {
            public b() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (smartRefreshLayout.reboundAnimator != null) {
                    smartRefreshLayout.reboundAnimator = null;
                    RefreshState refreshState = smartRefreshLayout.mState;
                    RefreshState refreshState2 = RefreshState.ReleaseToLoad;
                    if (refreshState != refreshState2) {
                        smartRefreshLayout.mKernel.d(refreshState2);
                    }
                    j jVar = j.this;
                    SmartRefreshLayout.this.setStateLoading(!jVar.f15130a);
                }
            }
        }

        public j(float f, int i, boolean z) {
            this.f40409a = f;
            this.K = i;
            this.f15130a = z;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mViceState != RefreshState.Loading) {
                return;
            }
            ValueAnimator valueAnimator = smartRefreshLayout.reboundAnimator;
            if (valueAnimator != null) {
                valueAnimator.cancel();
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            smartRefreshLayout2.mLastTouchX = smartRefreshLayout2.getMeasuredWidth() / 2.0f;
            SmartRefreshLayout.this.mKernel.d(RefreshState.PullUpToLoad);
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            smartRefreshLayout3.reboundAnimator = ValueAnimator.ofInt(smartRefreshLayout3.mSpinner, -((int) (smartRefreshLayout3.mFooterHeight * this.f40409a)));
            SmartRefreshLayout.this.reboundAnimator.setDuration(this.K);
            SmartRefreshLayout.this.reboundAnimator.setInterpolator(new qk8());
            SmartRefreshLayout.this.reboundAnimator.addUpdateListener(new a());
            SmartRefreshLayout.this.reboundAnimator.addListener(new b());
            SmartRefreshLayout.this.reboundAnimator.start();
        }
    }

    public class k implements Runnable {
        public int M;
        public float b;
        public int K = 0;
        public int L = 10;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f40412a = 0.0f;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f15131a = AnimationUtils.currentAnimationTimeMillis();

        public k(float f, int i) {
            this.b = f;
            this.M = i;
            SmartRefreshLayout.this.mHandler.postDelayed(this, this.L);
            if (f > 0.0f) {
                SmartRefreshLayout.this.mKernel.d(RefreshState.PullDownToRefresh);
            } else {
                SmartRefreshLayout.this.mKernel.d(RefreshState.PullUpToLoad);
            }
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.animationRunnable != this || smartRefreshLayout.mState.isFinishing) {
                return;
            }
            if (Math.abs(smartRefreshLayout.mSpinner) < Math.abs(this.M)) {
                double d = this.b;
                int i = this.K + 1;
                this.K = i;
                this.b = (float) (d * Math.pow(0.949999988079071d, i * 2));
            } else if (this.M != 0) {
                double d2 = this.b;
                int i2 = this.K + 1;
                this.K = i2;
                this.b = (float) (d2 * Math.pow(0.44999998807907104d, i2 * 2));
            } else {
                double d3 = this.b;
                int i3 = this.K + 1;
                this.K = i3;
                this.b = (float) (d3 * Math.pow(0.8500000238418579d, i3 * 2));
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            float f = this.b * (((jCurrentAnimationTimeMillis - this.f15131a) * 1.0f) / 1000.0f);
            if (Math.abs(f) >= 1.0f) {
                this.f15131a = jCurrentAnimationTimeMillis;
                float f2 = this.f40412a + f;
                this.f40412a = f2;
                SmartRefreshLayout.this.moveSpinnerInfinitely(f2);
                SmartRefreshLayout.this.mHandler.postDelayed(this, this.L);
                return;
            }
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            RefreshState refreshState = smartRefreshLayout2.mViceState;
            boolean z = refreshState.isDragging;
            if (z && refreshState.isHeader) {
                smartRefreshLayout2.mKernel.d(RefreshState.PullDownCanceled);
            } else if (z && refreshState.isFooter) {
                smartRefreshLayout2.mKernel.d(RefreshState.PullUpCanceled);
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            smartRefreshLayout3.animationRunnable = null;
            if (Math.abs(smartRefreshLayout3.mSpinner) >= Math.abs(this.M)) {
                int iMin = Math.min(Math.max((int) qk8.j(Math.abs(SmartRefreshLayout.this.mSpinner - this.M)), 30), 100) * 10;
                SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                smartRefreshLayout4.animSpinner(this.M, 0, smartRefreshLayout4.mReboundInterpolator, iMin);
            }
        }
    }

    public class l implements Runnable {
        public int K;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public float f40413a;
        public int L = 0;
        public int M = 10;
        public float b = 0.98f;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public long f15133a = 0;

        /* JADX INFO: renamed from: b, reason: collision with other field name */
        public long f15135b = AnimationUtils.currentAnimationTimeMillis();

        public l(float f) {
            this.f40413a = f;
            this.K = SmartRefreshLayout.this.mSpinner;
        }

        /* JADX WARN: Code duplicated, block: B:29:0x004b  */
        /* JADX WARN: Code duplicated, block: B:33:0x0059  */
        /* JADX WARN: Code duplicated, block: B:36:0x0065  */
        /* JADX WARN: Code duplicated, block: B:40:0x0093  */
        /* JADX WARN: Code duplicated, block: B:48:0x00a3 A[LOOP:0: B:34:0x0061->B:48:0x00a3, LOOP_END] */
        /* JADX WARN: Code duplicated, block: B:52:0x008b A[SYNTHETIC] */
        public Runnable b() {
            SmartRefreshLayout smartRefreshLayout;
            int i;
            float fPow;
            int i2;
            int i3;
            float f;
            RefreshState refreshState;
            RefreshState refreshState2;
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            RefreshState refreshState3 = smartRefreshLayout2.mState;
            if (refreshState3.isFinishing) {
                return null;
            }
            if (smartRefreshLayout2.mSpinner != 0) {
                if (refreshState3.isOpening || (smartRefreshLayout2.mFooterNoMoreData && smartRefreshLayout2.mEnableFooterFollowWhenNoMoreData && smartRefreshLayout2.mFooterNoMoreDataEffective && smartRefreshLayout2.isEnableRefreshOrLoadMore(smartRefreshLayout2.mEnableLoadMore))) {
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.mState == RefreshState.Loading || (smartRefreshLayout3.mFooterNoMoreData && smartRefreshLayout3.mEnableFooterFollowWhenNoMoreData && smartRefreshLayout3.mFooterNoMoreDataEffective && smartRefreshLayout3.isEnableRefreshOrLoadMore(smartRefreshLayout3.mEnableLoadMore))) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        if (smartRefreshLayout4.mSpinner >= (-smartRefreshLayout4.mFooterHeight)) {
                            smartRefreshLayout = SmartRefreshLayout.this;
                            if (smartRefreshLayout.mState == RefreshState.Refreshing && smartRefreshLayout.mSpinner > smartRefreshLayout.mHeaderHeight) {
                                i = SmartRefreshLayout.this.mSpinner;
                                fPow = this.f40413a;
                                i2 = 0;
                                i3 = i;
                                while (i * i3 > 0) {
                                    i2++;
                                    fPow = (float) (((double) fPow) * Math.pow(this.b, (this.M * i2) / 10.0f));
                                    f = ((this.M * 1.0f) / 1000.0f) * fPow;
                                    if (Math.abs(f) < 1.0f) {
                                        SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                                        refreshState = smartRefreshLayout5.mState;
                                        if (!refreshState.isOpening && ((refreshState != (refreshState2 = RefreshState.Refreshing) || i3 <= smartRefreshLayout5.mHeaderHeight) && (refreshState == refreshState2 || i3 >= (-smartRefreshLayout5.mFooterHeight)))) {
                                            break;
                                            break;
                                        }
                                        return null;
                                    }
                                    i3 = (int) (i3 + f);
                                }
                            }
                        } else {
                            i = SmartRefreshLayout.this.mSpinner;
                            fPow = this.f40413a;
                            i2 = 0;
                            i3 = i;
                            while (i * i3 > 0) {
                                i2++;
                                fPow = (float) (((double) fPow) * Math.pow(this.b, (this.M * i2) / 10.0f));
                                f = ((this.M * 1.0f) / 1000.0f) * fPow;
                                if (Math.abs(f) < 1.0f) {
                                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                                    refreshState = smartRefreshLayout6.mState;
                                    if (!refreshState.isOpening) {
                                    }
                                    return null;
                                }
                                i3 = (int) (i3 + f);
                            }
                        }
                    } else {
                        smartRefreshLayout = SmartRefreshLayout.this;
                        if (smartRefreshLayout.mState == RefreshState.Refreshing) {
                            i = SmartRefreshLayout.this.mSpinner;
                            fPow = this.f40413a;
                            i2 = 0;
                            i3 = i;
                            while (i * i3 > 0) {
                                i2++;
                                fPow = (float) (((double) fPow) * Math.pow(this.b, (this.M * i2) / 10.0f));
                                f = ((this.M * 1.0f) / 1000.0f) * fPow;
                                if (Math.abs(f) < 1.0f) {
                                    SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                                    refreshState = smartRefreshLayout7.mState;
                                    if (!refreshState.isOpening) {
                                    }
                                    return null;
                                }
                                i3 = (int) (i3 + f);
                            }
                        }
                    }
                } else {
                    i = SmartRefreshLayout.this.mSpinner;
                    fPow = this.f40413a;
                    i2 = 0;
                    i3 = i;
                    while (i * i3 > 0) {
                        i2++;
                        fPow = (float) (((double) fPow) * Math.pow(this.b, (this.M * i2) / 10.0f));
                        f = ((this.M * 1.0f) / 1000.0f) * fPow;
                        if (Math.abs(f) < 1.0f) {
                            SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                            refreshState = smartRefreshLayout8.mState;
                            if (!refreshState.isOpening) {
                            }
                            return null;
                        }
                        i3 = (int) (i3 + f);
                    }
                }
            }
            this.f15133a = AnimationUtils.currentAnimationTimeMillis();
            SmartRefreshLayout.this.mHandler.postDelayed(this, this.M);
            return this;
        }

        @Override // java.lang.Runnable
        public void run() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.animationRunnable != this || smartRefreshLayout.mState.isFinishing) {
                return;
            }
            long jCurrentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis();
            long j = jCurrentAnimationTimeMillis - this.f15135b;
            float fPow = (float) (((double) this.f40413a) * Math.pow(this.b, (jCurrentAnimationTimeMillis - this.f15133a) / (1000.0f / this.M)));
            this.f40413a = fPow;
            float f = fPow * ((j * 1.0f) / 1000.0f);
            if (Math.abs(f) <= 1.0f) {
                SmartRefreshLayout.this.animationRunnable = null;
                return;
            }
            this.f15135b = jCurrentAnimationTimeMillis;
            int i = (int) (this.K + f);
            this.K = i;
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            if (smartRefreshLayout2.mSpinner * i > 0) {
                smartRefreshLayout2.mKernel.i(i, true);
                SmartRefreshLayout.this.mHandler.postDelayed(this, this.M);
                return;
            }
            smartRefreshLayout2.animationRunnable = null;
            smartRefreshLayout2.mKernel.i(0, true);
            qk8.e(SmartRefreshLayout.this.mRefreshContent.g(), (int) (-this.f40413a));
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            if (!smartRefreshLayout3.mFooterLocked || f <= 0.0f) {
                return;
            }
            smartRefreshLayout3.mFooterLocked = false;
        }
    }

    public class m implements RefreshKernel {

        public class a extends AnimatorListenerAdapter {
            public a() {
            }

            @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                SmartRefreshLayout.this.mKernel.d(RefreshState.TwoLevel);
            }
        }

        public m() {
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel a() {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mState == RefreshState.TwoLevel) {
                smartRefreshLayout.mKernel.d(RefreshState.TwoLevelFinish);
                if (SmartRefreshLayout.this.mSpinner == 0) {
                    i(0, false);
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
                } else {
                    b(0).setDuration(SmartRefreshLayout.this.mFloorDuration);
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public ValueAnimator b(int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            return smartRefreshLayout.animSpinner(i, 0, smartRefreshLayout.mReboundInterpolator, smartRefreshLayout.mReboundDuration);
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel c(@NonNull RefreshInternal refreshInternal, boolean z) {
            if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                if (!smartRefreshLayout.mManualHeaderTranslationContent) {
                    smartRefreshLayout.mManualHeaderTranslationContent = true;
                    smartRefreshLayout.mEnableHeaderTranslationContent = z;
                }
            } else if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                if (!smartRefreshLayout2.mManualFooterTranslationContent) {
                    smartRefreshLayout2.mManualFooterTranslationContent = true;
                    smartRefreshLayout2.mEnableFooterTranslationContent = z;
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel d(@NonNull RefreshState refreshState) {
            switch (a.f40396a[refreshState.ordinal()]) {
                case 1:
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    RefreshState refreshState2 = smartRefreshLayout.mState;
                    RefreshState refreshState3 = RefreshState.None;
                    if (refreshState2 != refreshState3 && smartRefreshLayout.mSpinner == 0) {
                        smartRefreshLayout.notifyStateChanged(refreshState3);
                    } else if (smartRefreshLayout.mSpinner != 0) {
                        b(0);
                    }
                    break;
                case 2:
                    SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout2.mState.isOpening && smartRefreshLayout2.isEnableRefreshOrLoadMore(smartRefreshLayout2.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownToRefresh);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownToRefresh);
                    }
                    break;
                case 3:
                    SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
                    if (smartRefreshLayout3.isEnableRefreshOrLoadMore(smartRefreshLayout3.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
                        RefreshState refreshState4 = smartRefreshLayout4.mState;
                        if (!refreshState4.isOpening && !refreshState4.isFinishing && (!smartRefreshLayout4.mFooterNoMoreData || !smartRefreshLayout4.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout4.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout4.notifyStateChanged(RefreshState.PullUpToLoad);
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpToLoad);
                    break;
                case 4:
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout5.mState.isOpening && smartRefreshLayout5.isEnableRefreshOrLoadMore(smartRefreshLayout5.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.PullDownCanceled);
                        d(RefreshState.None);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.PullDownCanceled);
                    }
                    break;
                case 5:
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.isEnableRefreshOrLoadMore(smartRefreshLayout6.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                        if (!smartRefreshLayout7.mState.isOpening && (!smartRefreshLayout7.mFooterNoMoreData || !smartRefreshLayout7.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout7.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout7.notifyStateChanged(RefreshState.PullUpCanceled);
                            d(RefreshState.None);
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.PullUpCanceled);
                    break;
                case 6:
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout8.mState.isOpening && smartRefreshLayout8.isEnableRefreshOrLoadMore(smartRefreshLayout8.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToRefresh);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToRefresh);
                    }
                    break;
                case 7:
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    if (smartRefreshLayout9.isEnableRefreshOrLoadMore(smartRefreshLayout9.mEnableLoadMore)) {
                        SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                        RefreshState refreshState5 = smartRefreshLayout10.mState;
                        if (!refreshState5.isOpening && !refreshState5.isFinishing && (!smartRefreshLayout10.mFooterNoMoreData || !smartRefreshLayout10.mEnableFooterFollowWhenNoMoreData || !smartRefreshLayout10.mFooterNoMoreDataEffective)) {
                            smartRefreshLayout10.notifyStateChanged(RefreshState.ReleaseToLoad);
                        }
                    }
                    SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToLoad);
                    break;
                case 8:
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout11.mState.isOpening && smartRefreshLayout11.isEnableRefreshOrLoadMore(smartRefreshLayout11.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.ReleaseToTwoLevel);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.ReleaseToTwoLevel);
                    }
                    break;
                case 9:
                    SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout12.mState.isOpening && smartRefreshLayout12.isEnableRefreshOrLoadMore(smartRefreshLayout12.mEnableRefresh)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.RefreshReleased);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.RefreshReleased);
                    }
                    break;
                case 10:
                    SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                    if (!smartRefreshLayout13.mState.isOpening && smartRefreshLayout13.isEnableRefreshOrLoadMore(smartRefreshLayout13.mEnableLoadMore)) {
                        SmartRefreshLayout.this.notifyStateChanged(RefreshState.LoadReleased);
                    } else {
                        SmartRefreshLayout.this.setViceState(RefreshState.LoadReleased);
                    }
                    break;
                case 11:
                    SmartRefreshLayout.this.setStateRefreshing(true);
                    break;
                case 12:
                    SmartRefreshLayout.this.setStateLoading(true);
                    break;
                case 13:
                    SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                    if (smartRefreshLayout14.mState == RefreshState.Refreshing) {
                        smartRefreshLayout14.notifyStateChanged(RefreshState.RefreshFinish);
                    }
                    break;
                case 14:
                    SmartRefreshLayout smartRefreshLayout15 = SmartRefreshLayout.this;
                    if (smartRefreshLayout15.mState == RefreshState.Loading) {
                        smartRefreshLayout15.notifyStateChanged(RefreshState.LoadFinish);
                    }
                    break;
                case 15:
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevelReleased);
                    break;
                case 16:
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevelFinish);
                    break;
                case 17:
                    SmartRefreshLayout.this.notifyStateChanged(RefreshState.TwoLevel);
                    break;
            }
            return null;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        @NonNull
        public RefreshContent e() {
            return SmartRefreshLayout.this.mRefreshContent;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel f(@NonNull RefreshInternal refreshInternal, int i) {
            SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
            if (smartRefreshLayout.mPaint == null && i != 0) {
                smartRefreshLayout.mPaint = new Paint();
            }
            if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout.this.mHeaderBackgroundColor = i;
            } else if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout.this.mFooterBackgroundColor = i;
            }
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:8:0x0023  */
        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel g(boolean z) {
            if (z) {
                a aVar = new a();
                ValueAnimator valueAnimatorB = b(SmartRefreshLayout.this.getMeasuredHeight());
                if (valueAnimatorB != null) {
                    SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                    if (valueAnimatorB == smartRefreshLayout.reboundAnimator) {
                        valueAnimatorB.setDuration(smartRefreshLayout.mFloorDuration);
                        valueAnimatorB.addListener(aVar);
                    } else {
                        aVar.onAnimationEnd(null);
                    }
                } else {
                    aVar.onAnimationEnd(null);
                }
            } else if (b(0) == null) {
                SmartRefreshLayout.this.notifyStateChanged(RefreshState.None);
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel h(@NonNull RefreshInternal refreshInternal, boolean z) {
            if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout.this.mHeaderNeedTouchEventWhenRefreshing = z;
            } else if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout.this.mFooterNeedTouchEventWhenLoading = z;
            }
            return this;
        }

        /* JADX WARN: Code duplicated, block: B:46:0x0098  */
        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel i(int i, boolean z) {
            OnMultiPurposeListener onMultiPurposeListener;
            OnMultiPurposeListener onMultiPurposeListener2;
            int i2;
            boolean z2;
            RefreshInternal refreshInternal;
            RefreshInternal refreshInternal2;
            SmartRefreshLayout smartRefreshLayout;
            RefreshInternal refreshInternal3;
            RefreshInternal refreshInternal4;
            RefreshInternal refreshInternal5;
            RefreshInternal refreshInternal6;
            SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
            if (smartRefreshLayout2.mSpinner == i && (((refreshInternal5 = smartRefreshLayout2.mRefreshHeader) == null || !refreshInternal5.isSupportHorizontalDrag()) && ((refreshInternal6 = SmartRefreshLayout.this.mRefreshFooter) == null || !refreshInternal6.isSupportHorizontalDrag()))) {
                return this;
            }
            SmartRefreshLayout smartRefreshLayout3 = SmartRefreshLayout.this;
            int i3 = smartRefreshLayout3.mSpinner;
            smartRefreshLayout3.mSpinner = i;
            if (z) {
                RefreshState refreshState = smartRefreshLayout3.mViceState;
                if (refreshState.isDragging || refreshState.isOpening) {
                    if (i > smartRefreshLayout3.mHeaderHeight * smartRefreshLayout3.mHeaderTriggerRate) {
                        if (smartRefreshLayout3.mState != RefreshState.ReleaseToTwoLevel) {
                            smartRefreshLayout3.mKernel.d(RefreshState.ReleaseToRefresh);
                        }
                    } else if ((-i) > smartRefreshLayout3.mFooterHeight * smartRefreshLayout3.mFooterTriggerRate && !smartRefreshLayout3.mFooterNoMoreData) {
                        smartRefreshLayout3.mKernel.d(RefreshState.ReleaseToLoad);
                    } else if (i < 0 && !smartRefreshLayout3.mFooterNoMoreData) {
                        smartRefreshLayout3.mKernel.d(RefreshState.PullUpToLoad);
                    } else if (i > 0) {
                        smartRefreshLayout3.mKernel.d(RefreshState.PullDownToRefresh);
                    }
                }
            }
            SmartRefreshLayout smartRefreshLayout4 = SmartRefreshLayout.this;
            if (smartRefreshLayout4.mRefreshContent != null) {
                if (i < 0 || (refreshInternal4 = smartRefreshLayout4.mRefreshHeader) == null) {
                    i2 = 0;
                    z2 = false;
                } else {
                    if (smartRefreshLayout4.isEnableTranslationContent(smartRefreshLayout4.mEnableHeaderTranslationContent, refreshInternal4)) {
                        i2 = i;
                    } else if (i3 < 0) {
                        i2 = 0;
                    } else {
                        i2 = 0;
                        z2 = false;
                    }
                    z2 = true;
                }
                if (i <= 0 && (refreshInternal3 = (smartRefreshLayout = SmartRefreshLayout.this).mRefreshFooter) != null) {
                    if (smartRefreshLayout.isEnableTranslationContent(smartRefreshLayout.mEnableFooterTranslationContent, refreshInternal3)) {
                        i2 = i;
                    } else if (i3 > 0) {
                        i2 = 0;
                    }
                    z2 = true;
                }
                if (z2) {
                    SmartRefreshLayout smartRefreshLayout5 = SmartRefreshLayout.this;
                    smartRefreshLayout5.mRefreshContent.e(i2, smartRefreshLayout5.mHeaderTranslationViewId, smartRefreshLayout5.mFooterTranslationViewId);
                    SmartRefreshLayout smartRefreshLayout6 = SmartRefreshLayout.this;
                    if (smartRefreshLayout6.mFooterNoMoreData && smartRefreshLayout6.mFooterNoMoreDataEffective && smartRefreshLayout6.mEnableFooterFollowWhenNoMoreData) {
                        RefreshInternal refreshInternal7 = smartRefreshLayout6.mRefreshFooter;
                        if ((refreshInternal7 instanceof RefreshFooter) && refreshInternal7.getSpinnerStyle() == xm8.f45853a) {
                            SmartRefreshLayout smartRefreshLayout7 = SmartRefreshLayout.this;
                            if (smartRefreshLayout7.isEnableRefreshOrLoadMore(smartRefreshLayout7.mEnableLoadMore)) {
                                SmartRefreshLayout.this.mRefreshFooter.getView().setTranslationY(Math.max(0, i2));
                            }
                        }
                    }
                    SmartRefreshLayout smartRefreshLayout8 = SmartRefreshLayout.this;
                    boolean z3 = (smartRefreshLayout8.mEnableClipHeaderWhenFixedBehind && (refreshInternal2 = smartRefreshLayout8.mRefreshHeader) != null && refreshInternal2.getSpinnerStyle() == xm8.c) || SmartRefreshLayout.this.mHeaderBackgroundColor != 0;
                    SmartRefreshLayout smartRefreshLayout9 = SmartRefreshLayout.this;
                    boolean z4 = (smartRefreshLayout9.mEnableClipFooterWhenFixedBehind && (refreshInternal = smartRefreshLayout9.mRefreshFooter) != null && refreshInternal.getSpinnerStyle() == xm8.c) || SmartRefreshLayout.this.mFooterBackgroundColor != 0;
                    if ((z3 && (i2 >= 0 || i3 > 0)) || (z4 && (i2 <= 0 || i3 < 0))) {
                        smartRefreshLayout3.invalidate();
                    }
                }
            }
            if ((i >= 0 || i3 > 0) && SmartRefreshLayout.this.mRefreshHeader != null) {
                int iMax = Math.max(i, 0);
                SmartRefreshLayout smartRefreshLayout10 = SmartRefreshLayout.this;
                int i4 = smartRefreshLayout10.mHeaderHeight;
                int i5 = (int) (i4 * smartRefreshLayout10.mHeaderMaxDragRate);
                float f = (iMax * 1.0f) / (i4 == 0 ? 1 : i4);
                if (smartRefreshLayout10.isEnableRefreshOrLoadMore(smartRefreshLayout10.mEnableRefresh) || (SmartRefreshLayout.this.mState == RefreshState.RefreshFinish && !z)) {
                    SmartRefreshLayout smartRefreshLayout11 = SmartRefreshLayout.this;
                    if (i3 != smartRefreshLayout11.mSpinner) {
                        if (smartRefreshLayout11.mRefreshHeader.getSpinnerStyle() == xm8.f45853a) {
                            SmartRefreshLayout.this.mRefreshHeader.getView().setTranslationY(SmartRefreshLayout.this.mSpinner);
                            SmartRefreshLayout smartRefreshLayout12 = SmartRefreshLayout.this;
                            if (smartRefreshLayout12.mHeaderBackgroundColor != 0 && smartRefreshLayout12.mPaint != null && !smartRefreshLayout12.isEnableTranslationContent(smartRefreshLayout12.mEnableHeaderTranslationContent, smartRefreshLayout12.mRefreshHeader)) {
                                smartRefreshLayout3.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.mRefreshHeader.getSpinnerStyle() == xm8.b) {
                            SmartRefreshLayout.this.mRefreshHeader.getView().requestLayout();
                        }
                        SmartRefreshLayout.this.mRefreshHeader.onMoving(z, f, iMax, i4, i5);
                    }
                    if (z && SmartRefreshLayout.this.mRefreshHeader.isSupportHorizontalDrag()) {
                        int i6 = (int) SmartRefreshLayout.this.mLastTouchX;
                        int width = smartRefreshLayout3.getWidth();
                        SmartRefreshLayout smartRefreshLayout13 = SmartRefreshLayout.this;
                        smartRefreshLayout13.mRefreshHeader.onHorizontalDrag(smartRefreshLayout13.mLastTouchX / (width == 0 ? 1 : width), i6, width);
                    }
                }
                SmartRefreshLayout smartRefreshLayout14 = SmartRefreshLayout.this;
                if (i3 != smartRefreshLayout14.mSpinner && (onMultiPurposeListener = smartRefreshLayout14.mOnMultiPurposeListener) != null) {
                    RefreshInternal refreshInternal8 = smartRefreshLayout14.mRefreshHeader;
                    if (refreshInternal8 instanceof RefreshHeader) {
                        onMultiPurposeListener.b((RefreshHeader) refreshInternal8, z, f, iMax, i4, i5);
                    }
                }
            }
            if ((i <= 0 || i3 < 0) && SmartRefreshLayout.this.mRefreshFooter != null) {
                int i7 = -Math.min(i, 0);
                SmartRefreshLayout smartRefreshLayout15 = SmartRefreshLayout.this;
                int i8 = smartRefreshLayout15.mFooterHeight;
                int i9 = (int) (i8 * smartRefreshLayout15.mFooterMaxDragRate);
                float f2 = (i7 * 1.0f) / (i8 == 0 ? 1 : i8);
                if (smartRefreshLayout15.isEnableRefreshOrLoadMore(smartRefreshLayout15.mEnableLoadMore) || (SmartRefreshLayout.this.mState == RefreshState.LoadFinish && !z)) {
                    SmartRefreshLayout smartRefreshLayout16 = SmartRefreshLayout.this;
                    if (i3 != smartRefreshLayout16.mSpinner) {
                        if (smartRefreshLayout16.mRefreshFooter.getSpinnerStyle() == xm8.f45853a) {
                            SmartRefreshLayout.this.mRefreshFooter.getView().setTranslationY(SmartRefreshLayout.this.mSpinner);
                            SmartRefreshLayout smartRefreshLayout17 = SmartRefreshLayout.this;
                            if (smartRefreshLayout17.mFooterBackgroundColor != 0 && smartRefreshLayout17.mPaint != null && !smartRefreshLayout17.isEnableTranslationContent(smartRefreshLayout17.mEnableFooterTranslationContent, smartRefreshLayout17.mRefreshFooter)) {
                                smartRefreshLayout3.invalidate();
                            }
                        } else if (SmartRefreshLayout.this.mRefreshFooter.getSpinnerStyle() == xm8.b) {
                            SmartRefreshLayout.this.mRefreshFooter.getView().requestLayout();
                        }
                        SmartRefreshLayout.this.mRefreshFooter.onMoving(z, f2, i7, i8, i9);
                    }
                    if (z && SmartRefreshLayout.this.mRefreshFooter.isSupportHorizontalDrag()) {
                        int i10 = (int) SmartRefreshLayout.this.mLastTouchX;
                        int width2 = smartRefreshLayout3.getWidth();
                        SmartRefreshLayout smartRefreshLayout18 = SmartRefreshLayout.this;
                        smartRefreshLayout18.mRefreshFooter.onHorizontalDrag(smartRefreshLayout18.mLastTouchX / (width2 != 0 ? width2 : 1), i10, width2);
                    }
                }
                SmartRefreshLayout smartRefreshLayout19 = SmartRefreshLayout.this;
                if (i3 != smartRefreshLayout19.mSpinner && (onMultiPurposeListener2 = smartRefreshLayout19.mOnMultiPurposeListener) != null) {
                    RefreshInternal refreshInternal9 = smartRefreshLayout19.mRefreshFooter;
                    if (refreshInternal9 instanceof RefreshFooter) {
                        onMultiPurposeListener2.h((RefreshFooter) refreshInternal9, z, f2, i7, i8, i9);
                    }
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel j(@NonNull RefreshInternal refreshInternal) {
            if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshHeader)) {
                SmartRefreshLayout smartRefreshLayout = SmartRefreshLayout.this;
                un2 un2Var = smartRefreshLayout.mHeaderHeightStatus;
                if (un2Var.f20111a) {
                    smartRefreshLayout.mHeaderHeightStatus = un2Var.c();
                }
            } else if (refreshInternal.equals(SmartRefreshLayout.this.mRefreshFooter)) {
                SmartRefreshLayout smartRefreshLayout2 = SmartRefreshLayout.this;
                un2 un2Var2 = smartRefreshLayout2.mFooterHeightStatus;
                if (un2Var2.f20111a) {
                    smartRefreshLayout2.mFooterHeightStatus = un2Var2.c();
                }
            }
            return this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        @NonNull
        public RefreshLayout k() {
            return SmartRefreshLayout.this;
        }

        @Override // com.scwang.smartrefresh.layout.api.RefreshKernel
        public RefreshKernel l(int i) {
            SmartRefreshLayout.this.mFloorDuration = i;
            return this;
        }
    }

    public SmartRefreshLayout(Context context) {
        this(context, null);
    }

    public static void setDefaultRefreshFooterCreator(@NonNull DefaultRefreshFooterCreator defaultRefreshFooterCreator) {
        sFooterCreator = defaultRefreshFooterCreator;
    }

    public static void setDefaultRefreshHeaderCreator(@NonNull DefaultRefreshHeaderCreator defaultRefreshHeaderCreator) {
        sHeaderCreator = defaultRefreshHeaderCreator;
    }

    public static void setDefaultRefreshInitializer(@NonNull DefaultRefreshInitializer defaultRefreshInitializer) {
        sRefreshInitializer = defaultRefreshInitializer;
    }

    public ValueAnimator animSpinner(int i2, int i3, Interpolator interpolator, int i4) {
        if (this.mSpinner == i2) {
            return null;
        }
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        this.animationRunnable = null;
        ValueAnimator valueAnimatorOfInt = ValueAnimator.ofInt(this.mSpinner, i2);
        this.reboundAnimator = valueAnimatorOfInt;
        valueAnimatorOfInt.setDuration(i4);
        this.reboundAnimator.setInterpolator(interpolator);
        this.reboundAnimator.addListener(new d());
        this.reboundAnimator.addUpdateListener(new e());
        this.reboundAnimator.setStartDelay(i3);
        this.reboundAnimator.start();
        return this.reboundAnimator;
    }

    public void animSpinnerBounce(float f2) {
        RefreshState refreshState;
        if (this.reboundAnimator == null) {
            if (f2 > 0.0f && ((refreshState = this.mState) == RefreshState.Refreshing || refreshState == RefreshState.TwoLevel)) {
                this.animationRunnable = new k(f2, this.mHeaderHeight);
                return;
            }
            if (f2 < 0.0f && (this.mState == RefreshState.Loading || ((this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && this.mState != RefreshState.Refreshing)))) {
                this.animationRunnable = new k(f2, -this.mFooterHeight);
            } else if (this.mSpinner == 0 && this.mEnableOverScrollBounce) {
                this.animationRunnable = new k(f2, 0);
            }
        }
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoLoadMore() {
        int i2 = this.mReboundDuration;
        int i3 = this.mFooterHeight;
        float f2 = i3 * ((this.mFooterMaxDragRate / 2.0f) + 0.5f) * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return autoLoadMore(0, i2, f2 / i3, false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoLoadMoreAnimationOnly() {
        int i2 = this.mReboundDuration;
        int i3 = this.mFooterHeight;
        float f2 = i3 * ((this.mFooterMaxDragRate / 2.0f) + 0.5f) * 1.0f;
        if (i3 == 0) {
            i3 = 1;
        }
        return autoLoadMore(0, i2, f2 / i3, true);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoRefresh() {
        int i2 = this.mAttachedToWindow ? 0 : 400;
        int i3 = this.mReboundDuration;
        float f2 = (this.mHeaderMaxDragRate / 2.0f) + 0.5f;
        int i4 = this.mHeaderHeight;
        float f3 = f2 * i4 * 1.0f;
        if (i4 == 0) {
            i4 = 1;
        }
        return autoRefresh(i2, i3, f3 / i4, false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoRefreshAnimationOnly() {
        int i2 = this.mAttachedToWindow ? 0 : 400;
        int i3 = this.mReboundDuration;
        float f2 = (this.mHeaderMaxDragRate / 2.0f) + 0.5f;
        int i4 = this.mHeaderHeight;
        float f3 = f2 * i4 * 1.0f;
        if (i4 == 0) {
            i4 = 1;
        }
        return autoRefresh(i2, i3, f3 / i4, true);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout closeHeaderOrFooter() {
        RefreshState refreshState = this.mState;
        if (refreshState == RefreshState.Refreshing) {
            finishRefresh();
        } else if (refreshState == RefreshState.Loading) {
            finishLoadMore();
        } else if (this.mSpinner != 0) {
            animSpinner(0, 0, this.mReboundInterpolator, this.mReboundDuration);
        }
        return this;
    }

    @Override // android.view.View
    public void computeScroll() {
        this.mScroller.getCurrY();
        if (this.mScroller.computeScrollOffset()) {
            int finalY = this.mScroller.getFinalY();
            if ((finalY >= 0 || !((this.mEnableRefresh || this.mEnableOverScrollDrag) && this.mRefreshContent.d())) && (finalY <= 0 || !((this.mEnableLoadMore || this.mEnableOverScrollDrag) && this.mRefreshContent.a()))) {
                this.mVerticalPermit = true;
                invalidate();
            } else {
                if (this.mVerticalPermit) {
                    animSpinnerBounce(finalY > 0 ? -this.mScroller.getCurrVelocity() : this.mScroller.getCurrVelocity());
                }
                this.mScroller.forceFinished(true);
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:120:0x0163  */
    /* JADX WARN: Code duplicated, block: B:122:0x0169  */
    /* JADX WARN: Code duplicated, block: B:131:0x0187  */
    /* JADX WARN: Code duplicated, block: B:133:0x018b  */
    /* JADX WARN: Code duplicated, block: B:148:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:150:0x01bb  */
    /* JADX WARN: Code duplicated, block: B:153:0x01c7 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:158:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:161:0x01de  */
    /* JADX WARN: Code duplicated, block: B:164:0x01e7  */
    /* JADX WARN: Code duplicated, block: B:176:0x020b  */
    /* JADX WARN: Code duplicated, block: B:179:0x0240  */
    /* JADX WARN: Code duplicated, block: B:185:0x024f  */
    /* JADX WARN: Code duplicated, block: B:192:0x026d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:193:0x026f  */
    /* JADX WARN: Code duplicated, block: B:200:0x028d  */
    /* JADX WARN: Code duplicated, block: B:203:0x0294 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:204:0x0296  */
    /* JADX WARN: Code duplicated, block: B:209:0x02a0  */
    /* JADX WARN: Code duplicated, block: B:213:0x02a8  */
    /* JADX WARN: Code duplicated, block: B:217:0x02b9  */
    /* JADX WARN: Code duplicated, block: B:224:0x02cb  */
    /* JADX WARN: Code duplicated, block: B:227:0x02f3  */
    /* JADX WARN: Code duplicated, block: B:230:0x0311  */
    /* JADX WARN: Code duplicated, block: B:234:0x0319  */
    /* JADX WARN: Code duplicated, block: B:242:0x0355  */
    /* JADX WARN: Code duplicated, block: B:68:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:74:0x00da  */
    /* JADX WARN: Code duplicated, block: B:79:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:92:0x0102  */
    /* JADX WARN: Code duplicated, block: B:94:0x0105  */
    /* JADX WARN: Code duplicated, block: B:96:0x0108 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:98:0x010c  */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x00dc, code lost:
    
        if (r4.isFooter != false) goto L245;
     */
    @Override // android.view.ViewGroup, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        RefreshState refreshState;
        RefreshState refreshState2;
        RefreshContent refreshContent;
        MotionEvent motionEvent2;
        float f2;
        float f3;
        int i2;
        RefreshState refreshState3;
        long eventTime;
        MotionEvent motionEventObtain;
        RefreshState refreshState4;
        char c2;
        int i3;
        RefreshState refreshState5;
        ViewParent parent;
        RefreshState refreshState6;
        RefreshInternal refreshInternal;
        RefreshInternal refreshInternal2;
        int actionMasked = motionEvent.getActionMasked();
        int i4 = 0;
        boolean z = actionMasked == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        int pointerCount = motionEvent.getPointerCount();
        float x = 0.0f;
        float y = 0.0f;
        for (int i5 = 0; i5 < pointerCount; i5++) {
            if (actionIndex != i5) {
                x += motionEvent.getX(i5);
                y += motionEvent.getY(i5);
            }
        }
        if (z) {
            pointerCount--;
        }
        float f4 = pointerCount;
        float f5 = x / f4;
        float f6 = y / f4;
        if ((actionMasked == 6 || actionMasked == 5) && this.mIsBeingDragged) {
            this.mTouchY += f6 - this.mLastTouchY;
        }
        this.mLastTouchX = f5;
        this.mLastTouchY = f6;
        if (this.mNestedInProgress) {
            int i6 = this.mTotalUnconsumed;
            boolean zDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
            if (actionMasked == 2 && i6 == this.mTotalUnconsumed) {
                int i7 = (int) this.mLastTouchX;
                int width = getWidth();
                float f7 = this.mLastTouchX / (width != 0 ? width : 1);
                if (isEnableRefreshOrLoadMore(this.mEnableRefresh) && this.mSpinner > 0 && (refreshInternal2 = this.mRefreshHeader) != null && refreshInternal2.isSupportHorizontalDrag()) {
                    this.mRefreshHeader.onHorizontalDrag(f7, i7, width);
                } else if (isEnableRefreshOrLoadMore(this.mEnableLoadMore) && this.mSpinner < 0 && (refreshInternal = this.mRefreshFooter) != null && refreshInternal.isSupportHorizontalDrag()) {
                    this.mRefreshFooter.onHorizontalDrag(f7, i7, width);
                }
            }
            return zDispatchTouchEvent;
        }
        if (isEnabled() && (this.mEnableRefresh || this.mEnableLoadMore || this.mEnableOverScrollDrag)) {
            if (!this.mHeaderNeedTouchEventWhenRefreshing) {
                if (this.mFooterNeedTouchEventWhenLoading) {
                    refreshState6 = this.mState;
                    if (refreshState6.isOpening) {
                        if (refreshState6.isFinishing) {
                        }
                    }
                }
                if (!interceptAnimatorByAction(actionMasked)) {
                    refreshState = this.mState;
                    if (!refreshState.isFinishing) {
                        if (actionMasked != 0) {
                            this.mCurrentVelocity = 0;
                            this.mVelocityTracker.addMovement(motionEvent);
                            this.mScroller.forceFinished(true);
                            this.mTouchX = f5;
                            this.mTouchY = f6;
                            this.mLastSpinner = 0;
                            this.mTouchSpinner = this.mSpinner;
                            this.mIsBeingDragged = false;
                            this.mEnableDisallowIntercept = false;
                            this.mSuperDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                            if (this.mState != RefreshState.TwoLevel) {
                            }
                            refreshContent = this.mRefreshContent;
                            if (refreshContent != null) {
                                refreshContent.b(motionEvent);
                            }
                            return true;
                        }
                        if (actionMasked != 1) {
                            if (actionMasked != 2) {
                                f2 = f5 - this.mTouchX;
                                f3 = f6 - this.mTouchY;
                                this.mVelocityTracker.addMovement(motionEvent);
                                if (!this.mIsBeingDragged) {
                                    if (c2 != 'v') {
                                        this.mDragDirection = 'v';
                                        if (f3 <= 0.0f) {
                                            if (f3 < 0.0f) {
                                                this.mIsBeingDragged = true;
                                                this.mTouchY = this.mTouchSlop + f6;
                                            }
                                        } else if (f3 < 0.0f) {
                                            this.mIsBeingDragged = true;
                                            this.mTouchY = this.mTouchSlop + f6;
                                        }
                                        if (this.mIsBeingDragged) {
                                            f3 = f6 - this.mTouchY;
                                            if (this.mSuperDispatchTouchEvent) {
                                                motionEvent.setAction(3);
                                                super.dispatchTouchEvent(motionEvent);
                                            }
                                            RefreshKernel refreshKernel = this.mKernel;
                                            i3 = this.mSpinner;
                                            if (i3 <= 0) {
                                                refreshState5 = RefreshState.PullDownToRefresh;
                                            } else {
                                                refreshState5 = RefreshState.PullDownToRefresh;
                                            }
                                            refreshKernel.d(refreshState5);
                                            parent = getParent();
                                            if (parent instanceof ViewGroup) {
                                                ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                                            }
                                        }
                                    } else {
                                        this.mDragDirection = 'v';
                                        if (f3 <= 0.0f) {
                                            if (f3 < 0.0f) {
                                                this.mIsBeingDragged = true;
                                                this.mTouchY = this.mTouchSlop + f6;
                                            }
                                        } else if (f3 < 0.0f) {
                                            this.mIsBeingDragged = true;
                                            this.mTouchY = this.mTouchSlop + f6;
                                        }
                                        if (this.mIsBeingDragged) {
                                            f3 = f6 - this.mTouchY;
                                            if (this.mSuperDispatchTouchEvent) {
                                                motionEvent.setAction(3);
                                                super.dispatchTouchEvent(motionEvent);
                                            }
                                            RefreshKernel refreshKernel2 = this.mKernel;
                                            i3 = this.mSpinner;
                                            if (i3 <= 0) {
                                                refreshState5 = RefreshState.PullDownToRefresh;
                                            } else {
                                                refreshState5 = RefreshState.PullDownToRefresh;
                                            }
                                            refreshKernel2.d(refreshState5);
                                            parent = getParent();
                                            if (parent instanceof ViewGroup) {
                                                ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                                            }
                                        }
                                    }
                                }
                                if (this.mIsBeingDragged) {
                                    i2 = ((int) f3) + this.mTouchSpinner;
                                    refreshState3 = this.mViceState;
                                    if (refreshState3.isHeader) {
                                        this.mLastSpinner = i2;
                                        eventTime = motionEvent.getEventTime();
                                        if (this.mFalsifyEvent == null) {
                                            MotionEvent motionEventObtain2 = MotionEvent.obtain(eventTime, eventTime, 0, this.mTouchX + f2, this.mTouchY, 0);
                                            this.mFalsifyEvent = motionEventObtain2;
                                            super.dispatchTouchEvent(motionEventObtain2);
                                        }
                                        motionEventObtain = MotionEvent.obtain(eventTime, eventTime, 2, this.mTouchX + f2, this.mTouchY + i2, 0);
                                        super.dispatchTouchEvent(motionEventObtain);
                                        if (this.mFooterLocked) {
                                            this.mFooterLocked = false;
                                        }
                                        if (i2 <= 0) {
                                            if (i2 < 0) {
                                                i4 = i2;
                                            } else {
                                                i4 = i2;
                                            }
                                        } else if (i2 < 0) {
                                            i4 = i2;
                                        } else {
                                            i4 = i2;
                                        }
                                        refreshState4 = this.mViceState;
                                        if (!refreshState4.isHeader) {
                                            if (this.mFalsifyEvent != null) {
                                                this.mFalsifyEvent = null;
                                                motionEventObtain.setAction(3);
                                                super.dispatchTouchEvent(motionEventObtain);
                                            }
                                            motionEventObtain.recycle();
                                            i2 = i4;
                                        } else {
                                            if (this.mFalsifyEvent != null) {
                                                this.mFalsifyEvent = null;
                                                motionEventObtain.setAction(3);
                                                super.dispatchTouchEvent(motionEventObtain);
                                            }
                                            motionEventObtain.recycle();
                                            i2 = i4;
                                        }
                                        if (this.mSpinner != 0) {
                                            moveSpinnerInfinitely(0.0f);
                                        }
                                        return true;
                                    }
                                    this.mLastSpinner = i2;
                                    eventTime = motionEvent.getEventTime();
                                    if (this.mFalsifyEvent == null) {
                                        MotionEvent motionEventObtain3 = MotionEvent.obtain(eventTime, eventTime, 0, this.mTouchX + f2, this.mTouchY, 0);
                                        this.mFalsifyEvent = motionEventObtain3;
                                        super.dispatchTouchEvent(motionEventObtain3);
                                    }
                                    motionEventObtain = MotionEvent.obtain(eventTime, eventTime, 2, this.mTouchX + f2, this.mTouchY + i2, 0);
                                    super.dispatchTouchEvent(motionEventObtain);
                                    if (this.mFooterLocked) {
                                        this.mFooterLocked = false;
                                    }
                                    if (i2 <= 0) {
                                        if (i2 < 0) {
                                            i4 = i2;
                                        } else {
                                            i4 = i2;
                                        }
                                    } else if (i2 < 0) {
                                        i4 = i2;
                                    } else {
                                        i4 = i2;
                                    }
                                    refreshState4 = this.mViceState;
                                    if (!refreshState4.isHeader) {
                                        if (this.mFalsifyEvent != null) {
                                            this.mFalsifyEvent = null;
                                            motionEventObtain.setAction(3);
                                            super.dispatchTouchEvent(motionEventObtain);
                                        }
                                        motionEventObtain.recycle();
                                        i2 = i4;
                                    } else {
                                        if (this.mFalsifyEvent != null) {
                                            this.mFalsifyEvent = null;
                                            motionEventObtain.setAction(3);
                                            super.dispatchTouchEvent(motionEventObtain);
                                        }
                                        motionEventObtain.recycle();
                                        i2 = i4;
                                    }
                                    if (this.mSpinner != 0) {
                                        moveSpinnerInfinitely(0.0f);
                                    }
                                    return true;
                                    moveSpinnerInfinitely(i2);
                                    return true;
                                }
                                if (this.mFooterLocked) {
                                    this.mFooterLocked = false;
                                }
                            } else if (actionMasked == 3) {
                            }
                            return super.dispatchTouchEvent(motionEvent);
                        }
                        this.mVelocityTracker.addMovement(motionEvent);
                        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                        this.mCurrentVelocity = (int) this.mVelocityTracker.getYVelocity();
                        startFlingIfNeed(0.0f);
                        this.mVelocityTracker.clear();
                        this.mDragDirection = 'n';
                        motionEvent2 = this.mFalsifyEvent;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                            this.mFalsifyEvent = null;
                            long eventTime2 = motionEvent.getEventTime();
                            MotionEvent motionEventObtain4 = MotionEvent.obtain(eventTime2, eventTime2, actionMasked, this.mTouchX, f6, 0);
                            super.dispatchTouchEvent(motionEventObtain4);
                            motionEventObtain4.recycle();
                        }
                        overSpinner();
                        if (this.mIsBeingDragged) {
                            this.mIsBeingDragged = false;
                            return true;
                        }
                        return super.dispatchTouchEvent(motionEvent);
                    }
                }
                return false;
            }
            RefreshState refreshState7 = this.mState;
            if ((!refreshState7.isOpening && !refreshState7.isFinishing) || !refreshState7.isHeader) {
                if (this.mFooterNeedTouchEventWhenLoading) {
                    refreshState6 = this.mState;
                    if (refreshState6.isOpening) {
                        if (refreshState6.isFinishing) {
                        }
                    }
                }
                if (!interceptAnimatorByAction(actionMasked)) {
                    refreshState = this.mState;
                    if (!refreshState.isFinishing && ((refreshState != (refreshState2 = RefreshState.Loading) || !this.mDisableContentWhenLoading) && (refreshState != RefreshState.Refreshing || !this.mDisableContentWhenRefresh))) {
                        if (actionMasked != 0) {
                            this.mCurrentVelocity = 0;
                            this.mVelocityTracker.addMovement(motionEvent);
                            this.mScroller.forceFinished(true);
                            this.mTouchX = f5;
                            this.mTouchY = f6;
                            this.mLastSpinner = 0;
                            this.mTouchSpinner = this.mSpinner;
                            this.mIsBeingDragged = false;
                            this.mEnableDisallowIntercept = false;
                            this.mSuperDispatchTouchEvent = super.dispatchTouchEvent(motionEvent);
                            if (this.mState != RefreshState.TwoLevel && this.mTouchY < (getMeasuredHeight() * 5) / 6) {
                                this.mDragDirection = 'h';
                                return this.mSuperDispatchTouchEvent;
                            }
                            refreshContent = this.mRefreshContent;
                            if (refreshContent != null) {
                                refreshContent.b(motionEvent);
                            }
                            return true;
                        }
                        if (actionMasked != 1) {
                            if (actionMasked != 2) {
                                f2 = f5 - this.mTouchX;
                                f3 = f6 - this.mTouchY;
                                this.mVelocityTracker.addMovement(motionEvent);
                                if (!this.mIsBeingDragged && !this.mEnableDisallowIntercept && (c2 = this.mDragDirection) != 'h' && this.mRefreshContent != null) {
                                    if (c2 != 'v' || (Math.abs(f3) >= this.mTouchSlop && Math.abs(f2) < Math.abs(f3))) {
                                        this.mDragDirection = 'v';
                                        if (f3 <= 0.0f && (this.mSpinner < 0 || ((this.mEnableOverScrollDrag || this.mEnableRefresh) && this.mRefreshContent.d()))) {
                                            this.mIsBeingDragged = true;
                                            this.mTouchY = f6 - this.mTouchSlop;
                                        } else if (f3 < 0.0f && (this.mSpinner > 0 || ((this.mEnableOverScrollDrag || this.mEnableLoadMore) && ((this.mState == refreshState2 && this.mFooterLocked) || this.mRefreshContent.a())))) {
                                            this.mIsBeingDragged = true;
                                            this.mTouchY = this.mTouchSlop + f6;
                                        }
                                        if (this.mIsBeingDragged) {
                                            f3 = f6 - this.mTouchY;
                                            if (this.mSuperDispatchTouchEvent) {
                                                motionEvent.setAction(3);
                                                super.dispatchTouchEvent(motionEvent);
                                            }
                                            RefreshKernel refreshKernel3 = this.mKernel;
                                            i3 = this.mSpinner;
                                            if (i3 <= 0 || (i3 == 0 && f3 > 0.0f)) {
                                                refreshState5 = RefreshState.PullDownToRefresh;
                                            } else {
                                                refreshState5 = RefreshState.PullUpToLoad;
                                            }
                                            refreshKernel3.d(refreshState5);
                                            parent = getParent();
                                            if (parent instanceof ViewGroup) {
                                                ((ViewGroup) parent).requestDisallowInterceptTouchEvent(true);
                                            }
                                        }
                                    } else if (Math.abs(f2) >= this.mTouchSlop && Math.abs(f2) > Math.abs(f3) && this.mDragDirection != 'v') {
                                        this.mDragDirection = 'h';
                                    }
                                }
                                if (this.mIsBeingDragged) {
                                    i2 = ((int) f3) + this.mTouchSpinner;
                                    refreshState3 = this.mViceState;
                                    if ((refreshState3.isHeader && (i2 < 0 || this.mLastSpinner < 0)) || (refreshState3.isFooter && (i2 > 0 || this.mLastSpinner > 0))) {
                                        this.mLastSpinner = i2;
                                        eventTime = motionEvent.getEventTime();
                                        if (this.mFalsifyEvent == null) {
                                            MotionEvent motionEventObtain5 = MotionEvent.obtain(eventTime, eventTime, 0, this.mTouchX + f2, this.mTouchY, 0);
                                            this.mFalsifyEvent = motionEventObtain5;
                                            super.dispatchTouchEvent(motionEventObtain5);
                                        }
                                        motionEventObtain = MotionEvent.obtain(eventTime, eventTime, 2, this.mTouchX + f2, this.mTouchY + i2, 0);
                                        super.dispatchTouchEvent(motionEventObtain);
                                        if (this.mFooterLocked && f3 > this.mTouchSlop && this.mSpinner < 0) {
                                            this.mFooterLocked = false;
                                        }
                                        if (i2 <= 0 && ((this.mEnableOverScrollDrag || this.mEnableRefresh) && this.mRefreshContent.d())) {
                                            this.mLastTouchY = f6;
                                            this.mTouchY = f6;
                                            this.mTouchSpinner = 0;
                                            this.mKernel.d(RefreshState.PullDownToRefresh);
                                        } else if (i2 < 0 || !((this.mEnableOverScrollDrag || this.mEnableLoadMore) && this.mRefreshContent.a())) {
                                            i4 = i2;
                                        } else {
                                            this.mLastTouchY = f6;
                                            this.mTouchY = f6;
                                            this.mTouchSpinner = 0;
                                            this.mKernel.d(RefreshState.PullUpToLoad);
                                        }
                                        refreshState4 = this.mViceState;
                                        if ((!refreshState4.isHeader && i4 < 0) || (refreshState4.isFooter && i4 > 0)) {
                                            if (this.mSpinner != 0) {
                                                moveSpinnerInfinitely(0.0f);
                                            }
                                            return true;
                                        }
                                        if (this.mFalsifyEvent != null) {
                                            this.mFalsifyEvent = null;
                                            motionEventObtain.setAction(3);
                                            super.dispatchTouchEvent(motionEventObtain);
                                        }
                                        motionEventObtain.recycle();
                                        i2 = i4;
                                    }
                                    moveSpinnerInfinitely(i2);
                                    return true;
                                }
                                if (this.mFooterLocked && f3 > this.mTouchSlop && this.mSpinner < 0) {
                                    this.mFooterLocked = false;
                                }
                            } else if (actionMasked == 3) {
                            }
                            return super.dispatchTouchEvent(motionEvent);
                        }
                        this.mVelocityTracker.addMovement(motionEvent);
                        this.mVelocityTracker.computeCurrentVelocity(1000, this.mMaximumVelocity);
                        this.mCurrentVelocity = (int) this.mVelocityTracker.getYVelocity();
                        startFlingIfNeed(0.0f);
                        this.mVelocityTracker.clear();
                        this.mDragDirection = 'n';
                        motionEvent2 = this.mFalsifyEvent;
                        if (motionEvent2 != null) {
                            motionEvent2.recycle();
                            this.mFalsifyEvent = null;
                            long eventTime3 = motionEvent.getEventTime();
                            MotionEvent motionEventObtain6 = MotionEvent.obtain(eventTime3, eventTime3, actionMasked, this.mTouchX, f6, 0);
                            super.dispatchTouchEvent(motionEventObtain6);
                            motionEventObtain6.recycle();
                        }
                        overSpinner();
                        if (this.mIsBeingDragged) {
                            this.mIsBeingDragged = false;
                            return true;
                        }
                        return super.dispatchTouchEvent(motionEvent);
                    }
                }
                return false;
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.ViewGroup
    public boolean drawChild(Canvas canvas, View view, long j2) {
        Paint paint;
        Paint paint2;
        RefreshContent refreshContent = this.mRefreshContent;
        View view2 = refreshContent != null ? refreshContent.getView() : null;
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null && refreshInternal.getView() == view) {
            if (!isEnableRefreshOrLoadMore(this.mEnableRefresh) || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int iMax = Math.max(view2.getTop() + view2.getPaddingTop() + this.mSpinner, view.getTop());
                int i2 = this.mHeaderBackgroundColor;
                if (i2 != 0 && (paint2 = this.mPaint) != null) {
                    paint2.setColor(i2);
                    if (this.mRefreshHeader.getSpinnerStyle() == xm8.b) {
                        iMax = view.getBottom();
                    } else if (this.mRefreshHeader.getSpinnerStyle() == xm8.f45853a) {
                        iMax = view.getBottom() + this.mSpinner;
                    }
                    canvas.drawRect(0.0f, view.getTop(), getWidth(), iMax, this.mPaint);
                }
                if (this.mEnableClipHeaderWhenFixedBehind && this.mRefreshHeader.getSpinnerStyle() == xm8.c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), view.getTop(), view.getRight(), iMax);
                    boolean zDrawChild = super.drawChild(canvas, view, j2);
                    canvas.restore();
                    return zDrawChild;
                }
            }
        }
        RefreshInternal refreshInternal2 = this.mRefreshFooter;
        if (refreshInternal2 != null && refreshInternal2.getView() == view) {
            if (!isEnableRefreshOrLoadMore(this.mEnableLoadMore) || (!this.mEnablePreviewInEditMode && isInEditMode())) {
                return true;
            }
            if (view2 != null) {
                int iMin = Math.min((view2.getBottom() - view2.getPaddingBottom()) + this.mSpinner, view.getBottom());
                int i3 = this.mFooterBackgroundColor;
                if (i3 != 0 && (paint = this.mPaint) != null) {
                    paint.setColor(i3);
                    if (this.mRefreshFooter.getSpinnerStyle() == xm8.b) {
                        iMin = view.getTop();
                    } else if (this.mRefreshFooter.getSpinnerStyle() == xm8.f45853a) {
                        iMin = view.getTop() + this.mSpinner;
                    }
                    canvas.drawRect(0.0f, iMin, getWidth(), view.getBottom(), this.mPaint);
                }
                if (this.mEnableClipFooterWhenFixedBehind && this.mRefreshFooter.getSpinnerStyle() == xm8.c) {
                    canvas.save();
                    canvas.clipRect(view.getLeft(), iMin, view.getRight(), view.getBottom());
                    boolean zDrawChild2 = super.drawChild(canvas, view, j2);
                    canvas.restore();
                    return zDrawChild2;
                }
            }
        }
        return super.drawChild(canvas, view, j2);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishLoadMore() {
        return finishLoadMore(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300));
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishLoadMoreWithNoMoreData() {
        return finishLoadMore(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300), true, true);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishRefresh() {
        return finishRefresh(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300));
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishRefreshWithNoMoreData() {
        return finishRefresh(Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300), true, Boolean.TRUE);
    }

    @Override // android.view.ViewGroup
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @NonNull
    public ViewGroup getLayout() {
        return this;
    }

    @Override // android.view.ViewGroup, androidx.core.view.NestedScrollingParent
    public int getNestedScrollAxes() {
        return this.mNestedParent.getNestedScrollAxes();
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @Nullable
    public RefreshFooter getRefreshFooter() {
        RefreshInternal refreshInternal = this.mRefreshFooter;
        if (refreshInternal instanceof RefreshFooter) {
            return (RefreshFooter) refreshInternal;
        }
        return null;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @Nullable
    public RefreshHeader getRefreshHeader() {
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal instanceof RefreshHeader) {
            return (RefreshHeader) refreshInternal;
        }
        return null;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @NonNull
    public RefreshState getState() {
        return this.mState;
    }

    public boolean interceptAnimatorByAction(int i2) {
        if (i2 == 0) {
            if (this.reboundAnimator != null) {
                RefreshState refreshState = this.mState;
                if (refreshState.isFinishing || refreshState == RefreshState.TwoLevelReleased) {
                    return true;
                }
                if (refreshState == RefreshState.PullDownCanceled) {
                    this.mKernel.d(RefreshState.PullDownToRefresh);
                } else if (refreshState == RefreshState.PullUpCanceled) {
                    this.mKernel.d(RefreshState.PullUpToLoad);
                }
                this.reboundAnimator.cancel();
                this.reboundAnimator = null;
            }
            this.animationRunnable = null;
        }
        return this.reboundAnimator != null;
    }

    public boolean isEnableRefreshOrLoadMore(boolean z) {
        return z && !this.mEnablePureScrollMode;
    }

    public boolean isEnableTranslationContent(boolean z, RefreshInternal refreshInternal) {
        return z || this.mEnablePureScrollMode || refreshInternal == null || refreshInternal.getSpinnerStyle() == xm8.c;
    }

    @Override // android.view.View
    public boolean isNestedScrollingEnabled() {
        return this.mEnableNestedScrolling;
    }

    public void moveSpinnerInfinitely(float f2) {
        RefreshState refreshState;
        float f3 = (!this.mNestedInProgress || this.mEnableLoadMoreWhenContentNotFull || f2 >= 0.0f || this.mRefreshContent.a()) ? f2 : 0.0f;
        if (f3 > this.mScreenHeightPixels * 3 && getTag() == null) {
            Toast.makeText(getContext(), "你这么死拉，臣妾做不到啊！", 0).show();
            setTag("你这么死拉，臣妾做不到啊！");
        }
        RefreshState refreshState2 = this.mState;
        if (refreshState2 == RefreshState.TwoLevel && f3 > 0.0f) {
            this.mKernel.i(Math.min((int) f3, getMeasuredHeight()), true);
        } else if (refreshState2 == RefreshState.Refreshing && f3 >= 0.0f) {
            int i2 = this.mHeaderHeight;
            if (f3 < i2) {
                this.mKernel.i((int) f3, true);
            } else {
                double d2 = (this.mHeaderMaxDragRate - 1.0f) * i2;
                int iMax = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i3 = this.mHeaderHeight;
                double d3 = iMax - i3;
                double dMax = Math.max(0.0f, (f3 - i3) * this.mDragRate);
                double d4 = -dMax;
                if (d3 == AudioStats.AUDIO_AMPLITUDE_NONE) {
                    d3 = 1.0d;
                }
                this.mKernel.i(((int) Math.min(d2 * (1.0d - Math.pow(100.0d, d4 / d3)), dMax)) + this.mHeaderHeight, true);
            }
        } else if (f3 < 0.0f && (refreshState2 == RefreshState.Loading || ((this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) || (this.mEnableAutoLoadMore && !this.mFooterNoMoreData && isEnableRefreshOrLoadMore(this.mEnableLoadMore))))) {
            int i4 = this.mFooterHeight;
            if (f3 > (-i4)) {
                this.mKernel.i((int) f3, true);
            } else {
                double d5 = (this.mFooterMaxDragRate - 1.0f) * i4;
                int iMax2 = Math.max((this.mScreenHeightPixels * 4) / 3, getHeight());
                int i5 = this.mFooterHeight;
                double d6 = iMax2 - i5;
                double d7 = -Math.min(0.0f, (i5 + f3) * this.mDragRate);
                double d8 = -d7;
                if (d6 == AudioStats.AUDIO_AMPLITUDE_NONE) {
                    d6 = 1.0d;
                }
                this.mKernel.i(((int) (-Math.min(d5 * (1.0d - Math.pow(100.0d, d8 / d6)), d7))) - this.mFooterHeight, true);
            }
        } else if (f3 >= 0.0f) {
            double d9 = this.mHeaderMaxDragRate * this.mHeaderHeight;
            double dMax2 = Math.max(this.mScreenHeightPixels / 2, getHeight());
            double dMax3 = Math.max(0.0f, this.mDragRate * f3);
            double d10 = -dMax3;
            if (dMax2 == AudioStats.AUDIO_AMPLITUDE_NONE) {
                dMax2 = 1.0d;
            }
            this.mKernel.i((int) Math.min(d9 * (1.0d - Math.pow(100.0d, d10 / dMax2)), dMax3), true);
        } else {
            double d11 = this.mFooterMaxDragRate * this.mFooterHeight;
            double dMax4 = Math.max(this.mScreenHeightPixels / 2, getHeight());
            double d12 = -Math.min(0.0f, this.mDragRate * f3);
            double d13 = -d12;
            if (dMax4 == AudioStats.AUDIO_AMPLITUDE_NONE) {
                dMax4 = 1.0d;
            }
            this.mKernel.i((int) (-Math.min(d11 * (1.0d - Math.pow(100.0d, d13 / dMax4)), d12)), true);
        }
        if (!this.mEnableAutoLoadMore || this.mFooterNoMoreData || !isEnableRefreshOrLoadMore(this.mEnableLoadMore) || f3 >= 0.0f || (refreshState = this.mState) == RefreshState.Refreshing || refreshState == RefreshState.Loading || refreshState == RefreshState.LoadFinish) {
            return;
        }
        if (this.mDisableContentWhenLoading) {
            this.animationRunnable = null;
            this.mKernel.b(-this.mFooterHeight);
        }
        setStateDirectLoading(false);
        this.mHandler.postDelayed(new f(), this.mReboundDuration);
    }

    public void notifyStateChanged(RefreshState refreshState) {
        RefreshState refreshState2 = this.mState;
        if (refreshState2 == refreshState) {
            if (this.mViceState != refreshState2) {
                this.mViceState = refreshState2;
                return;
            }
            return;
        }
        this.mState = refreshState;
        this.mViceState = refreshState;
        RefreshInternal refreshInternal = this.mRefreshHeader;
        RefreshInternal refreshInternal2 = this.mRefreshFooter;
        OnMultiPurposeListener onMultiPurposeListener = this.mOnMultiPurposeListener;
        if (refreshInternal != null) {
            refreshInternal.onStateChanged(this, refreshState2, refreshState);
        }
        if (refreshInternal2 != null) {
            refreshInternal2.onStateChanged(this, refreshState2, refreshState);
        }
        if (onMultiPurposeListener != null) {
            onMultiPurposeListener.onStateChanged(this, refreshState2, refreshState);
        }
        if (refreshState == RefreshState.LoadFinish) {
            this.mFooterLocked = false;
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        RefreshInternal refreshInternal;
        super.onAttachedToWindow();
        boolean z = true;
        this.mAttachedToWindow = true;
        if (!isInEditMode()) {
            if (this.mRefreshHeader == null) {
                DefaultRefreshHeaderCreator defaultRefreshHeaderCreator = sHeaderCreator;
                if (defaultRefreshHeaderCreator != null) {
                    setRefreshHeader(defaultRefreshHeaderCreator.a(getContext(), this));
                } else {
                    setRefreshHeader(new BezierRadarHeader(getContext()));
                }
            }
            if (this.mRefreshFooter == null) {
                DefaultRefreshFooterCreator defaultRefreshFooterCreator = sFooterCreator;
                if (defaultRefreshFooterCreator != null) {
                    setRefreshFooter(defaultRefreshFooterCreator.a(getContext(), this));
                } else {
                    boolean z2 = this.mEnableLoadMore;
                    setRefreshFooter(new BallPulseFooter(getContext()));
                    this.mEnableLoadMore = z2;
                }
            } else {
                if (!this.mEnableLoadMore && this.mManualLoadMore) {
                    z = false;
                }
                this.mEnableLoadMore = z;
            }
            if (this.mRefreshContent == null) {
                int childCount = getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = getChildAt(i2);
                    RefreshInternal refreshInternal2 = this.mRefreshHeader;
                    if ((refreshInternal2 == null || childAt != refreshInternal2.getView()) && ((refreshInternal = this.mRefreshFooter) == null || childAt != refreshInternal.getView())) {
                        this.mRefreshContent = new td7(childAt);
                    }
                }
            }
            if (this.mRefreshContent == null) {
                int iD = qk8.d(20.0f);
                TextView textView = new TextView(getContext());
                textView.setTextColor(-39424);
                textView.setGravity(17);
                textView.setTextSize(20.0f);
                textView.setText(R.string.srl_content_empty);
                super.addView(textView, -1, -1);
                td7 td7Var = new td7(textView);
                this.mRefreshContent = td7Var;
                td7Var.getView().setPadding(iD, iD, iD, iD);
            }
            int i3 = this.mFixedHeaderViewId;
            View viewFindViewById = i3 > 0 ? findViewById(i3) : null;
            int i4 = this.mFixedFooterViewId;
            View viewFindViewById2 = i4 > 0 ? findViewById(i4) : null;
            this.mRefreshContent.f(this.mScrollBoundaryDecider);
            this.mRefreshContent.i(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.h(this.mKernel, viewFindViewById, viewFindViewById2);
            if (this.mSpinner != 0) {
                notifyStateChanged(RefreshState.None);
                RefreshContent refreshContent = this.mRefreshContent;
                this.mSpinner = 0;
                refreshContent.e(0, this.mHeaderTranslationViewId, this.mFooterTranslationViewId);
            }
        }
        int[] iArr = this.mPrimaryColors;
        if (iArr != null) {
            RefreshInternal refreshInternal3 = this.mRefreshHeader;
            if (refreshInternal3 != null) {
                refreshInternal3.setPrimaryColors(iArr);
            }
            RefreshInternal refreshInternal4 = this.mRefreshFooter;
            if (refreshInternal4 != null) {
                refreshInternal4.setPrimaryColors(this.mPrimaryColors);
            }
        }
        RefreshContent refreshContent2 = this.mRefreshContent;
        if (refreshContent2 != null) {
            super.bringChildToFront(refreshContent2.getView());
        }
        RefreshInternal refreshInternal5 = this.mRefreshHeader;
        if (refreshInternal5 != null && refreshInternal5.getSpinnerStyle() != xm8.c) {
            super.bringChildToFront(this.mRefreshHeader.getView());
        }
        RefreshInternal refreshInternal6 = this.mRefreshFooter;
        if (refreshInternal6 == null || refreshInternal6.getSpinnerStyle() == xm8.c) {
            return;
        }
        super.bringChildToFront(this.mRefreshFooter.getView());
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.mAttachedToWindow = false;
        this.mKernel.i(0, true);
        notifyStateChanged(RefreshState.None);
        Handler handler = this.mHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.mManualLoadMore = true;
        this.animationRunnable = null;
        ValueAnimator valueAnimator = this.reboundAnimator;
        if (valueAnimator != null) {
            valueAnimator.removeAllListeners();
            this.reboundAnimator.removeAllUpdateListeners();
            this.reboundAnimator.cancel();
            this.reboundAnimator = null;
        }
        this.mFooterLocked = false;
    }

    /* JADX WARN: Code duplicated, block: B:29:0x004d  */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // android.view.View
    public void onFinishInflate() {
        int i2;
        int i3;
        super.onFinishInflate();
        int childCount = super.getChildCount();
        if (childCount > 3) {
            throw new RuntimeException("最多只支持3个子View，Most only support three sub view");
        }
        int i4 = -1;
        int i5 = 0;
        char c2 = 0;
        while (true) {
            if (i5 >= childCount) {
                break;
            }
            View childAt = super.getChildAt(i5);
            if (qk8.f(childAt) && (c2 < 2 || i5 == 1)) {
                i4 = i5;
                c2 = 2;
            } else if (!(childAt instanceof RefreshInternal) && c2 < 1) {
                c2 = i5 > 0 ? (char) 1 : (char) 0;
                i4 = i5;
            }
            i5++;
        }
        if (i4 >= 0) {
            this.mRefreshContent = new td7(super.getChildAt(i4));
            if (i4 == 1) {
                i3 = childCount != 3 ? -1 : 2;
                i2 = 0;
            } else if (childCount == 2) {
                i2 = -1;
                i3 = 1;
            } else {
                i2 = -1;
                i3 = -1;
            }
        } else {
            i2 = -1;
            i3 = -1;
        }
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt2 = super.getChildAt(i6);
            if (i6 == i2 || (i6 != i3 && i2 == -1 && this.mRefreshHeader == null && (childAt2 instanceof RefreshHeader))) {
                this.mRefreshHeader = childAt2 instanceof RefreshHeader ? (RefreshHeader) childAt2 : new RefreshHeaderWrapper(childAt2);
            } else if (i6 == i3 || (i3 == -1 && (childAt2 instanceof RefreshFooter))) {
                this.mEnableLoadMore = this.mEnableLoadMore || !this.mManualLoadMore;
                this.mRefreshFooter = childAt2 instanceof RefreshFooter ? (RefreshFooter) childAt2 : new RefreshFooterWrapper(childAt2);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onLayout(boolean z, int i2, int i3, int i4, int i5) {
        int iMax;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        getPaddingBottom();
        int childCount = super.getChildCount();
        for (int i6 = 0; i6 < childCount; i6++) {
            View childAt = super.getChildAt(i6);
            if (childAt.getVisibility() != 8 && childAt.getTag(R.string.srl_component_falsify) != childAt) {
                RefreshContent refreshContent = this.mRefreshContent;
                if (refreshContent != null && refreshContent.getView() == childAt) {
                    boolean z2 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableRefresh) && this.mRefreshHeader != null;
                    View view = this.mRefreshContent.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    int i7 = marginLayoutParams.leftMargin + paddingLeft;
                    int i8 = marginLayoutParams.topMargin + paddingTop;
                    int measuredWidth = view.getMeasuredWidth() + i7;
                    int measuredHeight = view.getMeasuredHeight() + i8;
                    if (z2 && isEnableTranslationContent(this.mEnableHeaderTranslationContent, this.mRefreshHeader)) {
                        int i9 = this.mHeaderHeight;
                        i8 += i9;
                        measuredHeight += i9;
                    }
                    view.layout(i7, i8, measuredWidth, measuredHeight);
                }
                RefreshInternal refreshInternal = this.mRefreshHeader;
                if (refreshInternal != null && refreshInternal.getView() == childAt) {
                    boolean z3 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableRefresh);
                    View view2 = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : sDefaultMarginLP;
                    int i10 = marginLayoutParams2.leftMargin;
                    int i11 = marginLayoutParams2.topMargin + this.mHeaderInsetStart;
                    int measuredWidth2 = view2.getMeasuredWidth() + i10;
                    int measuredHeight2 = view2.getMeasuredHeight() + i11;
                    if (!z3 && this.mRefreshHeader.getSpinnerStyle() == xm8.f45853a) {
                        int i12 = this.mHeaderHeight;
                        i11 -= i12;
                        measuredHeight2 -= i12;
                    }
                    view2.layout(i10, i11, measuredWidth2, measuredHeight2);
                }
                RefreshInternal refreshInternal2 = this.mRefreshFooter;
                if (refreshInternal2 != null && refreshInternal2.getView() == childAt) {
                    boolean z4 = isInEditMode() && this.mEnablePreviewInEditMode && isEnableRefreshOrLoadMore(this.mEnableLoadMore);
                    View view3 = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : sDefaultMarginLP;
                    xm8 spinnerStyle = this.mRefreshFooter.getSpinnerStyle();
                    int i13 = marginLayoutParams3.leftMargin;
                    int measuredHeight3 = (marginLayoutParams3.topMargin + getMeasuredHeight()) - this.mFooterInsetStart;
                    if (this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && this.mEnableFooterFollowWhenNoMoreData && this.mRefreshContent != null && this.mRefreshFooter.getSpinnerStyle() == xm8.f45853a && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                        View view4 = this.mRefreshContent.getView();
                        ViewGroup.LayoutParams layoutParams4 = view4.getLayoutParams();
                        measuredHeight3 = view4.getMeasuredHeight() + paddingTop + paddingTop + (layoutParams4 instanceof ViewGroup.MarginLayoutParams ? ((ViewGroup.MarginLayoutParams) layoutParams4).topMargin : 0);
                    }
                    if (spinnerStyle == xm8.e) {
                        measuredHeight3 = marginLayoutParams3.topMargin - this.mFooterInsetStart;
                    } else {
                        if (z4 || spinnerStyle == xm8.d || spinnerStyle == xm8.c) {
                            iMax = this.mFooterHeight;
                        } else if (spinnerStyle == xm8.b && this.mSpinner < 0) {
                            iMax = Math.max(isEnableRefreshOrLoadMore(this.mEnableLoadMore) ? -this.mSpinner : 0, 0);
                        }
                        measuredHeight3 -= iMax;
                    }
                    view3.layout(i13, measuredHeight3, view3.getMeasuredWidth() + i13, view3.getMeasuredHeight() + measuredHeight3);
                }
            }
        }
    }

    /* JADX WARN: Code duplicated, block: B:109:0x020c  */
    /* JADX WARN: Code duplicated, block: B:112:0x0225  */
    @Override // android.view.View
    public void onMeasure(int i2, int i3) {
        int i4;
        int iMax;
        un2 un2Var;
        int i5;
        int i6;
        boolean z = isInEditMode() && this.mEnablePreviewInEditMode;
        int childCount = super.getChildCount();
        int measuredHeight = 0;
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = super.getChildAt(i7);
            if (childAt.getVisibility() != 8 && childAt.getTag(R.string.srl_component_falsify) != childAt) {
                RefreshInternal refreshInternal = this.mRefreshHeader;
                if (refreshInternal != null && refreshInternal.getView() == childAt) {
                    View view = this.mRefreshHeader.getView();
                    ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams = layoutParams instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams : sDefaultMarginLP;
                    int childMeasureSpec = ViewGroup.getChildMeasureSpec(i2, marginLayoutParams.leftMargin + marginLayoutParams.rightMargin, layoutParams.width);
                    int iMax2 = this.mHeaderHeight;
                    un2 un2Var2 = this.mHeaderHeightStatus;
                    if (un2Var2.f20110a < un2.g.f20110a) {
                        int i8 = layoutParams.height;
                        if (i8 > 0) {
                            int i9 = i8 + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                            un2 un2Var3 = un2.e;
                            if (un2Var2.a(un2Var3)) {
                                this.mHeaderHeight = layoutParams.height + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                this.mHeaderHeightStatus = un2Var3;
                            }
                            iMax2 = i9;
                        } else if (i8 == -2 && (this.mRefreshHeader.getSpinnerStyle() != xm8.e || !this.mHeaderHeightStatus.f20111a)) {
                            int iMax3 = Math.max((View.MeasureSpec.getSize(i3) - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, 0);
                            view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(iMax3, Integer.MIN_VALUE));
                            int measuredHeight2 = view.getMeasuredHeight();
                            if (measuredHeight2 > 0) {
                                if (measuredHeight2 != iMax3) {
                                    un2 un2Var4 = this.mHeaderHeightStatus;
                                    un2 un2Var5 = un2.c;
                                    if (un2Var4.a(un2Var5)) {
                                        this.mHeaderHeight = measuredHeight2 + marginLayoutParams.bottomMargin + marginLayoutParams.topMargin;
                                        this.mHeaderHeightStatus = un2Var5;
                                    }
                                }
                                iMax2 = -1;
                            }
                        }
                    }
                    if (this.mRefreshHeader.getSpinnerStyle() == xm8.e) {
                        iMax2 = View.MeasureSpec.getSize(i3);
                        i6 = -1;
                        i5 = 0;
                    } else {
                        if (this.mRefreshHeader.getSpinnerStyle() != xm8.b || z) {
                            i5 = 0;
                        } else {
                            i5 = 0;
                            iMax2 = Math.max(0, isEnableRefreshOrLoadMore(this.mEnableRefresh) ? this.mSpinner : 0);
                        }
                        i6 = -1;
                    }
                    if (iMax2 != i6) {
                        view.measure(childMeasureSpec, View.MeasureSpec.makeMeasureSpec(Math.max((iMax2 - marginLayoutParams.bottomMargin) - marginLayoutParams.topMargin, i5), 1073741824));
                    }
                    un2 un2Var6 = this.mHeaderHeightStatus;
                    if (!un2Var6.f20111a) {
                        this.mHeaderHeightStatus = un2Var6.b();
                        RefreshInternal refreshInternal2 = this.mRefreshHeader;
                        RefreshKernel refreshKernel = this.mKernel;
                        int i10 = this.mHeaderHeight;
                        refreshInternal2.onInitialized(refreshKernel, i10, (int) (this.mHeaderMaxDragRate * i10));
                    }
                    if (z && isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
                        measuredHeight += view.getMeasuredHeight();
                    }
                }
                RefreshInternal refreshInternal3 = this.mRefreshFooter;
                if (refreshInternal3 == null || refreshInternal3.getView() != childAt) {
                    i4 = 0;
                } else {
                    View view2 = this.mRefreshFooter.getView();
                    ViewGroup.LayoutParams layoutParams2 = view2.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams2 = layoutParams2 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams2 : sDefaultMarginLP;
                    int childMeasureSpec2 = ViewGroup.getChildMeasureSpec(i2, marginLayoutParams2.leftMargin + marginLayoutParams2.rightMargin, layoutParams2.width);
                    int i11 = this.mFooterHeight;
                    un2 un2Var7 = this.mFooterHeightStatus;
                    if (un2Var7.f20110a >= un2.g.f20110a) {
                        iMax = i11;
                    } else {
                        int i12 = layoutParams2.height;
                        if (i12 > 0) {
                            i11 = marginLayoutParams2.bottomMargin + i12 + marginLayoutParams2.topMargin;
                            un2 un2Var8 = un2.e;
                            if (un2Var7.a(un2Var8)) {
                                this.mFooterHeight = layoutParams2.height + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                this.mFooterHeightStatus = un2Var8;
                            }
                        } else if (i12 == -2 && (this.mRefreshFooter.getSpinnerStyle() != xm8.e || !this.mFooterHeightStatus.f20111a)) {
                            int iMax4 = Math.max((View.MeasureSpec.getSize(i3) - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, 0);
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(iMax4, Integer.MIN_VALUE));
                            int measuredHeight3 = view2.getMeasuredHeight();
                            if (measuredHeight3 > 0) {
                                if (measuredHeight3 != iMax4) {
                                    un2 un2Var9 = this.mFooterHeightStatus;
                                    un2 un2Var10 = un2.c;
                                    if (un2Var9.a(un2Var10)) {
                                        this.mFooterHeight = measuredHeight3 + marginLayoutParams2.topMargin + marginLayoutParams2.bottomMargin;
                                        this.mFooterHeightStatus = un2Var10;
                                    }
                                }
                                iMax = -1;
                            }
                        }
                        iMax = i11;
                    }
                    if (this.mRefreshFooter.getSpinnerStyle() == xm8.e) {
                        iMax = View.MeasureSpec.getSize(i3);
                    } else {
                        if (this.mRefreshFooter.getSpinnerStyle() == xm8.b && !z) {
                            i4 = 0;
                            iMax = Math.max(0, isEnableRefreshOrLoadMore(this.mEnableLoadMore) ? -this.mSpinner : 0);
                        }
                        if (iMax != -1) {
                            view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((iMax - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, i4), 1073741824));
                        }
                        un2Var = this.mFooterHeightStatus;
                        if (!un2Var.f20111a) {
                            this.mFooterHeightStatus = un2Var.b();
                            RefreshInternal refreshInternal4 = this.mRefreshFooter;
                            RefreshKernel refreshKernel2 = this.mKernel;
                            int i13 = this.mFooterHeight;
                            refreshInternal4.onInitialized(refreshKernel2, i13, (int) (this.mFooterMaxDragRate * i13));
                        }
                        if (z && isEnableRefreshOrLoadMore(this.mEnableLoadMore)) {
                            measuredHeight += view2.getMeasuredHeight();
                        }
                    }
                    i4 = 0;
                    if (iMax != -1) {
                        view2.measure(childMeasureSpec2, View.MeasureSpec.makeMeasureSpec(Math.max((iMax - marginLayoutParams2.bottomMargin) - marginLayoutParams2.topMargin, i4), 1073741824));
                    }
                    un2Var = this.mFooterHeightStatus;
                    if (!un2Var.f20111a) {
                        this.mFooterHeightStatus = un2Var.b();
                        RefreshInternal refreshInternal5 = this.mRefreshFooter;
                        RefreshKernel refreshKernel3 = this.mKernel;
                        int i14 = this.mFooterHeight;
                        refreshInternal5.onInitialized(refreshKernel3, i14, (int) (this.mFooterMaxDragRate * i14));
                    }
                    if (z) {
                        measuredHeight += view2.getMeasuredHeight();
                    }
                }
                RefreshContent refreshContent = this.mRefreshContent;
                if (refreshContent != null && refreshContent.getView() == childAt) {
                    View view3 = this.mRefreshContent.getView();
                    ViewGroup.LayoutParams layoutParams3 = view3.getLayoutParams();
                    ViewGroup.MarginLayoutParams marginLayoutParams3 = layoutParams3 instanceof ViewGroup.MarginLayoutParams ? (ViewGroup.MarginLayoutParams) layoutParams3 : sDefaultMarginLP;
                    view3.measure(ViewGroup.getChildMeasureSpec(i2, getPaddingLeft() + getPaddingRight() + marginLayoutParams3.leftMargin + marginLayoutParams3.rightMargin, layoutParams3.width), ViewGroup.getChildMeasureSpec(i3, getPaddingTop() + getPaddingBottom() + marginLayoutParams3.topMargin + marginLayoutParams3.bottomMargin + ((!z || ((this.mRefreshHeader == null || !isEnableRefreshOrLoadMore(this.mEnableRefresh) || !isEnableTranslationContent(this.mEnableHeaderTranslationContent, this.mRefreshHeader)) ? i4 : 1) == 0) ? i4 : this.mHeaderHeight) + ((!z || ((this.mRefreshFooter == null || !isEnableRefreshOrLoadMore(this.mEnableLoadMore) || !isEnableTranslationContent(this.mEnableFooterTranslationContent, this.mRefreshFooter)) ? i4 : 1) == 0) ? i4 : this.mFooterHeight), layoutParams3.height));
                    measuredHeight += view3.getMeasuredHeight();
                }
            }
        }
        super.setMeasuredDimension(View.resolveSize(super.getSuggestedMinimumWidth(), i2), View.resolveSize(measuredHeight, i3));
        this.mLastTouchX = getMeasuredWidth() / 2.0f;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedFling(@NonNull View view, float f2, float f3, boolean z) {
        return this.mNestedChild.dispatchNestedFling(f2, f3, z);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onNestedPreFling(@NonNull View view, float f2, float f3) {
        return (this.mFooterLocked && f3 > 0.0f) || startFlingIfNeed(-f3) || this.mNestedChild.dispatchNestedPreFling(f2, f3);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedPreScroll(@NonNull View view, int i2, int i3, @NonNull int[] iArr) {
        int i4 = this.mTotalUnconsumed;
        int i5 = 0;
        if (i3 * i4 > 0) {
            if (Math.abs(i3) > Math.abs(this.mTotalUnconsumed)) {
                int i6 = this.mTotalUnconsumed;
                this.mTotalUnconsumed = 0;
                i5 = i6;
            } else {
                this.mTotalUnconsumed -= i3;
                i5 = i3;
            }
            moveSpinnerInfinitely(this.mTotalUnconsumed);
        } else if (i3 > 0 && this.mFooterLocked) {
            int i7 = i4 - i3;
            this.mTotalUnconsumed = i7;
            moveSpinnerInfinitely(i7);
            i5 = i3;
        }
        this.mNestedChild.dispatchNestedPreScroll(i2, i3 - i5, iArr, null);
        iArr[1] = iArr[1] + i5;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScroll(@NonNull View view, int i2, int i3, int i4, int i5) {
        this.mNestedChild.dispatchNestedScroll(i2, i3, i4, i5, this.mParentOffsetInWindow);
        int i6 = i5 + this.mParentOffsetInWindow[1];
        if ((i6 < 0 && (this.mEnableRefresh || this.mEnableOverScrollDrag)) || (i6 > 0 && (this.mEnableLoadMore || this.mEnableOverScrollDrag))) {
            RefreshState refreshState = this.mViceState;
            if (refreshState == RefreshState.None || refreshState.isOpening) {
                this.mKernel.d(i6 > 0 ? RefreshState.PullUpToLoad : RefreshState.PullDownToRefresh);
            }
            int i7 = this.mTotalUnconsumed - i6;
            this.mTotalUnconsumed = i7;
            moveSpinnerInfinitely(i7);
        }
        if (!this.mFooterLocked || i3 >= 0) {
            return;
        }
        this.mFooterLocked = false;
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onNestedScrollAccepted(@NonNull View view, @NonNull View view2, int i2) {
        this.mNestedParent.onNestedScrollAccepted(view, view2, i2);
        this.mNestedChild.startNestedScroll(i2 & 2);
        this.mTotalUnconsumed = this.mSpinner;
        this.mNestedInProgress = true;
        interceptAnimatorByAction(0);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public boolean onStartNestedScroll(@NonNull View view, @NonNull View view2, int i2) {
        return (isEnabled() && isNestedScrollingEnabled() && (i2 & 2) != 0) && (this.mEnableOverScrollDrag || this.mEnableRefresh || this.mEnableLoadMore);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent, androidx.core.view.NestedScrollingParent
    public void onStopNestedScroll(@NonNull View view) {
        this.mNestedParent.onStopNestedScroll(view);
        this.mNestedInProgress = false;
        this.mTotalUnconsumed = 0;
        overSpinner();
        this.mNestedChild.stopNestedScroll();
    }

    public void overSpinner() {
        RefreshState refreshState = this.mState;
        if (refreshState == RefreshState.TwoLevel) {
            if (this.mCurrentVelocity <= -1000 || this.mSpinner <= getMeasuredHeight() / 2) {
                if (this.mIsBeingDragged) {
                    this.mKernel.a();
                    return;
                }
                return;
            } else {
                ValueAnimator valueAnimatorB = this.mKernel.b(getMeasuredHeight());
                if (valueAnimatorB != null) {
                    valueAnimatorB.setDuration(this.mFloorDuration);
                    return;
                }
                return;
            }
        }
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState == refreshState2 || (this.mEnableFooterFollowWhenNoMoreData && this.mFooterNoMoreData && this.mFooterNoMoreDataEffective && this.mSpinner < 0 && isEnableRefreshOrLoadMore(this.mEnableLoadMore))) {
            int i2 = this.mSpinner;
            int i3 = this.mFooterHeight;
            if (i2 < (-i3)) {
                this.mKernel.b(-i3);
                return;
            } else {
                if (i2 > 0) {
                    this.mKernel.b(0);
                    return;
                }
                return;
            }
        }
        RefreshState refreshState3 = this.mState;
        RefreshState refreshState4 = RefreshState.Refreshing;
        if (refreshState3 == refreshState4) {
            int i4 = this.mSpinner;
            int i5 = this.mHeaderHeight;
            if (i4 > i5) {
                this.mKernel.b(i5);
                return;
            } else {
                if (i4 < 0) {
                    this.mKernel.b(0);
                    return;
                }
                return;
            }
        }
        if (refreshState3 == RefreshState.PullDownToRefresh) {
            this.mKernel.d(RefreshState.PullDownCanceled);
            return;
        }
        if (refreshState3 == RefreshState.PullUpToLoad) {
            this.mKernel.d(RefreshState.PullUpCanceled);
            return;
        }
        if (refreshState3 == RefreshState.ReleaseToRefresh) {
            this.mKernel.d(refreshState4);
            return;
        }
        if (refreshState3 == RefreshState.ReleaseToLoad) {
            this.mKernel.d(refreshState2);
            return;
        }
        if (refreshState3 == RefreshState.ReleaseToTwoLevel) {
            this.mKernel.d(RefreshState.TwoLevelReleased);
            return;
        }
        if (refreshState3 == RefreshState.RefreshReleased) {
            if (this.reboundAnimator == null) {
                this.mKernel.b(this.mHeaderHeight);
            }
        } else if (refreshState3 == RefreshState.LoadReleased) {
            if (this.reboundAnimator == null) {
                this.mKernel.b(-this.mFooterHeight);
            }
        } else if (this.mSpinner != 0) {
            this.mKernel.b(0);
        }
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void requestDisallowInterceptTouchEvent(boolean z) {
        this.mEnableDisallowIntercept = z;
        super.requestDisallowInterceptTouchEvent(z);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout resetNoMoreData() {
        return setNoMoreData(false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setDisableContentWhenLoading(boolean z) {
        this.mDisableContentWhenLoading = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setDisableContentWhenRefresh(boolean z) {
        this.mDisableContentWhenRefresh = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setDragRate(float f2) {
        this.mDragRate = f2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableAutoLoadMore(boolean z) {
        this.mEnableAutoLoadMore = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableClipFooterWhenFixedBehind(boolean z) {
        this.mEnableClipFooterWhenFixedBehind = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableClipHeaderWhenFixedBehind(boolean z) {
        this.mEnableClipHeaderWhenFixedBehind = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @Deprecated
    public RefreshLayout setEnableFooterFollowWhenLoadFinished(boolean z) {
        this.mEnableFooterFollowWhenNoMoreData = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableFooterFollowWhenNoMoreData(boolean z) {
        this.mEnableFooterFollowWhenNoMoreData = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableFooterTranslationContent(boolean z) {
        this.mEnableFooterTranslationContent = z;
        this.mManualFooterTranslationContent = true;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableHeaderTranslationContent(boolean z) {
        this.mEnableHeaderTranslationContent = z;
        this.mManualHeaderTranslationContent = true;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableLoadMore(boolean z) {
        this.mManualLoadMore = true;
        this.mEnableLoadMore = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableLoadMoreWhenContentNotFull(boolean z) {
        this.mEnableLoadMoreWhenContentNotFull = z;
        RefreshContent refreshContent = this.mRefreshContent;
        if (refreshContent != null) {
            refreshContent.i(z);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableNestedScroll(boolean z) {
        setNestedScrollingEnabled(z);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableOverScrollBounce(boolean z) {
        this.mEnableOverScrollBounce = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableOverScrollDrag(boolean z) {
        this.mEnableOverScrollDrag = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnablePureScrollMode(boolean z) {
        this.mEnablePureScrollMode = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableRefresh(boolean z) {
        this.mEnableRefresh = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableScrollContentWhenLoaded(boolean z) {
        this.mEnableScrollContentWhenLoaded = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setEnableScrollContentWhenRefreshed(boolean z) {
        this.mEnableScrollContentWhenRefreshed = z;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setFooterHeight(float f2) {
        if (this.mFooterHeightStatus.a(un2.j)) {
            this.mFooterHeight = qk8.d(f2);
            this.mFooterHeightStatus = un2.i;
            RefreshInternal refreshInternal = this.mRefreshFooter;
            if (refreshInternal != null) {
                refreshInternal.getView().requestLayout();
            }
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setFooterInsetStart(float f2) {
        this.mFooterInsetStart = qk8.d(f2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setFooterMaxDragRate(float f2) {
        this.mFooterMaxDragRate = f2;
        RefreshInternal refreshInternal = this.mRefreshFooter;
        if (refreshInternal == null || !this.mAttachedToWindow) {
            this.mFooterHeightStatus = this.mFooterHeightStatus.c();
        } else {
            RefreshKernel refreshKernel = this.mKernel;
            int i2 = this.mFooterHeight;
            refreshInternal.onInitialized(refreshKernel, i2, (int) (i2 * f2));
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setFooterTriggerRate(float f2) {
        this.mFooterTriggerRate = f2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setHeaderHeight(float f2) {
        if (this.mHeaderHeightStatus.a(un2.j)) {
            this.mHeaderHeight = qk8.d(f2);
            this.mHeaderHeightStatus = un2.i;
            RefreshInternal refreshInternal = this.mRefreshHeader;
            if (refreshInternal != null) {
                refreshInternal.getView().requestLayout();
            }
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setHeaderInsetStart(float f2) {
        this.mHeaderInsetStart = qk8.d(f2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setHeaderMaxDragRate(float f2) {
        this.mHeaderMaxDragRate = f2;
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal == null || !this.mAttachedToWindow) {
            this.mHeaderHeightStatus = this.mHeaderHeightStatus.c();
        } else {
            RefreshKernel refreshKernel = this.mKernel;
            int i2 = this.mHeaderHeight;
            refreshInternal.onInitialized(refreshKernel, i2, (int) (f2 * i2));
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setHeaderTriggerRate(float f2) {
        this.mHeaderTriggerRate = f2;
        return this;
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.mEnableNestedScrolling = z;
        this.mNestedChild.setNestedScrollingEnabled(z);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setNoMoreData(boolean z) {
        if (this.mState == RefreshState.Loading && z) {
            finishLoadMoreWithNoMoreData();
            return this;
        }
        if (this.mFooterNoMoreData != z) {
            this.mFooterNoMoreData = z;
            RefreshInternal refreshInternal = this.mRefreshFooter;
            if (refreshInternal instanceof RefreshFooter) {
                if (((RefreshFooter) refreshInternal).setNoMoreData(z)) {
                    this.mFooterNoMoreDataEffective = true;
                    if (this.mFooterNoMoreData && this.mEnableFooterFollowWhenNoMoreData && this.mSpinner > 0 && this.mRefreshFooter.getSpinnerStyle() == xm8.f45853a && isEnableRefreshOrLoadMore(this.mEnableLoadMore) && isEnableTranslationContent(this.mEnableRefresh, this.mRefreshHeader)) {
                        this.mRefreshFooter.getView().setTranslationY(this.mSpinner);
                    }
                } else {
                    this.mFooterNoMoreDataEffective = false;
                    new RuntimeException("Footer:" + this.mRefreshFooter + " NoMoreData is not supported.(不支持NoMoreData，请使用ClassicsFooter或者自定义)").printStackTrace();
                }
            }
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.mLoadMoreListener = onLoadMoreListener;
        this.mEnableLoadMore = this.mEnableLoadMore || !(this.mManualLoadMore || onLoadMoreListener == null);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setOnMultiPurposeListener(OnMultiPurposeListener onMultiPurposeListener) {
        this.mOnMultiPurposeListener = onMultiPurposeListener;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mRefreshListener = onRefreshListener;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setOnRefreshLoadMoreListener(OnRefreshLoadMoreListener onRefreshLoadMoreListener) {
        this.mRefreshListener = onRefreshLoadMoreListener;
        this.mLoadMoreListener = onRefreshLoadMoreListener;
        this.mEnableLoadMore = this.mEnableLoadMore || !(this.mManualLoadMore || onRefreshLoadMoreListener == null);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setPrimaryColors(@ColorInt int... iArr) {
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null) {
            refreshInternal.setPrimaryColors(iArr);
        }
        RefreshInternal refreshInternal2 = this.mRefreshFooter;
        if (refreshInternal2 != null) {
            refreshInternal2.setPrimaryColors(iArr);
        }
        this.mPrimaryColors = iArr;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setPrimaryColorsId(@ColorRes int... iArr) {
        int[] iArr2 = new int[iArr.length];
        for (int i2 = 0; i2 < iArr.length; i2++) {
            iArr2[i2] = ContextCompat.getColor(getContext(), iArr[i2]);
        }
        setPrimaryColors(iArr2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setReboundDuration(int i2) {
        this.mReboundDuration = i2;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setReboundInterpolator(@NonNull Interpolator interpolator) {
        this.mReboundInterpolator = interpolator;
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshContent(@NonNull View view) {
        return setRefreshContent(view, -1, -1);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshFooter(@NonNull RefreshFooter refreshFooter) {
        return setRefreshFooter(refreshFooter, -1, -2);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshHeader(@NonNull RefreshHeader refreshHeader) {
        return setRefreshHeader(refreshHeader, -1, -2);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setScrollBoundaryDecider(ScrollBoundaryDecider scrollBoundaryDecider) {
        this.mScrollBoundaryDecider = scrollBoundaryDecider;
        RefreshContent refreshContent = this.mRefreshContent;
        if (refreshContent != null) {
            refreshContent.f(scrollBoundaryDecider);
        }
        return this;
    }

    public void setStateDirectLoading(boolean z) {
        RefreshState refreshState = this.mState;
        RefreshState refreshState2 = RefreshState.Loading;
        if (refreshState != refreshState2) {
            this.mLastOpenTime = System.currentTimeMillis();
            this.mFooterLocked = true;
            notifyStateChanged(refreshState2);
            OnLoadMoreListener onLoadMoreListener = this.mLoadMoreListener;
            if (onLoadMoreListener != null) {
                if (z) {
                    onLoadMoreListener.onLoadMore(this);
                }
            } else if (this.mOnMultiPurposeListener == null) {
                finishLoadMore(2000);
            }
            RefreshInternal refreshInternal = this.mRefreshFooter;
            if (refreshInternal != null) {
                int i2 = this.mFooterHeight;
                refreshInternal.onStartAnimator(this, i2, (int) (this.mFooterMaxDragRate * i2));
            }
            OnMultiPurposeListener onMultiPurposeListener = this.mOnMultiPurposeListener;
            if (onMultiPurposeListener == null || !(this.mRefreshFooter instanceof RefreshFooter)) {
                return;
            }
            if (z) {
                onMultiPurposeListener.onLoadMore(this);
            }
            OnMultiPurposeListener onMultiPurposeListener2 = this.mOnMultiPurposeListener;
            RefreshFooter refreshFooter = (RefreshFooter) this.mRefreshFooter;
            int i3 = this.mFooterHeight;
            onMultiPurposeListener2.g(refreshFooter, i3, (int) (this.mFooterMaxDragRate * i3));
        }
    }

    public void setStateLoading(boolean z) {
        b bVar = new b(z);
        notifyStateChanged(RefreshState.LoadReleased);
        ValueAnimator valueAnimatorB = this.mKernel.b(-this.mFooterHeight);
        if (valueAnimatorB != null) {
            valueAnimatorB.addListener(bVar);
        }
        RefreshInternal refreshInternal = this.mRefreshFooter;
        if (refreshInternal != null) {
            int i2 = this.mFooterHeight;
            refreshInternal.onReleased(this, i2, (int) (this.mFooterMaxDragRate * i2));
        }
        OnMultiPurposeListener onMultiPurposeListener = this.mOnMultiPurposeListener;
        if (onMultiPurposeListener != null) {
            RefreshInternal refreshInternal2 = this.mRefreshFooter;
            if (refreshInternal2 instanceof RefreshFooter) {
                int i3 = this.mFooterHeight;
                onMultiPurposeListener.f((RefreshFooter) refreshInternal2, i3, (int) (this.mFooterMaxDragRate * i3));
            }
        }
        if (valueAnimatorB == null) {
            bVar.onAnimationEnd(null);
        }
    }

    public void setStateRefreshing(boolean z) {
        c cVar = new c(z);
        notifyStateChanged(RefreshState.RefreshReleased);
        ValueAnimator valueAnimatorB = this.mKernel.b(this.mHeaderHeight);
        if (valueAnimatorB != null) {
            valueAnimatorB.addListener(cVar);
        }
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null) {
            int i2 = this.mHeaderHeight;
            refreshInternal.onReleased(this, i2, (int) (this.mHeaderMaxDragRate * i2));
        }
        OnMultiPurposeListener onMultiPurposeListener = this.mOnMultiPurposeListener;
        if (onMultiPurposeListener != null) {
            RefreshInternal refreshInternal2 = this.mRefreshHeader;
            if (refreshInternal2 instanceof RefreshHeader) {
                int i3 = this.mHeaderHeight;
                onMultiPurposeListener.c((RefreshHeader) refreshInternal2, i3, (int) (this.mHeaderMaxDragRate * i3));
            }
        }
        if (valueAnimatorB == null) {
            cVar.onAnimationEnd(null);
        }
    }

    public void setViceState(RefreshState refreshState) {
        RefreshState refreshState2 = this.mState;
        if (refreshState2.isDragging && refreshState2.isHeader != refreshState.isHeader) {
            notifyStateChanged(RefreshState.None);
        }
        if (this.mViceState != refreshState) {
            this.mViceState = refreshState;
        }
    }

    public boolean startFlingIfNeed(float f2) {
        if (f2 == 0.0f) {
            f2 = this.mCurrentVelocity;
        }
        if (Math.abs(f2) > this.mMinimumVelocity) {
            int i2 = this.mSpinner;
            if (i2 * f2 < 0.0f) {
                RefreshState refreshState = this.mState;
                if (refreshState == RefreshState.Refreshing || refreshState == RefreshState.Loading || (i2 < 0 && this.mFooterNoMoreData)) {
                    this.animationRunnable = new l(f2).b();
                    return true;
                }
                if (refreshState.isReleaseToOpening) {
                    return true;
                }
            }
            if ((f2 < 0.0f && ((this.mEnableOverScrollBounce && (this.mEnableLoadMore || this.mEnableOverScrollDrag)) || ((this.mState == RefreshState.Loading && i2 >= 0) || (this.mEnableAutoLoadMore && isEnableRefreshOrLoadMore(this.mEnableLoadMore))))) || (f2 > 0.0f && ((this.mEnableOverScrollBounce && this.mEnableRefresh) || this.mEnableOverScrollDrag || (this.mState == RefreshState.Refreshing && this.mSpinner <= 0)))) {
                this.mVerticalPermit = false;
                this.mScroller.fling(0, 0, 0, (int) (-f2), 0, 0, -2147483647, Integer.MAX_VALUE);
                this.mScroller.computeScrollOffset();
                invalidate();
            }
        }
        return false;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoLoadMore(int i2, int i3, float f2, boolean z) {
        if (this.mState != RefreshState.None || !isEnableRefreshOrLoadMore(this.mEnableLoadMore) || this.mFooterNoMoreData) {
            return false;
        }
        j jVar = new j(f2, i3, z);
        setViceState(RefreshState.Loading);
        if (i2 > 0) {
            this.mHandler.postDelayed(jVar, i2);
            return true;
        }
        jVar.run();
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    @Deprecated
    public boolean autoRefresh(int i2) {
        int i3 = this.mReboundDuration;
        float f2 = (this.mHeaderMaxDragRate / 2.0f) + 0.5f;
        int i4 = this.mHeaderHeight;
        float f3 = f2 * i4 * 1.0f;
        if (i4 == 0) {
            i4 = 1;
        }
        return autoRefresh(i2, i3, f3 / i4, false);
    }

    /* JADX WARN: Code duplicated, block: B:14:0x0037  */
    /* JADX WARN: Code duplicated, block: B:16:0x003b  */
    /* JADX WARN: Code duplicated, block: B:18:0x0043  */
    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshContent(@NonNull View view, int i2, int i3) {
        RefreshInternal refreshInternal;
        xm8 spinnerStyle;
        xm8 xm8Var;
        RefreshInternal refreshInternal2;
        RefreshContent refreshContent = this.mRefreshContent;
        if (refreshContent != null) {
            super.removeView(refreshContent.getView());
        }
        super.addView(view, 0, new LayoutParams(i2, i3));
        RefreshInternal refreshInternal3 = this.mRefreshHeader;
        if (refreshInternal3 != null) {
            xm8 spinnerStyle2 = refreshInternal3.getSpinnerStyle();
            xm8 xm8Var2 = xm8.c;
            if (spinnerStyle2 == xm8Var2) {
                super.bringChildToFront(view);
                RefreshInternal refreshInternal4 = this.mRefreshFooter;
                if (refreshInternal4 != null && refreshInternal4.getSpinnerStyle() != xm8Var2) {
                    super.bringChildToFront(this.mRefreshFooter.getView());
                }
            } else {
                refreshInternal = this.mRefreshFooter;
                if (refreshInternal != null) {
                    spinnerStyle = refreshInternal.getSpinnerStyle();
                    xm8Var = xm8.c;
                    if (spinnerStyle == xm8Var) {
                        super.bringChildToFront(view);
                        refreshInternal2 = this.mRefreshHeader;
                        if (refreshInternal2 != null && refreshInternal2.getSpinnerStyle() == xm8Var) {
                            super.bringChildToFront(this.mRefreshHeader.getView());
                        }
                    }
                }
            }
        } else {
            refreshInternal = this.mRefreshFooter;
            if (refreshInternal != null) {
                spinnerStyle = refreshInternal.getSpinnerStyle();
                xm8Var = xm8.c;
                if (spinnerStyle == xm8Var) {
                    super.bringChildToFront(view);
                    refreshInternal2 = this.mRefreshHeader;
                    if (refreshInternal2 != null) {
                        super.bringChildToFront(this.mRefreshHeader.getView());
                    }
                }
            }
        }
        this.mRefreshContent = new td7(view);
        if (this.mAttachedToWindow) {
            int i4 = this.mFixedHeaderViewId;
            View viewFindViewById = i4 > 0 ? findViewById(i4) : null;
            int i5 = this.mFixedFooterViewId;
            View viewFindViewById2 = i5 > 0 ? findViewById(i5) : null;
            this.mRefreshContent.f(this.mScrollBoundaryDecider);
            this.mRefreshContent.i(this.mEnableLoadMoreWhenContentNotFull);
            this.mRefreshContent.h(this.mKernel, viewFindViewById, viewFindViewById2);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshFooter(@NonNull RefreshFooter refreshFooter, int i2, int i3) {
        RefreshInternal refreshInternal = this.mRefreshFooter;
        if (refreshInternal != null) {
            super.removeView(refreshInternal.getView());
        }
        this.mRefreshFooter = refreshFooter;
        this.mFooterLocked = false;
        this.mFooterBackgroundColor = 0;
        this.mFooterNoMoreDataEffective = false;
        this.mFooterNeedTouchEventWhenLoading = false;
        this.mFooterHeightStatus = this.mFooterHeightStatus.c();
        this.mEnableLoadMore = !this.mManualLoadMore || this.mEnableLoadMore;
        if (this.mRefreshFooter.getSpinnerStyle() == xm8.c) {
            super.addView(this.mRefreshFooter.getView(), 0, new LayoutParams(i2, i3));
        } else {
            super.addView(this.mRefreshFooter.getView(), i2, i3);
        }
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout setRefreshHeader(@NonNull RefreshHeader refreshHeader, int i2, int i3) {
        RefreshInternal refreshInternal = this.mRefreshHeader;
        if (refreshInternal != null) {
            super.removeView(refreshInternal.getView());
        }
        this.mRefreshHeader = refreshHeader;
        this.mHeaderBackgroundColor = 0;
        this.mHeaderNeedTouchEventWhenRefreshing = false;
        this.mHeaderHeightStatus = this.mHeaderHeightStatus.c();
        if (this.mRefreshHeader.getSpinnerStyle() == xm8.c) {
            super.addView(this.mRefreshHeader.getView(), 0, new LayoutParams(i2, i3));
        } else {
            super.addView(this.mRefreshHeader.getView(), i2, i3);
        }
        return this;
    }

    public SmartRefreshLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.mFloorDuration = 250;
        this.mReboundDuration = 250;
        this.mDragRate = 0.5f;
        this.mDragDirection = 'n';
        this.mFixedHeaderViewId = -1;
        this.mFixedFooterViewId = -1;
        this.mHeaderTranslationViewId = -1;
        this.mFooterTranslationViewId = -1;
        this.mEnableRefresh = true;
        this.mEnableLoadMore = false;
        this.mEnableClipHeaderWhenFixedBehind = true;
        this.mEnableClipFooterWhenFixedBehind = true;
        this.mEnableHeaderTranslationContent = true;
        this.mEnableFooterTranslationContent = true;
        this.mEnableFooterFollowWhenNoMoreData = false;
        this.mEnablePreviewInEditMode = true;
        this.mEnableOverScrollBounce = true;
        this.mEnableOverScrollDrag = false;
        this.mEnableAutoLoadMore = true;
        this.mEnablePureScrollMode = false;
        this.mEnableScrollContentWhenLoaded = true;
        this.mEnableScrollContentWhenRefreshed = true;
        this.mEnableLoadMoreWhenContentNotFull = true;
        this.mEnableNestedScrolling = true;
        this.mDisableContentWhenRefresh = false;
        this.mDisableContentWhenLoading = false;
        this.mFooterNoMoreData = false;
        this.mFooterNoMoreDataEffective = false;
        this.mManualLoadMore = false;
        this.mManualHeaderTranslationContent = false;
        this.mManualFooterTranslationContent = false;
        this.mParentOffsetInWindow = new int[2];
        this.mNestedChild = new NestedScrollingChildHelper(this);
        this.mNestedParent = new NestedScrollingParentHelper(this);
        un2 un2Var = un2.f45183a;
        this.mHeaderHeightStatus = un2Var;
        this.mFooterHeightStatus = un2Var;
        this.mHeaderMaxDragRate = 2.5f;
        this.mFooterMaxDragRate = 2.5f;
        this.mHeaderTriggerRate = 1.0f;
        this.mFooterTriggerRate = 1.0f;
        this.mKernel = new m();
        RefreshState refreshState = RefreshState.None;
        this.mState = refreshState;
        this.mViceState = refreshState;
        this.mLastOpenTime = 0L;
        this.mHeaderBackgroundColor = 0;
        this.mFooterBackgroundColor = 0;
        this.mFooterLocked = false;
        this.mVerticalPermit = false;
        this.mFalsifyEvent = null;
        super.setClipToPadding(false);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.mHandler = new Handler();
        this.mScroller = new Scroller(context);
        this.mVelocityTracker = VelocityTracker.obtain();
        this.mScreenHeightPixels = context.getResources().getDisplayMetrics().heightPixels;
        this.mReboundInterpolator = new qk8();
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.mMinimumVelocity = viewConfiguration.getScaledMinimumFlingVelocity();
        this.mMaximumVelocity = viewConfiguration.getScaledMaximumFlingVelocity();
        this.mFooterHeight = qk8.d(60.0f);
        this.mHeaderHeight = qk8.d(100.0f);
        DefaultRefreshInitializer defaultRefreshInitializer = sRefreshInitializer;
        if (defaultRefreshInitializer != null) {
            defaultRefreshInitializer.a(context, this);
        }
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout);
        this.mDragRate = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlDragRate, this.mDragRate);
        this.mHeaderMaxDragRate = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderMaxDragRate, this.mHeaderMaxDragRate);
        this.mFooterMaxDragRate = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterMaxDragRate, this.mFooterMaxDragRate);
        this.mHeaderTriggerRate = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlHeaderTriggerRate, this.mHeaderTriggerRate);
        this.mFooterTriggerRate = typedArrayObtainStyledAttributes.getFloat(R.styleable.SmartRefreshLayout_srlFooterTriggerRate, this.mFooterTriggerRate);
        this.mEnableRefresh = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableRefresh, this.mEnableRefresh);
        this.mReboundDuration = typedArrayObtainStyledAttributes.getInt(R.styleable.SmartRefreshLayout_srlReboundDuration, this.mReboundDuration);
        int i3 = R.styleable.SmartRefreshLayout_srlEnableLoadMore;
        this.mEnableLoadMore = typedArrayObtainStyledAttributes.getBoolean(i3, this.mEnableLoadMore);
        int i4 = R.styleable.SmartRefreshLayout_srlHeaderHeight;
        this.mHeaderHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i4, this.mHeaderHeight);
        int i5 = R.styleable.SmartRefreshLayout_srlFooterHeight;
        this.mFooterHeight = typedArrayObtainStyledAttributes.getDimensionPixelOffset(i5, this.mFooterHeight);
        this.mHeaderInsetStart = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlHeaderInsetStart, this.mHeaderInsetStart);
        this.mFooterInsetStart = typedArrayObtainStyledAttributes.getDimensionPixelOffset(R.styleable.SmartRefreshLayout_srlFooterInsetStart, this.mFooterInsetStart);
        this.mDisableContentWhenRefresh = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenRefresh, this.mDisableContentWhenRefresh);
        this.mDisableContentWhenLoading = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlDisableContentWhenLoading, this.mDisableContentWhenLoading);
        int i6 = R.styleable.SmartRefreshLayout_srlEnableHeaderTranslationContent;
        this.mEnableHeaderTranslationContent = typedArrayObtainStyledAttributes.getBoolean(i6, this.mEnableHeaderTranslationContent);
        int i7 = R.styleable.SmartRefreshLayout_srlEnableFooterTranslationContent;
        this.mEnableFooterTranslationContent = typedArrayObtainStyledAttributes.getBoolean(i7, this.mEnableFooterTranslationContent);
        this.mEnablePreviewInEditMode = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePreviewInEditMode, this.mEnablePreviewInEditMode);
        this.mEnableAutoLoadMore = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableAutoLoadMore, this.mEnableAutoLoadMore);
        this.mEnableOverScrollBounce = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollBounce, this.mEnableOverScrollBounce);
        this.mEnablePureScrollMode = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnablePureScrollMode, this.mEnablePureScrollMode);
        this.mEnableScrollContentWhenLoaded = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenLoaded, this.mEnableScrollContentWhenLoaded);
        this.mEnableScrollContentWhenRefreshed = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableScrollContentWhenRefreshed, this.mEnableScrollContentWhenRefreshed);
        this.mEnableLoadMoreWhenContentNotFull = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableLoadMoreWhenContentNotFull, this.mEnableLoadMoreWhenContentNotFull);
        boolean z = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenLoadFinished, this.mEnableFooterFollowWhenNoMoreData);
        this.mEnableFooterFollowWhenNoMoreData = z;
        this.mEnableFooterFollowWhenNoMoreData = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableFooterFollowWhenNoMoreData, z);
        this.mEnableClipHeaderWhenFixedBehind = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipHeaderWhenFixedBehind, this.mEnableClipHeaderWhenFixedBehind);
        this.mEnableClipFooterWhenFixedBehind = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableClipFooterWhenFixedBehind, this.mEnableClipFooterWhenFixedBehind);
        this.mEnableOverScrollDrag = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableOverScrollDrag, this.mEnableOverScrollDrag);
        this.mFixedHeaderViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedHeaderViewId, this.mFixedHeaderViewId);
        this.mFixedFooterViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFixedFooterViewId, this.mFixedFooterViewId);
        this.mHeaderTranslationViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlHeaderTranslationViewId, this.mHeaderTranslationViewId);
        this.mFooterTranslationViewId = typedArrayObtainStyledAttributes.getResourceId(R.styleable.SmartRefreshLayout_srlFooterTranslationViewId, this.mFooterTranslationViewId);
        boolean z2 = typedArrayObtainStyledAttributes.getBoolean(R.styleable.SmartRefreshLayout_srlEnableNestedScrolling, this.mEnableNestedScrolling);
        this.mEnableNestedScrolling = z2;
        this.mNestedChild.setNestedScrollingEnabled(z2);
        this.mManualLoadMore = this.mManualLoadMore || typedArrayObtainStyledAttributes.hasValue(i3);
        this.mManualHeaderTranslationContent = this.mManualHeaderTranslationContent || typedArrayObtainStyledAttributes.hasValue(i6);
        this.mManualFooterTranslationContent = this.mManualFooterTranslationContent || typedArrayObtainStyledAttributes.hasValue(i7);
        this.mHeaderHeightStatus = typedArrayObtainStyledAttributes.hasValue(i4) ? un2.g : this.mHeaderHeightStatus;
        this.mFooterHeightStatus = typedArrayObtainStyledAttributes.hasValue(i5) ? un2.g : this.mFooterHeightStatus;
        int color = typedArrayObtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlAccentColor, 0);
        int color2 = typedArrayObtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_srlPrimaryColor, 0);
        if (color2 != 0) {
            if (color != 0) {
                this.mPrimaryColors = new int[]{color2, color};
            } else {
                this.mPrimaryColors = new int[]{color2};
            }
        } else if (color != 0) {
            this.mPrimaryColors = new int[]{0, color};
        }
        if (this.mEnablePureScrollMode && !this.mManualLoadMore && !this.mEnableLoadMore) {
            this.mEnableLoadMore = true;
        }
        typedArrayObtainStyledAttributes.recycle();
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public boolean autoRefresh(int i2, int i3, float f2, boolean z) {
        if (this.mState != RefreshState.None || !isEnableRefreshOrLoadMore(this.mEnableRefresh)) {
            return false;
        }
        i iVar = new i(f2, i3, z);
        setViceState(RefreshState.Refreshing);
        if (i2 > 0) {
            this.mHandler.postDelayed(iVar, i2);
            return true;
        }
        iVar.run();
        return true;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishLoadMore(int i2) {
        return finishLoadMore(i2, true, false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishRefresh(int i2) {
        return finishRefresh(i2, true, Boolean.FALSE);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishLoadMore(boolean z) {
        return finishLoadMore(z ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) : 0, z, false);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishRefresh(boolean z) {
        return finishRefresh(z ? Math.min(Math.max(0, 300 - ((int) (System.currentTimeMillis() - this.mLastOpenTime))), 300) : 0, z, !z ? Boolean.FALSE : null);
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishLoadMore(int i2, boolean z, boolean z2) {
        this.mHandler.postDelayed(new h(z, z2), i2 <= 0 ? 1L : i2);
        return this;
    }

    @Override // com.scwang.smartrefresh.layout.api.RefreshLayout
    public RefreshLayout finishRefresh(int i2, boolean z, Boolean bool) {
        this.mHandler.postDelayed(new g(bool, z), i2 <= 0 ? 1L : i2);
        return this;
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f40395a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public xm8 f15121a;

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            this.f40395a = 0;
            this.f15121a = null;
            TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SmartRefreshLayout_Layout);
            this.f40395a = typedArrayObtainStyledAttributes.getColor(R.styleable.SmartRefreshLayout_Layout_layout_srlBackgroundColor, this.f40395a);
            int i = R.styleable.SmartRefreshLayout_Layout_layout_srlSpinnerStyle;
            if (typedArrayObtainStyledAttributes.hasValue(i)) {
                this.f15121a = xm8.f20686a[typedArrayObtainStyledAttributes.getInt(i, xm8.f45853a.f20687a)];
            }
            typedArrayObtainStyledAttributes.recycle();
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
            this.f40395a = 0;
            this.f15121a = null;
        }
    }
}
