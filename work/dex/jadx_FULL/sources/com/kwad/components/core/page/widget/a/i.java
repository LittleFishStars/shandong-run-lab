package com.kwad.components.core.page.widget.a;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import androidx.core.view.MotionEventCompat;
import androidx.core.view.VelocityTrackerCompat;
import androidx.core.view.ViewCompat;
import androidx.core.widget.ScrollerCompat;
import java.util.Arrays;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public final class i {
    private static final Interpolator ahI = new Interpolator() { // from class: com.kwad.components.core.page.widget.a.i.1
        @Override // android.animation.TimeInterpolator
        public final float getInterpolation(float f) {
            float f2 = f - 1.0f;
            return (f2 * f2 * f2 * f2 * f2) + 1.0f;
        }
    };
    private final a ahJ;
    private final ViewGroup ahK;
    private int ahL;
    private float[] ahM;
    private float[] ahN;
    private float[] ahO;
    private float[] ahP;
    private int[] ahQ;
    private int[] ahR;
    private int[] ahS;
    private int ahT;
    private float ahU;
    private float ahV;
    private int ahW;
    private int ahX;
    private ScrollerCompat ahY;
    private View ahZ;
    private boolean aib;
    private int mTouchSlop;
    private VelocityTracker mVelocityTracker;
    private int duration = 0;
    private int mActivePointerId = -1;
    private final Runnable aia = new Runnable() { // from class: com.kwad.components.core.page.widget.a.i.2
        @Override // java.lang.Runnable
        public final void run() {
            i.this.bN(0);
        }
    };

    public static abstract class a {
        public static int getOrderedChildIndex(int i) {
            return i;
        }

        public int E(View view) {
            return 0;
        }

        public void bH(int i) {
        }

        public int bI(int i) {
            return 0;
        }

        public void onViewDragStateChanged(int i) {
        }

        public void onViewReleased(View view, float f, float f2) {
        }

        public abstract boolean tryCaptureView(View view, int i);

        public int vm() {
            return 0;
        }
    }

    private i(Context context, ViewGroup viewGroup, a aVar) {
        if (viewGroup == null) {
            throw new IllegalArgumentException("Parent view may not be null");
        }
        if (aVar == null) {
            throw new IllegalArgumentException("Callback may not be null");
        }
        this.ahK = viewGroup;
        this.ahJ = aVar;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.ahW = (int) ((context.getResources().getDisplayMetrics().density * 20.0f) + 0.5f);
        this.mTouchSlop = viewConfiguration.getScaledTouchSlop();
        this.ahU = viewConfiguration.getScaledMaximumFlingVelocity();
        this.ahV = viewConfiguration.getScaledMinimumFlingVelocity();
        this.ahY = ScrollerCompat.create(context, ahI);
    }

    public static i a(ViewGroup viewGroup, a aVar) {
        return new i(viewGroup.getContext(), viewGroup, aVar);
    }

    private int b(View view, int i, int i2, int i3, int i4) {
        float f;
        float f2;
        float f3;
        float f4;
        int iC = c(i3, (int) this.ahV, (int) this.ahU);
        int iC2 = c(i4, (int) this.ahV, (int) this.ahU);
        int iAbs = Math.abs(i);
        int iAbs2 = Math.abs(i2);
        int iAbs3 = Math.abs(iC);
        int iAbs4 = Math.abs(iC2);
        int i5 = iAbs3 + iAbs4;
        int i6 = iAbs + iAbs2;
        if (iC != 0) {
            f = iAbs3;
            f2 = i5;
        } else {
            f = iAbs;
            f2 = i6;
        }
        float f5 = f / f2;
        if (iC2 != 0) {
            f3 = iAbs4;
            f4 = i5;
        } else {
            f3 = iAbs2;
            f4 = i6;
        }
        return (int) ((b(i, iC, 0) * f5) + (b(i2, iC2, this.ahJ.vm()) * (f3 / f4)));
    }

    private void bL(int i) {
        float[] fArr = this.ahM;
        if (fArr == null) {
            return;
        }
        fArr[i] = 0.0f;
        this.ahN[i] = 0.0f;
        this.ahO[i] = 0.0f;
        this.ahP[i] = 0.0f;
        this.ahQ[i] = 0;
        this.ahR[i] = 0;
        this.ahS[i] = 0;
        this.ahT = (~(1 << i)) & this.ahT;
    }

    private void bM(int i) {
        float[] fArr = this.ahM;
        if (fArr == null || fArr.length <= i) {
            int i2 = i + 1;
            float[] fArr2 = new float[i2];
            float[] fArr3 = new float[i2];
            float[] fArr4 = new float[i2];
            float[] fArr5 = new float[i2];
            int[] iArr = new int[i2];
            int[] iArr2 = new int[i2];
            int[] iArr3 = new int[i2];
            if (fArr != null) {
                System.arraycopy(fArr, 0, fArr2, 0, fArr.length);
                float[] fArr6 = this.ahN;
                System.arraycopy(fArr6, 0, fArr3, 0, fArr6.length);
                float[] fArr7 = this.ahO;
                System.arraycopy(fArr7, 0, fArr4, 0, fArr7.length);
                float[] fArr8 = this.ahP;
                System.arraycopy(fArr8, 0, fArr5, 0, fArr8.length);
                int[] iArr4 = this.ahQ;
                System.arraycopy(iArr4, 0, iArr, 0, iArr4.length);
                int[] iArr5 = this.ahR;
                System.arraycopy(iArr5, 0, iArr2, 0, iArr5.length);
                int[] iArr6 = this.ahS;
                System.arraycopy(iArr6, 0, iArr3, 0, iArr6.length);
            }
            this.ahM = fArr2;
            this.ahN = fArr3;
            this.ahO = fArr4;
            this.ahP = fArr5;
            this.ahQ = iArr;
            this.ahR = iArr2;
            this.ahS = iArr3;
        }
    }

    private boolean bO(int i) {
        if (isPointerDown(i)) {
            return true;
        }
        Log.e("ViewDragHelper", "Ignoring pointerId=" + i + " because ACTION_DOWN was not received for this pointer before ACTION_MOVE. It likely happened because  ViewDragHelper did not receive all the events in the event stream.");
        return false;
    }

    private static int c(int i, int i2, int i3) {
        int iAbs = Math.abs(i);
        if (iAbs < i2) {
            return 0;
        }
        if (iAbs > i3) {
            return i > 0 ? i3 : -i3;
        }
        return i;
    }

    private void cancel() {
        this.mActivePointerId = -1;
        vp();
        VelocityTracker velocityTracker = this.mVelocityTracker;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.mVelocityTracker = null;
        }
    }

    private View findTopChildUnder(int i, int i2) {
        for (int childCount = this.ahK.getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = this.ahK.getChildAt(a.getOrderedChildIndex(childCount));
            if (i >= childAt.getLeft() && i < childAt.getRight() && i2 >= childAt.getTop() && i2 < childAt.getBottom()) {
                return childAt;
            }
        }
        return null;
    }

    private void g(float f, float f2) {
        this.aib = true;
        this.ahJ.onViewReleased(this.ahZ, f, f2);
        this.aib = false;
        if (this.ahL == 1) {
            bN(0);
        }
    }

    private void i(MotionEvent motionEvent) {
        int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
        for (int i = 0; i < pointerCount; i++) {
            int pointerId = MotionEventCompat.getPointerId(motionEvent, i);
            float x = MotionEventCompat.getX(motionEvent, i);
            float y = MotionEventCompat.getY(motionEvent, i);
            this.ahO[pointerId] = x;
            this.ahP[pointerId] = y;
        }
    }

    private boolean isCapturedViewUnder(int i, int i2) {
        return isViewUnder(this.ahZ, i, i2);
    }

    private boolean isPointerDown(int i) {
        return ((1 << i) & this.ahT) != 0;
    }

    private static boolean isViewUnder(View view, int i, int i2) {
        return view != null && i >= view.getLeft() && i < view.getRight() && i2 >= view.getTop() && i2 < view.getBottom();
    }

    private static float l(float f) {
        return (float) Math.sin((float) (((double) (f - 0.5f)) * 0.4712389167638204d));
    }

    private boolean m(View view, int i) {
        if (view == this.ahZ && this.mActivePointerId == i) {
            return true;
        }
        if (view == null || !this.ahJ.tryCaptureView(view, i)) {
            return false;
        }
        this.mActivePointerId = i;
        captureChildView(view, i);
        return true;
    }

    private int p(int i, int i2) {
        int i3 = i < this.ahK.getLeft() + this.ahW ? 1 : 0;
        if (i2 < this.ahK.getTop() + this.ahW) {
            i3 |= 4;
        }
        if (i > this.ahK.getRight() - this.ahW) {
            i3 |= 2;
        }
        return i2 > this.ahK.getBottom() - this.ahW ? i3 | 8 : i3;
    }

    private void vp() {
        float[] fArr = this.ahM;
        if (fArr == null) {
            return;
        }
        Arrays.fill(fArr, 0.0f);
        Arrays.fill(this.ahN, 0.0f);
        Arrays.fill(this.ahO, 0.0f);
        Arrays.fill(this.ahP, 0.0f);
        Arrays.fill(this.ahQ, 0);
        Arrays.fill(this.ahR, 0);
        Arrays.fill(this.ahS, 0);
        this.ahT = 0;
    }

    private void vq() {
        this.mVelocityTracker.computeCurrentVelocity(1000, this.ahU);
        g(a(VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), this.ahV, this.ahU), a(VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId), this.ahV, this.ahU));
    }

    public final void bN(int i) {
        this.ahK.removeCallbacks(this.aia);
        if (this.ahL != i) {
            this.ahL = i;
            this.ahJ.onViewDragStateChanged(i);
            if (this.ahL == 0) {
                this.ahZ = null;
            }
        }
    }

    public final void captureChildView(View view, int i) {
        if (view.getParent() == this.ahK) {
            this.ahZ = view;
            this.mActivePointerId = i;
            bN(1);
        } else {
            throw new IllegalArgumentException("captureChildView: parameter must be a descendant of the ViewDragHelper's tracked parent view (" + this.ahK + ")");
        }
    }

    public final boolean continueSettling(boolean z) {
        if (this.ahL == 2) {
            boolean zComputeScrollOffset = this.ahY.computeScrollOffset();
            int currX = this.ahY.getCurrX();
            int currY = this.ahY.getCurrY();
            int left = currX - this.ahZ.getLeft();
            int top = currY - this.ahZ.getTop();
            if (left != 0) {
                ViewCompat.offsetLeftAndRight(this.ahZ, left);
            }
            if (top != 0) {
                ViewCompat.offsetTopAndBottom(this.ahZ, top);
            }
            if (left != 0 || top != 0) {
                this.ahJ.bH(currY);
            }
            if (zComputeScrollOffset && currX == this.ahY.getFinalX() && currY == this.ahY.getFinalY()) {
                this.ahY.abortAnimation();
                zComputeScrollOffset = false;
            }
            if (!zComputeScrollOffset) {
                this.ahK.post(this.aia);
            }
        }
        return this.ahL == 2;
    }

    public final int getTouchSlop() {
        return this.mTouchSlop;
    }

    public final void processTouchEvent(MotionEvent motionEvent) {
        float x;
        int i;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i2 = 0;
        if (actionMasked == 0) {
            float x2 = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            View viewFindTopChildUnder = findTopChildUnder((int) x2, (int) y);
            a(x2, y, pointerId);
            m(viewFindTopChildUnder, pointerId);
            int i3 = this.ahQ[pointerId];
            return;
        }
        if (actionMasked == 1) {
            if (this.ahL == 1) {
                vq();
            }
            cancel();
            return;
        }
        float y2 = 0.0f;
        if (actionMasked == 2) {
            if (this.ahL == 1) {
                if (bO(this.mActivePointerId)) {
                    int iFindPointerIndex = MotionEventCompat.findPointerIndex(motionEvent, this.mActivePointerId);
                    try {
                        x = MotionEventCompat.getX(motionEvent, iFindPointerIndex);
                        try {
                            y2 = MotionEventCompat.getY(motionEvent, iFindPointerIndex);
                        } catch (IllegalArgumentException unused) {
                        }
                    } catch (IllegalArgumentException unused2) {
                        x = 0.0f;
                    }
                    float[] fArr = this.ahO;
                    int i4 = this.mActivePointerId;
                    int i5 = (int) (x - fArr[i4]);
                    int i6 = (int) (y2 - this.ahP[i4]);
                    b(this.ahZ.getLeft() + i5, this.ahZ.getTop() + i6, i5, i6);
                    i(motionEvent);
                    return;
                }
                return;
            }
            int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
            while (i2 < pointerCount) {
                int pointerId2 = MotionEventCompat.getPointerId(motionEvent, i2);
                if (bO(pointerId2)) {
                    float x3 = MotionEventCompat.getX(motionEvent, i2);
                    float y3 = MotionEventCompat.getY(motionEvent, i2);
                    float f = x3 - this.ahM[pointerId2];
                    float f2 = y3 - this.ahN[pointerId2];
                    b(f, f2, pointerId2);
                    if (this.ahL == 1) {
                        break;
                    }
                    View viewFindTopChildUnder2 = findTopChildUnder((int) x3, (int) y3);
                    if (a(viewFindTopChildUnder2, f, f2) && m(viewFindTopChildUnder2, pointerId2)) {
                        break;
                    }
                }
                i2++;
            }
            i(motionEvent);
            return;
        }
        if (actionMasked == 3) {
            if (this.ahL == 1) {
                g(0.0f, 0.0f);
            }
            cancel();
            return;
        }
        if (actionMasked == 5) {
            int pointerId3 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
            float x4 = MotionEventCompat.getX(motionEvent, actionIndex);
            float y4 = MotionEventCompat.getY(motionEvent, actionIndex);
            a(x4, y4, pointerId3);
            if (this.ahL == 0) {
                m(findTopChildUnder((int) x4, (int) y4), pointerId3);
                return;
            } else {
                if (isCapturedViewUnder((int) x4, (int) y4)) {
                    m(this.ahZ, pointerId3);
                    return;
                }
                return;
            }
        }
        if (actionMasked != 6) {
            return;
        }
        int pointerId4 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
        if (this.ahL == 1 && pointerId4 == this.mActivePointerId) {
            int pointerCount2 = MotionEventCompat.getPointerCount(motionEvent);
            while (true) {
                if (i2 >= pointerCount2) {
                    i = -1;
                    break;
                }
                int pointerId5 = MotionEventCompat.getPointerId(motionEvent, i2);
                if (pointerId5 != this.mActivePointerId) {
                    View viewFindTopChildUnder3 = findTopChildUnder((int) MotionEventCompat.getX(motionEvent, i2), (int) MotionEventCompat.getY(motionEvent, i2));
                    View view = this.ahZ;
                    if (viewFindTopChildUnder3 == view && m(view, pointerId5)) {
                        i = this.mActivePointerId;
                        break;
                    }
                }
                i2++;
            }
            if (i == -1) {
                vq();
            }
        }
        bL(pointerId4);
    }

    public final boolean settleCapturedViewAt(int i, int i2) {
        if (this.aib) {
            return a(i, i2, (int) VelocityTrackerCompat.getXVelocity(this.mVelocityTracker, this.mActivePointerId), (int) VelocityTrackerCompat.getYVelocity(this.mVelocityTracker, this.mActivePointerId));
        }
        throw new IllegalStateException("Cannot settleCapturedViewAt outside of a call to Callback#onViewReleased");
    }

    /* JADX WARN: Code duplicated, block: B:45:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:52:0x00d3  */
    public final boolean shouldInterceptTouchEvent(MotionEvent motionEvent) {
        View viewFindTopChildUnder;
        int actionMasked = MotionEventCompat.getActionMasked(motionEvent);
        int actionIndex = MotionEventCompat.getActionIndex(motionEvent);
        if (actionMasked == 0) {
            cancel();
        }
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        if (actionMasked == 0) {
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            int pointerId = MotionEventCompat.getPointerId(motionEvent, 0);
            a(x, y, pointerId);
            View viewFindTopChildUnder2 = findTopChildUnder((int) x, (int) y);
            if (viewFindTopChildUnder2 == this.ahZ && this.ahL == 2) {
                m(viewFindTopChildUnder2, pointerId);
            }
            int i = this.ahQ[pointerId];
        } else if (actionMasked == 1) {
            cancel();
        } else if (actionMasked != 2) {
            if (actionMasked == 3) {
                cancel();
            } else if (actionMasked == 5) {
                int pointerId2 = MotionEventCompat.getPointerId(motionEvent, actionIndex);
                float x2 = MotionEventCompat.getX(motionEvent, actionIndex);
                float y2 = MotionEventCompat.getY(motionEvent, actionIndex);
                a(x2, y2, pointerId2);
                int i2 = this.ahL;
                if (i2 != 0 && i2 == 2 && (viewFindTopChildUnder = findTopChildUnder((int) x2, (int) y2)) == this.ahZ) {
                    m(viewFindTopChildUnder, pointerId2);
                }
            } else if (actionMasked == 6) {
                bL(MotionEventCompat.getPointerId(motionEvent, actionIndex));
            }
        } else if (this.ahM != null && this.ahN != null) {
            int pointerCount = MotionEventCompat.getPointerCount(motionEvent);
            for (int i3 = 0; i3 < pointerCount; i3++) {
                int pointerId3 = MotionEventCompat.getPointerId(motionEvent, i3);
                if (bO(pointerId3)) {
                    float x3 = MotionEventCompat.getX(motionEvent, i3);
                    float y3 = MotionEventCompat.getY(motionEvent, i3);
                    float f = x3 - this.ahM[pointerId3];
                    float f2 = y3 - this.ahN[pointerId3];
                    View viewFindTopChildUnder3 = findTopChildUnder((int) x3, (int) y3);
                    boolean z = viewFindTopChildUnder3 != null && a(viewFindTopChildUnder3, f, f2);
                    if (!z) {
                        b(f, f2, pointerId3);
                        if (this.ahL == 1) {
                            break;
                        }
                        break;
                        break;
                    }
                    viewFindTopChildUnder3.getLeft();
                    this.ahJ.E(viewFindTopChildUnder3);
                    int top = viewFindTopChildUnder3.getTop();
                    int iBI = this.ahJ.bI(((int) f2) + top);
                    int iVm = this.ahJ.vm();
                    if (iVm == 0 || (iVm > 0 && iBI == top)) {
                        break;
                    }
                    b(f, f2, pointerId3);
                    if (this.ahL == 1 || (z && m(viewFindTopChildUnder3, pointerId3))) {
                        break;
                    }
                }
            }
            i(motionEvent);
        }
        return this.ahL == 1;
    }

    public final boolean smoothSlideViewTo(View view, int i, int i2) {
        this.ahZ = view;
        this.mActivePointerId = -1;
        boolean zA = a(i, i2, 0, 0);
        if (!zA && this.ahL == 0 && this.ahZ != null) {
            this.ahZ = null;
        }
        return zA;
    }

    private boolean a(int i, int i2, int i3, int i4) {
        int left = this.ahZ.getLeft();
        int top = this.ahZ.getTop();
        int i5 = i - left;
        int i6 = i2 - top;
        if (i5 == 0 && i6 == 0) {
            this.ahY.abortAnimation();
            bN(0);
            return false;
        }
        int i7 = this.duration;
        this.ahY.startScroll(left, top, i5, i6, i7 == 0 ? b(this.ahZ, i5, i6, i3, i4) : i7);
        bN(2);
        return true;
    }

    private static float a(float f, float f2, float f3) {
        float fAbs = Math.abs(f);
        if (fAbs < f2) {
            return 0.0f;
        }
        if (fAbs > f3) {
            return f > 0.0f ? f3 : -f3;
        }
        return f;
    }

    private int b(int i, int i2, int i3) {
        int iAbs;
        if (i == 0) {
            return 0;
        }
        int width = this.ahK.getWidth();
        float f = width / 2;
        float fL = f + (l(Math.min(1.0f, Math.abs(i) / width)) * f);
        int iAbs2 = Math.abs(i2);
        if (iAbs2 > 0) {
            iAbs = Math.round(Math.abs(fL / iAbs2) * 1000.0f) * 4;
        } else {
            iAbs = (int) (((Math.abs(i) / i3) + 1.0f) * 256.0f);
        }
        return Math.min(iAbs, 600);
    }

    private void a(float f, float f2, int i) {
        bM(i);
        float[] fArr = this.ahM;
        this.ahO[i] = f;
        fArr[i] = f;
        float[] fArr2 = this.ahN;
        this.ahP[i] = f2;
        fArr2[i] = f2;
        this.ahQ[i] = p((int) f, (int) f2);
        this.ahT |= 1 << i;
    }

    private boolean a(float f, float f2, int i, int i2) {
        float fAbs = Math.abs(f);
        float fAbs2 = Math.abs(f2);
        if ((this.ahQ[i] & i2) == i2 && (this.ahX & i2) != 0 && (this.ahS[i] & i2) != i2) {
            int i3 = this.ahR[i];
            if ((i3 & i2) != i2) {
                int i4 = this.mTouchSlop;
                if ((fAbs > i4 || fAbs2 > i4) && (i3 & i2) == 0 && fAbs > i4) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v14 */
    /* JADX WARN: Type inference failed for: r0v15 */
    /* JADX WARN: Type inference failed for: r0v16 */
    /* JADX WARN: Type inference failed for: r0v2 */
    /* JADX WARN: Type inference failed for: r0v3 */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r4v2 */
    private void b(float f, float f2, int i) {
        int i2;
        boolean zA = a(f, f2, i, 1);
        ?? r0 = zA;
        if (a(f2, f, i, 4)) {
            r0 = (zA ? 1 : 0) | 4;
        }
        ?? r1 = r0;
        if (a(f, f2, i, 2)) {
            r1 = (r0 == true ? 1 : 0) | 2;
        }
        ?? r2 = r1;
        if (a(f2, f, i, 8)) {
            i2 = (r1 == true ? 1 : 0) | 8;
        }
        if (r2 == 0) {
            r2 = i2;
            return;
        }
        r2 = i2;
        int[] iArr = this.ahR;
        iArr[i] = (iArr[i] | r2) == true ? 1 : 0;
    }

    private boolean a(View view, float f, float f2) {
        if (view == null) {
            return false;
        }
        return (this.ahJ.vm() > 0) && Math.abs(f2) > ((float) this.mTouchSlop);
    }

    private void b(int i, int i2, int i3, int i4) {
        int left = this.ahZ.getLeft();
        int top = this.ahZ.getTop();
        if (i3 != 0) {
            ViewCompat.offsetLeftAndRight(this.ahZ, this.ahJ.E(this.ahZ) - left);
        }
        if (i4 != 0) {
            i2 = this.ahJ.bI(i2);
            ViewCompat.offsetTopAndBottom(this.ahZ, i2 - top);
        }
        if (i3 == 0 && i4 == 0) {
            return;
        }
        this.ahJ.bH(i2);
    }
}
