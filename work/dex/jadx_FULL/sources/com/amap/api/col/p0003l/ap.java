package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class ap extends an {
    public static final PointF e = new PointF();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PointF f25876a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f696a;
    public PointF b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f697b;
    public PointF c;
    public PointF d;

    public interface a {
        boolean a(ap apVar);

        boolean b(ap apVar);

        void c(ap apVar);
    }

    public ap(Context context, a aVar) {
        super(context);
        this.c = new PointF();
        this.d = new PointF();
        this.f696a = aVar;
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a(int i, MotionEvent motionEvent, int i2, int i3) {
        if (i == 2) {
            if (this.f697b) {
                boolean zA = a(motionEvent, i2, i3);
                this.f697b = zA;
                if (zA) {
                    return;
                }
                ((ao) this).f693a = this.f696a.b(this);
                return;
            }
            return;
        }
        if (i != 5) {
            return;
        }
        a();
        ((ao) this).f692a = MotionEvent.obtain(motionEvent);
        ((ao) this).f690a = 0L;
        a(motionEvent);
        boolean zA2 = a(motionEvent, i2, i3);
        this.f697b = zA2;
        if (zA2) {
            return;
        }
        ((ao) this).f693a = this.f696a.b(this);
    }

    public final PointF j() {
        return this.d;
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a(int i, MotionEvent motionEvent) {
        if (i == 2) {
            a(motionEvent);
            if (((ao) this).f25875a / ((ao) this).b <= 0.67f || !this.f696a.a(this)) {
                return;
            }
            ((ao) this).f692a.recycle();
            ((ao) this).f692a = MotionEvent.obtain(motionEvent);
            return;
        }
        if (i == 3) {
            if (!this.f697b) {
                this.f696a.c(this);
            }
            a();
        } else {
            if (i != 6) {
                return;
            }
            a(motionEvent);
            if (!this.f697b) {
                this.f696a.c(this);
            }
            a();
        }
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a() {
        super.a();
        this.f697b = false;
    }

    @Override // com.amap.api.col.p0003l.an, com.amap.api.col.p0003l.ao
    public final void a(MotionEvent motionEvent) {
        PointF pointF;
        super.a(motionEvent);
        MotionEvent motionEvent2 = ((ao) this).f692a;
        this.f25876a = ao.d(motionEvent);
        this.b = ao.d(motionEvent2);
        if (((ao) this).f692a.getPointerCount() != motionEvent.getPointerCount()) {
            pointF = e;
        } else {
            PointF pointF2 = this.f25876a;
            float f = pointF2.x;
            PointF pointF3 = this.b;
            pointF = new PointF(f - pointF3.x, pointF2.y - pointF3.y);
        }
        this.d = pointF;
        PointF pointF4 = this.c;
        pointF4.x += pointF.x;
        pointF4.y += pointF.y;
    }
}
