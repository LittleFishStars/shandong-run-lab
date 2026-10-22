package com.zj.adlib;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.view.animation.Animation;
import android.view.animation.Transformation;
import java.util.Random;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_05_1888cls.dex */
public class as8 extends Animation {
    public int K;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f40601a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public final Paint f15389a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public PointF f15390a;
    public float b;

    /* JADX INFO: renamed from: b, reason: collision with other field name */
    public PointF f15391b;
    public float c;

    /* JADX INFO: renamed from: c, reason: collision with other field name */
    public PointF f15392c;

    public as8(int i, PointF pointF, PointF pointF2, int i2, int i3) {
        Paint paint = new Paint();
        this.f15389a = paint;
        this.b = 1.0f;
        this.c = 0.4f;
        this.K = i;
        this.f15390a = new PointF((pointF.x + pointF2.x) / 2.0f, (pointF.y + pointF2.y) / 2.0f);
        float f = pointF.x;
        PointF pointF3 = this.f15390a;
        this.f15391b = new PointF(f - pointF3.x, pointF.y - pointF3.y);
        float f2 = pointF2.x;
        PointF pointF4 = this.f15390a;
        this.f15392c = new PointF(f2 - pointF4.x, pointF2.y - pointF4.y);
        h(i2);
        i(i3);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
    }

    public void a(Canvas canvas) {
        PointF pointF = this.f15391b;
        float f = pointF.x;
        float f2 = pointF.y;
        PointF pointF2 = this.f15392c;
        canvas.drawLine(f, f2, pointF2.x, pointF2.y, this.f15389a);
    }

    @Override // android.view.animation.Animation
    public void applyTransformation(float f, Transformation transformation) {
        float f2 = this.b;
        d(f2 + ((this.c - f2) * f));
    }

    public void b(int i) {
        this.f40601a = (-new Random().nextInt(i)) + i;
    }

    public void d(float f) {
        this.f15389a.setAlpha((int) (f * 255.0f));
    }

    public void h(int i) {
        this.f15389a.setColor(i);
    }

    public void i(int i) {
        this.f15389a.setStrokeWidth(i);
    }

    public void k(float f, float f2) {
        this.b = f;
        this.c = f2;
        super.start();
    }
}
