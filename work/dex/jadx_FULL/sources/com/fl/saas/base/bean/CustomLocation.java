package com.fl.saas.base.bean;

import androidx.annotation.NonNull;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_08_10593cls.dex */
public class CustomLocation {
    private double lat;
    private double lng;

    public CustomLocation(double d, double d2) {
        this.lat = d;
        this.lng = d2;
    }

    public double getLat() {
        return this.lat;
    }

    public double getLng() {
        return this.lng;
    }

    public void setLat(double d) {
        this.lat = d;
    }

    public void setLng(double d) {
        this.lng = d;
    }

    @NonNull
    public String toString() {
        return "{\"lat\":" + this.lat + ",\"lng\":" + this.lng + "}";
    }
}
