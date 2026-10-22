package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class aq extends ao {
    public static final PointF e = new PointF();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PointF f25877a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f698a;
    public PointF b;
    public PointF c;
    public PointF d;

    public interface a {
        void a(aq aqVar);

        boolean b(aq aqVar);

        boolean c(aq aqVar);
    }

    public aq(Context context, a aVar) {
        super(context);
        this.c = new PointF();
        this.d = new PointF();
        this.f698a = aVar;
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a(int i, MotionEvent motionEvent, int i2, int i3) {
        if (i == 0) {
            a();
            ((ao) this).f692a = MotionEvent.obtain(motionEvent);
            ((ao) this).f690a = 0L;
            a(motionEvent);
            return;
        }
        if (i == 2) {
            ((ao) this).f693a = this.f698a.b(this);
            return;
        }
        if (i != 5) {
            return;
        }
        MotionEvent motionEvent2 = ((ao) this).f692a;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
        }
        ((ao) this).f692a = MotionEvent.obtain(motionEvent);
        a(motionEvent);
    }

    public final PointF g() {
        return this.d;
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a(int i, MotionEvent motionEvent) {
        if (i != 1) {
            if (i == 2) {
                a(motionEvent);
                if (((ao) this).f25875a / ((ao) this).b <= 0.67f || motionEvent.getPointerCount() > 1 || !this.f698a.c(this)) {
                    return;
                }
                ((ao) this).f692a.recycle();
                ((ao) this).f692a = MotionEvent.obtain(motionEvent);
                return;
            }
            if (i != 3) {
                return;
            }
        }
        this.f698a.a(this);
        a();
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a(MotionEvent motionEvent) {
        PointF pointF;
        super.a(motionEvent);
        MotionEvent motionEvent2 = ((ao) this).f692a;
        this.f25877a = ao.d(motionEvent);
        this.b = ao.d(motionEvent2);
        boolean z = ((ao) this).f692a.getPointerCount() != motionEvent.getPointerCount();
        if (z) {
            pointF = e;
        } else {
            PointF pointF2 = this.f25877a;
            float f = pointF2.x;
            PointF pointF3 = this.b;
            pointF = new PointF(f - pointF3.x, pointF2.y - pointF3.y);
        }
        this.d = pointF;
        if (z) {
            ((ao) this).f692a.recycle();
            ((ao) this).f692a = MotionEvent.obtain(motionEvent);
        }
        PointF pointF4 = this.c;
        float f2 = pointF4.x;
        PointF pointF5 = this.d;
        pointF4.x = f2 + pointF5.x;
        pointF4.y += pointF5.y;
    }
}
