package com.zj.adlib;

import android.location.Location;
import com.amap.api.maps.LocationSource;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public final class bmb implements LocationSource.OnLocationChangedListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Location f40781a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    public IAMapDelegate f15573a;

    public bmb(IAMapDelegate iAMapDelegate) {
        this.f15573a = iAMapDelegate;
    }

    @Override // com.amap.api.maps.LocationSource.OnLocationChangedListener
    public final void onLocationChanged(Location location) {
        this.f40781a = location;
        try {
            if (this.f15573a.isMyLocationEnabled()) {
                this.f15573a.showMyLocationOverlay(location);
            }
        } catch (Throwable th) {
            a7b.m(th, "AMapOnLocationChangedListener", "onLocationChanged");
            th.printStackTrace();
        }
    }
}
