package com.baidu.platform.core.poi;

import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public interface IPoiSearch {
    void destroy();

    boolean searchInBound(PoiBoundSearchOption poiBoundSearchOption);

    boolean searchInCity(PoiCitySearchOption poiCitySearchOption);

    boolean searchNearby(PoiNearbySearchOption poiNearbySearchOption);

    boolean searchPoiDetail(PoiDetailSearchOption poiDetailSearchOption);

    boolean searchPoiIndoor(PoiIndoorOption poiIndoorOption);

    void setOnPoiSearchListener(OnGetPoiSearchResultListener onGetPoiSearchResultListener);
}
