package com.amap.api.maps.model;

import com.autonavi.base.amap.mapcore.jbinding.JBindingInclude;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
@JBindingInclude
public class ColorLatLng {
    private int color;
    private List<LatLng> latLngs;

    public ColorLatLng(List<LatLng> list, int i) {
        ArrayList arrayList = new ArrayList();
        this.latLngs = arrayList;
        arrayList.clear();
        this.latLngs.addAll(list);
        this.color = i;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            ColorLatLng colorLatLng = (ColorLatLng) obj;
            if (this.color == colorLatLng.color && Objects.equals(this.latLngs, colorLatLng.latLngs)) {
                return true;
            }
        }
        return false;
    }

    public int getColor() {
        return this.color;
    }

    public List<LatLng> getLatLngs() {
        return this.latLngs;
    }

    public int hashCode() {
        return Objects.hash(this.latLngs, Integer.valueOf(this.color));
    }

    public String toString() {
        return "ColorLatLng{latLngs=" + this.latLngs + ", color=" + this.color + '}';
    }
}
