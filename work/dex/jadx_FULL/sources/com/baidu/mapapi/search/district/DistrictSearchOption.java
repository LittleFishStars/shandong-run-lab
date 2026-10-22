package com.baidu.mapapi.search.district;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class DistrictSearchOption {
    public String mCityName;
    public String mDistrictName;

    public DistrictSearchOption cityName(String str) {
        this.mCityName = str;
        return this;
    }

    public DistrictSearchOption districtName(String str) {
        this.mDistrictName = str;
        return this;
    }
}
