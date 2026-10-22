package com.github.chrisbanes.photoview.custom;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.zj.adlib.fj9;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class a {
    public static final int c = -1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f30393a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final ScaleGestureDetector f1851a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public VelocityTracker f1852a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final OnGestureListener f1853a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f1854a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f1856b;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public final float f1857c;
    public final float d;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f1850a = -1;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f1855b = 0;

    /* JADX INFO: renamed from: com.github.chrisbanes.photoview.custom.a$a, reason: collision with other inner class name */
    public class ScaleGestureDetectorOnScaleGestureListenerC0662a implements ScaleGestureDetector.OnScaleGestureListener {
        public ScaleGestureDetectorOnScaleGestureListenerC0662a() {
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
            a.this.f1856b = true;
            float scaleFactor = scaleGestureDetector.getScaleFactor();
            if (Float.isNaN(scaleFactor) || Float.isInfinite(scaleFactor)) {
                return false;
            }
            if (scaleFactor >= 0.0f) {
                a.this.f1853a.c(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            }
            return true;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
            return !a.this.f1854a;
        }

        @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
        public void onScaleEnd(ScaleGestureDetector scaleGestureDetector) {
        }
    }

    public a(Context context, OnGestureListener onGestureListener) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.d = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f1857c = viewConfiguration.getScaledTouchSlop();
        this.f1853a = onGestureListener;
        this.f1851a = new ScaleGestureDetector(context, new ScaleGestureDetectorOnScaleGestureListenerC0662a());
    }

    public final float d(MotionEvent motionEvent) {
        try {
            return motionEvent.getX(this.f1855b);
        } catch (Exception unused) {
            return motionEvent.getX();
        }
    }

    public final float e(MotionEvent motionEvent) {
        try {
            return motionEvent.getY(this.f1855b);
        } catch (Exception unused) {
            return motionEvent.getY();
        }
    }

    public boolean f() {
        return this.f1854a;
    }

    public boolean g() {
        return this.f1851a.isInProgress() || this.f1856b;
    }

    public boolean h(MotionEvent motionEvent) {
        try {
            this.f1851a.onTouchEvent(motionEvent);
            return i(motionEvent);
        } catch (IllegalArgumentException unused) {
            return true;
        }
    }

    public final boolean i(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            this.f1850a = motionEvent.getPointerId(0);
            VelocityTracker velocityTrackerObtain = VelocityTracker.obtain();
            this.f1852a = velocityTrackerObtain;
            if (velocityTrackerObtain != null) {
                velocityTrackerObtain.addMovement(motionEvent);
            }
            this.f30393a = d(motionEvent);
            this.b = e(motionEvent);
            this.f1854a = false;
            this.f1856b = false;
        } else if (action == 1) {
            this.f1850a = -1;
            if (this.f1854a && this.f1852a != null) {
                this.f30393a = d(motionEvent);
                this.b = e(motionEvent);
                this.f1852a.addMovement(motionEvent);
                this.f1852a.computeCurrentVelocity(1000);
                float xVelocity = this.f1852a.getXVelocity();
                float yVelocity = this.f1852a.getYVelocity();
                if (Math.max(Math.abs(xVelocity), Math.abs(yVelocity)) >= this.d) {
                    this.f1853a.b(this.f30393a, this.b, -xVelocity, -yVelocity);
                }
            }
            VelocityTracker velocityTracker = this.f1852a;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f1852a = null;
            }
        } else if (action == 2) {
            float fD = d(motionEvent);
            float fE = e(motionEvent);
            float f = fD - this.f30393a;
            float f2 = fE - this.b;
            if (!this.f1856b && !this.f1854a && motionEvent.getPointerCount() == 1) {
                this.f1854a = Math.sqrt((double) ((f * f) + (f2 * f2))) >= ((double) this.f1857c);
            }
            if (this.f1854a) {
                this.f1853a.a(f, f2);
                this.f30393a = fD;
                this.b = fE;
                VelocityTracker velocityTracker2 = this.f1852a;
                if (velocityTracker2 != null) {
                    velocityTracker2.addMovement(motionEvent);
                }
            }
        } else if (action == 3) {
            this.f1850a = -1;
            VelocityTracker velocityTracker3 = this.f1852a;
            if (velocityTracker3 != null) {
                velocityTracker3.recycle();
                this.f1852a = null;
            }
        } else if (action == 6) {
            int iB = fj9.b(motionEvent.getAction());
            if (motionEvent.getPointerId(iB) == this.f1850a) {
                int i = iB == 0 ? 1 : 0;
                this.f1850a = motionEvent.getPointerId(i);
                this.f30393a = motionEvent.getX(i);
                this.b = motionEvent.getY(i);
            }
        }
        int i2 = this.f1850a;
        this.f1855b = motionEvent.findPointerIndex(i2 != -1 ? i2 : 0);
        return true;
    }
}
