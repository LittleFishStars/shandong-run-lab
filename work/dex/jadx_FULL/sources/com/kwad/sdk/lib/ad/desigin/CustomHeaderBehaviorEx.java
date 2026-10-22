package com.kwad.sdk.lib.ad.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.Keep;
import androidx.core.view.ViewCompat;
import com.kwad.sdk.lib.ad.desigin.CustomAppBarFlingConsumer;
import com.kwad.sdk.lib.ad.desigin.KSAppBarLayout;
import com.kwad.sdk.lib.ad.desigin.KSAppBarLayout.a;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public final class CustomHeaderBehaviorEx<V extends KSAppBarLayout, B extends KSAppBarLayout.a & CustomAppBarFlingConsumer> extends KSViewOffsetBehavior<V> {
    private static final int FLING_MAX_VELOCITY = 10000;
    private static final int INVALID_POINTER = -1;
    private static final String TAG = CustomHeaderBehaviorEx.class.toString();
    private int mActivePointerId;
    private B mBehavior;
    private boolean mEnabled;
    private int mExtraFixedSize;
    private Runnable mFlingRunnable;
    private boolean mIsBeingDragged;
    private int mLastMotionY;
    private OverScroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public class a implements Runnable {
        private final KSCoordinatorLayout bhB;
        private final V bhC;
        private int bhD;

        public a(KSCoordinatorLayout kSCoordinatorLayout, V v, int i) {
            this.bhB = kSCoordinatorLayout;
            this.bhC = v;
            this.bhD = i;
        }

        @Override // java.lang.Runnable
        public final void run() {
            if (this.bhC == null || CustomHeaderBehaviorEx.this.mScroller == null) {
                return;
            }
            if (!CustomHeaderBehaviorEx.this.mScroller.computeScrollOffset()) {
                CustomHeaderBehaviorEx.this.mBehavior.onFlingFinished(this.bhB, (KSAppBarLayout) this.bhC);
                return;
            }
            int currY = CustomHeaderBehaviorEx.this.mScroller.getCurrY();
            int i = currY - this.bhD;
            int bottom = this.bhC.getBottom();
            int measuredHeight = (this.bhC.getMeasuredHeight() - this.bhC.getTotalScrollRange()) + CustomHeaderBehaviorEx.this.mExtraFixedSize;
            if (bottom == measuredHeight) {
                ((CustomAppBarFlingConsumer) CustomHeaderBehaviorEx.this.mBehavior).consumeAppBarFling(0, -i);
            } else if (bottom <= 0 || bottom + i >= measuredHeight) {
                KSAppBarLayout.a aVar = CustomHeaderBehaviorEx.this.mBehavior;
                KSCoordinatorLayout kSCoordinatorLayout = this.bhB;
                V v = this.bhC;
                aVar.setHeaderTopBottomOffset(kSCoordinatorLayout, v, v.getTop() + i);
            } else {
                KSAppBarLayout.a aVar2 = CustomHeaderBehaviorEx.this.mBehavior;
                KSCoordinatorLayout kSCoordinatorLayout2 = this.bhB;
                V v2 = this.bhC;
                aVar2.setHeaderTopBottomOffset(kSCoordinatorLayout2, v2, (v2.getTop() - bottom) + measuredHeight);
            }
            ViewCompat.postOnAnimation(this.bhC, this);
            this.bhD = currY;
        }
    }

    public CustomHeaderBehaviorEx(B b) {
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
        this.mBehavior = b;
    }

    private void ensureVelocityTracker() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    private boolean fling(KSCoordinatorLayout kSCoordinatorLayout, V v, int i, int i2, float f) {
        Runnable runnable = this.mFlingRunnable;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.mFlingRunnable = null;
        }
        if (this.mScroller == null) {
            this.mScroller = new OverScroller(v.getContext());
        }
        this.mScroller.fling(0, getTopAndBottomOffset(), 0, Math.round(f), 0, 0, i, i2);
        if (!this.mScroller.computeScrollOffset()) {
            this.mBehavior.onFlingFinished(kSCoordinatorLayout, v);
            return false;
        }
        a aVar = new a(kSCoordinatorLayout, v, this.mScroller.getCurrY());
        this.mFlingRunnable = aVar;
        ViewCompat.postOnAnimation(v, aVar);
        return true;
    }

    public final boolean isEnabled() {
        return this.mEnabled;
    }

    public final void setEnabled(boolean z) {
        this.mEnabled = z;
    }

    public final void setExtraFixedSize(int i) {
        this.mExtraFixedSize = i;
    }

    public final void stopFling() {
        OverScroller overScroller;
        if (this.mFlingRunnable == null || (overScroller = this.mScroller) == null || !overScroller.computeScrollOffset()) {
            return;
        }
        this.mScroller.abortAnimation();
    }

    /* JADX WARN: Code duplicated, block: B:25:0x0059  */
    /* JADX WARN: Code duplicated, block: B:27:0x0061  */
    @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public final boolean onInterceptTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int iFindPointerIndex;
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(kSCoordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.mIsBeingDragged) {
            return true;
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mIsBeingDragged = false;
            stopFling();
            if (this.mBehavior.canDragView(v) && kSCoordinatorLayout.isPointInChildBounds(v, x, y)) {
                this.mLastMotionY = y;
                this.mActivePointerId = motionEvent.getPointerId(0);
                ensureVelocityTracker();
                this.mBehavior.onAppBarTouchDown();
            }
        } else if (actionMasked == 1) {
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
        } else if (actionMasked == 2) {
            int i = this.mActivePointerId;
            if (i != -1 && (iFindPointerIndex = motionEvent.findPointerIndex(i)) != -1) {
                int y2 = (int) motionEvent.getY(iFindPointerIndex);
                if (Math.abs(y2 - this.mLastMotionY) > this.mTouchSlop) {
                    this.mIsBeingDragged = true;
                    this.mLastMotionY = y2;
                }
            }
        } else if (actionMasked == 3) {
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            velocityTracker = this.mVelocityTracker;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.mVelocityTracker = null;
            }
        }
        VelocityTracker velocityTracker2 = this.mVelocityTracker;
        if (velocityTracker2 != null) {
            velocityTracker2.addMovement(motionEvent);
        }
        return this.mIsBeingDragged;
    }

    @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public final boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(kSCoordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int x = (int) motionEvent.getX();
        int y = (int) motionEvent.getY();
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    float yVelocity = this.mVelocityTracker.getYVelocity(this.mActivePointerId);
                    fling(kSCoordinatorLayout, v, yVelocity < 0.0f ? -10000 : 0, yVelocity < 0.0f ? 0 : -v.getTop(), yVelocity);
                }
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (iFindPointerIndex == -1) {
                    return false;
                }
                int y2 = (int) motionEvent.getY(iFindPointerIndex);
                int i = this.mLastMotionY - y2;
                if (!this.mIsBeingDragged) {
                    int iAbs = Math.abs(i);
                    int i2 = this.mTouchSlop;
                    if (iAbs > i2) {
                        this.mIsBeingDragged = true;
                        i = i > 0 ? i - i2 : i + i2;
                    }
                }
                int i3 = i;
                if (this.mIsBeingDragged) {
                    this.mLastMotionY = y2;
                    B b = this.mBehavior;
                    b.scroll(kSCoordinatorLayout, v, i3, b.getMaxDragOffset(v), 0);
                }
            } else if (actionMasked == 3) {
            }
            this.mIsBeingDragged = false;
            this.mActivePointerId = -1;
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
        } else {
            if (!kSCoordinatorLayout.isPointInChildBounds(v, x, y) || !this.mBehavior.canDragView(v)) {
                return false;
            }
            this.mLastMotionY = y;
            this.mActivePointerId = motionEvent.getPointerId(0);
            ensureVelocityTracker();
        }
        VelocityTracker velocityTracker3 = this.mVelocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return true;
    }

    public CustomHeaderBehaviorEx(Context context, AttributeSet attributeSet, B b) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
        this.mBehavior = b;
    }
}
