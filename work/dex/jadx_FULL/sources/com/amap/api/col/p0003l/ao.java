package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class ao {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f25875a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public long f690a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Context f691a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public MotionEvent f692a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public boolean f693a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public MotionEvent f695b;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public int f689a = 0;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public int f694b = 0;

    public ao(Context context) {
        this.f691a = context;
    }

    public static PointF d(MotionEvent motionEvent) {
        int pointerCount = motionEvent.getPointerCount();
        float x = 0.0f;
        float y = 0.0f;
        for (int i = 0; i < pointerCount; i++) {
            x += motionEvent.getX(i);
            y += motionEvent.getY(i);
        }
        float f = pointerCount;
        return new PointF(x / f, y / f);
    }

    public abstract void a(int i, MotionEvent motionEvent);

    public abstract void a(int i, MotionEvent motionEvent, int i2, int i3);

    public void a(MotionEvent motionEvent) {
        MotionEvent motionEvent2 = this.f692a;
        MotionEvent motionEvent3 = this.f695b;
        if (motionEvent3 != null) {
            motionEvent3.recycle();
            this.f695b = null;
        }
        this.f695b = MotionEvent.obtain(motionEvent);
        this.f690a = motionEvent.getEventTime() - motionEvent2.getEventTime();
        this.f25875a = motionEvent.getPressure(motionEvent.getActionIndex());
        this.b = motionEvent2.getPressure(motionEvent2.getActionIndex());
    }

    public final void b(int i, int i2) {
        this.f689a = i;
        this.f694b = i2;
    }

    public final long c() {
        return this.f690a;
    }

    public final boolean e(MotionEvent motionEvent, int i, int i2) {
        int action = motionEvent.getAction() & 255;
        if (this.f693a) {
            a(action, motionEvent);
            return true;
        }
        a(action, motionEvent, i, i2);
        return true;
    }

    public final MotionEvent f() {
        return this.f695b;
    }

    public void a() {
        MotionEvent motionEvent = this.f692a;
        if (motionEvent != null) {
            motionEvent.recycle();
            this.f692a = null;
        }
        MotionEvent motionEvent2 = this.f695b;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.f695b = null;
        }
        this.f693a = false;
    }
}
