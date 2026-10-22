package com.autonavi.aps.amapapi.storage;

import com.amap.api.col.p0003l.gx;
import com.amap.api.col.p0003l.gy;
import com.amap.api.location.AMapLocation;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@gx(a = "c")
public class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    @gy(a = "a2", b = 6)
    private String f26193a;

    @gy(a = "a3", b = 5)
    private long b;

    @gy(a = "a4", b = 6)
    private String c;
    private AMapLocation d;

    public final AMapLocation a() {
        return this.d;
    }

    public final String b() {
        return this.c;
    }

    public final String c() {
        return this.f26193a;
    }

    public final long d() {
        return this.b;
    }

    public final void a(AMapLocation aMapLocation) {
        this.d = aMapLocation;
    }

    public final void b(String str) {
        this.f26193a = str;
    }

    public final void a(String str) {
        this.c = str;
    }

    public final void a(long j) {
        this.b = j;
    }
}
