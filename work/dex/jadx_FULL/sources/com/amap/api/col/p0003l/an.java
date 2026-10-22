package com.amap.api.col.p0003l;

import android.content.Context;
import android.graphics.PointF;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewConfiguration;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public abstract class an extends ao {
    public final float c;
    public float d;
    public float e;
    public float f;
    public float g;
    public float h;
    public float i;
    public float j;
    public float k;
    public float l;
    public float m;
    public float n;
    public float o;

    public an(Context context) {
        super(context);
        this.l = 0.0f;
        this.m = 0.0f;
        this.n = 0.0f;
        this.o = 0.0f;
        this.c = ViewConfiguration.get(context).getScaledEdgeSlop();
    }

    public static float g(MotionEvent motionEvent, int i) {
        float x = (i + motionEvent.getX()) - motionEvent.getRawX();
        if (1 < motionEvent.getPointerCount()) {
            return motionEvent.getX(1) + x;
        }
        return 0.0f;
    }

    public static float i(MotionEvent motionEvent, int i) {
        float y = (i + motionEvent.getY()) - motionEvent.getRawY();
        if (1 < motionEvent.getPointerCount()) {
            return motionEvent.getY(1) + y;
        }
        return 0.0f;
    }

    @Override // com.amap.api.col.p0003l.ao
    public void a(MotionEvent motionEvent) {
        super.a(motionEvent);
        MotionEvent motionEvent2 = ((ao) this).f692a;
        int pointerCount = motionEvent2.getPointerCount();
        int pointerCount2 = motionEvent.getPointerCount();
        if (pointerCount2 == 2 && pointerCount2 == pointerCount) {
            this.j = -1.0f;
            this.k = -1.0f;
            float x = motionEvent2.getX(0);
            float y = motionEvent2.getY(0);
            float x2 = motionEvent2.getX(1);
            float y2 = motionEvent2.getY(1);
            this.f = x2 - x;
            this.g = y2 - y;
            float x3 = motionEvent.getX(0);
            float y3 = motionEvent.getY(0);
            float x4 = motionEvent.getX(1);
            float y4 = motionEvent.getY(1);
            this.h = x4 - x3;
            this.i = y4 - y3;
            this.l = x3 - x;
            this.m = y3 - y;
            this.n = x4 - x2;
            this.o = y4 - y2;
        }
    }

    public final PointF h(int i) {
        return i == 0 ? new PointF(this.l, this.m) : new PointF(this.n, this.o);
    }

    public final boolean a(MotionEvent motionEvent, int i, int i2) {
        int i3;
        int i4 = ((ao) this).f689a;
        if (i4 != 0 && (i3 = ((ao) this).f694b) != 0) {
            float f = this.c;
            this.d = i4 - f;
            this.e = i3 - f;
        } else {
            DisplayMetrics displayMetrics = ((ao) this).f691a.getResources().getDisplayMetrics();
            float f2 = displayMetrics.widthPixels;
            float f3 = this.c;
            this.d = f2 - f3;
            this.e = displayMetrics.heightPixels - f3;
        }
        float f4 = this.c;
        float f5 = this.d;
        float f6 = this.e;
        float rawX = motionEvent.getRawX();
        float rawY = motionEvent.getRawY();
        float fG = g(motionEvent, i);
        float fI = i(motionEvent, i2);
        boolean z = rawX < f4 || rawY < f4 || rawX > f5 || rawY > f6;
        boolean z2 = fG < f4 || fI < f4 || fG > f5 || fI > f6;
        return (z && z2) || z || z2;
    }
}
