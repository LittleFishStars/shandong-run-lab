package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.view.MotionEvent;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class at extends an {
    public static final PointF e = new PointF();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public PointF f25879a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final a f712a;
    public PointF b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public boolean f713b;
    public PointF c;
    public PointF d;

    public interface a {
        void a(at atVar);
    }

    public static class b implements a {
        @Override // com.amap.api.col.3l.at.a
        public void a(at atVar) {
        }
    }

    public at(Context context, a aVar) {
        super(context);
        this.c = new PointF();
        this.d = new PointF();
        this.f712a = aVar;
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a(int i, MotionEvent motionEvent, int i2, int i3) {
        if (i != 5) {
            return;
        }
        a();
        ((ao) this).f692a = MotionEvent.obtain(motionEvent);
        ((ao) this).f690a = 0L;
        a(motionEvent);
        boolean zA = a(motionEvent, i2, i3);
        this.f713b = zA;
        if (zA) {
            return;
        }
        ((ao) this).f693a = true;
    }

    public final float j() {
        return this.c.x;
    }

    public final float k() {
        return this.c.y;
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a(int i, MotionEvent motionEvent) {
        if (i == 3) {
            a();
        } else {
            if (i != 6) {
                return;
            }
            a(motionEvent);
            if (!this.f713b) {
                this.f712a.a(this);
            }
            a();
        }
    }

    @Override // com.amap.api.col.p0003l.ao
    public final void a() {
        super.a();
        this.f713b = false;
        PointF pointF = this.c;
        pointF.x = 0.0f;
        PointF pointF2 = this.d;
        pointF2.x = 0.0f;
        pointF.y = 0.0f;
        pointF2.y = 0.0f;
    }

    @Override // com.amap.api.col.p0003l.an, com.amap.api.col.p0003l.ao
    public final void a(MotionEvent motionEvent) {
        PointF pointF;
        super.a(motionEvent);
        MotionEvent motionEvent2 = ((ao) this).f692a;
        this.f25879a = ao.d(motionEvent);
        this.b = ao.d(motionEvent2);
        if (((ao) this).f692a.getPointerCount() != motionEvent.getPointerCount()) {
            pointF = e;
        } else {
            PointF pointF2 = this.f25879a;
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
