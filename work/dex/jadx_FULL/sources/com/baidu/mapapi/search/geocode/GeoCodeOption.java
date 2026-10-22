package com.baidu.mapapi.search.geocode;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class GeoCodeOption {
    public String mCity = null;
    public String mAddress = null;

    public GeoCodeOption address(String str) {
        this.mAddress = str;
        return this;
    }

    public GeoCodeOption city(String str) {
        this.mCity = str;
        return this;
    }

    public String getAddress() {
        return this.mAddress;
    }
}
