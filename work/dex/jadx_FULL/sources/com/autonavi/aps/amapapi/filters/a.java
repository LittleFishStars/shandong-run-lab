package com.autonavi.aps.amapapi.filters;

import android.text.TextUtils;
import com.amap.api.location.AMapLocation;
import com.autonavi.aps.amapapi.utils.i;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    com.autonavi.aps.amapapi.model.a f26176a = null;
    long b = 0;
    long c = 0;
    private boolean h = true;
    int d = 0;
    long e = 0;
    AMapLocation f = null;
    long g = 0;

    private com.autonavi.aps.amapapi.model.a b(com.autonavi.aps.amapapi.model.a aVar) {
        if (i.a(aVar)) {
            if (!this.h || !com.autonavi.aps.amapapi.utils.a.a(aVar.getTime())) {
                aVar.setLocationType(this.d);
            } else if (aVar.getLocationType() == 5 || aVar.getLocationType() == 6) {
                aVar.setLocationType(4);
            }
        }
        return aVar;
    }

    public final void a() {
        this.f26176a = null;
        this.b = 0L;
        this.c = 0L;
        this.f = null;
        this.g = 0L;
    }

    public final com.autonavi.aps.amapapi.model.a a(com.autonavi.aps.amapapi.model.a aVar) {
        if (i.b() - this.e > 30000) {
            this.f26176a = aVar;
            this.e = i.b();
            return this.f26176a;
        }
        this.e = i.b();
        if (!i.a(this.f26176a) || !i.a(aVar)) {
            this.b = i.b();
            this.f26176a = aVar;
            return aVar;
        }
        if (aVar.getTime() == this.f26176a.getTime() && aVar.getAccuracy() < 300.0f) {
            return aVar;
        }
        if ("gps".equals(aVar.getProvider())) {
            this.b = i.b();
            this.f26176a = aVar;
            return aVar;
        }
        if (aVar.c() != this.f26176a.c()) {
            this.b = i.b();
            this.f26176a = aVar;
            return aVar;
        }
        if (aVar.getBuildingId() != null && !aVar.getBuildingId().equals(this.f26176a.getBuildingId()) && !TextUtils.isEmpty(aVar.getBuildingId())) {
            this.b = i.b();
            this.f26176a = aVar;
            return aVar;
        }
        this.d = aVar.getLocationType();
        float fA = i.a(aVar, this.f26176a);
        float accuracy = this.f26176a.getAccuracy();
        float accuracy2 = aVar.getAccuracy();
        float f = accuracy2 - accuracy;
        long jB = i.b();
        long j = jB - this.b;
        boolean z = accuracy <= 100.0f && accuracy2 > 299.0f;
        boolean z2 = accuracy > 299.0f && accuracy2 > 299.0f;
        if (z || z2) {
            long j2 = this.c;
            if (j2 == 0) {
                this.c = jB;
            } else if (jB - j2 > 30000) {
                this.b = jB;
                this.f26176a = aVar;
                this.c = 0L;
                return aVar;
            }
            com.autonavi.aps.amapapi.model.a aVarB = b(this.f26176a);
            this.f26176a = aVarB;
            return aVarB;
        }
        if (accuracy2 < 100.0f && accuracy > 299.0f) {
            this.b = jB;
            this.f26176a = aVar;
            this.c = 0L;
            return aVar;
        }
        if (accuracy2 <= 299.0f) {
            this.c = 0L;
        }
        if (fA >= 10.0f || fA <= 0.1d || accuracy2 <= 5.0f) {
            if (f < 300.0f) {
                this.b = i.b();
                this.f26176a = aVar;
                return aVar;
            }
            if (j >= 30000) {
                this.b = i.b();
                this.f26176a = aVar;
                return aVar;
            }
            com.autonavi.aps.amapapi.model.a aVarB2 = b(this.f26176a);
            this.f26176a = aVarB2;
            return aVarB2;
        }
        if (f >= -300.0f) {
            com.autonavi.aps.amapapi.model.a aVarB3 = b(this.f26176a);
            this.f26176a = aVarB3;
            return aVarB3;
        }
        if (accuracy / accuracy2 >= 2.0f) {
            this.b = jB;
            this.f26176a = aVar;
            return aVar;
        }
        com.autonavi.aps.amapapi.model.a aVarB4 = b(this.f26176a);
        this.f26176a = aVarB4;
        return aVarB4;
    }

    public final void a(boolean z) {
        this.h = z;
    }

    public final AMapLocation a(AMapLocation aMapLocation) {
        if (!i.a(aMapLocation)) {
            return aMapLocation;
        }
        long jB = i.b() - this.g;
        this.g = i.b();
        if (jB > 5000) {
            return aMapLocation;
        }
        AMapLocation aMapLocation2 = this.f;
        if (aMapLocation2 == null) {
            this.f = aMapLocation;
            return aMapLocation;
        }
        if (1 != aMapLocation2.getLocationType() && !"gps".equalsIgnoreCase(this.f.getProvider())) {
            this.f = aMapLocation;
            return aMapLocation;
        }
        if (this.f.getAltitude() == aMapLocation.getAltitude() && this.f.getLongitude() == aMapLocation.getLongitude()) {
            this.f = aMapLocation;
            return aMapLocation;
        }
        long jAbs = Math.abs(aMapLocation.getTime() - this.f.getTime());
        if (30000 < jAbs) {
            this.f = aMapLocation;
            return aMapLocation;
        }
        if (i.a(aMapLocation, this.f) > (((this.f.getSpeed() + aMapLocation.getSpeed()) * jAbs) / 2000.0f) + ((this.f.getAccuracy() + aMapLocation.getAccuracy()) * 2.0f) + 3000.0f) {
            return this.f;
        }
        this.f = aMapLocation;
        return aMapLocation;
    }
}
