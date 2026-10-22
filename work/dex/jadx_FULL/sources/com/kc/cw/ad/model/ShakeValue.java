package com.kc.cw.ad.model;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class ShakeValue {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f39072a;
    private double b;
    private int c;

    public ShakeValue() {
    }

    public ShakeValue(double d, double d2, int i) {
        this.f39072a = d;
        this.b = d2;
        this.c = i;
    }

    public double getAcceleration() {
        return this.f39072a;
    }

    public double getAngle() {
        return this.b;
    }

    public int getTime() {
        return this.c;
    }

    public void setAcceleration(double d) {
        this.f39072a = d;
    }

    public void setAngle(double d) {
        this.b = d;
    }

    public void setTime(int i) {
        this.c = i;
    }

    public String toString() {
        return "ShakeValue{acceleration=" + this.f39072a + ", angle=" + this.b + ", time=" + this.c + '}';
    }
}
