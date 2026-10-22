package com.baidu.platform.core.poi;

import com.baidu.mapapi.search.poi.OnGetPoiSearchResultListener;
import com.baidu.mapapi.search.poi.PoiBoundSearchOption;
import com.baidu.mapapi.search.poi.PoiCitySearchOption;
import com.baidu.mapapi.search.poi.PoiDetailSearchOption;
import com.baidu.mapapi.search.poi.PoiIndoorOption;
import com.baidu.mapapi.search.poi.PoiNearbySearchOption;
import com.baidu.platform.base.SearchType;

/* JADX INFO: loaded from: /home/ylxc/Projects/lib/ShanDong/work/APP_ALL/classes_10_7392cls.dex */
public class e extends com.baidu.platform.base.a implements IPoiSearch {
    private OnGetPoiSearchResultListener g = null;

    @Override // com.baidu.platform.core.poi.IPoiSearch
    public void destroy() {
        this.c.lock();
        this.g = null;
        this.c.unlock();
    }

    @Override // com.baidu.platform.core.poi.IPoiSearch
    public boolean searchInBound(PoiBoundSearchOption poiBoundSearchOption) {
        f fVar = new f(poiBoundSearchOption.mPageNum, poiBoundSearchOption.mPageCapacity);
        fVar.a(SearchType.POI_IN_BOUND_SEARCH);
        return a(new g(poiBoundSearchOption), this.g, fVar);
    }

    @Override // com.baidu.platform.core.poi.IPoiSearch
    public boolean searchInCity(PoiCitySearchOption poiCitySearchOption) {
        f fVar = new f(poiCitySearchOption.mPageNum, poiCitySearchOption.mPageCapacity);
        fVar.a(SearchType.POI_IN_CITY_SEARCH);
        return a(new g(poiCitySearchOption), this.g, fVar);
    }

    @Override // com.baidu.platform.core.poi.IPoiSearch
    public boolean searchNearby(PoiNearbySearchOption poiNearbySearchOption) {
        f fVar = new f(poiNearbySearchOption.mPageNum, poiNearbySearchOption.mPageCapacity);
        fVar.a(SearchType.POI_NEAR_BY_SEARCH);
        return a(new g(poiNearbySearchOption), this.g, fVar);
    }

    @Override // com.baidu.platform.core.poi.IPoiSearch
    public boolean searchPoiDetail(PoiDetailSearchOption poiDetailSearchOption) {
        c cVar = new c();
        if (poiDetailSearchOption != null) {
            cVar.a(poiDetailSearchOption.isSearchByUids());
        }
        cVar.a(SearchType.POI_DETAIL_SEARCH);
        return a(new d(poiDetailSearchOption), this.g, cVar);
    }

    @Override // com.baidu.platform.core.poi.IPoiSearch
    public boolean searchPoiIndoor(PoiIndoorOption poiIndoorOption) {
        a aVar = new a();
        aVar.a(SearchType.INDOOR_POI_SEARCH);
        return a(new b(poiIndoorOption), this.g, aVar);
    }

    @Override // com.baidu.platform.core.poi.IPoiSearch
    public void setOnPoiSearchListener(OnGetPoiSearchResultListener onGetPoiSearchResultListener) {
        this.c.lock();
        this.g = onGetPoiSearchResultListener;
        this.c.unlock();
    }
}
