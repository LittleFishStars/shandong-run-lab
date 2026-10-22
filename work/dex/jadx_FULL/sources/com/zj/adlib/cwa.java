package com.zj.adlib;

import com.autonavi.amap.mapcore.DPoint;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class cwa {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final double f41056a;
    public final double b;
    public final double c;
    public final double d;
    public final double e;
    public final double f;

    public cwa(double d, double d2, double d3, double d4) {
        this.f41056a = d;
        this.b = d3;
        this.c = d2;
        this.d = d4;
        this.e = (d + d2) / 2.0d;
        this.f = (d3 + d4) / 2.0d;
    }

    public final boolean a(double d, double d2) {
        return this.f41056a <= d && d <= this.c && this.b <= d2 && d2 <= this.d;
    }

    public final boolean b(double d, double d2, double d3, double d4) {
        return d < this.c && this.f41056a < d2 && d3 < this.d && this.b < d4;
    }

    public final boolean c(DPoint dPoint) {
        return a(dPoint.x, dPoint.y);
    }

    public final boolean d(cwa cwaVar) {
        return b(cwaVar.f41056a, cwaVar.c, cwaVar.b, cwaVar.d);
    }

    public final boolean e(cwa cwaVar) {
        return cwaVar.f41056a >= this.f41056a && cwaVar.c <= this.c && cwaVar.b >= this.b && cwaVar.d <= this.d;
    }
}
