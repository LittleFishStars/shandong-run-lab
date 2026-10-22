package com.baidu.mapapi.search.recommendstop;

import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class RecommendStopSearchOption {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f26550a = false;
    public LatLng mLocation;

    public LatLng getLocation() {
        return this.mLocation;
    }

    public boolean isNeedStationInfo() {
        return this.f26550a;
    }

    public RecommendStopSearchOption location(LatLng latLng) {
        this.mLocation = latLng;
        return this;
    }

    public RecommendStopSearchOption setNeedStationInfo(boolean z) {
        this.f26550a = z;
        return this;
    }
}
