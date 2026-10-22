package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class HeatMapItem {
    private LatLng center;
    private int[] indexes;
    private double intensity;

    public LatLng getCenter() {
        return this.center;
    }

    public int[] getIndexes() {
        return this.indexes;
    }

    public double getIntensity() {
        return this.intensity;
    }

    public void setCenter(double d, double d2) {
        this.center = new LatLng(d, d2);
    }

    public void setIndexes(int[] iArr) {
        this.indexes = iArr;
    }

    public void setIntensity(double d) {
        this.intensity = d;
    }
}
