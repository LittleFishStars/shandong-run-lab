package com.baidu.mapapi.search.busline;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class BusLineSearchOption {
    public String mUid = null;
    public String mCity = null;

    public BusLineSearchOption city(String str) {
        this.mCity = str;
        return this;
    }

    public BusLineSearchOption uid(String str) {
        this.mUid = str;
        return this;
    }
}
