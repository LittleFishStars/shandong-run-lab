package com.kwad.components.core.innerEc.live.widget;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import com.kwad.sdk.utils.az;
import com.kwad.sdk.utils.cc;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_06_4659cls.dex */
public class d extends GestureDetector implements cc.a {
    private static final int Ym = ViewConfiguration.getLongPressTimeout();
    private static final int Yn = ViewConfiguration.getTapTimeout();
    public static final int Yo = ViewConfiguration.getDoubleTapTimeout();
    private boolean YA;
    private float YB;
    private float YC;
    private float YD;
    private float YE;
    private boolean YF;
    private long YG;
    private int Yh;
    private int Yi;
    private int Yj;
    private int Yk;
    private int Yl;
    private final GestureDetector.OnGestureListener Yp;
    private GestureDetector.OnDoubleTapListener Yq;
    private boolean Yr;
    private boolean Ys;
    private boolean Yt;
    private boolean Yu;
    private boolean Yv;
    private boolean Yw;
    private boolean Yx;
    private MotionEvent Yy;
    private MotionEvent Yz;
    private final Handler jk;
    private VelocityTracker mVelocityTracker;

    public d(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    private boolean a(MotionEvent motionEvent, MotionEvent motionEvent2, MotionEvent motionEvent3) {
        if (!this.Yw) {
            return false;
        }
        long eventTime = motionEvent3.getEventTime() - motionEvent2.getEventTime();
        if (eventTime <= this.YG && eventTime >= 10) {
            int x = ((int) motionEvent.getX()) - ((int) motionEvent3.getX());
            int y = ((int) motionEvent.getY()) - ((int) motionEvent3.getY());
            if ((x * x) + (y * y) < ((motionEvent.getFlags() & 8) != 0 ? 0 : this.Yj)) {
                return true;
            }
        }
        return false;
    }

    private void cancel() {
        this.jk.removeMessages(1);
        this.jk.removeMessages(2);
        this.jk.removeMessages(3);
        this.mVelocityTracker.recycle();
        this.mVelocityTracker = null;
        this.YA = false;
        this.Yr = false;
        this.Yv = false;
        this.Yw = false;
        this.Ys = false;
        this.Yt = false;
        this.Yu = false;
        this.Yx = false;
    }

    private void init(Context context) {
        int scaledDoubleTapSlop;
        int touchSlop;
        az.checkNotNull(this.Yp);
        this.YF = true;
        int i = 300;
        if (context == null) {
            touchSlop = ViewConfiguration.getTouchSlop();
            this.Yk = ViewConfiguration.getMinimumFlingVelocity();
            this.Yl = ViewConfiguration.getMaximumFlingVelocity();
            scaledDoubleTapSlop = 300;
            i = touchSlop;
        } else {
            ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
            int scaledTouchSlop = viewConfiguration.getScaledTouchSlop();
            scaledDoubleTapSlop = viewConfiguration.getScaledDoubleTapSlop();
            this.Yk = viewConfiguration.getScaledMinimumFlingVelocity();
            this.Yl = viewConfiguration.getScaledMaximumFlingVelocity();
            touchSlop = scaledTouchSlop;
        }
        this.Yh = touchSlop * touchSlop;
        this.Yi = i * i;
        this.Yj = scaledDoubleTapSlop * scaledDoubleTapSlop;
    }

    private void sP() {
        this.jk.removeMessages(1);
        this.jk.removeMessages(2);
        this.jk.removeMessages(3);
        this.YA = false;
        this.Yv = false;
        this.Yw = false;
        this.Ys = false;
        this.Yt = false;
        this.Yu = false;
        this.Yx = false;
    }

    private void sQ() {
        this.jk.removeMessages(3);
        this.Ys = false;
        this.Yt = true;
        this.Yp.onLongPress(this.Yy);
    }

    public final void J(long j) {
        this.YG = j;
    }

    @Override // android.view.GestureDetector
    public boolean isLongpressEnabled() {
        return this.YF;
    }

    @Override // android.view.GestureDetector
    public boolean onTouchEvent(MotionEvent motionEvent) {
        boolean zOnDoubleTap;
        MotionEvent motionEvent2;
        boolean zOnFling;
        GestureDetector.OnDoubleTapListener onDoubleTapListener;
        int action = motionEvent.getAction();
        if (this.mVelocityTracker == null) {
            this.mVelocityTracker = VelocityTracker.obtain();
        }
        this.mVelocityTracker.addMovement(motionEvent);
        int i = action & 255;
        boolean z = i == 6;
        int actionIndex = z ? motionEvent.getActionIndex() : -1;
        boolean z2 = (motionEvent.getFlags() & 8) != 0;
        int pointerCount = motionEvent.getPointerCount();
        float x = 0.0f;
        float y = 0.0f;
        for (int i2 = 0; i2 < pointerCount; i2++) {
            if (actionIndex != i2) {
                x += motionEvent.getX(i2);
                y += motionEvent.getY(i2);
            }
        }
        float f = z ? pointerCount - 1 : pointerCount;
        float f2 = x / f;
        float f3 = y / f;
        if (i == 0) {
            if (this.Yq == null) {
                zOnDoubleTap = false;
            } else {
                boolean zHasMessages = this.jk.hasMessages(3);
                if (zHasMessages) {
                    this.jk.removeMessages(3);
                }
                MotionEvent motionEvent3 = this.Yy;
                if (motionEvent3 == null || (motionEvent2 = this.Yz) == null || !zHasMessages || !a(motionEvent3, motionEvent2, motionEvent)) {
                    this.jk.sendEmptyMessageDelayed(3, this.YG);
                    zOnDoubleTap = false;
                } else {
                    this.YA = true;
                    zOnDoubleTap = this.Yq.onDoubleTap(this.Yy) | false | this.Yq.onDoubleTapEvent(motionEvent);
                }
            }
            this.YB = f2;
            this.YD = f2;
            this.YC = f3;
            this.YE = f3;
            MotionEvent motionEvent4 = this.Yy;
            if (motionEvent4 != null) {
                motionEvent4.recycle();
            }
            this.Yy = MotionEvent.obtain(motionEvent);
            this.Yv = true;
            this.Yw = true;
            this.Yr = true;
            this.Yt = false;
            this.Ys = false;
            if (this.YF) {
                this.jk.removeMessages(2);
                this.jk.sendEmptyMessageAtTime(2, this.Yy.getDownTime() + ((long) Ym));
            }
            this.jk.sendEmptyMessageAtTime(1, this.Yy.getDownTime() + ((long) Yn));
            return zOnDoubleTap | this.Yp.onDown(motionEvent);
        }
        if (i == 1) {
            this.Yr = false;
            MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
            if (this.YA) {
                zOnFling = this.Yq.onDoubleTapEvent(motionEvent) | false;
            } else {
                if (this.Yt) {
                    this.jk.removeMessages(3);
                    this.Yt = false;
                } else if (this.Yv && !this.Yx) {
                    boolean zOnSingleTapUp = this.Yp.onSingleTapUp(motionEvent);
                    if (this.Ys && (onDoubleTapListener = this.Yq) != null) {
                        onDoubleTapListener.onSingleTapConfirmed(motionEvent);
                    }
                    zOnFling = zOnSingleTapUp;
                } else if (!this.Yx) {
                    VelocityTracker velocityTracker = this.mVelocityTracker;
                    int pointerId = motionEvent.getPointerId(0);
                    velocityTracker.computeCurrentVelocity(1000, this.Yl);
                    float yVelocity = velocityTracker.getYVelocity(pointerId);
                    float xVelocity = velocityTracker.getXVelocity(pointerId);
                    if (Math.abs(yVelocity) > this.Yk || Math.abs(xVelocity) > this.Yk) {
                        zOnFling = this.Yp.onFling(this.Yy, motionEvent, xVelocity, yVelocity);
                    }
                }
                zOnFling = false;
            }
            MotionEvent motionEvent5 = this.Yz;
            if (motionEvent5 != null) {
                motionEvent5.recycle();
            }
            this.Yz = motionEventObtain;
            VelocityTracker velocityTracker2 = this.mVelocityTracker;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.mVelocityTracker = null;
            }
            this.YA = false;
            this.Ys = false;
            this.Yx = false;
            this.jk.removeMessages(1);
            this.jk.removeMessages(2);
        } else {
            if (i != 2) {
                if (i == 3) {
                    cancel();
                    return false;
                }
                if (i == 5) {
                    this.YB = f2;
                    this.YD = f2;
                    this.YC = f3;
                    this.YE = f3;
                    sP();
                    return false;
                }
                if (i != 6) {
                    return false;
                }
                this.YB = f2;
                this.YD = f2;
                this.YC = f3;
                this.YE = f3;
                this.mVelocityTracker.computeCurrentVelocity(1000, this.Yl);
                int actionIndex2 = motionEvent.getActionIndex();
                int pointerId2 = motionEvent.getPointerId(actionIndex2);
                float xVelocity2 = this.mVelocityTracker.getXVelocity(pointerId2);
                float yVelocity2 = this.mVelocityTracker.getYVelocity(pointerId2);
                for (int i3 = 0; i3 < pointerCount; i3++) {
                    if (i3 != actionIndex2) {
                        int pointerId3 = motionEvent.getPointerId(i3);
                        if ((this.mVelocityTracker.getXVelocity(pointerId3) * xVelocity2) + (this.mVelocityTracker.getYVelocity(pointerId3) * yVelocity2) < 0.0f) {
                            this.mVelocityTracker.clear();
                            return false;
                        }
                    }
                }
                return false;
            }
            if (this.Yt || this.Yu) {
                return false;
            }
            float f4 = this.YB - f2;
            float f5 = this.YC - f3;
            if (this.YA) {
                return false | this.Yq.onDoubleTapEvent(motionEvent);
            }
            if (!this.Yv) {
                if (Math.abs(f4) < 1.0f && Math.abs(f5) < 1.0f) {
                    return false;
                }
                boolean zOnScroll = this.Yp.onScroll(this.Yy, motionEvent, f4, f5);
                this.YB = f2;
                this.YC = f3;
                return zOnScroll;
            }
            int i4 = (int) (f2 - this.YD);
            int i5 = (int) (f3 - this.YE);
            int i6 = (i4 * i4) + (i5 * i5);
            if (i6 > (z2 ? 0 : this.Yh)) {
                zOnFling = this.Yp.onScroll(this.Yy, motionEvent, f4, f5);
                this.YB = f2;
                this.YC = f3;
                this.Yv = false;
                this.jk.removeMessages(3);
                this.jk.removeMessages(1);
                this.jk.removeMessages(2);
            } else {
                zOnFling = false;
            }
            if (i6 > (z2 ? 0 : this.Yi)) {
                this.Yw = false;
            }
        }
        return zOnFling;
    }

    @Override // android.view.GestureDetector
    public void setIsLongpressEnabled(boolean z) {
        this.YF = z;
    }

    @Override // android.view.GestureDetector
    public void setOnDoubleTapListener(GestureDetector.OnDoubleTapListener onDoubleTapListener) {
        this.Yq = onDoubleTapListener;
    }

    private d(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        super(context, onGestureListener, null);
        this.YG = Yo;
        this.jk = new cc(this);
        this.Yp = onGestureListener;
        if (onGestureListener instanceof GestureDetector.OnDoubleTapListener) {
            setOnDoubleTapListener((GestureDetector.OnDoubleTapListener) onGestureListener);
        }
        init(context);
    }

    @Override // com.kwad.sdk.utils.cc.a
    public final void a(Message message) {
        GestureDetector.OnDoubleTapListener onDoubleTapListener;
        int i = message.what;
        if (i == 1) {
            this.Yp.onShowPress(this.Yy);
            return;
        }
        if (i == 2) {
            sQ();
            return;
        }
        if (i == 3 && (onDoubleTapListener = this.Yq) != null) {
            if (!this.Yr) {
                onDoubleTapListener.onSingleTapConfirmed(this.Yy);
            } else {
                this.Ys = true;
            }
        }
    }
}
