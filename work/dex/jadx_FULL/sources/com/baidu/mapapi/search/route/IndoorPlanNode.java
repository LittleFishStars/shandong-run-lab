package com.baidu.mapapi.search.route;

import com.baidu.mapapi.model.LatLng;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class IndoorPlanNode {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private LatLng f26556a;
    private String b;

    public IndoorPlanNode(LatLng latLng, String str) {
        this.f26556a = latLng;
        this.b = str;
    }

    public String getFloor() {
        return this.b;
    }

    public LatLng getLocation() {
        return this.f26556a;
    }
}
