package com.zj.adlib;

import android.annotation.SuppressLint;
import android.graphics.PointF;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_12_10194cls.dex */
@RestrictTo({RestrictTo.Scope.LIBRARY})
public class py1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final PointF f44084a;
    public final PointF b;
    public final PointF c;

    public py1() {
        this.f44084a = new PointF();
        this.b = new PointF();
        this.c = new PointF();
    }

    public PointF a() {
        return this.f44084a;
    }

    public PointF b() {
        return this.b;
    }

    public PointF c() {
        return this.c;
    }

    public void d(float f, float f2) {
        this.f44084a.set(f, f2);
    }

    public void e(float f, float f2) {
        this.b.set(f, f2);
    }

    public void f(py1 py1Var) {
        PointF pointF = py1Var.c;
        g(pointF.x, pointF.y);
        PointF pointF2 = py1Var.f44084a;
        d(pointF2.x, pointF2.y);
        PointF pointF3 = py1Var.b;
        e(pointF3.x, pointF3.y);
    }

    public void g(float f, float f2) {
        this.c.set(f, f2);
    }

    @NonNull
    @SuppressLint({"DefaultLocale"})
    public String toString() {
        return String.format("v=%.2f,%.2f cp1=%.2f,%.2f cp2=%.2f,%.2f", Float.valueOf(this.c.x), Float.valueOf(this.c.y), Float.valueOf(this.f44084a.x), Float.valueOf(this.f44084a.y), Float.valueOf(this.b.x), Float.valueOf(this.b.y));
    }

    public py1(PointF pointF, PointF pointF2, PointF pointF3) {
        this.f44084a = pointF;
        this.b = pointF2;
        this.c = pointF3;
    }
}
