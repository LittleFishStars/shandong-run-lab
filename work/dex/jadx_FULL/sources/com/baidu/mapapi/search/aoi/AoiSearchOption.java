package com.baidu.mapapi.search.aoi;

import com.baidu.mapapi.model.LatLng;
import java.util.ArrayList;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class AoiSearchOption {
    public ArrayList<LatLng> mLatLngList;

    public ArrayList<LatLng> getLatLngList() {
        return this.mLatLngList;
    }

    public AoiSearchOption setLatLngList(ArrayList<LatLng> arrayList) {
        this.mLatLngList = arrayList;
        return this;
    }
}
