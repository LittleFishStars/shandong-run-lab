package com.kwad.sdk.lib.ad.desigin;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.annotation.Keep;
import androidx.core.math.MathUtils;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_02_3758cls.dex */
@Keep
public abstract class KSHeaderBehavior<V extends View> extends KSViewOffsetBehavior<V> {
    private static final int INVALID_POINTER = -1;
    private int mActivePointerId;
    private Runnable mFlingRunnable;
    private boolean mIsBeingDragged;
    private int mLastMotionY;
    OverScroller mScroller;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;

    public class a implements Runnable {
        private final KSCoordinatorLayout bhB;
        private final V bhS;

        public a(KSCoordinatorLayout kSCoordinatorLayout, V v) {
            this.bhB = kSCoordinatorLayout;
            this.bhS = v;
        }

        @Override // java.lang.Runnable
        public final void run() {
            OverScroller overScroller;
            if (this.bhS == null || (overScroller = KSHeaderBehavior.this.mScroller) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                KSHeaderBehavior.this.onFlingFinished(this.bhB, this.bhS);
                return;
            }
            KSHeaderBehavior kSHeaderBehavior = KSHeaderBehavior.this;
            kSHeaderBehavior.setHeaderTopBottomOffset(this.bhB, this.bhS, kSHeaderBehavior.mScroller.getCurrY());
            ViewCompat.postOnAnimation(this.bhS, this);
        }
    }

    public KSHeaderBehavior() {
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
    }

    private void ensureVelocityTracker() {
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
    }

    public boolean canDragView(V v) {
        return false;
    }

    public final boolean fling(KSCoordinatorLayout kSCoordinatorLayout, V v, int i, int i2, float f) {
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
            onFlingFinished(kSCoordinatorLayout, v);
            return false;
        }
        a aVar = new a(kSCoordinatorLayout, v);
        this.mFlingRunnable = aVar;
        ViewCompat.postOnAnimation(v, aVar);
        return true;
    }

    public int getMaxDragOffset(V v) {
        return -v.getHeight();
    }

    public int getScrollRangeForDragFling(V v) {
        return v.getHeight();
    }

    public int getTopBottomOffsetForScrollingSibling() {
        return getTopAndBottomOffset();
    }

    public void onFlingFinished(KSCoordinatorLayout kSCoordinatorLayout, V v) {
    }

    /* JADX WARN: Code duplicated, block: B:25:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0057  */
    @Override // com.kwad.sdk.lib.ad.desigin.KSCoordinatorLayout.Behavior
    public boolean onInterceptTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        VelocityTracker velocityTracker;
        int iFindPointerIndex;
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(kSCoordinatorLayout.getContext()).getScaledTouchSlop();
        }
        if (motionEvent.getAction() == 2 && this.mIsBeingDragged) {
            return true;
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            this.mIsBeingDragged = false;
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (canDragView(v) && kSCoordinatorLayout.isPointInChildBounds(v, x, y)) {
                this.mLastMotionY = y;
                this.mActivePointerId = motionEvent.getPointerId(0);
                ensureVelocityTracker();
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
    public boolean onTouchEvent(KSCoordinatorLayout kSCoordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.mTouchSlop < 0) {
            this.mTouchSlop = ViewConfiguration.get(kSCoordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.mVelocityTracker;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.mVelocityTracker.computeCurrentVelocity(1000);
                    fling(kSCoordinatorLayout, v, -getScrollRangeForDragFling(v), 0, this.mVelocityTracker.getYVelocity(this.mActivePointerId));
                }
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.mActivePointerId);
                if (iFindPointerIndex == -1) {
                    return false;
                }
                int y = (int) motionEvent.getY(iFindPointerIndex);
                int i = this.mLastMotionY - y;
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
                    this.mLastMotionY = y;
                    scroll(kSCoordinatorLayout, v, i3, getMaxDragOffset(v), 0);
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
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (!kSCoordinatorLayout.isPointInChildBounds(v, x, y2) || !canDragView(v)) {
                return false;
            }
            this.mLastMotionY = y2;
            this.mActivePointerId = motionEvent.getPointerId(0);
            ensureVelocityTracker();
        }
        VelocityTracker velocityTracker3 = this.mVelocityTracker;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return true;
    }

    public final int scroll(KSCoordinatorLayout kSCoordinatorLayout, V v, int i, int i2, int i3) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, v, getTopBottomOffsetForScrollingSibling() - i, i2, i3);
    }

    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, V v, int i) {
        return setHeaderTopBottomOffset(kSCoordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public int setHeaderTopBottomOffset(KSCoordinatorLayout kSCoordinatorLayout, V v, int i, int i2, int i3) {
        int iClamp;
        int topAndBottomOffset = getTopAndBottomOffset();
        if (i2 == 0 || topAndBottomOffset < i2 || topAndBottomOffset > i3 || topAndBottomOffset == (iClamp = MathUtils.clamp(i, i2, i3))) {
            return 0;
        }
        setTopAndBottomOffset(iClamp);
        return topAndBottomOffset - iClamp;
    }

    public KSHeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mActivePointerId = -1;
        this.mTouchSlop = -1;
    }
}
