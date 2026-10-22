package com.kc.cw.ad.model;

import com.qihoo.SdkProtected.OSETSDK.Keep;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_09_10084cls.dex */
@Keep
public class SsLocation {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private double f39073a;
    private double b;
    private int c;
    private long d;

    public SsLocation() {
    }

    public SsLocation(double d, double d2, int i, long j) {
        this.f39073a = d;
        this.b = d2;
        this.c = i;
        this.d = j;
    }

    public double getLatitude() {
        return this.b;
    }

    public double getLongitude() {
        return this.f39073a;
    }

    public long getTime() {
        return this.d;
    }

    public int getType() {
        return this.c;
    }

    public void setLatitude(double d) {
        this.b = d;
    }

    public void setLongitude(double d) {
        this.f39073a = d;
    }

    public void setTime(long j) {
        this.d = j;
    }

    public void setType(int i) {
        this.c = i;
    }
}
