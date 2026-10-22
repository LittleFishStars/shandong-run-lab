package com.amap.api.col.p0003l;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class ar {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f25878a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f699a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f700a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f701a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MotionEvent f702a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f703a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f704a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f705b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public MotionEvent f706b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f707b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public boolean f709c;
    public float d;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public boolean f711d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public final float l;
    public float m;
    public float n;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public int f708c = 0;

    /* JADX INFO: renamed from: d, reason: collision with other field name */
    public int f710d = 0;

    public interface a {
        boolean a(ar arVar);

        boolean b(ar arVar);

        void c(ar arVar);
    }

    public ar(Context context, a aVar) {
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f701a = context;
        this.f703a = aVar;
        this.l = viewConfiguration.getScaledEdgeSlop();
    }

    public static float a(MotionEvent motionEvent, int i) {
        if (i < 0) {
            return Float.MIN_VALUE;
        }
        if (i == 0) {
            return motionEvent.getRawX();
        }
        return motionEvent.getX(i) + (motionEvent.getRawX() - motionEvent.getX());
    }

    public static float g(MotionEvent motionEvent, int i) {
        if (i < 0) {
            return Float.MIN_VALUE;
        }
        if (i == 0) {
            return motionEvent.getRawY();
        }
        return motionEvent.getY(i) + (motionEvent.getRawY() - motionEvent.getY());
    }

    public final int b(MotionEvent motionEvent, int i, int i2) {
        int pointerCount = motionEvent.getPointerCount();
        int iFindPointerIndex = motionEvent.findPointerIndex(i);
        for (int i3 = 0; i3 < pointerCount; i3++) {
            if (i3 != i2 && i3 != iFindPointerIndex) {
                float f = this.l;
                float f2 = this.m;
                float f3 = this.n;
                float fA = a(motionEvent, i3);
                float fG = g(motionEvent, i3);
                if (fA >= f && fG >= f && fA <= f2 && fG <= f3) {
                    return i3;
                }
            }
        }
        return -1;
    }

    public final MotionEvent c() {
        return this.f706b;
    }

    public final void d(int i, int i2) {
        this.f708c = i;
        this.f710d = i2;
    }

    /* JADX WARN: Code duplicated, block: B:144:0x0278  */
    public final boolean e(MotionEvent motionEvent) {
        int iB;
        int iB2;
        int i;
        int iB3;
        int action = motionEvent.getAction() & 255;
        if (action == 0) {
            p();
        }
        boolean z = false;
        if (this.f709c) {
            return false;
        }
        if (this.f704a) {
            if (action == 1) {
                p();
            } else if (action == 2) {
                h(motionEvent);
                if (this.j / this.k > 0.67f && this.f703a.a(this)) {
                    this.f702a.recycle();
                    this.f702a = MotionEvent.obtain(motionEvent);
                }
            } else if (action == 3) {
                this.f703a.c(this);
                p();
            } else if (action == 5) {
                this.f703a.c(this);
                int i2 = this.f699a;
                int i3 = this.f705b;
                p();
                this.f702a = MotionEvent.obtain(motionEvent);
                if (!this.f711d) {
                    i2 = i3;
                }
                this.f699a = i2;
                this.f705b = motionEvent.getPointerId(motionEvent.getActionIndex());
                this.f711d = false;
                int iFindPointerIndex = motionEvent.findPointerIndex(this.f699a);
                if (iFindPointerIndex < 0 || this.f699a == this.f705b) {
                    int i4 = this.f699a;
                    int i5 = this.f705b;
                    this.f699a = motionEvent.getPointerId(b(motionEvent, i4 != i5 ? i5 : -1, iFindPointerIndex));
                }
                h(motionEvent);
                this.f704a = this.f703a.b(this);
            } else if (action == 6) {
                int pointerCount = motionEvent.getPointerCount();
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                if (pointerCount > 2) {
                    int i6 = this.f699a;
                    if (pointerId == i6) {
                        int iB4 = b(motionEvent, this.f705b, actionIndex);
                        if (iB4 >= 0) {
                            this.f703a.c(this);
                            this.f699a = motionEvent.getPointerId(iB4);
                            this.f711d = true;
                            this.f702a = MotionEvent.obtain(motionEvent);
                            h(motionEvent);
                            this.f704a = this.f703a.b(this);
                        } else {
                            z = true;
                        }
                    } else if (pointerId == this.f705b) {
                        int iB5 = b(motionEvent, i6, actionIndex);
                        if (iB5 >= 0) {
                            this.f703a.c(this);
                            this.f705b = motionEvent.getPointerId(iB5);
                            this.f711d = false;
                            this.f702a = MotionEvent.obtain(motionEvent);
                            h(motionEvent);
                            this.f704a = this.f703a.b(this);
                        } else {
                            z = true;
                        }
                    }
                    this.f702a.recycle();
                    this.f702a = MotionEvent.obtain(motionEvent);
                    h(motionEvent);
                } else {
                    z = true;
                }
                if (z) {
                    h(motionEvent);
                    int i7 = this.f699a;
                    if (pointerId == i7) {
                        i7 = this.f705b;
                    }
                    int iFindPointerIndex2 = motionEvent.findPointerIndex(i7);
                    this.f25878a = motionEvent.getX(iFindPointerIndex2);
                    this.b = motionEvent.getY(iFindPointerIndex2);
                    this.f703a.c(this);
                    p();
                    this.f699a = i7;
                    this.f711d = true;
                }
            }
        } else if (action == 0) {
            this.f699a = motionEvent.getPointerId(0);
            this.f711d = true;
        } else if (action == 1) {
            p();
        } else if (action != 2) {
            if (action == 5) {
                int i8 = this.f708c;
                if (i8 == 0 || (i = this.f710d) == 0) {
                    DisplayMetrics displayMetrics = this.f701a.getResources().getDisplayMetrics();
                    float f = displayMetrics.widthPixels;
                    float f2 = this.l;
                    this.m = f - f2;
                    this.n = displayMetrics.heightPixels - f2;
                } else {
                    float f3 = this.l;
                    this.m = i8 - f3;
                    this.n = i - f3;
                }
                MotionEvent motionEvent2 = this.f702a;
                if (motionEvent2 != null) {
                    motionEvent2.recycle();
                }
                this.f702a = MotionEvent.obtain(motionEvent);
                this.f700a = 0L;
                int actionIndex2 = motionEvent.getActionIndex();
                int iFindPointerIndex3 = motionEvent.findPointerIndex(this.f699a);
                int pointerId2 = motionEvent.getPointerId(actionIndex2);
                this.f705b = pointerId2;
                if (iFindPointerIndex3 < 0 || iFindPointerIndex3 == actionIndex2) {
                    iFindPointerIndex3 = b(motionEvent, iFindPointerIndex3 != actionIndex2 ? pointerId2 : -1, iFindPointerIndex3);
                    this.f699a = motionEvent.getPointerId(iFindPointerIndex3);
                }
                this.f711d = false;
                h(motionEvent);
                float f4 = this.l;
                float f5 = this.m;
                float f6 = this.n;
                float fA = a(motionEvent, iFindPointerIndex3);
                float fG = g(motionEvent, iFindPointerIndex3);
                float fA2 = a(motionEvent, actionIndex2);
                float fG2 = g(motionEvent, actionIndex2);
                boolean z2 = fA < f4 || fG < f4 || fA > f5 || fG > f6;
                boolean z3 = fA2 < f4 || fG2 < f4 || fA2 > f5 || fG2 > f6;
                if (z2 && z3) {
                    this.f25878a = -1.0f;
                    this.b = -1.0f;
                    this.f707b = true;
                } else if (z2) {
                    this.f25878a = motionEvent.getX(actionIndex2);
                    this.b = motionEvent.getY(actionIndex2);
                    this.f707b = true;
                } else if (z3) {
                    this.f25878a = motionEvent.getX(iFindPointerIndex3);
                    this.b = motionEvent.getY(iFindPointerIndex3);
                    this.f707b = true;
                } else {
                    this.f707b = false;
                    this.f704a = this.f703a.b(this);
                }
            } else if (action == 6 && this.f707b) {
                int pointerCount2 = motionEvent.getPointerCount();
                int actionIndex3 = motionEvent.getActionIndex();
                int pointerId3 = motionEvent.getPointerId(actionIndex3);
                if (pointerCount2 > 2) {
                    int i9 = this.f699a;
                    if (pointerId3 == i9) {
                        int iB6 = b(motionEvent, this.f705b, actionIndex3);
                        if (iB6 >= 0) {
                            this.f699a = motionEvent.getPointerId(iB6);
                        }
                    } else if (pointerId3 == this.f705b && (iB3 = b(motionEvent, i9, actionIndex3)) >= 0) {
                        this.f705b = motionEvent.getPointerId(iB3);
                    }
                } else {
                    int i10 = this.f699a;
                    if (pointerId3 == i10) {
                        i10 = this.f705b;
                    }
                    int iFindPointerIndex4 = motionEvent.findPointerIndex(i10);
                    if (iFindPointerIndex4 < 0) {
                        this.f709c = true;
                        if (this.f704a) {
                            this.f703a.c(this);
                        }
                        return false;
                    }
                    this.f699a = motionEvent.getPointerId(iFindPointerIndex4);
                    this.f711d = true;
                    this.f705b = -1;
                    this.f25878a = motionEvent.getX(iFindPointerIndex4);
                    this.b = motionEvent.getY(iFindPointerIndex4);
                }
            }
        } else if (this.f707b) {
            float f7 = this.l;
            float f8 = this.m;
            float f9 = this.n;
            int iFindPointerIndex5 = motionEvent.findPointerIndex(this.f699a);
            int iFindPointerIndex6 = motionEvent.findPointerIndex(this.f705b);
            float fA3 = a(motionEvent, iFindPointerIndex5);
            float fG3 = g(motionEvent, iFindPointerIndex5);
            float fA4 = a(motionEvent, iFindPointerIndex6);
            float fG4 = g(motionEvent, iFindPointerIndex6);
            boolean z4 = fA3 < f7 || fG3 < f7 || fA3 > f8 || fG3 > f9;
            boolean z5 = fA4 < f7 || fG4 < f7 || fA4 > f8 || fG4 > f9;
            if (z4 && (iB2 = b(motionEvent, this.f705b, iFindPointerIndex5)) >= 0) {
                this.f699a = motionEvent.getPointerId(iB2);
                a(motionEvent, iB2);
                g(motionEvent, iB2);
                z4 = false;
                iFindPointerIndex5 = iB2;
            }
            if (z5 && (iB = b(motionEvent, this.f699a, iFindPointerIndex6)) >= 0) {
                this.f705b = motionEvent.getPointerId(iB);
                a(motionEvent, iB);
                g(motionEvent, iB);
                z5 = false;
                iFindPointerIndex6 = iB;
            }
            if (z4 && z5) {
                this.f25878a = -1.0f;
                this.b = -1.0f;
            } else if (z4) {
                this.f25878a = motionEvent.getX(iFindPointerIndex6);
                this.b = motionEvent.getY(iFindPointerIndex6);
            } else if (z5) {
                this.f25878a = motionEvent.getX(iFindPointerIndex5);
                this.b = motionEvent.getY(iFindPointerIndex5);
            } else {
                this.f707b = false;
                this.f704a = this.f703a.b(this);
            }
        }
        return true;
    }

    public final float f() {
        return this.f25878a;
    }

    public final void h(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.f706b;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        this.f706b = MotionEvent.obtain(motionEvent);
        this.g = -1.0f;
        this.h = -1.0f;
        this.i = -1.0f;
        MotionEvent motionEvent3 = this.f702a;
        int iFindPointerIndex = motionEvent3.findPointerIndex(this.f699a);
        int iFindPointerIndex2 = motionEvent3.findPointerIndex(this.f705b);
        int iFindPointerIndex3 = motionEvent.findPointerIndex(this.f699a);
        int iFindPointerIndex4 = motionEvent.findPointerIndex(this.f705b);
        if (iFindPointerIndex < 0 || iFindPointerIndex2 < 0 || iFindPointerIndex3 < 0 || iFindPointerIndex4 < 0) {
            this.f709c = true;
            if (this.f704a) {
                this.f703a.c(this);
                return;
            }
            return;
        }
        float x = motionEvent3.getX(iFindPointerIndex);
        float y = motionEvent3.getY(iFindPointerIndex);
        float x2 = motionEvent3.getX(iFindPointerIndex2);
        float y2 = motionEvent3.getY(iFindPointerIndex2);
        float x3 = motionEvent.getX(iFindPointerIndex3);
        float y3 = motionEvent.getY(iFindPointerIndex3);
        float x4 = motionEvent.getX(iFindPointerIndex4) - x3;
        float y4 = motionEvent.getY(iFindPointerIndex4) - y3;
        this.c = x2 - x;
        this.d = y2 - y;
        this.e = x4;
        this.f = y4;
        this.f25878a = x3 + (x4 * 0.5f);
        this.b = y3 + (y4 * 0.5f);
        this.f700a = motionEvent.getEventTime() - motionEvent3.getEventTime();
        this.j = motionEvent.getPressure(iFindPointerIndex3) + motionEvent.getPressure(iFindPointerIndex4);
        this.k = motionEvent3.getPressure(iFindPointerIndex) + motionEvent3.getPressure(iFindPointerIndex2);
    }

    public final float i() {
        return this.b;
    }

    public final float j() {
        return this.e;
    }

    public final float k() {
        return this.f;
    }

    public final float l() {
        return this.c;
    }

    public final float m() {
        return this.d;
    }

    public final float n() {
        if (this.i == -1.0f) {
            this.i = q() / r();
        }
        return this.i;
    }

    public final long o() {
        return this.f700a;
    }

    public final void p() {
        MotionEvent motionEvent = this.f702a;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f702a = null;
        }
        MotionEvent motionEvent2 = this.f706b;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f706b = null;
        }
        this.f707b = false;
        this.f704a = false;
        this.f699a = -1;
        this.f705b = -1;
        this.f709c = false;
    }

    public final float q() {
        if (this.g == -1.0f) {
            float f = this.e;
            float f2 = this.f;
            this.g = (float) Math.sqrt((f * f) + (f2 * f2));
        }
        return this.g;
    }

    public final float r() {
        if (this.h == -1.0f) {
            float f = this.c;
            float f2 = this.d;
            this.h = (float) Math.sqrt((f * f) + (f2 * f2));
        }
        return this.h;
    }
}
