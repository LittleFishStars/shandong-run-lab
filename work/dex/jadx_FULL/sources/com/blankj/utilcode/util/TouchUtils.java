package com.blankj.utilcode.util;

import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class TouchUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final int f28209a = 0;
    public static final int b = 1;
    public static final int c = 2;
    public static final int d = 4;
    public static final int e = 8;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Direction {
    }

    public static abstract class OnTouchUtilsListener implements View.OnTouchListener {
        public static final int T = 0;
        public static final int U = 1;
        public static final int V = 2;
        public static final int W = 1000;
        public int K;
        public int L;
        public int M;
        public int N;
        public int O;
        public int P;
        public int Q;
        public int R;
        public int S;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public VelocityTracker f28210a;

        public OnTouchUtilsListener() {
            g(-1, -1);
        }

        public abstract boolean a(View view, int i, int i2, MotionEvent motionEvent);

        public abstract boolean b(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, MotionEvent motionEvent);

        public abstract boolean c(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, MotionEvent motionEvent);

        public boolean d(View view, MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            g(rawX, rawY);
            view.setPressed(true);
            return a(view, rawX, rawY, motionEvent);
        }

        public boolean e(View view, MotionEvent motionEvent) {
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            if (this.L == -1) {
                g(rawX, rawY);
                view.setPressed(true);
            }
            if (this.P != 1) {
                if (Math.abs(rawX - this.N) < this.K && Math.abs(rawY - this.O) < this.K) {
                    return true;
                }
                this.P = 1;
                if (Math.abs(rawX - this.N) >= Math.abs(rawY - this.O)) {
                    if (rawX - this.N < 0) {
                        this.Q = 1;
                    } else {
                        this.Q = 4;
                    }
                } else if (rawY - this.O < 0) {
                    this.Q = 2;
                } else {
                    this.Q = 8;
                }
            }
            boolean zB = b(view, this.Q, rawX, rawY, rawX - this.N, rawY - this.O, rawX - this.L, rawY - this.M, motionEvent);
            this.N = rawX;
            this.O = rawY;
            return zB;
        }

        public boolean f(View view, MotionEvent motionEvent) {
            int i;
            int i2;
            int rawX = (int) motionEvent.getRawX();
            int rawY = (int) motionEvent.getRawY();
            VelocityTracker velocityTracker = this.f28210a;
            if (velocityTracker != null) {
                velocityTracker.computeCurrentVelocity(1000, this.R);
                int xVelocity = (int) this.f28210a.getXVelocity();
                int yVelocity = (int) this.f28210a.getYVelocity();
                this.f28210a.recycle();
                if (Math.abs(xVelocity) < this.S) {
                    xVelocity = 0;
                }
                if (Math.abs(yVelocity) < this.S) {
                    yVelocity = 0;
                }
                this.f28210a = null;
                i = xVelocity;
                i2 = yVelocity;
            } else {
                i = 0;
                i2 = 0;
            }
            view.setPressed(false);
            boolean zC = c(view, this.Q, rawX, rawY, rawX - this.L, rawY - this.M, i, i2, motionEvent);
            if (motionEvent.getAction() == 1 && this.P == 0) {
                if (motionEvent.getEventTime() - motionEvent.getDownTime() <= 1000) {
                    view.performClick();
                } else {
                    view.performLongClick();
                }
            }
            g(-1, -1);
            return zC;
        }

        public final void g(int i, int i2) {
            this.L = i;
            this.M = i2;
            this.N = i;
            this.O = i2;
            this.P = 0;
            this.Q = 0;
            VelocityTracker velocityTracker = this.f28210a;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }

        @Override // android.view.View.OnTouchListener
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (this.K == 0) {
                this.K = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
            }
            if (this.R == 0) {
                this.R = ViewConfiguration.get(view.getContext()).getScaledMaximumFlingVelocity();
            }
            if (this.S == 0) {
                this.S = ViewConfiguration.get(view.getContext()).getScaledMinimumFlingVelocity();
            }
            if (this.f28210a == null) {
                this.f28210a = VelocityTracker.obtain();
            }
            this.f28210a.addMovement(motionEvent);
            int action = motionEvent.getAction();
            if (action == 0) {
                return d(view, motionEvent);
            }
            if (action != 1) {
                if (action == 2) {
                    return e(view, motionEvent);
                }
                if (action != 3) {
                    return false;
                }
            }
            return f(view, motionEvent);
        }
    }

    public TouchUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static void a(View view, OnTouchUtilsListener onTouchUtilsListener) {
        if (view == null || onTouchUtilsListener == null) {
            return;
        }
        view.setOnTouchListener(onTouchUtilsListener);
    }
}
